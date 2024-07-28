package i;

import com.business.merchant_payments.utility.StringUtility;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class f implements Serializable, Comparable<f> {
    public static final f EMPTY = of(new byte[0]);
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final long serialVersionUID = 1;
    final byte[] data;
    transient int hashCode;
    transient String utf8;

    f(byte[] bArr) {
        this.data = bArr;
    }

    public static f of(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f of(byte[] bArr, int i2, int i3) {
        if (bArr != null) {
            x.a((long) bArr.length, (long) i2, (long) i3);
            byte[] bArr2 = new byte[i3];
            System.arraycopy(bArr, i2, bArr2, 0, i3);
            return new f(bArr2);
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f of(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new f(bArr);
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f encodeUtf8(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(x.f46329a));
            fVar.utf8 = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static f encodeString(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return new f(str.getBytes(charset));
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public String utf8() {
        String str = this.utf8;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.data, x.f46329a);
        this.utf8 = str2;
        return str2;
    }

    public String string(Charset charset) {
        if (charset != null) {
            return new String(this.data, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    public String base64() {
        return b.a(this.data);
    }

    public f md5() {
        return digest("MD5");
    }

    public f sha1() {
        return digest("SHA-1");
    }

    public f sha256() {
        return digest("SHA-256");
    }

    public f sha512() {
        return digest("SHA-512");
    }

    private f digest(String str) {
        try {
            return of(MessageDigest.getInstance(str).digest(this.data));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public f hmacSha1(f fVar) {
        return hmac("HmacSHA1", fVar);
    }

    public f hmacSha256(f fVar) {
        return hmac("HmacSHA256", fVar);
    }

    public f hmacSha512(f fVar) {
        return hmac("HmacSHA512", fVar);
    }

    private f hmac(String str, f fVar) {
        try {
            Mac instance = Mac.getInstance(str);
            instance.init(new SecretKeySpec(fVar.toByteArray(), str));
            return of(instance.doFinal(this.data));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        } catch (InvalidKeyException e3) {
            throw new IllegalArgumentException(e3);
        }
    }

    public String base64Url() {
        return b.b(this.data);
    }

    public static f decodeBase64(String str) {
        if (str != null) {
            byte[] a2 = b.a(str);
            if (a2 != null) {
                return new f(a2);
            }
            return null;
        }
        throw new IllegalArgumentException("base64 == null");
    }

    public String hex() {
        byte[] bArr = this.data;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public static f decodeHex(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i2 = 0; i2 < bArr.length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((decodeHexDigit(str.charAt(i3)) << 4) + decodeHexDigit(str.charAt(i3 + 1)));
            }
            return of(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(str)));
        }
    }

    private static int decodeHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c2)));
            }
        }
        return (c2 - c3) + 10;
    }

    public static f read(InputStream inputStream, int i2) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (i2 >= 0) {
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, i3, i2 - i3);
                if (read != -1) {
                    i3 += read;
                } else {
                    throw new EOFException();
                }
            }
            return new f(bArr);
        } else {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(i2)));
        }
    }

    public f toAsciiLowercase() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new f(bArr2);
            }
        }
    }

    public f toAsciiUppercase() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.data;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 < 97 || b2 > 122) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 - 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr2[i3] = (byte) (b3 - 32);
                    }
                }
                return new f(bArr2);
            }
        }
    }

    public f substring(int i2) {
        return substring(i2, this.data.length);
    }

    public f substring(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.data;
            if (i3 <= bArr.length) {
                int i4 = i3 - i2;
                if (i4 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i2 == 0 && i3 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(this.data, i2, bArr2, 0, i4);
                    return new f(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.data.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public byte getByte(int i2) {
        return this.data[i2];
    }

    public int size() {
        return this.data.length;
    }

    public byte[] toByteArray() {
        return (byte[]) this.data.clone();
    }

    /* access modifiers changed from: package-private */
    public byte[] internalArray() {
        return this.data;
    }

    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    public void write(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            outputStream.write(this.data);
            return;
        }
        throw new IllegalArgumentException("out == null");
    }

    /* access modifiers changed from: package-private */
    public void write(c cVar) {
        byte[] bArr = this.data;
        cVar.c(bArr, 0, bArr.length);
    }

    public boolean rangeEquals(int i2, f fVar, int i3, int i4) {
        return fVar.rangeEquals(i3, this.data, i2, i4);
    }

    public boolean rangeEquals(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0) {
            return false;
        }
        byte[] bArr2 = this.data;
        return i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && x.a(bArr2, i2, bArr, i3, i4);
    }

    public final boolean startsWith(f fVar) {
        return rangeEquals(0, fVar, 0, fVar.size());
    }

    public final boolean startsWith(byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }

    public final boolean endsWith(f fVar) {
        return rangeEquals(size() - fVar.size(), fVar, 0, fVar.size());
    }

    public final boolean endsWith(byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    public final int indexOf(f fVar) {
        return indexOf(fVar.internalArray(), 0);
    }

    public final int indexOf(f fVar, int i2) {
        return indexOf(fVar.internalArray(), i2);
    }

    public final int indexOf(byte[] bArr) {
        return indexOf(bArr, 0);
    }

    public int indexOf(byte[] bArr, int i2) {
        int length = this.data.length - bArr.length;
        for (int max = Math.max(i2, 0); max <= length; max++) {
            if (x.a(this.data, max, bArr, 0, bArr.length)) {
                return max;
            }
        }
        return -1;
    }

    public final int lastIndexOf(f fVar) {
        return lastIndexOf(fVar.internalArray(), size());
    }

    public final int lastIndexOf(f fVar, int i2) {
        return lastIndexOf(fVar.internalArray(), i2);
    }

    public final int lastIndexOf(byte[] bArr) {
        return lastIndexOf(bArr, size());
    }

    public int lastIndexOf(byte[] bArr, int i2) {
        for (int min = Math.min(i2, this.data.length - bArr.length); min >= 0; min--) {
            if (x.a(this.data, min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int size = fVar.size();
            byte[] bArr = this.data;
            return size == bArr.length && fVar.rangeEquals(0, bArr, 0, bArr.length);
        }
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        int hashCode2 = Arrays.hashCode(this.data);
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public int compareTo(f fVar) {
        int size = size();
        int size2 = fVar.size();
        int min = Math.min(size, size2);
        for (int i2 = 0; i2 < min; i2++) {
            byte b2 = getByte(i2) & 255;
            byte b3 = fVar.getByte(i2) & 255;
            if (b2 != b3) {
                return b2 < b3 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public String toString() {
        if (this.data.length == 0) {
            return "[size=0]";
        }
        String utf82 = utf8();
        int codePointIndexToCharIndex = codePointIndexToCharIndex(utf82, 64);
        if (codePointIndexToCharIndex != -1) {
            String replace = utf82.substring(0, codePointIndexToCharIndex).replace("\\", "\\\\").replace(StringUtility.NEW_LINE, "\\n").replace("\r", "\\r");
            if (codePointIndexToCharIndex < utf82.length()) {
                return "[size=" + this.data.length + " text=" + replace + "…]";
            }
            return "[text=" + replace + "]";
        } else if (this.data.length <= 64) {
            return "[hex=" + hex() + "]";
        } else {
            return "[size=" + this.data.length + " hex=" + substring(0, 64).hex() + "…]";
        }
    }

    static int codePointIndexToCharIndex(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 == i2) {
                return i3;
            }
            int codePointAt = str.codePointAt(i3);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i4++;
            i3 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        f read = read(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = f.class.getDeclaredField("data");
            declaredField.setAccessible(true);
            declaredField.set(this, read.data);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError();
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }
}
