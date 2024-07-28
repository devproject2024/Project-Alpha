package com.squareup.okhttp.internal.framed;

import i.e;
import i.f;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;

public interface FrameReader extends Closeable {

    public interface Handler {
        void ackSettings();

        void alternateService(int i2, String str, f fVar, String str2, int i3, long j);

        void data(boolean z, int i2, e eVar, int i3) throws IOException;

        void goAway(int i2, ErrorCode errorCode, f fVar);

        void headers(boolean z, boolean z2, int i2, int i3, List<Header> list, HeadersMode headersMode);

        void ping(boolean z, int i2, int i3);

        void priority(int i2, int i3, int i4, boolean z);

        void pushPromise(int i2, int i3, List<Header> list) throws IOException;

        void rstStream(int i2, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i2, long j);
    }

    boolean nextFrame(Handler handler) throws IOException;

    void readConnectionPreface() throws IOException;
}
