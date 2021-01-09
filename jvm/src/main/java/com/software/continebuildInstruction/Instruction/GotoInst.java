package com.software.continebuildInstruction.Instruction;

import com.software.buildInstruction.Frame;
import com.software.buildInstruction.Instruct;

//goto 指令，指令参数是个 int 数字。指令作用是无条件将程序计数器设置为指令参数的值。
public class GotoInst implements Instruct {

    public final int offset;

    public GotoInst(int offset) {
        this.offset = offset;
    }

    /*
    变更就是将 frame.pc = offset; 替换为 frame.pc += offset;，替换的原因是因为 class 文件内部保存 offset 的是个相对值，而 javap 命令为了方便开发者，将相对值改为了绝对值，比如 misc/Sum10.class 的 sum10 方法的 goto 指令，在使用 javap 命令时指令参数是 4，但实际上从 class 文件解析得到的值是 -13。因此需要改动这两处的代码。
     */

    @Override
//    public void eval(Frame frame) {
//        frame.pc = offset;
//    }
    public void eval(Frame frame) {
        frame.pc += offset;
    }

    @Override
    public int offset() {
        return 3;
    }
}
