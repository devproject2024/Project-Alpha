package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviesCastCrewModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "blogs_heading")
    private String blogHeading;
    @b(a = "content_id")
    private int contentId;
    @b(a = "blogs_list")
    private ArrayList<CJRMovieEntertainmentModel> entertainmentModels;
    @b(a = "lead_cast")
    private CJRMoviesCastCrewList mCjrMoviesCastList;
    @b(a = "crew")
    private CJRMoviesCastCrewList mCjrMoviesCrewList;
    @b(a = "movie_images")
    private ArrayList<String> mImageList;
    @b(a = "is_enabled")
    private boolean mIsEnabled;
    @b(a = "movie_id")
    private String mMovie_id;
    @b(a = "movie_name")
    private String mMovie_name;
    @b(a = "summary")
    private String mSummary;
    @b(a = "title")
    private String mTitle;
    @b(a = "voteCount")
    private int mVoteCount;
    @b(a = "postersHeading")
    private String postersHeading;
    @b(a = "videos_heading")
    private String videoHeading;
    @b(a = "videos_list")
    private ArrayList<CJRMovieVideoModel> videoList;

    public String getmSummary() {
        return this.mSummary;
    }

    public void setmSummary(String str) {
        this.mSummary = str;
    }

    public String getmTitle() {
        return this.mTitle;
    }

    public void setmTitle(String str) {
        this.mTitle = str;
    }

    public CJRMoviesCastCrewList getmCjrMoviesCrewList() {
        return this.mCjrMoviesCrewList;
    }

    public void setmCjrMoviesCrewList(CJRMoviesCastCrewList cJRMoviesCastCrewList) {
        this.mCjrMoviesCrewList = cJRMoviesCastCrewList;
    }

    public CJRMoviesCastCrewList getmCjrMoviesCastList() {
        return this.mCjrMoviesCastList;
    }

    public void setmCjrMoviesCastList(CJRMoviesCastCrewList cJRMoviesCastCrewList) {
        this.mCjrMoviesCastList = cJRMoviesCastCrewList;
    }

    public String getmMovie_id() {
        return this.mMovie_id;
    }

    public void setmMovie_id(String str) {
        this.mMovie_id = str;
    }

    public String getmMovie_name() {
        return this.mMovie_name;
    }

    public void setmMovie_name(String str) {
        this.mMovie_name = str;
    }

    public ArrayList<String> getGalleryList() {
        return this.mImageList;
    }

    public boolean ismIsEnabled() {
        return this.mIsEnabled;
    }

    public void setmIsEnabled(boolean z) {
        this.mIsEnabled = z;
    }

    public int getmVoteCount() {
        return this.mVoteCount;
    }

    public void setmVoteCount(int i2) {
        this.mVoteCount = i2;
    }

    public ArrayList<CJRMovieEntertainmentModel> getEntertainmentModels() {
        return this.entertainmentModels;
    }

    public String getBlogHeading() {
        return this.blogHeading;
    }

    public String getVideoHeading() {
        return this.videoHeading;
    }

    public ArrayList<CJRMovieVideoModel> getVideoList() {
        return this.videoList;
    }

    public String getPostersHeading() {
        return this.postersHeading;
    }

    public int getContentId() {
        return this.contentId;
    }
}
