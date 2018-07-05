package io.grpc.distribute;

import com.google.gson.Gson;

/**
 * Created by lzz on 2018/7/4.
 */
public abstract class DCallable<T> {
    private static Gson gson = new Gson();
    protected byte[] remoteCall() {
        T res =  call();
        byte[] byteRes = gson.toJson( res ).toString().getBytes();
        return byteRes;
    }
    protected abstract T call();
}
