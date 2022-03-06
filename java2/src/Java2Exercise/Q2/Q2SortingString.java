package Java2Exercise.Q2;

public class Q2SortingString {
    public void stringSelectionSort(String unsortedStr){
        System.out.println("unsorted string");
        System.out.println(unsortedStr);
        char[] unsortedArr=unsortedStr.toCharArray();
        int min_ele=0;
        for (int i=0; i<unsortedArr.length; i++){
            min_ele=i; //setting minimum element index
            for (int j = i+1; j < unsortedArr.length; j++) {
                if(unsortedArr[j]<unsortedArr[min_ele]){
                    min_ele=j;
                }
            }
            char temp=unsortedArr[min_ele];
            unsortedArr[min_ele]=unsortedArr[i];
            unsortedArr[i]=temp;
        }
        System.out.println("Sorted String");
        String sortedStr=new String(unsortedArr);
        System.out.println(sortedStr);
    }
}
