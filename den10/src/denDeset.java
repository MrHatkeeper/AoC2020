import java.util.Arrays;


public class denDeset {
    public static void main(String[] args) {

        String idk = "8\n" +
                "131\n" +
                "91\n" +
                "35\n" +
                "47\n" +
                "116\n" +
                "105\n" +
                "121\n" +
                "56\n" +
                "62\n" +
                "94\n" +
                "72\n" +
                "13\n" +
                "82\n" +
                "156\n" +
                "102\n" +
                "12\n" +
                "59\n" +
                "31\n" +
                "138\n" +
                "46\n" +
                "120\n" +
                "7\n" +
                "127\n" +
                "126\n" +
                "111\n" +
                "2\n" +
                "123\n" +
                "22\n" +
                "69\n" +
                "18\n" +
                "157\n" +
                "75\n" +
                "149\n" +
                "88\n" +
                "81\n" +
                "23\n" +
                "98\n" +
                "132\n" +
                "1\n" +
                "63\n" +
                "142\n" +
                "37\n" +
                "133\n" +
                "61\n" +
                "112\n" +
                "122\n" +
                "128\n" +
                "155\n" +
                "145\n" +
                "139\n" +
                "66\n" +
                "42\n" +
                "134\n" +
                "24\n" +
                "60\n" +
                "9\n" +
                "28\n" +
                "17\n" +
                "29\n" +
                "101\n" +
                "148\n" +
                "96\n" +
                "68\n" +
                "25\n" +
                "19\n" +
                "6\n" +
                "67\n" +
                "113\n" +
                "55\n" +
                "40\n" +
                "135\n" +
                "97\n" +
                "79\n" +
                "48\n" +
                "159\n" +
                "14\n" +
                "43\n" +
                "86\n" +
                "36\n" +
                "41\n" +
                "85\n" +
                "87\n" +
                "119\n" +
                "30\n" +
                "108\n" +
                "80\n" +
                "152\n" +
                "158\n" +
                "151\n" +
                "32\n" +
                "78\n" +
                "150\n" +
                "95\n" +
                "3\n" +
                "52\n" +
                "49";

        String[] strArray = idk.split("\n");
        int[] input = new int[strArray.length];
        for(int i = 0; i < strArray.length; i++) {
            input[i] = Integer.parseInt(strArray[i]);
        }



        int oneJolt = 0;
        int threeJolt = 0;
        int aktJolt = 0;

        Arrays.sort(input);
        System.out.println(Arrays.toString(input));

        for(int i = 0; i < input.length; i++){
            if(aktJolt + 3 == input[i]){
                threeJolt += 1;
                aktJolt += 3;
            }
            else{
                oneJolt += 1;
                aktJolt += 1;
            }

            System.out.println(threeJolt + " " + oneJolt + " " + aktJolt);
        }

        System.out.println("část jedna = " + ((threeJolt + 1) * oneJolt));
    }
}
