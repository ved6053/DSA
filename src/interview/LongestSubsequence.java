package interview;

import java.util.Arrays;

public class LongestSubsequence {
/*	Given a string you need to print longest possible substring that has exactly M unique characters. If there are more than one substring of longest possible length, then print any one of them.
	Examples: 

	"aabbcc", k = 1
	Max substring can be any one from {"aa" , "bb" , "cc"}.

	"aabbcc", k = 2
	Max substring can be any one from {"aabb" , "bbcc"}.

	"aabbcc", k = 3
	There are substrings with exactly 3 unique characters
	{"aabbcc" , "abbcc" , "aabbc" , "abbc" }
	Max is "aabbcc" with length 6.

	"aaabbb", k = 3
	There are only two unique characters, thus show error message. 
	
	Solution:
	Method 1 (Brute Force) 
If the length of string is n, then there can be n*(n+1)/2 possible substrings. A simple way is to generate all the substring and check each one whether it has exactly k unique characters or not. If we apply this brute force, it would take O(n2) to generate all substrings and O(n) to do a check on each one. Thus overall it would go O(n3).
We can further improve this solution by creating a hash table and while generating the substrings, check the number of unique characters using that hash table. Thus it would improve up to O(n2).
Method 2 (Linear Time) 
The problem can be solved in O(n). Idea is to maintain a window and add elements to the window till it contains less or equal k, update our result if required while doing so. If unique elements exceeds than required in window, start removing the elements from left side. 
Below are the implementations of above. The implementations assume that the input string alphabet contains only 26 characters (from �a� to �z�). The code can be easily extended to 256 characters. 
	*/
	 final static int MAX_CHARS = 26; 
	 
	   // This function calculates number 
	   // of unique characters 
	   // using a associative array 
	   // count[]. Returns true if 
	   // no. of characters are less 
	   // than required else returns 
	   // false. 
	    static boolean isValid(int count[], 
	                                   int k) 
	    { 
	        int val = 0; 
	        for (int i = 0; i < MAX_CHARS; i++) 
	        { 
	            if (count[i] > 0) 
	            { 
	                val++; 
	            } 
	        } 
	 
	        // Return true if k is greater
	        // than or equal to val 
	        return (k >= val); 
	    } 
	 
	    // Finds the maximum substring 
	    // with exactly k unique chars 
	    static void kUniques(String s, int k) 
	    { 
	        int u = 0; 
	        int n = s.length(); 
	 
	        // Associative array to store 
	        // the count of characters 
	        int count[] = new int[MAX_CHARS]; 
	        Arrays.fill(count, 0); 
	        // Traverse the string, Fills 
	        // the associative array 
	        // count[] and count number 
	        // of unique characters 
	        for (int i = 0; i < n; i++) 
	        { 
	            if (count[s.charAt(i) - 'a'] == 0) 
	            { 
	                u++; 
	            } 
	            count[s.charAt(i) - 'a']++; 
	        } 
	 
	        // If there are not enough 
	        // unique characters, show 
	        // an error message. 
	        if (u < k) { 
	            System.out.print("Not enough unique characters"); 
	            return; 
	        } 
	 
	        // Otherwise take a window with
	        // first element in it. 
	        // start and end variables. 
	        int curr_start = 0, curr_end = 0; 
	 
	        // Also initialize values for
	        // result longest window 
	        int max_window_size = 1;
	        int max_window_start = 0; 
	 
	        // Initialize associative 
	        // array count[] with zero 
	        Arrays.fill(count, 0); 
	         
	        // put the first character 
	        count[s.charAt(0) - 'a']++; 
	 
	        // Start from the second character and add 
	        // characters in window according to above 
	        // explanation 
	        for (int i = 1; i < n; i++) { 
	            // Add the character 's[i]' 
	            // to current window 
	            count[s.charAt(i) - 'a']++; 
	            curr_end++; 
	 
	            // If there are more than k 
	            // unique characters in 
	            // current window, remove from left side 
	            while (!isValid(count, k)) { 
	                count[s.charAt(curr_start) - 'a']--; 
	                curr_start++; 
	            } 
	 
	            // Update the max window size if required 
	            if (curr_end - curr_start + 1 > max_window_size) 
	            { 
	                max_window_size = curr_end - curr_start + 1; 
	                max_window_start = curr_start; 
	            } 
	        } 
	 
	        System.out.println("Max sustring is : "
	                + s.substring(max_window_start, 
	                    max_window_start + max_window_size) 
	                + " with length " + max_window_size); 
	    } 
	 
	    // Driver Code 
	    static public void main(String[] args) { 
	        String s = "aabacbebebe"; 
	        int k = 3; 
	        kUniques(s, k); 
	    } 
}
