package fp.option;


public class RichOption {
    public static <A> Option<A> some(A value) {
        return new Some<A>(value);
    }

    public static <A> Option<A> none() {
        return new None();
    }

    public static <A> Option<A> create(A value) {
        return value == null ? none() : some(value);
    }
}
