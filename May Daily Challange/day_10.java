class Solution {
    public int countPrimes(int n) {
        if(n == 0 || n==1 )return 0;
        int primes[] = new int[n];
        for(int i = 2;i<n;i++)
        {
            primes[i] = 1;
        }
        // O (n)
        for(int i = 2;i*i<n;i++)
        {
            if(primes[i] == 1){
                for(int j = i*i;j<n;j=j+i)
                {  
                    primes[j] = 0;
                }
            }
        }
        
        // O(logn * )
        for(int i= 1;i<n;i++)
        {
            primes[i] += primes[i-1];
        }
        //o(n)
        return primes[n-1];
    }
}