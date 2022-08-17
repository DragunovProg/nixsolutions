package ua.drahunov.first_task;

import java.util.Arrays;

public class Group {
    private Student[] students;

    public Group(Student[] students) {
        this.students = Arrays.copyOf(students, students.length);
    }

    public Student[] getStudents() {
        return students;
    }
}
