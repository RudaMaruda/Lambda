package pl.sda.zdjavapol73.tasks.functional;

@FunctionalInterface
public interface StringTransformator {

    // metoda publiczna (to domyslnie) o nazwie transform, ktora przyjmuje argumenty
    // typu String
    //ta metoda nie ma ciala poniewaz znajduje sie w interface
    String transform(String stringToTransform);
}
