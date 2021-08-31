package lrn.classes;

public class DataStructure {
    private final static int SIZE = 15;
    private final int[] arrayOfInts = new int[SIZE];

    public DataStructure() {
        for (int i = 0; i < SIZE; i++) {
            arrayOfInts[i] = i;
        }
    }

    public void printEven() {
        DataStructureIterator iterator = this.new EvenIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    interface DataStructureIterator extends java.util.Iterator<Integer> {
    }

    private class EvenIterator implements DataStructureIterator {
        private int nextIndex = 0;

        public boolean hasNext() {
            return (nextIndex <= SIZE - 1);
        }

        public Integer next() {
            Integer retValue = arrayOfInts[nextIndex];
            nextIndex += 2;
            return retValue;
        }
    }

    public static void main(String[] args) {
        DataStructure ds = new DataStructure();
        ds.printEven();
    }
}
