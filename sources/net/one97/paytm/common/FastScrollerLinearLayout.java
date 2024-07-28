package net.one97.paytm.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.wallet.R;

public final class FastScrollerLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f49582a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f49583b;

    /* renamed from: c  reason: collision with root package name */
    public a f49584c;

    /* renamed from: d  reason: collision with root package name */
    private int f49585d = -1;

    public interface a {
        void a(String str);
    }

    public final RecyclerView getParentRv() {
        RecyclerView recyclerView = this.f49582a;
        if (recyclerView == null) {
            k.a("parentRv");
        }
        return recyclerView;
    }

    public final void setParentRv(RecyclerView recyclerView) {
        k.c(recyclerView, "<set-?>");
        this.f49582a = recyclerView;
    }

    public final String[] getSectionList() {
        String[] strArr = this.f49583b;
        if (strArr == null) {
            k.a("sectionList");
        }
        return strArr;
    }

    public final void setSectionList(String[] strArr) {
        k.c(strArr, "<set-?>");
        this.f49583b = strArr;
    }

    public final a getListener() {
        a aVar = this.f49584c;
        if (aVar == null) {
            k.a("listener");
        }
        return aVar;
    }

    public final void setListener(a aVar) {
        k.c(aVar, "<set-?>");
        this.f49584c = aVar;
    }

    public final int getHighlightedPosition() {
        return this.f49585d;
    }

    public final void setHighlightedPosition(int i2) {
        this.f49585d = i2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastScrollerLinearLayout(Context context) {
        super(context);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastScrollerLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FastScrollerLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        k.c(context, "context");
    }

    public final void setUpWithRecyclerView(RecyclerView recyclerView, String[] strArr, a aVar) {
        k.c(recyclerView, "recyclerView");
        k.c(strArr, "headerList");
        k.c(aVar, "listener");
        setOrientation(1);
        this.f49582a = recyclerView;
        this.f49583b = strArr;
        this.f49584c = aVar;
        removeAllViews();
        String[] strArr2 = this.f49583b;
        if (strArr2 == null) {
            k.a("sectionList");
        }
        for (String text : strArr2) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fast_scroll_item, (ViewGroup) null);
            k.a((Object) inflate, "LayoutInflater.from(cont…t.fast_scroll_item, null)");
            View findViewById = inflate.findViewById(R.id.tv_fast_scroller_item);
            k.a((Object) findViewById, "childView.findViewById(R.id.tv_fast_scroller_item)");
            ((TextView) findViewById).setText(text);
            addView(inflate);
        }
        a(0);
    }

    public final void a(int i2) {
        int i3 = this.f49585d;
        this.f49585d = i2;
        if (i2 != i3) {
            if (i3 >= 0) {
                a(i3, R.color.color_999999);
            }
            a(i2, R.color.color_00b9f5);
        }
    }

    private final void a(int i2, int i3) {
        View childAt = getChildAt(i2);
        k.a((Object) childAt, "getChildAt(position)");
        View findViewById = childAt.findViewById(R.id.tv_fast_scroller_item);
        k.a((Object) findViewById, "child.findViewById(R.id.tv_fast_scroller_item)");
        getContext();
        ((TextView) findViewById).setTextColor(b.c(getContext(), i3));
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, "ev");
        if (motionEvent.getAction() == 1) {
            return false;
        }
        int round = Math.round(motionEvent.getY());
        int childCount = getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                if (round >= childAt.getTop() && round <= childAt.getBottom() && i2 != this.f49585d) {
                    View findViewById = childAt.findViewById(R.id.tv_fast_scroller_item);
                    k.a((Object) findViewById, "child.findViewById(R.id.tv_fast_scroller_item)");
                    TextView textView = (TextView) findViewById;
                    RecyclerView recyclerView = this.f49582a;
                    if (recyclerView == null) {
                        k.a("parentRv");
                    }
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    if (!(layoutManager != null ? layoutManager.isSmoothScrolling() : false)) {
                        a(i2);
                    }
                    a aVar = this.f49584c;
                    if (aVar == null) {
                        k.a("listener");
                    }
                    aVar.a(textView.getText().toString());
                }
                i2++;
            } else {
                throw new u("null cannot be cast to non-null type android.view.View");
            }
        }
        return true;
    }
}
