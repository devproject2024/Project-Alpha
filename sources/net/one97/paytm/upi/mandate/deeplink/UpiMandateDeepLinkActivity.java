package net.one97.paytm.upi.mandate.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.paytm.utility.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.deeplink.DummyDeepLinkActivity;
import net.one97.paytm.upi.deeplink.model.ExtraIntentParams;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity;
import net.one97.paytm.upi.mandate.d.a;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GAConstants;

public final class UpiMandateDeepLinkActivity extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private final int f67155a = 3;

    /* renamed from: b  reason: collision with root package name */
    private Uri f67156b;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_deeplink);
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            this.f67156b = intent.getData();
        }
        a();
    }

    private final void a() {
        MandateConfirmationUiModel mandateConfirmationUiModel;
        String str;
        UpiMandateDeepLinkActivity upiMandateDeepLinkActivity = this;
        Uri uri = upiMandateDeepLinkActivity.f67156b;
        if (uri != null) {
            String queryParameter = uri.getQueryParameter("pa");
            String queryParameter2 = uri.getQueryParameter("pn");
            String queryParameter3 = uri.getQueryParameter("am");
            String queryParameter4 = uri.getQueryParameter("validitystart");
            String queryParameter5 = uri.getQueryParameter("validityend");
            String queryParameter6 = uri.getQueryParameter("tn");
            String queryParameter7 = uri.getQueryParameter("mn");
            String queryParameter8 = uri.getQueryParameter("amrule");
            String queryParameter9 = uri.getQueryParameter("recur");
            String queryParameter10 = uri.getQueryParameter("recurvalue");
            String str2 = queryParameter10 == null ? "" : queryParameter10;
            String queryParameter11 = uri.getQueryParameter("recurtype");
            if (queryParameter11 == null) {
                str = "";
            } else {
                str = queryParameter11;
            }
            String queryParameter12 = uri.getQueryParameter("tr");
            String queryParameter13 = uri.getQueryParameter("mc");
            String str3 = "";
            String str4 = str;
            String str5 = str2;
            ExtraIntentParams extraIntentParams = new ExtraIntentParams(uri.getQueryParameter("mam"), uri.getQueryParameter("query"), uri.getQueryParameter("QRexpire"), uri.getQueryParameter("QRts"));
            String queryParameter14 = uri.getQueryParameter("url");
            String queryParameter15 = uri.getQueryParameter("purpose");
            if (queryParameter15 == null) {
                queryParameter15 = str3;
            }
            MandateConfirmationUiModel mandateConfirmationUiModel2 = r2;
            MandateConfirmationUiModel mandateConfirmationUiModel3 = new MandateConfirmationUiModel(queryParameter, queryParameter2, queryParameter3, queryParameter4, queryParameter5, queryParameter7, queryParameter6, queryParameter8, queryParameter9, str5, str4, queryParameter12, queryParameter13, queryParameter14, queryParameter15, (String) null, (String) null, extraIntentParams, 98304, (g) null);
            upiMandateDeepLinkActivity = this;
            MandateConfirmationUiModel mandateConfirmationUiModel4 = mandateConfirmationUiModel2;
            upiMandateDeepLinkActivity.a(mandateConfirmationUiModel4);
            mandateConfirmationUiModel = mandateConfirmationUiModel4;
        } else {
            mandateConfirmationUiModel = null;
        }
        if (b.r(getApplicationContext())) {
            Uri uri2 = upiMandateDeepLinkActivity.f67156b;
            if (uri2 == null || !p.a((CharSequence) String.valueOf(uri2), (CharSequence) "upi://mandate", false)) {
                Uri uri3 = upiMandateDeepLinkActivity.f67156b;
                if (uri3 != null) {
                    p.a((CharSequence) String.valueOf(uri3), (CharSequence) "upi://collect", false);
                    return;
                }
                return;
            }
            if (mandateConfirmationUiModel == null) {
                k.a();
            }
            upiMandateDeepLinkActivity.b(mandateConfirmationUiModel);
            return;
        }
        c();
    }

    private final void a(MandateConfirmationUiModel mandateConfirmationUiModel) {
        Context context = this;
        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_INTENT, Events.Action.DEEPLINK_OPENED, "QR_scan", String.valueOf(b.r(context)), "", mandateConfirmationUiModel.getPayeeVpa(), mandateConfirmationUiModel.getAmount(), "", "");
    }

    private final void b(MandateConfirmationUiModel mandateConfirmationUiModel) {
        b();
        MandateConfirmationDetailActivity.a aVar = MandateConfirmationDetailActivity.f67078a;
        MandateConfirmationDetailActivity.a.a(new a.C1354a(this, mandateConfirmationUiModel, true), net.one97.paytm.upi.mandate.utils.k.INTENT);
        finish();
    }

    private final void b() {
        Intent intent = new Intent(this, DummyDeepLinkActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    private final void c() {
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().a(this.f67155a, (Context) this);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != this.f67155a) {
            return;
        }
        if (i3 == -1) {
            a();
        } else {
            finish();
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
