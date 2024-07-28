package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTTemplate implements IJRDataModel {
    @b(a = "card")
    private ArrayList<CJRCSTCard> card = null;
    @b(a = "dataType")
    private String dataType;
    @b(a = "displayOrder")
    private Integer displayOrder;
    @b(a = "header")
    private CJRCSTHeader header = null;
    @b(a = "metaData")
    private CJRCSTMetaData metaData;
    private final Long serialVersionUID = 1L;
    @b(a = "id")
    private String templateId;
    @b(a = "tile")
    private List<CJRCSTTile> tile = null;
    @b(a = "type")
    private String type;

    public List<CJRCSTTile> getTile() {
        return this.tile;
    }

    public void setTile(List<CJRCSTTile> list) {
        this.tile = list;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(Integer num) {
        this.displayOrder = num;
    }

    public CJRCSTHeader getHeader() {
        return this.header;
    }

    public void setHeader(CJRCSTHeader cJRCSTHeader) {
        this.header = cJRCSTHeader;
    }

    public String getDataType() {
        return this.dataType;
    }

    public void setDataType(String str) {
        this.dataType = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public Long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public CJRCSTMetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(CJRCSTMetaData cJRCSTMetaData) {
        this.metaData = cJRCSTMetaData;
    }

    public String getTemplateId() {
        return this.templateId;
    }

    public void setTemplateId(String str) {
        this.templateId = str;
    }

    public ArrayList<CJRCSTCard> getCard() {
        return this.card;
    }

    public void setCard(ArrayList<CJRCSTCard> arrayList) {
        this.card = arrayList;
    }
}
