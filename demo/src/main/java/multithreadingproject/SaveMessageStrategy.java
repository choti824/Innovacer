package multithreadingproject;

public class SaveMessageStrategy implements MessageProcessingStrategy {
    @Override
    public void processMessage(String message) {
        System.out.println("Saving message: " + message);
        // Implement message saving logic here, e.g., save to a database
    }
}
