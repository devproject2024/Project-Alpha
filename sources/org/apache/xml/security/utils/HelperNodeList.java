package org.apache.xml.security.utils;

import java.util.ArrayList;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class HelperNodeList implements NodeList {

    /* renamed from: a  reason: collision with root package name */
    ArrayList f72762a;

    /* renamed from: b  reason: collision with root package name */
    boolean f72763b;

    public HelperNodeList() {
        this(false);
    }

    public HelperNodeList(boolean z) {
        this.f72762a = new ArrayList(20);
        this.f72763b = false;
        this.f72763b = z;
    }

    public int getLength() {
        return this.f72762a.size();
    }

    public Node item(int i2) {
        return (Node) this.f72762a.get(i2);
    }
}
