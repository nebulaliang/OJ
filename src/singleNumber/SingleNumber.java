package singleNumber;

public class SingleNumber {

    public int singleNumber(int[] A) {
        int res = 0;
        for (int i : A) {
            res ^= i;
        }

        return res;
    }

    public int singleNumber2(int[] A) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 0;
            for (int a : A) {
                int temp = a >> i;
                bit += temp & 1;
            }
            bit = bit % 3;
            result |= bit << i;
        }

        return result;
    }
}
