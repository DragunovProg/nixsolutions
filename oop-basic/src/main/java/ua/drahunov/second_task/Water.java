package ua.drahunov.second_task;

public class Water extends AbstractSubstance implements Substance{

    @Override
    public State heatUp(double temperature) {
        setTemperature(temperature);

        if (temperature > 100) {
            return State.GAS;
        }

        return temperature <= 0 ? State.SOLID : State.LIQUID;
    }
}
