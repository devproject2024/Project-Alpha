package net.one97.paytm.insurance.H5;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gsonhtcfix.o;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.utility.b;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import net.one97.paytm.insurance.b.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f13985a = new a();

    private a() {
    }

    public static String a(Context context) {
        k.c(context, "context");
        try {
            o oVar = new o();
            oVar.a(StringSet.token, c.a().getSSOToken(context.getApplicationContext()));
            oVar.a("userId", c.a().getUserId(context.getApplicationContext()));
            oVar.a("full_name", b.aa(context.getApplicationContext()));
            oVar.a("dob", b.F(context.getApplicationContext()));
            oVar.a("gender", b.G(context.getApplicationContext()));
            oVar.a(AppConstants.KEY_EMAIL, b.m(context.getApplicationContext()));
            oVar.a(ContactColumn.PHONE_NUMBER, b.l(context.getApplicationContext()));
            oVar.a("Authorization", b.m());
            f.a.a aVar = f.a.a.f13515a;
            if (f.a.a.c() != null) {
                f.a.a aVar2 = f.a.a.f13515a;
                Integer c2 = f.a.a.c();
                if (c2 == null) {
                    k.a();
                }
                oVar.a("insuranceType", String.valueOf(c2.intValue()));
            }
            f.a.a aVar3 = f.a.a.f13515a;
            if (f.a.a.d() != null) {
                f.a.a aVar4 = f.a.a.f13515a;
                String d2 = f.a.a.d();
                if (d2 == null) {
                    k.a();
                }
                oVar.a("orderId", d2.toString());
            }
            f.a.a aVar5 = f.a.a.f13515a;
            oVar.a("leadId", f.a.a.e());
            f.a.a aVar6 = f.a.a.f13515a;
            oVar.a("listingUrl", f.a.a.f());
            String oVar2 = oVar.toString();
            k.a((Object) oVar2, "`object`.toString()");
            return oVar2;
        } catch (Exception unused) {
            return "";
        }
    }
}
