package mypackage;

class Complex{
	private int realNumber, imgNumber;
	Complex(){}
	Complex(int real, int img){
		realNumber = real;
		imgNumber = img;
	}

	public void setRealNumber(int real){
		realNumber = real;
	}

	public void setImgNumber(int img){
		imgNumber = img;
	}

	public int getRealNumber(){
		return realNumber;
	}

	public int getImgNumber(){
		return imgNumber;
	}

	
	public static Complex sumComplex(Complex fisrtComplex, Complex secondComplex){
		Complex resualt = new Complex();
		int real = fisrtComplex.getRealNumber() + secondComplex.getRealNumber();
		int img = fisrtComplex.getImgNumber() + secondComplex.getImgNumber();
		resualt.setRealNumber(real);
		resualt.setImgNumber(img); 

		return resualt;
	}

	public static Complex subComplex(Complex fisrtComplex, Complex secondComplex){
		Complex resualt = new Complex();
		int real = fisrtComplex.getRealNumber() - secondComplex.getRealNumber();
		int img = fisrtComplex.getImgNumber() - secondComplex.getImgNumber();
		resualt.setRealNumber(real);
		resualt.setImgNumber(img); 

		return resualt;
	}

	public static void printComplex(Complex complex){
		System.out.print( complex.getRealNumber() );
		if( complex.getImgNumber() > 0){
			System.out.println( "+" + complex.getImgNumber() + "i" );
		}else{
			System.out.println( complex.getImgNumber() + "i" );
		}
		
		
	}
	
		
}

class Main{

	public static void main(String[] args){
	        Complex fComplex = new Complex(1,2);
		Complex sComplex = new Complex(3,4);

		Complex thirdComplex = new Complex();
		thirdComplex = Complex.sumComplex(fComplex , sComplex);
		Complex.printComplex(thirdComplex);
		thirdComplex = Complex.subComplex(fComplex , sComplex);
		Complex.printComplex(thirdComplex);
	}
}