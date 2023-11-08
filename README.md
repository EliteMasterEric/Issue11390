# hxjvm-Issue11054

https://github.com/HaxeFoundation/haxe/issues/11054

**Build instructions:**

1. Build the extern JAR: `cd ./project; ./build.bat`
2. Build the Haxe project: `haxe ./compile.hxml`
3. Run the extern JAR to preview the expected output: `cd ./project/out; java test.TestClass`
4. Run the Haxe output JAR to see the erroneous output: `cd ./bin/java; java -jar Main.jar`

**Expected Output**
```
Robot.performTask() called!
Result: 7
Robot.performTask() called!
Result: -1
Robot.performTask() called!
Hello, Robot!
```

**Erroneous Output**
```
Robot.performTask() called!
Result: 7
Robot.performTask() called!
Result: -1
Exception in thread "main" java.lang.ClassCastException: class haxe.root.Main$Closure_main_1 cannot be cast to class test.Robot$GreetRobot (haxe.root.Main$Closure_main_1 and test.Robot$GreetRobot are in unnamed module of loader 'app')
        at test.RobotFactory$2.performTask(RobotFactory.java:19)
        at haxe.root.Main.main(src/Main.hx:16)
        at haxe.root.Main.main(src/Main.hx:1)
```

**Notes**

Inspecting with a Java decompiler like Luyten reveals that `Main_add` and `Closure_main_0` (the auto-generated `Function` classes used for the functional interface) both implement `Robot.MathOperation`.

However, `Closure_main_1` does not implement `Robot.GreetRobot`, only `java.util.function.Function`.