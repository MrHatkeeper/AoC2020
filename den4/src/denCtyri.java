import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class denCtyri {
    public static void main(String[] args) {
        System.out.println("answer A: " + runA(getInput()));
        System.out.println("answer B: " + runB(getInput()));
    }

    public static long runA(String input) {
        return Arrays.stream(input.split("\n\n"))
                .filter(denCtyri::hasAllrequiredFields)
                .count();
    }

    public static boolean hasAllrequiredFields(String passport) {
        String[] data = passport.replace("\n", " ").split(" ");
        if(data.length == 8) return true;
        if(data.length == 6) return false;
        return passport.contains("byr") && passport.contains("iyr") && passport.contains("eyr") && passport.contains("hgt")
                && passport.contains("hcl") && passport.contains("ecl") && passport.contains("pid");
    }

    public static long runB(String input) {
        return Arrays.stream(input.split("\n\n"))
                .filter(denCtyri::hasAllrequiredFields)
                .filter(denCtyri::allFieldsCorrect)
                .count();
    }

    public static boolean allFieldsCorrect(String passport) {
        String[] data = passport.replace("\n", " ").split(" ");
        return Arrays.stream(data).noneMatch(denCtyri::fieldNotCorrect);

    }

    public static boolean fieldNotCorrect(String field) {
        String[] split = field.split(":");
        switch (split[0]) {
            case "byr" : return !isValidNumber(parseInt(split[1]), 1920, 2002);
            case "iyr" : return !isValidNumber(parseInt(split[1]), 2010, 2020);
            case "eyr" : return !isValidNumber(parseInt(split[1]), 2020, 2030);
            case "hgt" : return !isValidHeight(split[1]);
            case "hcl" : return !isValidHairColor(split[1]);
            case "ecl" : return !isValidEyeColor(split[1]);
            case "pid" : return !isValidPassportId(split[1]);
            case "cid" : return false;
        }
        return true;
    }

    public static boolean isValidPassportId(String passportId) {
        if (passportId.length() != 9) {
            return false;
        }
        try {
            parseInt(passportId);
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    public static boolean isValidEyeColor(String eyeColor) {
        return "amb".equals(eyeColor) || "blu".equals(eyeColor) || "brn".equals(eyeColor) || "gry".equals(eyeColor)
                || "grn".equals(eyeColor) || "hzl".equals(eyeColor) || "oth".equals(eyeColor);
    }

    public static boolean isValidHairColor(String hairColor) {
        if(hairColor.length() != 7 || hairColor.charAt(0) != '#') {
            return false;
        }
        try {
            Long.parseLong(hairColor.substring(1), 16);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidHeight(String height) {
        if (height.contains("cm")) {
            return isValidNumber(parseInt(height.replace("cm", "")), 150, 193);
        }
        return isValidNumber(parseInt(height.replace("in", "")), 59, 76);
    }

    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static String getInput() {
        return "eyr:2021 hgt:168cm hcl:#fffffd pid:180778832 byr:1923 ecl:amb iyr:2019 cid:241\n" +
                "\n" +
                "hcl:#341e13 ecl:lzr eyr:2024 iyr:2014 pid:161cm byr:1991 cid:59 hgt:150cm\n" +
                "\n" +
                "iyr:2018 eyr:2027\n" +
                "hgt:153cm\n" +
                "pid:642977294 ecl:gry hcl:#c0946f byr:1999\n" +
                "\n" +
                "pid:#534f2e eyr:2022\n" +
                "ecl:amb cid:268\n" +
                "iyr:2028 hcl:2b079f\n" +
                "byr:2008\n" +
                "hgt:185cm\n" +
                "\n" +
                "byr:2000 hgt:161cm ecl:blu\n" +
                "eyr:2030 pid:647793597 hcl:#a97842 iyr:2011\n" +
                "\n" +
                "hcl:#3e335d\n" +
                "hgt:75cm\n" +
                "iyr:2010 byr:1940 ecl:#e0f130\n" +
                "pid:434016528\n" +
                "cid:138 eyr:2017\n" +
                "\n" +
                "hcl:#6b5442 cid:185 hgt:163cm eyr:2023\n" +
                "pid:510706612 byr:2001 ecl:amb iyr:2019\n" +
                "\n" +
                "hcl:#6b5442 byr:1942 eyr:2022\n" +
                "iyr:2016 pid:969898152 ecl:amb\n" +
                "\n" +
                "ecl:blu\n" +
                "pid:734638153 byr:1968\n" +
                "hcl:#733820 eyr:2020 hgt:160cm\n" +
                "iyr:2019\n" +
                "\n" +
                "iyr:2014 eyr:2020 byr:1996\n" +
                "hgt:158cm ecl:oth pid:920487833 hcl:#888785\n" +
                "\n" +
                "byr:1948 hcl:#341e13 cid:117 pid:802002577\n" +
                "hgt:188cm eyr:2028\n" +
                "ecl:blu iyr:2010\n" +
                "\n" +
                "pid:9572562 hgt:65cm ecl:#ac200e iyr:2028\n" +
                "byr:2002\n" +
                "eyr:2031 hcl:z\n" +
                "\n" +
                "byr:2024 hcl:#866857 ecl:dne\n" +
                "eyr:2031 pid:#a28d39\n" +
                "iyr:1920 hgt:158in\n" +
                "\n" +
                "pid:023850020 hgt:163cm iyr:2017 byr:1966\n" +
                "cid:145\n" +
                "ecl:grn eyr:2027 hcl:#ceb3a1\n" +
                "\n" +
                "hcl:z byr:2008 eyr:2020 ecl:#e810c9 hgt:76cm pid:0485860220\n" +
                "\n" +
                "hgt:154cm\n" +
                "hcl:#fffffd ecl:grn byr:1929 iyr:2019 pid:868514160 eyr:2026\n" +
                "\n" +
                "cid:181 byr:1991 eyr:2026 hgt:166cm\n" +
                "hcl:#cfa07d\n" +
                "iyr:2010 ecl:hzl pid:248467397\n" +
                "\n" +
                "eyr:2036\n" +
                "hgt:60cm byr:2023 ecl:#7f7a50 iyr:1964 hcl:z pid:189cm\n" +
                "cid:233\n" +
                "\n" +
                "ecl:#8b23b5 iyr:1940 hcl:#341e13 pid:806874850 hgt:150cm eyr:2033 byr:1930\n" +
                "\n" +
                "hcl:#efcc98 ecl:#cf8dd0 byr:1939 hgt:75cm eyr:2023 pid:7912576181\n" +
                "iyr:2014\n" +
                "\n" +
                "cid:282 hcl:#18171d\n" +
                "ecl:blu pid:475471726\n" +
                "hgt:158cm byr:1948 eyr:2030 iyr:2018\n" +
                "\n" +
                "eyr:2030 iyr:2013 pid:843774570 hgt:186cm ecl:amb\n" +
                "byr:1961 hcl:#7d3b0c\n" +
                "\n" +
                "cid:239\n" +
                "eyr:2021 pid:814286281\n" +
                "ecl:gry byr:1945 iyr:2016 hcl:#efcc98\n" +
                "hgt:167cm\n" +
                "\n" +
                "byr:1931 hcl:#cfa07d pid:148883217 iyr:2011\n" +
                "hgt:172cm\n" +
                "eyr:2026 ecl:gry\n" +
                "\n" +
                "hcl:z\n" +
                "eyr:2037\n" +
                "ecl:#bbb299 iyr:2015 byr:1931 hgt:186in\n" +
                "pid:8019203964\n" +
                "\n" +
                "hgt:178 hcl:bf28b4\n" +
                "eyr:2028\n" +
                "ecl:zzz\n" +
                "pid:184cm byr:1935 iyr:2017\n" +
                "\n" +
                "cid:195 byr:1936\n" +
                "eyr:2028 hgt:168cm hcl:#a69e3b pid:836680712\n" +
                "ecl:amb iyr:2020\n" +
                "\n" +
                "hgt:65in\n" +
                "pid:580748663 eyr:2028 iyr:2018 ecl:amb hcl:#866857 byr:1969\n" +
                "\n" +
                "iyr:2021 hcl:94dc65\n" +
                "eyr:2027\n" +
                "byr:2011 pid:172cm ecl:#84a05a\n" +
                "hgt:72cm\n" +
                "\n" +
                "pid:138102285\n" +
                "hcl:#efcc98 iyr:2019\n" +
                "ecl:grn cid:270 byr:1969\n" +
                "hgt:187cm eyr:2027\n" +
                "\n" +
                "eyr:2022 hgt:151cm pid:505032844\n" +
                "ecl:brn iyr:2020 hcl:#cfa07d byr:1965\n" +
                "\n" +
                "hcl:#7d3b0c\n" +
                "ecl:blu eyr:2024\n" +
                "pid:7946112272 iyr:2010 cid:337 hgt:180in\n" +
                "byr:2011\n" +
                "\n" +
                "hgt:65in iyr:2011 pid:774065195 eyr:2020\n" +
                "ecl:brn\n" +
                "byr:1993\n" +
                "hcl:#c0946f\n" +
                "\n" +
                "ecl:blu\n" +
                "hgt:65in\n" +
                "iyr:2014\n" +
                "hcl:#6b5442 byr:1948\n" +
                "pid:672157135\n" +
                "\n" +
                "hcl:#2e5fe2 hgt:182cm byr:1989\n" +
                "cid:205 iyr:2010 pid:116603730 eyr:2020 ecl:oth\n" +
                "\n" +
                "ecl:zzz iyr:2029\n" +
                "pid:152cm hcl:z hgt:67cm\n" +
                "eyr:2032\n" +
                "byr:1942\n" +
                "\n" +
                "iyr:2012 hgt:180cm byr:1951 pid:777840558 cid:324 eyr:2029\n" +
                "ecl:blu hcl:#341e13\n" +
                "\n" +
                "hcl:z\n" +
                "cid:320 byr:1995 eyr:2022 pid:#0830f1 hgt:63 ecl:#9db56f iyr:2017\n" +
                "\n" +
                "eyr:1996 iyr:2018 ecl:gmt\n" +
                "hgt:182cm pid:523450129 hcl:#6660a6 cid:76 byr:1959\n" +
                "\n" +
                "iyr:2013\n" +
                "pid:427856678\n" +
                "eyr:2027 cid:146\n" +
                "ecl:hzl\n" +
                "hgt:171cm\n" +
                "\n" +
                "eyr:2027 hgt:158cm\n" +
                "pid:54529307 hcl:z\n" +
                "ecl:hzl byr:2018 iyr:1980\n" +
                "\n" +
                "iyr:2010 eyr:2026\n" +
                "ecl:amb hcl:#a97842 pid:404930776 cid:277 byr:1994 hgt:184cm\n" +
                "\n" +
                "eyr:2028 hgt:150cm pid:#534041 iyr:2022\n" +
                "hcl:#733820\n" +
                "cid:130 ecl:blu\n" +
                "byr:1963\n" +
                "\n" +
                "ecl:blu hgt:160cm hcl:#ceb3a1 byr:1951 eyr:2029\n" +
                "pid:655280714\n" +
                "iyr:2020\n" +
                "\n" +
                "cid:248 byr:1966 iyr:2017\n" +
                "eyr:2025 ecl:blu pid:930670644 hcl:#866857\n" +
                "\n" +
                "ecl:amb eyr:2028 cid:308 byr:1951 hgt:183cm pid:260537189\n" +
                "iyr:2011 hcl:#cfa07d\n" +
                "\n" +
                "byr:1993\n" +
                "hcl:#7d3b0c pid:787304941\n" +
                "iyr:2017 eyr:2024 hgt:178cm cid:314\n" +
                "ecl:hzl\n" +
                "\n" +
                "ecl:#62c438 hcl:915943 iyr:1958 pid:1027793033 byr:2015 hgt:90\n" +
                "eyr:2035\n" +
                "\n" +
                "hcl:#b6652a eyr:2028 ecl:gry hgt:168cm byr:1921 pid:130528933 iyr:2020\n" +
                "\n" +
                "eyr:2023 pid:675106386 ecl:brn byr:2021\n" +
                "iyr:2011\n" +
                "hgt:153cm hcl:#888785\n" +
                "\n" +
                "iyr:2010 pid:586165419 eyr:2023\n" +
                "ecl:gry hgt:169cm hcl:#623a2f byr:1993\n" +
                "\n" +
                "iyr:2015 pid:332903175 eyr:2021\n" +
                "hgt:154cm\n" +
                "hcl:#733820 ecl:gry byr:1951\n" +
                "\n" +
                "hcl:e58fa1 byr:1932 ecl:dne\n" +
                "cid:272 eyr:2026 hgt:175cm iyr:1936 pid:408053740\n" +
                "\n" +
                "iyr:2013 hgt:151cm\n" +
                "pid:151cm\n" +
                "hcl:#888785\n" +
                "byr:2014\n" +
                "cid:207 eyr:2023 ecl:#51625d\n" +
                "\n" +
                "iyr:2016 cid:112\n" +
                "ecl:amb\n" +
                "pid:727316519\n" +
                "eyr:2020 byr:1947 hcl:#ceb3a1 hgt:180cm\n" +
                "\n" +
                "eyr:2036 hcl:z\n" +
                "ecl:gmt pid:11080111\n" +
                "byr:1972 hgt:161in iyr:2030\n" +
                "\n" +
                "iyr:2013 ecl:gry eyr:2030\n" +
                "hcl:#602927 byr:1968 hgt:160cm\n" +
                "pid:888357737\n" +
                "\n" +
                "eyr:2026\n" +
                "pid:259305913 iyr:2012 hgt:166cm ecl:amb byr:1951 hcl:#b6652a\n" +
                "\n" +
                "byr:1939 hgt:158cm\n" +
                "cid:232 eyr:2022 ecl:amb\n" +
                "hcl:#fffffd pid:312632405\n" +
                "iyr:2016\n" +
                "\n" +
                "ecl:amb hgt:166cm pid:138763305 hcl:#a97842 byr:1972 eyr:2020\n" +
                "iyr:2020\n" +
                "\n" +
                "hgt:155cm hcl:#733820 byr:2010\n" +
                "pid:138766753\n" +
                "ecl:grt eyr:2032 cid:50\n" +
                "iyr:2002\n" +
                "\n" +
                "eyr:2029 ecl:gry iyr:2013 byr:1924\n" +
                "hgt:181cm\n" +
                "hcl:#fffffd pid:194780722\n" +
                "cid:216\n" +
                "\n" +
                "eyr:2020 pid:1817301064 hcl:#b6652a\n" +
                "ecl:grn iyr:2014\n" +
                "byr:2000 hgt:171cm\n" +
                "\n" +
                "hcl:#03f240 iyr:2017 ecl:oth byr:1921 pid:464020404 eyr:2025 cid:348\n" +
                "hgt:179cm\n" +
                "\n" +
                "cid:284 hcl:23f681\n" +
                "pid:190cm iyr:2023 eyr:2032\n" +
                "hgt:61cm ecl:#6da9d9\n" +
                "byr:2029\n" +
                "\n" +
                "hgt:175cm byr:1959 ecl:amb\n" +
                "eyr:2030 cid:315 hcl:#ceb3a1\n" +
                "pid:795101457\n" +
                "iyr:2013\n" +
                "\n" +
                "eyr:2027 hgt:170cm cid:100 ecl:grn\n" +
                "iyr:2011 hcl:#d6b2ee pid:760346767 byr:1950\n" +
                "\n" +
                "eyr:2014 hcl:#a97842 ecl:blu\n" +
                "pid:5560121737 hgt:73in\n" +
                "iyr:2010\n" +
                "\n" +
                "byr:1945 hcl:#7d3b0c eyr:2024 ecl:brn iyr:2013\n" +
                "pid:433715275\n" +
                "\n" +
                "eyr:2022 ecl:gry byr:1982 hcl:#6b5442 iyr:2019 pid:650096889 hgt:65in\n" +
                "\n" +
                "iyr:2010 ecl:oth hgt:154cm eyr:2024 cid:122 hcl:#341e13\n" +
                "byr:1929 pid:264796724\n" +
                "\n" +
                "eyr:2026 cid:225\n" +
                "byr:1928 pid:479832664 hcl:#cfa07d iyr:2020\n" +
                "hgt:192cm\n" +
                "ecl:gry\n" +
                "\n" +
                "pid:460595787 hgt:157cm iyr:2018\n" +
                "ecl:oth\n" +
                "hcl:#ceb3a1 eyr:2021\n" +
                "\n" +
                "iyr:2018 pid:787208686 hgt:178cm cid:118\n" +
                "hcl:#ceb3a1 ecl:oth\n" +
                "eyr:2030 byr:1949\n" +
                "\n" +
                "hcl:#efcc98 byr:1934 hgt:175cm ecl:oth\n" +
                "iyr:2019 cid:326 pid:337273951 eyr:2024\n" +
                "\n" +
                "hcl:#6b5442\n" +
                "pid:422717762 iyr:2010 ecl:gry\n" +
                "eyr:2024\n" +
                "hgt:165cm byr:1950\n" +
                "\n" +
                "pid:712203563 eyr:2023\n" +
                "hgt:151cm\n" +
                "iyr:2010\n" +
                "byr:1950\n" +
                "hcl:#ceb3a1 ecl:grn\n" +
                "\n" +
                "hcl:#888785 eyr:2020 iyr:2016\n" +
                "hgt:191cm byr:1927 pid:848960326 ecl:hzl\n" +
                "\n" +
                "byr:1999 iyr:2016\n" +
                "hgt:62in hcl:#7d3b0c eyr:2028\n" +
                "\n" +
                "cid:195\n" +
                "iyr:1957 eyr:2023 byr:1993\n" +
                "hgt:176cm pid:316550627 hcl:68f2e3 ecl:amb\n" +
                "\n" +
                "hcl:#623a2f pid:780723069\n" +
                "byr:1936 cid:271 eyr:2022\n" +
                "hgt:188cm\n" +
                "iyr:2017 ecl:grn\n" +
                "\n" +
                "eyr:2021 pid:209774111 hgt:192cm\n" +
                "hcl:#6b5442 ecl:amb\n" +
                "iyr:2018\n" +
                "byr:1983\n" +
                "\n" +
                "hcl:#edeee4 byr:2001 cid:68 pid:717560044 ecl:hzl eyr:2030 iyr:2016 hgt:191cm\n" +
                "\n" +
                "eyr:1968 cid:222 ecl:gry pid:90867093 hcl:#866857\n" +
                "iyr:2026 hgt:72 byr:1965\n" +
                "\n" +
                "eyr:2028\n" +
                "hgt:152cm pid:759034572 iyr:2017 hcl:#a97842\n" +
                "ecl:brn\n" +
                "cid:168 byr:1987\n" +
                "\n" +
                "hcl:453e20 eyr:2011\n" +
                "ecl:gry hgt:75cm byr:1994 pid:41067436 iyr:2024\n" +
                "\n" +
                "ecl:blu hgt:61cm\n" +
                "byr:1988 eyr:2022 iyr:2020\n" +
                "pid:219813481 hcl:#ceb3a1\n" +
                "\n" +
                "pid:635783992\n" +
                "byr:1950 eyr:2029 hgt:182cm hcl:#c0946f ecl:oth\n" +
                "\n" +
                "iyr:2016 ecl:amb pid:393320246 hgt:156cm\n" +
                "hcl:#fffffd byr:1988 eyr:2028\n" +
                "\n" +
                "pid:689161094\n" +
                "hcl:#623a2f iyr:2011\n" +
                "eyr:2020 byr:1953\n" +
                "hgt:153cm ecl:brn\n" +
                "\n" +
                "hgt:185cm hcl:#ceb3a1\n" +
                "pid:751921928 iyr:2019 ecl:grn eyr:2028\n" +
                "byr:1943\n" +
                "\n" +
                "hcl:#b6652a eyr:2025 iyr:2016 ecl:hzl\n" +
                "hgt:169cm byr:1931 pid:486548422\n" +
                "\n" +
                "hgt:160cm pid:49931386\n" +
                "ecl:gry iyr:2010 eyr:2021 hcl:#341e13 cid:64 byr:1933\n" +
                "\n" +
                "byr:1927\n" +
                "pid:415362434\n" +
                "ecl:gmt eyr:2028\n" +
                "hgt:153cm hcl:#18171d iyr:2017 cid:163\n" +
                "\n" +
                "byr:1949 pid:427698686\n" +
                "eyr:2027 iyr:2018 ecl:hzl hgt:159cm\n" +
                "hcl:#ceb3a1 cid:132\n" +
                "\n" +
                "hcl:#7d3b0c iyr:2013 byr:2023 eyr:2037\n" +
                "cid:83 ecl:#05c60a hgt:160\n" +
                "pid:429836535\n" +
                "\n" +
                "hgt:174cm eyr:1937 pid:149685914 byr:2004 iyr:2017\n" +
                "hcl:#623a2f cid:303\n" +
                "ecl:blu\n" +
                "\n" +
                "hgt:60cm pid:47770642\n" +
                "byr:2020 eyr:2032 ecl:#cc7bc6 cid:144 iyr:2025 hcl:z\n" +
                "\n" +
                "iyr:2010 ecl:amb\n" +
                "pid:#5f3343 hcl:#733820 eyr:2021 byr:1933\n" +
                "hgt:169cm\n" +
                "\n" +
                "hcl:#efcc98\n" +
                "hgt:172cm eyr:2020\n" +
                "ecl:oth\n" +
                "byr:2001 pid:027554330\n" +
                "iyr:1983 cid:165\n" +
                "\n" +
                "byr:2026 hgt:158cm iyr:2016 hcl:#733820\n" +
                "ecl:hzl cid:117\n" +
                "eyr:2037\n" +
                "pid:37781880\n" +
                "\n" +
                "hcl:#602927 cid:248\n" +
                "byr:1999\n" +
                "hgt:181cm eyr:2029 pid:554270506\n" +
                "iyr:2016\n" +
                "ecl:blu\n" +
                "\n" +
                "byr:1952 iyr:2014\n" +
                "ecl:oth\n" +
                "hcl:#cfa07d hgt:186cm pid:875655050\n" +
                "eyr:2024\n" +
                "\n" +
                "eyr:2030 hgt:186cm hcl:#18171d pid:038705513 ecl:grn cid:100 byr:1927\n" +
                "iyr:2015\n" +
                "\n" +
                "cid:98 eyr:2022\n" +
                "byr:1957 ecl:grn\n" +
                "hgt:182cm pid:607781478\n" +
                "hcl:#ceb3a1\n" +
                "\n" +
                "eyr:1977 iyr:2021\n" +
                "hgt:178cm cid:186 byr:2026\n" +
                "pid:#b15551 ecl:utc\n" +
                "hcl:z\n" +
                "\n" +
                "pid:334408791\n" +
                "hgt:158cm hcl:#6b5442 cid:83 byr:1983 iyr:2012 ecl:grn\n" +
                "eyr:2030\n" +
                "\n" +
                "eyr:2028 iyr:2015 ecl:amb\n" +
                "pid:352112783\n" +
                "cid:345 byr:1938 hgt:71in\n" +
                "hcl:#6b5442\n" +
                "\n" +
                "byr:2028 pid:380227894 eyr:2025\n" +
                "ecl:blu hgt:189cm hcl:a51656\n" +
                "iyr:1956\n" +
                "\n" +
                "hgt:184cm iyr:2016 ecl:hzl pid:485327910 hcl:#fffffd byr:1970 eyr:2027\n" +
                "\n" +
                "byr:1992 iyr:2018 eyr:2030 hcl:#888785 hgt:168cm pid:535221295 ecl:blu\n" +
                "\n" +
                "hgt:165cm hcl:#fffffd byr:1961 ecl:gry pid:639998127\n" +
                "eyr:2028\n" +
                "iyr:2011\n" +
                "\n" +
                "hgt:74in iyr:2015 cid:284 pid:035643775 byr:1978 hcl:#623a2f\n" +
                "ecl:grn eyr:2023\n" +
                "\n" +
                "byr:1954\n" +
                "ecl:#16e7c4 hgt:164cm\n" +
                "eyr:2029 iyr:2015 pid:377679333 hcl:#a97842 cid:233\n" +
                "\n" +
                "eyr:2026 pid:266604186 byr:1981 ecl:brn\n" +
                "iyr:2012\n" +
                "hgt:156cm\n" +
                "hcl:#c0946f\n" +
                "\n" +
                "cid:189 hcl:z ecl:#40f51a\n" +
                "hgt:180cm iyr:2014 pid:0942329667 byr:1946 eyr:2025\n" +
                "\n" +
                "eyr:2020 hgt:165cm byr:1961\n" +
                "iyr:2013 hcl:#888785 ecl:blu pid:156cm\n" +
                "\n" +
                "cid:126 hcl:#623a2f pid:153152767 hgt:163cm ecl:grn eyr:2030 iyr:2020 byr:1959\n" +
                "\n" +
                "byr:1935\n" +
                "pid:990549858 hcl:#623a2f\n" +
                "ecl:blu iyr:2012 cid:160 eyr:2028 hgt:172cm\n" +
                "\n" +
                "hcl:111b82\n" +
                "byr:1955 pid:765740335 hgt:150cm ecl:amb\n" +
                "iyr:2019 eyr:1937\n" +
                "\n" +
                "hgt:59cm byr:2023 eyr:2032 pid:652161761 cid:61 ecl:brn iyr:2011\n" +
                "hcl:#623a2f\n" +
                "\n" +
                "byr:1951 eyr:2023 iyr:2017\n" +
                "hcl:#18171d\n" +
                "ecl:brn cid:306 pid:446746225 hgt:187cm\n" +
                "\n" +
                "hgt:160cm ecl:blu pid:855958582 byr:1988 hcl:#6f97ba iyr:2016\n" +
                "eyr:2026\n" +
                "\n" +
                "iyr:2010 byr:1948\n" +
                "cid:336 ecl:hzl\n" +
                "eyr:2030\n" +
                "pid:475243853\n" +
                "hgt:175cm\n" +
                "hcl:#ceb3a1\n" +
                "\n" +
                "hgt:168cm eyr:2021 ecl:oth hcl:#229bb0\n" +
                "iyr:2016 byr:1949 pid:720804107\n" +
                "\n" +
                "iyr:2011\n" +
                "eyr:2025\n" +
                "ecl:gry cid:330 byr:1927 pid:699837182\n" +
                "hcl:#b6652a hgt:161cm\n" +
                "\n" +
                "byr:1988 eyr:2026 ecl:gry\n" +
                "hgt:162cm pid:924306872\n" +
                "iyr:2013\n" +
                "hcl:#888785\n" +
                "\n" +
                "byr:1934 ecl:brn pid:0774345729 iyr:1964 hcl:z hgt:170in cid:262\n" +
                "\n" +
                "eyr:2028 byr:1989\n" +
                "iyr:2014\n" +
                "ecl:blu pid:388512489\n" +
                "hcl:#7bc6b9\n" +
                "cid:212\n" +
                "hgt:187cm\n" +
                "\n" +
                "byr:1960 pid:#e494ee eyr:2026 hgt:192cm hcl:a82f5a\n" +
                "iyr:1999 ecl:#89848d\n" +
                "\n" +
                "byr:2006 pid:#3bac86\n" +
                "cid:297\n" +
                "hcl:55d36e\n" +
                "iyr:1985\n" +
                "ecl:#538688\n" +
                "eyr:1923\n" +
                "\n" +
                "ecl:hzl iyr:1925 eyr:2030\n" +
                "pid:1231954396 hgt:154cm byr:2009\n" +
                "hcl:#c0946f\n" +
                "\n" +
                "hgt:63in\n" +
                "pid:229535785 ecl:oth hcl:#9e34cd\n" +
                "iyr:2020\n" +
                "eyr:2021 byr:1943 cid:73\n" +
                "\n" +
                "hgt:63cm hcl:z byr:2029 eyr:1928 pid:4559542479\n" +
                "cid:258 iyr:2024 ecl:#7058ad\n" +
                "\n" +
                "ecl:hzl hcl:z pid:146884476 iyr:2011 cid:158\n" +
                "byr:1991 eyr:2030 hgt:156cm\n" +
                "\n" +
                "byr:2030 iyr:2017 pid:19198146\n" +
                "hcl:#7d3b0c\n" +
                "ecl:#af1431 eyr:2023\n" +
                "hgt:74cm\n" +
                "\n" +
                "hcl:#6b5442 hgt:168cm eyr:2020\n" +
                "cid:260 byr:1920\n" +
                "ecl:hzl\n" +
                "\n" +
                "byr:1971 cid:186 hgt:60 eyr:2022 pid:160cm\n" +
                "hcl:z\n" +
                "iyr:2013\n" +
                "ecl:blu\n" +
                "\n" +
                "hcl:#7d3b0c cid:218 eyr:2022 pid:015062066 ecl:hzl iyr:2010 hgt:170cm byr:2001\n" +
                "\n" +
                "iyr:1984 byr:2027\n" +
                "eyr:2033\n" +
                "hcl:94d9ab hgt:148 ecl:gmt\n" +
                "cid:288\n" +
                "pid:160cm\n" +
                "\n" +
                "hcl:#74c9e7 eyr:2026 hgt:168cm byr:1994 ecl:brn pid:651587465\n" +
                "\n" +
                "hgt:160cm\n" +
                "ecl:gry cid:182 byr:1929 pid:890454205 hcl:#efcc98 eyr:2029 iyr:2020\n" +
                "\n" +
                "ecl:brn hgt:156in\n" +
                "eyr:2022\n" +
                "cid:289 iyr:2022 hcl:e34ec4 pid:#206e1c byr:1938\n" +
                "\n" +
                "eyr:2030\n" +
                "pid:99239063 cid:166\n" +
                "hgt:153cm hcl:0a3633 byr:1990 iyr:2024 ecl:grn\n" +
                "\n" +
                "byr:2019 hgt:189cm hcl:#cfa07d iyr:1927 ecl:#bafabd pid:161cm eyr:2024\n" +
                "\n" +
                "hcl:#ceb3a1 iyr:2010\n" +
                "hgt:163cm eyr:2020\n" +
                "pid:948123697 ecl:brn byr:1973\n" +
                "\n" +
                "pid:691623749 iyr:2016 hcl:#18171d byr:1972 eyr:2030\n" +
                "hgt:173cm ecl:hzl\n" +
                "\n" +
                "hcl:#ceb3a1 cid:271\n" +
                "iyr:2010 byr:1977 hgt:161cm\n" +
                "eyr:2022\n" +
                "pid:460185976 ecl:hzl\n" +
                "\n" +
                "eyr:2028 ecl:hzl cid:98\n" +
                "pid:828517281 hgt:154cm\n" +
                "iyr:2016 hcl:#866857 byr:1924\n" +
                "\n" +
                "hgt:99\n" +
                "iyr:2030 byr:2003 eyr:2039 pid:184cm ecl:lzr cid:71\n" +
                "hcl:z\n" +
                "\n" +
                "eyr:2029 pid:864807599\n" +
                "iyr:2013 hcl:#866857 ecl:grn byr:1961 hgt:185cm\n" +
                "\n" +
                "hcl:#866857\n" +
                "hgt:66in ecl:oth iyr:2018\n" +
                "eyr:2026 cid:170 byr:1999 pid:538451102\n" +
                "\n" +
                "iyr:2024 byr:2015 cid:271 pid:69951601 hgt:190cm\n" +
                "ecl:xry\n" +
                "eyr:2003\n" +
                "hcl:#c0946f\n" +
                "\n" +
                "hgt:178cm hcl:#ceb3a1 byr:1942\n" +
                "pid:583281865 iyr:2015 eyr:2020\n" +
                "ecl:grn\n" +
                "\n" +
                "eyr:2020 hcl:#866857 ecl:oth hgt:153cm cid:212 byr:1972 iyr:2012 pid:198849319\n" +
                "\n" +
                "ecl:blu\n" +
                "cid:222 hgt:174cm hcl:#866857\n" +
                "byr:1971 iyr:2016 eyr:2030\n" +
                "\n" +
                "ecl:blu pid:521480106\n" +
                "iyr:2020\n" +
                "eyr:2027 byr:1942\n" +
                "hcl:#733820 hgt:153cm cid:106\n" +
                "\n" +
                "cid:57 pid:685649434\n" +
                "eyr:2026\n" +
                "hcl:#efcc98 ecl:grn iyr:2013\n" +
                "byr:1968 hgt:157cm\n" +
                "\n" +
                "cid:63 pid:195592844 hcl:#efcc98\n" +
                "byr:1980 ecl:gry iyr:2016\n" +
                "eyr:2023\n" +
                "hgt:178cm\n" +
                "\n" +
                "hcl:z\n" +
                "byr:2024 hgt:179cm\n" +
                "iyr:2017\n" +
                "eyr:1998 ecl:#d087a7\n" +
                "\n" +
                "pid:673581655 eyr:2023\n" +
                "byr:1924 hcl:#18171d ecl:blu hgt:187cm iyr:2015\n" +
                "cid:69\n" +
                "\n" +
                "byr:1979 eyr:2020 pid:925293477 ecl:amb cid:145 hcl:#1fc76d hgt:188cm iyr:2013\n" +
                "\n" +
                "pid:833495286\n" +
                "hcl:#cfa07d ecl:brn\n" +
                "byr:1993 eyr:2020 cid:209\n" +
                "hgt:165cm iyr:2018\n" +
                "\n" +
                "hgt:181cm\n" +
                "hcl:#efcc98 pid:264709463\n" +
                "iyr:2019\n" +
                "eyr:2026\n" +
                "cid:313 byr:1926 ecl:gry\n" +
                "\n" +
                "pid:798909144 iyr:2015 ecl:brn hgt:183cm hcl:#623a2f byr:1979\n" +
                "eyr:2023\n" +
                "\n" +
                "cid:257\n" +
                "ecl:grn pid:203787314 hcl:#fffffd iyr:2020 hgt:192cm byr:1964\n" +
                "\n" +
                "pid:15955243\n" +
                "eyr:1962\n" +
                "byr:2012 hgt:155cm iyr:2025 hcl:z\n" +
                "\n" +
                "cid:126\n" +
                "hgt:156cm\n" +
                "byr:1936 pid:495593265\n" +
                "ecl:brn hcl:ee357b iyr:2030 eyr:2014\n" +
                "\n" +
                "pid:182cm eyr:2022 ecl:#c8bb8a\n" +
                "iyr:2021 byr:1922 cid:270 hcl:#866857 hgt:190cm\n" +
                "\n" +
                "eyr:2030\n" +
                "byr:1963 cid:224 ecl:gry iyr:2020 hgt:192cm\n" +
                "hcl:#8117b1 pid:845227725\n" +
                "\n" +
                "byr:2028 pid:168cm eyr:1989 ecl:blu hcl:311389 hgt:173cm cid:227\n" +
                "iyr:2015\n" +
                "\n" +
                "byr:1949 hcl:#a97842 hgt:162cm\n" +
                "pid:100263539 eyr:2027\n" +
                "ecl:grn iyr:2015\n" +
                "\n" +
                "ecl:#6f9669 eyr:2033 byr:2003 hcl:z iyr:2019 pid:223282429\n" +
                "hgt:172\n" +
                "\n" +
                "pid:#8bc2c0 hgt:74cm ecl:zzz hcl:5afd12 eyr:1922\n" +
                "byr:2019 iyr:1924 cid:50\n" +
                "\n" +
                "hcl:#66518f hgt:187cm byr:1989\n" +
                "eyr:2027 iyr:2018 ecl:blu pid:656263178\n" +
                "\n" +
                "pid:257605814 iyr:2013 eyr:2026 ecl:grn hgt:170cm byr:2018 hcl:e9d195\n" +
                "\n" +
                "ecl:grt byr:2010 eyr:2033\n" +
                "pid:35619145\n" +
                "iyr:2025\n" +
                "hgt:64cm hcl:z\n" +
                "cid:221\n" +
                "\n" +
                "eyr:1997 pid:221307345 hgt:120\n" +
                "iyr:2019 ecl:zzz\n" +
                "byr:2009\n" +
                "hcl:#fffffd\n" +
                "\n" +
                "hgt:192cm byr:1932 cid:213 hcl:#ceb3a1\n" +
                "ecl:oth iyr:2018\n" +
                "eyr:2023 pid:232126505\n" +
                "\n" +
                "iyr:2020 cid:225\n" +
                "eyr:2025 pid:456238536 byr:1932 hcl:#fffffd ecl:oth\n" +
                "hgt:170cm\n" +
                "\n" +
                "eyr:2023 pid:113720753 hgt:173cm hcl:#efcc98\n" +
                "ecl:blu\n" +
                "byr:1977\n" +
                "iyr:2010\n" +
                "\n" +
                "hcl:#866857 pid:240698984 byr:1973\n" +
                "ecl:amb iyr:2014 hgt:159cm eyr:2020\n" +
                "\n" +
                "eyr:2026\n" +
                "iyr:2019 pid:150506583 byr:1984 cid:249\n" +
                "ecl:brn hgt:176cm\n" +
                "hcl:#18171d\n" +
                "\n" +
                "iyr:2012\n" +
                "hgt:189cm byr:1970\n" +
                "pid:152682317 eyr:2025 cid:315 ecl:oth hcl:#6b5442\n" +
                "\n" +
                "hgt:167cm eyr:1923 hcl:4a53cb pid:392236104 iyr:2018 ecl:gry\n" +
                "byr:1922\n" +
                "\n" +
                "byr:1966 hgt:191cm\n" +
                "iyr:2011 cid:167\n" +
                "ecl:brn eyr:2024 hcl:#29000d\n" +
                "\n" +
                "byr:1964 hgt:177\n" +
                "eyr:2037 pid:4494972428 hcl:#7d3b0c ecl:utc cid:205 iyr:2019\n" +
                "\n" +
                "hcl:#cfa07d iyr:2028 pid:165cm ecl:#e2a3e0\n" +
                "cid:147\n" +
                "eyr:2025\n" +
                "hgt:169in byr:2010\n" +
                "\n" +
                "hgt:162cm\n" +
                "hcl:#866857\n" +
                "eyr:2024 byr:1962 iyr:2020\n" +
                "pid:246010906\n" +
                "ecl:oth\n" +
                "\n" +
                "pid:145361253 ecl:brn iyr:2019 eyr:2025\n" +
                "hcl:#ceb3a1 hgt:164cm byr:1938\n" +
                "\n" +
                "hgt:157cm ecl:#f6feaa iyr:2015\n" +
                "hcl:#623a2f\n" +
                "cid:290 eyr:2034\n" +
                "pid:058787629\n" +
                "\n" +
                "hcl:#ceb3a1 iyr:2011\n" +
                "pid:468547313 cid:175 byr:1991 eyr:2021 hgt:158cm\n" +
                "ecl:blu\n" +
                "\n" +
                "ecl:hzl eyr:2026 pid:448134141 hgt:186cm iyr:2016 byr:1929 hcl:#c0946f\n" +
                "\n" +
                "hgt:64cm eyr:2027\n" +
                "ecl:#277bd0 hcl:df2be7\n" +
                "iyr:2023\n" +
                "pid:167286554\n" +
                "byr:2004\n" +
                "\n" +
                "pid:739664020 eyr:2026 hgt:61in\n" +
                "iyr:2011 byr:1959 ecl:grn\n" +
                "hcl:#602927\n" +
                "\n" +
                "eyr:2039 hgt:183cm hcl:z pid:5208130216\n" +
                "ecl:blu\n" +
                "cid:161 iyr:1932 byr:2004\n" +
                "\n" +
                "iyr:2015 pid:509173428 eyr:2030 ecl:#14471f hcl:z hgt:177in byr:1994\n" +
                "\n" +
                "byr:1951\n" +
                "iyr:2012 hcl:#733820\n" +
                "pid:799059999 hgt:70in eyr:2026 ecl:hzl\n" +
                "\n" +
                "eyr:2028 byr:1925\n" +
                "hgt:181cm\n" +
                "ecl:grn\n" +
                "iyr:2016\n" +
                "hcl:#cfa07d pid:558448804\n" +
                "\n" +
                "pid:675014385 iyr:2012 ecl:oth hgt:183cm\n" +
                "hcl:#623a2f byr:1997\n" +
                "eyr:2026 cid:311\n" +
                "\n" +
                "eyr:1972 hcl:c452d2\n" +
                "ecl:gmt\n" +
                "byr:2010 iyr:2015\n" +
                "hgt:66cm cid:266\n" +
                "pid:021900882\n" +
                "\n" +
                "ecl:gry hgt:65in cid:182 hcl:#c0946f\n" +
                "pid:558235233\n" +
                "eyr:2027 byr:1946 iyr:2017\n" +
                "\n" +
                "hcl:#b6652a pid:846441761 iyr:1971 hgt:59cm eyr:2027 byr:2010 ecl:amb cid:144\n" +
                "\n" +
                "cid:77 hgt:180in eyr:2024\n" +
                "hcl:b6c2c6 pid:159cm iyr:2002\n" +
                "ecl:#62e506 byr:1976\n" +
                "\n" +
                "iyr:1969 eyr:2024 cid:143 pid:#f31765 ecl:brn\n" +
                "hgt:68cm hcl:7f9598 byr:1949\n" +
                "\n" +
                "byr:1964\n" +
                "hcl:#341e13\n" +
                "ecl:gry\n" +
                "hgt:168cm eyr:2028\n" +
                "iyr:2012 pid:714678484\n" +
                "\n" +
                "hgt:185cm eyr:2028\n" +
                "hcl:#b6652a byr:1945 iyr:2012 ecl:hzl\n" +
                "\n" +
                "iyr:2015 hgt:191cm\n" +
                "ecl:blu hcl:#888785 pid:206356787\n" +
                "eyr:2021 byr:1920\n" +
                "\n" +
                "eyr:1937\n" +
                "hcl:b3eb9c hgt:175cm\n" +
                "iyr:2012 ecl:brn pid:62490997 cid:267\n" +
                "byr:2024\n" +
                "\n" +
                "hcl:#866857\n" +
                "byr:1960\n" +
                "pid:021105433\n" +
                "hgt:174cm eyr:2022 iyr:2017\n" +
                "ecl:blu cid:123\n" +
                "\n" +
                "hcl:#ceb3a1 byr:1976 pid:306207321\n" +
                "iyr:2019\n" +
                "cid:262 hgt:175cm\n" +
                "eyr:2025 ecl:oth\n" +
                "\n" +
                "byr:1945\n" +
                "cid:346 eyr:2030 hcl:#1f6f6f iyr:2013\n" +
                "hgt:65in pid:857729755\n" +
                "ecl:blu\n" +
                "\n" +
                "byr:1934 ecl:oth hgt:174cm\n" +
                "eyr:2030\n" +
                "cid:263 hcl:#47e20e pid:545880650\n" +
                "\n" +
                "pid:190920088 byr:1995\n" +
                "hcl:b4f162 iyr:2019 ecl:gry eyr:2020 hgt:176cm\n" +
                "\n" +
                "byr:1984 hcl:#7d3b0c\n" +
                "pid:947573713 hgt:154cm\n" +
                "ecl:blu\n" +
                "eyr:2023\n" +
                "iyr:2017\n" +
                "\n" +
                "hcl:#ceb3a1 pid:645117349 cid:213\n" +
                "eyr:2022 ecl:brn\n" +
                "iyr:2017 hgt:151cm byr:1997\n" +
                "\n" +
                "byr:1929 hcl:#18171d hgt:184cm pid:378639521\n" +
                "ecl:amb iyr:2018\n" +
                "eyr:2022\n" +
                "\n" +
                "pid:567411452 hgt:158cm byr:1998 eyr:2030 iyr:2013 hcl:#fffffd\n" +
                "ecl:grn\n" +
                "\n" +
                "iyr:1962\n" +
                "pid:184cm\n" +
                "eyr:2034 cid:62 ecl:gry hcl:z hgt:156in\n" +
                "\n" +
                "eyr:2022 byr:2015 pid:193cm ecl:#ca25ab\n" +
                "hcl:eb0dfc cid:136\n" +
                "hgt:150cm\n" +
                "iyr:1977\n" +
                "\n" +
                "pid:087678152\n" +
                "hcl:#ecdb8b\n" +
                "hgt:162cm iyr:2015\n" +
                "eyr:2024\n" +
                "byr:1939\n" +
                "ecl:grn\n" +
                "\n" +
                "eyr:2024 hgt:150cm iyr:2023 ecl:#ca3855 hcl:#888785 byr:1943\n" +
                "pid:4402658120\n" +
                "\n" +
                "pid:107396492 hcl:#341e13\n" +
                "hgt:145 ecl:oth iyr:2013\n" +
                "eyr:2025 cid:128 byr:2023\n" +
                "\n" +
                "eyr:2020 hgt:167cm byr:1997 hcl:#888785\n" +
                "ecl:oth pid:609333522 iyr:2017\n" +
                "\n" +
                "pid:172cm\n" +
                "eyr:1930 iyr:1966 ecl:#f98bd9 hgt:179in hcl:a1d424\n" +
                "\n" +
                "ecl:hzl byr:1924 iyr:2018 eyr:2020\n" +
                "pid:505733566\n" +
                "hcl:#733820\n" +
                "hgt:151cm\n" +
                "\n" +
                "eyr:2011 pid:176cm hgt:163in iyr:1964\n" +
                "hcl:z ecl:#9e90ad byr:2010\n" +
                "\n" +
                "ecl:brn iyr:2011 pid:932000043 byr:1995 eyr:2025 hgt:150cm\n" +
                "hcl:#6b5442\n" +
                "\n" +
                "pid:347820679\n" +
                "iyr:2010 ecl:#aa4902 hcl:56faf0 hgt:70cm byr:1923 eyr:2024\n" +
                "\n" +
                "ecl:blu\n" +
                "hgt:160cm iyr:2015 pid:706725204 byr:1987 eyr:2030 hcl:#cfa07d\n" +
                "\n" +
                "hcl:#763a5b iyr:2011\n" +
                "byr:1965 pid:834192733\n" +
                "cid:302 ecl:blu eyr:2028 hgt:170cm\n" +
                "\n" +
                "byr:1967 hgt:193cm\n" +
                "ecl:hzl\n" +
                "pid:598436934 cid:262\n" +
                "iyr:2014 hcl:#b6652a eyr:2021\n" +
                "\n" +
                "pid:336728648\n" +
                "eyr:2030 hcl:#888785\n" +
                "hgt:150cm ecl:hzl byr:1926\n" +
                "iyr:2015\n" +
                "\n" +
                "pid:073366341 byr:1984 hcl:#cfa07d iyr:2019 hgt:178cm ecl:grn eyr:2026\n" +
                "\n" +
                "iyr:1923 pid:19933565 ecl:#16b3c1 hgt:162\n" +
                "eyr:1945 hcl:e0e20c\n" +
                "byr:2028\n" +
                "\n" +
                "hgt:159in\n" +
                "pid:171cm eyr:2023 iyr:2022 ecl:#c073e6 hcl:22ed05 byr:2011\n" +
                "\n" +
                "byr:2003 eyr:2022\n" +
                "cid:336 ecl:grt\n" +
                "iyr:2020 hgt:156cm\n" +
                "hcl:#c0946f pid:716113144\n" +
                "\n" +
                "ecl:hzl\n" +
                "iyr:2019 hgt:171cm hcl:#9855d4\n" +
                "byr:1974\n" +
                "eyr:2025 pid:260661320\n" +
                "\n" +
                "hgt:165cm byr:2016 pid:203313454\n" +
                "iyr:2011\n" +
                "hcl:z ecl:blu eyr:2023\n" +
                "\n" +
                "eyr:2016\n" +
                "hgt:182cm iyr:2029 byr:2004\n" +
                "ecl:gmt hcl:25d3a1\n" +
                "pid:4435010716\n" +
                "\n" +
                "ecl:blu\n" +
                "pid:159928755 hgt:177 hcl:74fd3f eyr:2023 cid:244 byr:1956\n" +
                "iyr:2016\n" +
                "\n" +
                "hcl:#c5c154 iyr:2011 ecl:gry byr:1971 hgt:75in cid:251\n" +
                "eyr:2025\n" +
                "\n" +
                "eyr:2023\n" +
                "hgt:155cm byr:1943 iyr:2020 ecl:amb hcl:#ceb3a1 pid:591194126\n" +
                "\n" +
                "cid:123\n" +
                "byr:1950 iyr:2022 hgt:154cm ecl:hzl pid:555951199 hcl:#efcc98 eyr:2022\n" +
                "\n" +
                "cid:145 iyr:2028\n" +
                "hgt:163\n" +
                "byr:2007 ecl:#ca0e61 pid:#b57087 eyr:1985 hcl:#b6652a\n" +
                "\n" +
                "ecl:utc\n" +
                "iyr:1953 eyr:2034 hcl:#602927\n" +
                "cid:150 pid:166cm hgt:72cm byr:2003\n" +
                "\n" +
                "iyr:2012 pid:585191659\n" +
                "byr:1959 eyr:2027\n" +
                "hgt:150cm ecl:blu hcl:#888785\n" +
                "\n" +
                "ecl:#483899 eyr:2032 pid:#4d59f7 iyr:2020 byr:2005 hcl:a8a13c hgt:140\n" +
                "\n" +
                "ecl:brn pid:#8d9fe0 cid:265 byr:2029 hgt:68cm iyr:1989 hcl:4df783 eyr:1990\n" +
                "\n" +
                "cid:110 hgt:165cm\n" +
                "ecl:grn\n" +
                "iyr:2017 eyr:2025 byr:1923\n" +
                "\n" +
                "byr:1986 iyr:2020 hgt:69in pid:815979778 hcl:#ceb3a1 eyr:2027 ecl:blu\n" +
                "\n" +
                "pid:345227220\n" +
                "eyr:2030\n" +
                "byr:1954 ecl:hzl hcl:#733820 hgt:151cm iyr:2016\n" +
                "\n" +
                "hgt:152 byr:2016 ecl:grt hcl:z eyr:1994 pid:463925189\n" +
                "iyr:2013\n" +
                "\n" +
                "hcl:#341e13\n" +
                "hgt:169cm byr:1990 iyr:2015\n" +
                "ecl:blu\n" +
                "eyr:2034 pid:120750202\n" +
                "\n" +
                "iyr:2020\n" +
                "pid:589274468 byr:1995 ecl:blu eyr:2025 hgt:168cm hcl:#888785\n" +
                "\n" +
                "hcl:#888785\n" +
                "hgt:169cm iyr:2016\n" +
                "byr:1930\n" +
                "ecl:grn pid:864871732 eyr:2022\n" +
                "\n" +
                "eyr:2021 cid:73 hgt:186cm hcl:#8092f6 byr:1957 pid:151353277 ecl:blu iyr:2018\n" +
                "\n" +
                "hcl:5afb32 byr:2027 pid:179cm\n" +
                "cid:222 hgt:59cm ecl:grt eyr:2040 iyr:1980\n" +
                "\n" +
                "hcl:#a97842 pid:403342198 eyr:2026\n" +
                "byr:1976 ecl:gry hgt:150cm\n" +
                "iyr:2015\n" +
                "\n" +
                "hgt:63in eyr:2023 hcl:#6b5442 pid:371994667 iyr:2020 byr:1991 ecl:gry\n" +
                "\n" +
                "pid:247978507\n" +
                "hgt:175cm iyr:2016 eyr:2022\n" +
                "byr:1945 hcl:#b6652a ecl:gry\n" +
                "\n" +
                "hgt:150cm cid:254 hcl:#18171d ecl:blu eyr:2030\n" +
                "byr:1922\n" +
                "pid:450204714 iyr:2015\n" +
                "\n" +
                "iyr:2016 pid:470585547\n" +
                "hgt:60in\n" +
                "eyr:2024 byr:1946\n" +
                "ecl:oth hcl:#b6652a\n" +
                "\n" +
                "iyr:2020 eyr:2026\n" +
                "hcl:#cfa07d\n" +
                "pid:524717559 hgt:99\n" +
                "cid:303 byr:1967 ecl:amb\n" +
                "\n" +
                "cid:178 byr:2021 hcl:7234f4 hgt:192in eyr:2038 iyr:2020 pid:466801711 ecl:amb\n" +
                "\n" +
                "pid:597934488 iyr:2011 cid:336 hcl:#81434f\n" +
                "ecl:grt hgt:185cm eyr:2034\n" +
                "byr:2014\n" +
                "\n" +
                "eyr:2038\n" +
                "byr:2017 hgt:70cm cid:283\n" +
                "ecl:brn pid:392669975 iyr:2013 hcl:#602927\n" +
                "\n" +
                "pid:#c85b65 hgt:60cm iyr:2001 eyr:2035 hcl:e28fae\n" +
                "ecl:#32a45c byr:1924\n" +
                "\n" +
                "iyr:2011 byr:1945 hgt:164cm ecl:gry eyr:2029 hcl:#18171d\n" +
                "pid:402905843\n" +
                "\n" +
                "pid:5602590426 byr:2013 eyr:2024\n" +
                "ecl:zzz iyr:2014 hgt:173cm\n" +
                "hcl:#733820\n" +
                "\n" +
                "ecl:hzl eyr:1964\n" +
                "pid:508473248\n" +
                "byr:1961 hgt:181cm iyr:2020\n" +
                "hcl:#623a2f\n" +
                "\n" +
                "hcl:z hgt:121 pid:635654838 eyr:2020 iyr:1968\n" +
                "byr:1954\n" +
                "\n" +
                "byr:1974 pid:759133744\n" +
                "iyr:2010 eyr:2027\n" +
                "cid:266 ecl:hzl\n" +
                "hgt:153cm\n" +
                "\n" +
                "ecl:oth byr:1960\n" +
                "eyr:2022\n" +
                "iyr:2014\n" +
                "hgt:62in hcl:#623a2f pid:155340768\n" +
                "\n" +
                "hgt:187cm\n" +
                "hcl:#866857 pid:725526503 cid:134 iyr:2017 ecl:grn\n" +
                "byr:1982 eyr:2020\n" +
                "\n" +
                "hgt:154cm byr:1953\n" +
                "ecl:blu pid:212064297\n" +
                "cid:69 eyr:2022\n" +
                "hcl:#c0946f iyr:2015\n" +
                "\n" +
                "ecl:gry hgt:183cm iyr:2017 pid:995219023 eyr:2025\n" +
                "byr:1960 hcl:#7d3b0c\n" +
                "\n" +
                "byr:1935 ecl:oth cid:235 pid:978368915\n" +
                "hcl:#b6652a\n" +
                "iyr:2019 hgt:69in eyr:2028\n" +
                "\n" +
                "iyr:2005\n" +
                "eyr:2028\n" +
                "hgt:192in hcl:#9ced60 byr:2004\n" +
                "pid:102299023\n" +
                "cid:348 ecl:hzl\n" +
                "\n" +
                "hcl:6cbe91 pid:191cm iyr:1962\n" +
                "byr:2007 hgt:192in eyr:1963\n" +
                "\n" +
                "pid:020385831 hgt:173cm\n" +
                "ecl:amb hcl:fdbb66 cid:287\n" +
                "eyr:2034\n" +
                "byr:2024 iyr:2018\n" +
                "\n" +
                "eyr:2024\n" +
                "byr:1952 hgt:186cm cid:250\n" +
                "pid:852070008 ecl:blu\n" +
                "hcl:#c0946f iyr:2010\n" +
                "\n" +
                "ecl:#914e86 pid:164cm hgt:170cm iyr:2011\n" +
                "byr:2014\n" +
                "eyr:2026 hcl:z\n" +
                "\n" +
                "byr:1952 hgt:176in\n" +
                "hcl:#e49400\n" +
                "pid:011105160\n" +
                "eyr:2026 cid:103 ecl:oth iyr:2011\n" +
                "\n" +
                "ecl:#362113 hgt:155in\n" +
                "pid:859337122 cid:133\n" +
                "eyr:2025 byr:1997 iyr:2012\n" +
                "\n" +
                "ecl:hzl eyr:2025 iyr:2013\n" +
                "pid:669359650 byr:1922 hcl:#efcc98 cid:149 hgt:169cm\n" +
                "\n" +
                "iyr:2028 hgt:177in\n" +
                "cid:75\n" +
                "eyr:2036 byr:2007 pid:48265132\n" +
                "ecl:zzz hcl:z\n" +
                "\n" +
                "hgt:66in eyr:2030\n" +
                "hcl:#623a2f iyr:2010 pid:458699137\n" +
                "byr:1980\n" +
                "ecl:amb\n" +
                "\n" +
                "hgt:171cm ecl:amb iyr:2011 hcl:#888785 byr:1923 eyr:2020\n" +
                "pid:312162952\n" +
                "\n" +
                "byr:1963\n" +
                "hcl:#18171d pid:316505921 ecl:blu iyr:2017\n" +
                "hgt:155cm eyr:2029\n" +
                "\n" +
                "ecl:gry\n" +
                "byr:1973 iyr:2011\n" +
                "pid:479606625 eyr:2028\n" +
                "hcl:#888785 cid:108 hgt:160cm";
    }

}