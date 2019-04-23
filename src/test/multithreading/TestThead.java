package test.multithreading;

/**
 * <p>Title:TestThead </p>
 * <p>Description: 测试类</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 上午9:17:01
 */
public class TestThead {

	public static void main(String[] args) {
		Hero gareen = new Hero();
		gareen.name = "吕布";
		gareen.hp = 616;
		gareen.damage = 50;

		Hero teemo = new Hero();
		teemo.name = "孙悟空";
		teemo.hp = 300;
		teemo.damage = 30;

		Hero bh = new Hero();
		bh.name = "貂蝉";
		bh.hp = 500;
		bh.damage = 65;

		Hero leesin = new Hero();
		leesin.name = "安琪拉";
		leesin.hp = 455;
		leesin.damage = 80;

		//继承
/*		KillThread killThread1 = new KillThread(gareen, teemo);
		killThread1.start();
		KillThread killThread2 = new KillThread(bh, leesin);
		killThread2.start();*/
		
		//实现
/*      Battle battle1 = new Battle(gareen,teemo);       
        new Thread(battle1).start();
        Battle battle2 = new Battle(bh,leesin);
        new Thread(battle2).start();*/
		
        //匿名类
/*      Thread t1= new Thread(){
            public void run(){
                //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                while(!teemo.isDead()){
                    gareen.attackHero(teemo);
                }              
            }
        };         
        t1.start();
          
        Thread t2= new Thread(){
            public void run(){
                while(!leesin.isDead()){
                    bh.attackHero(leesin);
                }              
            }
        };
        t2.start();*/
		
        Thread t1= new Thread(){
            public void run(){
                int hair =1;
                while(true){
                    try {
                    	if(hair > 3) {
                    		hair = 1;
                    		System.out.printf(Thread.currentThread() + "开始充能 5 秒%n");
                    		Thread.sleep(5000);
                    	} else {
                    		Thread.sleep(1000);
                    	} 
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.printf("波动拳第 %d 发%n", hair++);
                }              
            }
        };
        t1.start();
		
	}

}
