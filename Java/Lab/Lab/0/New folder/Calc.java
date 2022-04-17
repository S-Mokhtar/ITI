class Calc
{
		public static void main (String[] args)
		{
			if (!validInput(args)) 
			{
            System.out.println("enter a Correct input");
            System.exit(0);
			}
			int num1 = Integer.parseInt(args[0]);
			String str = (args[1]);
            int num2 = Integer.parseInt(args[2]);
            int sum = num1 + num2;
			int sub = num1 - num2;  
			int mul = num1 * num2;
			int div = num1 / num2;
			if (str.equals("+"))
			{
			System.out.println(num1 + str + num2 + " = " + sum);
			}else if(str.equals("-"))
			{				
			System.out.println(num1 + str + num2 + " = " + sub);  
			}else if(str.equals("x"))
			{
				System.out.println(num1 + " * " + num2 + " = " + mul);
			}else
			{				
			System.out.println(num1 + str + num2 + " = " + div);  
			}
			
		}
		
		
    public static boolean validInput(String[] input) {
      
        if (input.length != 3)
            return false;

        boolean valid = (input[1].charAt(0) == '+' || input[1].charAt(0) == '-' || input[1].charAt(0) == '*' || input[1].charAt(0) == '/');
        
        try {
            Double.parseDouble(input[0]);
            Double.parseDouble(input[2]);
        } catch (NumberFormatException e) {
			return false;
        }
        
        valid &= !(input[1].charAt(0) == '/' && Double.parseDouble(input[2]) == 0.0);
        return valid;
    }
}