package net.one97.paytm.upi.mandate.confirmation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.io.Serializable;
import java.util.List;
import kotlin.g.b.l;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.e.x;
import net.one97.paytm.upi.mandate.a.b;
import net.one97.paytm.upi.mandate.d.a;
import net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel;
import net.one97.paytm.upi.mandate.utils.k;
import net.one97.paytm.upi.mandate.utils.m;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.view.MandatePostTransactionActivity;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.upi.util.UpiWebViewActivity;

public final class MandateConfirmationDetailActivity extends PaytmActivity implements b.C1350b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67078a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upi.e.b f67079b;

    /* renamed from: c  reason: collision with root package name */
    private MandateConfirmationUiModel f67080c;

    /* renamed from: d  reason: collision with root package name */
    private c f67081d;

    /* renamed from: e  reason: collision with root package name */
    private k f67082e;

    /* renamed from: f  reason: collision with root package name */
    private final int f67083f = 1008;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final int f67084g = 1009;

    /* renamed from: h  reason: collision with root package name */
    private final int f67085h = IuserActions.SCROLL_MAIN_RV;

    static final class c<T> implements z<net.one97.paytm.upi.mandate.data.a<List<? extends UpiProfileDefaultBank>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67086a;

        c(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67086a = mandateConfirmationDetailActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            int i2 = a.f67094a[((net.one97.paytm.upi.mandate.data.a) obj).f67117a.ordinal()];
            if (i2 == 1) {
                MandateConfirmationDetailActivity.a(this.f67086a);
            } else if (i2 == 2) {
                net.one97.paytm.upi.f.a((Context) this.f67086a, "Could not fetch banks", 0);
            } else if (i2 == 3) {
                x xVar = MandateConfirmationDetailActivity.b(this.f67086a).y;
                kotlin.g.b.k.a((Object) xVar, "binding.noBankSupportedLayout");
                ConstraintLayout a2 = xVar.a();
                kotlin.g.b.k.a((Object) a2, "binding.noBankSupportedLayout.root");
                net.one97.paytm.upi.f.a((View) a2);
            }
        }
    }

    static final class d<T> implements z<r<MandateDefaultResponseModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67087a;

        d(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67087a = mandateConfirmationDetailActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            if (rVar != null) {
                int i2 = a.f67095b[rVar.f67411a.ordinal()];
                if (i2 == 1) {
                    FrameLayout frameLayout = MandateConfirmationDetailActivity.b(this.f67087a).u;
                    kotlin.g.b.k.a((Object) frameLayout, "binding.lottieRootLayout");
                    net.one97.paytm.upi.f.a((View) frameLayout);
                    AnimationFactory.stopWalletLoader(MandateConfirmationDetailActivity.b(this.f67087a).n);
                    MandateConfirmationDetailActivity.a(this.f67087a, rVar.f67413c);
                } else if (i2 == 2) {
                    FrameLayout frameLayout2 = MandateConfirmationDetailActivity.b(this.f67087a).u;
                    kotlin.g.b.k.a((Object) frameLayout2, "binding.lottieRootLayout");
                    net.one97.paytm.upi.f.a((View) frameLayout2);
                    AnimationFactory.startWalletLoader(MandateConfirmationDetailActivity.b(this.f67087a).n);
                    T t = rVar.f67412b;
                    if (t == null) {
                        kotlin.g.b.k.a();
                    }
                    MandatePostTransactionActivity.a aVar = MandatePostTransactionActivity.f67445a;
                    MandateConfirmationDetailActivity mandateConfirmationDetailActivity = this.f67087a;
                    MandatePostTransactionActivity.a.a(mandateConfirmationDetailActivity, (MandateDefaultResponseModel) t, MandateConfirmationDetailActivity.c(mandateConfirmationDetailActivity).b(), MandateConfirmationDetailActivity.d(this.f67087a));
                    this.f67087a.finish();
                } else if (i2 == 3) {
                    FrameLayout frameLayout3 = MandateConfirmationDetailActivity.b(this.f67087a).u;
                    kotlin.g.b.k.a((Object) frameLayout3, "binding.lottieRootLayout");
                    net.one97.paytm.upi.f.b((View) frameLayout3);
                    AnimationFactory.startWalletLoader(MandateConfirmationDetailActivity.b(this.f67087a).n);
                }
            }
        }
    }

    public static final /* synthetic */ net.one97.paytm.upi.e.b b(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
        net.one97.paytm.upi.e.b bVar = mandateConfirmationDetailActivity.f67079b;
        if (bVar == null) {
            kotlin.g.b.k.a("binding");
        }
        return bVar;
    }

    public static final /* synthetic */ c c(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
        c cVar = mandateConfirmationDetailActivity.f67081d;
        if (cVar == null) {
            kotlin.g.b.k.a("mandateConfirmationViewModel");
        }
        return cVar;
    }

    public static final /* synthetic */ k d(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
        k kVar = mandateConfirmationDetailActivity.f67082e;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        return kVar;
    }

    public static final /* synthetic */ MandateConfirmationUiModel f(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
        MandateConfirmationUiModel mandateConfirmationUiModel = mandateConfirmationDetailActivity.f67080c;
        if (mandateConfirmationUiModel == null) {
            kotlin.g.b.k.a("mandateConfirmationUiModel");
        }
        return mandateConfirmationUiModel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:153:0x0306, code lost:
        if (kotlin.m.p.a(r2, "NA", true) == false) goto L_0x030a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x027c  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02be  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x02c1  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0338  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x03b0  */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x0415  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04ad  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x04c1  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04d0  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r11) {
        /*
            r10 = this;
            super.onCreate(r11)
            android.view.LayoutInflater r11 = r10.getLayoutInflater()
            net.one97.paytm.upi.e.b r11 = net.one97.paytm.upi.e.b.a(r11)
            java.lang.String r0 = "ActivityMandateConfirmat…g.inflate(layoutInflater)"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            r10.f67079b = r11
            net.one97.paytm.upi.e.b r11 = r10.f67079b
            java.lang.String r0 = "binding"
            if (r11 != 0) goto L_0x001b
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x001b:
            androidx.constraintlayout.widget.ConstraintLayout r11 = r11.a()
            android.view.View r11 = (android.view.View) r11
            r10.setContentView((android.view.View) r11)
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r1 = "intent_response_model"
            java.io.Serializable r11 = r11.getSerializableExtra(r1)
            if (r11 == 0) goto L_0x0502
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r11 = (net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel) r11
            r10.f67080c = r11
            android.content.Intent r11 = r10.getIntent()
            java.lang.String r1 = "mandate_source"
            java.io.Serializable r11 = r11.getSerializableExtra(r1)
            if (r11 == 0) goto L_0x04fa
            net.one97.paytm.upi.mandate.utils.k r11 = (net.one97.paytm.upi.mandate.utils.k) r11
            r10.f67082e = r11
            r11 = r10
            androidx.fragment.app.FragmentActivity r11 = (androidx.fragment.app.FragmentActivity) r11
            net.one97.paytm.upi.mandate.utils.o r1 = new net.one97.paytm.upi.mandate.utils.o
            r1.<init>()
            androidx.lifecycle.al$b r1 = (androidx.lifecycle.al.b) r1
            androidx.lifecycle.al r11 = androidx.lifecycle.am.a((androidx.fragment.app.FragmentActivity) r11, (androidx.lifecycle.al.b) r1)
            java.lang.Class<net.one97.paytm.upi.mandate.confirmation.c> r1 = net.one97.paytm.upi.mandate.confirmation.c.class
            androidx.lifecycle.ai r11 = r11.a(r1)
            java.lang.String r1 = "ViewModelProviders.of(ac…, factory)[T::class.java]"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r1)
            net.one97.paytm.upi.mandate.confirmation.c r11 = (net.one97.paytm.upi.mandate.confirmation.c) r11
            r10.f67081d = r11
            net.one97.paytm.upi.mandate.confirmation.c r11 = r10.f67081d
            java.lang.String r1 = "mandateConfirmationViewModel"
            if (r11 != 0) goto L_0x006a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x006a:
            net.one97.paytm.upi.mandate.utils.k r2 = r10.f67082e
            java.lang.String r3 = "mandateSource"
            if (r2 != 0) goto L_0x0073
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x0073:
            r11.a((net.one97.paytm.upi.mandate.utils.k) r2)
            net.one97.paytm.upi.mandate.confirmation.c r11 = r10.f67081d
            if (r11 != 0) goto L_0x007d
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x007d:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            java.lang.String r4 = "mandateConfirmationUiModel"
            if (r2 != 0) goto L_0x0086
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0086:
            net.one97.paytm.upi.mandate.utils.m r2 = r2.getMandateTransactionType()
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r5 = r10.f67080c
            if (r5 != 0) goto L_0x0091
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0091:
            java.lang.String r5 = r5.getAccRefId()
            r11.a((net.one97.paytm.upi.mandate.utils.m) r2, (java.lang.String) r5)
            net.one97.paytm.upi.e.b r11 = r10.f67079b
            if (r11 != 0) goto L_0x009f
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x009f:
            net.one97.paytm.upi.mandate.utils.k r0 = r10.f67082e
            if (r0 != 0) goto L_0x00a6
            kotlin.g.b.k.a((java.lang.String) r3)
        L_0x00a6:
            net.one97.paytm.upi.mandate.utils.k r2 = net.one97.paytm.upi.mandate.utils.k.PAYEE_UPDATE
            if (r0 != r2) goto L_0x00bc
            android.widget.TextView r0 = r11.o
            java.lang.String r2 = "confirmPaymentText"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r2 = net.one97.paytm.upi.R.string.confirm_to_update_schedule_payment
            java.lang.String r2 = r10.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x00bc:
            android.widget.ImageView r0 = r11.f66786d
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$f r2 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$f
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            android.view.View r0 = r11.p
            java.lang.String r2 = "dashLine"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x00d6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00d6:
            java.lang.String r2 = r2.getRefUrl()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r5 = 1
            if (r2 == 0) goto L_0x00e9
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x00e7
            goto L_0x00e9
        L_0x00e7:
            r2 = 0
            goto L_0x00ea
        L_0x00e9:
            r2 = 1
        L_0x00ea:
            r2 = r2 ^ r5
            net.one97.paytm.upi.f.a((android.view.View) r0, (boolean) r2)
            android.widget.TextView r0 = r11.J
            java.lang.String r2 = "viewDetailsTextView"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x00fe
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00fe:
            java.lang.String r2 = r2.getRefUrl()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x010f
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x010d
            goto L_0x010f
        L_0x010d:
            r2 = 0
            goto L_0x0110
        L_0x010f:
            r2 = 1
        L_0x0110:
            r2 = r2 ^ r5
            net.one97.paytm.upi.f.a((android.view.View) r0, (boolean) r2)
            android.widget.TextView r0 = r11.B
            java.lang.String r2 = "payeeName"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x0122
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0122:
            java.lang.String r2 = r2.getPayeeName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r11.C
            java.lang.String r2 = "payeeUpiId"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r2 = net.one97.paytm.upi.R.string.upi_id_with_placeholder
            java.lang.Object[] r6 = new java.lang.Object[r5]
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r7 = r10.f67080c
            if (r7 != 0) goto L_0x013d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x013d:
            java.lang.String r7 = r7.getPayeeVpa()
            r6[r3] = r7
            java.lang.String r2 = r10.getString(r2, r6)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r11.f66785c
            java.lang.String r2 = "amountTextView"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x015a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x015a:
            java.lang.String r2 = r2.getAmount()
            java.lang.String r2 = net.one97.paytm.upi.util.UpiAppUtils.formatNumber((java.lang.String) r2)
            java.lang.String r6 = "UpiAppUtils.formatNumber…nfirmationUiModel.amount)"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            java.lang.String r2 = net.one97.paytm.upi.f.b((java.lang.String) r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            int r0 = net.one97.paytm.upi.R.string.mt_amount_in_words_placeholder
            java.lang.Object[] r2 = new java.lang.Object[r5]
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r6 = r10.f67080c
            if (r6 != 0) goto L_0x017b
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x017b:
            java.lang.String r6 = r6.getAmount()
            java.lang.String r6 = net.one97.paytm.upi.util.EnglishNumberToWords.convert((java.lang.String) r6)
            r2[r3] = r6
            java.lang.String r0 = r10.getString(r0, r2)
            java.lang.String r2 = "getString(R.string.mt_am…firmationUiModel.amount))"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.widget.TextView r2 = r11.f66784b
            java.lang.String r6 = "amountInWordsTextView"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r6)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r6 = r10.f67080c
            if (r6 != 0) goto L_0x019c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x019c:
            java.lang.String r6 = r6.getAmountRule()
            java.lang.String r7 = "MAX"
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x01d1
            int r6 = net.one97.paytm.upi.R.string.upi_mandate_upto
            java.lang.String r6 = r10.getString(r6)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            java.lang.String r6 = " "
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r6)
            r8.append(r0)
            java.lang.String r0 = r8.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x01d3
        L_0x01d1:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x01d3:
            r2.setText(r0)
            android.widget.TextView r0 = r11.I
            java.lang.String r2 = "uptoPlaceHolder"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x01e6
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01e6:
            java.lang.String r2 = r2.getAmountRule()
            boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r7)
            net.one97.paytm.upi.f.a((android.view.View) r0, (boolean) r2)
            android.widget.TextView r0 = r11.v
            java.lang.String r2 = "mandateName"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r6 = r10.f67080c
            if (r6 != 0) goto L_0x01ff
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x01ff:
            java.lang.String r6 = r6.getMandateName()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            android.widget.TextView r0 = r11.m
            java.lang.String r6 = "comment"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r7 = r10.f67080c
            if (r7 != 0) goto L_0x0216
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0216:
            java.lang.String r7 = r7.getComment()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0.setText(r7)
            android.widget.TextView r0 = r11.v
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x022d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x022d:
            java.lang.String r2 = r2.getMandateName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x023e
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x023c
            goto L_0x023e
        L_0x023c:
            r2 = 0
            goto L_0x023f
        L_0x023e:
            r2 = 1
        L_0x023f:
            java.lang.String r7 = "NA"
            if (r2 != 0) goto L_0x025b
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x024a
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x024a:
            java.lang.String r2 = r2.getMandateName()
            if (r2 != 0) goto L_0x0253
            kotlin.g.b.k.a()
        L_0x0253:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r5)
            if (r2 != 0) goto L_0x025b
            r2 = 1
            goto L_0x025c
        L_0x025b:
            r2 = 0
        L_0x025c:
            net.one97.paytm.upi.f.a((android.view.View) r0, (boolean) r2)
            android.widget.TextView r0 = r11.m
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x026d
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x026d:
            java.lang.String r2 = r2.getComment()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x027e
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x027c
            goto L_0x027e
        L_0x027c:
            r2 = 0
            goto L_0x027f
        L_0x027e:
            r2 = 1
        L_0x027f:
            if (r2 != 0) goto L_0x0299
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x0288
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0288:
            java.lang.String r2 = r2.getComment()
            if (r2 != 0) goto L_0x0291
            kotlin.g.b.k.a()
        L_0x0291:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r5)
            if (r2 != 0) goto L_0x0299
            r2 = 1
            goto L_0x029a
        L_0x0299:
            r2 = 0
        L_0x029a:
            net.one97.paytm.upi.f.a((android.view.View) r0, (boolean) r2)
            android.widget.TextView r0 = r11.x
            java.lang.String r2 = "nameOfPaymentPlaceHolder"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x02ad
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x02ad:
            java.lang.String r2 = r2.getMandateName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x02be
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x02bc
            goto L_0x02be
        L_0x02bc:
            r2 = 0
            goto L_0x02bf
        L_0x02be:
            r2 = 1
        L_0x02bf:
            if (r2 != 0) goto L_0x0309
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x02c8
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x02c8:
            java.lang.String r2 = r2.getMandateName()
            if (r2 != 0) goto L_0x02d1
            kotlin.g.b.k.a()
        L_0x02d1:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r5)
            if (r2 != 0) goto L_0x0309
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x02de
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x02de:
            java.lang.String r2 = r2.getComment()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x02ef
            boolean r2 = kotlin.m.p.a(r2)
            if (r2 == 0) goto L_0x02ed
            goto L_0x02ef
        L_0x02ed:
            r2 = 0
            goto L_0x02f0
        L_0x02ef:
            r2 = 1
        L_0x02f0:
            if (r2 != 0) goto L_0x0309
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r2 = r10.f67080c
            if (r2 != 0) goto L_0x02f9
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x02f9:
            java.lang.String r2 = r2.getComment()
            if (r2 != 0) goto L_0x0302
            kotlin.g.b.k.a()
        L_0x0302:
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r7, (boolean) r5)
            if (r2 != 0) goto L_0x0309
            goto L_0x030a
        L_0x0309:
            r5 = 0
        L_0x030a:
            net.one97.paytm.upi.f.a((android.view.View) r0, (boolean) r5)
            android.widget.Button r0 = r11.D
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$g r2 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$g
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            android.view.View r0 = r11.f66787e
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$h r2 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$h
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r0 = r10.f67080c
            if (r0 != 0) goto L_0x032c
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x032c:
            net.one97.paytm.upi.mandate.utils.m r0 = r0.getMandateTransactionType()
            net.one97.paytm.upi.mandate.utils.m r2 = net.one97.paytm.upi.mandate.utils.m.RECURRING
            java.lang.String r5 = "forThePeriodValue"
            java.lang.String r6 = "toBePaidValue"
            if (r0 != r2) goto L_0x03b0
            android.widget.TextView r0 = r11.G
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            net.one97.paytm.upi.mandate.d.a r2 = net.one97.paytm.upi.mandate.d.a.f67112a
            r2 = r10
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r6 = r10.f67080c
            if (r6 != 0) goto L_0x0349
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0349:
            java.lang.String r6 = r6.getRecurrenceRule()
            if (r6 != 0) goto L_0x0352
            kotlin.g.b.k.a()
        L_0x0352:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r7 = r10.f67080c
            if (r7 != 0) goto L_0x0359
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0359:
            java.lang.String r7 = r7.getRecurrencePattern()
            if (r7 != 0) goto L_0x0362
            kotlin.g.b.k.a()
        L_0x0362:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r8 = r10.f67080c
            if (r8 != 0) goto L_0x0369
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0369:
            java.lang.String r8 = r8.getRecurrenceType()
            if (r8 != 0) goto L_0x0372
            kotlin.g.b.k.a()
        L_0x0372:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r9 = r10.f67080c
            if (r9 != 0) goto L_0x0379
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0379:
            java.lang.String r9 = r9.getStartDate()
            if (r9 != 0) goto L_0x0382
            kotlin.g.b.k.a()
        L_0x0382:
            java.lang.String r6 = net.one97.paytm.upi.mandate.d.a.a(r2, r6, r7, r8, r9)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r0.setText(r6)
            android.widget.TextView r0 = r11.r
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.mandate.d.a r5 = net.one97.paytm.upi.mandate.d.a.f67112a
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r5 = r10.f67080c
            if (r5 != 0) goto L_0x0399
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0399:
            java.lang.String r5 = r5.getStartDate()
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r6 = r10.f67080c
            if (r6 != 0) goto L_0x03a4
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03a4:
            java.lang.String r6 = r6.getEndDate()
            java.lang.CharSequence r2 = net.one97.paytm.upi.mandate.d.a.a((android.content.Context) r2, (java.lang.String) r5, (java.lang.String) r6)
            r0.setText(r2)
            goto L_0x0411
        L_0x03b0:
            android.widget.TextView r0 = r11.F
            java.lang.String r2 = "toBePaidPlaceHolder"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.a((android.view.View) r0)
            android.widget.TextView r0 = r11.G
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.a((android.view.View) r0)
            android.widget.TextView r0 = r11.q
            java.lang.String r2 = "forThePeriodPlaceHolder"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r2 = net.one97.paytm.upi.R.string.upi_mandate_valid_from
            java.lang.String r2 = r10.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r11.r
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r5)
            net.one97.paytm.upi.mandate.d.a r2 = net.one97.paytm.upi.mandate.d.a.f67112a
            r2 = r10
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r5 = r10.f67080c
            if (r5 != 0) goto L_0x03e9
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03e9:
            java.lang.String r5 = r5.getStartDate()
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r6 = r10.f67080c
            if (r6 != 0) goto L_0x03f4
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x03f4:
            java.lang.String r6 = r6.getEndDate()
            java.lang.CharSequence r2 = net.one97.paytm.upi.mandate.d.a.b(r2, r5, r6)
            r0.setText(r2)
            android.widget.TextView r0 = r11.t
            java.lang.String r2 = "importantMessage"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r2 = net.one97.paytm.upi.R.string.upi_mandate_one_time_imp_message
            java.lang.String r2 = r10.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0411:
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r0 = r10.f67080c
            if (r0 != 0) goto L_0x0418
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x0418:
            java.lang.String r0 = r0.getAccRefId()
            if (r0 == 0) goto L_0x042a
            android.widget.TextView r0 = r11.l
            java.lang.String r2 = "changeBank"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            android.view.View r0 = (android.view.View) r0
            net.one97.paytm.upi.f.a((android.view.View) r0)
        L_0x042a:
            net.one97.paytm.upi.e.x r0 = r11.y
            android.widget.Button r0 = r0.f66923a
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$i r2 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$i
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r11.J
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$j r2 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$j
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            android.widget.TextView r0 = r11.E
            java.lang.String r2 = "termsAndConditions"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.CharSequence r2 = r0.getText()
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r5 = 6
            java.lang.String r6 = "Terms"
            int r2 = kotlin.m.p.a((java.lang.CharSequence) r2, (java.lang.String) r6, (int) r3, (boolean) r3, (int) r5)
            java.lang.CharSequence r5 = r0.getText()
            java.lang.String r5 = r5.toString()
            int r5 = r5.length()
            java.lang.CharSequence r6 = r0.getText()
            java.lang.String r7 = "termsAndConditions.text"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
            android.text.SpannableString r6 = net.one97.paytm.upi.f.a((java.lang.CharSequence) r6)
            int r7 = net.one97.paytm.upi.R.color.metallic_blue
            java.lang.String r8 = "$this$getColorCompat"
            kotlin.g.b.k.c(r10, r8)
            r8 = r10
            android.content.Context r8 = (android.content.Context) r8
            int r7 = androidx.core.content.b.c(r8, r7)
            android.text.SpannableString r3 = net.one97.paytm.upi.f.a(r6, r7, r3, r2)
            java.lang.String r6 = "#00aeed"
            int r6 = net.one97.paytm.upi.f.c((java.lang.String) r6)
            android.text.SpannableString r2 = net.one97.paytm.upi.f.a(r3, r6, r2, r5)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$e r2 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$e
            r2.<init>(r10)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r0.setOnClickListener(r2)
            net.one97.paytm.upi.e.x r11 = r11.y
            android.widget.TextView r11 = r11.f66926d
            java.lang.String r0 = "noBankSupportedLayout.title"
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r0 = r10.f67080c
            if (r0 != 0) goto L_0x04b0
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x04b0:
            net.one97.paytm.upi.mandate.utils.m r0 = r0.getMandateTransactionType()
            net.one97.paytm.upi.mandate.utils.m r2 = net.one97.paytm.upi.mandate.utils.m.ASBA
            if (r0 != r2) goto L_0x04c1
            int r0 = net.one97.paytm.upi.R.string.your_linked_bank_accounts_currently_do_not_support_ipo_payments
            java.lang.String r0 = r10.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x04c9
        L_0x04c1:
            int r0 = net.one97.paytm.upi.R.string.your_linked_bank_accounts_currently_do_not_support_scheduled_payments
            java.lang.String r0 = r10.getString(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x04c9:
            r11.setText(r0)
            net.one97.paytm.upi.mandate.confirmation.c r11 = r10.f67081d
            if (r11 != 0) goto L_0x04d3
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x04d3:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.data.a<java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r11 = r11.f67096a
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            r0 = r10
            androidx.lifecycle.q r0 = (androidx.lifecycle.q) r0
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$c r2 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$c
            r2.<init>(r10)
            androidx.lifecycle.z r2 = (androidx.lifecycle.z) r2
            r11.observe(r0, r2)
            net.one97.paytm.upi.mandate.confirmation.c r11 = r10.f67081d
            if (r11 != 0) goto L_0x04eb
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x04eb:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.utils.r<net.one97.paytm.upi.mandate.data.model.MandateDefaultResponseModel>> r11 = r11.f67098c
            androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$d r1 = new net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$d
            r1.<init>(r10)
            androidx.lifecycle.z r1 = (androidx.lifecycle.z) r1
            r11.observe(r0, r1)
            return
        L_0x04fa:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.mandate.utils.MandateSource"
            r11.<init>(r0)
            throw r11
        L_0x0502:
            kotlin.u r11 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel"
            r11.<init>(r0)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.onCreate(android.os.Bundle):void");
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67089a;

        f(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67089a = mandateConfirmationDetailActivity;
        }

        public final void onClick(View view) {
            this.f67089a.onBackPressed();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67090a;

        g(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67090a = mandateConfirmationDetailActivity;
        }

        public final void onClick(View view) {
            UpiProfileDefaultBank upiProfileDefaultBank = MandateConfirmationDetailActivity.c(this.f67090a).f67097b;
            if (upiProfileDefaultBank == null) {
                kotlin.g.b.k.a();
            }
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "mandateConfirmationViewM…l.defaultBank!!.debitBank");
            if (debitBank.isMpinSet()) {
                MandateConfirmationDetailActivity.e(this.f67090a);
                MandateConfirmationDetailActivity.c(this.f67090a).a(MandateConfirmationDetailActivity.f(this.f67090a), MandateConfirmationDetailActivity.d(this.f67090a));
                return;
            }
            MandateConfirmationDetailActivity.g(this.f67090a);
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67091a;

        h(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67091a = mandateConfirmationDetailActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
            r11 = (java.util.List) r11.f67118b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r11) {
            /*
                r10 = this;
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.f(r11)
                java.lang.String r11 = r11.getAccRefId()
                if (r11 == 0) goto L_0x000d
                return
            L_0x000d:
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                net.one97.paytm.upi.mandate.confirmation.c r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.c(r11)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = r11.f67097b
                if (r11 == 0) goto L_0x00b7
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                net.one97.paytm.upi.mandate.utils.k r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.d(r11)
                net.one97.paytm.upi.mandate.utils.k r0 = net.one97.paytm.upi.mandate.utils.k.INTENT
                if (r11 != r0) goto L_0x007d
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                r0 = r11
                android.content.Context r0 = (android.content.Context) r0
                net.one97.paytm.upi.mandate.confirmation.c r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.c(r11)
                androidx.lifecycle.y<net.one97.paytm.upi.mandate.data.a<java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r11 = r11.f67096a
                androidx.lifecycle.LiveData r11 = (androidx.lifecycle.LiveData) r11
                java.lang.Object r11 = r11.getValue()
                net.one97.paytm.upi.mandate.data.a r11 = (net.one97.paytm.upi.mandate.data.a) r11
                if (r11 == 0) goto L_0x0050
                ResultType r11 = r11.f67118b
                java.util.List r11 = (java.util.List) r11
                if (r11 == 0) goto L_0x0050
                r1 = r11
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                r2 = 0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                net.one97.paytm.upi.mandate.confirmation.b r11 = net.one97.paytm.upi.mandate.confirmation.b.INSTANCE
                r7 = r11
                kotlin.g.a.b r7 = (kotlin.g.a.b) r7
                r8 = 31
                java.lang.String r11 = kotlin.a.k.a((java.lang.Iterable) r1, (java.lang.CharSequence) r2, (java.lang.CharSequence) r3, (java.lang.CharSequence) r4, (int) r5, (java.lang.CharSequence) r6, (kotlin.g.a.b) r7, (int) r8)
                goto L_0x0051
            L_0x0050:
                r11 = 0
            L_0x0051:
                r3 = r11
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.f(r11)
                java.lang.String r4 = r11.getRecurrencePattern()
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.f(r11)
                java.lang.String r6 = r11.getPayeeVpa()
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.f(r11)
                java.lang.String r7 = r11.getAmount()
                java.lang.String r1 = "/Automatic_Payment_Intent_Creation"
                java.lang.String r2 = "Change_Bank_clicked"
                java.lang.String r5 = ""
                java.lang.String r8 = "/Automatic_Payment_create_confirmation_Intent"
                java.lang.String r9 = ""
                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            L_0x007d:
                net.one97.paytm.upi.mandate.a.b$a r11 = net.one97.paytm.upi.mandate.a.b.f67019c
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r11 = r10.f67091a
                net.one97.paytm.upi.mandate.confirmation.c r11 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.c(r11)
                net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r11 = r11.f67097b
                if (r11 != 0) goto L_0x008c
                kotlin.g.b.k.a()
            L_0x008c:
                net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r11 = r11.getDebitBank()
                java.lang.String r0 = "mandateConfirmationViewM…l.defaultBank!!.debitBank"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
                java.lang.String r11 = r11.getAccount()
                java.lang.String r0 = "mandateConfirmationViewM…tBank!!.debitBank.account"
                kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r0)
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r0 = r10.f67091a
                net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r0 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.f(r0)
                java.lang.String r0 = r0.getBankFilterType()
                net.one97.paytm.upi.mandate.a.b r11 = net.one97.paytm.upi.mandate.a.b.a.a(r11, r0)
                net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r0 = r10.f67091a
                androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
                java.lang.String r1 = ""
                r11.show((androidx.fragment.app.j) r0, (java.lang.String) r1)
            L_0x00b7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.h.onClick(android.view.View):void");
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67092a;

        i(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67092a = mandateConfirmationDetailActivity;
        }

        public final void onClick(View view) {
            MandateConfirmationDetailActivity.h(this.f67092a);
            MandateConfirmationDetailActivity mandateConfirmationDetailActivity = this.f67092a;
            AccountProviderActivity.a((Activity) mandateConfirmationDetailActivity, mandateConfirmationDetailActivity.f67084g);
        }
    }

    static final class j implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67093a;

        j(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67093a = mandateConfirmationDetailActivity;
        }

        public final void onClick(View view) {
            UpiWebViewActivity.Companion companion = UpiWebViewActivity.Companion;
            MandateConfirmationDetailActivity mandateConfirmationDetailActivity = this.f67093a;
            Activity activity = mandateConfirmationDetailActivity;
            String refUrl = MandateConfirmationDetailActivity.f(mandateConfirmationDetailActivity).getRefUrl();
            if (refUrl == null) {
                kotlin.g.b.k.a();
            }
            companion.startActivity(activity, refUrl, Boolean.TRUE);
        }
    }

    static final class b extends l implements kotlin.g.a.b<UpiProfileDefaultBank, String> {
        public static final b INSTANCE = new b();

        b() {
            super(1);
        }

        public final String invoke(UpiProfileDefaultBank upiProfileDefaultBank) {
            kotlin.g.b.k.c(upiProfileDefaultBank, "it");
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "it.debitBank");
            String bankName = debitBank.getBankName();
            kotlin.g.b.k.a((Object) bankName, "it.debitBank.bankName");
            return bankName;
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MandateConfirmationDetailActivity f67088a;

        e(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
            this.f67088a = mandateConfirmationDetailActivity;
        }

        public final void onClick(View view) {
            MandateConfirmationDetailActivity.j(this.f67088a);
            UpiWebViewActivity.Companion.startActivity(this.f67088a, "https://www.paytmbank.com/Terms&Conditions", Boolean.TRUE);
        }
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        kotlin.g.b.k.c(upiProfileDefaultBank, CJRPGTransactionRequestUtils.PAYER_BANK_NAME);
        c cVar = this.f67081d;
        if (cVar == null) {
            kotlin.g.b.k.a("mandateConfirmationViewModel");
        }
        cVar.a(upiProfileDefaultBank);
        net.one97.paytm.upi.e.b bVar = this.f67079b;
        if (bVar == null) {
            kotlin.g.b.k.a("binding");
        }
        TextView textView = bVar.j;
        kotlin.g.b.k.a((Object) textView, "binding.bankName");
        BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
        kotlin.g.b.k.a((Object) debitBank, "bank.debitBank");
        textView.setText(debitBank.getBankName());
        net.one97.paytm.upi.e.b bVar2 = this.f67079b;
        if (bVar2 == null) {
            kotlin.g.b.k.a("binding");
        }
        UpiUtils.setBankIcon(bVar2.f66789g, upiProfileDefaultBank.getDebitBank(), (Context) this);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f67084g && i3 == -1) {
            if (intent == null) {
                kotlin.g.b.k.a();
            }
            Serializable serializableExtra = intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER);
            if (serializableExtra != null) {
                AccountProviderBody.AccountProvider accountProvider = (AccountProviderBody.AccountProvider) serializableExtra;
                Activity activity = this;
                c cVar = this.f67081d;
                if (cVar == null) {
                    kotlin.g.b.k.a("mandateConfirmationViewModel");
                }
                BankVpaCreationActivity.a(activity, accountProvider, cVar.a().getVirtualAddress(), this.f67083f);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upi.common.upi.AccountProviderBody.AccountProvider");
        } else if (i2 == this.f67083f && i3 == -1) {
            c cVar2 = this.f67081d;
            if (cVar2 == null) {
                kotlin.g.b.k.a("mandateConfirmationViewModel");
            }
            MandateConfirmationUiModel mandateConfirmationUiModel = this.f67080c;
            if (mandateConfirmationUiModel == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            m mandateTransactionType = mandateConfirmationUiModel.getMandateTransactionType();
            MandateConfirmationUiModel mandateConfirmationUiModel2 = this.f67080c;
            if (mandateConfirmationUiModel2 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            cVar2.a(mandateTransactionType, mandateConfirmationUiModel2.getAccRefId());
        } else if (i2 == this.f67085h && i3 == -1) {
            c cVar3 = this.f67081d;
            if (cVar3 == null) {
                kotlin.g.b.k.a("mandateConfirmationViewModel");
            }
            MandateConfirmationUiModel mandateConfirmationUiModel3 = this.f67080c;
            if (mandateConfirmationUiModel3 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            m mandateTransactionType2 = mandateConfirmationUiModel3.getMandateTransactionType();
            MandateConfirmationUiModel mandateConfirmationUiModel4 = this.f67080c;
            if (mandateConfirmationUiModel4 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            cVar3.a(mandateTransactionType2, mandateConfirmationUiModel4.getAccRefId());
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(a.C1354a aVar, k kVar) {
            kotlin.g.b.k.c(aVar, "confirmationIntentModel");
            kotlin.g.b.k.c(kVar, "source");
            Intent intent = new Intent(aVar.f67113a, MandateConfirmationDetailActivity.class);
            intent.putExtra("intent_response_model", aVar.f67114b);
            intent.putExtra("mandate_source", kVar);
            if (aVar.f67115c) {
                intent.setFlags(268468224);
            }
            aVar.f67113a.startActivity(intent);
        }
    }

    public static final /* synthetic */ void a(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
        c cVar = mandateConfirmationDetailActivity.f67081d;
        if (cVar == null) {
            kotlin.g.b.k.a("mandateConfirmationViewModel");
        }
        UpiProfileDefaultBank upiProfileDefaultBank = cVar.f67097b;
        if (upiProfileDefaultBank != null) {
            net.one97.paytm.upi.e.b bVar = mandateConfirmationDetailActivity.f67079b;
            if (bVar == null) {
                kotlin.g.b.k.a("binding");
            }
            CardView cardView = bVar.z;
            kotlin.g.b.k.a((Object) cardView, "payButtonCardView");
            net.one97.paytm.upi.f.b((View) cardView);
            Group group = bVar.f66788f;
            kotlin.g.b.k.a((Object) group, "bankGroup");
            net.one97.paytm.upi.f.b((View) group);
            net.one97.paytm.upi.e.b bVar2 = mandateConfirmationDetailActivity.f67079b;
            if (bVar2 == null) {
                kotlin.g.b.k.a("binding");
            }
            TextView textView = bVar2.l;
            kotlin.g.b.k.a((Object) textView, "binding.changeBank");
            View view = textView;
            MandateConfirmationUiModel mandateConfirmationUiModel = mandateConfirmationDetailActivity.f67080c;
            if (mandateConfirmationUiModel == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            net.one97.paytm.upi.f.a(view, mandateConfirmationUiModel.getAccRefId() == null);
            x xVar = bVar.y;
            kotlin.g.b.k.a((Object) xVar, "noBankSupportedLayout");
            ConstraintLayout a2 = xVar.a();
            kotlin.g.b.k.a((Object) a2, "noBankSupportedLayout.root");
            net.one97.paytm.upi.f.a((View) a2);
            net.one97.paytm.upi.e.b bVar3 = mandateConfirmationDetailActivity.f67079b;
            if (bVar3 == null) {
                kotlin.g.b.k.a("binding");
            }
            TextView textView2 = bVar3.j;
            kotlin.g.b.k.a((Object) textView2, "binding.bankName");
            BankAccountDetails.BankAccount debitBank = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank, "defaultBank.debitBank");
            String bankName = debitBank.getBankName();
            StringBuilder sb = new StringBuilder();
            sb.append(bankName);
            BankAccountDetails.BankAccount debitBank2 = upiProfileDefaultBank.getDebitBank();
            kotlin.g.b.k.a((Object) debitBank2, "defaultBank.debitBank");
            sb.append(UpiUtils.getFormattedMaskedAcc(debitBank2.getAccount()));
            textView2.setText(sb.toString());
            net.one97.paytm.upi.e.b bVar4 = mandateConfirmationDetailActivity.f67079b;
            if (bVar4 == null) {
                kotlin.g.b.k.a("binding");
            }
            UpiUtils.setBankIcon(bVar4.f66789g, upiProfileDefaultBank.getDebitBank(), (Context) mandateConfirmationDetailActivity);
            return;
        }
        net.one97.paytm.upi.e.b bVar5 = mandateConfirmationDetailActivity.f67079b;
        if (bVar5 == null) {
            kotlin.g.b.k.a("binding");
        }
        CardView cardView2 = bVar5.z;
        kotlin.g.b.k.a((Object) cardView2, "payButtonCardView");
        net.one97.paytm.upi.f.a((View) cardView2);
        Group group2 = bVar5.f66788f;
        kotlin.g.b.k.a((Object) group2, "bankGroup");
        net.one97.paytm.upi.f.a((View) group2);
        TextView textView3 = bVar5.l;
        kotlin.g.b.k.a((Object) textView3, "changeBank");
        net.one97.paytm.upi.f.a((View) textView3);
        x xVar2 = bVar5.y;
        kotlin.g.b.k.a((Object) xVar2, "noBankSupportedLayout");
        ConstraintLayout a3 = xVar2.a();
        kotlin.g.b.k.a((Object) a3, "noBankSupportedLayout.root");
        net.one97.paytm.upi.f.b((View) a3);
        c cVar2 = mandateConfirmationDetailActivity.f67081d;
        if (cVar2 == null) {
            kotlin.g.b.k.a("mandateConfirmationViewModel");
        }
        List<BankAccountDetails.BankAccount> c2 = cVar2.c();
        RecyclerView recyclerView = bVar5.y.f66924b;
        recyclerView.setAdapter((RecyclerView.a) null);
        recyclerView.setAdapter(new net.one97.paytm.upi.mandate.a.a(c2));
    }

    public static final /* synthetic */ void a(MandateConfirmationDetailActivity mandateConfirmationDetailActivity, t tVar) {
        if (tVar instanceof t.c) {
            Intent intent = new Intent(mandateConfirmationDetailActivity, UpiRegistrationActivity.class);
            intent.putExtra("redirect", 80);
            intent.setFlags(536870912);
            mandateConfirmationDetailActivity.startActivityForResult(intent, 80);
        } else if (tVar instanceof t.a) {
            String str = ((t.a) tVar).f67420a;
            if (str == null) {
                str = mandateConfirmationDetailActivity.getString(R.string.upi_some_went_wrong);
                kotlin.g.b.k.a((Object) str, "getString(R.string.upi_some_went_wrong)");
            }
            net.one97.paytm.upi.f.a((Context) mandateConfirmationDetailActivity, str, 1);
        } else if ((tVar instanceof t.k) || kotlin.g.b.k.a((Object) tVar, (Object) t.h.f67427a)) {
            net.one97.paytm.upi.f.a((Context) mandateConfirmationDetailActivity, R.string.error_fetching_profile_details, 1);
        } else if (tVar instanceof t.i) {
            CustomDialog.showAlert(mandateConfirmationDetailActivity, mandateConfirmationDetailActivity.getResources().getString(R.string.no_connection), mandateConfirmationDetailActivity.getResources().getString(R.string.no_internet));
        } else if (tVar instanceof t.f) {
            String str2 = ((t.f) tVar).f67425a;
            if (str2 == null) {
                str2 = mandateConfirmationDetailActivity.getString(R.string.something_went_wrong);
                kotlin.g.b.k.a((Object) str2, "getString(R.string.something_went_wrong)");
            }
            net.one97.paytm.upi.f.a((Context) mandateConfirmationDetailActivity, str2, 1);
        } else if (tVar instanceof t.j) {
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            MandateConfirmationDetailActivity.class.getName();
            a2.b().e(mandateConfirmationDetailActivity);
        } else if (tVar instanceof t.g) {
            net.one97.paytm.upi.f.a((Context) mandateConfirmationDetailActivity, R.string.something_went_wrong, 1);
        }
    }

    public static final /* synthetic */ void e(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
        BankAccountDetails.BankAccount debitBank;
        BankAccountDetails.BankAccount debitBank2;
        BankAccountDetails.BankAccount debitBank3;
        MandateConfirmationDetailActivity mandateConfirmationDetailActivity2 = mandateConfirmationDetailActivity;
        k kVar = mandateConfirmationDetailActivity2.f67082e;
        if (kVar == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        String str = null;
        if (kVar == k.INTENT) {
            Context context = mandateConfirmationDetailActivity2;
            c cVar = mandateConfirmationDetailActivity2.f67081d;
            if (cVar == null) {
                kotlin.g.b.k.a("mandateConfirmationViewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank = cVar.f67097b;
            if (!(upiProfileDefaultBank == null || (debitBank3 = upiProfileDefaultBank.getDebitBank()) == null)) {
                str = debitBank3.getBankName();
            }
            String str2 = str;
            MandateConfirmationUiModel mandateConfirmationUiModel = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            String recurrencePattern = mandateConfirmationUiModel.getRecurrencePattern();
            MandateConfirmationUiModel mandateConfirmationUiModel2 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel2 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            String payeeVpa = mandateConfirmationUiModel2.getPayeeVpa();
            MandateConfirmationUiModel mandateConfirmationUiModel3 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel3 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_INTENT, "Create_Intent_Confirm_confirmation_clicked", str2, recurrencePattern, "", payeeVpa, mandateConfirmationUiModel3.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_INTENT, "");
            return;
        }
        k kVar2 = mandateConfirmationDetailActivity2.f67082e;
        if (kVar2 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar2 == k.COLLECT) {
            Context context2 = mandateConfirmationDetailActivity2;
            c cVar2 = mandateConfirmationDetailActivity2.f67081d;
            if (cVar2 == null) {
                kotlin.g.b.k.a("mandateConfirmationViewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank2 = cVar2.f67097b;
            if (!(upiProfileDefaultBank2 == null || (debitBank2 = upiProfileDefaultBank2.getDebitBank()) == null)) {
                str = debitBank2.getBankName();
            }
            String str3 = str;
            MandateConfirmationUiModel mandateConfirmationUiModel4 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel4 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            String recurrencePattern2 = mandateConfirmationUiModel4.getRecurrencePattern();
            MandateConfirmationUiModel mandateConfirmationUiModel5 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel5 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            String payeeVpa2 = mandateConfirmationUiModel5.getPayeeVpa();
            MandateConfirmationUiModel mandateConfirmationUiModel6 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel6 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context2, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_COLLECT, "Create_Confirm_confirmation_clicked", str3, recurrencePattern2, "", payeeVpa2, mandateConfirmationUiModel6.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_CONFIRMATION, "");
            return;
        }
        k kVar3 = mandateConfirmationDetailActivity2.f67082e;
        if (kVar3 == null) {
            kotlin.g.b.k.a("mandateSource");
        }
        if (kVar3 == k.PAYEE_UPDATE) {
            Context context3 = mandateConfirmationDetailActivity2;
            c cVar3 = mandateConfirmationDetailActivity2.f67081d;
            if (cVar3 == null) {
                kotlin.g.b.k.a("mandateConfirmationViewModel");
            }
            UpiProfileDefaultBank upiProfileDefaultBank3 = cVar3.f67097b;
            if (!(upiProfileDefaultBank3 == null || (debitBank = upiProfileDefaultBank3.getDebitBank()) == null)) {
                str = debitBank.getBankName();
            }
            String str4 = str;
            MandateConfirmationUiModel mandateConfirmationUiModel7 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel7 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            String recurrencePattern3 = mandateConfirmationUiModel7.getRecurrencePattern();
            MandateConfirmationUiModel mandateConfirmationUiModel8 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel8 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            String payeeVpa3 = mandateConfirmationUiModel8.getPayeeVpa();
            MandateConfirmationUiModel mandateConfirmationUiModel9 = mandateConfirmationDetailActivity2.f67080c;
            if (mandateConfirmationUiModel9 == null) {
                kotlin.g.b.k.a("mandateConfirmationUiModel");
            }
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context3, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_UPDATE, "Update_Confirm_confirmation_clicked", str4, recurrencePattern3, "", payeeVpa3, mandateConfirmationUiModel9.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENT_CREATE_CONFIRMATION, "");
        }
    }

    public static final /* synthetic */ void g(MandateConfirmationDetailActivity mandateConfirmationDetailActivity) {
        c cVar = mandateConfirmationDetailActivity.f67081d;
        if (cVar == null) {
            kotlin.g.b.k.a("mandateConfirmationViewModel");
        }
        UpiProfileDefaultBank upiProfileDefaultBank = cVar.f67097b;
        if (upiProfileDefaultBank == null) {
            kotlin.g.b.k.a();
        }
        Intent intent = new Intent(mandateConfirmationDetailActivity, SetMPINActivity.class);
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(kotlin.a.k.a(upiProfileDefaultBank.getDebitBank())).build();
        kotlin.g.b.k.a((Object) build, "UserUpiDetails\n         …AccountList(list).build()");
        intent.putExtra("user_upi_details", build);
        mandateConfirmationDetailActivity.startActivityForResult(intent, mandateConfirmationDetailActivity.f67085h);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        r0 = (java.util.List) r0.f67118b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void h(net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r12) {
        /*
            net.one97.paytm.upi.mandate.utils.k r0 = r12.f67082e
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "mandateSource"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            net.one97.paytm.upi.mandate.utils.k r1 = net.one97.paytm.upi.mandate.utils.k.INTENT
            if (r0 != r1) goto L_0x0068
            r2 = r12
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.upi.mandate.confirmation.c r0 = r12.f67081d
            if (r0 != 0) goto L_0x0019
            java.lang.String r1 = "mandateConfirmationViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0019:
            androidx.lifecycle.y<net.one97.paytm.upi.mandate.data.a<java.util.List<net.one97.paytm.upi.common.upi.UpiProfileDefaultBank>>> r0 = r0.f67096a
            androidx.lifecycle.LiveData r0 = (androidx.lifecycle.LiveData) r0
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.upi.mandate.data.a r0 = (net.one97.paytm.upi.mandate.data.a) r0
            if (r0 == 0) goto L_0x003f
            ResultType r0 = r0.f67118b
            java.util.List r0 = (java.util.List) r0
            if (r0 == 0) goto L_0x003f
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity$b r0 = net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.b.INSTANCE
            r9 = r0
            kotlin.g.a.b r9 = (kotlin.g.a.b) r9
            r10 = 31
            java.lang.String r0 = kotlin.a.k.a((java.lang.Iterable) r3, (java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (int) r7, (java.lang.CharSequence) r8, (kotlin.g.a.b) r9, (int) r10)
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            r6 = r0
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r0 = r12.f67080c
            java.lang.String r1 = "mandateConfirmationUiModel"
            if (r0 != 0) goto L_0x004a
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x004a:
            java.lang.String r8 = r0.getPayeeVpa()
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r12 = r12.f67080c
            if (r12 != 0) goto L_0x0055
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0055:
            java.lang.String r9 = r12.getAmount()
            java.lang.String r3 = "/Automatic_Payment_Intent_Creation"
            java.lang.String r4 = "Link_Another_Bank_clicked"
            java.lang.String r5 = "yes"
            java.lang.String r7 = ""
            java.lang.String r10 = "/Automatic_Payment_create_confirmation_Intent"
            java.lang.String r11 = ""
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.h(net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        r0 = r0.getDebitBank();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void j(net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity r12) {
        /*
            net.one97.paytm.upi.mandate.utils.k r0 = r12.f67082e
            if (r0 != 0) goto L_0x0009
            java.lang.String r1 = "mandateSource"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0009:
            net.one97.paytm.upi.mandate.utils.k r1 = net.one97.paytm.upi.mandate.utils.k.COLLECT
            if (r0 != r1) goto L_0x0051
            r2 = r12
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.upi.mandate.confirmation.c r0 = r12.f67081d
            if (r0 != 0) goto L_0x0019
            java.lang.String r1 = "mandateConfirmationViewModel"
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0019:
            net.one97.paytm.upi.common.upi.UpiProfileDefaultBank r0 = r0.f67097b
            if (r0 == 0) goto L_0x0028
            net.one97.paytm.upi.common.upi.BankAccountDetails$BankAccount r0 = r0.getDebitBank()
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = r0.getBankName()
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            r5 = r0
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r0 = r12.f67080c
            java.lang.String r1 = "mandateConfirmationUiModel"
            if (r0 != 0) goto L_0x0033
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x0033:
            java.lang.String r6 = r0.getRecurrencePattern()
            net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel r12 = r12.f67080c
            if (r12 != 0) goto L_0x003e
            kotlin.g.b.k.a((java.lang.String) r1)
        L_0x003e:
            java.lang.String r9 = r12.getAmount()
            java.lang.String r3 = "/Automatic_Payment_Collect_Creation"
            java.lang.String r4 = "TnC_clicked"
            java.lang.String r7 = ""
            java.lang.String r8 = ""
            java.lang.String r10 = "/Automatic_Payment_create_confirmation"
            java.lang.String r11 = ""
            net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
        L_0x0051:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity.j(net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity):void");
    }
}
