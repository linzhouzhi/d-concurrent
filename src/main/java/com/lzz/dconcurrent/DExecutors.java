package com.lzz.dconcurrent;

import com.lzz.dconcurrent.util.HostAndPort;
import com.lzz.dconcurrent.util.NetUtil;

import java.lang.reflect.Field;
import java.net.UnknownHostException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/3/26.
 */
public class DExecutors {
    private List<DConcurrentClient> clientList = new ArrayList<DConcurrentClient>();

    public DExecutors(List<HostAndPort> hostAndPortList){
        for(HostAndPort hostAndPort : hostAndPortList){
            DConcurrentClient client = new DConcurrentClient(hostAndPort);
            clientList.add( client );
        }
    }

    public Future submit(final DCallable callable) {
        byte[] className = callable.getClass().getName().getBytes();
        Class classObj = callable.getClass();
        Field[] fields = classObj.getDeclaredFields();
        DmetaParam dmetaParam = null;
        for(Field field : fields){
            if( DmetaParam.class == field.getType().getSuperclass() ){
                System.out.println( field );
                try {
                    field.setAccessible(true);
                    dmetaParam = (DmetaParam) field.get( callable );
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] metaParam = dmetaParam == null ? null : dmetaParam.serialized();
        byte[] metaParamClass = dmetaParam == null ? null : dmetaParam.getClass().getName().getBytes();
        return dclient().call(className, metaParam, metaParamClass);
    }

    public void submit(final DRuannable runnable){
        byte[] className = runnable.getClass().getName().getBytes();
        Class classObj = runnable.getClass();
        Field[] fields = classObj.getDeclaredFields();
        DmetaParam dmetaParam = null;
        for(Field field : fields){
            if( DmetaParam.class == field.getType().getSuperclass() ){
                System.out.println( field );
                try {
                    field.setAccessible(true);
                    dmetaParam = (DmetaParam) field.get( runnable );
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        byte[] metaParam = dmetaParam == null ? null : dmetaParam.serialized();
        byte[] metaParamClass = dmetaParam == null ? null : dmetaParam.getClass().getName().getBytes();
        dclient().run( className, metaParam,  metaParamClass);
    }

    private DConcurrentClient dclient(){
        List<DConcurrentClient> tmpClientList = new ArrayList<DConcurrentClient>();
        Random random = new Random();
        for(DConcurrentClient client : clientList){
            if( !client.isShutdown() ){
                tmpClientList.add( client );
            }
        }

        int index = random.nextInt(tmpClientList.size());
        System.out.println("get client randow index : " + index);
        return tmpClientList.get( index );
    }

    public boolean isLeader(int serverPort){
        boolean res = false;
        try {
            String localIp = NetUtil.getLocalIp();
            for(DConcurrentClient client : clientList){
                try {
                    if(NetUtil.checkIpAndPort( client.hostAndPort) ){
                        if( localIp.equals( client.hostAndPort.getIp() ) && client.hostAndPort.getPort() == serverPort) {
                            res = true;
                        }
                        break;
                    }
                }catch (Exception e){}
            }
            Thread.sleep(2000);
        }catch (Exception e){

        }
        return res;
    }
}
