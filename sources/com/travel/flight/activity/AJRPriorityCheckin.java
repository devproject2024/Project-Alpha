package com.travel.flight.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.travel.flight.R;
import com.travel.flight.utils.i;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;
import net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse;

public final class AJRPriorityCheckin extends PaytmActivity {
    private static final String AIRLINE_CODE = AIRLINE_CODE;
    public static final a Companion = new a((byte) 0);
    private static final String DEEPLINK_PRIME = DEEPLINK_PRIME;
    private static final String EVEN_PAGE_LOAD = EVEN_PAGE_LOAD;
    private static final String GA_ACTION_FIRST_CLICKED = GA_ACTION_FIRST_CLICKED;
    private static final String GA_ACTION_FIRST_INTENT = GA_ACTION_FIRST_INTENT;
    private static final String GA_FLIGHT_SCREEN_FLIGHT_CHECKIN_CATEGORY = GA_FLIGHT_SCREEN_FLIGHT_CHECKIN_CATEGORY;
    private static final String GA_STATUS_FAILURE_OTHER = GA_STATUS_FAILURE_OTHER;
    private static final String GA_STATUS_SUCCESS_OTHER = GA_STATUS_SUCCESS_OTHER;
    private static final String GA_STATUS_SUCCESS_PAYTMFIRST = GA_STATUS_SUCCESS_PAYTMFIRST;
    private static final String GTM_FLIGHT_SCREEN_FLIGHT_CHECKIN = GTM_FLIGHT_SCREEN_FLIGHT_CHECKIN;
    private static final String KEY_IS_PAYTM_PRIME_USER = KEY_IS_PAYTM_PRIME_USER;
    private final kotlin.g airlineCode$delegate = getIntentData(AIRLINE_CODE);
    private final kotlin.g backButton$delegate = bind(this, R.id.prioritychecking_filter_close);
    private final kotlin.g button$delegate = bind(this, R.id.join_paytmPrime);
    private com.travel.flight.h.a model;
    private final kotlin.g progress$delegate = bind(this, R.id.progress);
    private final kotlin.g progressparent$delegate = bind(this, R.id.progressparent);

    private final ImageView getBackButton() {
        return (ImageView) this.backButton$delegate.getValue();
    }

    private final Button getButton() {
        return (Button) this.button$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LottieAnimationView getProgress() {
        return (LottieAnimationView) this.progress$delegate.getValue();
    }

    private final RelativeLayout getProgressparent() {
        return (RelativeLayout) this.progressparent$delegate.getValue();
    }

    public final String getAirlineCode() {
        return (String) this.airlineCode$delegate.getValue();
    }

    static final class d<T> implements z<net.one97.paytmflight.common.entity.prioritycheckinentity.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRPriorityCheckin f23505a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.travel.flight.b.e f23506b;

        d(AJRPriorityCheckin aJRPriorityCheckin, com.travel.flight.b.e eVar) {
            this.f23505a = aJRPriorityCheckin;
            this.f23506b = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f23506b.a((net.one97.paytmflight.common.entity.prioritycheckinentity.a) obj);
            this.f23506b.executePendingBindings();
            AJRPriorityCheckin aJRPriorityCheckin = this.f23505a;
            aJRPriorityCheckin.showLoading(aJRPriorityCheckin.getProgress(), false);
        }
    }

    static final class e<T> implements z<NetworkCustomError> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRPriorityCheckin f23507a;

