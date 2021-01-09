package com.software.readClassFile;

public class Utils {
    public static String getUtf8(CpInfo[] cp, int utf8Idx) {
        final CpInfo utf8 = cp[utf8Idx];
        if (utf8.tag.val != Const.CONSTANT_Utf8) {
            throw new IllegalStateException("unexpect tag");
        }

        return new String(utf8.info);
    }
}
