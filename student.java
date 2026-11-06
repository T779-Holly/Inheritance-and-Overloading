//Taydem Hansen
//Intructor: Mr. Gross
//Class: Software and programming development
//This program demonstrates the use of object-oriented programming concepts in Java, including classes, inheritance, and encapsulation. The program defines a base class `Student` and two derived classes `Undergraduate` and `Graduate`, each with their own unique attributes and behaviors.

public class Student {
    // 1. Attributes
    String studentName;
    int studentId;
    int studentAge;
    double studentFee;
    char studentGrade;
    boolean isEnrolled;

    // 2. Constructor
    public Student(String name, int id, int age, double fee, char grade, boolean enrolled) {
        studentName = name;
        studentId = id;
        studentAge = age;
        studentFee = fee;
        studentGrade = grade;
        isEnrolled = enrolled;
    }

    // 3. Methods to perform behaviors
    public void displayProfile() {
        System.out.println("--- Student Profile ---");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Age: " + studentAge);
        System.out.println("Fee Balance: $" + studentFee);
        System.out.println("Current Grade: " + studentGrade);
        System.out.println("Active Enrollment: " + isEnrolled);
    }

    public void makePayment(double amount) {
        studentFee -= amount;
        System.out.println(studentName + " made a payment of $" + amount);
    }

    public void updateGrade(char newGrade) {
        studentGrade = newGrade;
        System.out.println(studentName + "'s grade updated to: " + newGrade);
    }

    // 4. Main Method 
    public static void main(String[] args) {
        System.out.println("======= INITIALIZING ALL OBJECT TYPES =======");
        
        // 1. Create a base Student object
        Student johnDoe = new Student("John Doe", 101, 22, 1500.0, 'B', true);
        
        // 2. Create an Undergraduate object
        String[] undergradSchedule = {"CS101", "MATH201", "ENG102"};
        Undergraduate aliceSmith = new Undergraduate("Alice Smith", 204, 19, 3200.0, 'A', true, "Computer Science", undergradSchedule);
        
        // 3. Create a Graduate object 
        String[] gradAdvisors = {"Davis", "Miller"};
        Graduate markJohnson = new Graduate("Mark Johnson", 305, 26, 800.0, 'A', true, "AI Optimization", gradAdvisors);

        // Display initial profiles
        johnDoe.displayProfile();
        System.out.println();
        aliceSmith.displayProfile();
        System.out.println();
        markJohnson.displayProfile();
        System.out.println();

        System.out.println("======= PERFORMING ACTIONS & MODIFICATIONS =======");
        
        // Interact with the base Student
        johnDoe.updateGrade('A');
        
        // Interact with the Undergraduate object
        aliceSmith.dropClass(2); 
        aliceSmith.studentFee = 2700.0; // Direct modification
        System.out.println(aliceSmith.studentName + "'s fees manually overridden to: $" + aliceSmith.studentFee);

        // Interact with the Graduate object 
        markJohnson.updateThesis("Quantum Machine Learning Techniques");
        markJohnson.makePayment(800.0);

        System.out.println("\n======= UPDATED PROFILES =======");
        johnDoe.displayProfile();
        System.out.println();
        aliceSmith.displayProfile();
        System.out.println();
        markJohnson.displayProfile();
    }
}


// FIRST EXTENDED CLASS (Undergraduate)

class Undergraduate extends Student {
    String major;
    String[] currentSchedule; // Array data structure for storing classes

    public Undergraduate(String name, int id, int age, double fee, char grade, boolean enrolled, String major, String[] schedule) {
        super(name, id, age, fee, grade, enrolled); // Passes details to the base Student constructor
        this.major = major;
        this.currentSchedule = schedule;
    }

    // Unique behavior for undergrads
    public void dropClass(int index) {
        if (index >= 0 && index < currentSchedule.length) {
            System.out.println(studentName + " dropped class: " + currentSchedule[index]);
            currentSchedule[index] = "Dropped/Open Slot";
        }
    }

    @Override
    public void displayProfile() {
        super.displayProfile(); // Prints the base student profile attributes
        System.out.println("Major: " + major);
        System.out.print("Current Schedule: ");
        for (String course : currentSchedule) {
            System.out.print("[" + course + "] ");
        }
        System.out.println();
    }
}


// SECOND EXTENDED CLASS (Graduate)

class Graduate extends Student {
    String thesisTopic;
    String[] researchAdvisors; // Array data structure for storing thesis advisors

    public Graduate(String name, int id, int age, double fee, char grade, boolean enrolled, String thesisTopic, String[] advisors) {
        super(name, id, age, fee, grade, enrolled); // Passes details to the base Student constructor
        this.thesisTopic = thesisTopic;
        this.researchAdvisors = advisors;
    }

    // Unique behavior for grad students
    public void updateThesis(String newTopic) {
        this.thesisTopic = newTopic;
        System.out.println(studentName + " updated their thesis topic to: " + newTopic);
    }

    @Override
    public void displayProfile() {
        super.displayProfile(); // Prints the base student profile attributes
        System.out.println("Thesis Topic: " + thesisTopic);
        System.out.print("Research Committee: ");
        for (String advisor : researchAdvisors) {
            System.out.print("Dr. " + advisor + "  ");
        }
        System.out.println();
    }
}
