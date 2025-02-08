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

    public int add(int element) {
        if (size == nums.length) {
            int[] newNums = new int[size << 1];
            System.arraycopy(nums, 0, newNums, 0, size);
            nums = newNums;
        }
        
        nums[size++] = element;

        return element;
    }

    public int size() {
        return size;
    }

    public int get(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }
        return nums[position];
    }

    public int insert(int element, int position) {
        // TODO: write codes for this method
        // move elements from nums[position] till end to the right
        // insert the element 
        return element;
    }

    public int remove(int position) {
        if (position < 0 || position >= size) {
            throw new IndexOutOfBoundsException(position);
        }

        // TODO: write codes for this method
        return nums[position];
    }
}
