package net.one97.paytm.wallet.newdesign.fastscan.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.SparseArray;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.gms.vision.a.d;
import com.google.android.gms.vision.a.e;
import com.google.android.gms.vision.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f70920a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f70921b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f70922c;

    /* renamed from: d  reason: collision with root package name */
    public static e f70923d;

    /* renamed from: e  reason: collision with root package name */
    public static a f70924e;

    /* renamed from: f  reason: collision with root package name */
    public static final Context f70925f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f70926g = new b();

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f70927h = Pattern.compile("[A-Za-z]{4}0[A-Z0-9a-z]{6}");

    public interface a {
        void a();

        void a(String str);

        void b();
    }

    static {
        c a2 = net.one97.paytm.wallet.communicator.b.a();
        k.a((Object) a2, "WalletCommManager.getWalletCommunicator()");
        f70925f = a2.getContext();
    }

    private b() {
    }

    public static final /* synthetic */ a a() {
        a aVar = f70924e;
        if (aVar == null) {
            k.a("galleryFlowListener");
        }
        return aVar;
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.fastscan.a.b$b  reason: collision with other inner class name */
    public static final class C1435b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final C1435b f70929a = new C1435b();

        C1435b() {
        }

        public final void run() {
            net.one97.paytm.wallet.newdesign.fastscan.b bVar = net.one97.paytm.wallet.newdesign.fastscan.b.f70946a;
            if (!net.one97.paytm.wallet.newdesign.fastscan.b.a()) {
                b bVar2 = b.f70926g;
                b.a().a();
            }
        }
    }

    private static String a(SparseArray<d> sparseArray) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int size = sparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            d valueAt = sparseArray.valueAt(i2);
            k.a((Object) valueAt, "tBlock");
            sb.append(valueAt.a());
            sb.append("\n\n");
            for (com.google.android.gms.vision.a.c cVar : valueAt.b()) {
                k.a((Object) cVar, "line");
                sb2.append(cVar.a());
                sb2.append(StringUtility.NEW_LINE);
                for (com.google.android.gms.vision.a.c cVar2 : cVar.b()) {
                    k.a((Object) cVar2, "element");
                    sb3.append(cVar2.a());
                    sb3.append(AppConstants.COMMA);
                }
            }
        }
        return sb3.toString();
    }

    public static String a(String str) {
        String string = f70925f.getString(R.string.not_paytm_qr);
        if (str == null) {
            return string;
        }
        if (p.a(str, "incorrectData", true)) {
            return f70925f.getString(R.string.incorrect_qr_data_message);
        }
        return p.a(str, "loginError", true) ? f70925f.getString(R.string.user_not_logged_in_error) : string;
    }

    public static void a(String str, boolean z) {
        a.f70919c.a(str, z);
    }

    private static String b(String str) {
        CharSequence charSequence = str;
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (!z2) {
                z = true;
            } else {
                i2++;
            }
        }
        if (!net.one97.paytm.wallet.utility.a.f(charSequence.subSequence(i2, length + 1).toString())) {
            return "";
        }
        int length2 = charSequence.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = charSequence.charAt(!z3 ? i3 : length2) <= ' ';
            if (z3) {
                if (!z4) {
                    break;
                }
                length2--;
            } else if (!z4) {
                z3 = true;
            } else {
                i3++;
            }
        }
        return charSequence.subSequence(i3, length2 + 1).toString();
    }

    private static String c(String str) {
        try {
            CharSequence charSequence = str;
            int length = charSequence.length() - 1;
            int i2 = 0;
            boolean z = false;
            while (i2 <= length) {
                boolean z2 = charSequence.charAt(!z ? i2 : length) <= ' ';
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (!z2) {
                    z = true;
                } else {
                    i2++;
                }
            }
            str = charSequence.subSequence(i2, length + 1).toString();
            if (str.charAt(4) == 'O' || str.charAt(4) == 'o') {
                if (str != null) {
                    char[] charArray = str.toCharArray();
                    k.a((Object) charArray, "(this as java.lang.String).toCharArray()");
                    charArray[4] = '0';
                    str = new String(charArray);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
        } catch (Exception unused) {
        }
        Pattern pattern = f70927h;
        CharSequence charSequence2 = str;
        int length2 = charSequence2.length() - 1;
        int i3 = 0;
        boolean z3 = false;
        while (i3 <= length2) {
            boolean z4 = charSequence2.charAt(!z3 ? i3 : length2) <= ' ';
            if (z3) {
                if (!z4) {
                    break;
                }
                length2--;
            } else if (!z4) {
                z3 = true;
            } else {
                i3++;
            }
        }
        Matcher matcher = pattern.matcher(charSequence2.subSequence(i3, length2 + 1).toString());
        k.a((Object) matcher, "ifscPattern.matcher(text.trim { it <= ' ' })");
        if (!matcher.matches()) {
            return "";
        }
        int length3 = charSequence2.length() - 1;
        int i4 = 0;
        boolean z5 = false;
        while (i4 <= length3) {
            boolean z6 = charSequence2.charAt(!z5 ? i4 : length3) <= ' ';
            if (z5) {
                if (!z6) {
                    break;
                }
                length3--;
            } else if (!z6) {
                z5 = true;
            } else {
                i4++;
            }
        }
        return charSequence2.subSequence(i4, length3 + 1).toString();
    }

    public static void a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(-90.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        k.a((Object) createBitmap, "Bitmap.createBitmap(sour…etHeight(), matrix, true)");
        com.google.android.gms.vision.b a2 = new b.a().a(bitmap).a();
        com.google.android.gms.vision.b a3 = new b.a().a(createBitmap).a();
        e eVar = f70923d;
        if (eVar == null) {
            k.a("detector");
        }
        SparseArray<d> a4 = eVar.a(a2);
        e eVar2 = f70923d;
        if (eVar2 == null) {
            k.a("detector");
        }
        SparseArray<d> a5 = eVar2.a(a3);
        StringBuilder sb = new StringBuilder();
        k.a((Object) a4, "textBlocks");
        sb.append(a(a4));
        sb.append(AppConstants.COMMA);
        k.a((Object) a5, "rotatedTextBlocks");
        sb.append(a(a5));
        Object[] array = p.a((CharSequence) sb.toString(), new String[]{AppConstants.COMMA}).toArray(new String[0]);
        if (array != null) {
            String str = "";
            String str2 = str;
            for (String str3 : (String[]) array) {
                if (TextUtils.isEmpty(str)) {
                    str = b(str3);
                }
                if (TextUtils.isEmpty(str2)) {
                    str2 = c(str3);
                }
            }
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
