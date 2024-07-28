package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.e;

@Deprecated
public class PlaybackControlView extends PlayerControlView {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final a f33540a = new b((byte) 0);

    @Deprecated
    public interface a extends d {
    }

    @Deprecated
    static final class b extends e implements a {
        private b() {
        }

        /* synthetic */ b(byte b2) {
            this();
        }
    }

    public PlaybackControlView(Context context) {
        super(context);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public PlaybackControlView(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) {
        super(context, attributeSet, i2, attributeSet2);
    }
}
