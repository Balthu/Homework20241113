import java.util.Arrays;
import java.util.Optional;

public class Queue extends SQStructure{
    int pushPointer = 0, popPointer = 0;

    /**
     * Méthode d'empilement d'une valeur
     *
     * @param element valeur à empiler
     */
    @Override
    void Push(int element) {
        if (pushPointer == Size()) {
            RedimTableau(Count() + step);
        }
        tableau[pushPointer++] = element;
        nbElement++;
    }

    private void RedimTableau(int taille) {
        tableau = Arrays.copyOfRange(tableau, popPointer, taille + popPointer);
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
        if (nbElement == 0) {
            pushPointer = popPointer = 0;
            return Optional.empty();
        } else {
            if (Count() <= Size() - step) {
                RedimTableau(Size() - step / 2);
            }
            var retour = tableau[popPointer];
            tableau[popPointer++] = 0;
            nbElement--;
            return Optional.of(retour);
        }
    }

    @Override
    void Clear() {
        super.Clear();
        popPointer = pushPointer = 0 ;
    }
}
