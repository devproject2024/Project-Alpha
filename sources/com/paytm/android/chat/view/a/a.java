package com.paytm.android.chat.view.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.DensityUtil;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import java.util.List;

public final class a extends PopupWindow implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextView f42545a;

    /* renamed from: b  reason: collision with root package name */
    private ImageView f42546b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f42547c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f42548d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f42549e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f42550f;

    /* renamed from: g  reason: collision with root package name */
    private C0705a f42551g;

    /* renamed from: com.paytm.android.chat.view.a.a$a  reason: collision with other inner class name */
    public interface C0705a {
        void a();

        void b();

        void c();

        void d();

        void e();

        void f();
    }

    public a(Context context) {
        super(context);
        View inflate = LayoutInflater.from(context).inflate(R.layout.chat_pop_group_chat_top_menu, (ViewGroup) null);
        setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
        setHeight(DensityUtil.dp2px(80.0f));
        setWidth(-1);
        setContentView(inflate);
        this.f42545a = (TextView) inflate.findViewById(R.id.text_group_chat_menu_close);
        this.f42546b = (ImageView) inflate.findViewById(R.id.image_group_chat_menu_forward);
        this.f42547c = (ImageView) inflate.findViewById(R.id.image_group_chat_menu_copy);
        this.f42548d = (ImageView) inflate.findViewById(R.id.image_group_chat_menu_reply);
        this.f42549e = (ImageView) inflate.findViewById(R.id.image_group_chat_menu_start);
        this.f42550f = (ImageView) inflate.findViewById(R.id.image_group_chat_menu_delete);
        this.f42545a.setOnClickListener(this);
        this.f42546b.setOnClickListener(this);
        this.f42548d.setOnClickListener(this);
        this.f42549e.setOnClickListener(this);
        this.f42550f.setOnClickListener(this);
        this.f42547c.setOnClickListener(this);
    }

    public final void a(List<BaseMessage> list) {
        int size = list.size();
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (BaseMessage next : list) {
            if (next instanceof FileMessage) {
                z = true;
            }
            if (next.getCustomType().equals("contact") || next.getCustomType().equals("location")) {
                z2 = true;
            }
            if (next.getCustomType().equals("TRANSFER") || next.getCustomType().equals("TRANSFER_FAIL")) {
                z3 = true;
            }
        }
        if (size == 0) {
            dismiss();
        } else if (size > 1) {
            this.f42547c.setVisibility(8);
            if (!z && !z2) {
                if (z3) {
                    this.f42546b.setVisibility(8);
                }
                this.f42546b.setVisibility(0);
            }
            this.f42548d.setVisibility(8);
        } else {
            if (z || z2 || z3) {
                this.f42547c.setVisibility(8);
            } else {
                this.f42547c.setVisibility(0);
            }
            this.f42548d.setVisibility(8);
            if (z3) {
                this.f42546b.setVisibility(8);
            }
        }
    }

    public final void onClick(View view) {
        if (this.f42551g != null) {
            int id = view.getId();
            if (id == R.id.text_group_chat_menu_close) {
                this.f42551g.f();
                dismiss();
            } else if (id == R.id.image_group_chat_menu_reply) {
                this.f42551g.c();
                dismiss();
            } else if (id == R.id.image_group_chat_menu_copy) {
                this.f42551g.b();
                dismiss();
            } else if (id == R.id.image_group_chat_menu_forward) {
                this.f42551g.a();
            } else if (id == R.id.image_group_chat_menu_start) {
                this.f42551g.d();
                dismiss();
            } else if (id == R.id.image_group_chat_menu_delete) {
                this.f42551g.e();
                dismiss();
            }
        }
    }

    public final void a(C0705a aVar) {
        this.f42551g = aVar;
    }
}
