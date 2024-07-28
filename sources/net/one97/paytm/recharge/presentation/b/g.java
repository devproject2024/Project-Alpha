package net.one97.paytm.recharge.presentation.b;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.recharge.automatic.R;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel;

public final class g extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f64772a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private List<CJRAutomaticSubscriptionHistory> f64773b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f64774c;

    private View a(int i2) {
        if (this.f64774c == null) {
            this.f64774c = new HashMap();
        }
        View view = (View) this.f64774c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64774c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
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
        setStyle(0, R.style.CustomImpsBottomSheetDialogTheme);
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable("selected_automatic_subscribed_item") : null;
        if (serializable != null) {
            this.f64773b = ((CJRAutomaticSubscriptionItemModel) serializable).getHistory();
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionItemModel");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.bottom_sheet_payment_history, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_payment_history);
        k.a((Object) recyclerView, "rv_payment_history");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_payment_history);
        k.a((Object) recyclerView2, "rv_payment_history");
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        recyclerView2.setAdapter(new net.one97.paytm.recharge.presentation.a.g(context, this.f64773b));
        ImageView imageView = (ImageView) a(R.id.ic_close);
        if (imageView != null) {
            imageView.setOnClickListener(new b(this));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64775a;

        b(g gVar) {
            this.f64775a = gVar;
        }

        public final void onClick(View view) {
            this.f64775a.dismiss();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f64774c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
