public class Calculate_water {
    public int elephant_weight;
    public int now_weight=0;
    public GameFrame gf;
    public boolean flag=false;
    public Calculate_water(GameFrame gf)
    {
        this.gf=gf;
    }
    public int weight_get(int w)
    {
       elephant_weight=w;
       //System.out.println(elephant_weight);
       return elephant_weight;
    }
    public boolean calculate(int insert_stone)
    {
        now_weight=now_weight+insert_stone;
        //System.out.println(now_weight+"--");
        //System.out.println(elephant_weight);
        if(now_weight>=elephant_weight) {
            flag=true;
        }
        return flag;
    }
}
