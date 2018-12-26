import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Raymond on 24.12.2018.
 */
public class Bob {
    private static Logger log = Logger.getLogger(Alice.class.getName());
    private int p;
    private int a;
    private int x2;
    private int y1;
    private int y2;
    private int key;
    private int x2Bound = 10;

    public void setP(int p){
        this.p = p;
        log.info("Bob got P");
    }
    public void setA(int a){
        this.a = a;
        log.info("Bob got A");
    }

    public void generateX2(){
        Random random = new Random();
        x2 = random.nextInt(x2Bound);
        log.info("Bob's secret key x2 = " + Integer.toString(x2));
    }

    public int generateOpenKey(){
        generateX2();
        y1 = (int)(Math.pow(a,x2) % p);
        log.info("Bob's open key = " + Integer.toString(y1));
        return y1;
    }

    public void setOpenKey(int y2){
        this.y2 = y2;
    }

    public void calculateSharedKey(){
        key = (int) (Math.pow(y2,x2) % p);
        log.info("Bob's calculated closed key = " + Integer.toString(key));
    }


}
