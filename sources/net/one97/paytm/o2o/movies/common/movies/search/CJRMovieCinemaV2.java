package net.one97.paytm.o2o.movies.common.movies.search;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieCinemaV2 implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "app_cover_url")
    private String appCoverUrl;
    @b(a = "censor")
    private String censor;
    @b(a = "content")
    private String content;
    @b(a = "contentId")
    private Integer contentId;
    @b(a = "display")
    private String display;
    @b(a = "duration")
    private Integer duration;
    @b(a = "formatGrpName")
    private String formatGrpName;
    @b(a = "genre")
    private String genre;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "isContentAvailable")
    private int isContentAvailable;
    private boolean isReviewAvailable;
    @b(a = "language")
    private String language;
    @b(a = "openingDate")
    private String openingDate;
    @b(a = "ratings")
    private CJRMovieRatings ratings;
    @b(a = "screenFormat")
    private String screenFormat;
    @b(a = "sessions")
    private List<CJRMoviesSession> sessions = null;
    @b(a = "soundFormat")
    private String soundFormat;
    @b(a = "title")
    private String title;
    @b(a = "translated")
    private CJRMovieHomeTranslation translated;
    @b(a = "urlForTrailer")
    private String urlForTrailer;
    @b(a = "web_cover_url")
    private String webCoverUrl;

    public CJRMovieRatings getRatings() {
        return this.ratings;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public String getDisplay() {
        return this.display;
    }

    public void setDisplay(String str) {
        this.display = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getCensor() {
        return this.censor;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setCensor(String str) {
        this.censor = str;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public Integer getDuration() {
        Integer num = this.duration;
        return Integer.valueOf(num == null ? 0 : num.intValue());
    }

    public void setDuration(Integer num) {
        this.duration = num;
    }

    public String getUrlForTrailer() {
        return this.urlForTrailer;
    }

    public void setUrlForTrailer(String str) {
        this.urlForTrailer = str;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public String getOpeningDate() {
        return this.openingDate;
    }

    public void setOpeningDate(String str) {
        this.openingDate = str;
    }

    public List<CJRMoviesSession> getSessions() {
        return this.sessions;
    }

    public void setSessions(List<CJRMoviesSession> list) {
        this.sessions = list;
    }

    public String getWebCoverUrl() {
        return this.webCoverUrl;
    }

    public void setWebCoverUrl(String str) {
        this.webCoverUrl = str;
    }

    public String getAppCoverUrl() {
        return this.appCoverUrl;
    }

    public void setAppCoverUrl(String str) {
        this.appCoverUrl = str;
    }

    public String getScreenFormat() {
        return this.screenFormat;
    }

    public void setScreenFormat(String str) {
        this.screenFormat = str;
    }

    public String getSoundFormat() {
        return this.soundFormat;
    }

    public void setSoundFormat(String str) {
        this.soundFormat = str;
    }

    public int isContentAvailable() {
        return this.isContentAvailable;
    }

    public void setContentAvailable(int i2) {
        this.isContentAvailable = i2;
    }

    public String getFinalDisplayName() {
        return TextUtils.isEmpty(getFormatGrpName()) ? getDisplay() : getFormatGrpName();
    }

    public String getLocalizedFinalDisplayName() {
        String display2 = getDisplay();
        CJRMovieHomeTranslation cJRMovieHomeTranslation = this.translated;
        if (cJRMovieHomeTranslation != null && !TextUtils.isEmpty(cJRMovieHomeTranslation.getDisplay())) {
            display2 = this.translated.getDisplay();
        }
        return TextUtils.isEmpty(getFormatGrpName()) ? display2 : getFormatGrpName();
    }

    public String getFormatGrpName() {
        return this.formatGrpName;
    }

    public CJRMovieHomeTranslation getTranslated() {
        return this.translated;
    }

    public void setTranslated(CJRMovieHomeTranslation cJRMovieHomeTranslation) {
        this.translated = cJRMovieHomeTranslation;
    }

    public Integer getContentId() {
        return this.contentId;
    }

    public void setContentId(Integer num) {
        this.contentId = num;
    }

    public boolean isReviewAvailable() {
        return this.isReviewAvailable;
    }

    public void setReviewAvailable(boolean z) {
        this.isReviewAvailable = z;
    }

    public void setRatings(CJRMovieRatings cJRMovieRatings) {
        this.ratings = cJRMovieRatings;
    }

    public void setGenre(String str) {
        this.genre = str;
    }
}
