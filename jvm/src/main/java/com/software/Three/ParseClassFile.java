package com.software.Three;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class ParseClassFile {
    public static ClassFile getClassFileByPath(String path) {
        try (
                FileInputStream fis = new FileInputStream(path);
                DataInputStream dis = new DataInputStream(fis)
        ) {
            // 即 读取 U1
            final int unsignedByte = dis.readUnsignedByte();
            // 即 读取 U2
            final int unsignedShort = dis.readUnsignedShort();
            // 即 读取 U4
            final int unsignedInt = dis.readInt();
            int len = 10;
            byte[] bytes = new byte[len];
            // 读取 bytes 长度的 byte 到 bytes 里
            dis.read(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
