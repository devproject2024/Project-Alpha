package net.one97.paytm.o2o.movies.moviepass.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.moviepass.e.c;

public final class d extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f75514a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75515b;

    /* renamed from: c  reason: collision with root package name */
    public AppCompatImageView f75516c;

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f75517d;

    public interface a {
        void a(int i2, c cVar);
    }

    public d(View view) {
        super(view);
        this.f75516c = (AppCompatImageView) view.findViewById(R.id.mp_faq_drop_view);
        this.f75514a = (TextView) view.findViewById(R.id.mp_faq_question);
        this.f75515b = (TextView) view.findViewById(R.id.mp_faq_answer);
        this.f75517d = (LinearLayout) view.findViewById(R.id.faqContainer);
    }
}
