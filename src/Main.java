import java.util.*;

public class Main {
    public static Random random = new Random();
    public static List<PersonBase> darkTeam = new ArrayList<>();
    public static List<PersonBase> allTeam = new ArrayList<>();
    public static List<PersonBase> holyTeam = new ArrayList<>();

    public static void main(String[] args) {
        createTaems(darkTeam, 10);
        createTaems(holyTeam, 10);
        allTeam.addAll(holyTeam);
        allTeam.addAll(darkTeam);
        for (int i = 0; i < 10; i++) {
            View.view();
            for (PersonBase param : allTeam) {
                if (holyTeam.contains(param)) {
                    param.step((ArrayList<PersonBase>) darkTeam, (ArrayList<PersonBase>) holyTeam);
                } else {
                    param.step((ArrayList<PersonBase>) holyTeam, (ArrayList<PersonBase>) darkTeam);
                }
            }
        }
    }

    public static void createTaems(List<PersonBase> team, int num) {
        Random rnd = new Random();
        int cy = 1;
        while (num > 0) {
            int n = rnd.nextInt(4) + 1;
            String name = getName();
            Coordinates coordinates = new Coordinates(num, cy);
            switch (n) {
                case 1:
                    team.add(new Peasant(name, coordinates));
                    break;
                case 2:
                    team.add(new Magicians(name, coordinates));
                    break;
                case 3:
                    team.add(new Infantry(name, coordinates));
                    break;
                case 4:
                    team.add(new Sniper(name, coordinates));
                    break;
            }
            num--;
            System.out.println(team);
        }
    }


    public static String getName() {
        return String.valueOf(PersonBase.Names.values()[random.nextInt(PersonBase.Names.values().length)].toString());
    }
}

