package GoldmanSachs.FindMissingAndRepeating;
// https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        int repeating=-1, missing=-1;
        int sum = n*(n+1)/2;
        int hash[] = new int[n+1];
        
        for(int i=0; i<n; i++) {
            hash[arr[i]]++; 
           
        }
        
        for(int i=1; i<=n; i++) {
            if(hash[i] == 2) repeating = i;
            
            if(hash[i] == 0) missing= i;
            
            if(repeating != -1 && missing != -1)
                break;
        }
        
        return new int[]{repeating, missing};
        
    }
}
