package net.one97.paytm.upi.registration.view;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.utility.n;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UserUpiDetails;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.profile.view.SetMPINActivity;
import net.one97.paytm.upi.profile.view.UpiProfileAccountDetailActivity;
import net.one97.paytm.upi.registration.a.g;
import net.one97.paytm.upi.registration.b.a.b;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.CustomWalletLoaderDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.IncorrectUpiPinBottomSheet;
import net.one97.paytm.upi.util.PaytmUpiPrefUtil;
import net.one97.paytm.upi.util.UPICheckBalanceHelper;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class v extends h implements View.OnClickListener, n.c, a.C1347a, g.b {
    private String A;
    private String B;
    private boolean C;
    private boolean D;
    /* access modifiers changed from: private */
    public UPICheckBalanceHelper E;
    /* access modifiers changed from: private */
    public UpiProfileDefaultBank F = null;
    private BroadcastReceiver G = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (UpiConstants.INTENT_ACTION_REFRESH_LINKED_ACCOUNTS.equalsIgnoreCase(intent.getAction()) && v.this.u != null) {
                v.this.u.a();
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private TextView f69065a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f69066b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f69067c;

    /* renamed from: d  reason: collision with root package name */
    private RelativeLayout f69068d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f69069e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f69070f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f69071g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f69072h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f69073i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private RelativeLayout n;
    private TextView o;
    private TextView p;
    /* access modifiers changed from: private */
    public String q;
    private RecyclerView r;
    /* access modifiers changed from: private */
    public f s;
    private CustomWalletLoaderDialog t;
    /* access modifiers changed from: private */
    public g.a u;
    private List<BankAccountDetails.BankAccount> v = new ArrayList();
    private Dialog w;
    private boolean x;
    private boolean y;
    private boolean z;

    public void onServiceConnected() {
    }

    public void onServiceDisconnected() {
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.u = (g.a) obj;
    }

    public static v a(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        bundle.putBoolean("do_show_swipe", z2);
        v vVar = new v();
        vVar.setArguments(bundle);
        return vVar;
    }

    public static v b(String str, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putString("source", str);
        bundle.putBoolean("do_show_swipe", true);
        bundle.putBoolean("show_favorite_banks", true);
        bundle.putBoolean("show_vpa", z2);
        v vVar = new v();
        vVar.setArguments(bundle);
        return vVar;
    }

    public final String j() {
        return this.B;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.A = getArguments().getString("feature_type");
            this.y = getArguments().getBoolean("is_deeplink", false);
            this.B = getArguments().getString("source");
            this.z = getArguments().getBoolean("do_show_swipe", false);
            this.C = getArguments().getBoolean("show_favorite_banks", false);
            this.D = getArguments().getBoolean("show_vpa", false);
        }
        androidx.localbroadcastmanager.a.a.a(getActivity().getApplicationContext()).a(this.G, new IntentFilter(UpiConstants.INTENT_ACTION_REFRESH_LINKED_ACCOUNTS));
        getActivity();
        getActivity();
        b a2 = net.one97.paytm.upi.g.a(a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null));
        getActivity();
        net.one97.paytm.upi.profile.b.b a3 = net.one97.paytm.upi.g.a();
        getActivity();
        this.u = new net.one97.paytm.upi.registration.presenter.g(this, a2, a3, a.a(net.one97.paytm.upi.g.d(), this));
        this.E = new UPICheckBalanceHelper.UPICheckBalanceBuilder(getActivity(), this).setDeviceBindingRequestCode(112).setScreenName(getClass().getName()).setTag(getClass().getName()).setOnActivityResultRecieverAfterDeviceBinding((Fragment) this).build();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_linked_banks, viewGroup, false);
        this.f69069e = (RelativeLayout) inflate.findViewById(R.id.parentContainer);
        this.f69065a = (TextView) inflate.findViewById(R.id.tv_vpa);
        this.f69066b = (TextView) inflate.findViewById(R.id.tv_add_bank_account);
        this.f69067c = (TextView) inflate.findViewById(R.id.tv_heading);
        this.f69068d = (RelativeLayout) inflate.findViewById(R.id.top_banks_card);
        this.n = (RelativeLayout) inflate.findViewById(R.id.link_account_header);
        this.o = (TextView) inflate.findViewById(R.id.tv_header_add_bank);
        this.p = (TextView) inflate.findViewById(R.id.tv_saved_cards_label);
        inflate.findViewById(R.id.item1_ll).setOnClickListener(this);
        inflate.findViewById(R.id.item2_ll).setOnClickListener(this);
        inflate.findViewById(R.id.item3_ll).setOnClickListener(this);
        inflate.findViewById(R.id.item4_ll).setOnClickListener(this);
        inflate.findViewById(R.id.other_bank_ll).setOnClickListener(this);
        this.f69070f = (ImageView) inflate.findViewById(R.id.icon1);
        this.f69071g = (ImageView) inflate.findViewById(R.id.icon2);
        this.f69072h = (ImageView) inflate.findViewById(R.id.icon3);
        this.f69073i = (ImageView) inflate.findViewById(R.id.icon4);
        this.j = (TextView) inflate.findViewById(R.id.item1_tv);
        this.k = (TextView) inflate.findViewById(R.id.item2_tv);
        this.l = (TextView) inflate.findViewById(R.id.item3_tv);
        this.m = (TextView) inflate.findViewById(R.id.item4_tv);
        this.f69066b.setOnClickListener(this);
        this.o.setOnClickListener(this);
        this.r = (RecyclerView) inflate.findViewById(R.id.bank_account_list);
        this.r.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.s = new f(this.u, getActivity(), this.B);
        this.r.setAdapter(this.s);
        if ("UpiLanding".equalsIgnoreCase(this.B) || "saved_payment".equalsIgnoreCase(this.B)) {
            this.r.setNestedScrollingEnabled(false);
            this.f69067c.setVisibility(8);
        } else if ("ppb_landing".equalsIgnoreCase(this.B)) {
            this.f69067c.setVisibility(0);
            this.f69067c.setText(getString(R.string.upi_saved_bank));
        }
        if ("saved_payment".equalsIgnoreCase(this.B)) {
            this.u.g();
        } else {
            this.u.a();
        }
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_add_bank_account || id == R.id.tv_header_add_bank) {
            CJRSendGTMTag.sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.UPI_EVENT_CATEGORY, "add_new_bank_account_clicked", "", "", "", "/bhim-upi/landing-screen", "wallet");
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "add_bank_acc_clicked", "", "", "", GAConstants.SCREEN_NAME.UPI_LANDING_PAGE, "wallet");
            if (m()) {
                k();
            } else {
                l();
            }
        } else if (id == R.id.item1_ll) {
            this.u.d(0);
        } else if (id == R.id.item2_ll) {
            this.u.d(1);
        } else if (id == R.id.item3_ll) {
            this.u.d(2);
        } else if (id == R.id.item4_ll) {
            this.u.d(3);
        } else if (id == R.id.other_bank_ll) {
            this.u.d();
        }
    }

    private void k() {
        if (!TextUtils.isEmpty(this.q)) {
            AccountProviderActivity.a((Fragment) this, 1001);
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.upi_vpa_missing_error_message), 1).show();
        }
    }

    public final void a(AccountProviderBody.AccountProvider accountProvider, String str) {
        BankVpaCreationActivity.a((Fragment) this, accountProvider, str, 1002);
    }

    private void l() {
        Intent intent = new Intent(getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 112);
        intent.setFlags(536870912);
        startActivityForResult(intent, 112);
    }

    public final void a(ArrayList<BankAccountDetails.BankAccount> arrayList) {
        this.v.clear();
        this.v = arrayList;
        this.s.notifyDataSetChanged();
        if (this.v.size() != 0 || !this.C) {
            this.f69068d.setVisibility(8);
        } else {
            this.u.c();
        }
        if (this.z) {
            boolean z2 = false;
            if (n()) {
                z2 = PaytmUpiPrefUtil.getPref(getContext().getApplicationContext()).b("is_animation_shown", false, false);
            }
            if (!z2) {
                new Handler().postDelayed(new Runnable() {
                    public final void run() {
                        v.a(v.this);
                        f b2 = v.this.s;
                        if (b2.getItemCount() > 0) {
                            b2.f68845a.a("0");
                            new Handler().postDelayed(new Runnable() {
                                public final void run(
/*
Method generation error in method: net.one97.paytm.upi.registration.view.f.1.run():void, dex: classes7.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.registration.view.f.1.run():void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                                
*/
                            }, 500);
                        }
                    }
                }, 500);
            }
        }
    }

    public final void b(ArrayList<BankAccountDetails.BankAccount> arrayList) {
        this.v.clear();
        this.v = arrayList;
        this.s.notifyDataSetChanged();
    }

    public final void a(List<AccountProviderBody.AccountProvider> list) {
        this.f69068d.setVisibility(0);
        a(list.get(0), this.f69070f, this.j);
        a(list.get(1), this.f69071g, this.k);
        a(list.get(2), this.f69072h, this.l);
        a(list.get(3), this.f69073i, this.m);
        if ("ppb_landing".equalsIgnoreCase(this.B)) {
            this.f69066b.setVisibility(8);
        }
    }

    private static void a(AccountProviderBody.AccountProvider accountProvider, ImageView imageView, TextView textView) {
        a(imageView, accountProvider.getBankLogoUrl());
        textView.setText(accountProvider.getAccountProvider());
    }

    private static void a(ImageView imageView, String str) {
        if (imageView == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            w.a().a(str).a(R.drawable.ic_paytm_payments_bank).b(R.drawable.ic_paytm_payments_bank).a(imageView, (e) null);
        } else {
            imageView.setImageResource(R.drawable.ic_paytm_payments_bank);
        }
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError) {
        if (upiCustomVolleyError == null) {
            return;
        }
        if (UpiUtils.isAuthenticationFailure(upiCustomVolleyError.getmErrorCode())) {
            k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            new UpiCustomVolleyError();
            v.class.getName();
            kVar.e(activity);
            return;
        }
        String alertMessage = upiCustomVolleyError.getAlertMessage();
        if (TextUtils.isEmpty(alertMessage)) {
            alertMessage = getString(R.string.upi_error_something_went_wrong);
        }
        CustomDialog.showAlert(getActivity(), "Error", alertMessage);
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (!(getActivity() == null || i2 == 112)) {
            if (i2 == 1001) {
                if (i3 == -1) {
                    this.u.a((AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER));
                } else if (this.x) {
                    getActivity().finish();
                }
            } else if (i2 == 1002) {
                if (i3 == -1) {
                    this.u.a();
                    getActivity().setResult(-1);
                } else if (this.x) {
                    getActivity().finish();
                }
            } else if (i2 == 1003) {
                if (i3 == -1) {
                    this.u.a();
                    if (getActivity() != null && (getActivity() instanceof UpiLandingPageActivity)) {
                        ((UpiLandingPageActivity) getActivity()).e();
                    }
                }
            } else if (i2 == 10 && i3 == -1) {
                this.u.a();
            }
        }
        super.onActivityResult(i2, i3, intent);
    }

    public final void a(boolean z2, String str) {
        try {
            if (this.t == null) {
                this.t = new CustomWalletLoaderDialog(getActivity());
            }
            if (z2) {
                if (!TextUtils.isEmpty(str)) {
                    this.t.setTitle(str);
                }
                this.t.showLoader();
                return;
            }
            this.t.dismissLoader();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.G != null) {
            androidx.localbroadcastmanager.a.a.a((Context) getActivity()).a(this.G);
            this.G = null;
        }
    }

    public final void a(BankAccountDetails.BankAccount bankAccount) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getActivity(), CJRGTMConstants.UPI_EVENT_CATEGORY, "saved_account_clicked", "", "", "", "/bhim-upi/landing-screen", "wallet");
        UpiProfileAccountDetailActivity.a(this, bankAccount, this.q, 1003);
    }

    public final void a(UpiCustomVolleyError upiCustomVolleyError, String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("ZM".equals(str)) {
                b(false);
            } else if ("1006".equals(str)) {
                l();
            } else if ("Z6".equals(str)) {
                b(true);
            } else {
                Toast.makeText(getActivity(), R.string.upi_check_balance_error, 1).show();
            }
        } else if (upiCustomVolleyError != null) {
            String str2 = upiCustomVolleyError.getmErrorCode();
            if (UpiUtils.isAuthenticationFailure(str2)) {
                k kVar = i.a().k;
                FragmentActivity activity = getActivity();
                new UpiCustomVolleyError();
                kVar.e(activity);
            } else if (TextUtils.isEmpty(str2) || !UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
                Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        } else {
            Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
        }
    }

    private void b(boolean z2) {
        if (isAdded()) {
            IncorrectUpiPinBottomSheet.show(new IncorrectUpiPinBottomSheet.OnItemClick() {
                public final void onReEnterClicked() {
                    v.this.E.getUpiAccountBalance(v.this.F);
                }

                public final void onCreateNewPinClicked() {
                    v vVar = v.this;
                    UpiProfileDefaultBank c2 = vVar.F;
                    Intent intent = new Intent(vVar.getActivity(), SetMPINActivity.class);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(c2.getDebitBank());
                    UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, c2.getVirtualAddress()).setBankAccountList(arrayList).build();
                    intent.putExtra("user_upi_details", build);
                    if (build.getBankAccountList() != null) {
                        net.one97.paytm.upi.h hVar = i.a().m;
                        hVar.a("UpiLinkedAccountsFragment", build.getBankAccountList().size() + "_" + build.getSelectedBankIdx());
                    } else {
                        net.one97.paytm.upi.h hVar2 = i.a().m;
                        hVar2.a("UpiLinkedAccountsFragment", "null_" + build.getSelectedBankIdx());
                    }
                    intent.putExtra(UpiConstants.CAME_FROM_INCORRECT_PIN_DIALOG, true);
                    vVar.startActivityForResult(intent, 10);
                }
            }, getChildFragmentManager(), z2);
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            try {
                if (this.w == null) {
                    this.w = UpiAppUtils.getWalletStyleProgressDialog(getActivity());
                }
                if (this.w != null && !this.w.isShowing()) {
                    this.w.show();
                }
            } catch (Exception unused) {
            }
        } else if (this.w != null && this.w.isShowing()) {
            this.w.dismiss();
        }
    }

    public final void a(String str) {
        if (getActivity() != null && isAdded() && !TextUtils.isEmpty(str)) {
            this.q = str;
            this.f69065a.setText(String.format(getString(R.string.money_transfer_upi_without_bold), new Object[]{str}));
            if (this.D) {
                this.f69065a.setVisibility(0);
                this.n.setVisibility(0);
                this.f69067c.setVisibility(8);
            } else {
                this.f69065a.setVisibility(8);
                this.n.setVisibility(8);
            }
            if ("saved_payment".equalsIgnoreCase(this.B)) {
                this.f69066b.setVisibility(8);
            } else if ("ppb_landing".equalsIgnoreCase(this.B)) {
                this.f69066b.setVisibility(0);
            } else {
                this.f69066b.setVisibility(8);
                this.n.setVisibility(0);
                this.p.setText(getString(R.string.upi_saved_bank));
            }
        }
    }

    public final void c() {
        if (this.y && !this.x && UpiConstants.FEATURE_TYPE_LINK_BANK_LIST.equalsIgnoreCase(this.A)) {
            this.x = true;
            k();
        }
    }

    private boolean m() {
        return PaytmUpiPrefUtil.getPref(getActivity().getApplicationContext()).b(UpiConstants.PREF_KEY_IS_SAME_DEVICE, false, true);
    }

    public final void d() {
        a(true, "");
    }

    public final void f() {
        a(true, "");
    }

    public final void a(int i2) {
        Toast.makeText(getActivity(), R.string.upi_bank_delete_success, 1).show();
        this.v.remove(i2);
        if (this.v.size() > 0) {
            this.u.a();
        } else {
            a(false, "");
            this.s.notifyDataSetChanged();
        }
        if (getActivity() != null && (getActivity() instanceof UpiLandingPageActivity)) {
            ((UpiLandingPageActivity) getActivity()).e();
        }
        getActivity().setResult(-1);
    }

    public final void a(UserUpiDetails userUpiDetails, UpiConstants.PROFILE_VPA_ACCOUNT_TYPE profile_vpa_account_type) {
        if (profile_vpa_account_type == UpiConstants.PROFILE_VPA_ACCOUNT_TYPE.CREDIT) {
            BankAccountDetails.BankAccount selectedBankAccount = userUpiDetails.getSelectedBankAccount();
            if (selectedBankAccount != null) {
                Toast.makeText(getActivity(), getString(R.string.upi_default_account_success, selectedBankAccount.getBankName()), 1).show();
            } else {
                Toast.makeText(getActivity(), "Default bank changed", 1).show();
            }
            this.u.a();
            if (getActivity() != null && (getActivity() instanceof UpiLandingPageActivity)) {
                ((UpiLandingPageActivity) getActivity()).e();
            }
        }
    }

    public final void b(UpiCustomVolleyError upiCustomVolleyError, String str) {
        a(false, "");
        if ("88".equals(str) || "80".equals(str)) {
            Toast.makeText(getActivity(), R.string.upi_delete_default_bank, 1).show();
        } else if ("1006".equals(str)) {
            l();
        } else if ("102".equals(str) || "INT-1199".equals(str)) {
            Toast.makeText(getActivity(), R.string.upi_delete_default_bank_vpa, 1).show();
        } else if ("INT-4051".equals(str)) {
            Toast.makeText(getActivity(), R.string.upi_delete_error_msg, 1).show();
        } else {
            String str2 = upiCustomVolleyError.getmErrorCode();
            if (TextUtils.isEmpty(str2) || !UpiConstants.NETWORK_ERROR_CODE.equals(str2)) {
                Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
            } else {
                CustomDialog.showAlert(getActivity(), getResources().getString(R.string.no_connection), getResources().getString(R.string.no_internet));
            }
        }
    }

    public final void e() {
        a(false, "");
        Toast.makeText(getActivity(), R.string.upi_some_went_wrong, 1).show();
    }

    public final void b(final BankAccountDetails.BankAccount bankAccount) {
        final CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(getActivity());
        customWalletAlertDialog.hideTitle();
        customWalletAlertDialog.setMessage(getString(R.string.mpin_missing_dlg_txt));
        customWalletAlertDialog.setButton(-2, getString(R.string.upi_do_it_later), new View.OnClickListener() {
            public final void onClick(View view) {
                v.this.u.a(bankAccount);
                customWalletAlertDialog.dismiss();
            }
        });
        customWalletAlertDialog.setButton(-1, getString(R.string.set_upi_pin), new View.OnClickListener() {
            public final void onClick(View view) {
                UpiProfileDefaultBank upiProfileDefaultBank = new UpiProfileDefaultBank();
                upiProfileDefaultBank.setVirtualAddress(v.this.q);
                upiProfileDefaultBank.setDebitBank(bankAccount);
                v.this.a(upiProfileDefaultBank);
                customWalletAlertDialog.dismiss();
            }
        });
        customWalletAlertDialog.show();
    }

    public final void a(UpiProfileDefaultBank upiProfileDefaultBank) {
        Intent intent = new Intent(getActivity(), SetMPINActivity.class);
        ArrayList arrayList = new ArrayList();
        arrayList.add(upiProfileDefaultBank.getDebitBank());
        UserUpiDetails build = new UserUpiDetails.Builder((AccountProviderBody.AccountProvider) null, upiProfileDefaultBank.getVirtualAddress()).setBankAccountList(arrayList).build();
        intent.putExtra("user_upi_details", build);
        if (build.getBankAccountList() != null) {
            net.one97.paytm.upi.h hVar = i.a().m;
            hVar.a("UpiLinkedAccountsFragment", build.getBankAccountList().size() + "_" + build.getSelectedBankIdx());
        } else {
            net.one97.paytm.upi.h hVar2 = i.a().m;
            hVar2.a("UpiLinkedAccountsFragment", "null_" + build.getSelectedBankIdx());
        }
        startActivityForResult(intent, 10);
    }

    public final void h() {
        this.f69069e.setVisibility(8);
    }

    public final void g() {
        if (m()) {
            k();
        } else {
            l();
        }
    }

    public final boolean i() {
        return UpiUtils.isInActiveProfileExist(getActivity());
    }

    public final void c(BankAccountDetails.BankAccount bankAccount) {
        this.F = new UpiProfileDefaultBank();
        this.F.setDebitBank(bankAccount);
        this.F.setVirtualAddress(this.q);
        this.E.getUpiAccountBalance(this.F);
    }

    public final void a(n.b bVar) {
        if (bVar == n.b.INCORRECT_MPIN) {
            b(false);
        } else if (bVar == n.b.INCORRECT_MPIN_TOO_MANY_TIMES) {
            b(true);
        } else {
            UpiUtils.handleCheckBalanceError(getActivity(), bVar);
        }
    }

    public final void a(String str, String str2, String str3) {
        this.u.a(str, str2);
    }

    public final void b() {
        a(false);
    }

    public final void Z_() {
        a(true);
    }

    private boolean n() {
        return getActivity() != null && !getActivity().isFinishing() && isResumed();
    }

    public static boolean a(Context context) {
        return net.one97.paytm.upi.g.a(a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)).e() && !UpiUtils.isInActiveProfileExist(context);
    }

    static /* synthetic */ void a(v vVar) {
        if (vVar.n()) {
            PaytmUpiPrefUtil.getPref(vVar.getContext().getApplicationContext()).a("is_animation_shown", true, false);
        }
    }
}
