package net.one97.paytm.recharge.common.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.widgets.l;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.v4.CJRRechargeAlertItem;

public final class c extends d implements v {

    /* renamed from: a  reason: collision with root package name */
    private final List<CJRRechargeAlertItem> f61145a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f61146b;

    /* renamed from: c  reason: collision with root package name */
    private final String f61147c;

    /* renamed from: d  reason: collision with root package name */
    private final u f61148d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f61149e;

    public final View a(int i2) {
        if (this.f61149e == null) {
            this.f61149e = new HashMap();
        }
        View view = (View) this.f61149e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f61149e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a() {
        HashMap hashMap = this.f61149e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    private c(List<CJRRechargeAlertItem> list, boolean z, String str, u uVar) {
        k.c(list, "alertItems");
        this.f61145a = list;
        this.f61146b = z;
        this.f61147c = str;
        this.f61148d = uVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(List list, boolean z, String str, u uVar, int i2) {
        this(list, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : uVar);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return getLayoutInflater().inflate(R.layout.recharge_alert_bottom_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        RecyclerView recyclerView = (RecyclerView) a(R.id.recycler_view);
        k.a((Object) recyclerView, "recycler_view");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ((RecyclerView) a(R.id.recycler_view)).addItemDecoration(new l(getContext()));
        b bVar = new b(this.f61145a, getContext(), this.f61146b, this.f61147c);
        RecyclerView recyclerView2 = (RecyclerView) a(R.id.recycler_view);
        k.a((Object) recyclerView2, "recycler_view");
        recyclerView2.setAdapter(bVar);
        v vVar = this;
        k.c(vVar, "bottomSheetListener");
        bVar.f61134a = vVar;
    }

    public static final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f61150a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f61151b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f61152c;

        /* renamed from: d  reason: collision with root package name */
        RoboTextView f61153d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f61154e;

        /* renamed from: f  reason: collision with root package name */
        RelativeLayout f61155f;

        /* renamed from: g  reason: collision with root package name */
        RoboTextView f61156g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f61157h;

        /* renamed from: i  reason: collision with root package name */
        ImageView f61158i;
        RoboTextView j;
        ImageView k;
        Button l;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "view");
            this.f61150a = (RoboTextView) view.findViewById(R.id.heading);
            this.f61151b = (RoboTextView) view.findViewById(R.id.description);
            this.f61152c = (RoboTextView) view.findViewById(R.id.description1);
            this.f61153d = (RoboTextView) view.findViewById(R.id.description2);
            this.f61154e = (RelativeLayout) view.findViewById(R.id.description1_container);
            this.f61155f = (RelativeLayout) view.findViewById(R.id.description2_container);
            this.f61156g = (RoboTextView) view.findViewById(R.id.sample_label);
            this.f61157h = (ImageView) view.findViewById(R.id.info_image);
            this.f61158i = (ImageView) view.findViewById(R.id.close_btn);
            this.j = (RoboTextView) view.findViewById(R.id.message);
            this.k = (ImageView) view.findViewById(R.id.sample_image);
            this.l = (Button) view.findViewById(R.id.btn_action);
        }
    }

    public final void b() {
        dismiss();
    }

    public final void c() {
        dismiss();
    }
}
