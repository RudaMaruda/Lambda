package pl.sda.zdjavapol73.tasks.functional;

import pl.sda.zdjavapol73.api.Task;

public class FunctionalTask implements Task {
    @Override
    public void run() {
        innerClass();
        anonymous();
        lambda();
    }

    private void innerClass() {
        System.out.println("Hello from " + getClass().getSimpleName());
        final TransformableString transformableString = new TransformableString("SDA");
        System.out.println("String before transformation: " + transformableString);
        final TransformableString transformedString = transformableString.transss(new MyTransformator());
        System.out.println("String after transformation: " + transformedString);
    }

    private void anonymous() {
        System.out.println("Hello from " + getClass().getSimpleName());
        final TransformableString transformableString = new TransformableString("SDA");
        System.out.println("String before transformation: " + transformableString);
        final TransformableString transformedString = transformableString.transss(new StringTransformator() {
            @Override
            public String transform(String stringToTransform) {
                return stringToTransform + "!!!";
            }
        });
        System.out.println("String after transformation: " + transformedString);
    }

    private void lambda() {
        // lambda syntax
        // (args...) -> { body }/expression
        final StringTransformator transformator = (String arg) -> { return arg + "!!!"; };
        final StringTransformator transformator1 = (String arg) -> arg + "!!!";
        final StringTransformator transformator2 = (arg) -> arg + "!!!";

        final StringTransformator differentTransformator = String::toString;
        final StringTransformator differentTransformator1 = (arg) -> arg.toString();

        System.out.println("Hello from " + getClass().getSimpleName());
        final TransformableString transformableString = new TransformableString("SDA");
        System.out.println("String before transformation: " + transformableString);
        final TransformableString transformedString = transformableString.transss((arg) -> arg + "!!!");
        System.out.println("String after transformation: " + transformedString);
    }
}
// wewnetrzna klasa ktora implementuje Interface, ale w obowiazku jej jest nadpisac ta metode
// tzn nadac jej cialo metody
// to nadpisanie po prostu do tektu dodaje !!! i tyle
class MyTransformator implements StringTransformator {

    @Override
    public String transform(String stringToTransform) {
        return stringToTransform + "!!!";
    }
}
