package Java2Exercise.Q11;

public class Q11Code {
    public void runCode(){
        int s = 0;
        int t = 1;
        int i=0;
        while(i<10) //        for (int i = 0; i < 10; i++)
        {
            s = s + i;
            int j=i;
            while (j>0)//     for (int j = i; j > 0; j--)
            {
                t = t * (j - i);
                j--;
            }
            s = s * t;
            i++;
            System.out.println("T is " + t);
        }
        System.out.println("S is " + s);
    }
}
