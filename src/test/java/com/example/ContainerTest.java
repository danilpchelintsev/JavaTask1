package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit тесты для класса Container.
 */
public class ContainerTest {

    @Test
    public void testAddAndGet() {
        Container<Integer> container = new Container<>();
        container.add(1);
        container.add(2);
        container.add(3);

        assertEquals(1, container.get(0));
        assertEquals(2, container.get(1));
        assertEquals(3, container.get(2));
    }

    @Test
    public void testRemove() {
        Container<Integer> container = new Container<>();
        container.add(1);
        container.add(2);
        container.add(3);

        container.remove(1);
        assertEquals(1, container.get(0));
        assertEquals(3, container.get(1));
    }

    @Test
    public void testSize() {
        Container<Integer> container = new Container<>();
        assertEquals(0, container.size());

        container.add(1);
        assertEquals(1, container.size());

        container.add(2);
        assertEquals(2, container.size());

        container.remove(1);
        assertEquals(1, container.size());
    }

    @Test
    public void testOutOfBounds() {
        Container<Integer> container = new Container<>();
        container.add(1);

        assertThrows(IndexOutOfBoundsException.class, () -> container.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> container.remove(1));
    }
}
