package plusOne;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int n = digits.length;
        int[] res = new int[n];
        int carry = 0;
        for (int i = n - 1; i >= 0; i--) {
            int val = digits[i];
            int sum = val + carry;
            if (i == n - 1) {
                sum++;
            }
            res[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry >= 1) {
            int[] result = new int[n + 1];
            result[0] = carry;
            System.arraycopy(res, 0, result, 1, n);
            return result;
        } else {
            return res;
        }
    }

}
