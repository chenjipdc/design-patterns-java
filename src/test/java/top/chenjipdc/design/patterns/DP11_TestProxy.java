package top.chenjipdc.design.patterns;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/24 11:07 上午
 */
public class DP11_TestProxy {

    private static final ExecutorService pool = Executors.newSingleThreadExecutor();


    @Test
    public void testVirtualProxy() {
        Future<VirtualProxy.Real> realFuture = pool.submit(() -> {
            System.out.println("历程艰苦的创建real对象");
            Thread.sleep(1000);
            return new VirtualProxy.Real();
        });

        VirtualProxy virtualProxy = new VirtualProxy(realFuture);
        virtualProxy.doIt();
        for (int i = 0; i < 5; i++) {
            virtualProxy.doIt();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testSmartReferenceProxy() {
        new SmartReferenceProxy(new SmartReferenceProxy.Real()).doIt();
    }
}
