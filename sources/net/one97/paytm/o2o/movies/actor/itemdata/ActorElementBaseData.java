package net.one97.paytm.o2o.movies.actor.itemdata;

import java.util.List;
import net.one97.paytm.o2o.movies.actor.CJRActorBlogModel;
import net.one97.paytm.o2o.movies.actor.CJRActorMovieModel;
import net.one97.paytm.o2o.movies.actor.CJRMovieVideoModelNew;

public class ActorElementBaseData {
    public static final int FILMOGRAPHY_TYPE = 2;
    public static final int FILMOGRAPHY_TYPE_GRID = 4;
    public static final int TRENDING_STORIES = 3;
    public static final int VIDEO_TYPE = 1;
    public static final int VIDEO_TYPE_GRID = 5;
    public List<CJRActorBlogModel> blogs;
    public List<CJRActorMovieModel> movies;
    public int templateId;
    public List<CJRMovieVideoModelNew> videos;
}
