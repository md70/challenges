package arrays;

public class Dominator {
    public static void main(String[] args) {
        int[] arr = {3, 2, 2, 3};
        System.out.println(arr[dominatorOf(arr)]);
//        String s = "aaabccccccc";
//        int dominIndex = dominatorOf(s);
//        System.out.println(dominIndex != -1 ? s.charAt(dominIndex) : "Not Found");
    }

    private static int dominatorOf(String str) {
        int maxIndex = 0;
        int maxCount = 1;
        for (int i = 0, count = maxCount ; i < str.length() - 1 ; i++) {
            count = str.charAt(i) == str.charAt(i + 1) ? count + 1 : 1;
            if (maxCount < count) {
                maxCount = count;
                maxIndex = i;
            }
        }
        return maxCount > str.length() / 2 ? maxIndex : -1;
    }


    private static int dominatorOf(int[] a) {
        int maxIndex = 0;
        int maxCount = 1;
        for (int i = 0, count = maxCount ; i < a.length - 1 ; i++) {
            count = a[i] == a[i + 1] ? count+1 : 1;
            if (maxCount < count) {
                maxCount = count;
                maxIndex = i;
            }
        }
        return maxCount > a.length / 2 ? maxIndex : -1;
    }
    private static int dominator(int[] A) {
        if(A.length == 0) return -1;
        int count     = 0;
        int elem      = A[0];

        for(int i : A){
            if(i == elem){
                count++;
            } else {
                if(count == 0){
                    count++;
                    elem = i;
                }
                else count--;
            }
        }

        int ct = 0;
        int ind = -1;

        for(int i = 0; i < A.length; i++){
            if(A[i] == elem){
                ct++;
                ind = i;
            }

        }

        if(ct > A.length/2) return ind;
        else return -1;
    }


}
