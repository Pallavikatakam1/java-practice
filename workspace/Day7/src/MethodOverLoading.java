
public class MethodOverLoading {

	 void print(int number) {
	        System.out.println("Number :  " + number);
	    }
	    void print(String string) {
	        System.out.println("Name : " + string);
	    }
	    void print(String string1, String string2) {
	        System.out.println("Another name :  " + string1 + " " + string2);
	    }
	    void print(char letter) {
	        System.out.println("First letter  " + letter);
	    }
	    public static void main(String[] args) {
	    	MethodOverLoading loader = new MethodOverLoading();
	        loader.print(20);              
	        loader.print("Pallavi");
	        loader.print("Pallavi", "Katakam ");
	        loader.print('P');
	    }	
}