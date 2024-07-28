package net.one97.paytm.common.entity.movies;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviesCastCrewItem implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "description")
    private String description;
    @b(a = "crew_id")
    private int mCrew_id;
    @b(a = "image")
    private String mImageUrl;
    @b(a = "name")
    private String mName;
    @b(a = "type")
    private String mType;

    public void setId(int i2) {
        this.mCrew_id = i2;
    }

    public int getId() {
        return this.mCrew_id;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getDescription() {
        return this.description;
    }
}
