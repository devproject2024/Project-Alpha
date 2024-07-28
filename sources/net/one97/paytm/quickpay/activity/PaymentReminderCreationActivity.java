package net.one97.paytm.quickpay.activity;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.loader.a.a;
import androidx.loader.b.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.airbnb.lottie.LottieAnimationView;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.h;
import com.paytm.utility.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.common.entity.quick_pay.Payload;
import net.one97.paytm.common.entity.quick_pay.QuickListResponse;
import net.one97.paytm.common.entity.quick_pay.QuickPayAddResponse;
import net.one97.paytm.common.entity.quick_pay.StandingInstructionList;
import net.one97.paytm.common.entity.quick_pay.SupportingData;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.common.entity.wallet.RecentScan;
import net.one97.paytm.common.entity.wallet.RecentSendMoney;
import net.one97.paytm.common.widgets.CJRFlowLayout;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.quickpay.a.c;
import net.one97.paytm.quickpay.activity.QuickPaymentActivity;
import net.one97.paytm.quickpay.widget.datetimepicker.b.b;
import net.one97.paytm.quickpay.widget.datetimepicker.view.DateTimeView;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.ax;
import net.one97.paytm.utils.r;
import org.json.JSONException;
import org.json.JSONObject;

public class PaymentReminderCreationActivity extends QuickPaymentActivity implements View.OnClickListener, a.C0056a<Cursor>, b, ax.a {
    private LottieAnimationView A;
    /* access modifiers changed from: private */
    public String B;
    /* access modifiers changed from: private */
    public boolean C;
    /* access modifiers changed from: private */
    public boolean D;
    private StaggeredGridLayoutManager E;
    /* access modifiers changed from: private */
    public ArrayList<IJRDataModel> F = new ArrayList<>();
    /* access modifiers changed from: private */
    public net.one97.paytm.quickpay.a.a G;
    private boolean H;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private int S;
    private int T;
    private CJRFlowLayout U;
    /* access modifiers changed from: private */
    public RelativeLayout V;
    private RelativeLayout W;
    private View.OnFocusChangeListener X = new View.OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            if (z) {
                PaymentReminderCreationActivity.this.findViewById(R.id.payment_reminder_separator_view).setBackgroundColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.color_b8c2cb));
                PaymentReminderCreationActivity.this.f59934a.setBackgroundColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.color_00b9f5));
            } else if (TextUtils.isEmpty(PaymentReminderCreationActivity.this.f59935c.getText().toString())) {
                PaymentReminderCreationActivity.this.f59934a.setBackgroundColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.color_b8c2cb));
            }
        }
    };
    private TextWatcher Y = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable == null || editable.toString().length() == 0) {
                ((TextView) PaymentReminderCreationActivity.this.findViewById(R.id.qp_country_code_tv)).setTextColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.color_b8c2cb));
            } else {
                ((TextView) PaymentReminderCreationActivity.this.findViewById(R.id.qp_country_code_tv)).setTextColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.black));
            }
            if (!PaymentReminderCreationActivity.this.D) {
                PaymentReminderCreationActivity.this.f59938f.setVisibility(8);
                editable.toString().replace(" ", "").trim();
                if (editable.length() > 0) {
                    PaymentReminderCreationActivity.this.f59935c.setHint("");
                    PaymentReminderCreationActivity.this.f59936d.setVisibility(0);
                } else {
                    PaymentReminderCreationActivity.this.f59935c.setHint(PaymentReminderCreationActivity.this.getResources().getString(R.string.cp_enter_mobile_numbber));
                    PaymentReminderCreationActivity.this.f59936d.setVisibility(8);
                }
                if (editable.length() == 6 && ' ' == editable.charAt(editable.length() - 1)) {
                    editable.delete(editable.length() - 1, editable.length());
                }
                if (editable.length() == 6 && Character.isDigit(editable.charAt(editable.length() - 1))) {
                    InputFilter[] filters = editable.getFilters();
                    editable.setFilters(new InputFilter[0]);
                    editable.insert(editable.length() - 1, " ");
                    editable.setFilters(filters);
                }
                if (editable.length() < 10) {
                    PaymentReminderCreationActivity.this.f59939g.setText("");
                }
            }
            boolean unused = PaymentReminderCreationActivity.this.D = false;
        }
    };
    private TextWatcher Z = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            if (editable == null || editable.length() <= 0) {
                PaymentReminderCreationActivity.b(PaymentReminderCreationActivity.this, true);
            } else {
                PaymentReminderCreationActivity.b(PaymentReminderCreationActivity.this, false);
            }
            String unused = PaymentReminderCreationActivity.this.B = editable.toString();
            boolean unused2 = PaymentReminderCreationActivity.this.C = true;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public View f59934a;
    private AdapterView.OnItemClickListener aa = new AdapterView.OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            IJRDataModel a2 = ((net.one97.paytm.quickpay.a.a) adapterView.getAdapter()).getItem(i2);
            if (a2 != null) {
                if (a2 instanceof RecentSendMoney) {
                    RecentSendMoney recentSendMoney = (RecentSendMoney) a2;
                    String e2 = d.a().e(recentSendMoney.getPhoneNumber());
                    if (e2.length() > 10) {
                        e2 = d.a().a((Activity) PaymentReminderCreationActivity.this, e2);
                    }
                    if (PaymentReminderCreationActivity.b(e2)) {
                        String unused = PaymentReminderCreationActivity.this.k = "RECENT_NUMBER";
                        PaymentReminderCreationActivity.this.f59938f.setVisibility(8);
                        if (e2.length() > 5) {
                            String sb = new StringBuilder(e2).insert(5, ' ').toString();
                            boolean unused2 = PaymentReminderCreationActivity.this.D = true;
                            PaymentReminderCreationActivity.this.f59935c.setText(sb);
                            PaymentReminderCreationActivity.this.f59935c.setSelection(sb.length());
                        } else {
                            boolean unused3 = PaymentReminderCreationActivity.this.D = true;
                            PaymentReminderCreationActivity.this.f59935c.setText(e2);
                            PaymentReminderCreationActivity.this.f59935c.setSelection(e2.length());
                        }
                        if (TextUtils.isEmpty(recentSendMoney.getName())) {
                            PaymentReminderCreationActivity.this.f59939g.setVisibility(8);
                        } else {
                            PaymentReminderCreationActivity.this.f59939g.setVisibility(0);
                            PaymentReminderCreationActivity.this.f59939g.setText(recentSendMoney.getName());
                        }
                        PaymentReminderCreationActivity.h(PaymentReminderCreationActivity.this);
                    } else {
                        PaymentReminderCreationActivity.this.f59938f.setVisibility(0);
                        PaymentReminderCreationActivity.this.f59938f.setText(PaymentReminderCreationActivity.this.getString(R.string.p2p_phone_number_selection_error));
                    }
                } else if (a2 instanceof RecentScan) {
                    PaymentReminderCreationActivity.this.a((RecentScan) a2);
                }
            }
            PaymentReminderCreationActivity.this.m.setVisibility(8);
            PaymentReminderCreationActivity.this.n.setVisibility(0);
            PaymentReminderCreationActivity.this.f59935c.setSelection(PaymentReminderCreationActivity.this.f59935c.getText().length());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AutoCompleteTextView f59935c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ImageView f59936d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f59937e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f59938f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f59939g;

    /* renamed from: h  reason: collision with root package name */
    private final char f59940h = ' ';

    /* renamed from: i  reason: collision with root package name */
    private final int f59941i = 202;
    private ArrayList<IJRDataModel> j;
    /* access modifiers changed from: private */
    public String k = "MOBILE";
    private LinearLayout l;
    /* access modifiers changed from: private */
    public LinearLayout m;
    /* access modifiers changed from: private */
    public LinearLayout n;
    private RecyclerView o;
    /* access modifiers changed from: private */
    public ArrayList<CJRHomePageLayoutV2> p;
    /* access modifiers changed from: private */
    public LinearLayout q;
    private ExpandableListView r;
    /* access modifiers changed from: private */
    public net.one97.paytm.quickpay.a.b s;
    private EditText t;
    /* access modifiers changed from: private */
    public a u;
    private final int v = 201;
    /* access modifiers changed from: private */
    public CJRHomePageItem w;
    private int x;
    private String y;
    private TextView z;

    public final void a(int i2) {
    }

    public final void a(c<Cursor> cVar) {
    }

    public final /* synthetic */ void a(c cVar, Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && this.u == null) {
            this.u = new a(this);
            this.u.execute(new Cursor[]{cursor});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.lyt_payment_reminder_creation);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.H = getIntent().getBooleanExtra("is_called_post_txn_screen", false);
        this.I = getIntent().getStringExtra("quick_mobile_number");
        this.J = getIntent().getStringExtra(PayUtility.ACCOUNT_NUMBER);
        this.K = getIntent().getStringExtra("vpa");
        this.M = getIntent().getStringExtra("quick_amount");
        this.N = getIntent().getStringExtra("tag_name");
        this.P = getIntent().getStringExtra("tag_url");
        this.Q = getIntent().getStringExtra("account_holder_name");
        this.R = getIntent().getStringExtra("quick_pay_mode");
        this.L = getIntent().getStringExtra("ifsc_code");
        this.O = getIntent().getStringExtra(PayUtility.BANK_NAME);
        this.f59934a = findViewById(R.id.phone_number_separator_view);
        this.f59935c = (AutoCompleteTextView) findViewById(R.id.p2p_cp_contact_et);
        this.U = (CJRFlowLayout) findViewById(R.id.flow_to_lyt);
        this.f59939g = (TextView) findViewById(R.id.contact_name_txt);
        this.W = (RelativeLayout) findViewById(R.id.view_container_done);
        if (!this.H) {
            ((TextView) findViewById(R.id.txt_header)).setText(getString(R.string.qp_heading_creation));
            ((TextView) findViewById(R.id.qp_country_code_tv)).setText("+91");
            ((TextView) findViewById(R.id.qp_country_code_tv)).setTextColor(getResources().getColor(R.color.color_b8c2cb));
            this.f59935c.addTextChangedListener(this.Y);
            this.f59935c.setOnFocusChangeListener(this.X);
            this.f59935c.setThreshold(1);
            this.f59937e = (ImageView) findViewById(R.id.p2p_cp_contact_iv);
            this.f59937e.setOnClickListener(this);
        } else {
            ((TextView) findViewById(R.id.qp_country_code_tv)).setText(getString(R.string.rs_symbol));
            ((TextView) findViewById(R.id.qp_country_code_tv)).setTextColor(getResources().getColor(R.color.black));
            ((TextView) findViewById(R.id.txt_header)).setText(getString(R.string.payment_reminder_from_post_txn_header, new Object[]{com.paytm.utility.b.A(this.N)}));
            this.f59935c.setHint((CharSequence) null);
            this.f59935c.setText(this.M);
            if (!TextUtils.isEmpty(this.M)) {
                this.f59935c.setSelection(this.M.length());
            }
            this.f59937e = (ImageView) findViewById(R.id.p2p_cp_contact_iv);
            this.f59937e.setVisibility(8);
            this.f59939g.setVisibility(8);
            findViewById(R.id.p2p_cp_recent_tv).setVisibility(8);
        }
        this.f59938f = (TextView) findViewById(R.id.enter_number_tv);
        this.f59938f.setVisibility(8);
        this.f59936d = (ImageView) findViewById(R.id.p2p_cp_clear_iv);
        this.f59936d.setVisibility(8);
        this.f59936d.setOnClickListener(this);
        this.W.setOnClickListener(this);
        ((LinearLayout) findViewById(R.id.qpe_date_tym_ll)).addView(new DateTimeView(this, getSupportFragmentManager(), this).getDateView());
        this.l = (LinearLayout) findViewById(R.id.so_cp_recent_ll);
        this.o = (RecyclerView) findViewById(R.id.so_horizontal_recent_rv);
        this.q = (LinearLayout) findViewById(R.id.progress_dialog);
        this.V = (RelativeLayout) findViewById(R.id.qp_types);
        this.E = new StaggeredGridLayoutManager();
        this.t = (EditText) findViewById(R.id.edt_enter_qp);
        this.m = (LinearLayout) findViewById(R.id.contact_picker_container);
        this.r = (ExpandableListView) findViewById(R.id.p2p_contact_elv);
        this.n = (LinearLayout) findViewById(R.id.container);
        this.z = (TextView) findViewById(R.id.qp_add_tv);
        this.z.setOnClickListener(this);
        this.A = (LottieAnimationView) findViewById(R.id.dot_progress_bar);
        findViewById(R.id.back_arrow).setOnClickListener(this);
        this.t.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 == 6) {
                    return PaymentReminderCreationActivity.this.b();
                }
                return false;
            }
        });
        if (Build.VERSION.SDK_INT < 23 || androidx.core.content.b.a((Context) this, "android.permission.READ_CONTACTS") == 0) {
            getSupportLoaderManager().a(0, (Bundle) null, this);
        } else {
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 201);
        }
        this.A.setVisibility(0);
        this.A.setAnimation("Payments-Loader.json");
        this.A.loop(true);
        this.A.playAnimation();
        b(getResources().getColor(R.color.white));
        d.a().a("/personal-payments", "homescreen", (Activity) this);
        if (!this.H) {
            this.j = d.a().h((Activity) this);
            ArrayList<IJRDataModel> arrayList = this.j;
            if (arrayList == null || arrayList.size() <= 0) {
                this.l.setVisibility(8);
            } else {
                this.o.setVisibility(0);
                this.n.setVisibility(0);
                net.one97.paytm.quickpay.a.c cVar = new net.one97.paytm.quickpay.a.c(this, this.j, new c.b() {
                    public final void a(IJRDataModel iJRDataModel) {
                        if (iJRDataModel != null) {
                            if (iJRDataModel instanceof RecentSendMoney) {
                                RecentSendMoney recentSendMoney = (RecentSendMoney) iJRDataModel;
                                String e2 = d.a().e(recentSendMoney.getPhoneNumber());
                                if (e2.length() > 10) {
                                    e2 = d.a().a((Activity) PaymentReminderCreationActivity.this, e2);
                                }
                                if (PaymentReminderCreationActivity.b(e2)) {
                                    String unused = PaymentReminderCreationActivity.this.k = "RECENT_NUMBER";
                                    if (e2.length() > 5) {
                                        e2 = new StringBuilder(e2).insert(5, ' ').toString();
                                    }
                                    PaymentReminderCreationActivity.this.f59935c.setText(e2);
                                    PaymentReminderCreationActivity.this.f59935c.setSelection(e2.length());
                                    if (TextUtils.isEmpty(recentSendMoney.getName())) {
                                        PaymentReminderCreationActivity.this.f59939g.setVisibility(8);
                                    } else {
                                        PaymentReminderCreationActivity.this.f59939g.setVisibility(0);
                                        PaymentReminderCreationActivity.this.f59939g.setText(recentSendMoney.getName());
                                    }
                                    PaymentReminderCreationActivity.h(PaymentReminderCreationActivity.this);
                                } else {
                                    PaymentReminderCreationActivity.this.f59938f.setVisibility(0);
                                    PaymentReminderCreationActivity.this.f59938f.setText(PaymentReminderCreationActivity.this.getString(R.string.p2p_phone_number_selection_error));
                                }
                            } else if (iJRDataModel instanceof RecentScan) {
                                PaymentReminderCreationActivity.this.a((RecentScan) iJRDataModel);
                            }
                        }
                        PaymentReminderCreationActivity.this.m.setVisibility(8);
                        PaymentReminderCreationActivity.this.n.setVisibility(0);
                        PaymentReminderCreationActivity.this.f59935c.setSelection(PaymentReminderCreationActivity.this.f59935c.getText().length());
                    }
                });
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                linearLayoutManager.setOrientation(0);
                this.o.setLayoutManager(linearLayoutManager);
                this.o.setAdapter(cVar);
            }
            ArrayList<IJRDataModel> arrayList2 = this.j;
            if (arrayList2 != null && arrayList2.size() > 0) {
                this.F.addAll(this.j);
            }
            this.G = new net.one97.paytm.quickpay.a.a(this, this.F);
            this.f59935c.setAdapter(this.G);
            this.f59935c.setOnItemClickListener(this.aa);
        }
        this.p = net.one97.paytm.quickpay.d.a.a().d();
        ArrayList<CJRHomePageLayoutV2> arrayList3 = this.p;
        if (arrayList3 == null || arrayList3.size() <= 1) {
            this.V.setVisibility(8);
            this.q.setVisibility(0);
        } else {
            this.V.setVisibility(0);
            this.q.setVisibility(8);
            a(this.p);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", d.a().b((Context) this));
        hashMap.put("Content-Type", "application/json");
        com.paytm.network.a a2 = d.a(this, d.b().a("categoryUrl"), new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if ((iJRPaytmDataModel instanceof CJRHomePageV2) && iJRPaytmDataModel != null) {
                    net.one97.paytm.quickpay.d.a a2 = net.one97.paytm.quickpay.d.a.a();
                    CJRHomePageV2 cJRHomePageV2 = (CJRHomePageV2) iJRPaytmDataModel;
                    try {
                        ag.a(d.b().a()).a("default_quick_pay", new f().b(cJRHomePageV2), true);
                    } catch (Exception unused) {
                    }
                    a2.f60095b = cJRHomePageV2;
                    PaymentReminderCreationActivity.this.q.setVisibility(8);
                    PaymentReminderCreationActivity.this.V.setVisibility(0);
                    PaymentReminderCreationActivity.this.q.setVisibility(8);
                    if (PaymentReminderCreationActivity.this.s == null) {
                        ArrayList unused2 = PaymentReminderCreationActivity.this.p = net.one97.paytm.quickpay.d.a.a().d();
                        if (PaymentReminderCreationActivity.this.p != null && PaymentReminderCreationActivity.this.p.size() > 0) {
                            PaymentReminderCreationActivity paymentReminderCreationActivity = PaymentReminderCreationActivity.this;
                            paymentReminderCreationActivity.a((ArrayList<CJRHomePageLayoutV2>) paymentReminderCreationActivity.p);
                        }
                    }
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                try {
                    PaymentReminderCreationActivity.this.q.setVisibility(8);
                    PaymentReminderCreationActivity.this.V.setVisibility(0);
                    PaymentReminderCreationActivity.this.q.setVisibility(8);
                    if (PaymentReminderCreationActivity.this.s == null) {
                        Toast.makeText(PaymentReminderCreationActivity.this, PaymentReminderCreationActivity.this.getString(R.string.something_wrong_try_again), 1).show();
                    }
                } catch (Exception unused) {
                }
            }
        }, hashMap, (Map<String, String>) null, a.C0715a.POST, (String) null, new CJRHomePageV2(), a.c.PAYMENTS, a.b.SILENT);
        if (com.paytm.utility.a.m(this)) {
            ArrayList<CJRHomePageLayoutV2> arrayList4 = this.p;
            if (arrayList4 == null || arrayList4.isEmpty()) {
                this.q.setVisibility(0);
            }
            a2.a();
            return;
        }
        h hVar = new h(this);
        hVar.setTitle(getResources().getString(R.string.no_connection));
        hVar.a(getResources().getString(R.string.no_internet));
        hVar.setCanceledOnTouchOutside(false);
        hVar.a(-3, getResources().getString(R.string.p2p_ok), new View.OnClickListener(hVar) {

            /* renamed from: a */
            final /* synthetic */ h f60000a;

            public final void onClick(
/*
Method generation error in method: net.one97.paytm.quickpay.activity.QuickPaymentActivity.5.onClick(android.view.View):void, dex: classes6.dex
            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.quickpay.activity.QuickPaymentActivity.5.onClick(android.view.View):void, class status: UNLOADED
            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
            	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
            	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
            	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
            	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            
*/
        });
        hVar.show();
    }

    public void onClick(View view) {
        int id = view.getId();
        String str = "";
        if (id == R.id.p2p_cp_clear_iv) {
            this.f59935c.setText(str);
            this.f59939g.setVisibility(8);
        } else if (id == R.id.p2p_cp_contact_iv) {
            try {
                startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 202);
            } catch (Exception unused) {
            }
        } else if (id == R.id.qp_add_tv) {
            if (this.H) {
                StandingInstructionList standingInstructionList = new StandingInstructionList();
                String charSequence = this.f59939g.getText().toString();
                String str2 = this.I;
                String obj = this.f59935c.getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    this.f59935c.setError(getString(R.string.enter_amount));
                    this.f59935c.requestFocus();
                    return;
                }
                CJRHomePageItem cJRHomePageItem = this.w;
                if (cJRHomePageItem == null) {
                    Toast.makeText(this, getString(R.string.qp_reminder_type), 1).show();
                } else if (cJRHomePageItem != null && TextUtils.isEmpty(cJRHomePageItem.getName()) && this.w.getName().equalsIgnoreCase("null")) {
                    Toast.makeText(this, getString(R.string.qp_reminder_type), 1).show();
                } else if (TextUtils.isEmpty(this.y)) {
                    Toast.makeText(this, getString(R.string.qp_reminder_type), 1).show();
                } else {
                    if (!TextUtils.isEmpty(str2)) {
                        str2 = str2.replaceAll(" ", str);
                        String b2 = com.paytm.utility.a.b((Context) this);
                        if (!TextUtils.isEmpty(b2) && str2.contains(b2)) {
                            Toast.makeText(this, getString(R.string.qp_user_pay_num_same_error), 1).show();
                            return;
                        }
                    }
                    standingInstructionList.setType("QUICK_PAYMENTS");
                    if (!TextUtils.isEmpty(charSequence)) {
                        standingInstructionList.setReminderDisplayName(charSequence);
                    }
                    SupportingData supportingData = new SupportingData();
                    if (!TextUtils.isEmpty(str2)) {
                        supportingData.setBeneficiaryMobileNumber(str2);
                        if (TextUtils.isEmpty(charSequence)) {
                            standingInstructionList.setReminderDisplayName(this.I);
                        }
                    } else if (!TextUtils.isEmpty(this.K)) {
                        supportingData.setBeneficiaryUpiAddress(this.K);
                        supportingData.setBeneficiaryName(this.N);
                        supportingData.setBeneficiaryMobileNumber((String) null);
                        supportingData.setBeneficiaryAccountNumber((String) null);
                        supportingData.setBeneficiaryIfscCode((String) null);
                        supportingData.setBeneficiaryBankName((String) null);
                        if (TextUtils.isEmpty(charSequence)) {
                            standingInstructionList.setReminderDisplayName(this.N);
                        }
                    } else if (!TextUtils.isEmpty(this.J)) {
                        supportingData.setBeneficiaryAccountNumber(this.J);
                        supportingData.setBeneficiaryIfscCode(this.L);
                        supportingData.setBeneficiaryName(this.Q);
                        supportingData.setBeneficiaryBankName(this.O);
                        supportingData.setBeneficiaryMobileNumber((String) null);
                        supportingData.setBeneficiaryUpiAddress((String) null);
                        if (TextUtils.isEmpty(charSequence)) {
                            standingInstructionList.setReminderDisplayName(this.Q);
                        }
                    }
                    supportingData.setTagUrl(this.P);
                    supportingData.setTagName(this.w.getName());
                    supportingData.setTagUrl(this.C ? str : this.w.getImageUrl());
                    supportingData.setTagId(this.C ? str : this.w.getListId());
                    supportingData.setPaymentType("personal");
                    if (!this.C) {
                        str = this.w.getSubtitle();
                    }
                    supportingData.setStoreFrontTitle(str);
                    standingInstructionList.setSupportingData(supportingData);
                    standingInstructionList.setEnablePaymentsReminder(true);
                    standingInstructionList.setReminderTimeRange("9-23");
                    standingInstructionList.setReminderDayOfWeek((String) null);
                    standingInstructionList.setReminderDateIndex(this.y);
                    standingInstructionList.setReminderFrequency("monthly");
                    standingInstructionList.setStartDate((String) null);
                    standingInstructionList.setNextReminderDate((String) null);
                    standingInstructionList.setAmount(obj);
                    a(standingInstructionList);
                }
            } else {
                StandingInstructionList standingInstructionList2 = new StandingInstructionList();
                String charSequence2 = this.f59939g.getText().toString();
                String obj2 = this.f59935c.getText().toString();
                if (com.paytm.utility.b.b(TextUtils.isEmpty(obj2) ? obj2 : obj2.replaceAll(" ", str)) || this.H) {
                    CJRHomePageItem cJRHomePageItem2 = this.w;
                    if (cJRHomePageItem2 == null) {
                        Toast.makeText(this, getString(R.string.qp_reminder_type), 1).show();
                    } else if (cJRHomePageItem2 != null && TextUtils.isEmpty(cJRHomePageItem2.getName()) && this.w.getName().equalsIgnoreCase("null")) {
                        Toast.makeText(this, getString(R.string.qp_reminder_type), 1).show();
                    } else if (TextUtils.isEmpty(this.y)) {
                        Toast.makeText(this, getString(R.string.qp_reminder_type), 1).show();
                    } else {
                        String replaceAll = obj2.replaceAll(" ", str);
                        String b3 = com.paytm.utility.a.b((Context) this);
                        if (TextUtils.isEmpty(b3) || !replaceAll.contains(b3)) {
                            standingInstructionList2.setType("QUICK_PAYMENTS");
                            if (!TextUtils.isEmpty(charSequence2)) {
                                standingInstructionList2.setReminderDisplayName(charSequence2);
                            }
                            SupportingData supportingData2 = new SupportingData();
                            if (!TextUtils.isEmpty(replaceAll)) {
                                supportingData2.setBeneficiaryMobileNumber(replaceAll);
                                if (TextUtils.isEmpty(charSequence2)) {
                                    standingInstructionList2.setReminderDisplayName(replaceAll);
                                }
                            } else if (!TextUtils.isEmpty(this.K)) {
                                supportingData2.setBeneficiaryUpiAddress(this.K);
                                supportingData2.setBeneficiaryName(this.N);
                                supportingData2.setBeneficiaryMobileNumber((String) null);
                                supportingData2.setBeneficiaryAccountNumber((String) null);
                                supportingData2.setBeneficiaryIfscCode((String) null);
                                supportingData2.setBeneficiaryBankName((String) null);
                                if (TextUtils.isEmpty(charSequence2)) {
                                    standingInstructionList2.setReminderDisplayName(this.N);
                                }
                            } else if (!TextUtils.isEmpty(this.J)) {
                                supportingData2.setBeneficiaryAccountNumber(this.J);
                                supportingData2.setBeneficiaryIfscCode(this.L);
                                supportingData2.setBeneficiaryName(this.Q);
                                supportingData2.setBeneficiaryBankName(this.O);
                                supportingData2.setBeneficiaryMobileNumber((String) null);
                                supportingData2.setBeneficiaryUpiAddress((String) null);
                                if (TextUtils.isEmpty(charSequence2)) {
                                    standingInstructionList2.setReminderDisplayName(this.Q);
                                }
                            }
                            supportingData2.setTagUrl(this.P);
                            supportingData2.setTagName(this.w.getName());
                            supportingData2.setTagUrl(this.C ? str : this.w.getImageUrl());
                            supportingData2.setTagId(this.C ? str : this.w.getListId());
                            supportingData2.setPaymentType("personal");
                            if (!this.C) {
                                str = this.w.getSubtitle();
                            }
                            supportingData2.setStoreFrontTitle(str);
                            standingInstructionList2.setSupportingData(supportingData2);
                            standingInstructionList2.setEnablePaymentsReminder(true);
                            standingInstructionList2.setReminderTimeRange("9-23");
                            standingInstructionList2.setReminderDayOfWeek((String) null);
                            standingInstructionList2.setReminderDateIndex(this.y);
                            standingInstructionList2.setReminderFrequency("monthly");
                            standingInstructionList2.setStartDate((String) null);
                            standingInstructionList2.setNextReminderDate((String) null);
                            standingInstructionList2.setAmount(this.M);
                            a(standingInstructionList2);
                            return;
                        }
                        Toast.makeText(this, getString(R.string.qp_user_pay_num_same_error), 1).show();
                    }
                } else {
                    this.f59935c.setError(getString(R.string.enter_valid_mobile_number));
                    this.f59935c.requestFocus();
                }
            }
        } else if (id == R.id.back_arrow) {
            finish();
        } else if (id == R.id.view_container_done) {
            b();
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                if (Integer.parseInt(String.valueOf(str.charAt(0))) <= 4 || str.length() != 10) {
                    return false;
                }
                return true;
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 202) {
            Cursor cursor = null;
            try {
                Cursor query = getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
                query.moveToFirst();
                int columnIndex = query.getColumnIndex("data1");
                int columnIndex2 = query.getColumnIndex("display_name");
                String string = query.getString(columnIndex);
                String string2 = query.getString(columnIndex2);
                String e2 = d.a().e(string);
                if (e2.length() > 10) {
                    e2 = d.a().a((Activity) this, e2);
                }
                this.f59939g.setText("");
                if (b(e2)) {
                    this.f59938f.setVisibility(8);
                    if (e2.length() > 5) {
                        String sb = new StringBuilder(e2).insert(5, ' ').toString();
                        this.D = true;
                        this.f59935c.setText(sb);
                        this.f59935c.setSelection(sb.length());
                    } else {
                        this.D = true;
                        this.f59935c.setText(e2);
                        this.f59935c.setSelection(e2.length());
                    }
                    if (TextUtils.isEmpty(string2)) {
                        this.f59939g.setVisibility(8);
                    } else {
                        this.f59939g.setText(string2);
                        this.f59939g.setVisibility(0);
                    }
                } else {
                    if (e2.length() > 5) {
                        e2 = new StringBuilder(e2).insert(5, ' ').toString();
                    }
                    this.D = true;
                    this.f59935c.setText(e2);
                    this.f59935c.setSelection(this.f59935c.getText().length());
                    this.f59938f.setVisibility(0);
                    this.f59938f.setText(getString(R.string.p2p_phone_number_selection_error));
                    this.f59939g.setVisibility(8);
                }
                if (query != null && !query.isClosed()) {
                    query.close();
                }
            } catch (Exception e3) {
                q.b(e3.getMessage());
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
                throw th;
            }
        }
    }

    public final void a(String str, int i2) {
        this.x = i2;
        this.y = str;
    }

    /* access modifiers changed from: private */
    public void a(ArrayList<CJRHomePageLayoutV2> arrayList) {
        b(arrayList.get(0).getHomePageItemList());
    }

    class a extends AsyncTask<Cursor, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<PaymentReminderCreationActivity> f59961b;

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            if (this.f59961b.get() != null && !isCancelled() && ((PaymentReminderCreationActivity) this.f59961b.get()).G != null) {
                net.one97.paytm.quickpay.a.a p = ((PaymentReminderCreationActivity) this.f59961b.get()).G;
                ArrayList o = PaymentReminderCreationActivity.this.F;
                if (o != null && o.size() > 0) {
                    p.f59823a.clear();
                    p.f59823a.addAll(o);
                    p.f59824b.clear();
                    p.f59824b.addAll(o);
                    p.notifyDataSetChanged();
                }
            }
        }

        public a(PaymentReminderCreationActivity paymentReminderCreationActivity) {
            this.f59961b = new WeakReference<>(paymentReminderCreationActivity);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public Void doInBackground(Cursor... cursorArr) {
            try {
                Cursor cursor = cursorArr[0];
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                cursor.moveToFirst();
                while (!cursor.isAfterLast() && !isCancelled()) {
                    String string = cursor.getString(cursor.getColumnIndex("display_name"));
                    String e2 = d.a().e(cursor.getString(cursor.getColumnIndex("data1")));
                    if (e2.length() > 10) {
                        e2 = d.a().a((Activity) PaymentReminderCreationActivity.this, e2);
                    }
                    if (PaymentReminderCreationActivity.b(e2)) {
                        if (!arrayList2.contains(string)) {
                            arrayList2.add(string);
                            arrayList3.add(e2);
                            arrayList.add(new RecentSendMoney(string, e2));
                        } else if (!arrayList3.contains(e2)) {
                            arrayList3.add(e2);
                            arrayList.add(new RecentSendMoney(string, e2));
                        }
                    }
                    cursor.moveToNext();
                }
                if (this.f59961b.get() == null) {
                    return null;
                }
                ((PaymentReminderCreationActivity) this.f59961b.get()).F.addAll(arrayList);
                return null;
            } catch (Exception unused) {
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public final void onCancelled() {
            super.onCancelled();
            if (this.f59961b.get() != null) {
                a unused = ((PaymentReminderCreationActivity) this.f59961b.get()).u = null;
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        a aVar = this.u;
        if (aVar != null) {
            aVar.cancel(true);
        }
    }

    public final androidx.loader.b.c<Cursor> a(Bundle bundle) {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        int i2 = Build.VERSION.SDK_INT;
        return new androidx.loader.b.b(this, uri, new String[]{"display_name", "data1"}, (String) null, (String[]) null, "display_name");
    }

    private void a(final StandingInstructionList standingInstructionList) {
        String a2 = d.b().a("addQuickPaymentUrl");
        if (URLUtil.isValidUrl(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b((Context) this));
            hashMap.put("Content-Type", "application/json");
            try {
                JSONObject jSONObject = new JSONObject(new f().b(standingInstructionList));
                a((Context) this, getResources().getString(R.string.loading));
                d.a(this, a2, new com.paytm.network.listener.b() {
                    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                        PaymentReminderCreationActivity.this.a();
                        if (iJRPaytmDataModel instanceof QuickPayAddResponse) {
                            QuickPayAddResponse quickPayAddResponse = (QuickPayAddResponse) iJRPaytmDataModel;
                            if (quickPayAddResponse.getResponseCode() == 200) {
                                standingInstructionList.setId(String.valueOf(quickPayAddResponse.getPayload().getSiId()));
                                PaymentReminderCreationActivity.b(PaymentReminderCreationActivity.this, standingInstructionList.getId());
                                return;
                            }
                            PaymentReminderCreationActivity.this.a("Error", quickPayAddResponse.getResponseMessage());
                            return;
                        }
                        PaymentReminderCreationActivity.this.a("Error", "Something went wrong");
                    }

                    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                        PaymentReminderCreationActivity.this.a();
                        if (networkCustomError == null || !(networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403)) {
                            String str = new String(networkCustomError.networkResponse.data);
                            if (!TextUtils.isEmpty(str)) {
                                try {
                                    JSONObject jSONObject = new JSONObject(str);
                                    if (jSONObject.has("responseMessage")) {
                                        String string = jSONObject.getString("responseMessage");
                                        if (!TextUtils.isEmpty(string)) {
                                            PaymentReminderCreationActivity.this.a("Error", string);
                                        } else {
                                            PaymentReminderCreationActivity.this.a("Error", "Something went wrong");
                                        }
                                    } else {
                                        PaymentReminderCreationActivity.this.a("Error", "Something went wrong");
                                    }
                                } catch (Exception unused) {
                                }
                            } else {
                                PaymentReminderCreationActivity.this.a("Error", "Something went wrong");
                            }
                        } else {
                            r.a(PaymentReminderCreationActivity.this, (String) null, (Bundle) null, false, false);
                        }
                    }
                }, hashMap, (Map<String, String>) null, a.C0715a.POST, jSONObject.toString(), new QuickPayAddResponse(), a.c.PAYMENTS, a.b.SILENT).a();
            } catch (JSONException e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public void onResume() {
        super.onResume();
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            try {
                if (clipboardManager.hasPrimaryClip() && clipboardManager.getPrimaryClip().getItemCount() > 0) {
                    String replaceAll = clipboardManager.getPrimaryClip().getItemAt(0).getText().toString().replaceAll("\\s+", "");
                    if (!TextUtils.isEmpty(replaceAll) && replaceAll.length() >= 10) {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, replaceAll.substring(replaceAll.length() - 10, replaceAll.length())));
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    private void b(ArrayList<CJRHomePageItem> arrayList) {
        CJRFlowLayout cJRFlowLayout = this.U;
        if (cJRFlowLayout != null && cJRFlowLayout.getChildCount() > 0) {
            this.U.removeAllViews();
        }
        Iterator<CJRHomePageItem> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            CJRHomePageItem next = it2.next();
            final View inflate = getLayoutInflater().inflate(R.layout.row_default_payment_reminder, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.txt_payment_reminder);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ic_add_qp);
            this.S = com.paytm.utility.a.t(this);
            this.T = this.S / 4;
            int i2 = this.T;
            inflate.setPadding(i2, i2 + 10, i2, 0);
            if (next.isOther()) {
                textView.setText(getString(R.string.qp_add_other));
                imageView.setVisibility(0);
            } else {
                textView.setText(next.getName());
                imageView.setVisibility(8);
            }
            inflate.setTag(next);
            this.U.addView(inflate);
            CJRFlowLayout cJRFlowLayout2 = this.U;
            int i3 = this.T;
            cJRFlowLayout2.setPadding(i3, i3, i3, 0);
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) inflate.getTag();
                    if (cJRHomePageItem != null) {
                        if (TextUtils.isEmpty(cJRHomePageItem.getName()) || cJRHomePageItem.getName().equalsIgnoreCase("null")) {
                            CJRHomePageItem unused = PaymentReminderCreationActivity.this.w = null;
                        } else {
                            CJRHomePageItem unused2 = PaymentReminderCreationActivity.this.w = cJRHomePageItem;
                        }
                        PaymentReminderCreationActivity.this.a(cJRHomePageItem);
                        PaymentReminderCreationActivity.c(PaymentReminderCreationActivity.this, cJRHomePageItem.isOther());
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(CJRHomePageItem cJRHomePageItem) {
        for (int i2 = 0; i2 < this.U.getChildCount(); i2++) {
            View childAt = this.U.getChildAt(i2);
            if (childAt != null) {
                CJRHomePageItem cJRHomePageItem2 = (CJRHomePageItem) childAt.getTag();
                if (cJRHomePageItem2.getName() == null || !cJRHomePageItem.getName().equalsIgnoreCase(cJRHomePageItem2.getName())) {
                    childAt.setSelected(false);
                    childAt.setAlpha(1.0f);
                    ((TextView) childAt.findViewById(R.id.txt_payment_reminder)).setTextColor(getResources().getColor(R.color.color_00b9f5));
                    ((ImageView) childAt.findViewById(R.id.ic_add_qp)).setSelected(false);
                    ((ImageView) childAt.findViewById(R.id.ic_add_qp)).setVisibility(cJRHomePageItem2.isOther() ? 0 : 8);
                } else {
                    childAt.setSelected(true);
                    childAt.setAlpha(1.0f);
                    ((TextView) childAt.findViewById(R.id.txt_payment_reminder)).setTextColor(getResources().getColor(R.color.white));
                    ((ImageView) childAt.findViewById(R.id.ic_add_qp)).setSelected(true);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean b() {
        if (TextUtils.isEmpty(this.B) || this.B.trim().length() < 4) {
            Toast.makeText(this, "Please enter payment name with more than 4 characters", 1).show();
            return true;
        }
        for (int i2 = 0; i2 < this.U.getChildCount(); i2++) {
            View childAt = this.U.getChildAt(i2);
            if (childAt != null) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) childAt.getTag();
                if (cJRHomePageItem.getName() != null && !TextUtils.isEmpty(this.B) && cJRHomePageItem.getName().trim().equalsIgnoreCase(this.B.replaceAll(" ", ""))) {
                    Toast.makeText(this, getString(R.string.error_duplicate_tag_name_qp), 1).show();
                    return false;
                }
            }
        }
        CJRHomePageItem cJRHomePageItem2 = new CJRHomePageItem();
        this.B = this.B.trim();
        cJRHomePageItem2.setName(this.B);
        if (this.U != null) {
            final View inflate = getLayoutInflater().inflate(R.layout.row_default_payment_reminder, (ViewGroup) null);
            this.S = com.paytm.utility.a.t(this);
            this.T = this.S / 4;
            inflate.setTag(cJRHomePageItem2);
            int i3 = this.T;
            inflate.setPadding(i3, i3 + 10, i3, 0);
            ((TextView) inflate.findViewById(R.id.txt_payment_reminder)).setText(cJRHomePageItem2.getName());
            ((ImageView) inflate.findViewById(R.id.ic_add_qp)).setVisibility(8);
            CJRFlowLayout cJRFlowLayout = this.U;
            cJRFlowLayout.addView(inflate, cJRFlowLayout.getChildCount() - 1);
            CJRFlowLayout cJRFlowLayout2 = this.U;
            int i4 = this.T;
            cJRFlowLayout2.setPadding(i4, i4, i4, 0);
            inflate.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) inflate.getTag();
                    if (cJRHomePageItem != null) {
                        if (TextUtils.isEmpty(cJRHomePageItem.getName()) || cJRHomePageItem.getName().equalsIgnoreCase("null")) {
                            CJRHomePageItem unused = PaymentReminderCreationActivity.this.w = null;
                        } else {
                            CJRHomePageItem unused2 = PaymentReminderCreationActivity.this.w = cJRHomePageItem;
                        }
                        PaymentReminderCreationActivity.this.a(cJRHomePageItem);
                        PaymentReminderCreationActivity.c(PaymentReminderCreationActivity.this, cJRHomePageItem.isOther());
                    }
                }
            });
        }
        this.t.setText("");
        this.w = cJRHomePageItem2;
        this.W.setVisibility(8);
        a(cJRHomePageItem2);
        a((View) this.t);
        return false;
    }

    private void a(View view) {
        if (view != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public final void a(RecentScan recentScan) {
        try {
            JSONObject jSONObject = new JSONObject(recentScan.getScanResult());
            jSONObject.remove("ORDER_ID");
            if (com.paytm.utility.a.p(this)) {
                String uniqKey = recentScan.getUniqKey();
                String jSONObject2 = jSONObject.toString();
                CJRQRScanResultModel cJRQRScanResultModel = new CJRQRScanResultModel();
                try {
                    cJRQRScanResultModel.parseData(new JSONObject(jSONObject2), (Context) this);
                } catch (JSONException e2) {
                    q.b(e2.getMessage());
                }
                if ("QR_CODE_REQUEST_MONEY".equalsIgnoreCase(cJRQRScanResultModel.getRequestType())) {
                    this.k = "RECENT_SCAN";
                    this.f59935c.setText(cJRQRScanResultModel.getMobileNo());
                    if (TextUtils.isEmpty(cJRQRScanResultModel.getName())) {
                        this.f59939g.setVisibility(8);
                    } else {
                        this.f59939g.setVisibility(0);
                        this.f59939g.setText(cJRQRScanResultModel.getName());
                    }
                }
                if (!TextUtils.isEmpty(uniqKey) && uniqKey.length() == 24) {
                    d.a().a((Context) this, uniqKey);
                }
            }
        } catch (Exception e3) {
            q.b(e3.getMessage());
        }
    }

    static /* synthetic */ void h(PaymentReminderCreationActivity paymentReminderCreationActivity) {
        View currentFocus = paymentReminderCreationActivity.getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) paymentReminderCreationActivity.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    static /* synthetic */ void b(PaymentReminderCreationActivity paymentReminderCreationActivity, String str) {
        String a2 = d.b().a("getQuickPaymentsUrl");
        if (!TextUtils.isEmpty(a2)) {
            HashMap hashMap = new HashMap();
            hashMap.put("Authorization", d.a().b((Context) paymentReminderCreationActivity));
            com.paytm.network.a a3 = d.a(paymentReminderCreationActivity, a2 + "&siId=" + str, new com.paytm.network.listener.b() {
                public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                    PaymentReminderCreationActivity.this.a();
                    if (iJRPaytmDataModel != null) {
                        QuickListResponse quickListResponse = (QuickListResponse) iJRPaytmDataModel;
                        Payload payload = quickListResponse.getPayload();
                        if (payload == null || payload.getStandingInstructionList() == null || payload.getStandingInstructionList().size() <= 0) {
                            String responseMessage = quickListResponse.getResponseMessage();
                            if (TextUtils.isEmpty(responseMessage)) {
                                responseMessage = "Something went wrong";
                            }
                            PaymentReminderCreationActivity.this.a("Error", responseMessage);
                            return;
                        }
                        StandingInstructionList standingInstructionList = payload.getStandingInstructionList().get(0);
                        if (standingInstructionList != null) {
                            net.one97.paytm.quickpay.b.a.a((Context) PaymentReminderCreationActivity.this, standingInstructionList);
                            PaymentReminderCreationActivity paymentReminderCreationActivity = PaymentReminderCreationActivity.this;
                            paymentReminderCreationActivity.a(paymentReminderCreationActivity, paymentReminderCreationActivity.getResources().getString(R.string.qp_save_successfully), new QuickPaymentActivity.a() {
                                public final void a() {
                                    PaymentReminderCreationActivity.this.setResult(-1);
                                    PaymentReminderCreationActivity.this.finish();
                                }
                            });
                            return;
                        }
                        String responseMessage2 = quickListResponse.getResponseMessage();
                        if (TextUtils.isEmpty(responseMessage2)) {
                            responseMessage2 = "Something went wrong";
                        }
                        PaymentReminderCreationActivity.this.a("Error", responseMessage2);
                        return;
                    }
                    PaymentReminderCreationActivity.this.a("Error", "Something went wrong");
                }

                public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    PaymentReminderCreationActivity.this.a();
                    PaymentReminderCreationActivity.this.a("Error", "Something went wrong");
                }
            }, hashMap, (Map<String, String>) null, a.C0715a.GET, (String) null, new QuickListResponse(), a.c.PAYMENTS, a.b.SILENT);
            if (com.paytm.utility.a.m(paymentReminderCreationActivity)) {
                a3.a();
            }
        }
    }

    static /* synthetic */ void b(PaymentReminderCreationActivity paymentReminderCreationActivity, boolean z2) {
        for (int i2 = 0; i2 < paymentReminderCreationActivity.U.getChildCount(); i2++) {
            View childAt = paymentReminderCreationActivity.U.getChildAt(i2);
            if (childAt != null) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) childAt.getTag();
                if (cJRHomePageItem.getName() != null && (cJRHomePageItem.getName().equalsIgnoreCase("") || cJRHomePageItem.getName().equalsIgnoreCase("null"))) {
                    if (z2) {
                        childAt.setAlpha(1.0f);
                    } else {
                        childAt.setAlpha(0.3f);
                    }
                }
            }
        }
    }

    static /* synthetic */ void c(PaymentReminderCreationActivity paymentReminderCreationActivity, boolean z2) {
        if (z2) {
            paymentReminderCreationActivity.W.setVisibility(0);
            paymentReminderCreationActivity.findViewById(R.id.payment_reminder_separator_view).setVisibility(0);
            final EditText editText = paymentReminderCreationActivity.t;
            editText.postDelayed(new Runnable() {
                public final void run() {
                    try {
                        InputMethodManager inputMethodManager = (InputMethodManager) PaymentReminderCreationActivity.this.getSystemService("input_method");
                        if (inputMethodManager != null) {
                            inputMethodManager.showSoftInput(editText, 1);
                        }
                    } catch (Exception e2) {
                        q.b(e2.getMessage());
                    }
                }
            }, 100);
            paymentReminderCreationActivity.t.requestFocus();
            paymentReminderCreationActivity.f59934a.setBackgroundColor(paymentReminderCreationActivity.getResources().getColor(R.color.color_b8c2cb));
            paymentReminderCreationActivity.findViewById(R.id.payment_reminder_separator_view).setBackgroundColor(paymentReminderCreationActivity.getResources().getColor(R.color.color_00b9f5));
            paymentReminderCreationActivity.t.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public final void onFocusChange(View view, boolean z) {
                    if (z) {
                        PaymentReminderCreationActivity.this.f59934a.setBackgroundColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.color_b8c2cb));
                        PaymentReminderCreationActivity.this.findViewById(R.id.payment_reminder_separator_view).setBackgroundColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.color_00b9f5));
                        return;
                    }
                    PaymentReminderCreationActivity.this.findViewById(R.id.payment_reminder_separator_view).setBackgroundColor(PaymentReminderCreationActivity.this.getResources().getColor(R.color.color_b8c2cb));
                }
            });
            paymentReminderCreationActivity.t.addTextChangedListener(paymentReminderCreationActivity.Z);
            return;
        }
        paymentReminderCreationActivity.W.setVisibility(8);
        paymentReminderCreationActivity.C = false;
        paymentReminderCreationActivity.B = null;
        paymentReminderCreationActivity.t.removeTextChangedListener(paymentReminderCreationActivity.Z);
        paymentReminderCreationActivity.t.setText((CharSequence) null);
        paymentReminderCreationActivity.a((View) paymentReminderCreationActivity.t);
    }
}
