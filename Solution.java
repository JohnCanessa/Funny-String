import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;


public class Solution {

	// Complete the funnyString function below.
    static String funnyString(String s) {

    	// **** r holds the reverse of s ****
    	String r = new StringBuilder(s).reverse().toString();
    	
    	// **** build associated arrays with byte values ****
    	byte[] sba = s.getBytes();
    	byte[] rba = r.getBytes();
    	
    	// **** compare the values of the adjacent bytes ****
    	for (int i = 0; i < (sba.length - 1); i++) {
    		
    		// **** difference in sba ****
    		int sbaDiff;
    		if (sba[i] > sba[i + 1]) {
    			sbaDiff = sba[i] - sba[i + 1];
    		} else {
    			sbaDiff = sba[i + 1] - sba[i];
    		}
    		
     		// **** difference in rba ****
    		int rbaDiff;
    		if (rba[i] > rba[i + 1]) {
    			rbaDiff = rba[i] - rba[i + 1];
    		} else {
    			rbaDiff = rba[i + 1] - rba[i];
    		}
    		
    		// **** check if they do NOT match ****
    		if (sbaDiff != rbaDiff)
    			return "Not Funny";
    	}
 
    	// **** differences match ****
    	return "Funny";
    }

    
    private static final Scanner scanner = new Scanner(System.in);

    
    public static void main(String[] args) throws IOException {
    	
    	 BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            String result = funnyString(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
