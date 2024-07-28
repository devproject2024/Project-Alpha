package com.alipay.mobile.h5container.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class H5EventFilter {
    private Set<String> actions = new HashSet();

    public void addAction(String str) {
        this.actions.add(str);
    }

    public void setEventsList(List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String add : list) {
                this.actions.add(add);
            }
        }
    }

    public Iterator<String> actionIterator() {
        return this.actions.iterator();
    }
}
