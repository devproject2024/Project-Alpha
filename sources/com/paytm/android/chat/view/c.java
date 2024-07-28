package com.paytm.android.chat.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;

public class c extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f42559b = (!c.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    a f42560a;

    public interface a {
        void a(int i2);
    }

    public c(Context context, a aVar) {
        super(context, R.style.ChangeImgMethodDialog);
        this.f42560a = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_layout_dialog_image_sel_method);
        setCanceledOnTouchOutside(true);
        getWindow().getAttributes().gravity = 80;
        getWindow().getAttributes().width = -1;
        getWindow().getAttributes().height = -2;
        final TextView textView = (TextView) findViewById(R.id.image_sel_method_gallery);
        final TextView textView2 = (TextView) findViewById(R.id.image_sel_method_camera);
        TextView textView3 = (TextView) findViewById(R.id.image_sel_method_remove);
        if (this.f42560a != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick()) {
                        c.this.f42560a.a(0);
                        c.this.dismiss();
                    }
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick()) {
                        c.this.f42560a.a(1);
                        c.this.dismiss();
                    }
                }
            });
            textView3.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick()) {
                        c.this.f42560a.a(2);
                        c.this.dismiss();
                    }
                }
            });
        }
        Window window = getWindow();
        if (f42559b || window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 40;
            onWindowAttributesChanged(attributes);
            return;
        }
        throw new AssertionError();
    }
}
