package com.example;

// Лабораторная работа #1. Пчелинцев Данил 3 курс 7 группа

/**
 * Класс Container для хранения произвольного количества объектов.
 * Реализован на основе односвязного списка.
 *
 * @param <T> тип объектов, которые будут храниться в контейнере
 */
public class Container<T> {
    // Узел односвязного списка
    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;


    // Инициализация
    public Container() {
        head = null;
        size = 0;
    }

    /**
     * Добавление элемента в конец контейнера.
     *
     * @param item элемент для добавления
     */

    public void add(T item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Извлечение элемента по индексу.
     *
     * @param index индекс элемента для извлечения
     * @return элемент, находящийся по данному индексу
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона.");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /**
     * Удаление элемента по индексу.
     *
     * @param index индекс элемента для удаления
     * @throws IndexOutOfBoundsException если индекс вне допустимого диапазона
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона.");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Возвращает количество элементов в контейнере.
     *
     * @return количество элементов
     */
    public int size() {
        return size;
    }
}
