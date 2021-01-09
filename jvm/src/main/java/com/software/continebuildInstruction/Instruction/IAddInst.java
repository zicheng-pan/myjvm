package com.software.continebuildInstruction.Instruction;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;

public class IAddInst implements Instruct {
    @Override
    public void eval(Frame frame) {
        int v2 = frame.operandStack.pop();
        int v1 = frame.operandStack.pop();
        frame.operandStack.push(v1 + v2);

        frame.pc += offset();
    }
}
