import java.util.Arrays;

public class JasonList {

    private int arraySize = 0;
    private Object[] jasonArray = new Object[arraySize];

    boolean add(Object object) {
        arraySize += 1;
        Object[] newJasonArray = Arrays.copyOf(jasonArray, arraySize);
        newJasonArray[arraySize - 1] = object;
        jasonArray = newJasonArray;
        return true;
    }

    boolean remove(Object object) {
        Object[] newJasonArray = new Object[arraySize];
        int newArrayIndex = 0;
        boolean hasBeenRemoved = false;

        for (Object item : jasonArray) {
            if ((item == object || item.toString().equals(object.toString())) && !hasBeenRemoved) {
                arraySize -= 1;
                newJasonArray = Arrays.copyOf(newJasonArray, arraySize);
                hasBeenRemoved = true;
            } else {
                newJasonArray[newArrayIndex] = item;
                newArrayIndex++;
            }
        }
        jasonArray = newJasonArray;
        return hasBeenRemoved;
    }

    void bubbleSort() {
        for (int fullSetIterator = 0; fullSetIterator < arraySize - 1; fullSetIterator++) {
            for (int itemIterator = 0; itemIterator < arraySize - 1; itemIterator++) {
                if (jasonArray[itemIterator].toString().compareTo(jasonArray[itemIterator + 1].toString()) > 0) {
                    Object holdCurrentValue = jasonArray[itemIterator];
                    jasonArray[itemIterator] = jasonArray[itemIterator + 1];
                    jasonArray[itemIterator + 1] = holdCurrentValue;
                }
            }
        }
    }

    public String toString() {
        StringBuilder jasonString = new StringBuilder("[");
        for (Object item : jasonArray) {
            jasonString.append(item).append(", ");
        }
        jasonString = new StringBuilder(jasonString.toString().replaceAll(", $", ""));
        jasonString.append("]");
        return jasonString.toString();
    }
}

//3 2 1
//
//231
//213
//
//123
//
//5 4 3 2 1
//
//45321
//43521
//43251
//43215
//
//34215
//32415
//32145
//32145
//
//23145
//21345
//21345
//21345
//
//12345