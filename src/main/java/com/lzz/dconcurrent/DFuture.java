package com.lzz.dconcurrent;

import com.google.gson.Gson;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by gl49 on 2018/7/4.
 */
public class DFuture<T> {
    private static Gson gson = new Gson();
    private Class<?> classType;
    public DFuture(Class<?> classType) {
        this.classType = classType;
    }

    public T get(Future futureTask) throws ExecutionException, InterruptedException {
        byte[] resultByte = (byte[]) futureTask.get();
        String resultStr = new String(resultByte);
        return (T) gson.fromJson(resultStr, this.classType);
    }

    public T futureResult(Future futureTask, Class<?> classType) throws ExecutionException, InterruptedException {
        byte[] resultByte = (byte[]) futureTask.get();
        String resultStr = new String(resultByte);
        return (T) gson.fromJson(resultStr, classType);
    }
}
