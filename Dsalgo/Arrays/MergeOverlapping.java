import java.util.*;

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class MergeOverlapping {

    static void MergeIntervals(Interval a[]) {

        Arrays.sort(a, new Comparator<Interval>() {
            public int compare(Interval l1, Interval l2) {
                return l1.start - l2.start;
            }
        });

        int index = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[index].end > a[i].start) {
                a[index].end = Math.max(a[index].end, a[i].end);
                a[index].start = Math.max(a[index].start, a[i].start);
            } else {
                index++;
                a[index] = a[i];
            }
        }

        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= index; i++) {
            System.out.print("[" + a[i].start + "," + a[i].end + "]");
        }
    }

    public static void main(String[] args) {

        Interval a[] = new Interval[4];
        a[0] = new Interval(6, 8);
        a[1] = new Interval(1, 9);
        a[2] = new Interval(2, 4);
        a[3] = new Interval(4, 7);
        MergeIntervals(a);

    }

}