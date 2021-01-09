package com.software.continebuildInstruction.Instruction;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;

public class ILoad2Inst implements Instruct {
    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(frame.localVars.get(2));
        frame.pc += offset();
    }
}
