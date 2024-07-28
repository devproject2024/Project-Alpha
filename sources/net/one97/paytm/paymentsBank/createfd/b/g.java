package net.one97.paytm.paymentsBank.createfd.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.a.b;
import net.one97.paytm.paymentsBank.createfd.activity.FdPostTransactionActivity;
import net.one97.paytm.paymentsBank.createfd.c.d;
import net.one97.paytm.paymentsBank.createfd.c.e;
import net.one97.paytm.paymentsBank.createfd.model.CreateFdModel;
import net.one97.paytm.paymentsBank.createfd.model.OptionsModel;
import net.one97.paytm.paymentsBank.createfd.utils.a;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse;

public class g extends b implements b.a, d, e.b {

    /* renamed from: a  reason: collision with root package name */
    private Calendar f18114a;

    /* renamed from: b  reason: collision with root package name */
    TransactionDetailResponse f18115b;

    /* renamed from: c  reason: collision with root package name */
    public String f18116c;

    /* renamed from: d  reason: collision with root package name */
    public e.a f18117d;

    /* renamed from: e  reason: collision with root package name */
    String f18118e = "";

    /* renamed from: f  reason: collision with root package name */
    String f18119f;

    /* renamed from: g  reason: collision with root package name */
    boolean f18120g;

    /* renamed from: h  reason: collision with root package name */
    private b.a.c f18121h = b.a.c.PROCESSING;

    /* renamed from: i  reason: collision with root package name */
    private String f18122i;
    private net.one97.paytm.paymentsBank.createfd.utils.a j;
    private HashMap k;

    public View a(int i2) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.k.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void e() {
        HashMap hashMap = this.k;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        e();
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f18123a;

        a(g gVar) {
            this.f18123a = gVar;
        }

        public final void onClick(View view) {
            g gVar = this.f18123a;
            gVar.a("", (View) (ConstraintLayout) gVar.a(R.id.parent_lyt));
        }
    }

