public class Flat {
    int rooms;
    int area;
    boolean hasBalkony = true;

    public Flat(){

    }
    public Flat(int rooms, int area, boolean hasBalkony){
        this.area=area;
        this.rooms=rooms;
        this.hasBalkony=hasBalkony;
    }



    int getArea(){
        return area;
    }
    void setRooms(int rooms){
        this.rooms=rooms;
    }
}
