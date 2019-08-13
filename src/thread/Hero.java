package thread;

public class Hero {
    public String name;
    int hp;
    int damage;
    public Hero(String name,int hp,int damage){
        this.name=name;
        this.hp=hp;
        this.damage=damage;
    }
    public boolean isDead(){
        if (hp<0)
            return true;
        return false;
    }
    public void  attackHero(Hero hero){
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hero.hp-=damage;
        System.out.printf("%s正在被%s攻击，失去了%d血,剩下%d血\n",hero.name,this.name,this.damage,hero.hp);
        if (hero.isDead())
            System.out.printf("%s已经死亡\n",hero.name);
    }
}
