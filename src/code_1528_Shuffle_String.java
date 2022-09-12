import java.util.HashMap;
import java.util.Map;

public class code_1528_Shuffle_String {
    public static void main(String[] args) {

       String s = "codeleet";
       int[] indices = {4,5,6,7,0,2,1,3};
       String res = restoreString(s,indices);
        System.out.println(res);

    }
    public static String restoreString(String s, int[] indices) {
        char[] charString = s.toCharArray();
        Map<Integer,Character> charMap = new HashMap<Integer,Character>();
        int len = s.length();
        for(int i=0; i<len;i++){
            charMap.put(indices[i],charString[i]);
        }
        char[] resChar = new char[len];
        for(int i=0;i<len;i++){
            resChar[i] =(char) charMap.get(i);
        }

        return String.valueOf(resChar);
    }
}
