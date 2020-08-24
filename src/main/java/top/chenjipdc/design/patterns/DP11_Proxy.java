package top.chenjipdc.design.patterns;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/24 11:07 上午
 */
public class DP11_Proxy {
}

interface IDoit {
    void doIt();
}

/**
 * 远程代理
 *
 * 为一个位于不同的地址空间的对象提供一个本地的代理对象，这个不同的地址空间可以是在同一台主机中，也可是在另一台主机中，远程代理又称为大使 (Ambassador)。
 */
class RemoteProxy {

}

/**
 * 虚拟代理
 *
 * 如果需要创建一个资源消耗较大的对象，先创建一个消耗相对较小的对象来表示，真实对象只在需要时才会被真正创建。
 */
class VirtualProxy implements IDoit, Runnable{

    private Future<Real> realFuture;
    private volatile Real real;

    public VirtualProxy(Future<Real> realFuture) {
        this.realFuture = realFuture;
        if (realFuture != null){
            new Thread(this).start();
        }
    }

    @Override
    public void doIt() {
        if (real != null){
            real.doIt();
        }else {
            System.out.println("just proxy doit");
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        real = realFuture.get();
    }

    static class Real implements IDoit{
        public Real() {
            System.out.println("创建本对象需要花费一定时间，请等待");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("创建完毕");
        }

        @Override
        public void doIt() {
            System.out.println("real doit");
        }
    }

}

/**
 * 保护代理
 *
 *
 * 控制对一个对象的访问，可以给不同的用户提供不同级别的使用权限。
 */
class ProtectProxy {

}

/**
 * 缓冲代理
 *
 * 为某一个目标操作的结果提供临时的存储空间，以便多个客户端可以共享这些结果。
 */
class CacheProxy {

}

/**
 * 智能引用代理
 *
 * 当一个对象被引用时，提供一些额外的操作，例如将对象被调用的次数记录下来等。
 */
class SmartReferenceProxy implements IDoit{

    private final Real real;
    private final Log log = new Log();
    private final Other other = new Other();

    public SmartReferenceProxy(Real real) {
        this.real = real;
    }

    @Override
    public void doIt() {
        System.out.println("proxy doit start");
        log.log();
        real.doIt();
        other.doSomething();
        System.out.println("proxy doit end");
    }

    static class Real implements IDoit{

        @Override
        public void doIt() {
            System.out.println("real doit");
        }
    }

    static class Log {
        public void log(){
            System.out.println("记录日志");
        }
    }

    static class Other {
        public void doSomething(){
            System.out.println("做某些事");
        }
    }
}