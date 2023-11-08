package test;

public abstract class Robot<T> {
    public Robot() {}

    public void performTask(T listener) {
        System.out.println("Robot.performTask() called!");
    }

    /**
     * MathOperation
     */
    @FunctionalInterface
    public interface MathOperation {
        public int operate(int a, int b);
    }

    @FunctionalInterface
    public interface GreetRobot {
        public void greet(Robot robot);
    }

    @Override
    public String toString() {
        return "Robot";
    }
}
