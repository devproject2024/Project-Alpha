package net.one97.paytm.upi.mandate.view;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.m.p;
import kotlin.x;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.CJRReplacementReason;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.upi.MandateDetails;
import net.one97.paytm.upi.common.upi.UpiTransactionBankDetailsV2;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.e.c;
import net.one97.paytm.upi.mandate.f.d;
import net.one97.paytm.upi.mandate.update.b;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.mandate.utils.u;
import net.one97.paytm.upi.mandate.utils.v;
import net.one97.paytm.upi.mandate.view.m;
import net.one97.paytm.upi.registration.view.UpiRegistrationActivity;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiWebViewActivity;
import net.one97.paytm.upi.util.VerticalSpaceItemDecoration;

public final class ScheduledMandateFragment extends h implements m.a {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f67492a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.upi.mandate.f.d f67493b;

    /* renamed from: c  reason: collision with root package name */
    private LottieAnimationView f67494c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f67495d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f67496e;

    /* renamed from: f  reason: collision with root package name */
    private View f67497f;

    /* renamed from: g  reason: collision with root package name */
    private View f67498g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f67499h;

    /* renamed from: i  reason: collision with root package name */
    private View f67500i;
    private m j;
    private RefreshListReceiver k;
    private net.one97.paytm.upi.mandate.utils.h l;
    private final int m = 100;
    private HashMap n;

    static final class a<T> implements z<r<List<? extends MandateItem>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScheduledMandateFragment f67502a;

