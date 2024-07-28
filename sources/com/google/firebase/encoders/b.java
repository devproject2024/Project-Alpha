package com.google.firebase.encoders;

import java.io.IOException;

public interface b<TValue, TContext> {
    void a(TValue tvalue, TContext tcontext) throws IOException;
}
