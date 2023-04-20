package com.ll.exam.exam1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private MyArrayList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyArrayList<>();
    }

    @Test
    void testAdd() {
        assertTrue(list.add("Element1"));
        assertEquals(1, list.size());
        assertEquals("Element1", list.get(0));
    }

    @Test
    void testRemove() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals("Element2", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void testGet() {
        list.add("Element1");
        list.add("Element2");
        assertEquals("Element1", list.get(0));
        assertEquals("Element2", list.get(1));
    }

    @Test
    void testSize() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        assertEquals(3, list.size());
    }

    @Test
    void testContains() {
        list.add("Element1");
        list.add("Element2");
        assertTrue(list.contains("Element1"));
        assertFalse(list.contains("Element3"));
    }

    @Test
    void testIndexOf() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element1");
        assertEquals(0, list.indexOf("Element1"));
        assertEquals(1, list.indexOf("Element2"));
        assertEquals(-1, list.indexOf("Element3"));
    }

    @Test
    void testClear() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void 데이터_100개_삽입() {
        for (int i = 0; i < 100; i++) {
            list.add("Element%d".formatted(i + 1));
        }
        assertEquals(100,list.size());
    }

    @Test
    void 중간꺼_삭제_후_그_위치_재참조는_삭제한거의_다음꺼() {
        list.add("Element1");
        list.add("Element2");
        list.add("Element3");

        list.remove(1);

        assertEquals("Element3",list.get(1));
    }

    @Test
    void 범위밖조회_예외() {
        assertThrows(IndexOutOfBoundsException.class,()->list.get(1));
    }

    @Test
    void 범위밖삭제_예외() {
        assertThrows(IndexOutOfBoundsException.class,()->list.remove(1));
    }

    @Test
    void removeIfTest() {
        list.add("1");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("3");
        list.add("2");

        assertTrue(list.removeIf(e->e.equals("2")));
        assertEquals(list.size(), 4);
        assertEquals(list.get(0), "1");
        assertEquals(list.get(1), "1");
        assertEquals(list.get(2), "3");
        assertEquals(list.get(3), "3");
    }

    @Test
    void indexOfTest() {
        MyArrayList<String> list = new MyArrayList<>(100);

        IntStream.range(0, 100)
                .forEach(index -> list.add("사과 %d".formatted(index)));

        Assertions.assertThat(list.indexOf("사과 0")).isEqualTo(0);
        Assertions.assertThat(list.indexOf("사과 1")).isEqualTo(1);
        Assertions.assertThat(list.indexOf("사과 5")).isEqualTo(5);
        Assertions.assertThat(list.indexOf("사과 99")).isEqualTo(99);
        Assertions.assertThat(list.indexOf("사과 100")).isEqualTo(-1);
    }
}