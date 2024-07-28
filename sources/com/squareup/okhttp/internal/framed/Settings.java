package com.squareup.okhttp.internal.framed;

import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.Arrays;
import net.one97.paytm.upi.util.UpiConstants;

public final class Settings {
    static final int CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    static final int COUNT = 10;
    static final int CURRENT_CWND = 5;
    static final int DEFAULT_INITIAL_WINDOW_SIZE = 65536;
    static final int DOWNLOAD_BANDWIDTH = 2;
    static final int DOWNLOAD_RETRANS_RATE = 6;
    static final int ENABLE_PUSH = 2;
    static final int FLAG_CLEAR_PREVIOUSLY_PERSISTED_SETTINGS = 1;
    static final int FLOW_CONTROL_OPTIONS = 10;
    static final int FLOW_CONTROL_OPTIONS_DISABLED = 1;
    static final int HEADER_TABLE_SIZE = 1;
    static final int INITIAL_WINDOW_SIZE = 7;
    static final int MAX_CONCURRENT_STREAMS = 4;
    static final int MAX_FRAME_SIZE = 5;
    static final int MAX_HEADER_LIST_SIZE = 6;
    static final int PERSISTED = 2;
    static final int PERSIST_VALUE = 1;
    static final int ROUND_TRIP_TIME = 3;
    static final int UPLOAD_BANDWIDTH = 1;
    private int persistValue;
    private int persisted;
    private int set;
    private final int[] values = new int[10];

    /* access modifiers changed from: package-private */
    public final void clear() {
        this.persisted = 0;
        this.persistValue = 0;
        this.set = 0;
        Arrays.fill(this.values, 0);
    }

    /* access modifiers changed from: package-private */
    public final Settings set(int i2, int i3, int i4) {
        if (i2 >= this.values.length) {
            return this;
        }
        int i5 = 1 << i2;
        this.set |= i5;
        if ((i3 & 1) != 0) {
            this.persistValue |= i5;
        } else {
            this.persistValue &= ~i5;
        }
        if ((i3 & 2) != 0) {
            this.persisted |= i5;
        } else {
            this.persisted &= ~i5;
        }
        this.values[i2] = i4;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final boolean isSet(int i2) {
        return ((1 << i2) & this.set) != 0;
    }

    /* access modifiers changed from: package-private */
    public final int get(int i2) {
        return this.values[i2];
    }

    /* access modifiers changed from: package-private */
    public final int flags(int i2) {
        int i3 = isPersisted(i2) ? 2 : 0;
        return persistValue(i2) ? i3 | 1 : i3;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return Integer.bitCount(this.set);
    }

    /* access modifiers changed from: package-private */
    public final int getUploadBandwidth(int i2) {
        return (this.set & 2) != 0 ? this.values[1] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public final int getDownloadBandwidth(int i2) {
        return (this.set & 4) != 0 ? this.values[2] : i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean getEnablePush(boolean z) {
        return ((this.set & 4) != 0 ? this.values[2] : z ? 1 : 0) == 1;
    }

    /* access modifiers changed from: package-private */
    public final int getRoundTripTime(int i2) {
        return (this.set & 8) != 0 ? this.values[3] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxConcurrentStreams(int i2) {
        return (this.set & 16) != 0 ? this.values[4] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getCurrentCwnd(int i2) {
        return (this.set & 32) != 0 ? this.values[5] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxFrameSize(int i2) {
        return (this.set & 32) != 0 ? this.values[5] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getDownloadRetransRate(int i2) {
        return (this.set & 64) != 0 ? this.values[6] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxHeaderListSize(int i2) {
        return (this.set & 64) != 0 ? this.values[6] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getInitialWindowSize(int i2) {
        return (this.set & 128) != 0 ? this.values[7] : i2;
    }

    /* access modifiers changed from: package-private */
    public final int getClientCertificateVectorSize(int i2) {
        return (this.set & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? this.values[8] : i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean isFlowControlDisabled() {
        return (((this.set & TarConstants.EOF_BLOCK) != 0 ? this.values[10] : 0) & 1) != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean persistValue(int i2) {
        return ((1 << i2) & this.persistValue) != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPersisted(int i2) {
        return ((1 << i2) & this.persisted) != 0;
    }

    /* access modifiers changed from: package-private */
    public final void merge(Settings settings) {
        for (int i2 = 0; i2 < 10; i2++) {
            if (settings.isSet(i2)) {
                set(i2, settings.flags(i2), settings.get(i2));
            }
        }
    }
}
