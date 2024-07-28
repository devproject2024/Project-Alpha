package net.one97.paytm.feed.utility;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class PeekingLinearLayoutManager extends LinearLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    private final float f35380a = 0.9f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeekingLinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        k.c(context, "context");
        k.c(attributeSet, "attrs");
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        RecyclerView.LayoutParams generateDefaultLayoutParams = super.generateDefaultLayoutParams();
        k.a((Object) generateDefaultLayoutParams, "super.generateDefaultLayoutParams()");
        return a(generateDefaultLayoutParams);
    }

    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        RecyclerView.LayoutParams generateLayoutParams = super.generateLayoutParams(layoutParams);
        k.a((Object) generateLayoutParams, "super.generateLayoutParams(lp)");
        return a(generateLayoutParams);
    }

    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RecyclerView.LayoutParams generateLayoutParams = super.generateLayoutParams(context, attributeSet);
        k.a((Object) generateLayoutParams, "super.generateLayoutParams(c, attrs)");
        return a(generateLayoutParams);
    }

    private final RecyclerView.LayoutParams a(RecyclerView.LayoutParams layoutParams) {
        int orientation = getOrientation();
        if (orientation == 0) {
            layoutParams.width = (int) (((float) a()) * this.f35380a);
        } else if (orientation == 1) {
            layoutParams.height = (int) (((float) b()) * this.f35380a);
        }
        return layoutParams;
    }

    private final int a() {
        return (getWidth() - getPaddingStart()) - getPaddingEnd();
    }

    private final int b() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }
}
