package net.one97.paytm.moneytransfer.view.fragments;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.d.c;
import net.one97.paytm.moneytransfer.d.d;
import net.one97.paytm.moneytransfer.utils.f;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferPostTransactionActivity;
import net.one97.paytm.moneytransfer.view.activities.MoneyTransferV3Activity;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.Events;

public final class MoneyTransferInviteFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final a f54386a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private String f54387b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f54388c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f54389d = "";

    /* renamed from: e  reason: collision with root package name */
    private final int f54390e = 4;

    /* renamed from: f  reason: collision with root package name */
    private LottieAnimationView f54391f;

    /* renamed from: g  reason: collision with root package name */
    private View f54392g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f54393h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f54394i;
    private boolean j;
    private String k = "";
    private HashMap l;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static MoneyTransferInviteFragment a(boolean z, boolean z2, String str) {
            k.c(str, "payeeVpa");
            MoneyTransferInviteFragment moneyTransferInviteFragment = new MoneyTransferInviteFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_from_collect_req", z);
            bundle.putBoolean("is_from_upi_deeplink", z2);
            bundle.putString("payee_vpa", str);
            moneyTransferInviteFragment.setArguments(bundle);
            return moneyTransferInviteFragment;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_money_transfer_invite, viewGroup, false);
        String string = getString(R.string.upi_referral_desc);
        k.a((Object) string, "getString(R.string.upi_referral_desc)");
        View findViewById = inflate.findViewById(R.id.tv_desc);
        if (findViewById != null) {
            ((TextView) findViewById).setText(string);
            ((TextView) inflate.findViewById(R.id.invite_know_more)).setOnClickListener(new b(this));
            this.f54393h = (TextView) inflate.findViewById(R.id.tv_invite);
            this.f54391f = (LottieAnimationView) inflate.findViewById(R.id.money_transfer_loader);
            this.f54392g = inflate.findViewById(R.id.money_transfer_loader_container);
            View findViewById2 = inflate.findViewById(R.id.tv_invite);
            if (findViewById2 != null) {
                ((TextView) findViewById2).setOnClickListener(new c(this));
                View findViewById3 = inflate.findViewById(R.id.upi_invite_iv_image);
                if (findViewById3 != null) {
                    ((LottieAnimationView) findViewById3).setAnimation(net.one97.paytm.upi.R.raw.upi_invite_and_earn);
                    View findViewById4 = inflate.findViewById(R.id.upi_invite_iv_image);
                    if (findViewById4 != null) {
                        ((LottieAnimationView) findViewById4).setRepeatCount(-1);
                        new Handler().postDelayed(new d(inflate), 50);
                        Bundle arguments = getArguments();
                        this.f54389d = arguments != null ? arguments.getString("source") : null;
                        return inflate;
                    }
                    throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                }
                throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferInviteFragment f54395a;

        b(MoneyTransferInviteFragment moneyTransferInviteFragment) {
            this.f54395a = moneyTransferInviteFragment;
        }

        public final void onClick(View view) {
            MoneyTransferInviteFragment.a(this.f54395a);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MoneyTransferInviteFragment f54396a;

        c(MoneyTransferInviteFragment moneyTransferInviteFragment) {
            this.f54396a = moneyTransferInviteFragment;
        }

        public final void onClick(View view) {
            MoneyTransferInviteFragment.b(this.f54396a);
            MoneyTransferInviteFragment.c(this.f54396a);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f54397a;

        d(View view) {
            this.f54397a = view;
        }

        public final void run() {
            View findViewById = this.f54397a.findViewById(R.id.upi_invite_iv_image);
            if (findViewById != null) {
                ((LottieAnimationView) findViewById).playAnimation();
                return;
            }
            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        String str;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        f.a(getContext(), CJRGTMConstants.MT_V4_INVITE_SCREEN_NAME);
        Bundle arguments = getArguments();
        boolean z = false;
        this.f54394i = arguments != null ? arguments.getBoolean("is_from_collect_req", false) : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            z = arguments2.getBoolean("is_from_upi_deeplink", false);
        }
        this.j = z;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str = arguments3.getString("payee_vpa")) == null) {
            str = "";
        }
        this.k = str;
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.bottomsheet.a f54398a;

        e(com.google.android.material.bottomsheet.a aVar) {
            this.f54398a = aVar;
        }

        public final void onClick(View view) {
            this.f54398a.dismiss();
        }
    }

    public final void onResume() {
        super.onResume();
        View view = getView();
        View findViewById = view != null ? view.findViewById(R.id.tv_invite) : null;
        if (findViewById != null) {
            TextView textView = (TextView) findViewById;
            if (textView != null) {
                textView.setEnabled(true);
                return;
            }
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.TextView");
    }

    public static final /* synthetic */ void a(MoneyTransferInviteFragment moneyTransferInviteFragment) {
        View findViewById;
        Spanned spanned;
        TextView textView = null;
        View inflate = moneyTransferInviteFragment.getLayoutInflater().inflate(net.one97.paytm.upi.R.layout.offer_details_bottomsheet_lyt, (ViewGroup) null);
        Context context = moneyTransferInviteFragment.getContext();
        if (context == null) {
            k.a();
        }
        com.google.android.material.bottomsheet.a aVar = new com.google.android.material.bottomsheet.a(context);
        aVar.setContentView(inflate);
        aVar.show();
        if (inflate != null) {
            textView = (TextView) inflate.findViewById(net.one97.paytm.upi.R.id.tnc_text);
        }
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (textView != null) {
            String upiInviteTerms = UpiGTMLoader.getInstance().getUpiInviteTerms();
            if (Build.VERSION.SDK_INT >= 24) {
                spanned = Html.fromHtml(upiInviteTerms, 0);
            } else {
                spanned = Html.fromHtml(upiInviteTerms);
            }
            textView.setText(spanned);
        }
        View findViewById2 = inflate.findViewById(R.id.title);
        k.a((Object) findViewById2, "offerDetailsBottomSheetV…yId<TextView>(R.id.title)");
        ((TextView) findViewById2).setText(moneyTransferInviteFragment.getString(R.string.mt_know_more));
        if (inflate != null && (findViewById = inflate.findViewById(net.one97.paytm.upi.R.id.close)) != null) {
            findViewById.setOnClickListener(new e(aVar));
        }
    }

    public static final /* synthetic */ void b(MoneyTransferInviteFragment moneyTransferInviteFragment) {
        if (!(moneyTransferInviteFragment.getActivity() instanceof MoneyTransferV3Activity)) {
            if (moneyTransferInviteFragment.getActivity() instanceof MoneyTransferPostTransactionActivity) {
                f.a(moneyTransferInviteFragment.getContext(), "mt_p2p_new_v1", "invite_now_clicked", CJRGTMConstants.MT_V4_POST_TRANSACTION_SCREEN_NAME, "", "");
            } else {
                f.a(moneyTransferInviteFragment.getContext(), CJRGTMConstants.MONEY_TRANSFER_EVENT_CATEGORY, "summary_detail_bottom_links_clicked", "/money_transfer/summary", "invite", "");
            }
        }
        if (moneyTransferInviteFragment.f54394i) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(moneyTransferInviteFragment.requireContext(), Events.Category.COLLECT, Events.Action.INVITE_CLICKED, "", "", "", moneyTransferInviteFragment.k, "", Events.Screen.POST_TRANSACTION, "");
        } else if (moneyTransferInviteFragment.j) {
            CJRSendGTMTag.sendNewCustomGTMEventsWithMultipleLabel(moneyTransferInviteFragment.requireContext(), Events.Category.INTENT, Events.Action.INVITE_CLICKED, "", "", "", moneyTransferInviteFragment.k, "", Events.Screen.POST_TRANSACTION, "");
        }
    }

    public static final /* synthetic */ void c(MoneyTransferInviteFragment moneyTransferInviteFragment) {
        c.a aVar = net.one97.paytm.moneytransfer.d.c.C;
        String a2 = net.one97.paytm.moneytransfer.d.c.a(c.a.a().A, "paytmmp://referral?tag=REFERRAL");
        if (moneyTransferInviteFragment.getContext() != null) {
            d.a aVar2 = net.one97.paytm.moneytransfer.d.d.f53996a;
            net.one97.paytm.moneytransfer.d.a b2 = net.one97.paytm.moneytransfer.d.d.b(d.a.a());
            Context context = moneyTransferInviteFragment.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            b2.a(context, a2);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.l;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
