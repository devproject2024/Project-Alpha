package net.one97.paytm.o2o.movies.actor.holders;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJREntertainmentWebViewActivity;
import net.one97.paytm.o2o.movies.actor.CJRActorBlogModel;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.utils.n;

public class TrendingStoriesHolder extends RecyclerView.v {
    private ImageView bannerImageIv;
    private RelativeLayout blogContainer;
    private TextView dateTv;
    View itemView;
    private TextView titleTv;

    public TrendingStoriesHolder(View view) {
        super(view);
        this.itemView = view;
        this.bannerImageIv = (ImageView) view.findViewById(R.id.bannerIv);
        this.titleTv = (TextView) view.findViewById(R.id.titleTv);
        this.dateTv = (TextView) view.findViewById(R.id.dateTv);
        this.blogContainer = (RelativeLayout) view.findViewById(R.id.blogContainer);
    }

    public void updateListItem(CJRActorBlogModel cJRActorBlogModel, Context context) {
        if (!TextUtils.isEmpty(cJRActorBlogModel.imageUrl)) {
            Drawable b2 = a.b(context, R.drawable.ic_movie_placeholder_horizontal);
            t.a(b.f75032a.f75033b.getPicassoIsInMemory());
            this.bannerImageIv.getContext();
            t.a(cJRActorBlogModel.imageUrl, n.a(3, context), b2, b2, this.bannerImageIv, false);
        }
        if (!TextUtils.isEmpty(cJRActorBlogModel.title)) {
            this.titleTv.setText(cJRActorBlogModel.title);
        } else {
            this.titleTv.setText("");
        }
        if (!TextUtils.isEmpty(cJRActorBlogModel.dateOfUpload)) {
            this.dateTv.setText(cJRActorBlogModel.dateOfUpload);
        } else {
            this.dateTv.setText("");
        }
        this.blogContainer.setOnClickListener(new View.OnClickListener(cJRActorBlogModel, context) {
            private final /* synthetic */ CJRActorBlogModel f$1;
            private final /* synthetic */ Context f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onClick(View view) {
                TrendingStoriesHolder.this.lambda$updateListItem$0$TrendingStoriesHolder(this.f$1, this.f$2, view);
            }
        });
    }

    public /* synthetic */ void lambda$updateListItem$0$TrendingStoriesHolder(CJRActorBlogModel cJRActorBlogModel, Context context, View view) {
        handleblogClickListener(cJRActorBlogModel, context);
    }

    private void handleblogClickListener(CJRActorBlogModel cJRActorBlogModel, Context context) {
        if (!com.paytm.utility.b.c(context)) {
            Toast.makeText(context, net.one97.paytm.common.assets.R.string.no_internet, 0).show();
        } else if (!TextUtils.isEmpty("Blog title")) {
            Intent intent = new Intent(context, AJREntertainmentWebViewActivity.class);
            intent.putExtra("intent_movie_image_url", cJRActorBlogModel.blogUrl);
            context.startActivity(intent);
        }
    }
}
