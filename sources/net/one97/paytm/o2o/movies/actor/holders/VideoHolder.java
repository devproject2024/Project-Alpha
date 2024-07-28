package net.one97.paytm.o2o.movies.actor.holders;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.e;
import com.paytm.utility.q;
import com.paytm.utility.t;
import java.text.DecimalFormat;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.CJRMovieVideoModelNew;
import net.one97.paytm.o2o.movies.adapter.h;
import net.one97.paytm.o2o.movies.common.c.b;

public class VideoHolder extends RecyclerView.v {
    public ImageView cardThumbNail;
    public TextView mDuration;
    public TextView mNoOfViews;
    public TextView titleTv;

    public VideoHolder(View view) {
        super(view);
        this.cardThumbNail = (ImageView) view.findViewById(R.id.movie_video_thumb_image);
        this.mNoOfViews = (TextView) view.findViewById(R.id.noOfViews);
        this.mDuration = (TextView) view.findViewById(R.id.duration);
        this.titleTv = (TextView) view.findViewById(R.id.trailer_name);
    }

    public void updateListItem(CJRMovieVideoModelNew cJRMovieVideoModelNew, Context context, h.a aVar) {
        if (cJRMovieVideoModelNew != null) {
            setThumbnailImage(cJRMovieVideoModelNew, context);
            setNoOfViews(cJRMovieVideoModelNew);
            setDuration(cJRMovieVideoModelNew);
            setTitle(cJRMovieVideoModelNew);
            if (cJRMovieVideoModelNew.id != null) {
                this.cardThumbNail.setOnClickListener(new View.OnClickListener(cJRMovieVideoModelNew, context, aVar) {
                    private final /* synthetic */ CJRMovieVideoModelNew f$1;
                    private final /* synthetic */ Context f$2;
                    private final /* synthetic */ h.a f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void onClick(View view) {
                        VideoHolder.this.lambda$updateListItem$0$VideoHolder(this.f$1, this.f$2, this.f$3, view);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$updateListItem$0$VideoHolder(CJRMovieVideoModelNew cJRMovieVideoModelNew, Context context, h.a aVar, View view) {
        callYoutubeActivity(cJRMovieVideoModelNew, context, aVar);
    }

    private void setTitle(CJRMovieVideoModelNew cJRMovieVideoModelNew) {
        if (!TextUtils.isEmpty(cJRMovieVideoModelNew.title)) {
            this.titleTv.setText(cJRMovieVideoModelNew.title);
            this.titleTv.setSingleLine(false);
            this.titleTv.setEllipsize(TextUtils.TruncateAt.END);
            this.titleTv.setLines(2);
            this.titleTv.setVisibility(0);
        }
    }

    private void setDuration(CJRMovieVideoModelNew cJRMovieVideoModelNew) {
        if (!TextUtils.isEmpty(cJRMovieVideoModelNew.videoDuration)) {
            this.mDuration.setText(cJRMovieVideoModelNew.videoDuration);
            this.mDuration.setVisibility(0);
            return;
        }
        this.mDuration.setVisibility(8);
    }

    private void setNoOfViews(CJRMovieVideoModelNew cJRMovieVideoModelNew) {
        if (cJRMovieVideoModelNew.viewCount == null || cJRMovieVideoModelNew.viewCount.longValue() <= 0) {
            this.mNoOfViews.setVisibility(8);
            return;
        }
        long longValue = cJRMovieVideoModelNew.viewCount.longValue();
        int i2 = (longValue > 1000 ? 1 : (longValue == 1000 ? 0 : -1));
        if (i2 < 0) {
            if (longValue == 1) {
                TextView textView = this.mNoOfViews;
                textView.setText(String.valueOf(longValue) + " View");
            } else {
                TextView textView2 = this.mNoOfViews;
                textView2.setText(String.valueOf(longValue) + " Views");
            }
        } else if (i2 > 0) {
            TextView textView3 = this.mNoOfViews;
            textView3.setText(new DecimalFormat("##.#").format(((double) longValue) / 1000.0d) + "k Views");
        }
        this.mNoOfViews.setVisibility(0);
    }

    private void setThumbnailImage(CJRMovieVideoModelNew cJRMovieVideoModelNew, Context context) {
        String str = cJRMovieVideoModelNew.imageUrl;
        this.cardThumbNail.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            String trim = str.trim();
            Drawable b2 = a.b(context, R.drawable.ic_movie_placeholder_horizontal);
            t.a(b.f75032a.f75033b.getPicassoIsInMemory());
            t.a(trim, 8, b2, b2, this.cardThumbNail, false);
        }
    }

    public void callYoutubeActivity(CJRMovieVideoModelNew cJRMovieVideoModelNew, Context context, h.a aVar) {
        try {
            String str = cJRMovieVideoModelNew.videoUrl;
            String str2 = null;
            Intent intent = new Intent(context, b.f75032a.f75033b.getPaytmActivityMap().get("AJRYoutubeVideoPlay"));
            if (!TextUtils.isEmpty(str)) {
                q.d("URL ------".concat(String.valueOf(str)));
                str2 = com.paytm.utility.b.e(str);
                if (str2 == null) {
                    str2 = com.paytm.utility.b.f(str);
                }
                q.d("VIDEO ID ------".concat(String.valueOf(str2)));
                if (aVar != null) {
                    aVar.makeApiCallForMovieVideoCount(cJRMovieVideoModelNew.id);
                }
            }
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                intent.putExtra(e.aA, str2);
                context.startActivity(intent);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }
}
