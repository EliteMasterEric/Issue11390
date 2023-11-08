package test;

import test.Robot.GreetRobot;
import test.Robot.MathOperation;

public class RobotFactory {
    public static Robot<MathOperation> buildMathRobot() {
        return new Robot<MathOperation>() {
            public void performTask(MathOperation listener) {
                System.out.println("Robot.performTask() called!");        
                int result = listener.operate(3, 4);
                System.out.println("Result: " + result);
            }
        };
    }


    public static Robot<GreetRobot> buildGreetRobot(Robot target) {
        return new Robot<GreetRobot>() {
            public void performTask(GreetRobot listener) {
                System.out.println("Robot.performTask() called!");
                listener.greet(target);
            }
        };
    }
}
