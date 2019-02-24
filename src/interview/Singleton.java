package interview;

/**
 * Created by ASUS on 2016/8/30.
 * 单例模式
 */
public class Singleton {

    //-----------------------懒汉式----------------------
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //---------------------------懒汉加锁---------------
    public static synchronized Singleton getInstance1() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //-------------------------饿汉式-------------
    private static Singleton singleton1 = new Singleton();

    public static Singleton getInstance2() {
        return singleton1;
    }

    //-----------------------------静态内部类---------------
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance3() {
        return SingletonHolder.INSTANCE;
    }

    //------------------------双重校验锁------------------
    private static volatile Singleton singleton2;

    public static Singleton getInstance4() {
        if (singleton2 == null) {
            synchronized (Singleton.class) {
                if (singleton2 == null)
                    singleton2 = new Singleton();

            }
        }
        return singleton2;
    }

}
