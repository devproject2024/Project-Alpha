package okhttp3.internal.http2;

import i.e;
import java.io.IOException;
import java.util.List;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public boolean onHeaders(int i2, List<Header> list, boolean z) {
            return true;
        }

        public boolean onRequest(int i2, List<Header> list) {
            return true;
        }

        public void onReset(int i2, ErrorCode errorCode) {
        }

        public boolean onData(int i2, e eVar, int i3, boolean z) throws IOException {
            eVar.i((long) i3);
            return true;
        }
    };

    boolean onData(int i2, e eVar, int i3, boolean z) throws IOException;

    boolean onHeaders(int i2, List<Header> list, boolean z);

    boolean onRequest(int i2, List<Header> list);

    void onReset(int i2, ErrorCode errorCode);
}
