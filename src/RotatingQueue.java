
import java.util.Optional;

public class RotatingQueue extends Queue {
    /**
     * Méthode d'empilement d'une valeur
     *
     * @param element valeur à empiler
     */
    @Override
    void Push(int element) {
        if (Count() == Size()) {
            RedimTableau(Count() + step);
        }

        if (pushPointer == Size()) {
            pushPointer = 0;
        }

        tableau[pushPointer++] = element;
        nbElement++;
    }

    private void RedimTableau(int taille) {

        int[] temp = new int[taille];

        if (popPointer < pushPointer){
            System.arraycopy(tableau, popPointer, temp, 0, nbElement);
        }

        else{
            int borne = Size() - popPointer;
            System.arraycopy(tableau, popPointer, temp, 0, borne);
            System.arraycopy(tableau, 0, temp, borne, pushPointer);
    }
        tableau = temp;
        popPointer = 0;
        pushPointer = nbElement;
    }

    /**
     * Méthode de dépilement d'une valeur
     *
     * @return retourne un Optional qui contient éventuellement la valeur dépilé si il y a au mois un élément dans le tableau
     */
    @Override
    Optional Pop() {
        if (Count() == 0){
            Clear();
            return Optional.empty();
        }

        if (Count() <= Size() - step) {
            RedimTableau(Size() - (step / 2));
        }

        var temp = tableau[popPointer];
        tableau[popPointer++] = 0;
        if (popPointer == Size()){
            popPointer = 0;
        }
        nbElement--;
        return Optional.of(temp);
    }
}
