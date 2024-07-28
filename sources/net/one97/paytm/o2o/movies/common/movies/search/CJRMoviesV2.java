package net.one97.paytm.o2o.movies.common.movies.search;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviesV2 implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "censor")
    private String censor;
    @b(a = "code")
    private String code;
    @b(a = "display")
    private String display;
    @b(a = "edge_banner")
    private String edge_banner;
    @b(a = "firstSession")
    private String firstSession;
    @b(a = "formatGrpId")
    private String formatGroupId;
    @b(a = "formatGrpName")
    private String formatGroupName;
    private boolean gridItemViewed;
    @b(a = "image_url")
    private String imageUrl;
    @b(a = "imax_img_url")
    private String imaxImgUrl;
    private boolean itemViewed;
    @b(a = "language")
    private String language;
    @b(a = "openingDate")
    private String openingDate;
    @b(a = "ratings")
    private CJRMovieRatings ratings;
    @b(a = "screenFormat")
    private String screenFormat;
    private HashMap<String, CJRMoviesV2> screenFormatAndMovieCodeMap;
    @b(a = "sessionLength")
    private Integer sessionLength;
    @b(a = "soundFormat")
    private String soundFormat;
    @b(a = "title")
    private String title;
    @b(a = "translated")
    private CJRMovieHomeTranslation translated;

    public CJRMovieRatings getRatings() {
        return this.ratings;
    }

    public String getFormatGroupId() {
        return this.formatGroupId;
    }

    public void setFormatGroupId(String str) {
        this.formatGroupId = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
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

    public void setCensor(String str) {
        this.censor = str;
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

    public String getFirstSession() {
        return this.firstSession;
    }

    public void setFirstSession(String str) {
        this.firstSession = str;
    }

    public Integer getSessionLength() {
        return this.sessionLength;
    }

    public void setSessionLength(Integer num) {
        this.sessionLength = num;
    }

    public String getImaxImgUrl() {
        return this.imaxImgUrl;
    }

    public void setImaxImgUrl(String str) {
        this.imaxImgUrl = str;
    }

    public void setItemViewed() {
        this.itemViewed = true;
    }

    public boolean isItemViewed() {
        return this.itemViewed;
    }

    public boolean isGridItemViewed() {
        return this.gridItemViewed;
    }

    public void setGridItemViewed() {
        this.gridItemViewed = true;
    }

    public void setFormatGroupName(String str) {
        this.formatGroupName = str;
    }

    public String getFormatGroupName() {
        if (!TextUtils.isEmpty(this.formatGroupName)) {
            return this.formatGroupName;
        }
        return null;
    }

    public void putFormatAndMovieCode(String str, CJRMoviesV2 cJRMoviesV2) {
        if (this.screenFormatAndMovieCodeMap == null) {
            this.screenFormatAndMovieCodeMap = new LinkedHashMap();
        }
        this.screenFormatAndMovieCodeMap.put(str, cJRMoviesV2);
    }

    public CJRMoviesV2 getMovieCodeFromFormat(String str) {
        return this.screenFormatAndMovieCodeMap.get(str);
    }

    public Map<String, CJRMoviesV2> getScreenFormatAndMovieCodeMap() {
        return this.screenFormatAndMovieCodeMap;
    }

    public void updateScreenFormatMovieCodeMap(LinkedHashMap<String, CJRMoviesV2> linkedHashMap) {
        if (linkedHashMap == null) {
            this.screenFormatAndMovieCodeMap.clear();
            this.screenFormatAndMovieCodeMap = null;
            return;
        }
        HashMap<String, CJRMoviesV2> hashMap = this.screenFormatAndMovieCodeMap;
        if (hashMap == null) {
            this.screenFormatAndMovieCodeMap = new LinkedHashMap(linkedHashMap);
            return;
        }
        hashMap.clear();
        this.screenFormatAndMovieCodeMap.putAll(linkedHashMap);
    }

    public String getEdgeBanner() {
        return this.edge_banner;
    }

    public CJRMovieHomeTranslation getTranslated() {
        return this.translated;
    }

    public void setTranslated(CJRMovieHomeTranslation cJRMovieHomeTranslation) {
        this.translated = cJRMovieHomeTranslation;
    }
}
