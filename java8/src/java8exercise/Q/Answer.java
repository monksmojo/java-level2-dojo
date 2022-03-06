package java8exercise.Q;


import java.util.Arrays;
import java.util.List;

public class Answer {
    public static void main(String[] args) {
        Double du=new Double("8.0");
        Integer in=new Integer("2");
        System.out.println(du*in);
        List<String> accountIds = Arrays.asList("519933445287,460003782465".split(","));
        String query = "lineitem_usageaccountid in (:linkedaccountid)";
        StringBuilder accountIdList = new StringBuilder();
        for (String account : accountIds) {
            accountIdList.append("'").append(account).append("'").append(",");
        }
        accountIdList.setLength(accountIdList.length() - 1);
        System.out.println(query.replace(":linkedaccountid",accountIdList));
    }
}
