package multithreadingproject;
import java.util.concurrent.ThreadLocalRandom;

public class Producer {
    private final MessageProcessor processor;

    public Producer(MessageProcessor processor) {
        this.processor = processor;
    }

    public void fetchAndProduce(int numberOfMessages) throws InterruptedException {
        for (int i = 0; i < numberOfMessages; i++) {
            String message = fetchMessageFromAPI();
            processor.addMessage(message);

            Thread.sleep(500);
        }
    }

    private String fetchMessageFromAPI() {
        int messageId = ThreadLocalRandom.current().nextInt(100, 1000);
        return "API Message " + messageId;
    }
}
