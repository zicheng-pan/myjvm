package com.software.continebuildInstruction.Instruction;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;

public class IStore2Inst implements Instruct {
    @Override
    public void eval(Frame frame) {
        frame.localVars.put(2, frame.operandStack.pop());
        frame.pc += offset();
    }
}
