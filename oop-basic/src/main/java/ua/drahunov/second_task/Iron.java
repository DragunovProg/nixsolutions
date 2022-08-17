package ua.drahunov.second_task;

public class Iron implements Substance{
    private double temperate = 20;
    @Override
    public State heatUp(double temperature) {
        this.temperate = temperature;

        if (temperature > 1500) {
            return State.LIQUID;
        }

        return State.SOLID;
    }

    public double getTemperate() {
        return temperate;
    }

}
