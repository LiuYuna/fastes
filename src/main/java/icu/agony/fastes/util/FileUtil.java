package icu.agony.fastes.util;


import java.io.InputStream;

public enum FileUtil {
    ;

    public static InputStream gerResource(String path) {
        return FileUtil.class.getClassLoader().getResourceAsStream(path);
    }

}
