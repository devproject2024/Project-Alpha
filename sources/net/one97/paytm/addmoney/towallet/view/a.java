package net.one97.paytm.addmoney.towallet.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.listeners.IAdListener;
import com.paytmmall.clpartifact.listeners.IGAClickListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.grid.CJRGridProduct;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.helper.c;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class a extends h {

    /* renamed from: b  reason: collision with root package name */
    public static final C0861a f48884b = new C0861a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public StoreFrontGAHandler f48885a;

    /* renamed from: c  reason: collision with root package name */
    private View f48886c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f48887d = "widgetsViews";
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f48888e = SDKConstants.EVENT_KEY_SCREEN_NAME;

    /* renamed from: f  reason: collision with root package name */
    private IGAHandlerListener f48889f = new b(this);

    /* renamed from: g  reason: collision with root package name */
    private HashMap f48890g;

    private View a(int i2) {
        if (this.f48890g == null) {
            this.f48890g = new HashMap();
        }
        View view = (View) this.f48890g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f48890g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class b implements IGAHandlerListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f48891a;

        public final boolean IsClickEnable() {
            return true;
        }

        public /* synthetic */ void OnItemClick(Item item, int i2) {
            IGAClickListener.CC.$default$OnItemClick(this, item, i2);
        }

        public final void fireImpression(Item item, int i2) {
            k.c(item, "item");
        }

        public final void fireImpression(com.paytmmall.clpartifact.modal.clpCommon.View view, int i2) {
            k.c(view, "view");
        }

        public final void fireInfiniteGridProductImpression(CJRGridProduct cJRGridProduct, int i2) {
        }

        public final int getClient() {
            return 1001;
        }

        public /* synthetic */ String getClientRequestID() {
            return IAdListener.CC.$default$getClientRequestID(this);
        }

        b(a aVar) {
            this.f48891a = aVar;
        }

        public final void OnItemClick(Item item, int i2, boolean z) {
            String str;
            String str2;
            String string;
            k.c(item, "item");
            Context context = this.f48891a.getContext();
            if (context != null) {
                if (z) {
                    c a2 = net.one97.paytm.helper.a.f50546a.a();
                    k.a((Object) context, "it");
                    String gaCategory = item.getGaCategory();
                    k.a((Object) gaCategory, "item.gaCategory");
                    String str3 = item.getName() + "_clicked";
                    Bundle arguments = this.f48891a.getArguments();
                    if (arguments == null || (string = arguments.getString(this.f48891a.f48888e)) == null) {
                        str2 = "";
                    } else {
                        str2 = string;
                    }
                    a2.a(context, gaCategory, str3, (String) null, (String) null, "/", str2, "add_money");
                }
                c a3 = net.one97.paytm.helper.a.f50546a.a();
                k.a((Object) context, "it");
                Bundle arguments2 = this.f48891a.getArguments();
                if (arguments2 == null || (str = arguments2.getString(this.f48891a.f48888e)) == null) {
                    str = "";
                }
                a3.a(context, item, i2, str);
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_uam_ad_slot, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…d_slot, container, false)");
        this.f48886c = inflate;
        View view = this.f48886c;
        if (view == null) {
            k.a("mRootView");
        }
        return view;
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable(this.f48887d);
            if (serializable != null) {
                List<? extends com.paytmmall.clpartifact.modal.clpCommon.View> list = (List) serializable;
                ((RecyclerView) a(R.id.sfrv)).setLayoutManager(new LinearLayoutManager(getActivity()));
                net.one97.paytm.newaddmoney.a.c cVar = new net.one97.paytm.newaddmoney.a.c(this.f48885a);
                ((RecyclerView) a(R.id.sfrv)).setAdapter(cVar);
                if (list == null) {
                    list = cVar.f55816a;
                }
                cVar.f55816a = list;
                cVar.notifyDataSetChanged();
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.collections.List<com.paytmmall.clpartifact.modal.clpCommon.View>");
        }
    }

    /* renamed from: net.one97.paytm.addmoney.towallet.view.a$a  reason: collision with other inner class name */
    public static final class C0861a {
        private C0861a() {
        }

        public /* synthetic */ C0861a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f48890g;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
