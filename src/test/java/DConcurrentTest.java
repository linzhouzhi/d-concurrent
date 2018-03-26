import com.lzz.util.dconcurrent.DClient;
import org.junit.Test;

/**
 * Created by lzz on 2018/3/26.
 */
public class DConcurrentTest {
    @Test
    public void test001(){
        DClient.submit(new Runnable() {
            public void run() {
                System.out.println("helllo world");
            }
        });
    }

    @Test
    public void test002(){
        String aa = "fdsa";
        byte[] aaa = aa.getBytes();
        System.out.println( String.valueOf(aaa) );
        byte[] tt = "call able".getBytes();
        System.out.println( new String(tt));
    }
}
