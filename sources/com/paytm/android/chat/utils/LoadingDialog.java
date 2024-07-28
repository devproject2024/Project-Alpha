package com.paytm.android.chat.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.paytm.android.chat.R;

public class LoadingDialog extends Dialog {
    LinearLayout chat_list_load_text;

    public LoadingDialog(Context context, boolean z) {
        super(context, R.style.LoadingDialog);
        View inflate = LayoutInflater.from(context).inflate(R.layout.chat_dialog_loading, (ViewGroup) null, false);
        this.chat_list_load_text = (LinearLayout) inflate.findViewById(R.id.chat_list_load_text);
        if (z) {
            this.chat_list_load_text.setVisibility(0);
        } else {
            this.chat_list_load_text.setVisibility(8);
        }
        setContentView(inflate);
        setCanceledOnTouchOutside(false);
    }
}
