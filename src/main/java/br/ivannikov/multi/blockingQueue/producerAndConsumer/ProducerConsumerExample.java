package br.ivannikov.multi.blockingQueue.producerAndConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/*
Key Features:
Thread-Safe Queue: BlockingQueue handles all synchronization internally
put() blocks if queue is full
take() blocks if queue is empty

Proper Thread Management:
Producer produces items at a faster rate (200ms)
Consumer consumes at a slower rate (500ms)
Queue size limits buffer to 10 items

Graceful Shutdown:
InterruptedException handling
Producer stops after 20 items
Consumer runs until interrupted
* */
public class ProducerConsumerExample {

    public static void main(String[] args) {
        // Create a shared BlockingQueue with capacity of 10
        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>(10);

        // Create producer and consumer threads
        Thread producerThread = new Thread(new Producer(sharedQueue));
        Thread consumerThread = new Thread(new Consumer(sharedQueue));

        // Start threads
        producerThread.start();
        consumerThread.start();
    }
}

// Producer class
class Producer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i); // Blocks if queue is full
                Thread.sleep(200); // Simulate production time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

// Consumer class
class Consumer implements Runnable {
    private final BlockingQueue<Integer> sharedQueue;

    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer item = sharedQueue.take(); // Blocks if queue is empty
                System.out.println("Consumed: " + item);
                Thread.sleep(500); // Simulate consumption time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
