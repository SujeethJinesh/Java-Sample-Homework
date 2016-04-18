
public class Motorola1 {

    public static void main(String[] args) {
        String line = "1 1";
        String[] primeString = line.split(" ");
        int[] primes = new int[primeString.length];
        int counter = 0;
        for (String s : primeString) {
            primes[counter] = Integer.parseInt(String.valueOf(s));
            counter++;
        }
        int[] actualPrimes = getPrimes(primes[0], primes[1]);

        System.out.println(getNum(actualPrimes));
    }

    public static int[] getPrimes(int L, int R) {

        int[] primes = new int[R-L];
        int counter = 0;

        for (int i = L; i <= R; i++) {
            if (isPrime(i)) {
                primes[counter] = i;
                counter++;
            }
        }

        int[] temp = new int[counter];
        for (int i = 0; i < counter; i++) {
            temp[i] = primes[i];
        }
        primes = temp;
        return primes;
    }

    public static boolean isPrime(int i) {

        if (i < 2 || i%2 == 0)
            return false;
        if (i == 2)
            return true;
        for (int j = 3; j*j <= i; j += 2) {
            if (i%j == 0) {
                return false;
            }
        }

        return true;
    }

    public static int getNum(int[] arr) {

        int counter = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 2; j < arr.length; j++) {
                if (arr[i] + arr[i+1] + 1 == arr[j]) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
