package fp.option;

import java.util.function.Function;

public interface Option<A> {
    <B> Option<B> map(Function<A, B> f);
    <B> Option<B> flatMap(Function<A, Option<B>> f);
    <B> B fold(B ifNone, Function<A, B> f);
}
