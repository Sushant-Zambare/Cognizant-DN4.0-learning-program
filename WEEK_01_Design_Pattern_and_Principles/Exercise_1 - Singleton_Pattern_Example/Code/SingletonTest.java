public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("Testing Singleton Pattern Implementation....");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First message");
        logger2.log("Second message");

        String output = logger1 == logger2
                ? "logger1 and logger2 are the same instance."
                : "Different Instance Exists";

        System.out.println(output);
    }
}