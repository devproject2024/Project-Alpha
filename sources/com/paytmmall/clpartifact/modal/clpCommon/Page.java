package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page implements Serializable {
    @c(a = "attributes")
    private Attributes mAttributes;
    @c(a = "id")
    private Long mId;
    @c(a = "layout")
    private String mLayout;
    @c(a = "layout_details")
    private LayoutDetails mLayoutDetails;
    @c(a = "views")
    private List<View> mViews;

    public static Page getDummyPage(String str) {
        Page page = new Page();
        page.mViews = new ArrayList();
        page.mViews.add(new View(str));
        return page;
    }

    public Attributes getAttributes() {
        return this.mAttributes;
    }

    public void setAttributes(Attributes attributes) {
        this.mAttributes = attributes;
    }

    public Long getId() {
        return this.mId;
    }

    public void setId(Long l) {
        this.mId = l;
    }

    public String getLayout() {
        return this.mLayout;
    }

    public void setLayout(String str) {
        this.mLayout = str;
    }

    public LayoutDetails getLayoutDetails() {
        return this.mLayoutDetails;
    }

    public void setLayoutDetails(LayoutDetails layoutDetails) {
        this.mLayoutDetails = layoutDetails;
    }

    public List<View> getViews() {
        return this.mViews;
    }

    public void setViews(List<View> list) {
        this.mViews = list;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Page) {
            return ((Page) obj).getViews().get(0).getType().equals(getViews().get(0).getType());
        }
        return false;
    }

    public int hashCode() {
        return getViews().get(0).getType().hashCode() + 21;
    }
}
