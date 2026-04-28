public class Experiment {

    Sorter sorter = new Sorter();
    Searcher searcher = new Searcher();

    public long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.basicSort(arr);
        } else {
            sorter.advancedSort(arr);
        }

        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] small = sorter.generateRandomArray(10);
        int[] medium = sorter.generateRandomArray(100);
        int[] large = sorter.generateRandomArray(1000);

        System.out.println("Small array:");
        test(small);

        System.out.println("Medium array:");
        test(medium);

        System.out.println("Large array:");
        test(large);
    }

    private void test(int[] arr) {
        int[] copy1 = arr.clone();
        int[] copy2 = arr.clone();

        long t1 = measureSortTime(copy1, "basic");
        long t2 = measureSortTime(copy2, "advanced");

        long t3 = measureSearchTime(arr, arr[0]);

        System.out.println("Bubble sort time: " + t1);
        System.out.println("Quick sort time: " + t2);
        System.out.println("Search time: " + t3);
        System.out.println();
    }
}