package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTWidgetTemplateResponse implements IJRDataModel {
    @b(a = "pageType")
    private String pageType;
    private final Long serialVersionUID = 1L;
    @b(a = "template")
    private List<CJRCSTTemplate> template;

    public Long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public List<CJRCSTTemplate> getTemplate() {
        return this.template;
    }

    public void setTemplate(List<CJRCSTTemplate> list) {
        this.template = list;
    }

    public String getPageType() {
        return this.pageType;
    }

    public void setPageType(String str) {
        this.pageType = str;
    }
}
