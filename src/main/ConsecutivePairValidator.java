/**
 * Class for the consecutive pair validator.
 */
public class ConsecutivePairValidator
{
    /**
     * Testing if the number is a prime number.
     * @param N A Number.
     * @return Boolean indicating if the number is a prime number.
     */
    public static boolean isPrime(long N)
    {
        for (int i = 2; i <= Math.sqrt(N); i++)
            if (N % i == 0)
               return false;
        return true;
    }

    /**
     * Searching for the consecutive pairs in a given range, example: from 1000 to 2000.
     * @param from The starting value of the range.
     * @param end The ending value of the range.
     */
    public static void testInRange(long from, long end) {
        for(long i = from; i < end; i++) {
            if(isPrime(i) || isPrime(i+1)) {
                continue;
            }
            if(testForNaturalLogarithm(i, i+1)) {
                System.out.println(i + " & " + (i + 1));
                System.out.println(biggestPrimeFactor(i) + " < " + Math.log(i) + " & " + biggestPrimeFactor(i + 1) + " < " + Math.log(i + 1));
            }
        }
    }

    /**
     * Testing if the natural logarithm of the two consecutive numbers are bigger than their biggest prime factor.
     * @param firstConsecutiveNumber The first consecutive number.
     * @param secondConsecutiveNumber The seconds consecutive number.
     * @return Boolean indicating if the natural logarithm of the two consecutive numbers are bigger than their biggest prime factor.
     */
    private static boolean testForNaturalLogarithm(long firstConsecutiveNumber, long secondConsecutiveNumber) {
        return biggestPrimeFactor(firstConsecutiveNumber) < Math.log(firstConsecutiveNumber) && biggestPrimeFactor(secondConsecutiveNumber) < Math.log(secondConsecutiveNumber);
    }

    /**
     * Finds the biggest prime factor of a number.
     * @param n The number.
     * @return The biggest prime factor.
     */
    private static long biggestPrimeFactor(long n) {
        long result = n;
        for (long i = 2; (i*i)<= n; i++) {
            while (n % i == 0) {
                result = i;
                n = n / i;
            }
        }
        if(n > 1)
            return n;
        return result;

    }
}