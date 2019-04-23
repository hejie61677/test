package test.multithreading;

/**
 * <p>Title:Battle </p>
 * <p>Description: 实现runnable</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 上午9:02:23
 */
public class Battle implements Runnable {
    private Hero h1;
    private Hero h2;
 
    public Battle(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
