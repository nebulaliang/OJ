package nextPermutation;

public class NextPermutation {

  //IDEA: 
    //1. From right to left, find the first which smaller than its right; suppose the index is begin
    //2. From right to left, find the first one which bigger than num[begin], suppose the index is end
    //3. Swap num[begin] and num[end]
    //4. Reverse from begin+1 to end
    //Special case: If not find begin, reverse the total array
    public  void nextPermutation(int[] num) {
        int len = num.length;
        if (len == 1)
            return;
        int pre = num[len - 1];
        int replace_begin = -1;
        int replace_end = -1;
        for (int i = len - 2; i >= 0; i--) {
            int cur_num = num[i];
            if(cur_num <  pre){
                replace_begin = i;
                break;
            }
            pre = cur_num;
        }
        if(replace_begin == -1){
            reverse(num, 0, len - 1);
        }
        else{
            //find the first larger than num[replace_begin]
            for(int i = len - 1; i > replace_begin; i--){
                if(num[i] > num[replace_begin]){
                    replace_end = i;
                    break;
                }
            }
            swap(num,replace_begin, replace_end);
            replace_begin++;
            reverse(num, replace_begin, len - 1);
        }
    }
    private  void swap(int[] num, int a, int b){
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
    private  void reverse(int[] num, int begin, int end){
        while(begin < end){
            int temp = num[begin];
            num[begin] = num[end];
            num[end] = temp;
            begin++;
            end--;
        }
    }

}
