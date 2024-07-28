package net.one97.paytm.o2o.movies.entity.events;

import com.google.gson.a.c;

public final class Event {
    @c(a = "category_id")
    private CategoryId categoryId;
    @c(a = "city")
    private String city;
    @c(a = "event_state")
    private String eventState;
    @c(a = "h5url")
    private String h5url;
    @c(a = "horizontal_cover_image")
    private String horizontalCoverImage;
    @c(a = "_id")
    private String id;
    @c(a = "min_price")
    private Integer minPrice;
    @c(a = "min_show_start_time")
    private Integer minShowStartTime;
    @c(a = "name")
    private String name;
    @c(a = "price_display_string")
    private String priceDisplayString;
    @c(a = "slug")
    private String slug;
    @c(a = "type")
    private String type;
    @c(a = "venue_date_string")
    private String venueDateString;
    @c(a = "venue_name")
    private String venueName;
    @c(a = "vertical_cover_image")
    private Object verticalCoverImage;

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final String getSlug() {
        return this.slug;
    }

    public final void setSlug(String str) {
        this.slug = str;
    }

    public final String getHorizontalCoverImage() {
        return this.horizontalCoverImage;
    }

    public final void setHorizontalCoverImage(String str) {
        this.horizontalCoverImage = str;
    }

    public final Object getVerticalCoverImage() {
        return this.verticalCoverImage;
    }

    public final void setVerticalCoverImage(Object obj) {
        this.verticalCoverImage = obj;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getVenueName() {
        return this.venueName;
    }

    public final void setVenueName(String str) {
        this.venueName = str;
    }

    public final String getEventState() {
        return this.eventState;
    }

    public final void setEventState(String str) {
        this.eventState = str;
    }

    public final String getVenueDateString() {
        return this.venueDateString;
    }

    public final void setVenueDateString(String str) {
        this.venueDateString = str;
    }

    public final String getPriceDisplayString() {
        return this.priceDisplayString;
    }

    public final void setPriceDisplayString(String str) {
        this.priceDisplayString = str;
    }

    public final Integer getMinPrice() {
        return this.minPrice;
    }

    public final void setMinPrice(Integer num) {
        this.minPrice = num;
    }

    public final Integer getMinShowStartTime() {
        return this.minShowStartTime;
    }

    public final void setMinShowStartTime(Integer num) {
        this.minShowStartTime = num;
    }

    public final CategoryId getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(CategoryId categoryId2) {
        this.categoryId = categoryId2;
    }

    public final String getH5url() {
        return this.h5url;
    }

    public final void setH5url(String str) {
        this.h5url = str;
    }
}
