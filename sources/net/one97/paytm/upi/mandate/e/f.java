package net.one97.paytm.upi.mandate.e;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.List;
import kotlin.a.w;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.e.k;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity;
import net.one97.paytm.upi.mandate.data.model.MandateTimeLineItem;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CustomDialog;

public final class f extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f67183a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private boolean f67184b;

    /* renamed from: c  reason: collision with root package name */
    private String f67185c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f67186d = "";

    /* renamed from: e  reason: collision with root package name */
    private d f67187e;

    /* renamed from: f  reason: collision with root package name */
    private e f67188f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f67189g;

    public final void b() {
        HashMap hashMap = this.f67189g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    static final class b<T> implements z<r<List<? extends MandateTimeLineItem>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f67190a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k f67191b;

        b(f fVar, k kVar) {
            this.f67190a = fVar;
            this.f67191b = kVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            f.a(this.f67191b, false);
            int i2 = g.f67193a[rVar.f67411a.ordinal()];
            if (i2 == 1) {
                f.a(this.f67191b, true);
            } else if (i2 == 2) {
                f.a(this.f67190a, (List) rVar.f67412b);
            } else if (i2 == 3) {
                f.a(this.f67190a, rVar.f67413c);
            }
        }
    }

    public final int a() {
        return R.layout.bottom_sheet_mini_timeline;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            kotlin.g.b.k.a();
        }
        this.f67184b = arguments.getBoolean("is_recurring");
        String string = arguments.getString("umn");
        if (string == null) {
            kotlin.g.b.k.a();
        }
        this.f67185c = string;
        String string2 = arguments.getString("payee_name");
        if (string2 == null) {
            kotlin.g.b.k.a();
        }
        this.f67186d = string2;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        kotlin.g.b.k.c(view, "view");
        super.onViewCreated(view, bundle);
        k a2 = k.a(view);
        kotlin.g.b.k.a((Object) a2, "BottomSheetMiniTimelineBinding.bind(view)");
        this.f67188f = new e();
        TextView textView = a2.f66843b;
        kotlin.g.b.k.a((Object) textView, "historyFor");
        textView.setText(getString(R.string.upi_mandate_details_name_placeholder, this.f67186d));
        RecyclerView recyclerView = a2.f66844c;
        kotlin.g.b.k.a((Object) recyclerView, "historyRecyclerView");
        e eVar = this.f67188f;
        if (eVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        recyclerView.setAdapter(eVar);
        if (this.f67184b) {
            TextView textView2 = a2.f66846e;
            kotlin.g.b.k.a((Object) textView2, "title");
            textView2.setText(getString(R.string.recurring_payment_history));
        } else {
            TextView textView3 = a2.f66846e;
            kotlin.g.b.k.a((Object) textView3, "title");
            textView3.setText(getString(R.string.upi_payment_history_non_recurring));
        }
        a2.f66842a.setOnClickListener(new c(this));
        ai a3 = am.a((Fragment) this, (al.b) null).a(d.class);
        kotlin.g.b.k.a((Object) a3, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f67187e = (d) a3;
        d dVar = this.f67187e;
        if (dVar == null) {
            kotlin.g.b.k.a("mandateTimelineViewModel");
        }
        dVar.a(this.f67185c);
        d dVar2 = this.f67187e;
        if (dVar2 == null) {
            kotlin.g.b.k.a("mandateTimelineViewModel");
        }
        dVar2.f67171a.observe(getViewLifecycleOwner(), new b(this, a2));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f67192a;

        c(f fVar) {
            this.f67192a = fVar;
        }

        public final void onClick(View view) {
            this.f67192a.dismiss();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(k kVar, boolean z) {
        if (z) {
            AnimationFactory.startWalletLoader(kVar.f66845d);
        } else {
            AnimationFactory.stopWalletLoader(kVar.f66845d);
        }
    }

    public static final /* synthetic */ void a(f fVar, List list) {
        e eVar = fVar.f67188f;
        if (eVar == null) {
            kotlin.g.b.k.a("adapter");
        }
        if (list == null) {
            list = w.INSTANCE;
        }
        kotlin.g.b.k.c(list, "data");
        eVar.f67175a.addAll(list);
        eVar.notifyDataSetChanged();
    }

    public static final /* synthetic */ void a(f fVar, t tVar) {
        Context context;
        if (tVar instanceof t.a) {
            String str = ((t.a) tVar).f67420a;
            if (str == null) {
                str = fVar.getString(R.string.upi_some_went_wrong);
                kotlin.g.b.k.a((Object) str, "getString(R.string.upi_some_went_wrong)");
            }
            Context context2 = fVar.getContext();
            if (context2 != null) {
                net.one97.paytm.upi.f.a(context2, str, 1);
            }
        } else if ((tVar instanceof t.k) || kotlin.g.b.k.a((Object) tVar, (Object) t.h.f67427a)) {
            Context context3 = fVar.getContext();
            if (context3 != null) {
                net.one97.paytm.upi.f.a(context3, R.string.error_fetching_profile_details, 1);
            }
        } else if (tVar instanceof t.i) {
            CustomDialog.showAlert(fVar.getActivity(), fVar.getResources().getString(R.string.no_connection), fVar.getResources().getString(R.string.no_internet));
        } else if (tVar instanceof t.f) {
            Context context4 = fVar.getContext();
            if (context4 != null) {
                String str2 = ((t.f) tVar).f67425a;
                if (str2 == null) {
                    str2 = fVar.getString(R.string.something_went_wrong);
                    kotlin.g.b.k.a((Object) str2, "getString(R.string.something_went_wrong)");
                }
                net.one97.paytm.upi.f.a(context4, str2, 1);
            }
        } else if (tVar instanceof t.j) {
            i a2 = i.a();
            kotlin.g.b.k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            MandateConfirmationDetailActivity.class.getName();
            a2.b().e(fVar.getActivity());
        } else if ((tVar instanceof t.g) && (context = fVar.getContext()) != null) {
            net.one97.paytm.upi.f.a(context, R.string.something_went_wrong, 1);
        }
    }
}
