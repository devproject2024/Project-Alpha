package net.one97.paytm.upi.requestmoney.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.content.b;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CustomAmountTextInputEditText;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.common.upi.ValidateVpaResponse;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.passbook.view.UpiPassbookActivity;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.requestmoney.a.d;
import net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity;
import net.one97.paytm.upi.requestmoney.view.j;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.AnimationUtils;
import net.one97.paytm.upi.util.CommentsEditText;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiRequestBuilder;
import net.one97.paytm.upi.util.UpiUtils;

public class RequestMoneyV2SelectBankActivity extends PaytmActivity implements View.OnClickListener, View.OnFocusChangeListener, d.b {
    /* access modifiers changed from: private */
    public TextView A;
    /* access modifiers changed from: private */
    public TextView B;
    /* access modifiers changed from: private */
    public TextView C;
    private TextView D;
    private TextView E;
    /* access modifiers changed from: private */
    public TextView F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    /* access modifiers changed from: private */
    public TextView M;
    private TextView N;
    private TextView O;
    private TextView P;
    private TextView Q;
    /* access modifiers changed from: private */
    public a R = null;
    /* access modifiers changed from: private */
    public a S = null;
    /* access modifiers changed from: private */
    public BottomSheetBehavior T;
    /* access modifiers changed from: private */
    public String U;
    /* access modifiers changed from: private */
    public String V;
    private String W;
    /* access modifiers changed from: private */
    public RequestMoneyV2SelectBankActivity X;
    private j Y;
    private String Z;

    /* renamed from: a  reason: collision with root package name */
    List<UpiProfileDefaultBank> f69239a;
    private String aa;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    /* access modifiers changed from: private */
    public int ag;
    /* access modifiers changed from: private */
    public d.a ah;
    /* access modifiers changed from: private */
    public boolean ai;
    /* access modifiers changed from: private */
    public String aj;
    /* access modifiers changed from: private */
    public String ak;
    private Dialog al;
    private NestedScrollView am;
    private TextWatcher an = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (charSequence.length() == 0) {
                ((TextView) RequestMoneyV2SelectBankActivity.this.findViewById(R.id.rupee_prefix_tv)).setTextColor(b.c(RequestMoneyV2SelectBankActivity.this, R.color.edittext_hint_color));
                return;
            }
            ((TextView) RequestMoneyV2SelectBankActivity.this.findViewById(R.id.rupee_prefix_tv)).setTextColor(b.c(RequestMoneyV2SelectBankActivity.this, R.color.color_222222));
            RequestMoneyV2SelectBankActivity.this.F.setText("");
            RequestMoneyV2SelectBankActivity.this.F.setVisibility(4);
            try {
                RequestMoneyV2SelectBankActivity.this.a(RequestMoneyV2SelectBankActivity.this.f69240b);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    };

    /* renamed from: b  reason: collision with root package name */
    int f69240b = 0;

    /* renamed from: c  reason: collision with root package name */
    protected ProgressDialog f69241c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f69242d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f69243e;

    /* renamed from: f  reason: collision with root package name */
    private RelativeLayout f69244f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f69245g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f69246h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f69247i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    /* access modifiers changed from: private */
    public LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private CustomAmountTextInputEditText r;
    private View s;
    private View t;
    /* access modifiers changed from: private */
    public CommentsEditText u;
    private CardView v;
    private View w;
    private View x;
    private RecyclerView y;
    /* access modifiers changed from: private */
    public TextView z;

    public final void a(Bundle bundle) {
    }

    public final void a(String str) {
    }

    public final void a(boolean z2, String str, ValidateVpaResponse validateVpaResponse) {
    }

    public final void e() {
    }

    public final void f() {
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.ah = (d.a) obj;
    }

