package net.one97.paytm.upgradeKyc.editprofile.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.Group;
import com.alipay.mobile.h5container.api.H5Event;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.a;
import com.paytm.utility.q;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.paymentsbank.UADPincode;
import net.one97.paytm.common.entity.upgradeKyc.Address;
import net.one97.paytm.common.entity.upgradeKyc.CersaiDetails;
import net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress;
import net.one97.paytm.i.h;
import net.one97.paytm.landingpage.R;
import net.one97.paytm.upgradeKyc.editprofile.b.a;
import net.one97.paytm.upgradeKyc.editprofile.d.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends h implements View.OnClickListener, a.c {

    /* renamed from: a  reason: collision with root package name */
    CersaiDetails f65945a;

    /* renamed from: b  reason: collision with root package name */
    net.one97.paytm.upgradeKyc.editprofile.e.c f65946b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f65947c = Boolean.FALSE;

    /* renamed from: d  reason: collision with root package name */
    private final a f65948d = new a(this);

    /* renamed from: e  reason: collision with root package name */
    private final c f65949e = new c(this);

    /* renamed from: f  reason: collision with root package name */
    private final b f65950f = new b(this);

    /* renamed from: g  reason: collision with root package name */
    private final e f65951g = new e(this);

    /* renamed from: h  reason: collision with root package name */
    private final C1314d f65952h = new C1314d(this);

    /* renamed from: i  reason: collision with root package name */
    private final g f65953i = new g(this);
    private HashMap j;

    public final View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onClick(View view) {
    }

    public final void onStart() {
        super.onStart();
        d.a.a.c.a().a((Object) this, false);
    }

    public final void onStop() {
        super.onStop();
        d.a.a.c.a().b(this);
    }

    public final void a(String str) {
        k.c(str, "msg");
        CharSequence charSequence = str;
        if (!TextUtils.isEmpty(charSequence)) {
            TextInputLayout textInputLayout = (TextInputLayout) a(R.id.layout_kyc_contact_details_lyt_pincode);
            k.a((Object) textInputLayout, "layout_kyc_contact_details_lyt_pincode");
            textInputLayout.setError(charSequence);
            return;
        }
        TextInputLayout textInputLayout2 = (TextInputLayout) a(R.id.layout_kyc_contact_details_lyt_pincode);
        k.a((Object) textInputLayout2, "layout_kyc_contact_details_lyt_pincode");
        textInputLayout2.setError(getString(R.string.msg_invalid_pin));
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            this.f65947c = arguments != null ? Boolean.valueOf(arguments.getBoolean("standaloneCersai")) : null;
        }
        a.c cVar = this;
        a.C1308a aVar = net.one97.paytm.upgradeKyc.editprofile.d.a.f65816b;
        Context a2 = net.one97.paytm.common.b.d.b().a();
        k.a((Object) a2, "HomeHelper.getAppLaunchM…).getApplicationContext()");
        net.one97.paytm.upgradeKyc.editprofile.d.a a3 = a.C1308a.a(a2);
        if (a3 == null) {
            k.a();
        }
        this.f65946b = new net.one97.paytm.upgradeKyc.editprofile.e.c(cVar, a3);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.kyc_profile_address_layout, viewGroup, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0076, code lost:
        r6 = (r6 = r6.getAddress()).getCoresspondenceAddress();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r6, android.os.Bundle r7) {
        /*
            r5 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r6, r0)
            super.onViewCreated(r6, r7)
            java.lang.Boolean r6 = r5.f65947c
            if (r6 == 0) goto L_0x003e
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0029
            androidx.fragment.app.Fragment r6 = r5.getParentFragment()
            if (r6 == 0) goto L_0x0021
            net.one97.paytm.upgradeKyc.editprofile.view.b r6 = (net.one97.paytm.upgradeKyc.editprofile.view.b) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r6.f65918b
            r5.f65945a = r6
            goto L_0x003e
        L_0x0021:
            kotlin.u r6 = new kotlin.u
            java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.upgradeKyc.editprofile.view.KycDetailsFragment"
            r6.<init>(r7)
            throw r6
        L_0x0029:
            androidx.fragment.app.Fragment r6 = r5.getParentFragment()
            if (r6 == 0) goto L_0x0036
            net.one97.paytm.upgradeKyc.editprofile.view.a r6 = (net.one97.paytm.upgradeKyc.editprofile.view.a) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r6.f65906a
            r5.f65945a = r6
            goto L_0x003e
        L_0x0036:
            kotlin.u r6 = new kotlin.u
            java.lang.String r7 = "null cannot be cast to non-null type net.one97.paytm.upgradeKyc.editprofile.view.KycCersaiAdditionalDetailsFragment"
            r6.<init>(r7)
            throw r6
        L_0x003e:
            int r6 = net.one97.paytm.landingpage.R.id.correspondence_cb
            android.view.View r6 = r5.a((int) r6)
            android.widget.CheckBox r6 = (android.widget.CheckBox) r6
            net.one97.paytm.upgradeKyc.editprofile.view.d$f r7 = new net.one97.paytm.upgradeKyc.editprofile.view.d$f
            r7.<init>(r5)
            android.widget.CompoundButton$OnCheckedChangeListener r7 = (android.widget.CompoundButton.OnCheckedChangeListener) r7
            r6.setOnCheckedChangeListener(r7)
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r5.f65945a
            r7 = 1
            r0 = 0
            if (r6 == 0) goto L_0x017c
            if (r6 == 0) goto L_0x0069
            net.one97.paytm.common.entity.upgradeKyc.Address r6 = r6.getAddress()
            if (r6 == 0) goto L_0x0069
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r6 = r6.getCoresspondenceAddress()
            if (r6 == 0) goto L_0x0069
            java.lang.String r1 = "edit"
            r6.setAction(r1)
        L_0x0069:
            java.lang.Boolean r6 = java.lang.Boolean.FALSE
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r6 = r5.f65945a
            r1 = 0
            if (r6 == 0) goto L_0x0081
            net.one97.paytm.common.entity.upgradeKyc.Address r6 = r6.getAddress()
            if (r6 == 0) goto L_0x0081
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r6 = r6.getCoresspondenceAddress()
            if (r6 == 0) goto L_0x0081
            java.lang.Boolean r6 = r6.isSameAsPermanent()
            goto L_0x0082
        L_0x0081:
            r6 = r1
        L_0x0082:
            java.lang.String r2 = "correspondence_cb"
            if (r6 == 0) goto L_0x009e
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r3)
            if (r6 == 0) goto L_0x009e
            int r6 = net.one97.paytm.landingpage.R.id.correspondence_cb
            android.view.View r6 = r5.a((int) r6)
            android.widget.CheckBox r6 = (android.widget.CheckBox) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            r6.setChecked(r7)
            goto L_0x017c
        L_0x009e:
            int r6 = net.one97.paytm.landingpage.R.id.correspondence_cb
            android.view.View r6 = r5.a((int) r6)
            android.widget.CheckBox r6 = (android.widget.CheckBox) r6
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            r6.setChecked(r0)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_one_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65945a
            if (r2 == 0) goto L_0x00c9
            net.one97.paytm.common.entity.upgradeKyc.Address r2 = r2.getAddress()
            if (r2 == 0) goto L_0x00c9
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r2 = r2.getCoresspondenceAddress()
            if (r2 == 0) goto L_0x00c9
            java.lang.String r2 = r2.getAddressOne()
            goto L_0x00ca
        L_0x00c9:
            r2 = r1
        L_0x00ca:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_two_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65945a
            if (r2 == 0) goto L_0x00ec
            net.one97.paytm.common.entity.upgradeKyc.Address r2 = r2.getAddress()
            if (r2 == 0) goto L_0x00ec
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r2 = r2.getCoresspondenceAddress()
            if (r2 == 0) goto L_0x00ec
            java.lang.String r2 = r2.getAddressTwo()
            goto L_0x00ed
        L_0x00ec:
            r2 = r1
        L_0x00ed:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_three_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65945a
            if (r2 == 0) goto L_0x010f
            net.one97.paytm.common.entity.upgradeKyc.Address r2 = r2.getAddress()
            if (r2 == 0) goto L_0x010f
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r2 = r2.getCoresspondenceAddress()
            if (r2 == 0) goto L_0x010f
            java.lang.String r2 = r2.getAddressThree()
            goto L_0x0110
        L_0x010f:
            r2 = r1
        L_0x0110:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            int r6 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65945a
            if (r2 == 0) goto L_0x0132
            net.one97.paytm.common.entity.upgradeKyc.Address r2 = r2.getAddress()
            if (r2 == 0) goto L_0x0132
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r2 = r2.getCoresspondenceAddress()
            if (r2 == 0) goto L_0x0132
            java.lang.String r2 = r2.getPostalCode()
            goto L_0x0133
        L_0x0132:
            r2 = r1
        L_0x0133:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            int r6 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_city
            android.view.View r6 = r5.a((int) r6)
            android.widget.AutoCompleteTextView r6 = (android.widget.AutoCompleteTextView) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65945a
            if (r2 == 0) goto L_0x0155
            net.one97.paytm.common.entity.upgradeKyc.Address r2 = r2.getAddress()
            if (r2 == 0) goto L_0x0155
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r2 = r2.getCoresspondenceAddress()
            if (r2 == 0) goto L_0x0155
            java.lang.String r2 = r2.getCity()
            goto L_0x0156
        L_0x0155:
            r2 = r1
        L_0x0156:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r6.setText(r2)
            int r6 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_state
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r2 = r5.f65945a
            if (r2 == 0) goto L_0x0177
            net.one97.paytm.common.entity.upgradeKyc.Address r2 = r2.getAddress()
            if (r2 == 0) goto L_0x0177
            net.one97.paytm.common.entity.upgradeKyc.CorrespondenceAddress r2 = r2.getCoresspondenceAddress()
            if (r2 == 0) goto L_0x0177
            java.lang.String r1 = r2.getState()
        L_0x0177:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r6.setText(r1)
        L_0x017c:
            int r6 = net.one97.paytm.landingpage.R.id.address_line_one_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.upgradeKyc.editprofile.view.d$a r1 = r5.f65948d
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r6.addTextChangedListener(r1)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_two_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.upgradeKyc.editprofile.view.d$c r1 = r5.f65949e
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r6.addTextChangedListener(r1)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_three_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.upgradeKyc.editprofile.view.d$b r1 = r5.f65950f
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r6.addTextChangedListener(r1)
            int r6 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.upgradeKyc.editprofile.view.d$e r1 = r5.f65951g
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r6.addTextChangedListener(r1)
            int r6 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_city
            android.view.View r6 = r5.a((int) r6)
            android.widget.AutoCompleteTextView r6 = (android.widget.AutoCompleteTextView) r6
            net.one97.paytm.upgradeKyc.editprofile.view.d$d r1 = r5.f65952h
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r6.addTextChangedListener(r1)
            int r6 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_state
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            net.one97.paytm.upgradeKyc.editprofile.view.d$g r1 = r5.f65953i
            android.text.TextWatcher r1 = (android.text.TextWatcher) r1
            r6.addTextChangedListener(r1)
            int r6 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_state
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            java.lang.String r1 = "layout_kyc_contact_details_et_state"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
            r1 = 2
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r3 = new android.text.InputFilter$LengthFilter
            r4 = 30
            r3.<init>(r4)
            android.text.InputFilter r3 = (android.text.InputFilter) r3
            r2[r0] = r3
            android.text.InputFilter$AllCaps r3 = new android.text.InputFilter$AllCaps
            r3.<init>()
            android.text.InputFilter r3 = (android.text.InputFilter) r3
            r2[r7] = r3
            r6.setFilters(r2)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_three_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            java.lang.String r2 = "address_line_three_et"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r3 = new android.text.InputFilter$LengthFilter
            r4 = 150(0x96, float:2.1E-43)
            r3.<init>(r4)
            android.text.InputFilter r3 = (android.text.InputFilter) r3
            r2[r0] = r3
            android.text.InputFilter$AllCaps r3 = new android.text.InputFilter$AllCaps
            r3.<init>()
            android.text.InputFilter r3 = (android.text.InputFilter) r3
            r2[r7] = r3
            r6.setFilters(r2)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_two_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            java.lang.String r2 = "address_line_two_et"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            android.text.InputFilter[] r2 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r3 = new android.text.InputFilter$LengthFilter
            r3.<init>(r4)
            android.text.InputFilter r3 = (android.text.InputFilter) r3
            r2[r0] = r3
            android.text.InputFilter$AllCaps r3 = new android.text.InputFilter$AllCaps
            r3.<init>()
            android.text.InputFilter r3 = (android.text.InputFilter) r3
            r2[r7] = r3
            r6.setFilters(r2)
            int r6 = net.one97.paytm.landingpage.R.id.address_line_one_et
            android.view.View r6 = r5.a((int) r6)
            androidx.appcompat.widget.AppCompatEditText r6 = (androidx.appcompat.widget.AppCompatEditText) r6
            java.lang.String r2 = "address_line_one_et"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)
            android.text.InputFilter[] r1 = new android.text.InputFilter[r1]
            android.text.InputFilter$LengthFilter r2 = new android.text.InputFilter$LengthFilter
            r2.<init>(r4)
            android.text.InputFilter r2 = (android.text.InputFilter) r2
            r1[r0] = r2
            android.text.InputFilter$AllCaps r0 = new android.text.InputFilter$AllCaps
            r0.<init>()
            android.text.InputFilter r0 = (android.text.InputFilter) r0
            r1[r7] = r0
            r6.setFilters(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    public static final class f implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f65959a;

        f(d dVar) {
            this.f65959a = dVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            Address address2;
            CorrespondenceAddress coresspondenceAddress2;
            Address address3;
            CorrespondenceAddress coresspondenceAddress3;
            CersaiDetails cersaiDetails = this.f65959a.f65945a;
            if (!(cersaiDetails == null || (address3 = cersaiDetails.getAddress()) == null || (coresspondenceAddress3 = address3.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress3.setAction("edit");
            }
            if (!z) {
                CersaiDetails cersaiDetails2 = this.f65959a.f65945a;
                if (!(cersaiDetails2 == null || (address2 = cersaiDetails2.getAddress()) == null || (coresspondenceAddress2 = address2.getCoresspondenceAddress()) == null)) {
                    coresspondenceAddress2.setSameAsPermanent(Boolean.FALSE);
                }
                Group group = (Group) this.f65959a.a(R.id.kyc_new_address_lyt);
                k.a((Object) group, "kyc_new_address_lyt");
                group.setVisibility(0);
                return;
            }
            CersaiDetails cersaiDetails3 = this.f65959a.f65945a;
            if (!(cersaiDetails3 == null || (address = cersaiDetails3.getAddress()) == null || (coresspondenceAddress = address.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress.setSameAsPermanent(Boolean.TRUE);
            }
            Group group2 = (Group) this.f65959a.a(R.id.kyc_new_address_lyt);
            k.a((Object) group2, "kyc_new_address_lyt");
            group2.setVisibility(8);
        }
    }

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f65954a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        a(d dVar) {
            this.f65954a = dVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails cersaiDetails;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65954a.a(R.id.address_line_one_til);
            k.a((Object) textInputLayout, "address_line_one_til");
            textInputLayout.setError("");
            if (this.f65954a.f65945a != null && (cersaiDetails = this.f65954a.f65945a) != null && (address = cersaiDetails.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setAddressOne(editable.toString());
            }
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f65956a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        c(d dVar) {
            this.f65956a = dVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails cersaiDetails;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65956a.a(R.id.address_line_two_til);
            k.a((Object) textInputLayout, "address_line_two_til");
            textInputLayout.setError("");
            if (this.f65956a.f65945a != null && (cersaiDetails = this.f65956a.f65945a) != null && (address = cersaiDetails.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setAddressTwo(editable.toString());
            }
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f65955a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        b(d dVar) {
            this.f65955a = dVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails cersaiDetails;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65955a.a(R.id.address_line_three_til);
            k.a((Object) textInputLayout, "address_line_three_til");
            textInputLayout.setError("");
            if (!(this.f65955a.f65945a == null || (cersaiDetails = this.f65955a.f65945a) == null || (address = cersaiDetails.getAddress()) == null || (coresspondenceAddress = address.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress.setAddressThree(editable.toString());
            }
            TextInputLayout textInputLayout2 = (TextInputLayout) this.f65955a.a(R.id.address_line_three_til);
            k.a((Object) textInputLayout2, "address_line_three_til");
            textInputLayout2.setError("");
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f65958a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        e(d dVar) {
            this.f65958a = dVar;
        }

        public final void afterTextChanged(Editable editable) {
            net.one97.paytm.upgradeKyc.editprofile.e.c cVar;
            String str;
            CersaiDetails cersaiDetails;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            k.c(editable, "s");
            TextInputLayout textInputLayout = (TextInputLayout) this.f65958a.a(R.id.layout_kyc_contact_details_lyt_pincode);
            k.a((Object) textInputLayout, "layout_kyc_contact_details_lyt_pincode");
            textInputLayout.setError("");
            if (!(this.f65958a.f65945a == null || (cersaiDetails = this.f65958a.f65945a) == null || (address = cersaiDetails.getAddress()) == null || (coresspondenceAddress = address.getCoresspondenceAddress()) == null)) {
                coresspondenceAddress.setPostalCode(editable.toString());
            }
            if (editable.length() == 6 && (cVar = this.f65958a.f65946b) != null) {
                String obj = editable.toString();
                k.c(obj, "pinCode");
                net.one97.paytm.upgradeKyc.editprofile.d.a aVar = cVar.f65830a;
                if (aVar != null) {
                    a.d dVar = cVar;
                    k.c(obj, "pinCode");
                    k.c(dVar, H5Event.TYPE_CALL_BACK);
                    String e2 = com.paytm.utility.b.e(aVar.f65818a, net.one97.paytm.common.b.d.b().a("uadPincode"));
                    Map hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    String b2 = net.one97.paytm.common.b.d.a().b(aVar.f65818a);
                    k.a((Object) b2, "HomeHelper.getModuleInte…e().getSSOToken(mContext)");
                    hashMap.put("session_token", b2);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(obj);
                        jSONObject.put("pincodes", jSONArray);
                        jSONObject.put("addressResponseType", "SECONDARY");
                        jSONObject.put("tier3Type", "UNIQUE");
                        String jSONObject2 = jSONObject.toString();
                        k.a((Object) jSONObject2, "jsonObject.toString()");
                        str = jSONObject2;
                    } catch (JSONException e3) {
                        q.b(e3.getMessage());
                        str = "";
                    }
                    UADPincode uADPincode = new UADPincode();
                    uADPincode.setPincode(obj);
                    com.paytm.network.a a2 = net.one97.paytm.common.b.d.a(aVar.f65818a, e2, new a.d(dVar), hashMap, (Map<String, String>) null, a.C0715a.POST, str, uADPincode, a.c.HOME, a.b.SILENT);
                    if (!com.paytm.utility.a.m(aVar.f65818a)) {
                        dVar.a();
                    } else if (a2 != null) {
                        a2.a();
                    } else {
                        com.paytm.utility.a.c();
                    }
                }
            }
        }
    }

    /* renamed from: net.one97.paytm.upgradeKyc.editprofile.view.d$d  reason: collision with other inner class name */
    public static final class C1314d implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f65957a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        C1314d(d dVar) {
            this.f65957a = dVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails cersaiDetails;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            k.c(editable, "s");
            if (this.f65957a.f65945a != null && (cersaiDetails = this.f65957a.f65945a) != null && (address = cersaiDetails.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setCity(editable.toString());
            }
        }
    }

    public static final class g implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f65960a;

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            k.c(charSequence, "s");
        }

        g(d dVar) {
            this.f65960a = dVar;
        }

        public final void afterTextChanged(Editable editable) {
            CersaiDetails cersaiDetails;
            Address address;
            CorrespondenceAddress coresspondenceAddress;
            k.c(editable, "s");
            if (this.f65960a.f65945a != null && (cersaiDetails = this.f65960a.f65945a) != null && (address = cersaiDetails.getAddress()) != null && (coresspondenceAddress = address.getCoresspondenceAddress()) != null) {
                coresspondenceAddress.setState(editable.toString());
            }
        }
    }

    public final void a(UADPincode.SubPincode subPincode) {
        k.c(subPincode, "pinCode");
        if (((AutoCompleteTextView) a(R.id.layout_kyc_contact_details_et_city)) != null) {
            ((AutoCompleteTextView) a(R.id.layout_kyc_contact_details_et_city)).setText(subPincode.getTier3Value().toString());
        }
        if (((AppCompatEditText) a(R.id.layout_kyc_contact_details_et_state)) != null) {
            ((AppCompatEditText) a(R.id.layout_kyc_contact_details_et_state)).setText(subPincode.getState());
        }
    }

    private final void a(View view) {
        Point point = new Point();
        ScrollView scrollView = (ScrollView) a(R.id.cersai_address_layout_parent_container);
        k.a((Object) scrollView, "cersai_address_layout_parent_container");
        ViewParent parent = view.getParent();
        k.a((Object) parent, "view.parent");
        a(scrollView, parent, view, point);
        ((ScrollView) a(R.id.cersai_address_layout_parent_container)).smoothScrollTo(0, point.y);
    }

    private static void a(ViewGroup viewGroup, ViewParent viewParent, View view, Point point) {
        while (viewParent != null) {
            ViewGroup viewGroup2 = (ViewGroup) viewParent;
            point.x += view.getLeft();
            point.y += view.getTop();
            if (!k.a((Object) viewGroup2, (Object) viewGroup)) {
                ViewParent parent = viewGroup2.getParent();
                k.a((Object) parent, "parentGroup.parent");
                ViewParent viewParent2 = parent;
                view = viewGroup2;
                viewParent = viewParent2;
            } else {
                return;
            }
        }
        throw new u("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onEvent(net.one97.paytm.upgradeKyc.editprofile.c.a r4) {
        /*
            r3 = this;
            java.lang.String r0 = "editProfileObj"
            kotlin.g.b.k.c(r4, r0)
            int r4 = net.one97.paytm.landingpage.R.id.correspondence_cb
            android.view.View r4 = r3.a((int) r4)
            android.widget.CheckBox r4 = (android.widget.CheckBox) r4
            java.lang.String r0 = "correspondence_cb"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            boolean r4 = r4.isChecked()
            r0 = 0
            if (r4 != 0) goto L_0x01ff
            int r4 = net.one97.paytm.landingpage.R.id.address_line_one_et
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            java.lang.String r1 = "address_line_one_et"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x005c
            int r4 = net.one97.paytm.landingpage.R.id.address_line_one_til
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.String r1 = "address_line_one_til"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            int r2 = net.one97.paytm.landingpage.R.string.error_fill_details
            java.lang.String r2 = r3.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setError(r2)
            int r4 = net.one97.paytm.landingpage.R.id.address_line_one_til
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.view.View r4 = (android.view.View) r4
            r3.a((android.view.View) r4)
            goto L_0x0200
        L_0x005c:
            int r4 = net.one97.paytm.landingpage.R.id.address_line_two_et
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            java.lang.String r1 = "address_line_two_et"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x009f
            int r4 = net.one97.paytm.landingpage.R.id.address_line_two_til
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.String r1 = "address_line_two_til"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            int r2 = net.one97.paytm.landingpage.R.string.error_fill_details
            java.lang.String r2 = r3.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setError(r2)
            int r4 = net.one97.paytm.landingpage.R.id.address_line_two_til
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.view.View r4 = (android.view.View) r4
            r3.a((android.view.View) r4)
            goto L_0x0200
        L_0x009f:
            int r4 = net.one97.paytm.landingpage.R.id.address_line_three_et
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            java.lang.String r1 = "address_line_three_et"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x00e2
            int r4 = net.one97.paytm.landingpage.R.id.address_line_three_til
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.String r1 = "address_line_three_til"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            int r2 = net.one97.paytm.landingpage.R.string.error_fill_details
            java.lang.String r2 = r3.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setError(r2)
            int r4 = net.one97.paytm.landingpage.R.id.address_line_three_til
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.view.View r4 = (android.view.View) r4
            r3.a((android.view.View) r4)
            goto L_0x0200
        L_0x00e2:
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_city
            android.view.View r4 = r3.a((int) r4)
            android.widget.AutoCompleteTextView r4 = (android.widget.AutoCompleteTextView) r4
            java.lang.String r1 = "layout_kyc_contact_details_et_city"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0125
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_lyt_pincode
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.String r2 = "layout_kyc_contact_details_lyt_pincode"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r2 = net.one97.paytm.landingpage.R.string.pdp_enter_valid_pin
            java.lang.String r2 = r3.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setError(r2)
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_city
            android.view.View r4 = r3.a((int) r4)
            android.widget.AutoCompleteTextView r4 = (android.widget.AutoCompleteTextView) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.view.View r4 = (android.view.View) r4
            r3.a((android.view.View) r4)
            goto L_0x0200
        L_0x0125:
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_state
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            java.lang.String r1 = "layout_kyc_contact_details_et_state"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x0168
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_lyt_state
            android.view.View r4 = r3.a((int) r4)
            com.google.android.material.textfield.TextInputLayout r4 = (com.google.android.material.textfield.TextInputLayout) r4
            java.lang.String r2 = "layout_kyc_contact_details_lyt_state"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r2)
            int r2 = net.one97.paytm.landingpage.R.string.pdp_enter_valid_pin
            java.lang.String r2 = r3.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setError(r2)
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_state
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.view.View r4 = (android.view.View) r4
            r3.a((android.view.View) r4)
            goto L_0x0200
        L_0x0168:
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            java.lang.String r1 = "layout_kyc_contact_details_et_pincode"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 == 0) goto L_0x01a8
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            int r2 = net.one97.paytm.landingpage.R.string.error_pincode
            java.lang.String r2 = r3.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setError(r2)
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.view.View r4 = (android.view.View) r4
            r3.a((android.view.View) r4)
            goto L_0x0200
        L_0x01a8:
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x01ff
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.text.Editable r4 = r4.getText()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            boolean r4 = com.paytm.utility.p.a(r4)
            if (r4 != 0) goto L_0x01ff
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            int r2 = net.one97.paytm.landingpage.R.string.pdp_enter_valid_pin
            java.lang.String r2 = r3.getString(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r4.setError(r2)
            int r4 = net.one97.paytm.landingpage.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r4 = r3.a((int) r4)
            androidx.appcompat.widget.AppCompatEditText r4 = (androidx.appcompat.widget.AppCompatEditText) r4
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            android.view.View r4 = (android.view.View) r4
            r3.a((android.view.View) r4)
            goto L_0x0200
        L_0x01ff:
            r0 = 1
        L_0x0200:
            if (r0 == 0) goto L_0x020e
            d.a.a.c r4 = d.a.a.c.a()
            net.one97.paytm.upgradeKyc.editprofile.c.c r0 = new net.one97.paytm.upgradeKyc.editprofile.c.c
            r0.<init>()
            r4.c(r0)
        L_0x020e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.editprofile.view.d.onEvent(net.one97.paytm.upgradeKyc.editprofile.c.a):void");
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
