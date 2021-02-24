package pl.sda.zdjavapol73.tasks.functional;


//klasa dotyczaca przerabiania stringa
public class TransformableString {

    //prywatne pole content typu String
    private final String content;


    // konstruktor parametryczny z polem content
    public TransformableString(String content) {
        this.content = content;
    }

    //metoda o nazwie transs, przyjmuje argumenty typu Interface StringTransorm
    // transformator - tylko nazwa zmiennej

    // metoda ta wg interface przyjmuje argumenty typu string
    // zwracajaca nowy obiekt typu TransfString
    public TransformableString transss(StringTransformator transformator) {

        return new TransformableString(transformator.transform(content));
    }


    // nadpisanie metody to string ktora zwraca content
    @Override
    public String toString() {
        return content;
    }
}
