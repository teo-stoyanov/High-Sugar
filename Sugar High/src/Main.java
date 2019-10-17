import interfaces.Runnable;
import logic.Engine;

public class Main {
    public static void main(String[] args) {
        Runnable engine = new Engine();
        engine.run();
    }
}
