package net.one97.paytm.o2o.movies.common.movies.moviepass;

import net.one97.paytm.common.entity.movies.moviepass.CJRMoviePassModel;

public class CJRMoviePassModelNew extends CJRMoviePassModel {
    private String groupId;
    private String groupName;
    private int isOutOfStock;
    private String strikeOffPrice;

    public int getIsOutOfStock() {
        return this.isOutOfStock;
    }

    public void setIsOutOfStock(int i2) {
        this.isOutOfStock = i2;
    }

    public String getStrikeOffPrice() {
        return this.strikeOffPrice;
    }

    public void setStrikeOffPrice(String str) {
        this.strikeOffPrice = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }
}
