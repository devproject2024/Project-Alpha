package com.ta.utdid2.a.a;

import com.alipay.mobile.nebula.util.tar.TarHeader;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static byte[] f16104a = {TarHeader.LF_NORMAL, TarHeader.LF_NORMAL, TarHeader.LF_LINK, TarHeader.LF_CONTIG, 68, 67, TarHeader.LF_LINK, 66, 69, TarHeader.LF_SYMLINK, TarHeader.LF_SYMLINK, TarHeader.LF_DIR, 56, TarHeader.LF_DIR, TarHeader.LF_DIR, TarHeader.LF_BLK, 67, 70, TarHeader.LF_NORMAL, TarHeader.LF_SYMLINK, 67, TarHeader.LF_DIR, TarHeader.LF_CONTIG, 66, TarHeader.LF_CONTIG, 56, 69, TarHeader.LF_CONTIG, TarHeader.LF_BLK, TarHeader.LF_NORMAL, 65, TarHeader.LF_DIR};

    public static String a(String str, String str2) {
        byte[] bArr;
        try {
            str.getBytes();
            byte[] a2 = a();
            byte[] bytes = str2.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(a2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(1, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            bArr = instance.doFinal(bytes);
        } catch (Exception unused) {
            bArr = null;
        }
        if (bArr != null) {
            return a(bArr);
        }
        return null;
    }

    public static String b(String str, String str2) {
        try {
            str.getBytes();
            byte[] a2 = a();
            byte[] a3 = a(str2);
            SecretKeySpec secretKeySpec = new SecretKeySpec(a2, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance.init(2, secretKeySpec, new IvParameterSpec(new byte[instance.getBlockSize()]));
            return new String(instance.doFinal(a3));
        } catch (Exception unused) {
            return null;
        }
    }

    private static byte[] a() throws Exception {
        return a(new String(f16104a, 0, 32));
    }

    private static byte[] a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * 2;
            bArr[i2] = Integer.valueOf(str.substring(i3, i3 + 2), 16).byteValue();
        }
        return bArr;
    }

    private static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            stringBuffer.append("0123456789ABCDEF".charAt((b2 >> 4) & 15));
            stringBuffer.append("0123456789ABCDEF".charAt(b2 & 15));
        }
        return stringBuffer.toString();
    }
}
