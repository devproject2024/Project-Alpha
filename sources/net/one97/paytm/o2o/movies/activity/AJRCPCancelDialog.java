package net.one97.paytm.o2o.movies.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.business.merchant_payments.utility.StringUtility;
import com.google.gson.o;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRCPCancelRes;
import net.one97.paytm.o2o.movies.common.movies.orders.CJRPreclaimRes;
import org.json.JSONObject;

public final class AJRCPCancelDialog extends AppBaseActivity implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f73900a = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    private static final String f73901c = "javaClass";

    /* renamed from: b  reason: collision with root package name */
    private boolean f73902b;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f73903d;

    private View a(int i2) {
        if (this.f73903d == null) {
            this.f73903d = new HashMap();
        }
        View view = (View) this.f73903d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f73903d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onBackPressed() {
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_dialog_cp_cancel);
        ((ImageView) a(R.id.btn_close)).setOnClickListener(new d(this));
        ((RoboTextView) a(R.id.btn_dont_cancel)).setOnClickListener(new e(this));
        a();
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCPCancelDialog f73904a;

        d(AJRCPCancelDialog aJRCPCancelDialog) {
            this.f73904a = aJRCPCancelDialog;
        }

        public final void onClick(View view) {
            AJRCPCancelDialog.a(this.f73904a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRCPCancelDialog f73905a;

        e(AJRCPCancelDialog aJRCPCancelDialog) {
            this.f73905a = aJRCPCancelDialog;
        }

        public final void onClick(View view) {
            AJRCPCancelDialog.a(this.f73905a);
        }
    }

    /* access modifiers changed from: private */
    public final void a() {
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.layout_error);
            kotlin.g.b.k.a((Object) constraintLayout, "layout_error");
            net.one97.paytm.o2o.movies.common.a.e.a(constraintLayout, false);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.layout_cancel);
            kotlin.g.b.k.a((Object) constraintLayout2, "layout_cancel");
            net.one97.paytm.o2o.movies.common.a.e.b(constraintLayout2, true);
            ProgressBar progressBar = (ProgressBar) a(R.id.loader);
            kotlin.g.b.k.a((Object) progressBar, "loader");
            net.one97.paytm.o2o.movies.common.a.e.a(progressBar, true);
            kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            String e2 = net.one97.paytm.o2o.movies.common.b.c.e();
            Map hashMap = new HashMap();
            String stringExtra = getIntent().getStringExtra("ORDER_ID");
            kotlin.g.b.k.a((Object) stringExtra, "intent.getStringExtra(ORDER_ID)");
            hashMap.put("order_id", stringExtra);
            String c2 = com.paytm.utility.b.c(context, com.paytm.utility.b.a(e2, (Map<String, String>) hashMap));
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = context;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.GET;
            cVar.f42880d = c2;
            cVar.f42881e = null;
            cVar.f42885i = new CJRPreclaimRes();
            cVar.j = this;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.l().a();
            return;
        }
        String string = getString(R.string.network_error_message);
        kotlin.g.b.k.a((Object) string, "getString(R.string.network_error_message)");
        a(this, string, (kotlin.g.a.a) new g(this));
    }

    static final class g extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ AJRCPCancelDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(AJRCPCancelDialog aJRCPCancelDialog) {
            super(0);
            this.this$0 = aJRCPCancelDialog;
        }

        public final void invoke() {
            this.this$0.a();
        }
    }

    static final class f extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ String $refundAmount;
        final /* synthetic */ AJRCPCancelDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AJRCPCancelDialog aJRCPCancelDialog, String str) {
            super(0);
            this.this$0 = aJRCPCancelDialog;
            this.$refundAmount = str;
        }

        public final void invoke() {
            AJRCPCancelDialog.a(this.this$0, this.$refundAmount);
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        byte[] bArr;
        if (networkCustomError == null || (str = networkCustomError.getAlertMessage()) == null) {
            str = getString(R.string.something_wrong_try_again);
            kotlin.g.b.k.a((Object) str, "getString(R.string.something_wrong_try_again)");
        }
        if (networkCustomError != null) {
            try {
                NetworkResponse networkResponse = networkCustomError.networkResponse;
                if (!(networkResponse == null || (bArr = networkResponse.data) == null)) {
                    String string = new JSONObject(new String(bArr, kotlin.m.d.f47971a)).getString("error");
                    String string2 = TextUtils.isEmpty(string) ? new JSONObject(new String(bArr, kotlin.m.d.f47971a)).getString("message") : string;
                    if (string2 != null && !TextUtils.isEmpty(string2)) {
                        str = string2;
                    }
                }
            } catch (Exception unused) {
            }
        }
        if (iJRPaytmDataModel instanceof CJRPreclaimRes) {
            a(this, str, (kotlin.g.a.a) new b(this));
        } else if (iJRPaytmDataModel instanceof CJRCPCancelRes) {
            a(str, (kotlin.g.a.a<x>) new c(this), "Close");
        }
    }

    static final class b extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ AJRCPCancelDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(AJRCPCancelDialog aJRCPCancelDialog) {
            super(0);
            this.this$0 = aJRCPCancelDialog;
        }

        public final void invoke() {
            this.this$0.a();
        }
    }

    static final class c extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ AJRCPCancelDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AJRCPCancelDialog aJRCPCancelDialog) {
            super(0);
            this.this$0 = aJRCPCancelDialog;
        }

        public final void invoke() {
            AJRCPCancelDialog.a(this.this$0);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRPreclaimRes) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.layout_error);
            kotlin.g.b.k.a((Object) constraintLayout, "layout_error");
            net.one97.paytm.o2o.movies.common.a.e.a(constraintLayout, false);
            ProgressBar progressBar = (ProgressBar) a(R.id.loader);
            kotlin.g.b.k.a((Object) progressBar, "loader");
            net.one97.paytm.o2o.movies.common.a.e.a(progressBar, false);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.layout_cancel);
            kotlin.g.b.k.a((Object) constraintLayout2, "layout_cancel");
            net.one97.paytm.o2o.movies.common.a.e.b(constraintLayout2, false);
            RoboTextView roboTextView = (RoboTextView) a(R.id.txt_message);
            kotlin.g.b.k.a((Object) roboTextView, "txt_message");
            CJRPreclaimRes cJRPreclaimRes = (CJRPreclaimRes) iJRPaytmDataModel;
            roboTextView.setText(cJRPreclaimRes.getMessage());
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.txt_disclaimer);
            kotlin.g.b.k.a((Object) roboTextView2, "txt_disclaimer");
            roboTextView2.setText(cJRPreclaimRes.getDisclaimer());
            String totalRefundAmount = cJRPreclaimRes.getTotalRefundAmount();
            if (totalRefundAmount != null) {
                ((CardView) a(R.id.btn_cancel_ticket)).setOnClickListener(new h(totalRefundAmount, this));
            }
        } else if (iJRPaytmDataModel instanceof CJRCPCancelRes) {
            CJRCPCancelRes cJRCPCancelRes = (CJRCPCancelRes) iJRPaytmDataModel;
            Integer cancellationStatus = cJRCPCancelRes.getCancellationStatus();
            if (cancellationStatus != null && cancellationStatus.intValue() == 3) {
                ConstraintLayout constraintLayout3 = (ConstraintLayout) a(R.id.layout_error);
                kotlin.g.b.k.a((Object) constraintLayout3, "layout_error");
                net.one97.paytm.o2o.movies.common.a.e.a(constraintLayout3, false);
                ProgressBar progressBar2 = (ProgressBar) a(R.id.loader);
                kotlin.g.b.k.a((Object) progressBar2, "loader");
                net.one97.paytm.o2o.movies.common.a.e.a(progressBar2, false);
                ConstraintLayout constraintLayout4 = (ConstraintLayout) a(R.id.layout_cancel);
                kotlin.g.b.k.a((Object) constraintLayout4, "layout_cancel");
                net.one97.paytm.o2o.movies.common.a.e.b(constraintLayout4, false);
                RoboTextView roboTextView3 = (RoboTextView) a(R.id.txt_title);
                kotlin.g.b.k.a((Object) roboTextView3, "txt_title");
                roboTextView3.setText(getString(R.string.refund_amount_updated));
                RoboTextView roboTextView4 = (RoboTextView) a(R.id.txt_message);
                kotlin.g.b.k.a((Object) roboTextView4, "txt_message");
                roboTextView4.setText(cJRCPCancelRes.getMessage());
                RoboTextView roboTextView5 = (RoboTextView) a(R.id.txt_disclaimer);
                kotlin.g.b.k.a((Object) roboTextView5, "txt_disclaimer");
                roboTextView5.setText("");
                String refundAmount = cJRCPCancelRes.getRefundAmount();
                if (refundAmount != null) {
                    ((CardView) a(R.id.btn_cancel_ticket)).setOnClickListener(new i(refundAmount, this));
                    return;
                }
                return;
            }
            this.f73902b = true;
            String message = cJRCPCancelRes.getMessage();
            if (message != null) {
                a(message, (kotlin.g.a.a<x>) new j(this), "Close");
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f73906a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AJRCPCancelDialog f73907b;

        h(String str, AJRCPCancelDialog aJRCPCancelDialog) {
            this.f73906a = str;
            this.f73907b = aJRCPCancelDialog;
        }

        public final void onClick(View view) {
            AJRCPCancelDialog aJRCPCancelDialog = this.f73907b;
            String str = net.one97.paytm.o2o.movies.common.b.b.L;
            kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GT…IRM_BUTTON_EVENT_CATEGORY");
            AJRCPCancelDialog.b(aJRCPCancelDialog, str);
            AJRCPCancelDialog.a(this.f73907b, this.f73906a);
        }
    }

    static final class i implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f73908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AJRCPCancelDialog f73909b;

        i(String str, AJRCPCancelDialog aJRCPCancelDialog) {
            this.f73908a = str;
            this.f73909b = aJRCPCancelDialog;
        }

        public final void onClick(View view) {
            AJRCPCancelDialog aJRCPCancelDialog = this.f73909b;
            String str = net.one97.paytm.o2o.movies.common.b.b.M;
            kotlin.g.b.k.a((Object) str, "CJRMoviesGTMConstants.GT…TRY_BUTTON_EVENT_CATEGORY");
            AJRCPCancelDialog.b(aJRCPCancelDialog, str);
            AJRCPCancelDialog.a(this.f73909b, this.f73908a);
        }
    }

    static final class j extends l implements kotlin.g.a.a<x> {
        final /* synthetic */ AJRCPCancelDialog this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AJRCPCancelDialog aJRCPCancelDialog) {
            super(0);
            this.this$0 = aJRCPCancelDialog;
        }

        public final void invoke() {
            AJRCPCancelDialog.a(this.this$0);
        }
    }

    private static /* synthetic */ void a(AJRCPCancelDialog aJRCPCancelDialog, String str, kotlin.g.a.a aVar) {
        String string = aJRCPCancelDialog.getString(R.string.btn_retry);
        kotlin.g.b.k.a((Object) string, "getString(R.string.btn_retry)");
        aJRCPCancelDialog.a(str, (kotlin.g.a.a<x>) aVar, string);
    }

    private final void a(String str, kotlin.g.a.a<x> aVar, String str2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.layout_cancel);
        kotlin.g.b.k.a((Object) constraintLayout, "layout_cancel");
        net.one97.paytm.o2o.movies.common.a.e.b(constraintLayout, true);
        ProgressBar progressBar = (ProgressBar) a(R.id.loader);
        kotlin.g.b.k.a((Object) progressBar, "loader");
        net.one97.paytm.o2o.movies.common.a.e.a(progressBar, false);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.layout_error);
        kotlin.g.b.k.a((Object) constraintLayout2, "layout_error");
        net.one97.paytm.o2o.movies.common.a.e.a(constraintLayout2, true);
        RoboTextView roboTextView = (RoboTextView) a(R.id.txt_error);
        kotlin.g.b.k.a((Object) roboTextView, "txt_error");
        roboTextView.setText(p.a(str, "\\n", StringUtility.NEW_LINE, false));
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.txt_retry);
        kotlin.g.b.k.a((Object) roboTextView2, "txt_retry");
        roboTextView2.setText(str2);
        ((LinearLayout) a(R.id.btn_retry)).setOnClickListener(new k(aVar));
    }

    static final class k implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.g.a.a f73910a;

        k(kotlin.g.a.a aVar) {
            this.f73910a = aVar;
        }

        public final void onClick(View view) {
            this.f73910a.invoke();
        }
    }

    public final void onStart() {
        super.onStart();
        getWindow().setLayout(-1, -2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(AJRCPCancelDialog aJRCPCancelDialog) {
        aJRCPCancelDialog.setResult(aJRCPCancelDialog.f73902b ? -1 : 0);
        aJRCPCancelDialog.finish();
    }

    public static final /* synthetic */ void a(AJRCPCancelDialog aJRCPCancelDialog, String str) {
        Context context = aJRCPCancelDialog;
        if (com.paytm.utility.b.c(context)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) aJRCPCancelDialog.a(R.id.layout_error);
            kotlin.g.b.k.a((Object) constraintLayout, "layout_error");
            net.one97.paytm.o2o.movies.common.a.e.a(constraintLayout, false);
            ConstraintLayout constraintLayout2 = (ConstraintLayout) aJRCPCancelDialog.a(R.id.layout_cancel);
            kotlin.g.b.k.a((Object) constraintLayout2, "layout_cancel");
            net.one97.paytm.o2o.movies.common.a.e.b(constraintLayout2, true);
            ProgressBar progressBar = (ProgressBar) aJRCPCancelDialog.a(R.id.loader);
            kotlin.g.b.k.a((Object) progressBar, "loader");
            net.one97.paytm.o2o.movies.common.a.e.a(progressBar, true);
            kotlin.g.b.k.a((Object) net.one97.paytm.o2o.movies.common.b.c.a(), "MoviesGTMLoader.getInstance()");
            String a2 = net.one97.paytm.o2o.movies.common.b.c.a("moviesCancelInsuranceV2", (String) null);
            if (TextUtils.isEmpty(a2)) {
                a2 = "https://apiproxy.paytm.com/v2/movies/cancel-ticket";
            }
            o oVar = new o();
            oVar.a("ticket_key", aJRCPCancelDialog.getIntent().getStringExtra("ENCRYPTED_ORDER_ID"));
            oVar.a("refund_amount", str);
            String c2 = com.paytm.utility.b.c(context, a2);
            net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
            cVar.f42877a = context;
            cVar.f42878b = a.c.MOVIES;
            cVar.f42879c = a.C0715a.POST;
            cVar.f42880d = c2;
            cVar.f42881e = null;
            cVar.f42885i = new CJRCPCancelRes();
            cVar.f42884h = oVar.toString();
            cVar.j = aJRCPCancelDialog;
            cVar.n = a.b.USER_FACING;
            cVar.o = "movies";
            cVar.l().a();
            return;
        }
        String string = aJRCPCancelDialog.getString(R.string.network_error_message);
        kotlin.g.b.k.a((Object) string, "getString(R.string.network_error_message)");
        a(aJRCPCancelDialog, string, (kotlin.g.a.a) new f(aJRCPCancelDialog, str));
    }

    public static final /* synthetic */ void b(AJRCPCancelDialog aJRCPCancelDialog, String str) {
        try {
            HashMap hashMap = new HashMap();
            String stringExtra = aJRCPCancelDialog.getIntent().getStringExtra("CITY_NAME");
            String str2 = "";
            if (stringExtra == null) {
                stringExtra = str2;
            }
            String stringExtra2 = aJRCPCancelDialog.getIntent().getStringExtra("MOVIE_TITLE");
            if (stringExtra2 == null) {
                stringExtra2 = str2;
            }
            String stringExtra3 = aJRCPCancelDialog.getIntent().getStringExtra("CINEMA_NAME");
            if (stringExtra3 != null) {
                str2 = stringExtra3;
            }
            String str3 = stringExtra + ", " + stringExtra2 + ", " + str2;
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/summary");
            String str4 = net.one97.paytm.o2o.movies.common.b.b.f75007b;
            kotlin.g.b.k.a((Object) str4, "CJRMoviesGTMConstants.GTM_KEY_EVENT_CATEGORY");
            hashMap.put(str4, str);
            String str5 = net.one97.paytm.o2o.movies.common.b.b.f75008c;
            kotlin.g.b.k.a((Object) str5, "CJRMoviesGTMConstants.GTM_KEY_EVENT_ACTION");
            String str6 = net.one97.paytm.o2o.movies.common.b.b.N;
            kotlin.g.b.k.a((Object) str6, "CJRMoviesGTMConstants\n  …MOVIE_CANCEL_EVENT_ACTION");
            hashMap.put(str5, str6);
            String str7 = net.one97.paytm.o2o.movies.common.b.b.p;
            kotlin.g.b.k.a((Object) str7, "CJRMoviesGTMConstants.GTM_KEY_VERTICAL_NAME");
            String str8 = net.one97.paytm.o2o.movies.common.b.b.r;
            kotlin.g.b.k.a((Object) str8, "CJRMoviesGTMConstants\n  … .GTM_VALUE_VERTICAL_NAME");
            hashMap.put(str7, str8);
            String str9 = net.one97.paytm.o2o.movies.common.b.b.f75009d;
            kotlin.g.b.k.a((Object) str9, "CJRMoviesGTMConstants.GTM_KEY_EVENT_LABEL");
            hashMap.put(str9, str3);
            net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.sendCustomEventWithMap(net.one97.paytm.o2o.movies.common.b.b.f75006a, hashMap, aJRCPCancelDialog);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    public static final void a(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, String str5) {
        kotlin.g.b.k.c(appCompatActivity, "activity");
        kotlin.g.b.k.c(str, "orderId");
        kotlin.g.b.k.c(str2, "encryptedOrderId");
        kotlin.g.b.k.c(str3, "cityName");
        kotlin.g.b.k.c(str4, "movieTitle");
        kotlin.g.b.k.c(str5, "cinemaName");
        Intent intent = new Intent(appCompatActivity, AJRCPCancelDialog.class);
        intent.putExtra("ORDER_ID", str);
        intent.putExtra("ENCRYPTED_ORDER_ID", str2);
        intent.putExtra("CITY_NAME", str3);
        intent.putExtra("MOVIE_TITLE", str4);
        intent.putExtra("CINEMA_NAME", str5);
        appCompatActivity.startActivityForResult(intent, 5757);
    }
}
