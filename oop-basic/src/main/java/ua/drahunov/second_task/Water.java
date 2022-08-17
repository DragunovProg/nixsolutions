package ua.drahunov.second_task;

public class Water implements Substance{
    private double temperature = 20;

    @Override
    public State heatUp(double temperature) {
        this.temperature = temperature;
        if (temperature > 100) {
            return State.GAS;
        }

        return temperature <= 0 ? State.SOLID : State.LIQUID;
    }

    public double getTemperature() {
        return temperature;
    }
}
