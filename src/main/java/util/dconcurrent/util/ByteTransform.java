package util.dconcurrent.util;

import com.google.gson.Gson;

/**
 * Created by gl49 on 2018/7/7.
 */
public class ByteTransform {
    private static Gson gson = new Gson();

    public static byte[] serialized(Object object) {
        return gson.toJson(object).toString().getBytes();
    }

    public static Object unSerialized(byte[] byteObj, Class<?> T) {
        String objStr = new String(byteObj);
        return unSerialized(objStr, T);
    }

    public static Object unSerialized(String objStr, Class<?> T) {
        Object object = gson.fromJson(objStr, T);
        return object;
    }
}
