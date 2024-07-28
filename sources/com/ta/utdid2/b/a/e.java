package com.ta.utdid2.b.a;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

final class e {
    public static final void a(Map map, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (map == null) {
            xmlSerializer.startTag((String) null, "null");
            xmlSerializer.endTag((String) null, "null");
            return;
        }
        xmlSerializer.startTag((String) null, Item.CTA_URL_TYPE_MAP);
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        for (Map.Entry entry : map.entrySet()) {
            a(entry.getValue(), (String) entry.getKey(), xmlSerializer);
        }
        xmlSerializer.endTag((String) null, Item.CTA_URL_TYPE_MAP);
    }

    private static void a(List list, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (list == null) {
            xmlSerializer.startTag((String) null, "null");
            xmlSerializer.endTag((String) null, "null");
            return;
        }
        xmlSerializer.startTag((String) null, "list");
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2), (String) null, xmlSerializer);
        }
        xmlSerializer.endTag((String) null, "list");
    }

    private static void a(byte[] bArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (bArr == null) {
            xmlSerializer.startTag((String) null, "null");
            xmlSerializer.endTag((String) null, "null");
            return;
        }
        xmlSerializer.startTag((String) null, "byte-array");
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        xmlSerializer.attribute((String) null, "num", Integer.toString(r8));
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            int i2 = b2 >> 4;
            sb.append(i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            byte b3 = b2 & 255;
            sb.append(b3 >= 10 ? (b3 + 97) - 10 : b3 + TarHeader.LF_NORMAL);
        }
        xmlSerializer.text(sb.toString());
        xmlSerializer.endTag((String) null, "byte-array");
    }

    private static void a(int[] iArr, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        if (iArr == null) {
            xmlSerializer.startTag((String) null, "null");
            xmlSerializer.endTag((String) null, "null");
            return;
        }
        xmlSerializer.startTag((String) null, "int-array");
        if (str != null) {
            xmlSerializer.attribute((String) null, "name", str);
        }
        xmlSerializer.attribute((String) null, "num", Integer.toString(r7));
        for (int num : iArr) {
            xmlSerializer.startTag((String) null, "item");
            xmlSerializer.attribute((String) null, "value", Integer.toString(num));
            xmlSerializer.endTag((String) null, "item");
        }
        xmlSerializer.endTag((String) null, "int-array");
    }

    private static void a(Object obj, String str, XmlSerializer xmlSerializer) throws XmlPullParserException, IOException {
        String str2;
        if (obj == null) {
            xmlSerializer.startTag((String) null, "null");
            if (str != null) {
                xmlSerializer.attribute((String) null, "name", str);
            }
            xmlSerializer.endTag((String) null, "null");
        } else if (obj instanceof String) {
            xmlSerializer.startTag((String) null, "string");
            if (str != null) {
                xmlSerializer.attribute((String) null, "name", str);
            }
            xmlSerializer.text(obj.toString());
            xmlSerializer.endTag((String) null, "string");
        } else {
            if (obj instanceof Integer) {
                str2 = "int";
            } else if (obj instanceof Long) {
                str2 = "long";
            } else if (obj instanceof Float) {
                str2 = "float";
            } else if (obj instanceof Double) {
                str2 = "double";
            } else if (obj instanceof Boolean) {
                str2 = "boolean";
            } else if (obj instanceof byte[]) {
                a((byte[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof int[]) {
                a((int[]) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof Map) {
                a((Map) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof List) {
                a((List) obj, str, xmlSerializer);
                return;
            } else if (obj instanceof CharSequence) {
                xmlSerializer.startTag((String) null, "string");
                if (str != null) {
                    xmlSerializer.attribute((String) null, "name", str);
                }
                xmlSerializer.text(obj.toString());
                xmlSerializer.endTag((String) null, "string");
                return;
            } else {
                throw new RuntimeException("writeValueXml: unable to write value ".concat(String.valueOf(obj)));
            }
            xmlSerializer.startTag((String) null, str2);
            if (str != null) {
                xmlSerializer.attribute((String) null, "name", str);
            }
            xmlSerializer.attribute((String) null, "value", obj.toString());
            xmlSerializer.endTag((String) null, str2);
        }
    }

    private static HashMap a(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        HashMap hashMap = new HashMap();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                Object b2 = b(xmlPullParser, strArr);
                if (strArr[0] != null) {
                    hashMap.put(strArr[0], b2);
                } else {
                    throw new XmlPullParserException("Map value without name attribute: " + xmlPullParser.getName());
                }
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return hashMap;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static ArrayList b(XmlPullParser xmlPullParser, String str, String[] strArr) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        int eventType = xmlPullParser.getEventType();
        do {
            if (eventType == 2) {
                arrayList.add(b(xmlPullParser, strArr));
            } else if (eventType == 3) {
                if (xmlPullParser.getName().equals(str)) {
                    return arrayList;
                }
                throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
            }
            eventType = xmlPullParser.next();
        } while (eventType != 1);
        throw new XmlPullParserException("Document ended before " + str + " end tag");
    }

    private static int[] a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        try {
            int[] iArr = new int[Integer.parseInt(xmlPullParser.getAttributeValue((String) null, "num"))];
            int i2 = 0;
            int eventType = xmlPullParser.getEventType();
            do {
                if (eventType == 2) {
                    if (xmlPullParser.getName().equals("item")) {
                        try {
                            iArr[i2] = Integer.parseInt(xmlPullParser.getAttributeValue((String) null, "value"));
                        } catch (NullPointerException unused) {
                            throw new XmlPullParserException("Need value attribute in item");
                        } catch (NumberFormatException unused2) {
                            throw new XmlPullParserException("Not a number in value attribute in item");
                        }
                    } else {
                        throw new XmlPullParserException("Expected item tag at: " + xmlPullParser.getName());
                    }
                } else if (eventType == 3) {
                    if (xmlPullParser.getName().equals(str)) {
                        return iArr;
                    }
                    if (xmlPullParser.getName().equals("item")) {
                        i2++;
                    } else {
                        throw new XmlPullParserException("Expected " + str + " end tag at: " + xmlPullParser.getName());
                    }
                }
                eventType = xmlPullParser.next();
            } while (eventType != 1);
            throw new XmlPullParserException("Document ended before " + str + " end tag");
        } catch (NullPointerException unused3) {
            throw new XmlPullParserException("Need num attribute in byte-array");
        } catch (NumberFormatException unused4) {
            throw new XmlPullParserException("Not a number in num attribute in byte-array");
        }
    }

    public static final Object a(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 2) {
            if (eventType == 3) {
                throw new XmlPullParserException("Unexpected end tag at: " + xmlPullParser.getName());
            } else if (eventType != 4) {
                try {
                    eventType = xmlPullParser.next();
                    if (eventType == 1) {
                        throw new XmlPullParserException("Unexpected end of document");
                    }
                } catch (Exception unused) {
                    throw new XmlPullParserException("Unexpected call next(): " + xmlPullParser.getName());
                }
            } else {
                throw new XmlPullParserException("Unexpected text: " + xmlPullParser.getText());
            }
        }
        return b(xmlPullParser, strArr);
    }

    private static final Object b(XmlPullParser xmlPullParser, String[] strArr) throws XmlPullParserException, IOException {
        int next;
        Object d2;
        Object obj = null;
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "name");
        String name = xmlPullParser.getName();
        if (!name.equals("null")) {
            if (name.equals("string")) {
                String str = "";
                while (true) {
                    int next2 = xmlPullParser.next();
                    if (next2 == 1) {
                        throw new XmlPullParserException("Unexpected end of document in <string>");
                    } else if (next2 == 3) {
                        if (xmlPullParser.getName().equals("string")) {
                            strArr[0] = attributeValue;
                            return str;
                        }
                        throw new XmlPullParserException("Unexpected end tag in <string>: " + xmlPullParser.getName());
                    } else if (next2 == 4) {
                        str = String.valueOf(str) + xmlPullParser.getText();
                    } else if (next2 == 2) {
                        throw new XmlPullParserException("Unexpected start tag in <string>: " + xmlPullParser.getName());
                    }
                }
            } else if (name.equals("int")) {
                obj = Integer.valueOf(Integer.parseInt(xmlPullParser.getAttributeValue((String) null, "value")));
            } else if (name.equals("long")) {
                obj = Long.valueOf(xmlPullParser.getAttributeValue((String) null, "value"));
            } else {
                if (name.equals("float")) {
                    d2 = new Float(xmlPullParser.getAttributeValue((String) null, "value"));
                } else if (name.equals("double")) {
                    d2 = new Double(xmlPullParser.getAttributeValue((String) null, "value"));
                } else if (name.equals("boolean")) {
                    obj = Boolean.valueOf(xmlPullParser.getAttributeValue((String) null, "value"));
                } else if (name.equals("int-array")) {
                    xmlPullParser.next();
                    int[] a2 = a(xmlPullParser, "int-array");
                    strArr[0] = attributeValue;
                    return a2;
                } else if (name.equals(Item.CTA_URL_TYPE_MAP)) {
                    xmlPullParser.next();
                    HashMap a3 = a(xmlPullParser, Item.CTA_URL_TYPE_MAP, strArr);
                    strArr[0] = attributeValue;
                    return a3;
                } else if (name.equals("list")) {
                    xmlPullParser.next();
                    ArrayList b2 = b(xmlPullParser, "list", strArr);
                    strArr[0] = attributeValue;
                    return b2;
                } else {
                    throw new XmlPullParserException("Unknown tag: ".concat(String.valueOf(name)));
                }
                obj = d2;
            }
        }
        do {
            next = xmlPullParser.next();
            if (next == 1) {
                throw new XmlPullParserException("Unexpected end of document in <" + name + SimpleComparison.GREATER_THAN_OPERATION);
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(name)) {
                    strArr[0] = attributeValue;
                    return obj;
                }
                throw new XmlPullParserException("Unexpected end tag in <" + name + ">: " + xmlPullParser.getName());
            } else if (next == 4) {
                throw new XmlPullParserException("Unexpected text in <" + name + ">: " + xmlPullParser.getName());
            }
        } while (next != 2);
        throw new XmlPullParserException("Unexpected start tag in <" + name + ">: " + xmlPullParser.getName());
    }
}
