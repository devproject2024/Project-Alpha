package org.apache.xml.security.transforms.implementations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.apache.xml.security.c14n.CanonicalizationException;
import org.apache.xml.security.c14n.InvalidCanonicalizerException;
import org.apache.xml.security.exceptions.XMLSecurityException;
import org.apache.xml.security.signature.NodeFilter;
import org.apache.xml.security.signature.XMLSignatureInput;
import org.apache.xml.security.transforms.Transform;
import org.apache.xml.security.transforms.TransformSpi;
import org.apache.xml.security.transforms.TransformationException;
import org.apache.xml.security.transforms.params.XPath2FilterContainer;
import org.apache.xml.security.utils.CachedXPathAPIHolder;
import org.apache.xml.security.utils.CachedXPathFuncHereAPI;
import org.apache.xml.security.utils.XMLUtils;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TransformXPath2Filter extends TransformSpi {
    static Set a(List list) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < list.size(); i2++) {
            NodeList nodeList = (NodeList) list.get(i2);
            int length = nodeList.getLength();
            for (int i3 = 0; i3 < length; i3++) {
                hashSet.add(nodeList.item(i3));
            }
        }
        return hashSet;
    }

    public XMLSignatureInput a(XMLSignatureInput xMLSignatureInput, Transform transform) {
        XMLSignatureInput xMLSignatureInput2 = xMLSignatureInput;
        CachedXPathAPIHolder.a(transform.k().getOwnerDocument());
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            CachedXPathFuncHereAPI cachedXPathFuncHereAPI = new CachedXPathFuncHereAPI(CachedXPathAPIHolder.a());
            int length = XMLUtils.a(transform.k().getFirstChild(), "http://www.w3.org/2002/06/xmldsig-filter2", "XPath").length;
            if (length != 0) {
                Document b2 = xMLSignatureInput.m() != null ? XMLUtils.b(xMLSignatureInput.m()) : XMLUtils.a(xMLSignatureInput.b());
                for (int i2 = 0; i2 < length; i2++) {
                    XPath2FilterContainer a2 = XPath2FilterContainer.a(XMLUtils.a(transform.k().getFirstChild(), "http://www.w3.org/2002/06/xmldsig-filter2", "XPath", i2), xMLSignatureInput.k());
                    NodeList a3 = cachedXPathFuncHereAPI.a((Node) b2, a2.f(), CachedXPathFuncHereAPI.a(a2.f()), (Node) a2.k());
                    if (a2.a()) {
                        arrayList3.add(a3);
                    } else if (a2.b()) {
                        arrayList2.add(a3);
                    } else if (a2.c()) {
                        arrayList.add(a3);
                    }
                }
                xMLSignatureInput2.a((NodeFilter) new XPath2NodeFilter(a(arrayList), a(arrayList2), a(arrayList3)));
                xMLSignatureInput2.d(true);
                return xMLSignatureInput2;
            }
            throw new TransformationException("xml.WrongContent", new Object[]{"http://www.w3.org/2002/06/xmldsig-filter2", "XPath"});
        } catch (TransformerException e2) {
            throw new TransformationException("empty", (Exception) e2);
        } catch (DOMException e3) {
            throw new TransformationException("empty", (Exception) e3);
        } catch (CanonicalizationException e4) {
            throw new TransformationException("empty", (Exception) e4);
        } catch (InvalidCanonicalizerException e5) {
            throw new TransformationException("empty", (Exception) e5);
        } catch (XMLSecurityException e6) {
            throw new TransformationException("empty", (Exception) e6);
        } catch (SAXException e7) {
            throw new TransformationException("empty", (Exception) e7);
        } catch (IOException e8) {
            throw new TransformationException("empty", (Exception) e8);
        } catch (ParserConfigurationException e9) {
            throw new TransformationException("empty", (Exception) e9);
        }
    }
}
