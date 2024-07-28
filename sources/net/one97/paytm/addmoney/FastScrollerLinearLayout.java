package net.one97.paytm.addmoney;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;

public final class FastScrollerLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f48009a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f48010b;

    /* renamed from: c  reason: collision with root package name */
    public a f48011c;

    /* renamed from: d  reason: collision with root package name */
    private int f48012d = -1;

    public interface a {
        void a(String str);
    }

    public final RecyclerView getParentRv() {
        RecyclerView recyclerView = this.f48009a;
        if (recyclerView == null) {
            k.a("parentRv");
        }
        return recyclerView;
    }

    public final void setParentRv(RecyclerView recyclerView) {
        k.c(recyclerView, "<set-?>");
        this.f48009a = recyclerView;
    }

    public final String[] getSectionList() {
        String[] strArr = this.f48010b;
        if (strArr == null) {
            k.a("sectionList");
        }
        return strArr;
    }

    public final void setSectionList(String[] strArr) {
        k.c(strArr, "<set-?>");
        this.f48010b = strArr;
    }

    public final a getListener() {
        a aVar = this.f48011c;
        if (aVar == null) {
            k.a("listener");
        }
        return aVar;
    }

    public final void setListener(a aVar) {
        k.c(aVar, "<set-?>");
        this.f48011c = aVar;
    }

    public final int getHighlightedPosition() {
        return this.f48012d;
    }

    public final void setHighlightedPosition(int i2) {
        this.f48012d = i2;
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
        this.f48009a = recyclerView;
        this.f48010b = strArr;
        this.f48011c = aVar;
        removeAllViews();
        String[] strArr2 = this.f48010b;
        if (strArr2 == null) {
            k.a("sectionList");
        }
        int length = strArr2.length;
        int i2 = 0;
        while (i2 < length) {
            String str = strArr2[i2];
            Object systemService = getContext().getSystemService("layout_inflater");
            if (systemService != null) {
                View inflate = ((LayoutInflater) systemService).inflate(R.layout.fast_scroll_item, (ViewGroup) null);
                k.a((Object) inflate, "(context.getSystemServic…t.fast_scroll_item, null)");
                View findViewById = inflate.findViewById(R.id.tv_fast_scroller_item);
                k.a((Object) findViewById, "childView.findViewById(R.id.tv_fast_scroller_item)");
                ((TextView) findViewById).setText(str);
                addView(inflate);
                i2++;
            } else {
                throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
            }
        }
        a(0);
        RecyclerView recyclerView2 = this.f48009a;
        if (recyclerView2 == null) {
            k.a("parentRv");
        }
        RecyclerView.a adapter = recyclerView2.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new b());
        }
    }

    public static final class b extends RecyclerView.c {
        b() {
        }

        public final void onChanged() {
            super.onChanged();
        }
    }

    public final void a(int i2) {
        int i3 = this.f48012d;
        this.f48012d = i2;
        if (i2 != i3) {
            if (i3 >= 0) {
                a(i3, R.color.text_grey);
            }
            a(i2, R.color.color_00b9f5);
        }
    }

    private final void a(int i2, int i3) {
        View childAt = getChildAt(i2);
        k.a((Object) childAt, "getChildAt(position)");
        View findViewById = childAt.findViewById(R.id.tv_fast_scroller_item);
        k.a((Object) findViewById, "child.findViewById(R.id.tv_fast_scroller_item)");
        TextView textView = (TextView) findViewById;
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        textView.setTextColor(androidx.core.content.b.c(context, i3));
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        k.c(motionEvent, "ev");
        int i2 = 0;
        if (motionEvent.getAction() == 1) {
            return false;
        }
        int round = Math.round(motionEvent.getY());
        int childCount = getChildCount();
        while (i2 < childCount) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                if (round >= childAt.getTop() && round <= childAt.getBottom() && i2 != this.f48012d) {
                    View findViewById = childAt.findViewById(R.id.tv_fast_scroller_item);
                    k.a((Object) findViewById, "child.findViewById(R.id.tv_fast_scroller_item)");
                    TextView textView = (TextView) findViewById;
                    RecyclerView recyclerView = this.f48009a;
                    if (recyclerView == null) {
                        k.a("parentRv");
                    }
                    RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                    Boolean valueOf = layoutManager != null ? Boolean.valueOf(layoutManager.isSmoothScrolling()) : null;
                    if (valueOf == null) {
                        k.a();
                    }
                    if (!valueOf.booleanValue()) {
                        a(i2);
                    }
                    a aVar = this.f48011c;
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
