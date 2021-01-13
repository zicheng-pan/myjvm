package com.software.test;

import com.software.addclassPath.Class;
import com.software.addclassPath.ClassLoader;
import com.software.readClassFile.ClassFile;

/*下面举几个使用 classpath 的例子：
java HelloWorld
copy
默认情况下，虚拟机会将当前目录加到 classpath 中。

java -cp . HelloWorld
copy
-cp 或者 -classpath 命令是等价的（简单起见，我们要实现的虚拟机只支持 -cp 选项），这个例子和上面的例子是等价的，都是将当前目录加到 classpath 中。

java -cp misc Test
copy
意味着将当前目录下的 misc 目录加到 classpath 中。

java -cp temp/misc.jar Test
copy
意味着将当前目录下的 temp/misc.jar 文件加到 classpath 中。

java -cp misc:temp/misc.jar Test
copy
意味着将当前目录下的 misc 目录和当前目录下的 temp 目录下的 misc.jar 文件加到 classpath 中。其中 : 号多个 classpath 的分隔符。
 */
public class ClassLoaderTest {

    public static void testLoadClassFromDir() {
        final ClassLoader loader = new ClassLoader("misc");

        final ClassFile cf = loader.loadClassFileFromDir("misc", "Test");
    }

    public static void testLoadClassFromJar() {
        final String home = System.getenv("JAVA_HOME");
        String runtimeJarPath = home + "/jre/lib/rt.jar";
        final ClassLoader loader = new ClassLoader(runtimeJarPath);

        final ClassFile cf = loader.loadClassFileFromJar(runtimeJarPath, "java/lang/Object");
    }


    public static void testLoadClass_object() throws Exception {
        final String home = System.getenv("JAVA_HOME");
//        Assert.assertNotNull(home, "env JAVA_HOME");

        String runtimeJarPath = home + "/jre/lib/rt.jar";
        final ClassLoader loader = new ClassLoader(runtimeJarPath);

        // load java/lang/Object
        final Class clazz = loader.findClass("java/lang/Object");
//        Assert.assertNull(clazz.superClass, "java/lang/Object super class is null");
//        Assert.assertEq(14, clazz.methods.length, "java/lang/Object has 14 methods");
    }

    public static void testLoadClass_test() {
        final String home = System.getenv("JAVA_HOME");
        String runtimeJarPath = home + "\\jre\\lib\\rt.jar";
        String classpath = runtimeJarPath + ":" + "misc";
        final ClassLoader loader = new ClassLoader(classpath);

        // load Test
        final Class clazz = loader.findClass("Test");
//        Assert.assertNotNull(clazz.superClass, "Test super class is not null");
//        Assert.assertEq(2, clazz.methods.length, "Test has 2 methods");
    }

    public static void main(String[] args) {
        ClassLoaderTest.testLoadClass_test();
    }
}
