package test;

import test.Robot.GreetRobot;
import test.Robot.MathOperation;

public class TestClass {
    public static void main(String[] args) {
        Robot.MathOperation add = (a, b) -> a + b;

        Robot<MathOperation> mathRobot = RobotFactory.buildMathRobot();
        
        mathRobot.performTask(add);
        mathRobot.performTask((a, b) -> a - b);

        Robot<GreetRobot> greetRobot = RobotFactory.buildGreetRobot(mathRobot);

        greetRobot.performTask((target) -> {
            System.out.println("Hello, " + target.toString() + "!");
        });
    }
}

