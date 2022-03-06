package multithreading.casestudy;

import static multithreading.casestudy.Main.Max_Password;

public class DescHackerThread extends HackerThread{
    public DescHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for ( int guess=Max_Password; guess>=0 ;guess--){
            if(vault.isCorrectPassword(guess)){
                System.out.println(this.getName()+" guessed the password which is "+ guess);
                System.exit(0);
            }
        }
    }
}
