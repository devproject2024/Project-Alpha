package net.one97.paytm.feed.ui.feed.l;

import android.graphics.Color;
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
import net.one97.paytm.feed.b.da;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;

public final class a extends RecyclerView.a<e<da, ? super RecommendedApps>> {

    /* renamed from: a  reason: collision with root package name */
    String f35090a;

    /* renamed from: b  reason: collision with root package name */
    String f35091b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<RecommendedApps> f35092c;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        e eVar = (e) vVar;
        k.c(eVar, "holder");
        RecommendedApps recommendedApps = this.f35092c.get(i2);
        k.a((Object) recommendedApps, "result[position]");
        RecommendedApps recommendedApps2 = recommendedApps;
        String str = this.f35090a;
        String str2 = this.f35091b;
        k.c(recommendedApps2, "data");
        k.c(str, "title");
        B b2 = eVar.f35101a;
        b2.setVariable(net.one97.paytm.feed.a.f33780g, recommendedApps2);
        b2.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
        b2.setVariable(net.one97.paytm.feed.a.F, str);
        b2.setVariable(net.one97.paytm.feed.a.f33782i, Integer.valueOf(Color.parseColor(recommendedApps2.getBgColor())));
        b2.setVariable(net.one97.paytm.feed.a.v, "   |");
        b2.setVariable(net.one97.paytm.feed.a.f33781h, str2);
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(net.one97.paytm.feed.a.f33775b), new d())).entrySet()) {
            b2.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        String category = recommendedApps2.getCategory();
        if (category != null) {
            View findViewById = eVar.f35102b.findViewById(R.id.category);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.category)");
            ((TextView) findViewById).setText(category);
        }
        String appSize = recommendedApps2.getAppSize();
        if (appSize != null) {
            View findViewById2 = eVar.f35102b.findViewById(R.id.appsize);
            k.a((Object) findViewById2, "view.findViewById<TextView>(R.id.appsize)");
            ((TextView) findViewById2).setText(appSize);
        }
        eVar.f35101a.executePendingBindings();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        com.google.android.play.core.splitcompat.a.a(viewGroup.getContext());
        com.google.android.play.core.splitcompat.a.b(viewGroup.getContext());
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        if (from == null) {
            k.a();
        }
        View inflate = from.inflate(R.layout.recommended_items, viewGroup, false);
        k.a((Object) inflate, "view");
        return new e(inflate);
    }

    public final int getItemCount() {
        return this.f35092c.size();
    }
}
