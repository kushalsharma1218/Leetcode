/*
Goal is to find median
Most basic approach

 - create an arr of size m + n, and copy all elements from both array then sort and return median
 - We can also perform merge operation as both arrays are sorted
 - So wee need median right, for median we have element in left are all small and in right are all greater, so if we try to maintain two sets of small element and larger elements and just perform bs.

TC: O(logn) for median 
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // we need to perform BS on both array,
        // define ranges? -> 
        // we need four elements - l1, r1, l2, r2
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        
        if(n1 > n2)return findMedianSortedArrays(nums2, nums1);
        
        int s = 0;
        int e = n1;
        
        while(s <= e){
            int mid1 = (s+e)/2;
            int mid2 = (n1+n2+1)/2 - mid1;
            
            int l1 = (mid1 == 0)? Integer.MIN_VALUE : nums1[mid1-1];
            int l2 = (mid2 == 0)? Integer.MIN_VALUE : nums2[mid2-1];
            
            int r1 = (mid1 == n1)? Integer.MAX_VALUE : nums1[mid1];
            int r2 = (mid2 == n2)? Integer.MAX_VALUE : nums2[mid2];
            
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2) % 2 != 0)
                {
                    return (double)Math.max(l1, l2);
                }
                else return (double)(Math.max(l1, l2) + Math.min( r1 , r2))/2;
            }
            else if(l1 > r2){
                e = mid1-1;
            }
            else s = mid1+1;   
        }
        
        return 0.0;
        
        
    }

}