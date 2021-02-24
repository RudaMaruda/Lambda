package pl.sda.zdjavapol73;

public class Test {
    public static void main(String[] args) {


        String s = "toPrzykladowytekst";
        String sCamel = toCamelCase(s);
        System.out.println(sCamel);


    }

    static String toCamelCase(String s) {

        String sLowerCase = s.toLowerCase();
        char[] myArray = sLowerCase.toCharArray();
        String finalTekst = " ";
        String pojedyncza = "";

        for (int i = 0; i < myArray.length; i++) {
            if (i % 2 != 0) {
                pojedyncza = String.valueOf(myArray[i]);
                pojedyncza = pojedyncza.toUpperCase();
            } else {
                pojedyncza = String.valueOf(myArray[i]);
            }
            finalTekst = finalTekst + pojedyncza;
        }
        return finalTekst;
    }


}
