import java.util.ArrayList;
import java.util.Scanner;

class EISTULI {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long id = sc.nextLong();
            String name = sc.next();
            Student st = new Student(id, name);
            int noCourses = sc.nextInt();

            for (int j = 0; j < noCourses; j++) {
                int grade = sc.nextInt();
                int noCredits = 4;
                st.addGrade(grade, noCredits);
            }
            students.add(st);
        }

        students.sort((s1, s2) -> {
            // So sánh GPA của sinh viên thứ 2 (s2) với sinh viên thứ 1 (s1)
            int compare = Double.compare(s2.gpa, s1.gpa);
            return compare;
        });

        k = Math.min(k, n);
        double removeGpa = k < n ? students.get(k).gpa : -1;
        for (int index = 0; index < k; index++) {
            if (students.get(index).gpa > removeGpa) {
                sb.append(students.get(index).id + " " + students.get(index).name + " "
                        + Math.round(students.get(index).gpa) + " "
                        + students.get(index).noCredits + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    static class Student {
        long id;
        String name;
        int noCredits;
        double totalGrade;
        double gpa;

        public Student(long id, String name) {
            this.id = id;
            this.name = name;
            this.noCredits = 0;
            this.totalGrade = 0;
            this.gpa = 0;
        }

        public void addGrade(int grade, int noCredits) {
            if (grade >= 50) {
                totalGrade += grade * noCredits;
                this.noCredits += noCredits;
                this.gpa = this.noCredits > 0 ? totalGrade / this.noCredits : 0;
            }
        }
    }

}
