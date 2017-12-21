package com.github.gusenov.software_design_patterns.creational.prototype.bike;

import org.junit.Test;

/**
 * Client: references to {@link Prototype} and instantiates ConcretePrototype.
 *
 * @see <a href="http://www.thejavageek.com/2016/08/26/prototype-design-pattern-implementation/">Prototype Design Pattern Implementation - theJavaGeek</a>
 */
public class Client {
    @Test
    public void test() {
        try {

            System.out.println("Creating a new object now");
            Bike bike = new Bike("Honda", 250);
            System.out.println("Object creation done");


            long start = System.currentTimeMillis();
            System.out.println("Creating clone now");

            // Client calls bike.clone() method which quickly creates another object without taking much time.
            Bike clonedBike = (Bike)bike.clone();

            long end = System.currentTimeMillis();
            System.out.println("Time required = " + (end - start)); // Time required = 0
            System.out.println("Clone created");

        } catch (InterruptedException | CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
