package net.one97.paytm.fastag.b;

import android.content.Context;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.fastag.d.b;
import net.one97.paytm.fastag.d.c;
import net.one97.paytm.fastag.d.d;
import net.one97.paytm.fastag.d.e;
import net.one97.paytm.fastag.d.g;
import net.one97.paytm.fastag.ui.activity.FasTagKYCActivity;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f13556a;

    public a(Context context) {
        this.f13556a = context.getApplicationContext();
    }

    /* access modifiers changed from: protected */
    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, b bVar) {
        final b bVar2 = bVar;
        new HashMap().put("screen_name", FasTagKYCActivity.class.getName());
        a((e) new b(str, new g.a() {
            public final void onResponse(Object obj) {
                b.this.a((IJRPaytmDataModel) obj);
            }
        }, new d() {
            public final void onError(Throwable th) {
                bVar2.a(th);
            }
        }, iJRPaytmDataModel, map, str2, a.C0715a.PUT, a.c.PASSBOOK, a.b.USER_FACING, FasTagKYCActivity.class.getName()), bVar2);
    }

    /* access modifiers changed from: protected */
    public final void b(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, String str2, b bVar) {
        final b bVar2 = bVar;
        new HashMap().put("screen_name", FasTagKYCActivity.class.getName());
        a((e) new b(str, new g.a() {
            public final void onResponse(Object obj) {
                b.this.a((IJRPaytmDataModel) obj);
            }
        }, new d() {
            public final void onError(Throwable th) {
                bVar2.a(th);
            }
        }, iJRPaytmDataModel, map, str2, a.C0715a.POST, a.c.PASSBOOK, a.b.USER_FACING, FasTagKYCActivity.class.getName()), bVar2);
    }

    /* access modifiers changed from: protected */
    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel, Map<String, String> map, b bVar) {
        final b bVar2 = bVar;
        new HashMap().put("screen_name", FasTagKYCActivity.class.getName());
        a((e) new net.one97.paytm.fastag.d.a(str, new g.a() {
            public final void onResponse(Object obj) {
                b.this.a((IJRPaytmDataModel) obj);
            }
        }, new d() {
            public final void onError(Throwable th) {
                bVar2.a(th);
            }
        }, iJRPaytmDataModel, map, a.c.PASSBOOK, a.b.USER_FACING, FasTagKYCActivity.class.getName()), bVar2);
    }

    private void a(e eVar, b bVar) {
        if (com.paytm.utility.b.c(this.f13556a)) {
            c.a();
            c.a(eVar);
            return;
        }
        bVar.a((Throwable) new net.one97.paytm.fastag.c(eVar.a(), eVar));
    }
}
