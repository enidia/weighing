import java.awt.event.*;
public class Listener extends MouseAdapter {
    public GameFrame gf;
    boolean flag = false;
    int volum = 0;
    int wei=0;
    int stone_weight=0;
    boolean sa=false;
    int calculate_deep=0;
    int sant;
    public int c=0;
    public boolean stone_flag=false;
    public Listener(GameFrame gf) {
        this.gf = gf;
    }
    public void mousePressed(MouseEvent e) {
        if(gf.flags==true) {
            calculate_deep = 0;
            stone_flag=false;
            gf.flags=false;
        }
        int x = e.getX();
        int y = e.getY();
        if (x > 800 && x < 920 && y > 20 && y < 140) {
            gf.count = 100;
            sa=stoneadd();
            calculate_deep=calculate_deep+100;
            stone_flag=true;
            gf.in=false;
            c++;
        }
        if (x > 800 & x < 880 && y > 140 && y < 220) {
            gf.count = 1;
            sa=stoneadd();
            calculate_deep=calculate_deep+1;
            stone_flag=true;
            gf.in=false;
            c++;
        }
        if (x > 920 && x < 1020 && y > 20 && y < 120) {
            gf.count = 20;
            sa=stoneadd();
            calculate_deep=calculate_deep+20;
            stone_flag=true;
            gf.in=false;
            c++;
        }
        if (x > 920 && x < 1010 && y > 140 && y < 230) {
            gf.count = 5;
            sa=stoneadd();
            calculate_deep=calculate_deep+5;
            stone_flag=true;
            gf.in=false;
            c++;
        }
        if (x >= (gf.ele.x - 20) && x <= (20 + gf.ele.x + gf.ele.body_get()) && y >= (gf.ele.y - 20) && y <= (20 + gf.ele.x + gf.ele.body_get())) {
            flag = true;
        }
        gf.sta.setText("重量是:"+calculate_deep+"共:"+c+"步");
        sink();
        stone_sink();
    }

    public boolean stoneadd(){
        return true;
    }
    public void mouseReleased(MouseEvent e) {
        if(gf.flags==true) {
            calculate_deep = 0;
            stone_flag=false;
            gf.flags=false;
        }
        int x = e.getX() - (gf.ele.body_get() / 2);
        int y = e.getY() - (gf.ele.body_get() / 2);
        if (flag == true) {
            gf.ele.x = x;
            gf.ele.y = y;
            if (gf.ele.x < 0 || gf.ele.y < 0 || gf.ele.x > 800 - gf.ele.body_get() || gf.ele.y > 450 - gf.ele.body_get()) {
                gf.ele.x = 50;
                gf.ele.y = 50;
            }
            flag = false;
        }
        sink();
    }
    public void stone_sink(){
        if(gf.flags==true) {
            calculate_deep = 0;
            stone_flag=false;
            gf.flags=false;
        }
        sant=gf.high-225;
        new Thread(){
            public void run(){
                stone_weight=(calculate_deep/7)-sant;
                while (stone_weight>0)
                {
                    gf.high++;
                    stone_weight--;
                    try {
                        Thread.sleep(70);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    public void sink()
    {
        if(gf.flags==true) {
            calculate_deep = 0;
            stone_flag=false;
            gf.flags=false;
        }
        new Thread() {
            public void run() {
                if ((gf.ele.x+gf.ele.body_get()/2) <= 550&&(gf.ele.x+gf.ele.body_get()/2)>=250 && (gf.ele.y + gf.ele.body_get()/2) <= gf.high&&(gf.ele.y + gf.ele.body_get()/2)>=gf.high-70) {
                    volum = gf.ele.weight / 7;
                    while (volum > 0) {
                        gf.high++;
                        if ((gf.ele.x+gf.ele.body_get()/2) <= 550&&(gf.ele.x+gf.ele.body_get()/2)>=250 && (gf.ele.y + gf.ele.body_get()/2) <= gf.high&&(gf.ele.y + gf.ele.body_get()/2)>=gf.high-70) {
                            gf.ele.y++;
                        }
                        volum--;
                        try {
                            Thread.sleep(70);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    if(sa!=true)
                        while (true)
                        {
                            gf.high--;
                            if (gf.high<=225)
                            {
                                break;
                            }
                            try {
                                Thread.sleep(40);
                            }catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }
                }
            }
        }.start();
    }
}
