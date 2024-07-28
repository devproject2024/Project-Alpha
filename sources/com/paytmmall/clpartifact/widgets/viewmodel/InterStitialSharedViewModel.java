package com.paytmmall.clpartifact.widgets.viewmodel;

import androidx.lifecycle.ai;
import java.util.HashSet;

public class InterStitialSharedViewModel extends ai {
    HashSet<String> interStitialIdMap = new HashSet<>();

    public boolean isUniqueWidget(String str) {
        return !this.interStitialIdMap.contains(str);
    }

    public void setItemId(String str) {
        this.interStitialIdMap.add(str);
    }
}
