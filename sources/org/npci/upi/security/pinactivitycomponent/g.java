package org.npci.upi.security.pinactivitycomponent;

import android.content.Context;
import android.util.Base64;
import in.org.npci.commonlibrary.l;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import net.one97.paytm.upi.util.UpiConstants;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f72983a;

    /* renamed from: b  reason: collision with root package name */
    private String f72984b = "";

    /* renamed from: c  reason: collision with root package name */
    private i f72985c = null;

    /* renamed from: d  reason: collision with root package name */
    private h f72986d;

    /* renamed from: e  reason: collision with root package name */
    private String f72987e = "";

    public g(Context context) {
        try {
            this.f72983a = context;
            this.f72985c = new i(context);
            this.f72986d = new h();
        } catch (Exception e2) {
            e2.printStackTrace();
            throw e2;
        }
    }

    private boolean b(String str, String str2, String str3, String str4) {
        try {
            String b2 = this.f72985c.b();
            ad.b("Token in CL", b2);
            String encodeToString = Base64.encodeToString(this.f72986d.b(Base64.decode(str, 0), this.f72986d.b(b2)), 0);
            String str5 = str2 + "|" + str3 + "|" + str4;
            ad.b("CL Hmac Msg", str5);
            String encodeToString2 = Base64.encodeToString(this.f72986d.a(str5), 0);
            ad.b("CL Hash", encodeToString2);
            return encodeToString2.equalsIgnoreCase(encodeToString);
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return false;
        } catch (IllegalBlockSizeException e3) {
            e3.printStackTrace();
            return false;
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
            return false;
        } catch (InvalidAlgorithmParameterException e5) {
            e5.printStackTrace();
            return false;
        } catch (InvalidKeyException e6) {
            e6.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
            return false;
        } catch (Exception e8) {
            e8.printStackTrace();
            return false;
        }
    }

    public String a() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
            return this.f72986d.a(instance.generateKey().getEncoded());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String a(String str, String str2) {
        String str3;
        String format = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
        try {
            this.f72984b = b();
            str3 = a();
        } catch (Exception e2) {
            e2.printStackTrace();
            str3 = "";
        }
        try {
            h hVar = new h();
            if (str.equalsIgnoreCase("initial")) {
                this.f72985c.c();
                if (this.f72985c.a().size() > 0) {
                    this.f72985c.b(new ar(str3, this.f72984b, format));
                } else {
                    this.f72985c.a(new ar(str3, this.f72984b, format));
                }
                String a2 = hVar.a(this.f72984b + "|" + str3 + "|" + str2, l.a());
                ad.b("K0 in Challenge", str3);
                ad.b("token in Challenge", this.f72984b);
                return a2;
            }
            String a3 = ((ar) this.f72985c.a().get(0)).a();
            ad.b("K0 in Challenge", str3);
            ad.b("token in Challenge", this.f72984b);
            String encodeToString = Base64.encodeToString(hVar.a((this.f72984b + "|" + str3 + "|" + str2).getBytes(), hVar.b(a3)), 0);
            this.f72985c.c();
            this.f72985c.a(new ar(str3, this.f72984b, format));
            return encodeToString;
        } catch (Exception e3) {
            e3.printStackTrace();
            return "";
        }
    }

    public boolean a(String str, String str2, String str3, String str4) {
        ad.b("hmac", str4);
        return b(str4, str, str2, str3);
    }

    public String b() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance("AES");
            instance.init(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS);
            return this.f72986d.a(instance.generateKey().getEncoded());
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
