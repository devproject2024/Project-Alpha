package net.one97.paytm.oauth.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.e.g;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.view.ProgressViewButton;

public final class ad extends v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f56300a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f56301b;

    /* renamed from: c  reason: collision with root package name */
    private List<SubscriptionInfo> f56302c;

    /* renamed from: d  reason: collision with root package name */
    private String f56303d;

    /* renamed from: e  reason: collision with root package name */
    private int f56304e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.paytm.oauth.e.b f56305f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f56306g;

    public final View a(int i2) {
        if (this.f56306g == null) {
            this.f56306g = new HashMap();
        }
        View view = (View) this.f56306g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f56306g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f56306g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public ad() {
        this.f56301b = "";
        this.f56302c = new ArrayList();
        this.f56303d = "";
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static ad a(Bundle bundle, net.one97.paytm.oauth.e.b bVar) {
            k.c(bVar, "listener");
            ad adVar = new ad(bVar);
            adVar.setArguments(bundle);
            return adVar;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ad(net.one97.paytm.oauth.e.b bVar) {
        this();
        k.c(bVar, "listener");
        this.f56305f = bVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_dual_sim_mismatch, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        String str;
        List<SubscriptionInfo> list;
        String str2;
        String str3;
        ArrayList parcelableArrayList;
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("login_mobile")) == null) {
            str = "";
        }
        this.f56301b = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (parcelableArrayList = arguments2.getParcelableArrayList("simInfoList")) == null) {
            list = new ArrayList<>();
        } else {
            list = parcelableArrayList;
        }
        this.f56302c = list;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str2 = arguments3.getString("iccid")) == null) {
            str2 = "";
        }
        this.f56303d = str2;
        this.f56304e = OAuthUtils.a(this.f56303d, this.f56302c);
        RoboTextView roboTextView = (RoboTextView) a(R.id.tv_header);
        String str4 = "1";
        if (roboTextView != null) {
            aa aaVar = aa.f47921a;
            String string = getString(R.string.lbl_dual_sim_mismatch_header);
            k.a((Object) string, "getString(R.string.lbl_dual_sim_mismatch_header)");
            Object[] objArr = new Object[2];
            objArr[0] = this.f56304e == 0 ? str4 : "2";
            objArr[1] = this.f56301b;
            String format = String.format(string, Arrays.copyOf(objArr, 2));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            roboTextView.setText(format);
        }
        SubscriptionInfo b2 = b(this.f56304e);
        SubscriptionInfo b3 = b(this.f56304e == 0 ? 1 : 0);
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) a(R.id.radioBtn1);
        if (appCompatRadioButton != null) {
            aa aaVar2 = aa.f47921a;
            String string2 = getString(R.string.lbl_try_with_sim);
            k.a((Object) string2, "getString(R.string.lbl_try_with_sim)");
            Object[] objArr2 = new Object[2];
            if (this.f56304e == 0) {
                str3 = "2";
            } else {
                str3 = str4;
            }
            objArr2[0] = str3;
            objArr2[1] = b3 != null ? b3.getCarrierName() : null;
            String format2 = String.format(string2, Arrays.copyOf(objArr2, 2));
            k.a((Object) format2, "java.lang.String.format(format, *args)");
            appCompatRadioButton.setText(format2);
        }
        AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) a(R.id.radioBtn2);
        if (appCompatRadioButton2 != null) {
            aa aaVar3 = aa.f47921a;
            String string3 = getString(R.string.lbl_retry_with_sim);
            k.a((Object) string3, "getString(R.string.lbl_retry_with_sim)");
            Object[] objArr3 = new Object[2];
            if (this.f56304e != 0) {
                str4 = "2";
            }
            objArr3[0] = str4;
            objArr3[1] = b2 != null ? b2.getCarrierName() : null;
            String format3 = String.format(string3, Arrays.copyOf(objArr3, 2));
            k.a((Object) format3, "java.lang.String.format(format, *args)");
            appCompatRadioButton2.setText(format3);
        }
        AppCompatRadioButton appCompatRadioButton3 = (AppCompatRadioButton) a(R.id.radioBtn1);
        if (appCompatRadioButton3 != null) {
            appCompatRadioButton3.setChecked(true);
        }
        b();
        AppCompatRadioButton appCompatRadioButton4 = (AppCompatRadioButton) a(R.id.radioBtn1);
        if (appCompatRadioButton4 != null) {
            appCompatRadioButton4.setOnClickListener(this);
        }
        AppCompatRadioButton appCompatRadioButton5 = (AppCompatRadioButton) a(R.id.radioBtn2);
        if (appCompatRadioButton5 != null) {
            appCompatRadioButton5.setOnClickListener(this);
        }
        ProgressViewButton progressViewButton = (ProgressViewButton) a(R.id.btnProceed);
        if (progressViewButton != null) {
            progressViewButton.setOnClickListener(this);
        }
        RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_not_access_to_sim);
        if (roboTextView2 != null) {
            roboTextView2.setOnClickListener(this);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imgCross);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(this);
        }
        v.a("/login-signup", "login_signup", "dual_sim_mismatch_popup_loaded", (ArrayList) null, 24);
    }

    public final void onClick(View view) {
        String str;
        String str2 = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.imgCross;
        if (valueOf != null && valueOf.intValue() == i2) {
            v.a("/login-signup", "login_signup", "dual_sim_mismatch_popup_closed", (ArrayList) null, 24);
            net.one97.paytm.oauth.e.b bVar = this.f56305f;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        int i3 = R.id.radioBtn1;
        if (valueOf != null && valueOf.intValue() == i3) {
            b();
            return;
        }
        int i4 = R.id.radioBtn2;
        if (valueOf != null && valueOf.intValue() == i4) {
            b();
            return;
        }
        int i5 = R.id.btnProceed;
        if (valueOf != null && valueOf.intValue() == i5) {
            SubscriptionInfo b2 = b(this.f56304e);
            SubscriptionInfo b3 = b(this.f56304e == 0 ? 1 : 0);
            String str3 = (b2 == null || b2.getSimSlotIndex() != 0) ? "sim 2" : "sim 1";
            Bundle bundle = new Bundle(getArguments());
            AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) a(R.id.radioBtn1);
            k.a((Object) appCompatRadioButton, "radioBtn1");
            String str4 = "";
            if (appCompatRadioButton.isChecked()) {
                str4 = (b3 == null || b3.getSimSlotIndex() != 0) ? "sim 2" : "sim 1";
                if (b3 != null) {
                    str2 = b3.getIccId();
                }
                bundle.putString("iccid", str2);
                str = "diff_sim";
            } else {
                AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) a(R.id.radioBtn2);
                k.a((Object) appCompatRadioButton2, "radioBtn2");
                if (appCompatRadioButton2.isChecked()) {
                    str4 = (b2 == null || b2.getSimSlotIndex() != 0) ? "sim 2" : "sim 1";
                    if (b2 != null) {
                        str2 = b2.getIccId();
                    }
                    bundle.putString("iccid", str2);
                    str = "same_sim";
                } else {
                    str = str4;
                }
            }
            v.a("/login-signup", "login_signup", "mismatch_retry_clicked", kotlin.a.k.d(str, str4, str3), 16);
            net.one97.paytm.oauth.e.b bVar2 = this.f56305f;
            if (bVar2 != null) {
                bVar2.a(bundle, new b(this));
                return;
            }
            return;
        }
        int i6 = R.id.tv_not_access_to_sim;
        if (valueOf != null && valueOf.intValue() == i6) {
            v.a("/login-signup", "login_signup", "dont_have_sim_clicked", (ArrayList) null, 24);
            Bundle bundle2 = new Bundle(getArguments());
            bundle2.putBoolean("is_from_select_sim_card", false);
            net.one97.paytm.oauth.e.b bVar3 = this.f56305f;
            if (bVar3 != null) {
                bVar3.h(bundle2);
            }
        }
    }

    public static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ad f56307a;

        b(ad adVar) {
            this.f56307a = adVar;
        }

        public final void a() {
            ProgressViewButton progressViewButton = (ProgressViewButton) this.f56307a.a(R.id.btnProceed);
            if (progressViewButton != null) {
                progressViewButton.d();
            }
        }
    }

    private final void b() {
        AppCompatRadioButton appCompatRadioButton = (AppCompatRadioButton) a(R.id.radioBtn1);
        k.a((Object) appCompatRadioButton, "radioBtn1");
        if (appCompatRadioButton.isChecked()) {
            ((AppCompatRadioButton) a(R.id.radioBtn1)).setTypeface((Typeface) null, 1);
            ((AppCompatRadioButton) a(R.id.radioBtn2)).setTypeface((Typeface) null, 0);
            return;
        }
        AppCompatRadioButton appCompatRadioButton2 = (AppCompatRadioButton) a(R.id.radioBtn2);
        k.a((Object) appCompatRadioButton2, "radioBtn2");
        if (appCompatRadioButton2.isChecked()) {
            ((AppCompatRadioButton) a(R.id.radioBtn1)).setTypeface((Typeface) null, 0);
            ((AppCompatRadioButton) a(R.id.radioBtn2)).setTypeface((Typeface) null, 1);
        }
    }

    private final SubscriptionInfo b(int i2) {
        for (SubscriptionInfo next : this.f56302c) {
            if (next.getSimSlotIndex() == i2) {
                return next;
            }
        }
        return null;
    }
}
