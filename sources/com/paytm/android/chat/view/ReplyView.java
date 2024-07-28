package com.paytm.android.chat.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.view.round.RoundAngleFrameLayout;
import com.sendbird.android.BaseMessage;
import io.reactivex.rxjava3.d.g;

public class ReplyView extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f42509a = false;

    /* renamed from: b  reason: collision with root package name */
    private TextView f42510b;

    /* renamed from: c  reason: collision with root package name */
    private RoundAngleFrameLayout f42511c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f42512d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f42513e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f42514f;

    /* renamed from: g  reason: collision with root package name */
    private View f42515g;

    /* renamed from: h  reason: collision with root package name */
    private a f42516h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f42517i;
    private String j = "";
    private BaseMessage k;

    public interface a {
    }

    public ReplyView(Context context) {
        super(context);
        a(context);
    }

    public ReplyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public ReplyView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_layout_group_chat_reply_layout, this);
        this.f42510b = (TextView) findViewById(R.id.text_group_chat_reply_name);
        this.f42511c = (RoundAngleFrameLayout) findViewById(R.id.image_reply_thumb_container);
        this.f42512d = (ImageView) findViewById(R.id.image_reply_thumb);
        this.f42513e = (ImageView) findViewById(R.id.image_group_chat_file_type);
        this.f42517i = (RelativeLayout) findViewById(R.id.image_group_chat_file_type_container);
        this.f42514f = (TextView) findViewById(R.id.text_group_chat_file_name);
        this.f42515g = findViewById(R.id.color_indicator);
        ((ImageView) findViewById(R.id.image_group_chat_reply_close)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ReplyView.this.setReplyFromCancel(false);
            }
        });
    }

    public void setOtherId(String str) {
        this.j = str;
    }

    public BaseMessage getBaseMessage() {
        return this.k;
    }

    public void setReplyMessage(BaseMessage baseMessage) {
        if (!"TRANSFER_FAIL".equals(baseMessage.getCustomType())) {
            ChatManager.b().f40994f.fetchChannelForDisplay(baseMessage.getChannelUrl()).a(io.reactivex.rxjava3.android.b.a.a()).a(new g(baseMessage) {
                private final /* synthetic */ BaseMessage f$1;

                {
                    this.f$1 = r2;
                }

                public final void accept(Object obj) {
                    ReplyView.this.a(this.f$1, (ChatGroupChannelDataModel) obj);
                }
            }, (g<? super Throwable>) new g() {
                public final void accept(Object obj) {
                    ReplyView.this.a((Throwable) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Throwable th) throws Throwable {
        setReply(false);
    }

    public void setReply(boolean z) {
        this.k = null;
        this.f42509a = z;
        setVisibility(8);
        this.f42511c.setVisibility(8);
        this.f42517i.setVisibility(8);
    }

    public void setReplyFromCancel(boolean z) {
        this.k = null;
        this.f42509a = z;
        setVisibility(8);
        this.f42511c.setVisibility(8);
        this.f42517i.setVisibility(8);
    }

    public final boolean a() {
        return this.f42509a;
    }

    public void setOnReplyCancelled(a aVar) {
        this.f42516h = aVar;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01b4, code lost:
        if (r1.res == com.paytm.android.chat.R.drawable.chat_icon_chat_message_type_photo) goto L_0x01b6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(com.sendbird.android.BaseMessage r8, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            r7.setReply(r0)
            r7.k = r8
            r1 = 1
            r7.f42509a = r1
            r7.setVisibility(r0)
            com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean r1 = com.paytm.android.chat.utils.MessageContentUtils.getReplyContentBean(r8)
            com.paytm.android.chat.bean.ReceiverDisplayInfo r9 = r9.getReceiverDisplayInfo()
            java.lang.String r9 = r9.getName()
            boolean r2 = r8 instanceof com.sendbird.android.UserMessage
            r3 = 8
            if (r2 == 0) goto L_0x007e
            r2 = r8
            com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2
            com.sendbird.android.Sender r2 = r2.getSender()
            if (r2 == 0) goto L_0x006e
            java.lang.String r2 = r2.getUserId()
            java.lang.String r4 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0053
            android.widget.TextView r9 = r7.f42510b
            int r2 = com.paytm.android.chat.R.string.chat_you
            r9.setText(r2)
            android.widget.TextView r9 = r7.f42510b
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.paytm.android.chat.R.color.chat_color_4A80ED
            int r2 = r2.getColor(r4)
            r9.setTextColor(r2)
            android.view.View r9 = r7.f42515g
            int r2 = com.paytm.android.chat.R.color.chat_color_4A80ED
            r9.setBackgroundResource(r2)
            goto L_0x006e
        L_0x0053:
            android.widget.TextView r2 = r7.f42510b
            r2.setText(r9)
            android.widget.TextView r9 = r7.f42510b
            android.content.res.Resources r2 = r7.getResources()
            int r4 = com.paytm.android.chat.R.color.chat_color_E2743F
            int r2 = r2.getColor(r4)
            r9.setTextColor(r2)
            android.view.View r9 = r7.f42515g
            int r2 = com.paytm.android.chat.R.color.chat_color_E2743F
            r9.setBackgroundResource(r2)
        L_0x006e:
            java.lang.String r8 = r8.getCustomType()
            java.lang.String r9 = "TRANSFER_FAIL"
            boolean r8 = r9.equals(r8)
            if (r8 == 0) goto L_0x019e
            r7.setReply(r0)
            return
        L_0x007e:
            boolean r2 = r8 instanceof com.sendbird.android.FileMessage
            if (r2 == 0) goto L_0x019e
            r2 = r8
            com.sendbird.android.FileMessage r2 = (com.sendbird.android.FileMessage) r2
            java.lang.String r4 = r2.getType()
            com.sendbird.android.Sender r5 = r2.getSender()
            if (r5 == 0) goto L_0x00d6
            java.lang.String r5 = r5.getUserId()
            java.lang.String r6 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x00bb
            android.widget.TextView r9 = r7.f42510b
            int r5 = com.paytm.android.chat.R.string.chat_you
            r9.setText(r5)
            android.widget.TextView r9 = r7.f42510b
            android.content.res.Resources r5 = r7.getResources()
            int r6 = com.paytm.android.chat.R.color.chat_color_4A80ED
            int r5 = r5.getColor(r6)
            r9.setTextColor(r5)
            android.view.View r9 = r7.f42515g
            int r5 = com.paytm.android.chat.R.color.chat_color_4A80ED
            r9.setBackgroundResource(r5)
            goto L_0x00d6
        L_0x00bb:
            android.widget.TextView r5 = r7.f42510b
            r5.setText(r9)
            android.widget.TextView r9 = r7.f42510b
            android.content.res.Resources r5 = r7.getResources()
            int r6 = com.paytm.android.chat.R.color.chat_color_E2743F
            int r5 = r5.getColor(r6)
            r9.setTextColor(r5)
            android.view.View r9 = r7.f42515g
            int r5 = com.paytm.android.chat.R.color.chat_color_E2743F
            r9.setBackgroundResource(r5)
        L_0x00d6:
            java.lang.String r9 = r4.toLowerCase()
            java.lang.String r5 = "image"
            boolean r9 = r9.startsWith(r5)
            if (r9 == 0) goto L_0x0199
            com.sendbird.android.shadow.com.google.gson.Gson r9 = new com.sendbird.android.shadow.com.google.gson.Gson
            r9.<init>()
            java.lang.String r8 = r8.getData()
            java.lang.Class<com.paytm.android.chat.bean.jsonbean.FileDataBean> r5 = com.paytm.android.chat.bean.jsonbean.FileDataBean.class
            java.lang.Object r8 = r9.fromJson((java.lang.String) r8, r5)
            com.paytm.android.chat.bean.jsonbean.FileDataBean r8 = (com.paytm.android.chat.bean.jsonbean.FileDataBean) r8
            r9 = 0
            if (r8 == 0) goto L_0x015c
            java.io.File r9 = new java.io.File
            java.lang.String r8 = r8.path
            r9.<init>(r8)
            boolean r8 = com.paytm.android.chat.utils.FileUtils.fileExists(r9)
            if (r8 == 0) goto L_0x0111
            android.content.Context r8 = r7.getContext()
            java.lang.String r4 = r9.getAbsolutePath()
            android.widget.ImageView r5 = r7.f42512d
            com.paytm.android.chat.utils.ImageUtils.displayImageFromFile(r8, r4, r5)
            goto L_0x015c
        L_0x0111:
            android.content.Context r8 = r7.getContext()
            java.lang.String r9 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            java.lang.String r5 = r7.j
            java.lang.String r8 = com.paytm.android.chat.utils.FileUtils.getTypePath(r8, r9, r5, r4)
            java.io.File r9 = new java.io.File
            java.lang.String r4 = r2.getName()
            r9.<init>(r8, r4)
            boolean r8 = com.paytm.android.chat.utils.FileUtils.fileExists(r9)
            if (r8 == 0) goto L_0x013c
            android.content.Context r8 = r7.getContext()
            java.lang.String r4 = r9.getAbsolutePath()
            android.widget.ImageView r5 = r7.f42512d
            com.paytm.android.chat.utils.ImageUtils.displayImageFromFile(r8, r4, r5)
            goto L_0x015c
        L_0x013c:
            java.io.File r9 = new java.io.File
            java.lang.String r8 = com.paytm.android.chat.utils.FileUtils.getAbsCameraPath()
            java.lang.String r4 = r2.getName()
            r9.<init>(r8, r4)
            boolean r8 = com.paytm.android.chat.utils.FileUtils.fileExists(r9)
            if (r8 == 0) goto L_0x015c
            android.content.Context r8 = r7.getContext()
            java.lang.String r4 = r9.getAbsolutePath()
            android.widget.ImageView r5 = r7.f42512d
            com.paytm.android.chat.utils.ImageUtils.displayImageFromFile(r8, r4, r5)
        L_0x015c:
            if (r9 == 0) goto L_0x0164
            boolean r8 = r9.exists()
            if (r8 != 0) goto L_0x0193
        L_0x0164:
            java.util.List r8 = r2.getThumbnails()
            int r8 = r8.size()
            if (r8 <= 0) goto L_0x0186
            android.content.Context r8 = r7.getContext()
            java.util.List r9 = r2.getThumbnails()
            java.lang.Object r9 = r9.get(r0)
            com.sendbird.android.FileMessage$Thumbnail r9 = (com.sendbird.android.FileMessage.Thumbnail) r9
            java.lang.String r9 = r9.getUrl()
            android.widget.ImageView r2 = r7.f42512d
            com.paytm.android.chat.utils.ImageUtils.displayConnerImageFromUrl(r8, r9, r2)
            goto L_0x0193
        L_0x0186:
            android.content.Context r8 = r7.getContext()
            java.lang.String r9 = r2.getUrl()
            android.widget.ImageView r2 = r7.f42512d
            com.paytm.android.chat.utils.ImageUtils.displayConnerImageFromUrl(r8, r9, r2)
        L_0x0193:
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r8 = r7.f42511c
            r8.setVisibility(r0)
            goto L_0x019e
        L_0x0199:
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r8 = r7.f42511c
            r8.setVisibility(r3)
        L_0x019e:
            if (r1 == 0) goto L_0x01c2
            int r8 = r1.res
            if (r8 == 0) goto L_0x01b6
            android.widget.RelativeLayout r8 = r7.f42517i
            r8.setVisibility(r0)
            android.widget.ImageView r8 = r7.f42513e
            int r9 = r1.res
            r8.setImageResource(r9)
            int r8 = r1.res
            int r9 = com.paytm.android.chat.R.drawable.chat_icon_chat_message_type_photo
            if (r8 != r9) goto L_0x01bb
        L_0x01b6:
            android.widget.RelativeLayout r8 = r7.f42517i
            r8.setVisibility(r3)
        L_0x01bb:
            android.widget.TextView r8 = r7.f42514f
            java.lang.String r9 = r1.content
            r8.setText(r9)
        L_0x01c2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.ReplyView.a(com.sendbird.android.BaseMessage, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel):void");
    }
}
