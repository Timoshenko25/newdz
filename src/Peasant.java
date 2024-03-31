import java.util.ArrayList;
import java.util.List;

public class Peasant extends PersonBase{
    public Peasant (String name,Coordinates coordinates){
        super(name,coordinates);
        initiative = 0;
        Health = 2;
        Arrows = 10;
    }

    public PersonBase Search_opponent(ArrayList<PersonBase> darkTeam,ArrayList<PersonBase> holyTeam){
        PersonBase p = null;
        double minDistance = Double.MAX_VALUE;
        for (PersonBase param : holyTeam){
            if( param instanceof Sniper  || param instanceof Magicians ||param instanceof Infantry ){
                double distance = Coordinates.calculating_distances(this.coordinates, param.coordinates);
                if(distance < minDistance){
                    minDistance = distance;
                    p = param;
                }
            }
        }
        for (PersonBase param : darkTeam){
            if( param instanceof Sniper  || param instanceof Magicians ||param instanceof Infantry ){
                double distance = Coordinates.calculating_distances(this.coordinates, param.coordinates);
                if(distance < minDistance){
                    minDistance = distance;
                    p = param;
                }
            }
        }
        return p;
    }
    public void step(ArrayList<PersonBase> darkTeam, ArrayList<PersonBase> holyTeam) {
        if (Health > 0 || Arrows > 0) {
            PersonBase c = Search_opponent(darkTeam, holyTeam);
            int[] enemyCoords = c.getCoords();
            int[] myCoords = getCoords();
            int dX = enemyCoords[0] - myCoords[0];
            int dY = enemyCoords[1] - myCoords[1];
            if (Math.abs(dX) + Math.abs(dY) == 1) {
                // Enemy is adjacent, attack
                c.healed(-10); // Assuming damage is 10 for now
                System.out.println(name + " attacks " + c.name);
            } else {
                // Move towards the enemy
                if (Math.abs(dX) > Math.abs(dY)) {
                    // Move along X axis
                    coordinates.setXY(coordinates.getX() + Integer.compare(dX, 0), coordinates.getY());
                } else {
                    // Move along Y axis
                    coordinates.setXY(coordinates.getX(), coordinates.getY() + Integer.compare(dY, 0));
                }
                System.out.println(name + " moves towards " + c.name);
            }
        }
    }
    @Override
    public String getInfo() {
        String s = "Name"+name+"Координаты :"+coordinates+"жив"+getHp()+"количество стрел"+getArrows();
        return s;
    }
}