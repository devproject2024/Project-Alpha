package com.google.gson.internal.bind;

import com.google.gson.a.b;
import com.google.gson.b.a;
import com.google.gson.f;
import com.google.gson.internal.c;
import com.google.gson.w;
import com.google.gson.x;

public final class JsonAdapterAnnotationTypeAdapterFactory implements x {

    /* renamed from: a  reason: collision with root package name */
    private final c f39494a;

    public JsonAdapterAnnotationTypeAdapterFactory(c cVar) {
        this.f39494a = cVar;
    }

    public final <T> w<T> create(f fVar, a<T> aVar) {
        b bVar = (b) aVar.getRawType().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return a(this.f39494a, fVar, aVar, bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: com.google.gson.w<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: com.google.gson.w} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: com.google.gson.internal.bind.TreeTypeAdapter} */
    /* JADX WARNING: type inference failed for: r8v3, types: [com.google.gson.w, com.google.gson.w<?>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.gson.w<?> a(com.google.gson.internal.c r8, com.google.gson.f r9, com.google.gson.b.a<?> r10, com.google.gson.a.b r11) {
        /*
            java.lang.Class r0 = r11.a()
            com.google.gson.b.a r0 = com.google.gson.b.a.get(r0)
            com.google.gson.internal.h r8 = r8.a(r0)
            java.lang.Object r8 = r8.a()
            boolean r0 = r8 instanceof com.google.gson.w
            if (r0 == 0) goto L_0x0017
            com.google.gson.w r8 = (com.google.gson.w) r8
            goto L_0x0072
        L_0x0017:
            boolean r0 = r8 instanceof com.google.gson.x
            if (r0 == 0) goto L_0x0022
            com.google.gson.x r8 = (com.google.gson.x) r8
            com.google.gson.w r8 = r8.create(r9, r10)
            goto L_0x0072
        L_0x0022:
            boolean r0 = r8 instanceof com.google.gson.t
            if (r0 != 0) goto L_0x0058
            boolean r1 = r8 instanceof com.google.gson.k
            if (r1 == 0) goto L_0x002b
            goto L_0x0058
        L_0x002b:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Invalid attempt to bind an instance of "
            r11.<init>(r0)
            java.lang.Class r8 = r8.getClass()
            java.lang.String r8 = r8.getName()
            r11.append(r8)
            java.lang.String r8 = " as a @JsonAdapter for "
            r11.append(r8)
            java.lang.String r8 = r10.toString()
            r11.append(r8)
            java.lang.String r8 = ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r9.<init>(r8)
            throw r9
        L_0x0058:
            r1 = 0
            if (r0 == 0) goto L_0x0060
            r0 = r8
            com.google.gson.t r0 = (com.google.gson.t) r0
            r3 = r0
            goto L_0x0061
        L_0x0060:
            r3 = r1
        L_0x0061:
            boolean r0 = r8 instanceof com.google.gson.k
            if (r0 == 0) goto L_0x0068
            r1 = r8
            com.google.gson.k r1 = (com.google.gson.k) r1
        L_0x0068:
            r4 = r1
            com.google.gson.internal.bind.TreeTypeAdapter r8 = new com.google.gson.internal.bind.TreeTypeAdapter
            r7 = 0
            r2 = r8
            r5 = r9
            r6 = r10
            r2.<init>(r3, r4, r5, r6, r7)
        L_0x0072:
            if (r8 == 0) goto L_0x007e
            boolean r9 = r11.b()
            if (r9 == 0) goto L_0x007e
            com.google.gson.w r8 = r8.nullSafe()
        L_0x007e:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.a(com.google.gson.internal.c, com.google.gson.f, com.google.gson.b.a, com.google.gson.a.b):com.google.gson.w");
    }
}
