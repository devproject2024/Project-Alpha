package net.one97.travelpass.ordersummary.h;

import android.content.Context;
import android.os.Handler;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.travelpass.ordersummary.model.OrderSummary;
import net.one97.travelpass.ordersummary.model.OrderSummaryBody;

public final class a extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<OrderSummary> f30525a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<net.one97.travelpass.e.a> f30526b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    int f30527c;

    /* renamed from: d  reason: collision with root package name */
    int f30528d = 3;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.travelpass.ordersummary.f.a f30529e = new net.one97.travelpass.ordersummary.f.a();

    /* renamed from: net.one97.travelpass.ordersummary.h.a$a  reason: collision with other inner class name */
    public static final class C0518a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30530a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f30531b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f30532c;

        C0518a(a aVar, Context context, String str) {
            this.f30530a = aVar;
            this.f30531b = context;
            this.f30532c = str;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            this.f30530a.f30526b.setValue(new net.one97.travelpass.e.a(i2, iJRPaytmDataModel, networkCustomError));
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            OrderSummaryBody body;
            if (!(iJRPaytmDataModel instanceof OrderSummary)) {
                iJRPaytmDataModel = null;
            }
            OrderSummary orderSummary = (OrderSummary) iJRPaytmDataModel;
            if (orderSummary != null) {
                OrderSummaryBody body2 = orderSummary.getBody();
                if (((body2 == null || body2.getPaytmStatusCode() != 2) && ((body = orderSummary.getBody()) == null || body.getPaytmStatusCode() != 5)) || this.f30530a.f30527c >= this.f30530a.f30528d) {
                    this.f30530a.f30525a.setValue(orderSummary);
                    return;
                }
                new Handler().postDelayed(new b(this.f30530a, this.f30531b, this.f30532c), 3000);
                this.f30530a.f30527c++;
            }
        }
    }

    public final void a(Context context, String str) {
        k.c(str, "orderId");
        if (context != null && this.f30529e != null) {
            net.one97.travelpass.ordersummary.f.a.a(context, new C0518a(this, context, str), str);
        }
    }

    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f30533a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f30534b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f30535c;

        b(a aVar, Context context, String str) {
            this.f30533a = aVar;
            this.f30534b = context;
            this.f30535c = str;
        }

        public final void run() {
            this.f30533a.a(this.f30534b, this.f30535c);
        }
    }
}
