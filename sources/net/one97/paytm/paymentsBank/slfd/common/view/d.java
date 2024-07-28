package net.one97.paytm.paymentsBank.slfd.common.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.h.u;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.c;
import net.one97.paytm.paymentsBank.slfd.common.a.b;

public final class d extends f implements b.C0329b {

    /* renamed from: a  reason: collision with root package name */
    public b.a f19012a;

    /* renamed from: b  reason: collision with root package name */
    private b f19013b;

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f19014c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f19015d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19016e;

    /* renamed from: f  reason: collision with root package name */
    private ProgressBar f19017f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f19018g;

    /* renamed from: h  reason: collision with root package name */
    private HashMap f19019h;

    private b.a c() {
        b.a aVar = this.f19012a;
        if (aVar == null) {
            k.a("presenter");
        }
        return aVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
        c cVar = c.f18958a;
        FragmentActivity activity = getActivity();
        if (activity == null) {
            k.a();
        }
        k.a((Object) activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        k.a((Object) applicationContext, "activity!!.applicationContext");
        b.a bVar = new net.one97.paytm.paymentsBank.slfd.common.b.b(c.a(applicationContext), this, this);
        k.c(bVar, "<set-?>");
        this.f19012a = bVar;
        this.f19013b = new b(c(), this);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.layout_fd_intrest_table, viewGroup, false);
        RecyclerView recyclerView = inflate != null ? (RecyclerView) inflate.findViewById(R.id.rv_it_list) : null;
        if (recyclerView != null) {
            this.f19014c = recyclerView;
            View findViewById = inflate.findViewById(R.id.tv_no_item);
            if (findViewById != null) {
                this.f19015d = (TextView) findViewById;
                View findViewById2 = inflate.findViewById(R.id.it_table_msg);
                if (findViewById2 != null) {
                    this.f19016e = (TextView) findViewById2;
                    TextView textView = this.f19016e;
                    if (textView == null) {
                        k.a("effectiveRateTV");
                    }
                    textView.setVisibility(8);
                    View findViewById3 = inflate.findViewById(R.id.pb_progress_itab);
                    if (findViewById3 != null) {
                        this.f19017f = (ProgressBar) findViewById3;
                        ProgressBar progressBar = this.f19017f;
                        if (progressBar == null) {
                            k.a("progressBar");
                        }
                        u.g((View) progressBar, 10.0f);
                        RecyclerView recyclerView2 = this.f19014c;
                        if (recyclerView2 == null) {
                            k.a("rvListTable");
                        }
                        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
                        View findViewById4 = inflate.findViewById(R.id.cross_btn);
                        if (findViewById4 != null) {
                            this.f19018g = (ImageView) findViewById4;
                            ImageView imageView = this.f19018g;
                            if (imageView == null) {
                                k.a("crossBtn");
                            }
                            imageView.setOnClickListener(new a(this));
                            return inflate;
                        }
                        throw new kotlin.u("null cannot be cast to non-null type android.widget.ImageView");
                    }
                    throw new kotlin.u("null cannot be cast to non-null type android.widget.ProgressBar");
                }
                throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new kotlin.u("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f19020a;

        a(d dVar) {
            this.f19020a = dVar;
        }

        public final void onClick(View view) {
            this.f19020a.dismiss();
        }
    }

    public final void a(String str) {
        k.c(str, "effectiveDate");
        if (isAdded()) {
            try {
                TextView textView = this.f19016e;
                if (textView == null) {
                    k.a("effectiveRateTV");
                }
                textView.setVisibility(0);
                TextView textView2 = this.f19016e;
                if (textView2 == null) {
                    k.a("effectiveRateTV");
                }
                textView2.setText(getString(R.string.fd_rates_effective_from, str));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        c().a();
    }

    public final void a() {
        if (isAdded()) {
            TextView textView = this.f19015d;
            if (textView == null) {
                k.a("tvNoItem");
            }
            textView.setVisibility(0);
            com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
        }
    }

    public final void b() {
        if (isAdded()) {
            RecyclerView recyclerView = this.f19014c;
            if (recyclerView == null) {
                k.a("rvListTable");
            }
            b bVar = this.f19013b;
            if (bVar == null) {
                k.a("adapter");
            }
            recyclerView.setAdapter(bVar);
        }
    }

    public final void a(boolean z) {
        if (isAdded()) {
            if (z) {
                ProgressBar progressBar = this.f19017f;
                if (progressBar == null) {
                    k.a("progressBar");
                }
                progressBar.setVisibility(0);
                return;
            }
            ProgressBar progressBar2 = this.f19017f;
            if (progressBar2 == null) {
                k.a("progressBar");
            }
            progressBar2.setVisibility(8);
        }
    }

    public final int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f19019h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
