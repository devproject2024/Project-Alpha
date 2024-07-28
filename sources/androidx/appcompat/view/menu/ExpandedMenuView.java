package androidx.appcompat.view.menu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ac;

public final class ExpandedMenuView extends ListView implements AdapterView.OnItemClickListener, g.b, n {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1267a = {16842964, 16843049};

    /* renamed from: b  reason: collision with root package name */
    private g f1268b;

    /* renamed from: c  reason: collision with root package name */
    private int f1269c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ac a2 = ac.a(context, attributeSet, f1267a, i2, 0);
        if (a2.g(0)) {
            setBackgroundDrawable(a2.a(0));
        }
        if (a2.g(1)) {
            setDivider(a2.a(1));
        }
        a2.f1669a.recycle();
    }

    public final void a(g gVar) {
        this.f1268b = gVar;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final boolean a(i iVar) {
        return this.f1268b.a((MenuItem) iVar, (m) null, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
        a((i) getAdapter().getItem(i2));
    }

    public final int getWindowAnimations() {
        return this.f1269c;
    }
}
