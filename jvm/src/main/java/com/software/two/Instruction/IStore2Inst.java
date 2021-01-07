package com.software.two.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;

public class IStore2Inst implements Instruct {
    @Override
    public void eval(Frame frame) {
        frame.localVars.put(2, frame.operandStack.pop());
        frame.pc += offset();
    }
}
