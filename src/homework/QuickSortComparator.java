package homework;

import java.util.Comparator;

/**
 * Класс реализует алгоритм быстрой сортировки с помощью интерфейса Comparator<T>
 * @param <T> - типизированный элемент
 */
public class QuickSortComparator<T> {
    /**
     * Метод принимает коллекцию с любыми параметрами и вызывает метод quickSort()
     * @param myList - коллекция с типизированными параметрам
     * @param comparator - это экземпляр класса, который реализует интерфейс Comparator<T>
     */
    public void quickComparatorSort(MyList<T> myList, Comparator<T> comparator) {
        quickSort(myList, 0, myList.size() - 1, comparator);
    }

    /**
     * Метод рекурсивно сравнивает отдельные коллекции, получившиеся путем деления основной коллекции
     * через метод getMiddleObjectIndex(), и в каждой из них по новой запускает метод getMiddleObjectIndex()
     * @param myList - входящая коллекция
     * @param startIndex - первый индекс коллекции
     * @param endIndex - последний индекс коллекции
     * @param comparator- это экземпляр класса, который реализует интерфейс Comparator<T>
     */
    private void quickSort(MyList<T> myList, int startIndex, int endIndex, Comparator<T> comparator) {
        if (startIndex < endIndex) {
            int middleIndex = getMiddleObjectIndex(myList, startIndex, endIndex, comparator);
            quickSort(myList, startIndex, middleIndex - 1,comparator);
            quickSort(myList, middleIndex, endIndex, comparator);
        }
    }
    /**
     * Метод определяет опорный элемента коллекции, сравнивает элементы с опорным элементом
     * через метод compare, разбивает основную коллекцию на маньшие относительно опорного элемента и меняет местами
     * @param myList - входящая коллекция
     * @param startIndex - первый индекс коллекции
     * @param endIndex - последний индекс коллекции
     * @param comparator- это экземпляр класса, который реализует интерфейс Comparator<T>
     * @return - возвращает новое значение индекса, который будет считатся стартовым
     */
    private int getMiddleObjectIndex(MyList<T> myList, int startIndex, int endIndex, Comparator<T> comparator) {
        int middleIndex = (startIndex + endIndex)/2;
        T middleObject = myList.get(middleIndex);
        while (endIndex >= startIndex) {

            while (comparator.compare(myList.get(startIndex), middleObject) < 0) {
                startIndex++;
            }
            while (comparator.compare(middleObject, myList.get(endIndex)) < 0) {
                endIndex--;
            }

            if (endIndex >= startIndex) {
                T tmp = myList.get(startIndex);
                myList.set(startIndex,myList.get(endIndex));
                myList.set(endIndex,tmp);
                ++startIndex;
                --endIndex;
            }
        }
        return startIndex;
    }
}