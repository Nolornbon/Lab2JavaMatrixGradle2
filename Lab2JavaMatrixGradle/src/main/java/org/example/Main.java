package org.example;


public class Main {
    public static void main(String[] args) {
    /*
        //Step1. MatrixInitialization
        Matrix matrix = new Matrix(2, 3);
        System.out.println(matrix.getRows());
        System.out.println(matrix.getCols());
        matrix.print();
    */
    /*
        //Step2. Пуста матриця, матриця заданого розміру та копія іншої матриці
        Matrix matrix1 = new Matrix(2,2);
        Matrix matrix = new Matrix (matrix1);
        matrix.print();
        matrix1.print();
    */
    /*
        //Step3. Додати методи, що дозволяють заповнити матрицю значеннями
        Matrix matrix = new Matrix(2,2);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 3.0);
        matrix.setElement(1, 1, 4.0);
        matrix.print();

        double[][] data = {{9.9,8.8},{7.7,6.6}};
        matrix.fillWithData(data);
        matrix.print();

        matrix.autoFill();
        matrix.print();

        matrix.manualFill();
        matrix.print();
    */
    /*
        //Step4. Додати методи, що дозволяють отримати заданий елемент, рядок чи стовпчик
        Matrix matrix = new Matrix(2,2);
        double[][] data = {{9.9,8.8},{7.7,6.6}};
        matrix.fillWithData(data);

        System.out.print("Значення заданого елемента: " + matrix.getElement(1,1));
        double[] row = matrix.getRow(0);
        System.out.print("\nЗначення елементів рядка: ");
        for (double element : row) {
           System.out.print(element + " ");
        }
        System.out.print("\nЗначення елементів стовпця: ");
        double[] col = matrix.getColumn(1);
        for (double element : col) {
           System.out.print(element + " ");
        }
    */
    /*
        //Step5.Метод, що повертає розмірність матриці у вигляді масиву [рядки, стовпці]
        Matrix matrix = new Matrix(2,2);
        int[] size = matrix.getSize();
        System.out.println("Розмірність матриці "+ size[0]+"x"+size[1]);
    */
    /*
        //Step6. Equals\HashCode
        Matrix matrix = new Matrix(3,3);
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.fillWithData(data);
        Matrix matrix1 = new Matrix(3,3);
        double[][] data1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix1.fillWithData(data1);
        System.out.println(matrix.equals(matrix1));

        System.out.println(matrix.hashCode());
        System.out.println(matrix1.hashCode());
    */

        //Step 7.Immutable matrix

        //ImmutableMatrix matrix = new ImmutableMatrix();// пуста або
        //ImmutableMatrix matrix = new ImmutableMatrix(2,2);// заповнена 0

        //double[][] data = {{9.9,8.8},{7.7,6.6}}; //(1)
        //ImmutableMatrix matrix3 = new ImmutableMatrix(data); // створена з масиву

        //(1)Створення з копії матриці Mutable, Immutable матрицю

        //Matrix matrix1 = new Matrix(2,2);//(1)
        //matrix1.fillWithData(data);//(1)
        //ImmutableMatrix matrix2 = new ImmutableMatrix(matrix1); //(1) створена як копія змінної матриці

        //ImmutableMatrix matrix = new ImmutableMatrix(matrix3); // створена як копія незмінної матриці

        //System.out.println(matrix1.getRows());
        //System.out.println(matrix1.getCols());

        //matrix1.print();//(1)
        //matrix2.print();//(1)
        //matrix3.print();
        //matrix.print();

        //System.out.print(matrix.equals(matrix3));

        //double[][] data = {{9.9,8.8},{7.7,6.6}};
        //ImmutableMatrix matrix = new ImmutableMatrix(data);
        //matrix.print();

        //System.out.print("Значення заданого елемента: " + matrix.getElement(1,1));
        //double[] row = matrix.getRow(0);
        //System.out.print("\nЗначення елементів рядка: ");
        /*
        for (double element : row) {
            System.out.print(element + " ");
        }
        System.out.print("\nЗначення елементів стовпця: ");
        double[] col = matrix.getColumn(1);
        for (double element : col) {
            System.out.print(element + " ");
        }
        int[] size = matrix.getSize();
        System.out.println("\nРозмірність матриці "+ size[0]+"x"+size[1]);

        System.out.println(matrix.hashCode());
        */
    /*
        //Step.8 Diagonal matrix from vector
        double[] diagonal = {1.0,2.0,3.0};
        Matrix matrix = Matrix.diagonalMatrix(diagonal);
        ImmutableMatrix m;
        m = ImmutableMatrix.diagonalMatrix(diagonal);
        matrix.print();
        m.print();
    */

    /*
        //Step9.Методи, що перетворюють матрицю в нижню та верхню трикутну. (створюють нові матриці для Immutable)
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix1 = new ImmutableMatrix(data);
        ImmutableMatrix matrix2 = matrix1.toLowerTriangular();
        ImmutableMatrix matrix3 = matrix1.toUpperTriangular();
        matrix1.print();
        matrix2.print();
        matrix3.print();
     */
        //New
        /*//setElement
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix = new ImmutableMatrix(data);
        ImmutableMatrix newMatrix = matrix.setElement(0, 0, 900.0);
        //fillWithData
               double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
               ImmutableMatrix matrix = new ImmutableMatrix(data);
               double[][] newData2 = {{11.0, 12.0, 13.0}, {14.0, 15.0, 16.0}, {17.0, 18.0, 19.0}};
        ImmutableMatrix newMatrix = matrix.fillWithData(newData2);
        */
        //manualFill_autofill
        //ImmutableMatrix matrix = new ImmutableMatrix(2, 2);

        // Створення нової матриці викликом методу manual\auto
        //ImmutableMatrix newMatrix = matrix.manualFill(); // or autoFill();

        // Перевірка вмісту матриць оригінальної та нової після заповнення значеннями (для setElement, fillWithData, manualFill, autoFill)

        //matrix.print();
        //newMatrix.print();



    }


}