    public void attachBaseContext(Context context) {
        if (i.a().m == null) {
            super.attachBaseContext(context);
        }
        ContextWrapper d2 = i.a().m.d(context);
        if (d2 != null) {
            super.attachBaseContext(d2);
        } else {
            super.attachBaseContext(context);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_request_money_v2_step2);
        int color = getResources().getColor(R.color.white);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(16);
            if (Build.VERSION.SDK_INT >= 21) {
                View decorView = window.getDecorView();
                window.addFlags(Integer.MIN_VALUE);
                if (decorView != null) {
                    decorView.setSystemUiVisibility(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
                }
                window.setStatusBarColor(color);
            }
        }
        this.X = this;
        this.f69242d = (RelativeLayout) findViewById(R.id.toolbar_layout);
        this.f69247i = (ImageView) findViewById(R.id.iv_back_button);
        this.o = (LinearLayout) findViewById(R.id.title_layout);
        this.z = (TextView) findViewById(R.id.toolbar_title);
        this.A = (TextView) findViewById(R.id.toolbar_subtitle);
        this.B = (TextView) findViewById(R.id.tv_receiver_name);
        this.C = (TextView) findViewById(R.id.tv_receiver_acc_number);
        this.f69243e = (RelativeLayout) findViewById(R.id.image_layout_sender);
        this.j = (ImageView) findViewById(R.id.bankImageView);
        this.D = (TextView) findViewById(R.id.headerBankLogoName);
        this.p = (LinearLayout) findViewById(R.id.ll_amount_wrapper);
        this.r = (CustomAmountTextInputEditText) findViewById(R.id.amount_et);
        this.E = (TextView) findViewById(R.id.txt_add_desc);
        this.s = findViewById(R.id.v_uni_et_sep_1);
        this.F = (TextView) findViewById(R.id.amount_error_tv);
        this.u = (CommentsEditText) findViewById(R.id.edit_p2b_comment);
        this.t = findViewById(R.id.v_uni_et_sep_2);
        this.G = (TextView) findViewById(R.id.comments_error_tv);
        this.v = (CardView) findViewById(R.id.mt_selected_account_cv);
        this.k = (ImageView) findViewById(R.id.sender_bank_iv);
        this.H = (TextView) findViewById(R.id.source_name);
        this.I = (TextView) findViewById(R.id.source_balance);
        this.P = (TextView) findViewById(R.id.card_view_button);
        this.f69244f = (RelativeLayout) findViewById(R.id.rel_bottom);
        ((TextView) findViewById(R.id.tranfer_from_tv)).setText(R.string.upi_recieve_money_in);
        this.f69245g = (RelativeLayout) findViewById(R.id.rl_uni_selected_payment_inst);
        this.q = (LinearLayout) findViewById(R.id.ll_pay_wrapper);
        this.J = (TextView) findViewById(R.id.transfered_from);
        this.K = (TextView) findViewById(R.id.tv_selected_source_label);
        this.m = (ImageView) findViewById(R.id.arrow);
        this.L = (TextView) findViewById(R.id.ll_uni_pay);
        this.l = (ImageView) findViewById(R.id.arrow_iv);
        this.am = (NestedScrollView) findViewById(R.id.amount_scrollview);
        this.f69246h = (RelativeLayout) findViewById(R.id.lnr_details_layout);
        this.w = getLayoutInflater().inflate(R.layout.request_money_universal_vpa_list_bottomsheet, (ViewGroup) null, false);
        this.y = (RecyclerView) this.w.findViewById(R.id.recycler_view);
        this.n = (ImageView) this.w.findViewById(R.id.close_sheet_iv);
        this.N = (TextView) this.w.findViewById(R.id.bottom_sheet_button);
        ((TextView) this.w.findViewById(R.id.tranfer_from_tv)).setText(this.X.getString(R.string.request_money_in));
        this.O = (TextView) this.w.findViewById(R.id.view_all_accounts_tv);
        this.O.setVisibility(8);
        this.Q = (TextView) this.w.findViewById(R.id.link_another_tv);
        this.y.setLayoutManager(new LinearLayoutManager(this));
        this.Y = new j(this, this.f69239a);
        this.y.setAdapter(this.Y);
        this.x = this.w.findViewById(R.id.view_all_separator);
        this.R = new a(this);
        this.R.setContentView(this.w);
        this.R.setCancelable(true);
        this.R.setCanceledOnTouchOutside(true);
        this.R.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                UpiAppUtils.hideKeyboard(RequestMoneyV2SelectBankActivity.this.X);
            }
        });
        this.T = BottomSheetBehavior.from((View) this.w.getParent());
        this.T.setPeekHeight(UpiUtils.getScreenHeight() - UpiAppUtils.convertDpToPixel(50.0f, this));
        this.T.setState(3);
        this.T.setHideable(true);
        this.T.setSkipCollapsed(true);
        this.T.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 4) {
                    RequestMoneyV2SelectBankActivity.this.T.setPeekHeight(UpiUtils.getScreenHeight() - UpiAppUtils.convertDpToPixel(50.0f, RequestMoneyV2SelectBankActivity.this));
                    RequestMoneyV2SelectBankActivity.this.T.setState(3);
                }
                if (i2 == 5) {
                    RequestMoneyV2SelectBankActivity.this.R.dismiss();
                }
            }
        });
        this.Q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (RequestMoneyV2SelectBankActivity.this.a()) {
                    AccountProviderActivity.a((Activity) RequestMoneyV2SelectBankActivity.this, 31);
                } else {
                    RequestMoneyV2SelectBankActivity.this.g();
                }
            }
        });
        this.N.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!UpiAppUtils.isNetworkAvailable(RequestMoneyV2SelectBankActivity.this.X)) {
                    Toast.makeText(RequestMoneyV2SelectBankActivity.this.X, RequestMoneyV2SelectBankActivity.this.X.getResources().getString(R.string.no_internet), 0).show();
                } else if (RequestMoneyV2SelectBankActivity.this.R != null) {
                    RequestMoneyV2SelectBankActivity.this.R.cancel();
                    RequestMoneyV2SelectBankActivity.this.e(true);
                }
            }
        });
        this.ah = new net.one97.paytm.upi.requestmoney.presenter.d(g.c(), g.a(), g.a(net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null)), net.one97.paytm.upi.h.a.a(g.d(), (a.C1347a) null), this);
        this.ah.b();
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle bundleExtra = getIntent().getBundleExtra("key");
            this.V = bundleExtra.getString("payee_vpa", "");
            this.U = bundleExtra.getString("payee_name", "");
            this.W = bundleExtra.getString(UpiConstants.EXTRA_ACCOUNT_TYPE, "UPI");
            this.B.setText(this.U);
            TextView textView = this.C;
            textView.setText("UPI: " + this.V);
            a(this.j, this.W);
        }
        this.ag = UpiGTMLoader.getInstance().getCollectRequestExpiryTime();
        this.r.setOnFocusChangeListener(this);
        this.u.setOnFocusChangeListener(this);
        this.E.setOnClickListener(this);
        this.r.setOnClickListener(this);
        this.u.setOnClickListener(this);
        this.n.setOnClickListener(this);
        this.f69245g.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.r.setPrefix("");
        this.r.setMaxDigitsBeforeDecimalPoint(7);
        this.r.addTextChangedListener(this.an);
        this.l.setOnClickListener(this);
        this.f69247i.setOnClickListener(this);
        this.r.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                RequestMoneyV2SelectBankActivity.this.c(true);
                return false;
            }
        });
        this.u.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                if (i2 != 6) {
                    return false;
                }
                RequestMoneyV2SelectBankActivity.this.c(true);
                return false;
            }
        });
        this.r.setOnEditTextImeBackListener(new CustomAmountTextInputEditText.EditTextImeBackListener() {
            public final void onImeBack(CustomAmountTextInputEditText customAmountTextInputEditText, String str) {
                try {
                    RequestMoneyV2SelectBankActivity.this.c(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.u.setOnEditTextImeBackListener(new CommentsEditText.EditTextImeBackListener() {
            public final void onImeBack(CommentsEditText commentsEditText, String str) {
                try {
                    RequestMoneyV2SelectBankActivity.this.c(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        this.am.setOnScrollChangeListener(new NestedScrollView.b() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                if ((RequestMoneyV2SelectBankActivity.this.f69246h.getHeight() - RequestMoneyV2SelectBankActivity.this.B.getHeight()) - RequestMoneyV2SelectBankActivity.this.C.getHeight() >= i3) {
                    RequestMoneyV2SelectBankActivity.this.o.setVisibility(8);
                } else if (RequestMoneyV2SelectBankActivity.this.o.getVisibility() == 8) {
                    RequestMoneyV2SelectBankActivity.this.o.setVisibility(0);
                    RequestMoneyV2SelectBankActivity.this.A.setVisibility(0);
                    RequestMoneyV2SelectBankActivity.this.z.setText(RequestMoneyV2SelectBankActivity.this.U);
                    RequestMoneyV2SelectBankActivity.this.A.setText(String.format(RequestMoneyV2SelectBankActivity.this.getString(R.string.money_transfer_upi_without_bold), new Object[]{RequestMoneyV2SelectBankActivity.this.V}));
                }
            }
        });
    }

    public final void a(int i2) {
        this.f69240b = i2;
        b(i2);
        RecyclerView recyclerView = this.y;
        if (recyclerView != null && !recyclerView.isComputingLayout()) {
            this.Y.notifyDataSetChanged();
        }
        d(false);
    }

    public final void a(final UpiProfileDefaultBank upiProfileDefaultBank, TextView textView) {
        this.M = textView;
        if (upiProfileDefaultBank.getCreditBank() == null) {
            a(RequestMoneyV2Activity.a.PLEASE_ADD_BANK);
        } else if (this.ai || upiProfileDefaultBank.getCreditBank().isMpinSet()) {
            this.ah.a(upiProfileDefaultBank);
        } else {
            final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(this);
            customWalletAlertDialog.hideTitle();
            customWalletAlertDialog.setMessage(getString(R.string.mpin_missing_dlg_txt));
            customWalletAlertDialog.setButton(-2, getString(R.string.already_set_upi_pin), new View.OnClickListener() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f69262a = true;

                public final void onClick(View view) {
                    boolean unused = RequestMoneyV2SelectBankActivity.this.ai = true;
                    if (this.f69262a) {
                        RequestMoneyV2SelectBankActivity requestMoneyV2SelectBankActivity = RequestMoneyV2SelectBankActivity.this;
                        requestMoneyV2SelectBankActivity.a(upiProfileDefaultBank, requestMoneyV2SelectBankActivity.M);
                    } else {
                        RequestMoneyV2SelectBankActivity.s(RequestMoneyV2SelectBankActivity.this);
                    }
                    customWalletAlertDialog.dismiss();
                }
            });
            customWalletAlertDialog.setButton(-1, getString(R.string.set_upi_pin), new View.OnClickListener() {
                public final void onClick(View view) {
                    RequestMoneyV2SelectBankActivity.a(RequestMoneyV2SelectBankActivity.this, upiProfileDefaultBank);
                    customWalletAlertDialog.dismiss();
                }
            });
            customWalletAlertDialog.show();
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rl_uni_selected_payment_inst) {
            d(true);
        } else if (id == R.id.txt_add_desc) {
            this.E.setVisibility(8);
            this.u.setVisibility(0);
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    RequestMoneyV2SelectBankActivity.this.u.requestFocus();
                    RequestMoneyV2SelectBankActivity requestMoneyV2SelectBankActivity = RequestMoneyV2SelectBankActivity.this;
                    requestMoneyV2SelectBankActivity.u.postDelayed(new Runnable(requestMoneyV2SelectBankActivity.u) {
                        public final void run() {
                            try {
                                InputMethodManager inputMethodManager = (InputMethodManager) RequestMoneyV2SelectBankActivity.this.getSystemService("input_method");
                                if (inputMethodManager != null) {
                                    inputMethodManager.showSoftInput(r4, 1);
                                    RequestMoneyV2SelectBankActivity.this.getWindow().setSoftInputMode(20);
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }, 100);
                }
            }, 800);
            AnimationUtils.collapseViewAlongWidth(this.s, 400);
            AnimationUtils.expandViewAlongWidth(this.t, 400);
        } else if (id == R.id.arrow_iv) {
            d(true);
        } else if (id == R.id.edit_p2b_comment) {
            if (this.v.getVisibility() == 0) {
                c(false);
            }
        } else if (id == R.id.amount_et) {
            this.F.setVisibility(4);
            if (this.v.getVisibility() == 0) {
                c(false);
            }
        } else if (id == R.id.close_sheet_iv) {
            d(false);
        } else if (id == R.id.ll_uni_pay) {
            if (!this.L.getText().toString().trim().equalsIgnoreCase(getString(R.string.upi_link_account))) {
                e(false);
            } else if (a()) {
                AccountProviderActivity.a((Activity) this, 31);
            } else {
                g();
            }
        } else if (id == R.id.card_view_button) {
            e(false);
        } else if (id == R.id.iv_back_button) {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        UpiAppUtils.hideKeyboard(this);
        super.onBackPressed();
        finish();
    }

    /* access modifiers changed from: private */
    public boolean a() {
        return PaytmUpiPrefUtil.getPref(getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    /* access modifiers changed from: private */
    public void c(boolean z2) {
        if (z2) {
            if (this.v.getVisibility() == 8) {
                a((View) this.v);
            }
            this.q.setVisibility(8);
            return;
        }
        if (this.v.getVisibility() == 0) {
            AnimationUtils.collapseView(this.v, 50);
        }
        this.q.setVisibility(0);
    }

    private void a(final View view) {
        view.animate().translationY(0.0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }

            public final void onAnimationRepeat(Animator animator) {
                super.onAnimationRepeat(animator);
            }

            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
            }
        }).start();
    }

    private void d(boolean z2) {
        if (z2) {
            com.google.android.material.bottomsheet.a aVar = this.R;
            if (aVar != null) {
                aVar.show();
                this.T.setState(3);
                return;
            }
            return;
        }
        com.google.android.material.bottomsheet.a aVar2 = this.R;
        if (aVar2 != null && aVar2.isShowing()) {
            this.R.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.ah.f();
    }

    private void b(String str) {
        if (!this.X.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(str);
            builder.setNegativeButton(17039370, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.cancel();
                }
            });
            builder.show();
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(upiCustomVolleyError.getMessage()) || "410".equalsIgnoreCase(upiCustomVolleyError.getMessage())) {
            k kVar = i.a().k;
            RequestMoneyV2SelectBankActivity.class.getName();
            kVar.e(this);
        } else if (upiCustomVolleyError.getAlertMessage() != null) {
            String trim = upiCustomVolleyError.getAlertMessage().trim();
            if (TextUtils.isEmpty(trim)) {
                trim = getString(R.string.upi_oops_something_went_wrong);
            }
            com.paytm.utility.b.b((Context) this, "Error", trim);
        } else {
            com.paytm.utility.b.b((Context) this, "Error", getString(R.string.upi_oops_something_went_wrong));
        }
    }

    public final void a(RequestMoneyV2Activity.a aVar) {
        String str;
        if (aVar == RequestMoneyV2Activity.a.PLEASE_ADD_BANK) {
            str = getString(R.string.please_add_a_bank_account);
        } else if (aVar == RequestMoneyV2Activity.a.SOMETHING_WENT_WRONG) {
            str = getString(R.string.upi_oops_something_went_wrong);
        } else if (aVar == RequestMoneyV2Activity.a.CANNOT_TRANSFER_TO_SAME_ACC) {
            str = getString(R.string.you_cannot_transfer_money_to_same_account);
        } else {
            str = aVar == RequestMoneyV2Activity.a.NO_SIM ? getString(R.string.no_sim_attached) : "";
        }
        b(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:19|20|(1:26)|27|28|(1:40)(2:32|34)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0055 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A[Catch:{ Exception -> 0x0066 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r1, net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity.b r2) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x003b
            if (r2 == 0) goto L_0x001f
            net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity$b r1 = net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity.b.VERIFY_VPA     // Catch:{ Exception -> 0x0066 }
            if (r2 != r1) goto L_0x0011
            int r1 = net.one97.paytm.upi.R.string.verifying     // Catch:{ Exception -> 0x0066 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0066 }
            r0.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0066 }
        L_0x0011:
            net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity$b r1 = net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity.b.PROCESS_PAYMENT     // Catch:{ Exception -> 0x0066 }
            if (r2 != r1) goto L_0x0066
            int r1 = net.one97.paytm.upi.R.string.processing_your_payment     // Catch:{ Exception -> 0x0066 }
            java.lang.String r1 = r0.getString(r1)     // Catch:{ Exception -> 0x0066 }
            r0.a((android.content.Context) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x0066 }
            return
        L_0x001f:
            android.app.Dialog r1 = r0.al     // Catch:{ Exception -> 0x0066 }
            if (r1 != 0) goto L_0x0029
            android.app.Dialog r1 = net.one97.paytm.upi.util.UpiAppUtils.getWalletStyleProgressDialog(r0)     // Catch:{ Exception -> 0x0066 }
            r0.al = r1     // Catch:{ Exception -> 0x0066 }
        L_0x0029:
            android.app.Dialog r1 = r0.al     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0066
            android.app.Dialog r1 = r0.al     // Catch:{ Exception -> 0x0066 }
            boolean r1 = r1.isShowing()     // Catch:{ Exception -> 0x0066 }
            if (r1 != 0) goto L_0x0066
            android.app.Dialog r1 = r0.al     // Catch:{ Exception -> 0x0066 }
            r1.show()     // Catch:{ Exception -> 0x0066 }
            return
        L_0x003b:
            android.app.ProgressDialog r1 = r0.f69241c     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0055
            android.app.ProgressDialog r1 = r0.f69241c     // Catch:{ Exception -> 0x0055 }
            boolean r1 = r1.isShowing()     // Catch:{ Exception -> 0x0055 }
            if (r1 == 0) goto L_0x0055
            boolean r1 = r0.isFinishing()     // Catch:{ Exception -> 0x0055 }
            if (r1 != 0) goto L_0x0055
            android.app.ProgressDialog r1 = r0.f69241c     // Catch:{ Exception -> 0x0055 }
            r1.dismiss()     // Catch:{ Exception -> 0x0055 }
            r1 = 0
            r0.f69241c = r1     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            android.app.Dialog r1 = r0.al     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0066
            android.app.Dialog r1 = r0.al     // Catch:{ Exception -> 0x0066 }
            boolean r1 = r1.isShowing()     // Catch:{ Exception -> 0x0066 }
            if (r1 == 0) goto L_0x0066
            android.app.Dialog r1 = r0.al     // Catch:{ Exception -> 0x0066 }
            r1.dismiss()     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.requestmoney.view.RequestMoneyV2SelectBankActivity.a(boolean, net.one97.paytm.upi.requestmoney.view.RequestMoneyV2Activity$b):void");
    }

    private void a(Context context, String str) {
        ProgressDialog progressDialog = this.f69241c;
        if (progressDialog == null || !progressDialog.isShowing()) {
            this.f69241c = new ProgressDialog(context);
            try {
                this.f69241c.setProgressStyle(0);
                this.f69241c.setMessage(str);
                this.f69241c.setCancelable(false);
                this.f69241c.setCanceledOnTouchOutside(false);
                this.f69241c.show();
            } catch (Exception | IllegalArgumentException unused) {
            }
        }
    }

    public final void g() {
        Intent intent = new Intent(this, UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        startActivityForResult(intent, 80);
    }

    public final void a(List<UpiProfileDefaultBank> list) {
        this.f69239a = list;
        this.f69239a.clear();
        j jVar = this.Y;
        if (jVar != null) {
            jVar.f69475b = this.f69239a;
            jVar.notifyDataSetChanged();
        }
    }

    public final void b(List<UpiProfileDefaultBank> list) {
        this.f69239a = list;
        RecyclerView recyclerView = this.y;
        if (recyclerView != null && !recyclerView.isComputingLayout()) {
            j jVar = this.Y;
            jVar.f69475b = this.f69239a;
            jVar.notifyDataSetChanged();
        }
        List<UpiProfileDefaultBank> list2 = this.f69239a;
        if (list2 == null || list2.size() <= 0) {
            this.f69245g.setVisibility(8);
            this.L.setText(getString(R.string.upi_link_account));
            return;
        }
        this.L.setText(getString(R.string.proceed));
        int i2 = this.f69240b;
        this.f69240b = i2;
        b(i2);
        RecyclerView recyclerView2 = this.y;
        if (recyclerView2 != null && !recyclerView2.isComputingLayout()) {
            this.Y.notifyDataSetChanged();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 == 80) {
            a(false, (RequestMoneyV2Activity.b) null);
            if (i3 == -1) {
                this.ah.b();
            } else {
                finish();
            }
        } else if (i2 == 31) {
            if (i3 == -1) {
                this.ah.a((AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER));
            }
        } else if (i2 == 34) {
            if (i3 == -1) {
                this.ah.b();
            }
        } else if (i2 != 10) {
            finish();
        } else if (i3 == -1) {
            this.ah.b();
            this.ai = true;
        }
        super.onActivityResult(i2, i3, intent);
    }

    private void b(int i2) {
        List<UpiProfileDefaultBank> list = this.f69239a;
        if (list != null && list.size() > 0) {
            c(i2);
        }
    }

    private void c(int i2) {
        this.f69245g.setVisibility(0);
        this.u.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        if (i2 < this.f69239a.size() && this.f69239a.get(i2) != null) {
            this.aa = this.f69239a.get(this.f69240b).getVirtualAddress();
            if (!(this.f69239a.get(i2).getCreditBank() == null || this.f69239a.get(i2).getCreditBank().getBankName() == null)) {
                this.Z = this.f69239a.get(i2).getCreditBank().getBankName();
            }
            if (!(this.f69239a.get(i2).getCreditBank() == null || this.f69239a.get(i2).getCreditBank().getBankName() == null || this.f69239a.get(i2).getCreditBank().getAccount() == null)) {
                this.ac = this.f69239a.get(i2).getVirtualAddress();
                this.ad = this.f69239a.get(i2).getCreditBank().getAccount();
                this.H.setText(this.f69239a.get(i2).getCreditBank().getBankName());
                this.I.setText(String.format(getString(R.string.money_transfer_acc_no_with_placeholder_without_bold), new Object[]{UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(this.f69239a.get(i2).getCreditBank().getAccount()), 4)}));
                this.ae = String.format(getString(R.string.money_transfer_acc_no_with_placeholder_without_bold), new Object[]{UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(this.f69239a.get(i2).getCreditBank().getAccount()), 4)});
                String bankName = this.f69239a.get(i2).getCreditBank().getBankName();
                this.f69239a.get(i2).getVirtualAddress();
                c(bankName);
            }
            if (this.f69239a.get(i2).getCreditBank() != null && !TextUtils.isEmpty(this.f69239a.get(i2).getCreditBank().getIfsc())) {
                this.af = this.f69239a.get(i2).getCreditBank().getIfsc();
                a(this.k, this.af);
            }
            this.ab = this.f69239a.get(i2);
        }
    }

    private void c(String str) {
        this.K.setText(str);
    }

    /* access modifiers changed from: private */
    public void e(boolean z2) {
        this.aj = UpiAppUtils.getCleanString(this.r.getText().toString());
        this.ak = this.u.getText().toString();
        this.F.setVisibility(4);
        if (TextUtils.isEmpty(UpiAppUtils.getCleanString(this.aj))) {
            this.F.setText(getString(R.string.wallet_p2b_amount_error_part_1, new Object[]{UpiAppUtils.formatNumber(UpiUtils.getMinAmountAllowed(this)) + getString(R.string.wallet_p2b_amount_error_part_2) + UpiAppUtils.formatNumber(UpiUtils.getMaxAmountAllowed(this))}));
            this.F.setVisibility(0);
            this.r.requestFocus();
        } else if (!UpiUtils.isAmountValid(UpiAppUtils.getCleanString(this.aj))) {
            this.F.setText(getString(R.string.upi_err_msg_valid_upi_amount));
            this.F.setVisibility(0);
            this.r.requestFocus();
        } else if (!UpiAppUtils.isNetworkAvailable(this)) {
            CustomDialog.showAlert(this.X, getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
        } else if (!a(this.aj, UpiUtils.getMinAmountAllowed(this), UpiUtils.getMaxAmountAllowed(this))) {
            this.F.setVisibility(0);
            this.F.setText(getString(R.string.wallet_p2b_amount_error_part_1, new Object[]{UpiAppUtils.formatNumber(UpiUtils.getMinAmountAllowed(this)) + getString(R.string.wallet_p2b_amount_error_part_2) + UpiAppUtils.formatNumber(UpiUtils.getMaxAmountAllowed(this))}));
            this.r.requestFocus();
        } else if (!z2) {
            this.ah.a();
        } else {
            new Handler().postDelayed(new Runnable() {
                public final void run() {
                    RequestMoneyV2SelectBankActivity.this.ah.a();
                }
            }, 50);
        }
    }

    private static boolean a(String str, double d2, double d3) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            double parseDouble = Double.parseDouble(str);
            if (d3 <= 0.0d) {
                return true;
            }
            return parseDouble >= d2 && parseDouble <= d3;
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void a(ImageView imageView, String str) {
        if (!TextUtils.isEmpty(str) && str.contains("ICIC")) {
            imageView.setImageDrawable(b.a((Context) this, R.drawable.icici_bank_logo));
        } else if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("UPI")) {
            imageView.setImageDrawable(b.a((Context) this, R.drawable.ic_bhim));
        } else if (!TextUtils.isEmpty(str)) {
            w.a().a(UpiRequestBuilder.getBankIconUrl(getApplicationContext(), str)).a(R.drawable.ic_default_bank).b(R.drawable.ic_default_bank).a(imageView, (e) null);
        }
    }

    public final void a(boolean z2) {
        com.google.android.material.bottomsheet.a aVar = this.S;
        if (aVar != null) {
            aVar.dismiss();
        }
        if (!z2) {
            Toast.makeText(this.X, getString(R.string.upi_some_went_wrong), 0).show();
        }
        setResult(-1);
        finish();
    }

    public final void a(String str, String str2) {
        if ("1006".equalsIgnoreCase(str)) {
            Intent intent = new Intent(this, UpiRegistrationActivity.class);
            intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
            startActivity(intent);
            return;
        }
        CustomDialog.showAlert(this, "Error", str2);
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
        BankVpaCreationActivity.a((Activity) this, accountProvider, str, 34);
    }

    public final void b(boolean z2) {
        TextView textView = this.M;
        if (textView != null) {
            j.a aVar = (j.a) textView.getTag();
            if (z2) {
                if (aVar != null && aVar.f69488e != null) {
                    aVar.f69485b.setVisibility(8);
                    AnimationFactory.startWalletLoader((LottieAnimationView) aVar.f69488e);
                }
            } else if (aVar != null && aVar.f69488e != null) {
                aVar.f69485b.setVisibility(0);
                AnimationFactory.stopWalletLoader((LottieAnimationView) aVar.f69488e);
            }
        }
    }

    public final void a(String str, String str2, String str3) {
        a(false, (RequestMoneyV2Activity.b) null);
        if (!TextUtils.isEmpty(str)) {
            this.M.setText(getString(R.string.upi_new_balance, new Object[]{UpiAppUtils.priceToString(str2)}));
            this.M.setTextColor(b.c(this, R.color.color_222222));
        } else if (TextUtils.isEmpty(str3)) {
            Toast.makeText(this, R.string.upi_check_balance_error, 1).show();
        } else if ("ZM".equals(str3)) {
            Toast.makeText(this, R.string.upi_incorrect_mpin, 1).show();
        }
    }

    public final void i() {
        Intent intent = new Intent(this, UpiPassbookActivity.class);
        intent.putExtra(UpiConstants.KEY_UPI_ITEM_TYPE, UpiConstants.UpiItemType.PENDING_REQUESTS.ordinal());
        intent.putExtra("isFromRequestMoney", true);
        intent.putExtra(UpiConstants.EXTRA_INTENT_UPI_PASSBOOK_TAB, "getpendingrequestssent");
        startActivity(intent);
    }

    public void onFocusChange(View view, boolean z2) {
        int id = view.getId();
        try {
            if (id == R.id.amount_et) {
                if (z2) {
                    if (this.E.getVisibility() == 8) {
                        AnimationUtils.expandViewAlongWidth(this.s, 400);
                    }
                    c(false);
                } else if (this.E.getVisibility() == 8) {
                    AnimationUtils.collapseViewAlongWidth(this.s, 400);
                }
            } else if (id != R.id.edit_p2b_comment) {
            } else {
                if (z2) {
                    if (this.E.getVisibility() == 8 && this.t.getVisibility() == 4) {
                        AnimationUtils.expandViewAlongWidth(this.t, 400);
                    }
                    c(false);
                } else if (this.E.getVisibility() == 8) {
                    AnimationUtils.collapseViewAlongWidth(this.t, 400);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void h() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_upi_request_money, (ViewGroup) null);
        UpiAppUtils.updateAmount(String.format(getString(R.string.rs_str), new Object[]{UpiAppUtils.priceToString(UpiAppUtils.getCleanString(this.r.getText().toString()))}), (TextView) inflate.findViewById(R.id.tv_amount));
        ((TextView) inflate.findViewById(R.id.tv_payer_name)).setText(this.U);
        ((TextView) inflate.findViewById(R.id.tv_payer_vpa)).setText(String.format(getResources().getString(R.string.upi_collect_request_vpa), new Object[]{this.V}));
        this.S = new com.google.android.material.bottomsheet.a(this);
        this.S.setContentView(inflate);
        final BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
        from.setState(3);
        this.S.show();
        this.S.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                from.setState(4);
            }
        });
        TextView textView = (TextView) inflate.findViewById(R.id.tv_pay);
        textView.setText(getString(R.string.confirm));
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (TextUtils.isEmpty(RequestMoneyV2SelectBankActivity.this.u.getText().toString())) {
                    String unused = RequestMoneyV2SelectBankActivity.this.ak = "NA";
                }
                RequestMoneyV2SelectBankActivity.this.ah.a(RequestMoneyV2SelectBankActivity.this.ab, RequestMoneyV2SelectBankActivity.this.V, UpiUtils.convertToTwoPlaces(RequestMoneyV2SelectBankActivity.this.aj), String.valueOf(RequestMoneyV2SelectBankActivity.this.ag), RequestMoneyV2SelectBankActivity.this.ak, RequestMoneyV2SelectBankActivity.this.U);
                RequestMoneyV2SelectBankActivity.this.S.cancel();
            }
        });
        ((ImageView) inflate.findViewById(R.id.iv_cancel)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RequestMoneyV2SelectBankActivity.this.S.dismiss();
            }
        });
    }

    static /* synthetic */ void s(RequestMoneyV2SelectBankActivity requestMoneyV2SelectBankActivity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestMoneyV2SelectBankActivity.ab.getCreditBank());
        requestMoneyV2SelectBankActivity.ah.a(new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, requestMoneyV2SelectBankActivity.ab.getVirtualAddress()).setBankAccountList(arrayList).build());
    }

    static /* synthetic */ void a(RequestMoneyV2SelectBankActivity requestMoneyV2SelectBankActivity, UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(requestMoneyV2SelectBankActivity, SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getCreditBank());
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build();
        intent.putExtra("user_upi_details", build);
        if (build.getBankAccountList() != null) {
            h hVar = i.a().m;
            hVar.a("RequestMoneyV2SelectBankActivity", build.getBankAccountList().size() + "_" + build.getSelectedBankIdx());
        } else {
            h hVar2 = i.a().m;
            hVar2.a("RequestMoneyV2SelectBankActivity", "null_" + build.getSelectedBankIdx());
        }
        requestMoneyV2SelectBankActivity.startActivityForResult(intent, 10);
    }
}
