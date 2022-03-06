package multithreading.casestudy;

import static multithreading.casestudy.Main.Max_Password;

public class AscHackerThread extends HackerThread {
    public AscHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for ( int guess=0; guess<=Max_Password; guess++){
            if(vault.isCorrectPassword(guess)){
                System.out.println(this.getName()+" guessed the password which is "+ guess);
                System.exit(0);
            }
        }
    }
}
