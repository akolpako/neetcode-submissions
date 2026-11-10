class MinStack {

    private Elem[] elements;
    private int pointer;
    private int min;

    public MinStack() {
        this.elements = new Elem[128];
        this.pointer = -1;
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if (pointer == this.elements.length - 1) {
            this.elements = copyAndIncreaseSize(this.elements);
        }
        if (val < this.min) {
            this.min = val;
        }
        this.elements[++pointer] = new Elem(val, this.min);
    }
    
    public void pop() {
        pointer--;
        if (pointer >= 0) {
            this.min = elements[pointer].min();
        } else {
            this.min = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return elements[pointer].val();
    }
    
    public int getMin() {
        return min;
    }

    private static <T> T[] copyAndIncreaseSize(T[] old) {
        int oldSize = old.length;
        int newSize = oldSize << 1;
        return Arrays.copyOf(old, newSize);
    }

    private record Elem(int val, int min){};
}
