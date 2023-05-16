package basic_solution;

public class Current {
    private int temp;
    private float humidity;
    private float pressure;

    public void update(int temp1, float humidity1, float pressure1){
        System.out.println("Текущие данные обновились c учетом новых значений :" +
                temp1 + " " + humidity1 + " " + pressure1);

    }
}
