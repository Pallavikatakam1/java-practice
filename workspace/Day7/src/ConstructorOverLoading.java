
public class ConstructorOverLoading {
	String name;
    String company;
    int experience;
    double salary;
    ConstructorOverLoading() {
        name = "Pallavi";
        company = "Questk2";
        experience = 0;
    }
    ConstructorOverLoading(String name, String director) {
        this.name = name;
        this.company = company;
        this.experience = experience;
        this.salary = salary;
    }
    
    void display() {
        System.out.println(" Name: " + name + ":  Company " + company  + ":  Experience " + experience + "  : Salary :" +salary);
    }
    public static void main(String[] args) {
    	ConstructorOverLoading details = new ConstructorOverLoading();
    	details.display();
       
    }

}