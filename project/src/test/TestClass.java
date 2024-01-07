package test;

import test.Robot.GreetRobot;
import test.Robot.ManufactureRobot;
import test.Robot.MathOperation;

public class TestClass {
    static Robot mathRobot;

    public static void main(String[] args) {
        Robot.MathOperation add = (a, b) -> a + b;

        mathRobot = RobotFactory.buildMathRobot();
        
        mathRobot.performTask(add);
        // mathRobot.performTask((a, b) -> a - b);

        Robot<GreetRobot> greetRobot = RobotFactory.buildGreetRobot(mathRobot);

        greetRobot.performTask((target) -> {
            System.out.println("Hello, " + target.toString() + "!");
        });

        greetRobot.performTask((target) -> {
            System.out.println("Hello, " + target.toString() + "!");
        }, () -> {
            System.out.println("Cleaning up...");
        });

        Robot<ManufactureRobot<Robot<GreetRobot>>> manufactureRobot = RobotFactory.buildManufactureRobot();
        manufactureRobot.performTask(TestClass::onManufacture);
    }

    static Robot<GreetRobot> onManufacture(String robotType) {
        System.out.println("Robot.manufactureRobot() called!");
        if (robotType.equals("Greet")) {
            return RobotFactory.buildGreetRobot(mathRobot);
        } else {
            return null;
        }
    }
}

