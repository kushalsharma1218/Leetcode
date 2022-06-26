class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer num1 = null;
        Integer num2 = null;
        
        
        int c1 = 0;
        int c2= 0;
        
        for(int i = 0;i<nums.length;i++)
        {
            if(num1 != null && nums[i] == num1)c1++;
            else if(num2 != null && nums[i] == num2)c2++;
            else if(c1 == 0)
            {
                num1 = nums[i];
                c1 =1;
            }
            else if(c2 ==0)
            {
                num2 = nums[i];
                c2 =1;
            }
            else
            {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        
        for(int num : nums)
        {
            if(num1 != null && num == num1)c1++;
            if(num2 != null && num == num2)c2++;
        }
        
        List<Integer> al = new ArrayList<>();
        if(c1> nums.length/3)
        {
            al.add(num1);
        }
        if(c2 > nums.length/3)
        {
            al.add(num2);
        }
        
        return al;
    }
}