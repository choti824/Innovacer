package multithreadingproject;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("No processing strategy specified. Exiting.");
            return;
        }

        MessageProcessingStrategy strategy;
        switch (args[0].toLowerCase()) {
            case "print":
                strategy = new PrintMessageStrategy();
                break;
            case "log":
                strategy = new LogMessageStrategy();
                break;
            case "save":
                strategy = new SaveMessageStrategy();
                break;
            default:
                System.out.println("Invalid processing strategy specified. Exiting.");
                return;
        }

        MessageProcessor processor = new MessageProcessor(strategy);
        processor.start();

        Producer producer = new Producer(processor);
        producer.fetchAndProduce(5); // Example, adjust as needed

        Thread.sleep(5000); // Allow time for processing
        processor.stopProcessor();
        processor.join(); // Wait for the processing thread to finish
    }
}
