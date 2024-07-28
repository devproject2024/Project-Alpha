package com.jackpocket.scratchoff.views;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.jackpocket.scratchoff.c;

public class ScratchableLinearLayout extends LinearLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f40819a;

    public ScratchableLinearLayout(Context context) {
        super(context);
    }

    public ScratchableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ScratchableLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public final void a(c cVar) {
        this.f40819a = cVar;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c cVar = this.f40819a;
        if (cVar != null) {
            cVar.a(canvas);
        }
    }
}
