package com.software.test;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;
import com.software.buildInstruction.Interpreter;
import com.software.continebuildInstruction.ParseFile;

import java.util.Map;

public class Two {
    public static void main(String[] args) {
        //C:\project\mine\myjvm\jvm\src\main\java\test.bc
        Map<Integer, Instruct> instructionMap = ParseFile.parse("C:\\workspace\\intellj-java\\git_project\\myjvm\\jvm\\src\\main\\java\\Sum10.class");

        Frame frame = new Frame();
        Interpreter.run(frame, instructionMap);
    }
}
