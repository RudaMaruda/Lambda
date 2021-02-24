package pl.sda.zdjavapol73.tasks.functional;

import pl.sda.zdjavapol73.api.Task;

import java.util.*;

// all transformators should change content to camelCase
// i.e. SDA -> sDa
// Arek -> aReK
// test -> tEsT
public class FunctionalIndividual implements Task {
    @Override
    public void run() {
        innerClassInd();
        anonymousInd();
        lambdaInd();
    }


    private void innerClassInd() {
        System.out.println("Hello from " + getClass().getSimpleName());
        final TransformableString transformableString = new TransformableString("sdaAcademy");
        System.out.println("String before transformation: " + transformableString);
        final TransformableString transformedString = transformableString.transss(new MyIndywidualTranformator());
        System.out.println("String after transformation: " + transformedString);

    }

    // TODO: implement StringTransformator using Anonymous class
    private void anonymousInd() {
        System.out.println("Hello from " + getClass().getSimpleName());
        final TransformableString transformableString = new TransformableString("ArekAptewicz");
        System.out.println("String before transformation: " + transformableString);
        final TransformableString transformedString = transformableString.transss(new StringTransformator() {
            @Override
            public String transform(String stringToTransform) {
                return toCamelCase(stringToTransform);
            }

        });
        System.out.println("String after transformation: " + transformedString);

    }

    // TODO: use lambda

    private void lambdaInd() {
        System.out.println("Hello from " + getClass().getSimpleName());
        final TransformableString transformableString = new TransformableString("TestForHomework");
        System.out.println("String before transformation: " + transformableString);
        final TransformableString transformedString = transformableString.transss((arg) -> toCamelCase(arg));
        System.out.println("String after transformation: " + transformedString);

    }



    static String toCamelCase(String s) {

        String sLowerCase = s.toLowerCase();
        char[] myArray = sLowerCase.toCharArray();
        String finalTekst = "";
        String oneSign = "";

        for (int i = 0; i < myArray.length; i++) {
            if (i % 2 != 0) {
                oneSign = String.valueOf(myArray[i]);
                oneSign = oneSign.toUpperCase();
            } else {
                oneSign = String.valueOf(myArray[i]);
            }
            finalTekst = finalTekst + oneSign;
        }
        return finalTekst;
    }



}


// TODO: create class which implements StringTransformator
class MyIndywidualTranformator implements StringTransformator {

    @Override
    public String transform(String s) {

        String sLowerCase = s.toLowerCase();
        char[] myArray = sLowerCase.toCharArray();
        String finalTekst = " ";
        String oneSign = "";

        for (int i = 0; i < myArray.length; i++) {
            if (i % 2 != 0) {
                oneSign = String.valueOf(myArray[i]);
                oneSign = oneSign.toUpperCase();
            } else {
                oneSign = String.valueOf(myArray[i]);
            }
            finalTekst = finalTekst + oneSign;
        }
        return finalTekst;
    }

}
