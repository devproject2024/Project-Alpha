package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.common.server.converter.zab;
import com.google.android.gms.common.util.c;
import com.google.android.gms.common.util.l;
import com.google.android.gms.common.util.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class FastJsonResponse {

    public interface a<I, O> {
        I a(O o);
    }

    public abstract Map<String, Field<?, ?>> a();

    /* access modifiers changed from: protected */
    public abstract Object b();

    /* access modifiers changed from: protected */
    public abstract boolean c();

    /* access modifiers changed from: protected */
    public boolean a(Field field) {
        if (field.f8906c != 11) {
            return c();
        }
        if (field.f8907d) {
            throw new UnsupportedOperationException("Concrete type arrays not supported");
        }
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final a CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        protected final int f8904a;

        /* renamed from: b  reason: collision with root package name */
        protected final boolean f8905b;

        /* renamed from: c  reason: collision with root package name */
        protected final int f8906c;

        /* renamed from: d  reason: collision with root package name */
        protected final boolean f8907d;

        /* renamed from: e  reason: collision with root package name */
        protected final String f8908e;

        /* renamed from: f  reason: collision with root package name */
        protected final int f8909f;

        /* renamed from: g  reason: collision with root package name */
        protected final Class<? extends FastJsonResponse> f8910g;

        /* renamed from: h  reason: collision with root package name */
        zaj f8911h;
        /* access modifiers changed from: package-private */

        /* renamed from: i  reason: collision with root package name */
        public a<I, O> f8912i;
        private final int j;
        private final String k;

        Field(int i2, int i3, boolean z, int i4, boolean z2, String str, int i5, String str2, zab zab) {
            this.j = i2;
            this.f8904a = i3;
            this.f8905b = z;
            this.f8906c = i4;
            this.f8907d = z2;
            this.f8908e = str;
            this.f8909f = i5;
            if (str2 == null) {
                this.f8910g = null;
                this.k = null;
            } else {
                this.f8910g = SafeParcelResponse.class;
                this.k = str2;
            }
            if (zab == null) {
                this.f8912i = null;
            } else if (zab.f8902a != null) {
                this.f8912i = zab.f8902a;
            } else {
                throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
            }
        }

        private Field(int i2, boolean z, int i3, boolean z2, String str, int i4, Class<? extends FastJsonResponse> cls) {
            this.j = 1;
            this.f8904a = i2;
            this.f8905b = z;
            this.f8906c = i3;
            this.f8907d = z2;
            this.f8908e = str;
            this.f8909f = i4;
            this.f8910g = cls;
            if (cls == null) {
                this.k = null;
            } else {
                this.k = cls.getCanonicalName();
            }
            this.f8912i = null;
        }

        public final int a() {
            return this.f8909f;
        }

        private final String c() {
            String str = this.k;
            if (str == null) {
                return null;
            }
            return str;
        }

        public final Map<String, Field<?, ?>> b() {
            s.a(this.k);
            s.a(this.f8911h);
            return this.f8911h.a(this.k);
        }

        public static Field<Integer, Integer> a(String str) {
            return new Field(0, false, 0, false, str, 3, (Class<? extends FastJsonResponse>) null);
        }

        public static Field<String, String> a(String str, int i2) {
            return new Field(7, false, 7, false, str, i2, (Class<? extends FastJsonResponse>) null);
        }

        public static Field<ArrayList<String>, ArrayList<String>> b(String str, int i2) {
            return new Field(7, true, 7, true, str, i2, (Class<? extends FastJsonResponse>) null);
        }

        public static Field<byte[], byte[]> b(String str) {
            return new Field(8, false, 8, false, str, 4, (Class<? extends FastJsonResponse>) null);
        }

        public static <T extends FastJsonResponse> Field<T, T> a(String str, int i2, Class<T> cls) {
            return new Field(11, false, 11, false, str, i2, cls);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> a(String str, Class<T> cls) {
            return new Field(11, true, 11, true, str, 2, cls);
        }

        public String toString() {
            q.a a2 = q.a((Object) this).a(AppConstants.VERSION_CODE, Integer.valueOf(this.j)).a("typeIn", Integer.valueOf(this.f8904a)).a("typeInArray", Boolean.valueOf(this.f8905b)).a("typeOut", Integer.valueOf(this.f8906c)).a("typeOutArray", Boolean.valueOf(this.f8907d)).a("outputFieldName", this.f8908e).a("safeParcelFieldId", Integer.valueOf(this.f8909f)).a("concreteTypeName", c());
            Class<? extends FastJsonResponse> cls = this.f8910g;
            if (cls != null) {
                a2.a("concreteType.class", cls.getCanonicalName());
            }
            a<I, O> aVar = this.f8912i;
            if (aVar != null) {
                a2.a("converterName", aVar.getClass().getCanonicalName());
            }
            return a2.toString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            zab zab;
            int a2 = b.a(parcel, 20293);
            b.b(parcel, 1, this.j);
            b.b(parcel, 2, this.f8904a);
            b.a(parcel, 3, this.f8905b);
            b.b(parcel, 4, this.f8906c);
            b.a(parcel, 5, this.f8907d);
            b.a(parcel, 6, this.f8908e, false);
            b.b(parcel, 7, this.f8909f);
            b.a(parcel, 8, c(), false);
            a<I, O> aVar = this.f8912i;
            if (aVar == null) {
                zab = null;
            } else {
                zab = zab.a(aVar);
            }
            b.a(parcel, 9, zab, i2, false);
            b.b(parcel, a2);
        }
    }

    protected static <O, I> I a(Field<I, O> field, Object obj) {
        return field.f8912i != null ? field.f8912i.a(obj) : obj;
    }

    public String toString() {
        Map<String, Field<?, ?>> a2 = a();
        StringBuilder sb = new StringBuilder(100);
        for (String next : a2.keySet()) {
            Field field = a2.get(next);
            if (a(field)) {
                Object a3 = a(field, b(field));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                }
                sb.append("\"");
                sb.append(next);
                sb.append("\":");
                if (a3 != null) {
                    switch (field.f8906c) {
                        case 8:
                            sb.append("\"");
                            sb.append(c.a((byte[]) a3));
                            sb.append("\"");
                            break;
                        case 9:
                            sb.append("\"");
                            sb.append(c.b((byte[]) a3));
                            sb.append("\"");
                            break;
                        case 10:
                            m.a(sb, (HashMap) a3);
                            break;
                        default:
                            if (!field.f8905b) {
                                a(sb, field, a3);
                                break;
                            } else {
                                ArrayList arrayList = (ArrayList) a3;
                                sb.append("[");
                                int size = arrayList.size();
                                for (int i2 = 0; i2 < size; i2++) {
                                    if (i2 > 0) {
                                        sb.append(com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants.COMMA);
                                    }
                                    Object obj = arrayList.get(i2);
                                    if (obj != null) {
                                        a(sb, field, obj);
                                    }
                                }
                                sb.append("]");
                                break;
                            }
                    }
                } else {
                    sb.append("null");
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public Object b(Field field) {
        String str = field.f8908e;
        if (field.f8910g == null) {
            return b();
        }
        b();
        s.a(true, "Concrete field shouldn't be value object: %s", field.f8908e);
        try {
            char upperCase = Character.toUpperCase(str.charAt(0));
            String substring = str.substring(1);
            StringBuilder sb = new StringBuilder(String.valueOf(substring).length() + 4);
            sb.append("get");
            sb.append(upperCase);
            sb.append(substring);
            return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static void a(StringBuilder sb, Field field, Object obj) {
        if (field.f8904a == 11) {
            sb.append(((FastJsonResponse) field.f8910g.cast(obj)).toString());
        } else if (field.f8904a == 7) {
            sb.append("\"");
            sb.append(l.a((String) obj));
            sb.append("\"");
        } else {
            sb.append(obj);
        }
    }
}
