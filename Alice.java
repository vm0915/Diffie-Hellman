/**
 * Created by Raymond on 01.11.2018.
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;


public class Alice {
    private static Logger log = Logger.getLogger(Alice.class.getName());
    private int p;
    private int q;
    private int a;
    private int x1;
    private int y1;
    private int y2;
    private int key;
    private int x1Bound = 10;
    private int pBound = 30;

    public int generateP(){
        //выбрать p
        Random random = new Random();
        p = random.nextInt(pBound);
        //is p prime?
        while(!isPrime(p)){
            p = random.nextInt(pBound);
        }

        log.info("Created P = " + Integer.toString(p));
        q = (p - 1) / 2;
        return p;
    }

    public int generateA(){
        Random random = new Random();
        do {
            a = random.nextInt(p - 1);
        } while((a < 1) || (!validate(a)));

        log.info("Created A = " + Integer.toString(a));
        return a;
    }

    private void generateX1(){
        Random random = new Random();
        x1 = random.nextInt(x1Bound);
        log.info("Alice's secret key x1 = " + Integer.toString(x1));
    }

    public int generateOpenKey(){
        generateX1();
        y2 = (int)(Math.pow(a,x1) % p);
        log.info("Alice's open key = " + Integer.toString(y2));
        return y2;
    }

    public void setOpenKey(int y1){
        this.y1 = y1;
    }

    public void calculateSharedKey(){
        key = (int) (Math.pow(y1,x1) % p);
        log.info("Alice's calculated closed key = " + Integer.toString(key));
    }

    private boolean validate(int a){
        if(!((Math.pow(a,q) % p) == 1)){
            ArrayList<Double> list = new ArrayList();
            for(int i = 2; i < p; i++){
                if((!(list.contains((Math.pow(a,i) % p)))) && ((Math.pow(a,i) % p) > 0) && ((Math.pow(a,i) % p) < p)){
                    list.add((Math.pow(a,i) % p));
                }
                else return false;
            }
            return true;
        }
        return false;
    }

    private boolean isPrime(int number){
        if (number <= 3 || number % 2 == 0)
            return false;
        int divisor = 3;
        while ((divisor <= Math.sqrt(number)) && (number % divisor != 0))
            divisor += 2; //iterates through all possible divisors
        return number % divisor != 0; //returns true/false
    }

}
