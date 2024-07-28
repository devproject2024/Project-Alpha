package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTHeader implements IJRDataModel {
    @c(a = "id")
    private String id;
    private final Long serialVersionUID = 1L;
    @c(a = "widget")
    private ArrayList<CJRCSTWidget> widget = null;

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public ArrayList<CJRCSTWidget> getWidget() {
        return this.widget;
    }

    public void setWidget(ArrayList<CJRCSTWidget> arrayList) {
        this.widget = arrayList;
    }
}
