package net.one97.paytm.b.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Map;
import java.util.Stack;
import kotlin.g.b.k;
import net.one97.paytm.p2mNewDesign.models.SingleAPIResponseV2;
import net.one97.paytm.p2mNewDesign.models.c;
import net.one97.paytm.p2mNewDesign.models.d;
import net.one97.paytm.wallet.communicator.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static e f49487a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static y<c<Object>> f49488b = new y<>();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static d f49489c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static boolean f49490d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Stack<String> f49491e = new Stack<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f49492f;

    public static e a() {
        if (f49487a == null) {
            f49487a = new e();
            f49489c = new d();
            f49488b = new y<>();
            f49490d = b.a().getBooleanFromGTM(b.a().getContext(), "singleAPIForQREnabledAndroid", false);
        }
        return f49487a;
    }

    public static void b() {
        f49487a = null;
    }

    public final void c() {
        f49488b = new y<>();
        this.f49492f = false;
        f49489c = null;
    }

    public static y<c<Object>> d() {
        return f49488b;
    }

    public static d e() {
        return f49489c;
    }

    public static boolean f() {
        return f49490d;
    }

    public final void a(Context context, String str, String str2, Map<String, String> map) {
        this.f49491e.add(str2);
        c();
        new b(str2);
        Context applicationContext = context.getApplicationContext();
        AnonymousClass1 r0 = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                boolean z = iJRPaytmDataModel instanceof SingleAPIResponseV2;
                String str = "";
                if (z) {
                    c.a aVar = c.f56934d;
                    SingleAPIResponseV2 singleAPIResponseV2 = (SingleAPIResponseV2) c.a.a((SingleAPIResponseV2) iJRPaytmDataModel).f56936b;
                    if (singleAPIResponseV2 != null && singleAPIResponseV2.getBody() != null) {
                        if (e.f49489c == null) {
                            d unused = e.f49489c = new d();
                        }
                        if (e.f49488b == null) {
                            y unused2 = e.f49488b = new y();
                        }
                        if (!(singleAPIResponseV2.getBody().getQrInfo() == null || singleAPIResponseV2.getBody().getQrInfo().getResponse() == null)) {
                            str = singleAPIResponseV2.getBody().getQrInfo().getResponse().optString("qrCodeId", str);
                        }
                        if (e.this.f49491e.empty() || e.this.f49491e.size() == 1) {
                            e.f49489c.f49486a = singleAPIResponseV2.getBody().getQrInfo();
                            y h2 = e.f49488b;
                            c.a aVar2 = c.f56934d;
                            h2.postValue(c.a.a(iJRPaytmDataModel));
                            e.this.f49491e.clear();
                        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase((String) e.this.f49491e.peek())) {
                            e.f49489c.f49486a = singleAPIResponseV2.getBody().getQrInfo();
                            y h3 = e.f49488b;
                            c.a aVar3 = c.f56934d;
                            h3.postValue(c.a.a(iJRPaytmDataModel));
                            e.this.f49491e.clear();
                        }
                    }
                } else if (z) {
                    c.a aVar4 = c.f56934d;
                    SingleAPIResponseV2 singleAPIResponseV22 = (SingleAPIResponseV2) c.a.a((SingleAPIResponseV2) iJRPaytmDataModel).f56936b;
                    if (singleAPIResponseV22 != null && singleAPIResponseV22.getBody() != null) {
                        if (e.f49489c == null) {
                            d unused3 = e.f49489c = new d();
                        }
                        if (e.f49488b == null) {
                            y unused4 = e.f49488b = new y();
                        }
                        if (!(singleAPIResponseV22.getBody().getQrInfo() == null || singleAPIResponseV22.getBody().getQrInfo().getResponse() == null)) {
                            str = singleAPIResponseV22.getBody().getQrInfo().getResponse().optString("qrCodeId", str);
                        }
                        if (e.this.f49491e.empty() || e.this.f49491e.size() == 1) {
                            e.f49489c.f49486a = singleAPIResponseV22.getBody().getQrInfo();
                            y h4 = e.f49488b;
                            c.a aVar5 = c.f56934d;
                            h4.postValue(c.a.a(iJRPaytmDataModel));
                            e.this.f49491e.clear();
                        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase((String) e.this.f49491e.peek())) {
                            e.f49489c.f49486a = singleAPIResponseV22.getBody().getQrInfo();
                            y h5 = e.f49488b;
                            c.a aVar6 = c.f56934d;
                            h5.postValue(c.a.a(iJRPaytmDataModel));
                            e.this.f49491e.clear();
                        }
                    }
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                y h2 = e.f49488b;
                c.a aVar = c.f56934d;
                k.c(networkCustomError, "error");
                h2.postValue(new c(d.ERROR, null, networkCustomError));
                e.this.f49491e.clear();
            }
        };
        new StringBuilder().append(System.currentTimeMillis());
        b.a(applicationContext, str, str2, map, r0);
    }
}
