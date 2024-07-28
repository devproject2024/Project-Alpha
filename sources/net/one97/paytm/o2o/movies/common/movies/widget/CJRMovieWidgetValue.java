package net.one97.paytm.o2o.movies.common.movies.widget;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRMovieWidgetValue implements IJRDataModel {
    @b(a = "Header")
    private String header;
    @b(a = "Text")
    private String text;

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String str) {
        this.header = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }
}
