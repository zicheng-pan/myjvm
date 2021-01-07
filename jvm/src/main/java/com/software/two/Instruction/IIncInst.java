package com.software.two.Instruction;

import com.software.one.Frame;
import com.software.one.Instruct;
//iinc 指令，指令参数有两个，参数 1，表示在本地变量表的索引，参数 2，表示需要增加的值。
//指令作用是将本地变量表指令参数 1 对应位置的值加上指令参数 2，将结果放置于本地变量表指令参数 1 位置。
public class IIncInst implements Instruct {

    public final int index;
    public final int val;

    public IIncInst(int index, int val) {
        this.index = index;
        this.val = val;
    }

    @Override
    public void eval(Frame frame) {
        int tmp = frame.localVars.get(index);
        tmp += val;
        frame.localVars.put(index, tmp);

        frame.pc += offset();
    }

    @Override
    public int offset() {
        return 3;
    }

}
