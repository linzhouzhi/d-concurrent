package io.grpc.distribute;

import com.google.gson.Gson;

/**
 * Created by gl49 on 2018/7/4.
 */
public class DmetaParam {
    private static Gson gson = new Gson();

    public byte[] serialized() {
        return gson.toJson(this).toString().getBytes();
    }

    public static DmetaParam unSerialized(byte[] metaByte) {
        String metaStr = String.valueOf(metaByte);
        DmetaParam metaParam = gson.fromJson(metaStr, DmetaParam.class);
        return metaParam;
    }
}
