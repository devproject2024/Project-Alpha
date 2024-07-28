package com.sendbird.android.shadow.com.google.gson.internal;

import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.internal.bind.TypeAdapters;
import com.sendbird.android.shadow.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;

public final class Streams {
    private Streams() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.sendbird.android.shadow.com.google.gson.JsonIOException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.sendbird.android.shadow.com.google.gson.JsonNull.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: MalformedJsonException (r2v4 'e' com.sendbird.android.shadow.com.google.gson.stream.MalformedJsonException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.sendbird.android.shadow.com.google.gson.JsonElement parse(com.sendbird.android.shadow.com.google.gson.stream.JsonReader r2) throws com.sendbird.android.shadow.com.google.gson.JsonParseException {
        /*
            r2.peek()     // Catch:{ EOFException -> 0x0024, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.sendbird.android.shadow.com.google.gson.TypeAdapter<com.sendbird.android.shadow.com.google.gson.JsonElement> r1 = com.sendbird.android.shadow.com.google.gson.internal.bind.TypeAdapters.JSON_ELEMENT     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.read(r2)     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.sendbird.android.shadow.com.google.gson.JsonElement r2 = (com.sendbird.android.shadow.com.google.gson.JsonElement) r2     // Catch:{ EOFException -> 0x000d, MalformedJsonException -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.sendbird.android.shadow.com.google.gson.JsonSyntaxException r0 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.sendbird.android.shadow.com.google.gson.JsonIOException r0 = new com.sendbird.android.shadow.com.google.gson.JsonIOException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.sendbird.android.shadow.com.google.gson.JsonSyntaxException r0 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.sendbird.android.shadow.com.google.gson.JsonNull r2 = com.sendbird.android.shadow.com.google.gson.JsonNull.INSTANCE
            return r2
        L_0x002b:
            com.sendbird.android.shadow.com.google.gson.JsonSyntaxException r0 = new com.sendbird.android.shadow.com.google.gson.JsonSyntaxException
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.shadow.com.google.gson.internal.Streams.parse(com.sendbird.android.shadow.com.google.gson.stream.JsonReader):com.sendbird.android.shadow.com.google.gson.JsonElement");
    }

    public static void write(JsonElement jsonElement, JsonWriter jsonWriter) throws IOException {
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonElement);
    }

    public static Writer writerForAppendable(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f44934a;

        /* renamed from: b  reason: collision with root package name */
        private final C0756a f44935b = new C0756a();

        public final void close() {
        }

        public final void flush() {
        }

        a(Appendable appendable) {
            this.f44934a = appendable;
        }

        public final void write(char[] cArr, int i2, int i3) throws IOException {
            C0756a aVar = this.f44935b;
            aVar.f44936a = cArr;
            this.f44934a.append(aVar, i2, i3 + i2);
        }

        public final void write(int i2) throws IOException {
            this.f44934a.append((char) i2);
        }

        /* renamed from: com.sendbird.android.shadow.com.google.gson.internal.Streams$a$a  reason: collision with other inner class name */
        static class C0756a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f44936a;

            C0756a() {
            }

            public final int length() {
                return this.f44936a.length;
            }

            public final char charAt(int i2) {
                return this.f44936a[i2];
            }

            public final CharSequence subSequence(int i2, int i3) {
                return new String(this.f44936a, i2, i3 - i2);
            }
        }
    }
}
