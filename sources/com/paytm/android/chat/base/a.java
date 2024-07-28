package com.paytm.android.chat.base;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytm.android.chat.bean.jsonbean.UpdateUserJsonBean;
import com.paytm.android.chat.c;
import com.paytm.android.chat.fragment.a;
import com.paytm.android.chat.fragment.b;
import com.paytm.android.chat.network.requests.UpdateUserInfoRequest;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.LoadingDialog;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public class a extends h implements b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f41807a = false;

    /* renamed from: b  reason: collision with root package name */
    private LoadingDialog f41808b = null;

    /* renamed from: c  reason: collision with root package name */
    private com.paytm.android.chat.fragment.a f41809c;

    public void b() {
    }

    public void onCreate(Bundle bundle) {
        Context context;
        super.onCreate(bundle);
        if (c.a() == null) {
            try {
                AppUtilKt.reInitializeChatManager(getContext());
            } catch (Exception unused) {
            }
        }
        if (!f41807a && (context = getContext()) != null) {
            String myProfilePic = AppUtilKt.getMyProfilePic(context);
            if (!TextUtils.isEmpty(myProfilePic)) {
                UpdateUserJsonBean updateUserJsonBean = new UpdateUserJsonBean();
                updateUserJsonBean.setAvatar(myProfilePic);
                new UpdateUserInfoRequest(updateUserJsonBean, new c.a.a.a<String>() {
                    public final void a(int i2, String str) {
                    }

                    public final /* synthetic */ void a(Object obj) {
                        boolean unused = a.f41807a = true;
                    }
                });
            }
        }
    }

    public void onStop() {
        super.onStop();
    }

    public final void a() {
        com.paytm.android.chat.fragment.a aVar = this.f41809c;
        if (aVar != null) {
            aVar.dismiss();
        }
        a.C0695a aVar2 = com.paytm.android.chat.fragment.a.f42036a;
        k.c(this, "listener");
        com.paytm.android.chat.fragment.a aVar3 = new com.paytm.android.chat.fragment.a();
        aVar3.f42037b = this;
        this.f41809c = aVar3;
        this.f41809c.show(getChildFragmentManager(), (String) null);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            AppUtilKt.reInitializeChatManager(context);
        } catch (Exception unused) {
        }
    }
}
