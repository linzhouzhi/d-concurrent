package com.lzz.dconcurrent.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/3/26.
 */
public class DExecutors {
    static List<DConcurrentClient> clients = new ArrayList<DConcurrentClient>();
    static {
        DConcurrentClient client = new DConcurrentClient("127.0.0.1",50052);
        clients.add( client );
    }

    public Future<byte[]> submit(final Callable callable){
        return dclient().submit(callable);
    }

    public void submit(final Runnable runnable){
        dclient().submit(runnable);
    }

    public void submit(final DRuannable runnable){
        runnable.run();
        //dclient().submit(runnable);
    }

    private static DConcurrentClient dclient(){
        return clients.get(0);
    }


}
