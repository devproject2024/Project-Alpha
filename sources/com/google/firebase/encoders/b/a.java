package com.google.firebase.encoders.b;

import com.google.firebase.encoders.a.b;
import com.google.firebase.encoders.c;
import com.google.firebase.encoders.d;
import com.google.firebase.encoders.f;
import com.google.firebase.encoders.g;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class a implements b<a> {

    /* renamed from: b  reason: collision with root package name */
    private static final d<Object> f38734b = b.a();

    /* renamed from: f  reason: collision with root package name */
    private static final f<String> f38735f = c.a();

    /* renamed from: g  reason: collision with root package name */
    private static final f<Boolean> f38736g = d.a();

    /* renamed from: h  reason: collision with root package name */
    private static final C0647a f38737h = new C0647a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public boolean f38738a = false;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<?>, d<?>> f38739c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Map<Class<?>, f<?>> f38740d = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public d<Object> f38741e = f38734b;

    static /* synthetic */ void a(Object obj) throws IOException {
        throw new c("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    /* renamed from: com.google.firebase.encoders.b.a$a  reason: collision with other inner class name */
    static final class C0647a implements f<Date> {

        /* renamed from: a  reason: collision with root package name */
        private static final DateFormat f38743a;

        private C0647a() {
        }

        /* synthetic */ C0647a(byte b2) {
            this();
        }

        public final /* synthetic */ void a(Object obj, Object obj2) throws IOException {
            ((g) obj2).a(f38743a.format((Date) obj));
        }

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f38743a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    public a() {
        a(String.class, f38735f);
        a(Boolean.class, f38736g);
        a(Date.class, f38737h);
    }

    /* renamed from: b */
    public final <T> a a(Class<T> cls, d<? super T> dVar) {
        this.f38739c.put(cls, dVar);
        this.f38740d.remove(cls);
        return this;
    }

    private <T> a a(Class<T> cls, f<? super T> fVar) {
        this.f38740d.put(cls, fVar);
        this.f38739c.remove(cls);
        return this;
    }

    public final a a(com.google.firebase.encoders.a.a aVar) {
        aVar.a(this);
        return this;
    }

    public final com.google.firebase.encoders.a a() {
        return new com.google.firebase.encoders.a() {
            public final void a(Object obj, Writer writer) throws IOException {
                e eVar = new e(writer, a.this.f38739c, a.this.f38740d, a.this.f38741e, a.this.f38738a);
                eVar.a(obj);
                eVar.a();
                eVar.f38747a.flush();
            }

            public final String a(Object obj) {
                StringWriter stringWriter = new StringWriter();
                try {
                    a(obj, stringWriter);
                } catch (IOException unused) {
                }
                return stringWriter.toString();
            }
        };
    }
}
