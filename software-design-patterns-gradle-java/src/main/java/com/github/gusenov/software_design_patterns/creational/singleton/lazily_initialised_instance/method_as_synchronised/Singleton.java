package com.github.gusenov.software_design_patterns.creational.singleton.lazily_initialised_instance.method_as_synchronised;

/**
 * @see <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton: почему самый известный шаблон проектирования нужно использовать с осторожностью</a>
 * @see <a href="http://vojtechruzicka.com/singleton-pattern-pitfalls/">Singleton Pattern Pitfalls &bull; Design Patterns</a>
 *
 * @see <a href="https://sumitpal.wordpress.com/2010/05/22/volatile-and-synchronized-in-java-explained/">Volatile and Synchronized in Java Explained | Sumit Pal&#039;s Blog</a>
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    /**
     * {@code synchronized} obtains and releases locks on monitors which can force only one thread at a time to execute a code block,
     * if both threads use the same monitor (effectively the same object lock). That’s the fairly well known aspect to synchronized.
     * But synchronized also synchronizes memory. In fact synchronized synchronizes the whole of thread memory with “main” memory.
     *
     * {@code synchronized} synchronizes the value of all variables between thread memory and “main” memory, and locks and releases a monitor to boot.
     * Clearly {@code synchronized} is likely to have more overhead than {@code volatile}.
     *
     * Synchronization boundaries signal to the virtual machine that it must invalidate its registers.
     * When the virtual machine enters a synchronized method or block, it must reload data it has cached in its local registers.
     * Before the virtual machine exits a synchronization method or block, it must store its local registers to main memory.
     *
     * Проблема заключается в том, что, сохраняя время на старте программы,
     * мы теперь будем терять его каждый раз при обращении к Singleton’у из-за того, что метод синхронизирован,
     * а это очень дорого, если к экземпляру приходится часто обращаться. А ведь единственный раз,
     * когда свойство synchronised действительно требуется — первое обращение к методу.
     *
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
