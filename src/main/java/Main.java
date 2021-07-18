public class Main {
    public static void main(String[] args) {
        Flat bigFlat = new Flat(4, 100, true);
        Flat smallFlat = new Flat();
        smallFlat.setRooms(1);
        System.out.println(bigFlat.getArea());
    }
}
