package util.dconcurrent;

import util.dconcurrent.util.ByteTransform;

/**
 * Created by lzz on 2018/7/4.
 */
public abstract class DCallable<T> {
    protected byte[] remoteCall() {
        T res =  call();
        byte[] byteRes = ByteTransform.serialized( res );
        return byteRes;
    }
    protected abstract T call();
}
