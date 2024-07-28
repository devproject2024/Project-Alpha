package in.org.npci.commonlibrary.a;

import com.paytmmoney.lite.mod.util.PMConstants;
import java.io.StringReader;
import java.security.Key;
import java.security.PublicKey;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.xml.security.signature.XMLSignature;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class a {
    public static Document a(String str) {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(true);
        return newInstance.newDocumentBuilder().parse(new InputSource(new StringReader(str)));
    }

    public static boolean a(Document document, PublicKey publicKey) {
        NodeList elementsByTagNameNS = document.getElementsByTagNameNS("http://www.w3.org/2000/09/xmldsig#", PMConstants.SIGNATURE);
        if (elementsByTagNameNS.getLength() != 0) {
            return new XMLSignature((Element) elementsByTagNameNS.item(0), "").a((Key) publicKey);
        }
        throw new Exception("Signature not found");
    }
}
