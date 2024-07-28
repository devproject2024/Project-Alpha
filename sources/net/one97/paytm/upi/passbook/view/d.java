package net.one97.paytm.upi.passbook.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.io.Serializable;
import java.util.ArrayList;
import net.one97.paytm.games.model.pfg.BaseResult;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CJRReplacementReason;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.upi.UpiPendingRequestModel;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.k;
import net.one97.paytm.upi.passbook.a.a;
import net.one97.paytm.upi.passbook.c.b;
import net.one97.paytm.upi.q;
import net.one97.paytm.upi.registration.view.UpiLandingPageActivity;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomWalletAlertDialog;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.HorizontalDividerItemDecoration;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.upi.util.UpiWebViewActivity;
import net.one97.paytm.upi.util.UserActionEvent;

public class d extends h implements a.b {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f67800a;

    /* renamed from: b  reason: collision with root package name */
    protected RecyclerView f67801b;

    /* renamed from: c  reason: collision with root package name */
    protected LinearLayout f67802c;

    /* renamed from: d  reason: collision with root package name */
    protected LinearLayout f67803d;

    /* renamed from: e  reason: collision with root package name */
    protected ImageView f67804e;

    /* renamed from: f  reason: collision with root package name */
    protected TextView f67805f;

    /* renamed from: g  reason: collision with root package name */
    protected TextView f67806g;

    /* renamed from: h  reason: collision with root package name */
    protected TextView f67807h;

