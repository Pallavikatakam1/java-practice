import java.util.Scanner;

public class PowerCalculation {
	
	public static int powerCal(int baseNum, int exponentNum)  //considering the given numbers
	{
		if(exponentNum ==0)            //power value = 0 then
		{
			return 1;           //returns 1 value
		}
		return baseNum*powerCal(baseNum,exponentNum-1);       //condition verifies
	}
	
	
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);            //creating a new scanner object
		System.out.println("Enter base number : ");    //asks user to enter base num
		int baseNum=scanner.nextInt();              //gives input to scanner
		System.out.println("Enter exponent number : ");     //asks  user to enter power value
		int exponentNum=scanner.nextInt();          //gives input to scanner
		powerCal(baseNum,exponentNum);             //calculates the output
		System.out.println("power value of given number : " +powerCal(baseNum,exponentNum));  //output printed	
		
	}

}
