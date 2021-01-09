package com.software.readClassFile;

import com.software.buildInstruction.Instruct;
import com.software.buildInstruction.Instruction.ILoad0Inst;
import com.software.buildInstruction.Instruction.IReturnInst;
import com.software.buildInstruction.Instruction.IStore0Inst;
import com.software.buildInstruction.Instruction.Iconst1Inst;
import com.software.continebuildInstruction.Instruction.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Code {
    int maxStack;
    int maxLocals;
    // the real code
    byte[] bytes;
    ExceptionTableItem[] exceptionTable;
    AttributeInfo[] attributes;

    public Code(int maxStack, int maxLocals, ExceptionTableItem[] exceptionTable, byte[] bytes, AttributeInfo[] attributes) {
        this.maxStack = maxStack;
        this.maxLocals = maxLocals;
        this.exceptionTable = exceptionTable;
        this.bytes = bytes;
        this.attributes = attributes;
    }


    public Map<Integer, Instruct> getInstructions(CpInfo[] cp) {
        Map<Integer, Instruct> instructionMap = new HashMap<>();
        try (ByteArrayInputStream bis = new ByteArrayInputStream(this.bytes);
             final DataInputStream dis = new DataInputStream(bis)
        ) {
            int pc = 0;
            while (dis.available() > 0) {
                final int opcode = dis.read();
                switch (opcode) {
                    case 0x04:
                        instructionMap.put(pc, new Iconst1Inst());
                        pc++;
                        break;
                    case 0x3b:
                        instructionMap.put(pc, new IStore0Inst());
                        pc++;
                        break;
                    case 0x1a:
                        instructionMap.put(pc, new ILoad0Inst());
                        pc++;
                        break;
                    case 0xac:
                        instructionMap.put(pc, new IReturnInst());
                        pc++;
                        break;
                    case 0x03:
                        instructionMap.put(pc, new IConst0Inst());
                        pc++;
                        break;
                    case 0x3c:
                        instructionMap.put(pc, new IStore1Inst());
                        pc++;
                        break;
                    case 0x3d:
                        instructionMap.put(pc, new IStore2Inst());
                        pc++;
                        break;
                    case 0x1b:
                        instructionMap.put(pc, new ILoad1Inst());
                        pc++;
                        break;
                    case 0x1c:
                        instructionMap.put(pc, new ILoad2Inst());
                        pc++;
                        break;
                    case 0x60:
                        instructionMap.put(pc, new IAddInst());
                        pc++;
                        break;
                    case 0x10:
                        instructionMap.put(pc, new BiPushInst(dis.readByte()));
                        pc += 2;
                        break;
                    case 0x84:
                        instructionMap.put(pc, new IIncInst(dis.readUnsignedByte(), dis.readByte()));
                        pc += 3;
                        break;
                    case 0xa7:
                        instructionMap.put(pc, new GotoInst(dis.readShort()));
                        pc += 3;
                        break;
                    case 0xa3:
                        instructionMap.put(pc, new IfICmpGtInst(dis.readShort()));
                        pc += 3;
                        break;
                    default:
                        throw new IllegalStateException("unknown opcode " + opcode);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("method code parse failure");
        }

        return instructionMap;
    }
}

