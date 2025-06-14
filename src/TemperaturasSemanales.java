import java.util.Random;

public class TemperaturasSemanales {
    public static void main(String[] args) {
        int[][] temperaturas = new int[4][5];

        llenarMatriz(temperaturas);
        mostrarMatriz(temperaturas);

        int altas = contarDiasCalurosos(temperaturas);
        System.out.println("\n Dias con temperaturas mayores a 30: " + altas);

        double promedioBajas = promedioDiasFrescos(temperaturas);
        System.out.println("Promedio de temperaturas menores a 20: " + promedioBajas);

        System.out.println("\nTemperaturas críticas (mayores a 35):");
        imprimirTemperaturasExtremas(temperaturas);

        int[] posicion = posicionTemperaturaMasAlta(temperaturas);
        System.out.println("\nTemperatura mas alta está en la [" + posicion[0] + "][" + posicion[1] + "] con " + temperaturas[posicion[0]][posicion[1]] + " grados");

    }
    public static void llenarMatriz(int[][] m) {
        Random r = new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                m[i][j] = r.nextInt(81) + 10;  
            }
        }
    }
    public static void mostrarMatriz(int[][] m) {
        System.out.println("Temperaturas de la semana :");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int contarDiasCalurosos(int[][] m) {
        int contador = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > 30) {
                    contador++;
                }
            }
        }
        return contador;
    }
    public static double promedioDiasFrescos(int[][] m) {
        int suma = 0;
        int cantidad = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] < 20) {
                    suma += m[i][j];
                    cantidad++;
                }
            }
        }
        if (cantidad == 0) {
            return 0;
        }
        return (double) suma / cantidad;
    }
    public static void imprimirTemperaturasExtremas(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > 35) {
                    System.out.println("Temperatura crítica en [" + i + "][" + j + "]: " + m[i][j] + " grados");
                }
            }
        }
    }
   public static int[] posicionTemperaturaMasAlta(int[][] m) {
        int max = m[0][0];
        int fila = 0;
        int col = 0;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                    fila = i;
                    col = j;
                }
            }
        }
        return new int[]{fila, col};
    }
}

    


