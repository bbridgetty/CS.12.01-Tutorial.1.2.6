public class Mountain {

    /** @param array an array of positive integer values

     @param stop the last index to check
     Precondition: 0 <= stop < array.length
     @return true if for each j such that 0 <= j < stop, array[j] < array[j + 1] ;
     false otherwise
     */

    public static boolean isIncreasing(int[] array, int stop) {
        for (int j = 0; j < stop; j++) {
            if (array[j] >= array[j + 1]) {
                return false;
            }
        }
        return true;
    }
    /** @param array an array of positive integer values

     @param start the first index to check
     Precondition: 0 <= start < array.length - 1
     @return true if for each j such that start <= j < array.length - 1,
     array[j] > array[j + 1];
     false otherwise
     */

    public static boolean isDecreasing(int[] array, int start) {
        for (int j = start; j < array.length - 1; j++) {
            if (array[j] <= array[j + 1]) {
                return false;
                // If the current element is less than or equal to the next element, return false
            }
        }
        return true;
    }

    public static int getPeakIndex(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isMountain(int[] array) { // Check if the array forms a mountain pattern
        int peakIndex = getPeakIndex(array);

        if (peakIndex == -1 || peakIndex == 0 || peakIndex == array.length - 1) {
            return false;
        }
// Check if the array is increasing before the peak and decreasing after the peak
        return isIncreasing(array, peakIndex) && isDecreasing(array, peakIndex);
    }
}

