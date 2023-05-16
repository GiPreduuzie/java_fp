import fp.collections.RichArrayList;
import fp.option.None;
import fp.option.Option;
import fp.option.RichOption;
import fp.option.Some;

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
        //---------4----------
        System.out.println(new Some<Integer>(1).map(x -> x + 1));
        System.out.println(((Option<Integer>)new None()).map(x -> x + 1));
        System.out.println(RichOption.some(1).map(x -> x + 1));
        System.out.println(RichOption.none());
        System.out.println(RichArrayList.create(
                RichOption.some(1),
                RichOption.some(2),
                RichOption.<Integer>none(),
                RichOption.some(3)
        ).map(x -> x.map(y -> y + 1)));
        System.out.println(RichArrayList.create(1,2,3, null, 5).map(RichOption::create));
        System.out.println(RichOption.create(RichOption.create(1)).flatMap(x -> x));

    }
}
