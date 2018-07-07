package util.dconcurrent.util;

import java.io.IOException;
import java.net.*;

/**
 * Created by lzz on 2018/2/5.
 */
public class NetUtil {
    public static String getLocalIp() throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        return ip;
    }

    public static long pingTime(String ip) throws IOException {
        long startTime = System.currentTimeMillis();
        InetAddress.getByName( ip ).isReachable(3000);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static boolean checkPort(Integer port){
        boolean res = false;
        try {
            String ip = getLocalIp();
            HostAndPort hostAndPort = new HostAndPort(ip, port);
            res = checkIpAndPort( hostAndPort );
        } catch (Exception ignore) {

        }
        return res;
    }

    public static boolean checkIp(String ip){
        boolean res = false;
        try {
            res = InetAddress.getByName(ip).isReachable(5000);
        } catch (Exception ignore) {
        }
        return res;
    }

    public static boolean checkIp(String host, Integer timeOut) {
        try {
            return InetAddress.getByName(host).isReachable(timeOut);
        } catch (Exception e) {
            //ignore
        }
        return false;
    }

    public static boolean checkIpAndPort(HostAndPort hostAndPort){
        boolean res = false;
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress(hostAndPort.getIp(), hostAndPort.getPort()), 15000);
            res = true;
        } catch (IOException ignore) {

        } finally {
            try {
                if( !socket.isClosed() || socket.isConnected()){
                    socket.close();
                }
            } catch (IOException ignore) {
                ignore.printStackTrace();
            }
        }
        return res;
    }

}