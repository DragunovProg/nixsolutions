package ua.drahunov.second_task;

public class Oxygen implements Substance{
    private double temperature = 20;

    @Override
    public State heatUp(double temperature) {
        this.temperature = temperature;

        if (temperature > -183) {
            return State.GAS;
        }

        return temperature < -219 ? State.SOLID : State.LIQUID;
    }

    public double getTemperature() {
        return temperature;
    }
}
