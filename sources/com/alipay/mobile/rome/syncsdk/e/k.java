package com.alipay.mobile.rome.syncsdk.e;

import com.squareup.b.g;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15101a = k.class.getSimpleName();

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Object, java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends com.squareup.b.g> T a(byte[] r3, java.lang.Class<T> r4) {
        /*
            com.squareup.b.n r0 = new com.squareup.b.n
            r1 = 0
            java.lang.Class[] r2 = new java.lang.Class[r1]
            r0.<init>((java.lang.Class<?>[]) r2)
            int r2 = r3.length     // Catch:{ IOException -> 0x0027 }
            byte[] r3 = java.util.Arrays.copyOfRange(r3, r1, r2)     // Catch:{ IOException -> 0x0027 }
            java.lang.String r1 = "bytes"
            com.squareup.b.i.a(r3, r1)     // Catch:{ IOException -> 0x0027 }
            java.lang.String r1 = "messageClass"
            com.squareup.b.i.a(r4, r1)     // Catch:{ IOException -> 0x0027 }
            com.squareup.b.o r3 = com.squareup.b.o.a((byte[]) r3)     // Catch:{ IOException -> 0x0027 }
            com.squareup.b.h r0 = r0.a(r4)     // Catch:{ IOException -> 0x0027 }
            com.squareup.b.g r3 = r0.a((com.squareup.b.o) r3)     // Catch:{ IOException -> 0x0027 }
            r3.d()     // Catch:{ IOException -> 0x0027 }
            return r3
        L_0x0027:
            java.lang.String r3 = f15101a
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r0 = "parsePBObject thrown exception after parse: "
            java.lang.String r4 = r0.concat(r4)
            com.alipay.mobile.rome.syncsdk.e.h.d(r3, r4)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.rome.syncsdk.e.k.a(byte[], java.lang.Class):com.squareup.b.g");
    }

    public static byte[] a(g gVar) {
        byte[] bArr;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            gVar.d();
            dataOutputStream.write(g.u.a(gVar.getClass()).b(gVar));
            dataOutputStream.flush();
            bArr = byteArrayOutputStream.toByteArray();
            try {
                dataOutputStream.close();
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            bArr = null;
            h.d(f15101a, "convertLinkPBToByteArray  ");
            return bArr;
        }
        return bArr;
    }
}
