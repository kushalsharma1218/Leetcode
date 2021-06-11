class Solution {
    public int openLock(String[] d, String target) {
        Set<String> set = new HashSet<>();
        for(int i = 0;i<d.length;i++)
        {
            set.add(d[i]);
        }
        
        if(set.contains(target))return -1;
        if(set.contains("0000"))return -1;
        int steps = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0;i<size;i++){
                String curr = queue.poll();
              
                if(curr.equals(target))return steps;
              
                List<String> al = helper(curr);
                for(String it : al)
                {
                    if(set.contains(it))continue;
                    set.add(it);
                    queue.add(it);
                }
            }
            steps++;
        }
        return -1;
    }
    public List<String> helper(String s)
    {
        List<String> al = new ArrayList<>();
        for(int i = 0;i<4;i++)
        {
            int num = s.charAt(i) - '0';
            
            //decrease on from num
            int y = (num -1+10)%10;
            al.add(s.substring(0,i) + y + s.substring(i+1,4));
            
            
            //add one to num
            y = (num+1)%10;
            al.add(s.substring(0,i) + y + s.substring(i+1,4));
        }
        
        return al;
    }
}