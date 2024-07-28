package com.paytm.android.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a;
import com.imsdk.CPCSendbirdWrapper;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.o;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.c;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.network.requests.SetUserSettingsRequest;
import com.paytm.android.chat.utils.ChatOneButtonDialog;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.utility.q;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import java.util.ArrayList;

public class SubSettingsActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    o f41728a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ChatOneButtonDialog f41729b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ChatRepository f41730c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RecyclerView f41731d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f41732e;

    public void onCreate(Bundle bundle) {
        int i2;
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_settings);
        this.f41730c = ChatManager.b().f40994f;
        this.f41731d = (RecyclerView) findViewById(R.id.settings_rv);
        this.f41732e = (FrameLayout) findViewById(R.id.settings_empty_view);
        this.f41731d.setLayoutManager(new LinearLayoutManager(this));
        this.f41732e.setVisibility(8);
        this.f41731d.setVisibility(0);
        ChatManager.b().d();
        setSupportActionBar((Toolbar) findViewById(R.id.settings_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().b(true);
            getSupportActionBar().e(R.drawable.chat_ic_back_arrow);
        }
        Intent intent = getIntent();
        String str = "";
        String stringExtra = intent.hasExtra(KeyList.IntentExtraKey.SETTINGS_TITLE) ? intent.getStringExtra(KeyList.IntentExtraKey.SETTINGS_TITLE) : str;
        if (intent.hasExtra(KeyList.IntentExtraKey.SETTINGS_VALUES)) {
            str = intent.getStringExtra(KeyList.IntentExtraKey.SETTINGS_VALUES);
        }
        if (stringExtra != null && !stringExtra.isEmpty()) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().a((CharSequence) stringExtra);
            }
            ArrayList arrayList = new ArrayList();
            try {
                i2 = Integer.parseInt(str);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (getResources().getString(R.string.chat_module_settings_privacy_discover).equals(stringExtra)) {
                String[] stringArray = getResources().getStringArray(R.array.chat_module_settings_privacy_discover);
                if (i2 > 0) {
                    for (int i3 = 0; i3 < stringArray.length; i3++) {
                        if ((i2 & 1) == 1) {
                            arrayList.add(Integer.valueOf(i3));
                        }
                        i2 >>= 1;
                    }
                } else {
                    arrayList.add(Integer.valueOf(i2));
                }
            } else {
                arrayList.add(Integer.valueOf(i2));
            }
            a(stringExtra, arrayList);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v3, types: [int] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final java.lang.String r8, java.util.List<java.lang.Integer> r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r7.getResources()
            int r1 = com.paytm.android.chat.R.string.chat_module_settings_privacy_blocked_users
            java.lang.String r0 = r0.getString(r1)
            boolean r0 = r0.equals(r8)
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x012e
            android.content.res.Resources r0 = r7.getResources()
            int r3 = com.paytm.android.chat.R.string.chat_module_settings_block_list
            java.lang.String r0 = r0.getString(r3)
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x0024
            goto L_0x012e
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3 = 0
            android.content.res.Resources r4 = r7.getResources()
            int r5 = com.paytm.android.chat.R.string.chat_module_settings_privacy_profile_pic
            java.lang.String r4 = r4.getString(r5)
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0102
            android.content.res.Resources r4 = r7.getResources()
            int r5 = com.paytm.android.chat.R.string.chat_module_settings_privacy_online_status
            java.lang.String r4 = r4.getString(r5)
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x004c
            goto L_0x0102
        L_0x004c:
            android.content.res.Resources r4 = r7.getResources()
            int r5 = com.paytm.android.chat.R.string.chat_module_settings_privacy_msg_from
            java.lang.String r4 = r4.getString(r5)
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x0079
            android.content.res.Resources r8 = r7.getResources()
            int r1 = com.paytm.android.chat.R.array.chat_module_settings_privacy_message_from
            java.lang.String[] r8 = r8.getStringArray(r1)
            int r1 = r8.length
            r3 = 0
        L_0x0068:
            if (r3 >= r1) goto L_0x0072
            r4 = r8[r3]
            r0.add(r4)
            int r3 = r3 + 1
            goto L_0x0068
        L_0x0072:
            com.paytm.android.chat.activity.SubSettingsActivity$3 r3 = new com.paytm.android.chat.activity.SubSettingsActivity$3
            r3.<init>()
            goto L_0x011d
        L_0x0079:
            android.content.res.Resources r4 = r7.getResources()
            int r5 = com.paytm.android.chat.R.string.chat_module_settings_privacy_discover
            java.lang.String r4 = r4.getString(r5)
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x00a6
            android.content.res.Resources r8 = r7.getResources()
            int r3 = com.paytm.android.chat.R.array.chat_module_settings_privacy_discover
            java.lang.String[] r8 = r8.getStringArray(r3)
            int r3 = r8.length
        L_0x0094:
            if (r2 >= r3) goto L_0x009e
            r4 = r8[r2]
            r0.add(r4)
            int r2 = r2 + 1
            goto L_0x0094
        L_0x009e:
            com.paytm.android.chat.activity.SubSettingsActivity$4 r3 = new com.paytm.android.chat.activity.SubSettingsActivity$4
            r3.<init>()
            r2 = 1
            goto L_0x011d
        L_0x00a6:
            android.content.res.Resources r1 = r7.getResources()
            int r4 = com.paytm.android.chat.R.string.chat_module_settings_media_photos
            java.lang.String r1 = r1.getString(r4)
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x00e6
            android.content.res.Resources r1 = r7.getResources()
            int r4 = com.paytm.android.chat.R.string.chat_module_settings_media_videos
            java.lang.String r1 = r1.getString(r4)
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x00e6
            android.content.res.Resources r1 = r7.getResources()
            int r4 = com.paytm.android.chat.R.string.chat_module_settings_media_documents
            java.lang.String r1 = r1.getString(r4)
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x00e6
            android.content.res.Resources r1 = r7.getResources()
            int r4 = com.paytm.android.chat.R.string.chat_module_settings_media_audio
            java.lang.String r1 = r1.getString(r4)
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x011d
        L_0x00e6:
            android.content.res.Resources r1 = r7.getResources()
            int r3 = com.paytm.android.chat.R.array.chat_module_settings_media_download
            java.lang.String[] r1 = r1.getStringArray(r3)
            int r3 = r1.length
            r4 = 0
        L_0x00f2:
            if (r4 >= r3) goto L_0x00fc
            r5 = r1[r4]
            r0.add(r5)
            int r4 = r4 + 1
            goto L_0x00f2
        L_0x00fc:
            com.paytm.android.chat.activity.SubSettingsActivity$5 r3 = new com.paytm.android.chat.activity.SubSettingsActivity$5
            r3.<init>(r8)
            goto L_0x011d
        L_0x0102:
            android.content.res.Resources r1 = r7.getResources()
            int r3 = com.paytm.android.chat.R.array.chat_module_settings_privacy_visible
            java.lang.String[] r1 = r1.getStringArray(r3)
            int r3 = r1.length
            r4 = 0
        L_0x010e:
            if (r4 >= r3) goto L_0x0118
            r5 = r1[r4]
            r0.add(r5)
            int r4 = r4 + 1
            goto L_0x010e
        L_0x0118:
            com.paytm.android.chat.activity.SubSettingsActivity$2 r3 = new com.paytm.android.chat.activity.SubSettingsActivity$2
            r3.<init>(r8)
        L_0x011d:
            com.paytm.android.chat.a.o r8 = new com.paytm.android.chat.a.o
            r8.<init>(r7, r0, r2, r9)
            r7.f41728a = r8
            com.paytm.android.chat.a.o r8 = r7.f41728a
            r8.f41463f = r3
            androidx.recyclerview.widget.RecyclerView r9 = r7.f41731d
            r9.setAdapter(r8)
            return
        L_0x012e:
            android.widget.FrameLayout r9 = r7.f41732e
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r7)
            int r3 = com.paytm.android.chat.R.layout.chat_layout_empty_block_list
            android.widget.FrameLayout r4 = r7.f41732e
            android.view.View r0 = r0.inflate(r3, r4, r2)
            r9.addView(r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            com.paytm.android.chat.a.c r0 = new com.paytm.android.chat.a.c
            r0.<init>(r7, r9)
            com.paytm.android.chat.activity.SubSettingsActivity$1 r3 = new com.paytm.android.chat.activity.SubSettingsActivity$1
            r3.<init>(r9, r0, r8)
            r0.f41044a = r3
            androidx.recyclerview.widget.RecyclerView r8 = r7.f41731d
            r8.setAdapter(r0)
            boolean r8 = com.paytm.utility.b.c((android.content.Context) r7)
            if (r8 != 0) goto L_0x0195
            com.paytm.android.chat.utils.ChatOneButtonDialog r8 = r7.f41729b
            if (r8 != 0) goto L_0x0195
            com.paytm.android.chat.utils.ChatOneButtonDialog r8 = new com.paytm.android.chat.utils.ChatOneButtonDialog
            r8.<init>(r7)
            r7.f41729b = r8
            com.paytm.android.chat.utils.ChatOneButtonDialog r8 = r7.f41729b
            r8.hideTitle()
            com.paytm.android.chat.utils.ChatOneButtonDialog r8 = r7.f41729b
            android.content.res.Resources r1 = r7.getResources()
            int r3 = com.paytm.android.chat.R.string.chat_module_no_internet
            java.lang.String r1 = r1.getString(r3)
            r8.setMessage(r1)
            com.paytm.android.chat.utils.ChatOneButtonDialog r8 = r7.f41729b
            r1 = -3
            android.content.res.Resources r3 = r7.getResources()
            int r4 = com.paytm.android.chat.R.string.chat_module_button_ok
            java.lang.String r3 = r3.getString(r4)
            com.paytm.android.chat.activity.SubSettingsActivity$9 r4 = new com.paytm.android.chat.activity.SubSettingsActivity$9
            r4.<init>()
            r8.setButton(r1, r3, r4)
            com.paytm.android.chat.utils.ChatOneButtonDialog r8 = r7.f41729b
            r8.show()
            r1 = 0
        L_0x0195:
            if (r1 == 0) goto L_0x01f0
            com.paytm.android.chat.activity.SubSettingsActivity$6 r8 = new com.paytm.android.chat.activity.SubSettingsActivity$6
            r8.<init>(r9, r0)
            com.paytm.android.chat.data.repository.ChatRepository r9 = r7.f41730c
            boolean r9 = r9.isSenbirdWSConnected()
            if (r9 == 0) goto L_0x01ae
            com.paytm.android.chat.data.repository.ChatRepository r9 = r7.f41730c
            io.reactivex.rxjava3.a.y r9 = r9.getBlockedUserList()
            r9.a(r8)
            return
        L_0x01ae:
            com.paytm.android.chat.ChatManager.b()
            boolean r9 = com.paytm.android.chat.ChatManager.h()
            if (r9 == 0) goto L_0x01d0
            boolean r9 = com.paytm.android.chat.utils.AppUtilKt.checkIfRegisterIsUptoDateWithVersion()
            if (r9 == 0) goto L_0x01d0
            com.paytm.android.chat.data.repository.ChatRepository r9 = r7.f41730c
            io.reactivex.rxjava3.a.y r9 = r9.reConnect()
            com.paytm.android.chat.activity.-$$Lambda$SubSettingsActivity$B-v07HlcuQ0fhVdMy38rIpRHX2k r0 = new com.paytm.android.chat.activity.-$$Lambda$SubSettingsActivity$B-v07HlcuQ0fhVdMy38rIpRHX2k
            r0.<init>()
            io.reactivex.rxjava3.a.y r9 = r9.a(r0)
            r9.a(r8)
            return
        L_0x01d0:
            com.paytm.android.chat.ChatManager r0 = com.paytm.android.chat.ChatManager.b()
            java.lang.String r1 = com.paytm.android.chat.utils.SharedPreferencesUtil.getPFId()
            java.lang.String r2 = com.paytm.android.chat.utils.SharedPreferencesUtil.getNickname()
            java.lang.String r3 = com.paytm.android.chat.utils.SharedPreferencesUtil.getMobileNumber()
            java.lang.String r4 = com.paytm.android.chat.utils.AppUtilKt.getMyProfilePic(r7)
            java.lang.String r5 = com.paytm.android.chat.utils.SharedPreferencesUtil.getToken()
            com.paytm.android.chat.activity.SubSettingsActivity$7 r6 = new com.paytm.android.chat.activity.SubSettingsActivity$7
            r6.<init>(r8)
            r0.a(r1, r2, r3, r4, r5, r6)
        L_0x01f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.SubSettingsActivity.a(java.lang.String, java.util.List):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ac a(CPCSendbirdWrapper.ConnectionStatus connectionStatus) throws Throwable {
        return connectionStatus.getStatus() ? this.f41730c.getBlockedUserList() : y.T_();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onDestroy() {
        o oVar = this.f41728a;
        if (oVar != null && oVar.f41462e) {
            new SetUserSettingsRequest(SharedPreferencesUtil.getUserId(), c.f(), new a<String>() {
                public final /* synthetic */ void a(Object obj) {
                    q.b("SetUserSettingsRequest onSuccess:".concat(String.valueOf((String) obj)));
                }

                public final void a(int i2, String str) {
                    q.b("onFailure:[" + i2 + "]" + str);
                }
            });
        }
        super.onDestroy();
    }
}
