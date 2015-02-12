package searchInsertPosition;

public class SearchInsertPosition {
    // Search Insert Position
    // Given a sorted array and a target value, return the index if the target
    // is found. If not, return the index where it would be if it were inserted
    // in order.
    //
    // You may assume no duplicates in the array.
    //
    // Here are few examples.
    // [1,3,5,6], 5 -> 2
    // [1,3,5,6], 2 -> 1
    // [1,3,5,6], 7 -> 4
    // [1,3,5,6], 0 -> 0
    public static int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = A.length;
        return search(A, target, 0, n - 1);
    }

    // Search a 2D Matrix
    // Write an efficient algorithm that searches for a value in an m x n
    // matrix. This matrix has the following properties:
    //
    // Integers in each row are sorted from left to right.
    // The first integer of each row is greater than the last integer of the
    // previous row.
    // For example,
    //
    // Consider the following matrix:
    //
    // [
    // [1, 3, 5, 7],
    // [10, 11, 16, 20],
    // [23, 30, 34, 50]
    // ]
    // Given target = 3, return true.
    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int[] search = new int[n];
        for (int i = 0; i < n; i++) {
            search[i] = matrix[i][0];
        }
        // for(int j=0;j<search.length;j++){
        // p(search[j]);
        // }
        int inserpos = searchInsert(search, target);
        // p(inserpos);
        if (inserpos != n) {
            if (matrix[inserpos][0] == target)
                return true;
        }
        if (inserpos == 0)
            return false;
        int[] s = matrix[inserpos - 1];
        int pos = searchInsert(s, target);
        if (pos == s.length)
            return false;
        return s[pos] == target;

    }

    // binary search. If found,return the index; otherwise, return the position
    // it should insert.
    public static int search(int[] A, int target, int begin, int end) {
        int n = end - begin + 1;
        int mid = begin + n / 2;// p(mid);
        if (A[mid] == target)
            return mid;
        else if (A[mid] < target) {
            if (mid + 1 >= end) {
                if (A[end] == target)
                    return end;
                return A[end] > target ? end : end + 1;
            } else {
                return search(A, target, mid + 1, end);
            }
        } else {
            if (begin >= mid - 1) {
                if (A[begin] == target)
                    return begin;
                return A[begin] > target ? begin : begin + 1;
            } else {
                return search(A, target, begin, mid - 1);
            }
        }
    }

    public static void p(Object o) {
        System.out.println(o);
    }

    public int searchInsert1(int[] A, int target) {
        int n = A.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        if (target < A[0]) {
            return 0;
        }

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                start = mid;
            } else if (A[mid] > target) {
                end = mid;
            }
        }

        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        } else if (A[end] < target) {
            return end + 1;
        } else {
            return start + 1;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] A = new int[][] {
                { -8, -6, -5, -4, -2, -1, -1, 0, 2, 4, 5, 7, 7, 7, 7, 9, 9, 9,
                        9, 11 },
                { 12, 14, 15, 16, 18, 20, 20, 20, 21, 21, 22, 23, 23, 25, 25,
                        25, 26, 27, 29, 30 },
                { 31, 31, 32, 32, 33, 35, 37, 39, 39, 39, 40, 41, 43, 44, 46,
                        48, 48, 48, 48, 50 },
                { 52, 54, 55, 57, 57, 58, 58, 60, 62, 64, 65, 65, 65, 67, 69,
                        71, 71, 73, 74, 74 },
                { 75, 76, 78, 78, 80, 82, 82, 82, 84, 85, 85, 87, 87, 89, 90,
                        90, 91, 93, 93, 94 },
                { 96, 98, 100, 102, 104, 105, 107, 109, 111, 113, 113, 115,
                        115, 117, 119, 119, 120, 122, 122, 124 },
                { 126, 127, 128, 130, 130, 130, 130, 132, 132, 133, 134, 136,
                        137, 138, 140, 141, 141, 143, 144, 146 },
                { 148, 150, 151, 152, 154, 156, 157, 158, 159, 161, 161, 162,
                        162, 164, 164, 165, 167, 168, 169, 169 },
                { 171, 173, 173, 175, 176, 178, 179, 181, 182, 183, 184, 184,
                        184, 185, 186, 186, 186, 186, 187, 189 },
                { 190, 192, 192, 193, 195, 196, 197, 197, 198, 198, 198, 198,
                        198, 199, 201, 203, 204, 206, 208, 208 },
                { 209, 210, 211, 212, 212, 212, 214, 214, 216, 217, 218, 218,
                        219, 221, 222, 224, 225, 227, 229, 229 },
                { 230, 230, 230, 231, 233, 233, 234, 235, 237, 237, 238, 238,
                        240, 240, 242, 242, 244, 246, 246, 247 },
                { 249, 251, 252, 252, 254, 254, 256, 256, 257, 258, 259, 260,
                        260, 261, 263, 265, 266, 267, 267, 269 },
                { 271, 273, 273, 274, 274, 274, 276, 276, 276, 278, 279, 280,
                        280, 280, 282, 284, 284, 286, 286, 287 },
                { 289, 290, 290, 291, 293, 293, 293, 293, 295, 296, 296, 297,
                        298, 299, 299, 301, 302, 304, 306, 308 },
                { 309, 310, 311, 311, 312, 312, 314, 315, 317, 319, 320, 322,
                        323, 324, 324, 324, 326, 328, 329, 331 },
                { 332, 334, 335, 337, 337, 339, 341, 343, 345, 347, 348, 348,
                        348, 348, 348, 350, 350, 350, 351, 352 },
                { 353, 355, 355, 356, 357, 358, 360, 361, 361, 361, 362, 364,
                        364, 364, 365, 366, 368, 370, 370, 372 },
                { 374, 376, 378, 380, 382, 382, 383, 384, 385, 385, 387, 388,
                        388, 390, 392, 394, 394, 396, 397, 399 },
                { 400, 402, 403, 403, 405, 405, 407, 409, 411, 411, 413, 414,
                        415, 417, 418, 419, 419, 419, 421, 422 } };
        // p(searchMatrix(A,271));
        int[] t = new int[] { 1, 3, 5, 7, 9 };
        p(searchInsert(t, 3));// should be 1
        p(searchInsert(t, 4));// should be 2
    }

}
