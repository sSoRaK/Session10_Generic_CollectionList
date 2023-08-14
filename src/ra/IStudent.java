package ra;

import ra.impl.Student;

import java.util.List;
import java.util.Scanner;

public interface IStudent {
    public final byte MARK_PASS = 5;

    void inputData(Scanner scanner, List<Student> studentList);

    public abstract void displayData();

    public abstract float calAvgMark();
}
