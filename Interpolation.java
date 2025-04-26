public class InterpolationSearch {

    public static int interpolationSearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            // Avoid division by zero
            if (arr[high] == arr[low]) {
                if (arr[low] == target) {
                    return low;
                } else {
                    break;
                }
            }

            // Estimate position
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            // Check bounds
            if (pos < low || pos > high) {
                break;
            }

            if (arr[pos] == target) {
                return pos;
            } else if (arr[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int target = 70;

        int index = interpolationSearch(arr, target);

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}

