package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.cst.CJRCSTRaiseIssue;

public class CJRCSTWidgetResponse extends IJRPaytmDataModel {
    @b(a = "nodes")
    private List<CJRCSTRaiseIssue> nodes;
    @b(a = "response")
    private CJRCSTWidgetTemplateResponse response;
    private final Long serialVersionUID = 1L;
    @b(a = "template")
    private List<CJRCSTTemplate> template;

    public List<CJRCSTTemplate> getTemplate() {
        return this.template;
    }

    public void setTemplate(List<CJRCSTTemplate> list) {
        this.template = list;
    }

    public List<CJRCSTRaiseIssue> getNodes() {
        return this.nodes;
    }

    public void setNodes(List<CJRCSTRaiseIssue> list) {
        this.nodes = list;
    }

    public CJRCSTWidgetTemplateResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRCSTWidgetTemplateResponse cJRCSTWidgetTemplateResponse) {
        this.response = cJRCSTWidgetTemplateResponse;
    }
}
