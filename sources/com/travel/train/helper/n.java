package com.travel.train.helper;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.cdn.ResourceUtils;
import com.travel.train.R;
import com.travel.train.b.as;
import com.travel.train.b.e;
import com.travel.train.i.y;
import com.travel.train.i.z;
import com.travel.train.j.g;
import com.travel.train.j.o;
import com.travel.train.model.trainticket.CJRCountryCode;
import com.travel.train.model.trainticket.CJRPassengerInfo;
import com.travel.train.model.trainticket.CJRTrainConfig;
import com.travel.train.model.trainticket.CJRTrainDetailsBody;
import com.travel.train.model.trainticket.CJRTravellerBerth;
import com.travel.train.travellerProfile.travel.CJRTpUserProfileContact;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;

public final class n implements View.OnFocusChangeListener {
    private String A = "Senior Citizen";
    private String B = "Please select the food prefence";
    private int C;
    private int D;
    /* access modifiers changed from: private */
    public int E;
    /* access modifiers changed from: private */
    public CJRTrainConfig F;
    private boolean G;
    private boolean H;
    /* access modifiers changed from: private */
    public boolean I;
    private boolean J;
    private ArrayList<CJRTravellerBerth> K;
    /* access modifiers changed from: private */
    public AutoCompleteTextView L;
    /* access modifiers changed from: private */
    public LinearLayout M;
    private LinearLayout N;
    private LinearLayout O;
    private LinearLayout P;
    private y Q;
    private int R = 0;
    private int S;
    private CJRTrainDetailsBody T;
    /* access modifiers changed from: private */
    public boolean U = false;

    /* renamed from: a  reason: collision with root package name */
    String f27339a = "Please enter full name of traveller";

    /* renamed from: b  reason: collision with root package name */
    String f27340b = "Please enter full name of child traveller";

    /* renamed from: c  reason: collision with root package name */
    int f27341c;

    /* renamed from: d  reason: collision with root package name */
    int f27342d;

    /* renamed from: e  reason: collision with root package name */
    int f27343e;

    /* renamed from: f  reason: collision with root package name */
    int f27344f;

    /* renamed from: g  reason: collision with root package name */
    public int f27345g;

    /* renamed from: h  reason: collision with root package name */
    public int f27346h;
    /* access modifiers changed from: package-private */

    /* renamed from: i  reason: collision with root package name */
    public Activity f27347i;
    /* access modifiers changed from: package-private */
    public z j;
    ArrayList<CheckBox> k = new ArrayList<>();
    public ArrayList<CJRPassengerInfo> l = new ArrayList<>();
    /* access modifiers changed from: package-private */
    public String m = "CJRTrainTravellerDetailsHelper";
    /* access modifiers changed from: private */
    public String n = "Male";
    /* access modifiers changed from: private */
    public String o = "Female";
    /* access modifiers changed from: private */
    public String p = "Transgender";
    /* access modifiers changed from: private */
    public String q = "Transgender is not available";
    /* access modifiers changed from: private */
    public String r = "M";
    /* access modifiers changed from: private */
    public String s = AppConstants.FEED_SUB_TYPE;
    /* access modifiers changed from: private */
    public String t = "T";
    private String u = "Non-Veg";
    private String v = "Veg";
    private String w = "No food";
    private String x = "IF";
    private String y = "India";
    private String z = "IN";

    public n(Activity activity, CJRTrainConfig cJRTrainConfig, CJRTrainDetailsBody cJRTrainDetailsBody, z zVar, y yVar) {
        this.f27347i = activity;
        this.F = cJRTrainConfig;
        this.j = zVar;
        this.Q = yVar;
        this.T = cJRTrainDetailsBody;
        CJRTrainConfig cJRTrainConfig2 = this.F;
        if (cJRTrainConfig2 != null) {
            this.f27344f = cJRTrainConfig2.getMaxNameLength();
            this.f27343e = this.F.getMinNameLength();
            this.f27342d = this.F.getMinPassengerAge();
            this.f27341c = this.F.getMaxPassengerAge();
            this.G = this.F.ismFoodChoiceEnables();
            this.H = this.F.ismIdRequired();
            this.I = this.F.ismBedRollFlagEnabled();
            this.J = this.F.isSeniorCitizenApplicable();
            this.C = this.F.getMaxChildAge();
            this.D = this.F.getSeniorMenAge();
            this.E = this.F.getSeniorWomenAge();
            this.f27345g = this.F.getMaxInfant();
            this.f27346h = this.F.getMaxPassengers();
            this.f27341c = this.F.getMaxPassengerAge();
        }
        if (cJRTrainDetailsBody.getBerth() != null) {
            this.K = cJRTrainDetailsBody.getBerth();
        }
    }

    public final void a(LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3) {
        this.N = linearLayout;
        this.O = linearLayout2;
        this.P = linearLayout3;
    }

    public final void a() {
        boolean z2;
        CJRTrainDetailsBody cJRTrainDetailsBody = this.T;
        if (cJRTrainDetailsBody != null && cJRTrainDetailsBody.getPassengerInfo() != null) {
            for (int i2 = 0; i2 < this.T.getPassengerInfo().size(); i2++) {
                CJRPassengerInfo cJRPassengerInfo = this.T.getPassengerInfo().get(i2);
                if (cJRPassengerInfo != null) {
                    if (cJRPassengerInfo.getmCategory().equalsIgnoreCase(this.x)) {
                        this.P.setVisibility(0);
                        a(true, false, false, false);
                        z2 = true;
                    } else {
                        a(false, false, false, false);
                        z2 = false;
                    }
                    a(cJRPassengerInfo, this.R - 1, z2);
                }
            }
        }
    }

