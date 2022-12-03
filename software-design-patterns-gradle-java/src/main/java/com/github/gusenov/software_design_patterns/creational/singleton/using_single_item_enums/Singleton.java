package com.github.gusenov.software_design_patterns.creational.singleton.using_single_item_enums;

/**
 * A single-element enum type is the best way to implement a singleton.
 *
 * Since Singleton Pattern is about having a private constructor
 * and calling some method to control the instantiations (like some getInstance),
 * in Enums we already have an implicit private constructor.
 *
 * ENUM - A guaranteed singleton.
 * This approach is functionally equivalent to the public field approach, except that it is more concise,
 * provides the serialization machinery for free, and provides an ironclad guarantee against multiple instantiation,
 * even in the face of sophisticated serialization or reflection attacks.
 *
 * Полной защиты от намеренного создания второго экземпляра Singelton’а
 * можно добиться только с помощью использования enum’а с единственным состоянием,
 * но это — неоправданное злоупотребление возможностями языка,
 * ведь очевидно, что enum был придуман не для этого.
 *
 * An {@code enum} type is a special type of class type.
 * Your {@code enum} declaration actually compiles to something like:
 * <pre>{@code
 *  public final class Singleton {
 *      public final static Singleton INSTANCE = new Singleton();
 *      // When your code first accesses INSTANCE, the class Singleton will be loaded and initialized by the JVM.
 *      // This process initializes the static field above once (lazily).
 *
 *      // this class also contain private constructor
 *  }
 * }</pre>
 *
 * Initialization of the enum constants is thread safe.
 *
 * Making a class a Singleton can make it difficult to test its clients,
 * as it’s impossible to substitute a mock implementation for a singleton
 * unless it implements an interface that serves as its type.
 *
 * @see <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton: почему самый известный шаблон проектирования нужно использовать с осторожностью</a>
 * @see <a href="http://vojtechruzicka.com/singleton-pattern-pitfalls/">Singleton Pattern Pitfalls &bull; Design Patterns</a>
 *
 * @see <a href="https://stackoverflow.com/q/26285520/2289640">design patterns - Implementing Singleton with an Enum (in Java) - Stack Overflow</a>
 *
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.9.3">8.9.3. Enum Members</a>
 * @see <a href="https://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.4">12.4. Initialization of Classes and Interfaces</a>
 */
public enum Singleton {

    /**
     * {@code enum} fields are compile time constants, but they are instances of their {@code enum} type.
     * And, they're constructed when the enum type is referenced for the first time.
     *
     * Like all enum instances, Java instantiates each object when the class is loaded,
     * with some guarantee that it's instantiated exactly once per JVM.
     * Think of the INSTANCE declaration as a {@code public static final} field:
     * INSTANCE is same as {@code public static final Singleton INSTANCE = new Singleton();}
     * Java will instantiate the object the first time the class is referred to.
     * The instances are created during static initialization.
     *
     * Who is doing {@code new Singleton()}? The JVM is.
     */
    INSTANCE;

    /**
     * By default enums have implicit empty private constructor
     * and that explicitly adding a private constructor is not needed
     * unless you actually have code that you need to run in that constructor.
     *
     * Each enum field creates an instance only once, so no need to create private constructor.
     *
     * The private modifier has no meaning for an enum constructor and is entirely redundant.
     */
    private Singleton() {
        System.out.println("checks");
    }

    public void doWork() {
        System.out.println(" do work please ");
    }
}
