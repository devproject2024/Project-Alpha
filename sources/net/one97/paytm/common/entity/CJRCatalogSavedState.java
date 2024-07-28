package net.one97.paytm.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;

public class CJRCatalogSavedState implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRCatalogItem> catalogList;
    private CJRNode currentNode;
    private boolean isHome;
    private CJRCatalogItem mSelectedItem;

    public ArrayList<CJRCatalogItem> getCatalogList() {
        return this.catalogList;
    }

    public void setCatalogList(ArrayList<CJRCatalogItem> arrayList) {
        this.catalogList = arrayList;
    }

    public CJRNode getCurrentNode() {
        return this.currentNode;
    }

    public void setCurrentNode(CJRNode cJRNode) {
        this.currentNode = cJRNode;
    }

    public boolean isHome() {
        return this.isHome;
    }

    public void setHome(boolean z) {
        this.isHome = z;
    }

    public CJRCatalogItem getSelectedItem() {
        return this.mSelectedItem;
    }

    public void setSelectedItem(CJRCatalogItem cJRCatalogItem) {
        this.mSelectedItem = cJRCatalogItem;
    }
}
