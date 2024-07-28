package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gson.a.c;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTWidget implements IJRDataModel {
    @c(a = "dataType")
    private String data;
    @c(a = "displayOrder")
    private Integer displayOrder;
    @c(a = "font")
    private String font;
    @c(a = "fontSize")
    private String fontSize;
    @c(a = "fontStyle")
    private String fontStyle;
    @c(a = "link")
    private String link;
    @c(a = "metaData")
    private CJRCSTMetaData metaData;
    @c(a = "name")
    private String name;
    private final Long serialVersionUID = 1L;
    @c(a = "text")
    private String text;
    @c(a = "type")
    private String type;
    @c(a = "uri")
    private String uri;
    @c(a = "id")
    private String widgetId;

    public Long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public String getWidgetId() {
        return this.widgetId;
    }

    public void setWidgetId(String str) {
        this.widgetId = str;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public String getFont() {
        return this.font;
    }

    public void setFont(String str) {
        this.font = str;
    }

    public String getFontStyle() {
        return this.fontStyle;
    }

    public void setFontStyle(String str) {
        this.fontStyle = str;
    }

    public String getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(String str) {
        this.fontSize = str;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(Integer num) {
        this.displayOrder = num;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public CJRCSTMetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(CJRCSTMetaData cJRCSTMetaData) {
        this.metaData = cJRCSTMetaData;
    }
}
