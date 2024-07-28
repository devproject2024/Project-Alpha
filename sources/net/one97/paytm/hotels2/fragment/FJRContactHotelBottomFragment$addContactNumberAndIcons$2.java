package net.one97.paytm.hotels2.fragment;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

final class FJRContactHotelBottomFragment$addContactNumberAndIcons$2 implements View.OnClickListener {
    final /* synthetic */ String $number;
    final /* synthetic */ FJRContactHotelBottomFragment this$0;

    FJRContactHotelBottomFragment$addContactNumberAndIcons$2(FJRContactHotelBottomFragment fJRContactHotelBottomFragment, String str) {
        this.this$0 = fJRContactHotelBottomFragment;
        this.$number = str;
    }

    public final void onClick(View view) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel: " + this.$number));
        this.this$0.startActivity(intent);
    }
}
