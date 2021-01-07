package com.software.test;

import com.software.one.Frame;
import com.software.one.Instruct;
import com.software.one.Interpreter;
import com.software.two.ParseFile;

import java.util.Map;

public class Two {
    public static void main(String[] args) {
        //C:\project\mine\myjvm\jvm\src\main\java\test.bc
        Map<Integer, Instruct> instructionMap = ParseFile.parse("C:\\project\\mine\\myjvm\\jvm\\src\\main\\java\\sum10.bc");

        Frame frame = new Frame();
        Interpreter.run(frame, instructionMap);
    }
}
