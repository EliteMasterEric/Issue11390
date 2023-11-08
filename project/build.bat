REM Build all the Java files in the src/ folder into the out/ folder
javac -d out src/test/TestClass.java src/test/Robot.java src/test/RobotFactory.java
REM Create a JAR file from the compiled classes
cd out/
jar cf project.jar test/TestClass.class test/Robot.class test/Robot$MathOperation.class test/Robot$GreetRobot.class test/RobotFactory.class test/RobotFactory$1.class test/RobotFactory$2.class
