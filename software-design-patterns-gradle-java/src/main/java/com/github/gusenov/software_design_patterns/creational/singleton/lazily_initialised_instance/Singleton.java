package com.github.gusenov.software_design_patterns.creational.singleton.lazily_initialised_instance;

/**
 * Один из популярных вариантов реализации Singleton содержит ленивую инициализацию.
 *
 * @see <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton: почему самый известный шаблон проектирования нужно использовать с осторожностью</a>
 * @see <a href="http://vojtechruzicka.com/singleton-pattern-pitfalls/">Singleton Pattern Pitfalls &bull; Design Patterns</a>
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    /**
     * Объект класса создаётся не в самом начале, а лишь когда будет получено первое обращение к нему.
     *
     * Однако здесь начинаются проблемы с потоками, которые могут создавать несколько различных объектов.
     * Происходит это примерно так:
     * <ul>
     *     <li>Первый поток обращается к getInstance(), когда объект ещё не создан;</li>
     *     <li>В это время второй тоже обращается к этому методу, пока первый ещё не успел создать объект, и сам создаёт его;</li>
     *     <li>Первый поток создаёт ещё один, второй, экземпляр класса.</li>
     * </ul>
     *
     * @return
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
