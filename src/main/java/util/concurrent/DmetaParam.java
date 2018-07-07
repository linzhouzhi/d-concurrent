package util.concurrent;

import util.concurrent.util.ByteTransform;

/**
 * Created by gl49 on 2018/7/4.
 */
public class DmetaParam {
    public byte[] serialized() {
        return ByteTransform.serialized( this );
    }
}
