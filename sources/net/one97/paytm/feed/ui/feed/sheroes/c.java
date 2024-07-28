package net.one97.paytm.feed.ui.feed.sheroes;

import android.view.View;
import androidx.lifecycle.a;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.feed.b.cc;
import net.one97.paytm.feed.repository.models.sheroes.FeedSheroes;
import net.one97.paytm.feed.ui.base.b;

public final class c extends b<cc, FeedSheroes, a> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        k.c(view, "view");
    }

    public final void a(FeedSheroes feedSheroes, int i2) {
        k.c(feedSheroes, "data");
        cc ccVar = (cc) this.f34872a;
        ccVar.setVariable(net.one97.paytm.feed.a.f33780g, feedSheroes);
        ccVar.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
        for (Map.Entry entry : ae.c(new o(Integer.valueOf(net.one97.paytm.feed.a.f33775b), new a())).entrySet()) {
            ccVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        ((cc) this.f34872a).executePendingBindings();
    }
}
