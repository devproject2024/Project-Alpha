package net.one97.paytm.common.entity;

import java.io.Serializable;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJRCatalogItem;

public class CJRNode implements Serializable {
    private static final long serialVersionUID = 1;
    private ArrayList<CJRCatalogItem> mCatalogList;
    private String mHeader;
    private CJRNode mNextNode;
    private CJRCatalogItem mParent;
    private CJRNode mPreviousNode;
    private CJRCatalogItem mSelectedItem;

    public CJRCatalogItem getSelectedItem() {
        return this.mSelectedItem;
    }

    public void setSelectedItem(CJRCatalogItem cJRCatalogItem) {
        this.mSelectedItem = cJRCatalogItem;
    }

    public CJRNode(CJRNode cJRNode, ArrayList<CJRCatalogItem> arrayList, CJRNode cJRNode2, CJRCatalogItem cJRCatalogItem) {
        this.mPreviousNode = cJRNode;
        this.mCatalogList = arrayList;
        this.mNextNode = cJRNode2;
        this.mParent = cJRCatalogItem;
    }

    public CJRCatalogItem getParent() {
        return this.mParent;
    }

    public void setParent(CJRCatalogItem cJRCatalogItem) {
        this.mParent = cJRCatalogItem;
    }

    public void setPreviousNode(CJRNode cJRNode) {
        this.mPreviousNode = cJRNode;
    }

    public void setNextNode(CJRNode cJRNode) {
        this.mNextNode = cJRNode;
    }

    public CJRNode getPreviousNode() {
        return this.mPreviousNode;
    }

    public CJRNode getNextNode() {
        return this.mNextNode;
    }

    public ArrayList<CJRCatalogItem> getCatalogList() {
        return this.mCatalogList;
    }

    public void setCatalogList(ArrayList<CJRCatalogItem> arrayList) {
        this.mCatalogList = arrayList;
    }

    public void setHeader(String str) {
        this.mHeader = str;
    }

    public String getHeader() {
        return this.mHeader;
    }
}
