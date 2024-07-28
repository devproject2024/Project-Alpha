package net.one97.paytm.feed.ui.a;

import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.feed.R;

public final class e extends i {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f34839a;

    public final void b() {
        HashMap hashMap = this.f34839a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public final int a() {
        return R.layout.feed_language_error;
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f34840a;

        a(e eVar) {
            this.f34840a = eVar;
        }

        public final void onClick(View view) {
            this.f34840a.dismiss();
        }
    }

    public final void a(View view) {
        k.c(view, "view");
        try {
            ((ImageView) view.findViewById(R.id.close)).setOnClickListener(new a(this));
        } catch (Exception unused) {
        }
    }
}
