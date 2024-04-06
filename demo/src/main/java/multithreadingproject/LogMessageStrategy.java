package multithreadingproject;


public class LogMessageStrategy implements MessageProcessingStrategy {
    @Override
    public void processMessage(String message) {
        System.out.println("Logging message: " + message);
    }
}
