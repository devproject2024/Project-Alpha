package net.one97.paytm.p2b.view.c;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.view.a.b;

public final class g extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final a f12998b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public StoreFrontGAHandler f12999a;

    /* renamed from: c  reason: collision with root package name */
    private View f13000c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f13001d = "widgetsViews";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f13002e = "className";

    /* renamed from: f  reason: collision with root package name */
    private String f13003f = "P2B";

    /* renamed from: g  reason: collision with root package name */
    private HashMap f13004g;

    private View a(int i2) {
        if (this.f13004g == null) {
            this.f13004g = new HashMap();
        }
        View view = (View) this.f13004g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f13004g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_p2b_ad_slot, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…d_slot, container, false)");
        this.f13000c = inflate;
        View view = this.f13000c;
        if (view == null) {
            k.a("mRootView");
        }
        return view;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(this.f13001d);
            if (serializable != null) {
                List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list = (List) serializable;
                ((RecyclerView) a(R.id.sfrv)).setLayoutManager(new LinearLayoutManager(getActivity()));
                b bVar = new b(this.f12999a);
                ((RecyclerView) a(R.id.sfrv)).setAdapter(bVar);
                if (list == null) {
                    list = bVar.f12893a;
                }
                bVar.f12893a = list;
                bVar.notifyDataSetChanged();
                String string = arguments.getString(this.f13002e);
                if (string != null) {
                    this.f13003f = string;
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.List<com.paytmmall.clpartifact.modal.clpCommon.View>");
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f13004g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
