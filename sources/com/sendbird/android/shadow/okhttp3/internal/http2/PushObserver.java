package com.sendbird.android.shadow.okhttp3.internal.http2;

import com.sendbird.android.shadow.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public final boolean onHeaders(int i2, List<Header> list, boolean z) {
            return true;
        }

        public final boolean onRequest(int i2, List<Header> list) {
            return true;
        }

        public final void onReset(int i2, ErrorCode errorCode) {
        }

        public final boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException {
            bufferedSource.skip((long) i3);
            return true;
        }
    };

    boolean onData(int i2, BufferedSource bufferedSource, int i3, boolean z) throws IOException;

    boolean onHeaders(int i2, List<Header> list, boolean z);

    boolean onRequest(int i2, List<Header> list);

    void onReset(int i2, ErrorCode errorCode);
}
