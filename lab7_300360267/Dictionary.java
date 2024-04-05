import java.util.NoSuchElementException;
import java.util.Objects;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;
    private Pair[] elems;

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return elems.length;
    }

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        if (key == null || value == null) {
            throw new NullPointerException("key or value is null");
        }
        
        if (count == elems.length) {
            increaseCapacity();
        }
        elems[count++] = new Pair(key, value);
    }
    

    private void increaseCapacity() {
        Pair[] newArray = new Pair[elems.length + INCREMENT];
        System.arraycopy(elems, 0, newArray, 0, count);
        elems = newArray;
    }

    @Override
    public boolean contains(String key) {
    Objects.requireNonNull(key, "Key cannot be null");
    for (int i = count - 1; i >= 0; i--) {
        if (elems[i].getKey().equals(key)) {
            return true;
        }
    }
    return false;
    }


    @Override
    public Integer get(String key) {
    Objects.requireNonNull(key, "Key cannot be null");
    for (int i = count - 1; i >= 0; i--) {
        if (elems[i].getKey().equals(key)) {
            return elems[i].getValue();
        }
    }
    throw new NoSuchElementException("Key does not exist in dictionary");
    }


    @Override
    public void replace(String key, Integer value) {
    Objects.requireNonNull(key, "Key cannot be null");
    Objects.requireNonNull(value, "Value cannot be null");
    for (int i = count - 1; i >= 0; i--) {
        if (elems[i].getKey().equals(key)) {
            elems[i].setValue(value);
            return;
        }
    }
    throw new NoSuchElementException("Key does not exist in dictionary");
    }



        @Override
    public Integer remove(String key) {
    Objects.requireNonNull(key, "Key cannot be null");
    for (int i = count - 1; i >= 0; i--) {
        if (elems[i].getKey().equals(key)) {
            Integer value = elems[i].getValue();
            for (int j = i; j < count - 1; j++) {
                elems[j] = elems[j + 1];
            }
            elems[--count] = null;
            return value;
        }
    }
    throw new NoSuchElementException("Key does not exist in dictionary");
    }

    
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Dictionary: {elems = [");
        for (int i = count - 1; i >= 0; i--) {
            res.append(elems[i]);
            if (i > 0) {
                res.append(", ");
            }
        }
        res.append("]}");
        return res.toString();
    }
}
