package com.software.one;

import java.util.Map;

//解释器
public class Interpreter {
    public static void run(Frame frame, Map<Integer, Instruct> instructions) {
        do {
            // 获取指令并且执行
            instructions.get(frame.pc).eval(frame);

        } while (instructions.containsKey(frame.pc));
    }
}
