package com.google.android.youtube.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.youtube.player.internal.a;

public final class YouTubeThumbnailView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private a f37544a;

    public YouTubeThumbnailView(Context context) {
        this(context, (AttributeSet) null);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public YouTubeThumbnailView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        a aVar = this.f37544a;
        if (aVar != null) {
            if (aVar.a()) {
                String.format("The finalize() method for a YouTubeThumbnailLoader has work to do. You should have called release().", new Object[0]);
                if (aVar.a()) {
                    aVar.f37560b = true;
                    aVar.f37559a = null;
                }
            }
            this.f37544a = null;
        }
        super.finalize();
    }
}
