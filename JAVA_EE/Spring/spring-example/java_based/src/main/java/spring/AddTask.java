package spring;

/**
 * Created by Splayd on 18.02.2017.
 */
class AddTask implements Task<Integer> {

    private int value1;
    private int value2;
    private int result;

    public AddTask(int value1, int value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    @Override
    public void execute() {
        result = value1 + value2;
    }

    @Override
    public Object getResult() {
        return result;
    }
}
