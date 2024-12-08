import java.util.Scanner;

public class TranpuestaMatriz {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // Solicitar al usuario el tamaño de la matriz
        System.out.print("Introduce la dimensión de la matriz (d x d): ");
        int d = leer.nextInt();

        // Crear la matriz y permitir que el usuario ingrese los valores
        int[][] matriz = new int[d][d];
        System.out.println("Introduce los elementos de la matriz:");
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = leer.nextInt();
            }
        }

        // Imprimir la matriz original
        System.out.println("\nMatriz original:");
        imprimirMatriz(matriz);

        // Calcular la matriz transpuesta
        int[][] transpuesta = calcularTranspuesta(matriz);

        // Imprimir la matriz transpuesta
        System.out.println("\nMatriz transpuesta:");
        imprimirMatriz(transpuesta);
    }

    public static int[][] calcularTranspuesta(int[][] matriz) {
        int d = matriz.length;
        int[][] transpuesta = new int[d][d];

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }
        return transpuesta;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t"); // Imprime los elementos con tabulación
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
    }
}

