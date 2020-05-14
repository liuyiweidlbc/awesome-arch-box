package com.openmindstorm.creational.singleton;

public class SimpleSingleton {

    //外部任何类均不能创建本类的实例
    private SimpleSingleton() {
    }

    private static SimpleSingleton INSTANCE = new SimpleSingleton();

    public static SimpleSingleton getINSTANCE() {
        return INSTANCE;
    }

    public static void main(String[] args) {

        SimpleSingleton singleton = SimpleSingleton.getINSTANCE();
        SimpleSingleton duplicate = SimpleSingleton.getINSTANCE();
        assert (singleton.equals(duplicate));
        System.out.println("饿汉模式单例");
    }
}
