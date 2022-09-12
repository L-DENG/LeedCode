
/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 *
 */

public class code_4_MedianOfTwoSortedArrays {

    public static  double findMedianSortedArrays(int[] nums1, int[] nums2) {


        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1==0){
            return (len2%2) == 0 ? (double) (nums2[len2/2-1]+nums2[len2/2])/2 :nums2[len2/2];
        }

        if(len2==0){
            return (len1%2) == 0 ? (double) (nums1[len1/2-1]+nums2[len1/2])/2 :nums1[len1/2];
        }


        int totalNum = len1+len2;
        int median = (totalNum >> 1)+1;
        int n = 1;
        int first = 0;
        int second = 0;

        int a =0;
        int b =0;

        if(totalNum%2!=0){
            while(n <= median ){

                if (first==len1){

                    return nums2[second+median-n];
                }else if(second==len2){
                    return nums1[first+median-n];
                }else{
                    if(nums1[first]>=nums2[second]){
                        if(n==median){
                            return Math.min(nums1[first],nums2[second]);
                        }
                        n++;
                        second++;
                    }else {
                        if(n==median){
                            return Math.min(nums1[first],nums2[second]);
                        }
                        n++;
                        first++;
                    }
                }


            }
        }else{
            while(n <= median ){


                if (first==len1){

                    return (double) (median-n) ==0 ? (double)(nums1[len1-1]+nums2[second+median-n])/2 : (double)(nums2[second+median-n-1]+nums2[second+median-n])/2;
                }else if(second==len2){
                    return (double) (median-n) ==0 ? (double)(nums2[len2-1]+nums1[first+median-n])/2 : (double)(nums1[first+median-n-1]+nums1[first+median-n])/2;
                }else{
                    if(n==median){
                        a = Math.min(nums1[first],nums2[second]);
                    }
                    if(n == (median - 1)){
                        b = Math.min(nums1[first],nums2[second]);
                    }
                    n++;
                    if(nums1[first]>=nums2[second]){
                        second++;
                    }else {
                        first++;
                    }
                }

            }
            return (double)(a+b)/2;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {1};
        double a = findMedianSortedArrays(nums1, nums2);

        System.out.println(a);

    }
}
