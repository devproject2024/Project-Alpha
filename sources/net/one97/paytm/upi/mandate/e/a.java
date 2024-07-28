package net.one97.paytm.upi.mandate.e;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.e.i;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.mandate.confirmation.MandateConfirmationDetailActivity;
import net.one97.paytm.upi.mandate.data.model.MandateItem;
import net.one97.paytm.upi.mandate.data.model.MandateTimeLineItem;
import net.one97.paytm.upi.mandate.utils.r;
import net.one97.paytm.upi.mandate.utils.t;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CustomDialog;
import net.one97.paytm.upi.util.UpiUtils;

public final class a extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    public static final C1357a f67157a = new C1357a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private d f67158b;

    /* renamed from: c  reason: collision with root package name */
    private MandateItem f67159c;

    /* renamed from: d  reason: collision with root package name */
    private h f67160d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f67161e;

    public final void b() {
        HashMap hashMap = this.f67161e;
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
        final /* synthetic */ a f67162a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f67163b;

        b(a aVar, i iVar) {
            this.f67162a = aVar;
            this.f67163b = iVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            r rVar = (r) obj;
            int i2 = b.f67165a[rVar.f67411a.ordinal()];
            if (i2 == 1) {
                a.a(true, this.f67163b);
            } else if (i2 == 2) {
                a.a(false, this.f67163b);
                a.a(this.f67162a, (List) rVar.f67412b, this.f67163b);
            } else if (i2 == 3) {
                a.a(false, this.f67163b);
                a.a(this.f67162a, rVar.f67413c);
            }
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        Serializable serializable = arguments.getSerializable("mandate_item");
        if (serializable != null) {
            this.f67159c = (MandateItem) serializable;
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.upi.mandate.data.model.MandateItem");
    }

    public final int a() {
        return R.layout.bottom_sheet_mandate_detail_timeline;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        i a2 = i.a(view);
        k.a((Object) a2, "BottomSheetMandateDetailTimelineBinding.bind(view)");
        ai a3 = am.a((Fragment) this, (al.b) null).a(d.class);
        k.a((Object) a3, "ViewModelProviders.of(fr…, factory)[T::class.java]");
        this.f67158b = (d) a3;
        d dVar = this.f67158b;
        if (dVar == null) {
            k.a("viewModel");
        }
        MandateItem mandateItem = this.f67159c;
        if (mandateItem == null) {
            k.a("mandateItem");
        }
        dVar.a(mandateItem.getUmn());
        d dVar2 = this.f67158b;
        if (dVar2 == null) {
            k.a("viewModel");
        }
        dVar2.f67171a.observe(getViewLifecycleOwner(), new b(this, a2));
        TextView textView = a2.f66827d;
        k.a((Object) textView, "payeeName");
        MandateItem mandateItem2 = this.f67159c;
        if (mandateItem2 == null) {
            k.a("mandateItem");
        }
        textView.setText(mandateItem2.getPayee().getUserName());
        TextView textView2 = a2.f66828e;
        k.a((Object) textView2, "payeeVpa");
        MandateItem mandateItem3 = this.f67159c;
        if (mandateItem3 == null) {
            k.a("mandateItem");
        }
        textView2.setText(mandateItem3.getPayee().getVpa());
        MandateItem mandateItem4 = this.f67159c;
        if (mandateItem4 == null) {
            k.a("mandateItem");
        }
        CharSequence imageUrl = mandateItem4.getPayee().getImageUrl();
        if (imageUrl == null || p.a(imageUrl)) {
            a2.f66826c.setImageResource(R.color.paytm_blue);
            TextView textView3 = a2.f66830g;
            k.a((Object) textView3, "tvInitials");
            MandateItem mandateItem5 = this.f67159c;
            if (mandateItem5 == null) {
                k.a("mandateItem");
            }
            textView3.setText(UpiUtils.getNameInitials(f.a(mandateItem5.getPayee().getUserName())));
        } else {
            TextView textView4 = a2.f66830g;
            k.a((Object) textView4, "tvInitials");
            textView4.setText("");
            w a4 = w.a();
            MandateItem mandateItem6 = this.f67159c;
            if (mandateItem6 == null) {
                k.a("mandateItem");
            }
            a4.a(mandateItem6.getPayee().getImageUrl()).a((ImageView) a2.f66826c);
        }
        a2.f66824a.setOnClickListener(new c(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f67164a;

        c(a aVar) {
            this.f67164a = aVar;
        }

        public final void onClick(View view) {
            this.f67164a.dismiss();
        }
    }

    /* renamed from: net.one97.paytm.upi.mandate.e.a$a  reason: collision with other inner class name */
    public static final class C1357a {
        private C1357a() {
        }

        public /* synthetic */ C1357a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(boolean z, i iVar) {
        if (z) {
            AnimationFactory.startWalletLoader(iVar.f66825b);
        } else {
            AnimationFactory.stopWalletLoader(iVar.f66825b);
        }
    }

    public static final /* synthetic */ void a(a aVar, List list, i iVar) {
        if (list != null) {
            aVar.f67160d = new h(list);
            RecyclerView recyclerView = iVar.f66829f;
            k.a((Object) recyclerView, "binding.timelineAdapter");
            recyclerView.setAdapter((RecyclerView.a) null);
            RecyclerView recyclerView2 = iVar.f66829f;
            k.a((Object) recyclerView2, "binding.timelineAdapter");
            h hVar = aVar.f67160d;
            if (hVar == null) {
                k.a("adapter");
            }
            recyclerView2.setAdapter(hVar);
        }
    }

    public static final /* synthetic */ void a(a aVar, t tVar) {
        Context context;
        if (tVar instanceof t.a) {
            String str = ((t.a) tVar).f67420a;
            if (str == null) {
                str = aVar.getString(R.string.upi_some_went_wrong);
                k.a((Object) str, "getString(R.string.upi_some_went_wrong)");
            }
            Context context2 = aVar.getContext();
            if (context2 != null) {
                f.a(context2, str, 1);
            }
        } else if ((tVar instanceof t.k) || k.a((Object) tVar, (Object) t.h.f67427a)) {
            Context context3 = aVar.getContext();
            if (context3 != null) {
                f.a(context3, R.string.error_fetching_profile_details, 1);
            }
        } else if (tVar instanceof t.i) {
            CustomDialog.showAlert(aVar.getActivity(), aVar.getResources().getString(R.string.no_connection), aVar.getResources().getString(R.string.no_internet));
        } else if (tVar instanceof t.f) {
            Context context4 = aVar.getContext();
            if (context4 != null) {
                String str2 = ((t.f) tVar).f67425a;
                if (str2 == null) {
                    str2 = aVar.getString(R.string.something_went_wrong);
                    k.a((Object) str2, "getString(R.string.something_went_wrong)");
                }
                f.a(context4, str2, 1);
            }
        } else if (tVar instanceof t.j) {
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            new UpiCustomVolleyError();
            MandateConfirmationDetailActivity.class.getName();
            a2.b().e(aVar.getActivity());
        } else if ((tVar instanceof t.g) && (context = aVar.getContext()) != null) {
            f.a(context, R.string.something_went_wrong, 1);
        }
    }
}
