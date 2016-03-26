import java.util.Scanner;

public class BigNumber {
	public static void main(String[] atgs){		
		BigInt BI=new BigInt();
				
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter first integer: ");
	    String int1 = input.next();
	    System.out.print("Enter second integer: ");
	    String int2 = input.next();
	    
	    String test5=new String();
	    //BI.sub(int1, int2);
	    //test5=BI.unsign_sub(int1, int2);
	    //test5=BI.add(int1, int2);
	    //test5=BI.sub(int1, int2);
	    test5=BI.multi(int1, int2);
	    System.out.printf("%s", test5);
		
	}

}

class BigInt{
	
	
	String unsign_add(String a, String b){
		int num1[];
		int num2[];
		int ret[];
		String result=new String();
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
				
		result="";
		for(i=0;i<=maxlen;i++){
			if((ret[0]!=0) || i>0){
				//System.out.printf("%d", ret[i]);//for debug
				result=result + Integer.toString(ret[i]);
			}			
			
		}
		
		
		return result;
	}
	
	String add(String a, String b){
		int comp;
		int a_sign=0, b_sign=0;
		String a_prx, b_prx;
		String retstr;
		
		a_prx=new String();
		b_prx=new String();
		retstr=new String();
			
		a_prx=a.substring(0, 1);
		b_prx=b.substring(0, 1);			
		
		if(a_prx.compareTo("-")==0)
			a_sign=1;//negative		
		if(b_prx.compareTo("-")==0)
			b_sign=1;//negative				
		
		if((a_sign==0 && b_sign==1)){
			b=b.substring(1, b.length());
			retstr=unsign_sub(a,b);
		}
		else if((a_sign==1 && b_sign==0)){
			a=a.substring(1, a.length());
			retstr=unsign_sub(b,a);
		}
		else if(a_sign==0 && b_sign==0){			
			retstr=unsign_add(a,b);
		}
		else if(a_sign==1 && b_sign==1){			
			a=a.substring(1, a.length());
			b=b.substring(1, b.length());
			retstr="-" + unsign_add(a,b);
		}
		
		return retstr;
	}
	
	String unsign_sub(String a, String b){
		int num1[], num2[], tmpnum[];
		int ret[];
		String result=new String();
		int maxlen, len1, len2;
		
		len1=a.length();
		len2=b.length();
		maxlen=len1;
		if(maxlen<len2)
			maxlen=len2;						
		
		num1=new int[maxlen];
		num2=new int[maxlen];				
		ret=new int[maxlen];
			
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
		
		int negflag, comp;
		negflag=0;
		comp=comparestr(a, b);
		//System.out.printf("comp=%d\n", comp);//for debug
		if(comp<0){
			tmpnum=num1;
			num1=num2;
			num2=tmpnum;			
			negflag=1;
		}		
		
		
		int j, reg, bor;		
		bor=0;
		for(j=maxlen-1;j>=0;j--){
			reg=num1[j]-bor-num2[j];
			if(reg>=0){
				bor=0;
			}
			else{
				bor=1;
				reg=reg+10;
			}
			ret[j]=reg;									
		}		
		
		
		//print Ans
		if(negflag==1){
			System.out.printf("-");
		}
		int zeroflg;
		zeroflg=1;
		for(i=0;i<maxlen;i++){			
			if(ret[i]!=0){
				zeroflg=0;
			}
			
			if(zeroflg==0 || i==maxlen-1){
				result=result + Integer.toString(ret[i]);
				//System.out.printf("%d", ret[i]);//for debug
			}			 			
		}
						
		return result;
	}
	
	String sub(String a, String b){
		int comp;
		int a_sign=0, b_sign=0;
		String a_prx, b_prx;
		String retstr;
		
		a_prx=new String();
		b_prx=new String();
		retstr=new String();
			
		a_prx=a.substring(0, 1);
		b_prx=b.substring(0, 1);			
		
		if(a_prx.compareTo("-")==0)
			a_sign=1;//negative		
		if(b_prx.compareTo("-")==0)
			b_sign=1;//negative				
		
		if((a_sign==0 && b_sign==1)){
			b=b.substring(1, b.length());
			retstr=unsign_add(a,b);
		}
		else if((a_sign==1 && b_sign==0)){
			a=a.substring(1, a.length());
			retstr="-" + unsign_add(b,a);
		}
		else if(a_sign==0 && b_sign==0){			
			retstr=unsign_sub(a,b);
		}
		else if(a_sign==1 && b_sign==1){						
			b=b.substring(1, b.length());
			retstr=add(a,b);
		}
		
		return retstr;
	}
		
	
	String unsign_multi(String a, String b){
		int i,len1,len2,minlen;
		String result,Lstr,Sstr,tmp;
		
		result=new String();
		Lstr=new String();
		Sstr=new String();
		tmp=new String();
		
		int comp;		
		comp=comparestr(a, b);
		//System.out.printf("comp=%d\n", comp);//for debug
		if(comp<0){
			tmp=a;
			a=b;
			b=tmp;						
		}
			
		Lstr=a;
		Sstr=b;
		result="0";
		while(Sstr.compareTo("0")!=0){
			result=unsign_add(result, Lstr);
			//System.out.println(result);//for debug
			Sstr=unsign_sub(Sstr, "1");
		}
		return result;
	}	
	
	String multi(String a, String b){
		int comp;
		int a_sign=0, b_sign=0;
		String a_prx, b_prx;
		String retstr;
		
		a_prx=new String();
		b_prx=new String();
		retstr=new String();
			
		a_prx=a.substring(0, 1);
		b_prx=b.substring(0, 1);			
		
		if(a_prx.compareTo("-")==0)
			a_sign=1;//negative		
		if(b_prx.compareTo("-")==0)
			b_sign=1;//negative				
		
		if((a_sign==0 && b_sign==1)){
			b=b.substring(1, b.length());
			retstr="-" + unsign_multi(a,b);
		}
		else if((a_sign==1 && b_sign==0)){
			a=a.substring(1, a.length());
			retstr="-" + unsign_multi(b,a);
		}
		else if(a_sign==0 && b_sign==0){			
			retstr=unsign_multi(a,b);
		}
		else if(a_sign==1 && b_sign==1){
			a=a.substring(1, a.length());
			b=b.substring(1, b.length());
			retstr=multi(a,b);
		}
		
		return retstr;
	}

	
	int comparestr(String a, String b){
		String str1, str2;
		int len1,len2;
		int ret;
		ret=0;
		int i;
		int comp;
		
		len1=a.length();
		len2=b.length();			
		
		if(len1>len2){
			ret=1;
		}
		
		else if(len1==len2){
			for(i=0;i<len1;i++){
				str1=a.substring(i);
				str2=b.substring(i);
				comp=str1.compareTo(str2);
				if(comp>0){
					ret=1;
					break;
				}
				else if(comp==0){
					ret=0;
					continue;
				}
				else{
					ret=-1;
					break;
				}
			}
		}
		
		else{
			ret=-1;
		}
			
		return ret;
	}


		
}


