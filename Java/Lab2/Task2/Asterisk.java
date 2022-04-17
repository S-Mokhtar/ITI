package Task2;
public class Asterisk
{
     public static void main(String args[])
        {
           int n = 6;
           for(int i=0;i<n;i++){
              for(int j=0;j<=i;j++){
                 System.out.print("* ");
              }
              System.out.print(" ");
			  
              for(int k=i;k<n;k++)
              System.out.print("   ");

              for(int j=0;j<=i;j++){
			  System.out.print("* ");
			  }
			  System.out.println();
		   }
		}
}