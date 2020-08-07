package top.chenjipdc.design.patterns;

import org.junit.Test;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/7 10:31 上午
 */
public class DP01_TestSingleton {

    /**
     * 怎么测也不会出异常
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton1() throws InterruptedException {
        final Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singleton1 instance = Singleton1.getInstance();
                set.add(instance.toString());
            }).start();
        }
        Thread.sleep(1000);
        for (String s : set) {
            System.out.println(s);
        }
        assert set.size() == 1;
    }

    /**
     * 多测几次就可以测出异常
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton2() throws InterruptedException {
        final Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singleton2 instance = Singleton2.getInstance();
                set.add(instance.toString());
            }).start();
        }
        Thread.sleep(1000);
        for (String s : set) {
            System.out.println(s);
        }
        assert set.size() == 1;
    }

    /**
     * 怎么测也不会出异常
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton3() throws InterruptedException {
        final Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singleton3 instance = Singleton3.getInstance();
                set.add(instance.toString());
            }).start();
        }
        Thread.sleep(1000);
        for (String s : set) {
            System.out.println(s);
        }
        assert set.size() == 1;
    }

    /**
     * 模拟不出版初始化对象时a的值为0，概率极小。只能模拟创建的对象是一个单例对象。
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton4() throws InterruptedException {
        final Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singleton4 instance = Singleton4.getInstance();
                set.add(instance.toString());
            }).start();
        }
        Thread.sleep(1000);
        for (String s : set) {
            System.out.println(s);
        }
        assert set.size() == 1;
    }

    /**
     * 怎么测也不会出异常
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton5() throws InterruptedException {
        final Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singleton5 instance = Singleton5.getInstance();
                set.add(instance.toString());
            }).start();
        }
        Thread.sleep(1000);
        for (String s : set) {
            System.out.println(s);
        }
        assert set.size() == 1;
    }

    /**
     * 怎么测也不会出异常
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton6() throws InterruptedException {
        final Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singleton6 instance = Singleton6.getInstance();
                set.add(instance.toString());
            }).start();
        }
        Thread.sleep(1000);
        for (String s : set) {
            System.out.println(s);
        }
        assert set.size() == 1;
    }

    /**
     * 怎么测也不会出异常
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton7() throws InterruptedException {
        final Set<String> set = new ConcurrentSkipListSet<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                Singleton7 instance = Singleton7.getInstance();
                set.add(instance.toString());
            }).start();
        }
        Thread.sleep(1000);
        for (String s : set) {
            System.out.println(s);
        }
        assert set.size() == 1;
    }
}
