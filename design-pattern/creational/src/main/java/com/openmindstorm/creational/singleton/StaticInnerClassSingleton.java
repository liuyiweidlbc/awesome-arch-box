package com.openmindstorm.creational.singleton;

public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){}

    public static StaticInnerClassSingleton getInstance(){
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static void main(String[] args) {
        StaticInnerClassSingleton singleton = StaticInnerClassSingleton.getInstance();
        StaticInnerClassSingleton duplicate = StaticInnerClassSingleton.getInstance();
        assert singleton.equals(duplicate);
//        assert !singleton.equals(duplicate);
        System.out.println("静态内部类懒加载单例");
    }
}
