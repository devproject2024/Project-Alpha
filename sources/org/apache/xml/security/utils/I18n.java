package org.apache.xml.security.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.xml.security.Init;

public class I18n {

    /* renamed from: a  reason: collision with root package name */
    static String f72764a = null;

    /* renamed from: b  reason: collision with root package name */
    static String f72765b = null;

    /* renamed from: c  reason: collision with root package name */
    static ResourceBundle f72766c = null;

    /* renamed from: d  reason: collision with root package name */
    static boolean f72767d = false;

    /* renamed from: e  reason: collision with root package name */
    static String f72768e;

    /* renamed from: f  reason: collision with root package name */
    static String f72769f;

    private I18n() {
    }

    public static String a(String str) {
        return b(str);
    }

    public static String a(String str, Exception exc) {
        try {
            return MessageFormat.format(f72766c.getString(str), new Object[]{exc.getMessage()});
        } catch (Throwable unused) {
            if (!Init.a()) {
                return "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
            }
            StringBuffer stringBuffer = new StringBuffer("No message with ID \"");
            stringBuffer.append(str);
            stringBuffer.append("\" found in resource bundle \"org/apache/xml/security/resource/xmlsecurity\". Original Exception was a ");
            stringBuffer.append(exc.getClass().getName());
            stringBuffer.append(" and message ");
            stringBuffer.append(exc.getMessage());
            return stringBuffer.toString();
        }
    }

    public static String a(String str, Object[] objArr) {
        return b(str, objArr);
    }

    public static void a(String str, String str2) {
        f72764a = str;
        if (str == null) {
            f72764a = Locale.getDefault().getLanguage();
        }
        f72765b = str2;
        if (str2 == null) {
            f72765b = Locale.getDefault().getCountry();
        }
        b(f72764a, f72765b);
    }

    public static String b(String str) {
        try {
            return f72766c.getString(str);
        } catch (Throwable unused) {
            if (!Init.a()) {
                return "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
            }
            StringBuffer stringBuffer = new StringBuffer("No message with ID \"");
            stringBuffer.append(str);
            stringBuffer.append("\" found in resource bundle \"org/apache/xml/security/resource/xmlsecurity\"");
            return stringBuffer.toString();
        }
    }

    public static String b(String str, Object[] objArr) {
        try {
            return MessageFormat.format(f72766c.getString(str), objArr);
        } catch (Throwable unused) {
            if (!Init.a()) {
                return "You must initialize the xml-security library correctly before you use it. Call the static method \"org.apache.xml.security.Init.init();\" to do that before you use any functionality from that library.";
            }
            StringBuffer stringBuffer = new StringBuffer("No message with ID \"");
            stringBuffer.append(str);
            stringBuffer.append("\" found in resource bundle \"org/apache/xml/security/resource/xmlsecurity\"");
            return stringBuffer.toString();
        }
    }

    public static void b(String str, String str2) {
        if (!f72767d || !str.equals(f72768e) || !str2.equals(f72769f)) {
            if (str == null || str2 == null || str.length() <= 0 || str2.length() <= 0) {
                f72769f = f72765b;
                f72768e = f72764a;
            } else {
                f72768e = str;
                f72769f = str2;
            }
            f72766c = ResourceBundle.getBundle("org/apache/xml/security/resource/xmlsecurity", new Locale(f72768e, f72769f));
        }
    }
}
