package util.dconcurrent;

import util.dconcurrent.util.DClassLoader;
import util.dconcurrent.util.HostAndPort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by gl49 on 2018/7/10.
 */
public class DExecutorsManager {
    private String classPath;
    public DExecutorsManager(){

    }
    public DExecutorsManager(String classPath){
        this.classPath = classPath;
    }

    public void serverStart(int serverPort) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        DClassLoader reloader = new DClassLoader(this.classPath);
        Class r = reloader.findClass("util.dconcurrent.DExecutorsManager");
        Method method = r.getMethod("dserverStart", int.class);
        method.invoke(null, serverPort);
    }

    public DExecutors newFixDExecutor(List<HostAndPort> hostAndPortList) throws Exception {
        DClassLoader reloader = new DClassLoader(this.classPath);
        Class r = reloader.findClass("util.dconcurrent.DExecutorsManager");
        Method method = r.getMethod("dnewFixDExecutor", List.class);
        DExecutors dExecutors = (DExecutors) method.invoke(null, hostAndPortList);
        return dExecutors;
    }

    public static void dserverStart(int serverPort) throws Exception {
        DExecutors.serverStart(serverPort);
    }

    public static DExecutors dnewFixDExecutor(List<HostAndPort> hostAndPortList){
        DExecutors dExecutors = DExecutors.newFixDExecutor( hostAndPortList );
        return dExecutors;
    }
}
