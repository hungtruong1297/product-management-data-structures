public class MergeSort {

    // Divide
    // Sort
    // Merge

    public void sort(int[] numbers) {
        // {2,6,8,5,3} length: 5  middle 2
        if (numbers.length < 2) {
            return;
        }

        // Divide
        int middle = numbers.length / 2;
        int[] left = new int[middle];
        int[] right = new int[numbers.length - middle];

        System.arraycopy(numbers,0,left,0,middle);
        System.arraycopy(numbers,middle,right,0,numbers.length - middle);

        // Sort
        sort(left);
        sort(right);

        // Merge
        merge(left,right,numbers);
    }

    public void merge(int[] left, int[] right, int[] result) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Handle left-overs
        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

}