package test.multithreading;

/**
 * <p>Title:KillThread </p>
 * <p>Description: 继承Thread</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 上午9:04:08
 */
public class KillThread extends Thread {
    private Hero h1;
    private Hero h2;
 
    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }
 
    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }
}
