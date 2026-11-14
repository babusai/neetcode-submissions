class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int mid;
        while (rowStart <= rowEnd) {
            mid = rowStart + (rowEnd - rowStart) / 2;

            if (target < matrix[mid][0]) {
                if (target < matrix[rowStart][0]) {
                    return false;
                }
                rowEnd = mid - 1;
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                if (target > matrix[rowEnd][matrix[rowEnd].length - 1]) {
                    return false;
                }
                rowStart = mid + 1;
            } else if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                return binarySearch(matrix[mid], target);
            } else {
                return false;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        int mid;
        do {
            mid = start + (end - start) / 2;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        } while (start <= end && arr[mid] != target);

        return arr[mid] == target;
    }
}