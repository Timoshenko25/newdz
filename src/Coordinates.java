public class Coordinates {
    int x;
    int y;
    Coordinates(int x, int y){
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return x +", "+y;
    }
    public static double  calculating_distances(Coordinates c1,Coordinates c2){
        return Math.sqrt(Math.pow(c1.getX()- c2.getX(),2)+(Math.pow(c1.getY()- c2.getY(),2)));
    }

    public void setXY(int x, int i) {
x=x;
y=y;
    }
}