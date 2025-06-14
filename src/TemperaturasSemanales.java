import java.util.Random;

public class TemperaturasSemanales {
    public static void main(String[] args) {
        int[][] temperaturas = new int[4][5];

        llenarMatriz(temperaturas);
        mostrarMatriz(temperaturas);

        int altas = contarDiasCalurosos(temperaturas);
        System.out.println("\nTemperaturas mayores a 30: " + altas);

        double promedioBajas = promedioTemperaturasBajas(temperaturas);
        System.out.println("Promedio de temperaturas menores a 20: " + promedioBajas);

        System.out.println("\nTemperaturas críticas (mayores a 35):");
        imprimirTemperaturasPeligrosas(temperaturas);

        int[] pos = equipoMasCaliente(temperaturas);
        System.out.println("\nEquipo más caliente está en [" + pos[0] + "][" + pos[1] + "] con " + temperaturas[pos[0]][pos[1]] + " grados");

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

    

}

    


