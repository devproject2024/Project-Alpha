package net.one97.paytm.wallet.i.a;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.alipay.mobile.h5container.api.H5Event;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.wallet.R;

public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    public View f70396a;

    /* renamed from: b  reason: collision with root package name */
    private Runnable f70397b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f70398c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f70399d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f70400e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f70401f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f70402g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f70403h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final Handler f70404i = new Handler();
    /* access modifiers changed from: private */
    public final Handler j = new Handler();
    /* access modifiers changed from: private */
    public int k = 1;
    /* access modifiers changed from: private */
    public int l = 1;
    /* access modifiers changed from: private */
    public int m = 45;
    /* access modifiers changed from: private */
    public int n = 4;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public boolean p;
    private net.one97.paytm.wallet.i.a q;
    private final Fragment r;
    private HashMap s;

    public c(Fragment fragment) {
        k.c(fragment, "fragment");
        this.r = fragment;
    }

    public static final /* synthetic */ ProgressBar a(c cVar) {
        ProgressBar progressBar = cVar.f70400e;
        if (progressBar == null) {
            k.a("progressBar");
        }
        return progressBar;
    }

    public static final /* synthetic */ Runnable d(c cVar) {
        Runnable runnable = cVar.f70398c;
        if (runnable == null) {
            k.a("progressUpdater");
        }
        return runnable;
    }

    public static final /* synthetic */ TextView h(c cVar) {
        TextView textView = cVar.f70399d;
        if (textView == null) {
            k.a("timerTextView");
        }
        return textView;
    }

    public static final /* synthetic */ Runnable o(c cVar) {
        Runnable runnable = cVar.f70397b;
        if (runnable == null) {
            k.a("textUpdater");
        }
        return runnable;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.scp_transaction_process_bottom_sheet, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…_sheet, container, false)");
        this.f70396a = inflate;
        View view = this.f70396a;
        if (view == null) {
            k.a("rootView");
        }
        View findViewById = view.findViewById(R.id.circularProgressbar);
        k.a((Object) findViewById, "rootView.findViewById(R.id.circularProgressbar)");
        this.f70400e = (ProgressBar) findViewById;
        View view2 = this.f70396a;
        if (view2 == null) {
            k.a("rootView");
        }
        View findViewById2 = view2.findViewById(R.id.timer_text);
        k.a((Object) findViewById2, "rootView.findViewById(R.id.timer_text)");
        this.f70399d = (TextView) findViewById2;
        View view3 = this.f70396a;
        if (view3 == null) {
            k.a("rootView");
        }
        View findViewById3 = view3.findViewById(R.id.conn_with_bank);
        k.a((Object) findViewById3, "rootView.findViewById(R.id.conn_with_bank)");
        this.f70401f = (TextView) findViewById3;
        View view4 = this.f70396a;
        if (view4 == null) {
            k.a("rootView");
        }
        View findViewById4 = view4.findViewById(R.id.validaing_details);
        k.a((Object) findViewById4, "rootView.findViewById(R.id.validaing_details)");
        this.f70402g = (LinearLayout) findViewById4;
        View view5 = this.f70396a;
        if (view5 == null) {
            k.a("rootView");
        }
        View findViewById5 = view5.findViewById(R.id.redirecting);
        k.a((Object) findViewById5, "rootView.findViewById(R.id.redirecting)");
        this.f70403h = (TextView) findViewById5;
        this.m = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(getContext(), SDKConstants.KEY_SCP_TRANSACTION_MAX_TIME);
        this.n = net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(getContext(), SDKConstants.KEY_SCP_TRANSACTION_STATE_CHANGE_TIME);
        ProgressBar progressBar = this.f70400e;
        if (progressBar == null) {
            k.a("progressBar");
        }
        progressBar.setMax(this.m * 10);
        this.f70398c = new a(this);
        this.f70397b = new b(this);
        Handler handler = this.j;
        Runnable runnable = this.f70398c;
        if (runnable == null) {
            k.a("progressUpdater");
        }
        handler.post(runnable);
        Handler handler2 = this.f70404i;
        Runnable runnable2 = this.f70397b;
        if (runnable2 == null) {
            k.a("textUpdater");
        }
        handler2.post(runnable2);
        View view6 = this.f70396a;
        if (view6 == null) {
            k.a("rootView");
        }
        return view6;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f70405a;

        a(c cVar) {
            this.f70405a = cVar;
        }

        public final void run() {
            c.a(this.f70405a).setProgress(this.f70405a.k);
            c cVar = this.f70405a;
            cVar.k = cVar.k + 1;
            this.f70405a.j.postDelayed(c.d(this.f70405a), 100);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f70406a;

        b(c cVar) {
            this.f70406a = cVar;
        }

        public final void run() {
            if (this.f70406a.l == this.f70406a.m) {
                c.g(this.f70406a);
            }
            c.h(this.f70406a).setText(String.valueOf(this.f70406a.m - this.f70406a.l));
            if (this.f70406a.l % this.f70406a.n == 0) {
                if (this.f70406a.o) {
                    c.k(this.f70406a);
                } else if (this.f70406a.p) {
                    c.g(this.f70406a);
                } else {
                    c.m(this.f70406a);
                }
            }
            c cVar = this.f70406a;
            cVar.l = cVar.l + 1;
            this.f70406a.f70404i.postDelayed(c.o(this.f70406a), 1000);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        Handler handler = this.f70404i;
        Runnable runnable = this.f70397b;
        if (runnable == null) {
            k.a("textUpdater");
        }
        handler.removeCallbacks(runnable);
        Handler handler2 = this.j;
        Runnable runnable2 = this.f70398c;
        if (runnable2 == null) {
            k.a("progressUpdater");
        }
        handler2.removeCallbacks(runnable2);
        net.one97.paytm.wallet.i.a aVar = this.q;
        if (aVar != null) {
            aVar.onClosing();
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f70409a;

        d(c cVar) {
            this.f70409a = cVar;
        }

        public final void run() {
            c.g(this.f70409a);
        }
    }

    public final void a(boolean z, net.one97.paytm.wallet.i.a aVar) {
        k.c(aVar, H5Event.TYPE_CALL_BACK);
        this.p = true;
        this.o = z;
        this.q = aVar;
    }

    /* renamed from: net.one97.paytm.wallet.i.a.c$c  reason: collision with other inner class name */
    public static final class C1422c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f70407a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.wallet.i.a f70408b;

        public C1422c(c cVar, net.one97.paytm.wallet.i.a aVar) {
            this.f70407a = cVar;
            this.f70408b = aVar;
        }

        public final void onClick(View view) {
            this.f70408b.onClosing();
            c.g(this.f70407a);
        }
    }

    public static final /* synthetic */ void g(c cVar) {
        j childFragmentManager;
        q a2;
        Fragment fragment = cVar.r;
        if (fragment != null && (childFragmentManager = fragment.getChildFragmentManager()) != null && (a2 = childFragmentManager.a().a((Fragment) cVar)) != null) {
            a2.c();
        }
    }

    public static final /* synthetic */ void k(c cVar) {
        TextView textView = cVar.f70401f;
        if (textView == null) {
            k.a("connWithBankLyt");
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = cVar.f70402g;
        if (linearLayout == null) {
            k.a("validatingPaymentLyt");
        }
        linearLayout.setVisibility(8);
        cVar.getContext();
        TextView textView2 = cVar.f70403h;
        if (textView2 == null) {
            k.a("redirectingLyt");
        }
        textView2.setText(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(cVar.getContext(), SDKConstants.KEY_SCP_PAYMENT_PROCESSING_TEXT_3));
        TextView textView3 = cVar.f70403h;
        if (textView3 == null) {
            k.a("redirectingLyt");
        }
        textView3.setVisibility(0);
        new Handler().postDelayed(new d(cVar), (long) (cVar.n * 1000));
    }

    public static final /* synthetic */ void m(c cVar) {
        TextView textView = cVar.f70401f;
        if (textView == null) {
            k.a("connWithBankLyt");
        }
        if (textView.getVisibility() == 0) {
            LinearLayout linearLayout = cVar.f70402g;
            if (linearLayout == null) {
                k.a("validatingPaymentLyt");
            }
            linearLayout.animate().alpha(1.0f);
            LinearLayout linearLayout2 = cVar.f70402g;
            if (linearLayout2 == null) {
                k.a("validatingPaymentLyt");
            }
            linearLayout2.setVisibility(0);
            TextView textView2 = cVar.f70401f;
            if (textView2 == null) {
                k.a("connWithBankLyt");
            }
            textView2.animate().alpha(0.0f);
            TextView textView3 = cVar.f70401f;
            if (textView3 == null) {
                k.a("connWithBankLyt");
            }
            textView3.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = cVar.f70402g;
        if (linearLayout3 == null) {
            k.a("validatingPaymentLyt");
        }
        linearLayout3.animate().alpha(0.0f);
        LinearLayout linearLayout4 = cVar.f70402g;
        if (linearLayout4 == null) {
            k.a("validatingPaymentLyt");
        }
        linearLayout4.setVisibility(8);
        TextView textView4 = cVar.f70401f;
        if (textView4 == null) {
            k.a("connWithBankLyt");
        }
        textView4.animate().alpha(1.0f);
        TextView textView5 = cVar.f70401f;
        if (textView5 == null) {
            k.a("connWithBankLyt");
        }
        textView5.setVisibility(0);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
