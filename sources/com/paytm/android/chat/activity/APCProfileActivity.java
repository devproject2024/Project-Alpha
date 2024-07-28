package com.paytm.android.chat.activity;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import com.google.android.material.snackbar.Snackbar;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.base.APCBaseActivity;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.UserType;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.g.b;
import com.paytm.android.chat.h.a.a;
import com.paytm.android.chat.h.c;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.view.ChatHeadView;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import com.paytm.utility.RoboTextView;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.m.p;

public final class APCProfileActivity extends APCBaseActivity<com.paytm.android.chat.h.c, com.paytm.android.chat.g.b> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f41565b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    protected com.paytm.android.chat.h.c f41566a;

    /* renamed from: c  reason: collision with root package name */
    private androidx.appcompat.app.c f41567c;

    /* renamed from: d  reason: collision with root package name */
    private Snackbar f41568d;

    /* renamed from: e  reason: collision with root package name */
    private int f41569e = R.layout.chat_activity_profile;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f41570f;

    public final View a(int i2) {
        if (this.f41570f == null) {
            this.f41570f = new HashMap();
        }
        View view = (View) this.f41570f.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f41570f.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX WARNING: Removed duplicated region for block: B:138:0x0432  */
    /* JADX WARNING: Removed duplicated region for block: B:195:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01f3  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x029a  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x029d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x029f  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.paytm.android.chat.base.e r23) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            com.paytm.android.chat.g.b r1 = (com.paytm.android.chat.g.b) r1
            java.lang.String r2 = "state"
            kotlin.g.b.k.c(r1, r2)
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.d
            if (r2 == 0) goto L_0x001b
            com.paytm.android.chat.g.b$d r1 = (com.paytm.android.chat.g.b.d) r1
            int r1 = r1.f42147a
            r0.setResult(r1)
            r22.finish()
            return
        L_0x001b:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.a
            if (r2 == 0) goto L_0x0027
            com.paytm.android.chat.g.b$a r1 = (com.paytm.android.chat.g.b.a) r1
            int r1 = r1.f42144a
            r0.setResult(r1)
            return
        L_0x0027:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.g
            java.lang.String r3 = "switchBlock"
            java.lang.String r4 = "switchMute"
            r6 = 1
            if (r2 == 0) goto L_0x0467
            com.paytm.android.chat.g.b$g r1 = (com.paytm.android.chat.g.b.g) r1
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r1.f42154a
            com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity$ChatPaymentMetadata r1 = r1.f42155b
            java.lang.String r7 = r2.getChannelUrl()
            com.sendbird.android.GroupChannel r7 = com.paytm.android.chat.d.a.b.a(r7)
            com.paytm.android.chat.ChatManager r8 = com.paytm.android.chat.ChatManager.b()
            if (r7 == 0) goto L_0x004b
            java.lang.String r10 = r7.getUrl()
            goto L_0x004c
        L_0x004b:
            r10 = 0
        L_0x004c:
            com.paytm.android.chat.d r8 = r8.a((java.lang.String) r10)
            com.paytm.android.chat.bean.ReceiverDisplayInfo r10 = r2.getReceiverDisplayInfo()
            com.paytm.android.chat.bean.UserType r11 = r10.getUserType()
            int r12 = com.paytm.android.chat.R.id.layoutMute
            android.view.View r12 = r0.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            java.lang.String r13 = "layoutMute"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.view.View r12 = (android.view.View) r12
            com.paytm.android.chat.f.a((android.view.View) r12, (boolean) r6)
            int r12 = com.paytm.android.chat.R.id.layoutBlock
            android.view.View r12 = r0.a((int) r12)
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            java.lang.String r13 = "layoutBlock"
            kotlin.g.b.k.a((java.lang.Object) r12, (java.lang.String) r13)
            android.view.View r12 = (android.view.View) r12
            com.paytm.android.chat.f.a((android.view.View) r12, (boolean) r6)
            if (r7 == 0) goto L_0x0083
            com.sendbird.android.Member r12 = com.paytm.android.chat.utils.ChatVariantUtilKt.getChannelDisplayMember((com.sendbird.android.GroupChannel) r7)
            goto L_0x0084
        L_0x0083:
            r12 = 0
        L_0x0084:
            java.lang.String r15 = ""
            if (r12 == 0) goto L_0x0133
            com.paytm.android.chat.bean.ChatType r9 = r10.getChatType()
            com.paytm.android.chat.bean.ChatType$Companion r14 = com.paytm.android.chat.bean.ChatType.Companion
            java.lang.String r5 = "P2C"
            com.paytm.android.chat.bean.ChatType r5 = r14.fromString(r5)
            if (r9 != r5) goto L_0x0133
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r5 = com.paytm.android.chat.utils.ChatConfigUtil.Companion
            com.paytm.android.chat.utils.ChatConfigUtil r5 = r5.getInstance()
            boolean r5 = r5.isP4B()
            if (r5 == 0) goto L_0x00bc
            r10.setReceiver(r12)
            com.paytm.android.chat.bean.UserType r5 = r10.getUserType()
            com.paytm.android.chat.bean.UserType r9 = com.paytm.android.chat.bean.UserType.CUSTOMER
            if (r5 == r9) goto L_0x00b8
            com.paytm.android.chat.bean.UserType r5 = r10.getUserType()
            com.paytm.android.chat.bean.UserType r9 = com.paytm.android.chat.bean.UserType.MERCHANT
            if (r5 == r9) goto L_0x00b8
            r10.setName(r15)
        L_0x00b8:
            r10.setPhoneNumber(r15)
            goto L_0x0116
        L_0x00bc:
            com.paytm.android.chat.bean.UserType r11 = com.paytm.android.chat.bean.UserType.CHANNEL
            r10.setReceiver(r12)
            r5 = r12
            com.sendbird.android.User r5 = (com.sendbird.android.User) r5
            com.paytm.android.chat.bean.UserMetaData r9 = com.paytm.android.chat.g.a((com.sendbird.android.User) r5)
            if (r9 == 0) goto L_0x00cf
            java.lang.String r9 = r9.getName()
            goto L_0x00d0
        L_0x00cf:
            r9 = 0
        L_0x00d0:
            r10.setName(r9)
            java.lang.String r9 = r12.getPlainProfileImageUrl()
            r10.setProfileImage(r9)
            r10.setPhoneNumber(r15)
            com.paytm.android.chat.bean.UserMetaData r9 = com.paytm.android.chat.g.a((com.sendbird.android.User) r5)
            if (r9 == 0) goto L_0x00e8
            java.lang.String r9 = r9.getPaytmChannelId()
            goto L_0x00e9
        L_0x00e8:
            r9 = 0
        L_0x00e9:
            r10.setPaytmChannelId(r9)
            com.paytm.android.chat.bean.UserMetaData r9 = com.paytm.android.chat.g.a((com.sendbird.android.User) r5)
            if (r9 == 0) goto L_0x00f7
            java.lang.String r9 = r9.getName()
            goto L_0x00f8
        L_0x00f7:
            r9 = 0
        L_0x00f8:
            r10.setBusinessName(r9)
            com.paytm.android.chat.bean.UserMetaData r5 = com.paytm.android.chat.g.a((com.sendbird.android.User) r5)
            if (r5 == 0) goto L_0x0106
            java.lang.String r9 = r5.getAddressString()
            goto L_0x0107
        L_0x0106:
            r9 = 0
        L_0x0107:
            r10.setAddress(r9)
            r10.setBusinessNameAvailable(r6)
            r5 = 0
            r10.setFromContact(r5)
            com.paytm.android.chat.bean.UserType r5 = com.paytm.android.chat.bean.UserType.CHANNEL
            r10.setUserType(r5)
        L_0x0116:
            if (r7 == 0) goto L_0x0130
            int r5 = r7.getMemberCount()
            r9 = 2
            if (r5 <= r9) goto L_0x0130
            int r5 = com.paytm.android.chat.R.id.layoutBlock
            android.view.View r5 = r0.a((int) r5)
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r13)
            android.view.View r5 = (android.view.View) r5
            r9 = 0
            com.paytm.android.chat.f.a((android.view.View) r5, (boolean) r9)
        L_0x0130:
            r0.a((com.paytm.android.chat.bean.ReceiverDisplayInfo) r10, (com.paytm.android.chat.bean.UserType) r11)
        L_0x0133:
            java.lang.String r5 = r10.getPhoneNumber()
            if (r1 == 0) goto L_0x0194
            com.sendbird.android.BaseChannel r7 = (com.sendbird.android.BaseChannel) r7
            com.paytm.android.chat.bean.ChannelMetaData r7 = com.paytm.android.chat.g.a((com.sendbird.android.BaseChannel) r7)
            if (r7 == 0) goto L_0x0146
            com.paytm.android.chat.bean.ChatType r9 = r7.getChatType()
            goto L_0x0147
        L_0x0146:
            r9 = 0
        L_0x0147:
            if (r9 != 0) goto L_0x014a
            goto L_0x0194
        L_0x014a:
            int[] r7 = com.paytm.android.chat.activity.b.f41759a
            int r9 = r9.ordinal()
            r7 = r7[r9]
            if (r7 == r6) goto L_0x018d
            r9 = 2
            if (r7 == r9) goto L_0x018d
            r9 = 3
            if (r7 == r9) goto L_0x015b
            goto L_0x0194
        L_0x015b:
            java.lang.String r5 = r1.getBankName()
            if (r5 != 0) goto L_0x016a
            java.lang.String r5 = r1.getMaskedAccNo()
            if (r5 == 0) goto L_0x0168
            goto L_0x016a
        L_0x0168:
            r5 = 0
            goto L_0x0192
        L_0x016a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r1.getBankName()
            if (r7 != 0) goto L_0x0176
            r7 = r15
        L_0x0176:
            r5.append(r7)
            r7 = 32
            r5.append(r7)
            java.lang.String r1 = r1.getMaskedAccNo()
            if (r1 != 0) goto L_0x0185
            r1 = r15
        L_0x0185:
            r5.append(r1)
            java.lang.String r9 = r5.toString()
            goto L_0x0191
        L_0x018d:
            java.lang.String r9 = r1.getVpa()
        L_0x0191:
            r5 = r9
        L_0x0192:
            r1 = 1
            goto L_0x0195
        L_0x0194:
            r1 = 0
        L_0x0195:
            int r7 = com.paytm.android.chat.R.id.switchBlock
            android.view.View r7 = r0.a((int) r7)
            android.widget.Switch r7 = (android.widget.Switch) r7
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r3)
            com.paytm.android.chat.h.c r3 = r22.c()
            boolean r3 = r3.f42263d
            r7.setChecked(r3)
            int r3 = com.paytm.android.chat.R.id.switchMute
            android.view.View r3 = r0.a((int) r3)
            android.widget.Switch r3 = (android.widget.Switch) r3
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            boolean r4 = r2.isPushEnabled()
            r4 = r4 ^ r6
            r3.setChecked(r4)
            int r3 = com.paytm.android.chat.R.id.profileName
            android.view.View r3 = r0.a((int) r3)
            com.paytm.utility.RoboTextView r3 = (com.paytm.utility.RoboTextView) r3
            java.lang.String r4 = "profileName"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r4 = r10.getName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            java.lang.String r3 = "Resources.getSystem()"
            java.lang.String r4 = "profileImageHead"
            if (r1 == 0) goto L_0x01f3
            int r1 = com.paytm.android.chat.R.id.profileImageHead
            android.view.View r1 = r0.a((int) r1)
            com.paytm.android.chat.view.ChatHeadView r1 = (com.paytm.android.chat.view.ChatHeadView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r7 = 0
            r1.setVisibility(r7)
            int r1 = com.paytm.android.chat.R.id.profileImageHead
            android.view.View r1 = r0.a((int) r1)
            com.paytm.android.chat.view.ChatHeadView r1 = (com.paytm.android.chat.view.ChatHeadView) r1
            r1.setOnlinePaymentUI(r10)
            goto L_0x0259
        L_0x01f3:
            r7 = 0
            java.lang.String r1 = r10.getProfileImage()
            boolean r1 = kotlin.m.p.a((java.lang.String) r1, (java.lang.String) r15, (boolean) r7)
            if (r1 == 0) goto L_0x0220
            int r1 = com.paytm.android.chat.R.id.profileImageHead
            android.view.View r1 = r0.a((int) r1)
            com.paytm.android.chat.view.ChatHeadView r1 = (com.paytm.android.chat.view.ChatHeadView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r1.setVisibility(r7)
            int r1 = com.paytm.android.chat.R.id.profileImageHead
            android.view.View r1 = r0.a((int) r1)
            com.paytm.android.chat.view.ChatHeadView r1 = (com.paytm.android.chat.view.ChatHeadView) r1
            java.lang.String r4 = r10.getProfileImage()
            java.lang.String r7 = r10.getName()
            r1.setUI(r4, r7)
            goto L_0x0259
        L_0x0220:
            int r1 = com.paytm.android.chat.R.id.profileImage
            android.view.View r1 = r0.a((int) r1)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            java.lang.String r4 = "profileImage"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r4 = 0
            r1.setVisibility(r4)
            r16 = r0
            android.content.Context r16 = (android.content.Context) r16
            java.lang.String r17 = r10.getProfileImage()
            int r1 = com.paytm.android.chat.R.id.profileImage
            android.view.View r1 = r0.a((int) r1)
            r18 = r1
            android.widget.ImageView r18 = (android.widget.ImageView) r18
            r19 = 0
            r20 = 0
            android.content.res.Resources r1 = android.content.res.Resources.getSystem()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.widthPixels
            r21 = r1
            com.paytm.android.chat.utils.ImageUtils.displayImageFromUrl2(r16, r17, r18, r19, r20, r21)
        L_0x0259:
            int r1 = com.paytm.android.chat.R.id.contactNumber
            android.view.View r1 = r0.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            java.lang.String r4 = "contactNumber"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r1.setText(r5)
            int r1 = com.paytm.android.chat.R.id.contactNumber
            android.view.View r1 = r0.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            android.view.View r1 = (android.view.View) r1
            boolean r4 = android.text.TextUtils.isEmpty(r5)
            r4 = r4 ^ r6
            com.paytm.android.chat.f.a((android.view.View) r1, (boolean) r4)
            int r1 = com.paytm.android.chat.R.id.btnVisitStore
            android.view.View r1 = r0.a((int) r1)
            android.widget.Button r1 = (android.widget.Button) r1
            java.lang.String r4 = "btnVisitStore"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            android.view.View r1 = (android.view.View) r1
            java.lang.String r4 = r10.getPaytmChannelId()
            if (r4 == 0) goto L_0x029a
            java.lang.String r9 = com.paytm.android.chat.f.a((java.lang.String) r4)
            goto L_0x029b
        L_0x029a:
            r9 = 0
        L_0x029b:
            if (r9 == 0) goto L_0x029f
            r4 = 1
            goto L_0x02a0
        L_0x029f:
            r4 = 0
        L_0x02a0:
            com.paytm.android.chat.f.a((android.view.View) r1, (boolean) r4)
            android.content.Intent r1 = r22.getIntent()
            if (r1 == 0) goto L_0x03d0
            android.content.Intent r1 = r22.getIntent()
            java.lang.String r4 = "dateJoin"
            java.lang.String r1 = r1.getStringExtra(r4)
            boolean r1 = kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.Object) r15)
            r1 = r1 ^ r6
            if (r1 == 0) goto L_0x02ec
            int r1 = com.paytm.android.chat.R.id.since
            android.view.View r1 = r0.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            java.lang.String r5 = "since"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r7 = 0
            r1.setVisibility(r7)
            int r1 = com.paytm.android.chat.R.id.since
            android.view.View r1 = r0.a((int) r1)
            com.paytm.utility.RoboTextView r1 = (com.paytm.utility.RoboTextView) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            android.content.Intent r5 = r22.getIntent()
            java.lang.String r4 = r5.getStringExtra(r4)
            if (r4 == 0) goto L_0x02e6
            java.lang.String r9 = com.paytm.android.chat.f.a((java.lang.String) r4)
            goto L_0x02e7
        L_0x02e6:
            r9 = 0
        L_0x02e7:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r1.setText(r9)
        L_0x02ec:
            android.content.Intent r1 = r22.getIntent()
            java.lang.String r4 = "kyc_verified"
            r5 = 0
            boolean r1 = r1.getBooleanExtra(r4, r5)
            if (r1 == 0) goto L_0x03d0
            int r1 = com.paytm.android.chat.R.id.layoutKyc
            android.view.View r1 = r0.a((int) r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            java.lang.String r4 = "layoutKyc"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            android.view.View r1 = (android.view.View) r1
            com.paytm.android.chat.f.a((android.view.View) r1, (boolean) r6)
            int r1 = com.paytm.android.chat.R.id.divider_kyc
            android.view.View r1 = r0.a((int) r1)
            java.lang.String r4 = "divider_kyc"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            com.paytm.android.chat.f.a((android.view.View) r1, (boolean) r6)
            android.content.Intent r1 = r22.getIntent()
            java.lang.String r4 = "kyc_info"
            android.os.Parcelable r1 = r1.getParcelableExtra(r4)
            if (r1 == 0) goto L_0x03af
            android.content.Intent r1 = r22.getIntent()
            java.lang.String r4 = "kyc_info"
            android.os.Parcelable r1 = r1.getParcelableExtra(r4)
            com.paytm.android.chat.bean.jsonbean.KycInfo r1 = (com.paytm.android.chat.bean.jsonbean.KycInfo) r1
            if (r1 == 0) goto L_0x0338
            java.lang.String r9 = r1.getVerifiedIconUrl()
            goto L_0x0339
        L_0x0338:
            r9 = 0
        L_0x0339:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0346
            int r4 = r9.length()
            if (r4 != 0) goto L_0x0344
            goto L_0x0346
        L_0x0344:
            r4 = 0
            goto L_0x0347
        L_0x0346:
            r4 = 1
        L_0x0347:
            if (r4 != 0) goto L_0x0378
            r16 = r0
            android.content.Context r16 = (android.content.Context) r16
            if (r1 == 0) goto L_0x0356
            java.lang.String r9 = r1.getVerifiedIconUrl()
            r17 = r9
            goto L_0x0358
        L_0x0356:
            r17 = 0
        L_0x0358:
            int r4 = com.paytm.android.chat.R.id.iv_verified_badge
            android.view.View r4 = r0.a((int) r4)
            r18 = r4
            androidx.appcompat.widget.AppCompatImageView r18 = (androidx.appcompat.widget.AppCompatImageView) r18
            r19 = 0
            r20 = 0
            android.content.res.Resources r4 = android.content.res.Resources.getSystem()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r3)
            android.util.DisplayMetrics r3 = r4.getDisplayMetrics()
            int r3 = r3.widthPixels
            r21 = r3
            com.paytm.android.chat.utils.ImageUtils.displayImageFromUrl2(r16, r17, r18, r19, r20, r21)
        L_0x0378:
            int r3 = com.paytm.android.chat.R.id.tv_kyc_title
            android.view.View r3 = r0.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "tv_kyc_title"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            if (r1 == 0) goto L_0x038d
            java.lang.String r9 = r1.getKycNameKey()
            goto L_0x038e
        L_0x038d:
            r9 = 0
        L_0x038e:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r3.setText(r9)
            int r3 = com.paytm.android.chat.R.id.tv_kyc_name
            android.view.View r3 = r0.a((int) r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "tv_kyc_name"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            if (r1 == 0) goto L_0x03a8
            java.lang.String r9 = r1.getKycNameValue()
            goto L_0x03a9
        L_0x03a8:
            r9 = 0
        L_0x03a9:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r3.setText(r9)
            goto L_0x03d0
        L_0x03af:
            int r1 = com.paytm.android.chat.R.id.layoutKyc
            android.view.View r1 = r0.a((int) r1)
            androidx.constraintlayout.widget.ConstraintLayout r1 = (androidx.constraintlayout.widget.ConstraintLayout) r1
            java.lang.String r3 = "layoutKyc"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            android.view.View r1 = (android.view.View) r1
            r3 = 0
            com.paytm.android.chat.f.a((android.view.View) r1, (boolean) r3)
            int r1 = com.paytm.android.chat.R.id.divider_kyc
            android.view.View r1 = r0.a((int) r1)
            java.lang.String r4 = "divider_kyc"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            com.paytm.android.chat.f.a((android.view.View) r1, (boolean) r3)
        L_0x03d0:
            int r1 = com.paytm.android.chat.R.id.btnVisitStore
            android.view.View r1 = r0.a((int) r1)
            android.widget.Button r1 = (android.widget.Button) r1
            com.paytm.android.chat.activity.APCProfileActivity$b r3 = new com.paytm.android.chat.activity.APCProfileActivity$b
            r3.<init>(r0, r10, r8)
            android.view.View$OnClickListener r3 = (android.view.View.OnClickListener) r3
            r1.setOnClickListener(r3)
            r0.a((com.paytm.android.chat.bean.ReceiverDisplayInfo) r10, (com.paytm.android.chat.bean.UserType) r11)
            android.view.GestureDetector r1 = new android.view.GestureDetector
            r3 = r0
            android.content.Context r3 = (android.content.Context) r3
            com.paytm.android.chat.activity.APCProfileActivity$f r4 = new com.paytm.android.chat.activity.APCProfileActivity$f
            r4.<init>(r0)
            android.view.GestureDetector$OnGestureListener r4 = (android.view.GestureDetector.OnGestureListener) r4
            r1.<init>(r3, r4)
            android.view.GestureDetector r4 = new android.view.GestureDetector
            com.paytm.android.chat.activity.APCProfileActivity$e r5 = new com.paytm.android.chat.activity.APCProfileActivity$e
            r5.<init>(r0, r10)
            android.view.GestureDetector$OnGestureListener r5 = (android.view.GestureDetector.OnGestureListener) r5
            r4.<init>(r3, r5)
            int r5 = com.paytm.android.chat.R.id.switchMute
            android.view.View r5 = r0.a((int) r5)
            android.widget.Switch r5 = (android.widget.Switch) r5
            com.paytm.android.chat.activity.APCProfileActivity$c r7 = new com.paytm.android.chat.activity.APCProfileActivity$c
            r7.<init>(r1)
            android.view.View$OnTouchListener r7 = (android.view.View.OnTouchListener) r7
            r5.setOnTouchListener(r7)
            int r1 = com.paytm.android.chat.R.id.switchBlock
            android.view.View r1 = r0.a((int) r1)
            android.widget.Switch r1 = (android.widget.Switch) r1
            com.paytm.android.chat.activity.APCProfileActivity$d r5 = new com.paytm.android.chat.activity.APCProfileActivity$d
            r5.<init>(r4)
            android.view.View$OnTouchListener r5 = (android.view.View.OnTouchListener) r5
            r1.setOnTouchListener(r5)
            com.paytm.android.chat.h.c r1 = r22.c()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r1 = r1.f42262c
            if (r1 == 0) goto L_0x0466
            com.paytm.android.chat.bean.ReceiverDisplayInfo r1 = r1.getReceiverDisplayInfo()
            if (r1 == 0) goto L_0x0466
            java.lang.String r4 = r1.getProfileImage()
            if (r4 == 0) goto L_0x044f
            com.paytm.android.chat.bean.ChatType r1 = r1.getChatType()
            java.lang.String r1 = r1.name()
            boolean r2 = r2.isPushEnabled()
            r2 = r2 ^ r6
            com.paytm.android.chat.h.c r4 = r22.c()
            boolean r4 = r4.f42263d
            com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireUserProfileScreenLoadedEvent(r3, r1, r6, r2, r4)
            return
        L_0x044f:
            com.paytm.android.chat.bean.ChatType r1 = r1.getChatType()
            java.lang.String r1 = r1.name()
            boolean r2 = r2.isPushEnabled()
            r2 = r2 ^ r6
            com.paytm.android.chat.h.c r4 = r22.c()
            boolean r4 = r4.f42263d
            r5 = 0
            com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireUserProfileScreenLoadedEvent(r3, r1, r5, r2, r4)
        L_0x0466:
            return
        L_0x0467:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.f
            java.lang.String r5 = "java.lang.String.format(format, *args)"
            if (r2 == 0) goto L_0x04f5
            int r2 = com.paytm.android.chat.R.id.switchMute
            android.view.View r2 = r0.a((int) r2)
            android.widget.Switch r2 = (android.widget.Switch) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            com.paytm.android.chat.g.b$f r1 = (com.paytm.android.chat.g.b.f) r1
            boolean r3 = r1.f42151a
            r3 = r3 ^ r6
            r2.setChecked(r3)
            boolean r2 = r1.f42151a
            java.lang.String r3 = "this@APCProfileActivity.localClassName"
            if (r2 == 0) goto L_0x04be
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = com.paytm.android.chat.R.string.chat_module_toast_unmute_user_success
            java.lang.String r4 = "%s has been unmuted."
            java.lang.String r2 = com.paytm.android.chat.c.a(r2, r4)
            java.lang.String r4 = "ChatApplication.getStrin…, \"%s has been unmuted.\")"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.String r7 = r1.f42153c
            r8 = 0
            r4[r8] = r7
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r6)
            java.lang.String r2 = java.lang.String.format(r2, r4)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r0.a((java.lang.String) r2)
            r6 = r0
            android.content.Context r6 = (android.content.Context) r6
            r7 = 0
            java.lang.String r8 = r22.getLocalClassName()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r9 = r1.f42152b
            r10 = 1
            r11 = 0
            com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireMuteChatEvent(r6, r7, r8, r9, r10, r11)
            return
        L_0x04be:
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = com.paytm.android.chat.R.string.chat_module_toast_mute_user_success
            java.lang.String r4 = "%s has been muted."
            java.lang.String r2 = com.paytm.android.chat.c.a(r2, r4)
            java.lang.String r4 = "ChatApplication.getStrin…ss, \"%s has been muted.\")"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            java.lang.Object[] r4 = new java.lang.Object[r6]
            java.lang.String r7 = r1.f42153c
            r8 = 0
            r4[r8] = r7
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r6)
            java.lang.String r2 = java.lang.String.format(r2, r4)
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r5)
            r0.a((java.lang.String) r2)
            r6 = r0
            android.content.Context r6 = (android.content.Context) r6
            r7 = 1
            java.lang.String r8 = r22.getLocalClassName()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r3)
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r9 = r1.f42152b
            r10 = 1
            r11 = 0
            com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireMuteChatEvent(r6, r7, r8, r9, r10, r11)
            return
        L_0x04f5:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.e
            if (r2 == 0) goto L_0x055a
            int r2 = com.paytm.android.chat.R.id.switchMute
            android.view.View r2 = r0.a((int) r2)
            android.widget.Switch r2 = (android.widget.Switch) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r4)
            com.paytm.android.chat.g.b$e r1 = (com.paytm.android.chat.g.b.e) r1
            boolean r3 = r1.f42148a
            r3 = r3 ^ r6
            r2.setChecked(r3)
            boolean r2 = r1.f42148a
            if (r2 == 0) goto L_0x0535
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = com.paytm.android.chat.R.string.chat_module_toast_unmute_user_failed
            java.lang.String r3 = "Unmuting %s has failed."
            java.lang.String r2 = com.paytm.android.chat.c.a(r2, r3)
            java.lang.String r3 = "ChatApplication.getStrin…Unmuting %s has failed.\")"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r6]
            java.lang.String r1 = r1.f42149b
            r4 = 0
            r3[r4] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r6)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0.a((java.lang.String) r1)
            return
        L_0x0535:
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = com.paytm.android.chat.R.string.chat_module_toast_mute_user_failed
            java.lang.String r3 = "Muting %s has failed."
            java.lang.String r2 = com.paytm.android.chat.c.a(r2, r3)
            java.lang.String r3 = "ChatApplication.getStrin… \"Muting %s has failed.\")"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r6]
            java.lang.String r1 = r1.f42149b
            r4 = 0
            r3[r4] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r6)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0.a((java.lang.String) r1)
            return
        L_0x055a:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.c
            if (r2 == 0) goto L_0x05c7
            int r2 = com.paytm.android.chat.R.id.switchBlock
            android.view.View r2 = r0.a((int) r2)
            android.widget.Switch r2 = (android.widget.Switch) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r2.setChecked(r6)
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = com.paytm.android.chat.R.string.chat_module_toast_block_user_success
            java.lang.String r3 = "%s has been blocked."
            java.lang.String r2 = com.paytm.android.chat.c.a(r2, r3)
            java.lang.String r3 = "ChatApplication.getStrin…, \"%s has been blocked.\")"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r6]
            com.paytm.android.chat.g.b$c r1 = (com.paytm.android.chat.g.b.c) r1
            java.lang.String r1 = r1.f42146a
            r7 = 0
            r3[r7] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r6)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0.a((java.lang.String) r1)
            com.paytm.android.chat.h.c r1 = r22.c()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r1 = r1.f42262c
            if (r1 == 0) goto L_0x05c6
            com.paytm.android.chat.bean.ReceiverDisplayInfo r1 = r1.getReceiverDisplayInfo()
            if (r1 == 0) goto L_0x05c6
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            com.paytm.android.chat.bean.ChatType r3 = r1.getChatType()
            java.lang.String r3 = r3.name()
            java.lang.String r1 = r1.getProfileImage()
            if (r1 == 0) goto L_0x05b3
            r1 = 1
            goto L_0x05b4
        L_0x05b3:
            r1 = 0
        L_0x05b4:
            int r5 = com.paytm.android.chat.R.id.switchMute
            android.view.View r5 = r0.a((int) r5)
            android.widget.Switch r5 = (android.widget.Switch) r5
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r4)
            boolean r4 = r5.isChecked()
            com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireUserBlockedEvent(r2, r6, r3, r1, r4)
        L_0x05c6:
            return
        L_0x05c7:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.C0698b
            if (r2 == 0) goto L_0x05f2
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = com.paytm.android.chat.R.string.chat_module_toast_block_user_failed
            java.lang.String r3 = "Blocking %s has failed."
            java.lang.String r2 = com.paytm.android.chat.c.a(r2, r3)
            java.lang.String r3 = "ChatApplication.getStrin…Blocking %s has failed.\")"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            java.lang.Object[] r3 = new java.lang.Object[r6]
            com.paytm.android.chat.g.b$b r1 = (com.paytm.android.chat.g.b.C0698b) r1
            java.lang.String r1 = r1.f42145a
            r4 = 0
            r3[r4] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r3, r6)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0.a((java.lang.String) r1)
            return
        L_0x05f2:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.j
            if (r2 == 0) goto L_0x0665
            int r2 = com.paytm.android.chat.R.id.switchBlock
            android.view.View r2 = r0.a((int) r2)
            android.widget.Switch r2 = (android.widget.Switch) r2
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r3 = 0
            r2.setChecked(r3)
            kotlin.g.b.aa r2 = kotlin.g.b.aa.f47921a
            int r2 = com.paytm.android.chat.R.string.chat_module_toast_unblock_user_success
            java.lang.String r7 = "%s has been unblocked."
            java.lang.String r2 = com.paytm.android.chat.c.a(r2, r7)
            java.lang.String r7 = "ChatApplication.getStrin…\"%s has been unblocked.\")"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            java.lang.Object[] r7 = new java.lang.Object[r6]
            com.paytm.android.chat.g.b$j r1 = (com.paytm.android.chat.g.b.j) r1
            java.lang.String r1 = r1.f42158a
            r7[r3] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r7, r6)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0.a((java.lang.String) r1)
            com.paytm.android.chat.h.c r1 = r22.c()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r1 = r1.f42262c
            if (r1 == 0) goto L_0x0664
            com.paytm.android.chat.bean.ReceiverDisplayInfo r1 = r1.getReceiverDisplayInfo()
            if (r1 == 0) goto L_0x0664
            java.lang.String r2 = r1.getProfileImage()
            if (r2 == 0) goto L_0x0664
            r2 = r0
            android.content.Context r2 = (android.content.Context) r2
            com.paytm.android.chat.bean.ChatType r3 = r1.getChatType()
            java.lang.String r3 = r3.name()
            java.lang.String r1 = r1.getProfileImage()
            if (r1 == 0) goto L_0x0650
            goto L_0x0651
        L_0x0650:
            r6 = 0
        L_0x0651:
            int r1 = com.paytm.android.chat.R.id.switchMute
            android.view.View r1 = r0.a((int) r1)
            android.widget.Switch r1 = (android.widget.Switch) r1
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            boolean r1 = r1.isChecked()
            r4 = 0
            com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireUserBlockedEvent(r2, r4, r3, r6, r1)
        L_0x0664:
            return
        L_0x0665:
            boolean r2 = r1 instanceof com.paytm.android.chat.g.b.i
            if (r2 == 0) goto L_0x068a
            kotlin.g.b.aa r1 = kotlin.g.b.aa.f47921a
            int r1 = com.paytm.android.chat.R.string.chat_module_toast_unblock_user_failed
            java.lang.String r2 = "Unblock user failed."
            java.lang.String r1 = com.paytm.android.chat.c.a(r1, r2)
            java.lang.String r2 = "ChatApplication.getStrin…, \"Unblock user failed.\")"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r3, r2)
            java.lang.String r1 = java.lang.String.format(r1, r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r5)
            r0.a((java.lang.String) r1)
            return
        L_0x068a:
            boolean r1 = r1 instanceof com.paytm.android.chat.g.b.h
            if (r1 == 0) goto L_0x06a4
            com.paytm.android.chat.e.b r1 = com.paytm.android.chat.e.a()
            r2 = r0
            android.app.Activity r2 = (android.app.Activity) r2
            java.lang.Class<com.paytm.android.chat.activity.APCProfileActivity> r3 = com.paytm.android.chat.activity.APCProfileActivity.class
            java.lang.String r3 = r3.getName()
            com.paytm.network.model.NetworkCustomError r4 = new com.paytm.network.model.NetworkCustomError
            r4.<init>()
            r4 = 0
            r1.a(r2, r3, r6, r4)
        L_0x06a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCProfileActivity.a(com.paytm.android.chat.base.e):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final com.paytm.android.chat.h.c c() {
        com.paytm.android.chat.h.c cVar = this.f41566a;
        if (cVar == null) {
            k.a("viewModel");
        }
        return cVar;
    }

    public final int a() {
        return this.f41569e;
    }

    public final void e() {
        a.C0701a aVar = com.paytm.android.chat.h.a.a.f42178a;
        Application application = getApplication();
        k.a((Object) application, "application");
        String g2 = com.paytm.android.chat.c.g();
        k.a((Object) g2, "ChatApplication.getAppId()");
        ai a2 = new al((ao) this, (al.b) a.C0701a.a(application, g2)).a(com.paytm.android.chat.h.c.class);
        k.a((Object) a2, "ViewModelProvider(this, …VPCProfileVM::class.java)");
        com.paytm.android.chat.h.c cVar = (com.paytm.android.chat.h.c) a2;
        k.c(cVar, "<set-?>");
        this.f41566a = cVar;
        com.paytm.android.chat.h.c b2 = c();
        String stringExtra = getIntent().getStringExtra("channelUrl");
        b2.f42261b = stringExtra != null ? com.paytm.android.chat.f.a(stringExtra) : null;
    }

    public final void d() {
        Toolbar toolbar = (Toolbar) a(R.id.toolbar);
        boolean z = true;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.a((CharSequence) "");
                supportActionBar.b(true);
                supportActionBar.e(R.drawable.chat_ic_back_arrow);
            }
        }
        ChatHeadView chatHeadView = (ChatHeadView) a(R.id.profileImageHead);
        k.a((Object) chatHeadView, "profileImageHead");
        TextView initialTextView = chatHeadView.getInitialTextView();
        if (initialTextView != null) {
            initialTextView.setTextSize(40.0f);
        }
        com.paytm.android.chat.h.c b2 = c();
        String str = b2.f42261b;
        CharSequence charSequence = str;
        if (charSequence != null && !p.a(charSequence)) {
            z = false;
        }
        if (z) {
            b2.f42260a.onNext(new b.d((byte) 0));
        } else {
            b2.f42264e.getLocalChannelById(str).c(new c.a(b2, str)).c(c.b.f42267a).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(new c.C0703c(b2), new c.d(b2));
        }
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCProfileActivity f41571a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReceiverDisplayInfo f41572b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.paytm.android.chat.d f41573c;

        b(APCProfileActivity aPCProfileActivity, ReceiverDisplayInfo receiverDisplayInfo, com.paytm.android.chat.d dVar) {
            this.f41571a = aPCProfileActivity;
            this.f41572b = receiverDisplayInfo;
            this.f41573c = dVar;
        }

        public final void onClick(View view) {
            ReceiverDisplayInfo receiverDisplayInfo;
            if (FastClickUtil.isFastClick() && !TextUtils.isEmpty(this.f41572b.getPaytmChannelId())) {
                ChatGroupChannelDataModel chatGroupChannelDataModel = this.f41571a.c().f42262c;
                if (!(chatGroupChannelDataModel == null || (receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo()) == null || receiverDisplayInfo.getProfileImage() == null)) {
                    APCProfileActivity aPCProfileActivity = this.f41571a;
                    Context context = aPCProfileActivity;
                    Switch switchR = (Switch) aPCProfileActivity.a(R.id.switchBlock);
                    k.a((Object) switchR, "switchBlock");
                    boolean isChecked = switchR.isChecked();
                    String name = receiverDisplayInfo.getChatType().name();
                    boolean z = receiverDisplayInfo.getProfileImage() != null;
                    Switch switchR2 = (Switch) this.f41571a.a(R.id.switchMute);
                    k.a((Object) switchR2, "switchMute");
                    ChatAnalyticsHelperKt.fireMerchantVisitStoreEvent(context, isChecked, name, z, switchR2.isChecked());
                }
                String a2 = com.paytm.android.chat.e.a().a("chat_visit_store_cta", (String) null);
                if (a2 == null) {
                    a2 = "paytmmp://nearbuy?h5_url=https://mystore.paytmstores.com/store/{store_id}";
                }
                String paytmChannelId = this.f41572b.getPaytmChannelId();
                if (paytmChannelId == null) {
                    paytmChannelId = "";
                }
                String a3 = p.a(a2, "{store_id}", paytmChannelId, false);
                com.paytm.android.chat.d dVar = this.f41573c;
                if (dVar != null) {
                    dVar.a(this.f41571a, a3);
                }
            }
        }
    }

    public static final class f implements GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCProfileActivity f41578a;

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        f(APCProfileActivity aPCProfileActivity) {
            this.f41578a = aPCProfileActivity;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            com.paytm.android.chat.h.c b2 = this.f41578a.c();
            ChatGroupChannelDataModel chatGroupChannelDataModel = b2.f42262c;
            if (chatGroupChannelDataModel != null) {
                boolean z = !chatGroupChannelDataModel.isPushEnabled();
                ChatManager b3 = ChatManager.b();
                k.a((Object) b3, "ChatManager.getInstance()");
                b3.a().setChannelPushPreferences(chatGroupChannelDataModel, z).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.i.a.b()).a(new c.g(z, chatGroupChannelDataModel, b2), new c.h(z, chatGroupChannelDataModel, b2));
            }
            return true;
        }
    }

    public static final class e implements GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCProfileActivity f41576a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReceiverDisplayInfo f41577b;

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        public final void onLongPress(MotionEvent motionEvent) {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }

        public final void onShowPress(MotionEvent motionEvent) {
        }

        e(APCProfileActivity aPCProfileActivity, ReceiverDisplayInfo receiverDisplayInfo) {
            this.f41576a = aPCProfileActivity;
            this.f41577b = receiverDisplayInfo;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            Switch switchR = (Switch) this.f41576a.a(R.id.switchBlock);
            k.a((Object) switchR, "switchBlock");
            if (!switchR.isChecked()) {
                APCProfileActivity.a(this.f41576a, this.f41577b.getName());
            } else {
                this.f41576a.c().b();
            }
            return true;
        }
    }

    static final class c implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GestureDetector f41574a;

        c(GestureDetector gestureDetector) {
            this.f41574a = gestureDetector;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f41574a.onTouchEvent(motionEvent);
            return true;
        }
    }

    static final class d implements View.OnTouchListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ GestureDetector f41575a;

        d(GestureDetector gestureDetector) {
            this.f41575a = gestureDetector;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            this.f41575a.onTouchEvent(motionEvent);
            return true;
        }
    }

    private final void a(ReceiverDisplayInfo receiverDisplayInfo, UserType userType) {
        int i2 = b.f41760b[userType.ordinal()];
        if (i2 == 1) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.a((CharSequence) getString(R.string.chat_profile));
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) a(R.id.imageBlueTickName);
            k.a((Object) appCompatImageView, "imageBlueTickName");
            com.paytm.android.chat.f.a((View) appCompatImageView, false);
            RoboTextView roboTextView = (RoboTextView) a(R.id.businessName);
            k.a((Object) roboTextView, "businessName");
            com.paytm.android.chat.f.a((View) roboTextView, false);
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.address);
            k.a((Object) roboTextView2, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            com.paytm.android.chat.f.a((View) roboTextView2, false);
            Button button = (Button) a(R.id.btnVisitStore);
            k.a((Object) button, "btnVisitStore");
            com.paytm.android.chat.f.a((View) button, false);
        } else if (i2 == 2 || i2 == 3) {
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.a((CharSequence) getString(R.string.chat_business_profile));
            }
            String businessName = receiverDisplayInfo.getBusinessName();
            String str = "";
            if (businessName == null) {
                businessName = str;
            }
            String address = receiverDisplayInfo.getAddress();
            if (address != null) {
                str = address;
            }
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.address);
            k.a((Object) roboTextView3, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            CharSequence charSequence = str;
            com.paytm.android.chat.f.a((View) roboTextView3, !TextUtils.isEmpty(charSequence));
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.businessName);
            k.a((Object) roboTextView4, "businessName");
            CharSequence charSequence2 = businessName;
            roboTextView4.setText(charSequence2);
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.address);
            k.a((Object) roboTextView5, AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            roboTextView5.setText(charSequence);
            if (receiverDisplayInfo.isFromContact()) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) a(R.id.imageBlueTickName);
                k.a((Object) appCompatImageView2, "imageBlueTickName");
                com.paytm.android.chat.f.a((View) appCompatImageView2, false);
                ConstraintLayout constraintLayout = (ConstraintLayout) a(R.id.layoutBusinessName);
                k.a((Object) constraintLayout, "layoutBusinessName");
                com.paytm.android.chat.f.a((View) constraintLayout, !TextUtils.isEmpty(charSequence2));
                return;
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) a(R.id.imageBlueTickName);
            k.a((Object) appCompatImageView3, "imageBlueTickName");
            com.paytm.android.chat.f.a((View) appCompatImageView3, receiverDisplayInfo.isBusinessNameAvailable());
            ConstraintLayout constraintLayout2 = (ConstraintLayout) a(R.id.layoutBusinessName);
            k.a((Object) constraintLayout2, "layoutBusinessName");
            com.paytm.android.chat.f.a((View) constraintLayout2, false);
        }
    }

    static final class g implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCProfileActivity f41579a;

        g(APCProfileActivity aPCProfileActivity) {
            this.f41579a = aPCProfileActivity;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            this.f41579a.c().b();
        }
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem != null && menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private final void a(String str) {
        Snackbar snackbar = this.f41568d;
        if (snackbar != null) {
            snackbar.d();
        }
        if (((ScrollView) a(R.id.constraint)) != null) {
            this.f41568d = Snackbar.a((View) (ScrollView) a(R.id.constraint), (CharSequence) str, -1);
            Snackbar snackbar2 = this.f41568d;
            if (snackbar2 != null) {
                snackbar2.c();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(APCProfileActivity aPCProfileActivity, String str) {
        androidx.appcompat.app.c cVar = aPCProfileActivity.f41567c;
        if (cVar != null) {
            cVar.dismiss();
        }
        c.a aVar = new c.a(aPCProfileActivity);
        aa aaVar = aa.f47921a;
        String string = aPCProfileActivity.getString(R.string.chat_module_block_user_title);
        k.a((Object) string, "getString(R.string.chat_module_block_user_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        k.a((Object) format, "java.lang.String.format(format, *args)");
        aPCProfileActivity.f41567c = aVar.b((CharSequence) format).a(R.string.chat_button_ok, (DialogInterface.OnClickListener) new g(aPCProfileActivity)).b(R.string.chat_module_cancel, (DialogInterface.OnClickListener) null).a();
        androidx.appcompat.app.c cVar2 = aPCProfileActivity.f41567c;
        if (cVar2 != null) {
            cVar2.show();
        }
    }
}
