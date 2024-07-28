package org.apache.xml.security.keys.content.keyvalues;

import org.apache.xml.security.utils.SignatureElementProxy;

public class DSAKeyValue extends SignatureElementProxy implements KeyValueContent {
    public String e() {
        return "DSAKeyValue";
    }
}
