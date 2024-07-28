package net.one97.paytm.o2o.movies.actor.holders;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.CJRActorMovieModel;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.o2o.movies.common.d;
import net.one97.paytm.o2o.movies.utils.n;

public class FilmographyHolder extends RecyclerView.v {
    private LinearLayout imdbRatingLL;
    private TextView imdbRatingTv;
    View itemView;
    private TextView releaseDateTv;
    private TextView subtitleTv;
    private ImageView tileImageIv;
    private TextView titleTv;

    public FilmographyHolder(View view) {
        super(view);
        this.itemView = view;
        this.tileImageIv = (ImageView) view.findViewById(R.id.tileIv);
        this.titleTv = (TextView) view.findViewById(R.id.titleTv);
        this.subtitleTv = (TextView) view.findViewById(R.id.subtitleTv);
        this.releaseDateTv = (TextView) view.findViewById(R.id.releaseTv);
        this.imdbRatingTv = (TextView) view.findViewById(R.id.imdbRatingTv);
        this.imdbRatingLL = (LinearLayout) view.findViewById(R.id.imdbRatingLL);
    }

    public void updateListItem(CJRActorMovieModel cJRActorMovieModel, Context context) {
        setImage(cJRActorMovieModel, context);
        setTitle(cJRActorMovieModel);
        setCastNameInSubtitle(cJRActorMovieModel);
        setReleaseAndLanguageText(cJRActorMovieModel);
        setImdbRating(cJRActorMovieModel);
    }

    private void setImdbRating(CJRActorMovieModel cJRActorMovieModel) {
        if (!TextUtils.isEmpty(cJRActorMovieModel.imdbRating)) {
            this.imdbRatingTv.setText(cJRActorMovieModel.imdbRating);
            this.imdbRatingLL.setVisibility(0);
            return;
        }
        this.imdbRatingLL.setVisibility(8);
    }

    private void setReleaseAndLanguageText(CJRActorMovieModel cJRActorMovieModel) {
        this.releaseDateTv.setText(getReleaseText(cJRActorMovieModel));
    }

    private void setCastNameInSubtitle(CJRActorMovieModel cJRActorMovieModel) {
        if (cJRActorMovieModel.metadata == null || TextUtils.isEmpty(cJRActorMovieModel.metadata.castName)) {
            this.subtitleTv.setVisibility(8);
            return;
        }
        this.subtitleTv.setText(cJRActorMovieModel.metadata.castName);
        this.subtitleTv.setVisibility(0);
    }

    private void setTitle(CJRActorMovieModel cJRActorMovieModel) {
        if (!TextUtils.isEmpty(cJRActorMovieModel.title)) {
            this.titleTv.setText(cJRActorMovieModel.title);
        } else {
            this.titleTv.setText("");
        }
    }

    private void setImage(CJRActorMovieModel cJRActorMovieModel, Context context) {
        if (!TextUtils.isEmpty(cJRActorMovieModel.bannerImage)) {
            Drawable b2 = a.b(context, R.drawable.ic_movie_portrait_placeholder);
            t.a(b.f75032a.f75033b.getPicassoIsInMemory());
            this.tileImageIv.getContext();
            t.a(cJRActorMovieModel.bannerImage, n.a(3, context), b2, b2, this.tileImageIv);
        }
    }

    private String getReleaseText(CJRActorMovieModel cJRActorMovieModel) {
        String str = "";
        if (!TextUtils.isEmpty(cJRActorMovieModel.releaseDate)) {
            str = formatReleaseDate(cJRActorMovieModel, str);
        }
        if (!d.a((List) cJRActorMovieModel.languages)) {
            for (String next : cJRActorMovieModel.languages) {
                if (str.length() > 0) {
                    str = str + ", ";
                }
                str = str + next;
            }
        }
        return str;
    }

    private String formatReleaseDate(CJRActorMovieModel cJRActorMovieModel, String str) {
        try {
            Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(cJRActorMovieModel.releaseDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM, yyyy");
            return str + simpleDateFormat.format(parse);
        } catch (Exception unused) {
            return str;
        }
    }
}
