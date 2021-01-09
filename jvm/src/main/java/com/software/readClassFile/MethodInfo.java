package com.software.readClassFile;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

// 方法信息
//https://docs.oracle.com/javase/specs/jvms/se8/html/jvms-4.html#jvms-4.6
public class MethodInfo {

    U2 accessFlags; // 访问标志
    U2 nameIndex; // 方法名索引
    U2 descriptorIndex; // 方法描述符索引
    U2 attributesCount; // 属性数
    AttributeInfo[] attributes; // 属性

    public MethodInfo(U2 accessFlags,
                      U2 nameIndex,
                      U2 descriptorIndex,
                      U2 attributesCount,
                      AttributeInfo[] attributes) {
        this.accessFlags = accessFlags;
        this.nameIndex = nameIndex;
        this.descriptorIndex = descriptorIndex;
        this.attributesCount = attributesCount;
        this.attributes = attributes;
    }

    public Code getCode(ClassFile classFile) {
        Code code = null;
        final CpInfo[] constantPool = classFile.constantPool;
        for (AttributeInfo attribute : this.attributes) {
            final String attrName = Utils.getUtf8(constantPool, attribute.attributeNameIndex.val);
            if (Objects.equals("Code", attrName)) {
                final byte[] bytes = attribute.info;
                try (ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                     final DataInputStream dis = new DataInputStream(bis)
                ) {
                    final int maxStack = dis.readUnsignedShort();
                    final int maxLocals = dis.readUnsignedShort();
                    final int codeLength = dis.readInt();
                    byte[] codeBytes = new byte[codeLength];
                    dis.read(codeBytes);

                    final int exceptionTableLength = dis.readUnsignedShort();
                    // 异常表解析
                    final ExceptionTableItem[] exceptionTable = new ExceptionTableItem[exceptionTableLength];
                    if (exceptionTableLength > 0) {
                        for (int j = 0; j < exceptionTableLength; j++) {
                            exceptionTable[j] = new ExceptionTableItem(dis.readUnsignedShort(), dis.readUnsignedShort(),
                                    dis.readUnsignedShort(), dis.readUnsignedShort());
                        }
                    }

                    final int attributesCount = dis.readUnsignedShort();
                    AttributeInfo[] attributeInfos = new AttributeInfo[attributesCount];
                    for (int j = 0; j < attributeInfos.length; j++) {
                        int attributeNameIndex = dis.readUnsignedShort();
                        int attributeLength = dis.readInt();
                        byte[] info = new byte[attributeLength];
                        dis.read(info);
                        attributeInfos[j] = new AttributeInfo(new U2(attributeNameIndex), new U4(attributeLength), info);
                    }

                    code = new Code(maxStack, maxLocals, exceptionTable, codeBytes, attributeInfos);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new IllegalStateException("unknown exception");
                }
            }
        }
        return code;
    }
}
