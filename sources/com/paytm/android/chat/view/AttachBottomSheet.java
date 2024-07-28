package com.paytm.android.chat.view;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.b;

public class AttachBottomSheet extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    com.google.android.material.bottomsheet.a f42433a;

    /* renamed from: b  reason: collision with root package name */
    RecyclerView f42434b = ((RecyclerView) findViewById(R.id.rv));

    /* renamed from: c  reason: collision with root package name */
    LinearLayoutManager f42435c;

    /* renamed from: d  reason: collision with root package name */
    b f42436d;

    public interface a {
        void a(b.a aVar, String str);
    }

    public AttachBottomSheet(Context context, com.google.android.material.bottomsheet.a aVar, a aVar2) {
        super(context);
        inflate(context, R.layout.chat_attach_bottom_sheet, this);
        this.f42433a = aVar;
        this.f42433a.setContentView((View) this);
        ((View) getParent()).setBackgroundColor(getResources().getColor(17170445));
        this.f42435c = new LinearLayoutManager(context, 1, false);
        this.f42436d = new b(aVar2);
        this.f42434b.setLayoutManager(this.f42435c);
        this.f42434b.setAdapter(this.f42436d);
    }

    public final void a(boolean z, boolean z2) {
        if (this.f42433a != null) {
            b bVar = this.f42436d;
            if (!z || !z2) {
                bVar.f41037a.clear();
                bVar.f41037a.add(new b.a("Photos", R.drawable.chat_icon_chat_multi_item_gallery));
                bVar.f41037a.add(new b.a("Songs", R.drawable.chat_icon_chat_multi_item_audio));
                bVar.f41037a.add(new b.a("Contacts", R.drawable.chat_icon_chat_multi_item_contact2));
                bVar.f41037a.add(new b.a("Documents", R.drawable.chat_icon_chat_multi_item_document));
            } else {
                bVar.f41037a.clear();
                bVar.f41037a.add(new b.a("Send Money", R.drawable.chat_ic_payment));
                bVar.f41037a.add(new b.a("Photos", R.drawable.chat_icon_chat_multi_item_gallery));
                bVar.f41037a.add(new b.a("Songs", R.drawable.chat_icon_chat_multi_item_audio));
                bVar.f41037a.add(new b.a("Contacts", R.drawable.chat_icon_chat_multi_item_contact2));
                bVar.f41037a.add(new b.a("Documents", R.drawable.chat_icon_chat_multi_item_document));
            }
            bVar.notifyDataSetChanged();
            this.f42433a.show();
        }
    }

    public final void a() {
        com.google.android.material.bottomsheet.a aVar = this.f42433a;
        if (aVar != null) {
            aVar.dismiss();
        }
    }
}
