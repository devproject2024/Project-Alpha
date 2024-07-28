package org.apache.xml.security.utils.resolver.implementations;

import com.alipay.iap.android.webapp.sdk.provider.BaseJSApiPermissionProvider;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.utils.resolver.ResourceResolverException;
import org.apache.xml.security.utils.resolver.ResourceResolverSpi;
import org.apache.xml.utils.URI;
import org.w3c.dom.Attr;

public class ResolverLocalFilesystem extends ResourceResolverSpi {

    /* renamed from: d  reason: collision with root package name */
    static Log f72815d;

    /* renamed from: e  reason: collision with root package name */
    static Class f72816e;

    /* renamed from: f  reason: collision with root package name */
    private static int f72817f = 6;

    static {
        Class cls = f72816e;
        if (cls == null) {
            cls = c("org.apache.xml.security.utils.resolver.implementations.ResolverLocalFilesystem");
            f72816e = cls;
        }
        f72815d = LogFactory.getLog(cls.getName());
    }

    private static URI a(String str, String str2) {
        return (str2 == null || "".equals(str2)) ? new URI(str) : new URI(new URI(str2), str);
    }

    static Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static String d(String str) {
        int indexOf;
        String substring = str.substring(f72817f);
        if (substring.indexOf("%20") >= 0) {
            int i2 = 0;
            StringBuffer stringBuffer = new StringBuffer(substring.length());
            do {
                indexOf = substring.indexOf("%20", i2);
                if (indexOf == -1) {
                    stringBuffer.append(substring.substring(i2));
                    continue;
                } else {
                    stringBuffer.append(substring.substring(i2, indexOf));
                    stringBuffer.append(' ');
                    i2 = indexOf + 3;
                    continue;
                }
            } while (indexOf != -1);
            substring = stringBuffer.toString();
        }
        return substring.charAt(1) == ':' ? substring : "/".concat(String.valueOf(substring));
    }

    public XMLSignatureInput a(Attr attr, String str) {
        try {
            URI a2 = a(attr.getNodeValue(), str);
            URI uri = new URI(a2);
            uri.setFragment((String) null);
            XMLSignatureInput xMLSignatureInput = new XMLSignatureInput((InputStream) new FileInputStream(d(uri.toString())));
            xMLSignatureInput.b(a2.toString());
            return xMLSignatureInput;
        } catch (Exception e2) {
            throw new ResourceResolverException("generic.EmptyMessage", e2, attr, str);
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b(Attr attr, String str) {
        if (attr == null) {
            return false;
        }
        String nodeValue = attr.getNodeValue();
        if (!nodeValue.equals("") && nodeValue.charAt(0) != '#' && !nodeValue.startsWith(BaseJSApiPermissionProvider.PROTOCOL_HTTP)) {
            try {
                if (f72815d.isDebugEnabled()) {
                    f72815d.debug("I was asked whether I can resolve ".concat(String.valueOf(nodeValue)));
                }
                if (nodeValue.startsWith("file:") || str.startsWith("file:")) {
                    if (!f72815d.isDebugEnabled()) {
                        return true;
                    }
                    f72815d.debug("I state that I can resolve ".concat(String.valueOf(nodeValue)));
                    return true;
                }
            } catch (Exception unused) {
            }
            f72815d.debug("But I can't");
        }
        return false;
    }
}
