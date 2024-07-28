package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.paytm.android.chat.R;

public final class b extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    public View f45893a;

    /* renamed from: b  reason: collision with root package name */
    public ListView f45894b = ((ListView) this.f45897e.findViewById(R.id.folder_list));

    /* renamed from: c  reason: collision with root package name */
    public ListAdapter f45895c;

    /* renamed from: d  reason: collision with root package name */
    private Context f45896d;

    /* renamed from: e  reason: collision with root package name */
    private View f45897e;

    public b(Context context) {
        this.f45896d = context;
        this.f45897e = LayoutInflater.from(context).inflate(R.layout.chat_folder_popup, (ViewGroup) null);
        setContentView(this.f45897e);
        setHeight(-2);
        setWidth(-1);
        setFocusable(true);
        setOutsideTouchable(true);
        update();
        setBackgroundDrawable(new ColorDrawable(-1));
    }
}
