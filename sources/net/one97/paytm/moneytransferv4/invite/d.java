package net.one97.paytm.moneytransferv4.invite;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.lifecycle.k;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.p2p.PaymentCombinationAPIResponse;
import net.one97.paytm.common.entity.p2p.ReceiverInfo;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.am;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.moneytransferv4.PaymentFlow;
import net.one97.paytm.moneytransferv4.a.a.a;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.i;

public final class d extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public static final a f55674a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private PaymentFlow f55675b;

    /* renamed from: c  reason: collision with root package name */
    private am f55676c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f55677d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static d a(PaymentFlow paymentFlow) {
            k.c(paymentFlow, PayUtility.PAYMENT_FLOW);
            d dVar = new d();
            Bundle bundle = new Bundle();
            bundle.putSerializable("payment_flow", paymentFlow);
            dVar.setArguments(bundle);
            return dVar;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("payment_flow");
            if (!(serializable instanceof PaymentFlow)) {
                serializable = null;
            }
            this.f55675b = (PaymentFlow) serializable;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        ReceiverInfo receiverInfo;
        ReceiverInfo receiverInfo2;
        ReceiverInfo receiverInfo3;
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.non_upi_user_invite_fragment, viewGroup, false);
        am a2 = am.a(inflate);
        k.a((Object) a2, "NonUpiUserInviteFragmentBinding.bind(view)");
        this.f55676c = a2;
        am amVar = this.f55676c;
        if (amVar == null) {
            k.a("binding");
        }
        PaymentFlow paymentFlow = this.f55675b;
        String str2 = null;
        if (!(paymentFlow instanceof PaymentFlow.PaymentCombination)) {
            paymentFlow = null;
        }
        PaymentFlow.PaymentCombination paymentCombination = (PaymentFlow.PaymentCombination) paymentFlow;
        PaymentCombinationAPIResponse data = paymentCombination != null ? paymentCombination.getData() : null;
        TextView textView = amVar.f53690i;
        k.a((Object) textView, "heading");
        int i2 = R.string.mt_v4_invite_heading;
        Object[] objArr = new Object[1];
        if (data == null || (receiverInfo3 = data.getReceiverInfo()) == null || (str = receiverInfo3.getName()) == null) {
            if (data == null || (receiverInfo2 = data.getReceiverInfo()) == null || (str = receiverInfo2.getContactName()) == null) {
                if (!(data == null || (receiverInfo = data.getReceiverInfo()) == null)) {
                    str2 = receiverInfo.getPhoneNumber();
                }
                str = str2;
            }
            if (str == null) {
                str = "User";
            }
        }
        objArr[0] = str;
        textView.setText(getString(i2, objArr));
        TextView textView2 = amVar.q;
        k.a((Object) textView2, "walletTextHereWhy");
        String string = getString(R.string.mt_v4_here_why);
        k.a((Object) string, "getString(R.string.mt_v4_here_why)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new a(textView2), 0, string.length(), 18);
        textView2.setText(spannableString);
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
        textView2.setTextColor(net.one97.paytm.upi.f.c("#506d85"));
        am amVar2 = this.f55676c;
        if (amVar2 == null) {
            k.a("binding");
        }
        amVar2.q.setOnClickListener(new b(this));
        amVar2.m.setOnClickListener(new c(this));
        amVar2.f53683b.setOnClickListener(new C1035d(this));
        amVar2.k.setOnClickListener(new e(this));
        amVar2.j.f66772d.setOnClickListener(new f(this));
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55678a;

        b(d dVar) {
            this.f55678a = dVar;
        }

        public final void onClick(View view) {
            d.a(this.f55678a);
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55679a;

        c(d dVar) {
            this.f55679a = dVar;
        }

        public final void onClick(View view) {
            d.b(this.f55679a);
        }
    }

    /* renamed from: net.one97.paytm.moneytransferv4.invite.d$d  reason: collision with other inner class name */
    static final class C1035d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55680a;

        C1035d(d dVar) {
            this.f55680a = dVar;
        }

        public final void onClick(View view) {
            d.c(this.f55680a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55681a;

        e(d dVar) {
            this.f55681a = dVar;
        }

        public final void onClick(View view) {
            j fragmentManager = this.f55681a.getFragmentManager();
            if (fragmentManager != null) {
                fragmentManager.d();
            }
            FragmentActivity activity = this.f55681a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f55682a;

        f(d dVar) {
            this.f55682a = dVar;
        }

        public final void onClick(View view) {
            d.d(this.f55682a);
        }
    }

    private final boolean a() {
        if (getActivity() == null || !isAdded()) {
            return false;
        }
        androidx.lifecycle.k lifecycle = getLifecycle();
        k.a((Object) lifecycle, "lifecycle");
        return lifecycle.a().isAtLeast(k.b.RESUMED);
    }

    public static final /* synthetic */ void a(d dVar) {
        j fragmentManager;
        if (dVar.a() && (fragmentManager = dVar.getFragmentManager()) != null) {
            new net.one97.paytm.m.a.a.a().show(fragmentManager, "WalletBenefitsBottomSheet");
        }
    }

    public static final /* synthetic */ void b(d dVar) {
        PaymentFlow paymentFlow;
        if (dVar.a() && (paymentFlow = dVar.f55675b) != null) {
            int i2 = R.id.container;
            a.C0982a aVar = net.one97.paytm.moneytransferv4.a.a.a.f54784c;
            m.a(i2, (Fragment) a.C0982a.a(paymentFlow), "BeneficiaryHistoryFragment", dVar.getFragmentManager());
        }
    }

    public static final /* synthetic */ void c(d dVar) {
        if (dVar.a()) {
            m.a(net.one97.paytm.upi.R.id.container, (Fragment) new net.one97.paytm.moneytransferv4.b(), "TransferToBankAccountFragment", dVar.getFragmentManager());
        }
    }

    public static final /* synthetic */ void d(d dVar) {
        if (dVar.a()) {
            i a2 = i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            UpiGTMLoader instance = UpiGTMLoader.getInstance();
            kotlin.g.b.k.a((Object) instance, "UpiGTMLoader.getInstance()");
            a2.c().a((Activity) dVar.getActivity(), instance.getReferralDeeplink());
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f55677d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
