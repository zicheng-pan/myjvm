package com.software.test;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;
import com.software.buildInstruction.Instruction.ILoad0Inst;
import com.software.buildInstruction.Instruction.IReturnInst;
import com.software.buildInstruction.Instruction.IStore0Inst;
import com.software.buildInstruction.Instruction.Iconst1Inst;
import com.software.buildInstruction.Interpreter;

import java.util.HashMap;
import java.util.Map;

public class One {
    public static void main(String[] args) {
        Map<Integer, Instruct> instructMap = new HashMap<>();
        instructMap.put(0, new Iconst1Inst());
        instructMap.put(1, new IStore0Inst());
        instructMap.put(2, new ILoad0Inst());
        instructMap.put(3, new IReturnInst());
        // 准备解释
        Frame frame = new Frame();
        Interpreter.run(frame, instructMap);
    }
}
