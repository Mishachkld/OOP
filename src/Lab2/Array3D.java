package Lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Array3D<T> {

    public static void main(String[] args) {
        Array3D<Integer> array = new Array3D<>(2, 12);
        System.out.println(array);
        array.setItem0(1, 1, 9999);
        System.out.println(array);
        array.addItem(1, 0, 0, 999);
        System.out.println(array);
        array.setItem00(0, 1212);
        System.out.println(array);
        System.out.println(array.getItemAtPosition(1, 0, 0));
        System.out.println("array.get1D: " + array.getValue2(1));
        System.out.println("array.getItemAtPosition: "+ array.getItemAtPosition(1, 0, 0));
        System.out.println("array.getItem01: " + array.getItem01(0) );
        System.out.println("array.get2D: " + array.getValue1(1, 0));
    }

    private static final int START_POSITION = 0;
    private List<List<List<T>>> megaArray3D;

    public Array3D(List<List<List<T>>> megaArray3D) {
        this.megaArray3D = megaArray3D;
    }

    public Array3D(int size, T t) {
        if (checkerSize(size)) {
            megaArray3D = createArray(size);
            fill(size, t);
        } else throw new NegativeArraySizeException("Incorrect size!!!");
    }

    public Array3D(int size) {
        if (checkerSize(size))
            megaArray3D = createArray(size);
        else throw new NegativeArraySizeException("Incorrect size!!!");
    }

    /**
     * Заполняет массив элементами Integer из аргумента
     *
     * @param t
     * @return new 3DVector
     */
    public static Array3D<Integer> CreateFill(int size, Integer t) {
        if (size > 0) {
            List<List<List<Integer>>> array3D = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                array3D.add(new Vector<>());
                for (int j = 0; j < size; j++) {
                    array3D.get(i).add(new Vector<>());
                    for (int k = 0; k < size; k++) {
                        array3D.get(i).get(j).add(t);
                    }
                }
            }
            return new Array3D<>(array3D);
        } else throw new NegativeArraySizeException("Incorrect size!!!");
    }


    public void fill(int count, T t) {  /// c обобщениями не возможно сделать статитический метод, т.к. статческие методы инициализируются единожды на этапе компиляции
        for (List<List<T>> array2D : megaArray3D)
            for (List<T> array : array2D)
                for (int i = 0; i < count; i++) {
                    array.add(t);
                }
    }

    private List<List<List<T>>> createArray(int size) {
        List<List<List<T>>> array3D = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array3D.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                array3D.get(i).add(new ArrayList<>());
            }
        }
        return array3D;
    }

    private boolean checkerOfIndex(int i, int j, int k) {
        return (this.megaArray3D.size() > i) && (this.megaArray3D.get(i).size() > j) && (this.megaArray3D.get(i).get(j).size() > k);
    }

    private boolean checkerSize(int size) {
        return size > 0;
    }

    public T getItem01(int k) {
        return getItemAtPosition(START_POSITION, 1, k);
    }

    public T getItem02(int k) {
        return getItemAtPosition(START_POSITION, 2, k);
    }

    public T getItem12(int k) {
        return getItemAtPosition(1, 2, k);
    }



    public T getItemAtPosition(int i, int j, int k) {
        if (checkerOfIndex(i, j, k))
            return megaArray3D.get(i).get(j).get(j);
        else throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
    }

    public List<T> getValue1(int i, int j) {
        if (checkerOfIndex(i, j, START_POSITION))
            return megaArray3D.get(i).get(j);
        else throw new IndexOutOfBoundsException("Выход за пределы массива");
    }

    public List<List<T>> getValue2(int i) {
        if (checkerOfIndex(i, START_POSITION, START_POSITION))
            return megaArray3D.get(i);
        else throw new IndexOutOfBoundsException("Выход за пределы массива");
    }

    public List<List<List<T>>> getValue3() {
        return megaArray3D;
    }

    /**
     * Метод добавляет элемент в позицию i,j,k
     */
    public void addItem(int i, int j, int k, T t) {
        boolean result = false;
        if (checkerOfIndex(i, j, k)) {
            this.megaArray3D.get(i).get(j).add(k, t);
            result = true;
        } else throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
    }

    /**
     * Метод заменяет элемент расположенный в позиции i,j,k
     *
     * @param i
     * @param j
     * @param k
     */
    public void setItemAtPosition(int i, int j, int k, T t) {
        boolean result = false;
        if (checkerOfIndex(i, j, k)) {
            this.megaArray3D.get(i).get(j).set(k, t);
            result = true;
        } else throw new ArrayIndexOutOfBoundsException("Выход за пределы массива");
    }

    public void setItem00(int k, T t) {
        setItemAtPosition(START_POSITION, START_POSITION, k, t);
    }

    public void setItem11(int k, T t) {
        setItemAtPosition(1, 1, k, t);
    }

    public void setItem22(int k, T t) {
        setItemAtPosition(2, 2, k, t);
    }

    public void setItem0(int j, int k, T t) {
        setItemAtPosition(0, j, k, t);
    }

    public void setItem1(int j, int k, T t) {
        setItemAtPosition(1, j, k, t);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        int counter = 0;
        for (List<List<T>> array2D : megaArray3D) {
            strBuilder.append(counter++).append(". \n");
            for (List<T> array : array2D) {
                for (T item : array) {
                    strBuilder.append(item).append(" ");
                }
                strBuilder.append("\n");
            }
            strBuilder.append("-----------------------------------\n");
        }
        return strBuilder.toString();
    }


}
