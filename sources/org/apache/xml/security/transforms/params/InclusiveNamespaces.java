package org.apache.xml.security.transforms.params;

import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import org.apache.xml.security.transforms.TransformParam;
import org.apache.xml.security.utils.ElementProxy;
import org.w3c.dom.Element;

public class InclusiveNamespaces extends ElementProxy implements TransformParam {
    public InclusiveNamespaces(Element element, String str) {
        super(element, str);
    }

    public static SortedSet a(String str) {
        TreeSet treeSet = new TreeSet();
        if (!(str == null || str.length() == 0)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\r\n");
            while (stringTokenizer.hasMoreTokens()) {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken.equals("#default")) {
                    nextToken = "xmlns";
                }
                treeSet.add(nextToken);
            }
        }
        return treeSet;
    }

    public String a() {
        return this.k.getAttributeNS((String) null, "PrefixList");
    }

    public String d() {
        return "http://www.w3.org/2001/10/xml-exc-c14n#";
    }

    public String e() {
        return "InclusiveNamespaces";
    }
}
