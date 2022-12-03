package com.github.gusenov.software_design_patterns.creational.singleton.lazily_initialised_instance.synchronise_just_the_block;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

public class SingletonTest {
    /**
     * Используя рефлексию, можно изменить видимость конструктора с private на public прямо во время исполнения.
     * @throws NoSuchMethodException
     */
    @Test
    public void testReflectionAttack() throws NoSuchMethodException {
        Class clazz = Singleton.class;
        Constructor constructor = clazz.getDeclaredConstructor();
        assertFalse(constructor.isAccessible());
        constructor.setAccessible(true);
        assertFalse(constructor.isAccessible());
    }
}
