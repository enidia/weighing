import java.util.Random;
import java.awt.Image;

import javax.swing.ImageIcon;
public class Elephant extends Thread{
    public GameFrame start;
    public Image img_elephant=new ImageIcon("img\\elephant.jpg").getImage();
    public int weight = 0;
    public int i=0;
    public int x=50;
    public int y=50;
    public  Elephant(GameFrame start)
    {
        this.start=start;
        this.anime();
    }
    public void anime()
    {
        new Thread(){
            public void run(){
                for (int i=0;i<20;i++) {
                    x++;
                    y++;
                }
                for (int i=0;i<20;i++) {
                    x--;
                    y--;
                }
                try {
                    this.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
    public int weight_get()
    {
        Random rand=new Random();
        weight=rand.nextInt(400)+100;
        return weight;
    }
    public int body_get()
    {
        i=weight/100;
        if (i==1)
            return 100;
        else if(i==2)
            return 130;
        else if(i==3)
            return  150;
        else  if(i==4)
            return 200;
        else
            return 0;
    }
   /* public void res()
    {
        weight_get();
        body_get();
        this.start=start;
    }*/
}
