package net.one97.paytm.upi.deeplink;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.j;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.l;
import kotlin.m.p;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.deeplink.b;
import net.one97.paytm.upi.deeplink.model.ExtraIntentParams;
import net.one97.paytm.upi.deeplink.model.MandateConfirmationUiModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity;
import net.one97.paytm.upi.mandate.d.a;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class UPIQRScanDeeplinkActivity extends PaytmActivity implements b.a {

    /* renamed from: a  reason: collision with root package name */
    private final int f66676a = 3;

    /* renamed from: b  reason: collision with root package name */
    private Uri f66677b;

    /* renamed from: c  reason: collision with root package name */
    private int f66678c;

    public final void a(UpiAvailabilityModel.UpiAvailabilityResponse upiAvailabilityResponse) {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_deeplink);
        if (getIntent() != null) {
            Intent intent = getIntent();
            k.a((Object) intent, "intent");
            this.f66677b = intent.getData();
            this.f66678c = getIntent().getIntExtra(UpiConstants.UPI_SOURCE, 0);
        }
        b();
        getApplicationContext();
        getApplicationContext();
        String str = null;
        net.one97.paytm.upi.registration.b.a.b a2 = g.a(g.a((a.C1347a) null));
        ArrayList arrayList = new ArrayList();
        arrayList.add("Qr_scan");
        StringBuilder sb = new StringBuilder();
        k.a((Object) a2, "upi");
        sb.append(a2.e());
        arrayList.add(sb.toString());
        arrayList.add(String.valueOf(this.f66677b));
        Context applicationContext = getApplicationContext();
        String valueOf = String.valueOf(a2.e());
        String valueOf2 = String.valueOf(this.f66677b);
        Uri uri = this.f66677b;
        String queryParameter = uri != null ? uri.getQueryParameter("pa") : null;
        Uri uri2 = this.f66677b;
        if (uri2 != null) {
            str = uri2.getQueryParameter("am");
        }
        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(applicationContext, Events.Category.INTENT, Events.Action.DEEPLINK_OPENED, "upi_intent_link", valueOf, valueOf2, queryParameter, str, "none", "");
    }

    private final void b() {
        MandateConfirmationUiModel mandateConfirmationUiModel;
        boolean z;
        String str;
        MandateConfirmationUiModel mandateConfirmationUiModel2;
        UPIQRScanDeeplinkActivity uPIQRScanDeeplinkActivity = this;
        Uri uri = uPIQRScanDeeplinkActivity.f66677b;
        if (uri != null) {
            if (uri == null) {
                k.a();
            }
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
            String str4 = str2;
            ExtraIntentParams extraIntentParams = new ExtraIntentParams(uri.getQueryParameter("mam"), uri.getQueryParameter("query"), uri.getQueryParameter("QRexpire"), uri.getQueryParameter("QRts"));
            String queryParameter14 = uri.getQueryParameter("url");
            String queryParameter15 = uri.getQueryParameter("purpose");
            if (queryParameter15 == null) {
                queryParameter15 = str3;
            }
            String str5 = str3;
            MandateConfirmationUiModel mandateConfirmationUiModel3 = r3;
            MandateConfirmationUiModel mandateConfirmationUiModel4 = new MandateConfirmationUiModel(queryParameter, queryParameter2, queryParameter3, queryParameter4, queryParameter5, queryParameter7, queryParameter6, queryParameter8, queryParameter9, str4, str, queryParameter12, queryParameter13, queryParameter14, queryParameter15, (String) null, (String) null, extraIntentParams, 98304, (kotlin.g.b.g) null);
            CharSequence comment = mandateConfirmationUiModel3.getComment();
            if (!(comment == null || comment.length() == 0)) {
                l lVar = new l("[^.A-Za-z0-9 ]");
                String comment2 = mandateConfirmationUiModel3.getComment();
                if (comment2 == null) {
                    k.a();
                }
                String replace = lVar.replace((CharSequence) comment2, str5);
                mandateConfirmationUiModel2 = mandateConfirmationUiModel3;
                mandateConfirmationUiModel2.setComment(replace);
            } else {
                mandateConfirmationUiModel2 = mandateConfirmationUiModel3;
            }
            uPIQRScanDeeplinkActivity = this;
            uPIQRScanDeeplinkActivity.b(mandateConfirmationUiModel2);
            mandateConfirmationUiModel = mandateConfirmationUiModel2;
        } else {
            mandateConfirmationUiModel = null;
        }
        if (com.paytm.utility.b.r(getApplicationContext())) {
            Uri uri2 = uPIQRScanDeeplinkActivity.f66677b;
            if (uri2 != null) {
                z = false;
                if (p.a((CharSequence) String.valueOf(uri2), (CharSequence) "upi://collect", false)) {
                    return;
                }
            } else {
                z = false;
            }
            Uri uri3 = uPIQRScanDeeplinkActivity.f66677b;
            if (uri3 != null && p.a((CharSequence) String.valueOf(uri3), (CharSequence) "upi://mandate", z)) {
                UpiGTMLoader instance = UpiGTMLoader.getInstance();
                k.a((Object) instance, "UpiGTMLoader.getInstance()");
                Boolean isRecurringMandateEnabled = instance.isRecurringMandateEnabled();
                k.a((Object) isRecurringMandateEnabled, "UpiGTMLoader.getInstance…isRecurringMandateEnabled");
                if (isRecurringMandateEnabled.booleanValue()) {
                    if (uPIQRScanDeeplinkActivity.f66677b == null) {
                        k.a();
                    }
                    if (mandateConfirmationUiModel == null) {
                        k.a();
                    }
                    uPIQRScanDeeplinkActivity.a(mandateConfirmationUiModel);
                    return;
                }
            }
            e();
            return;
        }
        d();
    }

    private final void a(MandateConfirmationUiModel mandateConfirmationUiModel) {
        b(mandateConfirmationUiModel);
        c();
        MandateConfirmationDetailActivity.a aVar = MandateConfirmationDetailActivity.f67078a;
        MandateConfirmationDetailActivity.a.a(new a.C1354a(this, mandateConfirmationUiModel, true), net.one97.paytm.upi.mandate.utils.k.INTENT);
        finish();
    }

    private final void b(MandateConfirmationUiModel mandateConfirmationUiModel) {
        Context context = this;
        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(context, GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENT_INTENT, Events.Action.DEEPLINK_OPENED, "QR_scan", String.valueOf(com.paytm.utility.b.r(context)), "", mandateConfirmationUiModel.getPayeeVpa(), mandateConfirmationUiModel.getAmount(), "", "");
    }

    private final void c() {
        Intent intent = new Intent(this, DummyDeepLinkActivity.class);
        intent.setFlags(268468224);
        startActivity(intent);
    }

    private final void d() {
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().a(this.f66676a, (Context) this);
    }

    private final void e() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(UpiConstants.EXTRA_VPA_DATA, this.f66677b);
        bundle.putBoolean(UpiConstants.IS_FROM_SCAN, getIntent().getBooleanExtra(UpiConstants.IS_FROM_SCAN, false));
        bundle.putBoolean(UpiConstants.IS_GALLERY_SCAN, getIntent().getBooleanExtra(UpiConstants.IS_GALLERY_SCAN, false));
        bundle.putLong(UpiConstants.EVENT_START_TIME, getIntent().getLongExtra(UpiConstants.EVENT_START_TIME, -1));
        bundle.putLong(UpiConstants.EVENT_SCAN_TIME, getIntent().getLongExtra(UpiConstants.EVENT_SCAN_TIME, -1));
        bundle.putBoolean(UpiConstants.IS_MID_SCAN, getIntent().getBooleanExtra(UpiConstants.IS_MID_SCAN, false));
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().a((Context) this, bundle);
        finish();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != this.f66676a) {
            return;
        }
        if (i3 == -1) {
            b();
        } else {
            finish();
        }
    }

    public final void a() {
        j supportFragmentManager = getSupportFragmentManager();
        if (supportFragmentManager != null) {
            supportFragmentManager.e();
        }
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().b((Context) this);
    }

    public final void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
