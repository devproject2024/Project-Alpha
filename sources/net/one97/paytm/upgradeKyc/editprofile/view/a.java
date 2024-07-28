package net.one97.paytm.upgradeKyc.editprofile.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.Address;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails;
import net.one97.paytm.i.h;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upgradeKyc.editprofile.b.a;
import net.one97.paytm.upgradeKyc.editprofile.d.a;

public final class a extends h implements View.OnClickListener, a.C1307a {

    /* renamed from: a  reason: collision with root package name */
    CersaiDetails f65906a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upgradeKyc.editprofile.e.a f65907b;

    /* renamed from: c  reason: collision with root package name */
    private int f65908c = 1234;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f65909d = Boolean.FALSE;

    /* renamed from: e  reason: collision with root package name */
    private LottieAnimationView f65910e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f65911f;

    public final View a(int i2) {
        if (this.f65911f == null) {
            this.f65911f = new HashMap();
        }
        View view = (View) this.f65911f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f65911f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f65906a = (CersaiDetails) arguments.getSerializable("aadhaarData");
            this.f65909d = Boolean.valueOf(arguments.getBoolean("standaloneCersai"));
        }
        a.C1307a aVar = this;
        a.C1308a aVar2 = net.one97.paytm.upgradeKyc.editprofile.d.a.f65816b;
        Context a2 = net.one97.paytm.common.b.d.b().a();
        k.a((Object) a2, "HomeHelper.getAppLaunchM…).getApplicationContext()");
        net.one97.paytm.upgradeKyc.editprofile.d.a a3 = a.C1308a.a(a2);
        if (a3 == null) {
            k.a();
        }
        this.f65907b = new net.one97.paytm.upgradeKyc.editprofile.e.a(aVar, a3);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_additional_details_kyc, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2 = view;
        k.c(view2, "view");
        super.onViewCreated(view, bundle);
        this.f65910e = (LottieAnimationView) view2.findViewById(R.id.wallet_loader);
        Boolean bool = this.f65909d;
        if (bool != null && k.a((Object) bool, (Object) Boolean.FALSE)) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f65906a = ((b) parentFragment).f65918b;
                ((RadioButton) a(R.id.married)).requestFocus();
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.editprofile.view.KycDetailsFragment");
            }
        }
        View.OnClickListener onClickListener = this;
        ((TextInputLayout) a(R.id.select_profession_til)).setOnClickListener(onClickListener);
        ((AppCompatEditText) a(R.id.profession_et)).setOnClickListener(onClickListener);
        ((TextInputLayout) a(R.id.select_profession_cat)).setOnClickListener(onClickListener);
        ((AppCompatEditText) a(R.id.sub_profession_et)).setOnClickListener(onClickListener);
        ((TextInputLayout) a(R.id.select_annual_inc)).setOnClickListener(onClickListener);
        ((AppCompatEditText) a(R.id.annual_income_et)).setOnClickListener(onClickListener);
        ((Button) a(R.id.fragment_cersai_details_save_btn)).setOnClickListener(onClickListener);
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.kyc_family_mother_first_name_et);
        k.a((Object) appCompatEditText, "kyc_family_mother_first_name_et");
        appCompatEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new InputFilter.AllCaps()});
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.kyc_family_mother_last_name_et);
        k.a((Object) appCompatEditText2, "kyc_family_mother_last_name_et");
        appCompatEditText2.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new InputFilter.AllCaps()});
        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.kyc_family_father_first_name_et);
        k.a((Object) appCompatEditText3, "kyc_family_father_first_name_et");
        appCompatEditText3.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new InputFilter.AllCaps()});
        AppCompatEditText appCompatEditText4 = (AppCompatEditText) a(R.id.kyc_family_father_last_name_et);
        k.a((Object) appCompatEditText4, "kyc_family_father_last_name_et");
        appCompatEditText4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15), new InputFilter.AllCaps()});
        Boolean bool2 = this.f65909d;
        if (bool2 != null && k.a((Object) bool2, (Object) Boolean.TRUE)) {
            Button button = (Button) a(R.id.fragment_cersai_details_save_btn);
            k.a((Object) button, "fragment_cersai_details_save_btn");
            button.setVisibility(0);
            if (this.f65906a == null) {
                this.f65906a = new CersaiDetails((String) null, (String) null, (String) null, (String) null, (Address) null, (ArrayList) null, 63, (g) null);
                ArrayList arrayList = new ArrayList();
                CersaiDetails cersaiDetails = this.f65906a;
                if (cersaiDetails != null) {
                    cersaiDetails.setRelationships(arrayList);
                }
            }
        }
        CersaiDetails cersaiDetails2 = this.f65906a;
        String maritalStatus = cersaiDetails2 != null ? cersaiDetails2.getMaritalStatus() : null;
        if (!TextUtils.isEmpty(maritalStatus)) {
            if (p.a(maritalStatus, "UNMARRIED", true)) {
                RadioButton radioButton = (RadioButton) a(R.id.unmarried);
                k.a((Object) radioButton, "unmarried");
                radioButton.setChecked(true);
            } else if (p.a(maritalStatus, "MARRIED", true)) {
                RadioButton radioButton2 = (RadioButton) a(R.id.married);
                k.a((Object) radioButton2, "married");
                radioButton2.setChecked(true);
            } else {
                RadioButton radioButton3 = (RadioButton) a(R.id.others_marital);
                k.a((Object) radioButton3, "others_marital");
                radioButton3.setChecked(true);
            }
        }
        f();
        ((RadioGroup) a(R.id.married_question_rg)).setOnCheckedChangeListener(new c(this));
        ((AppCompatEditText) a(R.id.kyc_family_mother_first_name_et)).addTextChangedListener(new d(this));
        ((AppCompatEditText) a(R.id.kyc_family_mother_last_name_et)).addTextChangedListener(new e(this));
        ((AppCompatEditText) a(R.id.kyc_family_father_first_name_et)).addTextChangedListener(new C1312a(this));
        ((AppCompatEditText) a(R.id.kyc_family_father_last_name_et)).addTextChangedListener(new b(this));
        e eVar = new e();
        q a2 = getChildFragmentManager().a();
        k.a((Object) a2, "childFragmentManager.beginTransaction()");
        Bundle bundle2 = new Bundle();
        bundle2.putString("updateDocBannerDocText", getString(R.string.update_cersai_text));
        eVar.setArguments(bundle2);
        a2.a(R.id.yellow_frag_container, (Fragment) eVar).b();
    }

    public final void onClick(View view) {
        CersaiDetails cersaiDetails;
        net.one97.paytm.upgradeKyc.editprofile.e.a aVar;
        if (k.a((Object) view, (Object) (TextInputLayout) a(R.id.select_profession_cat)) || k.a((Object) view, (Object) (AppCompatEditText) a(R.id.profession_et))) {
            a("profession");
        } else if (k.a((Object) view, (Object) (TextInputLayout) a(R.id.select_profession_til)) || k.a((Object) view, (Object) (AppCompatEditText) a(R.id.sub_profession_et))) {
            AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.profession_et);
            k.a((Object) appCompatEditText, "profession_et");
            CharSequence text = appCompatEditText.getText();
            if (!(text == null || text.length() == 0)) {
                String string = getString(R.string.kyc_select_profession_category);
                AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.profession_et);
                k.a((Object) appCompatEditText2, "profession_et");
                if (!string.equals(String.valueOf(appCompatEditText2.getText()))) {
                    AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.profession_et);
                    k.a((Object) appCompatEditText3, "profession_et");
                    a(String.valueOf(appCompatEditText3.getText()));
                    return;
                }
            }
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.select_profession_cat);
            k.a((Object) textInputLayout, "select_profession_cat");
            textInputLayout.setError(getString(R.string.error_profession));
        } else if (k.a((Object) view, (Object) (TextInputLayout) a(R.id.select_annual_inc)) || k.a((Object) view, (Object) (AppCompatEditText) a(R.id.annual_income_et))) {
            a("Annual Income");
        } else if (k.a((Object) view, (Object) (Button) a(R.id.fragment_cersai_details_save_btn)) && e() && (cersaiDetails = this.f65906a) != null && cersaiDetails != null && (aVar = this.f65907b) != null) {
            k.c(cersaiDetails, "ckycData");
            aVar.f65826a.a();
            net.one97.paytm.upgradeKyc.editprofile.d.a aVar2 = aVar.f65827b;
            if (aVar2 != null) {
                aVar2.a(cersaiDetails, aVar);
            }
        }
    }

    private final void a(String str) {
        Intent intent = new Intent(getActivity(), KycProfessionChooseActivity.class);
        intent.putExtra("option", str);
        startActivityForResult(intent, this.f65908c);
    }

    public final void a() {
        net.one97.paytm.common.widgets.a.a(this.f65910e);
    }

    public final void b() {
        net.one97.paytm.common.widgets.a.b(this.f65910e);
    }

    public final void c() {
        com.paytm.utility.b.b(getContext(), getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
    }

    public final boolean e() {
        RadioGroup radioGroup = (RadioGroup) a(R.id.married_question_rg);
        k.a((Object) radioGroup, "married_question_rg");
        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) a(R.id.married);
        k.a((Object) radioButton, "married");
        if (checkedRadioButtonId == radioButton.getId()) {
            CersaiDetails cersaiDetails = this.f65906a;
            if (cersaiDetails != null) {
                cersaiDetails.setMaritalStatus("married");
            }
        } else {
            RadioButton radioButton2 = (RadioButton) a(R.id.unmarried);
            k.a((Object) radioButton2, "unmarried");
            if (checkedRadioButtonId == radioButton2.getId()) {
                CersaiDetails cersaiDetails2 = this.f65906a;
                if (cersaiDetails2 != null) {
                    cersaiDetails2.setMaritalStatus("unmarried");
                }
            } else {
                RadioButton radioButton3 = (RadioButton) a(R.id.others_marital);
                k.a((Object) radioButton3, "others_marital");
                if (checkedRadioButtonId == radioButton3.getId()) {
                    CersaiDetails cersaiDetails3 = this.f65906a;
                    if (cersaiDetails3 != null) {
                        cersaiDetails3.setMaritalStatus("others");
                    }
                } else {
                    TextView textView = (TextView) a(R.id.tv_error_martial);
                    k.a((Object) textView, "tv_error_martial");
                    textView.setVisibility(0);
                    TextView textView2 = (TextView) a(R.id.tv_error_martial);
                    k.a((Object) textView2, "tv_error_martial");
                    textView2.setText(getString(R.string.error_marital_status));
                    return false;
                }
            }
        }
        String string = getString(R.string.kyc_select_profession);
        AppCompatEditText appCompatEditText = (AppCompatEditText) a(R.id.profession_et);
        k.a((Object) appCompatEditText, "profession_et");
        if (p.a(string, String.valueOf(appCompatEditText.getText()), true)) {
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.select_profession_cat);
            k.a((Object) textInputLayout, "select_profession_cat");
            textInputLayout.setError(getString(R.string.error_profession));
            return false;
        }
        String string2 = getString(R.string.kyc_select_sub_profession);
        AppCompatEditText appCompatEditText2 = (AppCompatEditText) a(R.id.sub_profession_et);
        k.a((Object) appCompatEditText2, "sub_profession_et");
        if (p.a(string2, String.valueOf(appCompatEditText2.getText()), true)) {
            TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.select_profession_til);
            k.a((Object) textInputLayout2, "select_profession_til");
            textInputLayout2.setError(getString(R.string.error_sub_profession));
            return false;
        }
        String string3 = getString(R.string.kyc_select_annual_income);
        AppCompatEditText appCompatEditText3 = (AppCompatEditText) a(R.id.annual_income_et);
        k.a((Object) appCompatEditText3, "annual_income_et");
        if (p.a(string3, String.valueOf(appCompatEditText3.getText()), true)) {
            TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.select_annual_inc);
            k.a((Object) textInputLayout3, "select_annual_inc");
            textInputLayout3.setError(getString(R.string.error_annual_income));
            return false;
        }
        AppCompatEditText appCompatEditText4 = (AppCompatEditText) a(R.id.kyc_family_father_first_name_et);
        k.a((Object) appCompatEditText4, "kyc_family_father_first_name_et");
        if (TextUtils.isEmpty(String.valueOf(appCompatEditText4.getText()))) {
            TextInputLayout textInputLayout4 = (TextInputLayout) a(R.id.kyc_family_father_first_name_layout);
            k.a((Object) textInputLayout4, "kyc_family_father_first_name_layout");
            textInputLayout4.setError(getString(R.string.sign_up_first_name_error));
            return false;
        }
        AppCompatEditText appCompatEditText5 = (AppCompatEditText) a(R.id.kyc_family_mother_first_name_et);
        k.a((Object) appCompatEditText5, "kyc_family_mother_first_name_et");
        if (!TextUtils.isEmpty(String.valueOf(appCompatEditText5.getText()))) {
            return true;
        }
        TextInputLayout textInputLayout5 = (TextInputLayout) a(R.id.kyc_family_mother_first_name_layout);
        k.a((Object) textInputLayout5, "kyc_family_mother_first_name_layout");
        textInputLayout5.setError(getString(R.string.sign_up_first_name_error));
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0146 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void f() {
        /*
            r11 = this;
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65906a
            r1 = 0
            if (r0 == 0) goto L_0x000a
            java.util.ArrayList r0 = r0.getRelationships()
            goto L_0x000b
        L_0x000a:
            r0 = r1
        L_0x000b:
            r2 = 0
            java.lang.String r3 = "MOTHER"
            java.lang.String r4 = "FATHER"
            if (r0 == 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65906a
            if (r0 == 0) goto L_0x0025
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 == 0) goto L_0x0025
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0026
        L_0x0025:
            r0 = r1
        L_0x0026:
            if (r0 != 0) goto L_0x002b
            kotlin.g.b.k.a()
        L_0x002b:
            int r0 = r0.intValue()
            if (r0 <= 0) goto L_0x0137
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r11.f65906a
            if (r0 == 0) goto L_0x0042
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 == 0) goto L_0x0042
            java.util.Collection r0 = (java.util.Collection) r0
            kotlin.j.d r0 = kotlin.a.k.a((java.util.Collection<?>) r0)
            goto L_0x0043
        L_0x0042:
            r0 = r1
        L_0x0043:
            if (r0 != 0) goto L_0x0048
            kotlin.g.b.k.a()
        L_0x0048:
            int r5 = r0.f47939a
            int r0 = r0.f47940b
            if (r5 > r0) goto L_0x0143
            r6 = 0
        L_0x004f:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r7 = r11.f65906a
            if (r7 == 0) goto L_0x0066
            java.util.ArrayList r7 = r7.getRelationships()
            if (r7 == 0) goto L_0x0066
            java.lang.Object r7 = r7.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r7 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r7
            if (r7 == 0) goto L_0x0066
            java.lang.String r7 = r7.getRelationShip()
            goto L_0x0067
        L_0x0066:
            r7 = r1
        L_0x0067:
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            r10 = 1
            if (r9 != 0) goto L_0x00ce
            boolean r9 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r4, (boolean) r10)
            if (r9 == 0) goto L_0x00ce
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r11.f65906a
            if (r2 == 0) goto L_0x008e
            java.util.ArrayList r2 = r2.getRelationships()
            if (r2 == 0) goto L_0x008e
            java.lang.Object r2 = r2.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r2 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r2
            if (r2 == 0) goto L_0x008e
            java.lang.String r2 = r2.getFirstName()
            goto L_0x008f
        L_0x008e:
            r2 = r1
        L_0x008f:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            if (r9 != 0) goto L_0x00a2
            int r9 = net.one97.paytm.landingpage.R.id.kyc_family_father_first_name_et
            android.view.View r9 = r11.a((int) r9)
            androidx.appcompat.widget.AppCompatEditText r9 = (androidx.appcompat.widget.AppCompatEditText) r9
            r9.setText(r2)
        L_0x00a2:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r11.f65906a
            if (r2 == 0) goto L_0x00b9
            java.util.ArrayList r2 = r2.getRelationships()
            if (r2 == 0) goto L_0x00b9
            java.lang.Object r2 = r2.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r2 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r2
            if (r2 == 0) goto L_0x00b9
            java.lang.String r2 = r2.getLastName()
            goto L_0x00ba
        L_0x00b9:
            r2 = r1
        L_0x00ba:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r9 = android.text.TextUtils.isEmpty(r2)
            if (r9 != 0) goto L_0x00cd
            int r9 = net.one97.paytm.landingpage.R.id.kyc_family_father_last_name_et
            android.view.View r9 = r11.a((int) r9)
            androidx.appcompat.widget.AppCompatEditText r9 = (androidx.appcompat.widget.AppCompatEditText) r9
            r9.setText(r2)
        L_0x00cd:
            r2 = 1
        L_0x00ce:
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 != 0) goto L_0x0131
            boolean r7 = kotlin.m.p.a((java.lang.String) r7, (java.lang.String) r3, (boolean) r10)
            if (r7 == 0) goto L_0x0131
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r11.f65906a
            if (r6 == 0) goto L_0x00f1
            java.util.ArrayList r6 = r6.getRelationships()
            if (r6 == 0) goto L_0x00f1
            java.lang.Object r6 = r6.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r6 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r6
            if (r6 == 0) goto L_0x00f1
            java.lang.String r6 = r6.getFirstName()
            goto L_0x00f2
        L_0x00f1:
            r6 = r1
        L_0x00f2:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0105
            int r7 = net.one97.paytm.landingpage.R.id.kyc_family_mother_first_name_et
            android.view.View r7 = r11.a((int) r7)
            androidx.appcompat.widget.AppCompatEditText r7 = (androidx.appcompat.widget.AppCompatEditText) r7
            r7.setText(r6)
        L_0x0105:
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r11.f65906a
            if (r6 == 0) goto L_0x011c
            java.util.ArrayList r6 = r6.getRelationships()
            if (r6 == 0) goto L_0x011c
            java.lang.Object r6 = r6.get(r5)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r6 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r6
            if (r6 == 0) goto L_0x011c
            java.lang.String r6 = r6.getLastName()
            goto L_0x011d
        L_0x011c:
            r6 = r1
        L_0x011d:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x0130
            int r7 = net.one97.paytm.landingpage.R.id.kyc_family_mother_last_name_et
            android.view.View r7 = r11.a((int) r7)
            androidx.appcompat.widget.AppCompatEditText r7 = (androidx.appcompat.widget.AppCompatEditText) r7
            r7.setText(r6)
        L_0x0130:
            r6 = 1
        L_0x0131:
            if (r5 == r0) goto L_0x0144
            int r5 = r5 + 1
            goto L_0x004f
        L_0x0137:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r1 = r11.f65906a
            if (r1 == 0) goto L_0x0143
            r1.setRelationships(r0)
        L_0x0143:
            r6 = 0
        L_0x0144:
            if (r2 != 0) goto L_0x014f
            if (r6 != 0) goto L_0x014f
            r11.b(r3)
            r11.b(r4)
            return
        L_0x014f:
            if (r2 != 0) goto L_0x0155
            r11.b(r4)
            return
        L_0x0155:
            if (r6 != 0) goto L_0x015a
            r11.b(r3)
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.a.f():void");
    }

    private final void b(String str) {
        ArrayList<RelationShipDetails> relationships;
        RelationShipDetails relationShipDetails = new RelationShipDetails((String) null, (String) null, (String) null, (String) null, 15, (g) null);
        relationShipDetails.setAction("add");
        relationShipDetails.setRelationShip(str);
        CersaiDetails cersaiDetails = this.f65906a;
        if (cersaiDetails != null && (relationships = cersaiDetails.getRelationships()) != null) {
            relationships.add(relationShipDetails);
        }
    }

    static final class c implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65914a;

        c(a aVar) {
            this.f65914a = aVar;
        }

        public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
            CersaiDetails cersaiDetails;
            CersaiDetails cersaiDetails2;
            CersaiDetails cersaiDetails3;
            TextView textView = (TextView) this.f65914a.a(R.id.tv_error_martial);
            k.a((Object) textView, "tv_error_martial");
            textView.setVisibility(8);
            RadioButton radioButton = (RadioButton) this.f65914a.a(R.id.married);
            k.a((Object) radioButton, "married");
            if (radioButton.isChecked() && (cersaiDetails3 = this.f65914a.f65906a) != null) {
                cersaiDetails3.setMaritalStatus("married");
            }
            RadioButton radioButton2 = (RadioButton) this.f65914a.a(R.id.unmarried);
            k.a((Object) radioButton2, "unmarried");
            if (radioButton2.isChecked() && (cersaiDetails2 = this.f65914a.f65906a) != null) {
                cersaiDetails2.setMaritalStatus("unmarried");
            }
            RadioButton radioButton3 = (RadioButton) this.f65914a.a(R.id.others_marital);
            k.a((Object) radioButton3, "others_marital");
            if (radioButton3.isChecked() && (cersaiDetails = this.f65914a.f65906a) != null) {
                cersaiDetails.setMaritalStatus("others");
            }
        }
    }

    public static final class d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65915a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "charSequence");
        }

        d(a aVar) {
            this.f65915a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "editable");
            a.a(this.f65915a, "mother", true, false, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            k.c(charSequence, "charSequence");
            ((TextInputLayout) this.f65915a.a(R.id.kyc_family_mother_first_name_layout)).setError("");
            String valueOf = String.valueOf(((AppCompatEditText) this.f65915a.a(R.id.kyc_family_mother_first_name_et)).getText());
            if (valueOf.length() > 0 && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                AppCompatEditText appCompatEditText = (AppCompatEditText) this.f65915a.a(R.id.kyc_family_mother_first_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    appCompatEditText.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) this.f65915a.a(R.id.kyc_family_mother_first_name_et);
            Editable text = ((AppCompatEditText) this.f65915a.a(R.id.kyc_family_mother_first_name_et)).getText();
            if (text == null) {
                k.a();
            }
            appCompatEditText2.setSelection(text.length());
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65916a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "charSequence");
        }

        e(a aVar) {
            this.f65916a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "editable");
            a.a(this.f65916a, "mother", false, true, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            k.c(charSequence, "charSequence");
            String valueOf = String.valueOf(((AppCompatEditText) this.f65916a.a(R.id.kyc_family_mother_last_name_et)).getText());
            if (valueOf.length() > 0 && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                AppCompatEditText appCompatEditText = (AppCompatEditText) this.f65916a.a(R.id.kyc_family_mother_last_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    appCompatEditText.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) this.f65916a.a(R.id.kyc_family_mother_last_name_et);
            Editable text = ((AppCompatEditText) this.f65916a.a(R.id.kyc_family_mother_last_name_et)).getText();
            if (text == null) {
                k.a();
            }
            appCompatEditText2.setSelection(text.length());
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.view.a$a  reason: collision with other inner class name */
    public static final class C1312a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65912a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        C1312a(a aVar) {
            this.f65912a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "s");
            a.a(this.f65912a, "father", true, false, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            k.c(charSequence, "s");
            ((TextInputLayout) this.f65912a.a(R.id.kyc_family_father_first_name_layout)).setError("");
            String valueOf = String.valueOf(((AppCompatEditText) this.f65912a.a(R.id.kyc_family_mother_first_name_et)).getText());
            if (valueOf.length() > 0 && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                AppCompatEditText appCompatEditText = (AppCompatEditText) this.f65912a.a(R.id.kyc_family_father_first_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    appCompatEditText.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) this.f65912a.a(R.id.kyc_family_father_first_name_et);
            Editable text = ((AppCompatEditText) this.f65912a.a(R.id.kyc_family_father_first_name_et)).getText();
            if (text == null) {
                k.a();
            }
            appCompatEditText2.setSelection(text.length());
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65913a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        b(a aVar) {
            this.f65913a = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            k.c(editable, "s");
            a.a(this.f65913a, "father", false, true, editable);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            char charAt;
            k.c(charSequence, "s");
            String valueOf = String.valueOf(((AppCompatEditText) this.f65913a.a(R.id.kyc_family_father_last_name_et)).getText());
            if (valueOf.length() > 0 && '0' <= (charAt = valueOf.charAt(valueOf.length() - 1)) && '9' >= charAt) {
                AppCompatEditText appCompatEditText = (AppCompatEditText) this.f65913a.a(R.id.kyc_family_father_last_name_et);
                int length = valueOf.length() - 1;
                if (valueOf != null) {
                    String substring = valueOf.substring(0, length);
                    k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    appCompatEditText.setText(substring);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) this.f65913a.a(R.id.kyc_family_father_last_name_et);
            Editable text = ((AppCompatEditText) this.f65913a.a(R.id.kyc_family_father_last_name_et)).getText();
            if (text == null) {
                k.a();
            }
            appCompatEditText2.setSelection(text.length());
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.f65908c && i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra("type");
            String stringExtra2 = intent.getStringExtra("option_value");
            if (stringExtra2 != null) {
                k.a((Object) stringExtra, "type");
                k.c(stringExtra, "type");
                k.c(stringExtra2, "selectedOption");
                int hashCode = stringExtra.hashCode();
                if (hashCode != -1449745399) {
                    if (hashCode != -1210261252) {
                        if (hashCode == -864505325 && stringExtra.equals("profession_cat")) {
                            ((AppCompatEditText) a(R.id.profession_et)).setText(stringExtra2);
                            ((AppCompatEditText) a(R.id.sub_profession_et)).setText(getString(R.string.kyc_select_sub_profession));
                            CersaiDetails cersaiDetails = this.f65906a;
                            if (cersaiDetails != null) {
                                cersaiDetails.setProfessionCategory(stringExtra2);
                            }
                        }
                    } else if (stringExtra.equals("profession")) {
                        ((AppCompatEditText) a(R.id.sub_profession_et)).setText(stringExtra2);
                        CersaiDetails cersaiDetails2 = this.f65906a;
                        if (cersaiDetails2 != null) {
                            k.c(stringExtra2, "selectedOption");
                            cersaiDetails2.setProfession(p.a(stringExtra2, " ", "_", false));
                        }
                    }
                } else if (stringExtra.equals("annual_income")) {
                    ((AppCompatEditText) a(R.id.annual_income_et)).setText(stringExtra2);
                    CersaiDetails cersaiDetails3 = this.f65906a;
                    if (cersaiDetails3 != null) {
                        cersaiDetails3.setAnnualIncome(stringExtra2);
                    }
                }
                if (stringExtra != null) {
                    int hashCode2 = stringExtra.hashCode();
                    if (hashCode2 != -1449745399) {
                        if (hashCode2 != -1210261252) {
                            if (hashCode2 == -864505325 && stringExtra.equals("profession_cat")) {
                                TextInputLayout textInputLayout = (TextInputLayout) a(R.id.select_profession_cat);
                                k.a((Object) textInputLayout, "select_profession_cat");
                                textInputLayout.setErrorEnabled(false);
                            }
                        } else if (stringExtra.equals("profession")) {
                            TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.select_profession_til);
                            k.a((Object) textInputLayout2, "select_profession_til");
                            textInputLayout2.setErrorEnabled(false);
                        }
                    } else if (stringExtra.equals("annual_income")) {
                        TextInputLayout textInputLayout3 = (TextInputLayout) a(R.id.select_annual_inc);
                        k.a((Object) textInputLayout3, "select_annual_inc");
                        textInputLayout3.setErrorEnabled(false);
                    }
                }
            }
        }
    }

    public final void d() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Toast.makeText(activity, getString(R.string.profile_saved_toast), 0).show();
            com.paytm.utility.b.c((Activity) activity);
            activity.onBackPressed();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.getRelationships();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(net.one97.paytm.upgradeKyc.editprofile.view.a r5, java.lang.String r6, boolean r7, boolean r8, android.text.Editable r9) {
        /*
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r5.f65906a
            r1 = 0
            if (r0 == 0) goto L_0x0010
            java.util.ArrayList r0 = r0.getRelationships()
            if (r0 == 0) goto L_0x0010
            int r0 = r0.size()
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            if (r0 <= 0) goto L_0x005a
        L_0x0013:
            if (r1 >= r0) goto L_0x005a
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65906a
            if (r2 == 0) goto L_0x0026
            java.util.ArrayList r2 = r2.getRelationships()
            if (r2 == 0) goto L_0x0026
            java.lang.Object r2 = r2.get(r1)
            net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails r2 = (net.one97.paytm.common.entity.upgradeKyc.RelationShipDetails) r2
            goto L_0x0027
        L_0x0026:
            r2 = 0
        L_0x0027:
            if (r2 == 0) goto L_0x0057
            java.lang.String r3 = r2.getRelationShip()
            r4 = 1
            boolean r3 = kotlin.m.p.a((java.lang.String) r6, (java.lang.String) r3, (boolean) r4)
            if (r3 == 0) goto L_0x0057
            java.lang.String r3 = r2.getAction()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0045
            java.lang.String r3 = "edit"
            r2.setAction(r3)
        L_0x0045:
            if (r7 == 0) goto L_0x004e
            java.lang.String r3 = r9.toString()
            r2.setFirstName(r3)
        L_0x004e:
            if (r8 == 0) goto L_0x0057
            java.lang.String r3 = r9.toString()
            r2.setLastName(r3)
        L_0x0057:
            int r1 = r1 + 1
            goto L_0x0013
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.a.a(net.one97.paytm.upgradeKyc.editprofile.view.a, java.lang.String, boolean, boolean, android.text.Editable):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65911f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
