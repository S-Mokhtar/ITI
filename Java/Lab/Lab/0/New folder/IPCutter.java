import java.util.StringTokenizer;
class IPCutter
{
	public static void main (String [] args)
	{	
		cutWithSplit(args[0]);
		cutWithStringTokenizer(args[0]);
		cutWithStringIndexOf(args[0]);
		
        }
	
	
	public static void cutWithSplit(String str)
	{
		String[] numbers = str.split("\\.");
		for (int i = 0; i < numbers.length; i++)
			{
             System.out.println(numbers[i]);	
			}
		
	}
	public static void cutWithStringTokenizer(String str)
	{
		StringTokenizer numbers = new StringTokenizer(str, "\\.");
		 while (numbers.hasMoreTokens()) 
		 {
           System.out.println(numbers.nextToken());
         }
	}
	public static void cutWithStringIndexOf(String str)
	{  
	    int x = 0, dot = str.indexOf(".", x);
        while (dot != -1) {
            String numbers = str.substring(x, dot);
            System.out.println(numbers);
            x = dot + 1;
            dot = str.indexOf(".", dot + 1);
        }
       System.out.println(str.substring(x, str.length()));
	}
	 

} 