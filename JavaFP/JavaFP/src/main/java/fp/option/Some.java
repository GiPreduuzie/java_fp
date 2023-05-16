package fp.option;

import java.util.function.Function;

public class Some<A> implements Option<A> {
    A value;

    public Some(A value) {
        this.value = value;
    }

    @Override
    public <B> Option<B> map(Function<A, B> f) {
        return new Some<>(f.apply(value));
    }

    @Override
    public <B> Option<B> flatMap(Function<A, Option<B>> f) {
        return f.apply(value);
    }

    @Override
    public <B> B fold(B ifNone, Function<A, B> f) {
        return f.apply(value);
    }

    @Override
    public String toString() {
        return "Some(" + value +  ")";
    }
}
