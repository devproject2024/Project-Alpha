package net.one97.paytm.o2o.movies.actor.holders;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.appsflyer.internal.referrer.Payload;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.ActorBaseItemData;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.utils.f;
import net.one97.paytm.o2o.movies.utils.n;

public class ViewDisclaimerHolder extends ActorBaseHolder {
    private RelativeLayout container;

    static /* synthetic */ void lambda$null$0(View view) {
    }

    public ViewDisclaimerHolder(View view) {
        super(view);
        this.container = (RelativeLayout) view.findViewById(R.id.container);
    }

    public void setData(ActorBaseItemData actorBaseItemData, Context context) {
        List<String> list;
        if (actorBaseItemData == null || d.a((List) actorBaseItemData.disclaimerData)) {
            list = n.a();
        } else {
            list = actorBaseItemData.disclaimerData;
        }
        this.container.setOnClickListener(new View.OnClickListener(context, list) {
            private final /* synthetic */ Context f$0;
            private final /* synthetic */ List f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                f.a(this.f$0, "Disclaimer", this.f$1, Payload.RESPONSE_OK, $$Lambda$ViewDisclaimerHolder$Hu0cUdwhU75PNiKhz3FOvg7Z7E.INSTANCE);
            }
        });
    }
}