    public final void b() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.fd_download_icon);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new a(this));
        }
    }

    public final void a(String str, View view) {
        if (view == null) {
            net.one97.paytm.paymentsBank.createfd.utils.a aVar = this.j;
            if (aVar != null) {
                aVar.a(getActivity(), str, (ConstraintLayout) a(R.id.parent_lyt));
                return;
            }
            return;
        }
        net.one97.paytm.paymentsBank.createfd.utils.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.a(getActivity(), str, view);
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        net.one97.paytm.paymentsBank.createfd.utils.a aVar;
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        a.C0304a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.a.f18180d;
        if (i2 == net.one97.paytm.paymentsBank.createfd.utils.a.f18179c && (aVar = this.j) != null) {
            Activity activity = getActivity();
            k.c(strArr, "permissions");
            k.c(iArr, "grantResults");
            boolean z = false;
            if (i2 == net.one97.paytm.paymentsBank.createfd.utils.a.f18179c) {
                if (s.a(iArr)) {
                    aVar.a(activity, aVar.f18183b, aVar.f18182a);
                } else if (!(s.a(strArr, iArr, "android.permission.WRITE_EXTERNAL_STORAGE", activity) == 1 || activity == null)) {
                    Toast.makeText(activity, activity.getString(R.string.permission_not_granted), 0).show();
                    net.one97.paytm.paymentsBank.createfd.utils.a.a(activity);
                }
                z = true;
            }
            if (z) {
                return;
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    public final void a(boolean z) {
        if (z) {
            f();
        } else {
            h();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (arguments.containsKey(net.one97.paytm.paymentsBank.createfd.utils.b.f18190e)) {
                b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                this.f18122i = arguments.getString(net.one97.paytm.paymentsBank.createfd.utils.b.f18190e);
            }
            b.a aVar3 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (arguments.containsKey(net.one97.paytm.paymentsBank.createfd.utils.b.f18191f)) {
                b.a aVar4 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                this.f18116c = arguments.getString(net.one97.paytm.paymentsBank.createfd.utils.b.f18191f);
            }
            b.a aVar5 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (arguments.containsKey(net.one97.paytm.paymentsBank.createfd.utils.b.f18192g)) {
                b.a aVar6 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                this.f18118e = arguments.getString(net.one97.paytm.paymentsBank.createfd.utils.b.f18192g);
            }
            b.a aVar7 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (arguments.containsKey(net.one97.paytm.paymentsBank.createfd.utils.b.u)) {
                b.a aVar8 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                Serializable serializable = arguments.getSerializable(net.one97.paytm.paymentsBank.createfd.utils.b.u);
                if (serializable != null) {
                    this.f18115b = (TransactionDetailResponse) serializable;
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse");
                }
            }
        }
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        this.f18117d = new net.one97.paytm.paymentsBank.createfd.d.b(net.one97.paytm.paymentsBank.slfd.c.a(context), this);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fd_post_transaction, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…action, container, false)");
        View findViewById = inflate.findViewById(R.id.back_arrow);
        k.a((Object) findViewById, "lay.findViewById(R.id.back_arrow)");
        ((ImageView) findViewById).setOnClickListener(new b(this));
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f18124a;

        b(g gVar) {
            this.f18124a = gVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f18124a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        c(R.color.color_ffa400);
        a(Integer.valueOf(R.string.fd_processing_heading), this.f18116c, (Integer) null);
        this.f18114a = Calendar.getInstance();
        c();
        a(Boolean.TRUE);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a.C0304a aVar = net.one97.paytm.paymentsBank.createfd.utils.a.f18180d;
        if (net.one97.paytm.paymentsBank.createfd.utils.a.f18181e == null) {
            net.one97.paytm.paymentsBank.createfd.utils.a.f18181e = new net.one97.paytm.paymentsBank.createfd.utils.a((byte) 0);
        }
        net.one97.paytm.paymentsBank.createfd.utils.a b2 = net.one97.paytm.paymentsBank.createfd.utils.a.f18181e;
        if (b2 != null) {
            this.j = b2;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.createfd.utils.CJRBaseShareActionHandler");
    }

    private final void j() {
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_lyt_bottom);
        if (shimmerFrameLayout != null && !shimmerFrameLayout.c()) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.middleLayout);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            TextView textView = (TextView) a(R.id.tv_fd_balance);
            if (textView != null) {
                textView.setVisibility(8);
            }
            View a2 = a(R.id.dividerView_pt);
            if (a2 != null) {
                a2.setVisibility(8);
            }
            View a3 = a(R.id.shimmer_view_id);
            if (a3 != null) {
                a3.setVisibility(0);
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.shimmer_lyt_top);
            if (shimmerFrameLayout2 != null) {
                shimmerFrameLayout2.a();
            }
            ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) a(R.id.shimmer_lyt_bottom);
            if (shimmerFrameLayout3 != null) {
                shimmerFrameLayout3.a();
            }
        }
    }

    public final void c() {
        String i2 = i();
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (p.a(i2, net.one97.paytm.paymentsBank.createfd.utils.b.o, false)) {
            j();
        } else {
            String i3 = i();
            b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (p.a(i3, net.one97.paytm.paymentsBank.createfd.utils.b.n, false)) {
                k();
            }
        }
        e.a aVar3 = this.f18117d;
        if (aVar3 == null) {
            k.a("presenter");
        }
        String str = this.f18122i;
        if (str == null) {
            k.a();
        }
        aVar3.a(str);
    }

    public final void a(TransactionDetailResponse transactionDetailResponse) {
        e.a aVar = this.f18117d;
        if (aVar == null) {
            k.a("presenter");
        }
        b.a.c a2 = aVar.a(transactionDetailResponse);
        String i2 = i();
        b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (p.a(i2, net.one97.paytm.paymentsBank.createfd.utils.b.n, false)) {
            if (a2 == b.a.c.PROCESSING) {
                a2 = b.a.c.PENDING;
            }
            this.f18115b = transactionDetailResponse;
            String i3 = i();
            b.a aVar3 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            if (p.a(i3, net.one97.paytm.paymentsBank.createfd.utils.b.n, false)) {
                RelativeLayout relativeLayout = (RelativeLayout) a(R.id.loader_layout);
                if (relativeLayout != null) {
                    relativeLayout.setVisibility(8);
                }
                net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
            }
            FragmentActivity activity = getActivity();
            if (!(activity instanceof FdPostTransactionActivity)) {
                activity = null;
            }
            FdPostTransactionActivity fdPostTransactionActivity = (FdPostTransactionActivity) activity;
            if (fdPostTransactionActivity != null) {
                fdPostTransactionActivity.a(a2, transactionDetailResponse);
                return;
            }
            return;
        }
        String i4 = i();
        b.a aVar4 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (!p.a(i4, net.one97.paytm.paymentsBank.createfd.utils.b.o, false)) {
            return;
        }
        if (a2 == b.a.c.PROCESSING) {
            View view = getView();
            if (view != null) {
                Runnable cVar = new c(this);
                e.a aVar5 = this.f18117d;
                if (aVar5 == null) {
                    k.a("presenter");
                }
                view.postDelayed(cVar, aVar5.a());
                return;
            }
            return;
        }
        this.f18115b = transactionDetailResponse;
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_lyt_top);
        if (shimmerFrameLayout != null) {
            shimmerFrameLayout.b();
        }
        ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) a(R.id.shimmer_lyt_bottom);
        if (shimmerFrameLayout2 != null) {
            shimmerFrameLayout2.b();
        }
        View a3 = a(R.id.shimmer_view_id);
        if (a3 != null) {
            a3.setVisibility(8);
        }
        FragmentActivity activity2 = getActivity();
        if (!(activity2 instanceof FdPostTransactionActivity)) {
            activity2 = null;
        }
        FdPostTransactionActivity fdPostTransactionActivity2 = (FdPostTransactionActivity) activity2;
        if (fdPostTransactionActivity2 != null) {
            fdPostTransactionActivity2.a(a2, transactionDetailResponse);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f18125a;

        c(g gVar) {
            this.f18125a = gVar;
        }

        public final void run() {
            this.f18125a.c();
        }
    }

    public final void a(Boolean bool) {
        if (k.a((Object) bool, (Object) Boolean.TRUE)) {
            TextView textView = (TextView) a(R.id.fd_tv_view_details);
            if (textView != null) {
                textView.setVisibility(8);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.fd_download_icon);
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = (TextView) a(R.id.fd_tv_view_details);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.fd_download_icon);
        if (appCompatImageView2 != null) {
            appCompatImageView2.setVisibility(0);
        }
    }

    public final void b(int i2) {
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.top_layout);
        if (constraintLayout != null) {
            constraintLayout.setVisibility(i2);
        }
    }

    public final void c(int i2) {
        Window window;
        ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.top_layout);
        if (constraintLayout != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            constraintLayout.setBackgroundColor(androidx.core.content.b.c(context, i2));
        }
        String i3 = i();
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (p.a(i3, net.one97.paytm.paymentsBank.createfd.utils.b.o, false) && Build.VERSION.SDK_INT >= 21) {
            Context context2 = getContext();
            if (!(context2 instanceof Activity)) {
                context2 = null;
            }
            Activity activity = (Activity) context2;
            if (!(activity == null || (window = activity.getWindow()) == null)) {
                Context context3 = getContext();
                if (context3 == null) {
                    k.a();
                }
                window.setStatusBarColor(androidx.core.content.b.c(context3, i2));
            }
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.top_layout);
        if (constraintLayout2 != null) {
            constraintLayout2.setVisibility(0);
        }
    }

    public final void a(Integer num, String str, Integer num2) {
        String str2;
        TextView textView = (TextView) a(R.id.tv_header);
        if (textView != null) {
            Context context = getContext();
            if (context != null) {
                if (num == null) {
                    k.a();
                }
                str2 = context.getString(num.intValue());
            } else {
                str2 = null;
            }
            textView.setText(str2);
        }
        TextView textView2 = (TextView) a(R.id.tv_heading_rupees);
        if (textView2 != null) {
            textView2.setText(str);
        }
        if (num2 != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.header_icon);
            if (appCompatImageView != null) {
                appCompatImageView.setVisibility(0);
            }
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.header_icon);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setImageResource(num2.intValue());
            }
        } else {
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.header_icon);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setVisibility(8);
            }
        }
        String string = getString(R.string.pb_decimal_place_name);
        k.a((Object) string, "getString(R.string.pb_decimal_place_name)");
        TextView textView3 = (TextView) a(R.id.tv_heading_rupees_words);
        if (textView3 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.pb_fd_rupees));
            sb.append(" ");
            e.a aVar = this.f18117d;
            if (aVar == null) {
                k.a("presenter");
            }
            sb.append(aVar.b(str, string));
            sb.append(" ");
            sb.append(getString(R.string.only));
            textView3.setText(sb.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        r0 = r0.getBookingResponse();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.TextView r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0017
            net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse r0 = r1.f18115b
            if (r0 == 0) goto L_0x0011
            net.one97.paytm.paymentsBank.model.slfd.BookingResponse r0 = r0.getBookingResponse()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.getMessage()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setText(r0)
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.g.a(android.widget.TextView):void");
    }

    public final void b(TextView textView) {
        e.a aVar = this.f18117d;
        if (aVar == null) {
            k.a("presenter");
        }
        String b2 = aVar.b(this.f18115b);
        if (b2 != null && textView != null) {
            textView.setText(b2);
        }
    }

    public final void a(CreateFdModel createFdModel) {
        Intent intent;
        Intent intent2;
        k.c(createFdModel, "fdcreationResponse");
        a(false);
        if (p.a(createFdModel.getStatus(), "success", false)) {
            FragmentActivity activity = getActivity();
            if (!(activity == null || (intent2 = activity.getIntent()) == null)) {
                b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                intent2.putExtra(net.one97.paytm.paymentsBank.createfd.utils.b.f18190e, createFdModel.getOrderId());
            }
            FragmentActivity activity2 = getActivity();
            if (!(activity2 == null || (intent = activity2.getIntent()) == null)) {
                b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
                intent.putExtra(net.one97.paytm.paymentsBank.createfd.utils.b.f18191f, this.f18116c);
            }
            if (getContext() instanceof FdPostTransactionActivity) {
                Context context = getContext();
                if (!(context instanceof FdPostTransactionActivity)) {
                    context = null;
                }
                FdPostTransactionActivity fdPostTransactionActivity = (FdPostTransactionActivity) context;
                if (fdPostTransactionActivity != null) {
                    fdPostTransactionActivity.a(b.a.c.PROCESSING, (TransactionDetailResponse) null);
                }
            }
        }
    }

    public final void a(NetworkCustomError networkCustomError, b.a.c cVar) {
        k.c(networkCustomError, "error");
        k.c(cVar, "orderStatus");
        a((TransactionDetailResponse) null);
    }

    public final void d() {
        e.a aVar = this.f18117d;
        if (aVar == null) {
            k.a("presenter");
        }
        aVar.b();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(22:5|6|7|(1:9)|10|(1:12)(1:13)|14|(1:16)|17|(3:19|(1:21)|22)|23|(1:25)|26|27|(1:29)|30|(1:32)|(1:34)|35|(1:37)|38|(2:40|44)(1:46)) */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00f5 */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f9 A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0102 A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010c A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x013b A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x014a A[Catch:{ Exception -> 0x014d }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g() {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "presenter"
            java.lang.String r2 = r19.i()
            net.one97.paytm.paymentsBank.createfd.utils.b$a r3 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a
            java.lang.String r3 = net.one97.paytm.paymentsBank.createfd.utils.b.o
            r4 = 0
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r3, (boolean) r4)
            if (r2 != 0) goto L_0x0025
            int r1 = net.one97.paytm.paymentsBank.R.id.tv_updated_balance
            android.view.View r1 = r0.a((int) r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r1 == 0) goto L_0x0024
            r2 = 8
            r1.setVisibility(r2)
        L_0x0024:
            return
        L_0x0025:
            r2 = 0
            net.one97.paytm.paymentsBank.createfd.c.e$a r3 = r0.f18117d     // Catch:{ Exception -> 0x00f5 }
            if (r3 != 0) goto L_0x002d
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x00f5 }
        L_0x002d:
            net.one97.paytm.bankCommon.model.PBCJRAccountSummary r3 = r3.c()     // Catch:{ Exception -> 0x00f5 }
            if (r3 == 0) goto L_0x003c
            double r5 = r3.getSlfdBalance()     // Catch:{ Exception -> 0x00f5 }
            java.lang.Double r3 = java.lang.Double.valueOf(r5)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x003d
        L_0x003c:
            r3 = r2
        L_0x003d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r6 = "₹"
            r5.<init>(r6)     // Catch:{ Exception -> 0x00f5 }
            if (r3 != 0) goto L_0x0049
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x00f5 }
        L_0x0049:
            double r6 = r3.doubleValue()     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r3 = net.one97.paytm.bankCommon.mapping.a.a((double) r6)     // Catch:{ Exception -> 0x00f5 }
            r5.append(r3)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r3 = r5.toString()     // Catch:{ Exception -> 0x00f5 }
            r0.f18119f = r3     // Catch:{ Exception -> 0x00f5 }
            boolean r5 = r0.f18120g     // Catch:{ Exception -> 0x00f5 }
            r6 = 1
            if (r5 != 0) goto L_0x00b2
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x00f5 }
            r5.<init>()     // Catch:{ Exception -> 0x00f5 }
            java.util.List r5 = (java.util.List) r5     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r7 = r0.f18119f     // Catch:{ Exception -> 0x00f5 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x00f5 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00f5 }
            if (r7 != 0) goto L_0x008e
            r0.f18120g = r6     // Catch:{ Exception -> 0x00f5 }
            net.one97.paytm.paymentsBank.createfd.model.OptionsModel r7 = new net.one97.paytm.paymentsBank.createfd.model.OptionsModel     // Catch:{ Exception -> 0x00f5 }
            int r8 = net.one97.paytm.paymentsBank.R.string.pb_fd_updated_deposit_amount     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r8 = r0.getString(r8)     // Catch:{ Exception -> 0x00f5 }
            int r9 = net.one97.paytm.paymentsBank.R.drawable.ic_passbook_list     // Catch:{ Exception -> 0x00f5 }
            net.one97.paytm.paymentsBank.createfd.utils.b$a r10 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a     // Catch:{ Exception -> 0x00f5 }
            int r10 = net.one97.paytm.paymentsBank.createfd.utils.b.y     // Catch:{ Exception -> 0x00f5 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r11 = r0.f18119f     // Catch:{ Exception -> 0x00f5 }
            r7.<init>(r8, r9, r10, r11)     // Catch:{ Exception -> 0x00f5 }
            r5.add(r7)     // Catch:{ Exception -> 0x00f5 }
        L_0x008e:
            net.one97.paytm.paymentsBank.createfd.model.OptionsModel r7 = new net.one97.paytm.paymentsBank.createfd.model.OptionsModel     // Catch:{ Exception -> 0x00f5 }
            int r8 = net.one97.paytm.paymentsBank.R.string.option_help     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r13 = r0.getString(r8)     // Catch:{ Exception -> 0x00f5 }
            int r14 = net.one97.paytm.paymentsBank.R.drawable.pb_contact_us_icon_new     // Catch:{ Exception -> 0x00f5 }
            net.one97.paytm.paymentsBank.createfd.utils.b$a r8 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a     // Catch:{ Exception -> 0x00f5 }
            int r8 = net.one97.paytm.paymentsBank.createfd.utils.b.x     // Catch:{ Exception -> 0x00f5 }
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x00f5 }
            r16 = 0
            r17 = 8
            r18 = 0
            r12 = r7
            r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x00f5 }
            r5.add(r7)     // Catch:{ Exception -> 0x00f5 }
            r0.a((java.util.List<net.one97.paytm.paymentsBank.createfd.model.OptionsModel>) r5)     // Catch:{ Exception -> 0x00f5 }
        L_0x00b2:
            android.text.SpannableString r5 = new android.text.SpannableString     // Catch:{ Exception -> 0x00f5 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x00f5 }
            r5.<init>(r3)     // Catch:{ Exception -> 0x00f5 }
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan     // Catch:{ Exception -> 0x00f5 }
            r3.<init>(r6)     // Catch:{ Exception -> 0x00f5 }
            int r6 = r5.length()     // Catch:{ Exception -> 0x00f5 }
            r7 = 33
            r5.setSpan(r3, r4, r6, r7)     // Catch:{ Exception -> 0x00f5 }
            android.text.SpannableStringBuilder r3 = new android.text.SpannableStringBuilder     // Catch:{ Exception -> 0x00f5 }
            r3.<init>()     // Catch:{ Exception -> 0x00f5 }
            int r6 = net.one97.paytm.paymentsBank.R.string.updated_fd_balance     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x00f5 }
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00f5 }
            android.text.SpannableStringBuilder r3 = r3.append(r6)     // Catch:{ Exception -> 0x00f5 }
            java.lang.String r6 = " "
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6     // Catch:{ Exception -> 0x00f5 }
            android.text.SpannableStringBuilder r3 = r3.append(r6)     // Catch:{ Exception -> 0x00f5 }
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5     // Catch:{ Exception -> 0x00f5 }
            android.text.SpannableStringBuilder r3 = r3.append(r5)     // Catch:{ Exception -> 0x00f5 }
            int r5 = net.one97.paytm.paymentsBank.R.id.tv_fd_balance     // Catch:{ Exception -> 0x00f5 }
            android.view.View r5 = r0.a((int) r5)     // Catch:{ Exception -> 0x00f5 }
            android.widget.TextView r5 = (android.widget.TextView) r5     // Catch:{ Exception -> 0x00f5 }
            if (r5 == 0) goto L_0x00f5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x00f5 }
            r5.setText(r3)     // Catch:{ Exception -> 0x00f5 }
        L_0x00f5:
            net.one97.paytm.paymentsBank.createfd.c.e$a r3 = r0.f18117d     // Catch:{ Exception -> 0x014d }
            if (r3 != 0) goto L_0x00fc
            kotlin.g.b.k.a((java.lang.String) r1)     // Catch:{ Exception -> 0x014d }
        L_0x00fc:
            net.one97.paytm.bankCommon.model.PBCJRAccountSummary r1 = r3.c()     // Catch:{ Exception -> 0x014d }
            if (r1 == 0) goto L_0x010a
            double r1 = r1.getEffectiveBalance()     // Catch:{ Exception -> 0x014d }
            java.lang.Double r2 = java.lang.Double.valueOf(r1)     // Catch:{ Exception -> 0x014d }
        L_0x010a:
            if (r2 != 0) goto L_0x010f
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x014d }
        L_0x010f:
            double r1 = r2.doubleValue()     // Catch:{ Exception -> 0x014d }
            java.lang.String r1 = net.one97.paytm.bankCommon.mapping.a.a((double) r1)     // Catch:{ Exception -> 0x014d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014d }
            r2.<init>()     // Catch:{ Exception -> 0x014d }
            int r3 = net.one97.paytm.paymentsBank.R.string.updated_account_balance     // Catch:{ Exception -> 0x014d }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x014d }
            r2.append(r3)     // Catch:{ Exception -> 0x014d }
            java.lang.String r3 = " ₹ "
            r2.append(r3)     // Catch:{ Exception -> 0x014d }
            r2.append(r1)     // Catch:{ Exception -> 0x014d }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x014d }
            int r2 = net.one97.paytm.paymentsBank.R.id.tv_updated_balance     // Catch:{ Exception -> 0x014d }
            android.view.View r2 = r0.a((int) r2)     // Catch:{ Exception -> 0x014d }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x014d }
            if (r2 == 0) goto L_0x0140
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x014d }
            r2.setText(r1)     // Catch:{ Exception -> 0x014d }
        L_0x0140:
            int r1 = net.one97.paytm.paymentsBank.R.id.tv_updated_balance     // Catch:{ Exception -> 0x014d }
            android.view.View r1 = r0.a((int) r1)     // Catch:{ Exception -> 0x014d }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ Exception -> 0x014d }
            if (r1 == 0) goto L_0x014d
            r1.setVisibility(r4)     // Catch:{ Exception -> 0x014d }
        L_0x014d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.b.g.g():void");
    }

    public final void a(List<OptionsModel> list) {
        k.c(list, "optionList");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(1);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_options);
        k.a((Object) recyclerView, "rv_options");
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_options);
        if (recyclerView2 != null) {
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            recyclerView2.setAdapter(new net.one97.paytm.paymentsBank.createfd.a.b(list, context, this));
        }
    }

    public final void a() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final String i() {
        String str = this.f18118e;
        if (str == null) {
            return "";
        }
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (p.a(str, net.one97.paytm.paymentsBank.createfd.utils.b.n, false)) {
            b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
            return net.one97.paytm.paymentsBank.createfd.utils.b.n;
        }
        String str2 = this.f18118e;
        b.a aVar3 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (!p.a(str2, net.one97.paytm.paymentsBank.createfd.utils.b.o, false)) {
            return "";
        }
        b.a aVar4 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        return net.one97.paytm.paymentsBank.createfd.utils.b.o;
    }

    private void k() {
        String i2 = i();
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (p.a(i2, net.one97.paytm.paymentsBank.createfd.utils.b.n, false)) {
            ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.top_layout);
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.loader_layout);
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
        }
    }
}
