package jp.ac.uryukyu.ie.e175702;

/**
 * 敵クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Enemy extends LivingThing {

    public Enemy(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }

    @Override
    public void wounded(int damage) {

        int hp = getHitPoint();
        hp -= damage;
        setHitPoint(hp);
        if (hp < 0) {
            setDead(true);
            System.out.printf("モンスター%sは倒れた。\n", getName());
        }
    }

    public void attack(LivingThing opponent){
        if(isDead() == false) {
            int damage = (int)(Math.random() * getAttack());

            if(damage == 0){
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した!\n", getName(), opponent.getName(), damage);
            }else {
                int critical =(int)(Math.random()*10);

                if(critical >= 0 && critical <= 4){
                    damage =damage*2;
                    System.out.printf("%sの攻撃！痛恨の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }else{
                    System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
                    opponent.wounded(damage);
                }
            }
        }else{

        }
    }
}
