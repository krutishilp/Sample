package shape;
public class Circle{
	
	private int radius;
	
	public Circle(int radius){
		this.radius=radius;
		
	}
	
	public Circle(){
		radius=5;
		
	}
	
	
	public void setRadius(int rad){
			radius=rad;
	}
	
	public double calculateArea(){
		return (3.14*radius*radius);
	}
}