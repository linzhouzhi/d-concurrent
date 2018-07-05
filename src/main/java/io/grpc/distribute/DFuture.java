package io.grpc.distribute;


import com.google.gson.Gson;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/7/5.
 */
public class DFuture<T> {
    private static Gson gson = new Gson();

    private Future feature;
    private Class<?> returnType;

    public DFuture(Future feature, Class<?> returnType) {
        this.feature = feature;
        this.returnType = returnType;
    }

    public T get() throws ExecutionException, InterruptedException {
        byte[] resultByte = (byte[]) feature.get();
        String resultStr = new String(resultByte);
        return (T) gson.fromJson(resultStr, returnType);
    }
}
