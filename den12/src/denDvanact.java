import java.util.Arrays;

public class denDvanact {
    public static void main(String[] args) {

        String idk = "W5\n" +
                "R90\n" +
                "W3\n" +
                "F98\n" +
                "F87\n" +
                "R90\n" +
                "F57\n" +
                "R180\n" +
                "F3\n" +
                "L90\n" +
                "F60\n" +
                "N3\n" +
                "F94\n" +
                "N3\n" +
                "E2\n" +
                "S2\n" +
                "W2\n" +
                "L90\n" +
                "F26\n" +
                "R90\n" +
                "W1\n" +
                "F58\n" +
                "S5\n" +
                "F22\n" +
                "N3\n" +
                "F95\n" +
                "N1\n" +
                "W1\n" +
                "F11\n" +
                "R180\n" +
                "S3\n" +
                "R270\n" +
                "N1\n" +
                "N1\n" +
                "E4\n" +
                "S3\n" +
                "F81\n" +
                "W2\n" +
                "S2\n" +
                "L90\n" +
                "S4\n" +
                "R90\n" +
                "S1\n" +
                "E1\n" +
                "L90\n" +
                "S4\n" +
                "E2\n" +
                "F72\n" +
                "S1\n" +
                "W1\n" +
                "F73\n" +
                "W4\n" +
                "L180\n" +
                "S1\n" +
                "W5\n" +
                "S5\n" +
                "R90\n" +
                "E3\n" +
                "N3\n" +
                "F28\n" +
                "N1\n" +
                "F84\n" +
                "R90\n" +
                "E5\n" +
                "F13\n" +
                "W5\n" +
                "L90\n" +
                "F11\n" +
                "E4\n" +
                "F63\n" +
                "S1\n" +
                "S2\n" +
                "L90\n" +
                "N3\n" +
                "S5\n" +
                "F20\n" +
                "W1\n" +
                "S4\n" +
                "W1\n" +
                "S2\n" +
                "F67\n" +
                "N1\n" +
                "R180\n" +
                "F11\n" +
                "E1\n" +
                "R90\n" +
                "S2\n" +
                "R90\n" +
                "F38\n" +
                "S5\n" +
                "F27\n" +
                "S5\n" +
                "W3\n" +
                "S3\n" +
                "L90\n" +
                "N2\n" +
                "W2\n" +
                "S1\n" +
                "N4\n" +
                "R90\n" +
                "E1\n" +
                "F16\n" +
                "L90\n" +
                "E4\n" +
                "N1\n" +
                "L90\n" +
                "F89\n" +
                "E5\n" +
                "F90\n" +
                "E1\n" +
                "L180\n" +
                "N1\n" +
                "E3\n" +
                "S2\n" +
                "F58\n" +
                "S3\n" +
                "F53\n" +
                "R90\n" +
                "F100\n" +
                "W1\n" +
                "F53\n" +
                "W5\n" +
                "L90\n" +
                "W3\n" +
                "N4\n" +
                "F54\n" +
                "R180\n" +
                "S2\n" +
                "E2\n" +
                "F63\n" +
                "L90\n" +
                "S4\n" +
                "F40\n" +
                "F90\n" +
                "N3\n" +
                "F83\n" +
                "E5\n" +
                "F35\n" +
                "W4\n" +
                "W5\n" +
                "S3\n" +
                "E2\n" +
                "S2\n" +
                "S1\n" +
                "F12\n" +
                "L90\n" +
                "S1\n" +
                "F41\n" +
                "R90\n" +
                "S3\n" +
                "R90\n" +
                "F66\n" +
                "S2\n" +
                "F34\n" +
                "N5\n" +
                "R90\n" +
                "E5\n" +
                "R90\n" +
                "F25\n" +
                "N5\n" +
                "R90\n" +
                "W1\n" +
                "S2\n" +
                "S2\n" +
                "R90\n" +
                "E3\n" +
                "R90\n" +
                "F95\n" +
                "N3\n" +
                "W2\n" +
                "S4\n" +
                "R90\n" +
                "E3\n" +
                "L90\n" +
                "E3\n" +
                "R90\n" +
                "N2\n" +
                "F84\n" +
                "L90\n" +
                "N2\n" +
                "R90\n" +
                "S1\n" +
                "L90\n" +
                "F93\n" +
                "L90\n" +
                "F60\n" +
                "S4\n" +
                "F85\n" +
                "S2\n" +
                "F84\n" +
                "R180\n" +
                "W5\n" +
                "N4\n" +
                "W5\n" +
                "R270\n" +
                "S2\n" +
                "E2\n" +
                "L180\n" +
                "W4\n" +
                "R180\n" +
                "W5\n" +
                "F56\n" +
                "E1\n" +
                "F45\n" +
                "W4\n" +
                "R90\n" +
                "L180\n" +
                "S1\n" +
                "W4\n" +
                "S5\n" +
                "F87\n" +
                "R180\n" +
                "S2\n" +
                "F76\n" +
                "R90\n" +
                "F76\n" +
                "S1\n" +
                "E4\n" +
                "F6\n" +
                "S1\n" +
                "E2\n" +
                "F47\n" +
                "S3\n" +
                "W2\n" +
                "F16\n" +
                "F75\n" +
                "E3\n" +
                "F75\n" +
                "E4\n" +
                "R90\n" +
                "N5\n" +
                "W3\n" +
                "F1\n" +
                "S1\n" +
                "F8\n" +
                "E2\n" +
                "F64\n" +
                "R90\n" +
                "W4\n" +
                "S5\n" +
                "R90\n" +
                "N5\n" +
                "R90\n" +
                "E2\n" +
                "N1\n" +
                "E1\n" +
                "L180\n" +
                "F31\n" +
                "L180\n" +
                "E5\n" +
                "L90\n" +
                "N3\n" +
                "R90\n" +
                "F77\n" +
                "E3\n" +
                "F65\n" +
                "E4\n" +
                "R90\n" +
                "W1\n" +
                "N3\n" +
                "E3\n" +
                "F4\n" +
                "R90\n" +
                "E3\n" +
                "N4\n" +
                "F28\n" +
                "R180\n" +
                "N2\n" +
                "L90\n" +
                "S2\n" +
                "L90\n" +
                "N1\n" +
                "W1\n" +
                "L180\n" +
                "E4\n" +
                "F51\n" +
                "W4\n" +
                "F9\n" +
                "S4\n" +
                "R90\n" +
                "W5\n" +
                "S4\n" +
                "R90\n" +
                "E3\n" +
                "W2\n" +
                "F44\n" +
                "R90\n" +
                "E1\n" +
                "L180\n" +
                "S4\n" +
                "F93\n" +
                "S2\n" +
                "F58\n" +
                "R90\n" +
                "F80\n" +
                "L90\n" +
                "E2\n" +
                "F20\n" +
                "R90\n" +
                "F19\n" +
                "S4\n" +
                "F22\n" +
                "W1\n" +
                "S2\n" +
                "F62\n" +
                "N2\n" +
                "E5\n" +
                "F21\n" +
                "L90\n" +
                "F16\n" +
                "W2\n" +
                "F58\n" +
                "E2\n" +
                "F54\n" +
                "N1\n" +
                "F83\n" +
                "N3\n" +
                "E2\n" +
                "F62\n" +
                "S3\n" +
                "L90\n" +
                "E3\n" +
                "L270\n" +
                "F29\n" +
                "N5\n" +
                "L90\n" +
                "S2\n" +
                "F19\n" +
                "E5\n" +
                "R180\n" +
                "F87\n" +
                "R180\n" +
                "S2\n" +
                "F22\n" +
                "W3\n" +
                "S5\n" +
                "F35\n" +
                "E3\n" +
                "N5\n" +
                "R180\n" +
                "E2\n" +
                "R270\n" +
                "N3\n" +
                "F5\n" +
                "L90\n" +
                "W3\n" +
                "S1\n" +
                "L90\n" +
                "S2\n" +
                "R270\n" +
                "N5\n" +
                "L180\n" +
                "F79\n" +
                "N3\n" +
                "F82\n" +
                "N3\n" +
                "F73\n" +
                "N4\n" +
                "F57\n" +
                "L90\n" +
                "W3\n" +
                "F26\n" +
                "N4\n" +
                "E5\n" +
                "N4\n" +
                "F48\n" +
                "R90\n" +
                "F62\n" +
                "R90\n" +
                "F36\n" +
                "E1\n" +
                "F76\n" +
                "R90\n" +
                "N3\n" +
                "F83\n" +
                "E5\n" +
                "L90\n" +
                "S1\n" +
                "F1\n" +
                "E1\n" +
                "L90\n" +
                "F67\n" +
                "W3\n" +
                "L90\n" +
                "F42\n" +
                "E4\n" +
                "S2\n" +
                "L180\n" +
                "F89\n" +
                "N1\n" +
                "E4\n" +
                "S4\n" +
                "W1\n" +
                "S2\n" +
                "L90\n" +
                "F91\n" +
                "R90\n" +
                "F78\n" +
                "N5\n" +
                "F29\n" +
                "W2\n" +
                "R90\n" +
                "W1\n" +
                "R90\n" +
                "E2\n" +
                "F40\n" +
                "E2\n" +
                "F76\n" +
                "R90\n" +
                "E4\n" +
                "L90\n" +
                "W3\n" +
                "S1\n" +
                "W3\n" +
                "N4\n" +
                "F81\n" +
                "W4\n" +
                "F22\n" +
                "N1\n" +
                "W1\n" +
                "F47\n" +
                "E3\n" +
                "R90\n" +
                "N5\n" +
                "W4\n" +
                "L90\n" +
                "F44\n" +
                "L90\n" +
                "F58\n" +
                "S1\n" +
                "R90\n" +
                "E3\n" +
                "F91\n" +
                "N1\n" +
                "W4\n" +
                "N5\n" +
                "L90\n" +
                "F60\n" +
                "F8\n" +
                "S4\n" +
                "F17\n" +
                "E5\n" +
                "N2\n" +
                "L90\n" +
                "F37\n" +
                "L180\n" +
                "W4\n" +
                "L180\n" +
                "W4\n" +
                "F93\n" +
                "S5\n" +
                "F71\n" +
                "R90\n" +
                "N5\n" +
                "E3\n" +
                "F20\n" +
                "R90\n" +
                "N5\n" +
                "E5\n" +
                "R90\n" +
                "S2\n" +
                "R180\n" +
                "S5\n" +
                "L90\n" +
                "F26\n" +
                "E4\n" +
                "F49\n" +
                "E5\n" +
                "S4\n" +
                "E4\n" +
                "N1\n" +
                "L180\n" +
                "F33\n" +
                "E1\n" +
                "L90\n" +
                "S4\n" +
                "E5\n" +
                "N5\n" +
                "L180\n" +
                "F60\n" +
                "S1\n" +
                "F53\n" +
                "W1\n" +
                "F34\n" +
                "E2\n" +
                "N3\n" +
                "E2\n" +
                "S5\n" +
                "F61\n" +
                "F32\n" +
                "F18\n" +
                "L90\n" +
                "W4\n" +
                "N4\n" +
                "R90\n" +
                "E4\n" +
                "L90\n" +
                "F26\n" +
                "S3\n" +
                "W4\n" +
                "S5\n" +
                "E5\n" +
                "S2\n" +
                "R90\n" +
                "S5\n" +
                "R90\n" +
                "E2\n" +
                "R90\n" +
                "N2\n" +
                "S3\n" +
                "L90\n" +
                "S3\n" +
                "S2\n" +
                "L90\n" +
                "E5\n" +
                "F31\n" +
                "R180\n" +
                "E2\n" +
                "F42\n" +
                "R90\n" +
                "W4\n" +
                "L90\n" +
                "E5\n" +
                "S3\n" +
                "F79\n" +
                "R90\n" +
                "F76\n" +
                "W1\n" +
                "F9\n" +
                "N1\n" +
                "F91\n" +
                "R90\n" +
                "N3\n" +
                "F32\n" +
                "L180\n" +
                "N4\n" +
                "W2\n" +
                "F18\n" +
                "N5\n" +
                "L90\n" +
                "S4\n" +
                "L180\n" +
                "F22\n" +
                "E4\n" +
                "R180\n" +
                "S2\n" +
                "L90\n" +
                "W5\n" +
                "F31\n" +
                "L180\n" +
                "E1\n" +
                "F15\n" +
                "W1\n" +
                "S5\n" +
                "E4\n" +
                "F56\n" +
                "L90\n" +
                "F7\n" +
                "S3\n" +
                "E4\n" +
                "F13\n" +
                "R90\n" +
                "S4\n" +
                "F78\n" +
                "R180\n" +
                "E3\n" +
                "N1\n" +
                "R90\n" +
                "W4\n" +
                "F29\n" +
                "S4\n" +
                "L90\n" +
                "S4\n" +
                "W4\n" +
                "L180\n" +
                "F6\n" +
                "F84\n" +
                "E4\n" +
                "L90\n" +
                "F29\n" +
                "E2\n" +
                "F75\n" +
                "E3\n" +
                "N4\n" +
                "F33\n" +
                "L270\n" +
                "S4\n" +
                "F62\n" +
                "E2\n" +
                "N4\n" +
                "F50\n" +
                "E1\n" +
                "E2\n" +
                "L270\n" +
                "F100\n" +
                "R180\n" +
                "S2\n" +
                "F89\n" +
                "N2\n" +
                "W3\n" +
                "F5\n" +
                "E5\n" +
                "N2\n" +
                "F75\n" +
                "S3\n" +
                "F2\n" +
                "S4\n" +
                "W3\n" +
                "F33\n" +
                "S5\n" +
                "R90\n" +
                "E5\n" +
                "F20\n" +
                "S1\n" +
                "L90\n" +
                "S4\n" +
                "F10\n" +
                "W5\n" +
                "S2\n" +
                "L90\n" +
                "E3\n" +
                "E1\n" +
                "S3\n" +
                "F41\n" +
                "E5\n" +
                "L90\n" +
                "F28\n" +
                "S2\n" +
                "F40\n" +
                "S2\n" +
                "S4\n" +
                "N1\n" +
                "F15\n" +
                "W5\n" +
                "W2\n" +
                "R270\n" +
                "E5\n" +
                "R90\n" +
                "E4\n" +
                "F50\n" +
                "R90\n" +
                "S4\n" +
                "E1\n" +
                "N4\n" +
                "F73\n" +
                "L90\n" +
                "W2\n" +
                "L270\n" +
                "E4\n" +
                "S1\n" +
                "F30\n" +
                "S3\n" +
                "W4\n" +
                "L180\n" +
                "W4\n" +
                "F6\n" +
                "R90\n" +
                "F43\n" +
                "N5\n" +
                "W3\n" +
                "W3\n" +
                "R90\n" +
                "S2\n" +
                "R90\n" +
                "F50\n" +
                "W2\n" +
                "S4\n" +
                "L90\n" +
                "L180\n" +
                "W1\n" +
                "L270\n" +
                "E3\n" +
                "N2\n" +
                "E2\n" +
                "F48\n" +
                "W1\n" +
                "L90\n" +
                "N4\n" +
                "L90\n" +
                "E3\n" +
                "F86\n" +
                "L180\n" +
                "F10\n" +
                "S1\n" +
                "F36\n" +
                "S4\n" +
                "F33\n" +
                "N5\n" +
                "L90\n" +
                "F14\n" +
                "S2\n" +
                "E4\n" +
                "N4\n" +
                "R90\n" +
                "S2\n" +
                "W2\n" +
                "N2\n" +
                "L180\n" +
                "N4\n" +
                "R90\n" +
                "L90\n" +
                "E5\n" +
                "S1\n" +
                "F82\n" +
                "W1\n" +
                "S1\n" +
                "F19\n" +
                "E3\n" +
                "F19\n" +
                "S2\n" +
                "W1\n" +
                "F18\n" +
                "L90\n" +
                "F43\n" +
                "W1\n" +
                "N2\n" +
                "E3\n" +
                "L90\n" +
                "S1\n" +
                "F75\n" +
                "L90\n" +
                "E4\n" +
                "F80\n" +
                "N5\n" +
                "F15\n" +
                "F53\n" +
                "N4\n" +
                "E5\n" +
                "L90\n" +
                "E1\n" +
                "W5\n" +
                "R270\n" +
                "F17\n" +
                "F63\n" +
                "W2\n" +
                "F20\n" +
                "E1\n" +
                "S3\n" +
                "F19\n" +
                "E1\n" +
                "F99\n" +
                "S1\n" +
                "W1\n" +
                "F23\n" +
                "L180\n" +
                "S3\n" +
                "W4\n" +
                "F76";


        String[] strArray = idk.split("\n");


        char[] strany = {'N','E','S','W'};
        int pos = 1;
        char aktSmer = 'E';

        int north = 0;
        int east = 0;



        for(int i = 0; i < strArray.length;i++){
            String[] placeholder = strArray[i].split("",2);

            if(placeholder[0].charAt(0) == 'R'){
                pos += Integer.parseInt(placeholder[1]) / 90;
                if(pos > strany.length - 1){
                    pos -= strany.length;
                }
                aktSmer = strany[pos];
            }
            if(placeholder[0].charAt(0) == 'L'){
                pos -= Integer.parseInt(placeholder[1]) / 90;
                if(pos < 0){
                    pos += strany.length;
                }
                aktSmer = strany[pos];
            }
            else if(placeholder[0].charAt(0) == ('F')){
                if(aktSmer == ('N')){
                    north += Integer.parseInt(placeholder[1]);
                }
                else if(aktSmer == ('E')){
                    east +=  Integer.parseInt(placeholder[1]);
                }
                else if(aktSmer == ('S')){
                    north -=  Integer.parseInt(placeholder[1]);
                }
                else if(aktSmer ==('W')){
                    east -=  Integer.parseInt(placeholder[1]);
                }
            }
            else{
                if(placeholder[0].charAt(0) == ('N')){
                    north += Integer.parseInt(placeholder[1]);
                }
                else if(placeholder[0].charAt(0) == ('E')){
                    east +=  Integer.parseInt(placeholder[1]);
                }
                else if(placeholder[0].charAt(0) == ('S')){
                    north -=  Integer.parseInt(placeholder[1]);
                }
                else if(placeholder[0].charAt(0) == ('W')){
                    east -=  Integer.parseInt(placeholder[1]);
                }
            }
        }
        System.out.println(north + " " + east + " ");
    }
}
