package net.one97.paytm.managebeneficiary;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.BeneficiaryEntity;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.managebeneficiary.a.a;

public class EditBeneficiaryV2Activity extends BeneficiaryActivity implements View.OnClickListener {
    private String A = "";
    private String B = "";
    private String C = "";
    private String D = "";
    private String E = "";
    private String F = "";
    private String G = "";
    private String H = "";
    private String I = "";
    private String J = "";
    /* access modifiers changed from: private */
    public b K;
    /* access modifiers changed from: private */
    public d L;
    /* access modifiers changed from: private */
    public boolean M;
    /* access modifiers changed from: private */
    public TableRow N;
    private TextWatcher O = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (EditBeneficiaryV2Activity.this.L != null) {
                EditBeneficiaryV2Activity.this.L.a();
            }
            EditBeneficiaryV2Activity.this.r.setError("");
            EditBeneficiaryV2Activity.this.q.setError("");
        }
    };
    /* access modifiers changed from: private */
    public c P = new c() {
        public final void a(CJRAddBeneficiary cJRAddBeneficiary) {
            if (cJRAddBeneficiary == null) {
                EditBeneficiaryV2Activity editBeneficiaryV2Activity = EditBeneficiaryV2Activity.this;
                b.a((Context) editBeneficiaryV2Activity, editBeneficiaryV2Activity.getString(R.string.pb_mb_error), EditBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
            } else if (cJRAddBeneficiary.getError() != null) {
                if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                    EditBeneficiaryV2Activity editBeneficiaryV2Activity2 = EditBeneficiaryV2Activity.this;
                    b.a((Context) editBeneficiaryV2Activity2, editBeneficiaryV2Activity2.getString(R.string.pb_mb_error), cJRAddBeneficiary.getError().getErrorMsg());
                    return;
                }
                EditBeneficiaryV2Activity editBeneficiaryV2Activity3 = EditBeneficiaryV2Activity.this;
                b.a((Context) editBeneficiaryV2Activity3, editBeneficiaryV2Activity3.getString(R.string.pb_mb_error), EditBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
            } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                e.a(EditBeneficiaryV2Activity.this, f.a().getBeneficiaryDetailUpdatesMsg(EditBeneficiaryV2Activity.this));
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    View.OnClickListener f53219a = new View.OnClickListener() {
        public final void onClick(View view) {
            try {
                if (EditBeneficiaryV2Activity.this.K != null) {
                    EditBeneficiaryV2Activity.this.b(EditBeneficiaryV2Activity.this.t);
                }
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private ViewGroup f53220c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f53221d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f53222e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f53223f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f53224g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f53225h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f53226i;
    private ImageView j;
    private CheckBox k;
    /* access modifiers changed from: private */
    public CheckBox l;
    private LinearLayout m;
    private LinearLayout n;
    private AppCompatEditText o;
    private AppCompatEditText p;
    /* access modifiers changed from: private */
    public TextInputLayout q;
    /* access modifiers changed from: private */
    public TextInputLayout r;
    private BeneficiaryEntity s;
    /* access modifiers changed from: private */
    public boolean t;
    private boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    private boolean w;
    private boolean x;
    private String y = "";
    private String z = "";

    public void onCreate(Bundle bundle) {
        BeneficiaryEntity.OtherBankAccount otherBankAccount;
        String str;
        BeneficiaryEntity.WalletAccount walletAccount;
        super.onCreate(bundle);
        setContentView(R.layout.activity_edit_beneficiary_v2);
        this.L = new d(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        f.a().sendOpenScreenWithDeviceInfo("/beneficiary/wallet/edit", "beneficiary", this);
        this.f53220c = (ViewGroup) findViewById(R.id.root_view);
        findViewById(R.id.bene_back_arrow_iv).setOnClickListener(this);
        findViewById(R.id.bene_limit_iv).setOnClickListener(this);
        findViewById(R.id.bene_transaction_iv).setOnClickListener(this);
        this.f53221d = (TextView) findViewById(R.id.edit_bene_name_tv);
        this.f53223f = (TextView) findViewById(R.id.edit_bene_acc_no_tv);
        this.f53222e = (TextView) findViewById(R.id.edit_bene_bank_name_tv);
        this.j = (ImageView) findViewById(R.id.edit_bene_bank_iv);
        this.N = (TableRow) findViewById(R.id.bank_bank_layout);
        this.N.setVisibility(8);
        this.k = (CheckBox) findViewById(R.id.bank_bank_cb);
        this.l = (CheckBox) findViewById(R.id.bank_wallet_cb);
        this.f53224g = (TextView) findViewById(R.id.bene_bank_bank_setting_tv);
        this.f53224g.setOnClickListener(this);
        this.f53225h = (TextView) findViewById(R.id.bene_bank_wallet_setting_tv);
        this.f53225h.setOnClickListener(this);
        this.m = (LinearLayout) findViewById(R.id.bene_edit_wallet_ll);
        this.n = (LinearLayout) findViewById(R.id.bene_edit_bank_ll);
        this.q = (TextInputLayout) findViewById(R.id.layout_monthly_fund_transfer);
        this.o = (AppCompatEditText) findViewById(R.id.edit_monthly_fund_transfer);
        this.r = (TextInputLayout) findViewById(R.id.layout_maximum_transaction);
        this.p = (AppCompatEditText) findViewById(R.id.edit_maximum_transaction);
        this.p.addTextChangedListener(this.O);
        this.o.addTextChangedListener(this.O);
        this.p.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.f53226i = (TextView) findViewById(R.id.wallet_edit_bene_save_tv);
        this.f53226i.setOnClickListener(this);
        findViewById(R.id.edit_bene_save_bank_tv).setOnClickListener(this);
        findViewById(R.id.scrollView).getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            public final void onScrollChanged() {
                if (EditBeneficiaryV2Activity.this.L != null) {
                    EditBeneficiaryV2Activity.this.L.a();
                }
            }
        });
        if (getIntent() == null || !getIntent().hasExtra("kyc_beneficiary")) {
            finish();
        } else {
            this.s = (BeneficiaryEntity) getIntent().getSerializableExtra("kyc_beneficiary");
            BeneficiaryEntity beneficiaryEntity = this.s;
            if (!(beneficiaryEntity == null || beneficiaryEntity.instrumentPreferences == null)) {
                if (this.s.instrumentPreferences.wallet != null) {
                    this.t = true;
                } else {
                    this.t = false;
                }
            }
        }
        if (!this.t) {
            f.a().getBankAccStatus(this, new a() {
                public final void a(int i2) {
                    if (i2 == 3) {
                        boolean unused = EditBeneficiaryV2Activity.this.M = true;
                        EditBeneficiaryV2Activity.this.N.setVisibility(0);
                        return;
                    }
                    EditBeneficiaryV2Activity.this.N.setVisibility(8);
                    boolean unused2 = EditBeneficiaryV2Activity.this.v = true;
                    EditBeneficiaryV2Activity.this.l.setChecked(true);
                    EditBeneficiaryV2Activity.this.f53225h.setEnabled(true);
                    EditBeneficiaryV2Activity.this.f53225h.setTextColor(EditBeneficiaryV2Activity.this.getResources().getColor(R.color.color_00b9f5));
                }
            });
        }
        String str2 = "";
        if (this.t) {
            this.m.setVisibility(0);
            this.n.setVisibility(8);
            BeneficiaryEntity beneficiaryEntity2 = this.s;
            if (beneficiaryEntity2 != null && beneficiaryEntity2.instrumentPreferences != null && this.s.instrumentPreferences.wallet != null && (walletAccount = this.s.instrumentPreferences.wallet.accounts.get(0)) != null) {
                BeneficiaryEntity.WalletAccountDetail walletAccountDetail = walletAccount.accountDetail;
                if (walletAccountDetail != null) {
                    this.f53221d.setText(walletAccountDetail.beneficiaryName != null ? walletAccountDetail.beneficiaryName : str2);
                    TextView textView = this.f53223f;
                    if (walletAccountDetail.beneficiaryPhone != null) {
                        str2 = walletAccountDetail.beneficiaryPhone;
                    }
                    textView.setText(str2);
                }
                ArrayList<BeneficiaryEntity.Limit> arrayList = walletAccount.limits;
                if (arrayList != null && !arrayList.isEmpty()) {
                    Iterator<BeneficiaryEntity.Limit> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        BeneficiaryEntity.Limit next = it2.next();
                        String str3 = next.ruleId;
                        BeneficiaryEntity.RuleParam ruleParam = next.ruleParams;
                        if (ruleParam != null && "wallet".equalsIgnoreCase(ruleParam.source)) {
                            if ("LIMITS-1".equalsIgnoreCase(str3)) {
                                String str4 = ruleParam.txn;
                                this.D = str4;
                                this.J = str4;
                            } else if ("LIMITS-2".equalsIgnoreCase(str3)) {
                                String str5 = ruleParam.amount;
                                this.A = str5;
                                this.G = str5;
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(this.A)) {
                    this.o.setText(this.A);
                }
                if (!TextUtils.isEmpty(this.D)) {
                    this.p.setText(this.D);
                    return;
                }
                return;
            }
            return;
        }
        this.m.setVisibility(8);
        this.n.setVisibility(0);
        BeneficiaryEntity beneficiaryEntity3 = this.s;
        if (beneficiaryEntity3 != null && beneficiaryEntity3.instrumentPreferences != null && this.s.instrumentPreferences.otherBank != null && (otherBankAccount = this.s.instrumentPreferences.otherBank.accounts.get(0)) != null) {
            BeneficiaryEntity.OtherBankAccountDetail otherBankAccountDetail = otherBankAccount.accountDetail;
            if (otherBankAccountDetail != null) {
                this.f53221d.setText(otherBankAccountDetail.accountHolderName != null ? otherBankAccountDetail.accountHolderName : str2);
                TextView textView2 = this.f53223f;
                if (otherBankAccountDetail.accountNumber != null) {
                    str = "A/c No. " + otherBankAccountDetail.accountNumber;
                } else {
                    str = str2;
                }
                textView2.setText(str);
                TextView textView3 = this.f53222e;
                if (otherBankAccountDetail.bankName != null) {
                    str2 = otherBankAccountDetail.bankName;
                }
                textView3.setText(str2);
                ImageView imageView = this.j;
                String str6 = otherBankAccountDetail.ifscCode;
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_ic_default_bank);
                if (!TextUtils.isEmpty(str6)) {
                    if (str6.toUpperCase().startsWith("ICIC")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_icici_bank_logo);
                    } else if (str6.toUpperCase().startsWith("KOT")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_kotak);
                    } else if (str6.toUpperCase().startsWith("UTI")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_axis);
                    } else if (str6.toUpperCase().startsWith("HDF")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_hdfc);
                    } else if (str6.toUpperCase().startsWith("SBI")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_sbi);
                    } else if (str6.toUpperCase().startsWith("PNB")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_pnb);
                    } else if (str6.toUpperCase().startsWith("UPI")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_ic_default_bank);
                    } else if (str6.toUpperCase().startsWith("PYT")) {
                        decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.pb_mb_paytm_logo_money_transfer);
                    }
                }
                Bitmap bitmap = null;
                if (decodeResource != null && !decodeResource.isRecycled()) {
                    int width = decodeResource.getWidth() + 3;
                    int height = decodeResource.getHeight() + 3;
                    Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                    BitmapShader bitmapShader = new BitmapShader(decodeResource, tileMode, tileMode);
                    Paint paint = new Paint();
                    paint.setAntiAlias(true);
                    paint.setShader(bitmapShader);
                    Canvas canvas = new Canvas(createBitmap);
                    float f2 = (width > height ? (float) height : (float) width) / 2.0f;
                    float f3 = (float) (width / 2);
                    float f4 = (float) (height / 2);
                    canvas.drawCircle(f3, f4, f2, paint);
                    paint.setShader((Shader) null);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(Color.rgb(240, 240, 240));
                    paint.setStrokeWidth(3.0f);
                    canvas.drawCircle(f3, f4, f2 - 1.0f, paint);
                    bitmap = createBitmap;
                }
                imageView.setImageBitmap(bitmap);
            }
            BeneficiaryEntity.Source source = otherBankAccount.source;
            if (!(source == null || source.oba == null || !"ENABLED".equalsIgnoreCase(source.oba))) {
                this.u = true;
                this.w = true;
            }
            if (!(source == null || source.wallet == null || !"ENABLED".equalsIgnoreCase(source.wallet))) {
                this.v = true;
                this.x = true;
            }
            ArrayList<BeneficiaryEntity.Limit> arrayList2 = otherBankAccount.limits;
            if (arrayList2 != null && !arrayList2.isEmpty()) {
                Iterator<BeneficiaryEntity.Limit> it3 = arrayList2.iterator();
                while (it3.hasNext()) {
                    BeneficiaryEntity.Limit next2 = it3.next();
                    String str7 = next2.ruleId;
                    BeneficiaryEntity.RuleParam ruleParam2 = next2.ruleParams;
                    if (ruleParam2 != null) {
                        String str8 = ruleParam2.source;
                        if ("oba".equalsIgnoreCase(str8)) {
                            if ("LIMITS-1".equalsIgnoreCase(str7)) {
                                String str9 = ruleParam2.txn;
                                this.B = str9;
                                this.H = str9;
                            } else if ("LIMITS-2".equalsIgnoreCase(str7)) {
                                String str10 = ruleParam2.amount;
                                this.y = str10;
                                this.E = str10;
                            }
                        } else if ("wallet".equalsIgnoreCase(str8)) {
                            if ("LIMITS-1".equalsIgnoreCase(str7)) {
                                String str11 = ruleParam2.txn;
                                this.C = str11;
                                this.I = str11;
                            } else if ("LIMITS-2".equalsIgnoreCase(str7)) {
                                String str12 = ruleParam2.amount;
                                this.z = str12;
                                this.F = str12;
                            }
                        }
                    }
                }
            }
            if (this.u) {
                this.k.setChecked(true);
                this.f53224g.setEnabled(true);
                this.f53224g.setTextColor(getResources().getColor(R.color.color_00b9f5));
            } else {
                this.f53224g.setEnabled(false);
                this.f53224g.setTextColor(getResources().getColor(R.color.color_909090));
            }
            if (this.v) {
                this.l.setChecked(true);
                this.f53225h.setEnabled(true);
                this.f53225h.setTextColor(getResources().getColor(R.color.color_00b9f5));
                return;
            }
            this.f53225h.setEnabled(false);
            this.f53225h.setTextColor(getResources().getColor(R.color.color_909090));
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 101) {
            String stringExtra = intent.getStringExtra("which_setting");
            if ("bank_bank_setting".equals(stringExtra)) {
                if (intent.hasExtra("transfer_limit")) {
                    this.y = intent.getStringExtra("transfer_limit");
                }
                if (intent.hasExtra("max_no_transac")) {
                    this.B = intent.getStringExtra("max_no_transac");
                }
            } else if ("bank_wallet_setting".equals(stringExtra)) {
                if (intent.hasExtra("transfer_limit")) {
                    this.z = intent.getStringExtra("transfer_limit");
                }
                if (intent.hasExtra("max_no_transac")) {
                    this.C = intent.getStringExtra("max_no_transac");
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r8) {
        /*
            r7 = this;
            net.one97.paytm.managebeneficiary.d r0 = r7.L
            if (r0 == 0) goto L_0x0007
            r0.a()
        L_0x0007:
            int r0 = r8.getId()
            int r1 = net.one97.paytm.managebeneficiary.R.id.bene_back_arrow_iv
            if (r0 != r1) goto L_0x0013
            r7.onBackPressed()
            return
        L_0x0013:
            int r1 = net.one97.paytm.managebeneficiary.R.id.bene_limit_iv
            if (r0 != r1) goto L_0x002c
            net.one97.paytm.managebeneficiary.d r0 = r7.L
            if (r0 == 0) goto L_0x0158
            r0.a()
            net.one97.paytm.managebeneficiary.d r0 = r7.L
            android.view.ViewGroup r1 = r7.f53220c
            int r2 = net.one97.paytm.managebeneficiary.R.string.pb_mb_bene_limit_per_month
            java.lang.String r2 = r7.getString(r2)
            r0.a((android.view.View) r8, (android.view.ViewGroup) r1, (java.lang.String) r2)
            return
        L_0x002c:
            int r1 = net.one97.paytm.managebeneficiary.R.id.bene_transaction_iv
            if (r0 != r1) goto L_0x0045
            net.one97.paytm.managebeneficiary.d r0 = r7.L
            if (r0 == 0) goto L_0x0158
            r0.a()
            net.one97.paytm.managebeneficiary.d r0 = r7.L
            android.view.ViewGroup r1 = r7.f53220c
            int r2 = net.one97.paytm.managebeneficiary.R.string.pb_mb_bene_max_transaction
            java.lang.String r2 = r7.getString(r2)
            r0.a((android.view.View) r8, (android.view.ViewGroup) r1, (java.lang.String) r2)
            return
        L_0x0045:
            int r8 = net.one97.paytm.managebeneficiary.R.id.bene_bank_bank_setting_tv
            if (r0 != r8) goto L_0x004f
            java.lang.String r8 = "bank_bank_setting"
            r7.a((java.lang.String) r8)
            return
        L_0x004f:
            int r8 = net.one97.paytm.managebeneficiary.R.id.bene_bank_wallet_setting_tv
            if (r0 != r8) goto L_0x0059
            java.lang.String r8 = "bank_wallet_setting"
            r7.a((java.lang.String) r8)
            return
        L_0x0059:
            int r8 = net.one97.paytm.managebeneficiary.R.id.wallet_edit_bene_save_tv
            java.lang.String r1 = "/beneficiary/wallet/edit"
            java.lang.String r2 = "edit_and_save_advanced_settings"
            java.lang.String r3 = "beneficiary_wallet"
            r4 = 0
            if (r0 != r8) goto L_0x012a
            r8 = 1
            boolean r0 = r7.a((boolean) r8)
            if (r0 == 0) goto L_0x0075
            int r8 = net.one97.paytm.managebeneficiary.R.string.pb_mb_no_limits_updated
            java.lang.String r8 = r7.getString(r8)
            net.one97.paytm.managebeneficiary.e.a(r7, r8)
            return
        L_0x0075:
            androidx.appcompat.widget.AppCompatEditText r0 = r7.o
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r5 = 100000(0x186a0, float:1.4013E-40)
            java.lang.String r6 = ""
            if (r0 != 0) goto L_0x00bb
            androidx.appcompat.widget.AppCompatEditText r0 = r7.o
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            if (r0 <= 0) goto L_0x00aa
            if (r0 <= r5) goto L_0x009d
            goto L_0x00aa
        L_0x009d:
            androidx.appcompat.widget.AppCompatEditText r0 = r7.o
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r7.A = r0
            goto L_0x00bd
        L_0x00aa:
            com.google.android.material.textfield.TextInputLayout r0 = r7.q
            int r5 = net.one97.paytm.managebeneficiary.R.string.pb_mb_error_max_amt_limit
            java.lang.String r5 = r7.getString(r5)
            r0.setError(r5)
            androidx.appcompat.widget.AppCompatEditText r0 = r7.o
            r0.requestFocus()
            goto L_0x011f
        L_0x00bb:
            r7.A = r6
        L_0x00bd:
            androidx.appcompat.widget.AppCompatEditText r0 = r7.p
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00fe
            androidx.appcompat.widget.AppCompatEditText r0 = r7.p
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            int r0 = java.lang.Integer.parseInt(r0)
            if (r0 <= 0) goto L_0x00ed
            if (r0 <= r5) goto L_0x00e0
            goto L_0x00ed
        L_0x00e0:
            androidx.appcompat.widget.AppCompatEditText r0 = r7.p
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r7.D = r0
            goto L_0x0100
        L_0x00ed:
            com.google.android.material.textfield.TextInputLayout r0 = r7.r
            int r5 = net.one97.paytm.managebeneficiary.R.string.pb_mb_error_max_txn_limit
            java.lang.String r5 = r7.getString(r5)
            r0.setError(r5)
            androidx.appcompat.widget.AppCompatEditText r0 = r7.p
            r0.requestFocus()
            goto L_0x011f
        L_0x00fe:
            r7.D = r6
        L_0x0100:
            java.lang.String r0 = r7.D
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x011e
            java.lang.String r0 = r7.A
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x011e
            int r0 = net.one97.paytm.managebeneficiary.R.string.pb_mb_enable_atleast_one_limit
            java.lang.String r0 = r7.getString(r0)
            android.widget.Toast r0 = android.widget.Toast.makeText(r7, r0, r4)
            r0.show()
            goto L_0x011f
        L_0x011e:
            r4 = 1
        L_0x011f:
            if (r4 == 0) goto L_0x0158
            java.lang.String r0 = "pb_mb_paytm_wallet"
            net.one97.paytm.managebeneficiary.e.a(r7, r3, r2, r0, r1)
            r7.b((boolean) r8)
            return
        L_0x012a:
            int r8 = net.one97.paytm.managebeneficiary.R.id.edit_bene_save_bank_tv
            if (r0 != r8) goto L_0x0158
            boolean r8 = r7.a((boolean) r4)
            if (r8 == 0) goto L_0x013e
            int r8 = net.one97.paytm.managebeneficiary.R.string.pb_mb_no_limits_updated
            java.lang.String r8 = r7.getString(r8)
            net.one97.paytm.managebeneficiary.e.a(r7, r8)
            return
        L_0x013e:
            boolean r8 = r7.u
            if (r8 != 0) goto L_0x0150
            boolean r8 = r7.v
            if (r8 != 0) goto L_0x0150
            java.lang.String r8 = "Please check at least one checkbox"
            android.widget.Toast r8 = android.widget.Toast.makeText(r7, r8, r4)
            r8.show()
            return
        L_0x0150:
            java.lang.String r8 = "bank_account"
            net.one97.paytm.managebeneficiary.e.a(r7, r3, r2, r8, r1)
            r7.b((boolean) r4)
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.managebeneficiary.EditBeneficiaryV2Activity.onClick(android.view.View):void");
    }

    public void onCheckboxClicked(View view) {
        boolean isChecked = ((CheckBox) view).isChecked();
        int id = view.getId();
        if (id == R.id.bank_bank_cb) {
            if (isChecked) {
                this.u = true;
                this.f53224g.setTextColor(getResources().getColor(R.color.color_00b9f5));
                this.f53224g.setEnabled(true);
                return;
            }
            this.u = false;
            this.f53224g.setTextColor(getResources().getColor(R.color.color_909090));
            this.f53224g.setEnabled(false);
        } else if (id != R.id.bank_wallet_cb) {
        } else {
            if (!this.M) {
                this.v = true;
                this.f53225h.setTextColor(getResources().getColor(R.color.color_00b9f5));
                this.f53225h.setEnabled(true);
                this.l.setChecked(true);
            } else if (isChecked) {
                this.v = true;
                this.f53225h.setTextColor(getResources().getColor(R.color.color_00b9f5));
                this.f53225h.setEnabled(true);
            } else {
                this.v = false;
                this.f53225h.setTextColor(getResources().getColor(R.color.color_909090));
                this.f53225h.setEnabled(false);
            }
        }
    }

    private void a(String str) {
        Intent intent = new Intent(this, AdvanceSettingBeneficiaryActivity.class);
        intent.putExtra("which_setting", str);
        if ("bank_bank_setting".equals(str)) {
            intent.putExtra("transfer_limit", this.y);
            intent.putExtra("max_no_transac", this.B);
        } else if ("bank_wallet_setting".equals(str)) {
            intent.putExtra("transfer_limit", this.z);
            intent.putExtra("max_no_transac", this.C);
        }
        startActivityForResult(intent, 101);
    }

    private boolean a(boolean z2) {
        if (z2) {
            String obj = this.o.getText().toString();
            String obj2 = this.p.getText().toString();
            if (TextUtils.isEmpty(obj)) {
                obj = "";
            }
            if (TextUtils.isEmpty(obj2)) {
                obj2 = "";
            }
            if (!obj.equalsIgnoreCase(this.G) || !obj2.equalsIgnoreCase(this.J)) {
                return false;
            }
            return true;
        } else if (this.u != this.w || this.v != this.x || !this.y.equalsIgnoreCase(this.E) || !this.B.equalsIgnoreCase(this.H) || !this.z.equalsIgnoreCase(this.F) || !this.C.equalsIgnoreCase(this.I)) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        if (b.c((Context) this)) {
            a(this, getString(R.string.pb_mb_resending_otp));
            BeneficiaryEntity.Limit limit = null;
            if (z2) {
                ArrayList<BeneficiaryEntity.Limit> arrayList = (this.s.instrumentPreferences.wallet.accounts == null || this.s.instrumentPreferences.wallet.accounts.isEmpty()) ? null : this.s.instrumentPreferences.wallet.accounts.get(0).limits;
                if (arrayList == null || arrayList.isEmpty()) {
                    arrayList = new ArrayList<>();
                } else {
                    Iterator<BeneficiaryEntity.Limit> it2 = arrayList.iterator();
                    BeneficiaryEntity.Limit limit2 = null;
                    while (it2.hasNext()) {
                        BeneficiaryEntity.Limit next = it2.next();
                        if ("LIMITS-1".equalsIgnoreCase(next.ruleId)) {
                            limit = next;
                        } else if ("LIMITS-2".equalsIgnoreCase(next.ruleId)) {
                            limit2 = next;
                        }
                    }
                    if (limit != null) {
                        arrayList.remove(limit);
                    }
                    if (limit2 != null) {
                        arrayList.remove(limit2);
                    }
                }
                if (!TextUtils.isEmpty(this.D)) {
                    BeneficiaryEntity.Limit limit3 = new BeneficiaryEntity.Limit();
                    limit3.ruleId = "LIMITS-1";
                    BeneficiaryEntity.RuleParam ruleParam = new BeneficiaryEntity.RuleParam();
                    ruleParam.txn = this.D;
                    ruleParam.source = "wallet";
                    ruleParam.duration = "1";
                    ruleParam.durationUnit = "MONTH";
                    limit3.ruleParams = ruleParam;
                    arrayList.add(limit3);
                }
                if (!TextUtils.isEmpty(this.A)) {
                    BeneficiaryEntity.Limit limit4 = new BeneficiaryEntity.Limit();
                    limit4.ruleId = "LIMITS-2";
                    BeneficiaryEntity.RuleParam ruleParam2 = new BeneficiaryEntity.RuleParam();
                    ruleParam2.amount = this.A;
                    ruleParam2.source = "wallet";
                    ruleParam2.duration = "1";
                    ruleParam2.durationUnit = "MONTH";
                    limit4.ruleParams = ruleParam2;
                    arrayList.add(limit4);
                }
                if (this.s.instrumentPreferences.wallet.accounts != null && !this.s.instrumentPreferences.wallet.accounts.isEmpty()) {
                    this.s.instrumentPreferences.wallet.accounts.get(0).limits = arrayList;
                }
            } else {
                BeneficiaryEntity.Source source = new BeneficiaryEntity.Source();
                ArrayList<BeneficiaryEntity.Limit> arrayList2 = (this.s.instrumentPreferences.otherBank.accounts == null || this.s.instrumentPreferences.otherBank.accounts.isEmpty()) ? null : this.s.instrumentPreferences.otherBank.accounts.get(0).limits;
                if (arrayList2 == null || arrayList2.isEmpty()) {
                    arrayList2 = new ArrayList<>();
                } else {
                    Iterator<BeneficiaryEntity.Limit> it3 = arrayList2.iterator();
                    BeneficiaryEntity.Limit limit5 = null;
                    BeneficiaryEntity.Limit limit6 = null;
                    BeneficiaryEntity.Limit limit7 = null;
                    while (it3.hasNext()) {
                        BeneficiaryEntity.Limit next2 = it3.next();
                        if (!"LIMITS-1".equalsIgnoreCase(next2.ruleId) || !"oba".equalsIgnoreCase(next2.ruleParams.source)) {
                            Iterator<BeneficiaryEntity.Limit> it4 = it3;
                            if ("LIMITS-2".equalsIgnoreCase(next2.ruleId) && "oba".equalsIgnoreCase(next2.ruleParams.source)) {
                                it3 = it4;
                                limit5 = next2;
                            } else if ("LIMITS-1".equalsIgnoreCase(next2.ruleId) && "wallet".equalsIgnoreCase(next2.ruleParams.source)) {
                                it3 = it4;
                                limit6 = next2;
                            } else {
                                if ("LIMITS-2".equalsIgnoreCase(next2.ruleId) && "wallet".equalsIgnoreCase(next2.ruleParams.source)) {
                                    limit7 = next2;
                                }
                                it3 = it4;
                            }
                        } else {
                            limit = next2;
                        }
                    }
                    if (limit != null) {
                        arrayList2.remove(limit);
                    }
                    if (limit5 != null) {
                        arrayList2.remove(limit5);
                    }
                    if (limit6 != null) {
                        arrayList2.remove(limit6);
                    }
                    if (limit7 != null) {
                        arrayList2.remove(limit7);
                    }
                }
                source.upi = "DISABLED";
                if (this.u) {
                    source.oba = "ENABLED";
                } else {
                    source.oba = "DISABLED";
                }
                if (this.v) {
                    source.wallet = "ENABLED";
                } else {
                    source.wallet = "DISABLED";
                }
                if (this.u) {
                    if (!TextUtils.isEmpty(this.B)) {
                        BeneficiaryEntity.Limit limit8 = new BeneficiaryEntity.Limit();
                        limit8.ruleId = "LIMITS-1";
                        BeneficiaryEntity.RuleParam ruleParam3 = new BeneficiaryEntity.RuleParam();
                        ruleParam3.txn = this.B;
                        ruleParam3.source = "oba";
                        ruleParam3.duration = "1";
                        ruleParam3.durationUnit = "MONTH";
                        limit8.ruleParams = ruleParam3;
                        arrayList2.add(limit8);
                    }
                    if (!TextUtils.isEmpty(this.y)) {
                        BeneficiaryEntity.Limit limit9 = new BeneficiaryEntity.Limit();
                        limit9.ruleId = "LIMITS-2";
                        BeneficiaryEntity.RuleParam ruleParam4 = new BeneficiaryEntity.RuleParam();
                        ruleParam4.amount = this.y;
                        ruleParam4.source = "oba";
                        ruleParam4.duration = "1";
                        ruleParam4.durationUnit = "MONTH";
                        limit9.ruleParams = ruleParam4;
                        arrayList2.add(limit9);
                    }
                }
                if (this.v) {
                    if (!TextUtils.isEmpty(this.C)) {
                        BeneficiaryEntity.Limit limit10 = new BeneficiaryEntity.Limit();
                        limit10.ruleId = "LIMITS-1";
                        BeneficiaryEntity.RuleParam ruleParam5 = new BeneficiaryEntity.RuleParam();
                        ruleParam5.txn = this.C;
                        ruleParam5.source = "wallet";
                        ruleParam5.duration = "1";
                        ruleParam5.durationUnit = "MONTH";
                        limit10.ruleParams = ruleParam5;
                        arrayList2.add(limit10);
                    }
                    if (!TextUtils.isEmpty(this.z)) {
                        BeneficiaryEntity.Limit limit11 = new BeneficiaryEntity.Limit();
                        limit11.ruleId = "LIMITS-2";
                        BeneficiaryEntity.RuleParam ruleParam6 = new BeneficiaryEntity.RuleParam();
                        ruleParam6.amount = this.z;
                        ruleParam6.source = "wallet";
                        ruleParam6.duration = "1";
                        ruleParam6.durationUnit = "MONTH";
                        limit11.ruleParams = ruleParam6;
                        arrayList2.add(limit11);
                    }
                }
                if (this.s.instrumentPreferences.otherBank.accounts != null && !this.s.instrumentPreferences.otherBank.accounts.isEmpty()) {
                    this.s.instrumentPreferences.otherBank.accounts.get(0).limits = arrayList2;
                    this.s.instrumentPreferences.otherBank.accounts.get(0).source = source;
                }
            }
            h.a(this, this.s, new Response.Listener<IJRPaytmDataModel>() {
                public final /* synthetic */ void onResponse(Object obj) {
                    EditBeneficiaryV2Activity.this.a();
                    CJRAddBeneficiary cJRAddBeneficiary = (CJRAddBeneficiary) ((IJRPaytmDataModel) obj);
                    if (cJRAddBeneficiary.getError() != null) {
                        if (EditBeneficiaryV2Activity.this.K != null) {
                            EditBeneficiaryV2Activity.this.K.dismiss();
                        }
                        if (cJRAddBeneficiary.getError().getErrorMsg() != null) {
                            EditBeneficiaryV2Activity editBeneficiaryV2Activity = EditBeneficiaryV2Activity.this;
                            b.a((Context) editBeneficiaryV2Activity, editBeneficiaryV2Activity.getString(R.string.pb_mb_error), cJRAddBeneficiary.getError().getErrorMsg());
                            return;
                        }
                        EditBeneficiaryV2Activity editBeneficiaryV2Activity2 = EditBeneficiaryV2Activity.this;
                        b.a((Context) editBeneficiaryV2Activity2, editBeneficiaryV2Activity2.getString(R.string.pb_mb_error), EditBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
                    } else if (cJRAddBeneficiary.getAskOTP().equalsIgnoreCase("1")) {
                        if (EditBeneficiaryV2Activity.this.K == null || !EditBeneficiaryV2Activity.this.K.isShowing()) {
                            EditBeneficiaryV2Activity editBeneficiaryV2Activity3 = EditBeneficiaryV2Activity.this;
                            b unused = editBeneficiaryV2Activity3.K = new b(editBeneficiaryV2Activity3, cJRAddBeneficiary.getReferenceNumber(), EditBeneficiaryV2Activity.this.f53219a, EditBeneficiaryV2Activity.this.P);
                            EditBeneficiaryV2Activity.this.K.show();
                            return;
                        }
                        EditBeneficiaryV2Activity.this.K.f53257a = cJRAddBeneficiary.getReferenceNumber();
                    } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
                        e.a(EditBeneficiaryV2Activity.this, f.a().getBeneficiaryLimitUpdateMsg(EditBeneficiaryV2Activity.this));
                    }
                }
            }, new Response.ErrorListener() {
                public final void onErrorResponse(VolleyError volleyError) {
                    EditBeneficiaryV2Activity.this.a();
                    EditBeneficiaryV2Activity editBeneficiaryV2Activity = EditBeneficiaryV2Activity.this;
                    b.a((Context) editBeneficiaryV2Activity, editBeneficiaryV2Activity.getString(R.string.pb_mb_error), EditBeneficiaryV2Activity.this.getString(R.string.some_went_wrong));
                }
            });
            return;
        }
        a(this, getString(R.string.no_internet));
    }
}
