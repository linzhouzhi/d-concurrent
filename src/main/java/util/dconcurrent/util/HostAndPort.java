package util.dconcurrent.util;

/**
 * Created by gl49 on 2018/7/4.
 */
public class HostAndPort {
    private String ip;
    private int port;

    public HostAndPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "HostAndPort{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}
