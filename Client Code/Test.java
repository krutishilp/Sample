import shape.Circle;
import shape.Rectangle;
public class Test{
	
	public static void main(String[] args){
		Circle c=new Circle(10);
		Circle c1=new Circle(); 
		System.out.println("Area of Circle: "+ c.calculateArea());
		System.out.println("Area of Circle: "+ c1.calculateArea());
		
		Rectangle rec=new Rectangle(5,3);
		Rectangle rec1=new Rectangle();
		System.out.println("Area of Rectangle: "+ rec.calculateArea());
		System.out.println("Area of Rectangle: "+ rec1.calculateArea());
		
	}
}