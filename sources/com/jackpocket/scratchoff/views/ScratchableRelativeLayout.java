package com.jackpocket.scratchoff.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.jackpocket.scratchoff.c;

public class ScratchableRelativeLayout extends RelativeLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f40820a;

    public ScratchableRelativeLayout(Context context) {
        super(context);
    }

    public ScratchableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScratchableRelativeLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void a(c cVar) {
        this.f40820a = cVar;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c cVar = this.f40820a;
        if (cVar != null) {
            cVar.a(canvas);
        }
    }
}
