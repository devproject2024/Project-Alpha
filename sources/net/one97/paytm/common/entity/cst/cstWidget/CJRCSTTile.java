package net.one97.paytm.common.entity.cst.cstWidget;

import com.google.gson.a.c;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRCSTTile implements IJRDataModel {
    @c(a = "dataType")
    private String dataType;
    @c(a = "displayOrder")
    private Integer displayOrder;
    @c(a = "metaData")
    private CJRCSTMetaData metaData;
    private final Long serialVersionUID = 1L;
    @c(a = "id")
    private String tileId;
    @c(a = "type")
    private String type;
    @c(a = "widget")
    private ArrayList<CJRCSTWidget> widget = null;

    public CJRCSTMetaData getMetaData() {
        return this.metaData;
    }

    public void setMetaData(CJRCSTMetaData cJRCSTMetaData) {
        this.metaData = cJRCSTMetaData;
    }

    public Long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public String getTileId() {
        return this.tileId;
    }

    public void setTileId(String str) {
        this.tileId = str;
    }

    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(Integer num) {
        this.displayOrder = num;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public ArrayList<CJRCSTWidget> getWidget() {
        return this.widget;
    }

    public void setWidget(ArrayList<CJRCSTWidget> arrayList) {
        this.widget = arrayList;
    }
}
