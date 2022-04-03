package homework;

/**
 * Класс реализует алгоритм быстрой сортировки с помощью интерфейса Comparable<T>
 * @param <T> - типизированный элемент
 */
public class QuickSortComparable<T extends Comparable<T>> {
    /**
     * Метод принимает коллекцию с любыми параметрами и вызывает метод quickSort()
     * @param myList - коллекция с типизированными параметрами
     */
    public void quickComparableSort(MyList<T> myList) {
        quickSort(myList, 0, myList.size() - 1);
    }

    /**
     * Метод рекурсивно сравнивает отдельные коллекции, получившиеся путем деления основной коллекции
     * через метод getMiddleObjectIndex(), и в каждой из них по новой запускает метод getMiddleObjectIndex()
     * @param myList - входящая коллекция
     * @param startIndex - первый индекс коллекции
     * @param endIndex - последний индекс коллекции
     */
    private void quickSort(MyList<T> myList, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middleIndex = getMiddleObjectIndex(myList, startIndex, endIndex);
            quickSort(myList, startIndex, middleIndex - 1);
            quickSort(myList, middleIndex, endIndex);
        }
    }

    /**
     * Метод определяет опорный элемента коллекции, сравнивает элементы с опорным элементом
     * через метод compareTo, разбивает основную коллекцию на маньшие относительно опорного элемента и меняет местами
     * @param myList - входящая коллекция
     * @param startIndex - первый индекс коллекции
     * @param endIndex - последний индекс коллекции
     * @return - возвращает новое значение индекса, который будет считатся стартовым
     */
    private int getMiddleObjectIndex(MyList<T> myList, int startIndex, int endIndex) {
        int middleIndex = (startIndex + endIndex)/2;
        T middleObject = myList.get(middleIndex);
        while (endIndex >= startIndex) {
            while (myList.get(startIndex).compareTo(middleObject) < 0) {
                startIndex++;
            }
            while (middleObject.compareTo(myList.get(endIndex)) < 0) {
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
