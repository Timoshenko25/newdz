public abstract class PersonBase implements paramInterface{
    protected static Coordinates coordinates;
    protected static int initiative;
    protected static  String name;
    protected static Integer Health;
    protected static  Integer Arrows;
    PersonBase(String name,Coordinates coordinates){
        this.name=name;
        this.coordinates=coordinates;
    }
    public int[] getCoords(){
        int []a = new int [2];
        return new int[]{coordinates.getX(),coordinates.getY()};
    }
    public Integer getHp(){
        return Health;
    }
    public void healed(int health){this.Health = Math.min(this.Health+Health,30);}
    public Integer getArrows(){
        return Arrows;
    }
    public int getInitiative(){
        return initiative;
    }
    @Override
    public String toString() {
        return "Имя: " + name + ", Координаты: " + coordinates;
    }

    public String getInfo(){
        String s = name+coordinates+Health;
        return s;
    }
    enum  Names{
        Vanya, Igor ,Sasha ,Artem, Nikita, Marat, Sergey ,Tom, Mark, Miron, Danil ,Andrey ,Zhenya;
    }
}