        e(AJRPriorityCheckin aJRPriorityCheckin) {
            this.f23507a = aJRPriorityCheckin;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            NetworkCustomError networkCustomError = (NetworkCustomError) obj;
            AJRPriorityCheckin aJRPriorityCheckin = this.f23507a;
            aJRPriorityCheckin.showLoading(aJRPriorityCheckin.getProgress(), false);
            if (networkCustomError != null) {
                this.f23507a.showErrorDialog(networkCustomError);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding a2 = androidx.databinding.f.a(this, R.layout.activity_priority_checkin);
        k.a((Object) a2, "DataBindingUtil.setConte…ctivity_priority_checkin)");
        com.travel.flight.b.e eVar = (com.travel.flight.b.e) a2;
        ai a3 = am.a((FragmentActivity) this).a(com.travel.flight.h.a.class);
        k.a((Object) a3, "ViewModelProviders.of(th…kinViewModel::class.java)");
        this.model = (com.travel.flight.h.a) a3;
        com.travel.flight.h.a aVar = this.model;
        if (aVar == null) {
            k.a("model");
        }
        q qVar = this;
        aVar.f25407a.observe(qVar, new d(this, eVar));
        com.travel.flight.h.a aVar2 = this.model;
        if (aVar2 == null) {
            k.a("model");
        }
        aVar2.f25409c.observe(qVar, new e(this));
        getUserDetail();
        getButton().setOnClickListener(new f(this));
        getBackButton().setOnClickListener(new g(this));
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRPriorityCheckin f23508a;

        f(AJRPriorityCheckin aJRPriorityCheckin) {
            this.f23508a = aJRPriorityCheckin;
        }

        public final void onClick(View view) {
            this.f23508a.openPrimeDeeplink();
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRPriorityCheckin f23509a;

        g(AJRPriorityCheckin aJRPriorityCheckin) {
            this.f23509a = aJRPriorityCheckin;
        }

        public final void onClick(View view) {
            this.f23509a.finish();
        }
    }

    private final void getUserDetail() {
        if (com.travel.flight.flightorder.i.a.a(getApplicationContext()) == null) {
            showLogin(this);
        } else if (!isPrime()) {
            showLoading(getProgress(), true);
            isUserEligibleFromServer();
        } else {
            com.travel.flight.h.a aVar = this.model;
            if (aVar == null) {
                k.a("model");
            }
            aVar.a(true);
        }
    }

    public final void showErrorDialog(NetworkCustomError networkCustomError) {
        k.c(networkCustomError, "errorresponse");
        try {
            if (networkCustomError.getStatusCode() != 401) {
                if (networkCustomError.getStatusCode() != 410) {
                    if (networkCustomError.getMessage() != null && !net.one97.paytmflight.a.b.a((Context) this, (Exception) networkCustomError, "error.flights@paytm.com")) {
                        if (networkCustomError.getErrorType() == NetworkCustomError.ErrorType.ParsingError) {
                            com.paytm.utility.b.d((Context) this, networkCustomError.getUrl(), String.valueOf(networkCustomError.getStatusCode()));
                            return;
                        }
                        String string = getResources().getString(R.string.flight_network_error_message);
                        k.a((Object) string, "resources.getString(\n   …ht_network_error_message)");
                        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), string);
                        return;
                    }
                    return;
                }
            }
            net.one97.paytmflight.a.b.a(this, networkCustomError);
        } catch (Exception e2) {
            com.paytm.utility.q.b(e2.getMessage());
        }
    }

