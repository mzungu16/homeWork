package lesson14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Lesson14Test {
    @Test
    void getNewArray_Success() {
        int[] intArray1 = {1, 2, 4, 5, 4, 2, 5, 6, 7};
        int[] intArray2 = {1, 2, 4, 5, 4, 6, 7};
        int[] intArray3 = {34, 213, 123, 4, 123, 21, 3};
        int[] intArray4 = {1, 2, 5, 2, 5, 6, 7};
        int[] expectedIntArray1 = {2, 5, 6, 7};
        int[] expectedIntArray2 = {6, 7};
        int[] expectedIntArray3 = {123, 21, 3};
        Assertions.assertArrayEquals(expectedIntArray1, Lesson14.getNewArray(intArray1));
        Assertions.assertArrayEquals(expectedIntArray2, Lesson14.getNewArray(intArray2));
        Assertions.assertArrayEquals(expectedIntArray3, Lesson14.getNewArray(intArray3));
        Assertions.assertThrows(RuntimeException.class, () -> Lesson14.getNewArray(intArray4));
    }

    @Test
    void getNewArray_Failed() {
        int[] intArray1 = {1, 2, 4, 5, 4, 2, 5, 6, 7};
        int[] expectedIntArray = {2, 7};
        Assertions.assertArrayEquals(expectedIntArray, Lesson14.getNewArray(intArray1));
    }

    @Test
    void checkArray_Success() {
        int[] arrayToCheck1 = {1, 4, 4, 1, 4, 1, 1, 1};
        int[] arrayToCheck2 = {1, 1, 1, 1, 1, 1, 1, 1};
        Assertions.assertTrue(Lesson14.checkArray(arrayToCheck1));
        Assertions.assertFalse(Lesson14.checkArray(arrayToCheck2));
    }

    @Test
    void checkArray_Failed() {
        int[] arrayToCheck = {1, 4, 1, 4};
        Assertions.assertFalse(Lesson14.checkArray(arrayToCheck));
    }
}