class Solution1 {
  public int equi ( int[] A ) {
    long sum = 0;
    int i = 0;
    
    for (i = 0; i < A.length; i++) {
        sum += (long) A[i];
    }
    
    long sum_left = 0;
    for (i = 0; i < A.length; i++) {
        long sum_right = sum - sum_left - (long) A[i];
        
        if (sum_left == sum_right) {
            return i;
        }
        sum_left += (long) A[i];
    }
    return -1;// write your code here
  }
}