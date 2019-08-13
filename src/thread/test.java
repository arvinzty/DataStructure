package thread;

public class test {
    public static void main(String[] args) {
        Hero h1=new Hero("小鱼人",600,56);
        Hero h2=new Hero("幽鬼",550,42);
        Hero h3=new Hero("滚滚",620,46);
        Hero h4=new Hero("莱恩",500,62);
//        继承class的线程方法
//        KillThread k1=new KillThread(h1,h2);
//        KillThread k2=new KillThread(h3,h4);
//        k1.start();
//        k2.start();
//        继续接口的线程方法
//        Battle b1=new Battle(h1,h2);
//        Battle b2=new Battle(h3,h4);
//        new Thread(b1).start();
//        new Thread(b2).start();
//        匿名类
         Thread t1= new Thread(){
            public void run(){
                while (!h2.isDead()){
                    h1.attackHero(h2);
                }
            }
        };
         Thread t2= new Thread(){
             public void run(){
                 while (!h3.isDead())
                     h4.attackHero(h3);
             }
         };
         t2.start();
         t1.start();

    }
}
