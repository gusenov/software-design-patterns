package com.github.gusenov.software_design_patterns.creational.singleton.lazy_initialization_holder;

/**
 * Это решение основано на том, что вложенные классы не инициализируются до первого их использования.
 *
 * In all versions of Java, the idiom enables a safe, highly concurrent lazy initialization with good performance.
 * The implementation of the idiom relies on the initialization phase of execution within the Java Virtual Machine (JVM)
 * as specified by the Java Language Specification (JLS).
 * When the class {@link Singleton} is loaded by the JVM, the class goes through initialization.
 * Since the class does not have any static variables to initialize, the initialization completes trivially.
 *
 * @see <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton: почему самый известный шаблон проектирования нужно использовать с осторожностью</a>
 * @see <a href="http://vojtechruzicka.com/singleton-pattern-pitfalls/">Singleton Pattern Pitfalls &bull; Design Patterns</a>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom">Initialization-on-demand holder idiom - Wikipedia</a>
 * @see <a href="http://literatejava.com/jvm/fastest-threadsafe-singleton-jvm/">Fastest Thread-safe Singleton in Java | Literate Java</a>
 */
public class Singleton {
    /**
     * While the implementation is an efficient thread-safe "singleton" cache without synchronization overhead,
     * and better performing than uncontended synchronization,
     * the idiom can only be used when the construction of {@link Singleton} can be guaranteed to not fail.
     * In most JVM implementations, if construction of {@link Singleton} fails,
     * subsequent attempts to initialize it from the same class-loader will result in a {@link NoClassDefFoundError} failure.
     */
    private Singleton() {
        // Do nothing.
    }

    /**
     * Calling getSingleton() references the inner class, triggering the JVM to load & initialize it.
     * This is thread-safe, since classloading uses locks.
     * For subsequent calls, the JVM resolves our already-loaded inner class & returns the existing singleton.
     * Thus — a cache.
     *
     * Since the class initialization phase is guaranteed by the JLS to be sequential,
     * i.e., non-concurrent, no further synchronization is required
     * in the static {@link Singleton#getInstance} method during loading and initialization.
     *
     * And since the initialization phase writes the static variable {@link SingletonHolder#instance} in a sequential operation,
     * all subsequent concurrent invocations of the {@link Singleton#getInstance}
     * will return the same correctly initialized {@link SingletonHolder#instance}
     * without incurring any additional synchronization overhead.
     *
     * @return
     */
    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * The static class definition {@link SingletonHolder} within it is not initialized
     * until the JVM determines that {@link SingletonHolder} must be executed.
     *
     * The static class {@link SingletonHolder} is only executed
     * when the static method {@link Singleton#getInstance} is invoked on the class {@link Singleton},
     * and the first time this happens the JVM will load and initialize the {@link SingletonHolder} class.
     *
     * The initialization of the {@link SingletonHolder} class
     * results in static variable {@link SingletonHolder#instance} being initialized by executing the (private) constructor
     * for the outer class {@link Singleton}.
     */
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }
}
