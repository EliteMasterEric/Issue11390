package test;

import test.Robot.GreetRobot;
import test.Robot.GreetRobot2;
import test.Robot.MathOperation;
import test.Robot.MathOperation2;

public class RobotFactory {
    public static Robot<MathOperation, MathOperation2> buildMathRobot() {
        return new Robot<MathOperation, MathOperation2>() {
            public void performTask(MathOperation listener) {
                System.out.println("Robot.performTask() called!");        
                int result = listener.operate(3, 4);
                System.out.println("Result: " + result);
            }

            public void performTask(MathOperation2 listener, CleanupTask cleanupTask) {
                System.out.println("Robot.performTask() called!");        
                int result = listener.operate(3, 4);
                System.out.println("Result: " + result);
                cleanupTask.cleanup();
            }
        };
    }


    public static Robot<GreetRobot, GreetRobot2> buildGreetRobot(Robot target) {
        return new Robot<GreetRobot, GreetRobot2>() {
            public void performTask(GreetRobot listener) {
                System.out.println("Robot.performTask() called!");
                listener.greet(target);
            }

            public void performTask(GreetRobot2 listener, CleanupTask cleanupTask) {
                System.out.println("Robot.performTask() called!");
                listener.greet(target);
                cleanupTask.cleanup();
            }
        };
    }
}
