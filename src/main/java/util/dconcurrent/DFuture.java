package util.dconcurrent;

import util.dconcurrent.util.ByteTransform;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/7/5.
 */
public class DFuture<T> {

    private Future feature;
    private Class<?> returnType;

    public DFuture(Future feature, Class<?> returnType) {
        this.feature = feature;
        this.returnType = returnType;
    }

    public T get() throws ExecutionException, InterruptedException {
        byte[] resultByte = (byte[]) feature.get();
        return (T) ByteTransform.unSerialized(resultByte, returnType);
    }
}
