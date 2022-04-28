package ru.eleventh;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThrxTest {

    @Test
    void invalidInputTest() {
        assertThrows(AssertionError.class, () -> Thrx.calculateWaterAmount(new int[]{0, 0, -1, 0, 0}));
    }

    @Test
    void noDataTest() {
        assertEquals(0, Thrx.calculateWaterAmount(new int[]{}));
        assertEquals(0, Thrx.calculateWaterAmount(new int[]{0, 0, 0, 0, 0}));
    }

    @Test
    void trivialCasesTest() {
        assertEquals(0, Thrx.calculateWaterAmount(new int[]{0, 0, 1, 0, 0}));
        assertEquals(0, Thrx.calculateWaterAmount(new int[]{1, 0, 0, 0, 0}));
        assertEquals(0, Thrx.calculateWaterAmount(new int[]{0, 0, 0, 0, 1}));
        assertEquals(0, Thrx.calculateWaterAmount(new int[]{1, 1, 1, 1, 1}));

        assertEquals(0, Thrx.calculateWaterAmount(new int[]{4, 3, 2, 1, 0}));
        assertEquals(0, Thrx.calculateWaterAmount(new int[]{0, 1, 2, 3, 4}));

        assertEquals(9, Thrx.calculateWaterAmount(new int[]{3, 0, 3, 0, 3, 0, 3}));
        assertEquals(9, Thrx.calculateWaterAmount(new int[]{3, 1, 2, 3, 0, 0, 6}));
        assertEquals(15, Thrx.calculateWaterAmount(new int[]{3, 0, 0, 0, 0, 0, 3}));

        assertEquals(8, Thrx.calculateWaterAmount(new int[]{3, 0, 5, 0, 5, 0, 0}));
        assertEquals(8, Thrx.calculateWaterAmount(new int[]{0, 0, 5, 0, 5, 0, 3}));
        assertEquals(11, Thrx.calculateWaterAmount(new int[]{3, 0, 5, 0, 5, 0, 3}));
    }
}
