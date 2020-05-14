package com.openmindstorm.creational.singleton;

public class LazyLoadSingleton {

    private volatile static LazyLoadSingleton INSTANCE;

    private LazyLoadSingleton(){

    }

    public static LazyLoadSingleton getInstance(){
        if (INSTANCE == null) {
            synchronized (LazyLoadSingleton.class){
                if (INSTANCE == null) {
                    INSTANCE = new LazyLoadSingleton();
                }
            }
        }

        return INSTANCE;
    }

    public static void main(String[] args) {
        LazyLoadSingleton singleton = LazyLoadSingleton.getInstance();
        LazyLoadSingleton duplicate = LazyLoadSingleton.getInstance();
        assert singleton.equals(duplicate);
        System.out.println("双重检测懒汉模式单例");
    }
}
