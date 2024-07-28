package com.travel.train.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.activity.AJRSelectCountryActivity;
import com.travel.train.activity.AJRTrainGSTView;
import com.travel.train.activity.AJRTrainReviewItineraryActivity;
import com.travel.train.b.as;
import com.travel.train.helper.i;
import com.travel.train.helper.l;
import com.travel.train.i.aj;
import com.travel.train.i.d;
import com.travel.train.i.g;
import com.travel.train.j.b;
import com.travel.train.j.o;
import com.travel.train.k.f;
import com.travel.train.k.g;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.e;
import com.travel.train.model.trainticket.CJRCountryCode;
import com.travel.train.model.trainticket.CJRPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainAvailability;
import com.travel.train.model.trainticket.CJRTrainBooking;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTrainGstDetails;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.travellerProfile.model.CJRTpUserProfile;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import com.travel.train.viewholder.aa;
import com.travel.train.viewholder.s;
import com.travel.train.viewholder.t;
import com.travel.train.viewholder.u;
import com.travel.train.viewholder.v;
import com.travel.train.viewholder.w;
import com.travel.train.viewholder.x;
import com.travel.train.viewholder.z;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.entity.CJRPGTokenList;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class y extends am implements View.OnClickListener, d, g, b.C0491b {
    private LinearLayout A;
    private ImageView B;
    private ImageView C;
    private ImageView D;
    private ImageView E;
    private ImageView F;
    private ScrollView G;
    private EditText H;
    private TextView I;
    private TextView J;
    private TextView K;
    private boolean L = false;
    private Integer M;
    private boolean N = false;
    private aa O;
    private t P;
    private t Q;
    private s R;
    private x S;
    private w T;
    private u U;
    private v V;
    private com.travel.train.viewholder.y W;
    private String X;
    private l Y;
    private f Z;

    /* renamed from: a  reason: collision with root package name */
    public z f27224a;
    private String aa;
    private TextView ab;
    /* access modifiers changed from: private */
    public int ac = 295;
    /* access modifiers changed from: private */
    public boolean ad = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public i f27225b;

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainSearchResultsTrain f27226c;

    /* renamed from: d  reason: collision with root package name */
    private CJRTrainDetailsBody f27227d;

    /* renamed from: e  reason: collision with root package name */
    private CJRTrainAvailability f27228e;

    /* renamed from: f  reason: collision with root package name */
    private b f27229f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<CJRPassengerInfo> f27230g = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJRTrainSearchInput f27231h;

    /* renamed from: i  reason: collision with root package name */
    private CJRTrainGstDetails f27232i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n = "";
    private String o = "";
    private boolean p;
    private boolean q;
    private String r;
    private boolean s;
    private boolean t;
    private Button u;
    private RelativeLayout v;
    /* access modifiers changed from: private */
    public Dialog w;
    /* access modifiers changed from: private */
    public RoboTextView x;
    /* access modifiers changed from: private */
    public RadioButton y;
    /* access modifiers changed from: private */
    public RadioButton z;

    public interface a {
        void a(String str);
    }

    public final void a(boolean z2) {
    }

    public final void c() {
    }

    public final /* synthetic */ Activity e() {
        return super.getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.pre_t_passenger_detail_fragment, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        CJRTrainDetailsBody cJRTrainDetailsBody;
        super.onActivityCreated(bundle);
        this.Z = (f) am.a((Fragment) this, (al.b) new com.travel.train.k.g(new g.a(g.b.REVIEWITINERARY).a(com.travel.train.a.a.a((com.travel.train.a.a.b) new com.travel.train.a.a.a(getActivity()))))).a(f.class);
        this.Z.f27659a.observe(this, new androidx.lifecycle.z<CJRTrainBooking>() {
            public final /* synthetic */ void onChanged(Object obj) {
                y.a(y.this, (CJRTrainBooking) obj);
            }
        });
        this.Z.f27661c.observe(this, new androidx.lifecycle.z<e>() {
            public final /* synthetic */ void onChanged(Object obj) {
                e eVar = (e) obj;
                if (eVar != null) {
                    y.this.f27225b.handleErrorCode(eVar.f27696a, eVar.f27697b, eVar.f27698c);
                }
            }
        });
        if (getArguments() != null) {
            if (getArguments().containsKey("action_bar_height") && getArguments().getInt("action_bar_height") > 0) {
                this.ac = getArguments().getInt("action_bar_height");
            }
            if (getArguments().containsKey("chosenDate")) {
                this.aa = getArguments().getString("chosenDate");
            }
            if (getArguments().containsKey("train_detail_body")) {
                this.f27227d = (CJRTrainDetailsBody) getArguments().getSerializable("train_detail_body");
                if (this.f27227d.getmTrainAvailability() != null && this.f27227d.getmTrainAvailability().size() > 0) {
                    this.f27228e = this.f27227d.getmTrainAvailability().get(this.f27227d.getMiSelectedPosition());
                }
            }
            if (getArguments().containsKey("train_detail")) {
                this.f27226c = (CJRTrainSearchResultsTrain) getArguments().getSerializable("train_detail");
            }
            if (getArguments().containsKey("is_from_alternative_click")) {
                this.L = ((Boolean) getArguments().getSerializable("is_from_alternative_click")).booleanValue();
            }
            if (getArguments().containsKey("alternate_boarding_station_position")) {
                this.M = (Integer) getArguments().getSerializable("alternate_boarding_station_position");
            }
            if (getArguments().containsKey("request_id")) {
                this.j = getArguments().getString("request_id");
            }
            if (getArguments().containsKey("train_class_code")) {
                this.k = getArguments().getString("train_class_code");
            }
            if (getArguments().containsKey("train_class_details")) {
                this.l = getArguments().getString("train_class_details");
            }
            if (getArguments().containsKey("intent_extra_train_search_input")) {
                this.f27231h = (CJRTrainSearchInput) getArguments().getSerializable("intent_extra_train_search_input");
            }
            if (getArguments().containsKey("quota")) {
                this.m = getArguments().getString("quota");
            }
            if (getArguments().containsKey("minsuranceAlwaysTrue")) {
                this.p = getArguments().getBoolean("minsuranceAlwaysTrue", false);
            }
            if (getArguments().containsKey("minsuranceOption")) {
                this.q = getArguments().getBoolean("minsuranceOption", false);
            }
            if (getArguments().containsKey("waiting_list")) {
                this.t = getArguments().getBoolean("waiting_list", false);
            }
            if (getArguments().containsKey("is_from_quick_book")) {
                this.N = getArguments().getBoolean("is_from_quick_book", false);
            }
        }
        this.f27225b = new i(this, this.f27231h);
        CJRTrainSearchInput cJRTrainSearchInput = this.f27231h;
        CJRTrainGstDetails cJRTrainGstDetails = new CJRTrainGstDetails();
        cJRTrainGstDetails.setGstIn(cJRTrainSearchInput.getmGSTINNumber());
        cJRTrainGstDetails.setNameOnGst(cJRTrainSearchInput.getmGSTName());
        cJRTrainGstDetails.setFlat(cJRTrainSearchInput.getmGSTFlat());
        cJRTrainGstDetails.setStreet(cJRTrainSearchInput.getmGSTStreet());
        cJRTrainGstDetails.setPin(cJRTrainSearchInput.getmGSTPinCode());
        cJRTrainGstDetails.setState(cJRTrainSearchInput.getmGSTState());
        cJRTrainGstDetails.setCity(cJRTrainSearchInput.getmGSTCity());
        this.f27232i = cJRTrainGstDetails;
        View view = getView();
        this.G = (ScrollView) view.findViewById(R.id.traveller_scroll_view);
        this.O = new aa(view, this);
        View view2 = view;
        this.P = new t(view2, this, this.f27225b, this.f27227d, this.f27226c, false);
        this.f27224a = new z(view2, this, this.f27225b, this.f27227d, this.f27231h);
        this.R = new s(view2, this, this.f27227d, this.t, false);
        this.S = new x(view2, this, this.f27225b, this.f27227d, this.p, this.q, this.f27231h);
        this.T = new w(view2, this, this.f27225b, this.f27227d.isGst_enabled(), this.f27232i);
        this.U = new u(view);
        CJRTrainDetailsBody cJRTrainDetailsBody2 = this.f27227d;
        cJRTrainDetailsBody2.setmIsAddressCapture(cJRTrainDetailsBody2.getTrainConfig() != null && com.travel.train.j.g.Z.equals(this.f27227d.getTrainConfig().getCaptureAddress()));
        this.V = new v(view, this.f27227d.ismIsAddressCapture(), this.f27227d.getCovidInstructon());
        this.W = new com.travel.train.viewholder.y(view, this, this.f27227d, this.f27226c, this.k, this.m, this.f27225b);
        this.u = (Button) view.findViewById(R.id.detail_detail_proceed_button);
        this.u.setOnClickListener(this);
        try {
            getContext();
            if (!com.paytm.utility.b.d(this.f27231h.getmDate(), "dd MMM yy, EEE", "EEE, dd MMM").equalsIgnoreCase(this.aa) && !this.L) {
                Dialog dialog = new Dialog(getContext());
                dialog.requestWindowFeature(1);
                View inflate = getActivity().getLayoutInflater().inflate(R.layout.pre_t_train_travel_date_alert_lyt, (ViewGroup) null);
                this.Q = new t(inflate, this, this.f27225b, this.f27227d, this.f27226c, true);
                inflate.findViewById(R.id.divider).setVisibility(8);
                inflate.findViewById(R.id.boarding_station_divider).setVisibility(8);
                this.ab = (TextView) inflate.findViewById(R.id.message_date_text);
                b(0);
                this.ac += com.paytm.utility.b.a(20.0f, getContext());
                final RelativeLayout relativeLayout = (RelativeLayout) getView().findViewById(R.id.user_id_container);
                final boolean[] zArr = {false};
                final Dialog dialog2 = dialog;
                final View view3 = inflate;
                relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public final void onGlobalLayout() {
                        if (!y.this.ad) {
                            int measuredHeight = relativeLayout.getMeasuredHeight();
                            if (!zArr[0]) {
                                y yVar = y.this;
                                int unused = yVar.ac = yVar.ac + measuredHeight;
                            }
                            zArr[0] = true;
                            dialog2.setContentView(view3);
                            dialog2.show();
                            Window window = dialog2.getWindow();
                            window.setGravity(48);
                            WindowManager.LayoutParams attributes = window.getAttributes();
                            attributes.x = 0;
                            attributes.y = y.this.ac;
                            attributes.width = -1;
                            attributes.height = -2;
                            window.setAttributes(attributes);
                            window.setBackgroundDrawable((Drawable) null);
                        }
                    }
                });
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public final void onDismiss(DialogInterface dialogInterface) {
                        boolean unused = y.this.ad = true;
                    }
                });
            }
        } catch (Exception unused) {
        }
        this.P.a();
        t tVar = this.Q;
        if (tVar != null) {
            tVar.a();
        }
        if (this.L && this.M.intValue() != -1) {
            this.P.a(this.M.intValue());
            t tVar2 = this.Q;
            if (tVar2 != null) {
                tVar2.a(this.M.intValue());
            }
        }
        o.a((Activity) getActivity());
        if (!this.N || (cJRTrainDetailsBody = this.f27227d) == null || cJRTrainDetailsBody.getPassengerInfo() == null || this.f27227d.getPassengerInfo().size() <= 0) {
            this.f27224a.a(false);
        } else {
            this.f27230g = this.f27227d.getPassengerInfo();
            this.f27224a.a(this.f27230g);
            this.R.a(this.f27227d.getAutoUpgrade(), this.f27227d.getCoachNumber(), "");
        }
        com.travel.train.b.a();
        this.s = com.travel.train.b.b().x();
        this.s = true;
        if (com.paytm.utility.b.r((Context) getActivity()) && this.s) {
            this.f27225b.a();
        }
        com.travel.train.b.a();
        com.travel.train.b.b().a("/trains/traveller-details", "Trains", (Context) getActivity());
    }

    private void b(int i2) {
        CJRTrainDetailsBody cJRTrainDetailsBody = this.f27227d;
        if (cJRTrainDetailsBody == null || cJRTrainDetailsBody.getFormattedBoardingStation() == null) {
            this.ab.setText(b(this.f27227d.getBoardingStation().get(i2).split("-")[1] + "-" + this.f27227d.getBoardingStation().get(i2).split("-")[0], this.aa.split(AppConstants.COMMA)[0] + " " + this.aa.split(AppConstants.COMMA)[1] + ", " + this.f27227d.getBoardingDetail().get(0).getDepartureTime()));
            return;
        }
        String str = this.f27227d.getFormattedBoardingStation().split(AppConstants.COMMA)[0];
        StringBuilder sb = new StringBuilder();
        sb.append(this.f27227d.getFormattedBoardingStation().split(AppConstants.COMMA)[1]);
        if (this.f27227d.getFormattedBoardingStation().split(AppConstants.COMMA).length >= 3) {
            sb.append(", " + this.f27227d.getFormattedBoardingStation().split(AppConstants.COMMA)[2]);
        }
        this.ab.setText(b(str, sb.toString()));
    }

    private SpannableStringBuilder b(String str, String str2) {
        String string = getContext().getResources().getString(R.string.train_date_change_notify_expand_msg, new Object[]{str, str2});
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
        spannableStringBuilder.setSpan(new StyleSpan(1), string.indexOf(str), string.indexOf(str) + str.length(), 33);
        spannableStringBuilder.setSpan(new StyleSpan(1), string.indexOf(str2), string.indexOf(str2) + str2.length(), 33);
        return spannableStringBuilder;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ed A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r17, java.lang.String r18) {
        /*
            r16 = this;
            r0 = r16
            java.lang.String r1 = r0.m
            java.lang.String r2 = "LD"
            boolean r1 = r1.equals(r2)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0032
            com.travel.train.viewholder.z r1 = r0.f27224a
            int r4 = r1.j
            int r5 = r1.m
            int r4 = r4 + r5
            if (r4 <= 0) goto L_0x002e
            android.content.Context r4 = r1.f28300a
            android.content.Context r5 = r1.f28300a
            int r6 = com.travel.train.R.string.train_travellers_error
            java.lang.String r5 = r5.getString(r6)
            android.content.Context r1 = r1.f28300a
            int r6 = com.travel.train.R.string.ladies_quota_error
            java.lang.String r1 = r1.getString(r6)
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r1)
            r1 = 0
            goto L_0x002f
        L_0x002e:
            r1 = 1
        L_0x002f:
            if (r1 != 0) goto L_0x0032
            return
        L_0x0032:
            com.travel.train.viewholder.z r1 = r0.f27224a
            int r4 = r1.l
            int r5 = r1.j
            int r4 = r4 + r5
            int r5 = r1.k
            int r4 = r4 + r5
            int r5 = r1.n
            int r4 = r4 + r5
            int r5 = r1.m
            int r4 = r4 + r5
            int r5 = r1.o
            int r4 = r4 + r5
            com.travel.train.helper.n r5 = r1.f28302c
            int r5 = r5.f27346h
            if (r4 <= r5) goto L_0x006e
            android.content.Context r4 = r1.f28300a
            android.content.Context r5 = r1.f28300a
            int r6 = com.travel.train.R.string.train_travellers_error
            java.lang.String r5 = r5.getString(r6)
            android.content.Context r6 = r1.f28300a
            int r7 = com.travel.train.R.string.maximum_number_of_passenger
            java.lang.Object[] r8 = new java.lang.Object[r2]
            com.travel.train.helper.n r1 = r1.f28302c
            int r1 = r1.f27346h
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r8[r3] = r1
            java.lang.String r1 = r6.getString(r7, r8)
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r1)
            r1 = 0
            goto L_0x006f
        L_0x006e:
            r1 = 1
        L_0x006f:
            if (r1 != 0) goto L_0x0072
            return
        L_0x0072:
            com.travel.train.viewholder.z r1 = r0.f27224a
            int r4 = r1.j
            int r5 = r1.k
            int r4 = r4 + r5
            int r5 = r1.n
            int r4 = r4 + r5
            int r5 = r1.m
            int r4 = r4 + r5
            int r5 = r1.o
            int r4 = r4 + r5
            if (r4 != 0) goto L_0x00ea
            int r4 = r1.l
            if (r4 <= 0) goto L_0x00ea
            com.travel.train.helper.n r4 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            if (r4 == 0) goto L_0x00ea
            com.travel.train.helper.n r4 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x00ea
            boolean r4 = r1.q
            if (r4 != 0) goto L_0x00ea
            r4 = 0
        L_0x009d:
            com.travel.train.helper.n r5 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r5 = r5.l
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x00d0
            com.travel.train.helper.n r5 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r5 = r5.l
            java.lang.Object r5 = r5.get(r4)
            com.travel.train.model.trainticket.CJRPassengerInfo r5 = (com.travel.train.model.trainticket.CJRPassengerInfo) r5
            if (r5 == 0) goto L_0x00cd
            java.lang.String r6 = r5.getmCategory()
            if (r6 == 0) goto L_0x00cd
            java.lang.String r6 = r5.getmCategory()
            java.lang.String r7 = "CH"
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x00cd
            boolean r5 = r5.isIsBerthFlag()
            if (r5 == 0) goto L_0x00cd
            r4 = 1
            goto L_0x00d1
        L_0x00cd:
            int r4 = r4 + 1
            goto L_0x009d
        L_0x00d0:
            r4 = 0
        L_0x00d1:
            if (r4 != 0) goto L_0x00ea
            android.content.Context r4 = r1.f28300a
            android.content.Context r5 = r1.f28300a
            int r6 = com.travel.train.R.string.train_travellers_error
            java.lang.String r5 = r5.getString(r6)
            android.content.Context r1 = r1.f28300a
            int r6 = com.travel.train.R.string.seated_traveller_error
            java.lang.String r1 = r1.getString(r6)
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r1)
            r1 = 0
            goto L_0x00eb
        L_0x00ea:
            r1 = 1
        L_0x00eb:
            if (r1 != 0) goto L_0x00ee
            return
        L_0x00ee:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r4 = "train_traveller_age"
            r5 = r17
            r1.put(r4, r5)
            java.lang.String r4 = r0.n
            java.lang.String r5 = "train_travellers_gender"
            r1.put(r5, r4)
            java.lang.String r4 = r0.o
            java.lang.String r5 = "train_traveller_nationality"
            r1.put(r5, r4)
            com.travel.train.viewholder.z r4 = r0.f27224a
            com.travel.train.helper.n r4 = r4.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "train_travellers_number"
            r1.put(r5, r4)
            java.lang.String r4 = "train_berth_preference"
            r5 = r18
            r1.put(r4, r5)
            com.travel.train.helper.i r4 = r0.f27225b
            java.lang.String r5 = r4.b()
            java.lang.String r6 = "train_traveller_details_proceed_to_book_clicked"
            r4.a((java.lang.String) r6, (java.lang.String) r5, (java.util.HashMap<java.lang.String, java.lang.Object>) r1)
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r1 = com.travel.train.j.g.f27551a
            if (r1 == 0) goto L_0x013e
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r1 = com.travel.train.j.g.f27551a
            boolean r1 = r1.isBookingInstructionEnable()
            goto L_0x013f
        L_0x013e:
            r1 = 0
        L_0x013f:
            java.lang.String r4 = r16.f()
            if (r4 == 0) goto L_0x0158
            java.lang.String r4 = r16.f()
            java.lang.String r4 = r4.trim()
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0158
            java.lang.String r4 = r16.f()
            goto L_0x015a
        L_0x0158:
            java.lang.String r4 = "null"
        L_0x015a:
            r0.r = r4
            java.lang.String r4 = r0.r
            java.lang.String r5 = "Y"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 != 0) goto L_0x017a
            java.lang.String r4 = r0.r
            r5 = 0
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x0170
            goto L_0x017a
        L_0x0170:
            if (r1 == 0) goto L_0x0176
            r0.b((boolean) r3)
            goto L_0x017d
        L_0x0176:
            r16.g()
            goto L_0x017d
        L_0x017a:
            r0.b((boolean) r2)
        L_0x017d:
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            androidx.fragment.app.FragmentActivity r14 = r16.getActivity()
            r15 = 0
            java.lang.String r5 = "train_traveller_details"
            java.lang.String r12 = "contact_details_entered"
            java.lang.String r13 = "/trains/traveller-details"
            com.travel.train.j.o.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.y.a(java.lang.String, java.lang.String):void");
    }

    private String f() {
        return com.travel.train.j.w.a(getActivity().getApplicationContext()).b("new_user_flag", "", false);
    }

    private void b(boolean z2) {
        this.w = new Dialog(getActivity());
        this.w.requestWindowFeature(1);
        View inflate = getLayoutInflater().inflate(R.layout.pre_t_passneger_detail_dialog_lyt, (ViewGroup) null);
        this.w.setContentView(inflate);
        a(inflate);
        Window window = this.w.getWindow();
        window.setLayout(-1, -1);
        window.setGravity(80);
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (!z2) {
            this.A.setVisibility(8);
            this.v.setVisibility(0);
            this.H.setText(com.paytm.utility.b.W((Context) getActivity()));
            this.H.setSelection(com.paytm.utility.b.W((Context) getActivity()).length());
        } else {
            ((TextView) inflate.findViewById(R.id.irctc_heading)).setText(R.string.whats_next);
        }
        this.w.show();
    }

    private void a(View view) {
        ((ImageView) view.findViewById(R.id.dialog_close)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                y.this.w.dismiss();
            }
        });
        this.x = (RoboTextView) view.findViewById(R.id.detail_dialog_proceed_btn);
        this.y = (RadioButton) view.findViewById(R.id.password_remember_radio);
        this.z = (RadioButton) view.findViewById(R.id.password_not_remember_radio);
        this.H = (EditText) view.findViewById(R.id.irctc_user_id);
        this.v = (RelativeLayout) view.findViewById(R.id.userIdLyt);
        this.F = (ImageView) view.findViewById(R.id.success_icon);
        ResourceUtils.loadTrainImagesFromCDN(this.F, "success.png", false, true, n.a.V1);
        h();
        this.I = (TextView) view.findViewById(R.id.inst_payment);
        this.J = (TextView) view.findViewById(R.id.inst_login);
        this.K = (TextView) view.findViewById(R.id.inst_password);
        i();
        this.A = (LinearLayout) view.findViewById(R.id.instructionLL);
        this.B = (ImageView) view.findViewById(R.id.img_num_one);
        this.C = (ImageView) view.findViewById(R.id.irctc_userid_icon);
        this.D = (ImageView) view.findViewById(R.id.irctc_payment_icon);
        this.E = (ImageView) view.findViewById(R.id.irctc_password_icon);
        ResourceUtils.loadTrainImagesFromCDN(this.C, "irctc_userid.png", false, false, n.a.V1);
        ResourceUtils.loadTrainImagesFromCDN(this.D, "irctc_payment.png", false, false, n.a.V1);
        ResourceUtils.loadTrainImagesFromCDN(this.E, "irctc_password.png", false, false, n.a.V1);
        ((RadioGroup) view.findViewById(R.id.instruction_radio_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (i2 == R.id.password_remember_radio) {
                    y.this.y.setTextColor(androidx.core.content.b.c(y.this.getActivity(), R.color.flight_timings));
                    y.this.y.setChecked(true);
                    y.this.z.setTextColor(androidx.core.content.b.c(y.this.getActivity(), R.color.full_name_color));
                    y.this.z.setChecked(false);
                    y.this.x.setText(y.this.getString(R.string.continue_bookig));
                    if (y.this.f27231h != null) {
                        o.a("train_traveller_details", y.this.f27231h.getmSourceCityName(), y.this.f27231h.getmDestCityName(), y.this.f27231h.getmDate(), (String) null, (String) null, (String) null, "irctc_popup_i_remember_password", "/trains/traveller-details", y.this.getActivity(), (Map<String, Object>) null);
                    } else {
                        o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "irctc_popup_i_remember_password", "/trains/traveller-details", y.this.getActivity(), (Map<String, Object>) null);
                    }
                } else {
                    y.this.y.setTextColor(androidx.core.content.b.c(y.this.getActivity(), R.color.full_name_color));
                    y.this.y.setChecked(false);
                    y.this.z.setTextColor(androidx.core.content.b.c(y.this.getActivity(), R.color.flight_timings));
                    y.this.z.setChecked(true);
                    y.this.x.setText(y.this.getString(R.string.train_reset_password_text));
                    y.this.f27225b.a("train_traveller_details_irctc_popup_dont_remember_password", y.this.f27225b.b(), (HashMap<String, Object>) null);
                }
            }
        });
        this.x.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (y.this.x.getText().toString().equalsIgnoreCase(y.this.getString(R.string.continue_bookig))) {
                    y.this.g();
                } else if (y.this.x.getText().toString().equalsIgnoreCase(y.this.getString(R.string.train_reset_password_text))) {
                    y.this.f27225b.a(net.one97.paytm.common.utility.d.dj);
                    y.this.w.dismiss();
                    y.this.j();
                    y.l(y.this);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void g() {
        String str = "";
        String obj = (this.U.f28245a == null || this.U.f28245a.getText() == null) ? str : this.U.f28245a.getText().toString();
        if (!(this.U.f28246b == null || this.U.f28246b.getText() == null)) {
            str = this.U.f28246b.getText().toString();
        }
        c(obj, str);
        this.f27224a.i();
        Dialog dialog = this.w;
        if (dialog != null && dialog.isShowing()) {
            this.w.dismiss();
        }
    }

    private void c(String str, String str2) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            com.paytm.b.a.a a2 = com.travel.train.j.w.a(getActivity().getApplicationContext());
            if (!TextUtils.isEmpty(str)) {
                a2.a("registered_irctc_mobile_number", str, false);
            }
            if (!TextUtils.isEmpty(str2)) {
                a2.a("registered_irctc_email_id", str2, false);
            }
        }
    }

    public final void a() {
        Intent intent = new Intent(getActivity(), AJRTrainGSTView.class);
        intent.putExtra("train_gst_data", this.f27232i);
        intent.putExtra("is_from_quick_book", this.N);
        intent.putExtra("intent_extra_board_station", this.f27231h.getmSourceCityName());
        intent.putExtra("intent_extra_dest_station", this.f27231h.getmDestCityName());
        intent.putExtra("intent_extra_date", this.f27231h.getmDate());
        startActivityForResult(intent, 141);
    }

    public final void b() {
        aa aaVar = this.O;
        aaVar.f27750b.getParent().requestChildFocus(aaVar.f27750b, aaVar.f27750b);
        aaVar.f27751c.setText(com.paytm.utility.b.W(aaVar.f27749a));
        CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain = this.f27226c;
        if (cJRTrainSearchResultsTrain != null) {
            cJRTrainSearchResultsTrain.setMirctcuserid(com.paytm.utility.b.W((Context) getActivity()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:127:0x037f, code lost:
        r3 = r3.getText();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x044a, code lost:
        if (r1 == false) goto L_0x046b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0371  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x04aa  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0540  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x054c  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x055f  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x056b  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x0572  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0579  */
    /* JADX WARNING: Removed duplicated region for block: B:338:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x014a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r18) {
        /*
            r17 = this;
            r0 = r17
            int r1 = r18.getId()
            int r2 = com.travel.train.R.id.detail_detail_proceed_button
            if (r1 != r2) goto L_0x0675
            com.travel.train.viewholder.x r1 = r0.S
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0016
            java.lang.String r1 = r1.a()
            r9 = r1
            goto L_0x0017
        L_0x0016:
            r9 = r2
        L_0x0017:
            com.travel.train.helper.l r1 = new com.travel.train.helper.l
            androidx.fragment.app.FragmentActivity r4 = r17.getActivity()
            com.travel.train.model.trainticket.CJRTrainDetailsBody r5 = r0.f27227d
            java.lang.String r6 = r0.j
            java.lang.String r7 = r0.k
            boolean r8 = r0.L
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.Y = r1
            com.travel.train.model.CJRTrainSearchInput r1 = r0.f27231h
            if (r1 == 0) goto L_0x0051
            java.lang.String r4 = r1.getmSourceCityName()
            com.travel.train.model.CJRTrainSearchInput r1 = r0.f27231h
            java.lang.String r5 = r1.getmDestCityName()
            com.travel.train.model.CJRTrainSearchInput r1 = r0.f27231h
            java.lang.String r6 = r1.getmDate()
            r7 = 0
            r8 = 0
            r9 = 0
            androidx.fragment.app.FragmentActivity r12 = r17.getActivity()
            r13 = 0
            java.lang.String r3 = "train_traveller_details"
            java.lang.String r10 = "proceed_to_book"
            java.lang.String r11 = "/trains/traveller-details"
            com.travel.train.j.o.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
        L_0x0051:
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            com.travel.train.j.o.a((android.app.Activity) r1)
            r0.n = r2
            r0.o = r2
            com.travel.train.viewholder.z r1 = r0.f27224a
            r3 = 0
            r1.f28308i = r3
            com.travel.train.viewholder.t r1 = r0.P
            android.widget.Spinner r4 = r1.f28235c
            if (r4 == 0) goto L_0x007a
            android.widget.Spinner r4 = r1.f28235c
            java.lang.Object r4 = r4.getSelectedItem()
            if (r4 == 0) goto L_0x007a
            android.widget.Spinner r1 = r1.f28235c
            java.lang.Object r1 = r1.getSelectedItem()
            java.lang.String r1 = r1.toString()
            goto L_0x007b
        L_0x007a:
            r1 = r2
        L_0x007b:
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            java.lang.String r5 = "SW"
            java.lang.String r6 = "SM"
            java.lang.String r7 = "IF"
            java.lang.String r8 = "CH"
            java.lang.String r9 = "AT"
            java.lang.String r10 = "AM"
            java.lang.String r11 = "AF"
            if (r1 == 0) goto L_0x00a5
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            int r14 = com.travel.train.R.string.train_travellers_error
            java.lang.String r14 = r0.getString(r14)
            int r15 = com.travel.train.R.string.empty_boarding_station
            java.lang.String r15 = r0.getString(r15)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r14, (java.lang.String) r15)
        L_0x00a2:
            r12 = 3
            goto L_0x0494
        L_0x00a5:
            com.travel.train.viewholder.z r1 = r0.f27224a
            android.widget.LinearLayout r14 = r1.s
            if (r14 == 0) goto L_0x00f3
            r14 = 0
        L_0x00ac:
            android.widget.LinearLayout r15 = r1.s
            int r15 = r15.getChildCount()
            if (r14 >= r15) goto L_0x00f3
            android.widget.LinearLayout r15 = r1.s
            android.view.View r15 = r15.getChildAt(r14)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            int r12 = com.travel.train.R.id.passenger_type_radio
            android.view.View r12 = r15.findViewById(r12)
            android.widget.RadioGroup r12 = (android.widget.RadioGroup) r12
            int r4 = r12.getCheckedRadioButtonId()
            int r13 = com.travel.train.R.id.male_radio
            if (r4 != r13) goto L_0x00cf
            java.lang.String r4 = com.travel.train.j.g.V
            goto L_0x00e6
        L_0x00cf:
            int r4 = r12.getCheckedRadioButtonId()
            int r13 = com.travel.train.R.id.female_radio
            if (r4 != r13) goto L_0x00da
            java.lang.String r4 = com.travel.train.j.g.W
            goto L_0x00e6
        L_0x00da:
            int r4 = r12.getCheckedRadioButtonId()
            int r12 = com.travel.train.R.id.transgender_radio
            if (r4 != r12) goto L_0x00e5
            java.lang.String r4 = com.travel.train.j.g.X
            goto L_0x00e6
        L_0x00e5:
            r4 = r2
        L_0x00e6:
            com.travel.train.helper.n r12 = r1.f28302c
            boolean r4 = r12.a((int) r14, (android.view.View) r15, (java.lang.String) r4, (boolean) r3)
            if (r4 != 0) goto L_0x00f0
            r1 = 0
            goto L_0x00f4
        L_0x00f0:
            int r14 = r14 + 1
            goto L_0x00ac
        L_0x00f3:
            r1 = 1
        L_0x00f4:
            if (r1 != 0) goto L_0x00f7
        L_0x00f6:
            goto L_0x00a2
        L_0x00f7:
            com.travel.train.viewholder.z r1 = r0.f27224a
            android.widget.LinearLayout r4 = r1.t
            if (r4 == 0) goto L_0x0146
            r4 = 0
        L_0x00fe:
            android.widget.LinearLayout r12 = r1.t
            int r12 = r12.getChildCount()
            if (r4 >= r12) goto L_0x0146
            android.widget.LinearLayout r12 = r1.t
            android.view.View r12 = r12.getChildAt(r4)
            android.widget.RelativeLayout r12 = (android.widget.RelativeLayout) r12
            int r13 = com.travel.train.R.id.passenger_type_radio
            android.view.View r13 = r12.findViewById(r13)
            android.widget.RadioGroup r13 = (android.widget.RadioGroup) r13
            int r14 = r13.getCheckedRadioButtonId()
            int r15 = com.travel.train.R.id.male_radio
            if (r14 != r15) goto L_0x0121
            java.lang.String r13 = com.travel.train.j.g.V
            goto L_0x0138
        L_0x0121:
            int r14 = r13.getCheckedRadioButtonId()
            int r15 = com.travel.train.R.id.female_radio
            if (r14 != r15) goto L_0x012c
            java.lang.String r13 = com.travel.train.j.g.W
            goto L_0x0138
        L_0x012c:
            int r13 = r13.getCheckedRadioButtonId()
            int r14 = com.travel.train.R.id.transgender_radio
            if (r13 != r14) goto L_0x0137
            java.lang.String r13 = com.travel.train.j.g.X
            goto L_0x0138
        L_0x0137:
            r13 = r2
        L_0x0138:
            com.travel.train.helper.n r14 = r1.f28302c
            r15 = 1
            boolean r12 = r14.a((int) r4, (android.view.View) r12, (java.lang.String) r13, (boolean) r15)
            if (r12 != 0) goto L_0x0143
            r1 = 0
            goto L_0x0147
        L_0x0143:
            int r4 = r4 + 1
            goto L_0x00fe
        L_0x0146:
            r1 = 1
        L_0x0147:
            if (r1 != 0) goto L_0x014a
            goto L_0x00f6
        L_0x014a:
            com.travel.train.viewholder.z r1 = r0.f27224a
            com.travel.train.helper.n r4 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            if (r4 == 0) goto L_0x0230
            com.travel.train.helper.n r4 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r4 = r4.l
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x0230
            r4 = 0
        L_0x015d:
            com.travel.train.helper.n r12 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r12 = r12.l
            int r12 = r12.size()
            if (r4 >= r12) goto L_0x01ba
            com.travel.train.helper.n r12 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r12 = r12.l
            java.lang.Object r12 = r12.get(r4)
            com.travel.train.model.trainticket.CJRPassengerInfo r12 = (com.travel.train.model.trainticket.CJRPassengerInfo) r12
            if (r12 == 0) goto L_0x01b7
            java.lang.String r13 = r12.getmCategory()
            if (r13 == 0) goto L_0x01b7
            java.lang.String r13 = r12.getmCategory()
            boolean r13 = r13.equalsIgnoreCase(r10)
            if (r13 != 0) goto L_0x01b5
            java.lang.String r13 = r12.getmCategory()
            boolean r13 = r13.equalsIgnoreCase(r8)
            if (r13 != 0) goto L_0x01b5
            java.lang.String r13 = r12.getmCategory()
            boolean r13 = r13.equalsIgnoreCase(r11)
            if (r13 != 0) goto L_0x01b5
            java.lang.String r13 = r12.getmCategory()
            boolean r13 = r13.equalsIgnoreCase(r6)
            if (r13 != 0) goto L_0x01b5
            java.lang.String r13 = r12.getmCategory()
            boolean r13 = r13.equalsIgnoreCase(r5)
            if (r13 != 0) goto L_0x01b5
            java.lang.String r12 = r12.getmCategory()
            boolean r12 = r12.equalsIgnoreCase(r9)
            if (r12 == 0) goto L_0x01b7
        L_0x01b5:
            r4 = 1
            goto L_0x01bb
        L_0x01b7:
            int r4 = r4 + 1
            goto L_0x015d
        L_0x01ba:
            r4 = 0
        L_0x01bb:
            if (r4 != 0) goto L_0x01d3
            android.content.Context r4 = r1.f28300a
            android.content.Context r12 = r1.f28300a
            int r13 = com.travel.train.R.string.train_travellers_error
            java.lang.String r12 = r12.getString(r13)
            android.content.Context r1 = r1.f28300a
            int r13 = com.travel.train.R.string.min_number_of_passenger_error
            java.lang.String r1 = r1.getString(r13)
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r12, (java.lang.String) r1)
            goto L_0x0231
        L_0x01d3:
            r4 = 0
            r12 = 0
        L_0x01d5:
            com.travel.train.helper.n r13 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r13 = r13.l
            int r13 = r13.size()
            if (r4 >= r13) goto L_0x0208
            com.travel.train.helper.n r13 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r13 = r13.l
            java.lang.Object r13 = r13.get(r4)
            com.travel.train.model.trainticket.CJRPassengerInfo r13 = (com.travel.train.model.trainticket.CJRPassengerInfo) r13
            if (r13 == 0) goto L_0x0205
            java.lang.String r14 = r13.getmCategory()
            if (r14 == 0) goto L_0x0205
            java.lang.String r13 = r13.getmCategory()
            boolean r13 = r13.equalsIgnoreCase(r7)
            if (r13 == 0) goto L_0x0205
            int r12 = r12 + 1
            com.travel.train.helper.n r13 = r1.f28302c
            int r13 = r13.f27345g
            if (r12 <= r13) goto L_0x0205
            r4 = 0
            goto L_0x0209
        L_0x0205:
            int r4 = r4 + 1
            goto L_0x01d5
        L_0x0208:
            r4 = 1
        L_0x0209:
            if (r4 != 0) goto L_0x0230
            android.content.Context r4 = r1.f28300a
            android.content.Context r12 = r1.f28300a
            int r13 = com.travel.train.R.string.train_travellers_error
            java.lang.String r12 = r12.getString(r13)
            android.content.Context r13 = r1.f28300a
            int r14 = com.travel.train.R.string.maximum_number_of_infant
            r15 = 1
            java.lang.Object[] r3 = new java.lang.Object[r15]
            com.travel.train.helper.n r1 = r1.f28302c
            int r1 = r1.f27345g
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r15 = 0
            r3[r15] = r1
            java.lang.String r1 = r13.getString(r14, r3)
            com.paytm.utility.b.b((android.content.Context) r4, (java.lang.String) r12, (java.lang.String) r1)
            r3 = 0
            goto L_0x0231
        L_0x0230:
            r3 = 1
        L_0x0231:
            if (r3 != 0) goto L_0x0236
        L_0x0233:
            r3 = 0
            goto L_0x00a2
        L_0x0236:
            com.travel.train.viewholder.u r1 = r0.U
            android.widget.TextView r3 = r1.f28247c
            r4 = 8
            r3.setVisibility(r4)
            android.widget.TextView r3 = r1.f28248d
            r3.setVisibility(r4)
            android.view.View r3 = r1.f28249e
            android.content.Context r12 = r1.f28251g
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.travel.train.R.color.payment_success_line_grey
            int r12 = r12.getColor(r13)
            r3.setBackgroundColor(r12)
            android.view.View r3 = r1.f28250f
            android.content.Context r12 = r1.f28251g
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.travel.train.R.color.payment_success_line_grey
            int r12 = r12.getColor(r13)
            r3.setBackgroundColor(r12)
            android.widget.EditText r3 = r1.f28245a
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            int r3 = r3.length()
            if (r3 != 0) goto L_0x029d
            android.widget.TextView r3 = r1.f28247c
            android.content.Context r12 = r1.f28251g
            int r13 = com.travel.train.R.string.enter_mobile_number
            java.lang.String r12 = r12.getString(r13)
            r3.setText(r12)
            android.widget.TextView r3 = r1.f28247c
            r12 = 0
            r3.setVisibility(r12)
            android.view.View r3 = r1.f28249e
            android.content.Context r1 = r1.f28251g
            android.content.res.Resources r1 = r1.getResources()
            int r12 = com.travel.train.R.color.train_regreat_color
            int r1 = r1.getColor(r12)
            r3.setBackgroundColor(r1)
        L_0x029a:
            r1 = 0
            goto L_0x036d
        L_0x029d:
            android.widget.EditText r3 = r1.f28245a
            android.text.Editable r3 = r3.getText()
            int r3 = r3.length()
            r12 = 10
            if (r3 >= r12) goto L_0x02d0
            android.widget.TextView r3 = r1.f28247c
            android.content.Context r12 = r1.f28251g
            int r13 = com.travel.train.R.string.enter_mobile_number
            java.lang.String r12 = r12.getString(r13)
            r3.setText(r12)
            android.widget.TextView r3 = r1.f28247c
            r12 = 0
            r3.setVisibility(r12)
            android.view.View r3 = r1.f28249e
            android.content.Context r1 = r1.f28251g
            android.content.res.Resources r1 = r1.getResources()
            int r12 = com.travel.train.R.color.train_regreat_color
            int r1 = r1.getColor(r12)
            r3.setBackgroundColor(r1)
            goto L_0x029a
        L_0x02d0:
            android.widget.TextView r3 = r1.f28247c
            r3.setVisibility(r4)
            android.view.View r3 = r1.f28249e
            android.content.Context r12 = r1.f28251g
            android.content.res.Resources r12 = r12.getResources()
            int r13 = com.travel.train.R.color.payment_success_line_grey
            int r12 = r12.getColor(r13)
            r3.setBackgroundColor(r12)
            android.widget.EditText r3 = r1.f28246b
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            int r3 = r3.length()
            if (r3 != 0) goto L_0x031c
            android.widget.TextView r3 = r1.f28248d
            android.content.Context r12 = r1.f28251g
            int r13 = com.travel.train.R.string.enter_email
            java.lang.String r12 = r12.getString(r13)
            r3.setText(r12)
            android.widget.TextView r3 = r1.f28248d
            r12 = 0
            r3.setVisibility(r12)
            android.view.View r3 = r1.f28250f
            android.content.Context r1 = r1.f28251g
            android.content.res.Resources r1 = r1.getResources()
            int r12 = com.travel.train.R.color.train_regreat_color
            int r1 = r1.getColor(r12)
            r3.setBackgroundColor(r1)
            goto L_0x029a
        L_0x031c:
            android.widget.EditText r3 = r1.f28246b
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = r3.trim()
            boolean r3 = com.paytm.utility.b.d((java.lang.String) r3)
            if (r3 != 0) goto L_0x0356
            android.widget.TextView r3 = r1.f28248d
            android.content.Context r12 = r1.f28251g
            int r13 = com.travel.train.R.string.enter_email
            java.lang.String r12 = r12.getString(r13)
            r3.setText(r12)
            android.widget.TextView r3 = r1.f28248d
            r12 = 0
            r3.setVisibility(r12)
            android.view.View r3 = r1.f28250f
            android.content.Context r1 = r1.f28251g
            android.content.res.Resources r1 = r1.getResources()
            int r12 = com.travel.train.R.color.train_regreat_color
            int r1 = r1.getColor(r12)
            r3.setBackgroundColor(r1)
            goto L_0x029a
        L_0x0356:
            android.widget.TextView r3 = r1.f28248d
            r3.setVisibility(r4)
            android.view.View r3 = r1.f28250f
            android.content.Context r1 = r1.f28251g
            android.content.res.Resources r1 = r1.getResources()
            int r12 = com.travel.train.R.color.payment_success_line_grey
            int r1 = r1.getColor(r12)
            r3.setBackgroundColor(r1)
            r1 = 1
        L_0x036d:
            if (r1 != 0) goto L_0x0371
            goto L_0x0233
        L_0x0371:
            com.travel.train.model.trainticket.CJRTrainDetailsBody r1 = r0.f27227d
            boolean r1 = r1.ismIsAddressCapture()
            if (r1 == 0) goto L_0x044d
            com.travel.train.viewholder.v r1 = r0.V
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r1.f28256b
            if (r3 == 0) goto L_0x038a
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x038a
            java.lang.String r12 = r3.toString()
            goto L_0x038b
        L_0x038a:
            r12 = 0
        L_0x038b:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            boolean r3 = android.text.TextUtils.isEmpty(r12)
            if (r3 == 0) goto L_0x03c1
            android.widget.TextView r3 = r1.f28260f
            if (r3 == 0) goto L_0x03ae
            android.content.Context r4 = r1.f28255a
            if (r4 == 0) goto L_0x03a8
            android.content.res.Resources r4 = r4.getResources()
            if (r4 == 0) goto L_0x03a8
            int r12 = com.travel.train.R.string.gst_mandatory_error
            java.lang.String r12 = r4.getString(r12)
            goto L_0x03a9
        L_0x03a8:
            r12 = 0
        L_0x03a9:
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r3.setText(r12)
        L_0x03ae:
            android.widget.TextView r3 = r1.f28260f
            if (r3 == 0) goto L_0x03b6
            r4 = 0
            r3.setVisibility(r4)
        L_0x03b6:
            net.one97.paytm.common.widgets.CJRFloatingLabel r1 = r1.f28256b
            if (r1 == 0) goto L_0x03bd
            r1.requestFocus()
        L_0x03bd:
            r1 = 0
            r12 = 3
            goto L_0x044a
        L_0x03c1:
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r1.f28256b
            if (r3 == 0) goto L_0x03da
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x03da
            java.lang.String r3 = r3.toString()
            if (r3 == 0) goto L_0x03da
            int r3 = r3.length()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            goto L_0x03db
        L_0x03da:
            r12 = 0
        L_0x03db:
            if (r12 != 0) goto L_0x03e0
            kotlin.g.b.k.a()
        L_0x03e0:
            int r3 = r12.intValue()
            r12 = 3
            if (r3 >= r12) goto L_0x0413
            android.widget.TextView r3 = r1.f28260f
            if (r3 == 0) goto L_0x0402
            android.content.Context r4 = r1.f28255a
            if (r4 == 0) goto L_0x03fc
            android.content.res.Resources r4 = r4.getResources()
            if (r4 == 0) goto L_0x03fc
            int r13 = com.travel.train.R.string.train_min_characters_error
            java.lang.String r4 = r4.getString(r13)
            goto L_0x03fd
        L_0x03fc:
            r4 = 0
        L_0x03fd:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x0402:
            android.widget.TextView r3 = r1.f28260f
            if (r3 == 0) goto L_0x040a
            r4 = 0
            r3.setVisibility(r4)
        L_0x040a:
            net.one97.paytm.common.widgets.CJRFloatingLabel r1 = r1.f28256b
            if (r1 == 0) goto L_0x0411
            r1.requestFocus()
        L_0x0411:
            r1 = 0
            goto L_0x044a
        L_0x0413:
            android.widget.TextView r3 = r1.f28260f
            if (r3 == 0) goto L_0x041a
            r3.setVisibility(r4)
        L_0x041a:
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r1.f28257c
            if (r3 == 0) goto L_0x0429
            java.lang.CharSequence r3 = r3.getText()
            if (r3 == 0) goto L_0x0429
            java.lang.String r3 = r3.toString()
            goto L_0x042a
        L_0x0429:
            r3 = 0
        L_0x042a:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0442
            net.one97.paytm.common.widgets.CJRFloatingLabel r3 = r1.f28257c
            if (r3 == 0) goto L_0x0439
            r3.requestFocus()
        L_0x0439:
            android.widget.TextView r1 = r1.f28261g
            if (r1 == 0) goto L_0x0411
            r3 = 0
            r1.setVisibility(r3)
            goto L_0x0411
        L_0x0442:
            android.widget.TextView r1 = r1.f28261g
            if (r1 == 0) goto L_0x0449
            r1.setVisibility(r4)
        L_0x0449:
            r1 = 1
        L_0x044a:
            if (r1 != 0) goto L_0x044e
            goto L_0x046b
        L_0x044d:
            r12 = 3
        L_0x044e:
            com.travel.train.viewholder.y r1 = r0.W
            android.widget.CheckBox r1 = r1.f28289a
            boolean r1 = r1.isChecked()
            if (r1 != 0) goto L_0x046d
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            int r3 = com.travel.train.R.string.error
            java.lang.String r3 = r0.getString(r3)
            int r4 = com.travel.train.R.string.train_policy_error
            java.lang.String r4 = r0.getString(r4)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r4)
        L_0x046b:
            r3 = 0
            goto L_0x0494
        L_0x046d:
            com.travel.train.viewholder.w r1 = r0.T
            android.widget.CheckBox r1 = r1.f28270b
            boolean r1 = r1.isChecked()
            if (r1 == 0) goto L_0x0493
            com.travel.train.viewholder.w r1 = r0.T
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x0493
            androidx.fragment.app.FragmentActivity r1 = r17.getActivity()
            int r3 = com.travel.train.R.string.error
            java.lang.String r3 = r0.getString(r3)
            int r4 = com.travel.train.R.string.gst_empty_error
            java.lang.String r4 = r0.getString(r4)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r4)
            goto L_0x046b
        L_0x0493:
            r3 = 1
        L_0x0494:
            if (r3 == 0) goto L_0x0675
            com.travel.train.viewholder.z r1 = r0.f27224a
            com.travel.train.helper.n r1 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r1 = r1.l
            if (r1 == 0) goto L_0x0675
            com.travel.train.viewholder.z r1 = r0.f27224a
            com.travel.train.helper.n r1 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r1 = r1.l
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0675
            com.travel.train.viewholder.z r1 = r0.f27224a
            r15 = 0
            r1.l = r15
            r1.f28307h = r15
            r1.j = r15
            r1.k = r15
            r1.n = r15
            r1.m = r15
            r1.p = r15
            r1.o = r15
            r3 = r2
            r4 = r3
            r2 = 0
        L_0x04c0:
            com.travel.train.helper.n r13 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r13 = r13.l
            int r13 = r13.size()
            if (r2 >= r13) goto L_0x05b9
            com.travel.train.helper.n r13 = r1.f28302c
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r13 = r13.l
            java.lang.Object r13 = r13.get(r2)
            com.travel.train.model.trainticket.CJRPassengerInfo r13 = (com.travel.train.model.trainticket.CJRPassengerInfo) r13
            if (r13 == 0) goto L_0x0580
            java.lang.String r14 = r13.getmCategory()
            if (r14 == 0) goto L_0x0580
            java.lang.String r14 = r13.getmCategory()
            r16 = -1
            int r12 = r14.hashCode()
            r15 = 2085(0x825, float:2.922E-42)
            if (r12 == r15) goto L_0x0533
            r15 = 2092(0x82c, float:2.932E-42)
            if (r12 == r15) goto L_0x052b
            r15 = 2099(0x833, float:2.941E-42)
            if (r12 == r15) goto L_0x0523
            r15 = 2149(0x865, float:3.011E-42)
            if (r12 == r15) goto L_0x051b
            r15 = 2333(0x91d, float:3.269E-42)
            if (r12 == r15) goto L_0x0513
            r15 = 2650(0xa5a, float:3.713E-42)
            if (r12 == r15) goto L_0x050b
            r15 = 2660(0xa64, float:3.727E-42)
            if (r12 == r15) goto L_0x0503
            goto L_0x053b
        L_0x0503:
            boolean r12 = r14.equals(r5)
            if (r12 == 0) goto L_0x053b
            r12 = 3
            goto L_0x053c
        L_0x050b:
            boolean r12 = r14.equals(r6)
            if (r12 == 0) goto L_0x053b
            r12 = 4
            goto L_0x053c
        L_0x0513:
            boolean r12 = r14.equals(r7)
            if (r12 == 0) goto L_0x053b
            r12 = 5
            goto L_0x053c
        L_0x051b:
            boolean r12 = r14.equals(r8)
            if (r12 == 0) goto L_0x053b
            r12 = 0
            goto L_0x053c
        L_0x0523:
            boolean r12 = r14.equals(r9)
            if (r12 == 0) goto L_0x053b
            r12 = 6
            goto L_0x053c
        L_0x052b:
            boolean r12 = r14.equals(r10)
            if (r12 == 0) goto L_0x053b
            r12 = 1
            goto L_0x053c
        L_0x0533:
            boolean r12 = r14.equals(r11)
            if (r12 == 0) goto L_0x053b
            r12 = 2
            goto L_0x053c
        L_0x053b:
            r12 = -1
        L_0x053c:
            switch(r12) {
                case 0: goto L_0x0579;
                case 1: goto L_0x0572;
                case 2: goto L_0x056b;
                case 3: goto L_0x055f;
                case 4: goto L_0x0553;
                case 5: goto L_0x054c;
                case 6: goto L_0x0540;
                default: goto L_0x053f;
            }
        L_0x053f:
            goto L_0x0580
        L_0x0540:
            int r12 = r1.o
            r14 = 1
            int r12 = r12 + r14
            r1.o = r12
            int r12 = r1.f28307h
            int r12 = r12 + r14
            r1.f28307h = r12
            goto L_0x0581
        L_0x054c:
            r14 = 1
            int r12 = r1.p
            int r12 = r12 + r14
            r1.p = r12
            goto L_0x0581
        L_0x0553:
            r14 = 1
            int r12 = r1.m
            int r12 = r12 + r14
            r1.m = r12
            int r12 = r1.f28307h
            int r12 = r12 + r14
            r1.f28307h = r12
            goto L_0x0581
        L_0x055f:
            r14 = 1
            int r12 = r1.n
            int r12 = r12 + r14
            r1.n = r12
            int r12 = r1.f28307h
            int r12 = r12 + r14
            r1.f28307h = r12
            goto L_0x0581
        L_0x056b:
            r14 = 1
            int r12 = r1.k
            int r12 = r12 + r14
            r1.k = r12
            goto L_0x0581
        L_0x0572:
            r14 = 1
            int r12 = r1.j
            int r12 = r12 + r14
            r1.j = r12
            goto L_0x0581
        L_0x0579:
            r14 = 1
            int r12 = r1.l
            int r12 = r12 + r14
            r1.l = r12
            goto L_0x0581
        L_0x0580:
            r14 = 1
        L_0x0581:
            if (r13 == 0) goto L_0x05b3
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r3)
            java.lang.String r3 = r13.getAge()
            r12.append(r3)
            java.lang.String r3 = ","
            r12.append(r3)
            java.lang.String r12 = r12.toString()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            r15.append(r4)
            java.lang.String r4 = r13.getBerthPreference()
            r15.append(r4)
            r15.append(r3)
            java.lang.String r3 = r15.toString()
            r4 = r3
            r3 = r12
        L_0x05b3:
            int r2 = r2 + 1
            r12 = 3
            r15 = 0
            goto L_0x04c0
        L_0x05b9:
            boolean r2 = r1.r
            if (r2 == 0) goto L_0x0670
            int r2 = r1.f28307h
            if (r2 <= 0) goto L_0x0670
            int r2 = r1.f28308i
            int r5 = r1.f28307h
            if (r2 == r5) goto L_0x0670
            int r2 = r1.m
            if (r2 <= 0) goto L_0x05dc
            int r2 = r1.n
            if (r2 <= 0) goto L_0x05dc
            int r2 = r1.o
            if (r2 <= 0) goto L_0x05dc
            android.content.Context r2 = r1.f28300a
            int r5 = com.travel.train.R.string.label_senior_citizen_message_for_male_and_female_and_transgender
            java.lang.String r12 = r2.getString(r5)
            goto L_0x0637
        L_0x05dc:
            int r2 = r1.m
            if (r2 <= 0) goto L_0x05ed
            int r2 = r1.n
            if (r2 <= 0) goto L_0x05ed
            android.content.Context r2 = r1.f28300a
            int r5 = com.travel.train.R.string.label_senior_citizen_message_for_male_and_female
            java.lang.String r12 = r2.getString(r5)
            goto L_0x0637
        L_0x05ed:
            int r2 = r1.m
            if (r2 <= 0) goto L_0x05fe
            int r2 = r1.o
            if (r2 <= 0) goto L_0x05fe
            android.content.Context r2 = r1.f28300a
            int r5 = com.travel.train.R.string.label_senior_citizen_message_for_male_and_transgender
            java.lang.String r12 = r2.getString(r5)
            goto L_0x0637
        L_0x05fe:
            int r2 = r1.n
            if (r2 <= 0) goto L_0x060f
            int r2 = r1.o
            if (r2 <= 0) goto L_0x060f
            android.content.Context r2 = r1.f28300a
            int r5 = com.travel.train.R.string.label_senior_citizen_message_for_female_and_transgender
            java.lang.String r12 = r2.getString(r5)
            goto L_0x0637
        L_0x060f:
            int r2 = r1.m
            if (r2 <= 0) goto L_0x061c
            android.content.Context r2 = r1.f28300a
            int r5 = com.travel.train.R.string.label_senior_citizen_message_for_male_only
            java.lang.String r12 = r2.getString(r5)
            goto L_0x0637
        L_0x061c:
            int r2 = r1.n
            if (r2 <= 0) goto L_0x0629
            android.content.Context r2 = r1.f28300a
            int r5 = com.travel.train.R.string.label_senior_citizen_message_for_female_only
            java.lang.String r12 = r2.getString(r5)
            goto L_0x0637
        L_0x0629:
            int r2 = r1.o
            if (r2 <= 0) goto L_0x0636
            android.content.Context r2 = r1.f28300a
            int r5 = com.travel.train.R.string.label_senior_citizen_message_for_transgender_only
            java.lang.String r12 = r2.getString(r5)
            goto L_0x0637
        L_0x0636:
            r12 = 0
        L_0x0637:
            android.app.AlertDialog$Builder r2 = new android.app.AlertDialog$Builder
            android.content.Context r5 = r1.f28300a
            r2.<init>(r5)
            android.content.Context r5 = r1.f28300a
            int r6 = com.travel.train.R.string.senior_citizen_alert_title
            java.lang.String r5 = r5.getString(r6)
            r2.setTitle(r5)
            r2.setMessage(r12)
            android.content.Context r5 = r1.f28300a
            int r6 = com.travel.train.R.string.yes
            java.lang.String r5 = r5.getString(r6)
            com.travel.train.viewholder.z$1 r6 = new com.travel.train.viewholder.z$1
            r6.<init>(r3, r4)
            r2.setPositiveButton(r5, r6)
            android.content.Context r5 = r1.f28300a
            int r6 = com.travel.train.R.string.no
            java.lang.String r5 = r5.getString(r6)
            com.travel.train.viewholder.z$2 r6 = new com.travel.train.viewholder.z$2
            r6.<init>(r3, r4)
            r2.setNegativeButton(r5, r6)
            r2.show()
            return
        L_0x0670:
            com.travel.train.i.g r1 = r1.f28301b
            r1.a(r3, r4)
        L_0x0675:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.y.onClick(android.view.View):void");
    }

    private void a(String str, boolean z2, boolean z3, boolean z4) {
        this.f27229f = new b(getActivity(), this, false, (String) null, str, this.f27231h, getActivity().getSupportFragmentManager(), z2, 0, z3, z4);
        this.f27229f.a();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (intent != null) {
            if (i2 == 140) {
                ArrayList<CJRCountryCode> arrayList = (ArrayList) intent.getSerializableExtra("country_list");
                if (arrayList != null && arrayList.size() > 0) {
                    this.f27224a.f28306g = arrayList;
                }
                CJRCountryCode cJRCountryCode = (CJRCountryCode) intent.getSerializableExtra("selected_country");
                if (cJRCountryCode != null) {
                    this.f27224a.f28302c.a(cJRCountryCode);
                }
            } else if (i2 == 550) {
                if (i3 == 155) {
                    this.f27229f.b();
                }
            } else if (i2 == 551) {
                if (i3 == 555) {
                    this.f27230g.clear();
                    this.f27230g = (ArrayList) intent.getSerializableExtra("intent_extre_changed_passenger");
                    boolean booleanExtra = intent.getBooleanExtra("intent_is_additional_pref_present", false);
                    this.f27224a.a(this.f27230g);
                    if (booleanExtra) {
                        this.R.a(intent.getBooleanExtra("intent_extra_auto_upgrade", false), intent.getStringExtra("intent_extra_coach_number"), intent.getStringExtra("intent_extre_reservation_choice"));
                    }
                }
            } else if (i2 == 3) {
                if (com.travel.train.j.e.a((Context) getActivity())) {
                    this.f27225b.a();
                }
            } else if (i2 == 141 && intent.hasExtra("train_gst_data")) {
                this.f27232i = (CJRTrainGstDetails) intent.getSerializableExtra("train_gst_data");
                w wVar = this.T;
                wVar.f28269a = this.f27232i;
                if (!wVar.b()) {
                    wVar.f28270b.setChecked(true);
                }
                this.T.a();
            }
        } else if (i2 != 551) {
        } else {
            if (i3 == 552) {
                this.G.fullScroll(33);
            } else if (i3 == 553) {
                this.G.scrollTo(0, this.R.f28218a.getTop());
            }
        }
    }

    private void h() {
        if (com.travel.train.j.g.f27551a != null) {
            if (!TextUtils.isEmpty(com.travel.train.j.g.f27551a.getRememberPassword())) {
                this.y.setText(com.travel.train.j.g.f27551a.getRememberPassword());
            }
            if (!TextUtils.isEmpty(com.travel.train.j.g.f27551a.getForgotPassword())) {
                this.z.setText(com.travel.train.j.g.f27551a.getForgotPassword());
            }
        }
    }

    private void i() {
        String str;
        Spanned fromHtml;
        if (com.travel.train.j.g.f27551a == null || TextUtils.isEmpty(com.travel.train.j.g.f27551a.getTrainTravellerDetailsDialogInfoText())) {
            com.travel.train.b.a();
            str = com.paytm.utility.b.G(com.travel.train.b.b().D());
        } else {
            str = com.paytm.utility.b.G(com.travel.train.j.g.f27551a.getTrainTravellerDetailsDialogInfoText());
        }
        String W2 = com.paytm.utility.b.W((Context) getActivity());
        if (str != null && W2 != null && !TextUtils.isEmpty(str) && (fromHtml = Html.fromHtml(str)) != null && !TextUtils.isEmpty(fromHtml)) {
            String[] split = String.valueOf(fromHtml).split("\\r?\\n\\n");
            if (split.length > 0) {
                this.I.setText(b(split[0]));
            }
            if (split.length > 1) {
                this.J.setText(b(split[1]));
            }
            if (split.length > 2) {
                this.K.setText(d(split[2], W2));
            }
        }
    }

    private SpannableString d(String str, String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        SpannableString spannableString = new SpannableString(String.format(b(str), new Object[]{str2}));
        int indexOf = spannableString.toString().indexOf("\"") + 1;
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(getActivity(), R.color.radio_recharge_selected)), indexOf, str2.length() + indexOf, 33);
        spannableString.setSpan(new StyleSpan(1), indexOf, str2.length() + indexOf, 0);
        return spannableString;
    }

    private static String b(String str) {
        StringBuilder sb;
        if (str != null) {
            sb = new StringBuilder(str);
            sb.deleteCharAt(0);
        } else {
            sb = null;
        }
        return sb.toString().trim();
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRTpUserProfile) {
            z zVar = this.f27224a;
            CJRTpUserProfile cJRTpUserProfile = (CJRTpUserProfile) iJRPaytmDataModel;
            if (cJRTpUserProfile != null) {
                zVar.f28305f = cJRTpUserProfile.getBody().getContacts();
                if (zVar.f28305f != null && zVar.f28305f.size() > 0) {
                    zVar.f28303d.clear();
                    for (int i2 = 0; i2 < zVar.f28305f.size(); i2++) {
                        CJRTpUserProfileContact cJRTpUserProfileContact = zVar.f28305f.get(i2);
                        if (!(cJRTpUserProfileContact == null || !o.g(cJRTpUserProfileContact.getGender()) || cJRTpUserProfileContact.getAge() == null)) {
                            zVar.f28303d.add(cJRTpUserProfileContact);
                        }
                    }
                    com.travel.train.travellerProfile.a.a.a().a(zVar.f28303d);
                    if (!(zVar.s == null || zVar.s.getChildCount() <= 0 || zVar.s.getChildAt(0) == null)) {
                        as asVar = (as) ((AutoCompleteTextView) zVar.s.getChildAt(0).findViewById(R.id.full_name)).getAdapter();
                        ArrayList<CJRTpUserProfileContact> arrayList = new ArrayList<>(zVar.f28303d);
                        asVar.f26320a.clear();
                        asVar.f26320a = arrayList;
                        asVar.f26321b.clear();
                        asVar.f26321b.addAll(asVar.f26320a);
                        asVar.notifyDataSetChanged();
                    }
                    for (int i3 = 0; i3 < zVar.f28303d.size(); i3++) {
                        if (!(zVar.f28303d.get(i3) == null || zVar.f28303d.get(i3).getAge() == null || Integer.parseInt(zVar.f28303d.get(i3).getAge()) > 4)) {
                            zVar.f28304e.add(zVar.f28303d.get(i3));
                        }
                    }
                    for (int i4 = 0; i4 < zVar.f28304e.size(); i4++) {
                        zVar.f28303d.remove(zVar.f28304e.get(i4));
                    }
                }
            }
            o.a("train_traveller_details", (String) null, SDKConstants.PG_SCREEN_LOADED, "/trains/traveller-details", getActivity());
        } else if (iJRPaytmDataModel instanceof CJRPGTokenList) {
            this.X = com.travel.train.j.e.a((CJRPGTokenList) iJRPaytmDataModel);
            if (!TextUtils.isEmpty(this.X) && this.Z != null && this.Y != null) {
                if (this.T.f28270b.isChecked()) {
                    i.a(this.f27231h, this.f27232i);
                } else {
                    i.a(this.f27231h);
                }
                this.Z.a(com.travel.train.j.n.a(getContext(), this.X), this.Y.a(this.f27226c, this.L), this.Y.a(this.f27227d, this.f27226c, this.f27231h));
            }
        }
    }

    public final String d() {
        return this.P.f28234b;
    }

    public final void a(int i2) {
        this.ad = true;
        t tVar = this.P;
        if (tVar != null) {
            tVar.a(i2);
            b(i2);
        }
    }

    public void showProgressDialog(Context context, String str) {
        super.showProgressDialog(context, str);
    }

    public void showSessionTimeoutAlert(NetworkCustomError networkCustomError) {
        super.showSessionTimeoutAlert(networkCustomError);
    }

    public void removeProgressDialog() {
        super.removeProgressDialog();
    }

    /* renamed from: com.travel.train.fragment.y$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27244a = new int[aj.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.travel.train.i.aj[] r0 = com.travel.train.i.aj.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f27244a = r0
                int[] r0 = f27244a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.travel.train.i.aj r1 = com.travel.train.i.aj.USER_ID_EDIT_CLICK     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f27244a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.travel.train.i.aj r1 = com.travel.train.i.aj.START_COUNTRY_LIST_VIEW     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f27244a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.travel.train.i.aj r1 = com.travel.train.i.aj.START_REVIEW_ITERNARY_VIEW     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f27244a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.travel.train.i.aj r1 = com.travel.train.i.aj.IGNORE_CLICK     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.fragment.y.AnonymousClass8.<clinit>():void");
        }
    }

    public final void a(aj ajVar) {
        int i2 = AnonymousClass8.f27244a[ajVar.ordinal()];
        if (i2 == 1) {
            a(com.paytm.utility.b.W((Context) getActivity()), false, true, false);
        } else if (i2 == 2) {
            Intent intent = new Intent(getActivity(), AJRSelectCountryActivity.class);
            intent.putExtra("country_list", this.f27224a.f28306g);
            intent.putExtra("sign_up", false);
            startActivityForResult(intent, 140);
        } else if (i2 == 3) {
            j();
            i iVar = this.f27225b;
            if (com.paytm.utility.b.c((Context) iVar.f27313a.e())) {
                iVar.f27313a.showProgressDialog(iVar.f27313a.e(), iVar.f27313a.e().getResources().getString(R.string.train_review_fetching_data));
                com.travel.train.b.a();
                com.travel.train.b.a(iVar.f27313a.e(), (com.paytm.network.listener.b) iVar);
                return;
            }
            com.paytm.utility.b.c((Context) iVar.f27313a.e(), iVar.f27313a.e().getResources().getString(R.string.no_connection), iVar.f27313a.e().getResources().getString(R.string.no_internet_train));
        }
    }

    public void showErrorDialog(String str, String str2) {
        super.showErrorDialog(str, str2);
    }

    /* access modifiers changed from: private */
    public void j() {
        this.f27227d.setPassengerInfo(this.f27224a.f28302c.l);
        this.f27227d.setUserMobileNumber(this.U.f28245a.getText().toString());
        this.f27227d.setEmailAddress(this.U.f28246b.getText().toString().trim());
        this.f27227d.setCoachNumber(this.R.b());
        this.f27227d.setReservationCode(this.R.f28222e);
        this.f27227d.setmReservationChoice(this.R.f28221d);
        this.f27227d.setAutoUpgrade(this.R.c());
        this.f27227d.setBoardingDate(this.P.f28233a);
        this.f27227d.setBoardingTime(this.P.f28234b);
        if (this.f27227d.ismIsAddressCapture()) {
            this.f27227d.setmAddressLine(this.V.c());
            this.f27227d.setmPincode(this.V.d());
            this.f27227d.setmState(this.V.e());
            this.f27227d.setmCity(this.V.f());
            this.f27227d.setmPostOffice(this.V.g());
        }
    }

    public final void a(String str) {
        ((a) getActivity()).a(str);
    }

    static /* synthetic */ void a(y yVar, CJRTrainBooking cJRTrainBooking) {
        yVar.removeProgressDialog();
        if (yVar.T.f28270b.isChecked()) {
            i.a(yVar.f27231h, yVar.f27232i);
        } else {
            i.a(yVar.f27231h);
        }
        Intent intent = new Intent(yVar.getActivity(), AJRTrainReviewItineraryActivity.class);
        intent.putExtra("train_detail_body", yVar.f27227d);
        intent.putExtra("train_detail", yVar.f27226c);
        intent.putExtra("intent_extra_train_search_input", yVar.f27231h);
        intent.putExtra("request_id", yVar.j);
        intent.putExtra("train_class_code", yVar.k);
        intent.putExtra("train_class_name", yVar.l);
        intent.putExtra("is_from_alternative_click", yVar.L);
        intent.putExtra("waiting_list", yVar.t);
        intent.putExtra("insuranceChecked", yVar.S.a());
        intent.putExtra("train_booking_details", cJRTrainBooking);
        intent.putExtra("wallet_token", yVar.X);
        yVar.startActivityForResult(intent, 551);
    }

    static /* synthetic */ void l(y yVar) {
        if (com.paytm.utility.b.r((Context) yVar.getActivity())) {
            String W2 = com.paytm.utility.b.W((Context) yVar.getActivity());
            if (W2 == null || TextUtils.isEmpty(W2)) {
                yVar.a((String) null, true, false, true);
            } else {
                yVar.a(com.paytm.utility.b.W((Context) yVar.getActivity()), true, true, true);
            }
        }
    }
}
