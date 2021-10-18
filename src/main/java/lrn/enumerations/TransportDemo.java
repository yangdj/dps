package lrn.enumerations;

public class TransportDemo {
    public static void main(String[] args) {
        Transport tp;
        tp = Transport.AIRPLANE;
        System.out.println("Value of tp: " + tp);
        System.out.println();

        tp = Transport.TRAIN;

        if (tp == Transport.TRAIN) {
            System.out.println("tp contains TRAIN.\n");
        }
        switch (tp) {
            case CAR:
                System.out.println("A car carries people.");
                break;
            case TRUCK:
                System.out.println("A truck carries freight.");
                break;
            case AIRPLANE:
                System.out.println("A airplane flies");
                break;
            case TRAIN:
                System.out.println("A train runs on rails.");
                break;
            case BOAT:
                System.out.println("A boat sails on water.");
                break;
        }

        System.out.println("\nHere are all Transport constants");
        Transport[] allTransports = Transport.values();
        for (Transport t: allTransports) {
            System.out.println(t);
        }

        tp = Transport.valueOf("AIRPLANE");
        System.out.println("tp contains " + tp);
    }
}
