package util.dconcurrent;

import com.google.common.util.concurrent.ListenableFuture;
import util.dconcurrent.core.DObject;
import util.dconcurrent.util.ByteTransform;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/7/5.
 */
public class DFuture<T> {

    private ListenableFuture<DObject> feature;
    private Class<?> returnType;

    public DFuture(ListenableFuture<DObject> feature, Class<?> returnType) {
        this.feature = feature;
        this.returnType = returnType;
    }

    public T get() throws ExecutionException, InterruptedException {
        DObject dObject = feature.get();
        // 返回值会放到 DObject 中的第一个字段
        byte[] resultByte = dObject.getClassName().getValue().toByteArray();
        return (T) ByteTransform.unSerialized(resultByte, returnType);
    }
}
