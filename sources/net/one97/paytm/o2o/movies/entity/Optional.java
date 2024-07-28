package net.one97.paytm.o2o.movies.entity;

import java.util.NoSuchElementException;

public class Optional<M> {
    private final M optional;

    public Optional(M m) {
        this.optional = m;
    }

    public boolean isEmpty() {
        return this.optional == null;
    }

    public M get() {
        M m = this.optional;
        if (m != null) {
            return m;
        }
        throw new NoSuchElementException("No value present");
    }
}
