package com.openmindstorm.creational.singleton;

public class EnumSingleton {
    private EnumSingleton(){}

    enum SingletonEnum{//静态枚举类
        INSTANCE;

        private EnumSingleton singleton;

        SingletonEnum(){
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance(){
            return singleton;
        }
    }

    public static EnumSingleton getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.getInstance();
        EnumSingleton duplicate = EnumSingleton.getInstance();
        assert singleton.equals(duplicate);
        System.out.println("枚举单例");
    }
}
