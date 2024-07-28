package net.one97.paytm.upi.deeplink;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.BaseUpiResponse;
import net.one97.paytm.upi.common.upi.UpiTransactionStatusModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.passbook.b.a.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    BaseUpiResponse f66679a;

    /* renamed from: b  reason: collision with root package name */
    Bundle f66680b;

    /* renamed from: c  reason: collision with root package name */
    C1344a f66681c;

    /* renamed from: net.one97.paytm.upi.deeplink.a$a  reason: collision with other inner class name */
    public interface C1344a {
        void a(UpiCustomVolleyError upiCustomVolleyError);

        void a(BaseUpiResponse baseUpiResponse);

        void a(boolean z);

        void b(BaseUpiResponse baseUpiResponse);

        void c(BaseUpiResponse baseUpiResponse);
    }

    public a(Bundle bundle, C1344a aVar) {
        k.c(bundle, "bundle");
        k.c(aVar, "commonPayCallback");
        this.f66680b = bundle;
        this.f66681c = aVar;
    }

    public static final class b implements a.C1382a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66682a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f66683b;

        b(a aVar, Context context) {
            this.f66682a = aVar;
            this.f66683b = context;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            a aVar = this.f66682a;
            aVar.f66679a = (BaseUpiResponse) upiBaseDataModel;
            aVar.a(aVar.f66679a, this.f66683b);
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            this.f66682a.f66681c.a(false);
            this.f66682a.f66681c.a(upiCustomVolleyError);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(BaseUpiResponse baseUpiResponse, Context context) {
        String string;
        Boolean bool = null;
        if (!k.a((Object) baseUpiResponse != null ? baseUpiResponse.getResponse() : null, (Object) "92")) {
            if (!k.a((Object) baseUpiResponse != null ? baseUpiResponse.getResponse() : null, (Object) "91")) {
                if (!k.a((Object) baseUpiResponse != null ? baseUpiResponse.getResponse() : null, (Object) "RB")) {
                    if (baseUpiResponse != null) {
                        bool = Boolean.valueOf(baseUpiResponse.isSuccess());
                    }
                    if (bool == null) {
                        k.a();
                    }
                    if (!bool.booleanValue()) {
                        this.f66681c.b(baseUpiResponse);
                        return;
                    } else {
                        this.f66681c.a(baseUpiResponse);
                        return;
                    }
                }
            }
        }
        if (UpiGTMLoader.getInstance().isUpiTransactionStatusPollingEnabled() && !TextUtils.isEmpty(this.f66680b.getString(UpiConstants.EXTRA_DEEPLINK_TXN_ID)) && (string = this.f66680b.getString(UpiConstants.EXTRA_DEEPLINK_TXN_ID)) != null) {
            k.a((Object) string, "it");
            net.one97.paytm.upi.passbook.b.a.b b2 = g.b();
            if (b2 != null) {
                b2.b((a.C1379a) new c(this, context), string, "UPICommonPayHelper", "");
            }
        }
    }

    public static final class c implements a.C1379a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f66684a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f66685b;

        c(a aVar, Context context) {
            this.f66684a = aVar;
            this.f66685b = context;
        }

        public final void a(UpiBaseDataModel upiBaseDataModel) {
            k.c(upiBaseDataModel, Payload.RESPONSE);
            if (upiBaseDataModel instanceof BaseUpiResponse) {
                a.a(this.f66684a, (BaseUpiResponse) upiBaseDataModel, this.f66685b);
            }
        }

        public final void a(UpiCustomVolleyError upiCustomVolleyError) {
            k.c(upiCustomVolleyError, "error");
            if (!p.a(net.one97.paytm.upi.passbook.b.a.b.a.f67623a, upiCustomVolleyError.getmErrorCode(), true)) {
                upiCustomVolleyError.getAlertMessage();
                a.a(this.f66684a, (BaseUpiResponse) null, this.f66685b);
            }
        }
    }

    public static final /* synthetic */ void a(a aVar, BaseUpiResponse baseUpiResponse, Context context) {
        BaseUpiResponse baseUpiResponse2 = aVar.f66679a;
        if (baseUpiResponse2 != null && (baseUpiResponse2 instanceof BaseUpiResponse)) {
            if (baseUpiResponse != null) {
                if (baseUpiResponse.getMobileAppData() instanceof UpiTransactionStatusModel) {
                    Object mobileAppData = baseUpiResponse.getMobileAppData();
                    if (mobileAppData != null) {
                        UpiTransactionStatusModel upiTransactionStatusModel = (UpiTransactionStatusModel) mobileAppData;
                        if (!(upiTransactionStatusModel == null || upiTransactionStatusModel.getDetails() == null)) {
                            UpiTransactionStatusModel.TransactionStatus details = upiTransactionStatusModel.getDetails();
                            k.a((Object) details, "statusModel.details");
                            String status = details.getStatus();
                            if (p.a("SUCCESS", status, true)) {
                                aVar.f66679a = baseUpiResponse;
                            } else if (p.a("FAILURE", status, true)) {
                                BaseUpiResponse baseUpiResponse3 = aVar.f66679a;
                                if (baseUpiResponse3 != null) {
                                    UpiTransactionStatusModel.TransactionStatus details2 = upiTransactionStatusModel.getDetails();
                                    k.a((Object) details2, "statusModel.details");
                                    baseUpiResponse3.setResponse(details2.getRc());
                                    BaseUpiResponse baseUpiResponse4 = aVar.f66679a;
                                    if (baseUpiResponse4 != null) {
                                        baseUpiResponse4.setSuccess(false);
                                        UpiTransactionStatusModel.TransactionStatus details3 = upiTransactionStatusModel.getDetails();
                                        k.a((Object) details3, "statusModel.details");
                                        String message = details3.getMessage();
                                        if (TextUtils.isEmpty(message)) {
                                            BaseUpiResponse baseUpiResponse5 = aVar.f66679a;
                                            if (baseUpiResponse5 != null) {
                                                baseUpiResponse5.setMessage(context.getResources().getString(R.string.upi_default_failure_message_for_polling));
                                            } else {
                                                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
                                            }
                                        } else {
                                            BaseUpiResponse baseUpiResponse6 = aVar.f66679a;
                                            if (baseUpiResponse6 != null) {
                                                baseUpiResponse6.setMessage(message);
                                            } else {
                                                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
                                            }
                                        }
                                    } else {
                                        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
                                }
                            }
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.UpiTransactionStatusModel");
                    }
                }
                aVar.a(aVar.f66679a, context);
            } else if (baseUpiResponse2 == null) {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.BaseUpiResponse");
            } else if (k.a((Object) baseUpiResponse2.getResponse(), (Object) "92") || k.a((Object) baseUpiResponse2.getResponse(), (Object) "91") || k.a((Object) baseUpiResponse2.getResponse(), (Object) "RB")) {
                aVar.f66681c.c(baseUpiResponse2);
            }
        }
    }
}
