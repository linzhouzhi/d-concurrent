package util.dconcurrent;

import com.google.common.util.concurrent.ListenableFuture;
import util.dconcurrent.core.DBytes;
import util.dconcurrent.util.ByteTransform;

import java.util.concurrent.ExecutionException;

/**
 * Created by lzz on 2018/7/5.
 */
public class DFuture<T> {

    private ListenableFuture<DBytes> feature;
    private Class<?> returnType;

    public DFuture(ListenableFuture<DBytes> feature, Class<?> returnType) {
        this.feature = feature;
        this.returnType = returnType;
    }

    public T get() throws ExecutionException, InterruptedException {
        DBytes dByte = feature.get();
        // 返回值会放到 DObject 中的第一个字段
        byte[] resultByte = dByte.getRes().toByteArray();
        return (T) ByteTransform.unSerialized(resultByte, returnType);
    }
}
