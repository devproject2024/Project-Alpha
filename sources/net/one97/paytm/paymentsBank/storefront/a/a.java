package net.one97.paytm.paymentsBank.storefront.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.v;
import androidx.recyclerview.widget.z;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.a.g;
import net.one97.paytm.paymentsBank.fragment.f;
import net.one97.paytm.paymentsBank.storefront.model.StoreFrontViews;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final C0346a f19414a = new C0346a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private z f19415b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f19416c = true;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<StoreFrontViews> f19417d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f19418e;

    private View a(int i2) {
        if (this.f19418e == null) {
            this.f19418e = new HashMap();
        }
        View view = (View) this.f19418e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f19418e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.paymentsBank.storefront.a.a$a  reason: collision with other inner class name */
    public static final class C0346a {
        private C0346a() {
        }

        public /* synthetic */ C0346a(byte b2) {
            this();
        }

        public static a a(boolean z, List<StoreFrontViews> list) {
            k.c(list, "viewList");
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putBoolean("isPeakIn", z);
            aVar.setArguments(bundle);
            aVar.f19417d = list;
            return aVar;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_store_front, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            k.a();
        }
        this.f19416c = arguments.getBoolean("isPeakIn");
        RecyclerView recyclerView = (RecyclerView) a(R.id.rv_store_front);
        k.a((Object) recyclerView, "rv_store_front");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        if (!this.f19416c) {
            this.f19415b = new v();
            z zVar = this.f19415b;
            if (zVar != null) {
                zVar.attachToRecyclerView((RecyclerView) a(R.id.rv_store_front));
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dimen_2dp);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.dimen_5dp);
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            int c2 = b.c(context, R.color.paytm_blue_selected);
            ((RecyclerView) a(R.id.rv_store_front)).addItemDecoration(new f(dimensionPixelSize, dimensionPixelSize * 4, dimensionPixelSize2, c2, c2));
        }
        if (this.f19417d != null) {
            List<StoreFrontViews> list = this.f19417d;
            if (list == null) {
                k.a("itemList");
            }
            String title = list.get(0).getTitle();
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_store_front_title);
            k.a((Object) roboTextView, "tv_store_front_title");
            roboTextView.setText(title);
            if (this.f19416c) {
                Context context2 = getContext();
                if (context2 == null) {
                    k.a();
                }
                k.a((Object) context2, "this.context!!");
                List<StoreFrontViews> list2 = this.f19417d;
                if (list2 == null) {
                    k.a("itemList");
                }
                net.one97.paytm.paymentsBank.a.a aVar = new net.one97.paytm.paymentsBank.a.a(context2, list2, this.f19416c);
                RecyclerView recyclerView2 = (RecyclerView) a(R.id.rv_store_front);
                k.a((Object) recyclerView2, "rv_store_front");
                recyclerView2.setAdapter(aVar);
                return;
            }
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            k.a((Object) context3, "this.context!!");
            List<StoreFrontViews> list3 = this.f19417d;
            if (list3 == null) {
                k.a("itemList");
            }
            g gVar = new g(context3, list3);
            RecyclerView recyclerView3 = (RecyclerView) a(R.id.rv_store_front);
            k.a((Object) recyclerView3, "rv_store_front");
            recyclerView3.setAdapter(gVar);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f19418e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
