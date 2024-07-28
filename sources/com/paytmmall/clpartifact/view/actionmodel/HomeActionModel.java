package com.paytmmall.clpartifact.view.actionmodel;

import java.util.Map;
import kotlin.g.b.k;

public final class HomeActionModel implements IActionModel {
    private final Map<String, Object> actionData;
    private final int actionType;

    public HomeActionModel(int i2, Map<String, ? extends Object> map) {
        k.c(map, "actionData");
        this.actionType = i2;
        this.actionData = map;
    }

    public final Map<String, Object> getActionData() {
        return this.actionData;
    }

    public final int getActionType() {
        return this.actionType;
    }
}
