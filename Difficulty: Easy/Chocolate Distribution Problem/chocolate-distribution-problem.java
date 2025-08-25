// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        
        Collections.sort(arr);
        
        int res = Integer.MAX_VALUE;
        int i=0;
        
        if(m == arr.size())
        {
            return (arr.get(m-1)-arr.get(i));
        }
        
        while(i < arr.size() && arr.size() > ((i+m)-1))
        {
            int x = arr.get(i);
            
            int y = arr.get((i + m)-1);
            
            res = Math.min((y-x) , res);
            
            i++;
        }
        return res;
        
        
    }
}