package net.one97.paytm.paymentsBank.pdc.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.f.f;
import net.one97.paytm.payments.b.b.a;
import net.one97.paytm.paymentsBank.pdc.view.d;

public final class b implements f, net.one97.paytm.paymentsBank.pdc.d.b.b {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.paymentsBank.pdc.c.b.b f18713a;

    /* renamed from: b  reason: collision with root package name */
    private d f18714b;

    /* renamed from: c  reason: collision with root package name */
    private String f18715c;

    /* renamed from: d  reason: collision with root package name */
    private String f18716d;

    /* renamed from: e  reason: collision with root package name */
    private String f18717e;

    /* renamed from: f  reason: collision with root package name */
    private String f18718f;

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
    }

    public final void a(NetworkCustomError networkCustomError) {
    }

    public b(d dVar, net.one97.paytm.paymentsBank.pdc.c.a.b bVar) {
        this.f18714b = dVar;
        this.f18713a = bVar;
    }

    public final void a(String str) {
        this.f18715c = str;
    }

    public final void a() {
        if (a.f17207a.equals(this.f18715c)) {
            if (!TextUtils.isEmpty(this.f18716d)) {
            }
        } else if (a.f17208b.equals(this.f18715c)) {
            this.f18714b.a(this.f18715c, this.f18717e, this.f18718f);
        }
    }

    public final void b() {
        this.f18714b.b(this.f18715c);
    }

    public final void a(String str, String str2) {
        this.f18717e = str;
        this.f18718f = str2;
    }

    public final void c() {
        this.f18714b = null;
    }

    public final void a(Context context) {
        this.f18714b.b();
        this.f18713a.a(context, this);
    }
}
