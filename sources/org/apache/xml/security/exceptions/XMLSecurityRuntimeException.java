package org.apache.xml.security.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.MessageFormat;
import org.apache.xml.security.utils.I18n;

public class XMLSecurityRuntimeException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    protected Exception f72620a;

    /* renamed from: b  reason: collision with root package name */
    protected String f72621b;

    public XMLSecurityRuntimeException() {
        super("Missing message string");
        this.f72620a = null;
        this.f72621b = null;
        this.f72620a = null;
    }

    public XMLSecurityRuntimeException(String str, Exception exc) {
        super(I18n.a(str, exc));
        this.f72620a = null;
        this.f72621b = str;
        this.f72620a = exc;
    }

    public XMLSecurityRuntimeException(String str, Object[] objArr, Exception exc) {
        super(MessageFormat.format(I18n.b(str), objArr));
        this.f72620a = null;
        this.f72621b = str;
        this.f72620a = exc;
    }

    public void printStackTrace() {
        synchronized (System.err) {
            super.printStackTrace(System.err);
            if (this.f72620a != null) {
                this.f72620a.printStackTrace(System.err);
            }
        }
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Exception exc = this.f72620a;
        if (exc != null) {
            exc.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Exception exc = this.f72620a;
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
        if (this.f72620a == null) {
            return name;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(name);
        stringBuffer2.append("\nOriginal Exception was ");
        stringBuffer2.append(this.f72620a.toString());
        return stringBuffer2.toString();
    }
}
