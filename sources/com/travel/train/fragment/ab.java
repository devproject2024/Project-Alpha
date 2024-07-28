package com.travel.train.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.q;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.R;
import com.travel.train.a.a;
import com.travel.train.activity.AJREmbedWebView;
import com.travel.train.activity.AJRSelectCountryActivity;
import com.travel.train.activity.AJRTrainOffersListActivity;
import com.travel.train.helper.l;
import com.travel.train.i.d;
import com.travel.train.i.e;
import com.travel.train.j.b;
import com.travel.train.k.g;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.trainticket.CJRCountryCode;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainCancellationInsurance;
import com.travel.train.model.trainticket.CJRTrainConfirmation;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainFareDetail;
import com.travel.train.model.trainticket.CJRTrainOffers;
import com.travel.train.model.trainticket.CJRTrainPromoVerify;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.trainticket.CJRTrainVerifyCheckout;
import com.travel.train.model.travellerProfile.model.CJRTpUserProfile;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import com.travel.train.viewholder.c;
import com.travel.train.viewholder.f;
import com.travel.train.viewholder.g;
import com.travel.train.viewholder.h;
import com.travel.train.viewholder.i;
import com.travel.train.viewholder.j;
import com.travel.train.viewholder.k;
import com.travel.train.viewholder.m;
import com.travel.train.viewholder.n;
import com.travel.train.viewholder.o;
import com.travel.train.viewholder.p;
import com.travel.train.viewholder.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.PaytmSDK;
import net.one97.paytm.nativesdk.Utils.FetchOptionsRequest;
import net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener;
import net.one97.paytm.nativesdk.Utils.Server;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.upipush.pojo.VpaFetch;
import net.one97.paytm.nativesdk.orflow.Utility;
import net.one97.paytm.upi.common.upi.CommonPayParams;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public class ab extends am implements d, e, b.C0491b {
    private boolean A;
    /* access modifiers changed from: private */
    public com.travel.train.f.e B;
    private l C;
    private RelativeLayout D;
    private LinearLayout E;
    /* access modifiers changed from: private */
    public RelativeLayout F;
    private m G;
    private s H;
    private com.travel.train.viewholder.d I;
    private n J;
    private o K;
    private f L;
    private com.travel.train.viewholder.l M;
    private h N;
    private c O;
    private g P;
    private com.travel.train.viewholder.e Q;
    private p R;
    private i S;
    private k T;
    private j U;

    /* renamed from: a  reason: collision with root package name */
    private final String f26728a = "vertical_name";

    /* renamed from: b  reason: collision with root package name */
    private String f26729b = c.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private com.travel.train.k.f f26730c = null;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainDetailsBody f26731d;

    /* renamed from: e  reason: collision with root package name */
    private CJRTrainSearchResultsTrain f26732e;

    /* renamed from: f  reason: collision with root package name */
    private CJRTrainSearchInput f26733f;

    /* renamed from: g  reason: collision with root package name */
    private String f26734g;

    /* renamed from: h  reason: collision with root package name */
    private String f26735h;

    /* renamed from: i  reason: collision with root package name */
    private String f26736i;
    private String j;
    private String k;
    private CJRTrainBooking l = null;
    private Double m;
    private Double n;
    private String o;
    private String p;
    private int q;
    private ArrayList<CJRTrainFareDetail> r;
    private HashMap<Integer, String> s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public final void c() {
    }

    public ab() {
        Double valueOf = Double.valueOf(0.0d);
        this.m = valueOf;
        this.n = valueOf;
        this.r = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
    }

    public final /* synthetic */ Activity u() {
        return super.getActivity();
    }

    public static ab a(Bundle bundle) {
        ab abVar = new ab();
        abVar.setArguments(bundle);
        return abVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pre_t_fjr_train_view_iteneray_screen, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        String str;
        CJRTrainBooking cJRTrainBooking;
        CJRTrainBooking cJRTrainBooking2;
        super.onActivityCreated(bundle);
        this.f26730c = (com.travel.train.k.f) am.a((Fragment) this, (al.b) new com.travel.train.k.g(new g.a(g.b.REVIEWITINERARY).a(a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(getActivity()))))).a(com.travel.train.k.f.class);
        this.f26730c.f27659a.observe(this, new z<CJRTrainBooking>() {
            public final /* synthetic */ void onChanged(Object obj) {
                ab.this.a((CJRTrainBooking) obj);
            }
        });
        this.f26730c.f27662d.observe(this, new z<CJRTrainVerifyCheckout>() {
            public final /* synthetic */ void onChanged(Object obj) {
                CJRTrainVerifyCheckout cJRTrainVerifyCheckout = (CJRTrainVerifyCheckout) obj;
                ab abVar = ab.this;
                if (cJRTrainVerifyCheckout != null) {
                    CJRRechargePayment payment = cJRTrainVerifyCheckout.getPayment();
                    if (payment != null && "1".equalsIgnoreCase(payment.isNativeEnabled())) {
                        FragmentActivity activity = abVar.getActivity();
                        CJRRechargePayment payment2 = cJRTrainVerifyCheckout.getPayment();
                        AnonymousClass8 r7 = new FetchPayOptionsListener(cJRTrainVerifyCheckout) {

                            /* renamed from: a  reason: collision with root package name */
                            final /* synthetic */ CJRTrainVerifyCheckout f26745a;

                            public final void onPaymentOptionsReceived(CJPayMethodResponse cJPayMethodResponse) {
                            }

                            public final void onVpaReceived(VpaFetch vpaFetch) {
                            }

                            {
                                this.f26745a = r2;
                            }

                            public final void onRequestStart() {
                                ab abVar = ab.this;
                                abVar.showProgressDialog(abVar.getActivity(), ab.this.getResources().getString(R.string.please_wait_progress_msg));
                            }

                            public final void onPaymentOptionsError() {
                                ab.this.removeProgressDialog();
                                ab.this.a(this.f26745a);
                            }

                            public final void onRequestEnd(CJPayMethodResponse cJPayMethodResponse, VpaFetch vpaFetch) {
                                PaytmSDK.setResponse(cJPayMethodResponse, vpaFetch);
                                ab.this.removeProgressDialog();
                                ab.this.a(this.f26745a);
                            }
                        };
                        PaytmSDK.setServer(Server.PRODUCTION);
                        new FetchOptionsRequest((Context) activity, payment2.getMID(), payment2.getOrderId(), payment2.getmTxnToken(), (FetchPayOptionsListener) r7).executeRequest();
                        return;
                    }
                }
                abVar.a(cJRTrainVerifyCheckout);
            }
        });
        this.f26730c.f27661c.observe(this, new z<com.travel.train.model.e>() {
            public final /* synthetic */ void onChanged(Object obj) {
                com.travel.train.model.e eVar = (com.travel.train.model.e) obj;
                if (eVar != null) {
                    ab.this.B.handleErrorCode(eVar.f27696a, eVar.f27697b, eVar.f27698c);
                }
            }
        });
        this.f26730c.f27660b.observe(this, new z<Boolean>() {
            public final /* synthetic */ void onChanged(Object obj) {
                if (((Boolean) obj).booleanValue()) {
                    ab abVar = ab.this;
                    abVar.showProgressDialog(abVar.getContext(), ab.this.getContext().getResources().getString(R.string.train_review_fetching_data));
                    return;
                }
                ab.this.removeProgressDialog();
            }
        });
        if (getArguments() != null) {
            if (getArguments().containsKey("train_detail_body") && getArguments().getSerializable("train_detail_body") != null) {
                this.f26731d = (CJRTrainDetailsBody) getArguments().getSerializable("train_detail_body");
                CJRTrainDetailsBody cJRTrainDetailsBody = this.f26731d;
                if (cJRTrainDetailsBody != null) {
                    CJRTrainAvailability cJRTrainAvailability = cJRTrainDetailsBody.getmTrainAvailability().get(this.f26731d.getMiSelectedPosition());
                    String[] split = this.f26731d.getSelectedBoardingStation().split("-");
                    if (split.length > 0 && split[1] != null) {
                        this.k = split[1];
                    }
                    this.j = cJRTrainAvailability.getmQuotaCode();
                }
            }
            if (getArguments().containsKey("wallet_token")) {
                this.o = getArguments().getString("wallet_token");
            }
            if (getArguments().containsKey("train_detail") && getArguments().getSerializable("train_detail") != null) {
                this.f26732e = (CJRTrainSearchResultsTrain) getArguments().getSerializable("train_detail");
            }
            if (getArguments().containsKey("intent_extra_train_search_input") && getArguments().getSerializable("intent_extra_train_search_input") != null) {
                this.f26733f = (CJRTrainSearchInput) getArguments().getSerializable("intent_extra_train_search_input");
            }
            if (getArguments().containsKey("request_id") && getArguments().getString("request_id") != null) {
                this.f26734g = getArguments().getString("request_id");
            }
            if (getArguments().containsKey("train_class_code") && getArguments().getString("train_class_code") != null) {
                this.f26735h = getArguments().getString("train_class_code");
            }
            if (getArguments().containsKey("train_class_name") && getArguments().getString("train_class_name") != null) {
                this.f26736i = getArguments().getString("train_class_name");
            }
            if (getArguments().containsKey("insuranceChecked")) {
                this.p = getArguments().getString("insuranceChecked");
            }
            String str2 = this.p;
            if (str2 != null && str2.equalsIgnoreCase("true")) {
                this.u = true;
            }
            if (getArguments().containsKey("is_from_alternative_click")) {
                this.v = getArguments().getBoolean("is_from_alternative_click", false);
            }
            if (getArguments().containsKey("waiting_list")) {
                this.w = getArguments().getBoolean("waiting_list", false);
            }
            if (getArguments().containsKey("is_from_quick_book")) {
                this.z = getArguments().getBoolean("is_from_quick_book", false);
            }
            if (getArguments().containsKey("train_booking_details")) {
                this.l = (CJRTrainBooking) getArguments().getSerializable("train_booking_details");
            }
        }
        if (com.travel.train.j.g.f27551a != null) {
            this.t = com.travel.train.j.g.f27551a.isOldFareBreakupEnabled();
        }
        this.B = new com.travel.train.f.e(this, this.f26731d, this.f26734g);
        this.C = new l(getActivity(), this.f26731d, this.f26734g, this.f26735h, this.v, this.p);
        View view = getView();
        this.I = new com.travel.train.viewholder.d(view);
        this.J = new n(view, this.f26732e, this.f26731d, this.l, this.f26736i);
        this.K = new o(view, this, this.f26733f, this.f26731d);
        this.L = new f(view, this);
        this.M = new com.travel.train.viewholder.l(view, this);
        this.H = new s(view, this, this.f26731d, this.w, true);
        this.N = new h(view, this);
        this.O = new c(view, this);
        this.P = new com.travel.train.viewholder.g(view, this, this.f26732e);
        this.Q = new com.travel.train.viewholder.e(view, this);
        this.R = new p(view, this.f26731d);
        this.D = (RelativeLayout) view.findViewById(R.id.fare_rules_anim_layout);
        this.S = new i(view);
        this.T = new k(view);
        this.G = new m(view, this);
        this.E = (LinearLayout) view.findViewById(R.id.progress_lyt_hide);
        this.F = (RelativeLayout) view.findViewById(R.id.lyt_train_reprice_grey_bg);
        this.U = new j(view, this, this.f26732e);
        if (this.z && (cJRTrainBooking2 = this.l) != null) {
            c(cJRTrainBooking2);
        }
        if (TextUtils.isEmpty(this.o) || (cJRTrainBooking = this.l) == null) {
            this.B.a();
        } else {
            a(cJRTrainBooking);
        }
        s sVar = this.H;
        if (!(sVar.f28220c == null || sVar.f28220c.getTrainPreferences() == null || !sVar.f28220c.getTrainPreferences().isEnable())) {
            sVar.f28218a.setVisibility(0);
        }
        sVar.f28218a.setVisibility(sVar.f28223f ? 8 : 0);
        if (com.paytm.utility.b.r((Context) getActivity())) {
            com.travel.train.f.e eVar = this.B;
            com.travel.train.travellerProfile.a.a.a();
            com.travel.train.travellerProfile.a.a.a((Context) eVar.f26672a.u(), com.travel.train.travellerProfile.travel.a.train, (com.paytm.network.listener.b) eVar);
        }
        com.travel.train.b.a();
        com.travel.train.b.b().a("/trains/review-itinerary", "Trains", (Context) getActivity());
        com.travel.train.b.a();
        String F2 = com.travel.train.b.b().F();
        if (TextUtils.isEmpty(F2)) {
            F2 = getResources().getString(R.string.travel_push_notification_title);
        }
        String str3 = F2;
        com.travel.train.b.a();
        String G2 = com.travel.train.b.b().G();
        if (TextUtils.isEmpty(G2)) {
            str = getResources().getString(R.string.travel_train_push_content, new Object[]{this.f26732e.getSourceName(), this.f26732e.getDestinationName()});
        } else {
            str = getResources().getString(R.string.travel_push_content_hardcoded, new Object[]{this.f26732e.getSourceName(), this.f26732e.getDestinationName(), "Train"}) + G2;
        }
        com.travel.train.InAppPushNotification.a.b(getActivity().getApplicationContext(), "trainticket", "FD_Trains", str3, str, "searchdrop", "funneldrop");
    }

    public final void a() {
        j jVar = this.U;
        if (jVar.f28139c != null) {
            jVar.f28139c.setEnabled(true);
        }
    }

    public final void a(String str) {
        j jVar = this.U;
        if (jVar.f28139c != null) {
            jVar.f28139c.setText(str);
        }
    }

    public final void a(int i2) {
        this.S.a(i2);
    }

    public final CJRTrainBooking d() {
        return this.l;
    }

    public final HashMap<Integer, String> e() {
        return this.s;
    }

    public final boolean f() {
        return this.N.a();
    }

    private void b(CJRTrainBooking cJRTrainBooking) {
        String str;
        String str2 = "";
        CJRTrainConfirmation cJRTrainConfirmation = cJRTrainBooking.getmConfirmation();
        cJRTrainConfirmation.getmTrainDetails();
        getView().findViewById(R.id.review_details).setVisibility(0);
        m mVar = this.G;
        com.travel.train.b.a();
        if (com.travel.train.b.b().H()) {
            if (mVar.f28163e != null) {
                mVar.f28163e.cancel();
            }
            TextView textView = (TextView) mVar.f28164f.findViewById(R.id.count_down_text);
            mVar.f28164f.setVisibility(0);
            View findViewById = mVar.f28164f.findViewById(R.id.timer_bg_view);
            com.travel.train.b.a();
            int I2 = com.travel.train.b.b().I();
            textView.setTextColor(mVar.f28159a.getResources().getColor(R.color.color_00b9f5));
            findViewById.setBackgroundColor(mVar.f28159a.getResources().getColor(R.color.progress_bg));
            mVar.f28163e = new CountDownTimer((long) I2, textView, findViewById, I2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ TextView f28166a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ View f28167b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ int f28168c;

                {
                    this.f28166a = r4;
                    this.f28167b = r5;
                    this.f28168c = r6;
                }

                public final void onTick(long j) {
                    try {
                        long minutes = TimeUnit.MILLISECONDS.toMinutes(j);
                        long seconds = TimeUnit.MILLISECONDS.toSeconds(j) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(j));
                        if (TimeUnit.MILLISECONDS.toSeconds(j) <= 240) {
                            this.f28166a.setTextColor(m.this.f28159a.getResources().getColor(R.color.color_d0011b));
                            this.f28167b.setBackgroundColor(m.this.f28159a.getResources().getColor(R.color.color_1cd0011b));
                        }
                        this.f28166a.setText(String.format(m.this.f28161c, new Object[]{Long.valueOf(minutes), Long.valueOf(seconds)}));
                        ViewGroup.LayoutParams layoutParams = this.f28167b.getLayoutParams();
                        m.this.f28162d = (float) ((j * ((long) com.paytm.utility.b.a((Activity) m.this.f28159a))) / ((long) this.f28168c));
                        layoutParams.width = (int) m.this.f28162d;
                        this.f28167b.setLayoutParams(layoutParams);
                        new StringBuilder("incremental_value").append(m.this.f28162d);
                    } catch (Exception e2) {
                        q.c(e2.getMessage());
                    }
                }

                public final void onFinish() {
                    if (m.this.f28163e != null) {
                        m.this.f28163e.cancel();
                    }
                    m.this.f28160b.o();
                }
            };
            mVar.f28163e.start();
        }
        this.q = cJRTrainConfirmation.getGrandTotalKey().intValue();
        n nVar = this.J;
        if (nVar.f28171b != null) {
            TextView textView2 = nVar.f28177h;
            textView2.setText(com.travel.train.j.o.a(nVar.f28171b.getTrainName()) + " (" + nVar.f28171b.getTrainNumber() + ")");
            TextView textView3 = nVar.l;
            textView3.setText(nVar.f28171b.getSourceName() + " (" + nVar.f28171b.getSource() + ")");
            nVar.j.setText(com.travel.train.j.i.b(nVar.f28171b.getMSearchedTrainDepartureTime()));
            nVar.k.setText(com.travel.train.j.i.f(nVar.f28171b.getMSearchedTrainDepartureTime()));
            TextView textView4 = nVar.o;
            textView4.setText(nVar.f28171b.getDestinationName() + " (" + nVar.f28171b.getDestination() + ")");
            nVar.n.setText(com.travel.train.j.i.f(nVar.f28171b.getMSearchedTrainArrivalTime()));
            nVar.m.setText(com.travel.train.j.i.b(nVar.f28171b.getMSearchedTrainArrivalTime()));
        }
        TextView textView5 = nVar.f28178i;
        textView5.setText(nVar.f28176g + " | " + nVar.f28173d.getQuota());
        String[] split = nVar.f28174e.split(AppConstants.COMMA);
        nVar.q.setText(split[0]);
        nVar.s.setText(split[1]);
        try {
            if (nVar.f28172c == null || TextUtils.isEmpty(nVar.f28172c.getBoardingTime())) {
                nVar.k.setText(split[1].trim().replace("Hrs", str2));
            } else {
                nVar.k.setText(nVar.f28172c.getBoardingTime());
            }
            String[] split2 = split[0].split("-");
            String str3 = split2[0];
            String str4 = split2[1];
            TextView textView6 = nVar.l;
            textView6.setText(str4.trim() + " (" + str3.trim() + ")");
        } catch (Exception unused) {
        }
        nVar.r.setAdapter(new ArrayAdapter(nVar.f28170a, R.layout.pre_t_train_review_spinner_item, R.id.item_name, nVar.f28172c.getBoardingStation()));
        nVar.r.setSelection(nVar.f28172c.getMiSelectedPosition());
        n.a aVar = new n.a();
        nVar.r.setOnItemSelectedListener(aVar);
        nVar.r.setOnTouchListener(aVar);
        boolean z2 = nVar.f28172c != null && nVar.f28172c.getBoardingDate() != null && !TextUtils.isEmpty(nVar.f28172c.getBoardingDate().trim()) && com.paytm.utility.b.c(nVar.f28172c.getBoardingDate(), "dd MMM yyyy") && nVar.f28172c.getBoardingTime() != null && !TextUtils.isEmpty(nVar.f28172c.getBoardingTime().trim()) && com.paytm.utility.b.c(nVar.f28172c.getBoardingTime(), "HH:mm");
        if (z2) {
            str = v.a(nVar.f28172c.getBoardingDate(), " ", nVar.f28172c.getBoardingTime());
        } else {
            str = nVar.f28171b.getMSearchedTrainDepartureTime();
        }
        String c2 = com.travel.train.j.i.c(z2 ? com.paytm.utility.b.d(str, "dd MMM yy HH:mm", "yyyy-MM-dd'T'HH:mm:ss") : str, nVar.f28171b.getMSearchedTrainArrivalTime());
        if (!TextUtils.isEmpty(c2)) {
            nVar.p.setText(c2);
        }
        if (z2) {
            str = com.paytm.utility.b.d(str, "dd MMM yy HH:mm", "EEE, dd MMM");
        }
        nVar.j.setText(str);
        nVar.a(cJRTrainBooking);
        this.K.s.setVisibility(0);
        j jVar = this.U;
        if (jVar.f28140d.getVisibility() == 0) {
            jVar.f28140d.setVisibility(8);
            jVar.f28138b.setVisibility(0);
            jVar.f28137a.g();
        }
        p pVar = this.R;
        if (pVar.f28197b != null && !TextUtils.isEmpty(pVar.f28197b.getEmailAddress()) && !TextUtils.isEmpty(pVar.f28197b.getUserMobileNumber())) {
            pVar.f28198c.setVisibility(0);
            if (pVar.f28197b != null && !TextUtils.isEmpty(pVar.f28197b.getEmailAddress()) && !TextUtils.isEmpty(pVar.f28197b.getUserMobileNumber())) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("Your ticket will be sent to " + pVar.f28197b.getEmailAddress() + " and " + pVar.f28197b.getUserMobileNumber());
                spannableStringBuilder.setSpan(new StyleSpan(1), 28, pVar.f28197b.getEmailAddress().length() + 28, 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(pVar.f28196a.getResources().getColor(R.color.color_222222)), 28, pVar.f28197b.getEmailAddress().length() + 28, 33);
                spannableStringBuilder.setSpan(new CustomTypefaceSpan("sans-serif-mediam", Typeface.SANS_SERIF), 28, pVar.f28197b.getEmailAddress().length() + 28, 33);
                int length = pVar.f28197b.getEmailAddress().length() + 28 + 5;
                spannableStringBuilder.setSpan(new StyleSpan(1), length, pVar.f28197b.getUserMobileNumber().length() + length, 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(pVar.f28196a.getResources().getColor(R.color.color_222222)), length, pVar.f28197b.getUserMobileNumber().length() + length, 33);
                spannableStringBuilder.setSpan(new CustomTypefaceSpan("sans-serif-mediam", Typeface.SANS_SERIF), length, pVar.f28197b.getUserMobileNumber().length() + length, 33);
                str2 = spannableStringBuilder.toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                pVar.f28199d.setText(str2);
            }
        }
        i iVar = this.S;
        CJRTrainConfirmation cJRTrainConfirmation2 = cJRTrainBooking.getmConfirmation();
        if (cJRTrainConfirmation2.getPaymentTipMessage() == null || cJRTrainConfirmation2.getPaymentTipMessage().trim().length() == 0) {
            iVar.a(8);
        } else {
            iVar.a(0);
            iVar.f28133a.setText(cJRTrainConfirmation2.getPaymentTipMessage());
        }
        if (cJRTrainConfirmation.getFastForward() != null) {
            if (!cJRTrainConfirmation.getFastForward().isEnabled() || !cJRTrainConfirmation.getFastForward().isDefaultChecked()) {
                a(getResources().getString(R.string.train_itinerary_proceed_btn));
            } else {
                a(getResources().getString(R.string.train_itinerary_ff_proceed_btn));
            }
        }
        if (this.t) {
            a(cJRTrainConfirmation);
        } else {
            this.B.a(this.r, cJRTrainConfirmation, this.q);
            a(this.n);
        }
        h hVar = this.N;
        CJRTrainConfirmation cJRTrainConfirmation3 = cJRTrainBooking.getmConfirmation();
        CJRTrainDetailsBody cJRTrainDetailsBody = cJRTrainConfirmation3.getmTrainDetails();
        if (cJRTrainConfirmation3.getCancellationInsurance() == null || !cJRTrainConfirmation3.getCancellationInsurance().getEnabled()) {
            hVar.f28126d.setVisibility(8);
        } else {
            hVar.f28126d.setVisibility(0);
            CJRTrainCancellationInsurance cancellationInsurance = cJRTrainConfirmation3.getCancellationInsurance();
            TextView textView7 = (TextView) hVar.f28126d.findViewById(R.id.description_view);
            View findViewById2 = hVar.f28126d.findViewById(R.id.description_divider);
            LinearLayout linearLayout = (LinearLayout) hVar.f28126d.findViewById(R.id.tip_container);
            TextView textView8 = (TextView) hVar.f28126d.findViewById(R.id.tip_message_view);
            TextView textView9 = (TextView) hVar.f28126d.findViewById(R.id.view_txt);
            if (cancellationInsurance.getDefaultChecked()) {
                hVar.f28127e.setChecked(true);
            } else {
                hVar.f28127e.setChecked(false);
            }
            if (cancellationInsurance.getMandatoryOptIn()) {
                hVar.f28127e.setChecked(true);
                hVar.f28127e.setClickable(false);
            } else {
                hVar.f28127e.setClickable(true);
            }
            if (!TextUtils.isEmpty(cancellationInsurance.getTitle())) {
                hVar.f28127e.setText(cancellationInsurance.getTitle());
            }
            if (!TextUtils.isEmpty(cancellationInsurance.getTip())) {
                linearLayout.setVisibility(0);
                findViewById2.setVisibility(0);
                textView8.setText(cancellationInsurance.getTip());
            } else {
                linearLayout.setVisibility(8);
                findViewById2.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cancellationInsurance.getDescription())) {
                textView7.setVisibility(0);
                textView7.setText(cancellationInsurance.getDescription());
            } else {
                textView7.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cancellationInsurance.getTncText())) {
                textView9.setVisibility(0);
                textView9.setText(cancellationInsurance.getTncText());
            }
            textView9.setOnClickListener(new View.OnClickListener(cancellationInsurance) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ CJRTrainCancellationInsurance f28131a;

                {
                    this.f28131a = r2;
                }

                public final void onClick(View view) {
                    h hVar = h.this;
                    String str = net.one97.paytm.common.utility.d.ds;
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("user_id", com.paytm.utility.b.n(hVar.f28123a) != null ? com.paytm.utility.b.n(hVar.f28123a) : "");
                        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/review-itinerary");
                        com.travel.train.b.a();
                        com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, hVar.f28123a);
                    } catch (Exception e2) {
                        q.c(e2.getMessage());
                    }
                    h.this.f28124b.a(this.f28131a.getTncText(), this.f28131a.getTncUrl());
                }
            });
        }
        hVar.f28127e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(cJRTrainDetailsBody, cJRTrainBooking) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CJRTrainDetailsBody f28128a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CJRTrainBooking f28129b;

            {
                this.f28128a = r2;
                this.f28129b = r3;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                h hVar = h.this;
                String str = net.one97.paytm.common.utility.d.dr;
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_id", com.paytm.utility.b.n(hVar.f28123a) != null ? com.paytm.utility.b.n(hVar.f28123a) : "");
                    if (z) {
                        hashMap.put(net.one97.paytm.common.utility.d.df, CommonPayParams.Builder.YES);
                    } else {
                        hashMap.put(net.one97.paytm.common.utility.d.df, CommonPayParams.Builder.NO);
                    }
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/review-itinerary");
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, hVar.f28123a);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                if (!z || this.f28128a.getTrainFare().getCpCharges() == null) {
                    e eVar = h.this.f28124b;
                    eVar.b(h.this.f28123a.getResources().getString(R.string.rs_symbols) + " " + this.f28129b.getmConfirmation().getmTrainDetails().getTrainFare().getGrandTotal());
                    return;
                }
                e eVar2 = h.this.f28124b;
                eVar2.b(h.this.f28123a.getResources().getString(R.string.rs_symbols) + " " + this.f28129b.getmConfirmation().getmTrainDetails().getTrainFare().getCpCharges().getGrandTotalCp());
            }
        });
        this.O.a(cJRTrainBooking.getmConfirmation(), this.r);
        this.L.a(this.r);
        this.M.a(this.r);
        this.T.a(cJRTrainBooking);
    }

    public final double a(double d2, double d3) {
        double d4;
        if (this.l.getmConfirmation().getOptOutPGCharges() == null || this.l.getmConfirmation().getOptOutServiceCharges() == null || this.l.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered() == null || this.l.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered() == null) {
            if (!this.l.getmConfirmation().isServiceChargeEnabled() && !this.l.getmConfirmation().isGatewayChargeEnabled()) {
                d3 -= this.M.f28151c;
                d4 = this.L.f28087b;
            } else if (!this.l.getmConfirmation().isServiceChargeEnabled()) {
                d4 = this.M.f28151c;
            } else {
                if (!this.l.getmConfirmation().isGatewayChargeEnabled()) {
                    d4 = this.L.f28087b;
                }
                return d3;
            }
        } else if (!this.l.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() || !this.l.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
            if (!this.l.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() || this.l.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                if (this.l.getmConfirmation().getOptOutPGCharges().isWaiveOffConfigered().booleanValue() || !this.l.getmConfirmation().getOptOutServiceCharges().isWaiveOffConfigered().booleanValue()) {
                    return d2;
                }
                if (this.l.getmConfirmation().isServiceChargeEnabled() && !this.l.getmConfirmation().isGatewayChargeEnabled()) {
                    d3 -= this.M.f28151c;
                    d4 = this.L.f28087b;
                } else if (this.l.getmConfirmation().isServiceChargeEnabled()) {
                    d4 = this.M.f28151c;
                } else {
                    if (!this.l.getmConfirmation().isGatewayChargeEnabled()) {
                        d4 = this.L.f28087b;
                    }
                    return d3;
                }
            } else if (!this.l.getmConfirmation().isServiceChargeEnabled() && this.l.getmConfirmation().isGatewayChargeEnabled()) {
                d3 -= this.M.f28151c;
                d4 = this.L.f28087b;
            } else if (!this.l.getmConfirmation().isServiceChargeEnabled()) {
                d4 = this.M.f28151c;
            } else {
                if (this.l.getmConfirmation().isGatewayChargeEnabled()) {
                    d4 = this.L.f28087b;
                }
                return d3;
            }
        } else if (this.l.getmConfirmation().isServiceChargeEnabled() && this.l.getmConfirmation().isGatewayChargeEnabled()) {
            d3 -= this.M.f28151c;
            d4 = this.L.f28087b;
        } else if (this.l.getmConfirmation().isServiceChargeEnabled()) {
            d4 = this.M.f28151c;
        } else {
            if (this.l.getmConfirmation().isGatewayChargeEnabled()) {
                d4 = this.L.f28087b;
            }
            return d3;
        }
        return d3 - d4;
    }

    public final void a(CJRTpUserProfileContact cJRTpUserProfileContact) {
        com.travel.train.f.e eVar = this.B;
        if (eVar != null && cJRTpUserProfileContact != null) {
            com.travel.train.travellerProfile.a.a.a().a(eVar.f26672a.u().getApplicationContext(), cJRTpUserProfileContact, (com.paytm.network.listener.b) eVar);
        }
    }

    public final void g() {
        o oVar = this.K;
        oVar.v.setVisibility(8);
        if (oVar.t != null) {
            for (int i2 = 0; i2 < oVar.t.getChildCount(); i2++) {
                View childAt = oVar.t.getChildAt(i2);
                ((RelativeLayout) childAt.findViewById(R.id.add_passenger_layout)).setClickable(false);
                childAt.findViewById(R.id.delete_passenger).setVisibility(8);
            }
        }
        if (oVar.u != null) {
            for (int i3 = 0; i3 < oVar.u.getChildCount(); i3++) {
                View childAt2 = oVar.u.getChildAt(i3);
                ((RelativeLayout) childAt2.findViewById(R.id.add_passenger_layout)).setClickable(false);
                childAt2.findViewById(R.id.delete_passenger).setVisibility(8);
            }
        }
    }

    public final void b(int i2) {
        ((RelativeLayout.LayoutParams) this.F.getLayoutParams()).setMargins(0, 0, 0, i2);
    }

    public final void a(CJRTrainConfirmation cJRTrainConfirmation) {
        String str;
        Float f2;
        if (cJRTrainConfirmation != null && cJRTrainConfirmation.getCancellationInsurance() != null) {
            CJRTrainCancellationInsurance cancellationInsurance = cJRTrainConfirmation.getCancellationInsurance();
            if (!cancellationInsurance.getEnabled() || !cancellationInsurance.getDefaultChecked()) {
                str = cJRTrainConfirmation.getmTrainDetails().getTrainFare().getGrandTotal();
            } else {
                str = cJRTrainConfirmation.getmTrainDetails().getTrainFare().getCpCharges().getGrandTotalCp();
            }
            if (cJRTrainConfirmation.getOptOutPGCharges() == null || !Boolean.TRUE.equals(cJRTrainConfirmation.getOptOutPGCharges().isWaiveOffConfigered())) {
                if (!cJRTrainConfirmation.isGatewayChargeEnabled()) {
                    f2 = Float.valueOf(Float.parseFloat(str) - Float.parseFloat(cJRTrainConfirmation.getmTrainDetails().getTrainFare().getPgCharge()));
                } else {
                    f2 = Float.valueOf(Float.parseFloat(str));
                }
            } else if (cJRTrainConfirmation.isGatewayChargeEnabled()) {
                f2 = Float.valueOf(Float.parseFloat(str) - Float.parseFloat(cJRTrainConfirmation.getmTrainDetails().getTrainFare().getPgCharge()));
            } else {
                f2 = Float.valueOf(Float.parseFloat(str));
            }
            if (cJRTrainConfirmation.getOptOutServiceCharges() == null || !Boolean.TRUE.equals(cJRTrainConfirmation.getOptOutServiceCharges().isWaiveOffConfigered())) {
                if (!cJRTrainConfirmation.isServiceChargeEnabled()) {
                    f2 = Float.valueOf(f2.floatValue() - Float.parseFloat(cJRTrainConfirmation.getmTrainDetails().getTrainFare().getmPaytm_Service_Fee()));
                }
            } else if (cJRTrainConfirmation.isServiceChargeEnabled()) {
                f2 = Float.valueOf(f2.floatValue() - Float.parseFloat(cJRTrainConfirmation.getmTrainDetails().getTrainFare().getmPaytm_Service_Fee()));
            }
            b(getActivity().getResources().getString(R.string.rs_symbols) + " " + com.travel.train.j.o.a(Double.valueOf((double) f2.floatValue())));
        }
    }

    public final void a(Double d2) {
        String a2 = com.travel.train.j.o.a(d2);
        if (a2 != null) {
            b(getResources().getString(R.string.rs_symbols) + " " + a2);
        }
    }

    public final void b(String str) {
        this.U.a(str);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    private void c(CJRTrainBooking cJRTrainBooking) {
        if (cJRTrainBooking != null) {
            if (this.x) {
                this.x = false;
                this.y = true;
            }
            this.E.setVisibility(8);
            b(cJRTrainBooking);
            if (this.D.getVisibility() == 0) {
                q();
            }
            this.Q.a(cJRTrainBooking.getmConfirmation().getFastForward());
            if (com.travel.train.j.g.f27551a != null && com.travel.train.j.g.f27551a.getPromoCodeVisible()) {
                this.P.a();
                this.B.b();
            }
            removeProgressDialog();
        }
        this.I.a();
    }

    public final void a(CJRTrainBooking cJRTrainBooking) {
        this.l = cJRTrainBooking;
        if (this.l.getmConfirmation() != null) {
            c(this.l);
            com.travel.train.j.o.a("train_review_itinerary", (String) null, SDKConstants.PG_SCREEN_LOADED, "/trains/review-itinerary", getActivity());
        }
    }

    public final void a(CJRPGTokenList cJRPGTokenList) {
        this.o = com.travel.train.j.e.a(cJRPGTokenList);
        if (!this.z) {
            o();
        }
    }

    public final void a(CJRTrainOffers cJRTrainOffers) {
        this.P.a(cJRTrainOffers.getBody().getPromotions(), com.travel.train.j.g.f27551a != null && com.travel.train.j.g.f27551a.getPromoCodeVisible());
    }

    public final void a(CJRTrainPromoVerify cJRTrainPromoVerify) {
        Boolean bool;
        if (cJRTrainPromoVerify != null) {
            removeProgressDialog();
            com.travel.train.viewholder.g gVar = this.P;
            if (cJRTrainPromoVerify == null || cJRTrainPromoVerify.getBody() == null || cJRTrainPromoVerify.getBody().getPromostatus() == null || !cJRTrainPromoVerify.getBody().getPromostatus().equalsIgnoreCase("success")) {
                Boolean bool2 = Boolean.TRUE;
                com.paytm.utility.b.b(gVar.f28096a, (String) null, cJRTrainPromoVerify.getBody().getPromofailuretext());
                HashMap hashMap = new HashMap();
                hashMap.put("train_promocode", gVar.f28100e);
                gVar.f28099d = null;
                hashMap.put("train_promocode_error_message", cJRTrainPromoVerify.getBody().getPromofailuretext());
                com.travel.train.j.o.a("train_review_itinerary_promocode_error", gVar.f28097b.getSourceName(), gVar.f28097b.getDestinationName(), com.paytm.utility.b.n(gVar.f28096a), hashMap, gVar.f28096a);
                gVar.f28100e = null;
                gVar.f28102g.setVisibility(8);
                bool = bool2;
            } else {
                gVar.f28102g.setVisibility(0);
                gVar.f28103h.setText(gVar.f28100e);
                gVar.f28099d = gVar.f28100e;
                gVar.j = cJRTrainPromoVerify.getBody().getPromoText();
                gVar.f28104i.setText(gVar.j);
                bool = Boolean.FALSE;
                ScrollView scrollView = (ScrollView) gVar.itemView.findViewById(R.id.passenger_detail_scrollview);
                scrollView.post(new Runnable(scrollView) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ ScrollView f28112a;

                    {
                        this.f28112a = r2;
                    }

                    public final void run() {
                        this.f28112a.fullScroll(130);
                    }
                });
            }
            gVar.a(gVar.f28101f, bool.booleanValue());
        }
    }

    public final void a(CJRTpUserProfile cJRTpUserProfile) {
        o oVar = this.K;
        if (cJRTpUserProfile != null) {
            oVar.f28186f = cJRTpUserProfile.getBody().getContacts();
            if (oVar.f28186f != null && oVar.f28186f.size() > 0) {
                oVar.f28184d.clear();
                for (int i2 = 0; i2 < oVar.f28186f.size(); i2++) {
                    CJRTpUserProfileContact cJRTpUserProfileContact = oVar.f28186f.get(i2);
                    if (!(cJRTpUserProfileContact == null || !com.travel.train.j.o.g(cJRTpUserProfileContact.getGender()) || cJRTpUserProfileContact.getAge() == null)) {
                        oVar.f28184d.add(cJRTpUserProfileContact);
                    }
                }
                com.travel.train.travellerProfile.a.a.a().a(oVar.f28184d);
                for (int i3 = 0; i3 < oVar.f28184d.size(); i3++) {
                    if (!(oVar.f28184d.get(i3) == null || oVar.f28184d.get(i3).getAge() == null || Integer.parseInt(oVar.f28184d.get(i3).getAge()) > 4)) {
                        oVar.f28185e.add(oVar.f28184d.get(i3));
                    }
                }
                for (int i4 = 0; i4 < oVar.f28185e.size(); i4++) {
                    oVar.f28184d.remove(oVar.f28185e.get(i4));
                }
            }
        }
    }

    public void removeProgressDialog() {
        super.removeProgressDialog();
    }

    public void showProgressDialog(Context context, String str) {
        super.showProgressDialog(context, str);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof CJRTrainPromoVerify) {
            String message = networkCustomError.getMessage();
            com.travel.train.viewholder.g gVar = this.P;
            HashMap hashMap = new HashMap();
            hashMap.put("train_promocode", gVar.f28100e);
            hashMap.put("train_promocode_error_message", message);
            com.travel.train.j.o.a("train_review_itinerary_promocode_error", gVar.f28097b.getSourceName(), gVar.f28097b.getDestinationName(), com.paytm.utility.b.n(gVar.f28096a), hashMap, gVar.f28096a);
            this.P.a();
        }
    }

    public final void c(String str) {
        String str2 = this.f26734g;
        if (str2 != null) {
            com.travel.train.f.e eVar = this.B;
            if (str2 != null) {
                StringBuilder sb = new StringBuilder();
                com.travel.train.b.a();
                sb.append(com.travel.train.b.b().v());
                sb.append(str2);
                String s2 = com.paytm.utility.b.s(eVar.f26672a.u(), sb.toString());
                if (!URLUtil.isValidUrl(s2)) {
                    eVar.f26672a.removeProgressDialog();
                    com.paytm.utility.b.b((Context) eVar.f26672a.u(), (String) null, eVar.f26672a.u().getResources().getString(R.string.msg_invalid_url_train));
                } else if (com.paytm.utility.b.c((Context) eVar.f26672a.u())) {
                    try {
                        eVar.f26672a.showProgressDialog(eVar.f26672a.u(), eVar.f26672a.u().getString(R.string.please_wait_progress_msg));
                        eVar.f26673b = true;
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = eVar.f26672a.u();
                        bVar.f42878b = a.c.TRAIN;
                        bVar.n = a.b.SILENT;
                        bVar.o = com.travel.train.j.g.j;
                        bVar.f42879c = a.C0715a.POST;
                        bVar.f42880d = s2;
                        bVar.f42882f = com.travel.train.j.n.c((Context) eVar.f26672a.u());
                        bVar.f42884h = com.travel.train.f.e.a(str).toString();
                        bVar.f42885i = new CJRTrainPromoVerify();
                        bVar.j = eVar;
                        com.paytm.network.a l2 = bVar.l();
                        l2.f42859c = false;
                        l2.a();
                    } catch (Exception e2) {
                        eVar.f26672a.removeProgressDialog();
                        com.paytm.utility.b.b((Context) eVar.f26672a.u(), (String) null, e2.getMessage());
                    }
                } else {
                    eVar.f26672a.removeProgressDialog();
                    com.paytm.utility.b.b((Context) eVar.f26672a.u(), eVar.f26672a.u().getResources().getString(R.string.no_connection), eVar.f26672a.u().getResources().getString(R.string.no_internet_train));
                }
            }
        }
    }

    public final void h() {
        if (this.l.getmConfirmation().isDeferredCheckout().booleanValue()) {
            com.travel.train.k.f fVar = this.f26730c;
            HashMap<String, String> a2 = com.travel.train.j.n.a(getContext(), this.o);
            HashMap<String, String> a3 = this.C.a(this.v, this.Q.a(), this.t && this.B.e(), this.s, this.B.c(), this.B.d(), true);
            JSONObject a4 = l.a(this.P.f28100e);
            kotlin.g.b.k.c(a2, "headers");
            kotlin.g.b.k.c(a3, "urlParams");
            fVar.f27660b.postValue(Boolean.TRUE);
            com.travel.train.a.a aVar = fVar.f27663e;
            if (aVar != null) {
                com.paytm.network.listener.b bVar = fVar;
                aVar.b(bVar, bVar, a2, a3, a4);
            }
        } else {
            com.travel.train.k.f fVar2 = this.f26730c;
            HashMap<String, String> a5 = com.travel.train.j.n.a(getContext(), this.o);
            HashMap<String, String> a6 = this.C.a(this.v, this.Q.a(), this.t && this.B.e(), this.s, this.B.c(), this.B.d(), false);
            JSONObject a7 = l.a(this.P.f28100e);
            kotlin.g.b.k.c(a5, "headers");
            kotlin.g.b.k.c(a6, "urlParams");
            fVar2.f27660b.postValue(Boolean.TRUE);
            com.paytm.network.listener.b bVar2 = fVar2;
            fVar2.f27663e.c(bVar2, bVar2, a5, a6, a7);
        }
        if (getResources().getString(R.string.train_itinerary_proceed_btn).equalsIgnoreCase(this.U.f28139c.getText().toString())) {
            this.A = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:131:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0270  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r16 = this;
            r0 = r16
            r16.hideKeyboard()
            r1 = 1
            r0.x = r1
            com.travel.train.viewholder.s r2 = r0.H
            r2.a()
            com.travel.train.viewholder.o r2 = r0.K
            r3 = 0
            r2.f28189i = r3
            android.widget.LinearLayout r4 = r2.t
            java.lang.String r5 = "SW"
            java.lang.String r6 = "AT"
            java.lang.String r7 = "SM"
            java.lang.String r8 = "IF"
            java.lang.String r9 = "AF"
            java.lang.String r10 = "CH"
            java.lang.String r11 = "AM"
            java.lang.String r12 = ""
            if (r4 == 0) goto L_0x0070
            r4 = 0
        L_0x0027:
            android.widget.LinearLayout r13 = r2.t
            int r13 = r13.getChildCount()
            if (r4 >= r13) goto L_0x0070
            android.widget.LinearLayout r13 = r2.t
            android.view.View r13 = r13.getChildAt(r4)
            android.widget.RelativeLayout r13 = (android.widget.RelativeLayout) r13
            int r14 = com.travel.train.R.id.passenger_type_radio
            android.view.View r14 = r13.findViewById(r14)
            android.widget.RadioGroup r14 = (android.widget.RadioGroup) r14
            int r15 = r14.getCheckedRadioButtonId()
            int r1 = com.travel.train.R.id.male_radio
            if (r15 != r1) goto L_0x004a
            java.lang.String r1 = com.travel.train.j.g.V
            goto L_0x0061
        L_0x004a:
            int r1 = r14.getCheckedRadioButtonId()
            int r15 = com.travel.train.R.id.female_radio
            if (r1 != r15) goto L_0x0055
            java.lang.String r1 = com.travel.train.j.g.W
            goto L_0x0061
        L_0x0055:
            int r1 = r14.getCheckedRadioButtonId()
            int r14 = com.travel.train.R.id.transgender_radio
            if (r1 != r14) goto L_0x0060
            java.lang.String r1 = com.travel.train.j.g.X
            goto L_0x0061
        L_0x0060:
            r1 = r12
        L_0x0061:
            com.travel.train.helper.n r14 = r2.f28183c
            boolean r1 = r14.a((int) r4, (android.view.View) r13, (java.lang.String) r1, (boolean) r3)
            if (r1 != 0) goto L_0x006c
        L_0x0069:
            r1 = 0
            goto L_0x01a1
        L_0x006c:
            int r4 = r4 + 1
            r1 = 1
            goto L_0x0027
        L_0x0070:
            android.widget.LinearLayout r1 = r2.u
            if (r1 == 0) goto L_0x00bc
            r1 = 0
        L_0x0075:
            android.widget.LinearLayout r4 = r2.u
            int r4 = r4.getChildCount()
            if (r1 >= r4) goto L_0x00bc
            android.widget.LinearLayout r4 = r2.u
            android.view.View r4 = r4.getChildAt(r1)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            int r13 = com.travel.train.R.id.passenger_type_radio
            android.view.View r13 = r4.findViewById(r13)
            android.widget.RadioGroup r13 = (android.widget.RadioGroup) r13
            int r14 = r13.getCheckedRadioButtonId()
            int r15 = com.travel.train.R.id.male_radio
            if (r14 != r15) goto L_0x0098
            java.lang.String r13 = com.travel.train.j.g.V
            goto L_0x00af
        L_0x0098:
            int r14 = r13.getCheckedRadioButtonId()
            int r15 = com.travel.train.R.id.female_radio
            if (r14 != r15) goto L_0x00a3
            java.lang.String r13 = com.travel.train.j.g.W
            goto L_0x00af
        L_0x00a3:
            int r13 = r13.getCheckedRadioButtonId()
            int r14 = com.travel.train.R.id.transgender_radio
            if (r13 != r14) goto L_0x00ae
            java.lang.String r13 = com.travel.train.j.g.X
            goto L_0x00af
        L_0x00ae:
            r13 = r12
        L_0x00af:
            com.travel.train.helper.n r14 = r2.f28183c
            r15 = 1
            boolean r4 = r14.a((int) r1, (android.view.View) r4, (java.lang.String) r13, (boolean) r15)
            if (r4 != 0) goto L_0x00b9
            goto L_0x0069
        L_0x00b9:
            int r1 = r1 + 1
            goto L_0x0075
        L_0x00bc:
            com.travel.train.helper.n r1 = r2.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r1 = r1.l
            if (r1 == 0) goto L_0x01a0
            com.travel.train.helper.n r1 = r2.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r1 = r1.l
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x01a0
            r1 = 0
        L_0x00cd:
            com.travel.train.helper.n r4 = r2.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            int r4 = r4.size()
            if (r1 >= r4) goto L_0x012a
            com.travel.train.helper.n r4 = r2.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            java.lang.Object r4 = r4.get(r1)
            com.travel.train.model.trainticket.CJRPassengerInfo r4 = (com.travel.train.model.trainticket.CJRPassengerInfo) r4
            if (r4 == 0) goto L_0x0127
            java.lang.String r12 = r4.getmCategory()
            if (r12 == 0) goto L_0x0127
            java.lang.String r12 = r4.getmCategory()
            boolean r12 = r12.equalsIgnoreCase(r11)
            if (r12 != 0) goto L_0x0125
            java.lang.String r12 = r4.getmCategory()
            boolean r12 = r12.equalsIgnoreCase(r10)
            if (r12 != 0) goto L_0x0125
            java.lang.String r12 = r4.getmCategory()
            boolean r12 = r12.equalsIgnoreCase(r9)
            if (r12 != 0) goto L_0x0125
            java.lang.String r12 = r4.getmCategory()
            boolean r12 = r12.equalsIgnoreCase(r7)
            if (r12 != 0) goto L_0x0125
            java.lang.String r12 = r4.getmCategory()
            boolean r12 = r12.equalsIgnoreCase(r5)
            if (r12 != 0) goto L_0x0125
            java.lang.String r4 = r4.getmCategory()
            boolean r4 = r4.equalsIgnoreCase(r6)
            if (r4 == 0) goto L_0x0127
        L_0x0125:
            r1 = 1
            goto L_0x012b
        L_0x0127:
            int r1 = r1 + 1
            goto L_0x00cd
        L_0x012a:
            r1 = 0
        L_0x012b:
            if (r1 != 0) goto L_0x0144
            android.content.Context r1 = r2.f28181a
            android.content.Context r4 = r2.f28181a
            int r12 = com.travel.train.R.string.train_travellers_error
            java.lang.String r4 = r4.getString(r12)
            android.content.Context r2 = r2.f28181a
            int r12 = com.travel.train.R.string.min_number_of_passenger_error
            java.lang.String r2 = r2.getString(r12)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r4, (java.lang.String) r2)
            goto L_0x0069
        L_0x0144:
            r1 = 0
            r4 = 0
        L_0x0146:
            com.travel.train.helper.n r12 = r2.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r12 = r12.l
            int r12 = r12.size()
            if (r1 >= r12) goto L_0x0179
            com.travel.train.helper.n r12 = r2.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r12 = r12.l
            java.lang.Object r12 = r12.get(r1)
            com.travel.train.model.trainticket.CJRPassengerInfo r12 = (com.travel.train.model.trainticket.CJRPassengerInfo) r12
            if (r12 == 0) goto L_0x0176
            java.lang.String r13 = r12.getmCategory()
            if (r13 == 0) goto L_0x0176
            java.lang.String r12 = r12.getmCategory()
            boolean r12 = r12.equalsIgnoreCase(r8)
            if (r12 == 0) goto L_0x0176
            int r4 = r4 + 1
            com.travel.train.helper.n r12 = r2.f28183c
            int r12 = r12.f27345g
            if (r4 <= r12) goto L_0x0176
            r1 = 0
            goto L_0x017a
        L_0x0176:
            int r1 = r1 + 1
            goto L_0x0146
        L_0x0179:
            r1 = 1
        L_0x017a:
            if (r1 != 0) goto L_0x01a0
            android.content.Context r1 = r2.f28181a
            android.content.Context r4 = r2.f28181a
            int r12 = com.travel.train.R.string.train_travellers_error
            java.lang.String r4 = r4.getString(r12)
            android.content.Context r12 = r2.f28181a
            int r13 = com.travel.train.R.string.maximum_number_of_infant
            r14 = 1
            java.lang.Object[] r15 = new java.lang.Object[r14]
            com.travel.train.helper.n r2 = r2.f28183c
            int r2 = r2.f27345g
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r15[r3] = r2
            java.lang.String r2 = r12.getString(r13, r15)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r4, (java.lang.String) r2)
            goto L_0x0069
        L_0x01a0:
            r1 = 1
        L_0x01a1:
            if (r1 == 0) goto L_0x0345
            com.travel.train.viewholder.o r1 = r0.K
            com.travel.train.helper.n r2 = r1.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r2 = r2.l
            if (r2 == 0) goto L_0x0345
            com.travel.train.helper.n r2 = r1.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r2 = r2.l
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x0345
            r1.l = r3
            r1.f28188h = r3
            r1.j = r3
            r1.k = r3
            r1.n = r3
            r1.m = r3
            r1.p = r3
            r1.o = r3
            r2 = 0
        L_0x01c6:
            com.travel.train.helper.n r4 = r1.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            int r4 = r4.size()
            if (r2 >= r4) goto L_0x028a
            com.travel.train.helper.n r4 = r1.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            java.lang.Object r4 = r4.get(r2)
            com.travel.train.model.trainticket.CJRPassengerInfo r4 = (com.travel.train.model.trainticket.CJRPassengerInfo) r4
            if (r4 == 0) goto L_0x0285
            java.lang.String r12 = r4.getmCategory()
            if (r12 == 0) goto L_0x0285
            java.lang.String r4 = r4.getmCategory()
            r12 = -1
            int r13 = r4.hashCode()
            r14 = 2085(0x825, float:2.922E-42)
            if (r13 == r14) goto L_0x0238
            r14 = 2092(0x82c, float:2.932E-42)
            if (r13 == r14) goto L_0x0230
            r14 = 2099(0x833, float:2.941E-42)
            if (r13 == r14) goto L_0x0228
            r14 = 2149(0x865, float:3.011E-42)
            if (r13 == r14) goto L_0x0220
            r14 = 2333(0x91d, float:3.269E-42)
            if (r13 == r14) goto L_0x0218
            r14 = 2650(0xa5a, float:3.713E-42)
            if (r13 == r14) goto L_0x0210
            r14 = 2660(0xa64, float:3.727E-42)
            if (r13 == r14) goto L_0x0208
            goto L_0x0240
        L_0x0208:
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0240
            r4 = 3
            goto L_0x0241
        L_0x0210:
            boolean r4 = r4.equals(r7)
            if (r4 == 0) goto L_0x0240
            r4 = 4
            goto L_0x0241
        L_0x0218:
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0240
            r4 = 5
            goto L_0x0241
        L_0x0220:
            boolean r4 = r4.equals(r10)
            if (r4 == 0) goto L_0x0240
            r4 = 0
            goto L_0x0241
        L_0x0228:
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0240
            r4 = 6
            goto L_0x0241
        L_0x0230:
            boolean r4 = r4.equals(r11)
            if (r4 == 0) goto L_0x0240
            r4 = 1
            goto L_0x0241
        L_0x0238:
            boolean r4 = r4.equals(r9)
            if (r4 == 0) goto L_0x0240
            r4 = 2
            goto L_0x0241
        L_0x0240:
            r4 = -1
        L_0x0241:
            switch(r4) {
                case 0: goto L_0x027e;
                case 1: goto L_0x0277;
                case 2: goto L_0x0270;
                case 3: goto L_0x0264;
                case 4: goto L_0x0258;
                case 5: goto L_0x0251;
                case 6: goto L_0x0245;
                default: goto L_0x0244;
            }
        L_0x0244:
            goto L_0x0285
        L_0x0245:
            int r4 = r1.o
            r12 = 1
            int r4 = r4 + r12
            r1.o = r4
            int r4 = r1.f28188h
            int r4 = r4 + r12
            r1.f28188h = r4
            goto L_0x0286
        L_0x0251:
            r12 = 1
            int r4 = r1.p
            int r4 = r4 + r12
            r1.p = r4
            goto L_0x0286
        L_0x0258:
            r12 = 1
            int r4 = r1.m
            int r4 = r4 + r12
            r1.m = r4
            int r4 = r1.f28188h
            int r4 = r4 + r12
            r1.f28188h = r4
            goto L_0x0286
        L_0x0264:
            r12 = 1
            int r4 = r1.n
            int r4 = r4 + r12
            r1.n = r4
            int r4 = r1.f28188h
            int r4 = r4 + r12
            r1.f28188h = r4
            goto L_0x0286
        L_0x0270:
            r12 = 1
            int r4 = r1.k
            int r4 = r4 + r12
            r1.k = r4
            goto L_0x0286
        L_0x0277:
            r12 = 1
            int r4 = r1.j
            int r4 = r4 + r12
            r1.j = r4
            goto L_0x0286
        L_0x027e:
            r12 = 1
            int r4 = r1.l
            int r4 = r4 + r12
            r1.l = r4
            goto L_0x0286
        L_0x0285:
            r12 = 1
        L_0x0286:
            int r2 = r2 + 1
            goto L_0x01c6
        L_0x028a:
            r2 = 0
            boolean r3 = r1.r
            if (r3 == 0) goto L_0x0340
            int r3 = r1.f28188h
            if (r3 <= 0) goto L_0x0340
            int r3 = r1.f28189i
            int r4 = r1.f28188h
            if (r3 == r4) goto L_0x0340
            int r3 = r1.m
            if (r3 <= 0) goto L_0x02ae
            int r3 = r1.n
            if (r3 <= 0) goto L_0x02ae
            int r3 = r1.o
            if (r3 <= 0) goto L_0x02ae
            android.content.Context r2 = r1.f28181a
            int r3 = com.travel.train.R.string.label_senior_citizen_message_for_male_and_female_and_transgender
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0307
        L_0x02ae:
            int r3 = r1.m
            if (r3 <= 0) goto L_0x02bf
            int r3 = r1.n
            if (r3 <= 0) goto L_0x02bf
            android.content.Context r2 = r1.f28181a
            int r3 = com.travel.train.R.string.label_senior_citizen_message_for_male_and_female
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0307
        L_0x02bf:
            int r3 = r1.m
            if (r3 <= 0) goto L_0x02d0
            int r3 = r1.o
            if (r3 <= 0) goto L_0x02d0
            android.content.Context r2 = r1.f28181a
            int r3 = com.travel.train.R.string.label_senior_citizen_message_for_male_and_transgender
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0307
        L_0x02d0:
            int r3 = r1.n
            if (r3 <= 0) goto L_0x02e1
            int r3 = r1.o
            if (r3 <= 0) goto L_0x02e1
            android.content.Context r2 = r1.f28181a
            int r3 = com.travel.train.R.string.label_senior_citizen_message_for_female_and_transgender
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0307
        L_0x02e1:
            int r3 = r1.m
            if (r3 <= 0) goto L_0x02ee
            android.content.Context r2 = r1.f28181a
            int r3 = com.travel.train.R.string.label_senior_citizen_message_for_male_only
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0307
        L_0x02ee:
            int r3 = r1.n
            if (r3 <= 0) goto L_0x02fb
            android.content.Context r2 = r1.f28181a
            int r3 = com.travel.train.R.string.label_senior_citizen_message_for_female_only
            java.lang.String r2 = r2.getString(r3)
            goto L_0x0307
        L_0x02fb:
            int r3 = r1.o
            if (r3 <= 0) goto L_0x0307
            android.content.Context r2 = r1.f28181a
            int r3 = com.travel.train.R.string.label_senior_citizen_message_for_transgender_only
            java.lang.String r2 = r2.getString(r3)
        L_0x0307:
            android.app.AlertDialog$Builder r3 = new android.app.AlertDialog$Builder
            android.content.Context r4 = r1.f28181a
            r3.<init>(r4)
            android.content.Context r4 = r1.f28181a
            int r5 = com.travel.train.R.string.senior_citizen_alert_title
            java.lang.String r4 = r4.getString(r5)
            r3.setTitle(r4)
            r3.setMessage(r2)
            android.content.Context r2 = r1.f28181a
            int r4 = com.travel.train.R.string.yes
            java.lang.String r2 = r2.getString(r4)
            com.travel.train.viewholder.o$2 r4 = new com.travel.train.viewholder.o$2
            r4.<init>()
            r3.setPositiveButton(r2, r4)
            android.content.Context r2 = r1.f28181a
            int r4 = com.travel.train.R.string.no
            java.lang.String r2 = r2.getString(r4)
            com.travel.train.viewholder.o$3 r4 = new com.travel.train.viewholder.o$3
            r4.<init>()
            r3.setNegativeButton(r2, r4)
            r3.show()
            return
        L_0x0340:
            com.travel.train.i.e r1 = r1.f28182b
            r1.m()
        L_0x0345:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ab.i():void");
    }

    public final void a(boolean z2) {
        if (z2) {
            this.H.a(this.f26731d);
        }
        this.U.a();
    }

    public final void j() {
        this.U.a();
    }

    public final void b(Double d2) {
        this.m = d2;
    }

    public final Double k() {
        return this.m;
    }

    public final void c(Double d2) {
        this.n = d2;
    }

    public final Double l() {
        return this.n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00eb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m() {
        /*
            r8 = this;
            java.lang.String r0 = r8.j
            java.lang.String r1 = "LD"
            boolean r0 = r0.equals(r1)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0030
            com.travel.train.viewholder.o r0 = r8.K
            int r3 = r0.j
            int r4 = r0.m
            int r3 = r3 + r4
            if (r3 <= 0) goto L_0x002c
            android.content.Context r3 = r0.f28181a
            android.content.Context r4 = r0.f28181a
            int r5 = com.travel.train.R.string.train_travellers_error
            java.lang.String r4 = r4.getString(r5)
            android.content.Context r0 = r0.f28181a
            int r5 = com.travel.train.R.string.ladies_quota_error
            java.lang.String r0 = r0.getString(r5)
            com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r0)
            r0 = 0
            goto L_0x002d
        L_0x002c:
            r0 = 1
        L_0x002d:
            if (r0 != 0) goto L_0x0030
            return
        L_0x0030:
            com.travel.train.viewholder.o r0 = r8.K
            int r3 = r0.l
            int r4 = r0.j
            int r3 = r3 + r4
            int r4 = r0.k
            int r3 = r3 + r4
            int r4 = r0.n
            int r3 = r3 + r4
            int r4 = r0.m
            int r3 = r3 + r4
            int r4 = r0.o
            int r3 = r3 + r4
            com.travel.train.helper.n r4 = r0.f28183c
            int r4 = r4.f27346h
            if (r3 <= r4) goto L_0x006c
            android.content.Context r3 = r0.f28181a
            android.content.Context r4 = r0.f28181a
            int r5 = com.travel.train.R.string.train_travellers_error
            java.lang.String r4 = r4.getString(r5)
            android.content.Context r5 = r0.f28181a
            int r6 = com.travel.train.R.string.maximum_number_of_passenger
            java.lang.Object[] r7 = new java.lang.Object[r1]
            com.travel.train.helper.n r0 = r0.f28183c
            int r0 = r0.f27346h
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r7[r2] = r0
            java.lang.String r0 = r5.getString(r6, r7)
            com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r4, (java.lang.String) r0)
            r0 = 0
            goto L_0x006d
        L_0x006c:
            r0 = 1
        L_0x006d:
            if (r0 != 0) goto L_0x0070
            return
        L_0x0070:
            com.travel.train.viewholder.o r0 = r8.K
            int r3 = r0.j
            int r4 = r0.k
            int r3 = r3 + r4
            int r4 = r0.n
            int r3 = r3 + r4
            int r4 = r0.m
            int r3 = r3 + r4
            int r4 = r0.o
            int r3 = r3 + r4
            java.lang.String r4 = "CH"
            if (r3 != 0) goto L_0x00e8
            int r3 = r0.l
            if (r3 <= 0) goto L_0x00e8
            com.travel.train.helper.n r3 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r3 = r3.l
            if (r3 == 0) goto L_0x00e8
            com.travel.train.helper.n r3 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r3 = r3.l
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x00e8
            boolean r3 = r0.q
            if (r3 != 0) goto L_0x00e8
            r3 = 0
        L_0x009d:
            com.travel.train.helper.n r5 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r5 = r5.l
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x00ce
            com.travel.train.helper.n r5 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r5 = r5.l
            java.lang.Object r5 = r5.get(r3)
            com.travel.train.model.trainticket.CJRPassengerInfo r5 = (com.travel.train.model.trainticket.CJRPassengerInfo) r5
            if (r5 == 0) goto L_0x00cb
            java.lang.String r6 = r5.getmCategory()
            if (r6 == 0) goto L_0x00cb
            java.lang.String r6 = r5.getmCategory()
            boolean r6 = r6.equalsIgnoreCase(r4)
            if (r6 == 0) goto L_0x00cb
            boolean r5 = r5.isIsBerthFlag()
            if (r5 == 0) goto L_0x00cb
            r3 = 1
            goto L_0x00cf
        L_0x00cb:
            int r3 = r3 + 1
            goto L_0x009d
        L_0x00ce:
            r3 = 0
        L_0x00cf:
            if (r3 != 0) goto L_0x00e8
            android.content.Context r3 = r0.f28181a
            android.content.Context r5 = r0.f28181a
            int r6 = com.travel.train.R.string.train_travellers_error
            java.lang.String r5 = r5.getString(r6)
            android.content.Context r0 = r0.f28181a
            int r6 = com.travel.train.R.string.seated_traveller_error
            java.lang.String r0 = r0.getString(r6)
            com.paytm.utility.b.b((android.content.Context) r3, (java.lang.String) r5, (java.lang.String) r0)
            r0 = 0
            goto L_0x00e9
        L_0x00e8:
            r0 = 1
        L_0x00e9:
            if (r0 != 0) goto L_0x00ec
            return
        L_0x00ec:
            com.travel.train.viewholder.o r0 = r8.K
            com.travel.train.helper.n r3 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r3 = r3.l
            if (r3 == 0) goto L_0x0171
            com.travel.train.helper.n r3 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r3 = r3.l
            int r3 = r3.size()
            if (r3 <= 0) goto L_0x0171
            r3 = 0
        L_0x00ff:
            com.travel.train.helper.n r5 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r5 = r5.l
            int r5 = r5.size()
            if (r3 >= r5) goto L_0x0171
            com.travel.train.helper.n r5 = r0.f28183c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r5 = r5.l
            java.lang.Object r5 = r5.get(r3)
            com.travel.train.model.trainticket.CJRPassengerInfo r5 = (com.travel.train.model.trainticket.CJRPassengerInfo) r5
            if (r5 == 0) goto L_0x016e
            java.lang.String r6 = r5.getmCategory()
            if (r6 == 0) goto L_0x016e
            java.lang.String r6 = r5.getmCategory()
            boolean r6 = r6.equalsIgnoreCase(r4)
            if (r6 == 0) goto L_0x016e
            boolean r5 = r5.isIsBerthFlag()
            if (r5 == 0) goto L_0x016e
            com.paytm.utility.h r3 = new com.paytm.utility.h
            android.content.Context r4 = r0.f28181a
            r3.<init>(r4)
            r3.setCancelable(r2)
            android.content.Context r2 = r0.f28181a
            int r4 = com.travel.train.R.string.child_berth_choice_warning
            java.lang.String r2 = r2.getString(r4)
            r3.a(r2)
            r2 = -3
            android.content.Context r4 = r0.f28181a
            int r5 = com.travel.train.R.string.ok
            java.lang.String r4 = r4.getString(r5)
            com.travel.train.viewholder.o$1 r5 = new com.travel.train.viewholder.o$1
            r5.<init>(r3)
            r3.a(r2, r4, r5)
            r3.show()
            android.view.WindowManager$LayoutParams r0 = new android.view.WindowManager$LayoutParams
            r0.<init>()
            android.view.Window r2 = r3.getWindow()
            android.view.WindowManager$LayoutParams r3 = r2.getAttributes()
            r0.copyFrom(r3)
            r3 = -1
            r0.width = r3
            r3 = -2
            r0.height = r3
            r2.setAttributes(r0)
            goto L_0x0172
        L_0x016e:
            int r3 = r3 + 1
            goto L_0x00ff
        L_0x0171:
            r1 = 0
        L_0x0172:
            if (r1 != 0) goto L_0x0177
            r8.n()
        L_0x0177:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.ab.m():void");
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1 && i3 != 0) {
            return;
        }
        if (i2 == 111) {
            if (!intent.hasExtra("cart_applied_promo") || intent.getStringExtra("cart_applied_promo") == null) {
                this.P.a();
                return;
            }
            boolean booleanExtra = intent.getBooleanExtra("is_applied", true);
            String stringExtra = intent.getStringExtra("cart_applied_promo");
            String stringExtra2 = (!intent.hasExtra("offer_text") || intent.getStringExtra("offer_text") == null) ? "" : intent.getStringExtra("offer_text");
            com.travel.train.viewholder.g gVar = this.P;
            if (booleanExtra) {
                gVar.f28102g.setVisibility(0);
                gVar.f28100e = stringExtra;
                gVar.f28099d = stringExtra;
                gVar.a(gVar.f28101f, false);
                gVar.f28103h.setText(gVar.f28100e);
                if (!TextUtils.isEmpty(stringExtra2)) {
                    gVar.f28104i.setText(stringExtra2);
                }
                ScrollView scrollView = (ScrollView) gVar.itemView.findViewById(R.id.passenger_detail_scrollview);
                scrollView.post(new Runnable(scrollView) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ ScrollView f28110a;

                    {
                        this.f28110a = r2;
                    }

                    public final void run() {
                        this.f28110a.fullScroll(130);
                    }
                });
                return;
            }
            gVar.f28102g.setVisibility(8);
            gVar.f28100e = null;
            gVar.a(gVar.f28101f, true);
        } else if (i2 == 140) {
            if (intent != null) {
                ArrayList<CJRCountryCode> arrayList = (ArrayList) intent.getSerializableExtra("country_list");
                if (arrayList != null && arrayList.size() > 0) {
                    this.K.f28187g = arrayList;
                }
                CJRCountryCode cJRCountryCode = (CJRCountryCode) intent.getSerializableExtra("selected_country");
                if (cJRCountryCode != null) {
                    this.K.f28183c.a(cJRCountryCode);
                }
            }
        } else if (i2 == 3 && com.travel.train.j.e.a((Context) getActivity())) {
            this.B.a();
        }
    }

    public final void n() {
        if (this.f26731d.getTrainPreferences() == null || this.f26731d.getMessage() == null || !this.f26731d.getMessage().isTravellerMessageEnable()) {
            o();
            return;
        }
        final com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
        hVar.setCancelable(false);
        hVar.a(this.f26731d.getMessage().getTravellerMessage());
        hVar.a(-3, getActivity().getString(R.string.ok), new View.OnClickListener() {
            public final void onClick(View view) {
                ab.this.o();
                hVar.cancel();
            }
        });
        hVar.show();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        Window window = hVar.getWindow();
        layoutParams.copyFrom(window.getAttributes());
        layoutParams.width = -1;
        layoutParams.height = -2;
        window.setAttributes(layoutParams);
    }

    public final void o() {
        this.L.f28087b = 0.0d;
        this.M.f28151c = 0.0d;
        this.n = Double.valueOf(0.0d);
        this.O.f28064c.removeAllViews();
        if (this.x) {
            CJRTrainDetailsBody cJRTrainDetailsBody = this.f26731d;
            if (cJRTrainDetailsBody != null) {
                cJRTrainDetailsBody.setPassengerInfo(this.K.f28183c.l);
                this.H.a(this.f26731d);
            } else {
                return;
            }
        }
        v();
    }

    private void v() {
        com.travel.train.k.f fVar;
        if (!TextUtils.isEmpty(this.o) && (fVar = this.f26730c) != null && this.C != null) {
            fVar.a(com.travel.train.j.n.a(getContext(), this.o), this.C.a(this.f26732e, this.v), this.C.a(this.f26731d, this.f26732e, this.f26733f));
        }
    }

    public final void p() {
        if (this.F.getVisibility() == 0) {
            s();
            return;
        }
        this.U.a(true);
        this.F.setVisibility(0);
        this.D.setVisibility(0);
        this.D.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.anim_flight_bottom_to_top_above_tab));
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putBoolean("is_cancel_checked", this.N.a());
        bundle.putBoolean("is_insurance_checked", this.u);
        bundle.putSerializable("train_booking_details", this.l);
        bundle.putSerializable("train_fare_details", this.r);
        bundle.putDouble("final_amount", this.n.doubleValue());
        bundle.putInt("grand_total_key", this.q);
        bundle.putDouble("gate_way_charge", this.L.f28087b);
        bundle.putDouble("service_way_charge", this.M.f28151c);
        cVar.setArguments(bundle);
        androidx.fragment.app.q a2 = getChildFragmentManager().a();
        a2.b(R.id.frame_fare_rules, cVar, this.f26729b);
        a2.b();
    }

    public final void q() {
        this.D.setVisibility(8);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_flight_bottom_to_top_above_tab_close);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                ab.this.F.setVisibility(8);
            }
        });
        this.D.setAnimation(loadAnimation);
    }

    /* access modifiers changed from: package-private */
    public final void a(CJRTrainVerifyCheckout cJRTrainVerifyCheckout) {
        String str;
        CJRTrainBooking cJRTrainBooking = this.l;
        if (cJRTrainBooking == null || cJRTrainBooking.getmConfirmation() == null || this.l.getmConfirmation().getmTransactionId() == null || cJRTrainVerifyCheckout == null) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.some_went_wrong), getString(R.string.error_try_again));
            return;
        }
        Intent intent = new Intent();
        boolean z2 = false;
        if (this.l.getmConfirmation().isDeferredCheckout().booleanValue()) {
            PaytmSDK.parseAndSetInstruments(cJRTrainVerifyCheckout.getPaymentInstruments());
            if (cJRTrainVerifyCheckout.getPayment().isNativeEnabled() == "1") {
                z2 = true;
            }
            intent.putExtra("nativeSdkEnabled", z2);
            intent.putExtra("merchant_id", cJRTrainVerifyCheckout.getPayment().getMID());
            intent.putExtra(SDKConstants.PAYMENT_INFO, cJRTrainVerifyCheckout.getPayment());
            CJRRechargePayment payment = cJRTrainVerifyCheckout.getPayment();
            if (payment.getmPGParams() == null || !payment.getmPGParams().containsKey("TXN_AMOUNT")) {
                str = payment.getTxnAmount();
            } else {
                str = String.valueOf(payment.getmPGParams().get("TXN_AMOUNT"));
            }
            intent.putExtra("price", str);
            intent.putExtra("from_train_module", true);
            intent.putExtra("is_train_ticket", true);
            intent.putExtra("is_deferred_checkout_train", true);
            intent.putExtra("isDeferredCheckoutEnable", true);
            intent.putExtra("wallet_token", this.o);
            intent.putExtra("requestid", this.f26734g);
            intent.putExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.l.getmConfirmation().getmTransactionId());
            intent.putExtra("vertical_name", a.c.TRAIN);
            ArrayList arrayList = new ArrayList();
            this.B.a(arrayList, this.l, this.L.f28087b, this.M.f28151c);
            intent.putExtra("train_fare_details", arrayList);
            intent.putExtra("grand_total_key", this.q);
            if (!(com.travel.train.j.g.f27551a == null || com.travel.train.j.g.f27551a.getTestId() == null)) {
                intent.putExtra("test_id", com.travel.train.j.g.f27551a.getTestId().toString());
            }
        } else {
            intent.putExtra(SDKConstants.PAYMENT_INFO, cJRTrainVerifyCheckout.getPayment());
            intent.putExtra("from_train_module", true);
            intent.putExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST_TRANSACTION_ID, this.l.getmConfirmation().getmTransactionId());
            intent.putExtra("is_train_ticket", true);
            intent.putExtra("is_deferred_checkout_train", false);
            intent.putExtra("vertical_name", a.c.TRAIN);
            CJRRechargePayment payment2 = cJRTrainVerifyCheckout.getPayment();
            String str2 = null;
            if (payment2.getmPGParams() != null && payment2.getmPGParams().containsKey("TXN_AMOUNT")) {
                str2 = String.valueOf(payment2.getmPGParams().get("TXN_AMOUNT"));
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("price", str2);
            }
        }
        com.travel.train.b.a();
        com.travel.train.b.b().a(cJRTrainVerifyCheckout.getPayment(), intent);
        com.travel.train.b.a();
        com.travel.train.b.b().d(getActivity(), intent);
    }

    public final void r() {
        Intent intent = new Intent(getActivity(), AJRTrainOffersListActivity.class);
        intent.putExtra("request_id", this.f26734g);
        intent.putExtra("offers", this.P.f28099d);
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f26732e;
        if (cJRTrainSearchResultsTrain != null) {
            intent.putExtra("intent_extra_origin_city_list", cJRTrainSearchResultsTrain.getSourceName());
            intent.putExtra("destination_city", this.f26732e.getDestinationName());
        }
        intent.putExtra(Utility.EVENT_CATEGORY_PROMOCODE, this.P.f28099d);
        startActivityForResult(intent, 111);
    }

    public final void a(String str, String str2) {
        Intent intent = new Intent(getActivity(), AJREmbedWebView.class);
        intent.putExtra("url", str2);
        intent.putExtra(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, str);
        startActivity(intent);
    }

    public final void b() {
        this.f26732e.setMirctcuserid(com.paytm.utility.b.W((Context) getActivity()));
        this.B.a();
    }

    public final void s() {
        this.U.a(false);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_flight_bottom_to_top_above_tab_close);
        this.D.setVisibility(8);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                ab.this.F.setVisibility(8);
            }

            public final void onAnimationEnd(Animation animation) {
                if (ab.this.getChildFragmentManager() != null) {
                    androidx.fragment.app.q a2 = ab.this.getChildFragmentManager().a();
                    a2.a(ab.this.getChildFragmentManager().c(R.id.frame_fare_rules));
                    a2.c();
                }
            }
        });
        this.D.setAnimation(loadAnimation);
    }

    public void onDestroyView() {
        super.onDestroyView();
        m mVar = this.G;
        if (mVar.f28163e != null) {
            mVar.f28163e.cancel();
        }
    }

    public final void t() {
        Intent intent = new Intent(getActivity(), AJRSelectCountryActivity.class);
        intent.putExtra("country_list", this.K.f28187g);
        intent.putExtra("sign_up", false);
        startActivityForResult(intent, 140);
    }

    public boolean onBackPressed() {
        Fragment c2 = getChildFragmentManager().c(this.f26729b);
        if (c2 != null && (c2 instanceof c)) {
            ((c) c2).onBackPressed();
            return true;
        } else if (!this.y) {
            return false;
        } else {
            Intent intent = new Intent();
            intent.putExtra("intent_extre_changed_passenger", this.K.f28183c.l);
            if (this.H.f28218a.getVisibility() == 0) {
                intent.putExtra("intent_is_additional_pref_present", true);
                intent.putExtra("intent_extra_auto_upgrade", this.H.c());
                intent.putExtra("intent_extra_coach_number", TextUtils.isEmpty(this.H.b()) ? "" : this.H.b());
                intent.putExtra("intent_extre_reservation_choice", this.H.f28221d);
            }
            getActivity().setResult(555, intent);
            return false;
        }
    }

    public void onResume() {
        super.onResume();
        System.out.println("FJR Review iternary page: onResume");
        if (this.A) {
            this.A = false;
            o();
        }
    }
}
