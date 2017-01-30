import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * An instance of the College class simulates a college, which has a Library and lots of Students. 
 * A College is a funny place, because time seems to advance in discrete steps.
 * At each step a random Student wakes up, studies hard for a bit (for example, by borrowing a TextBook from the Library,
 * or reading a TextBook if they already have one) and then goes back to sleep again.
 * Students may eventually finish their studies, in which case they are removed from the college.
 * 
 * @author (Vaios Karpathakis) 
 * @version (coursework 2)
 */
public class College
{
    private ArrayList<Student> students;
    private Library Libra;
    private Random randomGenerator;
    private int n;
    
    public College(int numStudents, int textBooks)
    {
        int n = numStudents;
        Libra = new Library(textBooks);
        students = new ArrayList<>(numStudents);
        for (int i=0; i <numStudents; i++) {
            students.add(new Student("Student_" + i, Libra));
        }
        randomGenerator = new Random();
    }
    /**
     * Prints out a simple description of the state of the college.
     */
    public void describe()
    {
        System.out.println("The college has " + n + " hard-working students");
        Libra.describe();

    }
    /**
     * A random student is selected and if they have finished their studies, they are removed from the college.
     * Otherwise, the student studies.
     */
    private void nextStep()
    {
        if (students == null) {
            System.out.println("Everything has gone very quiet!"); }
        else {
             int randomStudent = randomGenerator.nextInt(students.size());
             Student theStudent = students.get(randomStudent); 
             if( theStudent.finishedStudies() ) {
                students.remove(randomStudent);
                System.out.println("The student has graduted and left the college!"); }
                 else { students.get(randomStudent).study(); } }
    }
    
    /**
     * Describes the state of the College n times(the user determines the number of times)
     * Invokes the nextStep() method n times.
     * @param n number of times the actions are carried out.
     */
    public  void runCollege(int nSteps)
    {
        for ( int i = 1; i <= nSteps; i++) {
             System.out.println("Step " + i); 
             describe();
             nextStep(); }
    }
    
    /**
     * The main method to run the program whithout BluJ
     */
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int students = scanner.nextInt();
        System.out.print("Enter number of books: ");
        int books = scanner.nextInt();
        System.out.print("Enter number of steps: ");
        int steps = scanner.nextInt();
        
        College collegeobj = new College(students, books);
        collegeobj.runCollege(steps);
    }
        
    
}            
    
    




        
