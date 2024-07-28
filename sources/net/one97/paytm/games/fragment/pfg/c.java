package net.one97.paytm.games.fragment.pfg;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.games.R;
import net.one97.paytm.games.e.a;
import net.one97.paytm.games.e.f;
import net.one97.paytm.games.fragment.b;
import net.one97.paytm.games.model.pfg.Bean;
import net.one97.paytm.games.model.pfg.BeansInfo;
import net.one97.paytm.games.view.pfg.pinnedheader.PinnedHeaderRecyclerView;
import net.one97.paytm.games.view.pfg.refresh.KSwipeRefreshLayout;

public class c extends b {

    /* renamed from: a  reason: collision with root package name */
    List<net.one97.paytm.games.view.pfg.a.b<String, Bean>> f35707a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    Map<String, ArrayList<Bean>> f35708b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    private final String f35709c = getClass().getName();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f35710d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f35711e = 0;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f35712f = "20";

    /* renamed from: g  reason: collision with root package name */
    private Boolean f35713g = Boolean.FALSE;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Boolean f35714h = Boolean.TRUE;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public net.one97.paytm.games.a.a.b f35715i;
    private LinearLayoutManager j;
    /* access modifiers changed from: private */
    public KSwipeRefreshLayout k;
    private PinnedHeaderRecyclerView l;
    /* access modifiers changed from: private */
    public RelativeLayout m;
    private LottieAnimationView n;

    static /* synthetic */ int h(c cVar) {
        int i2 = cVar.f35711e;
        cVar.f35711e = i2 + 1;
        return i2;
    }

    public static c a(String str) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putSerializable("type", str);
        cVar.setArguments(bundle);
        return cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f35710d = getArguments().getString("type");
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_points_history, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        final Context context = getContext();
        this.k = (KSwipeRefreshLayout) view.findViewById(R.id.ksRefresh);
        this.l = (PinnedHeaderRecyclerView) view.findViewById(R.id.mRecyclerView);
        this.m = (RelativeLayout) view.findViewById(R.id.loading);
        this.n = (LottieAnimationView) view.findViewById(R.id.animation_view);
        this.k.setLoadView(LayoutInflater.from(getContext()).inflate(R.layout.refresh_footer, (ViewGroup) null, false));
        this.k.setOnRefreshListener(new net.one97.paytm.games.view.pfg.refresh.b() {
            public final void a() {
                Context context = context;
                if (context == null || f.a(context)) {
                    int unused = c.this.f35711e = 0;
                    Boolean unused2 = c.this.f35714h = Boolean.FALSE;
                    a.a(context, String.valueOf(c.this.f35711e), c.this.f35712f, net.one97.paytm.games.e.a.b.b(), net.one97.paytm.games.e.a.b.a(), c.this.f35710d, c.this.a());
                    return;
                }
                c.this.k.setRefresh(false);
                Toast.makeText(context, R.string.com_gamepind_msg_network_connectivity, 0).show();
            }

            public final void b() {
                Context context = context;
                if (context == null || f.a(context)) {
                    c.h(c.this);
                    a.a(c.this.getContext(), String.valueOf(c.this.f35711e), c.this.f35712f, net.one97.paytm.games.e.a.b.b(), net.one97.paytm.games.e.a.b.a(), c.this.f35710d, c.this.a());
                    return;
                }
                c.this.m.setVisibility(8);
                Toast.makeText(context, R.string.com_gamepind_msg_network_connectivity, 0).show();
            }
        });
        this.j = new LinearLayoutManager(getContext());
        this.l.setLayoutManager(this.j);
        this.f35715i = new net.one97.paytm.games.a.a.b();
        this.l.setAdapter(this.f35715i);
        this.l.setOnPinnedHeaderClickListener(new PinnedHeaderRecyclerView.a() {
            public final void onPinnedHeaderClick(int i2) {
                c.this.a(i2);
            }
        });
        this.l.addItemDecoration(new net.one97.paytm.games.view.pfg.pinnedheader.c());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2) {
        this.f35715i.a(i2);
        this.j.scrollToPositionWithOffset(i2, 0);
    }

    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (this.f35714h.booleanValue() && !f.a(context)) {
            b();
            Toast.makeText(context, R.string.com_gamepind_msg_network_connectivity, 0).show();
        } else if (this.f35714h.booleanValue()) {
            this.m.setVisibility(0);
            a.a(context, String.valueOf(this.f35711e), this.f35712f, net.one97.paytm.games.e.a.b.b(), net.one97.paytm.games.e.a.b.a(), this.f35710d, a());
        }
    }

    /* access modifiers changed from: private */
    public com.paytm.network.listener.b a() {
        return new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                if (iJRPaytmDataModel instanceof BeansInfo) {
                    net.one97.paytm.games.a.a.b i2 = c.this.f35715i;
                    c cVar = c.this;
                    i2.a(c.a(cVar, (BeansInfo) iJRPaytmDataModel, String.valueOf(cVar.f35711e)));
                    c.this.f35715i.notifyDataSetChanged();
                    c.this.b();
                    Boolean unused = c.this.f35714h = Boolean.FALSE;
                }
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                c.this.b();
                Toast.makeText(c.this.getContext(), R.string.com_gamepind_something_went_retry, 0).show();
            }
        };
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.f35714h.booleanValue()) {
            this.m.setVisibility(8);
        } else {
            this.k.setRefresh(false);
        }
    }

    static /* synthetic */ List a(c cVar, BeansInfo beansInfo, String str) {
        if ("0".equals(str)) {
            cVar.f35707a.clear();
            cVar.f35708b.clear();
        }
        if (beansInfo.getItems() != null && !beansInfo.getItems().isEmpty()) {
            for (int i2 = 0; i2 < beansInfo.getItems().size(); i2++) {
                if (cVar.f35708b.containsKey(beansInfo.getItems().get(i2).getDay())) {
                    cVar.f35708b.get(beansInfo.getItems().get(i2).getDay()).add(beansInfo.getItems().get(i2));
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(beansInfo.getItems().get(i2));
                    cVar.f35708b.put(beansInfo.getItems().get(i2).getDay(), arrayList);
                }
            }
            cVar.f35707a.clear();
            for (Map.Entry next : cVar.f35708b.entrySet()) {
                net.one97.paytm.games.view.pfg.a.b bVar = new net.one97.paytm.games.view.pfg.a.b();
                bVar.f35726c = true;
                bVar.f35724a = (String) next.getKey();
                bVar.f35725b = (List) next.getValue();
                cVar.f35707a.add(bVar);
            }
        }
        return cVar.f35707a;
    }
}
