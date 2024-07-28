package net.one97.paytm.moneytransfer.contacts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.moneytransfer.R;

public final class FastScrollerLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f53894a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f53895b;

    /* renamed from: c  reason: collision with root package name */
    public a f53896c;

    /* renamed from: d  reason: collision with root package name */
    private int f53897d = -1;

    public interface a {
        void a(String str);
    }

    public final RecyclerView getParentRv() {
        RecyclerView recyclerView = this.f53894a;
        if (recyclerView == null) {
            k.a("parentRv");
        }
        return recyclerView;
    }

    public final void setParentRv(RecyclerView recyclerView) {
        k.c(recyclerView, "<set-?>");
        this.f53894a = recyclerView;
    }

    public final String[] getSectionList() {
        String[] strArr = this.f53895b;
        if (strArr == null) {
            k.a("sectionList");
        }
        return strArr;
    }

    public final void setSectionList(String[] strArr) {
        k.c(strArr, "<set-?>");
        this.f53895b = strArr;
    }

    public final a getListener() {
        a aVar = this.f53896c;
        if (aVar == null) {
            k.a("listener");
        }
        return aVar;
    }

    public final void setListener(a aVar) {
        k.c(aVar, "<set-?>");
        this.f53896c = aVar;
    }

    public final int getHighlightedPosition() {
        return this.f53897d;
    }

    public final void setHighlightedPosition(int i2) {
        this.f53897d = i2;
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
        RecyclerView.a adapter;
        k.c(recyclerView, "recyclerView");
        k.c(strArr, "headerList");
        k.c(aVar, "listener");
        setOrientation(1);
        this.f53894a = recyclerView;
        this.f53895b = strArr;
        this.f53896c = aVar;
        removeAllViews();
        String[] strArr2 = this.f53895b;
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
        RecyclerView recyclerView2 = this.f53894a;
        if (recyclerView2 == null) {
            k.a("parentRv");
        }
        if (recyclerView2 != null && (adapter = recyclerView2.getAdapter()) != null) {
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
        int i3 = this.f53897d;
        this.f53897d = i2;
        if (i2 != i3) {
            if (i3 >= 0) {
                a(i3, R.color.mt_grey_color);
            }
            a(i2, R.color.mt_blue_paytm);
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

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        r4 = r4.getLayoutManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ev"
            kotlin.g.b.k.c(r7, r0)
            int r0 = r7.getAction()
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x000e
            return r1
        L_0x000e:
            float r7 = r7.getY()
            int r7 = java.lang.Math.round(r7)
            int r0 = r6.getChildCount()
        L_0x001a:
            if (r1 >= r0) goto L_0x0087
            android.view.View r3 = r6.getChildAt(r1)
            if (r3 == 0) goto L_0x007f
            int r4 = r3.getTop()
            if (r7 < r4) goto L_0x007c
            int r4 = r3.getBottom()
            if (r7 > r4) goto L_0x007c
            int r4 = r6.f53897d
            if (r1 == r4) goto L_0x007c
            int r4 = net.one97.paytm.moneytransfer.R.id.tv_fast_scroller_item
            android.view.View r3 = r3.findViewById(r4)
            java.lang.String r4 = "child.findViewById(R.id.tv_fast_scroller_item)"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            android.widget.TextView r3 = (android.widget.TextView) r3
            androidx.recyclerview.widget.RecyclerView r4 = r6.f53894a
            if (r4 != 0) goto L_0x0048
            java.lang.String r5 = "parentRv"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0048:
            if (r4 == 0) goto L_0x0059
            androidx.recyclerview.widget.RecyclerView$LayoutManager r4 = r4.getLayoutManager()
            if (r4 == 0) goto L_0x0059
            boolean r4 = r4.isSmoothScrolling()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x005a
        L_0x0059:
            r4 = 0
        L_0x005a:
            if (r4 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0068
            r6.a(r1)
        L_0x0068:
            net.one97.paytm.moneytransfer.contacts.FastScrollerLinearLayout$a r4 = r6.f53896c
            if (r4 != 0) goto L_0x0071
            java.lang.String r5 = "listener"
            kotlin.g.b.k.a((java.lang.String) r5)
        L_0x0071:
            java.lang.CharSequence r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r4.a(r3)
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x001a
        L_0x007f:
            kotlin.u r7 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type android.view.View"
            r7.<init>(r0)
            throw r7
        L_0x0087:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.moneytransfer.contacts.FastScrollerLinearLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
