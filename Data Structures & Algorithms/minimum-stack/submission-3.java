class MinStack {

    private Elem[] elements;
    private int pointer;

    public MinStack() {
        this.elements = new Elem[128];
        this.pointer = -1;
    }
    
    public void push(int val) {
        if (pointer == this.elements.length - 1) {
            this.elements = copyAndIncreaseSize(this.elements);
        }
        int prevMin = getMin();
        this.elements[++pointer] = new Elem(val, val < prevMin ? val : prevMin);
    }
    
    public void pop() {
        this.elements[pointer] = null;
        pointer--;
    }
    
    public int top() {
        return elements[pointer].val();
    }
    
    public int getMin() {
        if (pointer < 0) {
            return Integer.MAX_VALUE;
        }
        return elements[pointer].min();
    }

    private static <T> T[] copyAndIncreaseSize(T[] old) {
        int oldSize = old.length;
        int newSize = oldSize << 1;
        return Arrays.copyOf(old, newSize);
    }

    private record Elem(int val, int min){}
}
