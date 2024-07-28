package com.travel.train.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.q;
import com.travel.train.R;
import com.travel.train.model.trainticket.i;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class ar extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    final String f26308a = "CJRPNRStatusDetailsAdapter";

    /* renamed from: b  reason: collision with root package name */
    Context f26309b;

    /* renamed from: c  reason: collision with root package name */
    int f26310c;

    /* renamed from: d  reason: collision with root package name */
    a f26311d;

    /* renamed from: e  reason: collision with root package name */
    private LayoutInflater f26312e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f26313f = this.f26309b.getResources().getStringArray(R.array.train_sort_by_array_values);

    public interface a {
        void a(int i2, i iVar);
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        b bVar = (b) vVar;
        k.c(bVar, "holder");
        String[] strArr = this.f26313f;
        if (strArr != null) {
            if (strArr.length == 0) {
                return;
            }
        }
        TextView textView = bVar.f26314a;
        String[] strArr2 = this.f26313f;
        if (strArr2 == null) {
            k.a();
        }
        textView.setText(strArr2[i2]);
        if (this.f26310c == i2) {
            bVar.f26314a.setTextAppearance(this.f26309b, R.style.TrainSortByWidgetSelected);
            bVar.f26315b.setVisibility(0);
        } else {
            bVar.f26314a.setTextAppearance(this.f26309b, R.style.TrainSortByWidget);
            bVar.f26315b.setVisibility(4);
        }
        bVar.f26316c.setOnClickListener(new c(this, bVar, i2));
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater layoutInflater = this.f26312e;
        View inflate = layoutInflater != null ? layoutInflater.inflate(R.layout.pre_t_lyt_train_sort_by_item, viewGroup, false) : null;
        if (inflate == null) {
            k.a();
        }
        return new b(inflate);
    }

    public ar(Context context, int i2, a aVar) {
        k.c(context, "mContext");
        this.f26309b = context;
        this.f26310c = i2;
        this.f26311d = aVar;
        Context context2 = this.f26309b;
        if (context2 != null) {
            Object systemService = context2.getSystemService("layout_inflater");
            if (systemService != null) {
                this.f26312e = (LayoutInflater) systemService;
                return;
            }
            throw new u("null cannot be cast to non-null type android.view.LayoutInflater");
        }
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ar f26317a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f26318b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f26319c;

        c(ar arVar, b bVar, int i2) {
            this.f26317a = arVar;
            this.f26318b = bVar;
            this.f26319c = i2;
        }

        public final void onClick(View view) {
            this.f26318b.f26314a.setTextAppearance(this.f26317a.f26309b, R.style.TrainSortByWidgetSelected);
            this.f26318b.f26315b.setVisibility(0);
            ar arVar = this.f26317a;
            int i2 = this.f26319c;
            arVar.f26310c = i2;
            a aVar = arVar.f26311d;
            if (aVar != null) {
                aVar.a(i2, (i) null);
            }
            this.f26317a.notifyDataSetChanged();
            ar arVar2 = this.f26317a;
            int i3 = this.f26319c;
            String str = d.cR;
            if (i3 == 0) {
                str = d.cR;
            } else if (i3 == 1) {
                str = d.cS;
            } else if (i3 == 2 || i3 == 3) {
                str = d.cT;
            } else if (i3 == 4 || i3 == 5) {
                str = d.cU;
            }
            k.a((Object) str, "selectedString");
            try {
                HashMap hashMap = new HashMap();
                Map map = hashMap;
                String n = com.paytm.utility.b.n(arVar2.f26309b) != null ? com.paytm.utility.b.n(arVar2.f26309b) : "";
                k.a((Object) n, "if (CJRAppCommonUtility.…tUserId(mContext) else \"\"");
                map.put("user_id", n);
                hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/trains/search-results");
                k.a((Object) com.travel.train.b.a(), "TrainController.getInstance()");
                com.travel.train.b.b().a(str, (Map<String, Object>) hashMap, arVar2.f26309b);
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    public final int getItemCount() {
        String[] strArr = this.f26313f;
        if (strArr != null) {
            return strArr.length;
        }
        return 0;
    }

    public static final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final TextView f26314a;

        /* renamed from: b  reason: collision with root package name */
        final ImageView f26315b;

        /* renamed from: c  reason: collision with root package name */
        final RelativeLayout f26316c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            k.c(view, "itemView");
            View findViewById = view.findViewById(R.id.sort_by_name);
            if (findViewById != null) {
                this.f26314a = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.sort_by_image);
                if (findViewById2 != null) {
                    this.f26315b = (ImageView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.sort_layout);
                    if (findViewById3 != null) {
                        this.f26316c = (RelativeLayout) findViewById3;
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.widget.RelativeLayout");
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }
    }
}
