package com.travel.flight.flightticket.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.utility.CustomTypefaceSpan;
import com.paytm.utility.RoboTextView;
import com.travel.cdn.ResourceUtils;
import com.travel.flight.R;
import com.travel.flight.a.b;
import com.travel.flight.flightticket.activity.AJRFlightTravellersItenary;
import com.travel.flight.flightticket.f.h;
import com.travel.flight.flightticket.f.m;
import com.travel.flight.flightticket.g.g;
import com.travel.flight.pojo.flightticket.CJRTravellerDetails;
import com.travel.flight.utils.c;
import com.travel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValidation;
import net.one97.paytmflight.common.entity.travel.CJRDynamicValue;
import net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact;

public final class ae extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    Activity f25089a;

    /* renamed from: b  reason: collision with root package name */
    Context f25090b;

    /* renamed from: c  reason: collision with root package name */
    public g f25091c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<CJRTravellerDetails> f25092d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    int f25093e = 0;

    /* renamed from: f  reason: collision with root package name */
    int f25094f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Boolean f25095g = Boolean.FALSE;

    /* renamed from: h  reason: collision with root package name */
    TextView f25096h;

    /* renamed from: i  reason: collision with root package name */
    TextView f25097i;
    h j;
    public HashMap<Integer, a> k = new HashMap<>();
    public ArrayList<CJRTpUserProfileContact> l;
    LinearLayout m;
    TextView n;
    public String o;
    private AJRFlightTravellersItenary p;
    private View q;
    private LinearLayout r;
    private RelativeLayout s;
    private ImageButton t;
    private ImageView u;

    public ae(Activity activity, View view, h hVar) {
        super(view);
        this.f25089a = activity;
        Activity activity2 = this.f25089a;
        this.p = (AJRFlightTravellersItenary) activity2;
        this.f25090b = activity2;
        this.q = view;
        this.j = hVar;
        this.l = com.travel.flight.travellerProfile.a.a().f25523b;
        if (this.f25091c == null) {
            this.f25091c = new g(this.f25090b.getApplicationContext());
        }
        this.r = (LinearLayout) this.q.findViewById(R.id.passenger_list_linear);
        this.m = (LinearLayout) this.q.findViewById(R.id.watch_out_msg);
        this.n = (TextView) this.q.findViewById(R.id.watch_out_text);
        this.t = (ImageButton) this.q.findViewById(R.id.watch_out_text_close);
        this.t.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ae.this.m.setVisibility(8);
            }
        });
        ResourceUtils.loadFlightImagesFromCDN((ImageView) this.m.findViewById(R.id.iv_group_24), "group_24.png", false, false, n.a.V1);
        ResourceUtils.loadFlightImagesFromCDN(this.t, "close_icon.png", false, false, n.a.V1);
        this.s = (RelativeLayout) this.q.findViewById(R.id.msgLyt);
        this.f25097i = (TextView) this.q.findViewById(R.id.msgBox);
        this.u = (ImageView) this.q.findViewById(R.id.msg_icon);
    }

    public final void a() {
        if (this.k.get(Integer.valueOf(this.f25094f)) != null) {
            String str = this.k.get(Integer.valueOf(this.f25094f)).o + " " + this.k.get(Integer.valueOf(this.f25094f)).p;
            if (!str.trim().isEmpty() && !str.contains("null") && this.k.get(Integer.valueOf(this.f25094f)).f25103e.getVisibility() == 0) {
                this.k.get(Integer.valueOf(this.f25094f)).f25103e.setVisibility(8);
                this.k.get(Integer.valueOf(this.f25094f)).f25102d.setVisibility(0);
                this.k.get(Integer.valueOf(this.f25094f)).a();
                this.k.get(Integer.valueOf(this.f25094f)).a(this.f25094f);
                this.f25092d.get(this.f25094f).setTravellerTitle(this.k.get(Integer.valueOf(this.f25094f)).b(this.f25092d.get(this.f25094f).getTravellerType()));
            }
        }
    }

    public final void b() {
        ArrayList<CJRTravellerDetails> arrayList = this.f25092d;
        if (arrayList != null && arrayList.size() <= 0) {
            this.f25092d = this.f25091c.f25037g;
            this.k = new HashMap<>();
            LayoutInflater from = LayoutInflater.from(this.f25090b);
            int size = this.f25092d.size();
            for (int i2 = 0; i2 < size; i2++) {
                CJRTravellerDetails cJRTravellerDetails = this.f25092d.get(i2);
                a aVar = new a();
                View inflate = from.inflate(R.layout.pre_f_flight_passenger_list, (ViewGroup) null);
                aVar.k = new com.travel.flight.flightticket.widget.a(aVar, ae.this.f25089a);
                aVar.f25099a = (ViewGroup) inflate.findViewById(R.id.layout_passenger_header);
                aVar.f25101c = (TextView) inflate.findViewById(R.id.txt_passenger_type);
                aVar.f25099a.setOnClickListener(aVar);
                aVar.f25102d = inflate.findViewById(R.id.divider_add_detail);
                aVar.f25103e = (LinearLayout) inflate.findViewById(R.id.userExpandView);
                aVar.j = (LinearLayout) inflate.findViewById(R.id.addPaxInfo);
                aVar.f25104f = (RadioGroup) inflate.findViewById(R.id.radio_group_gender);
                aVar.f25104f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                        RadioButton radioButton = (RadioButton) radioGroup.findViewById(i2);
                        if (radioButton != null && radioButton.isChecked()) {
                            String unused = a.this.n = radioButton.getText().toString();
                            ae.this.f25092d.get(a.this.m).setTravellerTitle(a.this.n);
                        }
                    }
                });
                aVar.f25105g = (RadioButton) inflate.findViewById(R.id.radio_mr);
                aVar.f25106h = (RadioButton) inflate.findViewById(R.id.radio_mrs);
                aVar.f25107i = (RadioButton) inflate.findViewById(R.id.radio_ms);
                aVar.f25100b = (ImageView) inflate.findViewById(R.id.traveler_icon);
                int unused = aVar.m = i2;
                aVar.f25101c.setText(this.f25090b.getString(R.string.enter_name_td_txt, new Object[]{cJRTravellerDetails.getPassengerType()}));
                aVar.f25101c.setTag(aVar);
                aVar.f25099a.setTag(aVar);
                this.k.put(Integer.valueOf(i2), aVar);
                a.a(aVar, cJRTravellerDetails, i2);
                inflate.setTag(aVar);
                if (i2 == 0) {
                    this.s.setVisibility(0);
                    this.f25097i.setText(this.f25092d.get(i2).getmTooltip());
                    if (this.f25095g.booleanValue()) {
                        this.u.setBackgroundResource(R.drawable.pre_f_flight_ic_flight_passport);
                    } else {
                        this.u.setBackgroundResource(R.drawable.pre_f_flight_ic_flight_aadhar);
                    }
                }
                aVar.j.setTag(aVar);
                if ("Child".equalsIgnoreCase(cJRTravellerDetails.getTravellerType()) || "Infant".equalsIgnoreCase(cJRTravellerDetails.getTravellerType())) {
                    aVar.f25105g.setText(this.f25090b.getString(R.string.flights_mstr));
                    aVar.f25107i.setText(this.f25090b.getString(R.string.flights_ms));
                    String unused2 = aVar.n = this.f25090b.getString(R.string.flights_mstr);
                    cJRTravellerDetails.setTravellerTitle(this.f25090b.getString(R.string.flights_mstr));
                    aVar.f25106h.setVisibility(8);
                }
                this.r.addView(inflate);
            }
        }
    }

    public final boolean c() {
        int i2;
        int i3;
        LinearLayout linearLayout;
        RoboTextView roboTextView;
        boolean z;
        boolean z2;
        CJRDynamicValidation cJRDynamicValidation;
        View view;
        RoboTextView roboTextView2;
        String str;
        String str2;
        String str3;
        String str4;
        if (this.f25092d == null) {
            return false;
        }
        int i4 = 0;
        boolean z3 = true;
        boolean z4 = false;
        while (i4 < this.f25092d.size()) {
            CJRTravellerDetails cJRTravellerDetails = this.f25092d.get(i4);
            a aVar = this.k.get(Integer.valueOf(i4));
            cJRTravellerDetails.setTravellerTitle(aVar.b(cJRTravellerDetails.getTravellerType()));
            LinearLayout g2 = aVar.j;
            int childCount = g2.getChildCount();
            boolean z5 = z3;
            boolean z6 = z4;
            int i5 = 0;
            boolean z7 = true;
            boolean z8 = false;
            RoboTextView roboTextView3 = null;
            while (i5 < childCount) {
                if (g2.getChildAt(i5) instanceof LinearLayout) {
                    LinearLayout linearLayout2 = (LinearLayout) g2.getChildAt(i5);
                    TextInputLayout textInputLayout = (TextInputLayout) linearLayout2.findViewById(R.id.text_input_layout);
                    if (textInputLayout != null) {
                        roboTextView2 = (RoboTextView) linearLayout2.findViewById(R.id.error_text);
                        view = textInputLayout.findViewById(R.id.child_view);
                        cJRDynamicValidation = (CJRDynamicValidation) view.getTag();
                    } else if (linearLayout2.findViewById(R.id.flyer_container) != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) linearLayout2.findViewById(R.id.flyer_container);
                        textInputLayout = (TextInputLayout) relativeLayout.findViewById(R.id.text_input_layout);
                        roboTextView2 = (RoboTextView) relativeLayout.findViewById(R.id.error_text);
                        view = textInputLayout.findViewById(R.id.child_view);
                        cJRDynamicValidation = (CJRDynamicValidation) view.getTag();
                    }
                    TextInputLayout textInputLayout2 = textInputLayout;
                    RoboTextView roboTextView4 = roboTextView2;
                    CJRDynamicValidation cJRDynamicValidation2 = cJRDynamicValidation;
                    TextInputLayout textInputLayout3 = textInputLayout2;
                    boolean z9 = view instanceof AutoCompleteTextView;
                    linearLayout = g2;
                    i3 = childCount;
                    if (z9) {
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
                        z = z5;
                        cJRDynamicValidation2.setmValue(autoCompleteTextView.getText().toString());
                        z2 = z8;
                        if (cJRDynamicValidation2.getType().equalsIgnoreCase("autosuggest")) {
                            String obj = autoCompleteTextView.getText().toString();
                            str2 = "";
                            ArrayList arrayList = (ArrayList) autoCompleteTextView.getTag(R.string.t_and_c);
                            if (arrayList != null && arrayList.size() > 0) {
                                i2 = i4;
                                roboTextView = roboTextView3;
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= arrayList.size()) {
                                        break;
                                    } else if (obj.equalsIgnoreCase(((com.travel.flight.pojo.flightticket.paxinfo.a) arrayList.get(i6)).f25439a)) {
                                        str4 = ((com.travel.flight.pojo.flightticket.paxinfo.a) arrayList.get(i6)).f25440b;
                                        break;
                                    } else {
                                        i6++;
                                    }
                                }
                            } else {
                                i2 = i4;
                                roboTextView = roboTextView3;
                            }
                            str4 = str2;
                            if (cJRDynamicValidation2.getKey().equalsIgnoreCase("passport_issue_country")) {
                                cJRTravellerDetails.setPassportCountryCode(str4);
                                cJRDynamicValidation2.setmValue(str4);
                            } else if (cJRDynamicValidation2.getKey().equalsIgnoreCase("birth_country")) {
                                cJRTravellerDetails.setBirthCountryCode(str4);
                                cJRDynamicValidation2.setmValue(str4);
                            } else if (cJRDynamicValidation2.getKey().equalsIgnoreCase("nationality")) {
                                cJRTravellerDetails.setNationalityCountryCode(str4);
                                cJRDynamicValidation2.setmValue(str4);
                            }
                        } else {
                            i2 = i4;
                            str2 = "";
                            roboTextView = roboTextView3;
                        }
                        if (cJRDynamicValidation2.getKey().equalsIgnoreCase("onward_frequent_flyer_number") || cJRDynamicValidation2.getKey().equalsIgnoreCase("return_frequent_flyer_number")) {
                            String obj2 = autoCompleteTextView.getText().toString();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= cJRDynamicValidation2.getValues().size()) {
                                    str3 = str2;
                                    break;
                                } else if (obj2.equalsIgnoreCase(cJRDynamicValidation2.getValues().get(i7).getValue())) {
                                    str3 = cJRDynamicValidation2.getValues().get(i7).getKey();
                                    break;
                                } else {
                                    i7++;
                                }
                            }
                            if (cJRDynamicValidation2.getKey().equals("onward_frequent_flyer_number") && com.travel.flight.flightticket.widget.a.d() && !TextUtils.isEmpty(str3)) {
                                cJRTravellerDetails.setMflyerName(str3);
                                cJRTravellerDetails.setFlyerFlightName(str3);
                            } else if (!cJRDynamicValidation2.getKey().equals("return_frequent_flyer_number") || !com.travel.flight.flightticket.widget.a.d() || TextUtils.isEmpty(str3)) {
                                cJRTravellerDetails.setMflyerName((String) null);
                                cJRTravellerDetails.setFlyerFlightName((String) null);
                                cJRTravellerDetails.setMflyerNameReturn((String) null);
                            } else {
                                cJRTravellerDetails.setMflyerNameReturn(str3);
                            }
                        }
                    } else {
                        i2 = i4;
                        z = z5;
                        z2 = z8;
                        roboTextView = roboTextView3;
                        if (view instanceof EditText) {
                            EditText editText = (EditText) view;
                            if (cJRDynamicValidation2.getKey().equals("frequent_flyer_number")) {
                                String obj3 = editText.getText().toString();
                                if (!cJRDynamicValidation2.isReturnTrip() && !TextUtils.isEmpty(obj3) && com.travel.flight.flightticket.widget.a.d()) {
                                    cJRTravellerDetails.setMflyerNumber(obj3);
                                } else if (!cJRDynamicValidation2.isReturnTrip() || TextUtils.isEmpty(obj3) || !com.travel.flight.flightticket.widget.a.d()) {
                                    cJRTravellerDetails.setMflyerNumber((String) null);
                                    cJRTravellerDetails.setMflyerNumberReturn((String) null);
                                } else {
                                    cJRTravellerDetails.setMflyerNumberReturn(obj3);
                                }
                            } else {
                                cJRDynamicValidation2.setmValue(editText.getText().toString());
                            }
                        }
                    }
                    if (!cJRDynamicValidation2.getKey().equalsIgnoreCase("onward_frequent_flyer_number") && !cJRDynamicValidation2.getKey().equalsIgnoreCase("return_frequent_flyer_number")) {
                        str = c.a(cJRDynamicValidation2, (Context) this.f25089a);
                    } else if (z9) {
                        str = c.a(cJRDynamicValidation2, (Context) this.f25089a);
                    } else {
                        CJRDynamicValidation cJRDynamicValidation3 = new CJRDynamicValidation();
                        cJRDynamicValidation3.setValue("Frequent Flyer No");
                        cJRDynamicValidation3.setKey("frequent_flyer_number");
                        cJRDynamicValidation3.setOptional(cJRDynamicValidation2.isOptional());
                        cJRDynamicValidation3.setmValue(cJRTravellerDetails.getMflyerName());
                        str = c.a(cJRDynamicValidation3, (Context) this.f25089a);
                    }
                    if (!str.equalsIgnoreCase("success")) {
                        roboTextView4.setVisibility(0);
                        roboTextView4.setText(str);
                        z8 = z2;
                        roboTextView3 = roboTextView;
                        z7 = false;
                        z5 = false;
                    } else {
                        roboTextView4.setVisibility(8);
                        roboTextView4.setText((CharSequence) null);
                        if (!z6) {
                            if (!cJRDynamicValidation2.getKey().equalsIgnoreCase("firstname")) {
                                roboTextView4 = roboTextView;
                            } else if (TextUtils.isEmpty(cJRDynamicValidation2.getmValue())) {
                                z2 = true;
                            }
                            if (!TextUtils.isEmpty(cJRDynamicValidation2.getmValue()) || !z2) {
                                roboTextView3 = roboTextView4;
                                z8 = z2;
                                z5 = z;
                            } else {
                                roboTextView4.setVisibility(0);
                                roboTextView4.setText(this.f25090b.getString(R.string.flight_first_name_validation));
                                textInputLayout3.requestFocus();
                                ((InputMethodManager) this.f25090b.getSystemService("input_method")).showSoftInput(textInputLayout3, 1);
                                roboTextView3 = roboTextView4;
                                z8 = z2;
                                z7 = false;
                                z5 = false;
                                z6 = true;
                            }
                        }
                        z8 = z2;
                        z5 = z;
                        roboTextView3 = roboTextView;
                    }
                    i5++;
                    g2 = linearLayout;
                    childCount = i3;
                    i4 = i2;
                }
                i2 = i4;
                linearLayout = g2;
                i3 = childCount;
                z = z5;
                z2 = z8;
                roboTextView = roboTextView3;
                z8 = z2;
                z5 = z;
                roboTextView3 = roboTextView;
                i5++;
                g2 = linearLayout;
                childCount = i3;
                i4 = i2;
            }
            boolean z10 = z5;
            int i8 = i4;
            if (!z7) {
                a(i8);
            }
            i4 = i8 + 1;
            z4 = z6;
            z3 = z10;
        }
        return z3;
    }

    private void a(int i2) {
        this.k.get(Integer.valueOf(i2)).f25103e.setVisibility(0);
        this.k.get(Integer.valueOf(i2)).f25102d.setVisibility(8);
    }

    public class a implements View.OnClickListener, com.travel.flight.flightticket.f.g, m {
        /* access modifiers changed from: package-private */

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f25099a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f25100b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f25101c;
        /* access modifiers changed from: package-private */

        /* renamed from: d  reason: collision with root package name */
        public View f25102d;
        /* access modifiers changed from: package-private */

        /* renamed from: e  reason: collision with root package name */
        public LinearLayout f25103e;

        /* renamed from: f  reason: collision with root package name */
        RadioGroup f25104f;
        /* access modifiers changed from: package-private */

        /* renamed from: g  reason: collision with root package name */
        public RadioButton f25105g;
        /* access modifiers changed from: package-private */

        /* renamed from: h  reason: collision with root package name */
        public RadioButton f25106h;
        /* access modifiers changed from: package-private */

        /* renamed from: i  reason: collision with root package name */
        public RadioButton f25107i;
        /* access modifiers changed from: package-private */
        public LinearLayout j;
        com.travel.flight.flightticket.widget.a k;
        /* access modifiers changed from: private */
        public int m = 0;
        /* access modifiers changed from: private */
        public String n;
        /* access modifiers changed from: private */
        public String o;
        /* access modifiers changed from: private */
        public String p;

        a() {
        }

        public final void a(ArrayList<com.travel.flight.pojo.flightticket.paxinfo.a> arrayList, View view, boolean z) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view.findViewById(R.id.child_view);
            autoCompleteTextView.setTag(R.string.t_and_c, arrayList);
            if (arrayList != null) {
                ArrayList<String> a2 = a(arrayList);
                if (a2.size() > 0) {
                    autoCompleteTextView.setAdapter(new b(ae.this.f25089a, a2));
                    autoCompleteTextView.showDropDown();
                    if (!z) {
                        autoCompleteTextView.onCommitCompletion(new CompletionInfo(0, 0, (CharSequence) null));
                    }
                }
            }
        }

        private static ArrayList<String> a(ArrayList<com.travel.flight.pojo.flightticket.paxinfo.a> arrayList) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            Iterator<com.travel.flight.pojo.flightticket.paxinfo.a> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().f25439a);
            }
            return arrayList2;
        }

        /* access modifiers changed from: private */
        public void a() {
            String str;
            if (!TextUtils.isEmpty(this.o)) {
                str = "" + " " + this.o;
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(this.p)) {
                str = str + " " + this.p;
            }
            if (!TextUtils.isEmpty(str.trim())) {
                String str2 = ae.this.k.get(Integer.valueOf(ae.this.f25093e)).n + ". " + str;
                int length = str2.length();
                String str3 = this.p;
                int length2 = length - (str3 != null ? str3.length() : 0);
                Typeface create = Typeface.create("sans-serif-medium", 0);
                Typeface create2 = Typeface.create("sans-serif", 0);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                spannableStringBuilder.setSpan(new CustomTypefaceSpan("", create), 0, length2, 34);
                if (this.p != null) {
                    spannableStringBuilder.setSpan(new CustomTypefaceSpan("", create2), length2, str2.length(), 34);
                }
                this.f25101c.setText(spannableStringBuilder);
                this.f25101c.setTextSize(2, 17.0f);
                return;
            }
            this.f25101c.setText(ae.this.f25090b.getString(R.string.enter_name_td_txt, new Object[]{ae.this.f25092d.get(ae.this.f25093e).getPassengerType()}));
            this.f25101c.setTextSize(2, 14.0f);
            this.f25101c.setTypeface(Typeface.create("sans-serif", 0));
        }

        public final void onClick(View view) {
            if (((view.getId() == R.id.txt_add_passenger) | (view.getId() == R.id.txt_passenger_type)) || (view.getId() == R.id.layout_passenger_header)) {
                a aVar = (a) view.getTag();
                int i2 = aVar.m;
                ae aeVar = ae.this;
                aeVar.f25094f = i2;
                if (aeVar.k.get(Integer.valueOf(ae.this.f25093e)) != null) {
                    String b2 = ae.this.k.get(Integer.valueOf(ae.this.f25093e)).b(ae.this.f25092d.get(ae.this.f25093e).getTravellerType());
                    ae.this.f25092d.get(ae.this.f25093e).setTravellerTitle(b2);
                    ae.this.k.get(Integer.valueOf(ae.this.f25093e)).n = b2;
                    ae.this.k.get(Integer.valueOf(ae.this.f25093e)).a(ae.this.f25093e);
                    ae.this.k.get(Integer.valueOf(ae.this.f25093e)).f25103e.setVisibility(8);
                    ae.this.k.get(Integer.valueOf(ae.this.f25093e)).f25102d.setVisibility(0);
                    ae.this.k.get(Integer.valueOf(ae.this.f25093e)).a();
                    aVar.f25103e.setVisibility(0);
                    aVar.f25100b.setVisibility(8);
                    aVar.f25102d.setVisibility(8);
                    aVar.f25101c.setText(ae.this.f25090b.getString(R.string.enter_name_td_txt, new Object[]{ae.this.f25092d.get(i2).getPassengerType()}));
                    if (ae.this.f25091c.f25037g.size() > 1) {
                        InputMethodManager inputMethodManager = (InputMethodManager) ae.this.f25089a.getSystemService("input_method");
                        inputMethodManager.hideSoftInputFromWindow(aVar.j.findViewById(R.id.child_view).getWindowToken(), 0);
                        aVar.j.findViewById(R.id.child_view).requestFocus();
                        inputMethodManager.toggleSoftInput(2, 0);
                    }
                }
                ae aeVar2 = ae.this;
                aeVar2.f25093e = this.m;
                ae.this.f25097i.setText(aeVar2.f25092d.get(this.m).getmTooltip());
            }
        }

        /* access modifiers changed from: private */
        public void a(int i2) {
            String str = "";
            if (!TextUtils.isEmpty(this.o)) {
                str = str + " " + this.o;
            }
            if (!TextUtils.isEmpty(this.p)) {
                str = str + " " + this.p;
            }
            if (!TextUtils.isEmpty(str.trim())) {
                String travellerType = ae.this.f25092d.get(i2).getTravellerType();
                if (!TextUtils.isEmpty(travellerType)) {
                    boolean isChecked = ae.this.k.get(Integer.valueOf(i2)).f25105g != null ? ae.this.k.get(Integer.valueOf(i2)).f25105g.isChecked() : false;
                    boolean isChecked2 = ae.this.k.get(Integer.valueOf(i2)).f25106h != null ? ae.this.k.get(Integer.valueOf(i2)).f25106h.isChecked() : false;
                    boolean isChecked3 = ae.this.k.get(Integer.valueOf(i2)).f25107i != null ? ae.this.k.get(Integer.valueOf(i2)).f25107i.isChecked() : false;
                    if ("Adult".equalsIgnoreCase(travellerType)) {
                        if (isChecked) {
                            this.f25100b.setImageDrawable(ae.this.f25090b.getResources().getDrawable(R.drawable.flight_male_revamp_img));
                        } else if (isChecked3 || isChecked2) {
                            this.f25100b.setImageDrawable(ae.this.f25090b.getResources().getDrawable(R.drawable.flight_female_revamp_img));
                        }
                    } else if (!"Child".equalsIgnoreCase(travellerType)) {
                        this.f25100b.setImageDrawable(ae.this.f25090b.getResources().getDrawable(R.drawable.flight_infant_revamp_img));
                    } else if (isChecked) {
                        this.f25100b.setImageDrawable(ae.this.f25090b.getResources().getDrawable(R.drawable.flight_child_male_revamp_img));
                    } else {
                        this.f25100b.setImageDrawable(ae.this.f25090b.getResources().getDrawable(R.drawable.flight_child_female_revamp_img));
                    }
                    ae.this.k.get(Integer.valueOf(i2)).f25100b.setVisibility(0);
                }
            }
        }

        /* access modifiers changed from: private */
        public String b(String str) {
            if ("Adult".equalsIgnoreCase(str)) {
                if (this.f25105g.isChecked()) {
                    return ae.this.f25090b.getString(R.string.flights_mr);
                }
                if (this.f25106h.isChecked()) {
                    return ae.this.f25090b.getString(R.string.flights_mrs);
                }
                if (this.f25107i.isChecked()) {
                    return ae.this.f25090b.getString(R.string.flights_ms);
                }
            } else if (this.f25105g.isChecked()) {
                return ae.this.f25090b.getString(R.string.flights_mstr);
            } else {
                if (this.f25107i.isChecked()) {
                    return ae.this.f25090b.getString(R.string.flights_ms);
                }
            }
            if ("Adult".equalsIgnoreCase(str)) {
                return ae.this.f25090b.getString(R.string.flights_mr);
            }
            return ae.this.f25090b.getString(R.string.flights_ms);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0055, code lost:
            if (r4.equalsIgnoreCase("Ms") != false) goto L_0x006d;
         */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007e  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void c(java.lang.String r4) {
            /*
                r3 = this;
                if (r4 != 0) goto L_0x0004
                java.lang.String r4 = ""
            L_0x0004:
                com.travel.flight.flightticket.j.ae r0 = com.travel.flight.flightticket.j.ae.this
                java.util.HashMap<java.lang.Integer, com.travel.flight.flightticket.j.ae$a> r0 = r0.k
                int r1 = r3.m
                java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
                java.lang.Object r0 = r0.get(r1)
                com.travel.flight.flightticket.j.ae$a r0 = (com.travel.flight.flightticket.j.ae.a) r0
                com.travel.flight.flightticket.j.ae r1 = com.travel.flight.flightticket.j.ae.this
                java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r1 = r1.f25092d
                int r2 = r3.m
                java.lang.Object r1 = r1.get(r2)
                com.travel.flight.pojo.flightticket.CJRTravellerDetails r1 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r1
                java.lang.String r1 = r1.getTravellerType()
                android.widget.RadioGroup r2 = r0.f25104f
                r2.clearCheck()
                java.lang.String r2 = "Adult"
                boolean r1 = r2.equalsIgnoreCase(r1)
                r2 = 1
                if (r1 == 0) goto L_0x005e
                java.lang.String r1 = "Mr"
                boolean r1 = r4.equalsIgnoreCase(r1)
                if (r1 != 0) goto L_0x0058
                boolean r1 = android.text.TextUtils.isEmpty(r4)
                if (r1 == 0) goto L_0x0041
                goto L_0x0058
            L_0x0041:
                java.lang.String r1 = "Mrs"
                boolean r1 = r4.equalsIgnoreCase(r1)
                if (r1 == 0) goto L_0x004f
                android.widget.RadioButton r0 = r0.f25106h
                r0.setChecked(r2)
                goto L_0x0078
            L_0x004f:
                java.lang.String r1 = "Ms"
                boolean r1 = r4.equalsIgnoreCase(r1)
                if (r1 == 0) goto L_0x0078
                goto L_0x006d
            L_0x0058:
                android.widget.RadioButton r0 = r0.f25105g
                r0.setChecked(r2)
                goto L_0x0078
            L_0x005e:
                java.lang.String r1 = "Mstr"
                boolean r1 = r4.equalsIgnoreCase(r1)
                if (r1 != 0) goto L_0x0073
                boolean r1 = android.text.TextUtils.isEmpty(r4)
                if (r1 == 0) goto L_0x006d
                goto L_0x0073
            L_0x006d:
                android.widget.RadioButton r0 = r0.f25107i
                r0.setChecked(r2)
                goto L_0x0078
            L_0x0073:
                android.widget.RadioButton r0 = r0.f25105g
                r0.setChecked(r2)
            L_0x0078:
                boolean r0 = r4.isEmpty()
                if (r0 != 0) goto L_0x008d
                com.travel.flight.flightticket.j.ae r0 = com.travel.flight.flightticket.j.ae.this
                java.util.ArrayList<com.travel.flight.pojo.flightticket.CJRTravellerDetails> r0 = r0.f25092d
                int r1 = r3.m
                java.lang.Object r0 = r0.get(r1)
                com.travel.flight.pojo.flightticket.CJRTravellerDetails r0 = (com.travel.flight.pojo.flightticket.CJRTravellerDetails) r0
                r0.setTravellerTitle(r4)
            L_0x008d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.j.ae.a.c(java.lang.String):void");
        }

        public final void a(TextView textView, LinearLayout linearLayout) {
            if (linearLayout.getTag() != null && (linearLayout.getTag() instanceof a)) {
                ae.this.f25096h = textView;
                CJRTravellerDetails cJRTravellerDetails = ae.this.f25092d.get(((a) linearLayout.getTag()).m);
                CJRDynamicValidation cJRDynamicValidation = (CJRDynamicValidation) textView.getTag();
                if (cJRDynamicValidation == null || cJRDynamicValidation.getKey().equalsIgnoreCase("dob")) {
                    ae.this.a(cJRTravellerDetails.getTravellerDOB());
                } else {
                    ae.this.a(cJRTravellerDetails.getTravellerDOB());
                }
            }
        }

        public final void a(String str) {
            ae aeVar = ae.this;
            aeVar.f25093e = ((a) this.f25101c.getTag()).m;
            net.one97.paytmflight.common.b.a.a(aeVar.f25089a);
            CJRTpUserProfileContact cJRTpUserProfileContact = null;
            if (ae.this.l != null) {
                for (int i2 = 0; i2 < ae.this.l.size(); i2++) {
                    if (str.trim().equalsIgnoreCase((ae.this.l.get(i2).getFirstname() + " " + ae.this.l.get(i2).getLastname()).trim())) {
                        try {
                            cJRTpUserProfileContact = ae.this.l.get(i2).clone();
                        } catch (CloneNotSupportedException unused) {
                        }
                    }
                }
            }
            if (cJRTpUserProfileContact != null) {
                ae.this.f25092d.get(this.m).setSelected_from_drop_down(true);
                this.n = cJRTpUserProfileContact.getTitle();
                c(this.n);
                a(cJRTpUserProfileContact);
            }
        }

        private void a(CJRTpUserProfileContact cJRTpUserProfileContact) {
            TextInputLayout textInputLayout;
            LinearLayout linearLayout = ae.this.k.get(Integer.valueOf(this.m)).j;
            int childCount = linearLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (linearLayout.getChildAt(i2) instanceof LinearLayout) {
                    LinearLayout linearLayout2 = (LinearLayout) linearLayout.getChildAt(i2);
                    if (linearLayout2.getChildAt(0) instanceof RelativeLayout) {
                        textInputLayout = (TextInputLayout) ((RelativeLayout) linearLayout2.findViewById(R.id.flyer_container)).findViewById(R.id.text_input_layout);
                    } else {
                        textInputLayout = (TextInputLayout) linearLayout2.findViewById(R.id.text_input_layout);
                        if (textInputLayout == null) {
                        }
                    }
                    View findViewById = textInputLayout.findViewById(R.id.child_view);
                    if (findViewById instanceof AutoCompleteTextView) {
                        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById;
                        CJRDynamicValidation cJRDynamicValidation = (CJRDynamicValidation) autoCompleteTextView.getTag();
                        String a2 = a(cJRDynamicValidation, cJRTpUserProfileContact, autoCompleteTextView.getText().toString());
                        cJRDynamicValidation.setmValue(a2);
                        String str = cJRDynamicValidation.getmAuxValue();
                        if (cJRDynamicValidation.getKey().equalsIgnoreCase("passport_issue_country") || cJRDynamicValidation.getKey().equalsIgnoreCase("nationality") || cJRDynamicValidation.getKey().equalsIgnoreCase("birth_country")) {
                            findViewById.setTag(R.id.TAG_FLAG_DISABLE_AUTO_FIRE_API, Boolean.TRUE);
                            findViewById.setTag(R.id.TAG_SAVED_CONTACT_ITEM, cJRTpUserProfileContact);
                            findViewById.setTag(R.id.TAG_AUTO_SUGGEST_VIEW_COUNTRY_TYPE, cJRDynamicValidation.getKey());
                        }
                        if (!TextUtils.isEmpty(str)) {
                            autoCompleteTextView.setText(str);
                        } else {
                            autoCompleteTextView.setText(a2);
                        }
                    } else if (findViewById instanceof EditText) {
                        EditText editText = (EditText) findViewById;
                        CJRDynamicValidation cJRDynamicValidation2 = (CJRDynamicValidation) editText.getTag();
                        String a3 = a(cJRDynamicValidation2, cJRTpUserProfileContact, (String) null);
                        cJRDynamicValidation2.setmValue(a3);
                        String str2 = cJRDynamicValidation2.getmAuxValue();
                        if (!TextUtils.isEmpty(str2)) {
                            editText.setText(str2);
                        } else {
                            editText.setText(a3);
                        }
                    }
                }
            }
        }

        private String a(CJRDynamicValidation cJRDynamicValidation, CJRTpUserProfileContact cJRTpUserProfileContact, String str) {
            String key = cJRDynamicValidation.getKey();
            String str2 = null;
            if (key.equals("title")) {
                str2 = cJRTpUserProfileContact.getTitle();
                this.n = str2;
            } else if (key.equals("dob")) {
                str2 = cJRTpUserProfileContact.getDob();
            } else if (key.equals("passport_expiry")) {
                str2 = cJRTpUserProfileContact.getPassport_expiry();
            } else if (key.equals("passport_issue_date")) {
                str2 = cJRTpUserProfileContact.getPassport_issue_date();
            } else if (key.equals("firstname")) {
                str2 = cJRTpUserProfileContact.getFirstname();
                this.o = str2;
            } else if (key.equals("lastname")) {
                str2 = cJRTpUserProfileContact.getLastname();
                this.p = str2;
            } else if (key.equals("passport_no")) {
                str2 = cJRTpUserProfileContact.getPassport_no();
            } else if (key.equals("visa_type")) {
                str2 = cJRTpUserProfileContact.getVisa_type();
            } else if (key.equals("onward_frequent_flyer_number") || key.equals("return_frequent_flyer_number") || key.equals("frequent_flyer_number")) {
                if (cJRDynamicValidation.getValue() == null || !cJRDynamicValidation.getValue().equals("Frequent Flyer Airline")) {
                    str2 = a(cJRTpUserProfileContact.getFf(), false, cJRDynamicValidation.getValues(), (String) null);
                } else {
                    str2 = a(cJRTpUserProfileContact.getFf(), true, cJRDynamicValidation.getValues(), str);
                }
            } else if (key.equals("passport_issue_country")) {
                str2 = cJRTpUserProfileContact.getPassport_issue_country();
                cJRDynamicValidation.setmAuxValue(cJRTpUserProfileContact.getPassport_country_displayname());
            } else if (key.equals("birth_country")) {
                str2 = cJRTpUserProfileContact.getBirth_country();
                cJRDynamicValidation.setmAuxValue(cJRTpUserProfileContact.getBirth_country_displayname());
            } else if (key.equals("nationality")) {
                str2 = cJRTpUserProfileContact.getNationality();
                cJRDynamicValidation.setmAuxValue(cJRTpUserProfileContact.getNationality_displayname());
            }
            ae.this.f25092d.get(ae.this.f25093e).setTravellerTitle(this.n);
            ae.this.f25092d.get(ae.this.f25093e).setTravellerFirstName(this.o);
            ae.this.f25092d.get(ae.this.f25093e).setTravellerLastName(this.p);
            return str2;
        }

        private static String a(HashMap<String, String> hashMap, boolean z, List<CJRDynamicValue> list, String str) {
            if (hashMap == null || hashMap.size() != 0) {
                for (Map.Entry next : hashMap.entrySet()) {
                    String str2 = (String) next.getKey();
                    String str3 = (String) next.getValue();
                    Iterator<CJRDynamicValue> it2 = list.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            CJRDynamicValue next2 = it2.next();
                            if (next2 != null && next2.getKey() != null && next2.getKey().equals(str2)) {
                                return z ? next2.getValue() : str3;
                            }
                        }
                    }
                }
            } else {
                for (CJRDynamicValue next3 : list) {
                    if (z) {
                        return str == null ? next3.getValue() : str;
                    }
                }
            }
            return str;
        }

        public final void a(String str, String str2) {
            ae aeVar = ae.this;
            aeVar.f25093e = ((a) this.f25101c.getTag()).m;
            aeVar.f25092d.get(ae.this.f25093e).setTravellerTitle(this.n);
            if (str.equalsIgnoreCase("firstname")) {
                this.o = str2;
                ae.this.f25092d.get(ae.this.f25093e).setTravellerFirstName(this.o);
            } else if (str.equalsIgnoreCase("lastname")) {
                this.p = str2;
                ae.this.f25092d.get(ae.this.f25093e).setTravellerLastName(this.p);
            }
        }

        public final void a(String str, String str2, int i2, View view, boolean z) {
            ae.this.j.a(str, str2, i2, view, z);
        }

        public final void a(String str, String str2, View view) {
            if (!str.equals("visa_type") || !str2.equalsIgnoreCase(ae.this.f25089a.getString(R.string.umra_visa))) {
                ae.this.m.setVisibility(8);
            } else if (!(ae.this.f25091c.f25032b == null || ae.this.f25091c.f25032b.getmUmraVisaMessage() == null || TextUtils.isEmpty(ae.this.f25091c.f25032b.getmUmraVisaMessage()))) {
                ae.this.m.setVisibility(0);
                ae.this.n.setText(ae.this.f25091c.f25032b.getmUmraVisaMessage());
            }
            final LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.lyt_student_baggage);
            final RoboTextView roboTextView = (RoboTextView) view.findViewById(R.id.txt_baggage_content);
            ((LinearLayout) view.findViewById(R.id.icon_close_student_baggage)).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    linearLayout.setVisibility(8);
                    roboTextView.setText((CharSequence) null);
                }
            });
            if (!str.equals("visa_type") || !str2.equalsIgnoreCase(ae.this.f25089a.getString(R.string.student))) {
                linearLayout.setVisibility(8);
                roboTextView.setText((CharSequence) null);
            } else if (ae.this.f25091c.f25032b.getMeta().getmStudentVisaNotes() != null && ae.this.f25091c.f25032b.getMeta().getmStudentVisaNotes().size() > 0) {
                linearLayout.setVisibility(0);
                roboTextView.setText(ae.this.f25091c.f25032b.getMeta().getmStudentVisaNotes().get(0));
            }
        }

        public final void a(CJRTpUserProfileContact cJRTpUserProfileContact, View view) {
            if (cJRTpUserProfileContact != null) {
                ae.this.j.a(cJRTpUserProfileContact, view);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:104:0x0556, code lost:
            if (r6.l.f25091c.f25032b.getmOnwardJourney().isNumerickeypad() != true) goto L_0x0559;
         */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x03a0  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x03a2  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void a(com.travel.flight.flightticket.j.ae.a r30, com.travel.flight.pojo.flightticket.CJRTravellerDetails r31, int r32) {
            /*
                r6 = r30
                r7 = r31
                r15 = r32
                android.widget.LinearLayout r0 = r6.j
                r14 = 0
                r0.setVisibility(r14)
                android.widget.LinearLayout r13 = r6.j
                java.util.List r0 = r31.getValidations()
                if (r0 == 0) goto L_0x0605
                java.util.List r11 = r31.getValidations()
                int r0 = r11.size()
                if (r15 >= r0) goto L_0x002b
                java.lang.Object r0 = r11.get(r15)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getmValue()
                r6.c((java.lang.String) r0)
            L_0x002b:
                int r10 = r11.size()
                r9 = 0
            L_0x0030:
                if (r9 >= r10) goto L_0x0605
                java.lang.Object r0 = r11.get(r9)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r8 = r0.getmValue()
                java.lang.Object r0 = r11.get(r9)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getType()
                java.lang.String r1 = "date"
                boolean r0 = r1.equalsIgnoreCase(r0)
                java.lang.String r3 = "sans-serif-medium"
                r4 = 0
                if (r0 == 0) goto L_0x00c3
                com.travel.flight.flightticket.widget.a r0 = r6.k
                java.lang.Object r5 = r11.get(r9)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r5 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r5
                android.view.LayoutInflater r12 = r0.f25315a
                int r1 = com.travel.flight.R.layout.pre_f_lyt_flight_textview
                android.view.View r1 = r12.inflate(r1, r4)
                int r4 = com.travel.flight.R.id.error_text
                android.view.View r4 = r1.findViewById(r4)
                com.paytm.utility.RoboTextView r4 = (com.paytm.utility.RoboTextView) r4
                java.lang.String r12 = r5.getValue()
                if (r12 == 0) goto L_0x007e
                int r12 = com.travel.flight.R.id.text_input_layout
                android.view.View r12 = r1.findViewById(r12)
                com.google.android.material.textfield.TextInputLayout r12 = (com.google.android.material.textfield.TextInputLayout) r12
                java.lang.String r2 = r5.getValue()
                r12.setHint(r2)
            L_0x007e:
                int r2 = com.travel.flight.R.id.child_view
                android.view.View r2 = r1.findViewById(r2)
                android.widget.EditText r2 = (android.widget.EditText) r2
                r2.setFocusable(r14)
                r2.setTag(r5)
                com.travel.flight.flightticket.widget.a$22 r12 = new com.travel.flight.flightticket.widget.a$22
                r12.<init>(r2, r13)
                r2.setOnClickListener(r12)
                com.travel.flight.flightticket.widget.a$23 r12 = new com.travel.flight.flightticket.widget.a$23
                r12.<init>()
                r2.setOnLongClickListener(r12)
                boolean r12 = com.paytm.utility.v.a((java.lang.String) r8)
                if (r12 != 0) goto L_0x00b2
                r2.setText(r8)
                android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r14)
                r2.setTypeface(r3)
                r3 = 1099431936(0x41880000, float:17.0)
                r8 = 2
                r2.setTextSize(r8, r3)
            L_0x00b2:
                com.travel.flight.flightticket.widget.a$24 r3 = new com.travel.flight.flightticket.widget.a$24
                r3.<init>(r4, r5, r2)
                r2.addTextChangedListener(r3)
                r13.addView(r1)
                r5 = r9
                r7 = r10
                r15 = r11
                r4 = r13
                goto L_0x01de
            L_0x00c3:
                java.lang.Object r0 = r11.get(r9)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getType()
                java.lang.String r1 = "textInput"
                boolean r0 = r1.equalsIgnoreCase(r0)
                if (r0 == 0) goto L_0x01b5
                java.lang.Object r0 = r11.get(r9)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getKey()
                java.lang.String r1 = "firstname"
                boolean r0 = r0.equalsIgnoreCase(r1)
                if (r0 == 0) goto L_0x019f
                com.travel.flight.flightticket.widget.a r5 = r6.k
                java.lang.String r3 = r31.getTravellerType()
                java.lang.Object r0 = r11.get(r9)
                r2 = r0
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r2 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r2
                android.view.LayoutInflater r0 = r5.f25315a
                int r1 = com.travel.flight.R.layout.lyt_flight_pax_drop_down_view_revamp
                android.view.View r4 = r0.inflate(r1, r4)
                int r0 = com.travel.flight.R.id.baggage_icon
                android.view.View r0 = r4.findViewById(r0)
                android.widget.ImageView r0 = (android.widget.ImageView) r0
                com.travel.utils.n$a r1 = com.travel.utils.n.a.V1
                java.lang.String r12 = "baggage_ancillary.png"
                com.travel.cdn.ResourceUtils.loadFlightImagesFromCDN(r0, r12, r14, r14, r1)
                int r0 = com.travel.flight.R.id.error_text
                android.view.View r0 = r4.findViewById(r0)
                r12 = r0
                com.paytm.utility.RoboTextView r12 = (com.paytm.utility.RoboTextView) r12
                int r0 = com.travel.flight.R.id.child_view
                android.view.View r0 = r4.findViewById(r0)
                r1 = r0
                android.widget.AutoCompleteTextView r1 = (android.widget.AutoCompleteTextView) r1
                java.lang.String r0 = r2.getValue()
                if (r0 == 0) goto L_0x0133
                int r0 = com.travel.flight.R.id.text_input_layout
                android.view.View r0 = r4.findViewById(r0)
                com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
                java.lang.String r14 = r2.getValue()
                r0.setHint(r14)
            L_0x0133:
                java.util.ArrayList<net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact> r0 = r5.f25317c
                java.util.ArrayList r14 = com.travel.flight.flightticket.widget.a.a((java.lang.String) r3, (java.util.ArrayList<net.one97.paytmflight.common.entity.travel.CJRTpUserProfileContact>) r0)
                com.travel.flight.flightticket.a.l r0 = new com.travel.flight.flightticket.a.l
                r16 = r1
                android.app.Activity r1 = r5.f25316b
                r19 = r0
                r22 = r16
                r23 = r10
                r10 = r2
                r2 = r14
                r20 = r3
                r3 = r30
                r7 = r4
                r4 = r22
                r24 = r9
                r9 = r5
                r5 = r32
                r0.<init>(r1, r2, r3, r4, r5)
                r0 = r22
                r0.setTag(r10)
                r1 = 1
                r0.setThreshold(r1)
                com.travel.flight.flightticket.widget.a$2 r1 = new com.travel.flight.flightticket.widget.a$2
                r1.<init>(r15, r10, r0)
                r0.addTextChangedListener(r1)
                r1 = r19
                r0.setAdapter(r1)
                com.travel.flight.flightticket.widget.a$3 r2 = new com.travel.flight.flightticket.widget.a$3
                r2.<init>(r12, r0)
                r0.setOnClickListener(r2)
                com.travel.flight.flightticket.widget.a$4 r2 = new com.travel.flight.flightticket.widget.a$4
                r2.<init>(r12, r1, r0)
                r0.setOnItemClickListener(r2)
                com.travel.flight.flightticket.widget.a$5 r2 = new com.travel.flight.flightticket.widget.a$5
                r16 = r2
                r17 = r9
                r18 = r14
                r21 = r0
                r16.<init>(r18, r19, r20, r21)
                r0.setOnTouchListener(r2)
                boolean r1 = com.paytm.utility.v.a((java.lang.String) r8)
                if (r1 != 0) goto L_0x0195
                r0.setText(r8)
            L_0x0195:
                r13.addView(r7)
                r15 = r11
                r4 = r13
                r7 = r23
                r5 = r24
                goto L_0x01de
            L_0x019f:
                r24 = r9
                r23 = r10
                com.travel.flight.flightticket.widget.a r0 = r6.k
                r14 = r24
                java.lang.Object r1 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r1
                android.view.View r0 = r0.b((net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r1, (java.lang.String) r8)
                r13.addView(r0)
                goto L_0x01d9
            L_0x01b5:
                r14 = r9
                r23 = r10
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getType()
                java.lang.String r1 = "dropdown"
                boolean r0 = r1.equalsIgnoreCase(r0)
                if (r0 == 0) goto L_0x01e2
                com.travel.flight.flightticket.widget.a r0 = r6.k
                java.lang.Object r1 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r1
                android.view.View r0 = r0.a((net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r1, (java.lang.String) r8)
                r13.addView(r0)
            L_0x01d9:
                r15 = r11
                r4 = r13
                r5 = r14
                r7 = r23
            L_0x01de:
                r1 = 8
                goto L_0x05f9
            L_0x01e2:
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getType()
                java.lang.String r1 = "multi_dropdown"
                boolean r0 = r1.equalsIgnoreCase(r0)
                if (r0 == 0) goto L_0x0574
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getKey()
                java.lang.String r1 = ""
                java.lang.String r2 = "frequent_flyer_number"
                java.lang.String r3 = "Frequent Flyer No"
                java.lang.String r5 = "Frequent Flyer Airline"
                if (r0 == 0) goto L_0x03bd
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getKey()
                java.lang.String r7 = "onward_frequent_flyer_number"
                boolean r0 = r0.equals(r7)
                if (r0 == 0) goto L_0x03bd
                com.travel.flight.flightticket.widget.a.c()
                com.travel.flight.flightticket.widget.a r0 = r6.k
                android.view.View r0 = r0.a()
                r13.addView(r0)
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                r0.setValue(r5)
                com.travel.flight.flightticket.widget.a r0 = r6.k
                java.lang.Object r5 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r5 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r5
                android.view.LayoutInflater r7 = r0.f25315a
                int r9 = com.travel.flight.R.layout.pre_f_flight_frequent_flyer_lyt
                android.view.View r7 = r7.inflate(r9, r4)
                int r9 = com.travel.flight.R.id.ff_main_container
                android.view.View r9 = r7.findViewById(r9)
                android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
                r0.f25318d = r9
                int r9 = com.travel.flight.R.id.arrow_button
                android.view.View r9 = r7.findViewById(r9)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                int r10 = com.travel.flight.R.id.child_view
                android.view.View r10 = r7.findViewById(r10)
                android.widget.AutoCompleteTextView r10 = (android.widget.AutoCompleteTextView) r10
                int r12 = com.travel.flight.R.id.error_text
                android.view.View r12 = r7.findViewById(r12)
                com.paytm.utility.RoboTextView r12 = (com.paytm.utility.RoboTextView) r12
                r10.setTag(r5)
                java.util.List r16 = r5.getValues()
                if (r16 == 0) goto L_0x02f6
                java.util.List r16 = r5.getValues()
                int r15 = r16.size()
                r16 = r1
                r1 = 1
                if (r15 <= r1) goto L_0x02f8
                r10.setKeyListener(r4)
                r1 = 0
                r9.setVisibility(r1)
                int r4 = com.travel.flight.R.drawable.pre_f_ic_flight_ff_arrow_down
                r9.setImageResource(r4)
                java.util.List r4 = r5.getValues()
                java.lang.Object r4 = r4.get(r1)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValue r4 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValue) r4
                java.lang.String r1 = r4.getValue()
                r10.setText(r1)
                com.travel.flight.flightticket.a.f r1 = new com.travel.flight.flightticket.a.f
                android.app.Activity r4 = r0.f25316b
                java.util.List r15 = r5.getValues()
                r1.<init>(r4, r15)
                r10.setAdapter(r1)
                com.travel.flight.flightticket.widget.a$7 r1 = new com.travel.flight.flightticket.widget.a$7
                r1.<init>(r9, r10)
                r10.setOnTouchListener(r1)
                com.travel.flight.flightticket.widget.a$8 r1 = new com.travel.flight.flightticket.widget.a$8
                r1.<init>(r9)
                r10.setOnDismissListener(r1)
                com.travel.flight.flightticket.widget.a$9 r1 = new com.travel.flight.flightticket.widget.a$9
                r1.<init>(r9)
                r10.setOnFocusChangeListener(r1)
                java.util.List r1 = r5.getValues()
                int r1 = r1.size()
                r4 = 1
                if (r1 != r4) goto L_0x02d8
                java.util.List r1 = r5.getValues()
                r4 = 0
                java.lang.Object r1 = r1.get(r4)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValue r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValue) r1
                java.lang.String r1 = r1.getValue()
                r10.setText(r1)
                goto L_0x02e1
            L_0x02d8:
                boolean r1 = com.paytm.utility.v.a((java.lang.String) r8)
                if (r1 != 0) goto L_0x02e1
                r10.setText(r8)
            L_0x02e1:
                com.travel.flight.flightticket.widget.a$11 r1 = new com.travel.flight.flightticket.widget.a$11
                r24 = r1
                r25 = r0
                r26 = r9
                r27 = r12
                r28 = r10
                r29 = r5
                r24.<init>(r26, r27, r28, r29)
                r10.setOnItemClickListener(r1)
                goto L_0x032a
            L_0x02f6:
                r16 = r1
            L_0x02f8:
                r1 = 8
                r9.setVisibility(r1)
                java.util.List r9 = r5.getValues()
                int r9 = r9.size()
                r15 = 1
                if (r9 != r15) goto L_0x0321
                r12.setVisibility(r1)
                r12.setText(r4)
                java.util.List r1 = r5.getValues()
                r4 = 0
                java.lang.Object r1 = r1.get(r4)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValue r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValue) r1
                java.lang.String r1 = r1.getValue()
                r10.setText(r1)
                goto L_0x032a
            L_0x0321:
                boolean r1 = com.paytm.utility.v.a((java.lang.String) r8)
                if (r1 != 0) goto L_0x032a
                r10.setText(r8)
            L_0x032a:
                com.travel.flight.flightticket.widget.a$12 r1 = new com.travel.flight.flightticket.widget.a$12
                r1.<init>(r10)
                r10.addTextChangedListener(r1)
                android.widget.LinearLayout r0 = r0.f25318d
                r1 = 8
                r0.setVisibility(r1)
                r13.addView(r7)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = new net.one97.paytmflight.common.entity.travel.CJRDynamicValidation
                r0.<init>()
                r0.setValue(r3)
                r0.setKey(r2)
                java.lang.Object r1 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r1
                java.util.List r1 = r1.getValues()
                r0.setValues(r1)
                java.lang.Object r1 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r1
                java.lang.Boolean r1 = r1.isOptional()
                r0.setOptional(r1)
                r1 = 0
                r0.setReturnTrip(r1)
                com.travel.flight.flightticket.j.ae r1 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r1 = r1.f25091c
                if (r1 == 0) goto L_0x03a2
                com.travel.flight.flightticket.j.ae r1 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r1 = r1.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r1.f25032b
                if (r1 == 0) goto L_0x03a2
                com.travel.flight.flightticket.j.ae r1 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r1 = r1.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r1.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
                if (r1 == 0) goto L_0x03a2
                com.travel.flight.flightticket.j.ae r1 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r1 = r1.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r1.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
                boolean r1 = r1.isNumerickeypad()
                if (r1 == 0) goto L_0x03a2
                com.travel.flight.flightticket.j.ae r1 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r1 = r1.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r1 = r1.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r1 = r1.getmOnwardJourney()
                boolean r1 = r1.isNumerickeypad()
                r2 = 1
                if (r1 != r2) goto L_0x03a2
                r1 = 1
                goto L_0x03a3
            L_0x03a2:
                r1 = 0
            L_0x03a3:
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r2 = r2.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r2.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
                r2.isNumerickeypad()
                com.travel.flight.flightticket.widget.a r2 = r6.k
                r7 = r16
                android.view.View r0 = r2.a(r0, r7, r1)
                r13.addView(r0)
                goto L_0x01d9
            L_0x03bd:
                r7 = r1
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getKey()
                if (r0 == 0) goto L_0x01d9
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getKey()
                java.lang.String r1 = "return_frequent_flyer_number"
                boolean r0 = r0.equals(r1)
                if (r0 == 0) goto L_0x01d9
                boolean r0 = com.travel.flight.flightticket.widget.a.b()
                if (r0 != 0) goto L_0x03eb
                com.travel.flight.flightticket.widget.a r0 = r6.k
                android.view.View r0 = r0.a()
                r13.addView(r0)
            L_0x03eb:
                com.travel.flight.flightticket.widget.a.c()
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                r0.setValue(r5)
                com.travel.flight.flightticket.widget.a r0 = r6.k
                java.lang.Object r1 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r1
                android.view.LayoutInflater r5 = r0.f25315a
                int r9 = com.travel.flight.R.layout.pre_f_flight_frequent_flyer_lyt
                android.view.View r5 = r5.inflate(r9, r4)
                int r9 = com.travel.flight.R.id.ff_main_container
                android.view.View r9 = r5.findViewById(r9)
                android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
                r0.f25320f = r9
                int r9 = com.travel.flight.R.id.arrow_button
                android.view.View r9 = r5.findViewById(r9)
                android.widget.ImageView r9 = (android.widget.ImageView) r9
                int r10 = com.travel.flight.R.id.child_view
                android.view.View r10 = r5.findViewById(r10)
                android.widget.AutoCompleteTextView r10 = (android.widget.AutoCompleteTextView) r10
                int r12 = com.travel.flight.R.id.error_text
                android.view.View r12 = r5.findViewById(r12)
                com.paytm.utility.RoboTextView r12 = (com.paytm.utility.RoboTextView) r12
                r10.setTag(r1)
                java.util.List r15 = r1.getValues()
                if (r15 == 0) goto L_0x04ae
                java.util.List r15 = r1.getValues()
                int r15 = r15.size()
                r16 = r7
                r7 = 1
                if (r15 <= r7) goto L_0x04b0
                r10.setKeyListener(r4)
                r4 = 0
                r9.setVisibility(r4)
                int r7 = com.travel.flight.R.drawable.pre_f_ic_flight_ff_arrow_down
                r9.setImageResource(r7)
                com.travel.flight.flightticket.a.f r7 = new com.travel.flight.flightticket.a.f
                android.app.Activity r15 = r0.f25316b
                java.util.List r4 = r1.getValues()
                r7.<init>(r15, r4)
                r10.setAdapter(r7)
                java.util.List r4 = r1.getValues()
                r7 = 0
                java.lang.Object r4 = r4.get(r7)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValue r4 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValue) r4
                java.lang.String r4 = r4.getValue()
                r10.setText(r4)
                com.travel.flight.flightticket.widget.a$13 r4 = new com.travel.flight.flightticket.widget.a$13
                r4.<init>(r9, r10)
                r10.setOnTouchListener(r4)
                java.util.List r4 = r1.getValues()
                int r4 = r4.size()
                r15 = 1
                if (r4 != r15) goto L_0x0490
                java.util.List r4 = r1.getValues()
                java.lang.Object r4 = r4.get(r7)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValue r4 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValue) r4
                java.lang.String r4 = r4.getValue()
                r10.setText(r4)
                goto L_0x0499
            L_0x0490:
                boolean r4 = com.paytm.utility.v.a((java.lang.String) r8)
                if (r4 != 0) goto L_0x0499
                r10.setText(r8)
            L_0x0499:
                com.travel.flight.flightticket.widget.a$14 r4 = new com.travel.flight.flightticket.widget.a$14
                r24 = r4
                r25 = r0
                r26 = r9
                r27 = r12
                r28 = r10
                r29 = r1
                r24.<init>(r26, r27, r28, r29)
                r10.setOnItemClickListener(r4)
                goto L_0x04e2
            L_0x04ae:
                r16 = r7
            L_0x04b0:
                r7 = 8
                r9.setVisibility(r7)
                java.util.List r9 = r1.getValues()
                int r9 = r9.size()
                r15 = 1
                if (r9 != r15) goto L_0x04d9
                r12.setVisibility(r7)
                r12.setText(r4)
                java.util.List r1 = r1.getValues()
                r4 = 0
                java.lang.Object r1 = r1.get(r4)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValue r1 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValue) r1
                java.lang.String r1 = r1.getValue()
                r10.setText(r1)
                goto L_0x04e2
            L_0x04d9:
                boolean r1 = com.paytm.utility.v.a((java.lang.String) r8)
                if (r1 != 0) goto L_0x04e2
                r10.setText(r8)
            L_0x04e2:
                com.travel.flight.flightticket.widget.a$15 r1 = new com.travel.flight.flightticket.widget.a$15
                r1.<init>(r10)
                r10.addTextChangedListener(r1)
                android.widget.LinearLayout r0 = r0.f25320f
                r1 = 8
                r0.setVisibility(r1)
                r13.addView(r5)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = new net.one97.paytmflight.common.entity.travel.CJRDynamicValidation
                r0.<init>()
                r0.setValue(r3)
                r0.setKey(r2)
                java.lang.Object r2 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r2 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r2
                java.lang.Boolean r2 = r2.isOptional()
                r0.setOptional(r2)
                java.lang.Object r2 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r2 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r2
                java.util.List r2 = r2.getValues()
                r0.setValues(r2)
                r2 = 1
                r0.setReturnTrip(r2)
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r2 = r2.f25091c
                if (r2 == 0) goto L_0x0559
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r2 = r2.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r2.f25032b
                if (r2 == 0) goto L_0x0559
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r2 = r2.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r2.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
                if (r2 == 0) goto L_0x0559
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r2 = r2.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r2.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
                boolean r2 = r2.isNumerickeypad()
                if (r2 == 0) goto L_0x0559
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r2 = r2.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r2.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
                boolean r2 = r2.isNumerickeypad()
                r3 = 1
                if (r2 != r3) goto L_0x0559
                goto L_0x055a
            L_0x0559:
                r3 = 0
            L_0x055a:
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                com.travel.flight.flightticket.g.g r2 = r2.f25091c
                com.travel.flight.pojo.flightticket.CJRFlightDetails r2 = r2.f25032b
                com.travel.flight.pojo.flightticket.CJRFlightDetailsItem r2 = r2.getmOnwardJourney()
                r2.isNumerickeypad()
                com.travel.flight.flightticket.widget.a r2 = r6.k
                r4 = r16
                android.view.View r0 = r2.b(r0, r4, r3)
                r13.addView(r0)
                goto L_0x05f4
            L_0x0574:
                r1 = 8
                java.lang.Object r0 = r11.get(r14)
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r0 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r0
                java.lang.String r0 = r0.getType()
                java.lang.String r2 = "autosuggest"
                boolean r0 = r2.equalsIgnoreCase(r0)
                if (r0 == 0) goto L_0x05f4
                com.travel.flight.flightticket.widget.a r9 = r6.k
                java.lang.Object r0 = r11.get(r14)
                r12 = r0
                net.one97.paytmflight.common.entity.travel.CJRDynamicValidation r12 = (net.one97.paytmflight.common.entity.travel.CJRDynamicValidation) r12
                android.view.LayoutInflater r0 = r9.f25315a
                int r2 = com.travel.flight.R.layout.pre_f_flight_pax_autosuggest
                android.view.View r0 = r0.inflate(r2, r4)
                int r2 = com.travel.flight.R.id.child_view
                android.view.View r2 = r0.findViewById(r2)
                android.widget.AutoCompleteTextView r2 = (android.widget.AutoCompleteTextView) r2
                int r4 = com.travel.flight.R.id.error_text
                android.view.View r4 = r0.findViewById(r4)
                r10 = r4
                com.paytm.utility.RoboTextView r10 = (com.paytm.utility.RoboTextView) r10
                r2.setTag(r12)
                if (r12 == 0) goto L_0x05c4
                java.lang.String r4 = r12.getValue()
                if (r4 == 0) goto L_0x05c4
                int r4 = com.travel.flight.R.id.text_input_layout
                android.view.View r4 = r0.findViewById(r4)
                com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
                java.lang.String r5 = r12.getValue()
                r4.setHint(r5)
            L_0x05c4:
                boolean r4 = com.paytm.utility.v.a((java.lang.String) r8)
                if (r4 != 0) goto L_0x05dc
                r2.setText(r8)
                r4 = 0
                android.graphics.Typeface r3 = android.graphics.Typeface.create(r3, r4)
                r2.setTypeface(r3)
                r3 = 1099431936(0x41880000, float:17.0)
                r5 = 2
                r2.setTextSize(r5, r3)
                goto L_0x05dd
            L_0x05dc:
                r4 = 0
            L_0x05dd:
                com.travel.flight.flightticket.widget.a$1 r3 = new com.travel.flight.flightticket.widget.a$1
                r8 = r3
                r5 = r14
                r7 = r23
                r15 = r11
                r11 = r2
                r14 = r13
                r13 = r32
                r4 = r14
                r14 = r0
                r8.<init>(r10, r11, r12, r13, r14)
                r2.addTextChangedListener(r3)
                r4.addView(r0)
                goto L_0x05f9
            L_0x05f4:
                r15 = r11
                r4 = r13
                r5 = r14
                r7 = r23
            L_0x05f9:
                int r9 = r5 + 1
                r13 = r4
                r10 = r7
                r11 = r15
                r14 = 0
                r7 = r31
                r15 = r32
                goto L_0x0030
            L_0x0605:
                r1 = 8
                r0 = r31
                if (r0 == 0) goto L_0x0632
                java.lang.String r2 = r31.getTravellerType()
                java.lang.String r3 = "Adult"
                boolean r2 = r3.equalsIgnoreCase(r2)
                if (r2 == 0) goto L_0x0625
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                android.content.Context r2 = r2.f25090b
                int r3 = com.travel.flight.R.string.flights_mr
                java.lang.String r2 = r2.getString(r3)
                r0.setTravellerTitle(r2)
                goto L_0x0632
            L_0x0625:
                com.travel.flight.flightticket.j.ae r2 = com.travel.flight.flightticket.j.ae.this
                android.content.Context r2 = r2.f25090b
                int r3 = com.travel.flight.R.string.flights_mstr
                java.lang.String r2 = r2.getString(r3)
                r0.setTravellerTitle(r2)
            L_0x0632:
                android.widget.TextView r0 = r6.f25101c
                java.lang.Object r0 = r0.getTag()
                com.travel.flight.flightticket.j.ae$a r0 = (com.travel.flight.flightticket.j.ae.a) r0
                if (r32 != 0) goto L_0x0654
                if (r0 == 0) goto L_0x0654
                android.widget.ImageView r2 = r0.f25100b
                r2.setVisibility(r1)
                android.widget.LinearLayout r2 = r0.f25103e
                r3 = 0
                r2.setVisibility(r3)
                android.view.View r0 = r0.f25102d
                r0.setVisibility(r1)
                com.travel.flight.flightticket.j.ae r0 = com.travel.flight.flightticket.j.ae.this
                int r1 = r6.m
                r0.f25093e = r1
            L_0x0654:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightticket.j.ae.a.a(com.travel.flight.flightticket.j.ae$a, com.travel.flight.pojo.flightticket.CJRTravellerDetails, int):void");
        }
    }

    public final void a(String str) {
        new w(this.f25096h, this.f25090b, str).show(this.p.getSupportFragmentManager(), H5Plugin.CommonEvents.DATE_PICKER);
    }
}
