public abstract class GeoShape
{
	private double dim1;
	
	public GeoShape(double dim1)
	{
		this.dim1=dim1;
	}
	
	public void setDim1(double dim1)
	{
		this.dim1=dim1;
	}
	public double getDim1()
	{
		return dim1;
	}
 public abstract double getArea();
}



