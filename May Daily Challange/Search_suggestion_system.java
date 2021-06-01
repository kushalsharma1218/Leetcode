class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> ans = new ArrayList<>();
        int start = 0;
        int bsStart = 0;
        int n = products.length;
        String prefix = "";
        for(char c: searchWord.toCharArray())
        {
            prefix += c;
            
            
            // binary serach on the product list 
            start = lower_binary(products, prefix, bsStart);
            ArrayList<String> al = new ArrayList<>();
            for(int i = start;i<Math.min(n, start + 3);i++)
            {
                //check
                if(products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix)) break;
                
                al.add(products[i]);
            }
            ans.add(al);
            
            
            bsStart = Math.abs(start);
        }
        return ans;
        
    }
    public int lower_binary(String pro[], String prefix, int start)
    {
        int l = start;
        int r = pro.length;
        
        while(l < r)
        {
            int m = (l+r)/2;
            // compare
            if(pro[m].compareTo(prefix) >= 0)
            {
                r = m;
            }
            else l = m+1;
        }
        
        return l;
    }
}