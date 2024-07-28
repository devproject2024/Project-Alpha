package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import java.util.List;
import kotlin.g.b.k;

public final class DataViewModel extends ai {
    private final y<String> dataToShow = new y<>();
    private boolean isHtmlText;
    private final y<List<String>> recyclerListData = new y<>();
    private boolean shouldHideBlueDot;
    private boolean showClose;
    private boolean showRecyclerViewList;
    private String title = "";

    public final y<String> getDataToShow() {
        return this.dataToShow;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        k.c(str, "<set-?>");
        this.title = str;
    }

    public final boolean getShowClose() {
        return this.showClose;
    }

    public final void setShowClose(boolean z) {
        this.showClose = z;
    }

    public final boolean getShowRecyclerViewList() {
        return this.showRecyclerViewList;
    }

    public final void setShowRecyclerViewList(boolean z) {
        this.showRecyclerViewList = z;
    }

    public final boolean getShouldHideBlueDot() {
        return this.shouldHideBlueDot;
    }

    public final void setShouldHideBlueDot(boolean z) {
        this.shouldHideBlueDot = z;
    }

    public final boolean isHtmlText() {
        return this.isHtmlText;
    }

    public final void setHtmlText(boolean z) {
        this.isHtmlText = z;
    }

    public final y<List<String>> getRecyclerListData() {
        return this.recyclerListData;
    }
}
