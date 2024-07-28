package net.one97.paytm.recharge.common.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.o;
import net.one97.paytm.recharge.common.widget.CJRSelectOperatorViewV8;
import net.one97.paytm.recharge.model.v4.CJRAggsItem;

public final class AJRRechargeOperatorSelectionV8 extends AJRRechargeOperatorListV4 implements o {

    /* renamed from: a  reason: collision with root package name */
    private int f60793a = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f60794i;

    /* access modifiers changed from: protected */
    public final boolean g() {
        return true;
    }

    public AJRRechargeOperatorSelectionV8() {
        CJRSelectOperatorViewV8.a aVar = CJRSelectOperatorViewV8.f61954f;
        this.f60794i = CJRSelectOperatorViewV8.j;
    }

    public final void a() {
        setContentView(R.layout.activity_operator_list_v8);
    }

    /* access modifiers changed from: protected */
    public final String f() {
        String f2 = super.f();
        k.a((Object) f2, "super.getToolbarTitle()");
        return f2;
    }

    public final void b() {
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("flightSelectedFilter")) {
            this.f60793a = extras.getInt("flightSelectedFilter");
            extras.remove("flightSelectedFilter");
        }
        if (extras != null && extras.containsKey("view_type_brand")) {
            this.f60794i = extras.getInt("view_type_brand");
        }
        super.b();
    }

    /* access modifiers changed from: protected */
    public final void h() {
        FrameLayout frameLayout = this.f60782f;
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        FrameLayout frameLayout2 = this.f60782f;
        if (frameLayout2 != null) {
            CJRSelectOperatorViewV8.b bVar = new CJRSelectOperatorViewV8.b();
            bVar.f61964b = true;
            List list = this.f60778b;
            k.a((Object) list, "variantList");
            CJRSelectOperatorViewV8.b a2 = bVar.a((List<CJRAggsItem>) list);
            a2.f61970h = this.f60794i;
            a2.f61965c = this.f60793a;
            frameLayout2.addView(new CJRSelectOperatorViewV8(this, a2.a((o) this)));
        }
        b(8);
    }

    public final void a(CJRAggsItem cJRAggsItem, int i2) {
        k.c(cJRAggsItem, "operatorItem");
        a(cJRAggsItem);
    }
}
