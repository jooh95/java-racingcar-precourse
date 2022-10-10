package racingcar.model;

public class Lap implements Comparable<Lap> {
    private int lap;

    public Lap(int lap) {
        this.lap = lap;
    }

    public int getLap() {
        return lap;
    }

    public void increment() {
        lap += 1;
    }

    @Override
    public int compareTo(Lap o) {
        if (lap > o.getLap()) {
            return 1;
        } else if (lap < o.getLap()) {
            return -1;
        }
        return 0;
    }
}
