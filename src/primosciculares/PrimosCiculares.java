package primosciculares;

/**
 *
 * @author hruiz
 */
public class PrimosCiculares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int n = 1000000, i;

        int[] taken = new int[n];// Sirve para no repetir si el nro es circular

        for (i = 1; i < n; ++i) {
            taken[i] = 0;
        }
        for (i = 3; i < n; i += 2) {
            CircularMT circular = new CircularMT(n, taken, i);
            circular.run();
        }
    }

}
