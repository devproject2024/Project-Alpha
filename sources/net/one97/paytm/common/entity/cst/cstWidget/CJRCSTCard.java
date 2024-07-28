package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTCard implements IJRDataModel {
    @b(a = "id")
    private String cardId;
    @b(a = "dataType")
    private String dataType;
    @b(a = "displayOrder")
    private Integer displayOrder;
    @b(a = "header")
    private CJRCSTHeader header = null;
    @b(a = "metaData")
    private CJRCSTMetaData metaData;
    @b(a = "resourceUrl")
    private String resourceUrl;
    private final Long serialVersionUID = 1L;
    @b(a = "tile")
    private List<CJRCSTTile> tile = null;
    @b(a = "type")
    private String type;

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

    public CJRCSTMetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(CJRCSTMetaData cJRCSTMetaData) {
        this.metaData = cJRCSTMetaData;
    }

    public String getResourceUrl() {
        return this.resourceUrl;
    }

    public void setResourceUrl(String str) {
        this.resourceUrl = str;
    }

    public CJRCSTHeader getHeader() {
        return this.header;
    }

    public void setHeader(CJRCSTHeader cJRCSTHeader) {
        this.header = cJRCSTHeader;
    }

    public Long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public String getCardId() {
        return this.cardId;
    }

    public void setCardId(String str) {
        this.cardId = str;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(Integer num) {
        this.displayOrder = num;
    }

    public List<CJRCSTTile> getTile() {
        return this.tile;
    }

    public void setTile(List<CJRCSTTile> list) {
        this.tile = list;
    }
}
