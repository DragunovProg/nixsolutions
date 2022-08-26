package ua.drahunov.secondtask;

public class Oxygen extends AbstractSubstance implements Substance{

    @Override
    public State heatUp(double temperature) {
        setTemperature(temperature);

        if (temperature > -183) {
            return State.GAS;
        }

        return temperature < -219 ? State.SOLID : State.LIQUID;
    }
}
