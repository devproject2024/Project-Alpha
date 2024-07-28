package net.one97.paytm.upi;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.h5container.api.H5Event;
import com.appsflyer.internal.referrer.Payload;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.upi.UpiAddBankHelperActivity;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.view.UpiQrCodeActivity;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiConstants;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final a f68356a = new a((byte) 0);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context) {
            k.c(context, "context");
            a(context, 0, (Fragment) null);
        }

        public static void a(Context context, int i2, Fragment fragment) {
            k.c(context, "context");
            ProgressDialog progressDialog = new ProgressDialog(context);
            progressDialog.setMessage(context.getString(R.string.please_wait));
            progressDialog.setIndeterminate(true);
            progressDialog.show();
            a(context, new C1385a(progressDialog, i2, context, fragment));
        }

        /* renamed from: net.one97.paytm.upi.q$a$a  reason: collision with other inner class name */
        public static final class C1385a implements a.C1382a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ProgressDialog f68357a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f68358b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f68359c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Fragment f68360d;

            C1385a(ProgressDialog progressDialog, int i2, Context context, Fragment fragment) {
                this.f68357a = progressDialog;
                this.f68358b = i2;
                this.f68359c = context;
                this.f68360d = fragment;
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                Context context;
                k.c(upiBaseDataModel, Payload.RESPONSE);
                ProgressDialog progressDialog = this.f68357a;
                if (progressDialog != null && progressDialog.isShowing()) {
                    this.f68357a.dismiss();
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
                                        if (this.f68358b == 0) {
                                            UpiAddBankHelperActivity.a aVar = UpiAddBankHelperActivity.f66481a;
                                            Context context2 = this.f68359c;
                                            k.a((Object) virtualAddress, "vpa");
                                            UpiAddBankHelperActivity.a.a(context2, virtualAddress);
                                            return;
                                        }
                                        UpiAddBankHelperActivity.a aVar2 = UpiAddBankHelperActivity.f66481a;
                                        Fragment fragment = this.f68360d;
                                        k.a((Object) virtualAddress, "vpa");
                                        int i2 = this.f68358b;
                                        k.c(virtualAddress, "virtualAddress");
                                        if (fragment != null && (context = fragment.getContext()) != null) {
                                            Intent intent = new Intent(context, UpiAddBankHelperActivity.class);
                                            intent.putExtra("vpa", virtualAddress);
                                            intent.putExtra("self_destroy", i2);
                                            fragment.startActivityForResult(intent, i2);
                                            return;
                                        }
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        Toast.makeText(this.f68359c, R.string.some_went_wrong, 1).show();
                        return;
                    }
                    Toast.makeText(this.f68359c, R.string.some_went_wrong, 1).show();
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                k.c(upiCustomVolleyError, "error");
                ProgressDialog progressDialog = this.f68357a;
                if (progressDialog != null && progressDialog.isShowing()) {
                    this.f68357a.dismiss();
                }
                Toast.makeText(this.f68359c, R.string.some_went_wrong, 1).show();
            }
        }

        public static final class d implements a.C1382a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ UpiPendingRequestModel f68363a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f68364b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f68365c;

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                k.c(upiCustomVolleyError, "error");
            }

            d(UpiPendingRequestModel upiPendingRequestModel, Context context, String str) {
                this.f68363a = upiPendingRequestModel;
                this.f68364b = context;
                this.f68365c = str;
            }

            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                k.c(upiBaseDataModel, Payload.RESPONSE);
                if (upiBaseDataModel instanceof UpiProfileModel) {
                    UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                    if (p.a(upiProfileModel.getStatus(), "SUCCESS", true) && p.a("0", upiProfileModel.getRespCode(), true) && upiProfileModel.getResponse() != null) {
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
                                k.a((Object) next, "upiProfileDefaultBank");
                                if (next.getDebitBank() != null) {
                                    BankAccountDetails.BankAccount debitBank = next.getDebitBank();
                                    k.a((Object) debitBank, "upiProfileDefaultBank.debitBank");
                                    if (debitBank.getAccount() != null && p.a(next.getVirtualAddress(), this.f68363a.getPayerVa(), true)) {
                                        next.setVirtualAddress(this.f68363a.getPayerVa());
                                        Bundle bundle = new Bundle();
                                        bundle.putSerializable(UpiConstants.EXTRA_MONEY_TRANSFER_PAYMENT_OPTION, UpiConstants.MoneyTransferPaymentOption.UPI);
                                        bundle.putString("amount", this.f68363a.getAmount());
                                        bundle.putString("payee_name", this.f68363a.getPayeeName());
                                        bundle.putString("payee_vpa", this.f68363a.getPayeeVa());
                                        bundle.putString(UpiConstants.EXTRA_PAYER_VPA, this.f68363a.getPayerVa());
                                        bundle.putSerializable("user_upi_details", next);
                                        bundle.putBoolean(UpiConstants.EXTRA_IS_COLLECT_REQUEST, true);
                                        bundle.putString(UpiConstants.EXTRA_UPI_TRAN_LOG_ID, this.f68363a.getTxnId());
                                        bundle.putString(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.f68363a.getTxnId());
                                        UpiProfileModel.AccountDetails response3 = upiProfileModel.getResponse();
                                        k.a((Object) response3, "response.response");
                                        UpiProfileModel.ProfileDetails profileDetail3 = response3.getProfileDetail();
                                        k.a((Object) profileDetail3, "response.response.profileDetail");
                                        bundle.putInt(UpiConstants.EXTRA_COLLECT_REQUEST_BANK_LIST_SIZE, profileDetail3.getBankAccountList().size());
                                        i a2 = i.a();
                                        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                                        a2.c().a(this.f68364b, bundle);
                                        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(this.f68364b, Events.Category.COLLECT, "screen_open", this.f68365c, "", "", this.f68363a.getPayeeVa(), this.f68363a.getAmount(), Events.Screen.ENTER_AMOUNT, "wallet");
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        public static void a(UpiPendingRequestModel upiPendingRequestModel, Context context, String str) {
            k.c(upiPendingRequestModel, "upiPendingRequestModel");
            k.c(context, "context");
            k.c(str, "source");
            a(context, new d(upiPendingRequestModel, context, str));
        }

        public static void a(Context context, a.C1382a aVar) {
            k.c(context, "context");
            k.c(aVar, H5Event.TYPE_CALL_BACK);
            g.a().a(aVar, "", "");
        }

        public static final class c implements net.one97.paytm.upi.profile.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Context f68362a;

            c(Context context) {
                this.f68362a = context;
            }

            public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
                k.c(upiProfileDefaultBank, "primaryBank");
                UpiQrCodeActivity.a(this.f68362a, upiProfileDefaultBank);
            }

            public final void a() {
                Context context = this.f68362a;
                String string = context.getString(R.string.error_fetching_profile_details_retry);
                k.a((Object) string, "context.getString(R.stri…ng_profile_details_retry)");
                f.a(context, string, 0);
            }
        }

        public static final class b implements a.C1382a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ net.one97.paytm.upi.profile.a f68361a;

            b(net.one97.paytm.upi.profile.a aVar) {
                this.f68361a = aVar;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: net.one97.paytm.upi.common.upi.UpiProfileDefaultBank} */
            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
                r0 = r0.getProfileDetail();
             */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel r9) {
                /*
                    r8 = this;
                    boolean r0 = r9 instanceof net.one97.paytm.upi.common.upi.UpiProfileModel
                    if (r0 == 0) goto L_0x00a3
                    net.one97.paytm.upi.common.upi.UpiProfileModel r9 = (net.one97.paytm.upi.common.upi.UpiProfileModel) r9
                    java.lang.String r0 = r9.getStatus()
                    r1 = 1
                    java.lang.String r2 = "SUCCESS"
                    boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r1)
                    if (r0 == 0) goto L_0x00a3
                    java.lang.String r0 = r9.getRespCode()
                    java.lang.String r2 = "0"
                    boolean r0 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r0, (boolean) r1)
                    if (r0 == 0) goto L_0x00a3
                    net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r9.getResponse()
                    r2 = 0
                    if (r0 == 0) goto L_0x0031
                    net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
                    if (r0 == 0) goto L_0x0031
                    java.util.List r0 = r0.getProfileVpaList()
                    goto L_0x0032
                L_0x0031:
                    r0 = r2
                L_0x0032:
                    java.util.Collection r0 = (java.util.Collection) r0
                    r3 = 0
                    if (r0 == 0) goto L_0x003f
                    boolean r0 = r0.isEmpty()
                    if (r0 == 0) goto L_0x003e
                    goto L_0x003f
                L_0x003e:
                    r1 = 0
                L_0x003f:
                    if (r1 != 0) goto L_0x00a3
                    net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r0 = r9.getResponse()
                    java.lang.String r1 = "response.response"
                    kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                    net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r0 = r0.getProfileDetail()
                    java.lang.String r4 = "response.response.profileDetail"
                    kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
                    java.util.List r0 = r0.getProfileVpaList()
                    java.lang.String r5 = "response.response.profileDetail.profileVpaList"
                    kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    java.util.Iterator r0 = r0.iterator()
                L_0x0062:
                    boolean r5 = r0.hasNext()
                    if (r5 == 0) goto L_0x007b
                    java.lang.Object r5 = r0.next()
                    r6 = r5
                    net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r6 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r6
                    java.lang.String r7 = "it"
                    kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                    boolean r6 = r6.isPrimary()
                    if (r6 == 0) goto L_0x0062
                    r2 = r5
                L_0x007b:
                    net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r2
                    if (r2 != 0) goto L_0x0098
                    net.one97.paytm.upi.common.upi.UpiProfileModel$AccountDetails r9 = r9.getResponse()
                    kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r1)
                    net.one97.paytm.upi.common.upi.UpiProfileModel$ProfileDetails r9 = r9.getProfileDetail()
                    kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r4)
                    java.util.List r9 = r9.getProfileVpaList()
                    java.lang.Object r9 = r9.get(r3)
                    r2 = r9
                    net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r2 = (net.one97.paytm.upi.common.upi.UpiProfileDefaultBank) r2
                L_0x0098:
                    net.one97.paytm.upi.profile.a r9 = r8.f68361a
                    if (r2 != 0) goto L_0x009f
                    kotlin.g.b.k.a()
                L_0x009f:
                    r9.a(r2)
                    return
                L_0x00a3:
                    net.one97.paytm.upi.profile.a r9 = r8.f68361a
                    r9.a()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.q.a.b.onSuccess(net.one97.paytm.upi.common.UpiBaseDataModel):void");
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                this.f68361a.a();
            }
        }
    }
}
