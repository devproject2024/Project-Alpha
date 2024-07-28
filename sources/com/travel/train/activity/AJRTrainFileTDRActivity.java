package com.travel.train.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.g;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.train.CJRTrainBaseActivity;
import com.travel.train.R;
import com.travel.train.b;
import com.travel.train.fragment.FJRTrainTDRBottomSheetFragment;
import com.travel.train.fragment.aj;
import com.travel.train.helper.m;
import com.travel.train.i.x;
import com.travel.train.model.a;
import com.travel.train.model.trainticket.CJRTrainTDRBody;
import com.travel.train.model.trainticket.CJRTrainTDRDetails;
import com.travel.train.model.trainticket.CJRTrainTDRReasons;
import com.travel.train.model.trainticket.CJRTrainTDRSubmitResponse;
import java.util.HashMap;
import java.util.Map;

public class AJRTrainFileTDRActivity extends CJRTrainBaseActivity implements View.OnClickListener, g.a, FJRTrainTDRBottomSheetFragment.a, x.b {

    /* renamed from: a  reason: collision with root package name */
    private TextView f25937a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f25938b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f25939c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f25940d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f25941e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f25942f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f25943g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f25944h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f25945i;
    private LinearLayout j;
    /* access modifiers changed from: private */
    public LinearLayout k;
    private LinearLayout l;
    /* access modifiers changed from: private */
    public RelativeLayout m;
    /* access modifiers changed from: private */
    public RelativeLayout n;
    private RelativeLayout o;
    private Button p;
    private x.a q;
    private String r;
    private String s;
    private CJRTrainTDRBody t;
    /* access modifiers changed from: private */
    public HashMap<Integer, Integer> u = new HashMap<>();
    /* access modifiers changed from: private */
    public String v;
    /* access modifiers changed from: private */
    public String w;
    /* access modifiers changed from: private */
    public Integer x = -1;
    private String y = "AJRTrainFileTDRActivity";

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.q = (x.a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.pre_t_activity_train_file_tdr);
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("order_id")) {
                this.r = intent.getStringExtra("order_id");
            }
            if (intent.hasExtra("intent_extra_train_tdr_url")) {
                this.s = intent.getStringExtra("intent_extra_train_tdr_url");
            }
        }
        setSupportActionBar((Toolbar) findViewById(R.id.train_tdr_toolbar));
        getSupportActionBar().c(false);
        ImageView imageView = (ImageView) findViewById(R.id.back_arrow);
        imageView.setImageResource(com.travel.common.R.drawable.travel_res_common_back_button);
        imageView.setRotation(180.0f);
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrainFileTDRActivity.this.a(view);
            }
        });
        ((TextView) findViewById(R.id.train_tdr_toolbar_title)).setText("File TDR");
        g.f43805b = this;
        this.q = new m(this, this);
        if (!TextUtils.isEmpty(this.r) && !TextUtils.isEmpty(this.s)) {
            this.q.a(this.s);
        }
    }

    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public final void a() {
        removeProgressDialog();
    }

    public final void a(String str) {
        showProgressDialog(this, str);
    }

    public final void a(int i2, NetworkCustomError networkCustomError) {
        if (!isFinishing()) {
            try {
                removeProgressDialog();
                a aVar = new a();
                if (networkCustomError.networkResponse != null) {
                    NetworkResponse networkResponse = networkCustomError.networkResponse;
                    if (networkResponse.data != null) {
                        try {
                            aVar = (a) new f().a(new String(networkResponse.data), aVar.getClass());
                        } catch (Exception e2) {
                            e2.getMessage();
                        }
                    }
                }
                if (i2 != 401) {
                    if (i2 != 410) {
                        if (!(i2 == 449 || i2 == 499 || i2 == 502 || i2 == 503)) {
                            if (i2 != 504) {
                                if (aVar != null && aVar.getStatus() != null && aVar.getStatus().getMessage() != null && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27692a) && !TextUtils.isEmpty(aVar.getStatus().getMessage().f27693b)) {
                                    showErrorDialog(aVar.getStatus().getMessage().f27692a, aVar.getStatus().getMessage().f27693b);
                                    return;
                                } else if (TextUtils.isEmpty(networkCustomError.getMessage()) || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                                    if (!TextUtils.isEmpty(networkCustomError.getMessage())) {
                                        b.a();
                                        if (!b.b().a((Context) this, (Exception) networkCustomError, "error.trains@paytm.com")) {
                                            if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                                                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train) + " " + networkCustomError.getUrl());
                                                return;
                                            }
                                            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error_data_display), getResources().getString(R.string.trains_message_error_data_display));
                                            return;
                                        }
                                    }
                                    com.paytm.utility.b.b((Context) this, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message_train));
                                    return;
                                } else {
                                    com.paytm.utility.b.b((Context) this, networkCustomError.getAlertTitle(), networkCustomError.getAlertMessage());
                                    return;
                                }
                            }
                        }
                        com.paytm.utility.b.b((Context) this, networkCustomError.getMessage(), networkCustomError.getMessage());
                        return;
                    }
                }
                b.a();
                b.b().a((Activity) this, networkCustomError);
            } catch (Exception e3) {
                q.c(e3.getMessage());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.ArrayList<com.travel.train.model.trainticket.CJRTrainTDRTravellerInfo> r17, java.lang.String r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = 0
            r3 = 0
        L_0x0006:
            int r4 = r17.size()
            if (r3 >= r4) goto L_0x01e1
            r4 = r17
            java.lang.Object r5 = r4.get(r3)
            com.travel.train.model.trainticket.CJRTrainTDRTravellerInfo r5 = (com.travel.train.model.trainticket.CJRTrainTDRTravellerInfo) r5
            r6 = -1
            if (r1 == r6) goto L_0x0019
        L_0x0017:
            r8 = 1
            goto L_0x0029
        L_0x0019:
            if (r5 == 0) goto L_0x0017
            boolean r8 = r5.isTDRFiled()
            if (r8 != 0) goto L_0x0028
            boolean r8 = r5.isCancelled()
            if (r8 != 0) goto L_0x0028
            goto L_0x0017
        L_0x0028:
            r8 = 0
        L_0x0029:
            if (r8 == 0) goto L_0x01db
            android.view.LayoutInflater r8 = android.view.LayoutInflater.from(r16)
            int r9 = com.travel.train.R.layout.pre_t_tdr_traveller_item
            r10 = 0
            android.view.View r8 = r8.inflate(r9, r10)
            int r9 = com.travel.train.R.id.traveler_icon
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            int r11 = com.travel.train.R.id.traveller_name
            android.view.View r11 = r8.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = com.travel.train.R.id.traveller_sub_title
            android.view.View r12 = r8.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r13 = com.travel.train.R.id.check_box
            android.view.View r13 = r8.findViewById(r13)
            android.widget.CheckBox r13 = (android.widget.CheckBox) r13
            android.widget.RadioGroup$LayoutParams r14 = new android.widget.RadioGroup$LayoutParams
            android.content.Context r15 = r16.getBaseContext()
            r14.<init>(r15, r10)
            android.content.res.Resources r10 = r16.getResources()
            int r15 = com.travel.train.R.dimen.dimen_15dp
            float r10 = r10.getDimension(r15)
            int r10 = (int) r10
            r14.setMargins(r2, r10, r2, r2)
            r8.setLayoutParams(r14)
            com.travel.train.activity.AJRTrainFileTDRActivity$2 r10 = new com.travel.train.activity.AJRTrainFileTDRActivity$2
            r10.<init>(r3, r5)
            r13.setOnCheckedChangeListener(r10)
            java.lang.String r10 = r5.getPassengerGender()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0183
            java.lang.String r10 = r5.getPassengerCategory()
            java.lang.String r14 = r5.getPassengerGender()
            boolean r15 = android.text.TextUtils.isEmpty(r10)
            if (r15 != 0) goto L_0x0183
            int r15 = r10.hashCode()
            r7 = 2085(0x825, float:2.922E-42)
            if (r15 == r7) goto L_0x00ed
            r7 = 2092(0x82c, float:2.932E-42)
            if (r15 == r7) goto L_0x00e3
            r7 = 2099(0x833, float:2.941E-42)
            if (r15 == r7) goto L_0x00d9
            r7 = 2149(0x865, float:3.011E-42)
            if (r15 == r7) goto L_0x00cf
            r7 = 2333(0x91d, float:3.269E-42)
            if (r15 == r7) goto L_0x00c5
            r7 = 2650(0xa5a, float:3.713E-42)
            if (r15 == r7) goto L_0x00bb
            r7 = 2660(0xa64, float:3.727E-42)
            if (r15 == r7) goto L_0x00b1
            goto L_0x00f7
        L_0x00b1:
            java.lang.String r7 = "SW"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x00f7
            r7 = 3
            goto L_0x00f8
        L_0x00bb:
            java.lang.String r7 = "SM"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x00f7
            r7 = 4
            goto L_0x00f8
        L_0x00c5:
            java.lang.String r7 = "IF"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x00f7
            r7 = 5
            goto L_0x00f8
        L_0x00cf:
            java.lang.String r7 = "CH"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x00f7
            r7 = 0
            goto L_0x00f8
        L_0x00d9:
            java.lang.String r7 = "AT"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x00f7
            r7 = 6
            goto L_0x00f8
        L_0x00e3:
            java.lang.String r7 = "AM"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x00f7
            r7 = 1
            goto L_0x00f8
        L_0x00ed:
            java.lang.String r7 = "AF"
            boolean r7 = r10.equals(r7)
            if (r7 == 0) goto L_0x00f7
            r7 = 2
            goto L_0x00f8
        L_0x00f7:
            r7 = -1
        L_0x00f8:
            java.lang.String r10 = "M"
            switch(r7) {
                case 0: goto L_0x0162;
                case 1: goto L_0x0154;
                case 2: goto L_0x0146;
                case 3: goto L_0x0138;
                case 4: goto L_0x012a;
                case 5: goto L_0x0108;
                case 6: goto L_0x00ff;
                default: goto L_0x00fd;
            }
        L_0x00fd:
            goto L_0x0183
        L_0x00ff:
            com.travel.utils.n$a r7 = com.travel.utils.n.a.V1
            java.lang.String r10 = "ic_button_transgender.png"
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r9, r10, r2, r2, r7)
            goto L_0x0183
        L_0x0108:
            boolean r7 = r14.equalsIgnoreCase(r10)
            if (r7 == 0) goto L_0x011c
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_ic_button_child_male
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
            goto L_0x0183
        L_0x011c:
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_ic_button_child_female
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
            goto L_0x0183
        L_0x012a:
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_ic_button_senior_citizen_male
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
            goto L_0x0183
        L_0x0138:
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_ic_button_senior_citizen_female
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
            goto L_0x0183
        L_0x0146:
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_female_tick
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
            goto L_0x0183
        L_0x0154:
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_male_tick
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
            goto L_0x0183
        L_0x0162:
            boolean r7 = r14.equalsIgnoreCase(r10)
            if (r7 == 0) goto L_0x0176
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_child_male_selected
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
            goto L_0x0183
        L_0x0176:
            android.content.res.Resources r7 = r16.getResources()
            int r10 = com.travel.train.R.drawable.pre_t_child_female_selected
            android.graphics.drawable.Drawable r7 = r7.getDrawable(r10)
            r9.setImageDrawable(r7)
        L_0x0183:
            java.lang.String r7 = r5.getPassengerName()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0194
            java.lang.String r5 = r5.getPassengerName()
            r11.setText(r5)
        L_0x0194:
            boolean r5 = android.text.TextUtils.isEmpty(r18)
            if (r5 != 0) goto L_0x01a3
            r12.setVisibility(r2)
            r5 = r18
            r12.setText(r5)
            goto L_0x01a5
        L_0x01a3:
            r5 = r18
        L_0x01a5:
            if (r1 == r6) goto L_0x01c4
            if (r1 == 0) goto L_0x01be
            r6 = 1
            if (r1 == r6) goto L_0x01ad
            goto L_0x01d5
        L_0x01ad:
            android.content.res.Resources r6 = r16.getResources()
            int r7 = com.travel.train.R.drawable.pre_t_check_tdr
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)
            r13.setButtonDrawable(r6)
            r13.setEnabled(r2)
            goto L_0x01d5
        L_0x01be:
            r6 = 8
            r13.setVisibility(r6)
            goto L_0x01d5
        L_0x01c4:
            android.content.res.Resources r6 = r16.getResources()
            int r7 = com.travel.train.R.drawable.pre_t_insurance_check_box
            android.graphics.drawable.Drawable r6 = r6.getDrawable(r7)
            r13.setButtonDrawable(r6)
            r6 = 1
            r13.setEnabled(r6)
        L_0x01d5:
            android.widget.LinearLayout r6 = r0.j
            r6.addView(r8)
            goto L_0x01dd
        L_0x01db:
            r5 = r18
        L_0x01dd:
            int r3 = r3 + 1
            goto L_0x0006
        L_0x01e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.activity.AJRTrainFileTDRActivity.a(java.util.ArrayList, java.lang.String, int):void");
    }

    private void c() {
        if (this.t.getReasons() != null) {
            if (!TextUtils.isEmpty(this.t.getReasons().getHeaderText())) {
                this.f25942f.setText(this.t.getReasons().getHeaderText());
            }
            if (!TextUtils.isEmpty(this.t.getReasons().getTipText())) {
                this.f25943g.setText(this.t.getReasons().getTipText());
            }
            if (!TextUtils.isEmpty(this.t.getRulesText())) {
                this.f25944h.setVisibility(0);
                this.f25944h.setText(this.t.getRulesText());
            }
            if (this.t.getReasons().getReasons() != null && this.t.getReasons().getReasons().size() > 0) {
                for (final int i2 = 0; i2 < this.t.getReasons().getReasons().size(); i2++) {
                    final CJRTrainTDRReasons.ReasonItem reasonItem = this.t.getReasons().getReasons().get(i2);
                    if (!TextUtils.isEmpty(reasonItem.getReasonText())) {
                        View inflate = LayoutInflater.from(this).inflate(R.layout.pre_t_train_tdr_reason_item, (ViewGroup) null);
                        final ImageView imageView = (ImageView) inflate.findViewById(R.id.reason_btn);
                        ((TextView) inflate.findViewById(R.id.reason_txt)).setText(reasonItem.getReasonText());
                        this.k.addView(inflate);
                        inflate.setOnClickListener(new View.OnClickListener() {
                            public final void onClick(View view) {
                                imageView.setImageResource(R.drawable.train_ic_radio_button_selected);
                                String unused = AJRTrainFileTDRActivity.this.v = reasonItem.getReasonText();
                                Integer unused2 = AJRTrainFileTDRActivity.this.x = reasonItem.getReasonId();
                                String unused3 = AJRTrainFileTDRActivity.this.w = reasonItem.getReasonDisclaimer();
                                AJRTrainFileTDRActivity.d(AJRTrainFileTDRActivity.this);
                                for (int i2 = 0; i2 < AJRTrainFileTDRActivity.this.k.getChildCount(); i2++) {
                                    ImageView imageView = (ImageView) AJRTrainFileTDRActivity.this.k.getChildAt(i2).findViewById(R.id.reason_btn);
                                    if (i2 != i2) {
                                        imageView.setImageResource(R.drawable.train_ic_radio_button_deselected);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    private static String b(String str) {
        if (str.length() == 0) {
            return "";
        }
        String str2 = "" + Character.toUpperCase(str.charAt(0));
        for (int i2 = 1; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (str.charAt(i2 - 1) == ' ') {
                str2 = str2 + Character.toUpperCase(charAt);
            } else {
                str2 = str2 + Character.toLowerCase(charAt);
            }
        }
        return str2;
    }

    public void onClick(View view) {
        CJRTrainTDRBody cJRTrainTDRBody;
        int id = view.getId();
        if (id == R.id.proceed_btn) {
            if (this.t == null) {
                return;
            }
            if (this.p.getText().toString().equalsIgnoreCase(getString(R.string.addcard_proceed))) {
                this.n.setVisibility(0);
                this.o.setVisibility(0);
                this.o.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_flight_bottom_to_top_above_tab));
                FJRTrainTDRBottomSheetFragment fJRTrainTDRBottomSheetFragment = new FJRTrainTDRBottomSheetFragment();
                Bundle bundle = new Bundle();
                bundle.putString("tdr_disclimer_text", this.w);
                bundle.putString("tdr_header", this.t.getBottomSheetHeader());
                bundle.putString("tdr_submit_txt", this.t.getBottomSheeFooter());
                fJRTrainTDRBottomSheetFragment.setArguments(bundle);
                androidx.fragment.app.q a2 = getSupportFragmentManager().a();
                a2.b(R.id.frame_tdr_rules, fJRTrainTDRBottomSheetFragment, "bottom_sheet_fragemnt");
                a2.b();
                this.p.setText(getString(R.string.submit_text));
            } else if (this.p.getText().toString().equalsIgnoreCase(getString(R.string.submit_text))) {
                b();
                HashMap<Integer, Integer> hashMap = this.u;
                if (hashMap != null && hashMap.size() > 0 && this.x.intValue() != -1 && !TextUtils.isEmpty(this.t.getTdrSubmitUrl())) {
                    this.q.a(this.r, this.t.getTdrSubmitUrl(), this.x.toString(), d());
                }
            }
        } else if (id == R.id.tdr_rules_txt && (cJRTrainTDRBody = this.t) != null && !TextUtils.isEmpty(cJRTrainTDRBody.getRulesLink())) {
            String rulesLink = this.t.getRulesLink();
            Intent intent = new Intent(this, AJREmbedWebView.class);
            intent.putExtra("url", "http://drive.google.com/viewerng/viewer?embedded=true&url=".concat(String.valueOf(rulesLink)));
            startActivity(intent);
        }
    }

    private String d() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry next : this.u.entrySet()) {
            if (next.getValue() != null) {
                sb.append(next.getValue());
                sb.append(AppConstants.COMMA);
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public final void b() {
        this.p.setText(getString(R.string.addcard_proceed));
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_flight_bottom_to_top_above_tab_close);
        this.o.setVisibility(8);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                AJRTrainFileTDRActivity.this.n.setVisibility(8);
            }
        });
        this.o.setAnimation(loadAnimation);
        Fragment c2 = getSupportFragmentManager().c("bottom_sheet_fragemnt");
        if (c2 != null) {
            getSupportFragmentManager().a().a(c2).b();
        }
    }

    public void onOkClick() {
        finish();
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRTrainTDRSubmitResponse cJRTrainTDRSubmitResponse;
        this.f25937a = (TextView) findViewById(R.id.source_dest_txt);
        this.f25938b = (TextView) findViewById(R.id.train_num_txt);
        this.f25939c = (TextView) findViewById(R.id.train_name_txt);
        this.f25940d = (TextView) findViewById(R.id.travel_date_txt);
        this.f25941e = (TextView) findViewById(R.id.traveller_title);
        this.f25942f = (TextView) findViewById(R.id.reason_title);
        this.f25943g = (TextView) findViewById(R.id.reason_sub_title_txt);
        this.f25944h = (TextView) findViewById(R.id.tdr_rules_txt);
        this.f25944h.setOnClickListener(this);
        this.f25945i = (TextView) findViewById(R.id.total_persons_txt);
        this.j = (LinearLayout) findViewById(R.id.traveller_container);
        this.k = (LinearLayout) findViewById(R.id.reason_radio_group);
        this.l = (LinearLayout) findViewById(R.id.progress_lyt_hide);
        this.m = (RelativeLayout) findViewById(R.id.proceed_lyt);
        this.p = (Button) findViewById(R.id.proceed_btn);
        this.p.setOnClickListener(this);
        this.n = (RelativeLayout) findViewById(R.id.lyt_train_tdr_grey_bg);
        this.o = (RelativeLayout) findViewById(R.id.tdr_rules_anim_layout);
        this.m.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                ((RelativeLayout.LayoutParams) AJRTrainFileTDRActivity.this.n.getLayoutParams()).setMargins(0, 0, 0, AJRTrainFileTDRActivity.this.m.getHeight());
                AJRTrainFileTDRActivity.this.m.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
        this.l.setVisibility(8);
        if (iJRPaytmDataModel instanceof CJRTrainTDRDetails) {
            CJRTrainTDRDetails cJRTrainTDRDetails = (CJRTrainTDRDetails) iJRPaytmDataModel;
            if (cJRTrainTDRDetails.getBody() != null) {
                this.t = cJRTrainTDRDetails.getBody();
                if (this.t != null) {
                    StringBuilder sb = new StringBuilder();
                    if (!TextUtils.isEmpty(this.t.getBoardingStationName()) && !TextUtils.isEmpty(this.t.getDestinationStationName())) {
                        sb.append(this.t.getBoardingStationName());
                        sb.append(" - ");
                        sb.append(this.t.getDestinationStationName());
                    }
                    this.f25937a.setText(sb.toString());
                    if (!TextUtils.isEmpty(this.t.getTrainNumber())) {
                        this.f25938b.setText(this.t.getTrainNumber());
                    }
                    if (!TextUtils.isEmpty(this.t.getTrainName())) {
                        this.f25939c.setText(b(this.t.getTrainName()));
                    }
                    if (!TextUtils.isEmpty(this.t.getBoardingDate())) {
                        this.f25940d.setText(this.t.getBoardingDate());
                    }
                    if (!TextUtils.isEmpty(this.t.getTravellersHeaderText())) {
                        this.f25941e.setText(this.t.getTravellersHeaderText());
                    }
                    if (this.t.getTravellers() != null && this.t.getTravellers().size() > 0) {
                        a(this.t.getTravellers(), "", -1);
                    }
                    if (this.t.getCancelledTravellers() != null && this.t.getCancelledTravellers().size() > 0) {
                        a(this.t.getCancelledTravellers(), this.t.getCancelledTravellersLabel(), 0);
                    }
                    if (this.t.getTdrFiledTravellers() != null && this.t.getTdrFiledTravellers().size() > 0) {
                        a(this.t.getTdrFiledTravellers(), this.t.getTdrFiledTravellersLabel(), 1);
                    }
                    c();
                }
            }
        } else if ((iJRPaytmDataModel instanceof CJRTrainTDRSubmitResponse) && (cJRTrainTDRSubmitResponse = (CJRTrainTDRSubmitResponse) iJRPaytmDataModel) != null && cJRTrainTDRSubmitResponse.getBody() != null) {
            aj ajVar = new aj(cJRTrainTDRSubmitResponse.getBody());
            ajVar.setCancelable(false);
            ajVar.show(getSupportFragmentManager(), "dialog");
        }
    }

    static /* synthetic */ void d(AJRTrainFileTDRActivity aJRTrainFileTDRActivity) {
        HashMap<Integer, Integer> hashMap = aJRTrainFileTDRActivity.u;
        if (hashMap != null && hashMap.size() > 0 && !TextUtils.isEmpty(aJRTrainFileTDRActivity.v)) {
            aJRTrainFileTDRActivity.m.setVisibility(0);
            StringBuilder sb = new StringBuilder();
            sb.append(aJRTrainFileTDRActivity.u.size());
            sb.append(" Person");
            if (aJRTrainFileTDRActivity.u.size() > 1) {
                sb.append("s");
            }
            aJRTrainFileTDRActivity.f25945i.setText(sb.toString());
            return;
        }
        aJRTrainFileTDRActivity.m.setVisibility(8);
    }
}
