package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {

    //Step1.
    @Test
    public void MatrixInitialization() {
        Matrix matrix = new Matrix(3, 3);
        Assertions.assertEquals(3, matrix.getRows());
        Assertions.assertEquals(3, matrix.getCols());
    }

    //Step2 Пуста матриця, матрицюя заданого розміру та копія іншої матриці
    @Test
    public void testEmptyMatrixCreation() {
        Matrix matrix = new Matrix();
        Assertions.assertEquals(0, matrix.getRows());
        Assertions.assertEquals(0, matrix.getCols());
    }

    @Test
    public void testMatrixCreationWithSize() {
        Matrix matrix = new Matrix(2, 2);
        Assertions.assertEquals(2, matrix.getRows());
        Assertions.assertEquals(2, matrix.getCols());
    }

    @Test
    public void testMatrixCreationWithCopy() {
        Matrix matrix1 = new Matrix(2, 3);
        Matrix matrix = new Matrix(matrix1);
        Assertions.assertEquals(2, matrix.getRows());
        Assertions.assertEquals(2, matrix1.getRows());
        Assertions.assertEquals(3, matrix.getCols());
        Assertions.assertEquals(3, matrix1.getCols());
    }

    //Step3 Mетоди, що дозволяють заповнити матрицю значеннями
    @Test
    public void testMatrixSetElement() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 3.0);
        matrix.setElement(1, 1, 4.0);
        double[][] actualData = matrix.getData();
        double[][] expectedData = {{1.0, 2.0}, {3.0, 4.0}};
        Assertions.assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testFillWithData() {
        Matrix matrix = new Matrix(3, 3);
        // Вхідні дані - двовимірний масив
        double[][] newData = {{1.1, 2.1, 3.1}, {4.2, 5.2, 6.2}, {7.3, 8.3, 9.3}};
        // Виклик методу fillWithData з вхідними даними
        matrix.fillWithData(newData);
        //Перевірка розмірів матриці
        Assertions.assertEquals(3, matrix.getRows());
        Assertions.assertEquals(3, matrix.getCols());
        // Перевірка вмісту матриці після заповнення
        double[][] actualData = matrix.getData();
        double[][] expectedData = {{1.1, 2.1, 3.1}, {4.2, 5.2, 6.2}, {7.3, 8.3, 9.3}};
        Assertions.assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testAutoFill() {
        Matrix matrix = new Matrix(2, 2);
        // Виклик методу autofill
        matrix.autoFill();
        // Перевірка вмісту матриці після заповнення
        matrix.print();
    }

    //Step4. Додати методи, що дозволяють отримати заданий елемент, рядок чи стовпчик
    @Test
    public void testMatrixGetElementRowColumn() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setElement(0, 0, 1.0);
        matrix.setElement(0, 1, 2.0);
        matrix.setElement(1, 0, 3.0);
        matrix.setElement(1, 1, 4.0);
        Assertions.assertEquals(1.0, matrix.getElement(0, 0));
        Assertions.assertEquals(2.0, matrix.getElement(0, 1));
        Assertions.assertEquals(3.0, matrix.getElement(1, 0));
        Assertions.assertEquals(4.0, matrix.getElement(1, 1));
        double[] row = matrix.getRow(1);
        Assertions.assertArrayEquals(new double[]{3.0, 4.0}, row);
        double[] column = matrix.getColumn(0);
        Assertions.assertArrayEquals(new double[]{1.0, 3.0}, column);
    }

    //Step5.    Метод, що повертає розмірність матриці у вигляді масиву [рядки, стовпці]
    @Test
    public void testMatrixGetSize() {
        Matrix matrix = new Matrix(2, 2);
        int[] size = matrix.getSize();
        Assertions.assertArrayEquals(new int[]{2, 2}, size);
    }

    //Step6. Equals/hashCode
    @Test
    public void testMatrixEquals() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.fillWithData(data);
        Matrix matrix1 = new Matrix(3, 3);
        double[][] data1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix1.fillWithData(data1);
        Assertions.assertEquals(matrix, matrix1);
    }

    @Test
    public void testHashCode() {
        Matrix matrix = new Matrix(3, 3);
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        matrix.fillWithData(data);
        Matrix matrix1 = new Matrix(matrix);
        Assertions.assertEquals(matrix.hashCode(), matrix1.hashCode());
    }

    //Step7. Immutable Matrix
    @Test
    public void testEmptyImmutableMatrixCreation() {
        ImmutableMatrix matrix = new ImmutableMatrix();
        Assertions.assertEquals(0, matrix.getRows());
        Assertions.assertEquals(0, matrix.getCols());
    }

    @Test
    public void testImmutableMatrixCreationWithZero() {
        ImmutableMatrix matrix = new ImmutableMatrix(2, 2);
        double[][] actualData = matrix.getData();
        double[][] expectedData = {{0.0, 0.0}, {0.0, 0.0}};
        Assertions.assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testImmutableMatrixCreationWithArray() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix = new ImmutableMatrix(data);
        double[][] actualData = matrix.getData();
        double[][] expectedData = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Assertions.assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testImmutableMatrixCreationWithCopy() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0}};
        ImmutableMatrix matrix1 = new ImmutableMatrix(data);
        ImmutableMatrix matrix = new ImmutableMatrix(matrix1);//копія з класу ImmutableMatrix
        double[][] data1 = {{1.1, 2.1}, {3.1, 4.1}};
        Matrix matrix2 = new Matrix(2, 2);
        matrix2.fillWithData(data1);
        ImmutableMatrix matrix3 = new ImmutableMatrix(matrix2);//копія з класу Matrix
        double[][] actualData1 = matrix.getData();
        double[][] expectedData1 = {{1.0, 2.0}, {3.0, 4.0}};
        Assertions.assertArrayEquals(expectedData1, actualData1);
        double[][] actualData2 = matrix3.getData();
        double[][] expectedData2 = {{1.1, 2.1}, {3.1, 4.1}};
        Assertions.assertArrayEquals(expectedData2, actualData2);
    }
    //new
    @Test
    public void testImmutableMatrixSetElement() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix = new ImmutableMatrix(data);
        ImmutableMatrix newMatrix = matrix.setElement(0, 0, 900.0);
        Assertions.assertEquals(900.0, newMatrix.getElement(0, 0));
        Assertions.assertEquals(1.0, matrix.getElement(0, 0));
        //       matrix.print();
        //       newMatrix.print();
    }
    //new
    @Test
    public void testImmutableMatrixAutoFill() {
        ImmutableMatrix matrix = new ImmutableMatrix(2, 2);
        // Виклик методу autofill
        ImmutableMatrix newMatrix = matrix.autoFill();
        // Перевірка вмісту матриці після заповнення
        matrix.print();
        newMatrix.print();
    }
    //new
    @Test
    public void testImmutableMatrixFillWithData() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix = new ImmutableMatrix(data);
        double[][] dataNew = {{11.0, 12.0, 13.0}, {14.0, 15.0, 16.0}, {17.0, 18.0, 19.0}};
        ImmutableMatrix matrix1 = matrix.fillWithData(dataNew);
        Assertions.assertEquals(11.0, matrix1.getElement(0, 0));
        Assertions.assertEquals(12.0, matrix1.getElement(0, 1));
        Assertions.assertEquals(13.0, matrix1.getElement(0, 2));
        Assertions.assertEquals(14.0, matrix1.getElement(1, 0));
        Assertions.assertEquals(15.0, matrix1.getElement(1, 1));
        Assertions.assertEquals(16.0, matrix1.getElement(1, 2));
        Assertions.assertEquals(17.0, matrix1.getElement(2, 0));
        Assertions.assertEquals(18.0, matrix1.getElement(2, 1));
        Assertions.assertEquals(19.0, matrix1.getElement(2, 2));
    }

    @Test
    public void testImmutableMatrixGetElementRowColumn() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix = new ImmutableMatrix(data);
        Assertions.assertEquals(5.0, matrix.getElement(1, 1));
        double[] row = matrix.getRow(1);
        Assertions.assertArrayEquals(new double[]{4.0, 5.0, 6.0}, row);
        double[] column = matrix.getColumn(2);
        Assertions.assertArrayEquals(new double[]{3.0, 6.0, 9.0}, column);
    }

    @Test
    public void testImmutableMatrixGetSize() {
        ImmutableMatrix matrix = new ImmutableMatrix(2, 2);
        int[] size = matrix.getSize();
        Assertions.assertArrayEquals(new int[]{2, 2}, size);
    }

    @Test
    public void testImmutableMatrixEquals() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix = new ImmutableMatrix(data);
        double[][] data1 = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix1 = new ImmutableMatrix(data1);
        Assertions.assertTrue(matrix.equals(matrix1));
    }

    @Test
    public void testImmutableHashCode() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        ImmutableMatrix matrix = new ImmutableMatrix(data);
        ImmutableMatrix matrix1 = new ImmutableMatrix(matrix);
        Assertions.assertEquals(matrix.hashCode(), matrix1.hashCode());
    }

    // Step.8 Diagonal matrix from vector
    @Test
    public void testDiagonalMatricesFromVector() {
        // Ініціалізація діагональної матриці
        double[] diagonal = {1.0, 2.0, 3.0};
        Matrix matrix = Matrix.diagonalMatrix(diagonal);
        ImmutableMatrix m = ImmutableMatrix.diagonalMatrix(diagonal);
        // m.print();
        // Перевірка правильності створення діагональної матриці з вектора
        double[][] expected = {{1.0, 0.0, 0.0}, {0.0, 2.0, 0.0}, {0.0, 0.0, 3.0}};
        Assertions.assertArrayEquals(expected, matrix.getData());
        Assertions.assertArrayEquals(expected, m.getData());
        //   assertTrue(matrix.equals(m));// result=false тому що різні класи
    }

    //Step9.Методи, що перетворюють матрицю в нижню та верхню трикутну.
    @Test
    public void testToLowerTriangular() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix matrix = new Matrix(3, 3);
        matrix.fillWithData(data);