    public final void a(ArrayList<CJRPassengerInfo> arrayList) {
        boolean z2;
        this.R = 0;
        this.S = 0;
        this.l.clear();
        this.N.removeAllViews();
        this.O.removeAllViews();
        if (arrayList != null) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                CJRPassengerInfo cJRPassengerInfo = arrayList.get(i2);
                if (cJRPassengerInfo != null) {
                    if (cJRPassengerInfo.getmCategory().equalsIgnoreCase(this.x)) {
                        this.j.b(0);
                        a(true, false, true, true);
                        z2 = true;
                    } else {
                        a(false, false, true, true);
                        z2 = false;
                    }
                    a(cJRPassengerInfo, this.R - 1, z2);
                }
            }
        }
    }

    private void a(CJRPassengerInfo cJRPassengerInfo, int i2, boolean z2) {
        View view;
        if (!z2) {
            LinearLayout linearLayout = this.N;
            if (!(linearLayout == null || linearLayout.getChildAt(linearLayout.getChildCount() - 1) == null)) {
                LinearLayout linearLayout2 = this.N;
                view = linearLayout2.getChildAt(linearLayout2.getChildCount() - 1);
                a(view, cJRPassengerInfo, z2);
                this.l.set(i2, cJRPassengerInfo);
            }
        } else {
            LinearLayout linearLayout3 = this.O;
            if (!(linearLayout3 == null || linearLayout3.getChildAt(linearLayout3.getChildCount() - 1) == null)) {
                LinearLayout linearLayout4 = this.O;
                view = linearLayout4.getChildAt(linearLayout4.getChildCount() - 1);
                a(view, cJRPassengerInfo, z2);
                this.l.set(i2, cJRPassengerInfo);
            }
        }
        view = null;
        a(view, cJRPassengerInfo, z2);
        this.l.set(i2, cJRPassengerInfo);
    }

    public final void a(ViewGroup viewGroup, TextView textView, String str, String str2, String str3, LinearLayout linearLayout, TextView textView2, CheckBox checkBox) {
        boolean z2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int parseInt = Integer.parseInt(str);
            if ((!str3.equalsIgnoreCase(g.V) || parseInt < 60) && ((!str3.equalsIgnoreCase(g.W) || parseInt < 58) && (!str3.equalsIgnoreCase(g.X) || parseInt < 60))) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2 && str2.equalsIgnoreCase(this.y)) {
                if (this.J) {
                    linearLayout.setVisibility(8);
                    checkBox.setChecked(true);
                    checkBox.setTag(this.A);
                    viewGroup.setVisibility(0);
                    if (str3.equalsIgnoreCase(g.V)) {
                        textView.setText(this.f27347i.getString(R.string.train_male_senior_text));
                        return;
                    } else if (str3.equalsIgnoreCase(g.W)) {
                        textView.setText(this.f27347i.getString(R.string.train_female_senior_text));
                        return;
                    } else {
                        textView.setText(this.f27347i.getString(R.string.train_transgender_senior_text));
                        return;
                    }
                } else {
                    if (g.f27551a == null || TextUtils.isEmpty(g.f27551a.getSeniorCitizenNoDiscountMessage())) {
                        textView2.setText(this.f27347i.getString(R.string.train_senior_no_discount_text));
                    } else {
                        textView2.setText(g.f27551a.getSeniorCitizenNoDiscountMessage());
                    }
                    viewGroup.setVisibility(8);
                    linearLayout.setVisibility(0);
                    return;
                }
            }
        }
        viewGroup.setVisibility(8);
        linearLayout.setVisibility(8);
    }

    public final void a(View view, boolean z2, String str, ImageView imageView) {
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.male_radio);
        RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.female_radio);
        RadioButton radioButton3 = (RadioButton) view.findViewById(R.id.transgender_radio);
        if (z2) {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_male, 0, 0);
            radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_female, 0, 0);
            if (g.f27551a != null && g.f27551a.isTransgenderEnabled()) {
                radioButton3.setVisibility(0);
            }
            if (str != null && imageView != null) {
                if (str.equalsIgnoreCase(g.V)) {
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_ic_button_senior_citizen_male));
                } else if (str.equalsIgnoreCase(g.W)) {
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_ic_button_senior_citizen_female));
                } else if (str.equalsIgnoreCase(g.X)) {
                    ResourceUtils.loadTrainImagesFromCDN(imageView, "ic_button_transgender.png", false, false, n.a.V1);
                }
            }
        } else {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_male, 0, 0);
            radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_female, 0, 0);
            radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_transgender, 0, 0);
            if (g.f27551a != null && g.f27551a.isTransgenderEnabled()) {
                radioButton3.setVisibility(0);
            }
            if (str != null && imageView != null) {
                if (str.equalsIgnoreCase(g.V)) {
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_male_tick));
                } else if (str.equalsIgnoreCase(g.W)) {
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_female_tick));
                } else if (str.equalsIgnoreCase(g.X)) {
                    ResourceUtils.loadTrainImagesFromCDN(imageView, "ic_button_transgender.png", false, false, n.a.V1);
                }
            }
        }
    }

    public final void a(String str, String str2, CheckBox checkBox, View view, String str3) {
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.male_radio);
        RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.female_radio);
        ((RadioButton) view.findViewById(R.id.transgender_radio)).setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_transgender, 0, 0);
        if (!TextUtils.isEmpty(str)) {
            int parseInt = Integer.parseInt(str);
            if (!this.J || !str3.equalsIgnoreCase(this.y) || !checkBox.isChecked()) {
                if (parseInt >= this.f27342d && parseInt <= this.C) {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_male_adult, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_female_adult, 0, 0);
                    return;
                }
            } else if (str2.equalsIgnoreCase(g.V)) {
                if (parseInt >= 60) {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_male, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_female, 0, 0);
                    return;
                } else if (parseInt < this.f27342d || parseInt > this.C) {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_male, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_female, 0, 0);
                    return;
                } else {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_male_adult, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_female_adult, 0, 0);
                    return;
                }
            } else if (str2.equalsIgnoreCase(g.W)) {
                if (parseInt > 57) {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_male, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_senior_citizen_female, 0, 0);
                    return;
                } else if (parseInt < this.f27342d || parseInt > this.C) {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_male, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_female, 0, 0);
                    return;
                } else {
                    radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_male_adult, 0, 0);
                    radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_female_adult, 0, 0);
                    return;
                }
            } else if (!str2.equalsIgnoreCase(g.X)) {
                return;
            }
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_male, 0, 0);
            radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_female, 0, 0);
        }
    }

    private void a(View view, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, Spinner spinner) {
        ArrayList<CJRTravellerBerth> arrayList;
        String str;
        View view2 = view;
        Spinner spinner2 = (Spinner) view2.findViewById(R.id.berth_preference);
        Spinner spinner3 = (Spinner) view2.findViewById(R.id.user_id);
        ArrayList arrayList2 = new ArrayList();
        new ArrayList();
        if (this.F != null && (arrayList = this.K) != null) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    arrayList2.add(arrayList.get(i2).getBerthName());
                }
                arrayList2.add(this.f27347i.getString(R.string.no_choice_berth));
            }
            ArrayList<String> validIdCardTypes = this.F.getValidIdCardTypes();
            ArrayList<String> foodDetailList = this.F.getFoodDetailList();
            ArrayList arrayList3 = new ArrayList();
            if (foodDetailList != null && foodDetailList.size() > 0) {
                for (int i3 = 0; i3 < foodDetailList.size(); i3++) {
                    String str2 = foodDetailList.get(i3);
                    char c2 = 65535;
                    int hashCode = str2.hashCode();
                    if (hashCode != 68) {
                        if (hashCode != 78) {
                            if (hashCode == 86 && str2.equals("V")) {
                                c2 = 1;
                            }
                        } else if (str2.equals(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                            c2 = 0;
                        }
                    } else if (str2.equals(UpiConstants.DEFAULT_ACCOUNT_CONSTANT)) {
                        c2 = 2;
                    }
                    if (c2 == 0) {
                        str = this.u;
                    } else if (c2 == 1) {
                        str = this.v;
                    } else if (c2 != 2) {
                        str = "";
                    } else {
                        str = this.w;
                    }
                    arrayList3.add(str);
                }
            }
            if (this.F != null) {
                if (this.G) {
                    relativeLayout.setVisibility(0);
                    a((ArrayList<String>) arrayList3, spinner, this.f27347i.getString(R.string.food_preference));
                }
                if (this.H) {
                    relativeLayout2.setVisibility(0);
                    a(validIdCardTypes, spinner3, this.f27347i.getString(R.string.type_of_id));
                }
                a((ArrayList<String>) arrayList2, spinner2, this.f27347i.getString(R.string.berth_preference));
                spinner2.setSelection(arrayList2.size());
                if (this.I) {
                    relativeLayout3.setVisibility(0);
                }
            }
        }
    }

    private void a(ArrayList<String> arrayList, Spinner spinner, String str) {
        int i2 = R.layout.pre_t_train_berth_spinner_item;
        Activity activity = this.f27347i;
        spinner.setAdapter(new e(i2, activity, arrayList, activity, str));
    }

    /* access modifiers changed from: package-private */
    public final void a(TextView textView, View view, String str) {
        textView.setText(str);
        view.setBackgroundColor(this.f27347i.getResources().getColor(R.color.train_regreat_color));
        textView.setVisibility(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:120:0x05cd  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0601  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x061f  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x062b  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x071d  */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x074c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r38, android.view.View r39, java.lang.String r40, boolean r41) {
        /*
            r37 = this;
            r0 = r37
            r1 = r39
            r2 = r40
            int r3 = com.travel.train.R.id.bert_preference_layout
            android.view.View r3 = r1.findViewById(r3)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            int r4 = com.travel.train.R.id.food_preference_layout
            android.view.View r4 = r1.findViewById(r4)
            android.widget.RelativeLayout r4 = (android.widget.RelativeLayout) r4
            int r5 = com.travel.train.R.id.user_id_layout
            android.view.View r5 = r1.findViewById(r5)
            android.widget.RelativeLayout r5 = (android.widget.RelativeLayout) r5
            int r6 = com.travel.train.R.id.senior_citizen_lyt
            android.view.View r6 = r1.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            int r7 = com.travel.train.R.id.radio_berth_choice
            android.view.View r7 = r1.findViewById(r7)
            android.widget.CheckBox r7 = (android.widget.CheckBox) r7
            int r8 = com.travel.train.R.id.radio_senior_citizen
            android.view.View r8 = r1.findViewById(r8)
            android.widget.CheckBox r8 = (android.widget.CheckBox) r8
            int r9 = com.travel.train.R.id.country_name
            android.view.View r9 = r1.findViewById(r9)
            android.widget.AutoCompleteTextView r9 = (android.widget.AutoCompleteTextView) r9
            int r10 = com.travel.train.R.id.bed_roll_lyt
            android.view.View r10 = r1.findViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            int r11 = com.travel.train.R.id.add_detailtext
            android.view.View r11 = r1.findViewById(r11)
            android.widget.TextView r11 = (android.widget.TextView) r11
            int r12 = com.travel.train.R.id.passenger_details_text
            android.view.View r12 = r1.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            int r13 = com.travel.train.R.id.country_choice_layout
            android.view.View r13 = r1.findViewById(r13)
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            int r14 = com.travel.train.R.id.child_berth_choice_lyt
            android.view.View r14 = r1.findViewById(r14)
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            int r15 = com.travel.train.R.id.add_passenger_layout
            android.view.View r15 = r1.findViewById(r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            r16 = r15
            int r15 = com.travel.train.R.id.passenger_info_layout
            android.view.View r15 = r1.findViewById(r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            r17 = r15
            int r15 = com.travel.train.R.id.gender_icon
            android.view.View r15 = r1.findViewById(r15)
            android.widget.ImageView r15 = (android.widget.ImageView) r15
            r18 = r12
            com.travel.train.helper.n$1 r12 = new com.travel.train.helper.n$1
            r12.<init>(r1, r2, r15)
            r8.setOnCheckedChangeListener(r12)
            com.travel.train.model.trainticket.CJRPassengerInfo r12 = new com.travel.train.model.trainticket.CJRPassengerInfo
            r12.<init>()
            r19 = r15
            int r15 = com.travel.train.R.id.full_name
            android.view.View r15 = r1.findViewById(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            r20 = r10
            int r10 = com.travel.train.R.id.name_error
            android.view.View r10 = r1.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            int r2 = com.travel.train.R.id.food_error
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r21 = r7
            int r7 = com.travel.train.R.id.age_error
            android.view.View r7 = r1.findViewById(r7)
            android.widget.TextView r7 = (android.widget.TextView) r7
            r22 = r14
            int r14 = com.travel.train.R.id.passport_error
            android.view.View r14 = r1.findViewById(r14)
            android.widget.TextView r14 = (android.widget.TextView) r14
            r23 = r8
            int r8 = com.travel.train.R.id.full_name_view
            android.view.View r8 = r1.findViewById(r8)
            r24 = r6
            int r6 = com.travel.train.R.id.age_view
            android.view.View r6 = r1.findViewById(r6)
            r25 = r13
            int r13 = com.travel.train.R.id.passport_number_view
            android.view.View r13 = r1.findViewById(r13)
            r26 = r9
            int r9 = com.travel.train.R.id.food_preference_view
            android.view.View r9 = r1.findViewById(r9)
            r27 = r4
            int r4 = com.travel.train.R.id.senior_citizen_lyt
            r1.findViewById(r4)
            int r4 = com.travel.train.R.id.age
            android.view.View r4 = r1.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r28 = r3
            int r3 = com.travel.train.R.id.user_id
            android.view.View r3 = r1.findViewById(r3)
            android.widget.Spinner r3 = (android.widget.Spinner) r3
            r29 = r3
            int r3 = com.travel.train.R.id.berth_preference
            android.view.View r3 = r1.findViewById(r3)
            android.widget.Spinner r3 = (android.widget.Spinner) r3
            r30 = r3
            int r3 = com.travel.train.R.id.food_preference
            android.view.View r3 = r1.findViewById(r3)
            android.widget.Spinner r3 = (android.widget.Spinner) r3
            r31 = r3
            int r3 = com.travel.train.R.id.id_number
            android.view.View r3 = r1.findViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            r32 = r3
            int r3 = com.travel.train.R.id.full_name_container
            r1.findViewById(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r1 = 8
            r10.setVisibility(r1)
            r7.setVisibility(r1)
            r14.setVisibility(r1)
            r2.setVisibility(r1)
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            r33 = r14
            int r14 = com.travel.train.R.color.payment_success_line_grey
            int r1 = r1.getColor(r14)
            r8.setBackgroundColor(r1)
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r14 = com.travel.train.R.color.payment_success_line_grey
            int r1 = r1.getColor(r14)
            r6.setBackgroundColor(r1)
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r14 = com.travel.train.R.color.payment_success_line_grey
            int r1 = r1.getColor(r14)
            r13.setBackgroundColor(r1)
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r14 = com.travel.train.R.color.payment_success_line_grey
            int r1 = r1.getColor(r14)
            r9.setBackgroundColor(r1)
            r15.setOnFocusChangeListener(r0)
            java.lang.CharSequence r1 = r15.getText()
            r14 = 0
            if (r1 == 0) goto L_0x01a0
            java.lang.CharSequence r1 = r15.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.trim()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01a0
            if (r41 != 0) goto L_0x0197
            r0.a((android.view.View) r15)
            java.lang.String r1 = r0.f27339a
            r0.a((android.widget.TextView) r10, (android.view.View) r8, (java.lang.String) r1)
            goto L_0x019f
        L_0x0197:
            r0.a((android.view.View) r15)
            java.lang.String r1 = r0.f27340b
            r0.a((android.widget.TextView) r10, (android.view.View) r8, (java.lang.String) r1)
        L_0x019f:
            return r14
        L_0x01a0:
            java.lang.String r1 = ""
            if (r15 != 0) goto L_0x01a5
            goto L_0x01b4
        L_0x01a5:
            java.lang.CharSequence r34 = r15.getText()
            if (r34 != 0) goto L_0x01ac
            goto L_0x01b4
        L_0x01ac:
            java.lang.CharSequence r1 = r15.getText()
            java.lang.String r1 = r1.toString()
        L_0x01b4:
            int r14 = r1.length()
            r35 = r13
            int r13 = r0.f27343e
            r36 = r2
            r2 = 1
            if (r14 < r13) goto L_0x0758
            java.lang.CharSequence r13 = r15.getText()
            java.lang.String r13 = r13.toString()
            int r13 = r13.length()
            int r14 = r0.f27344f
            if (r13 <= r14) goto L_0x01d3
            goto L_0x0758
        L_0x01d3:
            java.lang.String r13 = "[a-zA-z\\s]*"
            boolean r13 = r1.matches(r13)
            if (r13 != 0) goto L_0x01eb
            r0.a((android.view.View) r15)
            android.app.Activity r1 = r0.f27347i
            int r2 = com.travel.train.R.string.name_condition
            java.lang.String r1 = r1.getString(r2)
            r0.a((android.widget.TextView) r10, (android.view.View) r8, (java.lang.String) r1)
        L_0x01e9:
            r1 = 0
            return r1
        L_0x01eb:
            r12.setFullName(r1)
            r11.setText(r1)
            java.lang.CharSequence r1 = r4.getText()
            if (r1 == 0) goto L_0x0219
            int r1 = r4.length()
            if (r1 != 0) goto L_0x0219
            r0.a((android.view.View) r4)
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.passenger_empty_message
            java.lang.Object[] r2 = new java.lang.Object[r2]
            android.app.Activity r4 = r0.f27347i
            int r5 = com.travel.train.R.string.age
            java.lang.String r4 = r4.getString(r5)
            r5 = 0
            r2[r5] = r4
            java.lang.String r1 = r1.getString(r3, r2)
            r0.a((android.widget.TextView) r7, (android.view.View) r6, (java.lang.String) r1)
            return r5
        L_0x0219:
            java.lang.CharSequence r1 = r4.getText()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x0257
            if (r41 == 0) goto L_0x0257
            java.lang.CharSequence r1 = r4.getText()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            int r8 = r0.f27342d
            if (r1 < r8) goto L_0x0257
            r0.a((android.view.View) r4)
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.infant_child_age_error
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            int r5 = r0.f27342d
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r5 = 0
            r2[r5] = r4
            java.lang.String r1 = r1.getString(r3, r2)
            r0.a((android.widget.TextView) r7, (android.view.View) r6, (java.lang.String) r1)
            return r5
        L_0x0257:
            java.lang.CharSequence r1 = r4.getText()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x02ae
            if (r41 != 0) goto L_0x02ae
            java.lang.CharSequence r1 = r4.getText()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            int r8 = r0.f27341c
            if (r1 > r8) goto L_0x0283
            java.lang.CharSequence r1 = r4.getText()
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            int r8 = r0.f27342d
            if (r1 >= r8) goto L_0x02ae
        L_0x0283:
            r0.a((android.view.View) r4)
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.age_max_age
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r0.f27342d
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r8 = 0
            r4[r8] = r5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r9 = r0.f27341c
            r5.append(r9)
            java.lang.String r5 = r5.toString()
            r4[r2] = r5
            java.lang.String r1 = r1.getString(r3, r4)
            r0.a((android.widget.TextView) r7, (android.view.View) r6, (java.lang.String) r1)
            return r8
        L_0x02ae:
            java.lang.CharSequence r1 = r4.getText()
            java.lang.String r1 = r1.toString()
            r12.setAge(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.CharSequence r6 = r4.getText()
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r6 = " yrs"
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
            int r1 = r5.getVisibility()
            java.lang.String r5 = ", "
            if (r1 != 0) goto L_0x038d
            if (r29 == 0) goto L_0x030f
            java.lang.Object r1 = r29.getSelectedItem()
            if (r1 != 0) goto L_0x030f
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.train_travellers_error
            java.lang.String r3 = r1.getString(r3)
            android.app.Activity r4 = r0.f27347i
            int r5 = com.travel.train.R.string.passenger_form_empty_message
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            android.app.Activity r7 = r0.f27347i
            int r8 = com.travel.train.R.string.user_id
            java.lang.String r7 = r7.getString(r8)
            r8 = 0
            r6[r8] = r7
            int r7 = r38 + 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6[r2] = r7
            java.lang.String r2 = r4.getString(r5, r6)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r2)
            return r8
        L_0x030f:
            java.lang.Object r1 = r29.getSelectedItem()
            if (r1 == 0) goto L_0x0337
            java.lang.Object r1 = r29.getSelectedItem()
            java.lang.String r1 = r1.toString()
            r12.setIdentity(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.Object r6 = r29.getSelectedItem()
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
        L_0x0337:
            android.text.Editable r1 = r32.getText()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x036b
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.train_travellers_error
            java.lang.String r3 = r1.getString(r3)
            android.app.Activity r4 = r0.f27347i
            int r5 = com.travel.train.R.string.passenger_form_empty_message
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            android.app.Activity r7 = r0.f27347i
            int r8 = com.travel.train.R.string.id_nunber
            java.lang.String r7 = r7.getString(r8)
            r8 = 0
            r6[r8] = r7
            int r7 = r38 + 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6[r2] = r7
            java.lang.String r2 = r4.getString(r5, r6)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r2)
            return r8
        L_0x036b:
            android.text.Editable r1 = r32.getText()
            java.lang.String r1 = r1.toString()
            r12.setIdNumber(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            android.text.Editable r6 = r32.getText()
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
        L_0x038d:
            int r1 = r28.getVisibility()
            if (r1 != 0) goto L_0x03eb
            java.lang.Object r1 = r30.getSelectedItem()
            if (r1 != 0) goto L_0x03c3
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.train_travellers_error
            java.lang.String r3 = r1.getString(r3)
            android.app.Activity r4 = r0.f27347i
            int r5 = com.travel.train.R.string.passenger_form_empty_message
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            android.app.Activity r7 = r0.f27347i
            int r8 = com.travel.train.R.string.berth_preference
            java.lang.String r7 = r7.getString(r8)
            r8 = 0
            r6[r8] = r7
            int r7 = r38 + 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6[r2] = r7
            java.lang.String r2 = r4.getString(r5, r6)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r2)
            return r8
        L_0x03c3:
            java.lang.Object r1 = r30.getSelectedItem()
            if (r1 == 0) goto L_0x03eb
            java.lang.Object r1 = r30.getSelectedItem()
            java.lang.String r1 = r1.toString()
            r12.setBerthPreference(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.Object r6 = r30.getSelectedItem()
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
        L_0x03eb:
            int r1 = r27.getVisibility()
            if (r1 != 0) goto L_0x042f
            java.lang.Object r1 = r31.getSelectedItem()
            if (r1 != 0) goto L_0x0405
            r1 = r31
            r0.a((android.view.View) r1)
            java.lang.String r1 = r0.B
            r2 = r36
            r0.a((android.widget.TextView) r2, (android.view.View) r9, (java.lang.String) r1)
            goto L_0x01e9
        L_0x0405:
            r1 = r31
            java.lang.Object r6 = r1.getSelectedItem()
            if (r6 == 0) goto L_0x042f
            java.lang.Object r6 = r1.getSelectedItem()
            java.lang.String r6 = r6.toString()
            r12.setMealPreference(r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.Object r1 = r1.getSelectedItem()
            java.lang.String r1 = r1.toString()
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            r3.append(r1)
        L_0x042f:
            android.text.Editable r1 = r26.getText()
            int r1 = r1.length()
            if (r1 != 0) goto L_0x045f
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.train_travellers_error
            java.lang.String r3 = r1.getString(r3)
            android.app.Activity r4 = r0.f27347i
            int r5 = com.travel.train.R.string.passenger_form_empty_message
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            java.lang.CharSequence r7 = r26.getHint()
            r8 = 0
            r6[r8] = r7
            int r7 = r38 + 1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6[r2] = r7
            java.lang.String r2 = r4.getString(r5, r6)
            com.paytm.utility.b.b((android.content.Context) r1, (java.lang.String) r3, (java.lang.String) r2)
            return r8
        L_0x045f:
            int r1 = r25.getVisibility()
            if (r1 != 0) goto L_0x05a6
            android.text.Editable r1 = r26.getText()
            if (r1 == 0) goto L_0x05a6
            android.text.Editable r1 = r26.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r6 = r0.y
            boolean r1 = r1.equalsIgnoreCase(r6)
            if (r1 == 0) goto L_0x0498
            java.lang.String r1 = r0.z
            r12.setCountryCode(r1)
            java.lang.String r1 = r0.y
            r12.setmCountryName(r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            java.lang.String r5 = r0.y
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
            goto L_0x05a6
        L_0x0498:
            com.travel.train.i.z r1 = r0.j
            java.util.ArrayList r1 = r1.b()
            if (r1 == 0) goto L_0x0500
            com.travel.train.i.z r1 = r0.j
            java.util.ArrayList r1 = r1.b()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0500
            r1 = 0
        L_0x04ad:
            com.travel.train.i.z r6 = r0.j
            java.util.ArrayList r6 = r6.b()
            int r6 = r6.size()
            if (r1 >= r6) goto L_0x0500
            android.text.Editable r6 = r26.getText()
            java.lang.String r6 = r6.toString()
            com.travel.train.i.z r7 = r0.j
            java.util.ArrayList r7 = r7.b()
            java.lang.Object r7 = r7.get(r1)
            com.travel.train.model.trainticket.CJRCountryCode r7 = (com.travel.train.model.trainticket.CJRCountryCode) r7
            java.lang.String r7 = r7.getCountryName()
            boolean r6 = r6.equalsIgnoreCase(r7)
            if (r6 == 0) goto L_0x04fd
            com.travel.train.i.z r6 = r0.j
            java.util.ArrayList r6 = r6.b()
            java.lang.Object r6 = r6.get(r1)
            com.travel.train.model.trainticket.CJRCountryCode r6 = (com.travel.train.model.trainticket.CJRCountryCode) r6
            java.lang.String r6 = r6.getCountryCode()
            r12.setCountryCode(r6)
            com.travel.train.i.z r6 = r0.j
            java.util.ArrayList r6 = r6.b()
            java.lang.Object r6 = r6.get(r1)
            com.travel.train.model.trainticket.CJRCountryCode r6 = (com.travel.train.model.trainticket.CJRCountryCode) r6
            java.lang.String r6 = r6.getCountryName()
            r12.setmCountryName(r6)
        L_0x04fd:
            int r1 = r1 + 1
            goto L_0x04ad
        L_0x0500:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r5)
            android.text.Editable r6 = r26.getText()
            java.lang.String r6 = r6.toString()
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r3.append(r1)
            int r1 = com.travel.train.R.id.passport_number
            r6 = r39
            r7 = 8
            android.view.View r1 = r6.findViewById(r1)
            android.widget.EditText r1 = (android.widget.EditText) r1
            android.text.Editable r8 = r1.getText()
            if (r8 == 0) goto L_0x05aa
            android.text.Editable r8 = r1.getText()
            int r8 = r8.length()
            if (r8 == 0) goto L_0x0592
            android.text.Editable r8 = r1.getText()
            int r8 = r8.length()
            r9 = 6
            if (r8 < r9) goto L_0x0592
            android.text.Editable r8 = r1.getText()
            int r8 = r8.length()
            r9 = 10
            if (r8 > r9) goto L_0x0592
            android.text.Editable r8 = r1.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "^(?=.*\\d)(?=.*[a-zA-Z]*).{6,10}$"
            boolean r8 = r8.matches(r9)
            if (r8 == 0) goto L_0x0592
            android.text.Editable r8 = r1.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "[a-zA-Z0-9]*"
            boolean r8 = r8.matches(r9)
            if (r8 != 0) goto L_0x056b
            goto L_0x0592
        L_0x056b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r5)
            android.text.Editable r5 = r1.getText()
            java.lang.String r5 = r5.toString()
            r8.append(r5)
            java.lang.String r5 = r8.toString()
            r3.append(r5)
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = r1.toUpperCase()
            r12.setPassportNumber(r1)
            goto L_0x05aa
        L_0x0592:
            r0.a((android.view.View) r1)
            android.app.Activity r1 = r0.f27347i
            int r2 = com.travel.train.R.string.passport_error_message
            java.lang.String r1 = r1.getString(r2)
            r14 = r33
            r2 = r35
            r0.a((android.widget.TextView) r14, (android.view.View) r2, (java.lang.String) r1)
            goto L_0x01e9
        L_0x05a6:
            r6 = r39
            r7 = 8
        L_0x05aa:
            if (r24 == 0) goto L_0x05c7
            int r1 = r24.getVisibility()
            if (r1 != 0) goto L_0x05c7
            if (r23 == 0) goto L_0x05c7
            boolean r1 = r23.isChecked()
            if (r1 == 0) goto L_0x05c7
            r12.setIsSeniorCityZen(r2)
            com.travel.train.i.z r1 = r0.j
            int r5 = r1.c()
            int r5 = r5 + r2
            r1.a((int) r5)
        L_0x05c7:
            int r1 = r22.getVisibility()
            if (r1 != 0) goto L_0x05db
            boolean r1 = r21.isChecked()
            if (r1 == 0) goto L_0x05d7
            r12.setIsBerthFlag(r2)
            goto L_0x05db
        L_0x05d7:
            r1 = 0
            r12.setIsBerthFlag(r1)
        L_0x05db:
            r1 = r40
            r12.setTIttle(r1)
            java.lang.Object r5 = r39.getTag()
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            if (r1 == 0) goto L_0x05fb
            java.lang.CharSequence r8 = r4.getText()
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = r0.a((java.lang.String) r1, (java.lang.String) r8)
            r12.setmCategory(r8)
        L_0x05fb:
            int r8 = r20.getVisibility()
            if (r8 != 0) goto L_0x0617
            int r8 = com.travel.train.R.id.bed_roll_radio
            android.view.View r6 = r6.findViewById(r8)
            android.widget.CheckBox r6 = (android.widget.CheckBox) r6
            boolean r6 = r6.isChecked()
            if (r6 == 0) goto L_0x0613
            r12.setBedRollChoice(r2)
            goto L_0x0617
        L_0x0613:
            r6 = 0
            r12.setBedRollChoice(r6)
        L_0x0617:
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r6 = r0.l
            int r6 = r6.size()
            if (r5 >= r6) goto L_0x0624
            java.util.ArrayList<com.travel.train.model.trainticket.CJRPassengerInfo> r6 = r0.l
            r6.set(r5, r12)
        L_0x0624:
            r12 = r18
            r12.setText(r3)
            if (r41 != 0) goto L_0x071d
            java.lang.String r3 = com.travel.train.j.g.X
            boolean r3 = r1.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x0712
            java.lang.CharSequence r3 = r4.getText()
            java.lang.String r3 = r3.toString()
            int r3 = java.lang.Integer.parseInt(r3)
            java.lang.String r4 = com.travel.train.j.g.V
            boolean r4 = r1.equalsIgnoreCase(r4)
            r5 = 60
            if (r4 == 0) goto L_0x0677
            if (r3 < r5) goto L_0x0677
            boolean r1 = r23.isChecked()
            if (r1 == 0) goto L_0x0664
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_ic_button_senior_citizen_male
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15 = r19
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x0664:
            r15 = r19
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_male_tick
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x0677:
            r15 = r19
            java.lang.String r4 = com.travel.train.j.g.W
            boolean r4 = r1.equalsIgnoreCase(r4)
            r6 = 58
            if (r4 == 0) goto L_0x06ad
            if (r3 < r6) goto L_0x06ad
            boolean r1 = r23.isChecked()
            if (r1 == 0) goto L_0x069c
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_ic_button_senior_citizen_female
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x069c:
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_female_tick
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x06ad:
            java.lang.String r4 = com.travel.train.j.g.V
            boolean r4 = r1.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x06e0
            if (r3 >= r5) goto L_0x06e0
            int r1 = r0.f27342d
            if (r3 < r1) goto L_0x06d0
            int r1 = r0.C
            if (r3 > r1) goto L_0x06d0
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_child_male_selected
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x06d0:
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_male_tick
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x06e0:
            java.lang.String r4 = com.travel.train.j.g.W
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x0746
            if (r3 >= r6) goto L_0x0746
            int r1 = r0.f27342d
            if (r3 < r1) goto L_0x0702
            int r1 = r0.C
            if (r3 > r1) goto L_0x0702
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_child_female_selected
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x0702:
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_female_tick
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x0712:
            r15 = r19
            com.travel.utils.n$a r1 = com.travel.utils.n.a.V1
            java.lang.String r3 = "ic_button_transgender.png"
            r4 = 0
            com.travel.cdn.ResourceUtils.loadTrainImagesFromCDN(r15, r3, r4, r4, r1)
            goto L_0x0746
        L_0x071d:
            r15 = r19
            java.lang.String r3 = com.travel.train.j.g.V
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0737
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_ic_button_child_male
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
            goto L_0x0746
        L_0x0737:
            android.app.Activity r1 = r0.f27347i
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.travel.train.R.drawable.pre_t_ic_button_child_female
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r15.setImageDrawable(r1)
        L_0x0746:
            int r1 = r17.getVisibility()
            if (r1 != 0) goto L_0x0757
            r15 = r17
            r15.setVisibility(r7)
            r15 = r16
            r1 = 0
            r15.setVisibility(r1)
        L_0x0757:
            return r2
        L_0x0758:
            if (r41 != 0) goto L_0x077e
            r0.a((android.view.View) r15)
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.passenger_fullname_error
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r0.f27343e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 0
            r4[r6] = r5
            int r5 = r0.f27344f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r2] = r5
            java.lang.String r1 = r1.getString(r3, r4)
            r0.a((android.widget.TextView) r10, (android.view.View) r8, (java.lang.String) r1)
            r6 = 0
            goto L_0x07a0
        L_0x077e:
            r0.a((android.view.View) r15)
            android.app.Activity r1 = r0.f27347i
            int r3 = com.travel.train.R.string.child_passenger_fullname_error
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r5 = r0.f27343e
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r6 = 0
            r4[r6] = r5
            int r5 = r0.f27344f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r2] = r5
            java.lang.String r1 = r1.getString(r3, r4)
            r0.a((android.widget.TextView) r10, (android.view.View) r8, (java.lang.String) r1)
        L_0x07a0:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.helper.n.a(int, android.view.View, java.lang.String, boolean):boolean");
    }

    private void a(View view) {
        view.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) this.f27347i.getSystemService("input_method");
        inputMethodManager.showSoftInput(view, 1);
        inputMethodManager.toggleSoftInput(2, 0);
    }

    private String a(String str, String str2) {
        int parseInt = Integer.parseInt(str2);
        if (str.equalsIgnoreCase(g.V)) {
            if (parseInt < this.f27342d || parseInt > this.C) {
                if (parseInt > this.C && parseInt < this.D) {
                    return "AM";
                }
                if (parseInt >= this.D) {
                    return "SM";
                }
                return "IF";
            }
        } else if (str.equalsIgnoreCase(g.W)) {
            if (parseInt < this.f27342d || parseInt > this.C) {
                if (parseInt > this.C && parseInt < this.E) {
                    return "AF";
                }
                if (parseInt >= this.E) {
                    return "SW";
                }
                return "IF";
            }
        } else if (!str.equalsIgnoreCase(g.X)) {
            return "";
        } else {
            if (parseInt < this.f27342d || parseInt > this.C) {
                if (parseInt > this.C) {
                    return "AT";
                }
                return "IF";
            }
        }
        return "CH";
    }

    /* JADX WARNING: type inference failed for: r8v7, types: [boolean] */
    /* JADX WARNING: type inference failed for: r8v8 */
    /* JADX WARNING: type inference failed for: r8v14 */
    public final void a(boolean z2, boolean z3, boolean z4, boolean z5) {
        final ImageView imageView;
        ? r8;
        ImageView imageView2;
        boolean z6;
        int i2;
        n nVar;
        boolean z7;
        boolean z8 = z2;
        boolean z9 = z5;
        this.S++;
        HashMap hashMap = new HashMap();
        hashMap.put(d.o, "add");
        o.a("train_traveller_details", this.j.g().getmSourceCityName(), this.j.g().getmDestCityName(), this.j.g().getmDate(), (String) null, (String) null, (String) null, "add_rem_traveller", "/trains/traveller-details", this.f27347i, hashMap);
        String[] strArr = {g.V};
        final View inflate = this.f27347i.getLayoutInflater().inflate(R.layout.pre_t_train_passenger_detail_layout, (ViewGroup) null);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.delete_passenger);
        imageView3.setTag(Integer.valueOf(this.S));
        final TextView textView = (TextView) inflate.findViewById(R.id.age_error);
        final View findViewById = inflate.findViewById(R.id.age_view);
        EditText editText = (EditText) inflate.findViewById(R.id.age);
        HashMap hashMap2 = hashMap;
        AnonymousClass9 r9 = r0;
        final EditText editText2 = editText;
        final EditText editText3 = editText;
        final boolean z10 = z2;
        AnonymousClass9 r0 = new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (!z) {
                    n nVar = n.this;
                    EditText editText = editText2;
                    TextView textView = textView;
                    View view2 = findViewById;
                    boolean z2 = z10;
                    boolean z3 = false;
                    if (editText.getText() != null && editText.length() == 0) {
                        nVar.a(textView, view2, nVar.f27347i.getString(R.string.passenger_empty_message, new Object[]{nVar.f27347i.getString(R.string.age)}));
                    } else if (editText.getText().length() > 0 && z2 && Integer.parseInt(editText.getText().toString()) >= nVar.f27342d) {
                        Activity activity = nVar.f27347i;
                        int i2 = R.string.infant_child_age_error;
                        StringBuilder sb = new StringBuilder();
                        sb.append(nVar.f27342d);
                        nVar.a(textView, view2, activity.getString(i2, new Object[]{sb.toString()}));
                    } else if (editText.getText().length() <= 0 || z2 || (Integer.parseInt(editText.getText().toString()) <= nVar.f27341c && Integer.parseInt(editText.getText().toString()) >= nVar.f27342d)) {
                        z3 = true;
                    } else {
                        Activity activity2 = nVar.f27347i;
                        int i3 = R.string.age_max_age;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(nVar.f27341c);
                        nVar.a(textView, view2, activity2.getString(i3, new Object[]{Integer.valueOf(nVar.f27342d), sb2.toString()}));
                    }
                    if (!z3) {
                        return;
                    }
                    return;
                }
                HashMap hashMap = new HashMap();
                hashMap.put(d.q, n.this.f27347i.getString(R.string.age));
                o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_field_clicked", "/trains/traveller-details", n.this.f27347i, hashMap);
            }
        };
        editText3.setOnFocusChangeListener(r9);
        b(inflate);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) inflate.findViewById(R.id.full_name);
        final RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.bert_preference_layout);
        RelativeLayout relativeLayout2 = (RelativeLayout) inflate.findViewById(R.id.food_preference_layout);
        Spinner spinner = (Spinner) inflate.findViewById(R.id.food_preference);
        RelativeLayout relativeLayout3 = (RelativeLayout) inflate.findViewById(R.id.user_id_layout);
        RadioGroup radioGroup = (RadioGroup) inflate.findViewById(R.id.passenger_type_radio);
        ((RadioButton) radioGroup.findViewById(R.id.male_radio)).setText(this.f27347i.getResources().getString(R.string.male));
        ((RadioButton) radioGroup.findViewById(R.id.female_radio)).setText(this.f27347i.getResources().getString(R.string.female));
        ((RadioButton) radioGroup.findViewById(R.id.transgender_radio)).setText(this.f27347i.getResources().getString(R.string.transgenders));
        RelativeLayout relativeLayout4 = (RelativeLayout) inflate.findViewById(R.id.senior_citizen_lyt);
        final RelativeLayout relativeLayout5 = (RelativeLayout) inflate.findViewById(R.id.bed_roll_lyt);
        ((CheckBox) inflate.findViewById(R.id.bed_roll_radio)).setChecked(true);
        AutoCompleteTextView autoCompleteTextView2 = (AutoCompleteTextView) inflate.findViewById(R.id.country_name);
        TextView textView2 = (TextView) inflate.findViewById(R.id.train_passenger_count);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.senior_no_discount_lyt);
        TextView textView3 = (TextView) inflate.findViewById(R.id.no_discount_txt);
        TextView textView4 = (TextView) inflate.findViewById(R.id.senior_citizen_text);
        autoCompleteTextView2.setText("India");
        b(inflate);
        autoCompleteTextView2.setOnClickListener(new a(autoCompleteTextView2, (LinearLayout) inflate.findViewById(R.id.passport_number_lyt)));
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.radio_berth_choice);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.country_choice_layout);
        inflate.findViewById(R.id.child_berth_choice_lyt);
        checkBox.setChecked(true);
        RoboTextView roboTextView = (RoboTextView) inflate.findViewById(R.id.save_button);
        ((ImageView) inflate.findViewById(R.id.name_clear)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                autoCompleteTextView.setText("");
            }
        });
        ((ImageView) inflate.findViewById(R.id.age_clear)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                editText3.setText("");
            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    if (n.this.I) {
                        relativeLayout5.setVisibility(0);
                    }
                    relativeLayout.setVisibility(0);
                    return;
                }
                relativeLayout.setVisibility(8);
                relativeLayout5.setVisibility(8);
            }
        });
        CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.radio_senior_citizen);
        this.k.add(checkBox2);
        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                n nVar = n.this;
                n.a(nVar, "train_traveller_details_senior_citizen_clicked", b.n(nVar.f27347i.getApplicationContext()) != null ? b.n(nVar.f27347i.getApplicationContext()) : "");
                n.this.a(inflate, z, (String) null, (ImageView) null);
            }
        });
        Activity activity = this.f27347i;
        String str = strArr[0];
        String obj = autoCompleteTextView2.getText().toString();
        TextView textView5 = (TextView) inflate.findViewById(R.id.passenger_count);
        RelativeLayout relativeLayout6 = relativeLayout5;
        o oVar = r0;
        TextView textView6 = textView2;
        LinearLayout linearLayout3 = linearLayout2;
        RoboTextView roboTextView2 = roboTextView;
        RadioGroup radioGroup2 = radioGroup;
        RelativeLayout relativeLayout7 = relativeLayout;
        RelativeLayout relativeLayout8 = (RelativeLayout) inflate.findViewById(R.id.passenger_info_layout);
        TextView textView7 = textView5;
        o oVar2 = new o(activity, z2, str, inflate, obj, this.F);
        editText3.addTextChangedListener(oVar);
        final o oVar3 = oVar;
        final AutoCompleteTextView autoCompleteTextView3 = autoCompleteTextView2;
        final boolean z11 = z2;
        final RelativeLayout relativeLayout9 = relativeLayout4;
        o oVar4 = oVar;
        AnonymousClass14 r15 = r0;
        final TextView textView8 = textView4;
        ImageView imageView4 = imageView3;
        final EditText editText4 = editText3;
        View view = inflate;
        final RadioGroup radioGroup3 = radioGroup2;
        AutoCompleteTextView autoCompleteTextView4 = autoCompleteTextView;
        final LinearLayout linearLayout4 = linearLayout;
        EditText editText5 = editText3;
        final TextView textView9 = textView3;
        String[] strArr2 = strArr;
        final CheckBox checkBox3 = checkBox2;
        CheckBox checkBox4 = checkBox2;
        AutoCompleteTextView autoCompleteTextView5 = autoCompleteTextView2;
        final View view2 = view;
        AnonymousClass14 r02 = new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                oVar3.f27433e = autoCompleteTextView3.getText().toString();
                if (!z11) {
                    n.this.a(relativeLayout9, textView8, editText4.getText().toString(), autoCompleteTextView3.getText().toString(), n.a(radioGroup3.getCheckedRadioButtonId()), linearLayout4, textView9, checkBox3);
                    n.this.a(editText4.getText().toString(), n.a(radioGroup3.getCheckedRadioButtonId()), checkBox3, view2, autoCompleteTextView3.getText().toString());
                }
            }
        };
        autoCompleteTextView5.addTextChangedListener(r15);
        View view3 = view;
        view3.setTag(Integer.valueOf(this.R));
        AutoCompleteTextView autoCompleteTextView6 = autoCompleteTextView4;
        autoCompleteTextView6.setDropDownWidth(b.a(this.f27347i));
        boolean z12 = z2;
        o oVar5 = oVar4;
        a(autoCompleteTextView6, view3, z12, this.S);
        if (!z12) {
            a(view3, relativeLayout2, relativeLayout3, relativeLayout6, spinner);
            imageView = imageView4;
            imageView.setTag(Integer.valueOf(this.R));
            final boolean z13 = z5;
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (z13 && n.this.U) {
                        boolean unused = n.this.U = false;
                    }
                    n.this.j.a((View) imageView);
                }
            });
        } else {
            boolean z14 = z5;
            imageView = imageView4;
            relativeLayout7.setVisibility(8);
            linearLayout3.setVisibility(8);
            imageView.setTag(Integer.valueOf(this.R));
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    n.this.j.b(view);
                }
            });
        }
        TextView textView10 = (TextView) view3.findViewById(R.id.add_detailtext);
        textView10.setText("");
        RelativeLayout relativeLayout10 = (RelativeLayout) view3.findViewById(R.id.add_passenger_layout);
        TextView textView11 = (TextView) view3.findViewById(R.id.passenger_details_text);
        if (z12) {
            textView10.setText(this.f27347i.getString(R.string.add_infants_detail));
            textView10.setText("");
        }
        HashMap hashMap3 = new HashMap();
        hashMap2.put(d.p, this.f27347i.getString(R.string.male));
        o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_gender_selected", "/trains/traveller-details", this.f27347i, hashMap3);
        final boolean z15 = z2;
        final RelativeLayout relativeLayout11 = relativeLayout4;
        final TextView textView12 = textView4;
        AnonymousClass2 r14 = r0;
        final EditText editText6 = editText5;
        final AutoCompleteTextView autoCompleteTextView7 = autoCompleteTextView5;
        RelativeLayout relativeLayout12 = relativeLayout10;
        final LinearLayout linearLayout5 = linearLayout;
        TextView textView13 = textView10;
        final TextView textView14 = textView3;
        final CheckBox checkBox5 = checkBox4;
        ImageView imageView5 = imageView;
        final View view4 = view3;
        final HashMap hashMap4 = hashMap2;
        final String[] strArr3 = strArr2;
        RelativeLayout relativeLayout13 = relativeLayout12;
        final o oVar6 = oVar5;
        AnonymousClass2 r03 = new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                int i3 = i2;
                if (!z15) {
                    n.this.a(relativeLayout11, textView12, editText6.getText().toString(), autoCompleteTextView7.getText().toString(), n.a(i2), linearLayout5, textView14, checkBox5);
                    n.this.a(editText6.getText().toString(), n.a(i2), checkBox5, view4, autoCompleteTextView7.getText().toString());
                }
                if (i3 == R.id.male_radio) {
                    HashMap hashMap = new HashMap();
                    hashMap4.put(d.p, n.this.f27347i.getString(R.string.male));
                    o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_gender_selected", "/trains/traveller-details", n.this.f27347i, hashMap);
                    strArr3[0] = g.V;
                    oVar6.f27429a = strArr3[0];
                } else if (i3 == R.id.female_radio) {
                    HashMap hashMap2 = new HashMap();
                    hashMap4.put(d.p, n.this.f27347i.getString(R.string.female));
                    o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_gender_selected", "/trains/traveller-details", n.this.f27347i, hashMap2);
                    strArr3[0] = g.W;
                    oVar6.f27429a = strArr3[0];
                    if (editText6.getText().length() > 0) {
                        Integer.parseInt(editText6.getText().toString());
                        int unused = n.this.E;
                    }
                } else if (i3 == R.id.transgender_radio) {
                    HashMap hashMap3 = new HashMap();
                    hashMap4.put(d.p, n.this.f27347i.getString(R.string.transgenders));
                    o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_gender_selected", "/trains/traveller-details", n.this.f27347i, hashMap3);
                    strArr3[0] = g.X;
                    oVar6.f27429a = strArr3[0];
                }
            }
        };
        radioGroup2.setOnCheckedChangeListener(r14);
        final TextView textView15 = textView6;
        final View view5 = view3;
        final String[] strArr4 = strArr2;
        final boolean z16 = z2;
        final boolean z17 = z5;
        final RelativeLayout relativeLayout14 = relativeLayout13;
        final TextView textView16 = textView13;
        final TextView textView17 = textView11;
        final RelativeLayout relativeLayout15 = relativeLayout8;
        AnonymousClass3 r04 = new View.OnClickListener() {
            public final void onClick(View view) {
                n nVar = n.this;
                try {
                    InputMethodManager inputMethodManager = (InputMethodManager) nVar.f27347i.getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.hideSoftInputFromWindow(nVar.f27347i.getCurrentFocus().getWindowToken(), 0);
                    }
                } catch (Exception e2) {
                    if (b.v) {
                        q.c(e2.getMessage());
                    }
                }
                if (n.this.a(n.a(textView15) - 1, view5, strArr4[0], z16)) {
                    if (z17) {
                        boolean unused = n.this.U = false;
                    }
                    relativeLayout14.setVisibility(0);
                    textView16.setText(((TextView) view5.findViewById(R.id.full_name)).getText().toString());
                    textView17.setVisibility(0);
                    view5.findViewById(R.id.passenger_info_layout).setVisibility(8);
                    relativeLayout15.setVisibility(8);
                }
            }
        };
        final RoboTextView roboTextView3 = roboTextView2;
        roboTextView3.setOnClickListener(r04);
        final boolean z18 = z5;
        final TextView textView18 = textView13;
        final RelativeLayout relativeLayout16 = relativeLayout13;
        final RelativeLayout relativeLayout17 = relativeLayout8;
        AnonymousClass4 r05 = new View.OnClickListener() {
            public final void onClick(View view) {
                roboTextView3.setVisibility(0);
                if (z18) {
                    boolean unused = n.this.U = true;
                }
                textView18.setText("");
                relativeLayout16.setVisibility(8);
                relativeLayout17.setVisibility(0);
            }
        };
        RelativeLayout relativeLayout18 = relativeLayout13;
        relativeLayout18.setOnClickListener(r05);
        if (!z2) {
            nVar = this;
            if (nVar.N.getChildCount() < nVar.f27346h) {
                LinearLayout linearLayout6 = nVar.N;
                if (linearLayout6 == null || linearLayout6.getChildCount() <= 0) {
                    imageView2 = imageView5;
                    z6 = false;
                    z7 = true;
                    nVar.l.add((Object) null);
                    nVar.N.addView(view3);
                    textView7.setText(String.valueOf(nVar.N.getChildCount()));
                    textView6.setText("# " + nVar.N.getChildCount());
                    if (z5) {
                        nVar.U = false;
                    }
                    nVar.R++;
                } else if (nVar.N.getChildCount() > 0) {
                    z6 = false;
                    ((RelativeLayout.LayoutParams) relativeLayout8.getLayoutParams()).setMargins(0, 17, 0, 0);
                    view3.setPadding(0, 17, 0, 0);
                    nVar.l.add((Object) null);
                    nVar.N.addView(view3);
                    textView7.setText(String.valueOf(nVar.N.getChildCount()));
                    textView6.setText("# " + nVar.N.getChildCount());
                    imageView2 = imageView5;
                    imageView2.setVisibility(0);
                    if (z5) {
                        if (nVar.N.getChildCount() == 2 && nVar.N.getChildAt(0).findViewById(R.id.passenger_info_layout).getVisibility() != 0) {
                            nVar.N.getChildAt(0).findViewById(R.id.delete_passenger).setVisibility(0);
                        }
                        nVar.U = false;
                    }
                    z7 = true;
                    nVar.R++;
                } else {
                    imageView2 = imageView5;
                    z6 = false;
                    z7 = true;
                }
            } else {
                imageView2 = imageView5;
                z6 = false;
                z7 = true;
                Activity activity2 = nVar.f27347i;
                b.b((Context) activity2, activity2.getString(R.string.train_travellers_error), nVar.f27347i.getString(R.string.maximum_number_of_passenger, new Object[]{Integer.valueOf(nVar.f27346h)}));
            }
            i2 = 8;
            r8 = z7;
        } else {
            nVar = this;
            TextView textView19 = textView6;
            TextView textView20 = textView7;
            imageView2 = imageView5;
            z6 = false;
            r8 = 1;
            if (nVar.O.getChildCount() < nVar.f27345g) {
                view3.setPadding(0, 15, 0, 0);
                nVar.l.add((Object) null);
                nVar.O.addView(view3);
                textView20.setText(String.valueOf(nVar.O.getChildCount()));
                textView19.setText("# " + nVar.O.getChildCount());
                imageView2.setVisibility(0);
                if (z5) {
                    nVar.U = false;
                }
                nVar.R++;
            } else {
                Activity activity3 = nVar.f27347i;
                b.b((Context) activity3, activity3.getString(R.string.train_travellers_error), nVar.f27347i.getString(R.string.maximum_number_of_infant, new Object[]{Integer.valueOf(nVar.f27345g)}));
            }
            if (nVar.O.getChildCount() <= 0) {
                i2 = 8;
                nVar.j.b(8);
            } else {
                i2 = 8;
                nVar.j.b(0);
            }
        }
        if (z5) {
            if (nVar.N.getChildCount() > r8) {
                nVar.N.getChildAt(z6).findViewById(R.id.delete_passenger).setVisibility(z6);
            }
            if (z4) {
                relativeLayout18.setVisibility(z6);
                relativeLayout8.setVisibility(i2);
                return;
            }
            relativeLayout18.setVisibility(i2);
            relativeLayout8.setVisibility(z6);
            return;
        }
        RelativeLayout relativeLayout19 = relativeLayout8;
        if (z3) {
            relativeLayout18.setClickable(r8);
            relativeLayout18.setVisibility(i2);
            relativeLayout19.setVisibility(z6);
            if (nVar.N.getChildCount() > r8) {
                nVar.N.getChildAt(z6).findViewById(R.id.delete_passenger).setVisibility(z6);
                return;
            }
            return;
        }
        relativeLayout18.setClickable(z6);
        relativeLayout19.setVisibility(i2);
        imageView2.setVisibility(4);
        relativeLayout18.setVisibility(z6 ? 1 : 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0262 A[EDGE_INSN: B:108:0x0262->B:76:0x0262 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x02b9 A[EDGE_INSN: B:111:0x02b9->B:91:0x02b9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0200  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0217  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.view.View r26, com.travel.train.model.trainticket.CJRPassengerInfo r27, boolean r28) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            int r2 = com.travel.train.R.id.age
            android.view.View r2 = r1.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            int r3 = com.travel.train.R.id.male_radio
            android.view.View r3 = r1.findViewById(r3)
            android.widget.RadioButton r3 = (android.widget.RadioButton) r3
            int r4 = com.travel.train.R.id.female_radio
            android.view.View r4 = r1.findViewById(r4)
            android.widget.RadioButton r4 = (android.widget.RadioButton) r4
            int r5 = com.travel.train.R.id.transgender_radio
            android.view.View r5 = r1.findViewById(r5)
            android.widget.RadioButton r5 = (android.widget.RadioButton) r5
            int r6 = com.travel.train.R.id.gender_icon
            android.view.View r6 = r1.findViewById(r6)
            android.widget.ImageView r6 = (android.widget.ImageView) r6
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r7 = com.travel.train.j.g.f27551a
            r8 = 0
            if (r7 == 0) goto L_0x003c
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r7 = com.travel.train.j.g.f27551a
            boolean r7 = r7.isTransgenderEnabled()
            if (r7 == 0) goto L_0x003c
            r5.setVisibility(r8)
        L_0x003c:
            int r7 = com.travel.train.R.id.bert_preference_layout
            android.view.View r7 = r1.findViewById(r7)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            int r9 = com.travel.train.R.id.full_name
            android.view.View r9 = r1.findViewById(r9)
            android.widget.AutoCompleteTextView r9 = (android.widget.AutoCompleteTextView) r9
            if (r28 == 0) goto L_0x006e
            int r10 = com.travel.train.R.drawable.pre_t_train_btn_radio_trains_child_male
            r3.setCompoundDrawablesWithIntrinsicBounds(r8, r10, r8, r8)
            int r10 = com.travel.train.R.drawable.pre_t_train_btn_radio_trains_child_female
            r4.setCompoundDrawablesWithIntrinsicBounds(r8, r10, r8, r8)
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r10 = com.travel.train.j.g.f27551a
            if (r10 == 0) goto L_0x006e
            com.travel.train.model.trainticket.CJRTrainMessagingConfig r10 = com.travel.train.j.g.f27551a
            boolean r10 = r10.isTransgenderEnabled()
            if (r10 == 0) goto L_0x006e
            int r10 = com.travel.train.R.drawable.pre_t_train_btn_radio_trains_transgender
            r5.setCompoundDrawablesWithIntrinsicBounds(r8, r10, r8, r8)
            r10 = 8
            r5.setVisibility(r10)
        L_0x006e:
            int r10 = com.travel.train.R.id.bed_roll_radio
            android.view.View r10 = r1.findViewById(r10)
            android.widget.CheckBox r10 = (android.widget.CheckBox) r10
            int r11 = com.travel.train.R.id.radio_berth_choice
            android.view.View r11 = r1.findViewById(r11)
            android.widget.CheckBox r11 = (android.widget.CheckBox) r11
            int r12 = com.travel.train.R.id.user_id
            android.view.View r12 = r1.findViewById(r12)
            android.widget.Spinner r12 = (android.widget.Spinner) r12
            int r13 = com.travel.train.R.id.id_number
            android.view.View r13 = r1.findViewById(r13)
            android.widget.EditText r13 = (android.widget.EditText) r13
            int r14 = com.travel.train.R.id.user_id_layout
            android.view.View r14 = r1.findViewById(r14)
            android.widget.RelativeLayout r14 = (android.widget.RelativeLayout) r14
            int r15 = com.travel.train.R.id.bed_roll_lyt
            android.view.View r15 = r1.findViewById(r15)
            android.widget.RelativeLayout r15 = (android.widget.RelativeLayout) r15
            int r8 = com.travel.train.R.id.child_berth_choice_lyt
            android.view.View r8 = r1.findViewById(r8)
            android.widget.RelativeLayout r8 = (android.widget.RelativeLayout) r8
            r16 = r6
            int r6 = com.travel.train.R.id.food_preference
            android.view.View r6 = r1.findViewById(r6)
            android.widget.Spinner r6 = (android.widget.Spinner) r6
            r17 = r6
            int r6 = com.travel.train.R.id.passport_number
            android.view.View r6 = r1.findViewById(r6)
            android.widget.EditText r6 = (android.widget.EditText) r6
            r18 = r6
            int r6 = com.travel.train.R.id.food_preference_layout
            android.view.View r6 = r1.findViewById(r6)
            android.widget.RelativeLayout r6 = (android.widget.RelativeLayout) r6
            r19 = r6
            int r6 = com.travel.train.R.id.passport_number_lyt
            android.view.View r6 = r1.findViewById(r6)
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r20 = r6
            int r6 = com.travel.train.R.id.country_name
            android.view.View r6 = r1.findViewById(r6)
            android.widget.AutoCompleteTextView r6 = (android.widget.AutoCompleteTextView) r6
            r21 = r6
            int r6 = com.travel.train.R.id.berth_preference
            android.view.View r6 = r1.findViewById(r6)
            android.widget.Spinner r6 = (android.widget.Spinner) r6
            r22 = r12
            int r12 = com.travel.train.R.id.passenger_details_text
            android.view.View r12 = r1.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r23 = r12
            int r12 = com.travel.train.R.id.add_detailtext
            android.view.View r12 = r1.findViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            r24 = r14
            int r14 = com.travel.train.R.id.radio_senior_citizen
            android.view.View r1 = r1.findViewById(r14)
            android.widget.CheckBox r1 = (android.widget.CheckBox) r1
            java.lang.String r14 = r27.getTIttle()
            r26 = r1
            if (r14 == 0) goto L_0x0160
            java.lang.String r14 = r27.getTIttle()
            java.lang.String r1 = r0.o
            boolean r1 = r14.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x015c
            java.lang.String r1 = r27.getTIttle()
            java.lang.String r14 = r0.s
            boolean r1 = r1.equalsIgnoreCase(r14)
            if (r1 == 0) goto L_0x0121
            goto L_0x015c
        L_0x0121:
            java.lang.String r1 = r27.getTIttle()
            java.lang.String r4 = r0.n
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 != 0) goto L_0x0157
            java.lang.String r1 = r27.getTIttle()
            java.lang.String r4 = r0.r
            boolean r1 = r1.equalsIgnoreCase(r4)
            if (r1 == 0) goto L_0x013a
            goto L_0x0157
        L_0x013a:
            java.lang.String r1 = r27.getTIttle()
            java.lang.String r3 = r0.p
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 != 0) goto L_0x0152
            java.lang.String r1 = r27.getTIttle()
            java.lang.String r3 = r0.t
            boolean r1 = r1.equalsIgnoreCase(r3)
            if (r1 == 0) goto L_0x0160
        L_0x0152:
            r1 = 1
            r5.setChecked(r1)
            goto L_0x0160
        L_0x0157:
            r1 = 1
            r3.setChecked(r1)
            goto L_0x0160
        L_0x015c:
            r1 = 1
            r4.setChecked(r1)
        L_0x0160:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r27.getFullName()
            r9.setText(r3)
            java.lang.String r3 = r27.getFullName()
            r12.setText(r3)
            java.lang.String r3 = r27.getAge()
            r2.setText(r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            java.lang.String r3 = " yrs"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = r27.getBerthPreference()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            java.lang.String r3 = ", "
            if (r2 != 0) goto L_0x01e1
            java.util.ArrayList<com.travel.train.model.trainticket.CJRTravellerBerth> r2 = r0.K
            if (r2 == 0) goto L_0x01e1
            int r2 = r7.getVisibility()
            if (r2 != 0) goto L_0x01e1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r4 = r27.getBerthPreference()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.util.ArrayList<com.travel.train.model.trainticket.CJRTravellerBerth> r2 = r0.K
            r4 = 1
        L_0x01ba:
            int r5 = r2.size()
            r7 = 1
            int r5 = r5 + r7
            if (r4 >= r5) goto L_0x01e1
            java.lang.Object r5 = r6.getItemAtPosition(r4)
            if (r5 == 0) goto L_0x01de
            java.lang.Object r5 = r6.getItemAtPosition(r4)
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = r27.getBerthPreference()
            boolean r5 = r5.equalsIgnoreCase(r7)
            if (r5 == 0) goto L_0x01de
            r6.setSelection(r4)
            goto L_0x01e1
        L_0x01de:
            int r4 = r4 + 1
            goto L_0x01ba
        L_0x01e1:
            int r2 = r15.getVisibility()
            if (r2 != 0) goto L_0x01f8
            boolean r2 = r27.isBedRollChoice()
            if (r2 == 0) goto L_0x01f2
            r2 = 1
            r10.setChecked(r2)
            goto L_0x01f9
        L_0x01f2:
            r2 = 1
            r4 = 0
            r10.setChecked(r4)
            goto L_0x01fa
        L_0x01f8:
            r2 = 1
        L_0x01f9:
            r4 = 0
        L_0x01fa:
            int r5 = r8.getVisibility()
            if (r5 != 0) goto L_0x020d
            boolean r5 = r27.isIsBerthFlag()
            if (r5 == 0) goto L_0x020a
            r11.setChecked(r2)
            goto L_0x020d
        L_0x020a:
            r11.setChecked(r4)
        L_0x020d:
            java.lang.String r2 = r27.getIdNumber()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x021e
            java.lang.String r2 = r27.getIdNumber()
            r13.setText(r2)
        L_0x021e:
            int r2 = r24.getVisibility()
            if (r2 != 0) goto L_0x0262
            java.lang.String r2 = r27.getIdentity()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0262
            com.travel.train.model.trainticket.CJRTrainConfig r2 = r0.F
            java.util.ArrayList r2 = r2.getValidIdCardTypes()
            if (r2 == 0) goto L_0x0262
            r4 = 1
        L_0x0237:
            int r5 = r2.size()
            r6 = 1
            int r5 = r5 + r6
            if (r4 >= r5) goto L_0x0262
            r12 = r22
            java.lang.Object r5 = r12.getItemAtPosition(r4)
            if (r5 == 0) goto L_0x025d
            java.lang.Object r5 = r12.getItemAtPosition(r4)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = r27.getIdentity()
            boolean r5 = r5.equalsIgnoreCase(r6)
            if (r5 == 0) goto L_0x025d
            r12.setSelection(r4)
            goto L_0x0262
        L_0x025d:
            int r4 = r4 + 1
            r22 = r12
            goto L_0x0237
        L_0x0262:
            int r2 = r19.getVisibility()
            if (r2 != 0) goto L_0x02b9
            java.lang.String r2 = r27.getMealPreference()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02b9
            com.travel.train.model.trainticket.CJRTrainConfig r2 = r0.F
            java.util.ArrayList r2 = r2.getFoodDetailList()
            if (r2 == 0) goto L_0x02b9
            r4 = 1
        L_0x027b:
            int r5 = r2.size()
            r6 = 1
            int r5 = r5 + r6
            if (r4 >= r5) goto L_0x02b9
            r5 = r17
            java.lang.Object r7 = r5.getItemAtPosition(r4)
            if (r7 == 0) goto L_0x02b4
            java.lang.Object r7 = r5.getItemAtPosition(r4)
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = r27.getMealPreference()
            boolean r7 = r7.equalsIgnoreCase(r8)
            if (r7 == 0) goto L_0x02b4
            r5.setSelection(r4)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r4 = r27.getMealPreference()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            goto L_0x02b9
        L_0x02b4:
            int r4 = r4 + 1
            r17 = r5
            goto L_0x027b
        L_0x02b9:
            if (r28 != 0) goto L_0x02fe
            java.lang.String r2 = r27.getmCountryName()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x02e2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r4 = r27.getmCountryName()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = r27.getmCountryName()
            r6 = r21
            r6.setText(r2)
            goto L_0x02fe
        L_0x02e2:
            r6 = r21
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r4 = r27.getCountryCode()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r2 = r27.getCountryCode()
            r6.setText(r2)
        L_0x02fe:
            int r2 = r20.getVisibility()
            if (r2 != 0) goto L_0x032a
            java.lang.String r2 = r27.getPassportNumber()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x032a
            java.lang.String r2 = r27.getPassportNumber()
            r6 = r18
            r6.setText(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r3)
            java.lang.String r3 = r27.getPassportNumber()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.append(r2)
        L_0x032a:
            r12 = r23
            r12.setText(r1)
            r2 = r26
            r1 = r27
            r6 = r16
            r0.a((com.travel.train.model.trainticket.CJRPassengerInfo) r1, (android.widget.ImageView) r6, (android.widget.CheckBox) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.helper.n.a(android.view.View, com.travel.train.model.trainticket.CJRPassengerInfo, boolean):void");
    }

    private void a(CJRPassengerInfo cJRPassengerInfo, ImageView imageView, CheckBox checkBox) {
        if (cJRPassengerInfo != null && cJRPassengerInfo.getmCategory() != null) {
            String str = cJRPassengerInfo.getmCategory();
            char c2 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 2085) {
                if (hashCode != 2092) {
                    if (hashCode != 2099) {
                        if (hashCode != 2149) {
                            if (hashCode != 2333) {
                                if (hashCode != 2650) {
                                    if (hashCode == 2660 && str.equals("SW")) {
                                        c2 = 3;
                                    }
                                } else if (str.equals("SM")) {
                                    c2 = 4;
                                }
                            } else if (str.equals("IF")) {
                                c2 = 5;
                            }
                        } else if (str.equals("CH")) {
                            c2 = 0;
                        }
                    } else if (str.equals("AT")) {
                        c2 = 6;
                    }
                } else if (str.equals("AM")) {
                    c2 = 1;
                }
            } else if (str.equals("AF")) {
                c2 = 2;
            }
            switch (c2) {
                case 0:
                    if (cJRPassengerInfo.getTIttle().equalsIgnoreCase(this.n)) {
                        imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_child_male_selected));
                        return;
                    } else {
                        imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_child_female_selected));
                        return;
                    }
                case 1:
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_male_tick));
                    return;
                case 2:
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_female_tick));
                    return;
                case 3:
                    if (!cJRPassengerInfo.getIsSeniorCityZen()) {
                        checkBox.setChecked(false);
                        imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_female_tick));
                        return;
                    }
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_ic_button_senior_citizen_female));
                    return;
                case 4:
                    if (!cJRPassengerInfo.getIsSeniorCityZen()) {
                        checkBox.setChecked(false);
                        imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_male_tick));
                        return;
                    }
                    imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_ic_button_senior_citizen_male));
                    return;
                case 5:
                    if (cJRPassengerInfo.getTIttle().equalsIgnoreCase(this.n)) {
                        imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_ic_button_child_male));
                        return;
                    } else {
                        imageView.setImageDrawable(this.f27347i.getResources().getDrawable(R.drawable.pre_t_ic_button_child_female));
                        return;
                    }
                case 6:
                    if (!cJRPassengerInfo.getIsSeniorCityZen()) {
                        checkBox.setChecked(false);
                    }
                    ResourceUtils.loadTrainImagesFromCDN(imageView, "ic_button_transgender.png", false, false, n.a.V1);
                    return;
                default:
                    return;
            }
        }
    }

    private static void b(View view) {
        TextView textView = (TextView) view.findViewById(R.id.berth_opt_title);
        TextView textView2 = (TextView) view.findViewById(R.id.berth_preference_text);
        TextView textView3 = (TextView) view.findViewById(R.id.bedroll_text);
        TextView textView4 = (TextView) view.findViewById(R.id.bedroll_title);
        TextView textView5 = (TextView) view.findViewById(R.id.senior_citizen_title);
        TextView textView6 = (TextView) view.findViewById(R.id.tv_berth_warning_msg);
        com.travel.train.b.a();
        ((TextView) view.findViewById(R.id.senior_citizen_text)).setText(com.travel.train.b.b().A());
        if (g.f27551a != null) {
            if (!TextUtils.isEmpty(g.f27551a.getBerthRequiredTitle())) {
                textView.setText(g.f27551a.getBerthRequiredTitle());
            }
            if (!TextUtils.isEmpty(g.f27551a.getBerthPreferenceText())) {
                textView2.setText(g.f27551a.getBerthPreferenceText());
            }
            if (!TextUtils.isEmpty(g.f27551a.getBedrollText())) {
                textView3.setText(g.f27551a.getBedrollText());
            }
            if (!TextUtils.isEmpty(g.f27551a.getBedrollTitle())) {
                textView4.setText(g.f27551a.getBedrollTitle());
            }
            if (!TextUtils.isEmpty(g.f27551a.getSeniorCitizenDiscountTitle())) {
                textView5.setText(g.f27551a.getSeniorCitizenDiscountTitle());
            }
            if (textView6 != null && !TextUtils.isEmpty(g.f27551a.getTravellerBerthMsg())) {
                textView6.setText(g.f27551a.getTravellerBerthMsg());
                return;
            }
            return;
        }
        com.travel.train.b.a();
        textView2.setText(com.travel.train.b.b().B());
        com.travel.train.b.a();
        textView3.setText(com.travel.train.b.b().C());
    }

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private AutoCompleteTextView f27427b;

        /* renamed from: c  reason: collision with root package name */
        private LinearLayout f27428c;

        public a(AutoCompleteTextView autoCompleteTextView, LinearLayout linearLayout) {
            this.f27427b = autoCompleteTextView;
            this.f27428c = linearLayout;
        }

        public final void onClick(View view) {
            AutoCompleteTextView unused = n.this.L = this.f27427b;
            LinearLayout unused2 = n.this.M = this.f27428c;
            n.this.j.a();
        }
    }

    public final void a(CJRCountryCode cJRCountryCode) {
        this.L.setText(cJRCountryCode.getCountryName());
        if (cJRCountryCode.getCountryName().equalsIgnoreCase("india")) {
            LinearLayout linearLayout = this.M;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
                return;
            }
            return;
        }
        LinearLayout linearLayout2 = this.M;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
            this.M.getChildAt(0).setFocusableInTouchMode(true);
            this.M.getChildAt(0).setFocusable(true);
            this.M.getChildAt(0).requestFocus();
        }
    }

    public final void b() {
        ArrayList<CheckBox> arrayList = this.k;
        if (arrayList != null && arrayList.size() > 0) {
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                CheckBox checkBox = this.k.get(i2);
                if (checkBox.getTag() != null && checkBox.getTag().equals(this.A)) {
                    checkBox.setChecked(true);
                }
            }
        }
    }

    public static String a(int i2) {
        if (i2 == R.id.male_radio) {
            return g.V;
        }
        if (i2 == R.id.female_radio) {
            return g.W;
        }
        if (i2 == R.id.transgender_radio) {
            return g.X;
        }
        return g.V;
    }

    private void a(AutoCompleteTextView autoCompleteTextView, View view, boolean z2, int i2) {
        ArrayList arrayList;
        final AutoCompleteTextView autoCompleteTextView2 = autoCompleteTextView;
        View view2 = view;
        final TextView textView = (TextView) view2.findViewById(R.id.age);
        RadioButton radioButton = (RadioButton) view2.findViewById(R.id.male_radio);
        RadioButton radioButton2 = (RadioButton) view2.findViewById(R.id.female_radio);
        RadioButton radioButton3 = (RadioButton) view2.findViewById(R.id.transgender_radio);
        if (g.f27551a != null && g.f27551a.isTransgenderEnabled()) {
            radioButton3.setVisibility(0);
        }
        if (z2) {
            radioButton.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_male, 0, 0);
            radioButton2.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_child_female, 0, 0);
            if (g.f27551a != null && g.f27551a.isTransgenderEnabled()) {
                radioButton3.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pre_t_train_btn_radio_trains_transgender, 0, 0);
                radioButton3.setVisibility(8);
            }
        }
        final Spinner spinner = (Spinner) view2.findViewById(R.id.food_preference);
        EditText editText = (EditText) view2.findViewById(R.id.passport_number);
        RelativeLayout relativeLayout = (RelativeLayout) view2.findViewById(R.id.food_preference_layout);
        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.passport_number_lyt);
        AutoCompleteTextView autoCompleteTextView3 = (AutoCompleteTextView) view2.findViewById(R.id.country_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.name_error);
        View findViewById = view2.findViewById(R.id.full_name_view);
        ImageView imageView = (ImageView) view2.findViewById(R.id.name_clear);
        if (z2) {
            arrayList = new ArrayList(this.j.d());
        } else {
            arrayList = new ArrayList(this.j.e());
        }
        autoCompleteTextView2.setTag(Boolean.valueOf(z2));
        as asVar = r0;
        as asVar2 = new as(this.f27347i, arrayList, this.Q, autoCompleteTextView, i2);
        autoCompleteTextView2.setAdapter(asVar);
        final TextView textView3 = textView2;
        final ImageView imageView2 = imageView;
        final View view3 = findViewById;
        final AutoCompleteTextView autoCompleteTextView4 = autoCompleteTextView;
        autoCompleteTextView2.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                if (textView3.getVisibility() == 0) {
                    textView3.setVisibility(8);
                }
                if (charSequence.length() > 0) {
                    imageView2.setVisibility(0);
                } else {
                    imageView2.setVisibility(8);
                }
                view3.setBackgroundColor(n.this.f27347i.getResources().getColor(R.color.payment_success_line_grey));
                if (n.this.j.e() != null && n.this.j.e().size() > 0 && charSequence.length() == 0) {
                    n.this.j.f().remove(Integer.valueOf(((as) autoCompleteTextView4.getAdapter()).f26322c));
                }
            }
        });
        final RadioButton radioButton4 = radioButton2;
        final RadioButton radioButton5 = radioButton;
        final RadioButton radioButton6 = radioButton3;
        final LinearLayout linearLayout2 = linearLayout;
        final AutoCompleteTextView autoCompleteTextView5 = autoCompleteTextView3;
        final EditText editText2 = editText;
        final RelativeLayout relativeLayout2 = relativeLayout;
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                ArrayList<String> foodDetailList;
                n nVar = n.this;
                String str = d.du;
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_id", b.n((Context) nVar.f27347i) != null ? b.n((Context) nVar.f27347i) : "");
                    hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/review-itinerary");
                    com.travel.train.b.a();
                    com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) nVar.f27347i);
                } catch (Exception e2) {
                    q.c(e2.getMessage());
                }
                try {
                    as asVar = (as) adapterView.getAdapter();
                    CJRTpUserProfileContact a2 = asVar.getItem(i2);
                    int i3 = asVar.f26322c;
                    if (a2 != null) {
                        if (!a2.getGender().equalsIgnoreCase(n.this.p)) {
                            if (!a2.getGender().equalsIgnoreCase(n.this.t) || g.f27551a == null || g.f27551a.isTransgenderEnabled()) {
                                if (a2.getGender() != null) {
                                    if (!a2.getGender().equalsIgnoreCase(n.this.o)) {
                                        if (!a2.getGender().equalsIgnoreCase(n.this.s)) {
                                            if (!a2.getGender().equalsIgnoreCase(n.this.n)) {
                                                if (!a2.getGender().equalsIgnoreCase(n.this.r)) {
                                                    if (a2.getGender().equalsIgnoreCase(n.this.p) || a2.getGender().equalsIgnoreCase(n.this.t)) {
                                                        radioButton6.setChecked(true);
                                                    }
                                                }
                                            }
                                            radioButton5.setChecked(true);
                                        }
                                    }
                                    radioButton4.setChecked(true);
                                }
                                autoCompleteTextView4.setText(a2.getFullname());
                                autoCompleteTextView4.setSelection(autoCompleteTextView4.getText().length());
                                textView.setText(a2.getAge());
                                if (linearLayout2.getVisibility() == 0) {
                                    if (!TextUtils.isEmpty(a2.getNationality())) {
                                        autoCompleteTextView5.setText(a2.getNationality());
                                    }
                                    if (a2.getPassport_no() != null) {
                                        editText2.setText(a2.getPassport_no());
                                    }
                                }
                                if (relativeLayout2.getVisibility() == 0 && (foodDetailList = n.this.F.getFoodDetailList()) != null) {
                                    int i4 = 1;
                                    while (true) {
                                        if (i4 < foodDetailList.size() + 1) {
                                            if (spinner.getItemAtPosition(i4) != null && spinner.getItemAtPosition(i4).toString().equalsIgnoreCase(a2.getMeal_type())) {
                                                spinner.setSelection(i4);
                                                break;
                                            }
                                            i4++;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                n.this.j.f().put(Integer.valueOf(i3), a2);
                            }
                        }
                        b.b(n.this.f27347i.getApplicationContext(), n.this.f27347i.getString(R.string.train_travellers_error), n.this.q);
                        n.this.j.f().put(Integer.valueOf(i3), a2);
                    }
                } catch (Exception e3) {
                    String unused = n.this.m;
                    q.c(e3.getMessage());
                }
            }
        });
        autoCompleteTextView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList;
                if (n.this.j.e() != null && n.this.j.e().size() > 0) {
                    if (autoCompleteTextView2.getTag().equals(Boolean.TRUE)) {
                        arrayList = new ArrayList(n.this.j.d());
                    } else {
                        arrayList = new ArrayList(n.this.j.e());
                    }
                    for (CJRTpUserProfileContact remove : n.this.j.f().values()) {
                        arrayList.remove(remove);
                    }
                    ((as) autoCompleteTextView2.getAdapter()).a((ArrayList<CJRTpUserProfileContact>) arrayList, autoCompleteTextView2.getText());
                    new Handler().post(new Runnable() {
                        public final void run() {
                            autoCompleteTextView2.showDropDown();
                        }
                    });
                }
            }
        });
        final AutoCompleteTextView autoCompleteTextView6 = autoCompleteTextView;
        final TextView textView4 = textView2;
        final View view4 = findViewById;
        final boolean z3 = z2;
        autoCompleteTextView2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                ArrayList arrayList;
                if (!z) {
                    n nVar = n.this;
                    AutoCompleteTextView autoCompleteTextView = autoCompleteTextView6;
                    TextView textView = textView4;
                    View view2 = view4;
                    boolean z2 = z3;
                    if (autoCompleteTextView.getText() != null || autoCompleteTextView.getText().toString().trim().length() != 0) {
                        String str = "";
                        if (!(autoCompleteTextView == null || autoCompleteTextView.getText() == null)) {
                            str = autoCompleteTextView.getText().toString();
                        }
                        if (str.length() < nVar.f27343e || autoCompleteTextView.getText().toString().length() > nVar.f27344f) {
                            if (!z2) {
                                nVar.a(textView, view2, nVar.f27347i.getString(R.string.passenger_fullname_error, new Object[]{Integer.valueOf(nVar.f27343e), Integer.valueOf(nVar.f27344f)}));
                                return;
                            }
                            nVar.a(textView, view2, nVar.f27347i.getString(R.string.child_passenger_fullname_error, new Object[]{Integer.valueOf(nVar.f27343e), Integer.valueOf(nVar.f27344f)}));
                        } else if (!str.matches("[a-zA-z\\s]*")) {
                            nVar.a(textView, view2, nVar.f27347i.getString(R.string.name_condition));
                        }
                    } else if (!z2) {
                        nVar.a(textView, view2, nVar.f27339a);
                    } else {
                        nVar.a(textView, view2, nVar.f27340b);
                    }
                } else if (n.this.j.e() != null && n.this.j.e().size() > 0) {
                    if (autoCompleteTextView6.getTag().equals(Boolean.TRUE)) {
                        arrayList = new ArrayList(n.this.j.d());
                    } else {
                        arrayList = new ArrayList(n.this.j.e());
                    }
                    for (CJRTpUserProfileContact remove : n.this.j.f().values()) {
                        arrayList.remove(remove);
                    }
                    ((as) autoCompleteTextView6.getAdapter()).a((ArrayList<CJRTpUserProfileContact>) arrayList, autoCompleteTextView6.getText());
                    new Handler().post(new Runnable() {
                        public final void run() {
                            autoCompleteTextView6.showDropDown();
                        }
                    });
                }
            }
        });
    }

    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            int id = view.getId();
            if (id == R.id.age) {
                HashMap hashMap = new HashMap();
                hashMap.put(d.q, this.f27347i.getString(R.string.age));
                o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_field_clicked", "/trains/traveller-details", this.f27347i, hashMap);
            } else if (id == R.id.full_name) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(d.q, this.f27347i.getString(R.string.name_string));
                o.a("train_traveller_details", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, "traveller_field_clicked", "/trains/traveller-details", this.f27347i, hashMap2);
            }
        }
    }

    static /* synthetic */ void a(n nVar, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("train_user_id", str2);
            hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, d.u);
            com.travel.train.b.a();
            com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, (Context) nVar.f27347i);
        } catch (Exception e2) {
            q.c(e2.getMessage());
        }
    }

    static /* synthetic */ int a(TextView textView) {
        if (textView.getText().toString() == null) {
            return 0;
        }
        String[] split = textView.getText().toString().split(" ");
        if (split.length > 1) {
            return Integer.parseInt(split[1]);
        }
        return 0;
    }
}
