package net.one97.paytm.o2o.movies.entity.events;

import com.google.gson.a.c;
import java.util.List;

public final class Carousel {
    @c(a = "events")
    private List<Event> events;
    @c(a = "title")
    private String title;

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final List<Event> getEvents() {
        return this.events;
    }

    public final void setEvents(List<Event> list) {
        this.events = list;
    }
}