    /* renamed from: i  reason: collision with root package name */
    protected int f67808i;
    protected boolean j;
    protected boolean k;
    protected boolean l;
    protected boolean m;
    protected boolean n;
    protected RelativeLayout o;
    BroadcastReceiver p = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            if (UpiAppUtils.isNetworkAvailable(context)) {
                d.this.d(false);
                String action = intent.getAction();
                if (UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_TRANSACTIONS.equalsIgnoreCase(action)) {
                    if (d.this.t != null) {
                        d.this.t.j();
                    }
                } else if (UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_RECEIVED_TRANSACTIONS.equalsIgnoreCase(action)) {
                    if (d.this.t != null) {
                        d.this.t.h();
                    }
                } else if (UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SENT_TRANSACTIONS.equalsIgnoreCase(action)) {
                    if (d.this.t != null) {
                        d.this.t.i();
                    }
                } else if (UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SPAM.equalsIgnoreCase(action) && d.this.t != null) {
                    d.this.t.k();
                }
            }
        }
    };
    private LottieAnimationView q;
    private LottieAnimationView r;
    /* access modifiers changed from: private */
    public c s;
    /* access modifiers changed from: private */
    public a.C1377a t;
    private a u;
    private boolean v = false;
    private z<UserActionEvent.Action> w = new z<UserActionEvent.Action>() {
        public final /* synthetic */ void onChanged(Object obj) {
            UserActionEvent.Action action = (UserActionEvent.Action) obj;
            if (action != null && action.getData() != null && action.getType().equalsIgnoreCase(UserActionEvent.ActionType.PAY.name())) {
                d.this.t.a(action.getData());
            }
        }
    };

    public interface a {
        void a();
    }

    public void a(boolean z, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public void h() {
    }

    /* access modifiers changed from: protected */
    public void i() {
    }

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        this.t = (a.C1377a) obj;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j = getArguments().getBoolean(UpiConstants.INTENT_EXTRA_CST_MINIMIZE_TRANSACTION);
        this.f67808i = getArguments().getInt(UpiConstants.KEY_UPI_ITEM_TYPE);
        this.k = getArguments().getBoolean(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, false);
        this.l = getArguments().getBoolean(UpiConstants.EXTRA_INTENT_UPI_FROM_CST, false);
        this.n = getArguments().getBoolean(CJRGTMConstants.MT_V4_SETTINGS_SCREEN_NAME, false);
        this.t = g();
        this.s = a(this.t);
        if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_TRANSACTIONS);
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p, intentFilter);
        } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_RECEIVED_TRANSACTIONS);
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p, intentFilter2);
        } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
            IntentFilter intentFilter3 = new IntentFilter();
            intentFilter3.addAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SENT_TRANSACTIONS);
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p, intentFilter3);
        } else if (this.f67808i == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            IntentFilter intentFilter4 = new IntentFilter();
            intentFilter4.addAction(UpiConstants.EXTRA_ACTION_UPI_PASSBOOK_REFRESH_SPAM);
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p, intentFilter4);
        }
        if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal() && this.n) {
            Context context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append(this.s.getItemCount());
            CJRSendGTMTag.sendNewCustomGTMEvents(context, Events.Category.COLLECT, "screen_open", "", sb.toString(), "", Events.Screen.PAYMENT_REQUEST_PAGE, "");
            this.v = true;
        }
        if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            UserActionEvent.INSTANCE.getActionLiveData().observeForever(this.w);
        }
    }

    /* access modifiers changed from: protected */
    public b g() {
        getActivity();
        return new b(g.b(), this, this.f67808i, this.j);
    }

    /* access modifiers changed from: protected */
    public c a(a.C1377a aVar) {
        return new c(getActivity(), aVar, this.f67808i);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View a2 = a(layoutInflater, viewGroup);
        this.f67800a = (TextView) a2.findViewById(R.id.tv_date_header);
        this.f67803d = (LinearLayout) a2.findViewById(R.id.ll_no_transaction);
        this.f67805f = (TextView) a2.findViewById(R.id.tv_no_transaction);
        this.f67804e = (ImageView) a2.findViewById(R.id.iv_no_transaction);
        this.f67801b = (RecyclerView) a2.findViewById(R.id.rv_upi_transactions);
        this.f67802c = (LinearLayout) a2.findViewById(R.id.ll_error_container);
        this.q = (LottieAnimationView) a2.findViewById(R.id.wallet_loader);
        this.r = (LottieAnimationView) a2.findViewById(R.id.bottom_page_loader);
        this.o = (RelativeLayout) a2.findViewById(R.id.rl_section_header);
        this.f67807h = (TextView) a2.findViewById(R.id.tv_retry);
        RelativeLayout relativeLayout = this.o;
        if (relativeLayout != null) {
            this.f67806g = (TextView) relativeLayout.findViewById(R.id.tv_view_all);
            this.f67806g.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    d.this.h();
                }
            });
        }
        TextView textView = this.f67807h;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (d.this.t != null) {
                        d.this.d(false);
                        if (d.this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
                            d.this.t.j();
                        } else if (d.this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                            d.this.t.h();
                        } else if (d.this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
                            d.this.t.i();
                        } else {
                            d.this.t.k();
                        }
                    }
                }
            });
        }
        f();
        this.f67801b.setAdapter(this.s);
        this.t.e();
        return a2;
    }

    /* access modifiers changed from: protected */
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.m = true;
        return layoutInflater.inflate(R.layout.fragment_upi_transactions, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void f() {
        this.f67801b.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            this.f67801b.addItemDecoration(new HorizontalDividerItemDecoration(getActivity(), androidx.core.content.b.a((Context) getActivity(), R.drawable.upi_passbook_divider_narrow), 0));
        } else {
            this.f67801b.addItemDecoration(new HorizontalDividerItemDecoration(getActivity(), androidx.core.content.b.a((Context) getActivity(), R.drawable.upi_passbook_divider_wide), 0));
        }
        if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal() || this.f67808i == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            this.f67800a.setVisibility(0);
        } else {
            this.f67800a.setVisibility(8);
        }
        if (this.f67808i == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            CJRSendGTMTag.sendNewCustomGTMEvents(requireContext(), Events.Category.COLLECT, "screen_open", "", "", "", Events.Screen.SPAM_FOLDER, "passbook");
        }
        if (this.j) {
            this.f67800a.setVisibility(8);
        } else {
            this.f67801b.addOnScrollListener(new RecyclerView.l() {
                public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
                    super.onScrollStateChanged(recyclerView, i2);
                }

                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    super.onScrolled(recyclerView, i2, i3);
                    int itemCount = d.this.s.getItemCount();
                    int findLastVisibleItemPosition = ((LinearLayoutManager) d.this.f67801b.getLayoutManager()).findLastVisibleItemPosition();
                    int findFirstVisibleItemPosition = ((LinearLayoutManager) d.this.f67801b.getLayoutManager()).findFirstVisibleItemPosition();
                    if (findFirstVisibleItemPosition != -1 && (d.this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal() || d.this.f67808i == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal())) {
                        d dVar = d.this;
                        dVar.a(dVar.t.a(findFirstVisibleItemPosition));
                    }
                    if (findLastVisibleItemPosition < itemCount - 4) {
                        return;
                    }
                    if (d.this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
                        d.this.t.b();
                    } else if (d.this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                        d.this.t.c();
                    } else if (d.this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
                        d.this.t.d();
                    }
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            UserActionEvent.INSTANCE.getActionLiveData().removeObserver(this.w);
        }
        if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p);
        } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p);
        } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p);
        } else if (this.f67808i == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
            androidx.localbroadcastmanager.a.a.a(getContext()).a(this.p);
        }
        a.C1377a aVar = this.t;
        if (aVar != null) {
            aVar.f();
        }
    }

    public final void a(boolean z) {
        if (z) {
            AnimationFactory.startWalletLoader(this.q);
        } else {
            AnimationFactory.stopWalletLoader(this.q);
        }
    }

    public final void b(boolean z) {
        if (z) {
            AnimationFactory.startWalletLoader(this.r);
        } else {
            AnimationFactory.stopWalletLoader(this.r);
        }
    }

    public final void a(String str) {
        this.f67800a.setText(UpiUtils.getMonthNameAndYear(str));
    }

    public final void a(int i2, int i3) {
        this.s.a(i2, i3);
    }

    public final void a(int i2) {
        this.s.notifyItemRangeRemoved(0, i2);
    }

    public final void b(int i2) {
        this.s.notifyItemRangeRemoved(0, i2);
    }

    public final void c(int i2) {
        this.s.notifyItemRemoved(i2);
    }

    public final void a(int i2, int i3, ArrayList<UpiPendingRequestModel> arrayList) {
        if (arrayList.size() == 1 && !this.n && UpiGTMLoader.getInstance().isAutoRedirectionEnabled()) {
            q.a aVar = q.f68356a;
            q.a.a(arrayList.get(0), requireContext(), CJRGTMConstants.MT_V4_SOURCE_NOTIF_SMS);
        }
        this.s.a(i2, i3);
    }

    public final void a(boolean z, UpiPendingRequestModel upiPendingRequestModel) {
        if (z) {
            UserActionEvent.INSTANCE.setAction(new UserActionEvent.Action(UserActionEvent.ActionType.DECLINE.name(), upiPendingRequestModel.getTxnId()));
            Toast.makeText(getActivity(), getString(R.string.upi_request_declined), 0).show();
        } else {
            Toast.makeText(getActivity(), getString(R.string.upi_request_declined_err_msg), 0).show();
        }
        if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
            UpiUtils.sendReloadPassbookUpiBroadcast(getActivity(), true, false);
            this.t.h();
            return;
        }
        this.t.k();
    }

    public final void a(boolean z, boolean z2, UpiPendingRequestModel upiPendingRequestModel) {
        if (z) {
            if (z2) {
                UpiUtils.sendReloadPassbookUpiBroadcast(getActivity(), false, true);
                this.t.h();
            } else {
                getActivity().setResult(-1);
                UpiUtils.sendReloadPassbookUpiBroadcast(getActivity(), false, true);
                this.t.k();
            }
            UserActionEvent.INSTANCE.setAction(new UserActionEvent.Action(UserActionEvent.ActionType.SPAM.name(), upiPendingRequestModel.getTxnId()));
            return;
        }
        Toast.makeText(getActivity(), getString(R.string.upi_some_went_wrong), 0).show();
    }

    public final void a(int i2, String str, ImageView imageView) {
        if (this.s != null) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext(), Events.Category.COLLECT, "collect_request_menu_click", "", "", "", this.t.h(i2).getPayeeVa(), "", Events.Screen.PAYMENT_REQUEST_PAGE, "passbook");
            c cVar = this.s;
            PopupMenu popupMenu = new PopupMenu(cVar.f67747a, imageView);
            popupMenu.getMenuInflater().inflate(R.menu.collect_request_menu_layout, popupMenu.getMenu());
            popupMenu.show();
            MenuItem findItem = popupMenu.getMenu().findItem(R.id.order_details);
            popupMenu.getMenu().findItem(R.id.mark_spam);
            findItem.setVisible("02".equalsIgnoreCase(str));
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(i2, popupMenu) {

                /* renamed from: a */
                final /* synthetic */ int f67770a;

                /* renamed from: b */
                final /* synthetic */ PopupMenu f67771b;

                public final boolean onMenuItemClick(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.7.onMenuItemClick(android.view.MenuItem):boolean, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.7.onMenuItemClick(android.view.MenuItem):boolean, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
        }
    }

    public final void a(int i2, UpiPendingRequestModel upiPendingRequestModel) {
        if (this.s != null) {
            if (this.n) {
                q.a aVar = q.f68356a;
                q.a.a(upiPendingRequestModel, requireContext(), Events.Screen.PAYMENT_REQUEST_PAGE);
            } else {
                q.a aVar2 = q.f68356a;
                q.a.a(upiPendingRequestModel, requireContext(), CJRGTMConstants.MT_V4_SOURCE_NOTIF_SMS);
            }
            a(Events.Action.COLLECT_REQ_PAY_CLICKED, i2);
        }
    }

    public final void a(int i2, String str, String str2) {
        if (this.s != null) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext(), Events.Category.COLLECT, Events.Action.COLLECT_REQ_SPAM_CLICKED, "", "", "", this.t.h(i2).getPayeeVa(), "", Events.Screen.PAYMENT_REQUEST_PAGE, "passbook");
            c cVar = this.s;
            View inflate = LayoutInflater.from(cVar.f67747a).inflate(R.layout.dialog_upi_mark_spam, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_action);
            ((TextView) inflate.findViewById(R.id.tv_payee_name)).setText(str);
            ((TextView) inflate.findViewById(R.id.tv_payee_vpa)).setText(str2);
            ((TextView) inflate.findViewById(R.id.tv_message)).setText(cVar.f67747a.getString(R.string.upi_mark_spam_message, new Object[]{str2}));
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(cVar.f67747a);
            aVar.setContentView(inflate);
            BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
            from.setState(3);
            aVar.show();
            aVar.setOnDismissListener(new DialogInterface.OnDismissListener(from) {

                /* renamed from: a */
                final /* synthetic */ BottomSheetBehavior f67773a;

                public final void onDismiss(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.8.onDismiss(android.content.DialogInterface):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.8.onDismiss(android.content.DialogInterface):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            textView.setOnClickListener(new View.OnClickListener(aVar, i2, textView) {

                /* renamed from: a */
                final /* synthetic */ com.google.android.material.bottomsheet.a f67775a;

                /* renamed from: b */
                final /* synthetic */ int f67776b;

                /* renamed from: c */
                final /* synthetic */ TextView f67777c;

                public final void onClick(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.9.onClick(android.view.View):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.9.onClick(android.view.View):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            ((TextView) inflate.findViewById(R.id.tv_cancel)).setOnClickListener(new View.OnClickListener(aVar) {

                /* renamed from: a */
                final /* synthetic */ com.google.android.material.bottomsheet.a f67751a;

                public final void onClick(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.10.onClick(android.view.View):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.10.onClick(android.view.View):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            a(Events.Action.COLLECT_REQ_SPAM_CLICKED, i2);
        }
    }

    public final void a(int i2, String str) {
        if (this.s != null) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(requireContext(), Events.Category.COLLECT, "remove_from_spam_click", "", "", "", this.t.i(i2).getPayeeVa(), "", Events.Screen.SPAM_FOLDER, "passbook");
            c cVar = this.s;
            if (cVar.f67749c.i(i2) != null) {
                CustomWalletAlertDialog customWalletAlertDialog = new CustomWalletAlertDialog(cVar.f67747a);
                customWalletAlertDialog.setTitle(cVar.f67747a.getString(R.string.alert));
                customWalletAlertDialog.setMessage(String.format(cVar.f67747a.getString(R.string.upi_remove_from_spam_popup_content), new Object[]{str}));
                customWalletAlertDialog.setButton(-2, cVar.f67747a.getString(R.string.no), new View.OnClickListener(customWalletAlertDialog) {

                    /* renamed from: a */
                    final /* synthetic */ CustomWalletAlertDialog f67765a;

                    public final void onClick(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.5.onClick(android.view.View):void, dex: classes7.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.5.onClick(android.view.View):void, class status: UNLOADED
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
                });
                customWalletAlertDialog.setButton(-1, cVar.f67747a.getString(R.string.yes), new View.OnClickListener(customWalletAlertDialog, i2) {

                    /* renamed from: a */
                    final /* synthetic */ CustomWalletAlertDialog f67767a;

                    /* renamed from: b */
                    final /* synthetic */ int f67768b;

                    public final void onClick(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.6.onClick(android.view.View):void, dex: classes7.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.6.onClick(android.view.View):void, class status: UNLOADED
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
                });
                customWalletAlertDialog.show();
            }
        }
    }

    public final void a(int i2, String str, String str2, String str3) {
        int i3 = i2;
        c cVar = this.s;
        if (cVar != null) {
            View inflate = LayoutInflater.from(cVar.f67747a).inflate(R.layout.dialog_upi_mark_spam, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_action);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_cancel);
            ((TextView) inflate.findViewById(R.id.tv_title)).setText(cVar.f67747a.getString(R.string.upi_decline_request_title));
            ((TextView) inflate.findViewById(R.id.tv_payee_name)).setText(str2);
            ((TextView) inflate.findViewById(R.id.tv_payee_vpa)).setText(str3);
            ((TextView) inflate.findViewById(R.id.tv_message)).setVisibility(8);
            textView.setText(cVar.f67747a.getString(R.string.upi_decline_request_action));
            textView2.setText(cVar.f67747a.getString(R.string.upi_no));
            UpiAppUtils.updateAmount(UpiAppUtils.priceToString(str), (TextView) inflate.findViewById(R.id.tv_amount));
            ((LinearLayout) inflate.findViewById(R.id.ll_amount)).setVisibility(0);
            com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(cVar.f67747a);
            aVar.setContentView(inflate);
            BottomSheetBehavior from = BottomSheetBehavior.from((View) inflate.getParent());
            from.setState(3);
            aVar.show();
            aVar.setOnDismissListener(new DialogInterface.OnDismissListener(from) {

                /* renamed from: a */
                final /* synthetic */ BottomSheetBehavior f67753a;

                public final void onDismiss(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.11.onDismiss(android.content.DialogInterface):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.11.onDismiss(android.content.DialogInterface):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            textView.setOnClickListener(new View.OnClickListener(aVar, i2) {

                /* renamed from: a */
                final /* synthetic */ com.google.android.material.bottomsheet.a f67755a;

                /* renamed from: b */
                final /* synthetic */ int f67756b;

                public final void onClick(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.12.onClick(android.view.View):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.12.onClick(android.view.View):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            textView2.setOnClickListener(new View.OnClickListener(aVar) {

                /* renamed from: a */
                final /* synthetic */ com.google.android.material.bottomsheet.a f67758a;

                public final void onClick(
/*
Method generation error in method: net.one97.paytm.upi.passbook.view.c.2.onClick(android.view.View):void, dex: classes7.dex
                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: net.one97.paytm.upi.passbook.view.c.2.onClick(android.view.View):void, class status: UNLOADED
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
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                
*/
            });
            a(Events.Action.COLLECT_REQ_DECLINE_CLICKED, i2);
        }
    }

    public final void b(String str) {
        UpiWebViewActivity.Companion.startActivity(getActivity(), str);
    }

    public final void a(UpiTransactionModelV2 upiTransactionModelV2) {
        if (this.k) {
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), "passbook_UPI", "UPI_txn_details_clicked", "", "", "", "/passbook/upi", "passbook");
        }
        if (this.l || this.j) {
            CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
            cJRReplacementReason.setIssueText("UPI");
            cJRReplacementReason.setId(UpiConstants.CST_UPI_ID);
            i.a().m.a((Activity) getActivity(), (Object) upiTransactionModelV2, cJRReplacementReason);
            return;
        }
        Intent intent = new Intent(getActivity(), UpiPassbookTransactionDetailActivity.class);
        intent.putExtra("transaction", upiTransactionModelV2);
        intent.putExtra(UpiConstants.EXTRA_UPI_PENDING_REQUEST, (Serializable) null);
        intent.putExtra(UpiConstants.EXTRA_KEY_IS_FROM_PASSBOOK, this.k);
        startActivity(intent);
    }

    public final void a(a aVar) {
        this.u = aVar;
    }

    public void c(boolean z) {
        if (getActivity() != null) {
            if (z) {
                this.f67803d.setVisibility(0);
                if (this.f67808i == UpiConstants.UpiItemType.TRANSACTIONS.ordinal()) {
                    this.f67805f.setText(getString(R.string.upi_no_transaction));
                    this.f67804e.setImageResource(R.drawable.ic_no_upi_transactions);
                    a aVar = this.u;
                    if (aVar != null) {
                        aVar.a();
                    }
                } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal()) {
                    this.f67805f.setText(getString(R.string.upi_no_payment_request));
                    this.f67804e.setImageResource(R.drawable.ic_upi_empty_payment_requests);
                } else if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_SENT.ordinal()) {
                    this.f67805f.setText(getString(R.string.upi_no_payment_request_sent_message));
                    this.f67804e.setImageResource(R.drawable.ic_upi_empty_payment_requests);
                } else if (this.f67808i == UpiConstants.UpiItemType.SPAM_REQUESTS.ordinal()) {
                    this.f67805f.setText(getString(R.string.upi_no_spam_request));
                    this.f67804e.setImageResource(R.drawable.ic_upi_no_spam);
                }
            } else {
                this.f67803d.setVisibility(8);
            }
        }
    }

    public final void a() {
        Intent intent = new Intent(getContext(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", BaseResult.RESP_SYS_EXCEPTION);
        getContext().startActivity(intent);
    }

    public final void b() {
        if (i.a().k != null) {
            k kVar = i.a().k;
            FragmentActivity activity = getActivity();
            new UpiCustomVolleyError();
            UpiLandingPageActivity.class.getName();
            kVar.e(activity);
        }
    }

    public final boolean c() {
        return this.m;
    }

    public final boolean d() {
        return UpiAppUtils.isNetworkAvailable(getContext());
    }

    public final void a(UpiPendingRequestModel upiPendingRequestModel) {
        net.one97.paytm.upi.mandate.d.a aVar = net.one97.paytm.upi.mandate.d.a.f67112a;
        net.one97.paytm.upi.mandate.c.a.a(net.one97.paytm.upi.mandate.d.a.a(upiPendingRequestModel), getChildFragmentManager(), upiPendingRequestModel);
    }

    public final void e() {
        UpiUtils.showNoNetworkErrorDialog(getActivity());
        a aVar = this.u;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void a(String str, int i2) {
        UpiPendingRequestModel h2;
        if (this.f67808i == UpiConstants.UpiItemType.PENDING_REQUESTS_RECEIVED.ordinal() && (h2 = this.t.h(i2)) != null) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), Events.Category.COLLECT, str, Events.Label.PAYMENT_REQ, h2.getRefCategory(), "", h2.getPayeeVa(), "", Events.Screen.PAYMENT_REQUEST_PAGE, "");
        }
    }

    public void onResume() {
        super.onResume();
        if (!this.v && !this.n) {
            this.v = true;
            Context context = getContext();
            StringBuilder sb = new StringBuilder();
            sb.append(this.s.getItemCount());
            CJRSendGTMTag.sendNewCustomGTMEvents(context, Events.Category.COLLECT, "screen_open", "", sb.toString(), "", Events.Screen.PAYMENT_REQUEST_PAGE, "");
        }
    }

    public final void d(boolean z) {
        if (!this.m) {
            return;
        }
        if (z) {
            this.f67802c.setVisibility(0);
        } else {
            this.f67802c.setVisibility(8);
        }
    }
}
