package Lab2;

import java.util.Vector;

public class Array3D<T> extends Vector<T> {

    public static void main(String[] args) {
        Array3D<Integer> array3D = Array3D.CreateFill(15);
        System.out.println(array3D.getItem(9,9,1));

    }


    private Vector<Vector<Vector<T>>> megaArray3D;
    public Array3D(){
        megaArray3D = createArray();
    }
    public Array3D(Vector<Vector<Vector<T>>> megaArray3D){
        this.megaArray3D = megaArray3D;
    }

    /**
     * Заполняет массив элементами t из аргумента
     * @param t
     * @return new 3DVector
     */
    public static Array3D<Integer> CreateFill(Integer t){
        Vector<Vector<Vector<Integer>>> array3D = new Vector<>(10);
        for (int i = 0 ;i < 10 ; i++){
            array3D.add(new Vector<>());
            for (int j = 0; j < 10; j++) {
                array3D.get(i).add(new Vector<>());
                for (int k = 0; k < 10; k++) {
                    array3D.get(i).get(j).add(t);
                }
            }
        }
        return new Array3D<>(array3D);
    }
    private Vector<Vector<Vector<T>>> createArray(){
        Vector<Vector<Vector<T>>> array3D = new Vector<>();
        for (int i = 0 ;i < 10 ; i++){
            megaArray3D.add(new Vector<>());
            for (int j = 0; j < 10; j++) {
                megaArray3D.get(i).add(new Vector<>());
            }
        }
        return array3D;
    }
    public T getItem(int i, int j, int k){
        T result = megaArray3D.get(i).get(j).get(k);
        return result;
    }

    public boolean setItem(int i, int j, int k){
        boolean result = false;
        return result;
    }

    public Vector<T> get2D(int i, int j){
        return megaArray3D.get(i).get(j);
    }
    public Vector<Vector<T>> get1D(int i){
        return megaArray3D.get(i);
    }
    public Vector<Vector<Vector<T>>> getArray(){
        return megaArray3D;
    }


}
