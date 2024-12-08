import java.util.Random;
import java.util.Scanner;

public class SumadeAnillo {

    public static int sumaAnillo(int[][] matriz, int k) {
        int d = matriz.length; // Dimensión de la matriz (cuadrada)
        int suma = 0;

        //el numero de Anillos empezara desde 1
        k = k - 1;

        //Para matrices de dimension impar
        if(d % 2 !=0 && k == d / 2){
            return matriz[k][k];
        }

        // Recorremos el anillo "k" de la matriz
        for (int i = k; i < d - k; i++) {
            suma += matriz[k][i];          // Borde superior
            suma += matriz[d - k - 1][i];  // Borde inferior
        }
        for (int i = k + 1; i < d - k - 1; i++) {
            suma += matriz[i][k];          // Borde izquierdo
            suma += matriz[i][d - k - 1];  // Borde derecho
        }

        return suma;
    }

    public static void imprimirMatriz(int[][] matriz) {
        System.out.println("Matriz generada:");
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.printf("%4d", elemento); // Imprime cada elemento con 4 espacios para alinear
            }
            System.out.println(); // Salto de línea después de cada fila
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Random random = new Random();

        // Solicitar dimensión de la matriz
        System.out.print("Ingrese la dimensión de la matriz (d x d): ");
        int d = leer.nextInt();

        // Generar la matriz con números aleatorios entre -50 y 50
        int[][] matriz = new int[d][d];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                matriz[i][j] = random.nextInt(100)- 50; // Genera números entre -50 y 50
            }
        }

        // Imprimir la matriz generada
        imprimirMatriz(matriz);

        // Solicitar el número de anillo
        System.out.print("Ingrese el número de anillo que desea sumar (1 para el más externo): ");
        int k = leer.nextInt();

        // Validar el anillo y calcular la suma
        if (k < 1 || k > (d + 1) / 2) {
            System.out.println("El anillo " + k + " no es válido para una matriz de dimensión " + d);
        } else {
            int suma = sumaAnillo(matriz, k);
            System.out.println("La suma del anillo " + k + " es: " + suma);
        }

        leer.close();
    }
}