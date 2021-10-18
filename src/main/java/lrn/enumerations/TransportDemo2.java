package lrn.enumerations;

public class TransportDemo2 {
    public static void main(String[] args) {
        System.out.println("Typical speed for an airplane is " +
                Transport2.AIRPLANE.getSpeed() + " miles per hour.\n");
        System.out.println("All transport speeds: ");
        for (Transport2 t: Transport2.values())
            System.out.println(t + " typical speed is " + t.getSpeed() + " miles per hour.");
    }
}
