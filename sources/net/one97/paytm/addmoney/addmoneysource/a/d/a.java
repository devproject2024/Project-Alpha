package net.one97.paytm.addmoney.addmoneysource.a.d;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.Html;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.q;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.a.u;
import net.one97.paytm.addmoney.a.w;
import net.one97.paytm.addmoney.addmoneysource.a.a.a;
import net.one97.paytm.addmoney.common.b;
import net.one97.paytm.addmoney.common.model.DebitCardViewType;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.status.view.AddMoneyStatusActivity;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.addmoney.utils.f;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class a extends h implements View.OnClickListener, a.b {

    /* renamed from: f  reason: collision with root package name */
    private static char f48141f = '•';
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public a.C0839a f48142a;

    /* renamed from: b  reason: collision with root package name */
    char f48143b = '-';

    /* renamed from: c  reason: collision with root package name */
    char f48144c = '/';
    /* access modifiers changed from: package-private */

    /* renamed from: d  reason: collision with root package name */
    public String f48145d;

    /* renamed from: e  reason: collision with root package name */
    public e f48146e;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public u f48147g;

    /* renamed from: h  reason: collision with root package name */
    private w f48148h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f48149i;
    private String j = " •••• ";
    private int k;
    private Double l;
    private f m;
    private String n;
    private String o;
    /* access modifiers changed from: private */
    public int p;
    /* access modifiers changed from: private */
    public w q;
    /* access modifiers changed from: private */
    public b r;
    private boolean s;
    private BroadcastReceiver t = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction().equals("payment_item_selected")) {
                int intExtra = intent.getIntExtra("payment_item_type", -1);
                if (intExtra != a.this.p && intExtra != -1) {
                    a.this.g();
                }
            } else if (intent == null || !intent.getAction().equals("payment_item_validate_selection_status_dc")) {
                if (intent != null && intent.getAction().equals("payment_item_validate_selection_status_cc")) {
                    if (intent.getBooleanExtra("payment_item_is_valid", false)) {
                        a aVar = a.this;
                        a.a(aVar, aVar.q, a.this.r);
                        return;
                    }
                    w unused = a.this.q = null;
                    b unused2 = a.this.r = null;
                }
            } else if (intent.getBooleanExtra("payment_item_is_valid", false)) {
                a aVar2 = a.this;
                a.a(aVar2, aVar2.q, a.this.r);
            } else {
                w unused3 = a.this.q = null;
                b unused4 = a.this.r = null;
            }
        }
    };

    public final double e() {
        this.l = this.f48146e.s();
        return this.l.doubleValue();
    }

    public final void a(boolean z) {
        if (z) {
            LottieAnimationView lottieAnimationView = this.f48147g.v;
            lottieAnimationView.setVisibility(0);
            lottieAnimationView.setAnimation("Payments-Loader.json");
            lottieAnimationView.loop(true);
            lottieAnimationView.playAnimation();
            return;
        }
        LottieAnimationView lottieAnimationView2 = this.f48147g.v;
        lottieAnimationView2.cancelAnimation();
        lottieAnimationView2.setVisibility(8);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.p = getArguments().getInt("item_type");
        this.s = getArguments().getBoolean("destroy_self", false);
        if (this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
            IntentFilter intentFilter = new IntentFilter("payment_item_selected");
            if (this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal()) {
                intentFilter.addAction("payment_item_validate_selection_status_dc");
            } else if (this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                intentFilter.addAction("payment_item_validate_selection_status_cc");
            }
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.t, intentFilter);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f48147g = (u) androidx.databinding.f.a(layoutInflater, R.layout.uam_fragment_source_debit_card_layout, viewGroup, false);
        this.l = Double.valueOf(getArguments().getDouble("amount"));
        this.k = getArguments().getInt("destinationAddMoney");
        this.n = getArguments().getString("paymentMode");
        this.o = getArguments().getString("mid");
        f();
        if (this.n == null) {
            this.n = SDKConstants.DEBIT;
        }
        FragmentActivity activity = getActivity();
        getParentFragment();
        this.f48142a = new net.one97.paytm.addmoney.addmoneysource.a.b.a(this, net.one97.paytm.addmoney.addmoneysource.a.c.b.a((net.one97.paytm.addmoney.addmoneysource.a.c.a) net.one97.paytm.addmoney.addmoneysource.a.c.a.a.a((Context) activity), (net.one97.paytm.addmoney.addmoneysource.a.c.a) net.one97.paytm.addmoney.addmoneysource.a.c.b.a.a((Context) getActivity(), getParentFragment())), this.k, this.l.doubleValue(), this.n, this.o);
        this.f48147g.f48107d.setCustomSelectionActionModeCallback(new ActionMode.Callback() {
            public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public final void onDestroyActionMode(ActionMode actionMode) {
            }

            public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        });
        this.f48147g.u.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                if (!((RadioButton) radioGroup.findViewById(R.id.rb_otp)).isChecked()) {
                    a.this.f48147g.f48108e.setText("");
                }
            }
        });
        this.f48147g.f48107d.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                a aVar = a.this;
                if (editable.length() > 0 && editable.length() % 5 == 0 && aVar.f48143b == editable.charAt(editable.length() - 1)) {
                    editable.delete(editable.length() - 1, editable.length());
                }
                if (editable.length() > 0 && editable.length() % 5 == 0 && Character.isDigit(editable.charAt(editable.length() - 1)) && TextUtils.split(editable.toString(), String.valueOf(aVar.f48143b)).length <= 4) {
                    editable.insert(editable.length() - 1, String.valueOf(aVar.f48143b));
                }
                aVar.a(false, 1);
                aVar.f48142a.c(editable.toString());
            }
        });
        this.f48147g.f48108e.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                a aVar = a.this;
                aVar.a(false, 3);
                aVar.f48142a.a(editable.toString());
            }
        });
        this.f48147g.f48109f.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                String unused = a.this.f48145d = charSequence.toString();
            }

            public final void afterTextChanged(Editable editable) {
                a aVar = a.this;
                aVar.a(false, 2);
                if (aVar.f48145d.length() > editable.length()) {
                    if (editable.length() > 0 && editable.length() == 2) {
                        editable.charAt(editable.length() - 1);
                        editable.delete(editable.length() - 1, editable.length());
                    }
                } else if (editable.length() > 0 && editable.length() == 2 && Character.isDigit(editable.charAt(editable.length() - 1))) {
                    editable.insert(editable.length(), String.valueOf(aVar.f48144c));
                }
                aVar.f48142a.b(editable.toString());
            }
        });
        this.f48147g.m.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.f48142a.d();
            }
        });
        this.f48147g.l.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.f48142a.c();
            }
        });
        this.f48147g.n.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a.this.f48142a.a(z);
            }
        });
        this.f48147g.f48107d.setLongClickable(false);
        this.f48147g.m.setText(Html.fromHtml(getResources().getString(R.string.uam_debit_use_3d_secure_pin_or_otp)));
        this.f48147g.l.setText(Html.fromHtml(getResources().getString(R.string.uam_debit_use_atm_pin)));
        this.f48147g.t.setOnClickListener(this);
        this.f48147g.q.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f48142a.e();
            }
        });
        this.f48147g.f48104a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.f48142a.a(a.this.e());
            }
        });
        this.f48147g.n.setChecked(true);
        if (this.n.equals(SDKConstants.DEBIT)) {
            RoboTextView roboTextView = this.f48147g.t;
            roboTextView.setText("+    " + getString(R.string.uam_source_debit_add_new_card));
        } else {
            RoboTextView roboTextView2 = this.f48147g.t;
            roboTextView2.setText("+    " + getString(R.string.uam_source_credit_add_new_card));
        }
        this.f48142a.a();
        return this.f48147g.getRoot();
    }

    public void onDestroy() {
        super.onDestroy();
        if ((this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) && this.t != null) {
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.t);
            this.t = null;
        }
    }

    private void f() {
        if (this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal()) {
            this.f48147g.k.setVisibility(8);
            this.f48147g.j.setVisibility(8);
            this.f48147g.f48105b.setVisibility(0);
        } else if (this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
            this.f48147g.k.setVisibility(8);
            this.f48147g.j.setVisibility(8);
            this.f48147g.f48105b.setVisibility(0);
        } else {
            this.f48147g.k.setVisibility(0);
            this.f48147g.j.setVisibility(8);
            this.f48147g.f48105b.setVisibility(8);
        }
    }

    public final void c() {
        this.f48147g.f48110g.setVisibility(8);
        this.f48147g.f48112i.setVisibility(8);
        this.f48147g.u.setVisibility(8);
        this.f48147g.u.clearCheck();
        this.f48147g.f48108e.setVisibility(0);
    }

    public final void a(net.one97.paytm.addmoney.cvvHelp.b.a aVar) {
        net.one97.paytm.addmoney.cvvHelp.c.b a2 = net.one97.paytm.addmoney.cvvHelp.c.b.a(aVar);
        q a3 = ((AppCompatActivity) getActivity()).getSupportFragmentManager().a();
        a3.a("cvvsheet");
        a2.show(a3, (String) null);
    }

    public final void a(HashMap hashMap) {
        CJRRechargePayment cJRRechargePayment = c.a().f48962e;
        Intent f2 = net.one97.paytm.helper.a.b().f((Activity) getActivity());
        cJRRechargePayment.setmPGParams(hashMap);
        cJRRechargePayment.setmPGUrlToHit(net.one97.paytm.helper.a.b().f("processTxnAddMoneyURL") + "?mid=" + c.a().f48959b + "&orderId=" + c.a().f48960c);
        f2.putExtra(SDKConstants.PAYMENT_INFO, cJRRechargePayment);
        f2.putExtra("uam_add_money", true);
        startActivityForResult(f2, 1004);
    }

    public final void b(String str) {
        if (isAdded()) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), str);
        }
    }

    public final void a(int i2) {
        if (i2 == DebitCardViewType.NEW_EXPIRY.getNumVal()) {
            this.f48147g.f48109f.requestFocus();
        } else if (i2 == DebitCardViewType.NEW_CVV.getNumVal()) {
            if (this.f48147g.f48108e.getVisibility() != 0 || !this.f48147g.f48108e.isEnabled()) {
                com.paytm.utility.b.c((Activity) getActivity());
            } else {
                this.f48147g.f48108e.requestFocus();
            }
        } else if (i2 == DebitCardViewType.NEW_CARD_NUMBER.getNumVal()) {
            this.f48147g.f48107d.requestFocus();
        }
    }

    public final void a() {
        com.paytm.utility.b.c((Activity) getActivity());
    }

    public final void a(boolean z, int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        if (z) {
                            this.f48147g.r.setText(R.string.rupay_card_error_text);
                            this.f48147g.r.setTextColor(-65536);
                            this.f48147g.f48107d.setBackgroundResource(R.drawable.edit_text_error_bg);
                            return;
                        }
                        this.f48147g.r.setText(getResources().getString(R.string.uam_card_number));
                        this.f48147g.r.setTextColor(getResources().getColor(R.color.color_444444));
                        this.f48147g.f48107d.setBackgroundResource(R.drawable.addmoney_white_background_with_border);
                    }
                } else if (z) {
                    this.f48147g.p.setText(getResources().getString(R.string.uam_enter_valid_cvv));
                    this.f48147g.p.setTextColor(-65536);
                    this.f48147g.f48108e.setBackgroundResource(R.drawable.edit_text_error_bg);
                } else {
                    this.f48147g.p.setText(getResources().getString(R.string.cvv));
                    this.f48147g.p.setTextColor(getResources().getColor(R.color.color_444444));
                    this.f48147g.f48108e.setBackgroundResource(R.drawable.addmoney_white_background_with_border);
                }
            } else if (z) {
                this.f48147g.s.setText(getResources().getString(R.string.uam_enter_valid_expiry));
                this.f48147g.s.setTextColor(-65536);
                this.f48147g.f48109f.setBackgroundResource(R.drawable.edit_text_error_bg);
            } else {
                this.f48147g.s.setText(getResources().getString(R.string.uam_expiry_validity_date));
                this.f48147g.s.setTextColor(getResources().getColor(R.color.color_444444));
                this.f48147g.f48109f.setBackgroundResource(R.drawable.addmoney_white_background_with_border);
            }
        } else if (z) {
            this.f48147g.r.setText(getResources().getString(R.string.uam_enter_valid_card_number));
            this.f48147g.r.setTextColor(-65536);
            this.f48147g.f48107d.setBackgroundResource(R.drawable.edit_text_error_bg);
        } else {
            this.f48147g.r.setText(getResources().getString(R.string.uam_card_number));
            this.f48147g.r.setTextColor(getResources().getColor(R.color.color_444444));
            this.f48147g.f48107d.setBackgroundResource(R.drawable.addmoney_white_background_with_border);
        }
    }

    public final void a(boolean z, String str) {
        this.f48147g.f48112i.setVisibility(z ? 0 : 8);
        this.f48147g.f48112i.setText(str);
    }

    public final void d() {
        this.f48147g.f48112i.setText(getString(R.string.uam_maestro_no_exp_and_cvv_needed));
        this.f48147g.f48112i.setVisibility(0);
    }

    public final void c(int i2) {
        if (i2 == 0) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.uam_error), getString(R.string.uam_error_cc_not_for_ppb));
        } else if (i2 == 1) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.uam_error), getString(R.string.uam_error_invalid_credit_card));
        } else if (i2 == 2) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.uam_error), getString(R.string.uam_error_invalid_debit_card));
        }
    }

    public final void a(String str) {
        this.f48147g.f48110g.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.f48147g.f48110g.setImageDrawable(androidx.core.content.b.a((Context) getActivity(), AddMoneyUtils.a(str)));
        }
    }

    public final void a(List<b> list) {
        String str;
        if (isAdded()) {
            this.f48147g.f48105b.removeAllViews();
            if (list != null && list.size() > 0) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    final b bVar = list.get(i2);
                    if (this.k == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
                        if (!"PAYTM".equalsIgnoreCase(bVar.k)) {
                            str = a(bVar.f48420b, bVar.f48422d);
                        } else if (!c(bVar.f48419a)) {
                            str = a(bVar.f48420b, bVar.f48422d);
                        }
                    } else if (this.k == PaymentDestinationType.TO_WALLET.getNumVal()) {
                        str = a(bVar.f48420b, bVar.f48422d);
                    } else {
                        str = "";
                    }
                    net.one97.paytm.addmoney.addmoneysource.a.e.a aVar = new net.one97.paytm.addmoney.addmoneysource.a.e.a(bVar.f48419a, str, "");
                    final w wVar = (w) androidx.databinding.f.a(getLayoutInflater(), R.layout.uam_save_card_layout, (ViewGroup) null, false);
                    wVar.a(aVar);
                    wVar.a(aVar);
                    wVar.k.setTag(Integer.valueOf(i2));
                    wVar.f48116d.setImageDrawable(androidx.core.content.b.a((Context) getActivity(), AddMoneyUtils.a(bVar.f48424f)));
                    wVar.f48121i.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (a.this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || a.this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                                w unused = a.this.q = wVar;
                                b unused2 = a.this.r = bVar;
                                a.g(a.this);
                                return;
                            }
                            a.a(a.this, wVar, bVar);
                        }
                    });
                    wVar.j.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (a.this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || a.this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                                w unused = a.this.q = wVar;
                                b unused2 = a.this.r = bVar;
                                a.g(a.this);
                                return;
                            }
                            a.a(a.this, wVar, bVar);
                        }
                    });
                    wVar.k.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            if (a.this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || a.this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                                w unused = a.this.q = wVar;
                                b unused2 = a.this.r = bVar;
                                a.g(a.this);
                                return;
                            }
                            a.a(a.this, wVar, bVar);
                        }
                    });
                    wVar.f48117e.setClickable(false);
                    wVar.f48113a.setTag(Integer.valueOf(i2));
                    if (!(list.size() != 1 || this.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || this.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal())) {
                        aVar.f48180c = new ObservableBoolean(true);
                        wVar.f48117e.setChecked(true);
                        wVar.f48121i.performClick();
                    }
                    this.f48147g.f48105b.addView(wVar.getRoot());
                }
            }
            if (this.f48147g.f48105b.getChildCount() == 0) {
                c(true);
                this.f48147g.k.setVisibility(0);
                this.f48147g.j.setVisibility(8);
            } else {
                c(false);
                this.f48147g.j.setVisibility(0);
                this.f48147g.k.setVisibility(8);
            }
            f();
        }
    }

    private static boolean c(String str) {
        CustProductList custProductList = c.a().f48963f;
        if (custProductList == null) {
            return false;
        }
        String vdcMaskedCardNum = custProductList.getVdcMaskedCardNum();
        if (!TextUtils.isEmpty(vdcMaskedCardNum) && !TextUtils.isEmpty(str)) {
            try {
                if (!vdcMaskedCardNum.substring(0, 4).equalsIgnoreCase(str.substring(0, 4)) || !vdcMaskedCardNum.substring(vdcMaskedCardNum.length() - 4).equalsIgnoreCase(str.substring(str.length() - 4))) {
                    return false;
                }
                return true;
            } catch (IndexOutOfBoundsException unused) {
            }
        }
        return false;
    }

    private void a(final EditText editText) {
        editText.postDelayed(new Runnable() {
            public final void run() {
                try {
                    if (a.this.isAdded()) {
                        ((InputMethodManager) a.this.getActivity().getSystemService("input_method")).showSoftInput(editText, 1);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }, 100);
    }

    public final void b() {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), (String) null, (Bundle) null);
        }
    }

    public final boolean b(int i2) {
        if (i2 == DebitCardViewType.RADIO_ATM_NEW_CARD.getNumVal()) {
            return this.f48147g.l.isChecked();
        }
        if (i2 == DebitCardViewType.RADIO_OTP_NEW_CARD.getNumVal()) {
            return this.f48147g.m.isChecked();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void g() {
        w wVar = this.f48148h;
        if (wVar != null) {
            wVar.f48117e.setChecked(false);
            this.f48148h.f48115c.setText("");
            this.f48148h.f48114b.setVisibility(8);
            this.f48148h.f48113a.setVisibility(8);
            this.f48148h.m.clearCheck();
            this.f48148h.m.setVisibility(8);
        }
        this.f48148h = null;
    }

    public void onClick(View view) {
        if (view.getId() != R.id.tvPayWithNewDebitCard) {
            return;
        }
        if (this.f48147g.k.getVisibility() != 0) {
            this.f48147g.k.setVisibility(0);
            this.f48147g.f48105b.setVisibility(8);
            RoboTextView roboTextView = this.f48147g.t;
            roboTextView.setText("+    " + getString(R.string.uam_saved_cards));
            this.f48147g.f48107d.requestFocus();
            a(this.f48147g.f48107d);
            c(true);
            return;
        }
        this.f48147g.k.setVisibility(8);
        this.f48147g.f48105b.setVisibility(0);
        RoboTextView roboTextView2 = this.f48147g.t;
        roboTextView2.setText("+    " + getString(R.string.uam_source_debit_add_new_card));
        c(false);
        com.paytm.utility.b.c((Activity) getActivity());
    }

    private void c(boolean z) {
        Intent intent = new Intent("actionButtonClicked");
        intent.putExtra("extra_new_card_clicked", z);
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(intent);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (isAdded()) {
            if (i3 == -1) {
                if (i2 == 1004) {
                    String stringExtra = intent.getStringExtra("retry_allowed");
                    String stringExtra2 = intent.getStringExtra("error_message");
                    if (!TextUtils.isEmpty(stringExtra) && "true".equalsIgnoreCase(stringExtra)) {
                        com.paytm.utility.b.b(getContext(), "Error", stringExtra2);
                    } else if (this.s) {
                        getActivity().setResult(-1);
                        getActivity().finish();
                    } else {
                        intent.getStringExtra("extra_data");
                        Intent intent2 = new Intent(getActivity(), AddMoneyStatusActivity.class);
                        intent2.putExtra("destinationAddMoney", this.k);
                        if (this.n.equals(SDKConstants.CREDIT)) {
                            intent2.putExtra("sourceAddMoney", SourceCardType.CREDIT_CARD.getNumVal());
                        } else if (this.n.equals(SDKConstants.DEBIT)) {
                            intent2.putExtra("sourceAddMoney", SourceCardType.DEBIT_CARD.getNumVal());
                        }
                        intent2.putExtra("sourceName", a(this.f48142a.f(), this.n));
                        intent2.putExtra("sourceDesc", d(this.f48142a.g()));
                        intent2.putExtra("sourceImage", this.f48142a.h());
                        intent2.putExtra("account_no", this.f48142a.i());
                        intent2.putExtra("Amount", this.l);
                        intent2.putExtra("mid", intent.getStringExtra("merchant_id"));
                        intent2.putExtra("orderId", intent.getStringExtra("order_id"));
                        startActivity(intent2);
                        getActivity().finish();
                    }
                }
            } else if (this.s) {
                getActivity().setResult(0);
                getActivity().finish();
            }
        }
    }

    private String a(String str, String str2) {
        if (SDKConstants.AI_KEY_PPBL.equalsIgnoreCase(str)) {
            str = getString(R.string.uam_ppbl);
        }
        if (SDKConstants.CREDIT.equalsIgnoreCase(str2)) {
            return str + " - " + getString(R.string.uam_credit_card_source_card_title);
        }
        return str + " - " + getString(R.string.uam_debit_card_source_card_title);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f48142a.b();
    }

    public final void b(boolean z) {
        if (isAdded()) {
            if (!z) {
                a(false, "", "");
            } else if (getActivity() != null || getActivity().isFinishing()) {
                a(true, (String) null, (String) null);
            }
        }
    }

    private void a(boolean z, String str, String str2) {
        try {
            if (this.m == null) {
                this.m = new f(getActivity());
            }
            if (!TextUtils.isEmpty(str)) {
                this.m.f48967a = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.m.f48968b = str2;
            }
            if (z) {
                this.m.a();
            } else {
                this.m.b();
            }
        } catch (Exception e2) {
            net.one97.paytm.helper.a.b().a(e2);
        }
    }

    private static String d(String str) {
        String replaceAll = str.replaceAll("-", "");
        StringBuilder sb = new StringBuilder(replaceAll.substring(0, 4));
        sb.append(" ");
        for (int i2 = 0; i2 < 10; i2++) {
            if (i2 % 5 != 0) {
                sb.append(f48141f);
            } else {
                sb.append("  ");
            }
        }
        sb.append("  " + replaceAll.substring(replaceAll.length() - 4, replaceAll.length()));
        return sb.toString();
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), a.class.getCanonicalName(), (Bundle) null);
        }
    }

    static /* synthetic */ void a(a aVar, final w wVar, final b bVar) {
        if (wVar != null && bVar != null) {
            if (aVar.p == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || aVar.p == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                Intent intent = new Intent("payment_item_selected");
                intent.putExtra("payment_item_type", aVar.p);
                androidx.localbroadcastmanager.a.a.a((Context) aVar.getActivity()).a(intent);
            }
            aVar.g();
            aVar.f48147g.k.setVisibility(8);
            wVar.f48113a.setVisibility(0);
            wVar.f48117e.setChecked(true);
            wVar.f48117e.setTag(bVar);
            wVar.f48114b.setVisibility(0);
            wVar.m.setVisibility(8);
            wVar.f48119g.setChecked(true);
            wVar.f48114b.setVisibility(0);
            aVar.f48149i = "otp";
            if (bVar.f48424f.equalsIgnoreCase(SDKConstants.MAESTRO)) {
                wVar.f48114b.setVisibility(8);
            }
            new StringBuilder("&nbsp;&nbsp;").append(aVar.getResources().getString(R.string.uam_use_otp));
            StringBuilder sb = new StringBuilder("&nbsp;&nbsp;</br><font color=\"#9b9b9b\">");
            sb.append(aVar.getResources().getString(R.string.uam_use_otp_subtitle));
            sb.append("</font>");
            new StringBuilder("&nbsp;&nbsp;").append(aVar.getResources().getString(R.string.uam_use_atm));
            StringBuilder sb2 = new StringBuilder("&nbsp;&nbsp;</br><font color=\"#9b9b9b\">");
            sb2.append(aVar.getResources().getString(R.string.uam_use_atm_subtitle));
            sb2.append("</font>");
            wVar.f48119g.setText(Html.fromHtml(aVar.getString(R.string.uam_debit_use_3d_secure_pin_or_otp)));
            wVar.f48118f.setText(Html.fromHtml(aVar.getString(R.string.uam_debit_use_atm_pin)));
            aVar.f48149i = "otp";
            wVar.f48114b.setVisibility(0);
            aVar.f48148h = wVar;
            wVar.f48115c.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (bVar.f48424f.equalsIgnoreCase(SDKConstants.AMEX)) {
                        if (editable.toString().trim().length() == 4) {
                            com.paytm.utility.b.c((Activity) a.this.getActivity());
                        }
                    } else if (editable.toString().trim().length() == 3) {
                        com.paytm.utility.b.c((Activity) a.this.getActivity());
                    }
                }
            });
            wVar.f48113a.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.h(a.this);
                    if (TextUtils.isEmpty(a.this.f48149i)) {
                        Toast.makeText(a.this.getActivity(), a.this.getResources().getString(R.string.uam_otp_pin_auth_mode), 1).show();
                        return;
                    }
                    if (wVar.f48114b.getVisibility() != 0) {
                        wVar.f48115c.setText("");
                    } else if (bVar.f48424f.equalsIgnoreCase(SDKConstants.AMEX)) {
                        if (wVar.f48115c.getText().toString().trim().length() != 4) {
                            Toast.makeText(a.this.getActivity(), a.this.getResources().getString(R.string.uam_enter_valid_cvv), 1).show();
                            return;
                        }
                    } else if (!bVar.f48424f.equalsIgnoreCase(SDKConstants.MAESTRO) && wVar.f48115c.getText().toString().trim().length() != 3) {
                        Toast.makeText(a.this.getActivity(), a.this.getResources().getString(R.string.uam_enter_valid_cvv), 1).show();
                        return;
                    }
                    a.this.f48142a.a(bVar, wVar.f48115c.getText().toString().trim(), a.this.f48149i, a.this.e());
                }
            });
            if (wVar.f48114b.getVisibility() == 0) {
                aVar.a(wVar.f48115c);
            } else {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        com.paytm.utility.b.c((Activity) a.this.getActivity());
                    }
                }, 200);
            }
        }
    }

    static /* synthetic */ void g(a aVar) {
        Intent intent = new Intent("payment_item_validate_selection");
        intent.putExtra("payment_item_type", aVar.p);
        androidx.localbroadcastmanager.a.a.a((Context) aVar.getActivity()).a(intent);
    }

    static /* synthetic */ void h(a aVar) {
        if (aVar.k == PaymentDestinationType.TO_WALLET.ordinal()) {
            d.a((Context) aVar.getActivity(), "add_money_wallet", "proceed_button_clicked", "/add-money/wallet", "payment_source_debit_card", (String) null);
        }
    }
}
