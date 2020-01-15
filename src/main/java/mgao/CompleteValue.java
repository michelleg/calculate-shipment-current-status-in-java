package mgao;

public enum CompleteValue {
    COMPLETED(1), UNCOMPLETED(0);

    private int value;

    CompleteValue(int value) {
        this.value = value;
    }

    public int getValue() {
       return  this.value;
    }
}
