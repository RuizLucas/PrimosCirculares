package primosciculares;

import static java.lang.Math.sqrt;

/**
 *
 * @author hruiz
 */
public class CircularMT implements Runnable {

    private final int nro;
    private final int[] taken;
    private final int i;

    public CircularMT(int nro, int[] taken, int i) {
        this.nro = nro;
        this.taken = taken;
        this.i = i;
    }

    public int getNro() {
        return nro;
    }

    public int[] getTaken() {
        return taken;
    }

    public int getI() {
        return i;
    }

    @Override
    public void run() {
        int j;
        boolean primo = Boolean.TRUE;
        if (taken[i] == 0) {
            j = i;
            do {
                if (j < nro) {
                    taken[j] = 1;

                }
                primo = esPrimo(j);
                j = orbita(j);
            } while (primo && j != i);
            if (primo && i>7) {                
                System.out.println("Primo Circular =" + j);

            }
        }
    }

    /**
     * Metodo Establece si el <b>numero</b> es primo o no
     *
     * @param numero
     * @return
     */
    public static boolean esPrimo(int numero) {
        int sqrt_n = (int) sqrt(numero);
        int lim = (sqrt_n + 1) / 6;
        int i;        
        if (numero == 2 || numero == 3) {
            return Boolean.TRUE;
        }
        if (1 == numero || (numero % 2) == 0 || (numero % 3) == 0) {
            return Boolean.FALSE;
        }
        for (i = 1; i <= lim; ++i) {
            if ((numero % (6 * i - 1) == 0) || (numero % (6 * i + 1) == 0)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;

    }

    /**
     * Metodo nos permite girar el nro de acuerdo a la cantidad de posiciones
     * que tenga por ej: 13->31
     *
     * @param nro
     * @return
     */
    public static int orbita(int nro) {
        int n_10 = nro / 10;
        int orbit = nro % 10;
        nro = n_10;
        while (nro != 0) {
            orbit *= 10;
            nro /= 10;
        }
        orbit += n_10;
        return orbit;
    }

}
