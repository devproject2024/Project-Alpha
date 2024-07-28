package net.one97.paytm.upgradeKyc.utils;

import android.util.Base64;
import com.business.merchant_payments.utility.StringUtility;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.one97.paytm.upi.util.UpiConstants;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Date f66315a;

    /* renamed from: b  reason: collision with root package name */
    private PublicKey f66316b;

    public a(InputStream inputStream) {
        try {
            X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(inputStream);
            this.f66316b = x509Certificate.getPublicKey();
            this.f66315a = x509Certificate.getNotAfter();
        } catch (Exception e2) {
            throw new RuntimeException("Could not intialize encryption module", e2);
        }
    }

    public final String a(byte[] bArr) throws IOException, GeneralSecurityException {
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, this.f66316b);
        return Base64.encodeToString(instance.doFinal(bArr), 0).replaceAll(StringUtility.NEW_LINE, "").replaceAll("\r", "");
    }

    public static byte[] a() throws NoSuchProviderException, NoSuchAlgorithmException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        instance.init(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
        return instance.generateKey().getEncoded();
    }

    public final String b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(this.f66315a);
    }

    private static byte[] a(String str, int i2) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        return Arrays.copyOfRange(bytes, bytes.length - i2, bytes.length);
    }

    public static String a(byte[] bArr, byte[] bArr2, String str, boolean z) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchProviderException, InvalidKeySpecException, UnsupportedEncodingException, InvalidParameterSpecException {
        String str2;
        byte[] a2 = a(str, 12);
        byte[] a3 = a(str, 16);
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, a2);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(1, secretKeySpec, gCMParameterSpec);
        instance.updateAAD(a3);
        byte[] doFinal = instance.doFinal(bArr2);
        if (z) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            byte[] bArr3 = new byte[(doFinal.length + bytes.length)];
            System.arraycopy(bytes, 0, bArr3, 0, bytes.length);
            System.arraycopy(doFinal, 0, bArr3, bytes.length, doFinal.length);
            str2 = Base64.encodeToString(bArr3, 0);
        } else {
            str2 = Base64.encodeToString(doFinal, 0);
        }
        return str2.replaceAll(StringUtility.NEW_LINE, "").replaceAll("\r", "");
    }
}
