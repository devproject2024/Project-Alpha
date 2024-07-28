package net.one97.paytm.paymentsBank.slfd.common.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.n;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.createfd.activity.CreateFdActivity;
import net.one97.paytm.paymentsBank.model.slfd.SlfdModel;
import net.one97.paytm.paymentsBank.slfd.common.a.c;
import net.one97.paytm.paymentsBank.slfd.createfd.view.SlfdLandingPageActivity;
import net.one97.paytm.paymentsBank.slfd.interestprojection.InterestProjectionActivity;

public final class e extends h implements c.b {

    /* renamed from: a  reason: collision with root package name */
    public c.a f19021a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f19022b;

    /* renamed from: c  reason: collision with root package name */
    private ProgressBar f19023c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f19024d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f19025e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f19026f;

    /* renamed from: g  reason: collision with root package name */
    private f f19027g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final int f19028h = 4;

    /* renamed from: i  reason: collision with root package name */
    private String f19029i;
    private HashMap j;

    private View b(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ f a(e eVar) {
        f fVar = eVar.f19027g;
        if (fVar == null) {
            k.a("adapter");
        }
        return fVar;
    }

    public static final /* synthetic */ RecyclerView b(e eVar) {
        RecyclerView recyclerView = eVar.f19022b;
        if (recyclerView == null) {
            k.a("rvFdList");
        }
        return recyclerView;
    }

    public final void b() {
        throw new n("An operation is not implemented: ".concat("not implemented"));
    }

    public final void e() {
        if ((getActivity() instanceof SlfdLandingPageActivity) && getActivity() == null) {
            throw new u("null cannot be cast to non-null type net.one97.paytm.paymentsBank.slfd.createfd.view.SlfdLandingPageActivity");
        }
    }

    public final c.a f() {
        c.a aVar = this.f19021a;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        String string = arguments.getString("slfd_status", "");
        k.a((Object) string, "bundle!!.getString(SlfdC…TRA_SLFD_LIST_STATUS, \"\")");
        this.f19029i = string;
        net.one97.paytm.paymentsBank.slfd.c cVar = net.one97.paytm.paymentsBank.slfd.c.f18958a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        k.a((Object) applicationContext, "activity!!.applicationContext");
        net.one97.paytm.paymentsBank.slfd.a.a.b a2 = net.one97.paytm.paymentsBank.slfd.c.a(applicationContext);
        c.b bVar = this;
        String str = this.f19029i;
        if (str == null) {
            k.a("type");
        }
        c.a cVar2 = new net.one97.paytm.paymentsBank.slfd.common.b.c(a2, bVar, str);
        k.c(cVar2, "<set-?>");
        this.f19021a = cVar2;
        c.a f2 = f();
        String str2 = this.f19029i;
        if (str2 == null) {
            k.a("type");
        }
        this.f19027g = new f(f2, this, str2);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_fd_list, viewGroup, false);
        ProgressBar progressBar = inflate != null ? (ProgressBar) inflate.findViewById(R.id.pb_progress) : null;
        if (progressBar != null) {
            this.f19023c = progressBar;
            View findViewById = inflate.findViewById(R.id.rl_parent);
            if (findViewById != null) {
                this.f19024d = (FrameLayout) findViewById;
                View findViewById2 = inflate.findViewById(R.id.rl_no_transaction);
                if (findViewById2 != null) {
                    this.f19025e = (RelativeLayout) findViewById2;
                    View findViewById3 = inflate.findViewById(R.id.tv_no_transaction);
                    if (findViewById3 != null) {
                        this.f19026f = (TextView) findViewById3;
                        ProgressBar progressBar2 = this.f19023c;
                        if (progressBar2 == null) {
                            k.a("pbProgress");
                        }
                        androidx.core.h.u.g((View) progressBar2, 10.0f);
                        View findViewById4 = inflate.findViewById(R.id.rv_active_fds);
                        if (findViewById4 != null) {
                            this.f19022b = (RecyclerView) findViewById4;
                            RecyclerView recyclerView = this.f19022b;
                            if (recyclerView == null) {
                                k.a("rvFdList");
                            }
                            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                            RecyclerView recyclerView2 = this.f19022b;
                            if (recyclerView2 == null) {
                                k.a("rvFdList");
                            }
                            recyclerView2.addItemDecoration(new net.one97.paytm.paymentsBank.widget.a(getActivity()));
                            RecyclerView recyclerView3 = this.f19022b;
                            if (recyclerView3 == null) {
                                k.a("rvFdList");
                            }
                            f fVar = this.f19027g;
                            if (fVar == null) {
                                k.a("adapter");
                            }
                            recyclerView3.setAdapter(fVar);
                            RecyclerView recyclerView4 = this.f19022b;
                            if (recyclerView4 == null) {
                                k.a("rvFdList");
                            }
                            recyclerView4.addOnScrollListener(new a(this));
                            return inflate;
                        }
                        throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
            }
            throw new u("null cannot be cast to non-null type android.widget.FrameLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.ProgressBar");
    }

    public static final class a extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19030a;

        a(e eVar) {
            this.f19030a = eVar;
        }

        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            k.c(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 2) {
                int itemCount = e.a(this.f19030a).getItemCount();
                RecyclerView.LayoutManager layoutManager = e.b(this.f19030a).getLayoutManager();
                if (layoutManager == null) {
                    throw new u("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                } else if (((LinearLayoutManager) layoutManager).findLastVisibleItemPosition() >= itemCount - this.f19030a.f19028h) {
                    this.f19030a.f().d();
                }
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (net.one97.paytm.paymentsBank.utils.n.e()) {
            Button button = (Button) b(R.id.btn_create_fd);
            k.a((Object) button, "btn_create_fd");
            button.setVisibility(0);
        } else {
            Button button2 = (Button) b(R.id.btn_create_fd);
            k.a((Object) button2, "btn_create_fd");
            button2.setVisibility(8);
        }
        Button button3 = (Button) b(R.id.btn_create_fd);
        if (button3 != null) {
            button3.setOnClickListener(new b(this));
        }
        f().a();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f19031a;

        b(e eVar) {
            this.f19031a = eVar;
        }

        public final void onClick(View view) {
            this.f19031a.startActivity(new Intent(this.f19031a.getContext(), CreateFdActivity.class));
        }
    }

    public final void a(HashMap<String, Double> hashMap) {
        k.c(hashMap, "hashMap");
        f().a(hashMap);
    }

    public final void g() {
        f().e();
    }

    public final void a() {
        View b2 = b(R.id.no_fds_view);
        if (b2 != null) {
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(b2);
        }
        a(0);
    }

    public final void d() {
        View b2 = b(R.id.no_fds_view);
        if (b2 != null) {
            net.one97.paytm.paymentsBank.slfd.b.a.b.a(b2);
        }
        a(0);
    }

    private void a(int i2) {
        if (getActivity() instanceof SlfdLandingPageActivity) {
            FragmentActivity activity = getActivity();
            if (!(activity instanceof SlfdLandingPageActivity)) {
                activity = null;
            }
            SlfdLandingPageActivity slfdLandingPageActivity = (SlfdLandingPageActivity) activity;
            if (slfdLandingPageActivity != null) {
                slfdLandingPageActivity.b(i2);
            }
        }
    }

    public final void a(String str) {
        if (isAdded()) {
            FrameLayout frameLayout = this.f19024d;
            if (frameLayout == null) {
                k.a("parentContainer");
            }
            View view = frameLayout;
            if (str == null) {
                str = getString(R.string.pb_something_wrong_try_again);
                k.a((Object) str, "getString(R.string.pb_something_wrong_try_again)");
            }
            Snackbar a2 = Snackbar.a(view, (CharSequence) str, 0);
            k.a((Object) a2, "Snackbar.make(this, message, length)");
            a2.c();
        }
    }

    public final void a(int i2, int i3) {
        f fVar = this.f19027g;
        if (fVar == null) {
            k.a("adapter");
        }
        fVar.notifyItemRangeInserted(i2, i3);
    }

    public final void c() {
        if (isAdded()) {
            View b2 = b(R.id.no_fds_view);
            if (b2 != null) {
                net.one97.paytm.paymentsBank.slfd.b.a.b.b(b2);
            }
            a(f().c());
            c.a f2 = f();
            String str = this.f19029i;
            if (str == null) {
                k.a("type");
            }
            this.f19027g = new f(f2, this, str);
            RecyclerView recyclerView = this.f19022b;
            if (recyclerView == null) {
                k.a("rvFdList");
            }
            f fVar = this.f19027g;
            if (fVar == null) {
                k.a("adapter");
            }
            recyclerView.setAdapter(fVar);
        }
    }

    public final void a(String str, double d2, boolean z, boolean z2, SlfdModel slfdModel) {
        k.c(str, "fdId");
        k.c(slfdModel, "slfdModel");
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                k.a();
            }
            k.a((Object) activity, "activity!!");
            Intent intent = activity.getIntent();
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                k.a();
            }
            intent.setClass(activity2, InterestProjectionActivity.class);
            intent.putExtra("fd_id", str);
            intent.putExtra("slfd_amount", d2);
            FragmentActivity activity3 = getActivity();
            if (activity3 == null) {
                k.a();
            }
            k.a((Object) activity3, "activity!!");
            intent.putExtra("account_num", activity3.getIntent().getStringExtra("account_num"));
            intent.putExtra("redirect_time_line", true);
            intent.putExtra("fd_partially_transferred", z2);
            intent.putExtra("fd_auto_renewed", z);
            intent.putExtra("A", slfdModel);
            startActivity(intent);
        }
    }

    public final void a(String str, long j2, String str2, String str3, boolean z, boolean z2, SlfdModel slfdModel) {
        k.c(str, "orderId");
        k.c(str2, "orderAmount");
        k.c(str3, SDKConstants.TXN_TYPE);
        k.c(slfdModel, "slfdModel");
        Intent intent = new Intent(getContext(), InterestProjectionActivity.class);
        intent.putExtra("order_id", str);
        intent.putExtra("slfd_order_date", j2);
        intent.putExtra("slfd_amount", str2);
        intent.putExtra("vertical_id", str3);
        intent.putExtra("fd_partially_transferred", z2);
        intent.putExtra("fd_auto_renewed", z);
        intent.putExtra("A", slfdModel);
        startActivity(intent);
    }

    public final void a(boolean z) {
        if (isAdded()) {
            if (z) {
                ProgressBar progressBar = this.f19023c;
                if (progressBar == null) {
                    k.a("pbProgress");
                }
                progressBar.setVisibility(0);
                return;
            }
            ProgressBar progressBar2 = this.f19023c;
            if (progressBar2 == null) {
                k.a("pbProgress");
            }
            progressBar2.setVisibility(8);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        f().b();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
