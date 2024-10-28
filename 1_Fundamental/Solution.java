import java.util.ArrayList;

public class Solution {
    public static String solution(int[][] op) {
        ArrayList<Integer> list = new ArrayList<>();
        String result = "";
        for(int i=0;i<op.length;i++){
            if(op[i].length==2){
                list.add(op[i][1]);
            }else if(op[i].length==3){
                int size=op[i][2];
                int num=op[i][1];
                int num2=(num+size)-1;
                int count=0;
                for(int j=num;j<=num2;j++){
                    
                    if(list.contains(j)){
                        result+="0";
                        count++;
                        break;
                    }
                }
                if(count==0){
                    result+="1";
                }

            }
            }
            return result;
        }
    

    public static void main(String[] args) {
        int[][] operations = {
                { 1, 2 },
                { 1, 5 },
                { 2, 3, 2 },
                { 2, 3, 3 },
                { 2, 1, 1 },
                { 2, 1, 2 }
        };

        System.out.println(solution(operations)); // 1010

    }
}
