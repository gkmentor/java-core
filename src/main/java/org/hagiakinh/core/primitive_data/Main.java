package org.hagiakinh.core.primitive_data;

public class Main {

    // Biến static a = 10 sẽ được cấp phát bộ nhớ trong Metaspace(method area) khi lớp Main được nạp,
    // và sẽ tồn tại cho đến khi chương trình kết thúc hoặc lớp Main bị xóa khỏi bộ nhớ.
    private static int a = 10;

    private static class HeapClass {
        public int y; // Khi một instance của HeapClass được cấp phát, biến này sẽ nằm trên heap.
    }
    public static void main(String[] args) {
        int x = 1; // Biến này nằm trên stack.
    }
}





