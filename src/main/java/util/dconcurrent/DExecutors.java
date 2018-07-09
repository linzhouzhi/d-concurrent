package util.dconcurrent;

import com.google.common.collect.Lists;
import util.dconcurrent.core.DConcurrent;
import util.dconcurrent.strategy.RandomStrategy;
import util.dconcurrent.util.HostAndPort;
import util.dconcurrent.util.NetUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by lzz on 2018/3/26.
 */
public class DExecutors {
    private static List<DConcurrentClient> clientList = new ArrayList();
    private static List<DConcurrentClient> activeClientList = new ArrayList();
    private BalanceStrategy balanceStrategy = new RandomStrategy();
    public DExecutors(List<HostAndPort> hostAndPortList){
        clientInit(hostAndPortList);
    }

    public DExecutors(List<HostAndPort> hostAndPortList, BalanceStrategy balanceStrategy){
        this.balanceStrategy = balanceStrategy;
        clientInit(hostAndPortList);
    }

    static {
        Thread checkClientThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        activeClientList = new ArrayList();
                        for(DConcurrentClient client : clientList){
                            if( checkService( client.hostAndPort ) ){
                                activeClientList.add( client );
                            }
                        }
                        if( activeClientList.size() < clientList.size()/(double)2 ){
                            activeClientList = new ArrayList();
                            System.out.println("dconcurrent without able client");
                        }
                        Thread.sleep(10000);
                    }catch (Exception ignore){

                    }
                }
            }
        });
        checkClientThread.setName("dconcurrent-check-client-active");
        checkClientThread.setDaemon(true);
        checkClientThread.start();
    }

    private void clientInit(List<HostAndPort> hostAndPortList){
        for(HostAndPort hostAndPort : hostAndPortList){
            DConcurrentClient client = new DConcurrentClient(hostAndPort);
            clientList.add( client );
        }
    }
    public DFuture submit(final DCallable callable, String balanceKey) {
        Method runMethod = null;
        try {
            runMethod = callable.getClass().getDeclaredMethod( "call" );
        }catch (Exception e){

        }
        Type t = runMethod.getReturnType();
        Class<?> returnType = (Class<?>) t;
        byte[] className = callable.getClass().getName().getBytes();
        Class classObj = callable.getClass();
        Field[] fields = classObj.getDeclaredFields();
        DmetaParam dmetaParam = getDmetaParam(fields, callable);
        byte[] metaParam = dmetaParam == null ? null : dmetaParam.serialized();
        byte[] metaParamClass = dmetaParam == null ? null : dmetaParam.getClass().getName().getBytes();
        Future future = dclient(balanceKey).call(className, metaParam, metaParamClass);
        DFuture dfuture = new DFuture(future, returnType);
        return dfuture;
    }
    public DFuture submit(final DCallable callable) {
        return submit(callable, null);
    }

    public void submit(final Runnable runnable, String balanceKey){
        byte[] className = runnable.getClass().getName().getBytes();
        Class classObj = runnable.getClass();
        Field[] fields = classObj.getDeclaredFields();
        DmetaParam dmetaParam = getDmetaParam(fields, runnable);
        byte[] metaParam = dmetaParam == null ? null : dmetaParam.serialized();
        byte[] metaParamClass = dmetaParam == null ? null : dmetaParam.getClass().getName().getBytes();
        dclient(balanceKey).run( className, metaParam,  metaParamClass);
    }
    public void submit(final Runnable runnable){
        submit(runnable, null);
    }

    private DmetaParam getDmetaParam(Field[] fields, Object object) {
        DmetaParam dmetaParam = null;
        for(Field field : fields){
            if( DmetaParam.class == field.getType().getSuperclass() ){
                System.out.println( field );
                try {
                    field.setAccessible(true);
                    dmetaParam = (DmetaParam) field.get( object );
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return dmetaParam;
    }

    private DConcurrentClient dclient(String balanceKey){
        return (DConcurrentClient) balanceStrategy.getClient( activeClientList, balanceKey );
    }

    public boolean isLeader(){
        boolean res = false;
        try {
            String localIp = NetUtil.getLocalIp();
            for(DConcurrentClient client : activeClientList){
                HostAndPort hostAndPort = client.hostAndPort;
                try {
                    if( localIp.equals( hostAndPort.getIp() ) && hostAndPort.getPort() == DConcurrentServer.port) {
                        res = true;
                    }
                    break;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("leader..................................." + localIp + ":" + DConcurrentServer.port + " is " + res);
            // 不是 leader 10 秒后再试，因为有可能是其它节点挂了
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return res;
    }


    public static boolean checkService(HostAndPort hostAndPort){
        boolean res = false;
        try {
            DConcurrentClient dConcurrentClient = new DConcurrentClient( hostAndPort );
            dConcurrentClient.getStatus();
            dConcurrentClient.shutdown();
            res = true;
        }catch (Exception e){

        }
        return res;
    }
}
