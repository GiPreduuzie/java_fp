package fp.option;

import java.util.function.Function;

public class None implements Option {
    @Override
    public Option map(Function f) {
        return this;
    }

    @Override
    public Option flatMap(Function f) {
        return this;
    }

    @Override
    public String toString() {
        return "None";
    }

    @Override
    public Object fold(Object ifNone, Function f) {
        return ifNone;
    }
}
