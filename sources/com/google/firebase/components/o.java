package com.google.firebase.components;

import java.util.Arrays;
import java.util.List;

public final class o extends p {
    private final List<b<?>> componentsInCycle;

    public o(List<b<?>> list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.componentsInCycle = list;
    }

    public final List<b<?>> getComponentsInCycle() {
        return this.componentsInCycle;
    }
}
