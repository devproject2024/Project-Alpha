package net.one97.paytm.o2o.movies.one_pager.holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.o2o.movies.R;

public final class f extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f75696a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f75697b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f75698c;

    public f(View view) {
        super(view);
        this.f75696a = (ImageView) view.findViewById(R.id.featured_image);
        this.f75697b = (TextView) view.findViewById(R.id.movieNameTv);
        this.f75698c = (TextView) view.findViewById(R.id.movieLanguageTv);
    }
}
