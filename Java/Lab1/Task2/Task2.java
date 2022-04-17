package Lab1;
class Complex{
int real;
int imag;
int getReal(){ return real;}
int getImag(){ return imag;}
void setReal(int r){ real=r;}
void setImag(int i){ imag=i;}
public Complex(){ real=imag=0;}
public Complex(int r, int i)
    {
        real = r;
        imag = i;
    }
	
static Complex addComplex2(Complex c1,Complex c2){
Complex temp= new Complex();
temp.real=c1.real+c2.real;
temp.imag=c1.imag+c2.imag;
return temp;
}
public void addComplex1(Complex c){
this.real+=c.getReal();
this.imag+=c.getImag();
}
public void subComplex1(Complex c){
this.real-=c.getReal();
this.imag-=c.getImag();
}
static Complex subComplex2(Complex c1,Complex c2){
Complex temp= new Complex();
temp.real=c1.real-c2.real;
temp.imag=c1.imag-c2.imag;
return temp;
}

void print(){
	System.out.println("Complex is: "+this.real+"+"+this.imag+"i");
}
public static void main(String[] args){
Complex comp1 = new Complex(4, 5);
Complex comp2 = new Complex(10, 5);
Complex comp3=addComplex2(comp1,comp2);
Complex comp4=subComplex2(comp1,comp2);
System.out.println("Added Complex is: "+comp3.real+"+"+comp3.imag+"i");
System.out.println("Subtracted Complex is: "+comp4.real+"+"+comp4.imag+"i");
Complex comp5=new Complex(1,2);
comp5.subComplex1(comp2);
comp5.print();
Complex comp6=new Complex(2,2);
comp6.addComplex1(comp2);
comp6.print();
}
}
