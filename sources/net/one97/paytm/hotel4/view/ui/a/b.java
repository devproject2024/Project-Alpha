package net.one97.paytm.hotel4.view.ui.a;

import android.content.Context;
import com.google.android.play.core.splitcompat.a;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public class b extends h {
    public void onResume() {
        super.onResume();
        a.a((Context) getActivity());
        a.b((Context) getActivity());
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        a.a(context);
        a.b(context);
    }
}
