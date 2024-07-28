package com.paytm.android.chat.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.fragment.CharPortraitView;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.ImageUtils;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType;

public class ChatHeadView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f42443a;

    /* renamed from: b  reason: collision with root package name */
    private CharPortraitView f42444b;

    /* renamed from: c  reason: collision with root package name */
    private RelativeLayout f42445c;

    public ChatHeadView(Context context) {
        super(context);
        a(context);
    }

    public ChatHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ChatHeadView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_layout_chat_head_view, this);
        this.f42443a = (ImageView) findViewById(R.id.image_chat_head_view);
        this.f42444b = (CharPortraitView) findViewById(R.id.text_chat_head_view);
        this.f42445c = (RelativeLayout) findViewById(R.id.container);
    }

    public void setOnlinePaymentUI(ReceiverDisplayInfo receiverDisplayInfo) {
        CharPortraitView charPortraitView;
        if (this.f42443a != null && (charPortraitView = this.f42444b) != null) {
            charPortraitView.setVisibility(8);
            this.f42443a.setVisibility(0);
            if (receiverDisplayInfo == null || receiverDisplayInfo.getChatType() == null) {
                ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_placeholder));
                return;
            }
            switch (receiverDisplayInfo.getChatType()) {
                case P2VPA:
                case P2VPAM:
                    if (!TextUtils.isEmpty(receiverDisplayInfo.getProfileImage())) {
                        ImageUtils.displayCircleCropFromUrl(getContext(), receiverDisplayInfo.getProfileImage(), this.f42443a);
                        return;
                    } else {
                        ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_upi_placeholder));
                        return;
                    }
                case P2BK:
                    if (!TextUtils.isEmpty(receiverDisplayInfo.getProfileImage())) {
                        ImageUtils.displayCircleCropFromUrl(getContext(), receiverDisplayInfo.getProfileImage(), this.f42443a);
                        return;
                    } else {
                        ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_bank_placeholder));
                        return;
                    }
                case P2P:
                case P2C:
                case P2M:
                    if (!TextUtils.isEmpty(receiverDisplayInfo.getProfileImage())) {
                        ImageUtils.displayCircleCropFromUrl(getContext(), receiverDisplayInfo.getProfileImage(), this.f42443a);
                        return;
                    } else {
                        ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_placeholder));
                        return;
                    }
                default:
                    return;
            }
        }
    }

    public void setOfflineUI(ChatUserDataModel chatUserDataModel) {
        CharPortraitView charPortraitView;
        if (this.f42443a != null && (charPortraitView = this.f42444b) != null) {
            charPortraitView.setVisibility(8);
            this.f42443a.setVisibility(0);
            if (!TextUtils.isEmpty(chatUserDataModel.getAvatarUrl())) {
                ImageUtils.displayCircleCropFromUrl(getContext(), chatUserDataModel.getAvatarUrl(), this.f42443a);
            } else if (chatUserDataModel.getType() != null) {
                int i2 = AnonymousClass1.f42447b[chatUserDataModel.getType().ordinal()];
                if (i2 == 1) {
                    ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_upi_placeholder));
                } else if (i2 == 2) {
                    ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_bank_placeholder));
                } else if (i2 == 3 || i2 == 4 || i2 == 5) {
                    ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_placeholder));
                } else {
                    ImageUtils.displayCircleCropFromDrawable(getContext(), this.f42443a, b.a(getContext(), R.drawable.ic_chat_user_placeholder));
                }
            }
        }
    }

    /* renamed from: com.paytm.android.chat.view.ChatHeadView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f42447b = new int[ChatUserType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        static {
            /*
                net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType[] r0 = net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42447b = r0
                r0 = 1
                int[] r1 = f42447b     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r2 = net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType.VPA     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f42447b     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r3 = net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType.BANK     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f42447b     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r4 = net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType.CUSTOMER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f42447b     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r5 = net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType.MERCHANT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = f42447b     // Catch:{ NoSuchFieldError -> 0x0040 }
                net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType r6 = net.one97.paytm.common.entity.chat.moneytransfer.ChatUserType.MOBILE_NUMBER     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                com.paytm.android.chat.bean.ChatType[] r5 = com.paytm.android.chat.bean.ChatType.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f42446a = r5
                int[] r5 = f42446a     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.paytm.android.chat.bean.ChatType r6 = com.paytm.android.chat.bean.ChatType.P2VPA     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = f42446a     // Catch:{ NoSuchFieldError -> 0x005d }
                com.paytm.android.chat.bean.ChatType r5 = com.paytm.android.chat.bean.ChatType.P2VPAM     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = f42446a     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.paytm.android.chat.bean.ChatType r1 = com.paytm.android.chat.bean.ChatType.P2BK     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = f42446a     // Catch:{ NoSuchFieldError -> 0x0071 }
                com.paytm.android.chat.bean.ChatType r1 = com.paytm.android.chat.bean.ChatType.P2P     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = f42446a     // Catch:{ NoSuchFieldError -> 0x007b }
                com.paytm.android.chat.bean.ChatType r1 = com.paytm.android.chat.bean.ChatType.P2C     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = f42446a     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.paytm.android.chat.bean.ChatType r1 = com.paytm.android.chat.bean.ChatType.P2M     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.ChatHeadView.AnonymousClass1.<clinit>():void");
        }
    }

    public void setUI(String str, String str2) {
        if (this.f42443a != null && this.f42444b != null) {
            if (TextUtils.isEmpty(str2)) {
                this.f42444b.setVisibility(8);
            } else {
                this.f42444b.a(str2);
                this.f42444b.setVisibility(0);
            }
            if (TextUtils.isEmpty(str)) {
                this.f42443a.setVisibility(8);
                return;
            }
            ImageUtils.displayCircleCropFromUrl(getContext(), str, this.f42443a);
            this.f42444b.setVisibility(8);
            this.f42443a.setVisibility(0);
        }
    }

    public void setContainerBG(int i2) {
        this.f42445c.setBackgroundColor(getResources().getColor(i2));
    }

    public void setUI(String str, String str2, String str3, String str4) {
        if (this.f42443a != null && this.f42444b != null) {
            if (!TextUtils.isEmpty(str4)) {
                SyncContactBean searchContactByPhone = ContactManager.getInstance().searchContactByPhone(str4);
                if (searchContactByPhone != null) {
                    q.a("setUI: " + searchContactByPhone.toString());
                }
                if (searchContactByPhone != null && !"".equals(searchContactByPhone.getContactPic()) && searchContactByPhone.getContactPic() != null) {
                    this.f42443a.setVisibility(0);
                    this.f42444b.setVisibility(8);
                    ImageUtils.displayCircleCropFromUrl(getContext(), searchContactByPhone.getContactPic(), this.f42443a);
                } else if (!TextUtils.isEmpty(str)) {
                    this.f42443a.setVisibility(0);
                    this.f42444b.setVisibility(8);
                    ImageUtils.displayCircleCropFromUrl(getContext(), str, this.f42443a);
                } else {
                    this.f42443a.setVisibility(8);
                    this.f42444b.setVisibility(0);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f42444b.a(str2);
                    } else {
                        this.f42444b.a(str3);
                    }
                }
            } else if (!TextUtils.isEmpty(str)) {
                this.f42443a.setVisibility(0);
                this.f42444b.setVisibility(8);
                ImageUtils.displayCircleCropFromUrl(getContext(), str, this.f42443a);
            } else {
                this.f42443a.setVisibility(8);
                this.f42444b.setVisibility(0);
                if (!TextUtils.isEmpty(str2)) {
                    this.f42444b.a(str2);
                } else {
                    this.f42444b.a(str3);
                }
            }
        }
    }

    public TextView getInitialTextView() {
        return this.f42444b;
    }
}
