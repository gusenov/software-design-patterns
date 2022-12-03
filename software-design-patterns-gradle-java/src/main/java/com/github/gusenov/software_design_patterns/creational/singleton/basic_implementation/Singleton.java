package com.github.gusenov.software_design_patterns.creational.singleton.basic_implementation;

/**
 * Простейшая реализация паттерна "Одиночка".
 * Класс должен гарантированно иметь лишь один объект, и к этому объекту должен быть предоставлен глобальный доступ.
 *
 * It is thread safe because there is nothing in it to cause a race condition.
 *
 * @see <a href="https://tproger.ru/translations/singleton-pitfalls/">Подводные камни Singleton: почему самый известный шаблон проектирования нужно использовать с осторожностью</a>
 * @see <a href="http://vojtechruzicka.com/singleton-pattern-pitfalls/">Singleton Pattern Pitfalls &bull; Design Patterns</a>
 */
public class Singleton {
    /**
     * Поле для хранения экземпляра класса.
     */
    private static Singleton instance = new Singleton();

    /**
     * Приватный конструктор класса, чтобы не было возможности создать экземпляр класса извне.
     */
    private Singleton() {
        // Do nothing.
    }

    /**
     * Метод, который будет давать доступ к экземпляру класса.
     * @return
     */
    public static Singleton getInstance() {
        return instance;
    }
}
