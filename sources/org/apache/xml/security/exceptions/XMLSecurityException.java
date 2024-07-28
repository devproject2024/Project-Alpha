package org.apache.xml.security.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import org.apache.xml.security.utils.I18n;

public class XMLSecurityException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    protected Exception f72618a;

    /* renamed from: b  reason: collision with root package name */
    protected String f72619b;

    public XMLSecurityException() {
        super("Missing message string");
        this.f72618a = null;
        this.f72619b = null;
        this.f72618a = null;
    }

    public XMLSecurityException(String str) {
        super(I18n.b(str));
        this.f72618a = null;
        this.f72619b = str;
        this.f72618a = null;
    }

    public XMLSecurityException(String str, Exception exc) {
        super(I18n.a(str, exc));
        this.f72618a = null;
        this.f72619b = str;
        this.f72618a = exc;
    }

    public XMLSecurityException(String str, Object[] objArr) {
        super(MessageFormat.format(I18n.b(str), objArr));
        this.f72618a = null;
        this.f72619b = str;
        this.f72618a = null;
    }

    public XMLSecurityException(String str, Object[] objArr, Exception exc) {
        super(MessageFormat.format(I18n.b(str), objArr));
        this.f72618a = null;
        this.f72619b = str;
        this.f72618a = exc;
    }

    public void printStackTrace() {
        synchronized (System.err) {
            super.printStackTrace(System.err);
            if (this.f72618a != null) {
                this.f72618a.printStackTrace(System.err);
            }
        }
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Exception exc = this.f72618a;
        if (exc != null) {
            exc.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Exception exc = this.f72618a;
        if (exc != null) {
            exc.printStackTrace(printWriter);
        }
    }

    public String toString() {
        String name = getClass().getName();
        String localizedMessage = super.getLocalizedMessage();
        if (localizedMessage != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(name);
            stringBuffer.append(": ");
            stringBuffer.append(localizedMessage);
            name = stringBuffer.toString();
        }
        if (this.f72618a == null) {
            return name;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(name);
        stringBuffer2.append("\nOriginal Exception was ");
        stringBuffer2.append(this.f72618a.toString());
        return stringBuffer2.toString();
    }
}
