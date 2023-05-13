package com.example.testing.service;

import com.example.testing.exception.InvalidNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    @InjectMocks
    private OperationService operationService;

    @Test
    void testAdditionForHappyPath() throws InvalidNumberException {
        int x = 0;
        int y = 0;
        int expectedResult = 0;
        int actualResult = operationService.addition(x, y);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testAdditionForHappyPathNew() throws InvalidNumberException {
        int x = 2;
        int y = 2;
        int expectedResult = 4;
        int actualResult = operationService.addition(x, y);

        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void testAdditionForNegativeX() {
        int x = -1;
        int y = 5;

        String expectedExceptionMessage = "x is negative value";
        InvalidNumberException actualException = Assertions.assertThrows(InvalidNumberException.class, () -> operationService.addition(x, y));

        String actualExceptionMessage = actualException.getMessage();

        Assertions.assertTrue(expectedExceptionMessage.contentEquals(actualExceptionMessage));
    }

    @Test
    void testAdditionForNegativeY() {
        int x = 1;
        int y = -5;

        String expectedExceptionMessage = "y is negative value";
        InvalidNumberException actualException = Assertions.assertThrows(InvalidNumberException.class, () -> operationService.addition(x, y));

        String actualExceptionMessage = actualException.getMessage();

        Assertions.assertTrue(expectedExceptionMessage.contentEquals(actualExceptionMessage));
    }
}
