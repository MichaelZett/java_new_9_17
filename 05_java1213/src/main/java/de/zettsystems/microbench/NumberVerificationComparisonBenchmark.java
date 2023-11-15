package de.zettsystems.microbench;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/* To run a short example benchmark, uncomment this code:*/
@Fork(value=1, jvmArgsAppend = {"-XX:+UseParallelGC", "-Xms8g", "-Xmx8g"})
@Warmup(iterations = 1)
@Measurement(iterations = 1)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
public class NumberVerificationComparisonBenchmark {

	@Param({"X", StringUtils.EMPTY})
	public String prefix;

	@State(Scope.Thread)
	public static class IterationEnvironment {

		private final AtomicInteger positive = new AtomicInteger(0);
		private final AtomicInteger negative = new AtomicInteger(0);

		IntStream getIntStream() {
			return IntStream.range(0, 10_000_000);
		}

		AtomicInteger getPositive() {
			return positive;
		}

		AtomicInteger getNegative() {
			return negative;
		}

	}

	@Benchmark
	public void parseIntWithTryCatch(final IterationEnvironment iterationEnvironment, final Blackhole blackhole) {

		iterationEnvironment.getIntStream().forEach(value -> parseAndCatch(iterationEnvironment.getPositive(), iterationEnvironment.getNegative(), prefix, value));

		blackhole.consume(iterationEnvironment.getPositive().get());
		blackhole.consume(iterationEnvironment.getNegative().get());
	}

	@Benchmark
	public void isNumberWithRegex(final IterationEnvironment iterationEnvironment, final Blackhole blackhole) {

		iterationEnvironment.getIntStream().forEach(value -> matchWithRegex(iterationEnvironment.getPositive(), iterationEnvironment.getNegative(), prefix, value));

		blackhole.consume(iterationEnvironment.getPositive().get());
		blackhole.consume(iterationEnvironment.getNegative().get());
	}

	@Benchmark
	public void isNumericWithStringUtils(final IterationEnvironment iterationEnvironment, final Blackhole blackhole) {

		iterationEnvironment.getIntStream().forEach(value -> checkWithStringUtils(iterationEnvironment.getPositive(), iterationEnvironment.getNegative(), prefix, value));

		blackhole.consume(iterationEnvironment.getPositive().get());
		blackhole.consume(iterationEnvironment.getNegative().get());
	}

	private void parseAndCatch(final AtomicInteger positive, final AtomicInteger negative, final String prefix, final int value) {

		final String s = prefix + value;
		try {
			positive.getAndAdd(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			negative.getAndAdd(value);
		}
	}

	private void matchWithRegex(final AtomicInteger positive, final AtomicInteger negative, final String prefix, final int value) {

		final String s = prefix + value;
		if (s.matches("\\d+")) {
			positive.getAndAdd(value);
		} else {
			negative.getAndAdd(value);
		}
	}

	private void checkWithStringUtils(final AtomicInteger positive, final AtomicInteger negative, final String prefix, final int value) {

		final String s = prefix + value;
		if (StringUtils.isNumeric(s)) {
			positive.getAndAdd(value);
		} else {
			negative.getAndAdd(value);
		}
	}

}