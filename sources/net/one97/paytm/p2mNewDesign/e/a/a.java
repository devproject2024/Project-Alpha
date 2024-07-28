package net.one97.paytm.p2mNewDesign.e.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b;
import net.one97.paytm.p2mNewDesign.entity.CardDetailsV2;
import net.one97.paytm.p2mNewDesign.entity.InstrumentInfo;
import net.one97.paytm.p2mNewDesign.f.g;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.a;

public final class a extends net.one97.paytm.p2mNewDesign.e.a implements View.OnClickListener {
    private static String A = "home/pay-send/post-scan";
    private boolean B;
    private View C;
    private RelativeLayout D;
    private boolean E;
    private HashMap<String, CardDetailsV2> F;
    private HashMap<String, CardDetailsV2> G;
    /* access modifiers changed from: private */
    public LinearLayout H;
    /* access modifiers changed from: private */
    public double I = 0.0d;
    private List<View> J = new ArrayList();
    private List<View> K = new ArrayList();
    private LinearLayout L;
    private RelativeLayout M;
    private boolean N = true;
    private View O;
    private boolean P;
    private String Q;
    private boolean R = false;

    /* renamed from: a  reason: collision with root package name */
    public RelativeLayout f13256a;

    /* renamed from: b  reason: collision with root package name */
    public EditText f13257b;

    /* renamed from: d  reason: collision with root package name */
    View f13258d;

    /* renamed from: e  reason: collision with root package name */
    View f13259e;

    /* renamed from: f  reason: collision with root package name */
    boolean f13260f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f13261g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Context f13262h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f13263i;
    private RadioButton j;
    /* access modifiers changed from: private */
    public String k;
    private TextView l;
    private RelativeLayout m;
    private List<View> n;
    private List<View> o;
    private RadioButton p;
    private RelativeLayout q;
    private String r;
    private InstrumentInfo s;
    private LinearLayout t;
    private int u;
    private CheckBox v;
    /* access modifiers changed from: private */
    public g w;
    private List<InstrumentInfo> x;
    private List<InstrumentInfo> y;
    private TextView z;

    private boolean o() {
        return !TextUtils.isEmpty(this.w.d()) && !TextUtils.isEmpty(b.f().D()) && Double.valueOf(this.w.d()).doubleValue() >= 0.0d && Double.valueOf(this.w.d()).doubleValue() <= Double.valueOf(b.f().D()).doubleValue();
    }