//        matrix.print();
        matrix = matrix.toLowerTriangular();
        //      matrix.print();
        double[][] expected = {{1.0, 0.0, 0.0}, {4.0, 5.0, 0.0}, {7.0, 8.0, 9.0}};
        Assertions.assertArrayEquals(expected, matrix.getData());


        ImmutableMatrix matrix1 = new ImmutableMatrix(data);
        ImmutableMatrix matrix2 = matrix1.toLowerTriangular();
        //      matrix2.print();
        //      matrix1.print();
        // Перевірка правильності перетворення в нижню трикутну матрицю
        double[][] expected1 = {{1.0, 0.0, 0.0}, {4.0, 5.0, 0.0}, {7.0, 8.0, 9.0}};
        Assertions.assertArrayEquals(expected1, matrix2.getData());
        Assertions.assertArrayEquals(data,matrix1.getData());
    }

    @Test
    public void testToUpperTriangular() {
        double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Matrix matrix = new Matrix(3, 3);
        matrix.fillWithData(data);
        matrix = matrix.toUpperTriangular();
        //      matrix.print();
        double[][] expected = {{1.0, 2.0, 3.0}, {0.0, 5.0, 6.0}, {0.0, 0.0, 9.0}};
        Assertions.assertArrayEquals(expected, matrix.getData());

        ImmutableMatrix matrix1 = new ImmutableMatrix(data);
        ImmutableMatrix matrix2 = matrix1.toUpperTriangular();
        //      matrix2.print();
        //      matrix1.print();
        // Перевірка правильності перетворення в нижню трикутну матрицю
        double[][] expected1 = {{1.0, 2.0, 3.0}, {0.0, 5.0, 6.0}, {0.0, 0.0, 9.0}};
        Assertions.assertArrayEquals(expected1, matrix2.getData());
        Assertions.assertArrayEquals(data,matrix1.getData());
    }

}

