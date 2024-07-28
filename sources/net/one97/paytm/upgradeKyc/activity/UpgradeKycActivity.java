package net.one97.paytm.upgradeKyc.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.common.entity.auth.TncData;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.upgradeKyc.KYCDetail;
import net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3;
import net.one97.paytm.common.entity.upgradeKyc.KycLeadStatus;
import net.one97.paytm.common.entity.upgradeKyc.KycSavedUserData;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.aotp.a.a;
import net.one97.paytm.upgradeKyc.aotp.activity.EnterAadhaarDetailsActivity;
import net.one97.paytm.upgradeKyc.helper.a;
import net.one97.paytm.upgradeKyc.helper.d;
import net.one97.paytm.upgradeKyc.helper.e;
import net.one97.paytm.upgradeKyc.kycV3.activity.AppointmentBookedActivity;
import net.one97.paytm.upgradeKyc.kycV3.activity.ConsentCaptureActivity;
import net.one97.paytm.upgradeKyc.kycV3.activity.MinKycStatusActivity;
import net.one97.paytm.upgradeKyc.kycV3.activity.MinKycStatusSuccessActivity;
import net.one97.paytm.upgradeKyc.kycV3.activity.OtpKycSuccessActivity;
import net.one97.paytm.upgradeKyc.kycV3.b.a;
import net.one97.paytm.upgradeKyc.utils.c;
import net.one97.paytm.upgradeKyc.utils.j;
import net.one97.paytm.upgradeKyc.utils.l;
import net.one97.paytm.upgradeKyc.videokyc.activity.AddPanVideoKycActivity;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycActivity;
import net.one97.paytm.upgradeKyc.videokyc.activity.VideoKycStatusActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class UpgradeKycActivity extends UpgradeKycBaseActivity implements View.OnClickListener, a.C1294a {
    private boolean A;
    private TextWatcher B = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            UpgradeKycActivity.this.f65408i.setErrorEnabled(false);
            UpgradeKycActivity.this.f65408i.setError("");
            UpgradeKycActivity.this.j.setError("");
        }

        public final void afterTextChanged(Editable editable) {
            if (editable.length() > 0 && editable.length() % 5 == 0 && '-' == editable.charAt(editable.length() - 1)) {
                editable.delete(editable.length() - 1, editable.length());
            }
            if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), "-").length <= 3) {
                editable.insert(editable.length() - 1, "-");
            }
        }
    };
    private TextWatcher C = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            UpgradeKycActivity.this.f65408i.setError("");
            UpgradeKycActivity.this.j.setError("");
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f65401a = 11;

    /* renamed from: b  reason: collision with root package name */
    String f65402b = "";

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f65403d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<TncData> f65404e;

    /* renamed from: f  reason: collision with root package name */
    private CheckBox f65405f;

    /* renamed from: g  reason: collision with root package name */
    private TextInputEditText f65406g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextInputEditText f65407h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public TextInputLayout f65408i;
    /* access modifiers changed from: private */
    public TextInputLayout j;
    private TextView k;
    private ScrollView l;
    private MenuItem m;
    private LinearLayout n;
    /* access modifiers changed from: private */
    public LottieAnimationView o;
    private String p = "";
    private TextView q;
    private TextView r;
    private boolean s = false;
    private String t = "kyc";
    private String u;
    private String v;
    private String w;
    private String x = null;
    private CJRHomePageItem y;
    private ImageView z;

    public void onClick(View view) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.content.Intent] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v63 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
            r8 = this;
            super.onCreate(r9)
            net.one97.paytm.upgradeKyc.helper.d$a r9 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r9 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            r0 = 0
            r1 = 1
            if (r9 == 0) goto L_0x030c
            net.one97.paytm.upgradeKyc.helper.d$a r9 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r9 = "shouldShowPPBLWebPage"
            boolean r9 = net.one97.paytm.upgradeKyc.helper.d.a(r9, r1)
            if (r9 != 0) goto L_0x030c
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r2 = "extra_home_data"
            r3 = 0
            if (r9 == 0) goto L_0x0054
            android.content.Intent r9 = r8.getIntent()
            java.io.Serializable r9 = r9.getSerializableExtra(r2)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r9
            r8.y = r9
            android.content.Intent r9 = r8.getIntent()
            java.lang.String r4 = "isCstPriorityCustomer"
            boolean r9 = r9.getBooleanExtra(r4, r3)
            r8.A = r9
            boolean r9 = r8.A
            if (r9 == 0) goto L_0x0054
            long r4 = net.one97.paytm.upgradeKyc.utils.j.e()
            r6 = -1
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 != 0) goto L_0x0054
            long r4 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = java.lang.Long.valueOf(r4)
            net.one97.paytm.upgradeKyc.utils.j.a((java.lang.Long) r9)
        L_0x0054:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = r8.y
            java.lang.String r4 = "kyc"
            if (r9 == 0) goto L_0x0087
            java.lang.String r9 = r9.getVertical()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x006d
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = r8.y
            java.lang.String r9 = r9.getVertical()
            r8.t = r9
            goto L_0x006f
        L_0x006d:
            r8.t = r4
        L_0x006f:
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = r8.y
            java.lang.String r9 = r9.getNonAadhaar()
            r8.v = r9
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = r8.y
            java.lang.String r9 = r9.getAadhaarOtp()
            r8.u = r9
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r9 = r8.y
            java.lang.String r9 = r9.getCallBackUrl()
            r8.w = r9
        L_0x0087:
            java.lang.String r9 = r8.v
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x0093
            java.lang.String r9 = "true"
            r8.v = r9
        L_0x0093:
            java.lang.String r9 = r8.u
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x009f
            java.lang.String r9 = "false"
            r8.u = r9
        L_0x009f:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r8.f65404e = r9
            int r9 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
            android.view.View r9 = r8.findViewById(r9)
            com.airbnb.lottie.LottieAnimationView r9 = (com.airbnb.lottie.LottieAnimationView) r9
            r8.o = r9
            net.one97.paytm.upgradeKyc.helper.d$a r9 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r9 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r9 == 0) goto L_0x00c3
            net.one97.paytm.upgradeKyc.helper.d$a r9 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r9 = "min_kyc_status_v3_url"
            java.lang.String r0 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r9)
        L_0x00c3:
            java.lang.String r9 = com.paytm.utility.a.q(r8)
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0137
            boolean r9 = android.webkit.URLUtil.isValidUrl(r0)
            if (r9 == 0) goto L_0x0137
            android.content.Context r9 = r8.getApplicationContext()
            java.lang.String r9 = com.paytm.utility.b.e((android.content.Context) r9, (java.lang.String) r0)
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            android.content.Context r5 = r8.getApplicationContext()
            java.lang.String r5 = com.paytm.utility.a.q(r5)
            java.lang.String r6 = "session_token"
            r0.put(r6, r5)
            net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3 r5 = new net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3
            r5.<init>()
            net.one97.paytm.upgradeKyc.helper.a$a r6 = net.one97.paytm.upgradeKyc.helper.a.f66022a
            com.paytm.network.b r6 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()
            r6.f42877a = r8
            com.paytm.network.a$a r7 = com.paytm.network.a.C0715a.GET
            r6.f42879c = r7
            r6.f42882f = r0
            r6.f42885i = r5
            r6.f42880d = r9
            java.lang.Class<net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity> r9 = net.one97.paytm.upgradeKyc.activity.MinKycPanAadharUpgradeActivity.class
            java.lang.String r9 = r9.getName()
            r6.o = r9
            com.paytm.network.a$b r9 = com.paytm.network.a.b.USER_FACING
            r6.n = r9
            net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity$1 r9 = new net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity$1
            r9.<init>()
            r6.j = r9
            com.paytm.network.a r9 = r6.l()
            android.content.Context r0 = r8.getApplicationContext()
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x012e
            com.airbnb.lottie.LottieAnimationView r0 = r8.o
            net.one97.paytm.common.widgets.a.a(r0)
            r9.a()
            goto L_0x0137
        L_0x012e:
            int r9 = net.one97.paytm.common.assets.R.string.no_internet
            java.lang.String r9 = r8.getString(r9)
            r8.a((java.lang.String) r9)
        L_0x0137:
            int r9 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_doc_heading
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r8.q = r9
            int r9 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_using_doc
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r8.r = r9
            int r9 = net.one97.paytm.upgradeKyc.R.id.upgrade_kyc_right_arrow_iv
            android.view.View r9 = r8.findViewById(r9)
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r8.z = r9
            int r9 = net.one97.paytm.upgradeKyc.R.id.upgrade_kyc_know_more_tv
            android.view.View r9 = r8.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            int r0 = net.one97.paytm.upgradeKyc.R.id.payments_bank_info_btn_close
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r8)
            int r0 = net.one97.paytm.upgradeKyc.R.id.upgrade_kyc_lyt_parent_sv
            android.view.View r0 = r8.findViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            r8.l = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.rel_input
            android.view.View r0 = r8.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r8.n = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_lyt_et_aadhaar_no
            android.view.View r0 = r8.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            r8.f65408i = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_lyt_et_aadhaar_name
            android.view.View r0 = r8.findViewById(r0)
            com.google.android.material.textfield.TextInputLayout r0 = (com.google.android.material.textfield.TextInputLayout) r0
            r8.j = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_et_aadhaar_no
            android.view.View r0 = r8.findViewById(r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            r8.f65406g = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_et_aadhaar_name
            android.view.View r0 = r8.findViewById(r0)
            com.google.android.material.textfield.TextInputEditText r0 = (com.google.android.material.textfield.TextInputEditText) r0
            r8.f65407h = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_terms_checkbox
            android.view.View r0 = r8.findViewById(r0)
            android.widget.CheckBox r0 = (android.widget.CheckBox) r0
            r8.f65405f = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_non_kyc_layout
            android.view.View r0 = r8.findViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r8.f65403d = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.complete_kyc_heading_tv
            android.view.View r0 = r8.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r8.k = r0
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_terms_text
            r8.findViewById(r0)
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_tv_find_aadhaar
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r8)
            android.widget.LinearLayout r0 = r8.f65403d
            r5 = 8
            r0.setVisibility(r5)
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_terms_text
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r8)
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_button_proceed
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r8)
            int r0 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_using_doc
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r8)
            int r0 = net.one97.paytm.upgradeKyc.R.id.upgrade_kyc_right_arrow_iv
            android.view.View r0 = r8.findViewById(r0)
            r0.setOnClickListener(r8)
            r9.setOnClickListener(r8)
            android.widget.TextView r9 = r8.q
            r9.setOnClickListener(r8)
            com.google.android.material.textfield.TextInputEditText r9 = r8.f65407h
            r0 = 2
            android.text.InputFilter[] r0 = new android.text.InputFilter[r0]
            android.text.InputFilter$LengthFilter r6 = new android.text.InputFilter$LengthFilter
            r7 = 60
            r6.<init>(r7)
            r0[r3] = r6
            android.text.InputFilter$AllCaps r6 = new android.text.InputFilter$AllCaps
            r6.<init>()
            r0[r1] = r6
            r9.setFilters(r0)
            com.google.android.material.textfield.TextInputEditText r9 = r8.f65407h
            net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity$4 r0 = new net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity$4
            r0.<init>()
            r9.addTextChangedListener(r0)
            android.content.Intent r9 = r8.getIntent()
            boolean r0 = r9.hasExtra(r2)
            if (r0 == 0) goto L_0x0268
            java.io.Serializable r0 = r9.getSerializableExtra(r2)
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r0 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r0
            if (r0 == 0) goto L_0x0268
            java.lang.String r2 = r0.getMode()
            if (r2 == 0) goto L_0x024a
            java.lang.String r2 = r0.getMode()
            java.lang.String r6 = "non_aadhar"
            boolean r2 = r2.equalsIgnoreCase(r6)
            if (r2 == 0) goto L_0x024a
            r8.a((android.content.Intent) r9)
        L_0x024a:
            java.lang.String r9 = r0.getKyc_name()
            java.lang.String r0 = r0.getAadhar_number()
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L_0x025d
            com.google.android.material.textfield.TextInputEditText r2 = r8.f65407h
            r2.setText(r9)
        L_0x025d:
            boolean r9 = android.text.TextUtils.isEmpty(r0)
            if (r9 != 0) goto L_0x0268
            com.google.android.material.textfield.TextInputEditText r9 = r8.f65406g
            r9.setText(r0)
        L_0x0268:
            com.google.android.material.textfield.TextInputEditText r9 = r8.f65406g
            android.text.TextWatcher r0 = r8.B
            r9.addTextChangedListener(r0)
            int r9 = net.one97.paytm.upgradeKyc.R.string.kyc_i_agree_to_the
            java.lang.String r9 = r8.getString(r9)
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = " <a style=\"text-decoration:none\" href=https://www.google.com\">"
            r1.<init>(r2)
            int r2 = net.one97.paytm.upgradeKyc.R.string.kyc_terms_and_conditions
            java.lang.String r2 = r8.getString(r2)
            r1.append(r2)
            java.lang.String r2 = "</a> "
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0[r3] = r1
            java.lang.String.format(r9, r0)
            java.lang.String r9 = r8.t
            boolean r9 = r9.equalsIgnoreCase(r4)
            if (r9 == 0) goto L_0x02c1
            java.lang.String r9 = ""
            r8.setTitle(r9)
            androidx.appcompat.app.ActionBar r9 = r8.getSupportActionBar()
            if (r9 == 0) goto L_0x02b0
            androidx.appcompat.app.ActionBar r9 = r8.getSupportActionBar()
            r0 = 0
            r9.a((float) r0)
        L_0x02b0:
            android.widget.TextView r9 = r8.k
            r9.setVisibility(r3)
            net.one97.paytm.upgradeKyc.helper.e$a r9 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r9 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            java.lang.String r0 = "/kyc-wallet-upgrade"
            r9.a((java.lang.String) r0, (java.lang.String) r4, (android.content.Context) r8)
            return
        L_0x02c1:
            java.lang.String r9 = r8.t
            java.lang.String r0 = "bank"
            boolean r9 = r9.equalsIgnoreCase(r0)
            if (r9 == 0) goto L_0x0366
            androidx.appcompat.app.ActionBar r9 = r8.getSupportActionBar()
            if (r9 == 0) goto L_0x02d8
            androidx.appcompat.app.ActionBar r9 = r8.getSupportActionBar()
            r9.f()
        L_0x02d8:
            int r9 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_lyt_bank_header
            android.view.View r9 = r8.findViewById(r9)
            r9.setVisibility(r3)
            int r9 = net.one97.paytm.upgradeKyc.R.id.activity_upgrade_kyc_tv_heading
            android.view.View r9 = r8.findViewById(r9)
            r9.setVisibility(r3)
            android.widget.TextView r9 = r8.q
            r9.setVisibility(r5)
            android.widget.TextView r9 = r8.r
            r9.setVisibility(r5)
            android.widget.ImageView r9 = r8.z
            r9.setVisibility(r5)
            android.widget.TextView r9 = r8.k
            r9.setVisibility(r5)
            net.one97.paytm.upgradeKyc.helper.e$a r9 = net.one97.paytm.upgradeKyc.helper.e.f66028b
            net.one97.paytm.upgradeKyc.helper.f r9 = net.one97.paytm.upgradeKyc.helper.e.a.b()
            java.lang.String r0 = "/bank/savings-account/aadhar-details"
            java.lang.String r1 = "banksavingsaccount"
            r9.a((java.lang.String) r0, (java.lang.String) r1, (android.content.Context) r8)
            return
        L_0x030c:
            net.one97.paytm.upgradeKyc.helper.d$a r9 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d r9 = net.one97.paytm.upgradeKyc.helper.d.a.a()
            if (r9 == 0) goto L_0x0320
            net.one97.paytm.upgradeKyc.helper.d$a r9 = net.one97.paytm.upgradeKyc.helper.d.f66026a
            net.one97.paytm.upgradeKyc.helper.d.a.a()
            java.lang.String r9 = "ppblWebPageUrl"
            java.lang.String r9 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r9)
            goto L_0x0321
        L_0x0320:
            r9 = r0
        L_0x0321:
            boolean r2 = android.text.TextUtils.isEmpty(r9)
            if (r2 != 0) goto L_0x0363
            android.content.Intent r2 = new android.content.Intent     // Catch:{ ClassNotFoundException -> 0x033c }
            net.one97.paytm.upgradeKyc.helper.e$a r3 = net.one97.paytm.upgradeKyc.helper.e.f66028b     // Catch:{ ClassNotFoundException -> 0x033c }
            net.one97.paytm.upgradeKyc.helper.f r3 = net.one97.paytm.upgradeKyc.helper.e.a.b()     // Catch:{ ClassNotFoundException -> 0x033c }
            java.lang.String r3 = r3.d()     // Catch:{ ClassNotFoundException -> 0x033c }
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x033c }
            r2.<init>(r8, r3)     // Catch:{ ClassNotFoundException -> 0x033c }
            r0 = r2
            goto L_0x0340
        L_0x033c:
            r2 = move-exception
            r2.printStackTrace()
        L_0x0340:
            java.lang.String r2 = "url"
            r0.putExtra(r2, r9)
            int r9 = net.one97.paytm.upgradeKyc.R.string.link_your_aadhaar
            java.lang.String r9 = r8.getString(r9)
            java.lang.String r2 = "title"
            r0.putExtra(r2, r9)
            int r9 = net.one97.paytm.upgradeKyc.R.string.link_your_aadhaar
            java.lang.String r9 = r8.getString(r9)
            java.lang.String r2 = "From"
            r0.putExtra(r2, r9)
            java.lang.String r9 = "Close"
            r0.putExtra(r9, r1)
            r8.startActivity(r0)
        L_0x0363:
            r8.finish()
        L_0x0366:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity.onCreate(android.os.Bundle):void");
    }

    private void d() {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("session_token", com.paytm.utility.a.q(this));
        hashMap.put("version", "8.3.2");
        hashMap.put("deviceidentifier", b.A((Context) this));
        hashMap.put("channel", "androidapp");
        d.a aVar = d.f66026a;
        if (d.a.a() != null) {
            d.a aVar2 = d.f66026a;
            d.a.a();
            str = d.a("leadStatusFetchRequest");
        } else {
            str = null;
        }
        if (!URLUtil.isValidUrl(str)) {
            a(getString(R.string.msg_invalid_url));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("solutionType", "kyc");
            jSONObject.put("entityType", "INDIVIDUAL");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
        com.paytm.network.b a2 = a.C1317a.a();
        a2.f42877a = this;
        a2.f42879c = a.C0715a.POST;
        a2.f42882f = hashMap;
        a2.f42885i = new KycLeadStatus();
        a2.f42884h = jSONObject.toString();
        a2.f42880d = str;
        a2.k = true;
        a2.o = UpgradeKycActivity.class.getName();
        a2.n = a.b.USER_FACING;
        a2.f42878b = a.c.KYC;
        a2.j = new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                UpgradeKycActivity.a(UpgradeKycActivity.this, iJRPaytmDataModel);
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                l.a();
                if (!l.a((Context) UpgradeKycActivity.this, networkCustomError)) {
                    net.one97.paytm.common.widgets.a.b(UpgradeKycActivity.this.o);
                    UpgradeKycActivity upgradeKycActivity = UpgradeKycActivity.this;
                    upgradeKycActivity.a(upgradeKycActivity.getString(R.string.msg_invalid_url));
                }
            }
        };
        com.paytm.network.a l2 = a2.l();
        if (b.c((Context) this)) {
            net.one97.paytm.common.widgets.a.a(this.o);
            l2.a();
            return;
        }
        a(getString(net.one97.paytm.common.assets.R.string.no_internet));
    }

    private void e() {
        e.a aVar = e.f66028b;
        String g2 = j.g(e.a.b().a());
        e.a aVar2 = e.f66028b;
        if (!j.m(e.a.b().a())) {
            f();
            return;
        }
        e.a aVar3 = e.f66028b;
        if (!j.m(e.a.b().a()) || TextUtils.isEmpty(g2) || !c.b(g2).before(c.b("15 May 2021"))) {
            e.a aVar4 = e.f66028b;
            if (!j.e(e.a.b().a())) {
                startActivity(new Intent(this, AddPanVideoKycActivity.class));
                finish();
                return;
            }
            startActivity(new Intent(this, VideoKycActivity.class));
            finish();
            return;
        }
        getSupportFragmentManager().a().a(R.id.container, (Fragment) new net.one97.paytm.upgradeKyc.aotp.a.a()).a((String) null).c();
    }

    private void f() {
        Intent intent = new Intent(this, EnterAadhaarDetailsActivity.class);
        intent.putExtra("isVideoKYCFlow", true);
        startActivity(intent);
        finish();
    }

    private void a(String str, int i2) {
        net.one97.paytm.common.widgets.a.b(this.o);
        Intent intent = new Intent(this, KycFlowActivity.class);
        intent.putExtra("kyc_flow_purpose", 1);
        intent.setFlags(67108864);
        intent.putExtra("leadPostedDate", str);
        intent.putExtra("screenId", i2);
        startActivity(intent);
        finish();
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            if (!intent.hasExtra("kyc_flow_purpose") || !"kyc".equalsIgnoreCase(this.t)) {
                h();
            } else if (intent.getIntExtra("kyc_flow_purpose", 0) == 20) {
                startActivityForResult(new Intent(this, KycBaseActivity.class), 20);
            }
            if (!intent.hasExtra("kyc_aadhaar_otp")) {
                return;
            }
            if (intent.getBooleanExtra("kyc_aadhaar_otp", true)) {
                this.u = "true";
            } else {
                this.u = "false";
            }
        }
    }

    private void g() {
        startActivity(new Intent(this, InPersonVerification.class));
        finish();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    private void h() {
        this.u = "true";
        this.f65403d.setVisibility(0);
        if (this.m == null) {
            return;
        }
        if (TextUtils.isEmpty(this.f65402b) || !this.f65402b.equalsIgnoreCase(net.one97.paytm.upgradeKyc.d.l.class.getName())) {
            this.m.setVisible(true);
        } else {
            this.m.setVisible(false);
        }
    }

    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment instanceof net.one97.paytm.upgradeKyc.aotp.a.a) {
            ((net.one97.paytm.upgradeKyc.aotp.a.a) fragment).f65468a = this;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.m == null) {
            TextView textView = new TextView(this);
            textView.setText(getString(R.string.use_other_govt_id));
            textView.setTextColor(getResources().getColor(R.color.color_00b9f5));
            textView.setPadding(0, 0, 20, 0);
            textView.setTypeface(Typeface.SANS_SERIF, 0);
            textView.setTextSize(14.0f);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    UpgradeKycActivity.this.a(view);
                }
            });
            menu.add(0, this.f65401a, 1, R.string.use_other_govt_id).setActionView(textView).setShowAsAction(2);
            this.m = menu.findItem(this.f65401a);
            this.m.setVisible(false);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a((Intent) null);
    }

    public void onBackPressed() {
        if (this.t.equalsIgnoreCase(CJRPGTransactionRequestUtils.PAYER_BANK_NAME)) {
            Intent intent = null;
            try {
                e.a aVar = e.f66028b;
                intent = new Intent(this, Class.forName(e.a.b().b()));
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
            }
            intent.setFlags(67108864);
            intent.putExtra("open_bank_tab", true);
            startActivity(intent);
            finish();
            return;
        }
        super.onBackPressed();
    }

    private void a(Intent intent) {
        HashMap hashMap = new HashMap();
        hashMap.put("kyc_user_id", b.n((Context) this));
        e.a aVar = e.f66028b;
        e.a.b().a("kyc_upgrade_wallet_kyc_with_other_docs_clicked", (HashMap<String, Object>) hashMap, (Context) this);
        Intent intent2 = new Intent(this, VerifyDocActivity.class);
        if (intent != null && intent.hasExtra("extra_home_data")) {
            intent2.putExtra("extra_home_data", intent.getSerializableExtra("extra_home_data"));
            intent2.putExtra("vertical", this.t);
        }
        startActivityForResult(intent2, 103);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 103 && i3 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == 104 && i3 == -1) {
            setResult(-1);
            finish();
        } else if (i2 == 20 && i3 == -1) {
            h();
        } else if (i2 == 20 && i3 == 0) {
            setResult(-1);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        c.a aVar = new c.a(this);
        aVar.b((CharSequence) str);
        aVar.a(false);
        aVar.a((CharSequence) "Ok", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                UpgradeKycActivity.this.a(dialogInterface, i2);
            }
        });
        if (!isFinishing() && !isDestroyed()) {
            aVar.b();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        finish();
    }

    public final int a() {
        return R.layout.activity_upgrade_kyc;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    /* renamed from: net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f65415a = new int[net.one97.paytm.upgradeKyc.aotp.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                net.one97.paytm.upgradeKyc.aotp.a[] r0 = net.one97.paytm.upgradeKyc.aotp.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f65415a = r0
                int[] r0 = f65415a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.upgradeKyc.aotp.a r1 = net.one97.paytm.upgradeKyc.aotp.a.CONSENT_GIVEN     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f65415a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.upgradeKyc.aotp.a r1 = net.one97.paytm.upgradeKyc.aotp.a.TRY_USING_DIFFERENT_METHOD     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.activity.UpgradeKycActivity.AnonymousClass7.<clinit>():void");
        }
    }

    public final void a(net.one97.paytm.upgradeKyc.aotp.a aVar) {
        int i2 = AnonymousClass7.f65415a[aVar.ordinal()];
        if (i2 == 1) {
            f();
        } else if (i2 == 2) {
            g();
        }
    }

    static /* synthetic */ void a(UpgradeKycActivity upgradeKycActivity, IJRPaytmDataModel iJRPaytmDataModel) {
        int i2 = 0;
        if (iJRPaytmDataModel instanceof KycLeadStatus) {
            KycLeadStatus kycLeadStatus = (KycLeadStatus) iJRPaytmDataModel;
            if (kycLeadStatus.getStatusCode() != 200) {
                return;
            }
            if (kycLeadStatus.getScreenId() != 13 || !kycLeadStatus.getKycType().equals("Video")) {
                String str = null;
                if (kycLeadStatus.getScreenId() == 13 || kycLeadStatus.getScreenId() == 14) {
                    if (kycLeadStatus.getTimlineSRO() != null) {
                        while (true) {
                            if (i2 >= kycLeadStatus.getTimlineSRO().size()) {
                                break;
                            }
                            String subStage = kycLeadStatus.getTimlineSRO().get(i2).getSubStage();
                            if (!TextUtils.isEmpty(subStage) && subStage.equalsIgnoreCase("LEAD_POSTED")) {
                                str = b.h(kycLeadStatus.getTimlineSRO().get(i2).getSuccessTime(), "yyyy-MM-dd HH:mm", "dd MMMM''yy");
                                break;
                            }
                            i2++;
                        }
                        if (str != null) {
                            upgradeKycActivity.a(str, kycLeadStatus.getScreenId());
                        } else {
                            upgradeKycActivity.a("", kycLeadStatus.getScreenId());
                        }
                    } else {
                        upgradeKycActivity.a(upgradeKycActivity.getString(R.string.msg_invalid_url));
                    }
                } else if (kycLeadStatus.getScreenId() == 12) {
                    d.a aVar = d.f66026a;
                    if (d.a.a() != null) {
                        d.a aVar2 = d.f66026a;
                        d.a.a();
                        str = d.a("mwGetAppointmentV3Url");
                    }
                    if (!URLUtil.isValidUrl(str)) {
                        upgradeKycActivity.a(upgradeKycActivity.getString(R.string.msg_invalid_url));
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("session_token", com.paytm.utility.a.q(upgradeKycActivity.getApplicationContext()));
                    hashMap.put("Content-Type", "application/json");
                    hashMap.put("Accept", "application/json");
                    a.C1317a aVar3 = net.one97.paytm.upgradeKyc.helper.a.f66022a;
                    com.paytm.network.b a2 = a.C1317a.a();
                    a2.f42877a = upgradeKycActivity;
                    a2.f42879c = a.C0715a.GET;
                    a2.f42882f = hashMap;
                    a2.f42885i = new KycSavedUserData();
                    a2.f42880d = b.e((Context) upgradeKycActivity, str) + "&userInterest=true&leadSource=App";
                    a2.k = false;
                    a2.o = upgradeKycActivity.getClass().getName();
                    a2.n = a.b.USER_FACING;
                    a2.j = new com.paytm.network.listener.b() {
                        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                            UpgradeKycActivity.a(UpgradeKycActivity.this, iJRPaytmDataModel);
                        }

                        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            l.a();
                            if (!l.a((Context) UpgradeKycActivity.this, networkCustomError)) {
                                String string = UpgradeKycActivity.this.getString(R.string.msg_invalid_url);
                                if (!TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                                    string = networkCustomError.getAlertMessage();
                                }
                                UpgradeKycActivity.this.a(string);
                            }
                        }
                    };
                    com.paytm.network.a l2 = a2.l();
                    if (b.c(upgradeKycActivity.getApplicationContext())) {
                        l2.a();
                    } else {
                        upgradeKycActivity.a(upgradeKycActivity.getString(net.one97.paytm.common.assets.R.string.no_internet));
                    }
                } else if (kycLeadStatus.getScreenId() == 11) {
                    net.one97.paytm.common.widgets.a.b(upgradeKycActivity.o);
                    if (upgradeKycActivity.A) {
                        upgradeKycActivity.e();
                    } else if (j.d(upgradeKycActivity) == 1) {
                        upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, MinKycStatusActivity.class));
                        upgradeKycActivity.finish();
                    } else if (j.b((Context) upgradeKycActivity) == 1 && j.c(upgradeKycActivity).equalsIgnoreCase("OTP_UPI")) {
                        upgradeKycActivity.g();
                    } else if (j.b((Context) upgradeKycActivity) != 1 || !j.c(upgradeKycActivity).equalsIgnoreCase("OTP")) {
                        upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, MinKycStatusSuccessActivity.class));
                        upgradeKycActivity.finish();
                    } else {
                        upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, OtpKycSuccessActivity.class));
                        upgradeKycActivity.finish();
                    }
                }
            } else {
                upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, VideoKycStatusActivity.class));
                upgradeKycActivity.finish();
            }
        } else if (iJRPaytmDataModel instanceof KycSavedUserData) {
            KycSavedUserData kycSavedUserData = (KycSavedUserData) iJRPaytmDataModel;
            if (kycSavedUserData.getKYCDetail() == null || kycSavedUserData.getKYCDetail().size() <= 0) {
                upgradeKycActivity.a(upgradeKycActivity.getString(R.string.msg_invalid_url));
                return;
            }
            KYCDetail kYCDetail = kycSavedUserData.getKYCDetail().get(0);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("customerId", b.n((Context) upgradeKycActivity));
                if (!TextUtils.isEmpty(kYCDetail.getQrCodeId())) {
                    jSONObject.put("qrCodeId", kYCDetail.getQrCodeId());
                }
                jSONObject.put("leadSource", "App");
                jSONObject.put("addressChanged", "false");
                if (!TextUtils.isEmpty(kYCDetail.getAppointmentTimeSlot())) {
                    jSONObject.put("appointmentTimeSlot", kYCDetail.getAppointmentTimeSlot());
                }
                if (!TextUtils.isEmpty(kYCDetail.getAppointmentDate())) {
                    jSONObject.put("appointmentDate", kYCDetail.getAppointmentDate());
                }
                if (!TextUtils.isEmpty(b.l((Context) upgradeKycActivity))) {
                    jSONObject.put("phoneNumber", b.l((Context) upgradeKycActivity));
                    jSONObject.put("altPhoneNumber", b.l((Context) upgradeKycActivity));
                }
                JSONObject jSONObject2 = new JSONObject();
                if (!(kYCDetail.getAddDetails() == null || kYCDetail.getAddDetails().size() <= 0 || kYCDetail.getAddDetails().get(0) == null)) {
                    jSONObject2.put("addressLine1", kYCDetail.getAddDetails().get(0).getAddressLine1());
                    jSONObject2.put("addressLine2", kYCDetail.getAddDetails().get(0).getAddressLine3());
                    jSONObject2.put(AddEditGstinViewModelKt.BODY_PARAM_PINCODE, kYCDetail.getAddDetails().get(0).getPincodeC());
                    jSONObject2.put("city", kYCDetail.getAddDetails().get(0).getCity());
                    jSONObject2.put("state", kYCDetail.getAddDetails().get(0).getState());
                }
                jSONObject.put("kycAddress", jSONObject2);
                jSONObject.put("kycDocument", new JSONObject());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a.C1325a aVar4 = net.one97.paytm.upgradeKyc.kycV3.b.a.f66162b;
            a.C1325a.a(upgradeKycActivity.getApplicationContext());
            net.one97.paytm.upgradeKyc.kycV3.b.a.a("slotBookData", jSONObject.toString());
            net.one97.paytm.common.widgets.a.b(upgradeKycActivity.o);
            if (!kYCDetail.getConsentCaptured()) {
                upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, ConsentCaptureActivity.class));
                upgradeKycActivity.finish();
            } else if (!TextUtils.isEmpty(kYCDetail.getQrCodeId())) {
                Intent intent = new Intent(upgradeKycActivity, AppointmentBookedActivity.class);
                intent.putExtra("kyc_additional_info", kYCDetail);
                upgradeKycActivity.startActivity(intent);
                upgradeKycActivity.finish();
            } else {
                upgradeKycActivity.a(upgradeKycActivity.getString(R.string.msg_invalid_url));
            }
        } else if (iJRPaytmDataModel instanceof KYCStatusV3) {
            net.one97.paytm.common.widgets.a.b(upgradeKycActivity.o);
            KYCStatusV3 kYCStatusV3 = (KYCStatusV3) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(kYCStatusV3.getExpiryType())) {
                j.g(upgradeKycActivity.getApplicationContext(), kYCStatusV3.getExpiryType());
            }
            j.b(upgradeKycActivity.getApplicationContext(), kYCStatusV3.isMinKycEligible());
            j.c((Context) upgradeKycActivity, kYCStatusV3.getKycType());
            j.a(upgradeKycActivity.getApplicationContext(), kYCStatusV3.isMinKycStatus());
            j.a((Context) upgradeKycActivity, kYCStatusV3.getIsKycDone());
            j.b((Context) upgradeKycActivity, kYCStatusV3.isKycExpired());
            j.c((Context) upgradeKycActivity, kYCStatusV3.isAadharVerified());
            j.a("true".equals(kYCStatusV3.getIsPanVerified()));
            j.a(kYCStatusV3.getPanSubmittedAs());
            j.b(kYCStatusV3.isForm60());
            j.a(kYCStatusV3.getIsKycDone());
            j.b(kYCStatusV3.getAadhaarSubmittedAs());
            String kycExpiryTime = kYCStatusV3.getKycExpiryTime();
            if (!TextUtils.isEmpty(kycExpiryTime)) {
                j.d(upgradeKycActivity.getApplicationContext(), net.one97.paytm.upgradeKyc.utils.c.a(kycExpiryTime));
            }
            if (!TextUtils.isEmpty(kYCStatusV3.getIsMinor())) {
                j.e(upgradeKycActivity.getApplicationContext(), kYCStatusV3.getIsMinor());
            }
            if (kYCStatusV3.getIsKycDone() == 1) {
                if (kYCStatusV3.getKycType().equalsIgnoreCase("OTP_UPI") || kYCStatusV3.getKycType().equalsIgnoreCase("OTP")) {
                    upgradeKycActivity.d();
                } else if (kYCStatusV3.isForm60() || ((!kYCStatusV3.getIsPanVerified().equalsIgnoreCase("NA") && !kYCStatusV3.getIsPanVerified().equalsIgnoreCase("false")) || (!kYCStatusV3.getKycType().equalsIgnoreCase("biometric") && !kYCStatusV3.getKycType().equalsIgnoreCase("manual")))) {
                    upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, WalletUpgradedSuccessActivity.class));
                    upgradeKycActivity.finish();
                } else {
                    upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, PanUpdateActivity.class));
                    upgradeKycActivity.finish();
                }
            } else if (upgradeKycActivity.A) {
                upgradeKycActivity.e();
            } else if (kYCStatusV3.isMinKycStatus() || j.d(upgradeKycActivity) == 1) {
                upgradeKycActivity.d();
            } else {
                upgradeKycActivity.startActivity(new Intent(upgradeKycActivity, VerifyDocActivity.class));
                upgradeKycActivity.finish();
            }
        }
    }
}
