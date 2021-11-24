package com.software.buildInstruction;

import java.util.Map;

//解释器 执行指令的集合 可以将class文件翻译成指定的指令，然后进行执行
public class Interpreter {
    public static void run(Frame frame, Map<Integer, Instruct> instructions) {
        do {
            // 获取指令并且执行
            instructions.get(frame.pc).eval(frame);

        } while (instructions.containsKey(frame.pc));
    }
}
