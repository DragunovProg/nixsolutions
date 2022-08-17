package ua.drahunov.first_task;

public class ContractStudent extends Student{
    private double contractValue;

    public ContractStudent(String name, int age, double contractValue) {
        super(name, age);
        this.contractValue = contractValue;
    }

    public double getContractValue() {
        return contractValue;
    }

    public void setContractValue(double contractValue) {
        this.contractValue = contractValue;
    }

    @Override
    public String toString() {
        return "ContractStudent{" +
                "name: " + getName() +
                "   contractValue=" + contractValue +
                '}';
    }
}
