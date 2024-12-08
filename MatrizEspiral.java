import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrizEspiral {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        // Solicitar dimensiones de la matriz
        System.out.print("Introduce el número de filas: ");
        int filas = leer.nextInt();
        System.out.print("Introduce el número de columnas: ");
        int columnas = leer.nextInt();

        // Crear la matriz y permitir que el usuario ingrese los valores
        int[][] matriz = new int[filas][columnas];
        System.out.println("Introduce los elementos de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = leer.nextInt();
            }
        }

        // Imprimir la matriz original
        System.out.println("\nMatriz ingresada:");
        imprimirMatriz(matriz);

        // Obtener la lista de elementos en orden espiral
        List<Integer> espiral = recorrerEspiral(matriz);

        // Imprimir el resultado
        System.out.println("\nElementos en orden espiral:");
        System.out.println(espiral);
    }

    public static List<Integer> recorrerEspiral(int[][] matriz) {
        List<Integer> resultado = new ArrayList<>();
        if (matriz == null || matriz.length == 0) return resultado;

        int filaInicio = 0, filaFin = matriz.length - 1;
        int columnaInicio = 0, columnaFin = matriz[0].length - 1;

        while (filaInicio <= filaFin && columnaInicio <= columnaFin) {
            // Recorrer de izquierda a derecha
            for (int j = columnaInicio; j <= columnaFin; j++) {
                resultado.add(matriz[filaInicio][j]);
            }
            filaInicio++;

            // Recorrer de arriba hacia abajo
            for (int i = filaInicio; i <= filaFin; i++) {
                resultado.add(matriz[i][columnaFin]);
            }
            columnaFin--;

            // Recorrer de derecha a izquierda (si queda una fila por recorrer)
            if (filaInicio <= filaFin) {
                for (int j = columnaFin; j >= columnaInicio; j--) {
                    resultado.add(matriz[filaFin][j]);
                }
                filaFin--;
            }

            // Recorrer de abajo hacia arriba (si queda una columna por recorrer)
            if (columnaInicio <= columnaFin) {
                for (int i = filaFin; i >= filaInicio; i--) {
                    resultado.add(matriz[i][columnaInicio]);
                }
                columnaInicio++;
            }
        }

        return resultado;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
    }
}
