public class FindSmallestLargetThanTarget {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 9};
        int target = 6;
        FindSmallestLargetThanTargetSolution test = new FindSmallestLargetThanTargetSolution();
        int res = test.smallestLarger(array, target);
        System.out.print(res);
    }
}

class FindSmallestLargetThanTargetSolution {
    public int smallestLarger(int[] array, int target) {
        //corner case
        if (array == null || array.length == 0) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                //keep searching right excluding mid
                left = mid + 1;
            } else if (array[mid] < target) {
                //keep searching right excluding mid
                left = mid + 1;
            } else {
                //keeping search left including mid
                right = mid;
            }
        }
        //post process 1 element
        if (array[left] > target) {
            return left;
        }
        return -1;
    }
}