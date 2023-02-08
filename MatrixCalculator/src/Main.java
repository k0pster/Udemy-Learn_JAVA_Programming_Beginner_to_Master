import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Kalkulator sumowania dwóech macierzy o tych samych wymiarach

        //Pobieram wymiary dla obu macierzy od usera
        Scanner sc = new Scanner(System.in);
        System.out.println("Matrix Calculator");
        System.out.println("Provide dimension n for Matrixes [n x m]:");
        int nMatrixDim = sc.nextInt();
        System.out.println("Provide dimension m for Matrixes [n x m]:");
        int mMatrixDim = sc.nextInt();

        //Inicjalizuje dwie puste macierze i macierz wynikową w oparciu o
        //podane przez usera wymiary
        int [][] matrixA = new int [nMatrixDim][mMatrixDim];
        int [][] matrixB = new int [nMatrixDim][mMatrixDim];
        int [][] matrixResult = new int [nMatrixDim][mMatrixDim];


        //Tworzę macierz A pobierając kolejne elementy macierzy przy pomocy zagnieżdzonej pętli
        //for o wymiarach ixj,
        System.out.println("Provide elements for Matrix A:");
        for (int i = 0; i < nMatrixDim; i++)
        {
            for (int j = 0; j < mMatrixDim; j++)
            {
                System.out.println("Provide element "+i+","+j+"= ");
                matrixA[i][j] = sc.nextInt();
            }
        }

        //Pobieram elementy dla Macierzy B
        System.out.println("Provide elements for Matrix B:");
        for (int i = 0; i < nMatrixDim; i++)
        {
            for (int j = 0; j < mMatrixDim; j++)
            {
                System.out.println("Provide element "+i+","+j+"= ");
                matrixB[i][j] = sc.nextInt();
            }
        }

        //Wykonanie działania na macierzach
        for (int i = 0; i < nMatrixDim; i++)
        {
            for (int j = 0; j < mMatrixDim; j++)
            {
                matrixResult[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        /*
        //Wyświetlenie macierzy wynikowej
        for (int i = 0; i < nMatrixDim; i++)
        {
            for (int j = 0; j < mMatrixDim; j++)
            {
                System.out.format("%02d ",matrixResult[i][j]);
            }
            System.out.println("");
        }*/

        //UPDATE: Wyświetlenie macierzy wynikowej za pomocą utworzonej uniwersalnej fukncji tylko poprzez jej
        //wywołanie i podanie macierzy do wyświetlenia oraz jej rozmiarów. Możemy teraz wyświetlić dowolną macierz,
        //dwuwyrazową wprowadzoną jako argument.
        //displayMatrix(matrixA,nMatrixDim,mMatrixDim);
        //displayMatrix(matrixB,nMatrixDim,mMatrixDim);

        displayMatrix(matrixResult,nMatrixDim,mMatrixDim);
    }

    //Uniwersalna funkcja do wyświetlania macierzy dwuwyrazowej, dzięki niej nie trzeba powtarzać kodu.
    public static void displayMatrix(int[][] inputMatrix,int nMatrixDim,int mMatrixDim){
        for (int i = 0; i < nMatrixDim; i++)
        {
            for (int j = 0; j < mMatrixDim; j++)
            {
                System.out.format("%02d ",inputMatrix[i][j]);
            }
            System.out.println("");
        }

    }
}