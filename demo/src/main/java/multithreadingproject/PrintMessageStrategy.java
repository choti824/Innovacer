package multithreadingproject;

public class PrintMessageStrategy implements MessageProcessingStrategy {
    @Override
    public void processMessage(String message) {
        System.out.println("Processing message: " + message);
        
    }
}
