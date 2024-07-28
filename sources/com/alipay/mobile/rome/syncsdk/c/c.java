package com.alipay.mobile.rome.syncsdk.c;

import android.content.Context;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.e.l;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

public class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private static final String f15013b = c.class.getSimpleName();

    public c(Context context) {
        super(context);
    }

    public final void a(String str) {
        this.f15011a = str;
    }

    private String[] b() {
        String str = a() + this.f15011a;
        h.a(f15013b, "getMsgList() perMsgName=".concat(String.valueOf(str)));
        File file = new File(str);
        String[] strArr = null;
        if (!file.exists() || file.length() <= 0) {
            h.a(f15013b, "getMsgList() perMsgName isn't find!");
        } else {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(bArr, "utf-8");
                h.a(f15013b, "getMsgList() listMsgId:".concat(str2));
                if (str2.trim().length() > 0) {
                    String[] a2 = l.a(str2);
                    try {
                        Arrays.sort(a2);
                        strArr = a2;
                    } catch (Exception e2) {
                        e = e2;
                        strArr = a2;
                        h.d(f15013b, "getMsgList() perMsgName isn't find! e=".concat(String.valueOf(e)));
                        return strArr;
                    }
                }
                fileInputStream.close();
            } catch (Exception e3) {
                e = e3;
            }
        }
        return strArr;
    }

    public final boolean a(a aVar) {
        String str = f15013b;
        h.a(str, "isContainMsg() newPerMsgId=" + aVar.getPerMsgId());
        String[] b2 = b();
        if (b2 != null) {
            return l.a(b2, aVar.getPerMsgId());
        }
        return false;
    }

    public final void b(a aVar) {
        String perMsgId = aVar.getPerMsgId();
        h.a(f15013b, "saveMsgRecord() perMsgId=".concat(String.valueOf(perMsgId)));
        if (perMsgId == null || perMsgId.length() <= 0) {
            h.c(f15013b, "saveMsgRecord() perMsgId is invalid!");
            return;
        }
        String[] b2 = b();
        if (b2 == null || b2.length <= 0) {
            b2 = new String[]{perMsgId};
        } else if (b2.length >= 50) {
            b2[0] = perMsgId;
        } else {
            if (b2 == null) {
                b2 = new String[0];
            }
            int i2 = perMsgId == null ? 0 : 1;
            int length = b2.length;
            String[] strArr = new String[(length + i2)];
            for (int i3 = 0; i3 < length; i3++) {
                strArr[i3] = b2[i3];
            }
            if (i2 == 1) {
                strArr[length] = perMsgId;
            }
            b2 = strArr;
        }
        h.a(f15013b, "updatePerMsgList() perMsgId=".concat(String.valueOf(perMsgId)));
        String str = "";
        for (int i4 = 0; i4 < b2.length; i4++) {
            if (i4 > 0) {
                str = str + AppConstants.COMMA;
            }
            str = str + b2[i4];
        }
        h.a(f15013b, "saveMsgRecord() listMsgId:".concat(String.valueOf(str)));
        try {
            File file = new File(a() + this.f15011a);
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception unused) {
            h.a(f15013b, "saveMsgRecord() encounter exception!");
        }
    }
}
