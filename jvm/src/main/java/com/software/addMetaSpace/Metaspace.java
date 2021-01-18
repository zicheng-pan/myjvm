package com.software.addMetaSpace;

import com.software.addclassPath.Class;
import com.software.addclassPath.ClassLoader;

import java.util.HashMap;
import java.util.Map;

/*
缓存加载过的类, 避免重复加载。
缓存类加载器，以便实现运行时类加载。
维护本地方法映射, 后面实现本地方法调用时会涉及到。
维护虚拟机的调用栈，实现方法调用时会涉及到。
 */
public class Metaspace {


    static final Map<String, Class> CLASS_MAP = new HashMap<>();

    public static Class findClass(String name) {
        return CLASS_MAP.get(name);
    }

    public static void putClass(String name, Class clazz) {
        if (CLASS_MAP.containsKey(name)) {
            throw new IllegalStateException("duplicate class name, " + name);
        }
        CLASS_MAP.put(name, clazz);
    }

    /**
     * 类加载器
     */
    static ClassLoader loader;

    public static void setClassLoader(ClassLoader classLoader) {
        loader = classLoader;
    }

    public static ClassLoader getClassLoader() {
        return loader;
    }


}
