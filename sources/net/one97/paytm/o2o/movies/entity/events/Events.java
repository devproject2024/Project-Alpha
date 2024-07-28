package net.one97.paytm.o2o.movies.entity.events;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public final class Events extends IJRPaytmDataModel {
    @c(a = "carousels")
    private List<Carousel> carousels;
    @c(a = "categories")
    private List<Category> categories;
    @c(a = "categoryTitleText")
    private String categoryTitleText;
    @c(a = "digitalEvents")
    private List<DigitalEvent> digitalEvents;
    @c(a = "digitalEventsDescription")
    private String digitalEventsDescription;
    @c(a = "digitalEventsTitleText")
    private String digitalEventsTitleText;

    public final List<Carousel> getCarousels() {
        return this.carousels;
    }

    public final void setCarousels(List<Carousel> list) {
        this.carousels = list;
    }

    public final String getCategoryTitleText() {
        return this.categoryTitleText;
    }

    public final void setCategoryTitleText(String str) {
        this.categoryTitleText = str;
    }

    public final List<Category> getCategories() {
        return this.categories;
    }

    public final void setCategories(List<Category> list) {
        this.categories = list;
    }

    public final String getDigitalEventsTitleText() {
        return this.digitalEventsTitleText;
    }

    public final void setDigitalEventsTitleText(String str) {
        this.digitalEventsTitleText = str;
    }

    public final String getDigitalEventsDescription() {
        return this.digitalEventsDescription;
    }

    public final void setDigitalEventsDescription(String str) {
        this.digitalEventsDescription = str;
    }

    public final List<DigitalEvent> getDigitalEvents() {
        return this.digitalEvents;
    }

    public final void setDigitalEvents(List<DigitalEvent> list) {
        this.digitalEvents = list;
    }
}
