public class LinearSearchRecursive {
    public static int linearSearchRecursive(int[] arr, int key, int index) {
        if (index >= arr.length) {
            return -1;
        }
        if (arr[index] == key) {
            return index;
        }
        return linearSearchRecursive(arr, key, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 30;
        int result = linearSearchRecursive(arr, key, 0);
        System.out.println("Element found at index: " + result);
    }
}
