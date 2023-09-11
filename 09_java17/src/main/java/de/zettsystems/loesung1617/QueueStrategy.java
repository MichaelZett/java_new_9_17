package de.zettsystems.loesung1617;

public sealed interface QueueStrategy permits FifoQueueStrategyImpl, LifoQueueStrategyImpl {
    void execute();
}
