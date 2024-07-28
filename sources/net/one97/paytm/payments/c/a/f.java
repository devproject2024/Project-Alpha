package net.one97.paytm.payments.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.activity.ChequeBookDDActivity;
import net.one97.paytm.paymentsBank.chequebook.landing.view.ChequeBookLandingPageActivity;
import net.one97.paytm.paymentsBank.chequebook.model.CBChequeStatusDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookDetailResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeDetailsForInwardOutward;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.RequestCBActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.phoenix.api.H5Event;
import org.json.JSONObject;

public final class f extends net.one97.paytm.phoenix.core.a {

    /* renamed from: a  reason: collision with root package name */
    Activity f17218a;

    /* renamed from: b  reason: collision with root package name */
    boolean f17219b;

    /* renamed from: c  reason: collision with root package name */
    ChequeBookFinResponse f17220c;

    /* renamed from: d  reason: collision with root package name */
    Context f17221d;

    /* renamed from: e  reason: collision with root package name */
    boolean f17222e;

    /* renamed from: f  reason: collision with root package name */
    String f17223f;

    /* renamed from: g  reason: collision with root package name */
    String f17224g;

    /* renamed from: h  reason: collision with root package name */
    int f17225h;

    /* renamed from: i  reason: collision with root package name */
    h f17226i;
    private H5Event m;
    private net.one97.paytm.phoenix.api.b n;

    public f() {
        super("openChequebookScreen");
    }

    public static final /* synthetic */ Context b(f fVar) {
        Context context = fVar.f17221d;
        if (context == null) {
            k.a("context");
        }
        return context;
    }

    public static final /* synthetic */ Activity c(f fVar) {
        Activity activity = fVar.f17218a;
        if (activity == null) {
            k.a("activity");
        }
        return activity;
    }

