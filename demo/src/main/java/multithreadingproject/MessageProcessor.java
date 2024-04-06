package multithreadingproject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class MessageProcessor extends Thread {
    private final BlockingQueue<String> messageQueue = new LinkedBlockingQueue<>();
    private final MessageProcessingStrategy strategy;
    private boolean isRunning = true;

    public MessageProcessor(MessageProcessingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void run() {
        while (isRunning || !messageQueue.isEmpty()) {
            try {
                String message = messageQueue.take();
                strategy.processMessage(message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopProcessor() {
        isRunning = false;
    }

    public void addMessage(String message) {
        messageQueue.add(message);
    }
}
