
 class Complex
{
	private double real,imag;
	
	public Complex(double real ,double imag )
	{
		this.real=real;
		this.imag=imag;
	}
	public void setReal(double real)
	{
		
			this.real=real;
	}
	public double getReal()
	{
		return real;
	}
	
	public void setImag(double imag)
	{
			this.imag=imag;	
	}
	public double getImag()
	{
		return imag;
	}
	public static Complex add(Complex n1, Complex n2)
    {
        Complex temp = new Complex(0.0, 0.0);

        temp.real = n1.real + n2.real;
        temp.imag = n1.imag + n2.imag;

        return(temp);
    }
	public static Complex sub(Complex n1, Complex n2)
    {
        Complex temp2 = new Complex(0.0, 0.0);

        temp2.real = n1.real - n2.real;
        temp2.imag = n1.imag - n2.imag;

        return(temp2);
    }

	
	public static void main (String [] args)
		{
			
			Complex n1 = new Complex(5.4, 7.3),
                    n2 = new Complex(3.1, 5.0),
                    temp,
					temp2;
		   	   

			temp = add(n1, n2);
			temp2 = sub(n1, n2);
			System.out.println("Sum = " + temp.real+" + " + temp.imag+"i");
			System.out.println("Sum = " + temp2.real+" - " + temp2.imag+"i");
		}
}