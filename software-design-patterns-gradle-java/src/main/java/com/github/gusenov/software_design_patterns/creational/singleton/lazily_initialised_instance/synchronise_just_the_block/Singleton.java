package com.github.gusenov.software_design_patterns.creational.singleton.lazily_initialised_instance.synchronise_just_the_block;

/**
 * @see <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton: почему самый известный шаблон проектирования нужно использовать с осторожностью</a>
 * @see <a href="http://vojtechruzicka.com/singleton-pattern-pitfalls/">Singleton Pattern Pitfalls &bull; Design Patterns</a>
 *
 * @see <a href="https://stackoverflow.com/a/9665538/2289640">java - why using volatile with synchronized block? - Stack Overflow</a>
 * @see <a href="https://sumitpal.wordpress.com/2010/05/22/volatile-and-synchronized-in-java-explained/">Volatile and Synchronized in Java Explained | Sumit Pal&#039;s Blog</a>
 */
public class Singleton {
    /**
     * Threads can have local copies of variables, and the data does not have to be the same as the data held in other threads.
     * In particular, another thread may have updated {@link Singleton#instance} in it’s thread,
     * but the value in the current thread could be different from that updated value.
     * In fact Java has the idea of a “main” memory, and this is the memory that holds the current “correct” value for variables.
     * Threads can have their own copy of data for variables, and the thread copy can be different from the “main” memory.
     *
     * A volatile variable is not allowed to have a local copy of a variable that is different from the value currently held in “main” memory.
     * Effectively, a variable declared volatile must have it’s data synchronized across all threads,
     * so that whenever you access or update the variable in any thread, all other threads immediately see the same value.
     * Of course, it is likely that volatile variables have a higher access and update overhead than “plain” variables,
     * since the reason threads can have their own copy of data is for better efficiency.
     *
     * {@code volatile} only synchronizes the value of one variable between thread memory and “main” memory
     *
     * Using the volatile keyword ensures that the variable is never kept in a register.
     * This guarantees that the variable is truly shared between threads.
     *
     * Volatile alone would not be enough because you need to perform more than one operation atomically.
     */
    private static volatile Singleton instance;

    private Singleton() {
    }

    /**
     * Это нельзя использовать в версии Java ниже, чем 1.5, потому что там используется иная модель памяти.
     *
     * Synchronization by itself would be enough in this case if the first check was within synchronized block
     * (but it's not and one thread might not see changes performed by another if the variable were not volatile).
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
