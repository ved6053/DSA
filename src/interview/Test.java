package interview;

public class Test {
	
	public static void main(String args[]) {
		
				String a="987";
				String b="167";

				int n1= a.length();

				int n2= b.length();

				int n= Math.min(n1, n2);
				int c=0;

				String str="";
				for(int i=1; i<=n;i++)
				{
					int d1= a.charAt(n1-i)-'0';
					int d2= b.charAt(n2-i)-'0';
					
					int d=(d1+d2+c)%10;
					str=d+str;
					c=(d1+d2+c)/10;

				}
				
				if(n1>n2){
				  for(int i=n2;i>=0;i++){
					  int d1= a.charAt(n1-i)-'0';
					  int d=(d1+c)%10;
					  str=d+str;
					  c=(d1+c)/10;
				  }
				}
				if(n2>n1){
				 for(int i=n1;i>=0;i++){
				  int d1= a.charAt(n2-i)-'0';
				  	int d=(d1+c)%10;
					str=d+str;
					c=(d1+c)/10;
				  }
				}
				
				if(c!=0)
					str=c+str;

			System.out.println(str);
	}

}