    public static final /* synthetic */ ChequeBookFinResponse e(f fVar) {
        ChequeBookFinResponse chequeBookFinResponse = fVar.f17220c;
        if (chequeBookFinResponse == null) {
            k.a("cbFinResponse");
        }
        return chequeBookFinResponse;
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        String str;
        com.paytm.network.a aVar;
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.n = bVar;
        this.m = h5Event;
        if (h5Event.getActivity() == null) {
            return false;
        }
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            k.a();
        }
        this.f17218a = activity;
        Activity activity2 = this.f17218a;
        if (activity2 == null) {
            k.a("activity");
        }
        Context baseContext = activity2.getBaseContext();
        k.a((Object) baseContext, "activity.baseContext");
        this.f17221d = baseContext;
        JSONObject params = h5Event.getParams();
        if (params == null || (str = params.getString(CJRPGTransactionRequestUtils.PAYER_ACCOUNT_NUMBER)) == null) {
            str = "";
        }
        this.f17223f = str;
        if (!n.a() || j.a().equals("ICA")) {
            Context context = this.f17221d;
            if (context == null) {
                k.a("context");
            }
            Intent intent = new Intent(context, ChequeBookDDActivity.class);
            Activity activity3 = this.f17218a;
            if (activity3 == null) {
                k.a("activity");
            }
            activity3.startActivity(intent);
            b();
            return true;
        }
        g.a aVar2 = g.f17964b;
        Context context2 = this.f17221d;
        if (context2 == null) {
            k.a("context");
        }
        g a2 = g.a.a(context2);
        if (a2 != null) {
            Context context3 = this.f17221d;
            if (context3 == null) {
                k.a("context");
            }
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            aVar = a2.a(context3, "0", (com.paytm.network.listener.b) new c(this), simpleName);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            k.a();
        }
        aVar.a();
        return true;
    }

    public static final class c implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f17229a;

        c(f fVar) {
            this.f17229a = fVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            f.a(this.f17229a);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            com.paytm.network.a aVar;
            ChequeBookDetailResponse chequeBookDetailResponse = (ChequeBookDetailResponse) iJRPaytmDataModel;
            if (f.b(this.f17229a) != null) {
                f fVar = this.f17229a;
                fVar.f17226i = h.a(f.b(fVar));
                if (this.f17229a.f17226i != null) {
                    h.a("CB_KEY_CB_LIST_RESPONSE", new com.google.gsonhtcfix.f().a((Object) chequeBookDetailResponse), f.c(this.f17229a));
                }
            }
            if (chequeBookDetailResponse != null && chequeBookDetailResponse.getCbList().size() > 0) {
                this.f17229a.f17222e = true;
            }
            f fVar2 = this.f17229a;
            g.a aVar2 = g.f17964b;
            Context context = fVar2.f17221d;
            if (context == null) {
                k.a("context");
            }
            g a2 = g.a.a(context);
            if (a2 != null) {
                Context context2 = fVar2.f17221d;
                if (context2 == null) {
                    k.a("context");
                }
                String simpleName = fVar2.getClass().getSimpleName();
                k.a((Object) simpleName, "javaClass.simpleName");
                aVar = a2.b(context2, new b(fVar2), simpleName);
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f17228a;

        b(f fVar) {
            this.f17228a = fVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            if (!(iJRPaytmDataModel instanceof ChequeBookFinResponse)) {
                return;
            }
            if (this.f17228a.f17222e) {
                f.d(this.f17228a);
            } else {
                f.a(this.f17228a);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            f fVar = this.f17228a;
            if (iJRPaytmDataModel != null) {
                fVar.f17220c = (ChequeBookFinResponse) iJRPaytmDataModel;
                if (f.e(fVar) != null) {
                    if (f.b(this.f17228a) != null) {
                        f fVar2 = this.f17228a;
                        fVar2.f17226i = h.a(f.b(fVar2));
                        if (this.f17228a.f17226i != null) {
                            h.b("CB_KEY_FIN_RESPONSE");
                        }
                    }
                    if (this.f17228a.f17226i != null) {
                        h.a("CB_KEY_FIN_RESPONSE", new com.google.gsonhtcfix.f().a((Object) f.e(this.f17228a)), f.c(this.f17228a));
                    }
                    ChequeBookResponse response = f.e(this.f17228a).getResponse();
                    if (response != null) {
                        this.f17228a.f17225h = response.getPendingChequeBooks().size();
                        ChequeBookSignature signature = response.getSignature();
                        k.a((Object) signature, "cbResponse.getSignature()");
                        if (signature != null) {
                            this.f17228a.f17224g = signature.getStatus();
                            if (p.a(f.e(this.f17228a).getStatusCode(), "SUCCESS", true)) {
                                String str = this.f17228a.f17223f;
                                if (str == null) {
                                    k.a("mAccountNumber");
                                }
                                if (!TextUtils.isEmpty(str)) {
                                    f.d(this.f17228a);
                                } else {
                                    this.f17228a.a();
                                }
                            }
                        }
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse");
            }
        }
    }

    public static final class a implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f17227a;

        a(f fVar) {
            this.f17227a = fVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            f.a(this.f17227a);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            if (iJRPaytmDataModel != null) {
                CBChequeStatusDetailResponse cBChequeStatusDetailResponse = (CBChequeStatusDetailResponse) iJRPaytmDataModel;
                if (cBChequeStatusDetailResponse != null) {
                    List<ChequeDetailsForInwardOutward> chqListForInwrdOutwrd = cBChequeStatusDetailResponse.getChqListForInwrdOutwrd();
                    if ((chqListForInwrdOutwrd != null ? chqListForInwrdOutwrd.size() : 0) > 0) {
                        this.f17227a.f17219b = true;
                    }
                }
                if (f.e(this.f17227a) != null) {
                    f fVar = this.f17227a;
                    ChequeBookFinResponse chequeBookFinResponse = fVar.f17220c;
                    if (chequeBookFinResponse == null) {
                        k.a("cbFinResponse");
                    }
                    k.a((Object) chequeBookFinResponse.getResponse(), "cbFinResponse.response");
                    ChequeBookFinResponse chequeBookFinResponse2 = fVar.f17220c;
                    if (chequeBookFinResponse2 == null) {
                        k.a("cbFinResponse");
                    }
                    if (!p.a(chequeBookFinResponse2.getStatusCode(), "SUCCESS", true)) {
                        return;
                    }
                    if (fVar.f17222e || ((fVar.f17224g != null && !p.a(fVar.f17224g, "UPLOADED", true) && !p.a(fVar.f17224g, "REJECTED", true)) || fVar.f17225h != 0)) {
                        fVar.a();
                        return;
                    }
                    Context context = fVar.f17221d;
                    if (context == null) {
                        k.a("context");
                    }
                    Intent intent = new Intent(context, RequestCBActivity.class);
                    ChequeBookFinResponse chequeBookFinResponse3 = fVar.f17220c;
                    if (chequeBookFinResponse3 == null) {
                        k.a("cbFinResponse");
                    }
                    if (chequeBookFinResponse3 != null) {
                        intent.putExtra("CB_FIN_PRODUCT_RESPONSE", chequeBookFinResponse3);
                        intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", false);
                        Context context2 = fVar.f17221d;
                        if (context2 == null) {
                            k.a("context");
                        }
                        if (context2 != null) {
                            Activity activity = fVar.f17218a;
                            if (activity == null) {
                                k.a("activity");
                            }
                            activity.startActivity(intent);
                        }
                        fVar.b();
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.os.Parcelable");
                }
                this.f17227a.a();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.chequebook.model.CBChequeStatusDetailResponse");
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        Context context = this.f17221d;
        if (context == null) {
            k.a("context");
        }
        Intent intent = new Intent(context, ChequeBookLandingPageActivity.class);
        intent.putExtra("CHEQUEBOOK_SIGNATURE_STATUS", this.f17224g);
        intent.putExtra("showDepositedView", this.f17219b);
        intent.putExtra("pendingOrders", this.f17225h);
        intent.putExtra("cb_list_flow", this.f17222e);
        Context context2 = this.f17221d;
        if (context2 == null) {
            k.a("context");
        }
        if (context2 != null) {
            Activity activity = this.f17218a;
            if (activity == null) {
                k.a("activity");
            }
            activity.startActivity(intent);
        }
        b();
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "true");
        net.one97.paytm.phoenix.api.b bVar = this.n;
        if (bVar == null) {
            k.a("mBridgeContext");
        }
        if (bVar != null) {
            H5Event h5Event = this.m;
            if (h5Event == null) {
                k.a("ev");
            }
            bVar.a(h5Event, jSONObject);
        }
    }

    public static final /* synthetic */ void a(f fVar) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", "false");
        Context context = fVar.f17221d;
        if (context == null) {
            k.a("context");
        }
        String string = context.getString(R.string.error);
        Context context2 = fVar.f17221d;
        if (context2 == null) {
            k.a("context");
        }
        jSONObject.put(string, context2.getString(R.string.pb_something_wrong_try_again));
        net.one97.paytm.phoenix.api.b bVar = fVar.n;
        if (bVar == null) {
            k.a("mBridgeContext");
        }
        if (bVar != null) {
            H5Event h5Event = fVar.m;
            if (h5Event == null) {
                k.a("ev");
            }
            bVar.a(h5Event, jSONObject);
        }
    }

    public static final /* synthetic */ void d(f fVar) {
        com.paytm.network.a aVar;
        Context context = fVar.f17221d;
        if (context == null) {
            k.a("context");
        }
        if (context != null) {
            Context context2 = fVar.f17221d;
            if (context2 == null) {
                k.a("context");
            }
            if (context2.getApplicationContext() != null) {
                g.a aVar2 = g.f17964b;
                Context context3 = fVar.f17221d;
                if (context3 == null) {
                    k.a("context");
                }
                g a2 = g.a.a(context3.getApplicationContext());
                if (a2 != null) {
                    String str = fVar.f17223f;
                    if (str == null) {
                        k.a("mAccountNumber");
                    }
                    String simpleName = fVar.getClass().getSimpleName();
                    k.a((Object) simpleName, "javaClass.simpleName");
                    aVar = a2.a(str, "outward", "", (com.paytm.network.listener.b) new a(fVar), simpleName);
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    aVar.a();
                }
            }
        }
    }
}
