package de.zettsystems.microbench;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkRunner {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(NumberVerificationComparisonBenchmark.class.getSimpleName())
//                .include(ToArrayBench.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}