    public final void attachBaseContext(Context context) {
        k.c(context, "newBase");
        com.travel.utils.q.a(context);
        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
        super.attachBaseContext(com.travel.flight.b.b().d(context));
        com.travel.utils.q.c(context);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 233 && i3 == -1) {
            isUserEligibleFromServer();
        }
    }

    public final boolean isPrime() {
        i.a aVar = i.f25591a;
        Context applicationContext = getApplicationContext();
        k.a((Object) applicationContext, "this.applicationContext");
        return i.a.a(applicationContext).b(KEY_IS_PAYTM_PRIME_USER, false, true);
    }

    /* access modifiers changed from: private */
    public final void openPrimeDeeplink() {
        if (getProgressparent().getVisibility() == 8) {
            k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
            com.travel.flight.b.b().a(getApplicationContext(), DEEPLINK_PRIME);
        }
    }

    static final class b extends l implements kotlin.g.a.a<T> {
        final /* synthetic */ int $res;
        final /* synthetic */ Activity $this_bind;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Activity activity, int i2) {
            super(0);
            this.$this_bind = activity;
            this.$res = i2;
        }

        public final T invoke() {
            T findViewById = this.$this_bind.findViewById(this.$res);
            if (findViewById != null) {
                return findViewById;
            }
            throw new u("null cannot be cast to non-null type T");
        }
    }

    public final <T extends View> kotlin.g<T> bind(Activity activity, int i2) {
        k.c(activity, "$this$bind");
        return kotlin.h.a(kotlin.l.NONE, new b(activity, i2));
    }

    static final class c extends l implements kotlin.g.a.a<T> {
        final /* synthetic */ String $key;
        final /* synthetic */ AJRPriorityCheckin this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AJRPriorityCheckin aJRPriorityCheckin, String str) {
            super(0);
            this.this$0 = aJRPriorityCheckin;
            this.$key = str;
        }

        public final T invoke() {
            T stringExtra = this.this$0.getIntent().getStringExtra(this.$key);
            if (stringExtra != null) {
                return stringExtra;
            }
            throw new u("null cannot be cast to non-null type T");
        }
    }

    public final <T extends String> kotlin.g<T> getIntentData(String str) {
        k.c(str, "key");
        return kotlin.h.a(kotlin.l.NONE, new c(this, str));
    }

    public final void getPriorityCheckinIntentData() {
        com.travel.flight.h.a aVar = this.model;
        if (aVar == null) {
            k.a("model");
        }
        String airlineCode = getAirlineCode();
        k.c(airlineCode, "airlineCode");
        com.travel.flight.g.a aVar2 = aVar.f25408b;
        k.c(airlineCode, "airlineCode");
        com.travel.flight.b.a();
        String R = com.travel.flight.b.b().R();
        k.a((Object) R, "FlightController.getInst….getPriorityCheckingURL()");
        if (URLUtil.isValidUrl(R)) {
            if (R != null) {
                R = Uri.parse(R).buildUpon().appendQueryParameter(AIRLINE_CODE, airlineCode).build().toString();
                k.a((Object) R, "uriBuilder.build().toString()");
            }
            HashMap hashMap = new HashMap();
            hashMap.put("Content-Type", "application/json");
            com.travel.flight.b.a();
            hashMap.put(AppConstants.SSO_TOKEN, com.travel.flight.b.b().a(aVar2.f25404a));
            if (R != null) {
                com.paytm.network.a l = new com.paytm.network.b().a(aVar2.f25404a).a(a.b.SILENT).c(com.travel.flight.g.a.f25402b).a(a.c.FLIGHT).a(a.C0715a.GET).a(R).a((Map<String, String>) hashMap).a((IJRPaytmDataModel) new IJRPriorityCheckinResponse((String) null, (IJRPriorityCheckinResponse.Status) null, (IJRPriorityCheckinResponse.Body) null, (Integer) null, (IJRPriorityCheckinResponse.Meta) null, 31, (kotlin.g.b.g) null)).a((com.paytm.network.listener.b) aVar2).l();
                k.a((Object) l, "CJRCommonNetworkCallBuil…                 .build()");
                l.a();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void isUserEligibleFromServer() {
        if (com.paytm.utility.b.c((Context) this)) {
            getPriorityCheckinIntentData();
        } else {
            showApiNetworkDialog();
        }
    }

    private final void showApiNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.no_connection));
        builder.setMessage(getResources().getString(R.string.no_internet));
        builder.setPositiveButton(getResources().getString(R.string.network_retry_yes), new h(this));
        builder.show();
    }

    static final class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRPriorityCheckin f23510a;

        h(AJRPriorityCheckin aJRPriorityCheckin) {
            this.f23510a = aJRPriorityCheckin;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.cancel();
            this.f23510a.isUserEligibleFromServer();
        }
    }

    private final void showLogin(Context context) {
        Intent intent = new Intent();
        intent.putExtra("VERTICAL_NAME", "Flights");
        k.a((Object) com.travel.flight.b.a(), "FlightController.getInstance()");
        com.travel.flight.b.b().a(context, intent, (int) UpiPushView.REQUEST_CODE_UPI_CHECK_BALANCE);
    }

    public final void showLoading(LottieAnimationView lottieAnimationView, boolean z) {
        if (z) {
            try {
                net.one97.paytm.common.widgets.a.a(lottieAnimationView);
            } catch (Exception e2) {
                com.paytm.utility.q.b(e2.getMessage());
            }
        } else {
            net.one97.paytm.common.widgets.a.b(lottieAnimationView);
            getProgressparent().setVisibility(8);
        }
    }
}
