package io.reactivex.rxjava3.c;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;

public final class a extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public a(Throwable... thArr) {
        this((Iterable<? extends Throwable>) thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    public a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).getExceptions());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            this.exceptions = Collections.unmodifiableList(new ArrayList(linkedHashSet));
            this.message = this.exceptions.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }

    public final List<Throwable> getExceptions() {
        return this.exceptions;
    }

    public final String getMessage() {
        return this.message;
    }

    public final synchronized Throwable getCause() {
        int i2;
        if (this.cause == null) {
            String property = System.getProperty("line.separator");
            if (this.exceptions.size() > 1) {
                IdentityHashMap identityHashMap = new IdentityHashMap();
                StringBuilder sb = new StringBuilder();
                sb.append("Multiple exceptions (");
                sb.append(this.exceptions.size());
                sb.append(")");
                sb.append(property);
                for (Throwable next : this.exceptions) {
                    int i3 = 0;
                    while (true) {
                        if (next == null) {
                            break;
                        }
                        for (int i4 = 0; i4 < i3; i4++) {
                            sb.append("  ");
                        }
                        sb.append("|-- ");
                        sb.append(next.getClass().getCanonicalName());
                        sb.append(": ");
                        String message2 = next.getMessage();
                        if (message2 == null || !message2.contains(property)) {
                            sb.append(message2);
                            sb.append(property);
                        } else {
                            sb.append(property);
                            for (String str : message2.split(property)) {
                                for (int i5 = 0; i5 < i3 + 2; i5++) {
                                    sb.append("  ");
                                }
                                sb.append(str);
                                sb.append(property);
                            }
                        }
                        int i6 = 0;
                        while (true) {
                            i2 = i3 + 2;
                            if (i6 >= i2) {
                                break;
                            }
                            sb.append("  ");
                            i6++;
                        }
                        StackTraceElement[] stackTrace = next.getStackTrace();
                        if (stackTrace.length > 0) {
                            sb.append("at ");
                            sb.append(stackTrace[0]);
                            sb.append(property);
                        }
                        if (!identityHashMap.containsKey(next)) {
                            identityHashMap.put(next, Boolean.TRUE);
                            next = next.getCause();
                            i3++;
                        } else {
                            Throwable cause2 = next.getCause();
                            if (cause2 != null) {
                                for (int i7 = 0; i7 < i2; i7++) {
                                    sb.append("  ");
                                }
                                sb.append("|-- ");
                                sb.append("(cause not expanded again) ");
                                sb.append(cause2.getClass().getCanonicalName());
                                sb.append(": ");
                                sb.append(cause2.getMessage());
                                sb.append(property);
                            }
                        }
                    }
                }
                this.cause = new C0785a(sb.toString().trim());
            } else {
                this.cause = this.exceptions.get(0);
            }
        }
        return this.cause;
    }

    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    public final void printStackTrace(PrintStream printStream) {
        printStackTrace((b) new c(printStream));
    }

    public final void printStackTrace(PrintWriter printWriter) {
        printStackTrace((b) new d(printWriter));
    }

    private void printStackTrace(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append(10);
        for (StackTraceElement append : getStackTrace()) {
            sb.append("\tat ");
            sb.append(append);
            sb.append(10);
        }
        int i2 = 1;
        for (Throwable appendStackTrace : this.exceptions) {
            sb.append("  ComposedException ");
            sb.append(i2);
            sb.append(" :\n");
            appendStackTrace(sb, appendStackTrace, "\t");
            i2++;
        }
        bVar.a(sb.toString());
    }

    private void appendStackTrace(StringBuilder sb, Throwable th, String str) {
        while (true) {
            sb.append(str);
            sb.append(th);
            sb.append(10);
            for (StackTraceElement append : th.getStackTrace()) {
                sb.append("\t\tat ");
                sb.append(append);
                sb.append(10);
            }
            if (th.getCause() != null) {
                sb.append("\tCaused by: ");
                th = th.getCause();
                str = "";
            } else {
                return;
            }
        }
    }

    static abstract class b {
        /* access modifiers changed from: package-private */
        public abstract void a(Object obj);

        b() {
        }
    }

    static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintStream f46641a;

        c(PrintStream printStream) {
            this.f46641a = printStream;
        }

        /* access modifiers changed from: package-private */
        public final void a(Object obj) {
            this.f46641a.println(obj);
        }
    }

    static final class d extends b {

        /* renamed from: a  reason: collision with root package name */
        private final PrintWriter f46642a;

        d(PrintWriter printWriter) {
            this.f46642a = printWriter;
        }

        /* access modifiers changed from: package-private */
        public final void a(Object obj) {
            this.f46642a.println(obj);
        }
    }

    /* renamed from: io.reactivex.rxjava3.c.a$a  reason: collision with other inner class name */
    static final class C0785a extends RuntimeException {
        private static final long serialVersionUID = 3875212506787802066L;

        C0785a(String str) {
            super(str);
        }

        public final synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public final int size() {
        return this.exceptions.size();
    }
}
