package test;

import homework.MyArrayList;
import homework.MyList;
import org.junit.jupiter.api.Test;

class MyArrayListTest {

    @Test
    void testAdd() {
        //Given
        Integer item = 1;

        //When
        MyList<Integer> expected = new MyArrayList<Integer>();
        expected.add(item);

        //Then
        assert expected.size() == 1;
        assert item.equals(expected.get(0));
    }

    @Test
    void testAddIndex() {
        //Given
        Integer item1 = 1;
        Integer item2 = 2;
        Integer item3 = 3;
        Integer item4 = 4;

        MyList<Integer> expected = new MyArrayList<Integer>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        expected.add(item4);

        //When
        Integer item5 = 0;
        expected.add(0, item5);

        //Then
        assert expected.size() == 5;
        assert item5.equals(expected.get(0));
        assert item1.equals(expected.get(1));
        assert item2.equals(expected.get(2));
        assert item3.equals(expected.get(3));
        assert item4.equals(expected.get(4));
    }

    @Test
    void testGet() {
        //Given
        String item1 = "Плутон";

        MyList<String> expected = new MyArrayList<>();
        expected.add(item1);

        //When
        expected.get(0);

        //Then
        assert expected.size() == 1;
        assert "Плутон".equals(expected.get(0));
    }

    @Test
    void testIndexOf() {
        //Given
        Double item1 = 3.33;
        Double item2 = 5.5555;
        Double item3 = 8.8888888;

        MyList<Double> expected = new MyArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);

        //When
        expected.indexOf(item2);

        //Then
        assert expected.size() == 3;
        assert item2.equals(expected.get(1));
    }

    @Test
    void testRemove() {
        //Given
        String item1 = "Меркурий";
        String item2 = "Венера";
        String item3 = "Земля";
        String item4 = "Луна";

        MyList<String> expected = new MyArrayList<>();
        expected.add(0, item1);
        expected.add(1, item2);
        expected.add(2, item3);
        expected.add(3, item4);

        //When
        expected.remove(3);

        //Then
        assert expected.size() == 3;
    }

    @Test
    void testSize() {
        //Given
        Double item = 5.5555;

        MyList<Double> expected = new MyArrayList<>();
        expected.add(item);

        //When
        expected.size();

        //Then
        assert expected.size() == 1;
    }

    @Test
    void testSet() {
        //Given
        String item1 = "Меркурий";
        String item2 = "Венера";
        String item3 = "Земля";
        String item4 = "Луна";

        MyList<String> expected = new MyArrayList<>();

        expected.add(0, item1);
        expected.add(1, item2);
        expected.add(2, item3);
        expected.add(3, item4);

        //When
        expected.set(3, "Марс");

        //Then
        assert expected.size() == 4;
        assert "Меркурий".equals(expected.get(0));
        assert "Венера".equals(expected.get(1));
        assert "Земля".equals(expected.get(2));
        assert "Марс".equals(expected.get(3));
    }
}