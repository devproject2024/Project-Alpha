package net.one97.paytm.feed.ui.feed.l;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.feed.e.b;
import net.one97.paytm.feed.repository.models.recommendedapps.RecommendedApps;

public final class d {
    public static void a(View view, RecommendedApps recommendedApps) {
        k.c(view, "view");
        k.c(recommendedApps, "recommendedApps");
        if (p.a(recommendedApps.getType(), "Playstore", true)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(recommendedApps.getUrl()));
            view.getContext().startActivity(intent);
        } else if (p.a(recommendedApps.getType(), "H5", true)) {
            b bVar = b.f34268c;
            b.a(view.getContext(), recommendedApps.getUrl(), "", "");
        } else {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(recommendedApps.getUrl()));
            view.getContext().startActivity(intent2);
        }
    }
}
