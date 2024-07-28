package net.one97.paytm.addmoney.common.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.common.a.a;
import net.one97.paytm.addmoney.common.b.b;
import net.one97.paytm.addmoney.common.model.PaymentDestinationType;
import net.one97.paytm.addmoney.common.model.SourceCardDataModel;
import net.one97.paytm.addmoney.common.model.SourceCardType;
import net.one97.paytm.addmoney.common.model.UAMErrorType;
import net.one97.paytm.addmoney.common.paymethodresponse.CJPayMethodResponse;
import net.one97.paytm.addmoney.j;
import net.one97.paytm.addmoney.utils.AddMoneyUtils;
import net.one97.paytm.addmoney.utils.CustomAmountTextInputEditText;
import net.one97.paytm.addmoney.utils.c;
import net.one97.paytm.addmoney.utils.d;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.addmoney.utils.f;
import net.one97.paytm.addmoney.utils.g;
import net.one97.paytm.addmoney.utils.m;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.common.entity.shopping.CJRCart;
import net.one97.paytm.common.entity.shopping.CJRCartProduct;
import net.one97.paytm.i.h;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.wallet.newdesign.addmoney.view.NearByAddMoneyActivity;

public class a extends h implements a.c, e {
    /* access modifiers changed from: private */
    public int A;
    private LottieAnimationView B;
    private ProgressDialog C;
    private ViewGroup D;
    private AppCompatImageView E;
    private TextView F;
    /* access modifiers changed from: private */
    public TextView G;
    private ImageView H;
    private boolean I;
    private f J;
    /* access modifiers changed from: private */
    public NestedScrollView K;
    /* access modifiers changed from: private */
    public RelativeLayout L;
    private RelativeLayout M;
    private LinearLayout N;
    /* access modifiers changed from: private */
    public TextView O;
    /* access modifiers changed from: private */
    public TextView P;
    private int Q = 0;
    /* access modifiers changed from: private */
    public int R;
    private LinearLayoutManager S;
    /* access modifiers changed from: private */
    public String T;
    private boolean U;
    private LinearLayout V;
    private TextView W;
    private ImageView X;
    /* access modifiers changed from: private */
    public TextView Y;
    private BroadcastReceiver Z = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equalsIgnoreCase("actionButtonClicked")) {
                a.a(a.this);
                if (intent.getBooleanExtra("extra_new_card_clicked", false)) {
                    a.this.G.setText(R.string.uam_enter_dc_detail);
                } else {
                    a.this.G.setText(R.string.uam_sel_saved_card_add_money);
                }
            } else if (intent.getAction().equalsIgnoreCase("payment_item_selected")) {
                int intExtra = intent.getIntExtra("payment_item_type", -1);
                if (intExtra == SourceCardType.NO_CARD.getNumVal() && a.this.f48504a != null) {
                    a.this.f48504a.l();
                }
                if (intExtra == SourceCardType.OTHER_BANKS.getNumVal()) {
                    a.a(a.this);
                }
            } else if (intent.getAction().equals("payment_item_validate_selection")) {
                int intExtra2 = intent.getIntExtra("payment_item_type", -1);
                if (intExtra2 == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal() || intExtra2 == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal() || intExtra2 == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
                    a.a(a.this);
                    a.this.f48504a.a(intExtra2);
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public a.C0849a f48504a;
    /* access modifiers changed from: package-private */

    /* renamed from: b  reason: collision with root package name */
    public b f48505b;

    /* renamed from: c  reason: collision with root package name */
    public String f48506c;

    /* renamed from: d  reason: collision with root package name */
    private net.one97.paytm.addmoney.common.view.a.a f48507d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RecyclerView f48508e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f48509f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f48510g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f48511h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f48512i;
    private EditText j;
    /* access modifiers changed from: private */
    public TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    private ImageView m;
    private TextView n;
    private TextView o;
    private ViewGroup p;
    private RoboTextView q;
    private TextView r;
    private TranslateAnimation s;
    private TranslateAnimation t;
    private ScaleAnimation u;
    private ScaleAnimation v;
    private ScaleAnimation w;
    private ScaleAnimation x;
    /* access modifiers changed from: private */
    public RelativeLayout y;
    private View z;

    public static a c(int i2) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putInt("destinationAddMoney", i2);
        aVar.setArguments(bundle);
        return aVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.U = getArguments().getBoolean("destroy_self", false);
        this.A = getArguments().getInt("destinationAddMoney");
        this.f48504a = new net.one97.paytm.addmoney.common.c.a(this, this.A, j.a(getContext(), getParentFragment()));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.z = layoutInflater.inflate(R.layout.uam_fragment_common_add_money, viewGroup, false);
        if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
            d.a(getActivity(), "/add-money/wallet");
        }
        this.r = (TextView) e(R.id.tv_add_cash_wallet);
        this.r.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.c(a.this);
            }
        });
        if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
            this.r.setText(getString(R.string.uam_ppb_cash_point_text));
        }
        this.X = (ImageView) e(R.id.img_collapse);
        this.V = (LinearLayout) e(R.id.acc_ly);
        this.W = (TextView) e(R.id.tv_acc_no);
        this.Y = (TextView) e(R.id.tv_ifsc_code);
        this.f48508e = (RecyclerView) e(R.id.sourceCardRV);
        this.V.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (a.this.Y.getVisibility() == 0) {
                    a.e(a.this);
                } else {
                    a.f(a.this);
                }
            }
        });
        this.f48508e.setNestedScrollingEnabled(false);
        this.S = new LinearLayoutManager(getContext(), 1, false);
        this.f48508e.setLayoutManager(this.S);
        this.f48507d = new net.one97.paytm.addmoney.common.view.a.a(this, this.f48504a, this.A, this.U);
        this.f48508e.setAdapter(this.f48507d);
        this.f48512i = (TextView) e(R.id.nonEditableTitleTV);
        this.f48509f = (TextView) e(R.id.nonEditableAmountTV);
        this.j = (EditText) e(R.id.amount_et);
        this.l = (TextView) e(R.id.tv_error_message);
        this.k = (TextView) e(R.id.rupee_beside_et);
        this.y = (RelativeLayout) e(R.id.amountEditableLayout);
        this.m = (ImageView) e(R.id.bank_icon);
        this.n = (TextView) e(R.id.balanceTv);
        this.o = (TextView) e(R.id.title);
        this.p = (ViewGroup) e(R.id.open_item_layout);
        this.q = (RoboTextView) e(R.id.add_money_from_tv);
        this.B = (LottieAnimationView) e(R.id.content_loader);
        this.D = (ViewGroup) e(R.id.open_item_header);
        this.E = (AppCompatImageView) e(R.id.open_item_header_icon);
        this.F = (TextView) e(R.id.open_item_header_title);
        this.G = (TextView) e(R.id.open_item_header_subtitle);
        this.H = (ImageView) e(R.id.bankMotifIV);
        this.L = (RelativeLayout) e(R.id.editTextLayout);
        this.M = (RelativeLayout) e(R.id.rl_uam_promo_code);
        this.O = (TextView) e(R.id.toolbarTitle);
        this.P = (TextView) e(R.id.toolbarSubTitle);
        this.N = (LinearLayout) e(R.id.lnr_promo_applied);
        this.Q = (int) getResources().getDimension(R.dimen.uam_et_layout_height);
        this.R = ((LinearLayout.LayoutParams) this.L.getLayoutParams()).topMargin;
        if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
            this.f48512i.setText(R.string.uam_toolbar_title_wallet);
            this.o.setText(R.string.uam_toolbar_title_wallet);
            this.O.setText(R.string.uam_toolbar_title_wallet);
            this.m.setImageDrawable(androidx.core.content.b.a((Context) getActivity(), R.drawable.uam_wallet_source_list_icon));
        } else if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
            this.f48512i.setText(R.string.uam_ppb_add_money_title_non_edit);
            this.O.setText(R.string.uam_toolbar_title_ppb_new);
            this.m.setImageDrawable(androidx.core.content.b.a((Context) getActivity(), R.drawable.uam_ppb_header_icon));
        }
        this.K = (NestedScrollView) e(R.id.scrollview);
        this.K.setOnScrollChangeListener(new NestedScrollView.b() {
            public final void onScrollChange(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                if (a.this.L.getHeight() + a.this.R >= i3) {
                    a.this.P.setVisibility(8);
                    a.this.O.setVisibility(8);
                } else if (a.this.P.getVisibility() == 8) {
                    a.this.P.setVisibility(0);
                    a.this.O.setVisibility(0);
                }
            }
        });
        e(R.id.payments_bank_info_btn_close).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.r();
            }
        });
        this.s = new TranslateAnimation(0.0f, 0.0f, 150.0f, 0.0f);
        this.s.setFillAfter(true);
        this.s.setDuration(350);
        this.s.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
                a.this.y.setVisibility(4);
            }
        });
        this.t = new TranslateAnimation(0.0f, 0.0f, -150.0f, 0.0f);
        this.t.setFillAfter(true);
        this.t.setDuration(350);
        this.t.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                a.this.f48509f.setVisibility(8);
                a.this.y.setVisibility(0);
            }
        });
        this.u = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.u.setDuration(350);
        this.u.setFillAfter(true);
        this.v = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.v.setDuration(350);
        this.v.setFillAfter(true);
        this.w = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f);
        this.w.setDuration(350);
        this.w.setFillAfter(true);
        this.x = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f);
        this.x.setDuration(350);
        this.x.setFillAfter(true);
        c.a().f48964g = null;
        ((CustomAmountTextInputEditText) this.j).setPrefix("");
        ((CustomAmountTextInputEditText) this.j).setMaxDigitsBeforeDecimalPoint(6);
        this.j.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                a.this.l.setVisibility(4);
            }

            public final void afterTextChanged(Editable editable) {
                String obj = editable.toString();
                String str = c.a().f48964g;
                if (!TextUtils.isEmpty(str) && !str.equalsIgnoreCase(obj)) {
                    Intent intent = new Intent("payment_item_selected");
                    intent.putExtra("payment_item_type", SourceCardType.NO_CARD.getNumVal());
                    androidx.localbroadcastmanager.a.a.a((Context) a.this.getActivity()).a(intent);
                    a.this.f48504a.m();
                    if (a.this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
                        String unused = a.this.f48506c = null;
                        a.this.d((String) null);
                    }
                }
                c.a().f48964g = obj;
                if (editable.length() > 0) {
                    a.this.k.setTextColor(androidx.core.content.b.c(a.this.getActivity(), R.color.black));
                } else {
                    a.this.k.setTextColor(androidx.core.content.b.c(a.this.getActivity(), R.color.color_b8c2cb));
                }
                if (!TextUtils.isEmpty(a.this.a())) {
                    a.this.P.setText(a.this.getString(R.string.uam_rs_amount, com.paytm.utility.b.T(a.this.a())));
                    return;
                }
                a.this.P.setText("");
            }
        });
        String string = getArguments().getString("Amount");
        if (!TextUtils.isEmpty(string)) {
            this.j.setText(string.replace(".00", "").replace(".0", ""));
            EditText editText = this.j;
            editText.setSelection(editText.getText().length());
        }
        if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
            this.M.setVisibility(0);
        }
        this.f48511h = (TextView) e(R.id.uam_have_a_promo_code_tv);
        this.f48511h.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!TextUtils.isEmpty(a.this.a())) {
                    String string = a.this.getActivity().getString(R.string.apply_promo_code);
                    a aVar = a.this;
                    b unused = aVar.f48505b = new b(aVar.getActivity(), string, a.this.getActivity().getString(R.string.apply), new net.one97.paytm.wallet.newdesign.addmoney.c.b() {
                        public final void a(String str) {
                            String unused = a.this.T = str;
                            a.this.f48504a.n();
                        }
                    });
                    a.this.f48505b.setCanceledOnTouchOutside(true);
                    a.this.f48505b.show();
                    b g2 = a.this.f48505b;
                    EditText editText = g2.f48429b;
                    editText.postDelayed(new Runnable(editText) {

                        /* renamed from: a */
                        final /* synthetic */ EditText f48437a;

                        public final void run(
/*
Method generation error in method: net.one97.paytm.addmoney.common.b.b.3.run():void, dex: classes3.dex
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.addmoney.common.b.b.3.run():void, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
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
                    }, 100);
                    return;
                }
                a.this.a(UAMErrorType.VALID_AMOUNT);
            }
        });
        this.f48510g = (TextView) e(R.id.uam_promo_code_label_tv);
        this.f48510g.setMaxWidth(com.paytm.utility.b.f((Context) getActivity()) * 6);
        this.f48510g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a aVar = a.this;
                try {
                    if (aVar.f48505b != null && !aVar.f48505b.isShowing()) {
                        aVar.f48505b.show();
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        e(R.id.uam_promo_code_clear_iv).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a aVar = a.this;
                AlertDialog.Builder builder = new AlertDialog.Builder(aVar.getActivity());
                builder.setTitle(aVar.getResources().getString(R.string.remove_code_title));
                builder.setMessage(aVar.getResources().getString(R.string.remove_code_msg));
                builder.setPositiveButton(aVar.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        String unused = a.this.f48506c = null;
                        a.this.d((String) null);
                    }
                });
                builder.setNegativeButton(aVar.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                if (!aVar.getActivity().isFinishing()) {
                    builder.show();
                }
            }
        });
        this.f48504a.a();
        int color = getResources().getColor(R.color.white);
        Window window = getActivity().getWindow();
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
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("actionButtonClicked");
        intentFilter.addAction("payment_item_selected");
        intentFilter.addAction("payment_item_validate_selection");
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.Z, intentFilter);
        return this.z;
    }

    private View e(int i2) {
        return this.z.findViewById(i2);
    }

    public final double e() {
        return UpiUtils.getMinAmountAllowed(getContext());
    }

    public final double f() {
        return UpiUtils.getMaxAmountAllowed(getContext());
    }

    public final boolean g() {
        return com.paytm.utility.b.c((Context) getActivity());
    }

    public final void h() {
        if (isAdded()) {
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.uam_error), getString(R.string.uam_check_network));
        }
    }

    public final void b(UAMErrorType uAMErrorType) {
        if (isAdded() && uAMErrorType == UAMErrorType.PLEASE_WAIT) {
            com.paytm.utility.b.a((Context) getActivity(), getString(R.string.uam_please_wait));
        }
    }

    public final void a(CJPayMethodResponse cJPayMethodResponse) {
        g.a().updateResponse(cJPayMethodResponse);
        if (getActivity() != null && !getActivity().isFinishing()) {
            g.a().a((Context) getActivity());
        }
    }

    public final String i() {
        if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
            return net.one97.paytm.helper.a.b().f("ppb_merchant_id");
        }
        return this.A == PaymentDestinationType.TO_WALLET.getNumVal() ? net.one97.paytm.helper.a.b().f("wallet_merchant_id") : "";
    }

    public final String j() {
        return com.paytm.utility.a.q(getActivity());
    }

    public final String k() {
        return net.one97.paytm.helper.a.b().f("universalAddMoneyPayMethodsList");
    }

    public final String l() {
        return net.one97.paytm.helper.a.b().m();
    }

    public final void n() {
        if (isAdded()) {
            this.f48507d.notifyDataSetChanged();
        }
    }

    public final void a(String str) {
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            String string = getString(R.string.error);
            if (str == null) {
                str = getString(R.string.title_400);
            }
            com.paytm.utility.b.b((Context) activity, string, str);
        }
    }

    public final void a(String str, final String str2, String str3) {
        if (isAdded()) {
            final com.paytm.utility.h hVar = new com.paytm.utility.h(getActivity());
            hVar.a();
            if (str == null) {
                str = getString(R.string.title_400);
            }
            hVar.a(str);
            hVar.a(-1, str3, new View.OnClickListener() {
                public final void onClick(View view) {
                    hVar.dismiss();
                    net.one97.paytm.helper.a.b().a((Context) a.this.getActivity(), str2);
                }
            });
            hVar.show();
        }
    }

    public final void r() {
        if (this.I) {
            getActivity().finish();
        } else {
            getActivity().finish();
        }
    }

    public final void a(boolean z2) {
        a(z2, (String) null, (String) null);
    }

    public final String a() {
        return this.j.getText().toString().replace(AppConstants.COMMA, "");
    }

    public final String m() {
        return this.T;
    }

    public final double d() throws NumberFormatException {
        try {
            return Double.parseDouble(a());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public final void a(UAMErrorType uAMErrorType) {
        String str = "";
        if (uAMErrorType == UAMErrorType.AMOUNTNULL) {
            str = getString(R.string.uam_please_enter_amount);
        } else if (uAMErrorType == UAMErrorType.VALID_AMOUNT) {
            str = getString(R.string.uam_please_enter_valid_amount);
        } else if (uAMErrorType == UAMErrorType.MORE_THAN_AVAILABLE) {
            str = getString(R.string.uam_amt_more_than_available);
        } else if (uAMErrorType == UAMErrorType.INVALID_AMOUNT) {
            str = getString(R.string.uam_invalid_amount);
        } else if (uAMErrorType == UAMErrorType.INSUFFICIENT_BALANCE) {
            str = getString(R.string.uam_bhim_low_bal_error);
        } else {
            UAMErrorType uAMErrorType2 = UAMErrorType.WALLET_LIMIT_BREACH;
        }
        e(str);
    }

    public final void a(String str, String str2, SourceCardDataModel sourceCardDataModel) {
        String string = getString(R.string.uam_enter_amount_between, com.paytm.utility.b.T(str), com.paytm.utility.b.T(str2));
        if (TextUtils.isEmpty(str)) {
            if (sourceCardDataModel.getType() == SourceCardType.BHIM_UPI || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_UPI) {
                string = getString(R.string.uam_bhim_max_amount_error, com.paytm.utility.b.T(str2));
            } else if (sourceCardDataModel.getType() == SourceCardType.DEBIT_CARD || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC) {
                string = getString(R.string.uam_dc_max_amount_error, com.paytm.utility.b.T(str2));
            } else if (sourceCardDataModel.getType() == SourceCardType.CREDIT_CARD || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                string = getString(R.string.uam_cc_max_amount_error, com.paytm.utility.b.T(str2));
            }
        } else if (TextUtils.isEmpty(str2)) {
            if (sourceCardDataModel.getType() == SourceCardType.WALLET) {
                string = getString(R.string.uam_wallet_max_amount_error, com.paytm.utility.b.T(str));
            } else if (sourceCardDataModel.getType() == SourceCardType.DEBIT_CARD || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_DC) {
                string = getString(R.string.uam_dc_max_amount_error, com.paytm.utility.b.T(str));
            } else if (sourceCardDataModel.getType() == SourceCardType.CREDIT_CARD || sourceCardDataModel.getType() == SourceCardType.PAYMENT_ITEM_TYPE_CC) {
                string = getString(R.string.uam_cc_max_amount_error, com.paytm.utility.b.T(str));
            }
        }
        e(string);
    }

    private void e(String str) {
        if (this.j.getVisibility() == 0) {
            this.l.setText(str);
            this.l.setVisibility(0);
            this.j.requestFocus();
        } else {
            r();
            this.l.setText(str);
            this.l.setVisibility(0);
            this.j.requestFocus();
        }
        this.K.scrollTo(0, 0);
    }

    public final void d(int i2) {
        if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
            d.a((Context) getActivity(), "add_money_wallet", "payment_option_selected", "/add-money/wallet", (i2 == SourceCardType.BHIM_UPI.getNumVal() || i2 == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal()) ? "upi" : (i2 == SourceCardType.DEBIT_CARD.getNumVal() || i2 == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal()) ? "debit_card" : (i2 == SourceCardType.CREDIT_CARD.getNumVal() || i2 == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) ? "credit_card" : i2 == SourceCardType.WALLET.getNumVal() ? "paytm_wallet" : i2 == SourceCardType.FD.getNumVal() ? "fixed_deposit" : i2 == SourceCardType.OTHER_BANKS.getNumVal() ? "other_bank" : i2 == SourceCardType.GOLD.getNumVal() ? "paytm_gold" : i2 == SourceCardType.PPB.getNumVal() ? "paytm_bank" : null, (String) null);
        }
    }

    public final void a(int i2) {
        this.f48507d.notifyItemChanged(i2);
    }

    public final void b() {
        if (isAdded()) {
            try {
                if (this.C != null && this.C.isShowing() && isResumed()) {
                    this.C.dismiss();
                    this.C = null;
                }
            } catch (Exception e2) {
                net.one97.paytm.helper.a.b().a(e2);
            }
        }
    }

    public final void c() {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), (String) null, (Bundle) null);
        }
    }

    public final void b(NetworkCustomError networkCustomError) {
        AddMoneyUtils.a(getActivity(), networkCustomError, (String) null, Boolean.FALSE);
    }

    private void a(boolean z2, String str, String str2) {
        try {
            if (this.J == null) {
                this.J = new f(getActivity());
            }
            if (!TextUtils.isEmpty(str)) {
                this.J.f48967a = str;
            }
            if (!TextUtils.isEmpty(str2)) {
                this.J.f48968b = str2;
            }
            if (z2) {
                this.J.a();
            } else {
                this.J.b();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void o() {
        if (isAdded()) {
            a(true, getString(R.string.uam_fetching_instruments), getString(R.string.please_wait));
        }
    }

    public final double p() {
        int h2;
        if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
            h2 = net.one97.paytm.helper.a.b().h("ppb_debit_card_limit");
        } else {
            h2 = net.one97.paytm.helper.a.b().h("wallet_debit_card_limit");
        }
        return (double) h2;
    }

    public final void b(String str) {
        if (isAdded()) {
            this.n.setText(getString(R.string.uam_available_ppb_balance, com.paytm.utility.b.T(str)));
            String o2 = this.f48504a.o();
            if (!TextUtils.isEmpty(o2)) {
                this.W.setText(getString(R.string.uam_ppb_acc_no, AddMoneyUtils.f(o2)));
                this.r.setVisibility(0);
            }
        }
    }

    public void onResume() {
        super.onResume();
    }

    public final void a(boolean z2, int i2) {
        String str;
        if (i2 == SourceCardType.PAYMENT_ITEM_TYPE_DC.getNumVal()) {
            str = "payment_item_validate_selection_status_dc";
        } else if (i2 == SourceCardType.PAYMENT_ITEM_TYPE_CC.getNumVal()) {
            str = "payment_item_validate_selection_status_cc";
        } else {
            str = i2 == SourceCardType.PAYMENT_ITEM_TYPE_UPI.getNumVal() ? "payment_item_validate_selection_status_upi" : "";
        }
        if (!TextUtils.isEmpty(str)) {
            Intent intent = new Intent(str);
            intent.putExtra("payment_item_is_valid", z2);
            intent.putExtra("payment_item_type", i2);
            androidx.localbroadcastmanager.a.a.a(getContext()).a(intent);
        }
    }

    public final Double s() {
        return Double.valueOf(d());
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), a.class.getCanonicalName(), (Bundle) null);
        }
    }

    public final void b(final int i2) {
        NestedScrollView nestedScrollView;
        if (i2 > 2 && (nestedScrollView = this.K) != null && this.f48508e != null) {
            nestedScrollView.postDelayed(new Runnable() {
                public final void run() {
                    View childAt = a.this.f48508e.getLayoutManager().getChildAt(i2);
                    if (childAt != null) {
                        ObjectAnimator.ofInt(a.this.K, "scrollY", new int[]{childAt.getBottom()}).setDuration(500).start();
                    }
                }
            }, 100);
        }
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (TextUtils.isEmpty(str) || !str.equalsIgnoreCase("PRIME")) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(getActivity().getString(R.string.add_money));
                builder.setMessage(str2);
                builder.setPositiveButton(getActivity().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        if (a.this.getActivity() != null) {
                            a.this.startActivity(net.one97.paytm.helper.a.b().l(a.this.getActivity()));
                        }
                    }
                });
                builder.setNegativeButton(getActivity().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        if (a.this.getActivity() == null) {
                            a.this.getActivity().isFinishing();
                        }
                    }
                });
                builder.setCancelable(true);
                builder.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            com.paytm.utility.b.b((Context) getActivity(), getActivity().getString(R.string.add_money), str2);
        }
    }

    public final void a(CJRCart cJRCart) {
        String str;
        b bVar;
        String str2 = null;
        if (cJRCart == null || cJRCart.getPromoStatus() == null || !cJRCart.getPromoStatus().equalsIgnoreCase("SUCCESS")) {
            this.f48506c = null;
            if (cJRCart != null) {
                str2 = cJRCart.getPromoFailureText();
            }
            if (str2 == null || str2.trim().length() == 0) {
                str2 = getActivity().getResources().getString(R.string.msg_invalid_recharge_promo_code);
            }
            b bVar2 = this.f48505b;
            if (bVar2 != null && bVar2.isShowing()) {
                this.f48505b.a(str2);
            }
        } else {
            if (cJRCart.getCartItems() == null || cJRCart.getCartItems().size() <= 0) {
                str = null;
            } else {
                CJRCartProduct cJRCartProduct = cJRCart.getCartItems().get(0);
                String promoCode = cJRCartProduct.getPromoCode();
                str = cJRCartProduct.getPromoText();
                str2 = promoCode;
            }
            if (TextUtils.isEmpty(str2) && (bVar = this.f48505b) != null) {
                str2 = bVar.b();
            }
            this.f48506c = str2;
            if (TextUtils.isEmpty(str)) {
                str = cJRCart.getPromoText();
            }
            b bVar3 = this.f48505b;
            if (bVar3 != null && bVar3.isShowing()) {
                this.f48505b.a(str2, str);
                com.paytm.utility.b.c((Activity) getActivity());
            }
        }
        d(this.f48506c);
    }

    public final void c(String str) {
        if (isAdded() && getActivity() != null && !getActivity().isFinishing()) {
            net.one97.paytm.helper.a.b().a(getContext(), str);
            if (str.contains("paytmmp://payment_bank?featuretype=redeem_fd&amount_to_redeem=")) {
                Intent intent = new Intent();
                intent.putExtra("fd_clicked", true);
                getActivity().setResult(-1, intent);
            }
            getActivity().finish();
        }
    }

    public final boolean a(CJRRechargeCart cJRRechargeCart) {
        FragmentActivity activity = getActivity();
        String string = getString(R.string.proceed);
        Iterator<CJRCartProduct> it2 = cJRRechargeCart.getCart().getCartItems().iterator();
        while (it2.hasNext()) {
            CJRCartProduct next = it2.next();
            if (next.getError() != null) {
                String errorCode = next.getErrorCode();
                if (TextUtils.isEmpty(errorCode) || (!"CT_CP_4001".equalsIgnoreCase(errorCode) && !"CT_CP_4010".equalsIgnoreCase(errorCode))) {
                    String errorTitle = next.getErrorTitle();
                    if (errorTitle == null || errorTitle.trim().length() <= 0) {
                        com.paytm.utility.b.b((Context) activity, string, next.getError());
                    } else {
                        com.paytm.utility.b.b((Context) activity, errorTitle, next.getError());
                    }
                    return true;
                }
                com.paytm.utility.b.b((Context) activity, activity.getResources().getString(R.string.title_msg_for_deals), activity.getResources().getString(R.string.error_msg_for_deals));
                return true;
            }
        }
        if (cJRRechargeCart.getCart().getError() == null) {
            return false;
        }
        if (cJRRechargeCart == null || cJRRechargeCart.getCart() == null) {
            com.paytm.utility.b.b((Context) activity, activity.getResources().getString(R.string.network_error_heading), activity.getResources().getString(R.string.network_error_message));
        } else {
            String errorTitle2 = cJRRechargeCart.getCart().getErrorTitle();
            if (errorTitle2 != null && errorTitle2.trim().length() > 0) {
                string = errorTitle2;
            }
            com.paytm.utility.b.b((Context) activity, string, cJRRechargeCart.getCart().getError());
        }
        return true;
    }

    public final void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f48511h.setVisibility(0);
            this.N.setVisibility(8);
            return;
        }
        this.f48511h.setVisibility(8);
        this.N.setVisibility(0);
        this.f48510g.setText(str);
    }

    public final void q() {
        b bVar = this.f48505b;
        if (bVar != null) {
            bVar.a();
            if (this.f48505b.isShowing()) {
                this.f48505b.dismiss();
            }
        }
    }

    private static void a(ImageView imageView, int i2) {
        imageView.clearAnimation();
        imageView.animate().rotation(i2 == 0 ? 180.0f : 0.0f).setDuration(300).start();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 109) {
            HashMap hashMap = new HashMap();
            hashMap.put("app_permissions_and_status", "location=true");
            if (!(androidx.core.app.a.a((Context) getActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0 || androidx.core.app.a.a((Context) getActivity(), "android.permission.ACCESS_COARSE_LOCATION") == 0)) {
                hashMap.put("app_permissions_and_status", "location=false");
            }
            net.one97.paytm.helper.a.b().a("app_permissions_provided", (Map<String, Object>) hashMap, getActivity().getApplicationContext());
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(getActivity().getApplicationContext(), "Please go to setting and enable the location permission", 0).show();
            } else {
                t();
            }
        }
    }

    private void t() {
        Intent intent = new Intent(getActivity(), NearByAddMoneyActivity.class);
        intent.putExtra("showTab", true);
        if (this.A == PaymentDestinationType.TO_PAYTM_BANK.getNumVal()) {
            intent.putExtra("nearby_points", m.NEARBY_BANKING_POINT.getIdentifier());
        } else if (this.A == PaymentDestinationType.TO_WALLET.getNumVal()) {
            intent.putExtra("nearby_points", m.NEARBY_CASH_POINT.getIdentifier());
        }
        startActivity(intent);
    }

    public void onDestroyView() {
        androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.Z);
        super.onDestroyView();
    }

    static /* synthetic */ void a(a aVar) {
        if (!TextUtils.isEmpty(aVar.a())) {
            aVar.l.setText("");
            aVar.l.setVisibility(4);
        }
    }

    static /* synthetic */ void c(a aVar) {
        if (Build.VERSION.SDK_INT < 23) {
            aVar.t();
        } else if (androidx.core.content.b.a((Context) aVar.getActivity(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            aVar.requestPermissions(new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 109);
        } else {
            aVar.t();
        }
    }

    static /* synthetic */ void e(a aVar) {
        aVar.Y.setVisibility(8);
        a(aVar.X, 1);
    }

    static /* synthetic */ void f(a aVar) {
        aVar.Y.setVisibility(0);
        aVar.Y.setText(aVar.getString(R.string.ifsc_ppb));
        a(aVar.X, 0);
    }
}
