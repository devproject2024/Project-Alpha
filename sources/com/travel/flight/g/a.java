package com.travel.flight.g;

import android.content.Context;
import android.text.Html;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.R;
import com.travel.flight.c;
import kotlin.g.b.k;
import net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse;

public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final String f25402b = f25402b;

    /* renamed from: c  reason: collision with root package name */
    public static final C0473a f25403c = new C0473a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final Context f25404a;

    /* renamed from: d  reason: collision with root package name */
    private b f25405d;

    public static String c(boolean z) {
        return z ? "priority_checkin_join_prime_status.png" : "priority_checkin_success.png";
    }

    public a(b bVar) {
        k.c(bVar, "viewmodelRepoBridge");
        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
        c b2 = com.travel.flight.b.b();
        k.a((Object) b2, "FlightController.getInstance().flightEventListener");
        this.f25404a = b2.a();
        this.f25405d = bVar;
    }

    /* renamed from: com.travel.flight.g.a$a  reason: collision with other inner class name */
    public static final class C0473a {
        private C0473a() {
        }

        public /* synthetic */ C0473a(byte b2) {
            this();
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        b bVar;
        if ((iJRPaytmDataModel instanceof IJRPriorityCheckinResponse) && (bVar = this.f25405d) != null) {
            bVar.a((IJRPriorityCheckinResponse) iJRPaytmDataModel);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        b bVar = this.f25405d;
        if (bVar != null) {
            bVar.a(networkCustomError);
        }
    }

    public final String a(boolean z) {
        if (z) {
            Context context = this.f25404a;
            k.a((Object) context, "context");
            String string = context.getResources().getString(R.string.priority_checkin_heading);
            k.a((Object) string, "context.resources.getStr…priority_checkin_heading)");
            return string;
        }
        Context context2 = this.f25404a;
        k.a((Object) context2, "context");
        String string2 = context2.getResources().getString(R.string.priority_checkin_fail_heading);
        k.a((Object) string2, "context.resources.getStr…ity_checkin_fail_heading)");
        return string2;
    }

    public final String b(boolean z) {
        String string;
        String str;
        if (z) {
            Context context = this.f25404a;
            k.a((Object) context, "context");
            string = context.getResources().getString(R.string.priority_checkin_status_success_message1);
            str = "context.resources.getStr…_status_success_message1)";
        } else {
            Context context2 = this.f25404a;
            k.a((Object) context2, "context");
            string = context2.getResources().getString(R.string.priority_checkin_status_fail_message1);
            str = "context.resources.getStr…kin_status_fail_message1)";
        }
        k.a((Object) string, str);
        return string;
    }

    public final String a() {
        Context context = this.f25404a;
        k.a((Object) context, "context");
        return Html.fromHtml(context.getResources().getString(R.string.priority_checkin_status_success_message_bullet_1)).toString();
    }

    public final String b() {
        Context context = this.f25404a;
        k.a((Object) context, "context");
        return Html.fromHtml(context.getResources().getString(R.string.priority_checkin_status_success_message_bullet_2)).toString();
    }
}
