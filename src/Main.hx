package;

import test.Robot;
import test.RobotFactory;

class Main {
	public static function main() {
		var robot1 = RobotFactory.buildMathRobot();
		var robot2 = RobotFactory.buildGreetRobot(robot1);

		robot1.performTask(add);
		robot1.performTask(function(a:Int, b:Int):Int {
			return a - b;
		});

		robot2.performTask(function (target) {
            trace('Hello, ${target.toString()}!');
        });
	}

	static function add(a:Int, b:Int):Int {
		return a + b;
	}
}