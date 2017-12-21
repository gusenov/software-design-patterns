package com.github.gusenov.software_design_patterns.creational.prototype.bike;

/**
 * ConcretePrototype: A concrete class which implements {@link Prototype} interface.
 *
 * @see <a href="http://www.thejavageek.com/2016/08/26/prototype-design-pattern-implementation/">Prototype Design Pattern Implementation - theJavaGeek</a>
 */
public class Bike implements Prototype {
    private String manufacturer;

    private int engineCapacity;

    /**
     * We have created Bike constructor such that it takes 2000 milliseconds to simulate expensive object creation which takes lot of time.
     * We are printing out time spent in constructing {@link Bike} object using constructor.
     *
     * @param manufacturer
     * @param engineCapacity
     * @throws InterruptedException
     */
    public Bike(String manufacturer, int engineCapacity) throws InterruptedException {
        this.manufacturer = manufacturer;
        this.engineCapacity = engineCapacity;

        long start = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("Time required = " + (end - start)); // Time required = 2000
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    /**
     * Although clone method is defined in Object class, we have to implement Cloneable for some reason which we will not discuss here.
     *
     * This helps us create multiple object clones where creation of object is expensive and resource intensive.
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Prototype clone() throws CloneNotSupportedException{
        return (Bike)super.clone();
    }
}
