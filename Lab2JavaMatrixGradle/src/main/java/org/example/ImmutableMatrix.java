package org.example;


import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class ImmutableMatrix {

    private final int rows;
    private final int cols;
    private final double[][] data;

    //Конструктор незмінної матриці з масиву
    public ImmutableMatrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (data[i].length != cols) {
                throw new RuntimeException("Рядки повинні мати однакову кількість стовпчиків");
            }
            System.arraycopy(data[i], 0, this.data[i], 0, cols);
        }
    }

    // Конструктор незмінної матриці через копіювання змінної матриці
    public ImmutableMatrix(Matrix other) {
        this.rows = other.getRows();
        this.cols = other.getCols();
        this.data = new double[this.rows][this.cols];
        System.arraycopy(other.getData(), 0, this.data, 0, this.data.length);
    }

    // Конструктор незмінної матриці через копіювання незмінної матриці
    public ImmutableMatrix(ImmutableMatrix other) {
        this.rows = other.getRows();
        this.cols = other.getCols();
        this.data = new double[this.rows][this.cols];
        System.arraycopy(other.getData(), 0, this.data, 0, this.data.length);
    }

    // Конструктор матриці заданного розміру, заповненої 0

    public ImmutableMatrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new RuntimeException("Розміри матриці повинні бути більше 0");
        }
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];//ініціалізація з 0
    }

    // Конструктор незмінної пустої матриці

    public ImmutableMatrix() {
        this.rows = 0;
        this.cols = 0;
        this.data = new double[0][0];
    }

    // Метод для отримання даних матриці у вагляді масиву

    public double[][] getData() {
        return data;
    }

    // Метод для отримання кількості рядків матриці

    public int getRows() {
        return rows;
    }
    // Метод для отримання кількості стовпців матриці

    public int getCols() {
        return cols;
    }

    //Метод заповнення матриці значеннями з двовимірного масиву - створення нової матриці на базі незмінної
    public ImmutableMatrix fillWithData(double[][] newData) {
        if (newData.length == rows && newData[0].length == cols) {
            double[][] dataCopy = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(newData[i], 0, dataCopy[i], 0, cols);
            }
            return new ImmutableMatrix(dataCopy);
        } else {
            throw new RuntimeException("Розмір переданого масиву не відповідає розміру матриці");
        }

    }

    //Метод для встановлення значення елементу матриці - створення нової матриці на базі незмінної
    public ImmutableMatrix setElement(int row, int col, double value) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            double[][] newData = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(data[i], 0, newData[i], 0, cols);
            }
            newData[row][col] = value;
            return new ImmutableMatrix(newData);
        } else {
            throw new RuntimeException("Неприпустимі індекси рядка або стовпця");
        }
    }

    //Метод заповнення матриці рандомними значеннями - створення нової матриці на базі незмінної
    public ImmutableMatrix autoFill() {
        double[][] newData = new double[rows][cols];
        for(int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                newData[i][j]=(int) (-20 + (Math.random() * 50));
            }
        }
        return new ImmutableMatrix(newData);
    }

    //Метод ручного заповнення матриці- створення нової матриці на базі незмінної
    public ImmutableMatrix manualFill() {
        double[][] newData = getUserInput();
        return new ImmutableMatrix(newData);
    }

    private double[][] getUserInput() {
        double[][] newData = new double[rows][cols];
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Будь ласка, введіть [" + i + "; " + j + "] елемент");
                newData[i][j] = sc.nextDouble();
            }
        }
        return newData;
    }
    // Метод, що повертає значення заданого елемента матриці

    public double getElement(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return data[row][col];
        } else {
            throw new RuntimeException("Неправильні індекси рядка або стовпця");
        }
    }

    // Метод, що повертає рядок матриці за заданим індексом

    public double[] getRow(int row) {
        if (row >= 0 && row < rows) {
            return data[row];
        } else {
            throw new RuntimeException("Неправильний індекс рядка");
        }
    }
    // Метод, що повертає стовпець матриці за заданим індексом

    public double[] getColumn(int col) {
        if (col >= 0 && col < cols) {
            double[] column = new double[rows];
            for (int i = 0; i < rows; i++) {
                column[i] = data[i][col];
            }
            return column;
        } else {
            throw new RuntimeException("Неправильний індекс стовпця");
        }
    }
    // Метод, що повертає розмірність матриці у вигляді масиву [рядки, стовпці]

    public int[] getSize() {
        int[] size = new int[2];
        size[0] = this.getRows();
        size[1] = this.getCols();
        return size;
    }

    // Метод, що порівнює дві матриці на рівність

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ImmutableMatrix other = (ImmutableMatrix) obj;
        return this.rows == other.rows && this.cols == other.cols && Arrays.deepEquals(this.data, other.data);
    }
    // Метод, що генерує хеш-код для об'єкту матриці

    @Override
    public int hashCode() {
        int result = Objects.hash(rows, cols);
        result = 31 * result + Arrays.deepHashCode(data);
        return result;
    }


    // Метод для виведення матриці у вигляді рядків

    public void print() {
        if (rows != 0 && cols != 0) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Пуста матриця");
        }
    }
    //Метод для створення діагональної матриці (на основі задано вектора)
    public static ImmutableMatrix diagonalMatrix(double[] vector) {
        Matrix matrix = Matrix.diagonalMatrix(vector);
        return new ImmutableMatrix(matrix);
    }

    // Методи, що перетворюють матрицю в нижню та верхню трикутну. (створюють нові матриці для Immutable)

    // Метод для перетворення матриці на нижню трикутну форму
    public ImmutableMatrix toLowerTriangular() {
        Matrix matrix = new Matrix(this.getRows(),this.getCols());
        matrix.fillWithData(this.getData());
        matrix = matrix.toLowerTriangular();
        return new ImmutableMatrix(matrix);
    }
    // Метод для перетворення матриці на верхню трикутну форму
    public ImmutableMatrix toUpperTriangular() {
        Matrix matrix = new Matrix(this.getRows(),this.getCols());
        matrix.fillWithData(this.getData());
        matrix = matrix.toUpperTriangular();
        return new ImmutableMatrix(matrix);
    }
}


