import java.util.Scanner;

public class SumaDiagonal {
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
        
        // Imprimir la matriz
        System.out.println("\nMatriz ingresada:");
        imprimirMatriz(matriz);

        // Calcular las sumas
        int[] resultado = calcularSumasDiagonales(matriz);
        
        // Imprimir los resultados
        System.out.println("\nSuma de la diagonal principal: " + resultado[0]);
        System.out.println("Suma de la diagonal secundaria: " + resultado[1]);
    }

    public static int[] calcularSumasDiagonales(int[][] matriz) {
        int sumaDiagonalPrincipal = 0;
        int sumaDiagonalSecundaria = 0;
        int d = matriz.length; // Dimensión de la matriz
        
        for (int i = 0; i < d; i++) {
            sumaDiagonalPrincipal += matriz[i][i]; // Elementos de la diagonal principal
            sumaDiagonalSecundaria += matriz[i][d - i - 1]; // Elementos de la diagonal secundaria
        }
        
        return new int[]{sumaDiagonalPrincipal, sumaDiagonalSecundaria};
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