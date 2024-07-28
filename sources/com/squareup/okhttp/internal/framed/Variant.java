package com.squareup.okhttp.internal.framed;

import com.squareup.okhttp.Protocol;
import i.d;
import i.e;

public interface Variant {
    Protocol getProtocol();

    FrameReader newReader(e eVar, boolean z);

    FrameWriter newWriter(d dVar, boolean z);
}
