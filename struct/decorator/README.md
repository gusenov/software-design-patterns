# Декоратор

Паттерн декоратор может быть применим, когда уже есть какая-то библиотека интерфейсы, которой надо расширить.
Но нельзя поменять код интерфейсов и объектов.

Паттерн декоратор признак плохого дизайна.
Как будто что-то сделалано не так, а потом исправляется паттерном.
Использовать декоратор для своих классов может быть признаком плохой архитектуры.
Почему бы сразу не сделать подходящий интерфейс, без того чтобы потом его декорировать?
Но в реальных случаях при использовании третьих компонентов надо совмещать их.
В таком случае такие способы могут быть применимы.
