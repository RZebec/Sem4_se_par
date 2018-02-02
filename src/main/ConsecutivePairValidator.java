import java.util.stream.LongStream;

public class ConsecutivePairValidator
{
    /** Check if num is prime **/
    public static boolean isPrime(long N)
    {
        /**
        for (int i = 2; i <= Math.sqrt(N); i++)
            if (N % i == 0)
                return false;
        return true;
         */
        return N > 1 && LongStream.range(2,(int)Math.sqrt(N)).noneMatch(index -> N % index == 0);
    }

    public static void testInRange(long from, long end) {
        for(long i = from; i < end; i++) {
            //System.out.println("Testing Numbers: " + i + " & " + (i + 1));
            if(isPrime(i) || isPrime(i+1)) {
                continue;
            }
            if(testForNaturalLogarithm(i, i+1)) {
                System.out.println(i + " & " + (i + 1));
                System.out.println(biggestPrimeFactor(i) + " < " + Math.log(i) + " & " + biggestPrimeFactor(i + 1) + " < " + Math.log(i + 1));
            }
        }
    }

    private static boolean testForNaturalLogarithm(long firstConsecutiveNumber, long secondConsecutiveNumber) {
        return biggestPrimeFactor(firstConsecutiveNumber) < Math.log(firstConsecutiveNumber) && biggestPrimeFactor(secondConsecutiveNumber) < Math.log(secondConsecutiveNumber);
    }

    private static long biggestPrimeFactor(long N) {
        long biggestDivisor;
        for (biggestDivisor = 2; biggestDivisor <= N; biggestDivisor++) {
            if (N % biggestDivisor == 0) {
                N /= biggestDivisor;
                biggestDivisor--;
            }
        }
        return biggestDivisor;
    }
}