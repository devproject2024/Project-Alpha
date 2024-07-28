package net.one97.travelpass.ordersummary.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class OrderSummaryFiled extends IJRPaytmDataModel {
    @b(a = "deepLink")
    private String deepLink;
    private String deepLinkText;
    @b(a = "icon")
    private String icon;
    @b(a = "isCopy")
    private Boolean isCopy;
    @b(a = "label")
    private String label;
    @b(a = "subContent")
    private String subContent;
    @b(a = "value")
    private String value;
    @b(a = "values")
    private List<a> values = null;

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public String getIcon() {
        return this.icon;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public List<a> getValues() {
        return this.values;
    }

    public void setValues(List<a> list) {
        this.values = list;
    }

    public Boolean getCopy() {
        return this.isCopy;
    }

    public void setCopy(Boolean bool) {
        this.isCopy = bool;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }

    public String getSubContent() {
        return this.subContent;
    }

    public void setSubContent(String str) {
        this.subContent = str;
    }

    public void setDeepLink(String str) {
        this.deepLink = str;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public String getDeepLinkText() {
        return this.deepLinkText;
    }

    public void setDeepLinkText(String str) {
        this.deepLinkText = str;
    }

    public class a {
        @b(a = "promoCode")

        /* renamed from: a  reason: collision with root package name */
        private String f30536a;
        @b(a = "isCopy")

        /* renamed from: b  reason: collision with root package name */
        private Boolean f30537b;

        public final String a() {
            return this.f30536a;
        }

        public final Boolean b() {
            return this.f30537b;
        }
    }
}
