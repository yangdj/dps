package lrn.enumerations;

public enum Transport2 {
    CAR(65), TRUCK(55), AIRPLANE(600), TRAIN(70), BOAT(22);

    private int speed;

    Transport2(int s) { speed = s;}
    int getSpeed() { return  speed;}
}
