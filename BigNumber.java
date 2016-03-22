import java.util.Scanner;

public class BigNumber {
	public static void main(String[] atgs){		
		BigInt BI=new BigInt();
				
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
	    String int1 = input.next();
	    System.out.print("Enter second integer: ");
	    String int2 = input.next();
	    
	    BI.add(int1, int2);
		
	}

}

class BigInt{
	
	
	int add(String a, String b){
		int num1[];
		int num2[];
		int ret[];
		int maxlen, len1, len2;
		
		len1=a.length();
		len2=b.length();
		maxlen=len1;
		if(maxlen<len2)
			maxlen=len2;						
		
		num1=new int[maxlen];
		num2=new int[maxlen];				
		ret=new int[maxlen+1];
			
		int i;
		for(i=0;i<=maxlen-1;i++){
			if(len1-i>0)				
				num1[maxlen-1-i]=Integer.valueOf(a.substring(len1-i-1, len1-i));
			else
				num1[maxlen-1-i]=0;	
		}
		
		for(i=0;i<=maxlen-1;i++){
			if(len2-i>0)				
				num2[maxlen-1-i]=Integer.valueOf(b.substring(len2-i-1, len2-i));
			else
				num2[maxlen-1-i]=0;	
		}
		
		int j, sum;
		sum=0;
		for(j=maxlen-1;j>=0;j--){
			sum=num1[j]+num2[j]+sum/10;
			ret[j+1]=sum%10;						
		}
		ret[0]=sum/10;
				
		
		for(i=0;i<=maxlen;i++){
			if((ret[0]!=0) || i>0){
				System.out.printf("%d", ret[i]);
			}			
			
		}
		
		
		return 0;
	}
	
	int sub(String a, String b){
		
		return 0;
	}
	
	int multi(String a, String b){
		
		return 0;
	}

	int div(String a, String b){
		
		return 0;
	}

	


}


