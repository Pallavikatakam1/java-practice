
class Parent {
	public void details() {
		System.out.println("Good");
	}
}
class Child extends Parent{
	public void display(String food,int price) {
		System.out.println("Food: "+food+ " and price: "+price );
	}
}
public class Inherit{
	public static void main(String[] args) {
		Child child=new Child();
		child.display("Biryani",100);
		child.details();
	}
}