
/**
 * Created by Raymond on 01.11.2018.
 */
public class Main {
    public static void main(String[] args){
        Alice alice = new Alice();
        Bob bob = new Bob();

        //передача P,A
        bob.setP(alice.generateP());
        bob.setA(alice.generateA());

        //обмен открытыми ключами Y1, Y2
        bob.setOpenKey(alice.generateOpenKey());
        alice.setOpenKey(bob.generateOpenKey());

        //вычисление закрытого общего ключа
        alice.calculateSharedKey();
        bob.calculateSharedKey();


    }
}
