public class BinarySearchRecursive {
    public static int binarySearch(int[] arr, int key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (arr[mid] > key) {
            return binarySearch(arr, key, left, mid - 1);
        } else {
            return binarySearch(arr, key, mid + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 30;
        int result = binarySearch(arr, key, 0, arr.length - 1);
        System.out.println("Element found at index: " + result);
    }
}
