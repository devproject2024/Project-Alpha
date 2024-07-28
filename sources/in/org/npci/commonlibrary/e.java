package in.org.npci.commonlibrary;

import in.org.npci.commonlibrary.a.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.xml.security.Init;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static List f46346a;

    /* renamed from: b  reason: collision with root package name */
    private i f46347b;

    /* renamed from: c  reason: collision with root package name */
    private k f46348c;

    /* renamed from: d  reason: collision with root package name */
    private b f46349d;

    /* renamed from: e  reason: collision with root package name */
    private String f46350e = "";

    public e(String str) {
        Init.b();
        try {
            this.f46349d = new b();
            if (this.f46349d.a(str)) {
                System.out.println("XML Validated");
                this.f46348c = new k(str);
                f46346a = this.f46348c.a();
                try {
                    this.f46347b = new i();
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                    e2.printStackTrace();
                    throw new f(g.UNKNOWN_ERROR);
                }
            } else {
                System.out.println("XML Not Validated");
                throw new f(g.KEYS_NOT_VALID);
            }
        } catch (f e3) {
            e3.printStackTrace();
            throw e3;
        } catch (Exception e4) {
            e4.printStackTrace();
            throw new f(g.UNKNOWN_ERROR);
        }
    }

    private String a(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(500);
        try {
            String b2 = a.b(this.f46347b.a(this.f46347b.a(str3), this.f46347b.b(str4)), 2);
            sb.append(str2);
            sb.append("|");
            sb.append(str);
            sb.append("|");
            sb.append(b2);
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            throw new f(g.UNKNOWN_ERROR);
        }
    }

    private byte[] a(String str) {
        byte[] bytes = str.getBytes();
        try {
            PublicKey b2 = b(this.f46350e);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, b2);
            return instance.doFinal(bytes);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private PublicKey b(String str) {
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(str.getBytes("utf-8"), 2)));
    }

    public Message a(String str, String str2, String str3, String str4, String str5) {
        if (str == null || !str.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (j jVar : f46346a) {
                if (jVar.b().equals(str)) {
                    arrayList.add(jVar);
                }
            }
            if (arrayList.size() != 0) {
                j jVar2 = (j) arrayList.get(new Random().nextInt(arrayList.size()));
                this.f46350e = jVar2.c();
                return new Message("", "", new Data(jVar2.a(), jVar2.b(), a.b(a(a(str2, str3, str4, str5)), 2)));
            }
            throw new f(g.KEY_CODE_INVALID);
        }
        throw new f(g.KEY_CODE_EMPTY);
    }

    public void a(String str, String str2, String str3) {
        try {
            i iVar = new i();
            String b2 = a.b(iVar.a(str2), 2);
            String b3 = a.b(iVar.b(a.a(str, 2), iVar.b(str3)), 2);
            if (b3 == null) {
                return;
            }
            if (!b3.equalsIgnoreCase(b2)) {
                throw new f(g.TRUST_NOT_VALID);
            }
        } catch (UnsupportedEncodingException | InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e2) {
            e2.printStackTrace();
            throw new f(g.UNKNOWN_ERROR);
        } catch (Exception e3) {
            e3.printStackTrace();
            throw new f(g.UNKNOWN_ERROR);
        }
    }
}
