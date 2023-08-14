package ra.impl;

import ra.IStudent;

import java.util.List;
import java.util.Scanner;

public class Student implements IStudent {
    private String studentId;
    private String studentName;
    private int age;
    private float htmlScore;
    private float cssScore;
    private float javascriptScore;
    private float avgMark;
    private String sex;
    private String rank;
    private String status;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, float htmlScore, float cssScore, float javascriptScore, float avgMark, String sex, String rank, String status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.htmlScore = htmlScore;
        this.cssScore = cssScore;
        this.javascriptScore = javascriptScore;
        this.avgMark = avgMark;
        this.sex = sex;
        this.rank = rank;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHtmlScore() {
        return htmlScore;
    }

    public void setHtmlScore(float htmlScore) {
        this.htmlScore = htmlScore;
    }

    public float getCssScore() {
        return cssScore;
    }

    public void setCssScore(float cssScore) {
        this.cssScore = cssScore;
    }

    public float getJavascriptScore() {
        return javascriptScore;
    }

    public void setJavascriptScore(float javascriptScore) {
        this.javascriptScore = javascriptScore;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if ("Nam".equalsIgnoreCase(sex) || "Nữ".equalsIgnoreCase(sex)) {
            this.sex = sex;
        }
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner, List<Student> studentList) {
        System.out.print("Nhập mã sinh viên: ");
        boolean checkStudentId;
        do {
            this.studentId = scanner.nextLine();
            checkStudentId = uniqueStudentId(studentList);
            if (checkStudentId) {
                System.err.println("Mã sinh viên đã tồn tại, vui lòng nhập lại!");
                checkStudentId = false;
            } else {
                if (this.studentId.length() == 4 && this.studentId.startsWith("SV")) {
                    break;
                } else {
                    System.err.println("Mã sinh viên bắt đầu bằng 'SV', bắt buộc phải 4 ký tự");
                }
            }
        } while (!checkStudentId);

        System.out.print("Nhập tên sinh viên: ");
        boolean checkStudentName = true;
        do {
            this.studentName = scanner.nextLine();
            if (this.studentName.length() >= 6 && this.studentName.length() <= 50) {
                break;
            } else {
                System.err.println("Tên sinh viên phải chứa 6 - 50 ký tự!");
            }
        } while (checkStudentName);

        System.out.print("Nhập tuổi: ");
        boolean checkAge = true;
        do {
            this.age = Integer.parseInt(scanner.nextLine());
            if (age >= 18) {
                break;
            } else {
                System.err.println("Sinh viên yêu cầu trên 18 tuổi!");
            }
        } while (checkAge);

        System.out.print("Nhập giới tính: ");
        this.sex = scanner.nextLine();

        System.out.print("Nhập điểm HTML: ");
        boolean checkHTMLScore = true;
        do {
            this.htmlScore = Float.parseFloat(scanner.nextLine());
            if (this.htmlScore >= 0 && this.htmlScore <= 10) {
                break;
            } else {
                System.err.println("Điểm số nằm trong khoảng 0 - 10");
            }
        } while (checkHTMLScore);

        System.out.print("Nhập điểm CSS: ");
        boolean checkCSSSCore = true;
        do {
            this.cssScore = Float.parseFloat(scanner.nextLine());
            if (this.cssScore >= 0 && this.cssScore <= 10) {
                break;
            } else {
                System.err.println("Điểm số nằm trong khoảng 0 - 10");
            }
        } while (checkCSSSCore);

        System.out.print("Nhập điểm JS: ");
        boolean checkJSScore = true;
        do {
            this.javascriptScore = Float.parseFloat(scanner.nextLine());
            if (this.javascriptScore >= 0 && this.javascriptScore <= 10) {
                break;
            } else {
                System.err.println("Điểm số nằm trong khoảng 0 - 10");
            }
        } while (checkJSScore);
    }

    @Override
    public void displayData() {
        System.out.printf("%-20s%-30s%-10d%-15s%-15.2f%-15.2f%-15.2f%-15.2f%-15s%-15s\n", studentId, studentName, age, sex, htmlScore, cssScore, javascriptScore, avgMark, rank, status);
    }

    @Override
    public float calAvgMark() {
        return this.avgMark = (htmlScore + cssScore + javascriptScore) / 3;
    }

    public boolean uniqueStudentId(List<Student> studentList) {
        for (Student student : studentList) {
            if (student.studentId.equals(this.studentId)) {
                return true;
            }
        }
        return false;
    }

    public void rank() {
        if (this.calAvgMark() >= 0 && this.calAvgMark() <= 5) {
            this.rank = "Yếu";
        } else if (this.calAvgMark() < 7) {
            this.rank = "Trung bình";
        } else if (this.calAvgMark() < 8) {
            this.rank = "Khá";
        } else if (this.calAvgMark() < 9) {
            this.rank = "Giỏi";
        } else {
            this.rank = "Xuất sắc";
        }
    }

    public void status() {
        if (this.calAvgMark() >= MARK_PASS) {
            this.status = "PASS";
        } else {
            this.status = "FAIL";
        }
    }

    public void StudentsByRank(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Không có sinh viên nào trong danh sách.");
        }
        int[] studentsByRank = new int[studentList.size()];
        String[] arrRank = new String[studentList.size()];

        int studentCount = 0;
        for (int i = 0; i < studentList.size(); i++) {
            String student = studentList.get(i).getRank();
            boolean isExist = false;
            for (int j = 0; j < studentCount; j++) {
                if (arrRank[j].equals(student)) {
                    studentsByRank[j]++;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                arrRank[studentCount] = student;
                studentsByRank[studentCount] = 1;
                studentCount++;
            }
        }
        System.out.println("Thống kê sinh viên theo xếp loại");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%s: %d sinh viên\n", arrRank[i], studentsByRank[i]);
        }
    }

    public void studentsByStatus(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("Không có sinh viên nào trong danh sách.");
            return;
        }
        int[] studentsByStatus = new int[studentList.size()];
        String[] arrStatus = new String[studentList.size()];
        int studentCount = 0;

        for (int i = 0; i < studentList.size(); i++) {
            String student = studentList.get(i).getStatus();
            boolean isExist = false;
            for (int j = 0; j < studentCount; j++) {
                if (arrStatus[j].equals(student)) {
                    studentsByStatus[j]++;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                arrStatus[studentCount] = student;
                studentsByStatus[studentCount] = 1;
                studentCount++;
            }
        }
        System.out.println("Thống kê sinh viên theo trạng thái");
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("%s: %d sinh viên\n", arrStatus[i], studentsByStatus[i]);
        }
    }
}

