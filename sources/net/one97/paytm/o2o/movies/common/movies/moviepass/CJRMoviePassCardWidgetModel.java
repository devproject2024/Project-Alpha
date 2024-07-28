package net.one97.paytm.o2o.movies.common.movies.moviepass;

import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMoviePassCardWidgetModel implements IJRDataModel {
    private String bgImage;
    private String cinemaLocationValidityText;
    private String description;
    private String heading;
    private boolean isDisabled;
    private boolean isMoviePassIconVisible;
    private String movieCountText;
    private String passMrpText;
    private String passValidityText;
    private String priceText;
    private String subDescription;
    private String ticketsCountText;

    public String getPassMrpText() {
        return this.passMrpText;
    }

    public void setPassMrpText(String str) {
        this.passMrpText = str;
    }

    public boolean isDisabled() {
        return this.isDisabled;
    }

    public void setDisabled(boolean z) {
        this.isDisabled = z;
    }

    public String getHeading() {
        return this.heading;
    }

    public void setHeading(String str) {
        this.heading = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getSubDescription() {
        return this.subDescription;
    }

    public void setSubDescription(String str) {
        this.subDescription = str;
    }

    public String getTicketsCountText() {
        return this.ticketsCountText;
    }

    public void setTicketsCountText(String str) {
        this.ticketsCountText = str;
    }

    public String getPriceText() {
        return this.priceText;
    }

    public void setPriceText(String str) {
        this.priceText = str;
    }

    public String getBgImage() {
        return this.bgImage;
    }

    public void setBgImage(String str) {
        this.bgImage = str;
    }

    public boolean isMoviePassIconVisible() {
        return this.isMoviePassIconVisible;
    }

    public void setMoviePassIconVisible(boolean z) {
        this.isMoviePassIconVisible = z;
    }

    public String getCinemaLocationValidityText() {
        return this.cinemaLocationValidityText;
    }

    public void setCinemaLocationValidityText(String str) {
        this.cinemaLocationValidityText = str;
    }

    public String getPassValidityText() {
        return this.passValidityText;
    }

    public void setPassValidityText(String str) {
        this.passValidityText = str;
    }

    public String getMovieCountText() {
        return this.movieCountText;
    }

    public void setMovieCountText(String str) {
        this.movieCountText = str;
    }
}
