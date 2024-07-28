package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.URLUtil;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.q;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.upgradeKyc.EkycData;
import net.one97.paytm.common.entity.upgradeKyc.EkycDataResponse;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.common.entity.upgradeKyc.UADPincode;
import net.one97.paytm.common.utility.RadioGridGroup;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.d.i;
import net.one97.paytm.upgradeKyc.d.m;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.utils.d;
import net.one97.paytm.upgradeKyc.utils.f;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upgradeKyc.videokyc.activity.AddPanVideoKycActivity;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CompleteProfileAadhaarActivity extends UpgradeKycBaseActivity implements View.OnClickListener, View.OnFocusChangeListener, b, d.a {
    private ScrollView A;
    /* access modifiers changed from: private */
    public TextInputLayout B;
    private TextInputEditText C;
    private TextView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private TextView H;
    /* access modifiers changed from: private */
    public TextInputLayout I;
    /* access modifiers changed from: private */
    public TextInputLayout J;
    /* access modifiers changed from: private */
    public TextInputLayout K;
    /* access modifiers changed from: private */
    public TextInputLayout L;
    /* access modifiers changed from: private */
    public TextInputLayout M;
    /* access modifiers changed from: private */
    public TextInputLayout N;
    /* access modifiers changed from: private */
    public TextInputLayout O;
    /* access modifiers changed from: private */
    public TextInputLayout P;
    /* access modifiers changed from: private */
    public TextInputLayout Q;
    /* access modifiers changed from: private */
    public TextInputLayout R;
    private TextView S;
    private TextView T;
    private TextView U;
    private ImageView V;
    /* access modifiers changed from: private */
    public LinearLayout W;
    private LinearLayout X;
    private RelativeLayout Y;
    /* access modifiers changed from: private */
    public TextView Z;

    /* renamed from: a  reason: collision with root package name */
    TextWatcher f65252a = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            CompleteProfileAadhaarActivity.this.P.setError((CharSequence) null);
            if (i3 == 0) {
                if (charSequence.length() == 2 || charSequence.length() == 5) {
                    TextInputEditText b2 = CompleteProfileAadhaarActivity.this.t;
                    b2.setText(CompleteProfileAadhaarActivity.this.t.getText() + "/");
                    CompleteProfileAadhaarActivity.this.t.setSelection(CompleteProfileAadhaarActivity.this.t.getText().length());
                }
                if (CompleteProfileAadhaarActivity.this.t.getText().length() == 10) {
                    try {
                        int parseInt = Integer.parseInt(CompleteProfileAadhaarActivity.this.t.getText().toString().substring(CompleteProfileAadhaarActivity.this.t.getText().length() - 4));
                        Calendar unused = CompleteProfileAadhaarActivity.this.ad = Calendar.getInstance();
                        CompleteProfileAadhaarActivity.this.ad.set(1, parseInt);
                    } catch (NumberFormatException unused2) {
                    }
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean aa = false;
    /* access modifiers changed from: private */
    public AutoCompleteTextView ab;
    private String ac;
    /* access modifiers changed from: private */
    public Calendar ad;
    private TextInputLayout ae;
    private TextInputLayout af;
    private TextInputLayout ag;
    private TextView ah;
    private KycAadharEkycDetails.KycResponse ai;
    private TextView aj;
    /* access modifiers changed from: private */
    public boolean ak;
    private int al = -1;
    private int am = 1234;
    private EditText an;
    private EditText ao;
    private EditText ap;
    private String aq;
    private String ar;
    private String as;
    private TextWatcher at = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            CompleteProfileAadhaarActivity.this.O.setError("");
        }
    };
    private TextWatcher au = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            CompleteProfileAadhaarActivity.this.Z.setVisibility(8);
            CompleteProfileAadhaarActivity.this.W.setBackgroundColor(Color.parseColor("#FFFFFF"));
            CompleteProfileAadhaarActivity.this.K.setError("");
        }
    };
    private TextWatcher av = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            CompleteProfileAadhaarActivity.this.B.setError("");
            if (charSequence != null && charSequence.length() == 6) {
                CompleteProfileAadhaarActivity.a(CompleteProfileAadhaarActivity.this, charSequence.toString());
            }
        }

        public final void afterTextChanged(Editable editable) {
            CompleteProfileAadhaarActivity.this.ab.setText("");
            CompleteProfileAadhaarActivity.this.ab.setAdapter((ListAdapter) null);
            CompleteProfileAadhaarActivity.this.l.setText("");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private RadioGridGroup f65253b;

    /* renamed from: d  reason: collision with root package name */
    private RadioGridGroup f65254d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<TncData> f65255e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f65256f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f65257g;

    /* renamed from: h  reason: collision with root package name */
    private LinearLayout f65258h;

    /* renamed from: i  reason: collision with root package name */
    private TextInputEditText f65259i;
    private TextInputEditText j;
    private TextInputEditText k;
    /* access modifiers changed from: private */
    public TextInputEditText l;
    /* access modifiers changed from: private */
    public TextInputEditText m;
    private TextInputEditText n;
    private TextInputEditText o;
    /* access modifiers changed from: private */
    public TextInputEditText p;
    /* access modifiers changed from: private */
    public TextInputEditText q;
    /* access modifiers changed from: private */
    public TextInputEditText r;
    /* access modifiers changed from: private */
    public TextInputEditText s;
    /* access modifiers changed from: private */
    public TextInputEditText t;
    private TextInputEditText u;
    private RadioGroup v;
    private RadioGroup w;
    private RadioGroup x;
    private RadioGroup y;
    private CheckBox z;

    /* access modifiers changed from: private */
    public static /* synthetic */ void j() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x055d  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0643  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
            r9 = this;
            super.onCreate(r10)
            android.content.Intent r10 = r9.getIntent()
            r0 = 0
            if (r10 == 0) goto L_0x0020
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r1 = "isVideoKYCFlow"
            boolean r10 = r10.hasExtra(r1)
            if (r10 == 0) goto L_0x0020
            android.content.Intent r10 = r9.getIntent()
            boolean r10 = r10.getBooleanExtra(r1, r0)
            r9.ak = r10
        L_0x0020:
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r1 = "reference_number"
            if (r10 == 0) goto L_0x0053
            android.content.Intent r10 = r9.getIntent()
            android.os.Bundle r10 = r10.getExtras()
            if (r10 == 0) goto L_0x0053
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r10 = r10.getStringExtra(r1)
            r9.ac = r10
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r2 = "vertical"
            r10.getStringExtra(r2)
            android.content.Intent r10 = r9.getIntent()
            java.lang.String r2 = "aadhaarData"
            java.io.Serializable r10 = r10.getSerializableExtra(r2)
            net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails$KycResponse r10 = (net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails.KycResponse) r10
            r9.ai = r10
        L_0x0053:
            net.one97.paytm.upgradeKyc.helper.e$a r10 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r10 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            java.lang.String r2 = "/kyc-wallet-upgrade/aadhaar-otp/additional-details"
            java.lang.String r3 = "kyc"
            r10.a((java.lang.String) r2, (java.lang.String) r3, (android.content.Context) r9)
            int r10 = net.one97.paytm.upgradeKyc.R.id.appointment_book_parent_sv
            android.view.View r10 = r9.findViewById(r10)
            android.widget.ScrollView r10 = (android.widget.ScrollView) r10
            r9.A = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_error_martial
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.D = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_error_profession
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.G = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_error_address_three
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.Z = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.cersai_form_60_heading_tv
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.E = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_name_adhar
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.S = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_kyc_perm_address_label
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.F = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_dob_adhar
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.T = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_value_gender
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.U = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_kyc_perm_address
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.aj = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.user_adhar_image
            android.view.View r10 = r9.findViewById(r10)
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r9.V = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_lyt_address3
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.K = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.cersai_page_ekyc_data_lyt
            android.view.View r10 = r9.findViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            r9.Y = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_lyt_extra
            android.view.View r10 = r9.findViewById(r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.f65258h = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_martial_rg
            android.view.View r10 = r9.findViewById(r10)
            net.one97.paytm.common.utility.RadioGridGroup r10 = (net.one97.paytm.common.utility.RadioGridGroup) r10
            r9.f65254d = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_profession_rg
            android.view.View r10 = r9.findViewById(r10)
            net.one97.paytm.common.utility.RadioGridGroup r10 = (net.one97.paytm.common.utility.RadioGridGroup) r10
            r9.f65253b = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.lyt_address
            android.view.View r10 = r9.findViewById(r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.W = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tv_error_cb_indian
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.H = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_lyt_city
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.R = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_lyt_state
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.Q = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_lyt_pincode
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.B = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_pincode
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.f65259i = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_house
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.j = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_area
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.k = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_address3
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.C = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_state
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.l = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_et_city
            android.view.View r10 = r9.findViewById(r10)
            android.widget.AutoCompleteTextView r10 = (android.widget.AutoCompleteTextView) r10
            r9.ab = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.profession_et
            android.view.View r10 = r9.findViewById(r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            r9.an = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.sub_profession_et
            android.view.View r10 = r9.findViewById(r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            r9.ao = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.annual_income_et
            android.view.View r10 = r9.findViewById(r10)
            android.widget.EditText r10 = (android.widget.EditText) r10
            r9.ap = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.select_profession_cat
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.ae = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.select_profession_til
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.af = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.select_annual_inc
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.ag = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_family_father_first_name_layout
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.I = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_family_mother_first_name_layout
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.J = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_family_father_first_name_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.p = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_family_father_last_name_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.q = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_family_mother_first_name_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.r = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_family_mother_last_name_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.s = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_rg_address
            android.view.View r10 = r9.findViewById(r10)
            android.widget.RadioGroup r10 = (android.widget.RadioGroup) r10
            r9.v = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_contact_details_rg_address_type
            android.view.View r10 = r9.findViewById(r10)
            android.widget.RadioGroup r10 = (android.widget.RadioGroup) r10
            r9.w = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_do_you_have_pan
            android.view.View r10 = r9.findViewById(r10)
            android.widget.RadioGroup r10 = (android.widget.RadioGroup) r10
            r9.x = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_til_pan_number
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.L = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_enter_doc_num_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.m = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.annual_agri_income
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.M = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.annual_non_agri_income
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.N = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.annual_agri_income_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.n = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.annual_non_agri_income_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.o = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.tnc_set_form60_tv
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r9.ah = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.activity_complete_profile_indian_decleration_cb
            android.view.View r10 = r9.findViewById(r10)
            android.widget.CheckBox r10 = (android.widget.CheckBox) r10
            r9.z = r10
            android.widget.AutoCompleteTextView r10 = r9.ab
            r2 = 1
            r10.setClickable(r2)
            int r10 = net.one97.paytm.upgradeKyc.R.id.activity_complete_profile_aadhaar_btn_save
            android.view.View r10 = r9.findViewById(r10)
            r10.setOnClickListener(r9)
            int r10 = net.one97.paytm.upgradeKyc.R.id.know_more_adhar_tv
            android.view.View r10 = r9.findViewById(r10)
            r10.setOnClickListener(r9)
            com.google.android.material.textfield.TextInputLayout r10 = r9.ae
            r10.setOnClickListener(r9)
            android.widget.EditText r10 = r9.an
            r10.setOnClickListener(r9)
            com.google.android.material.textfield.TextInputLayout r10 = r9.af
            r10.setOnClickListener(r9)
            android.widget.EditText r10 = r9.ao
            r10.setOnClickListener(r9)
            com.google.android.material.textfield.TextInputLayout r10 = r9.ag
            r10.setOnClickListener(r9)
            android.widget.EditText r10 = r9.ap
            r10.setOnClickListener(r9)
            boolean r10 = r9.ak
            r3 = 8
            if (r10 == 0) goto L_0x02b3
            int r10 = net.one97.paytm.upgradeKyc.R.id.do_you_have_pan_lyt
            android.view.View r10 = r9.findViewById(r10)
            r10.setVisibility(r3)
            int r10 = net.one97.paytm.upgradeKyc.R.id.cersai_form60_lyt
            android.view.View r10 = r9.findViewById(r10)
            r10.setVisibility(r3)
            com.google.android.material.textfield.TextInputLayout r10 = r9.af
            r10.setVisibility(r0)
            com.google.android.material.textfield.TextInputLayout r10 = r9.ag
            r10.setVisibility(r0)
            com.google.android.material.textfield.TextInputEditText r10 = r9.s
            r4 = 6
            r10.setImeOptions(r4)
            goto L_0x02cf
        L_0x02b3:
            int r10 = net.one97.paytm.upgradeKyc.R.id.do_you_have_pan_lyt
            android.view.View r10 = r9.findViewById(r10)
            r10.setVisibility(r0)
            int r10 = net.one97.paytm.upgradeKyc.R.id.do_you_have_pan_lyt
            android.view.View r10 = r9.findViewById(r10)
            r10.setVisibility(r0)
            com.google.android.material.textfield.TextInputLayout r10 = r9.af
            r10.setVisibility(r3)
            com.google.android.material.textfield.TextInputLayout r10 = r9.ag
            r10.setVisibility(r3)
        L_0x02cf:
            com.google.android.material.textfield.TextInputEditText r10 = r9.p
            r4 = 2
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r7 = 30
            r6.<init>(r7)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.q
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r7)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.r
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r7)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.s
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r7)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.j
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r8 = 150(0x96, float:2.1E-43)
            r6.<init>(r8)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.k
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r8)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.C
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r8)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            android.widget.AutoCompleteTextView r10 = r9.ab
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r7)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.l
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r6.<init>(r7)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.m
            android.text.InputFilter[] r5 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r8 = 10
            r6.<init>(r8)
            r5[r0] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r5[r2] = r6
            r10.setFilters(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.f65259i
            android.text.TextWatcher r5 = r9.av
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.m
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$7 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$7
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.n
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$8 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$8
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.o
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$9 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$9
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.p
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$10 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$10
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.q
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$11 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$11
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.r
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$12 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$12
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.s
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$13 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$13
            r5.<init>()
            r10.addTextChangedListener(r5)
            android.widget.AutoCompleteTextView r10 = r9.ab
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$14 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$14
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.l
            net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$2 r5 = new net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity$2
            r5.<init>()
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.j
            android.text.TextWatcher r5 = r9.au
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.k
            android.text.TextWatcher r5 = r9.au
            r10.addTextChangedListener(r5)
            com.google.android.material.textfield.TextInputEditText r10 = r9.C
            android.text.TextWatcher r5 = r9.au
            r10.addTextChangedListener(r5)
            android.widget.RadioGroup r10 = r9.v
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$zTCXDU04qVgNCHHBDmZy-hbJ_pY r5 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$zTCXDU04qVgNCHHBDmZy-hbJ_pY
            r5.<init>()
            r10.setOnCheckedChangeListener(r5)
            net.one97.paytm.common.utility.RadioGridGroup r10 = r9.f65254d
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$2AqFI4tEoxrdLE9JBJnEf2NwNKw r5 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$2AqFI4tEoxrdLE9JBJnEf2NwNKw
            r5.<init>()
            r10.setCheckChangeListener(r5)
            net.one97.paytm.common.utility.RadioGridGroup r10 = r9.f65253b
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$am3ilo9NLdbhaqs4Owh13AShSJU r5 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$am3ilo9NLdbhaqs4Owh13AShSJU
            r5.<init>()
            r10.setCheckChangeListener(r5)
            android.widget.CheckBox r10 = r9.z
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$Snq93RjRS1LKDD9dFVgVQulMIsI r5 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$Snq93RjRS1LKDD9dFVgVQulMIsI
            r5.<init>()
            r10.setOnCheckedChangeListener(r5)
            net.one97.paytm.upgradeKyc.f.c r10 = net.one97.paytm.upgradeKyc.f.c.a()
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$S1Mw6lTV566iVgOql3mibb4rbLE r5 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$S1Mw6lTV566iVgOql3mibb4rbLE
            r5.<init>()
            r10.f65975b = r5
            r10.f65976c = r9
            java.lang.String r5 = r10.f65974a
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x047f
            android.content.Context r5 = r9.getApplicationContext()
            com.paytm.b.a.a r5 = net.one97.paytm.common.utility.i.a(r5)
            java.lang.String r6 = "pan_number"
            java.lang.String r8 = ""
            java.lang.String r5 = r5.b((java.lang.String) r6, (java.lang.String) r8, (boolean) r2)
            r10.f65974a = r5
            java.lang.String r5 = r10.f65974a
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x047f
            android.content.Context r5 = r9.getApplicationContext()
            r10.f65976c = r5
            r10.a((android.content.Context) r9, (com.paytm.network.listener.b) r10)
            goto L_0x048a
        L_0x047f:
            net.one97.paytm.upgradeKyc.f.c$c r5 = r10.f65975b
            if (r5 == 0) goto L_0x048a
            net.one97.paytm.upgradeKyc.f.c$c r5 = r10.f65975b
            java.lang.String r10 = r10.f65974a
            r5.onPanRecieved(r10)
        L_0x048a:
            android.widget.RadioGroup r10 = r9.x
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$_sVXYtoyxzx3iE9nlX4zjWjlRq0 r5 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$_sVXYtoyxzx3iE9nlX4zjWjlRq0
            r5.<init>()
            r10.setOnCheckedChangeListener(r5)
            int r10 = net.one97.paytm.upgradeKyc.R.id.cersai_form60_lyt
            android.view.View r10 = r9.findViewById(r10)
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.X = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.layout_kyc_have_applied_pan
            android.view.View r10 = r9.findViewById(r10)
            android.widget.RadioGroup r10 = (android.widget.RadioGroup) r10
            r9.y = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.pan_ack_date_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.t = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.pan_ack_num_et
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = (com.google.android.material.textfield.TextInputEditText) r10
            r9.u = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.pan_ack_date_til
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.P = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.pan_ack_num_til
            android.view.View r10 = r9.findViewById(r10)
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r9.O = r10
            int r10 = net.one97.paytm.upgradeKyc.R.id.have_applied_pan_tv
            r9.findViewById(r10)
            com.google.android.material.textfield.TextInputEditText r10 = r9.u
            android.text.InputFilter[] r4 = new android.text.InputFilter[r4]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r7)
            r4[r0] = r5
            android.text.InputFilter$AllCaps r5 = new android.text.InputFilter$AllCaps
            r5.<init>()
            r4[r2] = r5
            r10.setFilters(r4)
            com.google.android.material.textfield.TextInputEditText r10 = r9.u
            android.text.TextWatcher r4 = r9.at
            r10.addTextChangedListener(r4)
            com.google.android.material.textfield.TextInputEditText r10 = r9.t
            android.text.TextWatcher r4 = r9.f65252a
            r10.addTextChangedListener(r4)
            com.google.android.material.textfield.TextInputEditText r10 = r9.t
            r10.setOnFocusChangeListener(r9)
            com.google.android.material.textfield.TextInputEditText r10 = r9.t
            r10.setOnClickListener(r9)
            android.widget.RadioGroup r10 = r9.y
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$ULqLUwIhw4CZez6mdIrSrspTdDY r4 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$ULqLUwIhw4CZez6mdIrSrspTdDY
            r4.<init>()
            r10.setOnCheckedChangeListener(r4)
            com.google.android.material.textfield.TextInputEditText r10 = r9.n
            android.text.InputFilter[] r4 = new android.text.InputFilter[r2]
            android.text.InputFilter$LengthFilter r5 = new android.text.InputFilter$LengthFilter
            r5.<init>(r3)
            r4[r0] = r5
            r10.setFilters(r4)
            com.google.android.material.textfield.TextInputEditText r10 = r9.o
            android.text.InputFilter[] r2 = new android.text.InputFilter[r2]
            android.text.InputFilter$LengthFilter r4 = new android.text.InputFilter$LengthFilter
            r4.<init>(r3)
            r2[r0] = r4
            r10.setFilters(r2)
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_again_doubt_tv
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            android.content.res.Resources r0 = r9.getResources()
            int r2 = net.one97.paytm.upgradeKyc.R.color.color_00b9f5
            int r0 = r0.getColor(r2)
            r10.setTextColor(r0)
            int r0 = net.one97.paytm.upgradeKyc.R.string.why_am_i_being_asked_text
            java.lang.String r0 = r9.getString(r0)
            r10.setText(r0)
            net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$vsGgdcyZgRUghyyKYbbkBkfIueo r0 = new net.one97.paytm.upgradeKyc.activity.-$$Lambda$CompleteProfileAadhaarActivity$vsGgdcyZgRUghyyKYbbkBkfIueo
            r0.<init>()
            r10.setOnClickListener(r0)
            int r10 = net.one97.paytm.upgradeKyc.R.id.kyc_again_know_more_tv
            android.view.View r10 = r9.findViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            r10.setVisibility(r3)
            net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails$KycResponse r10 = r9.ai
            if (r10 != 0) goto L_0x0643
            net.one97.paytm.upgradeKyc.helper.d$a r10 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r10 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            r0 = 0
            if (r10 == 0) goto L_0x0572
            net.one97.paytm.upgradeKyc.helper.d$a r10 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r10 = "fetchEkycData"
            java.lang.String r10 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r10)
            goto L_0x0573
        L_0x0572:
            r10 = r0
        L_0x0573:
            boolean r2 = android.webkit.URLUtil.isValidUrl(r10)
            if (r2 == 0) goto L_0x0633
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r10)
            java.lang.String r10 = "?event_type=EKYCOTP"
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            java.lang.String r10 = com.paytm.utility.b.e((android.content.Context) r9, (java.lang.String) r10)
            java.lang.String r2 = com.paytm.utility.b.e()
            java.lang.String r3 = com.paytm.utility.b.f()
            net.one97.paytm.upgradeKyc.helper.e$a r4 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ Exception -> 0x05b9 }
            net.one97.paytm.upgradeKyc.helper.f r4 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ Exception -> 0x05b9 }
            java.lang.String r4 = r4.c()     // Catch:{ Exception -> 0x05b9 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x05b9 }
            r5.<init>()     // Catch:{ Exception -> 0x05b9 }
            r5.append(r2)     // Catch:{ Exception -> 0x05b9 }
            r6 = 58
            r5.append(r6)     // Catch:{ Exception -> 0x05b9 }
            r5.append(r3)     // Catch:{ Exception -> 0x05b9 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x05b9 }
            java.lang.String r0 = net.one97.paytm.common.utility.f.a(r4, r5)     // Catch:{ Exception -> 0x05b9 }
            goto L_0x05bd
        L_0x05b9:
            r4 = move-exception
            r4.printStackTrace()
        L_0x05bd:
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.lang.String r5 = com.paytm.utility.a.q(r9)
            java.lang.String r6 = "session_token"
            r4.put(r6, r5)
            java.lang.String r5 = "x-keyiv"
            r4.put(r5, r0)
            net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails r0 = new net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails
            r0.<init>()
            r0.setIv(r3)
            r0.setKey(r2)
            java.lang.String r2 = r9.ac
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x05e8
            java.lang.String r2 = r9.ac
            r4.put(r1, r2)
        L_0x05e8:
            boolean r1 = com.paytm.utility.b.c((android.content.Context) r9)
            if (r1 == 0) goto L_0x0623
            int r1 = net.one97.paytm.upgradeKyc.R.string.please_wait
            java.lang.String r1 = r9.getString(r1)
            com.paytm.utility.b.k(r9, r1)
            net.one97.paytm.upgradeKyc.helper.a$a r1 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            com.paytm.network.b r1 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
            r1.f42877a = r9
            com.paytm.network.a$a r2 = com.paytm.network.a.C0715a.GET
            r1.f42879c = r2
            r1.f42882f = r4
            r1.f42885i = r0
            r1.f42880d = r10
            com.paytm.network.a$b r10 = com.paytm.network.a.b.USER_FACING
            r1.n = r10
            com.paytm.network.a$c r10 = com.paytm.network.a.c.KYC
            r1.f42878b = r10
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity> r10 = net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity.class
            java.lang.String r10 = r10.getName()
            r1.o = r10
            r1.j = r9
            com.paytm.network.a r10 = r1.l()
            r10.a()
            goto L_0x0646
        L_0x0623:
            int r10 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r10 = r9.getString(r10)
            int r0 = net.one97.paytm.upgradeKyc.R.string.msg_invalid_url
            java.lang.String r0 = r9.getString(r0)
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r0)
            goto L_0x0646
        L_0x0633:
            int r10 = net.one97.paytm.upgradeKyc.R.string.error
            java.lang.String r10 = r9.getString(r10)
            int r0 = net.one97.paytm.upgradeKyc.R.string.msg_invalid_url
            java.lang.String r0 = r9.getString(r0)
            com.paytm.utility.b.b((android.content.Context) r9, (java.lang.String) r10, (java.lang.String) r0)
            goto L_0x0646
        L_0x0643:
            r9.d()
        L_0x0646:
            r9.f()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity.onCreate(android.os.Bundle):void");
    }

    private void d() {
        if (this.ai != null) {
            this.Y.setVisibility(0);
            if (!TextUtils.isEmpty(this.ai.getName())) {
                this.S.setText(this.ai.getName());
            } else {
                this.S.setText("-");
            }
            if (!TextUtils.isEmpty(this.ai.getDob())) {
                this.T.setText(this.ai.getDob());
            } else {
                this.T.setText("-");
            }
            String gender = this.ai.getGender();
            if (!TextUtils.isEmpty(gender)) {
                if (gender.equalsIgnoreCase("m")) {
                    this.U.setText(getString(R.string.cersai_male));
                } else if (gender.equalsIgnoreCase("f")) {
                    this.U.setText(getString(R.string.cersai_female));
                } else if (gender.equalsIgnoreCase("t")) {
                    this.U.setText(getString(R.string.cersai_trans));
                }
            }
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.ai.getCo())) {
                sb.append(this.ai.getCo());
                sb.append(StringUtility.NEW_LINE);
            }
            if (!TextUtils.isEmpty(this.ai.getHouse())) {
                sb.append(this.ai.getHouse());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(this.ai.getLocation())) {
                sb.append(this.ai.getLocation());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(this.ai.getStreet())) {
                sb.append(this.ai.getStreet());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(this.ai.getLandMark())) {
                sb.append(this.ai.getLandMark());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(this.ai.getDistrict())) {
                sb.append(this.ai.getDistrict());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(this.ai.getPostOffice())) {
                sb.append(this.ai.getPostOffice());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(this.ai.getState())) {
                sb.append(this.ai.getState());
                sb.append(" ");
            }
            if (!TextUtils.isEmpty(this.ai.getPostalCode())) {
                sb.append(this.ai.getPostalCode());
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                this.F.setVisibility(0);
                this.aj.setText(sb.toString());
            }
            if (!TextUtils.isEmpty(this.ai.getPhoto())) {
                byte[] decode = Base64.decode(this.ai.getPhoto(), 0);
                this.V.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                return;
            }
            return;
        }
        this.Y.setVisibility(8);
        this.aj.setVisibility(8);
        this.F.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.yes) {
            if (this.ak) {
                b("yes_radio_button_selected", "/kyc/video_kyc/confirm_details");
            }
            this.f65258h.setVisibility(8);
            return;
        }
        if (this.ak) {
            b("no_radio_button_selected", "/kyc/video_kyc/confirm_details");
        }
        this.f65258h.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        this.D.setVisibility(8);
        if (!this.ak) {
            return;
        }
        if (view.getId() == R.id.married) {
            b("married_radio_button_selected", "/kyc/video_kyc/confirm_details");
        } else if (view.getId() == R.id.unmarried) {
            b("unmarried_radio_button_selected", "/kyc/video_kyc/confirm_details");
        } else if (view.getId() == R.id.other) {
            b("others_radio_button_selected", "/kyc/video_kyc/confirm_details");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.G.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CompoundButton compoundButton, boolean z2) {
        if (this.ak && z2) {
            b("checkbox_selected", "/kyc/video_kyc/confirm_details");
        }
        this.H.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.ak) {
            b("info_link_clicked", "/kyc/video_kyc/confirm_details");
        }
        i a2 = i.a("cersaiPageFooter");
        a2.show(getSupportFragmentManager(), a2.getTag());
    }

    /* access modifiers changed from: private */
    public void e() {
        ArrayList<TncData> arrayList = this.f65255e;
        if (arrayList != null && arrayList.size() > 0) {
            m a2 = m.a(this.f65255e);
            a2.f65713a = $$Lambda$CompleteProfileAadhaarActivity$4s0tW2OuEUw56UMrFEvXktV48L0.INSTANCE;
            q a3 = getSupportFragmentManager().a();
            a3.a((Fragment) a2, "KycTNCFragment");
            a3.c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.no_have_pan) {
            this.L.setVisibility(8);
            String h2 = j.h(getApplicationContext());
            if (TextUtils.isEmpty(h2) || !h2.equalsIgnoreCase("true")) {
                this.E.setVisibility(0);
                this.M.setVisibility(0);
                this.N.setVisibility(0);
                this.X.setVisibility(0);
                this.ah.setVisibility(0);
                String string = getString(R.string.tnc_form60);
                String format = String.format(string, new Object[]{" <a style=\"text-decoration:none\" href=https://www.google.com\">" + getString(R.string.kyc_terms_and_conditions) + "</a> "});
                TextView textView = this.ah;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(Html.fromHtml(format));
                textView.setLinkTextColor(androidx.core.content.b.c(this, R.color.paytm_blue));
                textView.setText(spannableStringBuilder);
                textView.setMovementMethod(new f() {
                    public final void a(String str) {
                        boolean unused = CompleteProfileAadhaarActivity.this.f65257g = false;
                        if (CompleteProfileAadhaarActivity.this.f65255e != null) {
                            CompleteProfileAadhaarActivity.this.e();
                            return;
                        }
                        boolean unused2 = CompleteProfileAadhaarActivity.this.f65256f = true;
                        CompleteProfileAadhaarActivity.this.f();
                    }
                });
            }
        } else if (i2 == R.id.yes_have_pan) {
            this.E.setVisibility(8);
            this.L.setVisibility(0);
            this.M.setVisibility(8);
            this.N.setVisibility(8);
            this.X.setVisibility(8);
            this.ah.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        String str;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            str = net.one97.paytm.upgradeKyc.helper.d.a("form60fetchTnc");
        } else {
            str = null;
        }
        if (URLUtil.isValidUrl(str)) {
            String e2 = com.paytm.utility.b.e((Context) this, str);
            a.C1317a aVar3 = a.f66022a;
            Map<String, String> a2 = a.C1317a.a(this);
            if (com.paytm.utility.b.c((Context) this)) {
                com.paytm.utility.b.k(this, getString(R.string.please_wait));
                a.C1317a aVar4 = a.f66022a;
                com.paytm.network.b a3 = a.C1317a.a();
                a3.f42877a = this;
                a3.f42879c = a.C0715a.GET;
                a3.f42882f = a2;
                a3.f42885i = new KYCFetchTnc();
                a3.f42880d = e2;
                a3.o = DigilockerActivity.class.getName();
                a3.n = a.b.SILENT;
                a3.j = this;
                a3.l().a();
                return;
            }
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.no_internet));
            return;
        }
        com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
    }

    private void g() {
        Class<CompleteProfileAadhaarActivity> cls = CompleteProfileAadhaarActivity.class;
        if (this.f65255e == null) {
            f();
            return;
        }
        this.f65257g = false;
        String str = null;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            str = net.one97.paytm.upgradeKyc.helper.d.a("kyc_tnc_user_url");
        }
        if (!URLUtil.isValidUrl(str)) {
            com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.msg_invalid_url));
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", "clickthrough");
            getSystemService(ContactColumn.PHONE_NUMBER);
            jSONObject.put("deviceId", com.paytm.utility.b.e((Context) this));
            if (this.f65255e != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<TncData> it2 = this.f65255e.iterator();
                while (it2.hasNext()) {
                    TncData next = it2.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("code", next.getCode());
                        jSONObject2.put("version", next.getVersion());
                        jSONArray.put(jSONObject2);
                    }
                }
                jSONObject.put("tnCList", jSONArray);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        String jSONObject3 = jSONObject.toString();
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        Map<String, String> a2 = a.C1317a.a(this);
        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a3 = a.C1317a.a();
        e.a aVar5 = e.f66028b;
        a3.f42877a = e.a.b().a();
        a3.f42879c = a.C0715a.PUT;
        a3.f42882f = a2;
        a3.f42885i = new KYCTncAccept();
        a3.o = cls.getName();
        a3.f42884h = jSONObject3;
        a3.f42880d = str;
        a3.n = a.b.USER_FACING;
        a3.o = cls.getName();
        a3.f42878b = a.c.KYC;
        a3.j = this;
        com.paytm.network.a l2 = a3.l();
        if (com.paytm.utility.b.c((Context) this)) {
            com.paytm.utility.b.k(this, getString(R.string.please_wait));
            l2.a();
            return;
        }
        com.paytm.utility.b.b((Context) this, getString(R.string.error), getString(R.string.no_internet));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(RadioGroup radioGroup, int i2) {
        if (i2 == R.id.no_have_applied_pan) {
            this.P.setVisibility(8);
            this.O.setVisibility(8);
        } else if (i2 == R.id.yes_have_applied_pan) {
            this.P.setVisibility(0);
            this.O.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.aa = true;
            this.m.setText(str);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.activity_complete_profile_aadhaar_btn_save) {
            if (this.ak) {
                b("proceed_button_clicked", "/kyc/video_kyc/confirm_details");
            }
            boolean z2 = false;
            if (this.f65254d.getCheckedRadioButtonId() == -1) {
                this.D.setVisibility(0);
                this.D.setText(R.string.error_marital_status);
                a((View) this.D);
            } else {
                if (this.ak) {
                    if (TextUtils.isEmpty(this.aq)) {
                        this.ae.setError(getString(R.string.error_profession));
                    } else if (TextUtils.isEmpty(this.ar)) {
                        this.af.setError(getString(R.string.error_sub_profession));
                    } else if (TextUtils.isEmpty(this.as)) {
                        this.ag.setError(getString(R.string.error_annual_income));
                    }
                } else if (TextUtils.isEmpty(this.aq)) {
                    this.ae.setError(getString(R.string.error_profession));
                }
                if (TextUtils.isEmpty(this.p.getText())) {
                    this.I.setError(getString(R.string.first_name));
                    a((View) this.p);
                } else if (TextUtils.isEmpty(this.r.getText())) {
                    this.J.setError(getString(R.string.first_name));
                    a((View) this.r);
                } else {
                    if (!this.ak) {
                        if (this.x.getCheckedRadioButtonId() == R.id.yes_have_pan && (TextUtils.isEmpty(this.m.getText()) || !com.paytm.utility.b.V(this.m.getText().toString()))) {
                            this.L.setError(getString(R.string.error_valid_pan));
                            a((View) this.L);
                        } else if (this.x.getCheckedRadioButtonId() == R.id.no_have_pan && j.h(getApplicationContext()).equalsIgnoreCase("false")) {
                            if (TextUtils.isEmpty(this.n.getText())) {
                                this.M.setError(getString(R.string.error_valid_income));
                                a((View) this.M);
                            } else if (Integer.parseInt(this.n.getText().toString()) > 1000000000) {
                                this.M.setError(getString(R.string.error_greater_agri));
                                a((View) this.M);
                            } else if (TextUtils.isEmpty(this.o.getText())) {
                                this.N.setError(getString(R.string.error_valid_income));
                                a((View) this.N);
                            } else if (Integer.parseInt(this.o.getText().toString()) > 250000) {
                                this.N.setError(getString(R.string.error_greater_nonagri));
                                a((View) this.N);
                            }
                        }
                    }
                    if (this.v.getCheckedRadioButtonId() == R.id.no && TextUtils.isEmpty(this.j.getText()) && TextUtils.isEmpty(this.k.getText()) && TextUtils.isEmpty(this.C.getText())) {
                        this.W.setBackgroundColor(Color.parseColor("#FFFEF1"));
                        this.j.requestFocus();
                        this.Z.setVisibility(0);
                        this.Z.setText(getString(R.string.error_fill_details));
                        a((View) this.j);
                    } else if (this.v.getCheckedRadioButtonId() != R.id.no || !TextUtils.isEmpty(this.f65259i.getText())) {
                        if (this.v.getCheckedRadioButtonId() == R.id.no) {
                            if (!(this.f65259i.getText().length() >= 6 && Integer.parseInt(this.f65259i.getText().subSequence(0, 1).toString()) != 0)) {
                                this.B.setError(getString(R.string.msg_invalid_pin));
                                a((View) this.f65259i);
                            }
                        }
                        if (this.v.getCheckedRadioButtonId() == R.id.no && TextUtils.isEmpty(this.ab.getText())) {
                            this.R.setError(getString(R.string.msg_invalid_pin));
                            a((View) this.ab);
                        } else if (this.v.getCheckedRadioButtonId() == R.id.no && TextUtils.isEmpty(this.l.getText())) {
                            this.Q.setError(getString(R.string.msg_invalid_pin));
                            a((View) this.l);
                        } else if (!this.z.isChecked()) {
                            this.H.setVisibility(0);
                            this.H.setText(R.string.error_check_indian);
                            a((View) this.z);
                        } else {
                            if (this.y.getCheckedRadioButtonId() == R.id.yes_have_applied_pan) {
                                if (TextUtils.isEmpty(this.u.getText().toString())) {
                                    this.O.setError(getString(R.string.pan_ack_num_error));
                                    a((View) this.O);
                                } else {
                                    String obj = this.t.getText().toString();
                                    if (TextUtils.isEmpty(obj)) {
                                        this.P.setError(getString(R.string.pan_ack_date_error));
                                        a((View) this.P);
                                    } else if (a(obj)) {
                                        this.P.setError(getString(R.string.pan_ack_date_error));
                                        a((View) this.P);
                                    }
                                }
                            }
                            z2 = true;
                        }
                    } else {
                        this.B.setError(getString(R.string.error_pincode));
                        a((View) this.f65259i);
                    }
                }
            }
            if (z2) {
                HashMap hashMap = new HashMap();
                hashMap.put("kyc_aadhaar_otp_user_id", com.paytm.utility.b.n((Context) this));
                e.a aVar = e.f66028b;
                e.a.b().a("kyc_aadhaar_otp_submit_details_clicked", (HashMap<String, Object>) hashMap, (Context) this);
                a("/kyc/adhaar-screen", "aadhaar_submit_clicked", (HashMap<String, Object>) null, "signal");
                g();
            }
        }
        if (view.getId() == R.id.know_more_adhar_tv) {
            net.one97.paytm.upgradeKyc.d.f a2 = net.one97.paytm.upgradeKyc.d.f.a();
            a2.show(getSupportFragmentManager(), a2.getTag());
        }
        if (view.getId() == R.id.pan_ack_date_et) {
            i();
        }
        if (view.getId() == R.id.select_profession_cat || view.getId() == R.id.profession_et) {
            if (this.ak) {
                b("profession_selected", "/kyc/video_kyc/confirm_details");
            }
            b(this.ak ? "profession" : "aadhaar_profession");
        }
        if (view.getId() == R.id.select_profession_til || view.getId() == R.id.sub_profession_et) {
            if (this.ak) {
                b("sub_profession_selected", "/kyc/video_kyc/confirm_details");
            }
            if ((this.an.getText() == null || !this.an.getText().toString().isEmpty()) && this.aq != null) {
                b("Sub-Profession");
            } else {
                this.ae.setError(getString(R.string.error_profession));
            }
        }
        if (view.getId() == R.id.select_annual_inc || view.getId() == R.id.annual_income_et) {
            if (this.ak) {
                b("annual_income_selected", "/kyc/video_kyc/confirm_details");
            }
            b("Annual Income");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r3) {
        /*
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r1 = "dd/MM/yyyy"
            r0.<init>(r1)
            r1 = 0
            java.util.Date r2 = new java.util.Date     // Catch:{ ParseException -> 0x001c }
            r2.<init>()     // Catch:{ ParseException -> 0x001c }
            java.lang.String r2 = r0.format(r2)     // Catch:{ ParseException -> 0x001c }
            java.util.Date r2 = r0.parse(r2)     // Catch:{ ParseException -> 0x001c }
            java.util.Date r1 = r0.parse(r3)     // Catch:{ ParseException -> 0x001a }
            goto L_0x0021
        L_0x001a:
            r3 = move-exception
            goto L_0x001e
        L_0x001c:
            r3 = move-exception
            r2 = r1
        L_0x001e:
            r3.printStackTrace()
        L_0x0021:
            if (r1 == 0) goto L_0x002b
            boolean r3 = r1.after(r2)
            if (r3 == 0) goto L_0x002b
            r3 = 1
            return r3
        L_0x002b:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity.a(java.lang.String):boolean");
    }

    public final void a(int i2, int i3, int i4) {
        com.paytm.utility.q.d("Selected Date is" + i2 + " " + i3 + " " + i4);
        this.ad = Calendar.getInstance();
        this.ad.set(5, i2);
        this.ad.set(2, i3 + -1);
        this.ad.set(1, i4);
        TextInputEditText textInputEditText = this.t;
        textInputEditText.setText(String.format("%02d", new Object[]{Integer.valueOf(i2)}) + "/" + String.format("%02d", new Object[]{Integer.valueOf(i3)}) + "/" + i4);
    }

    private void a(View view) {
        Point point = new Point();
        a(this.A, view.getParent(), view, point);
        this.A.smoothScrollTo(0, point.y);
    }

    private static void a(ViewGroup viewGroup, ViewParent viewParent, View view, Point point) {
        while (true) {
            ViewGroup viewGroup2 = (ViewGroup) viewParent;
            point.x += view.getLeft();
            point.y += view.getTop();
            if (!viewGroup2.equals(viewGroup)) {
                view = viewGroup2;
                viewParent = viewGroup2.getParent();
            } else {
                return;
            }
        }
    }

    private void i() {
        net.one97.paytm.upgradeKyc.utils.d dVar;
        if (TextUtils.isEmpty(this.t.getText().toString())) {
            dVar = net.one97.paytm.upgradeKyc.utils.d.a();
        } else {
            String[] split = this.t.getText().toString().split("/");
            int parseInt = Integer.parseInt(split[2]);
            dVar = net.one97.paytm.upgradeKyc.utils.d.a(Integer.parseInt(split[0]), Integer.parseInt(split[1]), parseInt);
        }
        dVar.show(getSupportFragmentManager(), "DatePicker");
        dVar.f66323f = this;
    }

    public void onFocusChange(View view, boolean z2) {
        if (view == this.t && z2) {
            i();
        }
    }

    public final int a() {
        return R.layout.activity_complete_profile_aadhaarv2;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        KycAadharEkycDetails kycAadharEkycDetails;
        if (iJRPaytmDataModel == null) {
            return;
        }
        if (iJRPaytmDataModel instanceof UADPincode) {
            com.paytm.utility.b.p();
            UADPincode uADPincode = (UADPincode) iJRPaytmDataModel;
            if (uADPincode.getResponseCode() != null && uADPincode.getResponseCode().equals("200")) {
                if (uADPincode.getPincodeMap() != null) {
                    Map<String, List<UADPincode.SubPincode>> pincodeMap = uADPincode.getPincodeMap();
                    Iterator<String> it2 = pincodeMap.keySet().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        String next = it2.next();
                        PrintStream printStream = System.out;
                        printStream.println(next + ": " + pincodeMap.get(next));
                        List list = pincodeMap.get(next);
                        if (list != null) {
                            this.ab.setText(((UADPincode.SubPincode) list.get(0)).getTier3Value());
                            this.l.setText(((UADPincode.SubPincode) list.get(0)).getState());
                            break;
                        }
                    }
                } else {
                    this.B.setErrorEnabled(true);
                    this.B.setError(getString(R.string.msg_invalid_pin));
                }
            }
            this.B.setError("");
            this.B.setErrorEnabled(false);
        } else if (iJRPaytmDataModel instanceof EkycDataResponse) {
            com.paytm.utility.b.p();
            EkycDataResponse ekycDataResponse = (EkycDataResponse) iJRPaytmDataModel;
            if (ekycDataResponse.getStatusCode() == 201 || ekycDataResponse.getStatusCode() == 202 || ekycDataResponse.getStatusCode() == 203) {
                if (this.ak) {
                    j.c((Context) this, true);
                    e.a aVar = e.f66028b;
                    if (!j.e(e.a.a().f66030a.a())) {
                        startActivity(new Intent(this, AddPanVideoKycActivity.class));
                        finish();
                        return;
                    }
                    startActivity(new Intent(this, VideoKycActivity.class));
                    finish();
                    return;
                }
                Intent intent = new Intent(this, InPersonVerification.class);
                intent.putExtra("ekyc_complete", true);
                startActivity(intent);
                finish();
            } else if (!TextUtils.isEmpty(ekycDataResponse.getMessage())) {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), ekycDataResponse.getMessage());
            } else if (!TextUtils.isEmpty(ekycDataResponse.getSuccessMsg())) {
                com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), ekycDataResponse.getSuccessMsg());
            }
        } else if (iJRPaytmDataModel instanceof KYCFetchTnc) {
            com.paytm.utility.b.p();
            KYCFetchTnc kYCFetchTnc = (KYCFetchTnc) iJRPaytmDataModel;
            if (kYCFetchTnc.getStatus() == null || !kYCFetchTnc.getStatus().equalsIgnoreCase("error")) {
                if (kYCFetchTnc.getStatus() != null && kYCFetchTnc.getStatus().equalsIgnoreCase("success") && kYCFetchTnc.getTncDataList() != null) {
                    this.f65255e = kYCFetchTnc.getTncDataList();
                    if (this.f65256f) {
                        e();
                    }
                }
            } else if (!TextUtils.isEmpty(kYCFetchTnc.getMessage())) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), kYCFetchTnc.getMessage());
            }
        } else if (iJRPaytmDataModel instanceof KYCTncAccept) {
            KYCTncAccept kYCTncAccept = (KYCTncAccept) iJRPaytmDataModel;
            if (kYCTncAccept.getStatus() == null || !kYCTncAccept.getStatus().equalsIgnoreCase("error")) {
                if (kYCTncAccept.getStatus() != null && kYCTncAccept.getStatus().equalsIgnoreCase("success") && kYCTncAccept.getResponseCode().equals("2004")) {
                    String str = null;
                    d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                    if (d.a.a() != null) {
                        d.a aVar3 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
                        d.a.a();
                        str = net.one97.paytm.upgradeKyc.helper.d.a("saveEkycData");
                    }
                    if (!URLUtil.isValidUrl(str)) {
                        com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.msg_invalid_url));
                        return;
                    }
                    String e2 = com.paytm.utility.b.e((Context) this, str);
                    JSONObject h2 = h();
                    if (h2 != null) {
                        String jSONObject = h2.toString();
                        HashMap hashMap = new HashMap();
                        hashMap.put("session_token", com.paytm.utility.a.q(this));
                        hashMap.put("Content-Type", "application/json");
                        a.C1317a aVar4 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                        com.paytm.network.b a2 = a.C1317a.a();
                        a2.f42877a = this;
                        a2.f42879c = a.C0715a.POST;
                        a2.f42882f = hashMap;
                        a2.f42885i = new EkycDataResponse();
                        a2.f42880d = e2;
                        a2.f42884h = jSONObject;
                        a2.n = a.b.USER_FACING;
                        a2.f42878b = a.c.KYC;
                        a2.o = CompleteProfileAadhaarActivity.class.getName();
                        a2.j = this;
                        com.paytm.network.a l2 = a2.l();
                        if (com.paytm.utility.b.c((Context) this)) {
                            l2.a();
                        } else {
                            com.paytm.utility.b.b((Context) this, getResources().getString(R.string.error), getResources().getString(R.string.no_internet));
                        }
                    }
                }
            } else if (!TextUtils.isEmpty(kYCTncAccept.getMessage())) {
                com.paytm.utility.b.b((Context) this, getString(R.string.error), kYCTncAccept.getMessage());
            }
        } else if ((iJRPaytmDataModel instanceof KycAadharEkycDetails) && (kycAadharEkycDetails = (KycAadharEkycDetails) iJRPaytmDataModel) != null && kycAadharEkycDetails.getStatusCode() != null && kycAadharEkycDetails.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS) && kycAadharEkycDetails.getData() != null && kycAadharEkycDetails.getData().getKycResponse() != null) {
            this.ai = kycAadharEkycDetails.getData().getKycResponse();
            String isMinor = kycAadharEkycDetails.getData().getIsMinor();
            if (!TextUtils.isEmpty(isMinor) && (isMinor.equalsIgnoreCase("true") || isMinor.equalsIgnoreCase("false"))) {
                j.e(getApplicationContext(), isMinor);
            }
            d();
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        l.a();
        l.a((Context) this, networkCustomError);
    }

    private void b(String str) {
        Intent intent = new Intent(this, KycProfessionChooseActivity.class);
        intent.putExtra("option", str);
        if (str.equals("Sub-Profession")) {
            intent.putExtra("main_profession", this.aq);
        }
        startActivityForResult(intent, this.am);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
            r10 = this;
            super.onActivityResult(r11, r12, r13)
            int r0 = r10.am
            if (r11 != r0) goto L_0x00c6
            r11 = -1
            if (r12 != r11) goto L_0x00c6
            if (r13 == 0) goto L_0x00c6
            java.lang.String r12 = "option"
            java.lang.String r12 = r13.getStringExtra(r12)
            java.lang.String r0 = "display_text"
            java.lang.String r0 = r13.getStringExtra(r0)
            java.lang.String r1 = "api_value"
            java.lang.String r13 = r13.getStringExtra(r1)
            if (r0 == 0) goto L_0x00c6
            if (r13 == 0) goto L_0x00c6
            int r1 = r12.hashCode()
            java.lang.String r2 = "aadhaar_profession"
            java.lang.String r3 = "profession"
            java.lang.String r4 = "Annual Income"
            java.lang.String r5 = "Sub-Profession"
            r6 = 3
            r7 = 2
            r8 = 1
            r9 = 0
            switch(r1) {
                case -1985098007: goto L_0x004e;
                case -1645073654: goto L_0x0046;
                case -1210261252: goto L_0x003e;
                case 71784621: goto L_0x0036;
                default: goto L_0x0035;
            }
        L_0x0035:
            goto L_0x0056
        L_0x0036:
            boolean r1 = r12.equals(r2)
            if (r1 == 0) goto L_0x0056
            r1 = 1
            goto L_0x0057
        L_0x003e:
            boolean r1 = r12.equals(r3)
            if (r1 == 0) goto L_0x0056
            r1 = 0
            goto L_0x0057
        L_0x0046:
            boolean r1 = r12.equals(r4)
            if (r1 == 0) goto L_0x0056
            r1 = 3
            goto L_0x0057
        L_0x004e:
            boolean r1 = r12.equals(r5)
            if (r1 == 0) goto L_0x0056
            r1 = 2
            goto L_0x0057
        L_0x0056:
            r1 = -1
        L_0x0057:
            if (r1 == 0) goto L_0x0070
            if (r1 == r8) goto L_0x0070
            if (r1 == r7) goto L_0x0068
            if (r1 == r6) goto L_0x0060
            goto L_0x0085
        L_0x0060:
            android.widget.EditText r1 = r10.ap
            r1.setText(r0)
            r10.as = r13
            goto L_0x0085
        L_0x0068:
            android.widget.EditText r1 = r10.ao
            r1.setText(r0)
            r10.ar = r13
            goto L_0x0085
        L_0x0070:
            android.widget.EditText r1 = r10.an
            r1.setText(r0)
            android.widget.EditText r0 = r10.ao
            int r1 = net.one97.paytm.upgradeKyc.R.string.kyc_select_sub_profession
            java.lang.String r1 = r10.getString(r1)
            r0.setText(r1)
            r10.aq = r13
            r13 = 0
            r10.ar = r13
        L_0x0085:
            int r13 = r12.hashCode()
            switch(r13) {
                case -1985098007: goto L_0x00a5;
                case -1645073654: goto L_0x009d;
                case -1210261252: goto L_0x0095;
                case 71784621: goto L_0x008d;
                default: goto L_0x008c;
            }
        L_0x008c:
            goto L_0x00ac
        L_0x008d:
            boolean r12 = r12.equals(r2)
            if (r12 == 0) goto L_0x00ac
            r11 = 1
            goto L_0x00ac
        L_0x0095:
            boolean r12 = r12.equals(r3)
            if (r12 == 0) goto L_0x00ac
            r11 = 0
            goto L_0x00ac
        L_0x009d:
            boolean r12 = r12.equals(r4)
            if (r12 == 0) goto L_0x00ac
            r11 = 3
            goto L_0x00ac
        L_0x00a5:
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L_0x00ac
            r11 = 2
        L_0x00ac:
            if (r11 == 0) goto L_0x00c1
            if (r11 == r8) goto L_0x00c1
            if (r11 == r7) goto L_0x00bb
            if (r11 == r6) goto L_0x00b5
            goto L_0x00c6
        L_0x00b5:
            com.google.android.material.textfield.TextInputLayout r11 = r10.ag
            r11.setErrorEnabled(r9)
            goto L_0x00c6
        L_0x00bb:
            com.google.android.material.textfield.TextInputLayout r11 = r10.af
            r11.setErrorEnabled(r9)
            return
        L_0x00c1:
            com.google.android.material.textfield.TextInputLayout r11 = r10.ae
            r11.setErrorEnabled(r9)
        L_0x00c6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.CompleteProfileAadhaarActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void c() {
        super.c();
        if (this.ak) {
            b("go_back_clicked", "/kyc/video_kyc/confirm_details");
        }
    }

    private JSONObject h() {
        String str;
        EkycData ekycData = new EkycData();
        if (this.f65254d.getCheckedRadioButtonId() == R.id.married) {
            str = "married";
        } else if (this.f65254d.getCheckedRadioButtonId() == R.id.unmarried) {
            str = "unmarried";
        } else {
            str = this.f65254d.getCheckedRadioButtonId() == R.id.other ? "others" : "";
        }
        if (!TextUtils.isEmpty(str)) {
            ekycData.setMaritalStatus(str);
        }
        ekycData.setProfession(this.aq);
        if (this.ak) {
            ekycData.setSubProfession(this.ar);
            ekycData.setAnnualIncome(this.as);
        }
        String obj = this.p.getText().toString();
        String obj2 = this.q.getText().toString();
        String obj3 = this.r.getText().toString();
        String obj4 = this.s.getText().toString();
        ekycData.setFatherFirstName(obj);
        ekycData.setFatherLastName(obj2);
        ekycData.setMotherFirstName(obj3);
        ekycData.setMotherLastName(obj4);
        ekycData.setFather(true);
        if (!this.ak) {
            if (this.x.getCheckedRadioButtonId() == R.id.yes_have_pan) {
                if (!this.aa) {
                    ekycData.setPanNumber(this.m.getText().toString());
                }
            } else if (this.x.getCheckedRadioButtonId() == R.id.no_have_pan && j.h(getApplicationContext()).equalsIgnoreCase("false")) {
                ekycData.setAgriIncome(Integer.parseInt(this.n.getText().toString()));
                ekycData.setNonAgriIncome(Integer.parseInt(this.o.getText().toString()));
            }
        }
        if (this.v.getCheckedRadioButtonId() == R.id.no) {
            ekycData.setCorrespondanceAddressSameAsAadhar(false);
            String obj5 = this.j.getText().toString();
            String obj6 = this.k.getText().toString();
            String obj7 = this.C.getText().toString();
            String obj8 = this.f65259i.getText().toString();
            String obj9 = this.ab.getText().toString();
            String obj10 = this.l.getText().toString();
            ekycData.setHouse(obj5);
            ekycData.setLocality(obj7);
            ekycData.setStreetName(obj6);
            ekycData.setPincode(obj8);
            ekycData.setCity(obj9);
            ekycData.setState(obj10);
            if (this.w.getCheckedRadioButtonId() == R.id.residential) {
                ekycData.setAddressType("residential");
            } else if (this.w.getCheckedRadioButtonId() == R.id.profession_business) {
                ekycData.setAddressType("business");
            }
        } else {
            ekycData.setCorrespondanceAddressSameAsAadhar(true);
        }
        if (!this.ak && this.y.getCheckedRadioButtonId() == R.id.yes_have_applied_pan) {
            String obj11 = this.t.getText().toString();
            if (!TextUtils.isEmpty(obj11)) {
                ekycData.setPanAckDate(obj11);
            }
            String obj12 = this.u.getText().toString();
            if (!TextUtils.isEmpty(obj12)) {
                ekycData.setPanAckNumber(obj12);
            }
        }
        ekycData.setFatcaDeclaration(this.z.isChecked());
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.ac)) {
                jSONObject.put("uuid", this.ac);
            }
            if (!TextUtils.isEmpty(ekycData.getMaritalStatus())) {
                jSONObject.put("maritalStatus", ekycData.getMaritalStatus());
            }
            if (this.ak) {
                jSONObject.put("professionCategory", ekycData.getProfession());
                jSONObject.put("profession", ekycData.getSubProfession());
                jSONObject.put("annualIncome", ekycData.getAnnualIncome());
            } else if (!TextUtils.isEmpty(ekycData.getProfession())) {
                jSONObject.put("profession", ekycData.getProfession());
            }
            if (this.ak || this.x.getCheckedRadioButtonId() != R.id.yes_have_pan || this.aa) {
                if (!this.ak && this.x.getCheckedRadioButtonId() == R.id.no_have_pan && j.h(getApplicationContext()).equalsIgnoreCase("false")) {
                    jSONObject.put("agriIncome", ekycData.getAgriIncome());
                    jSONObject.put("nonAgriIncome", ekycData.getNonAgriIncome());
                }
            } else if (!TextUtils.isEmpty(ekycData.getPanNumber())) {
                jSONObject.put("pan", ekycData.getPanNumber());
            }
            if (!TextUtils.isEmpty(ekycData.getMotherFirstName())) {
                jSONObject.put("motherFirstName", ekycData.getMotherFirstName());
            }
            if (!TextUtils.isEmpty(ekycData.getMotherLastName())) {
                jSONObject.put("motherLastName", ekycData.getMotherLastName());
            }
            if (!TextUtils.isEmpty(ekycData.getFatherFirstName())) {
                jSONObject.put("fatherFirstName", ekycData.getFatherFirstName());
            }
            if (!TextUtils.isEmpty(ekycData.getFatherLastName())) {
                jSONObject.put("fatherLastName", ekycData.getFatherLastName());
            }
            if (!TextUtils.isEmpty(ekycData.getHouse())) {
                jSONObject.put("house", ekycData.getHouse());
            }
            if (!TextUtils.isEmpty(ekycData.getStreetName())) {
                jSONObject.put("streetName", ekycData.getStreetName());
            }
            if (!TextUtils.isEmpty(ekycData.getLocality())) {
                jSONObject.put("locality", ekycData.getLocality());
            }
            if (!TextUtils.isEmpty(ekycData.getPincode())) {
                jSONObject.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, ekycData.getPincode());
            }
            if (!TextUtils.isEmpty(ekycData.getState())) {
                jSONObject.put("state", ekycData.getState());
            }
            if (!TextUtils.isEmpty(ekycData.getCity())) {
                jSONObject.put("city", ekycData.getCity());
            }
            if (!TextUtils.isEmpty(ekycData.getAddressType())) {
                jSONObject.put("addressType", ekycData.getAddressType());
            }
            if (!this.ak && !TextUtils.isEmpty(ekycData.getPanAckNumber())) {
                jSONObject.put("panAckNumber", ekycData.getPanAckNumber());
            }
            if (!this.ak && !TextUtils.isEmpty(ekycData.getPanAckDate())) {
                jSONObject.put("panAckDate", ekycData.getPanAckDate());
            }
            jSONObject.put("fatcaDeclaration", ekycData.isFatcaDeclaration());
            jSONObject.put("isCorrespondanceAddressSameAsAadhar", ekycData.isCorrespondanceAddressSameAsAadhar());
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    static /* synthetic */ void a(CompleteProfileAadhaarActivity completeProfileAadhaarActivity, String str) {
        String str2;
        String str3;
        d.a aVar = net.one97.paytm.upgradeKyc.helper.d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = net.one97.paytm.upgradeKyc.helper.d.f66026a;
            d.a.a();
            str2 = net.one97.paytm.upgradeKyc.helper.d.a("uadPincode");
        } else {
            str2 = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("session_token", com.paytm.utility.a.q(completeProfileAadhaarActivity));
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(str);
            jSONObject.put("pincodes", jSONArray);
            jSONObject.put("addressResponseType", "SECONDARY");
            jSONObject.put("tier3Type", "UNIQUE");
            str3 = jSONObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = "";
        }
        UADPincode uADPincode = new UADPincode();
        uADPincode.setPincode(str);
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        a2.f42877a = completeProfileAadhaarActivity;
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = uADPincode;
        a2.f42880d = str2;
        a2.f42884h = str3;
        a2.n = a.b.USER_FACING;
        a2.f42878b = a.c.KYC;
        a2.o = CompleteProfileAadhaarActivity.class.getName();
        a2.j = completeProfileAadhaarActivity;
        com.paytm.network.a l2 = a2.l();
        if (com.paytm.utility.b.c((Context) completeProfileAadhaarActivity)) {
            com.paytm.utility.b.k(completeProfileAadhaarActivity, completeProfileAadhaarActivity.getString(R.string.please_wait));
            l2.a();
            return;
        }
        com.paytm.utility.b.b((Context) completeProfileAadhaarActivity, completeProfileAadhaarActivity.getString(R.string.error), completeProfileAadhaarActivity.getString(R.string.no_internet));
    }
}
