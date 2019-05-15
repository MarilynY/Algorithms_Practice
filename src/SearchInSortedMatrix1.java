public class SearchInSortedMatrix1 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 4, 5}, {6, 7, 8, 9}};
        SearchInSortedMatrix1Solution test = new SearchInSortedMatrix1Solution();
        int[] res = test.search(matrix, 7);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}

class SearchInSortedMatrix1Solution {
    public int[] search(int[][] matrix, int target) {
        // Write your solution here
        int row = matrix.length;
        int col = matrix[0].length;
        //corner case
        if (row == 0 || col == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = row * col - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / col][mid % col] == target) {
                return new int[]{mid / col, mid % col};
            } else if (matrix[mid / col][mid % col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //if target was not found
        return new int[]{-1, -1};
    }
}
//Time = O（logrow*col）
//Space = O(1)