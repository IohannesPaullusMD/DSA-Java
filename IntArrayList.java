public class IntArrayList {
    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    private int[] nums;
    private int size;

    // constructor 1
    public IntArrayList()
    {
        // the next line will simply call constructor 2 with the given argument
        this(DEFAULT_INITIAL_CAPACITY);
    }

    // constructor 2
    public IntArrayList(int inititalCapacity) {
        if (inititalCapacity != DEFAULT_INITIAL_CAPACITY) {
            // make the initial capacity be a power 2
            int x = 1;
            while (x < inititalCapacity) {
                x = x << 1;
            }
            inititalCapacity = x;
        }

        nums = new int[inititalCapacity];
        size = 0;
    }

    private void resize() {
        int[] newNums = new int[size << 1];
        System.arraycopy(nums, 0, newNums, 0, size);
        nums = newNums;
    }

    public int size() {
        return size;
    }

    public int add(int element) {
        return insert(element, size);
    }

    public int insert(int element, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(position);
        }

        if (size == nums.length) {
            resize();
        }

        for (int i = size; i > position; --i) {
            nums[i] = nums[i-1];
        }

        return nums[size++] = element;
    }

    public int get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }
        return nums[position];
    }

    public int replace(int element, int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(position);
        }
        return nums[position] = element;
    }

    public int remove(int position) {
        if (position < 0 || position > size) {
            throw new IndexOutOfBoundsException(position);
        }
        
        int x = nums[position];
        --size;
        
        for (int i = position + 1; i < size; ++i) {
            nums[i-1] = nums[i];
        }

        return x;
    }
}
