package com.software.addclassPath;

import com.software.readClassFile.ClassFile;
import com.software.readClassFile.ClassReader;

import java.io.*;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

//jar 文件其实就是 zip 文件，因此我们可以使用 java.uti.ZipFile 类来加载 jar 文件，通过其 API 可以拿到相应文件的输入流 InputStream，进而可以通过 ClassReader 来读取得到对应 ClassFile 实例。
public class ClassLoader {

    String classpath;

    public ClassLoader(String classpath) {
        this.classpath = classpath;
    }

    /**
     * 从 jar 包中加载 class
     *
     * @param path jar 文件路径
     * @param name 类名
     * @return return null if not found
     */
    public ClassFile loadClassFileFromJar(String path, String name) {
        ZipFile file;
        try {
            file = new ZipFile(path);
        } catch (IOException e) {
            throw new IllegalStateException("not found jar file, " + path);
        }

        ZipEntry entry = file.getEntry(name + ".class");
        if (entry == null) {
            return null;
        }

        try (InputStream is = file.getInputStream(entry);
             DataInputStream dis = new DataInputStream(is)) {
            return ClassReader.read(dis);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException("read class failure, " + name);
        }
    }

    public ClassFile loadClassFileFromDir(String path, String name) {
        if (!name.contains("/")) {
            final File dir = new File(path);
            if (!dir.exists()) {
                return null;
            }
            final String[] files = dir.list();
            if (files == null) {
                return null;
            }

            for (String file : files) {
                // found it
                if (Objects.equals(file, name + ".class")) {
                    try (FileInputStream fis = new FileInputStream(new File(path + "/" + name + ".class"));
                         DataInputStream dis = new DataInputStream(fis)) {
                        return ClassReader.read(dis);
                    } catch (Exception e) {
                        throw new IllegalStateException("read class failure, " + name);
                    }
                }
            }
            return null;
        }

        // 继续下一个目录
        int idx = name.indexOf("/");
        String subDir = name.substring(0, idx);
        String subPath = path + "/" + subDir;
        final String newName = name.substring(idx + 1);
        return loadClassFileFromDir(subPath, newName);
    }

    /**
     * 从 classpath 中加载 class
     *
     * @param classpath e.g temp/test.jar:misc
     * @param name      类名
     * @return return null if not found
     */
    ClassFile loadClassFileFromClasspath(String classpath, String name) {
        ClassFile classFile = null;
        for (String path : classpath.split(":")) {
            // 2.1 jar ?
            if (path.endsWith(".jar")) {
                classFile = loadClassFileFromJar(path, name);
                if (classFile != null) {
                    break;
                }
            } else {
                // dir
                classFile = loadClassFileFromDir(path, name);
                if (classFile != null) {
                    break;
                }
            }
        }

        if (classFile == null) {
            throw new IllegalStateException("class not found, " + name);
        }
        return classFile;
    }
}
