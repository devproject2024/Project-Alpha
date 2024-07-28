package net.one97.paytm.feed.ui.feed.l;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.bq;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;

public final class g extends RecyclerView.a<f<bq, ? super RecommendedApps>> {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<RecommendedApps> f35105a = new ArrayList<>();

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        f fVar = (f) vVar;
        k.c(fVar, "holder");
        RecommendedApps recommendedApps = this.f35105a.get(i2);
        k.a((Object) recommendedApps, "result[position]");
        RecommendedApps recommendedApps2 = recommendedApps;
        k.c(recommendedApps2, "data");
        B b2 = fVar.f35103a;
        b2.setVariable(a.f33780g, recommendedApps2);
        b2.setVariable(a.f33778e, Integer.valueOf(i2));
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(a.f33775b), new d())).entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        String appSize = recommendedApps2.getAppSize();
        if (appSize != null) {
            View findViewById = fVar.f35104b.findViewById(R.id.appsize);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.appsize)");
            ((TextView) findViewById).setText(appSize);
        }
        fVar.f35103a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.feed_recommended_items_v2, viewGroup, false);
        k.a((Object) inflate, "view");
        return new f(inflate);
    }

    public final int getItemCount() {
        return this.f35105a.size();
    }
}
