package fp.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

public class RichArrayList<A> {

    private final ArrayList<A> arrayList;

    public static <A> RichArrayList<A> create(A... params) {
        ArrayList<A> a = new ArrayList<A>();
        Collections.addAll(a, params);
        return new RichArrayList<A>(a);
    }

    public static <A> RichArrayList<A> fill(A element, int times) {
        ArrayList<A> a = new ArrayList<A>();
        for (int i = 0; i < times; i++) {
            a.add(element);
        }
        return new RichArrayList<A>(a);
    }

    public RichArrayList(ArrayList<A> arrayList) {
        this.arrayList = arrayList;
    }

    public <B> RichArrayList<B> map(Function<A, B> f) {
        ArrayList<B> newArrayList = new ArrayList<B>();
        for (A item : arrayList) {
            newArrayList.add(f.apply(item));
        }
        return new RichArrayList<B>(newArrayList);
    }

    public RichArrayList<A> filter(Predicate<A> p) {
        ArrayList<A> newArrayList = new ArrayList<A>();
        for (A item : arrayList) {
            if (p.test(item)) {
                newArrayList.add(item);
            }
        }
        return new RichArrayList<A>(newArrayList);
    }

    public <B> B foldLeft(B accum, BiFunction<A, B, B> f) {
        B myAccum = accum;
        for (A item : arrayList) {
            myAccum = f.apply(item, myAccum);
        }
        return myAccum;
    }

    public <B> RichArrayList<B> flatMap(Function<A, RichArrayList<B>> f) {
        ArrayList<B> newArrayList = new ArrayList<B>();
        for (A item : arrayList) {
            newArrayList.addAll(f.apply(item).arrayList);
        }
        return new RichArrayList<B>(newArrayList);
    }

    @Override
    public String toString() {
        return arrayList.toString();
    }
}
