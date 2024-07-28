package net.one97.paytm.o2o.movies.fragment;

import android.content.Context;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.i.h;

public class b extends h {
    public void onAttach(Context context) {
        super.onAttach(context);
        a.a(context);
        a.b(context);
    }

    public void onResume() {
        super.onResume();
        if (getActivity() != null) {
            a.a((Context) getActivity());
            a.b((Context) getActivity());
        }
    }
}
