package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.CJRActorBlogModel;
import net.one97.paytm.o2o.movies.actor.CJRActorMovieModel;
import net.one97.paytm.o2o.movies.actor.CJRMovieVideoModelNew;
import net.one97.paytm.o2o.movies.actor.holders.FilmographyHolder;
import net.one97.paytm.o2o.movies.actor.holders.TrendingStoriesHolder;
import net.one97.paytm.o2o.movies.actor.holders.VideoHolder;
import net.one97.paytm.o2o.movies.actor.itemdata.ActorElementBaseData;

public final class h extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    private Context f74643a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRMovieVideoModelNew> f74644b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRActorMovieModel> f74645c;

    /* renamed from: d  reason: collision with root package name */
    private List<CJRActorBlogModel> f74646d;

    /* renamed from: e  reason: collision with root package name */
    private a f74647e;

    /* renamed from: f  reason: collision with root package name */
    private ActorElementBaseData f74648f;

    public interface a {
        void makeApiCallForMovieVideoCount(Long l);
    }

    public h(Context context, a aVar, ActorElementBaseData actorElementBaseData) {
        this.f74643a = context;
        this.f74647e = aVar;
        this.f74644b = actorElementBaseData.videos;
        this.f74645c = actorElementBaseData.movies;
        this.f74646d = actorElementBaseData.blogs;
        this.f74648f = actorElementBaseData;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 2) {
            return new FilmographyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filmography_tile_layout, viewGroup, false));
        }
        if (i2 == 4) {
            return new FilmographyHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.filmography_grid_tile_layout, viewGroup, false));
        }
        if (i2 == 3) {
            return new TrendingStoriesHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trending_story_item_layout, viewGroup, false));
        }
        if (i2 == 5) {
            return new VideoHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_video_grid_item, viewGroup, false));
        }
        return new VideoHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_video_item, viewGroup, false));
    }

    public final int getItemViewType(int i2) {
        return this.f74648f.templateId;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (vVar != null) {
            if (vVar instanceof VideoHolder) {
                ((VideoHolder) vVar).updateListItem(this.f74644b.get(i2), this.f74643a, this.f74647e);
            } else if (vVar instanceof FilmographyHolder) {
                ((FilmographyHolder) vVar).updateListItem(this.f74645c.get(i2), this.f74643a);
            } else if (vVar instanceof TrendingStoriesHolder) {
                ((TrendingStoriesHolder) vVar).updateListItem(this.f74646d.get(i2), this.f74643a);
            }
        }
    }

    public final int getItemCount() {
        if (2 == this.f74648f.templateId || 4 == this.f74648f.templateId) {
            List<CJRActorMovieModel> list = this.f74645c;
            if (list == null) {
                return 0;
            }
            return list.size();
        } else if (3 == this.f74648f.templateId) {
            List<CJRActorBlogModel> list2 = this.f74646d;
            if (list2 == null) {
                return 0;
            }
            return list2.size();
        } else {
            List<CJRMovieVideoModelNew> list3 = this.f74644b;
            if (list3 == null) {
                return 0;
            }
            return list3.size();
        }
    }
}
