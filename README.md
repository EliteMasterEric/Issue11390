# hxjvm-Issue11023

https://github.com/HaxeFoundation/haxe/issues/11023

**Build instructions:**

- `cd ./project; ./build.bat; cd ../`
- `haxe ./compile.hxml`
- `cd ./bin/java; java -jar Main.jar`

**Error Message**
> Exception in thread "main" java.lang.IncompatibleClassChangeError: Method 'void test.Util.testStatic()' must be InterfaceMethodref constant
> at haxe.root.Main.main(src/Main.hx:8)
> at haxe.root.Main.main(src/Main.hx:1)

**javap**
- `javap -c -v --class-path .\Main.jar haxe.root.Main > Main.javap`
