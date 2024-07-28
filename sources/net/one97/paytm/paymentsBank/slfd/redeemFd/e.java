package net.one97.paytm.paymentsBank.slfd.redeemFd;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.bankCommon.utils.c;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.RedemptionResponseListItem;
import net.one97.paytm.paymentsBank.slfd.common.view.SlfdCheckoutActivity;
import net.one97.paytm.paymentsBank.slfd.redeemFd.d;
import net.one97.paytm.paymentsBank.utils.o;

public final class e extends h implements d.b {
    public static final a m = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public Toolbar f19311a;

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f19312b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f19313c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f19314d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f19315e;

    /* renamed from: f  reason: collision with root package name */
    public NestedScrollView f19316f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f19317g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f19318h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f19319i;
    public Button j;
    public FrameLayout k;
    public d.a l;
    private String n = "";
    private String o = "";
    private HashMap p;

    /* renamed from: net.one97.paytm.paymentsBank.slfd.redeemFd.e$e  reason: collision with other inner class name */
    static final class C0343e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C0343e f19323a = new C0343e();

        C0343e() {
        }

        public final void onClick(View view) {
        }
    }

    public final void a(boolean z) {
    }

    public final d.a g() {
        d.a aVar = this.l;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                k.a();
            }
            this.n = arguments.getString("slfd_amount").toString();
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                k.a();
            }
            this.o = arguments2.getString("account_num").toString();
            d.b bVar = this;
            net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            d.a fVar = new f(bVar, net.one97.paytm.paymentsBank.slfd.c.a(activity), this.n);
            k.c(fVar, "<set-?>");
            this.l = fVar;
        }
        net.one97.paytm.bankCommon.mapping.c.a("/select-fixed-deposit-reedemption", "fixed-deposit", (Context) getActivity());
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.activity_view_lifo_fd, viewGroup, false);
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.rv_fd_list);
            if (findViewById != null) {
                this.f19312b = (RecyclerView) findViewById;
                View findViewById2 = inflate.findViewById(R.id.fl_progress_bar);
                if (findViewById2 != null) {
                    this.f19313c = (FrameLayout) findViewById2;
                    View findViewById3 = inflate.findViewById(R.id.ll_error_container);
                    if (findViewById3 != null) {
                        this.f19315e = (LinearLayout) findViewById3;
                        View findViewById4 = inflate.findViewById(R.id.wallet_loader);
                        if (findViewById4 != null) {
                            this.f19314d = (LottieAnimationView) findViewById4;
                            LinearLayout linearLayout = this.f19315e;
                            if (linearLayout == null) {
                                k.a("llErrorContainer");
                            }
                            View findViewById5 = linearLayout.findViewById(R.id.tv_error_msg);
                            if (findViewById5 != null) {
                                this.f19318h = (TextView) findViewById5;
                                LinearLayout linearLayout2 = this.f19315e;
                                if (linearLayout2 == null) {
                                    k.a("llErrorContainer");
                                }
                                View findViewById6 = linearLayout2.findViewById(R.id.tv_retry);
                                if (findViewById6 != null) {
                                    this.f19319i = (TextView) findViewById6;
                                    View findViewById7 = inflate.findViewById(R.id.ns_parent);
                                    if (findViewById7 != null) {
                                        this.f19316f = (NestedScrollView) findViewById7;
                                        View findViewById8 = inflate.findViewById(R.id.ll_action_content);
                                        if (findViewById8 != null) {
                                            this.f19317g = (LinearLayout) findViewById8;
                                            View findViewById9 = inflate.findViewById(R.id.btn_proceed);
                                            if (findViewById9 != null) {
                                                this.j = (Button) findViewById9;
                                                View findViewById10 = inflate.findViewById(R.id.ll_parent_content);
                                                if (findViewById10 != null) {
                                                    this.k = (FrameLayout) findViewById10;
                                                    View findViewById11 = inflate.findViewById(R.id.toolbar);
                                                    if (findViewById11 != null) {
                                                        this.f19311a = (Toolbar) findViewById11;
                                                        Button button = this.j;
                                                        if (button == null) {
                                                            k.a("btnRedeem");
                                                        }
                                                        button.setOnClickListener(new b(this));
                                                        Toolbar toolbar = this.f19311a;
                                                        if (toolbar == null) {
                                                            k.a("toolbar");
                                                        }
                                                        ((ImageView) toolbar.findViewById(R.id.iv_back_arrow)).setOnClickListener(new c(this));
                                                        View findViewById12 = toolbar.findViewById(R.id.tv_toolbar_title);
                                                        if (findViewById12 != null) {
                                                            ((TextView) findViewById12).setText("");
                                                            TextView textView = this.f19319i;
                                                            if (textView == null) {
                                                                k.a("tvRetry");
                                                            }
                                                            textView.setOnClickListener(new d(this));
                                                            FrameLayout frameLayout = this.f19313c;
                                                            if (frameLayout == null) {
                                                                k.a("flProgressbar");
                                                            }
                                                            frameLayout.setOnClickListener(C0343e.f19323a);
                                                            RecyclerView recyclerView = this.f19312b;
                                                            if (recyclerView == null) {
                                                                k.a("rvFdList");
                                                            }
                                                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                                                            RecyclerView recyclerView2 = this.f19312b;
                                                            if (recyclerView2 == null) {
                                                                k.a("rvFdList");
                                                            }
                                                            recyclerView2.addItemDecoration(new h(net.one97.paytm.bankCommon.mapping.a.a(10.0f, (Context) getActivity())));
                                                        } else {
                                                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                                                        }
                                                    } else {
                                                        throw new u("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
                                                    }
                                                } else {
                                                    throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
                                                }
                                            } else {
                                                throw new u("null cannot be cast to non-null type android.widget.Button");
                                            }
                                        } else {
                                            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                                        }
                                    } else {
                                        throw new u("null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
                                    }
                                } else {
                                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type com.airbnb.lottie.LottieAnimationView");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
                }
            } else {
                throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            }
        }
        return inflate;
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19320a;

        b(e eVar) {
            this.f19320a = eVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.bankCommon.mapping.c.a(this.f19320a.getActivity(), "fixed_deposit", "select_reedem_fixed_deposit_button_clicked", (String) null, (String) null, (String) null, "/select-fixed-deposit-reedemption", "fixed_deposit");
            this.f19320a.g().c();
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19321a;

        c(e eVar) {
            this.f19321a = eVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f19321a.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19322a;

        d(e eVar) {
            this.f19322a = eVar;
        }

        public final void onClick(View view) {
            this.f19322a.g().a();
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        g().a();
    }

    public final void a() {
        LottieAnimationView lottieAnimationView = this.f19314d;
        if (lottieAnimationView == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.a(lottieAnimationView);
        LinearLayout linearLayout = this.f19315e;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        NestedScrollView nestedScrollView = this.f19316f;
        if (nestedScrollView == null) {
            k.a("scrollContent");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(nestedScrollView);
        LinearLayout linearLayout2 = this.f19317g;
        if (linearLayout2 == null) {
            k.a("llActionContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout2);
    }

    public final void a(List<RedemptionResponseListItem> list) {
        k.c(list, "fdList");
        LottieAnimationView lottieAnimationView = this.f19314d;
        if (lottieAnimationView == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        LinearLayout linearLayout = this.f19315e;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        NestedScrollView nestedScrollView = this.f19316f;
        if (nestedScrollView == null) {
            k.a("scrollContent");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(nestedScrollView);
        LinearLayout linearLayout2 = this.f19317g;
        if (linearLayout2 == null) {
            k.a("llActionContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(linearLayout2);
        RecyclerView recyclerView = this.f19312b;
        if (recyclerView == null) {
            k.a("rvFdList");
        }
        recyclerView.setAdapter(new net.one97.paytm.paymentsBank.slfd.common.view.a(list, true));
        RecyclerView recyclerView2 = this.f19312b;
        if (recyclerView2 == null) {
            k.a("rvFdList");
        }
        RecyclerView.a adapter = recyclerView2.getAdapter();
        if (adapter == null) {
            k.a();
        }
        adapter.notifyDataSetChanged();
    }

    public final void c() {
        LottieAnimationView lottieAnimationView = this.f19314d;
        if (lottieAnimationView == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        LinearLayout linearLayout = this.f19315e;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout);
        NestedScrollView nestedScrollView = this.f19316f;
        if (nestedScrollView == null) {
            k.a("scrollContent");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(nestedScrollView);
        LinearLayout linearLayout2 = this.f19317g;
        if (linearLayout2 == null) {
            k.a("llActionContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout2);
    }

    public final void a(String str) {
        LottieAnimationView lottieAnimationView = this.f19314d;
        if (lottieAnimationView == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        LinearLayout linearLayout = this.f19315e;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(linearLayout);
        NestedScrollView nestedScrollView = this.f19316f;
        if (nestedScrollView == null) {
            k.a("scrollContent");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(nestedScrollView);
        LinearLayout linearLayout2 = this.f19317g;
        if (linearLayout2 == null) {
            k.a("llActionContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout2);
        TextView textView = this.f19318h;
        if (textView == null) {
            k.a("tvErrorMsg");
        }
        if (str == null) {
            str = getString(R.string.pb_something_wrong_try_again);
        }
        textView.setText(str);
    }

    public final void b() {
        LottieAnimationView lottieAnimationView = this.f19314d;
        if (lottieAnimationView == null) {
            k.a("contentLoadingProgress");
        }
        net.one97.paytm.common.widgets.a.b(lottieAnimationView);
        LinearLayout linearLayout = this.f19315e;
        if (linearLayout == null) {
            k.a("llErrorContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(linearLayout);
        NestedScrollView nestedScrollView = this.f19316f;
        if (nestedScrollView == null) {
            k.a("scrollContent");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(nestedScrollView);
        LinearLayout linearLayout2 = this.f19317g;
        if (linearLayout2 == null) {
            k.a("llActionContainer");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(linearLayout2);
    }

    public final void e() {
        net.one97.paytm.paymentsBank.h.a a2 = o.a();
        k.a((Object) a2, "PaymentsBankHelper.getImplListener()");
        Intent intent = new Intent(getActivity(), a2.getAJREnterPasscodeClass());
        intent.putExtra("ENTER_HEADER", "paytm_redeem_fd_passcode");
        intent.putExtra("REDIRECT_TO", c.b.RETURN_TO_CALLER_ACTIVITY.ordinal());
        startActivityForResult(intent, 101);
    }

    public final void b(String str) {
        FrameLayout frameLayout = this.f19313c;
        if (frameLayout == null) {
            k.a("flProgressbar");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(frameLayout);
        FrameLayout frameLayout2 = this.k;
        if (frameLayout2 == null) {
            k.a("flParentContent");
        }
        View view = frameLayout2;
        if (str == null) {
            str = getString(R.string.pb_something_wrong_try_again);
            k.a((Object) str, "getString(R.string.pb_something_wrong_try_again)");
        }
        Snackbar a2 = Snackbar.a(view, (CharSequence) str, 0);
        k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public final void d() {
        FrameLayout frameLayout = this.f19313c;
        if (frameLayout == null) {
            k.a("flProgressbar");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(frameLayout);
    }

    public final void a(a aVar) {
        k.c(aVar, "validationError");
        FrameLayout frameLayout = this.f19313c;
        if (frameLayout == null) {
            k.a("flProgressbar");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(frameLayout);
        FrameLayout frameLayout2 = this.k;
        if (frameLayout2 == null) {
            k.a("flParentContent");
        }
        String string = getString(R.string.pb_something_wrong_try_again);
        k.a((Object) string, "getString(R.string.pb_something_wrong_try_again)");
        Snackbar a2 = Snackbar.a((View) frameLayout2, (CharSequence) string, 0);
        k.a((Object) a2, "Snackbar.make(this, message, length)");
        a2.c();
    }

    public final void f() {
        FrameLayout frameLayout = this.f19313c;
        if (frameLayout == null) {
            k.a("flProgressbar");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.a(frameLayout);
    }

    public final void a(String str, Double d2) {
        FrameLayout frameLayout = this.f19313c;
        if (frameLayout == null) {
            k.a("flProgressbar");
        }
        net.one97.paytm.paymentsBank.slfd.b.a.b.b(frameLayout);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent(getActivity(), SlfdCheckoutActivity.class);
            intent.putExtra("order_id", str);
            intent.putExtra("slfd_amount", d2);
            intent.putExtra("account_num", this.o);
            startActivity(intent);
            activity.setResult(-1);
            activity.finish();
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 101 && i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("passcode"))) {
            d.a g2 = g();
            String stringExtra = intent.getStringExtra("passcode");
            k.a((Object) stringExtra, "data.getStringExtra(PBConstants.EXTRA_PASSCODE)");
            g2.a(stringExtra);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.p;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
