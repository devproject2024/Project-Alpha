package net.one97.paytm.recharge.mobile_v3.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.i;
import net.one97.paytm.recharge.common.e.g;

public class CJROutstandingAmountDisplayValuesV3 extends RecyclerView implements g<net.one97.paytm.recharge.mobile_v3.c.a> {

    /* renamed from: c  reason: collision with root package name */
    public static final int f63955c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final a f63956d = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final int f63957e = 3;

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<CJRDisplayValues> f63958a;

    /* renamed from: b  reason: collision with root package name */
    public int f63959b;

    public final long c_(int i2) {
        return (long) i2;
    }

    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.v3_content_info_secondary_bill_status_2, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(pare…_status_2, parent, false)");
        return new net.one97.paytm.recharge.mobile_v3.c.a(inflate);
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        net.one97.paytm.recharge.mobile_v3.c.a aVar = (net.one97.paytm.recharge.mobile_v3.c.a) vVar;
        k.c(aVar, "holder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i3 = this.f63959b;
        int pow = i3 * ((int) Math.pow((double) i3, (double) i2));
        for (int i4 = i2 * i3; i4 < pow; i4++) {
            CJRDisplayValues cJRDisplayValues = this.f63958a.get(i4);
            k.a((Object) cJRDisplayValues, "displayVlaues[counter]");
            CJRDisplayValues cJRDisplayValues2 = cJRDisplayValues;
            String label = cJRDisplayValues2.getLabel();
            k.a((Object) label, "displayValue.label");
            String value = cJRDisplayValues2.getValue();
            k.a((Object) value, "displayValue.value");
            linkedHashMap.put(label, value);
        }
        aVar.a(linkedHashMap);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJROutstandingAmountDisplayValuesV3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "context");
        this.f63958a = new ArrayList<>();
        this.f63959b = f63955c;
        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        setAdapter(new i(this));
        new v().attachToRecyclerView(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CJROutstandingAmountDisplayValuesV3(Context context) {
        this(context, (AttributeSet) null);
        k.c(context, "context");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public int getItemCount() {
        return this.f63958a.size() / this.f63959b;
    }
}
