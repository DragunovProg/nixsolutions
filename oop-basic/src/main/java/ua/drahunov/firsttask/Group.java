package ua.drahunov.firsttask;

import java.util.Arrays;
import java.util.List;

public class Group {
    private Student[] students;

    public Group(Student[] students) {
        this.students = Arrays.copyOf(students, students.length);
    }

    public Student[] getStudents() {
        return students;
    }

    public List<Student> getContractStudents() {
        return Arrays.stream(students)
                .filter(student -> student instanceof ContractStudent)
                .toList();
    }
}
