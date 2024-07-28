package com.sendbird.android.shadow.okio;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class HashingSource extends ForwardingSource {
    private final Mac mac;
    private final MessageDigest messageDigest;

    public static HashingSource md5(Source source) {
        return new HashingSource(source, "MD5");
    }

    public static HashingSource sha1(Source source) {
        return new HashingSource(source, "SHA-1");
    }

    public static HashingSource sha256(Source source) {
        return new HashingSource(source, "SHA-256");
    }

    public static HashingSource hmacSha1(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA1");
    }

    public static HashingSource hmacSha256(Source source, ByteString byteString) {
        return new HashingSource(source, byteString, "HmacSHA256");
    }

    private HashingSource(Source source, String str) {
        super(source);
        try {
            this.messageDigest = MessageDigest.getInstance(str);
            this.mac = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        }
    }

    private HashingSource(Source source, ByteString byteString, String str) {
        super(source);
        try {
            this.mac = Mac.getInstance(str);
            this.mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            this.messageDigest = null;
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final long read(Buffer buffer, long j) throws IOException {
        long read = super.read(buffer, j);
        if (read != -1) {
            long j2 = buffer.size - read;
            long j3 = buffer.size;
            d dVar = buffer.head;
            while (j3 > j2) {
                dVar = dVar.f45279g;
                j3 -= (long) (dVar.f45275c - dVar.f45274b);
            }
            while (j3 < buffer.size) {
                int i2 = (int) ((((long) dVar.f45274b) + j2) - j3);
                MessageDigest messageDigest2 = this.messageDigest;
                if (messageDigest2 != null) {
                    messageDigest2.update(dVar.f45273a, i2, dVar.f45275c - i2);
                } else {
                    this.mac.update(dVar.f45273a, i2, dVar.f45275c - i2);
                }
                j2 = ((long) (dVar.f45275c - dVar.f45274b)) + j3;
                dVar = dVar.f45278f;
                j3 = j2;
            }
        }
        return read;
    }

    public final ByteString hash() {
        MessageDigest messageDigest2 = this.messageDigest;
        return ByteString.of(messageDigest2 != null ? messageDigest2.digest() : this.mac.doFinal());
    }
}