    public final void onClick(View view) {
        boolean z2;
        boolean z3;
        boolean z4;
        View view2 = view;
        int id = view.getId();
        String u2 = b.f().u(this.k);
        if (!TextUtils.isEmpty(u2) && !"0".equalsIgnoreCase(u2) && Double.parseDouble(u2) < Double.valueOf(this.w.d()).doubleValue()) {
            b.f();
            if (b.q(this.k)) {
                this.w.a(String.format(this.f13262h.getResources().getString(R.string.merchant_limit_exhaust_p2m), new Object[]{u2}), false, false);
                return;
            }
        }
        b.f();
        if (!b.q(this.k)) {
            this.w.a("0".equalsIgnoreCase(b.f().A) ? this.f13262h.getResources().getString(R.string.limit_breach_msg) : String.format(this.f13262h.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A}), false, false);
        } else if (this.R) {
            this.w.a(this.f13262h.getString(R.string.card_otp_breached_alert), false, false);
        } else if (id == R.id.rl_card) {
            if (b.f().J == null || b.f().H == null || !b.f().L) {
                String str = (String) view.getTag();
                if (b.f().n == null || b.f().n.getPaymentDetails() == null || !this.s.getPaymentDetails().contains(b.f().n.getPaymentDetails())) {
                    if (b.f().n != null && str.equalsIgnoreCase(b.f().n.getPaymentDetails())) {
                        boolean isCardFromEMITab = b.f().n.isCardFromEMITab();
                        List<InstrumentInfo> list = this.x;
                        if (list != null) {
                            Iterator<InstrumentInfo> it2 = list.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                InstrumentInfo next = it2.next();
                                if (next.getPaymentDetails().equalsIgnoreCase(b.f().n.getPaymentDetails())) {
                                    z4 = next.isCardFromEMITab();
                                    break;
                                }
                            }
                        }
                        List<InstrumentInfo> list2 = this.y;
                        if (list2 != null) {
                            Iterator<InstrumentInfo> it3 = list2.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                InstrumentInfo next2 = it3.next();
                                if (next2.getPaymentDetails().equalsIgnoreCase(b.f().n.getPaymentDetails())) {
                                    z4 = next2.isCardFromEMITab();
                                    break;
                                }
                            }
                        }
                        z4 = false;
                        if (isCardFromEMITab == z4) {
                            return;
                        }
                    }
                    LinearLayout linearLayout = this.f13261g;
                    boolean booleanValue = (linearLayout == null || linearLayout.getTag() == null) ? false : ((Boolean) this.f13261g.getTag()).booleanValue();
                    g(str);
                    List<View> list3 = this.n;
                    if (list3 != null && list3.size() > 0) {
                        Iterator<View> it4 = this.n.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                break;
                            }
                            View next3 = it4.next();
                            String str2 = (String) next3.getTag();
                            if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
                                a("offline_payments", "post_scan_saveddc_selected", b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", this.f13262h, A);
                                this.f13258d = next3;
                            }
                        }
                    }
                    List<View> list4 = this.o;
                    if (list4 != null && list4.size() > 0) {
                        for (View next4 : this.o) {
                            String str3 = (String) next4.getTag();
                            if (!TextUtils.isEmpty(str3) && str3.equalsIgnoreCase(str)) {
                                if (b.f().f13092h) {
                                    a("offline_payments", "post_pay_savedcc_selected", "flow_through_scan_icon", this.f13262h, A);
                                } else {
                                    a("offline_payments", "post_pay_savedcc_selected", "flow_through_pay_icon", this.f13262h, A);
                                }
                                this.f13258d = next4;
                            }
                        }
                    }
                    if (this.k.equalsIgnoreCase(SDKConstants.DEBIT)) {
                        this.s = b.f().f(str);
                    } else {
                        this.s = b.f().g(str);
                    }
                    RadioButton radioButton = this.p;
                    if (radioButton != null) {
                        radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_inactive));
                    }
                    RelativeLayout relativeLayout = this.f13256a;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    LinearLayout linearLayout2 = this.L;
                    if (linearLayout2 != null) {
                        linearLayout2.clearAnimation();
                        this.L.setVisibility(8);
                    }
                    RelativeLayout relativeLayout2 = this.D;
                    if (relativeLayout2 != null) {
                        relativeLayout2.setVisibility(8);
                    }
                    TextView textView = this.z;
                    if (textView != null) {
                        textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                    }
                    TextView textView2 = this.l;
                    if (textView2 != null) {
                        textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
                    }
                    RelativeLayout relativeLayout3 = this.q;
                    if (relativeLayout3 != null) {
                        relativeLayout3.setVisibility(8);
                    }
                    this.f13256a = (RelativeLayout) view2.findViewById(R.id.rl_cvv_layout);
                    this.L = (LinearLayout) view2.findViewById(R.id.ll_visa_one_click);
                    this.M = (RelativeLayout) view2.findViewById(R.id.lyt_scp_enabled);
                    this.N = true;
                    this.H = (LinearLayout) view2.findViewById(R.id.cvv_container);
                    this.D = (RelativeLayout) view2.findViewById(R.id.lyt_emi_plan);
                    this.s = e(str);
                    InstrumentInfo instrumentInfo = this.s;
                    this.B = instrumentInfo == null ? false : instrumentInfo.isEmiClicked();
                    this.D.setVisibility(this.B ? 0 : 8);
                    if (this.E) {
                        this.D.setVisibility(8);
                    }
                    this.f13257b = (EditText) this.f13256a.findViewById(R.id.et_cvv);
                    t();
                    this.f13257b.getText().clear();
                    this.r = this.s.getCardType();
                    r();
                    this.f13263i = (TextView) this.f13256a.findViewById(R.id.tv_cvv_help);
                    this.f13263i.setVisibility(8);
                    q();
                    if (!this.s.isOneClickSupported() || !b.f().G || !this.s.isEnrollmentPossible() || b.f().J != null) {
                        this.f13256a.setVisibility(0);
                        h();
                        z2 = false;
                    } else {
                        z2 = this.s.isScpEnrolled();
                        if (!z2) {
                            d(false);
                        } else if (o()) {
                            d(true);
                        } else {
                            this.f13256a.setVisibility(0);
                            h();
                        }
                        p();
                    }
                    this.z = (TextView) view2.findViewById(R.id.tv_instrument_primary_info);
                    this.z.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    this.q = (RelativeLayout) this.f13256a.findViewById(R.id.rl_proceed_to_pay);
                    this.q.setVisibility(8);
                    this.q.setTag("saved");
                    this.q.setOnClickListener(this);
                    this.p = (RadioButton) view2.findViewById(R.id.rb_instrumentInfo);
                    this.p.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_active));
                    this.w.d(a());
                    try {
                        InstrumentInfo instrumentInfo2 = (InstrumentInfo) this.s.clone();
                        instrumentInfo2.setEmiClicked(booleanValue);
                        this.w.a(instrumentInfo2, "uncheck");
                        this.w.a(instrumentInfo2, "sectionClose");
                        this.w.a(instrumentInfo2, "updateSelection");
                        if (booleanValue) {
                            z3 = true;
                        } else {
                            z3 = this.B;
                        }
                        instrumentInfo2.setEmiClicked(z3);
                    } catch (Exception unused) {
                        this.w.a(this.s, "uncheck");
                        this.w.a(this.s, "sectionClose");
                        this.w.a(this.s, "updateSelection");
                    }
                    if (!this.P && !z2) {
                        this.f13257b.requestFocus();
                        d();
                    }
                    this.P = false;
                    return;
                }
                return;
            }
            this.f51247c = false;
        } else if (id == R.id.rl_proceed_to_pay) {
            s();
        }
    }

    private void p() {
        net.one97.paytm.wallet.i.b bVar = net.one97.paytm.wallet.i.b.f70414a;
        net.one97.paytm.wallet.i.b.a(this.f13262h, this.s.getCardFirstSixDigit(), this.s.getCardLastFourDigit(), "");
    }

    private void b(String str) {
        Toast.makeText(this.f13262h, str, 0).show();
    }

    public final void d() {
        if (!this.w.k()) {
            ((InputMethodManager) this.f13262h.getSystemService("input_method")).toggleSoftInput(2, 1);
        }
    }

    private void q() {
        if (!TextUtils.isEmpty(this.r)) {
            if (this.r.equalsIgnoreCase(SDKConstants.MAESTRO) || this.r.equalsIgnoreCase("BAJAJ FINSERV EMI CARD") || this.r.equalsIgnoreCase("bajaj") || this.r.equalsIgnoreCase("bajajfn")) {
                this.f13257b.setVisibility(8);
            } else {
                this.f13257b.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(View view) {
        Context context = this.f13262h;
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (view != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    private void r() {
        if (TextUtils.isEmpty(this.r) || this.r.equalsIgnoreCase("AMEX")) {
            this.f13257b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            this.u = 4;
        } else if (this.r.equalsIgnoreCase("MASTER") || this.r.equalsIgnoreCase(SDKConstants.VISA) || this.r.equalsIgnoreCase("DINERS") || this.r.equalsIgnoreCase("RUPAY")) {
            this.f13257b.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            this.u = 3;
        }
    }

    public final void a(g gVar) {
        this.w = gVar;
    }

    private void s() {
        if (this.q.getTag().equals("saved")) {
            this.s.setSavedCard(true);
            String obj = this.f13257b.getText().toString();
            boolean isScpEnrolled = this.s.isScpEnrolled();
            String str = "EMI";
            if (this.s.isOneClickSupported() && isScpEnrolled) {
                InstrumentInfo instrumentInfo = this.s;
                if (instrumentInfo != null) {
                    this.r = instrumentInfo.getCardType();
                    this.s.setUniqueId(a());
                    b.f().a(this.s);
                }
                StringBuilder sb = new StringBuilder(this.s.getPaymentDetails().replace("|", ""));
                sb.append("||" + obj + "|");
                this.s.setPaymentDetails(sb.toString());
                this.s = e(this.s.getPaymentDetails());
                this.B = this.s.isEmiClicked();
                InstrumentInfo instrumentInfo2 = this.s;
                if (!this.B) {
                    str = this.k;
                }
                instrumentInfo2.setPayMode(str);
                if (this.B) {
                    InstrumentInfo instrumentInfo3 = this.s;
                    instrumentInfo3.setPlanId(f(instrumentInfo3.getPaymentDetails()));
                    this.s.setEmiType(this.k);
                }
                i();
            } else if (c(obj)) {
                b(this.f13262h.getString(R.string.please_enter_cvv));
                this.w.c(false);
                this.f13257b.requestFocus();
                d();
                return;
            } else {
                InstrumentInfo instrumentInfo4 = this.s;
                if (instrumentInfo4 != null) {
                    this.r = instrumentInfo4.getCardType();
                    this.s.setUniqueId(a());
                    b.f().a(this.s);
                }
                StringBuilder sb2 = new StringBuilder(this.s.getPaymentDetails());
                if (sb2.length() > 5) {
                    String substring = sb2.substring(sb2.length() - 6, sb2.length());
                    if (substring.startsWith("||") && substring.endsWith("|")) {
                        sb2 = new StringBuilder(sb2.substring(0, sb2.length() - 6));
                    }
                }
                String sb3 = sb2.toString();
                if (!sb3.endsWith(obj + "|")) {
                    sb2.append("||" + obj + "|");
                }
                this.s.setPaymentDetails(sb2.toString());
                this.s = e(this.s.getPaymentDetails());
                this.B = this.s.isEmiClicked();
                InstrumentInfo instrumentInfo5 = this.s;
                if (!this.B) {
                    str = this.k;
                }
                instrumentInfo5.setPayMode(str);
                if (this.B) {
                    InstrumentInfo instrumentInfo6 = this.s;
                    instrumentInfo6.setPlanId(f(instrumentInfo6.getPaymentDetails()));
                    this.s.setEmiType(this.k);
                }
            }
            this.w.a(this.s, "proceedtoPay");
        }
    }

    private void t() {
        EditText editText = this.f13257b;
        if (editText != null) {
            editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    Resources resources;
                    int i2;
                    if (a.this.H != null) {
                        LinearLayout a2 = a.this.H;
                        if (z) {
                            resources = a.this.f13262h.getResources();
                            i2 = R.drawable.blue_stroke;
                        } else {
                            resources = a.this.f13262h.getResources();
                            i2 = R.drawable.gray_stroke;
                        }
                        a2.setBackground(resources.getDrawable(i2));
                    }
                }
            });
        }
    }

    private boolean c(String str) {
        if ("BAJAJ FINSERV EMI CARD".equalsIgnoreCase(this.r)) {
            return false;
        }
        if (TextUtils.isEmpty(str) || str.length() < this.u) {
            return true;
        }
        return false;
    }

    public final void g() {
        if (b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
            for (View next : this.o) {
                if (next.getTag().equals(b.f().n.getPaymentDetails())) {
                    this.C = next;
                    b(b.f().n.getSelectedEMIPlan());
                    b(next);
                    c(next);
                }
            }
            return;
        }
        for (View next2 : this.n) {
            if (next2.getTag().equals(b.f().n.getPaymentDetails())) {
                this.C = next2;
                b(b.f().n.getSelectedEMIPlan());
                b(next2);
                c(next2);
            }
        }
    }

    private void d(String str) {
        if (b.f().n != null) {
            if (TextUtils.isEmpty(this.w.d()) || ((b.f().n.getmMinAmount() != null && Double.parseDouble(this.w.d()) < b.f().n.getmMinAmount().getValue().doubleValue()) || (b.f().n.getmMaxAmount() != null && Double.parseDouble(this.w.d()) > b.f().n.getmMaxAmount().getValue().doubleValue()))) {
                if (b.f().n.getSelectedEMIPlan() != null && u() != null) {
                    ((RoboTextView) this.C.findViewById(R.id.tv_instrument_secondary_info_2)).setVisibility(0);
                    ((RelativeLayout) this.C.findViewById(R.id.lyt_emi_plan)).setVisibility(8);
                    b.f().a((net.one97.paytm.p2mNewDesign.models.a) null);
                    b.f().n.setEmiClicked(false);
                    b.f().n.setEmiTypeCard(false);
                    this.s = a(b.f().n.getSelectedEMIPlan(), false);
                }
            } else if (b.f().n.getSelectedEMIPlan() != null) {
                b.f().n.getSelectedEMIPlan().f56922e = str;
                this.s = a(b.f().n.getSelectedEMIPlan(), true);
                b(u());
            }
        }
    }

    private void b(View view) {
        ((RoboTextView) view.findViewById(R.id.tv_instrument_secondary_info_2)).setVisibility(8);
        ((RelativeLayout) view.findViewById(R.id.lyt_emi_plan)).setVisibility(0);
        net.one97.paytm.p2mNewDesign.models.a selectedEMIPlan = b.f().n.getSelectedEMIPlan();
        if (selectedEMIPlan != null) {
            ((TextView) view.findViewById(R.id.tv_emi_plan_detail)).setText("EMI of ₹" + net.one97.paytm.wallet.utility.a.a(Double.valueOf(this.w.d()).doubleValue()) + " for " + selectedEMIPlan.a() + " months @ " + selectedEMIPlan.f56920c + "% p. a.");
            StringBuilder sb = new StringBuilder("Total ₹");
            sb.append(net.one97.paytm.wallet.utility.a.a(a(selectedEMIPlan)));
            ((TextView) view.findViewById(R.id.tv_total_emi_value)).setText(sb.toString());
        }
    }

    private InstrumentInfo e(String str) {
        List<InstrumentInfo> list = this.y;
        if (list != null) {
            for (InstrumentInfo next : list) {
                if (next.getPaymentDetails().equalsIgnoreCase(str)) {
                    return next;
                }
            }
        }
        List<InstrumentInfo> list2 = this.x;
        if (list2 != null) {
            for (InstrumentInfo next2 : list2) {
                if (next2.getPaymentDetails().equalsIgnoreCase(str)) {
                    return next2;
                }
            }
        }
        return this.s;
    }

    /* access modifiers changed from: private */
    public void b(net.one97.paytm.p2mNewDesign.models.a aVar) {
        List<InstrumentInfo> list = this.y;
        if (list != null) {
            Iterator<InstrumentInfo> it2 = list.iterator();
            while (true) {
                boolean z2 = false;
                String str = null;
                if (!it2.hasNext()) {
                    break;
                }
                InstrumentInfo next = it2.next();
                next.setSelectedEMIPlan(aVar);
                if (aVar != null) {
                    str = aVar.f56918a;
                }
                next.setSelectedEMIPlanId(str);
                if (aVar != null) {
                    z2 = true;
                }
                next.setEmiClicked(z2);
            }
            List<InstrumentInfo> list2 = this.x;
            if (list2 != null) {
                for (InstrumentInfo next2 : list2) {
                    next2.setSelectedEMIPlan(aVar);
                    next2.setSelectedEMIPlanId(aVar == null ? null : aVar.f56918a);
                    next2.setEmiClicked(aVar != null);
                }
            }
        }
    }

    private String f(String str) {
        List<InstrumentInfo> list = this.y;
        if (list == null) {
            return null;
        }
        for (InstrumentInfo next : list) {
            if (next.getPaymentDetails().equalsIgnoreCase(str)) {
                return next.getSelectedEMIPlanId();
            }
        }
        List<InstrumentInfo> list2 = this.x;
        if (list2 == null) {
            return null;
        }
        for (InstrumentInfo next2 : list2) {
            if (next2.getPaymentDetails().equalsIgnoreCase(str)) {
                return next2.getSelectedEMIPlanId();
            }
        }
        return null;
    }

    private static List<InstrumentInfo> b(List<InstrumentInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            try {
                for (InstrumentInfo clone : list) {
                    arrayList.add((InstrumentInfo) clone.clone());
                }
            } catch (Exception unused) {
            }
        }
        return arrayList;
    }

    private View u() {
        if (b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
            List<View> list = this.o;
            if (list == null) {
                return null;
            }
            for (View next : list) {
                if (next.getTag().equals(b.f().n.getPaymentDetails())) {
                    this.C = next;
                    return next;
                }
            }
            return null;
        }
        List<View> list2 = this.n;
        if (list2 == null) {
            return null;
        }
        for (View next2 : list2) {
            if (next2.getTag().equals(b.f().n.getPaymentDetails())) {
                this.C = next2;
                return next2;
            }
        }
        return null;
    }

    private InstrumentInfo a(net.one97.paytm.p2mNewDesign.models.a aVar, boolean z2) {
        if (b.f().n.getPayMode().equalsIgnoreCase(SDKConstants.CREDIT)) {
            List<InstrumentInfo> list = this.y;
            if (list == null) {
                return null;
            }
            for (InstrumentInfo next : list) {
                if (next.getPaymentDetails() != null && next.getPaymentDetails().equalsIgnoreCase(this.s.getPaymentDetails())) {
                    next.setSelectedEMIPlan(aVar);
                    next.setEmiClicked(z2);
                    return next;
                }
            }
            return null;
        }
        List<InstrumentInfo> list2 = this.x;
        if (list2 == null) {
            return null;
        }
        for (InstrumentInfo next2 : list2) {
            if (next2.getPaymentDetails() != null && next2.getPaymentDetails().equalsIgnoreCase(this.s.getPaymentDetails())) {
                next2.setSelectedEMIPlan(aVar);
                next2.setEmiClicked(z2);
                return next2;
            }
        }
        return null;
    }

    private void g(String str) {
        if (str == null) {
            str = "";
        }
        HashMap<String, CardDetailsV2> hashMap = this.F;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, CardDetailsV2> value : this.F.entrySet()) {
                CardDetailsV2 cardDetailsV2 = (CardDetailsV2) value.getValue();
                View view = cardDetailsV2.getView();
                InstrumentInfo instrumentInfo = cardDetailsV2.getInstrumentInfo();
                if (!str.equalsIgnoreCase(instrumentInfo.getPaymentDetails())) {
                    instrumentInfo.setEmiClicked(false);
                    instrumentInfo.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
                    instrumentInfo.setSelectedEMIPlanId((String) null);
                    if (instrumentInfo.isEMIavailable()) {
                        view.findViewById(R.id.tv_instrument_secondary_info_2).setVisibility(0);
                    }
                }
            }
        }
        HashMap<String, CardDetailsV2> hashMap2 = this.G;
        if (hashMap2 != null && hashMap2.size() > 0) {
            for (Map.Entry<String, CardDetailsV2> value2 : this.G.entrySet()) {
                CardDetailsV2 cardDetailsV22 = (CardDetailsV2) value2.getValue();
                View view2 = cardDetailsV22.getView();
                InstrumentInfo instrumentInfo2 = cardDetailsV22.getInstrumentInfo();
                if (!str.equalsIgnoreCase(instrumentInfo2.getPaymentDetails())) {
                    instrumentInfo2.setEmiClicked(false);
                    instrumentInfo2.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
                    instrumentInfo2.setSelectedEMIPlanId((String) null);
                    if (instrumentInfo2.isEMIavailable()) {
                        view2.findViewById(R.id.tv_instrument_secondary_info_2).setVisibility(0);
                    }
                }
            }
        }
    }

    private void c(View view) {
        String str = (String) view.getTag();
        LinearLayout linearLayout = this.f13261g;
        boolean z2 = false;
        boolean booleanValue = (linearLayout == null || linearLayout.getTag() == null) ? false : ((Boolean) this.f13261g.getTag()).booleanValue();
        g(str);
        List<View> list = this.n;
        if (list != null && list.size() > 0) {
            Iterator<View> it2 = this.n.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                View next = it2.next();
                String str2 = (String) next.getTag();
                if (!TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(str)) {
                    if (b.f().f13092h) {
                        a("offline_payments", "post_scan_saveddc_selected", "flow_through_scan_icon", this.f13262h, A);
                    } else {
                        a("offline_payments", "post_scan_saveddc_selected", "flow_through_pay_icon", this.f13262h, A);
                    }
                    this.f13258d = next;
                }
            }
        }
        List<View> list2 = this.o;
        if (list2 != null && list2.size() > 0) {
            Iterator<View> it3 = this.o.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                View next2 = it3.next();
                String str3 = (String) next2.getTag();
                if (!TextUtils.isEmpty(str3) && str3.equalsIgnoreCase(str)) {
                    if (b.f().f13092h) {
                        a("offline_payments", "post_pay_savedcc_selected", "flow_through_scan_icon", this.f13262h, A);
                    } else {
                        a("offline_payments", "post_pay_savedcc_selected", "flow_through_pay_icon", this.f13262h, A);
                    }
                    this.f13258d = next2;
                }
            }
        }
        if (this.k.equalsIgnoreCase(SDKConstants.DEBIT)) {
            this.s = b.f().f(str);
        } else {
            this.s = b.f().g(str);
        }
        RadioButton radioButton = this.p;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_inactive));
        }
        RelativeLayout relativeLayout = this.f13256a;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        if (this.L != null) {
            b.f().F = false;
            this.L.clearAnimation();
            this.L.setVisibility(8);
        }
        RelativeLayout relativeLayout2 = this.D;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        TextView textView = this.z;
        if (textView != null) {
            textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        RelativeLayout relativeLayout3 = this.q;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        this.f13256a = (RelativeLayout) view.findViewById(R.id.rl_cvv_layout);
        this.f13256a.setVisibility(0);
        this.H = (LinearLayout) view.findViewById(R.id.cvv_container);
        this.D = (RelativeLayout) view.findViewById(R.id.lyt_emi_plan);
        this.s = e(str);
        InstrumentInfo instrumentInfo = this.s;
        this.B = instrumentInfo == null ? false : instrumentInfo.isEmiClicked();
        this.D.setVisibility(this.B ? 0 : 8);
        if (this.E) {
            this.D.setVisibility(8);
        }
        this.f13257b = (EditText) this.f13256a.findViewById(R.id.et_cvv);
        t();
        this.f13257b.getText().clear();
        this.r = this.s.getCardType();
        r();
        this.f13263i = (TextView) this.f13256a.findViewById(R.id.tv_cvv_help);
        this.f13263i.setVisibility(8);
        q();
        this.z = (TextView) view.findViewById(R.id.tv_instrument_primary_info);
        boolean z3 = true;
        this.z.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
        this.q = (RelativeLayout) this.f13256a.findViewById(R.id.rl_proceed_to_pay);
        this.q.setVisibility(8);
        this.q.setTag("saved");
        this.q.setOnClickListener(this);
        this.p = (RadioButton) view.findViewById(R.id.rb_instrumentInfo);
        this.p.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_active));
        this.w.d(a());
        View view2 = this.f13258d;
        if (view2 != null) {
            view2.performClick();
        }
        try {
            InstrumentInfo instrumentInfo2 = (InstrumentInfo) this.s.clone();
            if (booleanValue) {
                z2 = true;
            }
            instrumentInfo2.setEmiClicked(z2);
            this.w.a(instrumentInfo2, "uncheck");
            this.w.a(instrumentInfo2, "sectionClose");
            this.w.a(instrumentInfo2, "updateSelection");
            if (!booleanValue) {
                z3 = this.B;
            }
            instrumentInfo2.setEmiClicked(z3);
        } catch (Exception unused) {
            this.w.a(this.s, "uncheck");
            this.w.a(this.s, "sectionClose");
            this.w.a(this.s, "updateSelection");
        }
        this.f13257b.requestFocus();
        d();
    }

    private boolean h(String str) {
        String str2;
        String str3;
        String u2 = b.f().u(this.k);
        if (!TextUtils.isEmpty(u2) && !"0".equalsIgnoreCase(u2) && Double.parseDouble(u2) < Double.valueOf(str).doubleValue()) {
            b.f();
            if (b.q(this.k)) {
                if (this.f13260f) {
                    HashMap<String, CardDetailsV2> hashMap = this.F;
                    if (hashMap != null && hashMap.size() > 0) {
                        Iterator<Map.Entry<String, CardDetailsV2>> it2 = this.F.entrySet().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            CardDetailsV2 cardDetailsV2 = (CardDetailsV2) it2.next().getValue();
                            View view = cardDetailsV2.getView();
                            if (this.Q.equalsIgnoreCase(cardDetailsV2.getInstrumentInfo().getPaymentDetails())) {
                                c(false);
                                view.setAlpha(0.4f);
                                break;
                            }
                        }
                    }
                } else {
                    HashMap<String, CardDetailsV2> hashMap2 = this.G;
                    if (hashMap2 != null && hashMap2.size() > 0) {
                        Iterator<Map.Entry<String, CardDetailsV2>> it3 = this.G.entrySet().iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            CardDetailsV2 cardDetailsV22 = (CardDetailsV2) it3.next().getValue();
                            View view2 = cardDetailsV22.getView();
                            if (this.Q.equalsIgnoreCase(cardDetailsV22.getInstrumentInfo().getPaymentDetails())) {
                                c(false);
                                view2.setAlpha(0.4f);
                                break;
                            }
                        }
                    }
                }
                return true;
            }
        }
        if (TextUtils.isEmpty(b.f().A)) {
            str2 = "0";
        } else {
            str2 = b.f().A;
        }
        if (Double.parseDouble(str2) < Double.valueOf(str).doubleValue()) {
            b.f();
            if (!b.q(this.k)) {
                if (b.f().n != null && this.k.equalsIgnoreCase(b.f().n.getPayMode())) {
                    g gVar = this.w;
                    if ("0".equalsIgnoreCase(b.f().A)) {
                        str3 = this.f13262h.getResources().getString(R.string.limit_breach_msg);
                    } else {
                        str3 = String.format(this.f13262h.getResources().getString(R.string.limit_breach_msg_with_amount_new), new Object[]{b.f().A});
                    }
                    gVar.a(str3, false, false);
                }
                List<View> list = this.o;
                if (list != null && list.size() > 0) {
                    for (View next : this.o) {
                        next.findViewById(R.id.et_cvv).setEnabled(false);
                        next.setAlpha(0.4f);
                    }
                }
                List<View> list2 = this.n;
                if (list2 != null && list2.size() > 0) {
                    for (View next2 : this.n) {
                        next2.findViewById(R.id.et_cvv).setEnabled(false);
                        next2.setAlpha(0.4f);
                    }
                }
                return true;
            }
        } else {
            List<View> list3 = this.o;
            if (list3 != null && list3.size() > 0) {
                for (View next3 : this.o) {
                    next3.findViewById(R.id.et_cvv).setEnabled(true);
                    c(true);
                    next3.setAlpha(1.0f);
                }
            }
            List<View> list4 = this.n;
            if (list4 != null && list4.size() > 0) {
                for (View next4 : this.n) {
                    next4.findViewById(R.id.et_cvv).setEnabled(true);
                    c(true);
                    next4.setAlpha(1.0f);
                }
            }
        }
        return false;
    }

    public final void h() {
        b.f().F = false;
        CheckBox checkBox = this.v;
        if (checkBox != null) {
            checkBox.setChecked(false);
        }
        LinearLayout linearLayout = this.L;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.L.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.M;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    public final void a(double d2) {
        this.s = b.f().n;
        InstrumentInfo instrumentInfo = this.s;
        if (instrumentInfo != null && this.N && instrumentInfo.isOneClickSupported() && this.s.isScpEnrolled()) {
            if (d2 > Double.valueOf(b.f().D()).doubleValue()) {
                b.f().F = false;
                this.M.setVisibility(8);
                this.f13256a.setVisibility(0);
                return;
            }
            b.f().F = true;
            this.M.setVisibility(0);
            this.f13256a.setVisibility(8);
        }
    }

    public final void b(double d2) {
        String paymentDetails = (b.f().n == null || b.f().n.getPaymentDetails() == null) ? "" : b.f().n.getPaymentDetails();
        HashMap<String, CardDetailsV2> hashMap = this.F;
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry<String, CardDetailsV2> a2 : this.F.entrySet()) {
                a(d2, a2, paymentDetails);
            }
        }
        HashMap<String, CardDetailsV2> hashMap2 = this.G;
        if (hashMap2 != null && hashMap2.size() > 0) {
            for (Map.Entry<String, CardDetailsV2> a3 : this.G.entrySet()) {
                a(d2, a3, paymentDetails);
            }
        }
    }

    private static void a(double d2, Map.Entry<String, CardDetailsV2> entry, String str) {
        CardDetailsV2 value = entry.getValue();
        View view = value.getView();
        InstrumentInfo instrumentInfo = value.getInstrumentInfo();
        boolean isScpEnrolled = instrumentInfo.isScpEnrolled();
        if (instrumentInfo.isOneClickSupported() && isScpEnrolled && !instrumentInfo.getPaymentDetails().equalsIgnoreCase(str)) {
            if (d2 > Double.valueOf(b.f().D()).doubleValue()) {
                view.findViewById(R.id.lyt_scp_enabled).setVisibility(8);
            } else {
                view.findViewById(R.id.lyt_scp_enabled).setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        this.w.p();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        this.w.o();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        CheckBox checkBox = this.v;
        checkBox.setChecked(!checkBox.isChecked());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (compoundButton.isChecked()) {
            p();
            b.f().F = true;
            return;
        }
        b.f().F = false;
    }

    /* access modifiers changed from: private */
    public void d(boolean z2) {
        if (z2) {
            b.f().F = true;
            this.M.setVisibility(0);
            this.L.clearAnimation();
            this.L.setVisibility(8);
            this.f13256a.setVisibility(8);
            return;
        }
        b.f().F = false;
        this.M.setVisibility(8);
        this.f13256a.setVisibility(0);
        this.L.setVisibility(0);
        this.L.startAnimation(AnimationUtils.loadAnimation(this.f13262h, R.anim.wallet_vscp_shake));
    }

    public final void a(Context context, InstrumentInfo instrumentInfo, InstrumentInfo instrumentInfo2, String str, boolean z2) {
        int i2;
        Context context2;
        List<InstrumentInfo> list;
        LinearLayout linearLayout;
        final Context context3 = context;
        final InstrumentInfo instrumentInfo3 = instrumentInfo;
        this.P = false;
        this.Q = instrumentInfo.getPaymentDetails();
        if (!instrumentInfo.isEMICard()) {
            this.f13262h = context3;
            this.s = instrumentInfo3;
            this.k = instrumentInfo.getPayMode();
            this.f13260f = this.k.equalsIgnoreCase(SDKConstants.DEBIT);
            if (this.F == null) {
                this.F = new HashMap<>();
            }
            if (this.G == null) {
                this.G = new HashMap<>();
            }
            this.k = instrumentInfo.getPayMode();
            if (this.k.equalsIgnoreCase(SDKConstants.DEBIT)) {
                this.x = b(b.f().h(SDKConstants.DEBIT));
                List<InstrumentInfo> list2 = this.x;
                if (list2 != null && list2.size() > 0) {
                    this.n = new ArrayList();
                }
            } else {
                this.y = b(b.f().h(SDKConstants.CREDIT));
                List<InstrumentInfo> list3 = this.y;
                if (list3 != null && list3.size() > 0) {
                    this.o = new ArrayList();
                }
            }
            final LinearLayout linearLayout2 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card_expand_v2, (ViewGroup) null);
            this.O = linearLayout2;
            RelativeLayout relativeLayout = (RelativeLayout) linearLayout2.findViewById(R.id.rl_cvv_layout);
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_proceed_to_pay);
            relativeLayout2.setTag("saved");
            RadioButton radioButton = (RadioButton) linearLayout2.findViewById(R.id.rb_instrumentInfo);
            TextView textView = (TextView) linearLayout2.findViewById(R.id.tv_instrument_primary_info);
            EditText editText = (EditText) relativeLayout.findViewById(R.id.et_cvv);
            ((TextView) linearLayout2.findViewById(R.id.tv_cvv_help)).setVisibility(8);
            LinearLayout linearLayout3 = (LinearLayout) linearLayout2.findViewById(R.id.cvv_container);
            final RelativeLayout relativeLayout3 = (RelativeLayout) linearLayout2.findViewById(R.id.lyt_emi_plan);
            ImageView imageView = (ImageView) linearLayout2.findViewById(R.id.iv_cancel);
            linearLayout2.findViewById(R.id.tv_emi_plan_detail);
            linearLayout2.findViewById(R.id.tv_total_emi_value);
            TextView textView2 = (TextView) linearLayout2.findViewById(R.id.tv_change_plan);
            TextView textView3 = (TextView) linearLayout2.findViewById(R.id.tv_instrument_secondary_info);
            final TextView textView4 = (TextView) linearLayout2.findViewById(R.id.tv_instrument_secondary_info_2);
            textView4.setText("EMI Available");
            ImageView imageView2 = (ImageView) linearLayout2.findViewById(R.id.iv_card_type);
            textView4.setTextColor(androidx.core.content.b.c(this.f13262h, R.color.color_00b9f5));
            this.f13256a = relativeLayout;
            this.M = (RelativeLayout) linearLayout2.findViewById(R.id.lyt_scp_enabled);
            this.M.findViewById(R.id.scp_enabled_info_cta).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.f(view);
                }
            });
            TextView textView5 = (TextView) this.M.findViewById(R.id.scp_enabled_tv);
            RelativeLayout relativeLayout4 = relativeLayout2;
            if (!TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13262h, SDKConstants.KEY_SCP_ENABLED_TEXT))) {
                textView5.setText(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13262h, SDKConstants.KEY_SCP_ENABLED_TEXT));
            }
            this.L = (LinearLayout) linearLayout2.findViewById(R.id.ll_visa_one_click);
            this.L.findViewById(R.id.visa_one_click_info_cta).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.e(view);
                }
            });
            this.v = (CheckBox) this.L.findViewById(R.id.cb_visa_one_click);
            this.L.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.d(view);
                }
            });
            ((TextView) linearLayout2.findViewById(R.id.tv_enable_visa_one_click)).setText(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(this.f13262h, SDKConstants.KEY_ENABLE_SCP_TEXT));
            this.v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    a.this.a(compoundButton, z);
                }
            });
            if (!instrumentInfo.isOneClickSupported() || !b.f().G || !o() || b.f().J != null) {
                linearLayout = linearLayout3;
            } else if (!z2) {
                net.one97.paytm.wallet.i.b bVar = net.one97.paytm.wallet.i.b.f70414a;
                linearLayout = linearLayout3;
                net.one97.paytm.wallet.i.b.a(this.f13262h, instrumentInfo.getCardFirstSixDigit(), instrumentInfo.getCardLastFourDigit(), "", new a.b() {
                    public final void a(boolean z, boolean z2, String str) {
                        if (!b.f().P) {
                            instrumentInfo3.setIsScpEnrolled(z);
                            instrumentInfo3.setEnrollmentPossible(z2);
                            a.a(a.this, instrumentInfo3, z, z2);
                            if (!z2) {
                                a.this.h();
                                if (b.f().n != null && !TextUtils.isEmpty(b.f().n.getPaymentDetails()) && b.f().n.getPaymentDetails().equalsIgnoreCase(instrumentInfo3.getPaymentDetails())) {
                                    a.this.f13256a.setVisibility(0);
                                }
                            } else if (z) {
                                a.this.d(true);
                            } else {
                                b.f().F = false;
                                linearLayout2.findViewById(R.id.lyt_scp_enabled).setVisibility(8);
                            }
                        }
                    }

                    public final void a(String str, String str2) {
                        a(false, false, (String) null);
                    }
                });
            } else {
                linearLayout = linearLayout3;
                if (!instrumentInfo.isEnrollmentPossible()) {
                    h();
                    if (b.f().n != null && !TextUtils.isEmpty(b.f().n.getPaymentDetails()) && b.f().n.getPaymentDetails().equalsIgnoreCase(instrumentInfo.getPaymentDetails())) {
                        this.f13256a.setVisibility(0);
                    }
                } else if (instrumentInfo.isScpEnrolled()) {
                    d(true);
                } else {
                    b.f().F = false;
                    linearLayout2.findViewById(R.id.lyt_scp_enabled).setVisibility(8);
                }
            }
            if (!instrumentInfo.isEMIavailable() || !this.w.i()) {
                textView4.setVisibility(8);
            } else if (TextUtils.isEmpty(this.w.e()) || instrumentInfo.getmMinAmount() == null || instrumentInfo.getmMaxAmount() == null || (instrumentInfo.getmMinAmount().getValue().doubleValue() <= Double.parseDouble(this.w.e()) && Double.parseDouble(this.w.e()) <= instrumentInfo.getmMaxAmount().getValue().doubleValue())) {
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
            textView4.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.a(view);
                    if (((double) System.currentTimeMillis()) - a.this.I >= 3000.0d) {
                        double unused = a.this.I = (double) System.currentTimeMillis();
                        String str = "Debit Card";
                        if (TextUtils.isEmpty(a.this.w.d()) || a.this.w.d().equalsIgnoreCase("0")) {
                            g g2 = a.this.w;
                            String string = context3.getString(R.string.emi_saved_cards_no_amount);
                            Object[] objArr = new Object[2];
                            StringBuilder sb = new StringBuilder();
                            sb.append(instrumentInfo3.getDisplaySecondaryInfo());
                            sb.append(" ");
                            if (!SDKConstants.DEBIT.equalsIgnoreCase(a.this.k)) {
                                str = "Credit Card";
                            }
                            sb.append(str);
                            objArr[0] = sb.toString();
                            objArr[1] = net.one97.paytm.wallet.utility.a.a(instrumentInfo3.getmMinAmount().getValue().doubleValue());
                            g2.a(String.format(string, objArr), true, true);
                        } else if (Double.parseDouble(a.this.w.d()) < instrumentInfo3.getmMinAmount().getValue().doubleValue() || Double.parseDouble(a.this.w.d()) > instrumentInfo3.getmMaxAmount().getValue().doubleValue()) {
                            g g3 = a.this.w;
                            String string2 = context3.getString(R.string.emi_not_applicable_on_this_saved_card);
                            Object[] objArr2 = new Object[2];
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(instrumentInfo3.getDisplaySecondaryInfo());
                            sb2.append(" ");
                            if (!SDKConstants.DEBIT.equalsIgnoreCase(a.this.k)) {
                                str = "Credit Card";
                            }
                            sb2.append(str);
                            objArr2[0] = sb2.toString();
                            objArr2[1] = net.one97.paytm.wallet.utility.a.a(instrumentInfo3.getmMinAmount().getValue().doubleValue());
                            g3.a(String.format(string2, objArr2), true, true);
                        } else {
                            instrumentInfo3.setFromSavedCard(true);
                            instrumentInfo3.setUniqueId(a.this.a());
                            b.f().a(instrumentInfo3);
                            a aVar = a.this;
                            aVar.a((View) aVar.f13261g);
                            a.this.w.a(instrumentInfo3, "openEMIPlanBottomSheet");
                        }
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.a(view);
                    instrumentInfo3.setFromSavedCard(true);
                    instrumentInfo3.setUniqueId(a.this.a());
                    b.f().a(instrumentInfo3);
                    a.this.w.a(instrumentInfo3, "openEMIPlanBottomSheet");
                    a.this.w.a(instrumentInfo3, "uncheck");
                }
            });
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    relativeLayout3.setVisibility(8);
                    instrumentInfo3.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
                    instrumentInfo3.setUniqueId(a.this.a());
                    b.f().a(instrumentInfo3);
                    if (instrumentInfo3.isEMIavailable()) {
                        textView4.setVisibility(0);
                    }
                    a.this.b((net.one97.paytm.p2mNewDesign.models.a) null);
                }
            });
            if (b.f().n != null && !TextUtils.isEmpty(b.f().n.getPaymentDetails()) && b.f().n.getPaymentDetails().equalsIgnoreCase(instrumentInfo.getPaymentDetails())) {
                textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                this.z = textView;
                this.f13257b = editText;
                t();
                radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_active));
                this.p = radioButton;
                this.r = b.f().n.getCardType();
                r();
                q();
                this.D = relativeLayout3;
                this.H = linearLayout;
                b.f();
                if (!this.s.isOneClickSupported() || !b.f().G || !this.s.isEnrollmentPossible() || b.f().J != null) {
                    this.f13256a.setVisibility(0);
                    h();
                } else {
                    if (!this.s.isScpEnrolled()) {
                        d(false);
                    } else if (o()) {
                        d(true);
                    } else {
                        this.f13256a.setVisibility(0);
                        h();
                    }
                    p();
                }
                this.q = relativeLayout4;
                this.q.setOnClickListener(this);
            }
            Drawable g2 = net.one97.paytm.wallet.utility.a.g(this.f13262h, instrumentInfo.getCardType());
            if (g2 != null) {
                imageView2.setImageDrawable(g2);
            } else {
                b.f();
                b.a(this.f13262h, imageView2, instrumentInfo.getIconUrl(), instrumentInfo.getPayMode());
            }
            linearLayout2.setTag(instrumentInfo.getPaymentDetails());
            linearLayout2.setOnClickListener(this);
            if (this.f13260f) {
                this.F.put(instrumentInfo.getPaymentDetails(), new CardDetailsV2(instrumentInfo3, linearLayout2));
                this.n.add(linearLayout2);
            } else {
                this.G.put(instrumentInfo.getPaymentDetails(), new CardDetailsV2(instrumentInfo3, linearLayout2));
                this.o.add(linearLayout2);
            }
            textView.setText(instrumentInfo.getDisplayPrimaryInfo());
            textView3.setText(instrumentInfo.getDisplaySecondaryInfo());
            b.f();
            if (!b.q(this.k)) {
                linearLayout2.setAlpha(0.4f);
                return;
            }
            return;
        }
        String str2 = this.k;
        this.f13262h = context3;
        this.f13261g = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card, (ViewGroup) null);
        this.k = str2;
        this.E = true;
        this.f13261g.setTag(Boolean.TRUE);
        this.m = (RelativeLayout) this.f13261g.findViewById(R.id.rl_pay_mode_pg);
        this.m.setOnClickListener(this);
        this.t = (LinearLayout) this.f13261g.findViewById(R.id.ll_card_expand);
        this.j = (RadioButton) this.f13261g.findViewById(R.id.rb_instrumentInfo);
        this.j.setOnClickListener(this);
        this.l = (TextView) this.f13261g.findViewById(R.id.tv_pay_mode);
        TextView textView6 = this.l;
        b.f();
        if (b.c(str2).equalsIgnoreCase(this.f13262h.getString(R.string.debit_cards))) {
            context2 = this.f13262h;
            i2 = R.string.debit_card_pay_mode;
        } else {
            context2 = this.f13262h;
            i2 = R.string.credit_card;
        }
        textView6.setText(context2.getString(i2));
        this.s = b.f().n;
        this.B = true;
        InstrumentInfo instrumentInfo4 = b.f().n;
        this.f13262h = context3;
        boolean equalsIgnoreCase = this.k.equalsIgnoreCase(SDKConstants.DEBIT);
        this.f13259e = this.f13259e;
        if (this.k.equalsIgnoreCase(SDKConstants.DEBIT)) {
            this.x = b(b.f().h(SDKConstants.DEBIT));
            list = this.x;
            if (list != null && list.size() > 0) {
                this.n = new ArrayList();
            }
        } else {
            this.y = b(b.f().h(SDKConstants.CREDIT));
            list = this.y;
            if (list != null && list.size() > 0) {
                this.o = new ArrayList();
            }
        }
        if (list != null && list.size() > 0 && instrumentInfo.getChannelCode() != null && instrumentInfo4.getBankCode() != null && instrumentInfo.getChannelCode().equalsIgnoreCase(instrumentInfo4.getBankCode())) {
            b.f();
            if (b.a(instrumentInfo3, this.w.d())) {
                instrumentInfo3.setEmiTypeCard(true);
                instrumentInfo3.setEmiClicked(true);
                instrumentInfo3.setCardFromEMITab(true);
                net.one97.paytm.p2mNewDesign.models.a selectedEMIPlan = instrumentInfo.getSelectedEMIPlan();
                if (selectedEMIPlan != null) {
                    instrumentInfo3.setSelectedEMIPlanId(selectedEMIPlan.f56918a);
                    instrumentInfo3.setSelectedEMIPlan(selectedEMIPlan);
                }
                this.B = true;
                LinearLayout linearLayout4 = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.lyt_debit_card_expand_v2, (ViewGroup) null);
                RelativeLayout relativeLayout5 = (RelativeLayout) linearLayout4.findViewById(R.id.rl_cvv_layout);
                RelativeLayout relativeLayout6 = (RelativeLayout) relativeLayout5.findViewById(R.id.rl_proceed_to_pay);
                relativeLayout6.setTag("saved");
                RadioButton radioButton2 = (RadioButton) linearLayout4.findViewById(R.id.rb_instrumentInfo);
                TextView textView7 = (TextView) linearLayout4.findViewById(R.id.tv_instrument_primary_info);
                TextView textView8 = (TextView) linearLayout4.findViewById(R.id.tv_instrument_secondary_info);
                EditText editText2 = (EditText) relativeLayout5.findViewById(R.id.et_cvv);
                ImageView imageView3 = (ImageView) linearLayout4.findViewById(R.id.iv_card_type);
                ((TextView) linearLayout4.findViewById(R.id.tv_cvv_help)).setVisibility(8);
                LinearLayout linearLayout5 = (LinearLayout) linearLayout4.findViewById(R.id.cvv_container);
                RelativeLayout relativeLayout7 = (RelativeLayout) linearLayout4.findViewById(R.id.lyt_emi_plan);
                relativeLayout7.setTag(Boolean.FALSE);
                linearLayout4.findViewById(R.id.iv_cancel);
                linearLayout4.findViewById(R.id.tv_emi_plan_detail);
                linearLayout4.findViewById(R.id.tv_total_emi_value);
                linearLayout4.findViewById(R.id.tv_change_plan);
                TextView textView9 = (TextView) linearLayout4.findViewById(R.id.tv_instrument_secondary_info_2);
                textView9.setText("EMI Available");
                textView9.setTextColor(androidx.core.content.b.c(this.f13262h, R.color.color_00b9f5));
                if (b.f().n != null && !TextUtils.isEmpty(b.f().n.getPaymentDetails()) && b.f().n.getPaymentDetails().equalsIgnoreCase(instrumentInfo.getPaymentDetails())) {
                    textView7.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
                    this.z = textView7;
                    this.f13257b = editText2;
                    t();
                    radioButton2.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_active));
                    this.p = radioButton2;
                    this.r = b.f().n.getCardType();
                    r();
                    q();
                    this.q = relativeLayout6;
                    this.q.setOnClickListener(this);
                    relativeLayout5.setVisibility(0);
                    this.f13256a = relativeLayout5;
                    this.D = relativeLayout7;
                    this.H = linearLayout5;
                }
                Drawable g3 = net.one97.paytm.wallet.utility.a.g(this.f13262h, instrumentInfo.getCardType());
                if (g3 != null) {
                    imageView3.setImageDrawable(g3);
                } else {
                    b.f();
                    b.a(this.f13262h, imageView3, instrumentInfo.getIconUrl(), instrumentInfo.getPayMode());
                }
                linearLayout4.setTag(instrumentInfo.getPaymentDetails());
                linearLayout4.setOnClickListener(this);
                if (equalsIgnoreCase) {
                    this.n.add(linearLayout4);
                } else {
                    this.o.add(linearLayout4);
                }
                textView7.setText(instrumentInfo.getDisplayPrimaryInfo());
                textView8.setText(instrumentInfo.getDisplaySecondaryInfo());
                b.f();
                if (!b.q(this.k)) {
                    linearLayout4.setAlpha(0.4f);
                }
            }
        }
    }

    public final String a() {
        return this.s.getPayMode() + this.s.getCardLastFourDigit();
    }

    public final void a(boolean z2) {
        if (z2) {
            this.P = true;
            this.O.performClick();
            return;
        }
        RadioButton radioButton = this.p;
        if (radioButton != null) {
            radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_inactive));
        }
        RelativeLayout relativeLayout = this.q;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
        EditText editText = this.f13257b;
        if (editText != null) {
            editText.setVisibility(8);
        }
        TextView textView = this.z;
        if (textView != null) {
            textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        TextView textView2 = this.l;
        if (textView2 != null) {
            textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        }
        RelativeLayout relativeLayout2 = this.f13256a;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(8);
        }
        LinearLayout linearLayout = this.L;
        if (linearLayout != null) {
            linearLayout.clearAnimation();
            this.L.setVisibility(8);
        }
        RelativeLayout relativeLayout3 = this.D;
        if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        View view = this.f13258d;
        if (view != null) {
            View findViewById = view.findViewById(R.id.lyt_emi_plan);
            View findViewById2 = this.f13258d.findViewById(R.id.tv_instrument_secondary_info_2);
            findViewById.setVisibility(8);
            this.s.setSelectedEMIPlan((net.one97.paytm.p2mNewDesign.models.a) null);
            if (this.s.isEMIavailable()) {
                findViewById2.setVisibility(0);
            }
            b((net.one97.paytm.p2mNewDesign.models.a) null);
        }
    }

    public final void a(String str) {
        if (this.f13260f) {
            if (!h(str)) {
                d(str);
            }
        } else if (!h(str)) {
            d(str);
        }
    }

    public final View c() {
        return (this.f13260f ? this.n : this.o).get(0);
    }

    public final void b() {
        s();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r4.Q) != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (r4.Q.equalsIgnoreCase(r1.f51233c) == false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[EDGE_INSN: B:17:0x003b->B:14:0x003b ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.util.List<net.one97.paytm.p2mNewDesign.db.b.a> r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x003b
            java.util.Iterator r5 = r5.iterator()
        L_0x0007:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x003b
            java.lang.Object r1 = r5.next()
            net.one97.paytm.p2mNewDesign.db.b.a r1 = (net.one97.paytm.p2mNewDesign.db.b.a) r1
            java.lang.String r2 = r1.f51232b
            java.lang.String r3 = "SAVED_CC"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0027
            java.lang.String r2 = r1.f51232b
            java.lang.String r3 = "SAVED_DC"
            boolean r2 = r3.equalsIgnoreCase(r2)
            if (r2 == 0) goto L_0x0007
        L_0x0027:
            java.lang.String r5 = r4.Q
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x003b
            java.lang.String r5 = r4.Q
            java.lang.String r1 = r1.f51233c
            boolean r5 = r5.equalsIgnoreCase(r1)
            if (r5 == 0) goto L_0x003b
            r5 = 1
            return r5
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.p2mNewDesign.e.a.a.a(java.util.List):boolean");
    }

    public final String e() {
        return this.s.getPriority();
    }

    public final boolean f() {
        if (this.s.getmIsDisabled() == null) {
            return false;
        }
        return this.s.getmIsDisabled().getStatus().booleanValue();
    }

    public final void j() {
        String str;
        b bVar;
        if (this.f13260f) {
            bVar = b.f();
            str = SDKConstants.DEBIT;
        } else {
            bVar = b.f();
            str = SDKConstants.CREDIT;
        }
        List<InstrumentInfo> h2 = bVar.h(str);
        InstrumentInfo instrumentInfo = null;
        if (h2 != null && h2.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 >= h2.size()) {
                    break;
                } else if (this.s.getPaymentDetails().contains(h2.get(i2).getPaymentDetails())) {
                    instrumentInfo = h2.get(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        InstrumentInfo instrumentInfo2 = instrumentInfo;
        if (instrumentInfo2 != null) {
            a(this.f13262h, instrumentInfo2, (InstrumentInfo) null, this.w.d(), true);
        }
    }

    public final void k() {
        this.O.setAlpha(0.4f);
    }

    public final void l() {
        List<View> list = this.K;
        if (list != null && list.size() > 0) {
            for (View next : this.K) {
                next.findViewById(R.id.et_cvv).setEnabled(true);
                next.setAlpha(1.0f);
            }
        }
        List<View> list2 = this.J;
        if (list2 != null && list2.size() > 0) {
            for (View next2 : this.J) {
                next2.findViewById(R.id.et_cvv).setEnabled(true);
                next2.setAlpha(1.0f);
            }
        }
        this.O.setAlpha(1.0f);
    }

    public final void m() {
        List<View> list = this.K;
        if (list != null && list.size() > 0) {
            for (View next : this.K) {
                next.findViewById(R.id.et_cvv).setEnabled(false);
                next.setAlpha(0.4f);
            }
        }
        List<View> list2 = this.J;
        if (list2 != null && list2.size() > 0) {
            for (View next2 : this.J) {
                next2.findViewById(R.id.et_cvv).setEnabled(false);
                next2.setAlpha(0.4f);
            }
        }
        this.O.setAlpha(0.4f);
    }

    public final void n() {
        this.O.setAlpha(1.0f);
    }

    public final void i() {
        a(this.O);
    }

    private static double a(net.one97.paytm.p2mNewDesign.models.a aVar) {
        try {
            return aVar.f56921d.doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public final void b(boolean z2) {
        if (!z2) {
            RadioButton radioButton = this.p;
            if (radioButton != null) {
                radioButton.setButtonDrawable(androidx.core.content.b.a(this.f13262h, R.drawable.ic_radio_inactive));
            }
            RelativeLayout relativeLayout = this.q;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            EditText editText = this.f13257b;
            if (editText != null) {
                editText.setVisibility(8);
            }
            TextView textView = this.z;
            if (textView != null) {
                textView.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                textView2.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
            }
            RelativeLayout relativeLayout2 = this.f13256a;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            LinearLayout linearLayout = this.L;
            if (linearLayout != null) {
                linearLayout.clearAnimation();
                this.L.setVisibility(8);
            }
            RelativeLayout relativeLayout3 = this.D;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(8);
            }
            g("");
        }
    }

    static /* synthetic */ void a(a aVar, InstrumentInfo instrumentInfo, boolean z2, boolean z3) {
        b f2 = b.f();
        int i2 = 0;
        if (SDKConstants.DEBIT.equalsIgnoreCase(instrumentInfo.getPayMode())) {
            for (int i3 = 0; i3 < f2.o.size(); i3++) {
                if (f2.o.get(i3).getPaymentDetails().equals(instrumentInfo.getPaymentDetails())) {
                    f2.o.get(i3).setIsScpEnrolled(z2);
                    f2.o.get(i3).setEnrollmentPossible(z3);
                }
            }
        } else {
            for (int i4 = 0; i4 < f2.p.size(); i4++) {
                if (f2.p.get(i4).getPaymentDetails().equals(instrumentInfo.getPaymentDetails())) {
                    f2.p.get(i4).setIsScpEnrolled(z2);
                    f2.p.get(i4).setEnrollmentPossible(z3);
                }
            }
        }
        if (SDKConstants.DEBIT.equalsIgnoreCase(instrumentInfo.getPayMode())) {
            while (i2 < aVar.x.size()) {
                if (aVar.x.get(i2).getPaymentDetails().equals(instrumentInfo.getPaymentDetails())) {
                    aVar.x.get(i2).setIsScpEnrolled(z2);
                    aVar.x.get(i2).setEnrollmentPossible(z3);
                }
                i2++;
            }
            return;
        }
        while (i2 < aVar.y.size()) {
            if (aVar.y.get(i2).getPaymentDetails().equals(instrumentInfo.getPaymentDetails())) {
                aVar.y.get(i2).setIsScpEnrolled(z2);
                aVar.y.get(i2).setEnrollmentPossible(z3);
            }
            i2++;
        }
    }
}
