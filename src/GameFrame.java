import java.awt.*;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.*;
public class GameFrame extends JFrame{
    public Elephant ele;
    public BackgroundImage bg;
    public Huge_stone hs;
    public Little_stone ls;
    public Big_stone bs;
    public Medium_stone ms;
    public Boat bt;
    public int take=0;
    public boolean save=false;
    public int count=0;
    public boolean in=true;
    public int high=225;
    public boolean flags=false;
    //public boolean restart=false;
    JButton clear = new JButton("清除");
    // JButton again=new JButton("再来一局！");
    JLabel sta=new JLabel("开始称重");
    JLabel end=new JLabel();
    Calculate_water cal=new Calculate_water(this);
    public GameFrame()throws Exception {
        ele=new Elephant(this);
        ele.start();
        cal.weight_get(ele.weight_get());
        bg=new BackgroundImage();
        hs=new Huge_stone();
        ls=new Little_stone();
        bs=new Big_stone();
        ms=new Medium_stone();
        bt=new Boat();
        new Thread(){
            public void run() {
                while (true) {
                    if (cal.calculate(count)) {
                        if (cal.now_weight == ele.weight) {
                            end.setText("你赢了！");
                            // again.setBounds(800, 345, 170, 40);
                            //  again.setVisible(true);
                            take = 1;
                            break;
                            //  restart = true;
                        }
                        else if(cal.now_weight>ele.weight+150){
                            take = 2;
                            end.setText("你输了！");
                            sank();
                            if (save==true) {
                                break;
                            }
                        }
                    }
                    count = 0;
                    repaint(0, 0, 800, 450);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    public void sank(){
        new Thread(){
            public void run(){
                while (true)
                {
                    high++;
                    if(high>450)
                        break;
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                save=true;
            }
        }.start();
    }
    public void paint(Graphics g)
    {
        BufferedImage bi =(BufferedImage)this.createImage(this.getSize().width,this.getSize().height);
        Graphics big =bi.getGraphics();
        big.drawImage(bg.img, 0 ,0 ,null);
        big.drawImage(hs.img,800,20,120,120,null);
        big.drawImage(ls.img,800,140,80,80,null);
        big.drawImage(bs.img,920,20,100,100,null);
        big.drawImage(ms.img,920,140,90,90,null);
        big.drawImage(ele.img_elephant,ele.x,ele.y,ele.body_get(),ele.body_get(),null);
        big.drawImage(bt.img,250,high,300,50,null);
        if(flags==false&&in==false)
        {
            big.drawImage(bg.img2,325,high-50,120,50,null);
        }
        if (cal.now_weight>ele.weight&&cal.now_weight<=ele.weight+150)
        {
            end.setText("超重了！");
        }
        else if (cal.now_weight<ele.weight) {
            end.setText("");
        }
        g.drawImage(bi,0,0,null);
    }
    public  void initFrame()
    {
        button();
        this.setSize(1050,450);
        this.setTitle("曹冲称象小游戏");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.add(clear);
        //  this.add(again);
        this.add(sta);
        this.add(end);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cal.now_weight=0;
                high=225;
                flags=true;
                in=true;
            }
        });
        // again.addActionListener(new ActionListener() {
        //    @Override
        //    public void actionPerformed(ActionEvent e) {
        //      restart=true;
        //   }
        //   });
        this.setVisible(true);
        Listener mouse=new Listener(this);
        this.addMouseListener(mouse);
    }
    public void button(){
        clear.setBounds(800,325,170,40);
        clear.setVisible(true);
        sta.setBounds(800,200,250,80);
        sta.setFont(new Font("宋体",Font.PLAIN, 20));
        sta.setVisible(true);
        end.setBounds(800,245,250,80);
        end.setFont(new Font("宋体",Font.PLAIN ,20));
    }
}
