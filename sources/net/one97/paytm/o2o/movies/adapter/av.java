package net.one97.paytm.o2o.movies.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.o2o.movies.R;

public final class av extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    final TextView f74480a = ((TextView) this.f74487h.findViewById(R.id.txtValueRating));

    /* renamed from: b  reason: collision with root package name */
    final TextView f74481b = ((TextView) this.f74487h.findViewById(R.id.txtCriticsReviewItem));

    /* renamed from: c  reason: collision with root package name */
    final TextView f74482c = ((TextView) this.f74487h.findViewById(R.id.txtReviewSource));

    /* renamed from: d  reason: collision with root package name */
    final TextView f74483d = ((TextView) this.f74487h.findViewById(R.id.reviewDate));

    /* renamed from: e  reason: collision with root package name */
    final CircularImageView f74484e = ((CircularImageView) this.f74487h.findViewById(R.id.ivReviewSource));

    /* renamed from: f  reason: collision with root package name */
    final ImageView f74485f = ((ImageView) this.f74487h.findViewById(R.id.ivRatingStar));

    /* renamed from: g  reason: collision with root package name */
    final View f74486g = this.f74487h.findViewById(R.id.dividerView);

    /* renamed from: h  reason: collision with root package name */
    final View f74487h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public av(View view) {
        super(view);
        k.c(view, "view");
        this.f74487h = view;
    }
}
