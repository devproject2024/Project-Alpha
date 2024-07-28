package net.one97.paytm.feed.utility;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f35407a = new m();

    private m() {
    }

    public static Document a(String str) {
        k.c(str, "xml");
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(str));
            return newDocumentBuilder.parse(inputSource);
        } catch (ParserConfigurationException e2) {
            e2.getMessage();
            i.a();
            return null;
        } catch (SAXException e3) {
            e3.getMessage();
            i.a();
            return null;
        } catch (IOException e4) {
            e4.getMessage();
            i.a();
            return null;
        }
    }

    public static String a(Element element, String str) {
        k.c(element, "item");
        k.c(str, "str");
        Node item = element.getElementsByTagName(str).item(0);
        if (item == null || !item.hasChildNodes()) {
            return "";
        }
        for (Node firstChild = item.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 3) {
                String nodeValue = firstChild.getNodeValue();
                k.a((Object) nodeValue, "child!!.getNodeValue()");
                return nodeValue;
            }
        }
        return "";
    }

    public static String b(String str) {
        k.c(str, "url");
        String str2 = p.a((CharSequence) p.h((CharSequence) str).toString(), new String[]{"/"}).get(0);
        if (str2 != null) {
            return p.h((CharSequence) str2).toString();
        }
        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
