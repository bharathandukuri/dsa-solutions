class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        merge(nums, l, m, r);
    }
    
    void merge(int[] nums, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = nums[l + i];
        }

        for (int j = 0; j < n2; j++) {
            right[j] = nums[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                nums[l + k] = left[i];
                i++;
            } else {
                nums[l + k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[l + k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[l + k] = right[j];
            j++;
            k++;
        }
    }
}