package org.hagiakinh.thread.concurrency.threadpipeline;

import java.util.concurrent.BlockingQueue;

public interface Processor extends Runnable {

    public BlockingQueue setInputQueue(BlockingQueue inputQueue);

    public BlockingQueue setOutputQueue(BlockingQueue outputQueue);

    public void requestShutdown();

}
