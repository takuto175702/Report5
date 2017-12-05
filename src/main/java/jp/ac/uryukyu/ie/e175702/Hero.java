package jp.ac.uryukyu.ie.e175702;

/**
 * ヒーロークラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Hero extends LivingThing {

    public Hero(String name, int maximumHP, int attack) {
        super(name, maximumHP, attack);
    }


    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     *
     * @param damage 受けたダメージ
     */

    @Override
    public void wounded(int damage) {

        int hp = getHitPoint();
        setHitPoint(hp);
        hp -= damage;
        if (hp < 0) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }

    public void attack(LivingThing opponent){
        if(isDead() == false) {
            int damage = (int)(Math.random() * getAttack());

                if(damage == 0){
                    System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した!\n", getName(), opponent.getName(), damage);
                }else {
                    int critical =(int)(Math.random()*10);

                        if(critical >= 0 && critical <= 3){
                            damage =damage*2;
                            System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
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
