package net.one97.paytm.o2o.movies.one_pager.holders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.one_pager.c;

public final class g extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f75703a;

    public g(View view) {
        super(view);
        this.f75703a = (ImageView) view.findViewById(R.id.featured_image);
    }

    public final void a(Context context, CJRHomePageItem cJRHomePageItem, c.a aVar) {
        if (cJRHomePageItem != null && !TextUtils.isEmpty(cJRHomePageItem.getImageUrl())) {
            Drawable drawable = context.getResources().getDrawable(R.drawable.ic_movies_sqr_placeholder);
            t.a(b.f75032a.f75033b.getPicassoIsInMemory());
            t.a(cJRHomePageItem.getImageUrl(), 0, drawable, drawable, this.f75703a, true);
            this.f75703a.setOnClickListener(new View.OnClickListener(aVar, cJRHomePageItem) {
                private final /* synthetic */ c.a f$1;
                private final /* synthetic */ CJRHomePageItem f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    g.this.a(this.f$1, this.f$2, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(c.a aVar, CJRHomePageItem cJRHomePageItem, View view) {
        this.f75703a.setClickable(false);
        aVar.a(cJRHomePageItem);
        this.f75703a.setClickable(true);
    }
}
