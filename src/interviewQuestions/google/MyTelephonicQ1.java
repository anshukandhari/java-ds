package interviewQuestions.google;

/**
 * Check if the given String (contains latin chars too) has all the alphabets in sequence. Example
 * sabuycudkge fagkhfgi jakilameng,okpaq reswytgukjvfwgxaeyw z,kg
 *  ^^  ^ ^  ^ ^ ^ ^  ^ ^ ^ ^ ^ ^  ^ ^ ^ ^ ^  ^ ^  ^ ^ ^  ^  ^
 */
public class MyTelephonicQ1 {

    public static boolean hasAllAlphabets(String s){
        int cur = -1, val;

        for(int i = 0; i< s.length(); i++){
            val = s.charAt(i)-'a';
            if(val <0 || val > 25)
                continue;

            if(s.charAt(i)-'a' == cur+1){
                cur++;
            }

            if(cur == 25)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "sabuycudkge fagkhfgi jakilameng,okpaq reswytgukjvfwgxaeyw z,kg";
        System.out.println(hasAllAlphabets(str));


    }

}
