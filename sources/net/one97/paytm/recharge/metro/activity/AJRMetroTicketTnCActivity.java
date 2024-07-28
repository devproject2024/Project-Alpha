package net.one97.paytm.recharge.metro.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.metro.CJRMetroTnCListModel;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class AJRMetroTicketTnCActivity extends CJRBaseMetroActivity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f63236a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final String f63237b = "METRO_TERM_AND_CONDITION";

    /* renamed from: c  reason: collision with root package name */
    private HashMap f63238c;

    public final View a(int i2) {
        if (this.f63238c == null) {
            this.f63238c = new HashMap();
        }
        View view = (View) this.f63238c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f63238c.put(Integer.valueOf(i2), findViewById);
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
        getLayoutInflater().inflate(R.layout.activity_metro_ticket_tnc, c(), true);
        b();
    }

    private final void b() {
        Intent intent = getIntent();
        k.a((Object) intent, "intent");
        Bundle extras = intent.getExtras();
        String string = extras != null ? extras.getString("metro_filter") : null;
        Intent intent2 = getIntent();
        k.a((Object) intent2, "intent");
        Bundle extras2 = intent2.getExtras();
        String string2 = extras2 != null ? extras2.getString("product_type") : null;
        d dVar = d.f64967a;
        CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setScreenName(this.f63237b);
        CRUFlowModel flowName = a2.getFlowName();
        if (flowName == null) {
            flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
        }
        a2.setFlowName(flowName);
        CRUFlowModel flowName2 = a2.getFlowName();
        if (flowName2 != null) {
            flowName2.setErrorType(ERROR_TYPE.UNDEFINED.name());
        }
        CRUFlowModel flowName3 = a2.getFlowName();
        if (flowName3 != null) {
            flowName3.setActionType(ACTION_TYPE.GET_TERM_AND_CONDITION.name());
        }
        net.one97.paytm.recharge.metro.f.a.a("fetch_metro_tnc", (Context) this, (ai) new c(this), string, string2, (Object) a2);
    }

    public static final class c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMetroTicketTnCActivity f63240a;

        c(AJRMetroTicketTnCActivity aJRMetroTicketTnCActivity) {
            this.f63240a = aJRMetroTicketTnCActivity;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Activity activity = this.f63240a;
                if (networkCustomError == null) {
                    k.a();
                }
                CJRRechargeUtilities.handleError$default(cJRRechargeUtilities, str, activity, (Fragment) null, networkCustomError, false, 102, obj, 20, (Object) null);
                return;
            }
            this.f63240a.finish();
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            if (iJRPaytmDataModel == null) {
                this.f63240a.finish();
                return;
            }
            List<String> list = ((CJRMetroTnCListModel) iJRPaytmDataModel).getmTnCList();
            if (list == null || list.isEmpty()) {
                this.f63240a.finish();
                return;
            }
            AJRMetroTicketTnCActivity aJRMetroTicketTnCActivity = this.f63240a;
            RecyclerView recyclerView = (RecyclerView) aJRMetroTicketTnCActivity.findViewById(R.id.tnc_list);
            k.a((Object) recyclerView, "rvTnCList");
            recyclerView.setLayoutManager(new LinearLayoutManager(aJRMetroTicketTnCActivity));
            recyclerView.setAdapter(new a(this, list));
        }

        public static final class a extends RecyclerView.a<b> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f63241a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ List f63242b;

            a(c cVar, List list) {
                this.f63241a = cVar;
                this.f63242b = list;
            }

            public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
                b bVar = (b) vVar;
                k.c(bVar, "holder");
                bVar.f63239a.setText((CharSequence) this.f63242b.get(i2));
            }

            public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
                k.c(viewGroup, "parent");
                View inflate = this.f63241a.f63240a.getLayoutInflater().inflate(R.layout.metro_tnc_item, viewGroup, false);
                k.a((Object) inflate, "layoutInflater.inflate(R…_tnc_item, parent, false)");
                return new b(inflate);
            }

            public final int getItemCount() {
                return this.f63242b.size();
            }
        }
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f63239a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.tnc_text);
            if (findViewById != null) {
                this.f63239a = (TextView) findViewById;
                return;
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 != 102) {
            return;
        }
        if (i3 != 0) {
            b();
            return;
        }
        ay ayVar = ay.f61523a;
        ay.a(102);
    }
}
