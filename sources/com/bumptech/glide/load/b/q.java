package com.bumptech.glide.load.b;

import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class q extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private com.bumptech.glide.load.a dataSource;
    private String detailMessage;
    private Exception exception;
    private g key;

    public final Throwable fillInStackTrace() {
        return this;
    }

    public q(String str) {
        this(str, (List<Throwable>) Collections.emptyList());
    }

    public q(String str, Throwable th) {
        this(str, (List<Throwable>) Collections.singletonList(th));
    }

    public q(String str, List<Throwable> list) {
        this.detailMessage = str;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    /* access modifiers changed from: package-private */
    public final void setLoggingDetails(g gVar, com.bumptech.glide.load.a aVar) {
        setLoggingDetails(gVar, aVar, (Class<?>) null);
    }

    /* access modifiers changed from: package-private */
    public final void setLoggingDetails(g gVar, com.bumptech.glide.load.a aVar, Class<?> cls) {
        this.key = gVar;
        this.dataSource = aVar;
        this.dataClass = cls;
    }

    public final void setOrigin(Exception exc) {
        this.exception = exc;
    }

    public final Exception getOrigin() {
        return this.exception;
    }

    public final List<Throwable> getCauses() {
        return this.causes;
    }

    public final List<Throwable> getRootCauses() {
        ArrayList arrayList = new ArrayList();
        addRootCauses(this, arrayList);
        return arrayList;
    }

    public final void logRootCauses(String str) {
        List<Throwable> rootCauses = getRootCauses();
        int size = rootCauses.size();
        int i2 = 0;
        while (i2 < size) {
            StringBuilder sb = new StringBuilder("Root cause (");
            int i3 = i2 + 1;
            sb.append(i3);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            rootCauses.get(i2);
            i2 = i3;
        }
    }

    private void addRootCauses(Throwable th, List<Throwable> list) {
        if (th instanceof q) {
            for (Throwable addRootCauses : ((q) th).getCauses()) {
                addRootCauses(addRootCauses, list);
            }
            return;
        }
        list.add(th);
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        printStackTrace((Appendable) printStream);
    }

    public final void printStackTrace(PrintWriter printWriter) {
        printStackTrace((Appendable) printWriter);
    }

    private void printStackTrace(Appendable appendable) {
        appendExceptionMessage(this, appendable);
        appendCauses(getCauses(), new a(appendable));
    }

    public final String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.detailMessage);
        String str3 = "";
        if (this.dataClass != null) {
            str = ", " + this.dataClass;
        } else {
            str = str3;
        }
        sb.append(str);
        if (this.dataSource != null) {
            str2 = ", " + this.dataSource;
        } else {
            str2 = str3;
        }
        sb.append(str2);
        if (this.key != null) {
            str3 = ", " + this.key;
        }
        sb.append(str3);
        List<Throwable> rootCauses = getRootCauses();
        if (rootCauses.isEmpty()) {
            return sb.toString();
        }
        if (rootCauses.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(rootCauses.size());
            sb.append(" causes:");
        }
        for (Throwable next : rootCauses) {
            sb.append(10);
            sb.append(next.getClass().getName());
            sb.append('(');
            sb.append(next.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    private static void appendExceptionMessage(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append(10);
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            appendCausesWrapped(list, appendable);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            int i3 = i2 + 1;
            appendable.append("Cause (").append(String.valueOf(i3)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i2);
            if (th instanceof q) {
                ((q) th).printStackTrace(appendable);
            } else {
                appendExceptionMessage(th, appendable);
            }
            i2 = i3;
        }
    }

    static final class a implements Appendable {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f6937a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6938b = true;

        private static CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        a(Appendable appendable) {
            this.f6937a = appendable;
        }

        public final Appendable append(char c2) throws IOException {
            boolean z = false;
            if (this.f6938b) {
                this.f6938b = false;
                this.f6937a.append("  ");
            }
            if (c2 == 10) {
                z = true;
            }
            this.f6938b = z;
            this.f6937a.append(c2);
            return this;
        }

        public final Appendable append(CharSequence charSequence) throws IOException {
            CharSequence a2 = a(charSequence);
            return append(a2, 0, a2.length());
        }

        public final Appendable append(CharSequence charSequence, int i2, int i3) throws IOException {
            CharSequence a2 = a(charSequence);
            boolean z = false;
            if (this.f6938b) {
                this.f6938b = false;
                this.f6937a.append("  ");
            }
            if (a2.length() > 0 && a2.charAt(i3 - 1) == 10) {
                z = true;
            }
            this.f6938b = z;
            this.f6937a.append(a2, i2, i3);
            return this;
        }
    }
}
