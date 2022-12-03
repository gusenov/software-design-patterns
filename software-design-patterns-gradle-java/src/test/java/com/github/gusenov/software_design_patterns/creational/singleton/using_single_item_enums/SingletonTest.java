package com.github.gusenov.software_design_patterns.creational.singleton.using_single_item_enums;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import java.lang.reflect.Constructor;

public class SingletonTest {
    @Test
    public void test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Singleton.INSTANCE.hashCode());
    }

    @Test(expected = NoSuchMethodException.class)
    public void testReflectionAttack() throws NoSuchMethodException {
        Class clazz = Singleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
    }
}
