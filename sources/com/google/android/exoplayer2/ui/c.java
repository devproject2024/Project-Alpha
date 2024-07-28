package com.google.android.exoplayer2.ui;

public interface c {

    public interface a {
        void a(long j);

        void a(long j, boolean z);

        void b(long j);
    }

    void a(a aVar);

    long getPreferredUpdateDelay();

    void setAdGroupTimesMs(long[] jArr, boolean[] zArr, int i2);

    void setBufferedPosition(long j);

    void setDuration(long j);

    void setEnabled(boolean z);

    void setPosition(long j);
}
