package com.software.readClassFile;

public class ExceptionTableItem {
    final int startPc;
    final int endPc;
    final int handlerPc;
    final int catchType;

    public ExceptionTableItem(int startPc, int endPc, int handlerPc, int catchType) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
    }
}
