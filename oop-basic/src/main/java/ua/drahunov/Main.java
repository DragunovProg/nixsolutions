package ua.drahunov;

import ua.drahunov.first_task.ContractStudent;
import ua.drahunov.first_task.Group;
import ua.drahunov.first_task.Student;
import ua.drahunov.second_task.*;

import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Group group = new Group(createStudents());

        for (Student student : group.getContractStudents()) {
            System.out.println(student);
        }

        heatingSubstances(new Substance[] {new Water(), new Iron(), new Oxygen()});
        int i = input.nextInt();
    }


    public static boolean heatingSubstances(Substance[] substances) {
            System.out.println("Choose substance:\nWater\nIron\nOxygen");
            int substanceIndex = input.nextInt();
            double temperature = 0;
            State state;


            Substance substance = substances[substanceIndex - 1];
            while (true) {
                System.out.println("Choose temperature");
                temperature = input.nextInt();
                if (temperature == 0) {
                    System.out.println("stopping application.....");
                    return true;
                }

                System.out.printf("at a temperature %.2fC the substance %s have %s state\n"
                        , temperature, substance.getClass().getSimpleName(), substance.heatUp(temperature).name());
            }

    }
    public static Student[] createStudents() {
        return new Student[] { new ContractStudent("Sergo", 20, 10000.00)
                , new Student("Smith", 21), new Student("John", 19)
                , new ContractStudent("Cassandra", 18, 12000.00)
                , new ContractStudent("Emma", 18, 20000.00)};
    }

}
