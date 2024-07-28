package com.travel.flight.utils;

import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import com.travel.flight.R;
import com.travel.flight.flightorder.a.d;
import com.travel.flight.flightorder.a.e;
import com.travel.flight.pojo.Card;
import com.travel.flight.pojo.Info;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0479a f25576a = new C0479a((byte) 0);

    /* renamed from: com.travel.flight.utils.a$a  reason: collision with other inner class name */
    public static final class C0479a {
        private C0479a() {
        }

        public /* synthetic */ C0479a(byte b2) {
            this();
        }
    }

    public static final void a(TextView textView, String str) {
        if (textView != null && str != null) {
            textView.setText(textView.getContext().getString(R.string.rupee_symbol) + ' ' + b.S(str));
        }
    }

    public static final void a(RecyclerView recyclerView, List<Info> list) {
        if (recyclerView != null && list != null) {
            recyclerView.setAdapter(new d(list));
        }
    }

    public static final void b(RecyclerView recyclerView, List<Card> list) {
        if (recyclerView != null && list != null) {
            recyclerView.setAdapter(new e(list));
        }
    }
}
