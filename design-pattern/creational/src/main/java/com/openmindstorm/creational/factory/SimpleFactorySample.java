package com.openmindstorm.creational.factory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleFactorySample {

    public static void main(String[] args) {
        PhoneFactory factory = new PhoneFactory();
        Phone samsung = factory.create("samsung");
        log.info("first: " + samsung.brand());
        Phone iphone = factory.create("iphone");
        log.info("second: " + iphone.brand());
    }
}


class PhoneFactory{
    public Phone create(String name){
        if ("samsung".equals(name)) {
            return new Samsung();
        } else if ("iphone".equals(name)) {
            return new IPhone();
        } else {
            throw new RuntimeException("illegal phone type");
        }
    }
}

class Samsung implements Phone{
    @Override
    public String brand() {
        return "brand: samsung s20ultra";
    }
}

class IPhone implements Phone{
    @Override
    public String brand() {
        return "brand: apple iphone";
    }
}

interface Phone{
    String brand();
}