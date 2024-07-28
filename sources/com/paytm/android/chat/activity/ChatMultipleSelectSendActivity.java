package com.paytm.android.chat.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.i;
import com.paytm.android.chat.base.BaseActivity;
import com.paytm.android.chat.bean.SelectChannelBean;
import com.paytm.android.chat.d.a.b;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.utils.ChatVariantUtilKt;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.ToastUtil;
import com.sendbird.android.GroupChannel;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.k;

public class ChatMultipleSelectSendActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f41602a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public List<SelectChannelBean> f41603b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public i f41604c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f41605d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayout f41606e;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Throwable th) throws Throwable {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.chat_activity_multiple_select_send);
        ((Toolbar) findViewById(R.id.toolbar_select_send_channel)).setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChatMultipleSelectSendActivity.this.finish();
            }
        });
        this.f41602a = (RecyclerView) findViewById(R.id.rv_select_send_channel);
        this.f41606e = (LinearLayout) findViewById(R.id.btn_send_channel);
        this.f41602a.setLayoutManager(new LinearLayoutManager(this));
        this.f41605d = new ArrayList<>();
        i iVar = this.f41604c;
        if (iVar == null) {
            this.f41604c = new i(this, this.f41603b);
            this.f41602a.setAdapter(this.f41604c);
        } else {
            iVar.notifyDataSetChanged();
        }
        ChatManager.b().f40994f.getLocalChannelsForDisplay().a($$Lambda$ChatMultipleSelectSendActivity$IVyDHlZPX1g1ADAlmRJpFUD0fEw.INSTANCE).b(a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g() {
            public final void accept(Object obj) {
                ChatMultipleSelectSendActivity.this.a((List) obj);
            }
        }, (g<? super Throwable>) $$Lambda$ChatMultipleSelectSendActivity$DawZTft4BPqc5d7c9Ht5s8q4DTs.INSTANCE);
        this.f41606e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (!FastClickUtil.isFastClick()) {
                    return;
                }
                if (ChatMultipleSelectSendActivity.this.f41605d.size() > 0) {
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("channels", ChatMultipleSelectSendActivity.this.f41605d);
                    ChatMultipleSelectSendActivity.this.setResult(-1, intent);
                    ChatMultipleSelectSendActivity.this.finish();
                    return;
                }
                ChatMultipleSelectSendActivity chatMultipleSelectSendActivity = ChatMultipleSelectSendActivity.this;
                Toast.makeText(chatMultipleSelectSendActivity, chatMultipleSelectSendActivity.getResources().getString(R.string.chat_module_please_select_a_channel), 0).show();
            }
        });
        this.f41604c.f41387b = new i.b() {
            public final void a(int i2) {
                ((SelectChannelBean) ChatMultipleSelectSendActivity.this.f41603b.get(i2)).setSelect(!((SelectChannelBean) ChatMultipleSelectSendActivity.this.f41603b.get(i2)).isSelect());
                if (!((SelectChannelBean) ChatMultipleSelectSendActivity.this.f41603b.get(i2)).isSelect()) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= ChatMultipleSelectSendActivity.this.f41605d.size()) {
                            break;
                        } else if (((String) ChatMultipleSelectSendActivity.this.f41605d.get(i3)).equals(((SelectChannelBean) ChatMultipleSelectSendActivity.this.f41603b.get(i2)).getGroupChannel().getUrl())) {
                            ChatMultipleSelectSendActivity.this.f41605d.remove(i3);
                            break;
                        } else {
                            i3++;
                        }
                    }
                    ((SelectChannelBean) ChatMultipleSelectSendActivity.this.f41603b.get(i2)).setSelect(false);
                } else if (ChatMultipleSelectSendActivity.this.f41605d.size() < 5) {
                    ChatMultipleSelectSendActivity.this.f41605d.add(((SelectChannelBean) ChatMultipleSelectSendActivity.this.f41603b.get(i2)).getGroupChannel().getUrl());
                } else {
                    ((SelectChannelBean) ChatMultipleSelectSendActivity.this.f41603b.get(i2)).setSelect(false);
                    ToastUtil.showMsg(R.string.chat_module_no_more_than_five_users);
                }
                ChatMultipleSelectSendActivity.this.f41604c.notifyDataSetChanged();
            }
        };
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List b(List list) throws Throwable {
        $$Lambda$ChatMultipleSelectSendActivity$Y3g6nJbSvFjX1C0HIxMhEh3OQXc r0 = $$Lambda$ChatMultipleSelectSendActivity$Y3g6nJbSvFjX1C0HIxMhEh3OQXc.INSTANCE;
        k.d(list, "$this$mapNotNull");
        k.d(r0, "transform");
        Collection arrayList = new ArrayList();
        for (Object invoke : list) {
            Object invoke2 = r0.invoke(invoke);
            if (invoke2 != null) {
                arrayList.add(invoke2);
            }
        }
        return (List) arrayList;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ SelectChannelBean a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        GroupChannel a2 = b.a(chatGroupChannelDataModel.getChannelUrl());
        if (ChatVariantUtilKt.isReplyAllowed(chatGroupChannelDataModel.getCustomType(), chatGroupChannelDataModel.getData())) {
            return new SelectChannelBean(a2, false);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(List list) throws Throwable {
        this.f41603b.clear();
        this.f41603b.addAll(list);
        if (this.f41603b.size() > 0) {
            i iVar = this.f41604c;
            iVar.f41388c.clear();
            iVar.f41389d.clear();
            iVar.f41390e.clear();
            iVar.f41391f.clear();
            iVar.f41392g.clear();
            i iVar2 = this.f41604c;
            iVar2.f41386a = this.f41603b;
            iVar2.notifyDataSetChanged();
        }
    }
}
