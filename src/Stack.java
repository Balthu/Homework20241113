import java.util.Arrays;
import java.util.Optional;

public class Stack extends SQStructure {
    /**
     * Méthode d'empilement d'une valeur
     *
     * @param element valeur à empiler
     */
    @Override
    void Push(int element) {
        if (nbElement == Size()) {
            RedimTableau(Size() + step);
        }
        tableau[nbElement++] = element;
    }

    private void RedimTableau(int taille) {
        tableau = Arrays.copyOf(tableau, taille);
    }

    /**
     * Méthode de dépilement d'une valeur
     *
     * @return retourne un Optional qui contient éventuellement la valeur dépilé si il y a au mois un élément dans le tableau
     */
    @Override
    Optional Pop() {
        if (nbElement == 0) {
            return Optional.empty();
        } else {
            if (Count() <= Size() - step) {
                RedimTableau(Size() - step / 2);
            }
            var retour = tableau[--nbElement];
            tableau[nbElement] = 0;
            return Optional.of(retour);
        }
    }
}
