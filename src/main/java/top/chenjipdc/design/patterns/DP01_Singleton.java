package top.chenjipdc.design.patterns;

/**
 * @author chenjipdc@gmail.com
 * @date 2020/8/7 9:46 上午
 */
public class DP01_Singleton {
}

/**
 * 最简单单例，依靠类加载保证创建
 */
class Singleton1 {
    int a = 1;
    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance(){
        return INSTANCE;
    }
}

/**
 * 线程安全有问题单例
 */
class Singleton2 {
    int a = 1;
    private static Singleton2 INSTANCE = null;
    public static Singleton2 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}

/**
 * 暴力的方法上锁，效率低
 */
class Singleton3 {
    int a = 1;
    private static Singleton3 INSTANCE = null;
    public static synchronized Singleton3 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}

/**
 * 粒度更细加锁，双重检查方式。
 * 但是高并发下可能有半初始化对象问题，导致a拿到的是0。
 */
class Singleton4 {
    int a = 1;
    private static Singleton4 INSTANCE = null;
    private static final Object LOCK = new Object();
    public static Singleton4 getInstance(){
        if (INSTANCE == null){
            synchronized (LOCK){
                if (INSTANCE == null){
                    INSTANCE = new Singleton4();
                }
            }
        }
        return INSTANCE;
    }
}

/**
 * 细粒度单例修复半初始化问题，堪称比较完美单例。
 * 属性添加volatile关键字
 */
class Singleton5 {
    int a = 1;
    private static volatile Singleton5 INSTANCE = null;
    private static final Object LOCK = new Object();
    public static Singleton5 getInstance(){
        if (INSTANCE == null){
            synchronized (LOCK){
                if (INSTANCE == null){
                    INSTANCE = new Singleton5();
                }
            }
        }
        return INSTANCE;
    }
}

/**
 * 通过枚举创建单例
 */
class Singleton6 {
    int a = 1;
    public static Singleton6 getInstance(){
        return  ESingleton6.INSTANCE.getInstance();
    }

    enum ESingleton6 {
        /**
         * 创建单例
         */
        INSTANCE;

        private final Singleton6 singleton6;
        ESingleton6() {
            this.singleton6 = new Singleton6();
        }
        private Singleton6 getInstance(){
            return singleton6;
        }
    }
}