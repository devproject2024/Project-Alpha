package net.one97.paytm.passbook.spendanalytics.piechart;

import android.content.Context;
import android.util.AttributeSet;
import java.util.ArrayList;

public class CircularGraphView extends AbstractCircularGraphView {

    /* renamed from: e  reason: collision with root package name */
    public a f58589e;

    public interface a {
        void a(int i2);
    }

    public CircularGraphView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CircularGraphView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public CircularGraphView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public final void a(int i2) {
        a aVar = this.f58589e;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public void setOnItemClickListener(a aVar) {
        this.f58589e = aVar;
    }

    public void setData(ArrayList<a> arrayList) {
        c();
        this.f58579b = arrayList;
        a();
        invalidate();
    }
}
