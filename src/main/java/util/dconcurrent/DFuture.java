package util.dconcurrent;

import com.google.common.util.concurrent.ListenableFuture;
import util.dconcurrent.core.DBytes;
import util.dconcurrent.util.ByteTransform;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by lzz on 2018/7/5.
 */
public class DFuture<T> {

    private ListenableFuture<DBytes> future;
    private Class<?> returnType;

    public DFuture(ListenableFuture<DBytes> future, Class<?> returnType) {
        this.future = future;
        this.returnType = returnType;
    }

    public T get() throws ExecutionException, InterruptedException {
        T res = null;
        try {
            res =  get(0, null);
        } catch (TimeoutException ignore) {

        }
        return res;
    }

    public T get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        DBytes dByte;
        if( 0 == timeout || null == unit ){
            dByte = future.get();
        }else{
            dByte = future.get(timeout, unit);
        }
        // 返回值会放到 DObject 中的第一个字段
        byte[] resultByte = dByte.getRes().toByteArray();
        return (T) ByteTransform.unSerialized(resultByte, returnType);
    }
}
