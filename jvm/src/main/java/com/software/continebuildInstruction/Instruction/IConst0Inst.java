package com.software.continebuildInstruction.Instruction;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;

public class IConst0Inst implements Instruct {

    //
    @Override
    public void eval(Frame frame) {
        frame.operandStack.push(0);
        frame.pc += offset();
    }
}
