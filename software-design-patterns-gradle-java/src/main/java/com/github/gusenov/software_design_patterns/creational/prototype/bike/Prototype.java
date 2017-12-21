package com.github.gusenov.software_design_patterns.creational.prototype.bike;

/**
 * Prototype design pattern implementation helps us get multiple copies of one object without having to worry about expenses of creating a new object.
 * In java, prototype design pattern implementation can be achieved by using {@link Cloneable} interface.
 *
 * {@link Prototype}: An interface which declares methods for cloning the object.
 *
 * @see <a href="http://www.thejavageek.com/2016/08/26/prototype-design-pattern-implementation/">Prototype Design Pattern Implementation - theJavaGeek</a>
 */
public interface Prototype extends Cloneable {
    public Prototype clone() throws CloneNotSupportedException;
}
