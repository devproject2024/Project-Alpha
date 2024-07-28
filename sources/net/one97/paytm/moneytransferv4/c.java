package net.one97.paytm.moneytransferv4;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.appsflyer.internal.referrer.Payload;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.CustProductListV2;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.b.a.a;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.MoneyTransferUtilityActivity;
import net.one97.paytm.moneytransferv4.home.presentation.view.MoneyTransferV4Activity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55350a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static int f55351b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static final class e implements a.C1389a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ x.e f55365a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f55366b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DeepLinkData f55367c;

            public e(x.e eVar, Context context, DeepLinkData deepLinkData) {
                this.f55365a = eVar;
                this.f55366b = context;
                this.f55367c = deepLinkData;
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                k.c(upiBaseDataModel, Payload.RESPONSE);
                if (((ProgressDialog) this.f55365a.element) != null && ((ProgressDialog) this.f55365a.element).isShowing()) {
                    ((ProgressDialog) this.f55365a.element).dismiss();
                }
                if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel.getResponse() != null) {
                        UpiAvailabilityModel.UpiAvailabilityResponse response = upiAvailabilityModel.getResponse();
                        k.a((Object) response, "responseUpi.response");
                        if (response.isUpiUser()) {
                            if (!m.c(this.f55366b)) {
                                a aVar = c.f55350a;
                                Context context = this.f55366b;
                                DeepLinkData deepLinkData = this.f55367c;
                                ProgressDialog progressDialog = new ProgressDialog(context);
                                progressDialog.setMessage(context.getString(R.string.please_wait));
                                progressDialog.setIndeterminate(true);
                                progressDialog.show();
                                q.a aVar2 = q.f68356a;
                                q.a.a(context, new C1020a(progressDialog, context, deepLinkData));
                                return;
                            }
                            a aVar3 = c.f55350a;
                            a.b(this.f55366b, this.f55367c);
                        } else if (m.d(this.f55366b)) {
                            MoneyTransferUtilityActivity.a aVar4 = MoneyTransferUtilityActivity.f54779a;
                            Context context2 = this.f55366b;
                            String str = this.f55367c.f50283a;
                            if (str == null) {
                                str = "";
                            }
                            MoneyTransferUtilityActivity.a.a(context2, "", str, AppConstants.REQUEST_CODE.ADD_PRIMARY_EMAIL);
                        } else {
                            a aVar5 = c.f55350a;
                            a.c(this.f55366b, this.f55367c);
                        }
                    }
                } else {
                    Toast.makeText(this.f55366b, R.string.some_went_wrong, 1).show();
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                k.c(upiCustomVolleyError, "error");
                if (!(this.f55366b == null || ((ProgressDialog) this.f55365a.element) == null || !((ProgressDialog) this.f55365a.element).isShowing())) {
                    ((ProgressDialog) this.f55365a.element).dismiss();
                }
                String str = upiCustomVolleyError.getmErrorCode();
                if (!TextUtils.isEmpty(str) && k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
                    Toast.makeText(this.f55366b, R.string.no_internet, 1).show();
                } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
                    d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    Context context = this.f55366b;
                    if (context != null) {
                        new NetworkCustomError();
                        b2.a((Activity) context, (String) null, true);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                } else {
                    Toast.makeText(this.f55366b, R.string.some_went_wrong, 1).show();
                }
            }
        }

        public static void a(Context context, DeepLinkData deepLinkData) {
            k.c(context, "context");
            k.c(deepLinkData, "deepLinkData");
            if (!m.b(context)) {
                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                if (!net.one97.paytm.moneytransfer.d.d.b(d.a.a()).b(context)) {
                    ProgressDialog progressDialog = new ProgressDialog(context);
                    progressDialog.setMessage(context.getString(R.string.please_wait));
                    progressDialog.setIndeterminate(true);
                    progressDialog.show();
                    progressDialog.setCancelable(true);
                    net.one97.paytm.moneytransfer.b.a(context).b(new b(progressDialog, context, deepLinkData), new C1021c());
                    a(new d(progressDialog, context, deepLinkData));
                    return;
                }
            }
            b(context, deepLinkData);
        }

        public static final class b implements a.C0960a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ProgressDialog f55355a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f55356b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DeepLinkData f55357c;

            b(ProgressDialog progressDialog, Context context, DeepLinkData deepLinkData) {
                this.f55355a = progressDialog;
                this.f55356b = context;
                this.f55357c = deepLinkData;
            }

            public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
                k.c(iJRPaytmDataModel, Payload.RESPONSE);
                CustProductListV2 custProductListV2 = (CustProductListV2) iJRPaytmDataModel;
                if (p.a(custProductListV2.getStatus(), "SUCCESS", true) && custProductListV2.isSuccess()) {
                    ProgressDialog progressDialog = this.f55355a;
                    if (progressDialog != null && progressDialog.isShowing() && (this.f55355a.getContext() instanceof Activity)) {
                        Context context = this.f55355a.getContext();
                        if (context == null) {
                            throw new u("null cannot be cast to non-null type android.app.Activity");
                        } else if (!((Activity) context).isFinishing()) {
                            this.f55355a.dismiss();
                        }
                    }
                    if (custProductListV2.getResponse() != null) {
                        CustProductListV2.Isa response = custProductListV2.getResponse();
                        k.a((Object) response, "custProductList.response");
                        if (!TextUtils.isEmpty(response.getIsaStatus())) {
                            CustProductListV2.Isa response2 = custProductListV2.getResponse();
                            k.a((Object) response2, "custProductList.response");
                            if (k.a((Object) response2.getIsaStatus(), (Object) "ISSUED")) {
                                d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                                net.one97.paytm.moneytransfer.d.d.b(d.a.a()).a(this.f55356b, net.one97.paytm.moneytransfer.utils.a.ISSUED.getNumVal());
                                a aVar2 = c.f55350a;
                                a.b(this.f55356b, this.f55357c);
                                return;
                            }
                        }
                    }
                    c.f55351b = c.f55351b + 1;
                    if (c.f55351b == 2) {
                        c.f55351b = 0;
                        a aVar3 = c.f55350a;
                        a.d(this.f55356b, this.f55357c);
                    }
                }
            }

            public final void a(UpiCustomVolleyError upiCustomVolleyError) {
                k.c(upiCustomVolleyError, "error");
                ProgressDialog progressDialog = this.f55355a;
                if (progressDialog != null && progressDialog.isShowing() && (this.f55355a.getContext() instanceof Activity)) {
                    Context context = this.f55355a.getContext();
                    if (context == null) {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    } else if (!((Activity) context).isFinishing()) {
                        this.f55355a.dismiss();
                    }
                }
                String str = upiCustomVolleyError.getmErrorCode();
                if (!TextUtils.isEmpty(str) && k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
                    Toast.makeText(this.f55356b, R.string.no_internet, 1).show();
                } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
                    d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    Context context2 = this.f55356b;
                    if (context2 != null) {
                        new NetworkCustomError();
                        b2.a((Activity) context2, (String) null, true);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                } else {
                    Toast.makeText(this.f55356b, R.string.some_went_wrong, 1).show();
                }
                c.f55351b = c.f55351b + 1;
                if (c.f55351b == 2) {
                    c.f55351b = 0;
                    a aVar2 = c.f55350a;
                    a.d(this.f55356b, this.f55357c);
                }
            }
        }

        /* renamed from: net.one97.paytm.moneytransferv4.c$a$c  reason: collision with other inner class name */
        public static final class C1021c implements a.c {
            C1021c() {
            }
        }

        public static final class d implements a.C1389a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ProgressDialog f55361a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f55362b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DeepLinkData f55363c;

            d(ProgressDialog progressDialog, Context context, DeepLinkData deepLinkData) {
                this.f55361a = progressDialog;
                this.f55362b = context;
                this.f55363c = deepLinkData;
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                k.c(upiBaseDataModel, Payload.RESPONSE);
                if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel.getResponse() != null) {
                        UpiAvailabilityModel.UpiAvailabilityResponse response = upiAvailabilityModel.getResponse();
                        k.a((Object) response, "response.response");
                        boolean isUpiUser = response.isUpiUser();
                        ProgressDialog progressDialog = this.f55361a;
                        if (progressDialog != null && progressDialog.isShowing() && (this.f55361a.getContext() instanceof Activity)) {
                            Context context = this.f55361a.getContext();
                            if (context == null) {
                                throw new u("null cannot be cast to non-null type android.app.Activity");
                            } else if (!((Activity) context).isFinishing()) {
                                this.f55361a.dismiss();
                            }
                        }
                        if (isUpiUser) {
                            a aVar = c.f55350a;
                            a.b(this.f55362b, this.f55363c);
                            return;
                        }
                        c.f55351b = c.f55351b + 1;
                        if (c.f55351b == 2) {
                            c.f55351b = 0;
                            a aVar2 = c.f55350a;
                            a.d(this.f55362b, this.f55363c);
                            return;
                        }
                        return;
                    }
                    return;
                }
                Toast.makeText(this.f55362b, R.string.some_went_wrong, 1).show();
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                k.c(upiCustomVolleyError, "error");
                ProgressDialog progressDialog = this.f55361a;
                if (progressDialog != null && progressDialog.isShowing() && (this.f55361a.getContext() instanceof Activity)) {
                    Context context = this.f55361a.getContext();
                    if (context == null) {
                        throw new u("null cannot be cast to non-null type android.app.Activity");
                    } else if (!((Activity) context).isFinishing()) {
                        this.f55361a.dismiss();
                    }
                }
                String str = upiCustomVolleyError.getmErrorCode();
                if (!TextUtils.isEmpty(str) && k.a((Object) UpiConstants.NETWORK_ERROR_CODE, (Object) str)) {
                    Toast.makeText(this.f55362b, R.string.no_internet, 1).show();
                } else if (p.a(UpiUtils.AUTHENTICATION_FAILURE_401, upiCustomVolleyError.getmErrorCode(), true) || p.a("410", upiCustomVolleyError.getmErrorCode(), true)) {
                    d.a aVar = net.one97.paytm.moneytransfer.d.d.f53996a;
                    net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
                    Context context2 = this.f55362b;
                    if (context2 != null) {
                        new NetworkCustomError();
                        b2.a((Activity) context2, (String) null, true);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.app.Activity");
                } else {
                    Toast.makeText(this.f55362b, R.string.some_went_wrong, 1).show();
                }
                c.f55351b = c.f55351b + 1;
                if (c.f55351b == 2) {
                    c.f55351b = 0;
                    a aVar2 = c.f55350a;
                    a.d(this.f55362b, this.f55363c);
                }
            }
        }

        public static void b(Context context, DeepLinkData deepLinkData) {
            k.c(context, "context");
            k.c(deepLinkData, "deepLinkData");
            Intent intent = new Intent(context, MoneyTransferV4Activity.class);
            intent.putExtra("EXTRA_DEEP_LINK_DATA", deepLinkData);
            intent.putExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, true);
            intent.setFlags(536870912);
            context.startActivity(intent);
        }

        static void c(Context context, DeepLinkData deepLinkData) {
            Intent intent = new Intent(context, UpiSelectBankActivity.class);
            intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, deepLinkData.f50283a);
            intent.setFlags(536870912);
            context.startActivity(intent);
        }

        public static void d(Context context, DeepLinkData deepLinkData) {
            k.c(context, "context");
            k.c(deepLinkData, "deepLinkData");
            c.f55351b = 0;
            if (m.d(context)) {
                MoneyTransferUtilityActivity.a aVar = MoneyTransferUtilityActivity.f54779a;
                String str = deepLinkData.f50283a;
                if (str == null) {
                    str = "";
                }
                MoneyTransferUtilityActivity.a.a(context, "", str, AppConstants.REQUEST_CODE.ADD_PRIMARY_EMAIL);
                return;
            }
            c(context, deepLinkData);
        }

        /* renamed from: net.one97.paytm.moneytransferv4.c$a$a  reason: collision with other inner class name */
        public static final class C1020a implements a.C1382a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ProgressDialog f55352a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f55353b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ DeepLinkData f55354c;

            C1020a(ProgressDialog progressDialog, Context context, DeepLinkData deepLinkData) {
                this.f55352a = progressDialog;
                this.f55353b = context;
                this.f55354c = deepLinkData;
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                k.c(upiBaseDataModel, Payload.RESPONSE);
                ProgressDialog progressDialog = this.f55352a;
                if (progressDialog != null && progressDialog.isShowing()) {
                    this.f55352a.dismiss();
                }
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (p.a("success", upiProfileModel.getStatus(), true)) {
                        if (upiProfileModel.getResponse() != null) {
                            UpiProfileModel.AccountDetails response = upiProfileModel.getResponse();
                            k.a((Object) response, "response.response");
                            UpiProfileModel.ProfileDetails profileDetail = response.getProfileDetail();
                            k.a((Object) profileDetail, "response.response.profileDetail");
                            if (profileDetail.getProfileVpaList() != null) {
                                UpiProfileModel.AccountDetails response2 = upiProfileModel.getResponse();
                                k.a((Object) response2, "response.response");
                                UpiProfileModel.ProfileDetails profileDetail2 = response2.getProfileDetail();
                                k.a((Object) profileDetail2, "response.response.profileDetail");
                                for (UpiProfileDefaultBank next : profileDetail2.getProfileVpaList()) {
                                    k.a((Object) next, "vpaProfile");
                                    if (next.isPrimary()) {
                                        String virtualAddress = next.getVirtualAddress();
                                        MoneyTransferUtilityActivity.a aVar = MoneyTransferUtilityActivity.f54779a;
                                        Context context = this.f55353b;
                                        k.a((Object) virtualAddress, "vpa");
                                        String str = this.f55354c.f50283a;
                                        if (str == null) {
                                            str = "";
                                        }
                                        MoneyTransferUtilityActivity.a.a(context, virtualAddress, str, 1100);
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        Toast.makeText(this.f55353b, R.string.some_went_wrong, 1).show();
                        return;
                    }
                    Toast.makeText(this.f55353b, R.string.some_went_wrong, 1).show();
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                k.c(upiCustomVolleyError, "error");
                ProgressDialog progressDialog = this.f55352a;
                if (!(progressDialog == null || this.f55353b == null || !progressDialog.isShowing())) {
                    this.f55352a.dismiss();
                }
                Toast.makeText(this.f55353b, R.string.some_went_wrong, 1).show();
            }
        }

        public static void a(a.C1389a aVar) {
            g.a(g.a((a.C1347a) null)).e(aVar, "deeplink", "Home");
        }
    }
}
