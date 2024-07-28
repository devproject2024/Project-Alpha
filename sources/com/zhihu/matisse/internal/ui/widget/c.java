package com.zhihu.matisse.internal.ui.widget;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.appcompat.app.c;
import com.paytm.android.chat.R;
import net.one97.paytm.i.g;

public class c extends g {
    public static c a(String str, String str2) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putString("extra_title", str);
        bundle.putString("extra_message", str2);
        cVar.setArguments(bundle);
        return cVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        String string = getArguments().getString("extra_title");
        String string2 = getArguments().getString("extra_message");
        c.a aVar = new c.a(getActivity());
        if (!TextUtils.isEmpty(string)) {
            aVar.a((CharSequence) string);
        }
        if (!TextUtils.isEmpty(string2)) {
            aVar.b((CharSequence) string2);
        }
        aVar.a(R.string.chat_module_button_ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        return aVar.a();
    }
}
