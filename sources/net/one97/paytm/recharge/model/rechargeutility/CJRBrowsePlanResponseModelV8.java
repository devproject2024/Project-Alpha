package net.one97.paytm.recharge.model.rechargeutility;

import com.google.gson.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBrowsePlanResponseModelV8 extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "bottomStripUtilities")
    @a
    private List<Object> bottomStripUtilities = null;
    @b(a = "categoryHeader")
    @a
    private String categoryHeader;
    @b(a = "dealsFastForward")
    @a
    private Integer dealsFastForward;
    @b(a = "description")
    @a
    private String description;
    @b(a = "disclaimer")
    @a
    private String disclaimer;
    @b(a = "disclaimerHtml")
    @a
    private String disclaimerHtml;
    @b(a = "displayName")
    @a
    private String displayName;
    @b(a = "fastForwardText")
    @a
    private String fastForwardText;
    @b(a = "gaKey")
    @a
    private String gaKey;
    @b(a = "groupings")
    @a
    private List<CJRBowsePlanGroupingListV8> groupings = null;
    @b(a = "inputFields")
    @a
    private List<Object> inputFields = null;
    @b(a = "recentsPrefill")
    @a
    private Integer recentsPrefill;
    @b(a = "showFastForward")
    @a
    private Integer showFastForward;
    @b(a = "showHelp")
    @a
    private Integer showHelp;
    @b(a = "showUpgrade")
    @a
    private Integer showUpgrade;
    @b(a = "skipDeals")
    @a
    private Integer skipDeals;
    @b(a = "staticForm")
    @a
    private Integer staticForm;
    @b(a = "verticalId")
    @a
    private Integer verticalId;

    public List<Object> getBottomStripUtilities() {
        return this.bottomStripUtilities;
    }

    public void setBottomStripUtilities(List<Object> list) {
        this.bottomStripUtilities = list;
    }

    public Integer getShowFastForward() {
        return this.showFastForward;
    }

    public void setShowFastForward(Integer num) {
        this.showFastForward = num;
    }

    public Integer getShowUpgrade() {
        return this.showUpgrade;
    }

    public void setShowUpgrade(Integer num) {
        this.showUpgrade = num;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public String getDisclaimerHtml() {
        return this.disclaimerHtml;
    }

    public void setDisclaimerHtml(String str) {
        this.disclaimerHtml = str;
    }

    public List<Object> getInputFields() {
        return this.inputFields;
    }

    public void setInputFields(List<Object> list) {
        this.inputFields = list;
    }

    public String getFastForwardText() {
        return this.fastForwardText;
    }

    public void setFastForwardText(String str) {
        this.fastForwardText = str;
    }

    public Integer getShowHelp() {
        return this.showHelp;
    }

    public void setShowHelp(Integer num) {
        this.showHelp = num;
    }

    public Integer getRecentsPrefill() {
        return this.recentsPrefill;
    }

    public void setRecentsPrefill(Integer num) {
        this.recentsPrefill = num;
    }

    public Integer getSkipDeals() {
        return this.skipDeals;
    }

    public void setSkipDeals(Integer num) {
        this.skipDeals = num;
    }

    public String getDisclaimer() {
        return this.disclaimer;
    }

    public void setDisclaimer(String str) {
        this.disclaimer = str;
    }

    public String getCategoryHeader() {
        return this.categoryHeader;
    }

    public void setCategoryHeader(String str) {
        this.categoryHeader = str;
    }

    public Integer getDealsFastForward() {
        return this.dealsFastForward;
    }

    public void setDealsFastForward(Integer num) {
        this.dealsFastForward = num;
    }

    public Integer getVerticalId() {
        return this.verticalId;
    }

    public void setVerticalId(Integer num) {
        this.verticalId = num;
    }

    public Integer getStaticForm() {
        return this.staticForm;
    }

    public void setStaticForm(Integer num) {
        this.staticForm = num;
    }

    public List<CJRBowsePlanGroupingListV8> getGroupings() {
        return this.groupings;
    }

    public void setGroupings(List<CJRBowsePlanGroupingListV8> list) {
        this.groupings = list;
    }

    public String getGaKey() {
        return this.gaKey;
    }

    public void setGaKey(String str) {
        this.gaKey = str;
    }
}
