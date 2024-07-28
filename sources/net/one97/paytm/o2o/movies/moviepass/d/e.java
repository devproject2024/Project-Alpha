package net.one97.paytm.o2o.movies.moviepass.d;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.o2o.movies.R;

public final class e extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public TextView f75522a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75523b;

    public e(View view) {
        super(view);
        this.f75522a = (TextView) view.findViewById(R.id.title);
        this.f75523b = (TextView) view.findViewById(R.id.description);
    }
}
