package net.one97.paytm.games.fragment;

import android.content.Context;
import android.view.View;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;

public class a extends g {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f35627a;

    public View a(int i2) {
        if (this.f35627a == null) {
            this.f35627a = new HashMap();
        }
        View view = (View) this.f35627a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f35627a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void a() {
        HashMap hashMap = this.f35627a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.a(context);
    }
}
