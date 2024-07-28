package com.google.c;

import com.google.c.a;
import com.google.c.a.C0622a;
import com.google.c.at;
import com.google.c.j;
import java.io.IOException;

public abstract class a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0622a<MessageType, BuilderType>> implements at {

    /* renamed from: d  reason: collision with root package name */
    protected int f37678d = 0;

    public final j c() {
        try {
            j.f newCodedBuilder = j.newCodedBuilder(j());
            a(newCodedBuilder.f37857a);
            return newCodedBuilder.a();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a " + "ByteString" + " threw an IOException (should never happen).", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int d() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final int a(bm bmVar) {
        int d2 = d();
        if (d2 != -1) {
            return d2;
        }
        int b2 = bmVar.b(this);
        a(b2);
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final bs e() {
        return new bs((at) this);
    }

    /* renamed from: com.google.c.a$a  reason: collision with other inner class name */
    public static abstract class C0622a<MessageType extends a<MessageType, BuilderType>, BuilderType extends C0622a<MessageType, BuilderType>> implements at.a {
        /* renamed from: a */
        public abstract BuilderType clone();

        /* access modifiers changed from: protected */
        public abstract BuilderType a(MessageType messagetype);

        public final /* synthetic */ at.a a(at atVar) {
            if (o().getClass().isInstance(atVar)) {
                return a((a) atVar);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }
}
