package homework;


/**
 * Создание класса MyArrayList, его основных параметров и конструктора
 * @author Александр Волошин
 * @param <E> - для принятия при создании MyArrayList любого типа данных
 */

public class MyArrayList<E> implements MyList<E> {

    private static final int INITIAL_CAPACITY = 10;
    private E[] data;
    private int size = 0;
    private int capacity = 0;

    public MyArrayList() {
        capacity = INITIAL_CAPACITY;
        data = (E[]) new Object[capacity];
    }

    /**
     * Метод добавляет указанный элемент в конец созданного списка
     * @param item - элемент любого типа
     * @return - возвращает boolean выражение о возможности добавления элемента
     */
    public boolean add(E item) {
        if(size < capacity) {
            data[size] = item;
            size++;
            return true;
        }else {
            increasingTheArray();
            data[size] = item;
            return true;
        }
    }

    /**
     * Метод вставляет указанный элемент в указанную позицию списка
     * @param index - индекс/позиция в списке
     * @param item - элемент который будет вставлен в позицию index
     * @throws ArrayIndexOutOfBoundsException - если указанный индекс меньше 0 или больше размера списка,
     * выбрасывается исключение
     */
    public void add(int index, E item){
        if(index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        if(size >= capacity) {
            increasingTheArray();
        }

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = item;
        size++;
    }

    /**
     * Вспомогательный метод, который увеличивает массив, если место в нем закончилось
     */
    private void increasingTheArray() {
        E[] newData = (E[]) new Object[data.length * 2];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * Метод возвращает элемент в указанной позиции списка
     * @param index - индекс элемента, кторый необходимо вернуть
     * @return - метод возвращает элемент списка по указанному индексу
     * @throws ArrayIndexOutOfBoundsException - если указанный индекс меньше 0 или больше размера списка,
     * выбрасывается исключение
     */
    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return data[index];
    }

    /**
     * Метод возвращает индекс первого вхождения указанного элемента в этом списке
     * или -1, если этот список не содержит элемента
     * @param item - элемент любого типа
     * @return - метод возвращает индекс указанного элемента или -1 если его нет в списке
     */
    public int indexOf(E item) {
        if(item != null) {
            for (int i = 0; i < size; i++) {
                if(data[i] == item)
                    return i;
            }
        }else {
            return -1;
        }

        return -1;
    }

    /**
     * Метод удаляет элемент в указанной позиции в этом списке
     * @param index - индекс элемента который будет удален
     * @return - метод возвращает удаленный элемент по его индексу в списке
     * @throws IndexOutOfBoundsException - если указанный индекс меньше 0 или больше или равен размеру списка,
     * выбрасывается исключение
     */
    public E remove(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        E returnedItem = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        size--;
        return returnedItem;
    }

    /**
     * Метод возвращает количество элементов в этом списке
     * @return - возвращает число (int)
     */
    public int size() {
        return this.size;
    }

    /**
     * Метод заменяет элемент в указанной позиции списка указанным элементом
     * @param index - индекс элемента который будет заменен
     * @param item - элемент который будет вставлен в позицию index
     * @return - метод возвращает замененный элемент
     * @throws IndexOutOfBoundsException - если указанный индекс меньше 0 или больше или равен размеру списка,
     * выбрасывается исключение
     */
    public E set(int index, E item) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        E oldEntry = data[index];
        data[index] = item;

        return oldEntry;
    }

    @Override
    public String toString() {
        String result = "[" + data[0];

        for (int i = 1; i < size; i++) {
            result += ", " + data[i];
        }

        result += "]";

        return  result;
    }
}