        a(ScheduledMandateFragment scheduledMandateFragment) {
            this.f67502a = scheduledMandateFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            if (rVar != null) {
                int i2 = n.f67606a[rVar.f67411a.ordinal()];
                if (i2 == 1) {
                    ScheduledMandateFragment.b(this.f67502a);
                } else if (i2 == 2) {
                    ScheduledMandateFragment.a(this.f67502a, (List) rVar.f67412b, rVar.f67414d);
                } else if (i2 == 3) {
                    if (rVar.f67413c instanceof t.a) {
                        ScheduledMandateFragment.a(this.f67502a, ((t.a) rVar.f67413c).f67420a);
                        return;
                    }
                    ScheduledMandateFragment.a(this.f67502a, (String) null);
                    ScheduledMandateFragment.a(this.f67502a, rVar.f67413c);
                }
            }
        }
    }

    static final class b<T> implements z<r<String>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScheduledMandateFragment f67503a;

        b(ScheduledMandateFragment scheduledMandateFragment) {
            this.f67503a = scheduledMandateFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            if (rVar != null) {
                int i2 = n.f67607b[rVar.f67411a.ordinal()];
                if (i2 == 1) {
                    AnimationFactory.startWalletLoader(ScheduledMandateFragment.c(this.f67503a));
                } else if (i2 == 2) {
                    AnimationFactory.stopWalletLoader(ScheduledMandateFragment.c(this.f67503a));
                } else if (i2 == 3) {
                    AnimationFactory.stopWalletLoader(ScheduledMandateFragment.c(this.f67503a));
                    ScheduledMandateFragment.a(this.f67503a, rVar.f67413c);
                }
            }
        }
    }

    static final class c<T> implements z<d.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScheduledMandateFragment f67504a;

        c(ScheduledMandateFragment scheduledMandateFragment) {
            this.f67504a = scheduledMandateFragment;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            d.a aVar = (d.a) obj;
            if (aVar != null && (aVar instanceof d.a.b)) {
                ScheduledMandateFragment.d(this.f67504a);
            }
        }
    }

    static final class d extends l implements kotlin.g.a.b<x, x> {
        final /* synthetic */ ScheduledMandateFragment this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ScheduledMandateFragment scheduledMandateFragment) {
            super(1);
            this.this$0 = scheduledMandateFragment;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((x) obj);
            return x.f47997a;
        }

        public final void invoke(x xVar) {
            k.c(xVar, "it");
            net.one97.paytm.upi.mandate.f.d a2 = ScheduledMandateFragment.a(this.this$0);
            if (!a2.f67241e) {
                return;
            }
            if (UpiAppUtils.isNetworkAvailable(a2.f67243g)) {
                a2.f67240d++;
                a2.a();
                return;
            }
            a2.f67237a.setValue(new r(u.ERROR, (Object) null, t.i.f67428a, a2.f67241e, 2));
        }
    }

    public static final /* synthetic */ net.one97.paytm.upi.mandate.f.d a(ScheduledMandateFragment scheduledMandateFragment) {
        net.one97.paytm.upi.mandate.f.d dVar = scheduledMandateFragment.f67493b;
        if (dVar == null) {
            k.a("scheduledMandateViewModel");
        }
        return dVar;
    }

    public static final /* synthetic */ LottieAnimationView c(ScheduledMandateFragment scheduledMandateFragment) {
        LottieAnimationView lottieAnimationView = scheduledMandateFragment.f67494c;
        if (lottieAnimationView == null) {
            k.a("walletLoader");
        }
        return lottieAnimationView;
    }

    public final class RefreshListReceiver extends BroadcastReceiver {
        public RefreshListReceiver() {
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null && p.a("action_refresh_scheduled_mandates", intent.getAction(), true)) {
                if (ScheduledMandateFragment.this.isResumed()) {
                    ScheduledMandateFragment.a(ScheduledMandateFragment.this).b();
                } else {
                    ScheduledMandateFragment.a(ScheduledMandateFragment.this).f67242f = true;
                }
            }
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (!(activity instanceof net.one97.paytm.upi.mandate.utils.h)) {
            activity = null;
        }
        this.l = (net.one97.paytm.upi.mandate.utils.h) activity;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_received_mandate, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.rvMandateList);
        k.a((Object) findViewById, "view.findViewById(R.id.rvMandateList)");
        this.f67492a = (RecyclerView) findViewById;
        View findViewById2 = view.findViewById(R.id.ivEmptyImage);
        k.a((Object) findViewById2, "view.findViewById(R.id.ivEmptyImage)");
        this.f67495d = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.tvEmptyMessage);
        k.a((Object) findViewById3, "view.findViewById(R.id.tvEmptyMessage)");
        this.f67496e = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.wallet_loader);
        k.a((Object) findViewById4, "view.findViewById(R.id.wallet_loader)");
        this.f67494c = (LottieAnimationView) findViewById4;
        View findViewById5 = view.findViewById(R.id.empty_view);
        k.a((Object) findViewById5, "view.findViewById(R.id.empty_view)");
        this.f67497f = findViewById5;
        View findViewById6 = view.findViewById(R.id.ll_error_container);
        k.a((Object) findViewById6, "view.findViewById(R.id.ll_error_container)");
        this.f67498g = findViewById6;
        View findViewById7 = view.findViewById(R.id.tv_retry);
        k.a((Object) findViewById7, "view.findViewById(R.id.tv_retry)");
        this.f67500i = findViewById7;
        View findViewById8 = view.findViewById(R.id.tv_error_msg);
        k.a((Object) findViewById8, "view.findViewById(R.id.tv_error_msg)");
        this.f67499h = (TextView) findViewById8;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 1, false);
        this.j = new m(this, new ArrayList());
        m mVar = this.j;
        if (mVar == null) {
            k.a("adapter");
        }
        kotlin.g.a.b<? super x, x> dVar = new d(this);
        k.c(dVar, "listener");
        mVar.f66588c = dVar;
        RecyclerView recyclerView = this.f67492a;
        if (recyclerView == null) {
            k.a("rvScheduledMandateList");
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        m mVar2 = this.j;
        if (mVar2 == null) {
            k.a("adapter");
        }
        recyclerView.setAdapter(mVar2);
        recyclerView.addItemDecoration(new VerticalSpaceItemDecoration(24));
        this.k = new RefreshListReceiver();
        IntentFilter intentFilter = new IntentFilter("action_refresh_scheduled_mandates");
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
        RefreshListReceiver refreshListReceiver = this.k;
        if (refreshListReceiver == null) {
            k.a();
        }
        a2.a(refreshListReceiver, intentFilter);
        View view2 = this.f67500i;
        if (view2 == null) {
            k.a("tvRetry");
        }
        view2.setOnClickListener(new e(this));
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ScheduledMandateFragment f67505a;

        e(ScheduledMandateFragment scheduledMandateFragment) {
            this.f67505a = scheduledMandateFragment;
        }

        public final void onClick(View view) {
            ScheduledMandateFragment.a(this.f67505a).b();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ai a2 = am.a((Fragment) this).a(net.one97.paytm.upi.mandate.f.d.class);
        k.a((Object) a2, "ViewModelProviders.of(th…ateViewModel::class.java)");
        this.f67493b = (net.one97.paytm.upi.mandate.f.d) a2;
        net.one97.paytm.upi.mandate.f.d dVar = this.f67493b;
        if (dVar == null) {
            k.a("scheduledMandateViewModel");
        }
        dVar.f67237a.observe(getViewLifecycleOwner(), new a(this));
        net.one97.paytm.upi.mandate.f.d dVar2 = this.f67493b;
        if (dVar2 == null) {
            k.a("scheduledMandateViewModel");
        }
        dVar2.f67238b.observe(getViewLifecycleOwner(), new b(this));
        net.one97.paytm.upi.mandate.f.d dVar3 = this.f67493b;
        if (dVar3 == null) {
            k.a("scheduledMandateViewModel");
        }
        dVar3.f67239c.observe(getViewLifecycleOwner(), new c(this));
        net.one97.paytm.upi.mandate.f.d dVar4 = this.f67493b;
        if (dVar4 == null) {
            k.a("scheduledMandateViewModel");
        }
        dVar4.b();
    }

    public final void onResume() {
        super.onResume();
        net.one97.paytm.upi.mandate.f.d dVar = this.f67493b;
        if (dVar == null) {
            k.a("scheduledMandateViewModel");
        }
        if (dVar.f67242f) {
            dVar.b();
            dVar.f67242f = false;
        }
    }

    public final void a(MandateItem mandateItem) {
        k.c(mandateItem, "mandateItem");
        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Overflow_View Invoice", mandateItem.getState(), mandateItem.getModifyAllowed(), mandateItem.getRevokeAllowed(), mandateItem.getPayee().getVpa(), mandateItem.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENTS, "UPI");
        UpiWebViewActivity.Companion companion = UpiWebViewActivity.Companion;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Activity activity2 = activity;
        String refUrl = mandateItem.getRefUrl();
        if (refUrl == null) {
            k.a();
        }
        companion.startActivity(activity2, refUrl, Boolean.TRUE);
    }

    public final void c(MandateItem mandateItem) {
        k.c(mandateItem, "mandateItem");
        c.a aVar = net.one97.paytm.upi.mandate.e.c.f67166a;
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        c.a.a(mandateItem, childFragmentManager);
    }

    public final void a(MandateItem mandateItem, v vVar) {
        MandateItem mandateItem2 = mandateItem;
        v vVar2 = vVar;
        k.c(mandateItem2, "mandateItem");
        k.c(vVar2, "updateType");
        int i2 = n.f67608c[vVar.ordinal()];
        if (i2 == 1) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Overflow_Pause", mandateItem.getState(), mandateItem.getModifyAllowed(), mandateItem.getRevokeAllowed(), mandateItem.getPayee().getVpa(), mandateItem.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENTS, "UPI");
        } else if (i2 == 2) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Overflow_Resume", mandateItem.getState(), mandateItem.getModifyAllowed(), mandateItem.getRevokeAllowed(), mandateItem.getPayee().getVpa(), mandateItem.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENTS, "UPI");
        } else if (i2 == 3) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Overflow_Revoke", mandateItem.getState(), mandateItem.getModifyAllowed(), mandateItem.getRevokeAllowed(), mandateItem.getPayee().getVpa(), mandateItem.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENTS, "UPI");
        } else if (i2 == 4) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Overflow_Update", mandateItem.getState(), mandateItem.getModifyAllowed(), mandateItem.getRevokeAllowed(), mandateItem.getPayee().getVpa(), mandateItem.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENTS, "UPI");
        }
        b.a aVar = net.one97.paytm.upi.mandate.update.b.f67346a;
        j childFragmentManager = getChildFragmentManager();
        k.a((Object) childFragmentManager, "childFragmentManager");
        k.c(mandateItem2, "mandateItem");
        k.c(vVar2, "updateType");
        k.c(childFragmentManager, "fragmentManager");
        net.one97.paytm.upi.mandate.update.b bVar = new net.one97.paytm.upi.mandate.update.b();
        Bundle bundle = new Bundle();
        bundle.putSerializable("mandate_item", mandateItem2);
        bundle.putSerializable("update_type", vVar2);
        bVar.setArguments(bundle);
        bVar.show(childFragmentManager, "");
    }

    public final void b(MandateItem mandateItem) {
        String str;
        MandateItem mandateItem2 = mandateItem;
        k.c(mandateItem2, "mandateItem");
        CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(getContext(), GAConstants.CATEGORY.UPI_MT_AUTOMATIC_PAYMENTS, "Overflow_Need Help", mandateItem.getState(), mandateItem.getModifyAllowed(), mandateItem.getRevokeAllowed(), mandateItem.getPayee().getVpa(), mandateItem.getAmount(), GAConstants.SCREEN_NAME.UPI_MT_AUTOMATIC_PAYMENTS, "UPI");
        CJRReplacementReason cJRReplacementReason = new CJRReplacementReason();
        cJRReplacementReason.setIssueText("UPI");
        cJRReplacementReason.setId(UpiConstants.CST_UPI_ID);
        net.one97.paytm.upi.mandate.f.d dVar = this.f67493b;
        if (dVar == null) {
            k.a("scheduledMandateViewModel");
        }
        k.c(mandateItem2, "mandateItem");
        String state = mandateItem.getState();
        if (state == null || p.a((CharSequence) state, '_', 0, false, 6) != -1) {
            String state2 = mandateItem.getState();
            if (state2 != null) {
                int a2 = p.a((CharSequence) mandateItem.getState(), '_', 0, false, 6);
                if (state2 != null) {
                    str = state2.substring(0, a2);
                    k.a((Object) str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    throw new kotlin.u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                str = null;
            }
        } else {
            str = mandateItem.getState();
        }
        if (str == null) {
            str = "";
        }
        String txnId = mandateItem.getTxnId();
        String amount = mandateItem.getAmount();
        Date parse = new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).parse(mandateItem.getValidityStartDate());
        k.a((Object) parse, "SimpleDateFormat(FORMAT_…teItem.validityStartDate)");
        String valueOf = String.valueOf(parse.getTime());
        String note = mandateItem.getNote();
        String rrn = mandateItem.getRrn();
        UpiTransactionBankDetailsV2 upiTransactionBankDetailsV2 = new UpiTransactionBankDetailsV2(mandateItem.getPayer().getUserId(), mandateItem.getPayer().getUserId(), mandateItem.getPayer().getUserName(), mandateItem.getPayer().getBankAccount(), mandateItem.getPayer().getBankIfsc(), mandateItem.getPayer().getBankName(), UpiAppUtils.getMobile(dVar.f67243g), "", mandateItem.getPayer().getVpa());
        UpiTransactionBankDetailsV2 upiTransactionBankDetailsV22 = new UpiTransactionBankDetailsV2(mandateItem.getPayee().getUserId(), mandateItem.getPayee().getUserId(), mandateItem.getPayee().getUserName(), mandateItem.getPayee().getBankAccount(), mandateItem.getPayee().getBankIfsc(), mandateItem.getPayee().getBankName(), "", mandateItem.getPayee().getImageUrl(), mandateItem.getPayee().getVpa());
        String imageUrl = mandateItem.getPayee().getImageUrl();
        String category = mandateItem.getCategory();
        String umn = mandateItem.getUmn();
        Date parse2 = new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).parse(mandateItem.getValidityStartDate());
        k.a((Object) parse2, "SimpleDateFormat(FORMAT_…teItem.validityStartDate)");
        Long valueOf2 = Long.valueOf(parse2.getTime());
        Date parse3 = new SimpleDateFormat("ddMMyyyy", Locale.getDefault()).parse(mandateItem.getValidityEndDate());
        k.a((Object) parse3, "SimpleDateFormat(FORMAT_…dateItem.validityEndDate)");
        UpiTransactionModelV2 upiTransactionModelV2 = new UpiTransactionModelV2(txnId, str, amount, valueOf, note, "DEBIT", "MANDATE", rrn, upiTransactionBankDetailsV2, upiTransactionBankDetailsV22, "Automatic Payment", imageUrl, category, "MANDATE", new MandateDetails(umn, valueOf2, Long.valueOf(parse3.getTime()), mandateItem.getState(), mandateItem.getType()));
        i a3 = i.a();
        k.a((Object) a3, "PaytmUpiSdk.getInstance()");
        a3.c().a((Activity) requireActivity(), (Object) upiTransactionModelV2, cJRReplacementReason);
    }

    private final int a() {
        RecyclerView recyclerView = this.f67492a;
        if (recyclerView == null) {
            k.a("rvScheduledMandateList");
        }
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (!(adapter instanceof m)) {
            adapter = null;
        }
        m mVar = (m) adapter;
        if (mVar != null) {
            return mVar.getItemCount();
        }
        return 0;
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (getActivity() != null) {
            if (this.k != null) {
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    k.a();
                }
                androidx.localbroadcastmanager.a.a a2 = androidx.localbroadcastmanager.a.a.a((Context) activity);
                RefreshListReceiver refreshListReceiver = this.k;
                if (refreshListReceiver == null) {
                    k.a();
                }
                a2.a((BroadcastReceiver) refreshListReceiver);
            }
            this.k = null;
        }
        HashMap hashMap = this.n;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public static final /* synthetic */ void b(ScheduledMandateFragment scheduledMandateFragment) {
        View view = scheduledMandateFragment.f67498g;
        if (view == null) {
            k.a("errorView");
        }
        view.setVisibility(8);
        View view2 = scheduledMandateFragment.f67497f;
        if (view2 == null) {
            k.a("emptyView");
        }
        view2.setVisibility(8);
        if (scheduledMandateFragment.a() == 0) {
            LottieAnimationView lottieAnimationView = scheduledMandateFragment.f67494c;
            if (lottieAnimationView == null) {
                k.a("walletLoader");
            }
            AnimationFactory.startWalletLoader(lottieAnimationView);
        }
    }

    public static final /* synthetic */ void a(ScheduledMandateFragment scheduledMandateFragment, List list, boolean z) {
        MandateListActivity mandateListActivity;
        View view = scheduledMandateFragment.f67498g;
        if (view == null) {
            k.a("errorView");
        }
        view.setVisibility(8);
        LottieAnimationView lottieAnimationView = scheduledMandateFragment.f67494c;
        if (lottieAnimationView == null) {
            k.a("walletLoader");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView);
        if (scheduledMandateFragment.getActivity() instanceof MandateListActivity) {
            FragmentActivity activity = scheduledMandateFragment.getActivity();
            if (activity != null) {
                mandateListActivity = (MandateListActivity) activity;
            } else {
                throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.view.MandateListActivity");
            }
        } else {
            mandateListActivity = null;
        }
        m mVar = scheduledMandateFragment.j;
        if (mVar == null) {
            k.a("adapter");
        }
        mVar.f66589d = z;
        boolean z2 = false;
        if (list == null || !(!list.isEmpty())) {
            if (mandateListActivity != null) {
                mandateListActivity.a(false);
            }
            if (scheduledMandateFragment.a() == 0) {
                View view2 = scheduledMandateFragment.f67497f;
                if (view2 == null) {
                    k.a("emptyView");
                }
                view2.setVisibility(0);
                RecyclerView recyclerView = scheduledMandateFragment.f67492a;
                if (recyclerView == null) {
                    k.a("rvScheduledMandateList");
                }
                recyclerView.setVisibility(8);
                ImageView imageView = scheduledMandateFragment.f67495d;
                if (imageView == null) {
                    k.a("ivEmptyImage");
                }
                imageView.setImageResource(R.drawable.ic_img_no_scheduled_mandates);
                TextView textView = scheduledMandateFragment.f67496e;
                if (textView == null) {
                    k.a("tvEmptyMessage");
                }
                textView.setText(scheduledMandateFragment.getString(R.string.upi_mandate_empty_scheduled_msg));
                return;
            }
            return;
        }
        if (mandateListActivity != null) {
            mandateListActivity.a(true);
        }
        RecyclerView recyclerView2 = scheduledMandateFragment.f67492a;
        if (recyclerView2 == null) {
            k.a("rvScheduledMandateList");
        }
        recyclerView2.setVisibility(0);
        View view3 = scheduledMandateFragment.f67497f;
        if (view3 == null) {
            k.a("emptyView");
        }
        view3.setVisibility(8);
        net.one97.paytm.upi.mandate.f.d dVar = scheduledMandateFragment.f67493b;
        if (dVar == null) {
            k.a("scheduledMandateViewModel");
        }
        if (dVar.f67240d == 0) {
            z2 = true;
        }
        if (z2) {
            m mVar2 = scheduledMandateFragment.j;
            if (mVar2 == null) {
                k.a("adapter");
            }
            k.c(list, "resultList");
            mVar2.f67552e.clear();
            mVar2.a(list);
            return;
        }
        m mVar3 = scheduledMandateFragment.j;
        if (mVar3 == null) {
            k.a("adapter");
        }
        mVar3.a(list);
    }

    public static final /* synthetic */ void a(ScheduledMandateFragment scheduledMandateFragment, String str) {
        View view = scheduledMandateFragment.f67497f;
        if (view == null) {
            k.a("emptyView");
        }
        view.setVisibility(8);
        LottieAnimationView lottieAnimationView = scheduledMandateFragment.f67494c;
        if (lottieAnimationView == null) {
            k.a("walletLoader");
        }
        AnimationFactory.stopWalletLoader(lottieAnimationView);
        if (scheduledMandateFragment.a() == 0) {
            View view2 = scheduledMandateFragment.f67498g;
            if (view2 == null) {
                k.a("errorView");
            }
            view2.setVisibility(0);
            TextView textView = scheduledMandateFragment.f67499h;
            if (textView == null) {
                k.a("errorMsg");
            }
            if (str == null) {
                str = scheduledMandateFragment.getString(R.string.upi_some_went_wrong);
            }
            textView.setText(str);
            RecyclerView recyclerView = scheduledMandateFragment.f67492a;
            if (recyclerView == null) {
                k.a("rvScheduledMandateList");
            }
            recyclerView.setVisibility(8);
        } else if (scheduledMandateFragment.getUserVisibleHint()) {
            Toast.makeText(scheduledMandateFragment.getActivity(), str != null ? str : scheduledMandateFragment.getString(R.string.upi_some_went_wrong), 0).show();
        }
    }

    public static final /* synthetic */ void a(ScheduledMandateFragment scheduledMandateFragment, t tVar) {
        if (scheduledMandateFragment.getActivity() == null) {
            return;
        }
        if (tVar instanceof t.i) {
            CustomDialog.showAlert(scheduledMandateFragment.getActivity(), scheduledMandateFragment.getResources().getString(R.string.no_connection), scheduledMandateFragment.getResources().getString(R.string.no_internet));
        } else if (tVar instanceof t.a) {
            Context context = scheduledMandateFragment.getContext();
            if (context != null) {
                String str = ((t.a) tVar).f67420a;
                if (str == null) {
                    str = scheduledMandateFragment.getString(R.string.upi_some_went_wrong);
                    k.a((Object) str, "getString(R.string.upi_some_went_wrong)");
                }
                f.a(context, str, 0);
            }
        } else if (tVar instanceof t.d) {
            Context context2 = scheduledMandateFragment.getContext();
            if (context2 != null) {
                String string = scheduledMandateFragment.getString(R.string.upi_some_went_wrong);
                k.a((Object) string, "getString(R.string.upi_some_went_wrong)");
                f.a(context2, string, 0);
            }
        } else if (tVar instanceof t.k) {
            Context context3 = scheduledMandateFragment.getContext();
            if (context3 != null) {
                String string2 = scheduledMandateFragment.getString(R.string.upi_profile_fetch_error);
                k.a((Object) string2, "getString(R.string.upi_profile_fetch_error)");
                f.a(context3, string2, 0);
            }
        } else if (tVar instanceof t.f) {
            Context context4 = scheduledMandateFragment.getContext();
            if (context4 != null) {
                String str2 = ((t.f) tVar).f67425a;
                if (str2 == null) {
                    str2 = scheduledMandateFragment.getString(R.string.something_went_wrong);
                    k.a((Object) str2, "getString(R.string.something_went_wrong)");
                }
                f.a(context4, str2, 1);
            }
        } else if ((tVar instanceof t.j) && scheduledMandateFragment.getUserVisibleHint()) {
            i a2 = i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            MandateListActivity.class.getName();
            a2.b().e(scheduledMandateFragment.getActivity());
        }
    }

    public static final /* synthetic */ void d(ScheduledMandateFragment scheduledMandateFragment) {
        Intent intent = new Intent(scheduledMandateFragment.getActivity(), UpiRegistrationActivity.class);
        intent.putExtra("redirect", 80);
        intent.setFlags(536870912);
        scheduledMandateFragment.startActivityForResult(intent, 80);
    }
}
