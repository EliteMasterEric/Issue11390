package test;

public abstract class Robot<T, U> {
    public Robot() {}

    public void performTask(T listener) {
        System.out.println("Robot.performTask() called!");
    }

    public void performTask(U listener, CleanupTask cleanupTask) {
        System.out.println("Robot.performTask() called!");
        cleanupTask.cleanup();
    }

    /**
     * MathOperation
     */
    @FunctionalInterface
    public interface MathOperation {
        public int operate(int a, int b);
    }

    @FunctionalInterface
    public interface MathOperation2 {
        public int operate(int a, int b);
    }

    @FunctionalInterface
    public interface GreetRobot {
        public void greet(Robot robot);
    }

    @FunctionalInterface
    public interface GreetRobot2 {
        public void greet(Robot robot);
    }

    @FunctionalInterface
    public interface CleanupTask {
        public void cleanup();
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
