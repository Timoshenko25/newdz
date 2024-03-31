import java.util.*;
public class Main {
    public static Random random = new Random();
    public static List<PersonBase> darkTeam = new ArrayList<>();
    public static List<PersonBase> allTeam = new ArrayList<>();
    public static List<PersonBase> holyTeam = new ArrayList<>();
    public static void main(String[] args) {
       createTaems(darkTeam,1);
        createTaems(holyTeam,9);
            allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        for (int i =0;i<10;i++) {
            View.view();
            for (PersonBase param : allTeam) {
                if (holyTeam.contains(param)) {
                    param.step((ArrayList<PersonBase>)darkTeam, (ArrayList<PersonBase>) holyTeam);
                } else {
                    param.step((ArrayList<PersonBase>)holyTeam,(ArrayList<PersonBase>) darkTeam);
                }
            }
        }
    }
    public static void createTaems(List<PersonBase> team, int num) {
        Random rnd = new Random();
        int cy = 1;
        while (num>0) {
            String name = getName();
            int i = 0;
            int n = rnd.nextInt(4);
            switch (n) {
                case 0:
                    team.add(i, new Peasant(name, new Coordinates(num, cy)));
                    i++;
                    break;
                case 1:
                    team.add(i, new Magicians(name, new Coordinates(num, cy)));
                    i++;
                    break;
                case 2: team.add(i, new Infantry(name, new Coordinates(num, cy)));
                i++;
                break;
                case 3:
                team.add(i, (new Sniper(name, new Coordinates(num, cy))));
                i++;
                break;
            }
            cy ++;
            num--;
        }
        System.out.println(team);
    }
    public static String getName(){
        return String.valueOf(PersonBase.Names.values()[random.nextInt(PersonBase.Names.values().length)].toString());
    }
}

