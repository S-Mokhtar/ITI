public class Rectangle extends GeoShape
{
	private double dim2;
	
	public Rectangle(double dim1 ,double dim2)
	{
		super(dim1);
		this.dim2=dim2;
	}
	
	public void setDim2(double dim2)
	{
		this.dim2=dim2;
	}
	public double getDim2()
	{
		return dim2;
	}
	@Override
	public double getArea()
	{
		return getDim1()*dim2;
	}
}