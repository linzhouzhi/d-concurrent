package util.dconcurrent.util;

import util.dconcurrent.DExecutors;
import util.dconcurrent.DExecutorsManager;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
// https://blog.csdn.net/idontwantobe/article/details/48497465

/**
 * Created by gl49 on 2018/7/9.
 */
public class DClassLoader extends ClassLoader {
    private String classPath;

    public DClassLoader(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;

    }

    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }

}