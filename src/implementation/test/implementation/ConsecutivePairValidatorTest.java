package implementation.test.implementation;

import implementation.ConsecutivePairValidator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ConsecutivePairValidatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    /**
     * Used for methods which use the console.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Used for methods which use the console.
     */
    @After
    public void restoreStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void ConsecutivePairValidator_isPrime() {
        Assert.assertTrue("Should be Prime", ConsecutivePairValidator.isPrime(328513));
        Assert.assertTrue("Should be Prime", ConsecutivePairValidator.isPrime(5));
        Assert.assertTrue("Should be Prime", ConsecutivePairValidator.isPrime(5749));
        Assert.assertTrue("Should be Prime", ConsecutivePairValidator.isPrime(6599));
        Assert.assertTrue("Should be Prime", ConsecutivePairValidator.isPrime(50333));

        Assert.assertFalse("Should not be Prime", ConsecutivePairValidator.isPrime(45786));
        Assert.assertFalse("Should not be Prime", ConsecutivePairValidator.isPrime(25032));
        Assert.assertFalse("Should not be Prime", ConsecutivePairValidator.isPrime(12031));
        Assert.assertFalse("Should not be Prime", ConsecutivePairValidator.isPrime(12));
        Assert.assertFalse("Should not be Prime", ConsecutivePairValidator.isPrime(12393));
    }

    @Test
    public void ConsecutivePairValidator_testInRange() {
        final long startOfRange = 1000;
        final long endOfRange = 3000;

        ConsecutivePairValidator.testInRange(startOfRange, endOfRange);

        Assert.assertEquals("Should output the results to the console", "2400 & 2401", outContent.toString().trim());
    }

    @Test
    public void ConsecutivePairValidator_biggestPrimeFactor() {
        final long firstNumber = 25698751364526L;

        final long biggestPrimeFactorOfFirstNumber = ConsecutivePairValidator.biggestPrimeFactor(firstNumber);

        Assert.assertEquals("Should be the same", 328513, biggestPrimeFactorOfFirstNumber);
    }

    @Test
    public void ConsecutivePairValidator_testForNaturalLogarithm() {
        long firstNumber = 2400L;
        long secondNumber = firstNumber + 1;

        boolean testForConsecutiveNumberPrimeFactorsAndNaturalLogarithm = ConsecutivePairValidator.testForNaturalLogarithm(firstNumber, secondNumber);

        Assert.assertTrue("Should be true", testForConsecutiveNumberPrimeFactorsAndNaturalLogarithm);

        firstNumber = 4501;
        secondNumber = firstNumber + 1;

        testForConsecutiveNumberPrimeFactorsAndNaturalLogarithm = ConsecutivePairValidator.testForNaturalLogarithm(firstNumber, secondNumber);

        Assert.assertFalse("Should be true", testForConsecutiveNumberPrimeFactorsAndNaturalLogarithm);

        firstNumber = 2501;
        secondNumber = firstNumber + 1;

        testForConsecutiveNumberPrimeFactorsAndNaturalLogarithm = ConsecutivePairValidator.testForNaturalLogarithm(firstNumber, secondNumber);

        Assert.assertFalse("Should be false", testForConsecutiveNumberPrimeFactorsAndNaturalLogarithm);
    }
}
