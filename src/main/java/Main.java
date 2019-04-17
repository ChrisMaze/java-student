import com.tw.controller.Command;
import com.tw.model.Student;
import com.tw.model.StudentRepository;
import com.tw.view.PrintReport;
public class Main {
    public static void main(String[] args){
        Student student1 = new Student("Tom", "001", 90, 90, 90, 90);
        Student student2 = new Student("Jack", "002", 90, 90, 90, 90);
        Student student3 = new Student("Jerry", "003", 90, 90, 90, 90);
        Student student4 = new Student("Zino", "004", 90, 90, 90, 90);
        Student student5 = new Student("Harris", "005", 90, 90, 90, 90);
        StudentRepository.getInstance().addStudents(student1,student2,student3,student4,student5);
        PrintReport printReport = new PrintReport();
        Command command = new Command();
        while(true)
        {
            System.out.printf(printReport.toString());
            command.reciveCommand();
        }



    }
}
