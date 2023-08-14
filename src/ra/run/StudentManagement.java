package ra.run;

import ra.impl.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        Student student = new Student();

        do {
            System.out.println("*************************** MENU *************************");
            System.out.println("1. Nhập thông tin n sinh viên (n nhập từ bàn phím)");
            System.out.println("2. Tính điểm trung bình tất cả sinh viên");
            System.out.println("3. Đánh giá xếp loại các sinh viên");
            System.out.println("4. Trạng thái của sinh viên");
            System.out.println("5. In thông tin các sinh viên");
            System.out.println("6. Sắp xếp sinh viên tăng dần theo điểm trung bình");
            System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
            System.out.println("8. Thống kê sinh viên theo xếp loại");
            System.out.println("9. Thống kê sinh viên theo trạng thái");
            System.out.println("10. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập số sinh viên: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        System.out.print("Nhập thông tin sinh viên thứ " + (i + 1) + "\n");
                        Student newStudent = new Student();
                        newStudent.inputData(scanner,studentList);
                        studentList.add(newStudent);
                    }
                    break;
                case 2:
                    for (Student st : studentList) {
                        st.calAvgMark();
                    }
                    System.out.println("Đã tính điểm trung bình của tất cả sinh viên!");
                    break;
                case 3:
                    for (Student st : studentList) {
                        st.rank();
                    }
                    System.out.println("Đã xếp loại của từng sinh viên!");
                    break;
                case 4:
                    for (Student st : studentList) {
                        st.status();
                    }
                    System.out.println("Đã xét trạng thái của từng sinh viên!");
                    break;
                case 5:
                    System.out.println("Thông tin sinh viên");
                    System.out.printf("%-20s%-30s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Điểm HTML", "Điểm CSS", "Điểm JS", "Điểm TB", "Xếp loại", "Trạng thái");
                    for (Student st : studentList) {
                        st.displayData();
                    }
                    break;
                case 6:
                    List<Student> newStudents = new ArrayList<>(studentList);
                    // selection sort
                    for (int i = 0; i < studentList.size() - 1; i++) {
                        for (int j = i + 1; j < studentList.size(); j++) {
                            if (newStudents.get(i).calAvgMark() > newStudents.get(j).calAvgMark()) {
                                Student temp = newStudents.get(i);
                                newStudents.set(i, newStudents.get(j));
                                newStudents.set(j, temp);
                            }
                        }
                    }
                    System.out.printf("%-70s%s\n\n", " ", "Danh sách điểm trung bình tăng dần");
                    System.out.printf("%-20s%-30s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Điểm HTML", "Điểm CSS", "Điểm JS", "Điểm TB", "Xếp loại", "Trạng thái");
                    for (Student newStudent : newStudents) {
                        newStudent.displayData();
                    }
                    break;
                case 7:
                    System.out.print("Nhập tên sinh viên muốn tìm kiếm: ");
                    String searchName = scanner.nextLine();
                    boolean checkSearch = false;
                    System.out.printf("%-70s%s\n\n", " ", "Thông tin sinh viên");
                    System.out.printf("%-20s%-30s%-10s%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n", "Mã sinh viên", "Họ và tên", "Tuổi", "Giới tính", "Điểm HTML", "Điểm CSS", "Điểm JS", "Điểm TB", "Xếp loại", "Trạng thái");
                    for (Student studentSearch : studentList) {
                        if (studentSearch.getStudentName().toLowerCase().contains(searchName.toLowerCase())) {
                            studentSearch.displayData();
                            checkSearch = true;
                        }
                    }
                    if (!checkSearch) {
                        System.err.println("Không tìm thấy tên sinh viên " + searchName);
                    }
                    break;
                case 8:
                    student.StudentsByRank(studentList);
                    break;
                case 9:
                    student.studentsByStatus(studentList);
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập lựa chọn từ 1 - 10");
                    break;
            }
        } while (true);
    }
}
