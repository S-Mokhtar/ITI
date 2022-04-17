package Task3;
import java.util.Arrays;
import java.lang.*;
import java.util.StringTokenizer;

class IPCutter{
    public static void main(String[] args){
	    /*boolean flag=true;
		String string=args[0];
		int firstIndex=string.indexOf(".");
		String firstVal=string.substring(0,firstIndex);
		System.out.println(firstVal);
		do{
		   int middleIndex=string.indexOf(".", firstIndex+1);
		   if (middleIndex!=-1){
		   String middleVal=string.substring(firstIndex+1,middleIndex);
		   System.out.println(middleVal);
		   firstIndex=middleIndex;
		   }
		else{
		   String lastVal=string.substring(firstIndex+1,string.length());
		   System.out.println(lastVal);
		   flag=false;
		}
	    }while(flag);*/
		
        /*String[] ip = args[0].split("\\.", 4);
        for (String values : ip)
            System.out.println(values);*/
		
		String string=args[0];
		StringTokenizer str = new StringTokenizer(string,"\\.");
		while (str.hasMoreTokens()) {
			System.out.println(str.nextToken());
		}
	}
}

