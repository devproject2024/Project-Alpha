package net.one97.paytm.o2o.movies.adapter;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import kotlin.g.b.k;
import net.one97.paytm.o2o.movies.R;

public final class be extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final LinearLayout f74579a;

    /* renamed from: b  reason: collision with root package name */
    final RoboTextView f74580b;

    /* renamed from: c  reason: collision with root package name */
    final RoboTextView f74581c;

    /* renamed from: d  reason: collision with root package name */
    final RoboTextView f74582d;

    /* renamed from: e  reason: collision with root package name */
    final View f74583e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public be(View view) {
        super(view);
        k.c(view, "view");
        this.f74583e = view;
        LinearLayout linearLayout = (LinearLayout) this.f74583e.findViewById(R.id.ll_movie_time_slot);
        k.a((Object) linearLayout, "view.ll_movie_time_slot");
        this.f74579a = linearLayout;
        RoboTextView roboTextView = (RoboTextView) this.f74583e.findViewById(R.id.time_text);
        k.a((Object) roboTextView, "view.time_text");
        this.f74580b = roboTextView;
        RoboTextView roboTextView2 = (RoboTextView) this.f74583e.findViewById(R.id.movie_format);
        k.a((Object) roboTextView2, "view.movie_format");
        this.f74581c = roboTextView2;
        RoboTextView roboTextView3 = (RoboTextView) this.f74583e.findViewById(R.id.category);
        k.a((Object) roboTextView3, "view.category");
        this.f74582d = roboTextView3;
    }
}
