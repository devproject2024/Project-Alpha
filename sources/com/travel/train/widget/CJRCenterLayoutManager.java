package com.travel.train.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;

public class CJRCenterLayoutManager extends LinearLayoutManager {
    public CJRCenterLayoutManager(Context context) {
        super(context);
    }

    public CJRCenterLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i2);
        startSmoothScroll(aVar);
    }

    static class a extends p {
        a(Context context) {
            super(context);
        }

        public final int calculateDtToFit(int i2, int i3, int i4, int i5, int i6) {
            return (i4 + ((i5 - i4) / 6)) - (i2 + ((i3 - i2) / 6));
        }
    }
}
