package net.one97.paytm.feed.ui.feed.g;

import android.view.View;
import android.widget.Toast;
import kotlin.g.a.b;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.feed.R;
import net.one97.paytm.feed.ui.feed.g.a;

public final class c {

    public static final class a extends l implements b<String, x> {
        final /* synthetic */ a.C0579a $languageResponseHandler;
        final /* synthetic */ int $position;
        final /* synthetic */ View $view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(a.C0579a aVar, int i2, View view) {
            super(1);
            this.$languageResponseHandler = aVar;
            this.$position = i2;
            this.$view = view;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return x.f47997a;
        }

        public final void invoke(String str) {
            if (str != null) {
                this.$languageResponseHandler.a(this.$position);
                Toast.makeText(this.$view.getContext(), R.string.language_set, 0).show();
            }
        }
    }
}
