import java.util.Hashtable;

public class DarkChocolate {
	
	private static int numStudents = 3;
	private static int boxes [] = {2, 7, 6, 1, 4, 5};
	
	public static void hashExample() {
		Hashtable table = new Hashtable();
		
		//Still not working
		int[] sum = new int [boxes.length];
		sum[0] = boxes[0];
			for(int i = 1; i < boxes.length; i ++) {
				sum[i] = sum [i -1] + boxes[i];
			
			}
		
		for (int j = 0; j < sum.length; j++)
			System.out.println(sum[j]);
		
	}
	
	/*public static void main (String args[]) {
		//findSums();
		 { 
		        int [] a = {2, 7, 6, 1, 4, 5}; 
		        System.out.println("Maximum contiguous sum is " + 
		                                       maxSubArraySum(a)); 
		        
		        maxSubArraySum(a, a.length);
		    } 
	}*/
	
	 // Prints sums of all 
    // subsets of arr[l..r]
    static void subsetSums(int []arr, int l,
                            int r, int sum )
    {
         
        // Print current subset
        if (l > r)
        {
            System.out.print(sum + " ");
            return;
        }
     
        // Subset including arr[l]
        subsetSums(arr, l + 1, r, 
                   sum + arr[l]);
     
        // Subset excluding arr[l]
        subsetSums(arr, l + 1, r, sum);
    }
     
    // Driver code
    public static void main (String[] args)
    {
    	hashExample();
      //  int []arr = {2, 7, 6, 1, 4, 5};
        //int n = arr.length;
     
    //    subsetSums(arr, 0, n - 1, 0);
    }
		    static int maxSubArraySum(int a[]) 
		    { 
		    	int major = 0;
		        int size = a.length; 
		        int max_so_far = 0, max_ending_here = 0; 
		        System.out.println(max_so_far);
		        for (int i = 0; i < size; i++) 
		        { 
		            max_ending_here = max_ending_here + a[i]; 
		            if (max_ending_here % numStudents == 0) {
		                max_so_far = max_ending_here; 
		                if(max_so_far < major) {
		                	major = max_so_far;
		                }
		            }
		        } 
		        return major; 
		    } 
		    static void maxSubArraySum(int a[], int size) 
		    { 
		        int max_so_far = Integer.MIN_VALUE, 
		        max_ending_here = 0,start = 0, major = 0,
		        end = 0, s = 0; 
		  
		        for (int i = 0; i < size; i++)  
		        { 
		            max_ending_here += a[i]; 
		  
		            if (max_ending_here % numStudents == 0)  
		            { 
		                max_so_far = max_ending_here; 
		                start = s; 
		                end = i; 
		                major = max_ending_here;
		                //max_ending_here = 0;
		            } 
		  
		            if (major > max_so_far)  
		            { 
		               // max_ending_here = 0; 
		            	max_so_far = major;
		                s = i + 1; 
		            } 
		        } 
		        System.out.println("Maximum contiguous sum is " 
		                           + max_so_far); 
		        System.out.println("Starting index " + start); 
		        System.out.println("Ending index " + end); 
		    } 
	
	
	public static void findSums() {
		
		/*int[] sum = new int [boxes.length];
		sum[0] = boxes[0];
		//for(int i = 0; i < sum.length; i++)
		//	sum[i] = 0;
		
		//for(int i = 0; i < boxes.length; i ++) {
			for(int j = 1; j < boxes.length; j++) {
				sum[j] = sum[j -1] + boxes[j];
				System.out.println(sum[j]);
			}
		}*/
	
		
	//}
	
		//One array for all sums
		int[] sums = new int [21];
		
		for(int i = 0; i < sums.length; i++) {
			for(int j = 0; j < boxes.length; j++) {
				if(j == 0) {
					sums[i] = boxes[j];
				}
				else {
					sums[i] = 1;
				}
			}
		}
		
	}
	
}
		
		

