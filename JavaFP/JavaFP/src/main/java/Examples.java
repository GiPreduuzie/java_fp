import fp.collections.RichArrayList;

public class Examples {
    public static void main(String[] args) {
        //---------1----------
        RichArrayList<Integer> xx =
                RichArrayList
                        .create("1", "2", "3", "4")
                        .map(Integer::parseInt)
                        .filter(x -> x % 2 == 0)
                        .map(x -> x * x + 1);
        System.out.println(xx);
        // [5, 17]
        //---------2----------
        System.out.println(RichArrayList.create(1, 2, 3, 4, 5)
                .foldLeft(0, Integer::sum));
        // 15
        //---------3----------
        System.out.println(RichArrayList
                .create(1, 2, 3, 4, 5)
                .flatMap(x -> RichArrayList.fill(x, x)));
        // [1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5]
    }
}
