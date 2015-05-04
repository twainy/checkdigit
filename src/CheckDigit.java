import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 123456789012345
 * Created by takeshi-wakasugi on 2015/03/24.
 */
public class CheckDigit {
    public static void main(String args[] ) throws Exception {
        /*
        System.out.println(getDoubleSumEvenDigit(1234567890L)); // 0 8(1+6) 6(1+2) 4(8) + 2(4) = 22
        System.out.println(getSumOddDigitWithoutOne(1234567890L)); // X 9 7 5 3 1 = 25
        return;
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String readLine = br.readLine();
            readLine = readLine.trim();
            String[] readLineArray = readLine.split(",");
            long num = getCheckDigit(Long.parseLong(readLineArray[0].substring(0, readLineArray[0].length()-1)));
            System.out.println(num);
        }
    }
    
    public static int getCheckDigit(long num) {
        return (10 - ((getDoubleSumEvenDigit(num) + getSumOddDigitWithoutOne(num)) % 10))%10;
    }

    /**
     * 偶数桁の2倍したものの総和
     * @return int
     */
    public static int getDoubleSumEvenDigit (long num) {
        int sum = 0, tmpnum;
        for (int i = 0; i < 8; i++) {
            // get first digit
            tmpnum = (int)(num % 10) * 2;
            if (tmpnum >= 10) {
                sum += (tmpnum / 10) + (tmpnum % 10);
            } else {
                sum += tmpnum;
            }
            num = num / 100;
        }
        return sum;
    }
    /**
     * 奇数桁の総和(ただし1桁目は除く)
     * @return int
     */
    public static int getSumOddDigitWithoutOne (long num) {
        int sum = 0, tmpnum;
        num = num / 10;
        for (int i = 0; i < 8; i++) {
            // get first digit
            sum += (int)(num % 10);
            num = num / 100;
        }
        return sum;
    }
    
}
