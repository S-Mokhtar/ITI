package Task3;
import java.util.Arrays;
import java.lang.*;
import java.util.StringTokenizer;

class Token{
    public static void main(String[] args){	String string=args[0];
		StringTokenizer str = new StringTokenizer(string,"\\.");
		while (str.hasMoreTokens()) {
			System.out.println(str.nextToken());
		}
	}
}