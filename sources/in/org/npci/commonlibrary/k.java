package in.org.npci.commonlibrary;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.npci.upi.security.pinactivitycomponent.CLConstants;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class k extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    private static List f46368a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static j f46369b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f46370c = null;

    public k() {
    }

    public k(String str) {
        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new InputSource(new StringReader(str)), this);
        } catch (IOException | ParserConfigurationException | SAXException unused) {
            throw new f(g.PARSER_MISCONFIG);
        }
    }

    public List a() {
        return f46368a;
    }

    public void characters(char[] cArr, int i2, int i3) {
        f46370c = String.copyValueOf(cArr, i2, i3).trim();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void endElement(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
        /*
            r1 = this;
            int r2 = r4.hashCode()
            r3 = 106079(0x19e5f, float:1.48648E-40)
            r0 = 1
            if (r2 == r3) goto L_0x001a
            r3 = 492250706(0x1d572652, float:2.8474824E-21)
            if (r2 == r3) goto L_0x0010
            goto L_0x0024
        L_0x0010:
            java.lang.String r2 = "keyValue"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0024
            r2 = 1
            goto L_0x0025
        L_0x001a:
            java.lang.String r2 = "key"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x0024
            r2 = 0
            goto L_0x0025
        L_0x0024:
            r2 = -1
        L_0x0025:
            if (r2 == 0) goto L_0x0032
            if (r2 == r0) goto L_0x002a
            goto L_0x0031
        L_0x002a:
            in.org.npci.commonlibrary.j r2 = f46369b
            java.lang.String r3 = f46370c
            r2.c(r3)
        L_0x0031:
            return
        L_0x0032:
            java.util.List r2 = f46368a
            in.org.npci.commonlibrary.j r3 = f46369b
            r2.add(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: in.org.npci.commonlibrary.k.endElement(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        System.out.println("KeyParser Destroyed");
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) {
        if (((str3.hashCode() == 106079 && str3.equals("key")) ? (char) 0 : 65535) == 0) {
            j jVar = new j();
            f46369b = jVar;
            jVar.a(attributes.getValue(CLConstants.FIELD_KI));
            f46369b.b(attributes.getValue("owner"));
        }
    }
}
