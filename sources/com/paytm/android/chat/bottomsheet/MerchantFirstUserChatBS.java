package com.paytm.android.chat.bottomsheet;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.b;
import com.paytm.android.chat.R;
import com.paytm.android.chat.f;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;

public final class MerchantFirstUserChatBS extends BottomSheetBaseView {

    /* renamed from: c  reason: collision with root package name */
    private final String f41826c;

    /* renamed from: d  reason: collision with root package name */
    private final String f41827d;

    /* renamed from: e  reason: collision with root package name */
    private final String f41828e;

    /* renamed from: f  reason: collision with root package name */
    private final String f41829f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f41830g;

    public final View a(int i2) {
        if (this.f41830g == null) {
            this.f41830g = new HashMap();
        }
        View view = (View) this.f41830g.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f41830g.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return true;
    }

    public final String getImageUrl() {
        return this.f41826c;
    }

    public final String getTitle() {
        return this.f41827d;
    }

    public final String getDesc() {
        return this.f41828e;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MerchantFirstUserChatBS(Context context, String str, String str2, String str3, String str4) {
        super(context);
        String a2;
        String a3;
        String a4;
        String a5;
        k.c(context, "context");
        this.f41826c = str;
        this.f41827d = str2;
        this.f41828e = str3;
        this.f41829f = str4;
        ((CardView) a(R.id.btnDismiss)).setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ MerchantFirstUserChatBS f41831a;

            {
                this.f41831a = r1;
            }

            public final void onClick(View view) {
                this.f41831a.f41815a.dismiss();
            }
        });
        String str5 = this.f41826c;
        if (!(str5 == null || (a5 = f.a(str5)) == null)) {
            b.b(context).a(a5).a((ImageView) (AppCompatImageView) a(R.id.top_logo));
        }
        String str6 = this.f41827d;
        if (!(str6 == null || (a4 = f.a(str6)) == null)) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.txtTitle);
            k.a((Object) roboTextView, "txtTitle");
            roboTextView.setText(a4);
        }
        String str7 = this.f41828e;
        if (!(str7 == null || (a3 = f.a(str7)) == null)) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.txtDescription);
            k.a((Object) roboTextView2, "txtDescription");
            roboTextView2.setText(a3);
        }
        String str8 = this.f41829f;
        if (str8 != null && (a2 = f.a(str8)) != null) {
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.btnTextView);
            k.a((Object) roboTextView3, "btnTextView");
            roboTextView3.setText(a2);
        }
    }

    public final String getBtnText() {
        return this.f41829f;
    }

    /* access modifiers changed from: protected */
    public final int b() {
        return R.layout.chat_bottom_sheet_merchant_first_user_chat;
    }
}
