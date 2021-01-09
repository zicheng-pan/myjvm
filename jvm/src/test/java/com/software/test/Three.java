package com.software.test;

import com.software.readClassFile.ClassFile;
import com.software.readClassFile.ClassReader;
import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;
import com.software.buildInstruction.Interpreter;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

public class Three {
    public static void testRead() throws IOException {
        try (FileInputStream is = new FileInputStream(Paths.get("C:\\project\\mine\\myjvm\\jvm\\src\\main\\java\\Test.class").toFile());
             DataInputStream dis = new DataInputStream(is)
        ) {
            final ClassFile file = ClassReader.read(dis); // 1 从输入流中读取 ClassFile 实例 file
            System.out.println("a");
//            Assert.assertEq(0xCAFEBABE, file.magic.val, "magic"); // 2 断言 file 的 magic 是 0xCAFEBABE
//            Assert.assertEq(0, file.minorVersion.val, "minor_version"); // 3 断言 file 的 minnor_version 是 0
//            Assert.assertEq(52, file.majorVersion.val, "major_version"); // 4 断言 file 的 major_version 是 52
//            Assert.assertEq(15, file.constantPoolCount.val, "constant_pooL_count"); // 5
//            Assert.assertEq(2, file.methodsCount.val, "methods_count"); // 6
//            Assert.assertEq(1, file.attributesCount.val, "attributes_count"); // 7
        }
    }

    public static void main(String[] args) throws Exception {
        final File file = new File("C:\\workspace\\intellj-java\\git_project\\myjvm\\jvm\\src\\main\\java\\Sum10.class");

        ClassFile classFile = null;
        try (FileInputStream fis = new FileInputStream(file);
             final DataInputStream dis = new DataInputStream(fis)
        ) {
            classFile = ClassReader.read(dis);
        }

        Map<Integer, Instruct> instructionMap = classFile.methods[1].getCode(classFile).getInstructions(classFile.constantPool);
        if (instructionMap != null) {
            Frame frame = new Frame();
            Interpreter.run(frame, instructionMap);
        }
    }
}
