import java.util.Scanner;

public class SimetriaMatriz {
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

        // Verificar simetría
        boolean esSimetrica = verificarSimetria(matriz);

        // Imprimir el resultado
        if (esSimetrica) {
            System.out.println("\nLa matriz es simétrica.");
        } else {
            System.out.println("\nLa matriz no es simétrica.");
        }
    }

    public static boolean verificarSimetria(int[][] matriz) {
        int d = matriz.length;

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < i; j++) { // Solo es necesario verificar los elementos por debajo de la diagonal principal
                if (matriz[i][j] != matriz[j][i]) {
                    return false; // Si algún par no coincide, la matriz no es simétrica
                }
            }
        }
        return true; // Si se recorren todos los pares y coinciden, la matriz es simétrica
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
