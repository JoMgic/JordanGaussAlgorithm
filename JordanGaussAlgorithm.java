
package org.jordangaussalgorithm;

/**
 *
 * @author johannes
 */
public class JordanGaussAlgorithm {

    class LineOperation{
        public static final double[][] multiply(double[][] arr, int zeileNeu, double skalar){
            for(int i = 0; i < arr.length; i++){
                arr[zeileNeu][i] = arr[zeileNeu][i] * skalar;
            }
            return arr;
        }
        public static final double[][] sub(double[][] arr, int zeileNeu, int zeileDivisor, double anzahl){
            for(int i = 0; i < arr.length; i++){
                arr[zeileNeu][i] = arr[zeileNeu][i] - anzahl * arr[zeileDivisor][i];
            }
            return arr;
        }
    }
    public static double[][] jordangaussalgorithm(double[][] arr){
        double[][] einheitsMatrix = createEinheismatrix(arr.length);
        double n;
        for(int spalte = 0; spalte < arr.length; spalte++){
            n = 1 / arr[spalte][spalte];
            arr = LineOperation.multiply(arr, spalte, n);
            einheitsMatrix = LineOperation.multiply(einheitsMatrix, spalte, n);


             for(int zeile = (spalte + 1); zeile < arr.length; zeile++){
                 if(arr[spalte][zeile] == 0);
                 else
                 {
                     n = arr[zeile][spalte];
                     arr = LineOperation.sub(arr, zeile, spalte, n); // zeile steht hier für den Teil der 1 ist
                     einheitsMatrix = LineOperation.sub(einheitsMatrix, zeile, spalte, n);
                 }
             }
        }
        for(int spalte = 0; spalte < arr.length; spalte++){
            for(int zeile = 0; zeile < arr.length; zeile++){
                if(zeile != spalte){
                    n = arr[zeile][spalte];
                    if(n != 0){
                        LineOperation.sub(arr, zeile, spalte, n);
                        LineOperation.sub(einheitsMatrix, zeile, spalte, n);
                    }
                }
            }
        }
        return einheitsMatrix;
    }
    private static double[][] createEinheismatrix(int size){
        double[][] arr = new double[size][size];
        for(int i = 0; i < size; i++){
            for(int spalte = 0; spalte < i; spalte++){  arr[i][spalte] = 0; }
            arr[i][i] = 1;
            for(int spalte = i+1; spalte < size; spalte++){  arr[i][spalte] = 0; }

        }
        return arr;
    }
    private static void print(double[][] arr){
        System.out.print("\n");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        double [][] matrix = new double[][]{
            {6, 8, 3},
            {4, 7.5, 3},
            {1, 2, 2}
        };
        JordanGaussAlgorithm.print(JordanGaussAlgorithm.createEinheismatrix(3));
        JordanGaussAlgorithm.print(matrix);
        JordanGaussAlgorithm.print(JordanGaussAlgorithm.jordangaussalgorithm(matrix));
        
    }
}
