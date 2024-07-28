package org.apache.xml.security.c14n.helper;

import java.io.Serializable;
import java.util.Comparator;
import org.w3c.dom.Attr;

public class AttrCompare implements Serializable, Comparator {
    public int compare(Object obj, Object obj2) {
        String localName;
        String localName2;
        Attr attr = (Attr) obj;
        Attr attr2 = (Attr) obj2;
        String namespaceURI = attr.getNamespaceURI();
        String namespaceURI2 = attr2.getNamespaceURI();
        boolean equals = "http://www.w3.org/2000/xmlns/".equals(namespaceURI);
        boolean equals2 = "http://www.w3.org/2000/xmlns/".equals(namespaceURI2);
        if (equals) {
            if (!equals2) {
                return -1;
            }
            String localName3 = attr.getLocalName();
            String localName4 = attr2.getLocalName();
            if ("xmlns".equals(localName3)) {
                localName3 = "";
            }
            if ("xmlns".equals(localName4)) {
                localName4 = "";
            }
            return localName3.compareTo(localName4);
        } else if (equals2) {
            return 1;
        } else {
            if (namespaceURI == null) {
                if (namespaceURI2 != null) {
                    return -1;
                }
                localName = attr.getName();
                localName2 = attr2.getName();
            } else if (namespaceURI2 == null) {
                return 1;
            } else {
                int compareTo = namespaceURI.compareTo(namespaceURI2);
                if (compareTo != 0) {
                    return compareTo;
                }
                localName = attr.getLocalName();
                localName2 = attr2.getLocalName();
            }
            return localName.compareTo(localName2);
        }
    }
}
