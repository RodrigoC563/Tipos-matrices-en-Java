import java.util.Scanner;

public class Sumarbordes {
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

        // Calcular la suma del perímetro
        int sumaPerimetro = calcularSumaPerimetro(matriz);

        // Imprimir el resultado
        System.out.println("\nSuma del perímetro de la matriz: " + sumaPerimetro);
    }

    public static int calcularSumaPerimetro(int[][] matriz) {
        int suma = 0;
        int d = matriz.length;

        // Recorrer la primera y última fila
        for (int j = 0; j < d; j++) {
            suma += matriz[0][j]; // Primera fila
            suma += matriz[d - 1][j]; // Última fila
        }

        // Recorrer la primera y última columna (excluyendo las esquinas ya sumadas)
        for (int i = 1; i < d - 1; i++) {
            suma += matriz[i][0]; // Primera columna
            suma += matriz[i][d - 1]; // Última columna
        }

        return suma;
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
