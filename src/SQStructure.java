import java.util.Arrays;
import java.util.Optional;

public abstract class SQStructure {

    final static int step = 10;
    int[] tableau = new int[step];
    int nbElement = 0;

    SQStructure() {
        this(step);
    }

    SQStructure(int size) {
        tableau = new int[size];
    }

    /**
     * Méthode d'empilement d'une valeur
     * @param element valeur à empiler
     */
    abstract void Push(int element);// {}

    /**
     * Méthode de dépilement d'une valeur
     * @return retourne un Optional qui contient éventuellement la valeur dépilé si il y a au mois un élément dans le tableau
     */
    abstract Optional Pop(); // {}

    void Clear() {
        tableau = new int[step];
        nbElement = 0;
    }

    final int Count() {
        return nbElement;
    }

    final int Size() {
        return tableau.length;
    }

    @Override
    public String toString() {
        return "SQStructure{" +
                "tableau=" + Arrays.toString(tableau) +
                ", nbElement=" + nbElement +
                '}';
    }
}
