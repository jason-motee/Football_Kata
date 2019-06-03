import java.util.Arrays;

public class JasonSet {

    private int arraySize = 0;
    private Object[] jasonArray = new Object[arraySize];

    boolean add(Object object) {
        for (Object item: jasonArray) {
            if(item == object || item.toString().equals(object.toString())){
                return false;
            }
        }

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
            if (item == object || item.toString().equals(object.toString())) {
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
