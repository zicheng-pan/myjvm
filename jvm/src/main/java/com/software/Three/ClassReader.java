package com.software.Three;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassReader {
    public static ClassFile read(DataInputStream is) throws IOException {
        int magic = is.readInt(); // magic number
        int minorVersion = is.readUnsignedShort(); // minor version
        int majorVersion = is.readUnsignedShort(); // major version

        // constant pool
        int cpSize = is.readUnsignedShort(); // constant_pool_count
        CpInfo[] cpInfo = new CpInfo[cpSize]; // constant_pool
        for (int i = 1; i < cpSize; i++) {
            int tag = is.readUnsignedByte();
            byte[] info = null;
            int step = 0;
            switch (tag) {
                case Const.CONSTANT_Fieldref:
                case Const.CONSTANT_Methodref:
                case Const.CONSTANT_InterfaceMethodref:
                case Const.CONSTANT_InvokeDynamic:
                case Const.CONSTANT_NameAndType:
                case Const.CONSTANT_Integer:
                case Const.CONSTANT_Float:
                    info = new byte[4];
                    is.read(info);
                    break;
                case Const.CONSTANT_MethodHandle:
                    info = new byte[3];
                    is.read(info);
                    break;
                case Const.CONSTANT_Class:
                case Const.CONSTANT_String:
                case Const.CONSTANT_MethodType:
                    info = new byte[2];
                    is.read(info);
                    break;
                case Const.CONSTANT_Utf8:
                    int ulen = is.readUnsignedShort();
                    info = new byte[ulen];
                    is.read(info);
                    break;
                case Const.CONSTANT_Double:
                case Const.CONSTANT_Long:
                    info = new byte[8];
                    is.read(info);
                    step = 1;
                    break;
                default:
                    throw new IllegalStateException("unknown tag, " + tag);
            }
            cpInfo[i] = new CpInfo(new U1(tag), info);
            i += step;
        }

        //parse Method
        int methodsCount = is.readUnsignedShort();
        MethodInfo[] methods = new MethodInfo[methodsCount];
        for (int i = 0; i < methodsCount; i++) {
            int methodAccessFlags = is.readUnsignedShort(); // 访问标志
            int methodNameIndex = is.readUnsignedShort();   // 方法名
            int methodDescriptor = is.readUnsignedShort();  // 方法描述符
            int methodAttributesCount = is.readUnsignedShort(); // 方法属性数
            AttributeInfo[] methodAttributeInfo = new AttributeInfo[methodAttributesCount]; // 方法属性
            for (int j = 0; j < methodAttributesCount; j++) {
                int methodAttributeNameIndex = is.readUnsignedShort();
                int methodAttributeLength = is.readInt();
                byte[] info = new byte[methodAttributeLength];
                is.read(info);
                //指令在 methodAttributeInfo 的其中一个
                methodAttributeInfo[j] = new AttributeInfo(
                        new U2(methodAttributeNameIndex),
                        new U4(methodAttributeLength),
                        info);
            }

            methods[i] = new MethodInfo(
                    new U2(methodAccessFlags),
                    new U2(methodNameIndex),
                    new U2(methodDescriptor),
                    new U2(methodAttributesCount),
                    methodAttributeInfo);
        }


        return new ClassFile(new U4(magic), new U2(minorVersion), new U2(majorVersion), new U2(cpSize), null, null, null, null, null, null, null, null, null, null, null, null);
    }
}
