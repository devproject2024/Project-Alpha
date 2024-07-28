package org.apache.xml.security.keys.content.keyvalues;

import org.apache.xml.security.utils.SignatureElementProxy;

public class RSAKeyValue extends SignatureElementProxy implements KeyValueContent {
    public String e() {
        return "RSAKeyValue";
    }
}
