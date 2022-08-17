package ua.drahunov.second_task;

public class Iron extends AbstractSubstance implements Substance{

    @Override
    public State heatUp(double temperature) {
        setTemperature(temperature);

        if (temperature > 1500) {
            return State.LIQUID;
        }

        return State.SOLID;
    }

}
