class DynamicArray {
    private int[] arr;
    private int size;
    private int capacity;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (size ==  capacity){
            resize();
        }
        arr[size] = n; 
        size++;
    }

    public int popback() {
        size--;
        int result = arr[size];
        arr[size] = -1;
        return result;
    }

    private void resize() {
        capacity *= 2;
        int[] copy = new int[capacity];
        for (int i = 0; i < size; i++){
            copy[i] = arr[i];
        }
        this.arr = copy;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }
}
