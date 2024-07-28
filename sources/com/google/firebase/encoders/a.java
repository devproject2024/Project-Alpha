package com.google.firebase.encoders;

import java.io.IOException;
import java.io.Writer;

public interface a {
    String a(Object obj);

    void a(Object obj, Writer writer) throws IOException;
}
