package com.paytm.android.chat.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.f;
import com.paytm.android.chat.bean.CTA;
import com.paytm.android.chat.bean.CtaType;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.jsonbean.AdminMessageBean;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.android.chat.bean.jsonbean.UserDataBean;
import com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel;
import com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageUPIData;
import com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel;
import com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel;
import com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel;
import com.paytm.android.chat.data.models.messages.MiniAppNotificationBean;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.utils.CTextUtils;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.DateUtils;
import com.paytm.android.chat.utils.DensityUtil;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.utils.ToastUtil;
import com.paytm.android.chat.view.AudioPlayView;
import com.paytm.android.chat.view.ChatHeadView;
import com.paytm.android.chat.view.CircleProgressBar;
import com.paytm.android.chat.view.FlexBox;
import com.paytm.android.chat.view.round.RoundAngleFrameLayout;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.UserMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class f extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f41127a;

    /* renamed from: b  reason: collision with root package name */
    HashMap<String, AudioPlayView> f41128b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    ChatGroupChannelDataModel f41129c;

    /* renamed from: d  reason: collision with root package name */
    HashMap<String, CircleProgressBar> f41130d;

    /* renamed from: e  reason: collision with root package name */
    List<ChatMessageDataModel> f41131e;

    /* renamed from: f  reason: collision with root package name */
    m f41132f;

    /* renamed from: g  reason: collision with root package name */
    String f41133g = "";

    /* renamed from: h  reason: collision with root package name */
    boolean f41134h = false;

    /* renamed from: i  reason: collision with root package name */
    ChatUserDataModel f41135i;
    String j;
    l k;
    Map<String, File> l = new HashMap();
    boolean m = true;
    private final String n = "GroupChatAdapter";
    private List<BaseMessage> o;
    private n p;
    private o q;
    private String r;

    public interface l {
        void a();
    }

    public interface m {
        void a();

        void a(int i2);

        void a(long j);

        void a(CTA cta, ChatMessageUPIData chatMessageUPIData);

        void a(AdminMessageBean adminMessageBean);

        void a(BaseMessage baseMessage);

        void a(FileMessage fileMessage);

        void a(UserMessage userMessage);

        void a(String str);

        void a(String str, String str2);

        void a(String str, String str2, String str3);

        void b(BaseMessage baseMessage);

        void b(FileMessage fileMessage);

        void c(BaseMessage baseMessage);

        void c(FileMessage fileMessage);

        void d(FileMessage fileMessage);
    }

    public interface n {
        void a(int i2);
    }

    public interface o {
        void a(List<ChatMessageDataModel> list);
    }

    public final void a(List<ChatMessageDataModel> list, h.b bVar) {
        if (list == null || list.isEmpty()) {
            list = new ArrayList<>();
            this.f41128b.clear();
            this.f41130d.clear();
        }
        this.f41131e.clear();
        this.f41131e.addAll(list);
        bVar.a((RecyclerView.a) this);
        o oVar = this.q;
        if (oVar != null) {
            oVar.a(this.f41131e);
        }
    }

    public final void a() {
        notifyItemRangeChanged(0, this.f41131e.size());
    }

    public final void a(boolean z2) {
        this.f41134h = z2;
    }

    public f(Context context) {
        this.f41127a = context;
        this.o = new ArrayList();
        this.f41131e = new ArrayList();
        this.f41130d = new HashMap<>();
    }

    public final void a(Context context) {
        this.f41127a = context;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x09e7, code lost:
        if (r2.equals("pptx") != false) goto L_0x0a23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:323:0x0ad5, code lost:
        if (r2.equals("pptx") != false) goto L_0x0b11;
     */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x070f  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x071e  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x079d  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x07a7  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x07ad  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x090c  */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x090e  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0915  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x091c  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0926  */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0945  */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0973  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:468:0x0f77  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.RecyclerView.v r17, int r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r0.f41129c
            if (r2 == 0) goto L_0x0fd7
            java.lang.String r2 = r2.getChannelUrl()
            com.sendbird.android.GroupChannel r2 = com.paytm.android.chat.d.a.b.a(r2)
            if (r2 != 0) goto L_0x0014
            goto L_0x0fd7
        L_0x0014:
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r0.f41129c
            java.lang.String r2 = r2.getChannelUrl()
            com.sendbird.android.GroupChannel r2 = com.paytm.android.chat.d.a.b.a(r2)
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r3 = r0.f41131e
            java.lang.Object r3 = r3.get(r1)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r3
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r4 = r0.f41131e
            int r4 = r4.size()
            r5 = 1
            int r4 = r4 - r5
            r6 = 0
            if (r1 >= r4) goto L_0x0045
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r4 = r0.f41131e
            int r7 = r1 + 1
            java.lang.Object r4 = r4.get(r7)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r4 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r4
            long r7 = r3.time
            long r9 = r4.time
            boolean r4 = com.paytm.android.chat.utils.DateUtils.hasSameDate(r7, r9)
            r4 = r4 ^ r5
            goto L_0x0051
        L_0x0045:
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r4 = r0.f41131e
            int r4 = r4.size()
            int r4 = r4 - r5
            if (r1 != r4) goto L_0x0050
            r4 = 1
            goto L_0x0051
        L_0x0050:
            r4 = 0
        L_0x0051:
            if (r1 != 0) goto L_0x0055
            r7 = 1
            goto L_0x0056
        L_0x0055:
            r7 = 0
        L_0x0056:
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r9 = r0.f41131e     // Catch:{ Exception -> 0x00bc }
            int r9 = r9.size()     // Catch:{ Exception -> 0x00bc }
            int r9 = r9 - r5
            if (r1 == r9) goto L_0x00bc
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r9 = r0.f41131e     // Catch:{ Exception -> 0x00bc }
            java.lang.Object r9 = r9.get(r1)     // Catch:{ Exception -> 0x00bc }
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r9 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r9     // Catch:{ Exception -> 0x00bc }
            com.sendbird.android.BaseMessage r9 = r9.baseMessage     // Catch:{ Exception -> 0x00bc }
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r10 = r0.f41131e     // Catch:{ Exception -> 0x00bc }
            int r11 = r1 + 1
            java.lang.Object r10 = r10.get(r11)     // Catch:{ Exception -> 0x00bc }
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r10 = (com.paytm.android.chat.data.models.messages.ChatMessageDataModel) r10     // Catch:{ Exception -> 0x00bc }
            com.sendbird.android.BaseMessage r10 = r10.baseMessage     // Catch:{ Exception -> 0x00bc }
            boolean r11 = r9 instanceof com.sendbird.android.UserMessage     // Catch:{ Exception -> 0x00bc }
            if (r11 == 0) goto L_0x0084
            com.sendbird.android.UserMessage r9 = (com.sendbird.android.UserMessage) r9     // Catch:{ Exception -> 0x00bc }
            com.sendbird.android.Sender r9 = r9.getSender()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r9 = r9.getUserId()     // Catch:{ Exception -> 0x00bc }
            goto L_0x0094
        L_0x0084:
            boolean r11 = r9 instanceof com.sendbird.android.FileMessage     // Catch:{ Exception -> 0x00bc }
            if (r11 == 0) goto L_0x0093
            com.sendbird.android.FileMessage r9 = (com.sendbird.android.FileMessage) r9     // Catch:{ Exception -> 0x00bc }
            com.sendbird.android.Sender r9 = r9.getSender()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r9 = r9.getUserId()     // Catch:{ Exception -> 0x00bc }
            goto L_0x0094
        L_0x0093:
            r9 = 0
        L_0x0094:
            boolean r11 = r10 instanceof com.sendbird.android.UserMessage     // Catch:{ Exception -> 0x00bc }
            if (r11 == 0) goto L_0x00a3
            com.sendbird.android.UserMessage r10 = (com.sendbird.android.UserMessage) r10     // Catch:{ Exception -> 0x00bc }
            com.sendbird.android.Sender r10 = r10.getSender()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r10 = r10.getUserId()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00b3
        L_0x00a3:
            boolean r11 = r10 instanceof com.sendbird.android.FileMessage     // Catch:{ Exception -> 0x00bc }
            if (r11 == 0) goto L_0x00b2
            com.sendbird.android.FileMessage r10 = (com.sendbird.android.FileMessage) r10     // Catch:{ Exception -> 0x00bc }
            com.sendbird.android.Sender r10 = r10.getSender()     // Catch:{ Exception -> 0x00bc }
            java.lang.String r10 = r10.getUserId()     // Catch:{ Exception -> 0x00bc }
            goto L_0x00b3
        L_0x00b2:
            r10 = 0
        L_0x00b3:
            if (r9 == 0) goto L_0x00bc
            if (r10 == 0) goto L_0x00bc
            boolean r9 = r9.equals(r10)     // Catch:{ Exception -> 0x00bc }
            goto L_0x00bd
        L_0x00bc:
            r9 = 0
        L_0x00bd:
            java.util.List<com.paytm.android.chat.data.models.messages.ChatMessageDataModel> r10 = r0.f41131e
            r10.get(r1)
            long r10 = r3.messageId
            r12 = 0
            int r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x00cc
            r1 = 1
            goto L_0x00cd
        L_0x00cc:
            r1 = 0
        L_0x00cd:
            int r10 = r17.getItemViewType()
            r12 = 8
            if (r10 == 0) goto L_0x0f77
            if (r10 == r5) goto L_0x0f28
            java.lang.String r13 = "jpg"
            java.lang.String r14 = "doc"
            java.lang.String r8 = "reply"
            java.lang.String r15 = "image"
            java.lang.String r11 = ""
            r5 = 4
            switch(r10) {
                case 10: goto L_0x0d3e;
                case 11: goto L_0x0b5c;
                case 12: goto L_0x0a7d;
                case 13: goto L_0x09c6;
                case 14: goto L_0x080e;
                case 15: goto L_0x06bf;
                case 16: goto L_0x060f;
                case 17: goto L_0x0587;
                case 18: goto L_0x057d;
                case 19: goto L_0x0573;
                case 20: goto L_0x04d6;
                case 21: goto L_0x0381;
                case 22: goto L_0x02d3;
                case 23: goto L_0x02c9;
                case 24: goto L_0x02bf;
                case 25: goto L_0x02b5;
                case 26: goto L_0x02ab;
                case 27: goto L_0x01da;
                case 28: goto L_0x01d0;
                case 29: goto L_0x01c6;
                case 30: goto L_0x01bc;
                case 31: goto L_0x01b2;
                case 32: goto L_0x00ef;
                default: goto L_0x00e5;
            }
        L_0x00e5:
            r1 = r17
            com.paytm.android.chat.a.f$c r1 = (com.paytm.android.chat.a.f.c) r1
            androidx.cardview.widget.CardView r1 = r1.f41175a
            r1.setVisibility(r12)
            return
        L_0x00ef:
            r1 = r17
            com.paytm.android.chat.a.f$ab r1 = (com.paytm.android.chat.a.f.ab) r1
            com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel) r3
            com.paytm.android.chat.data.models.messages.ChatMessageUPIData r2 = r3.getData()
            if (r2 == 0) goto L_0x01ac
            com.paytm.android.chat.data.models.messages.ChatMessageUPIData r2 = r3.getData()
            com.paytm.android.chat.bean.jsonbean.UserDataBean r7 = r2.getReply()
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r8 = r8.f41129c
            r1.a((com.paytm.android.chat.bean.jsonbean.UserDataBean) r7, (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r8)
            java.lang.String r7 = r2.getReceiverState()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0123
            android.widget.TextView r7 = r1.f41158a
            java.lang.String r8 = r2.getReceiverState()
            r7.setText(r8)
            android.widget.TextView r7 = r1.f41158a
            r7.setVisibility(r6)
            goto L_0x0128
        L_0x0123:
            android.widget.TextView r7 = r1.f41158a
            r7.setVisibility(r12)
        L_0x0128:
            java.lang.String r7 = r2.getReceiverDesc()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0141
            android.widget.TextView r7 = r1.f41159b
            java.lang.String r2 = r2.getReceiverDesc()
            r7.setText(r2)
            android.widget.TextView r2 = r1.f41159b
            r2.setVisibility(r6)
            goto L_0x0146
        L_0x0141:
            android.widget.TextView r2 = r1.f41159b
            r2.setVisibility(r12)
        L_0x0146:
            if (r4 == 0) goto L_0x015d
            android.widget.TextView r2 = r1.f41161d
            r2.setVisibility(r6)
            android.widget.TextView r2 = r1.f41161d
            long r7 = r3.time
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            android.content.Context r10 = r10.f41127a
            java.lang.String r7 = com.paytm.android.chat.utils.DateUtils.getMessageDate(r7, r10)
            r2.setText(r7)
            goto L_0x0162
        L_0x015d:
            android.widget.TextView r2 = r1.f41161d
            r2.setVisibility(r12)
        L_0x0162:
            android.widget.TextView r2 = r1.f41160c
            long r7 = r3.time
            java.lang.String r3 = com.paytm.android.chat.utils.DateUtils.formatDateMonthTime(r7)
            r2.setText(r3)
            if (r4 != 0) goto L_0x018c
            if (r9 == 0) goto L_0x018c
            android.view.View r2 = r1.f41163f
            android.view.View r3 = r1.f41163f
            android.content.Context r3 = r3.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.paytm.android.chat.R.drawable.chat_shape_chat_other_rounded_bg
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)
            r2.setBackground(r3)
            android.widget.ImageView r2 = r1.f41162e
            r2.setVisibility(r5)
            goto L_0x01a6
        L_0x018c:
            android.widget.ImageView r2 = r1.f41162e
            r2.setVisibility(r6)
            android.view.View r2 = r1.f41163f
            android.view.View r3 = r1.f41163f
            android.content.Context r3 = r3.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.paytm.android.chat.R.drawable.chat_shape_chat_other_bg
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)
            r2.setBackground(r3)
        L_0x01a6:
            android.view.View r1 = r1.f41164g
            r1.setVisibility(r6)
            return
        L_0x01ac:
            android.view.View r1 = r1.f41164g
            r1.setVisibility(r12)
            return
        L_0x01b2:
            r1 = r17
            com.paytm.android.chat.a.f$aa r1 = (com.paytm.android.chat.a.f.aa) r1
            com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel) r3
            r1.a(r3, r2, r4, r9)
            return
        L_0x01bc:
            r1 = r17
            com.paytm.android.chat.a.f$z r1 = (com.paytm.android.chat.a.f.z) r1
            com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel r3 = (com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel) r3
            r1.a(r3, r4, r9)
            return
        L_0x01c6:
            r1 = r17
            com.paytm.android.chat.a.f$y r1 = (com.paytm.android.chat.a.f.y) r1
            com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel r3 = (com.paytm.android.chat.data.models.messages.ChatUPIRequestDatModel) r3
            r1.a(r3, r2, r4, r9)
            return
        L_0x01d0:
            r1 = r17
            com.paytm.android.chat.a.f$d r1 = (com.paytm.android.chat.a.f.d) r1
            com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel) r3
            r1.a((com.paytm.android.chat.data.models.messages.ChatGenericMessageDataModel) r3, (boolean) r4, (boolean) r9)
            return
        L_0x01da:
            r1 = r17
            com.paytm.android.chat.a.f$b r1 = (com.paytm.android.chat.a.f.b) r1
            com.paytm.android.chat.data.models.messages.MiniAppNotificationBean r3 = (com.paytm.android.chat.data.models.messages.MiniAppNotificationBean) r3
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r2 = r3.getNotifData()
            if (r2 == 0) goto L_0x02a5
            com.paytm.android.chat.data.models.messages.MiniAppNotificationData r2 = r3.getNotifData()
            java.lang.String r7 = r2.getTitle()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0203
            android.widget.TextView r7 = r1.f41166a
            java.lang.String r8 = r2.getTitle()
            r7.setText(r8)
            android.widget.TextView r7 = r1.f41166a
            r7.setVisibility(r6)
            goto L_0x0208
        L_0x0203:
            android.widget.TextView r7 = r1.f41166a
            r7.setVisibility(r12)
        L_0x0208:
            java.lang.String r7 = r2.getDesc()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x0221
            android.widget.TextView r7 = r1.f41167b
            java.lang.String r8 = r2.getDesc()
            r7.setText(r8)
            android.widget.TextView r7 = r1.f41167b
            r7.setVisibility(r6)
            goto L_0x0226
        L_0x0221:
            android.widget.TextView r7 = r1.f41167b
            r7.setVisibility(r12)
        L_0x0226:
            android.widget.TextView r7 = r1.f41168c
            java.lang.String r8 = r2.getCta_text()
            r7.setText(r8)
            java.lang.String r2 = r2.getCta_text()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x023f
            android.widget.TextView r2 = r1.f41168c
            r2.setVisibility(r6)
            goto L_0x0244
        L_0x023f:
            android.widget.TextView r2 = r1.f41168c
            r2.setVisibility(r12)
        L_0x0244:
            if (r4 == 0) goto L_0x025b
            android.widget.TextView r2 = r1.f41170e
            r2.setVisibility(r6)
            android.widget.TextView r2 = r1.f41170e
            long r7 = r3.time
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            android.content.Context r10 = r10.f41127a
            java.lang.String r7 = com.paytm.android.chat.utils.DateUtils.getMessageDate(r7, r10)
            r2.setText(r7)
            goto L_0x0260
        L_0x025b:
            android.widget.TextView r2 = r1.f41170e
            r2.setVisibility(r12)
        L_0x0260:
            android.widget.TextView r2 = r1.f41169d
            long r7 = r3.time
            java.lang.String r3 = com.paytm.android.chat.utils.DateUtils.formatTimeWithMarker(r7)
            r2.setText(r3)
            if (r4 != 0) goto L_0x028a
            if (r9 == 0) goto L_0x028a
            android.view.View r2 = r1.f41172g
            android.view.View r3 = r1.f41172g
            android.content.Context r3 = r3.getContext()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = com.paytm.android.chat.R.drawable.chat_shape_chat_other_rounded_bg
            android.graphics.drawable.Drawable r3 = r3.getDrawable(r4)
            r2.setBackground(r3)
            android.widget.ImageView r1 = r1.f41171f
            r1.setVisibility(r5)
            return
        L_0x028a:
            android.widget.ImageView r2 = r1.f41171f
            r2.setVisibility(r6)
            android.view.View r2 = r1.f41172g
            android.view.View r1 = r1.f41172g
            android.content.Context r1 = r1.getContext()
            android.content.res.Resources r1 = r1.getResources()
            int r3 = com.paytm.android.chat.R.drawable.chat_shape_chat_other_bg
            android.graphics.drawable.Drawable r1 = r1.getDrawable(r3)
            r2.setBackground(r1)
            return
        L_0x02a5:
            android.view.View r1 = r1.f41173h
            r1.setVisibility(r12)
            return
        L_0x02ab:
            r1 = r17
            com.paytm.android.chat.a.f$x r1 = (com.paytm.android.chat.a.f.x) r1
            com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel) r3
            r1.a((com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel) r3, (boolean) r4, (boolean) r9)
            return
        L_0x02b5:
            r1 = r17
            com.paytm.android.chat.a.f$w r1 = (com.paytm.android.chat.a.f.w) r1
            com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel) r3
            r1.a((com.paytm.android.chat.data.models.messages.ChatUPIResponseDataModel) r3, (boolean) r4, (boolean) r9)
            return
        L_0x02bf:
            r1 = r17
            com.paytm.android.chat.a.f$x r1 = (com.paytm.android.chat.a.f.x) r1
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r3
            r1.a((com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r3, (boolean) r4, (boolean) r9)
            return
        L_0x02c9:
            r1 = r17
            com.paytm.android.chat.a.f$w r1 = (com.paytm.android.chat.a.f.w) r1
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r3
            r1.a((com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r3, (boolean) r4, (boolean) r9)
            return
        L_0x02d3:
            r1 = r17
            com.paytm.android.chat.a.f$t r1 = (com.paytm.android.chat.a.f.t) r1
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r3
            android.widget.ImageView r2 = r1.f41318h
            r2.setVisibility(r12)
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r2 = r3.bean
            com.paytm.android.chat.bean.jsonbean.UserDataBean r5 = r2.getReply()
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r8 = r8.f41129c
            r1.a((com.paytm.android.chat.bean.jsonbean.UserDataBean) r5, (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r8)
            if (r2 == 0) goto L_0x033d
            com.paytm.android.chat.utils.CTextUtils$Builder r5 = com.paytm.android.chat.utils.CTextUtils.getBuilder(r11)
            java.lang.String r8 = "₹"
            com.paytm.android.chat.utils.CTextUtils$Builder r5 = r5.append(r8)
            r8 = 1061326684(0x3f428f5c, float:0.76)
            com.paytm.android.chat.utils.CTextUtils$Builder r5 = r5.setProportion(r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = r2.getAmount()
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            com.paytm.android.chat.utils.CTextUtils$Builder r5 = r5.append(r8)
            r8 = 1065353216(0x3f800000, float:1.0)
            com.paytm.android.chat.utils.CTextUtils$Builder r5 = r5.setProportion(r8)
            android.widget.TextView r8 = r1.f41311a
            r5.into(r8)
            java.lang.String r5 = r2.getMessage()
            boolean r8 = android.text.TextUtils.isEmpty(r5)
            if (r8 != 0) goto L_0x0333
            android.widget.TextView r8 = r1.f41312b
            r8.setText(r5)
            android.widget.TextView r5 = r1.f41312b
            r5.setVisibility(r6)
            goto L_0x033d
        L_0x0333:
            android.widget.TextView r5 = r1.f41312b
            r5.setText(r11)
            android.widget.TextView r5 = r1.f41312b
            r5.setVisibility(r12)
        L_0x033d:
            long r10 = r3.time
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            android.content.Context r5 = r5.f41127a
            r1.b(r4, r10, r5)
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r8 = r3.baseMessage
            android.view.View r10 = r1.n
            android.view.View r11 = r1.p
            r5.b(r8, r10, r11)
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5 = r5.f41129c
            boolean r5 = r5.isReplyAllowed()
            r1.b(r5)
            android.view.View r5 = r1.f41313c
            com.paytm.android.chat.a.f$t$1 r8 = new com.paytm.android.chat.a.f$t$1
            r8.<init>(r2)
            r5.setOnClickListener(r8)
            r1.a((boolean) r4, (boolean) r9, (boolean) r6)
            if (r7 == 0) goto L_0x0380
            boolean r2 = r3.showAnim
            if (r2 == 0) goto L_0x0380
            android.widget.LinearLayout r2 = r1.f41316f
            android.view.animation.Animation r4 = r1.f41314d
            r2.startAnimation(r4)
            android.view.animation.Animation r2 = r1.f41314d
            com.paytm.android.chat.a.f$t$2 r4 = new com.paytm.android.chat.a.f$t$2
            r4.<init>(r3)
            r2.setAnimationListener(r4)
        L_0x0380:
            return
        L_0x0381:
            r1 = r17
            com.paytm.android.chat.a.f$f r1 = (com.paytm.android.chat.a.f.C0690f) r1
            com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel) r3
            com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean r5 = r3.bean
            if (r5 == 0) goto L_0x045f
            com.paytm.android.chat.bean.jsonbean.UserDataBean r8 = r5.getReply()
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r10 = r10.f41129c
            r1.a((com.paytm.android.chat.bean.jsonbean.UserDataBean) r8, (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r10)
            com.paytm.android.chat.utils.CTextUtils$Builder r8 = com.paytm.android.chat.utils.CTextUtils.getBuilder(r11)
            java.lang.String r10 = "₹"
            com.paytm.android.chat.utils.CTextUtils$Builder r8 = r8.append(r10)
            r10 = 1061326684(0x3f428f5c, float:0.76)
            com.paytm.android.chat.utils.CTextUtils$Builder r8 = r8.setProportion(r10)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r13 = r5.getAmount()
            r10.append(r13)
            java.lang.String r10 = r10.toString()
            com.paytm.android.chat.utils.CTextUtils$Builder r8 = r8.append(r10)
            r10 = 1065353216(0x3f800000, float:1.0)
            com.paytm.android.chat.utils.CTextUtils$Builder r8 = r8.setProportion(r10)
            android.widget.TextView r10 = r1.f41203a
            r8.into(r10)
            java.lang.String r8 = r5.getMessage()
            boolean r10 = android.text.TextUtils.isEmpty(r8)
            if (r10 != 0) goto L_0x03dc
            android.widget.TextView r10 = r1.f41204b
            r10.setText(r8)
            android.widget.TextView r8 = r1.f41204b
            r8.setVisibility(r6)
            goto L_0x03e6
        L_0x03dc:
            android.widget.TextView r8 = r1.f41204b
            r8.setVisibility(r12)
            android.widget.TextView r8 = r1.f41204b
            r8.setText(r11)
        L_0x03e6:
            int r8 = r5.getStatus()
            if (r8 != 0) goto L_0x0428
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r8 = r3.state
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r10 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            if (r8 != r10) goto L_0x03f4
            r8 = 1
            goto L_0x03f5
        L_0x03f4:
            r8 = 0
        L_0x03f5:
            com.sendbird.android.BaseMessage r10 = r3.baseMessage
            r1.a(r8, r2, r10)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            int r8 = com.paytm.android.chat.R.string.chat_module_paid
            java.lang.String r2 = r2.getString(r8)
            android.widget.ImageView r8 = r1.k
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            android.content.Context r10 = r10.f41127a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = com.paytm.android.chat.R.drawable.chat_ic_payment_success
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r11)
            r8.setImageDrawable(r10)
            android.view.View r8 = r1.l
            r8.setVisibility(r6)
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r8 = r8.f41129c
            boolean r8 = r8.isReplyAllowed()
            r1.b(r8)
            goto L_0x0452
        L_0x0428:
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            int r8 = com.paytm.android.chat.R.string.chat_module_pending
            java.lang.String r2 = r2.getString(r8)
            android.widget.ImageView r8 = r1.j
            r8.setVisibility(r12)
            android.widget.ImageView r8 = r1.k
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            android.content.Context r10 = r10.f41127a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = com.paytm.android.chat.R.drawable.chat_ic_payment_pending
            android.graphics.drawable.Drawable r10 = r10.getDrawable(r11)
            r8.setImageDrawable(r10)
            android.view.View r8 = r1.l
            r8.setVisibility(r12)
            r1.b(r6)
        L_0x0452:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            com.paytm.android.chat.utils.CTextUtils$Builder r2 = com.paytm.android.chat.utils.CTextUtils.getBuilder(r2)
            android.widget.TextView r8 = r1.f41205c
            r2.into(r8)
        L_0x045f:
            long r10 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.b(r4, r10, r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r8 = r3.baseMessage
            android.view.View r10 = r1.n
            android.view.View r11 = r1.p
            r2.b(r8, r10, r11)
            android.view.View r2 = r1.f41206d
            com.paytm.android.chat.a.f$f$1 r8 = new com.paytm.android.chat.a.f$f$1
            r8.<init>(r5)
            r2.setOnClickListener(r8)
            r2 = 1
            r1.a((boolean) r4, (boolean) r9, (boolean) r2)
            if (r7 == 0) goto L_0x04a9
            boolean r2 = r3.showAnim
            if (r2 == 0) goto L_0x04a9
            int r2 = r5.getStatus()
            if (r2 != 0) goto L_0x04a9
            android.widget.LinearLayout r2 = r1.f41211i
            android.view.animation.Animation r4 = r1.f41209g
            r2.startAnimation(r4)
            android.view.animation.Animation r2 = r1.f41209g
            com.paytm.android.chat.a.f$f$2 r4 = new com.paytm.android.chat.a.f$f$2
            r4.<init>()
            r2.setAnimationListener(r4)
            android.view.animation.Animation r2 = r1.f41210h
            com.paytm.android.chat.a.f$f$3 r4 = new com.paytm.android.chat.a.f$f$3
            r4.<init>(r3, r5)
            r2.setAnimationListener(r4)
            return
        L_0x04a9:
            boolean r2 = r3.showQuickReply
            if (r2 == 0) goto L_0x04d0
            androidx.recyclerview.widget.RecyclerView r2 = r1.f41207e
            r2.setVisibility(r6)
            java.lang.String[] r2 = r5.getSenderQuickReply()
            java.util.List r2 = java.util.Arrays.asList(r2)
            com.paytm.android.chat.a.j r3 = new com.paytm.android.chat.a.j
            com.paytm.android.chat.a.f r4 = com.paytm.android.chat.a.f.this
            android.content.Context r4 = r4.f41127a
            r3.<init>(r4, r2)
            androidx.recyclerview.widget.RecyclerView r2 = r1.f41207e
            r2.setAdapter(r3)
            com.paytm.android.chat.a.f$f$4 r2 = new com.paytm.android.chat.a.f$f$4
            r2.<init>()
            r3.f41402a = r2
            return
        L_0x04d0:
            androidx.recyclerview.widget.RecyclerView r1 = r1.f41207e
            r1.setVisibility(r12)
            return
        L_0x04d6:
            r1 = r17
            com.paytm.android.chat.a.f$a r1 = (com.paytm.android.chat.a.f.a) r1
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean r3 = (com.paytm.android.chat.bean.jsonbean.AdminMessageBean) r3
            com.sendbird.android.BaseMessage r2 = r3.baseMessage
            boolean r2 = r2 instanceof com.sendbird.android.AdminMessage
            if (r2 == 0) goto L_0x0568
            android.widget.TextView r2 = r1.f41142a
            java.lang.String r4 = r3.message
            r2.setText(r4)
            android.widget.TextView r2 = r1.f41142a
            r2.setVisibility(r6)
            androidx.cardview.widget.CardView r2 = r1.f41143b
            r2.setVisibility(r6)
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean$UIInfo r2 = com.paytm.android.chat.utils.AppUtilKt.getMyAdminMessageUiInfoDetails(r3)
            if (r2 == 0) goto L_0x0528
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean$UIInfo r2 = com.paytm.android.chat.utils.AppUtilKt.getMyAdminMessageUiInfoDetails(r3)
            java.lang.String r2 = r2.getLeft()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0528
            android.widget.ImageView r2 = r1.f41144c
            r2.setVisibility(r6)
            android.view.View r2 = r1.itemView
            android.content.Context r2 = r2.getContext()
            com.bumptech.glide.i r2 = com.bumptech.glide.b.b(r2)
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean$UIInfo r4 = com.paytm.android.chat.utils.AppUtilKt.getMyAdminMessageUiInfoDetails(r3)
            java.lang.String r4 = r4.getLeft()
            com.bumptech.glide.h r2 = r2.a((java.lang.String) r4)
            android.widget.ImageView r4 = r1.f41144c
            r2.a((android.widget.ImageView) r4)
            goto L_0x052d
        L_0x0528:
            android.widget.ImageView r2 = r1.f41144c
            r2.setVisibility(r12)
        L_0x052d:
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean$UIInfo r2 = com.paytm.android.chat.utils.AppUtilKt.getMyAdminMessageUiInfoDetails(r3)
            if (r2 == 0) goto L_0x0562
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean$UIInfo r2 = com.paytm.android.chat.utils.AppUtilKt.getMyAdminMessageUiInfoDetails(r3)
            java.lang.String r2 = r2.getRight()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x0562
            android.widget.ImageView r2 = r1.f41145d
            r2.setVisibility(r6)
            android.view.View r2 = r1.itemView
            android.content.Context r2 = r2.getContext()
            com.bumptech.glide.i r2 = com.bumptech.glide.b.b(r2)
            com.paytm.android.chat.bean.jsonbean.AdminMessageBean$UIInfo r3 = com.paytm.android.chat.utils.AppUtilKt.getMyAdminMessageUiInfoDetails(r3)
            java.lang.String r3 = r3.getRight()
            com.bumptech.glide.h r2 = r2.a((java.lang.String) r3)
            android.widget.ImageView r1 = r1.f41145d
            r2.a((android.widget.ImageView) r1)
            return
        L_0x0562:
            android.widget.ImageView r1 = r1.f41145d
            r1.setVisibility(r12)
            return
        L_0x0568:
            android.widget.TextView r2 = r1.f41142a
            r2.setVisibility(r12)
            androidx.cardview.widget.CardView r1 = r1.f41143b
            r1.setVisibility(r12)
            return
        L_0x0573:
            r1 = r17
            com.paytm.android.chat.a.f$q r1 = (com.paytm.android.chat.a.f.q) r1
            com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel) r3
            r1.a(r3, r4, r9)
            return
        L_0x057d:
            r1 = r17
            com.paytm.android.chat.a.f$e r1 = (com.paytm.android.chat.a.f.e) r1
            com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatContactsMessageDataModel) r3
            r1.a(r3, r2, r4, r9)
            return
        L_0x0587:
            r1 = r17
            com.paytm.android.chat.a.f$p r1 = (com.paytm.android.chat.a.f.p) r1
            com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel) r3
            long r7 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r7, (android.content.Context) r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r7 = r1.n
            android.view.View r8 = r1.p
            r2.b(r5, r7, r8)
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41279a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r3.fileUrl
            r5.append(r7)
            java.lang.String r7 = r3.requestId
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r2.setTag(r5)
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41279a
            java.lang.String r5 = r3.fileName
            r2.setAudioName(r5)
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41279a
            android.widget.ImageView r2 = r2.getImagePlay()
            com.paytm.android.chat.a.f$p$1 r5 = new com.paytm.android.chat.a.f$p$1
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            com.paytm.android.chat.view.AudioPlayView r5 = r1.f41279a
            android.widget.SeekBar r5 = r5.getAudioBar()
            com.paytm.android.chat.a.f$p$2 r7 = new com.paytm.android.chat.a.f$p$2
            r7.<init>(r3)
            r5.setOnSeekBarChangeListener(r7)
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r7 = r1.n
            r5.a((com.sendbird.android.BaseMessage) r3, (android.view.View) r7, (android.view.View) r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            java.lang.String r2 = r2.f41133g
            if (r2 == 0) goto L_0x0600
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            java.lang.String r2 = r2.f41133g
            com.paytm.android.chat.view.AudioPlayView r3 = r1.f41279a
            java.lang.Object r3 = r3.getTag()
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0600
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41279a
            r2.setAudioTime(r6, r6)
        L_0x0600:
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r2.f41129c
            boolean r2 = r2.isReplyAllowed()
            r1.b(r2)
            r1.a((boolean) r4, (boolean) r9, (boolean) r6)
            return
        L_0x060f:
            r1 = r17
            com.paytm.android.chat.a.f$g r1 = (com.paytm.android.chat.a.f.g) r1
            com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatAudioMessageDataModel) r3
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r5 = r3.state
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r7 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            if (r5 != r7) goto L_0x061d
            r5 = 1
            goto L_0x061e
        L_0x061d:
            r5 = 0
        L_0x061e:
            com.sendbird.android.BaseMessage r7 = r3.baseMessage
            r1.a(r5, r2, r7)
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41220a
            java.lang.String r5 = r3.fileName
            r2.setAudioName(r5)
            boolean r2 = r3.isForward
            r1.a((boolean) r2)
            long r7 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r7, (android.content.Context) r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r2.f41129c
            boolean r2 = r2.isReplyAllowed()
            r1.b(r2)
            android.widget.TextView r2 = r1.u
            com.paytm.android.chat.a.f$g$1 r5 = new com.paytm.android.chat.a.f$g$1
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            android.widget.TextView r2 = r1.v
            com.paytm.android.chat.a.f$g$2 r5 = new com.paytm.android.chat.a.f$g$2
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41220a
            android.widget.ImageView r2 = r2.getImagePlay()
            com.paytm.android.chat.a.f$g$3 r5 = new com.paytm.android.chat.a.f$g$3
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r7 = r3.baseMessage
            android.view.View r8 = r1.n
            r5.a((com.sendbird.android.BaseMessage) r7, (android.view.View) r8, (android.view.View) r2)
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41220a
            android.widget.SeekBar r2 = r2.getAudioBar()
            com.paytm.android.chat.a.f$g$4 r5 = new com.paytm.android.chat.a.f$g$4
            r5.<init>(r3)
            r2.setOnSeekBarChangeListener(r5)
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41220a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r7 = r3.fileUrl
            r5.append(r7)
            java.lang.String r7 = r3.requestId
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            r2.setTag(r5)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            java.lang.String r2 = r2.f41133g
            if (r2 == 0) goto L_0x06af
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            java.lang.String r2 = r2.f41133g
            com.paytm.android.chat.view.AudioPlayView r5 = r1.f41220a
            java.lang.Object r5 = r5.getTag()
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x06af
            com.paytm.android.chat.view.AudioPlayView r2 = r1.f41220a
            r2.setAudioTime(r6, r6)
        L_0x06af:
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.view.View r6 = r1.p
            r2.b(r3, r5, r6)
            r2 = 1
            r1.a((boolean) r4, (boolean) r9, (boolean) r2)
            return
        L_0x06bf:
            r1 = r17
            com.paytm.android.chat.a.f$s r1 = (com.paytm.android.chat.a.f.s) r1
            android.content.Context r2 = r0.f41127a
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel) r3
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            java.util.HashMap<java.lang.String, com.paytm.android.chat.view.CircleProgressBar> r5 = r5.f41130d
            java.lang.String r7 = r3.fileName
            com.paytm.android.chat.view.CircleProgressBar r8 = r1.f41304d
            r5.put(r7, r8)
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5 = r5.f41129c
            boolean r5 = r5.isReplyAllowed()
            r1.b(r5)
            long r7 = r3.time
            r1.a((boolean) r4, (long) r7, (android.content.Context) r2)
            java.lang.String r5 = r3.messageData
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x06fd
            java.lang.String r5 = r3.messageData
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x06fd
            android.widget.TextView r7 = r1.f41301a
            r7.setText(r5)
            android.widget.TextView r5 = r1.f41301a
            r5.setVisibility(r6)
            goto L_0x0702
        L_0x06fd:
            android.widget.TextView r5 = r1.f41301a
            r5.setVisibility(r12)
        L_0x0702:
            java.lang.String r5 = r3.fileType
            java.lang.String r5 = r5.toLowerCase()
            boolean r5 = r5.startsWith(r15)
            if (r5 == 0) goto L_0x070f
            goto L_0x0712
        L_0x070f:
            java.lang.String r15 = "video"
        L_0x0712:
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            boolean r5 = r5.m
            if (r5 == 0) goto L_0x079d
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.users.ChatUserDataModel r5 = r5.f41135i
            if (r5 == 0) goto L_0x079d
            java.lang.String r5 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            com.paytm.android.chat.a.f r7 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.users.ChatUserDataModel r7 = r7.f41135i
            java.lang.String r7 = r7.getSendbirdUserId()
            java.lang.String r5 = com.paytm.android.chat.utils.FileUtils.getTypePath(r2, r5, r7, r15)
            com.paytm.android.chat.a.f r7 = com.paytm.android.chat.a.f.this
            java.util.Map<java.lang.String, java.io.File> r7 = r7.l
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = r3.fileName
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            java.lang.Object r7 = r7.get(r8)
            java.io.File r7 = (java.io.File) r7
            if (r7 != 0) goto L_0x0792
            java.io.File r7 = new java.io.File
            java.lang.String r8 = r3.fileName
            r7.<init>(r5, r8)
            boolean r5 = r7.exists()
            if (r5 == 0) goto L_0x076b
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            java.util.Map<java.lang.String, java.io.File> r5 = r5.l
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r10 = r3.fileName
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            r5.put(r8, r7)
            goto L_0x0792
        L_0x076b:
            java.io.File r8 = new java.io.File
            java.lang.String r5 = com.paytm.android.chat.utils.FileUtils.getAbsCameraPath()
            java.lang.String r7 = r3.fileName
            r8.<init>(r5, r7)
            boolean r5 = r8.exists()
            if (r5 == 0) goto L_0x079e
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            java.util.Map<java.lang.String, java.io.File> r5 = r5.l
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = r3.fileName
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r5.put(r7, r8)
            goto L_0x0793
        L_0x0792:
            r8 = r7
        L_0x0793:
            java.lang.String r5 = r8.getAbsolutePath()
            android.widget.ImageView r7 = r1.f41302b
            com.paytm.android.chat.utils.ImageUtils.displayImageFromFile(r2, r5, r7)
            goto L_0x079e
        L_0x079d:
            r8 = 0
        L_0x079e:
            if (r8 == 0) goto L_0x07ad
            boolean r5 = r8.exists()
            if (r5 != 0) goto L_0x07a7
            goto L_0x07ad
        L_0x07a7:
            android.view.View r2 = r1.f41303c
            r2.setVisibility(r12)
            goto L_0x07d5
        L_0x07ad:
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            boolean r5 = r5.m
            if (r5 == 0) goto L_0x07b8
            android.view.View r5 = r1.f41303c
            r5.setVisibility(r6)
        L_0x07b8:
            java.lang.String r5 = r3.thumbnail
            if (r8 == 0) goto L_0x07c2
            boolean r7 = r8.exists()
            if (r7 != 0) goto L_0x07d5
        L_0x07c2:
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x07ce
            android.widget.ImageView r7 = r1.f41302b
            com.paytm.android.chat.utils.ImageUtils.displayImageBlurreFromUrl(r2, r5, r7)
            goto L_0x07d5
        L_0x07ce:
            java.lang.String r5 = r3.fileUrl
            android.widget.ImageView r7 = r1.f41302b
            com.paytm.android.chat.utils.ImageUtils.displayImageBlurreFromUrl(r2, r5, r7)
        L_0x07d5:
            android.widget.ImageView r2 = r1.f41302b
            com.paytm.android.chat.a.f$s$1 r5 = new com.paytm.android.chat.a.f$s$1
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            android.view.View r2 = r1.f41305e
            com.paytm.android.chat.a.f$s$2 r5 = new com.paytm.android.chat.a.f$s$2
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r7 = r1.n
            android.widget.ImageView r8 = r1.f41302b
            r2.a((com.sendbird.android.BaseMessage) r5, (android.view.View) r7, (android.view.View) r8)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r7 = r1.n
            android.view.View r8 = r1.f41305e
            r2.a((com.sendbird.android.BaseMessage) r5, (android.view.View) r7, (android.view.View) r8)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.view.View r7 = r1.p
            r2.b(r3, r5, r7)
            r1.a((boolean) r4, (boolean) r9, (boolean) r6)
            return
        L_0x080e:
            r5 = r17
            com.paytm.android.chat.a.f$i r5 = (com.paytm.android.chat.a.f.i) r5
            android.content.Context r7 = r0.f41127a
            com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatImageMessageDataModel) r3
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            java.util.HashMap<java.lang.String, com.paytm.android.chat.view.CircleProgressBar> r8 = r8.f41130d
            java.lang.String r10 = r3.fileName
            com.paytm.android.chat.view.CircleProgressBar r11 = r5.f41246f
            r8.put(r10, r11)
            long r10 = r3.time
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            android.content.Context r8 = r8.f41127a
            r5.a((boolean) r4, (long) r10, (android.content.Context) r8)
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            boolean r8 = r8.m
            if (r8 == 0) goto L_0x08d3
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            java.util.Map<java.lang.String, java.io.File> r8 = r8.l
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = r3.fileName
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.lang.Object r8 = r8.get(r10)
            java.io.File r8 = (java.io.File) r8
            if (r8 != 0) goto L_0x08c9
            java.io.File r8 = new java.io.File
            java.lang.String r10 = r3.filePath
            r8.<init>(r10)
            boolean r10 = r8.exists()
            if (r10 != 0) goto L_0x08c1
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.users.ChatUserDataModel r10 = r10.f41135i
            if (r10 == 0) goto L_0x08d4
            java.lang.String r8 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.users.ChatUserDataModel r10 = r10.f41135i
            java.lang.String r10 = r10.getSendbirdUserId()
            java.lang.String r8 = com.paytm.android.chat.utils.FileUtils.getTypePath(r7, r8, r10, r15)
            java.io.File r10 = new java.io.File
            java.lang.String r11 = r3.fileName
            r10.<init>(r8, r11)
            boolean r8 = r10.exists()
            if (r8 == 0) goto L_0x0891
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            java.util.Map<java.lang.String, java.io.File> r8 = r8.l
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = r3.fileName
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            r8.put(r11, r10)
            r8 = r10
            goto L_0x08c9
        L_0x0891:
            java.io.File r8 = new java.io.File
            java.lang.String r10 = com.paytm.android.chat.utils.FileUtils.getAbsCameraPath()
            java.lang.String r11 = r3.fileName
            r8.<init>(r10, r11)
            boolean r10 = r8.exists()
            if (r10 == 0) goto L_0x08d4
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            java.util.Map<java.lang.String, java.io.File> r10 = r10.l
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = r3.fileName
            r11.append(r13)
            java.lang.String r11 = r11.toString()
            r10.put(r11, r8)
            java.lang.String r10 = r8.getAbsolutePath()
            android.widget.ImageView r11 = r5.f41242b
            com.paytm.android.chat.utils.ImageUtils.displayImageFromFile(r7, r10, r11)
            goto L_0x08d4
        L_0x08c1:
            java.lang.String r10 = r3.filePath
            android.widget.ImageView r11 = r5.f41242b
            com.paytm.android.chat.utils.ImageUtils.displayImageFromFile(r7, r10, r11)
            goto L_0x08d4
        L_0x08c9:
            java.lang.String r10 = r8.getAbsolutePath()
            android.widget.ImageView r11 = r5.f41242b
            com.paytm.android.chat.utils.ImageUtils.displayImageFromFile(r7, r10, r11)
            goto L_0x08d4
        L_0x08d3:
            r8 = 0
        L_0x08d4:
            java.lang.String r10 = r3.messageData
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x08ef
            java.lang.String r10 = r3.messageData
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x08ef
            android.widget.TextView r11 = r5.f41241a
            r11.setText(r10)
            android.widget.TextView r10 = r5.f41241a
            r10.setVisibility(r6)
            goto L_0x08fb
        L_0x08ef:
            android.widget.TextView r10 = r5.f41241a
            java.lang.String r11 = " "
            r10.setText(r11)
            android.widget.TextView r10 = r5.f41241a
            r10.setVisibility(r6)
        L_0x08fb:
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r10 = r10.f41129c
            boolean r10 = r10.isReplyAllowed()
            r5.b(r10)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r10 = r3.state
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r11 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            if (r10 != r11) goto L_0x090e
            r10 = 1
            goto L_0x090f
        L_0x090e:
            r10 = 0
        L_0x090f:
            com.sendbird.android.BaseMessage r11 = r3.baseMessage
            boolean r13 = r3.isForward
            if (r13 != 0) goto L_0x091a
            java.lang.String r13 = r3.messageData
            android.text.TextUtils.isEmpty(r13)
        L_0x091a:
            if (r10 == 0) goto L_0x0926
            android.view.View r10 = r5.x
            if (r10 == 0) goto L_0x092f
            android.view.View r10 = r5.x
            r10.setVisibility(r6)
            goto L_0x092f
        L_0x0926:
            android.view.View r10 = r5.x
            if (r10 == 0) goto L_0x092f
            android.view.View r10 = r5.x
            r10.setVisibility(r12)
        L_0x092f:
            r5.a(r2, r11)
            boolean r2 = r3.isForward
            r5.a((boolean) r2)
            android.view.View r2 = r5.f41243c
            r2.setVisibility(r12)
            android.view.View r2 = r5.f41244d
            r2.setVisibility(r6)
            java.lang.String r2 = r3.thumbnail
            if (r1 != 0) goto L_0x0973
            if (r8 == 0) goto L_0x0954
            boolean r1 = r8.exists()
            if (r1 != 0) goto L_0x094e
            goto L_0x0954
        L_0x094e:
            android.view.View r1 = r5.f41245e
            r1.setVisibility(r12)
            goto L_0x0978
        L_0x0954:
            com.paytm.android.chat.a.f r1 = com.paytm.android.chat.a.f.this
            boolean r1 = r1.m
            if (r1 == 0) goto L_0x095f
            android.view.View r1 = r5.f41245e
            r1.setVisibility(r6)
        L_0x095f:
            boolean r1 = android.text.TextUtils.isEmpty(r2)
            if (r1 != 0) goto L_0x096b
            android.widget.ImageView r1 = r5.f41242b
            com.paytm.android.chat.utils.ImageUtils.displayImageBlurreFromUrl(r7, r2, r1)
            goto L_0x0978
        L_0x096b:
            java.lang.String r1 = r3.fileUrl
            android.widget.ImageView r2 = r5.f41242b
            com.paytm.android.chat.utils.ImageUtils.displayImageBlurreFromUrl(r7, r1, r2)
            goto L_0x0978
        L_0x0973:
            android.view.View r1 = r5.f41245e
            r1.setVisibility(r12)
        L_0x0978:
            android.widget.TextView r1 = r5.u
            com.paytm.android.chat.a.f$i$1 r2 = new com.paytm.android.chat.a.f$i$1
            r2.<init>(r3)
            r1.setOnClickListener(r2)
            android.widget.TextView r1 = r5.v
            com.paytm.android.chat.a.f$i$2 r2 = new com.paytm.android.chat.a.f$i$2
            r2.<init>(r3)
            r1.setOnClickListener(r2)
            android.widget.ImageView r1 = r5.f41242b
            com.paytm.android.chat.a.f$i$3 r2 = new com.paytm.android.chat.a.f$i$3
            r2.<init>(r3)
            r1.setOnClickListener(r2)
            android.view.View r1 = r5.f41247g
            com.paytm.android.chat.a.f$i$4 r2 = new com.paytm.android.chat.a.f$i$4
            r2.<init>(r3)
            r1.setOnClickListener(r2)
            com.paytm.android.chat.a.f r1 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r2 = r3.baseMessage
            android.view.View r6 = r5.n
            android.view.View r7 = r5.f41247g
            r1.a((com.sendbird.android.BaseMessage) r2, (android.view.View) r6, (android.view.View) r7)
            com.paytm.android.chat.a.f r1 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r2 = r3.baseMessage
            android.view.View r6 = r5.n
            android.widget.ImageView r7 = r5.f41242b
            r1.a((com.sendbird.android.BaseMessage) r2, (android.view.View) r6, (android.view.View) r7)
            com.paytm.android.chat.a.f r1 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r2 = r3.baseMessage
            android.view.View r3 = r5.n
            android.view.View r6 = r5.p
            r1.b(r2, r3, r6)
            r1 = 1
            r5.a((boolean) r4, (boolean) r9, (boolean) r1)
            return
        L_0x09c6:
            r1 = r17
            com.paytm.android.chat.a.f$r r1 = (com.paytm.android.chat.a.f.r) r1
            com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel) r3
            android.widget.TextView r2 = r1.f41295b
            java.lang.String r7 = r3.fileName
            r2.setText(r7)
            java.lang.String r2 = r3.fileName
            java.lang.String r2 = com.paytm.android.chat.utils.FileUtils.getFormatName(r2)
            int r7 = r2.hashCode()
            switch(r7) {
                case 99640: goto L_0x0a1a;
                case 105441: goto L_0x0a12;
                case 110834: goto L_0x0a08;
                case 111220: goto L_0x09fe;
                case 3088960: goto L_0x09f4;
                case 3268712: goto L_0x09ea;
                case 3447940: goto L_0x09e1;
                default: goto L_0x09e0;
            }
        L_0x09e0:
            goto L_0x0a22
        L_0x09e1:
            java.lang.String r7 = "pptx"
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0a22
            goto L_0x0a23
        L_0x09ea:
            java.lang.String r5 = "jpeg"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0a22
            r5 = 2
            goto L_0x0a23
        L_0x09f4:
            java.lang.String r5 = "docx"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0a22
            r5 = 6
            goto L_0x0a23
        L_0x09fe:
            java.lang.String r5 = "ppt"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0a22
            r5 = 3
            goto L_0x0a23
        L_0x0a08:
            java.lang.String r5 = "pdf"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0a22
            r5 = 0
            goto L_0x0a23
        L_0x0a12:
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0a22
            r5 = 1
            goto L_0x0a23
        L_0x0a1a:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0a22
            r5 = 5
            goto L_0x0a23
        L_0x0a22:
            r5 = -1
        L_0x0a23:
            switch(r5) {
                case 0: goto L_0x0a32;
                case 1: goto L_0x0a2f;
                case 2: goto L_0x0a2f;
                case 3: goto L_0x0a2c;
                case 4: goto L_0x0a2c;
                case 5: goto L_0x0a29;
                case 6: goto L_0x0a29;
                default: goto L_0x0a26;
            }
        L_0x0a26:
            int r2 = com.paytm.android.chat.R.drawable.chat_efp__ic_file
            goto L_0x0a34
        L_0x0a29:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_doc
            goto L_0x0a34
        L_0x0a2c:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_ppt
            goto L_0x0a34
        L_0x0a2f:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_jpg
            goto L_0x0a34
        L_0x0a32:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_pdf
        L_0x0a34:
            android.view.View r5 = r1.f41294a
            com.paytm.android.chat.a.f$r$1 r7 = new com.paytm.android.chat.a.f$r$1
            r7.<init>(r3)
            r5.setOnClickListener(r7)
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r7 = r3.baseMessage
            android.view.View r8 = r1.n
            android.view.View r10 = r1.f41294a
            r5.a((com.sendbird.android.BaseMessage) r7, (android.view.View) r8, (android.view.View) r10)
            android.widget.ImageView r5 = r1.f41297d
            r5.setImageResource(r2)
            android.widget.TextView r2 = r1.f41296c
            int r5 = r3.fileSize
            long r7 = (long) r5
            java.lang.String r5 = com.paytm.android.chat.utils.FileUtils.toReadableFileSize(r7)
            r2.setText(r5)
            long r7 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r7, (android.content.Context) r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.view.View r7 = r1.p
            r2.b(r3, r5, r7)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r2.f41129c
            boolean r2 = r2.isReplyAllowed()
            r1.b(r2)
            r1.a((boolean) r4, (boolean) r9, (boolean) r6)
            return
        L_0x0a7d:
            r1 = r17
            com.paytm.android.chat.a.f$h r1 = (com.paytm.android.chat.a.f.h) r1
            com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatFileMessageDataModel) r3
            android.widget.TextView r7 = r1.f41231b
            java.lang.String r8 = r3.fileName
            r7.setText(r8)
            android.widget.TextView r7 = r1.f41232c
            int r8 = r3.fileSize
            long r10 = (long) r8
            java.lang.String r8 = com.paytm.android.chat.utils.FileUtils.toReadableFileSize(r10)
            r7.setText(r8)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r7 = r3.state
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r8 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            if (r7 != r8) goto L_0x0a9e
            r7 = 1
            goto L_0x0a9f
        L_0x0a9e:
            r7 = 0
        L_0x0a9f:
            com.sendbird.android.BaseMessage r8 = r3.baseMessage
            r1.a(r7, r2, r8)
            long r7 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r7, (android.content.Context) r2)
            android.widget.TextView r2 = r1.u
            com.paytm.android.chat.a.f$h$1 r7 = new com.paytm.android.chat.a.f$h$1
            r7.<init>(r3)
            r2.setOnClickListener(r7)
            android.widget.TextView r2 = r1.v
            com.paytm.android.chat.a.f$h$2 r7 = new com.paytm.android.chat.a.f$h$2
            r7.<init>(r3)
            r2.setOnClickListener(r7)
            java.lang.String r2 = r3.fileName
            java.lang.String r2 = com.paytm.android.chat.utils.FileUtils.getFormatName(r2)
            int r7 = r2.hashCode()
            switch(r7) {
                case 99640: goto L_0x0b08;
                case 105441: goto L_0x0b00;
                case 110834: goto L_0x0af6;
                case 111220: goto L_0x0aec;
                case 3088960: goto L_0x0ae2;
                case 3268712: goto L_0x0ad8;
                case 3447940: goto L_0x0acf;
                default: goto L_0x0ace;
            }
        L_0x0ace:
            goto L_0x0b10
        L_0x0acf:
            java.lang.String r6 = "pptx"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0b10
            goto L_0x0b11
        L_0x0ad8:
            java.lang.String r5 = "jpeg"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0b10
            r5 = 2
            goto L_0x0b11
        L_0x0ae2:
            java.lang.String r5 = "docx"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0b10
            r5 = 6
            goto L_0x0b11
        L_0x0aec:
            java.lang.String r5 = "ppt"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0b10
            r5 = 3
            goto L_0x0b11
        L_0x0af6:
            java.lang.String r5 = "pdf"
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x0b10
            r5 = 0
            goto L_0x0b11
        L_0x0b00:
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0b10
            r5 = 1
            goto L_0x0b11
        L_0x0b08:
            boolean r2 = r2.equals(r14)
            if (r2 == 0) goto L_0x0b10
            r5 = 5
            goto L_0x0b11
        L_0x0b10:
            r5 = -1
        L_0x0b11:
            switch(r5) {
                case 0: goto L_0x0b20;
                case 1: goto L_0x0b1d;
                case 2: goto L_0x0b1d;
                case 3: goto L_0x0b1a;
                case 4: goto L_0x0b1a;
                case 5: goto L_0x0b17;
                case 6: goto L_0x0b17;
                default: goto L_0x0b14;
            }
        L_0x0b14:
            int r2 = com.paytm.android.chat.R.drawable.chat_efp__ic_file
            goto L_0x0b22
        L_0x0b17:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_doc
            goto L_0x0b22
        L_0x0b1a:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_ppt
            goto L_0x0b22
        L_0x0b1d:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_jpg
            goto L_0x0b22
        L_0x0b20:
            int r2 = com.paytm.android.chat.R.drawable.chat_icon_file_pdf
        L_0x0b22:
            android.widget.ImageView r5 = r1.f41233d
            r5.setImageResource(r2)
            android.view.View r2 = r1.f41230a
            com.paytm.android.chat.a.f$h$3 r5 = new com.paytm.android.chat.a.f$h$3
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r2.f41129c
            boolean r2 = r2.isReplyAllowed()
            r1.b(r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r6 = r1.n
            android.view.View r7 = r1.f41230a
            r2.a((com.sendbird.android.BaseMessage) r5, (android.view.View) r6, (android.view.View) r7)
            boolean r2 = r3.isForward
            r1.a((boolean) r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.view.View r6 = r1.p
            r2.b(r3, r5, r6)
            r2 = 1
            r1.a((boolean) r4, (boolean) r9, (boolean) r2)
            return
        L_0x0b5c:
            r1 = r17
            com.paytm.android.chat.a.f$v r1 = (com.paytm.android.chat.a.f.v) r1
            com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel) r3
            long r10 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r10, (android.content.Context) r2)
            java.lang.String r2 = r3.message
            java.lang.String r7 = r3.customType
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0c90
            android.view.View r7 = r1.f41331a
            r7.setVisibility(r6)
            java.lang.String r7 = r3.replyUserId
            if (r7 == 0) goto L_0x0bac
            java.lang.String r7 = r3.replyUserId
            java.lang.String r8 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L_0x0bac
            android.widget.TextView r7 = r1.f41334d
            int r8 = com.paytm.android.chat.R.string.chat_you
            r7.setText(r8)
            android.widget.TextView r7 = r1.f41334d
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            android.content.Context r8 = r8.f41127a
            android.content.res.Resources r8 = r8.getResources()
            int r10 = com.paytm.android.chat.R.color.chat_color_4A80ED
            int r8 = r8.getColor(r10)
            r7.setTextColor(r8)
            android.view.View r7 = r1.f41331a
            int r8 = com.paytm.android.chat.R.drawable.chat_shape_reply_message_other_bg
            r7.setBackgroundResource(r8)
            goto L_0x0bdc
        L_0x0bac:
            android.widget.TextView r7 = r1.f41334d
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            java.lang.String r8 = r8.j
            boolean r8 = android.text.TextUtils.isEmpty(r8)
            if (r8 == 0) goto L_0x0bbb
            java.lang.String r8 = r3.replyName
            goto L_0x0bbf
        L_0x0bbb:
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            java.lang.String r8 = r8.j
        L_0x0bbf:
            r7.setText(r8)
            android.widget.TextView r7 = r1.f41334d
            com.paytm.android.chat.a.f r8 = com.paytm.android.chat.a.f.this
            android.content.Context r8 = r8.f41127a
            android.content.res.Resources r8 = r8.getResources()
            int r10 = com.paytm.android.chat.R.color.chat_color_E2743F
            int r8 = r8.getColor(r10)
            r7.setTextColor(r8)
            android.view.View r7 = r1.f41331a
            int r8 = com.paytm.android.chat.R.drawable.chat_shape_reply_message_bg
            r7.setBackgroundResource(r8)
        L_0x0bdc:
            android.widget.TextView r7 = r1.f41333c
            java.lang.String r8 = r3.replyContent
            r7.setText(r8)
            int r7 = r3.replyType
            if (r7 <= 0) goto L_0x0c7b
            android.widget.RelativeLayout r7 = r1.f41339i
            r7.setVisibility(r6)
            android.widget.ImageView r7 = r1.f41336f
            r7.setVisibility(r6)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r7 = r1.f41338h
            r7.setVisibility(r12)
            int r7 = r3.replyType
            r8 = 2
            if (r7 != r8) goto L_0x0c04
            android.widget.ImageView r5 = r1.f41336f
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_audio
            r5.setImageResource(r7)
            goto L_0x0c85
        L_0x0c04:
            int r7 = r3.replyType
            r8 = 1
            if (r7 != r8) goto L_0x0c4a
            java.lang.String r5 = r3.iconUrl
            if (r5 == 0) goto L_0x0c33
            java.lang.String r5 = r3.iconUrl
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0c16
            goto L_0x0c33
        L_0x0c16:
            android.widget.ImageView r5 = r1.f41336f
            r5.setVisibility(r12)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r5 = r1.f41338h
            r5.setVisibility(r6)
            android.widget.ImageView r5 = r1.f41337g
            r5.setVisibility(r6)
            android.view.View r5 = r1.p
            android.content.Context r5 = r5.getContext()
            java.lang.String r7 = r3.iconUrl
            android.widget.ImageView r8 = r1.f41337g
            com.paytm.android.chat.utils.ImageUtils.displayConnerImageFromUrl(r5, r7, r8)
            goto L_0x0c85
        L_0x0c33:
            android.widget.ImageView r5 = r1.f41336f
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_message_type_photo
            r5.setImageResource(r7)
            android.widget.ImageView r5 = r1.f41336f
            r5.setVisibility(r6)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r5 = r1.f41338h
            r5.setVisibility(r12)
            android.widget.ImageView r5 = r1.f41337g
            r5.setVisibility(r12)
            goto L_0x0c85
        L_0x0c4a:
            int r7 = r3.replyType
            r8 = 3
            if (r7 != r8) goto L_0x0c5c
            android.widget.ImageView r5 = r1.f41336f
            a((android.widget.ImageView) r5)
            android.widget.ImageView r5 = r1.f41336f
            int r7 = com.paytm.android.chat.R.drawable.chat_ic_payment_success
            r5.setImageResource(r7)
            goto L_0x0c85
        L_0x0c5c:
            int r7 = r3.replyType
            if (r7 != r5) goto L_0x0c68
            android.widget.ImageView r5 = r1.f41336f
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_document
            r5.setImageResource(r7)
            goto L_0x0c85
        L_0x0c68:
            int r5 = r3.replyType
            r7 = 5
            if (r5 != r7) goto L_0x0c75
            android.widget.ImageView r5 = r1.f41336f
            int r7 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_contact2
            r5.setImageResource(r7)
            goto L_0x0c85
        L_0x0c75:
            android.widget.ImageView r5 = r1.f41336f
            r5.setVisibility(r12)
            goto L_0x0c85
        L_0x0c7b:
            android.widget.RelativeLayout r5 = r1.f41339i
            r5.setVisibility(r12)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r5 = r1.f41338h
            r5.setVisibility(r12)
        L_0x0c85:
            android.view.View r5 = r1.f41331a
            com.paytm.android.chat.a.f$v$1 r7 = new com.paytm.android.chat.a.f$v$1
            r7.<init>(r3)
            r5.setOnClickListener(r7)
            goto L_0x0c9a
        L_0x0c90:
            android.view.View r5 = r1.f41331a
            r5.setVisibility(r12)
            android.view.View r5 = r1.f41331a
            r5.setVisibility(r12)
        L_0x0c9a:
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5 = r5.f41129c
            boolean r5 = r5.isReplyAllowed()
            r1.b(r5)
            boolean r5 = com.paytm.android.chat.utils.CTextUtils.containsEmoji(r2)
            if (r5 == 0) goto L_0x0cb3
            android.widget.TextView r5 = r1.f41332b
            r7 = 1108082688(0x420c0000, float:35.0)
            r5.setTextSize(r7)
            goto L_0x0cba
        L_0x0cb3:
            android.widget.TextView r5 = r1.f41332b
            r7 = 1096810496(0x41600000, float:14.0)
            r5.setTextSize(r7)
        L_0x0cba:
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5 = r5.f41129c
            java.lang.String r5 = r5.getChannelUrl()
            com.sendbird.android.GroupChannel r5 = com.paytm.android.chat.d.a.b.a(r5)
            if (r5 == 0) goto L_0x0d1a
            java.util.List r7 = r5.getMembers()
            if (r7 == 0) goto L_0x0d1a
            java.util.List r5 = r5.getMembers()
            int r5 = r5.size()
            r7 = 2
            if (r5 <= r7) goto L_0x0d1a
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            com.sendbird.android.Sender r5 = r5.getSender()
            java.lang.String r5 = r5.getNickname()
            if (r5 == 0) goto L_0x0d04
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            com.sendbird.android.Sender r5 = r5.getSender()
            java.lang.String r5 = r5.getNickname()
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0d04
            android.widget.TextView r5 = r1.f41335e
            com.sendbird.android.BaseMessage r7 = r3.baseMessage
            com.sendbird.android.Sender r7 = r7.getSender()
            java.lang.String r7 = r7.getNickname()
            r5.setText(r7)
        L_0x0d04:
            java.lang.Boolean r5 = r3.showStore
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0d14
            android.widget.TextView r5 = r1.f41335e
            int r7 = com.paytm.android.chat.R.drawable.ic_chat_p4b_store_owner_indicator
            r5.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r7, r6)
            goto L_0x0d1f
        L_0x0d14:
            android.widget.TextView r5 = r1.f41335e
            r5.setCompoundDrawablesWithIntrinsicBounds(r6, r6, r6, r6)
            goto L_0x0d1f
        L_0x0d1a:
            android.widget.TextView r5 = r1.f41335e
            r5.setVisibility(r12)
        L_0x0d1f:
            android.widget.TextView r5 = r1.f41332b
            r5.setText(r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r7 = r1.n
            android.view.View r8 = r1.p
            r2.b(r5, r7, r8)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.widget.TextView r7 = r1.f41332b
            r2.b(r3, r5, r7)
            r1.a((boolean) r4, (boolean) r9, (boolean) r6)
            return
        L_0x0d3e:
            r1 = r17
            com.paytm.android.chat.a.f$k r1 = (com.paytm.android.chat.a.f.k) r1
            com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel r3 = (com.paytm.android.chat.data.models.messages.ChatUserMessageDataModel) r3
            com.paytm.android.chat.a.f r7 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r7 = r7.f41129c
            boolean r7 = r7.isReplyAllowed()
            r1.b(r7)
            java.lang.String r7 = r3.message
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r10 = com.paytm.android.chat.utils.ChatConfigUtil.Companion
            com.paytm.android.chat.utils.ChatConfigUtil r10 = r10.getInstance()
            boolean r10 = r10.isP4B()
            if (r10 == 0) goto L_0x0d89
            com.sendbird.android.BaseMessage r10 = r3.baseMessage
            com.sendbird.android.Sender r10 = r10.getSender()
            java.lang.String r10 = r10.getNickname()
            if (r10 == 0) goto L_0x0d8e
            com.sendbird.android.BaseMessage r10 = r3.baseMessage
            com.sendbird.android.Sender r10 = r10.getSender()
            java.lang.String r10 = r10.getNickname()
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x0d8e
            android.widget.TextView r10 = r1.f41268e
            com.sendbird.android.BaseMessage r11 = r3.baseMessage
            com.sendbird.android.Sender r11 = r11.getSender()
            java.lang.String r11 = r11.getNickname()
            r10.setText(r11)
            goto L_0x0d8e
        L_0x0d89:
            android.widget.TextView r10 = r1.f41268e
            r10.setVisibility(r12)
        L_0x0d8e:
            android.widget.TextView r10 = r1.f41265b
            r10.setText(r7)
            java.lang.String r10 = r3.customType
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0ec0
            android.view.View r8 = r1.f41264a
            r8.setVisibility(r6)
            java.lang.String r8 = r3.replyUserId
            if (r8 == 0) goto L_0x0dd2
            java.lang.String r8 = r3.replyUserId
            java.lang.String r10 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0dd2
            android.widget.TextView r8 = r1.f41267d
            int r10 = com.paytm.android.chat.R.string.chat_you
            r8.setText(r10)
            android.widget.TextView r8 = r1.f41267d
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            android.content.Context r10 = r10.f41127a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = com.paytm.android.chat.R.color.chat_color_4A80ED
            int r10 = r10.getColor(r11)
            r8.setTextColor(r10)
            android.view.View r8 = r1.f41264a
            int r10 = com.paytm.android.chat.R.drawable.chat_shape_reply_message_other_bg
            r8.setBackgroundResource(r10)
            goto L_0x0e02
        L_0x0dd2:
            android.widget.TextView r8 = r1.f41267d
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            java.lang.String r10 = r10.j
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 == 0) goto L_0x0de1
            java.lang.String r10 = r3.replyName
            goto L_0x0de5
        L_0x0de1:
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            java.lang.String r10 = r10.j
        L_0x0de5:
            r8.setText(r10)
            android.widget.TextView r8 = r1.f41267d
            com.paytm.android.chat.a.f r10 = com.paytm.android.chat.a.f.this
            android.content.Context r10 = r10.f41127a
            android.content.res.Resources r10 = r10.getResources()
            int r11 = com.paytm.android.chat.R.color.chat_color_E2743F
            int r10 = r10.getColor(r11)
            r8.setTextColor(r10)
            android.view.View r8 = r1.f41264a
            int r10 = com.paytm.android.chat.R.drawable.chat_shape_reply_message_bg
            r8.setBackgroundResource(r10)
        L_0x0e02:
            android.widget.TextView r8 = r1.f41266c
            java.lang.String r10 = r3.replyContent
            r8.setText(r10)
            int r8 = r3.replyType
            if (r8 <= 0) goto L_0x0ea1
            android.widget.RelativeLayout r8 = r1.f41271h
            r8.setVisibility(r6)
            android.widget.ImageView r8 = r1.f41269f
            r8.setVisibility(r6)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r8 = r1.f41272i
            r8.setVisibility(r12)
            int r8 = r3.replyType
            r10 = 2
            if (r8 != r10) goto L_0x0e2a
            android.widget.ImageView r5 = r1.f41269f
            int r8 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_audio
            r5.setImageResource(r8)
            goto L_0x0eb5
        L_0x0e2a:
            int r8 = r3.replyType
            r10 = 1
            if (r8 != r10) goto L_0x0e70
            java.lang.String r5 = r3.iconUrl
            if (r5 == 0) goto L_0x0e59
            java.lang.String r5 = r3.iconUrl
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L_0x0e3c
            goto L_0x0e59
        L_0x0e3c:
            android.widget.ImageView r5 = r1.f41269f
            r5.setVisibility(r6)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r5 = r1.f41272i
            r5.setVisibility(r6)
            android.widget.ImageView r5 = r1.f41270g
            r5.setVisibility(r6)
            android.view.View r5 = r1.p
            android.content.Context r5 = r5.getContext()
            java.lang.String r8 = r3.iconUrl
            android.widget.ImageView r10 = r1.f41270g
            com.paytm.android.chat.utils.ImageUtils.displayConnerImageFromUrl(r5, r8, r10)
            goto L_0x0eb5
        L_0x0e59:
            android.widget.ImageView r5 = r1.f41269f
            int r8 = com.paytm.android.chat.R.drawable.chat_icon_chat_message_type_photo
            r5.setImageResource(r8)
            android.widget.ImageView r5 = r1.f41269f
            r5.setVisibility(r6)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r5 = r1.f41272i
            r5.setVisibility(r12)
            android.widget.ImageView r5 = r1.f41270g
            r5.setVisibility(r12)
            goto L_0x0eb5
        L_0x0e70:
            int r8 = r3.replyType
            r10 = 3
            if (r8 != r10) goto L_0x0e82
            android.widget.ImageView r5 = r1.f41269f
            a((android.widget.ImageView) r5)
            android.widget.ImageView r5 = r1.f41269f
            int r8 = com.paytm.android.chat.R.drawable.chat_ic_payment_success
            r5.setImageResource(r8)
            goto L_0x0eb5
        L_0x0e82:
            int r8 = r3.replyType
            if (r8 != r5) goto L_0x0e8e
            android.widget.ImageView r5 = r1.f41269f
            int r8 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_document
            r5.setImageResource(r8)
            goto L_0x0eb5
        L_0x0e8e:
            int r5 = r3.replyType
            r8 = 5
            if (r5 != r8) goto L_0x0e9b
            android.widget.ImageView r5 = r1.f41269f
            int r8 = com.paytm.android.chat.R.drawable.chat_icon_chat_multi_item_contact2
            r5.setImageResource(r8)
            goto L_0x0eb5
        L_0x0e9b:
            android.widget.ImageView r5 = r1.f41269f
            r5.setVisibility(r12)
            goto L_0x0eb5
        L_0x0ea1:
            android.widget.RelativeLayout r5 = r1.f41271h
            r5.setVisibility(r12)
            android.widget.ImageView r5 = r1.f41269f
            r5.setVisibility(r12)
            com.paytm.android.chat.view.round.RoundAngleFrameLayout r5 = r1.f41272i
            r5.setVisibility(r12)
            android.widget.ImageView r5 = r1.f41270g
            r5.setVisibility(r12)
        L_0x0eb5:
            android.view.View r5 = r1.f41264a
            com.paytm.android.chat.a.f$k$1 r8 = new com.paytm.android.chat.a.f$k$1
            r8.<init>(r3)
            r5.setOnClickListener(r8)
            goto L_0x0ec5
        L_0x0ec0:
            android.view.View r5 = r1.f41264a
            r5.setVisibility(r12)
        L_0x0ec5:
            boolean r5 = com.paytm.android.chat.utils.CTextUtils.containsEmoji(r7)
            if (r5 == 0) goto L_0x0ed3
            android.widget.TextView r5 = r1.f41265b
            r7 = 1108082688(0x420c0000, float:35.0)
            r5.setTextSize(r7)
            goto L_0x0eda
        L_0x0ed3:
            android.widget.TextView r5 = r1.f41265b
            r7 = 1096810496(0x41600000, float:14.0)
            r5.setTextSize(r7)
        L_0x0eda:
            com.paytm.android.chat.view.FlexBox r5 = r1.l
            r5.requestLayout()
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r5 = r3.state
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r7 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            if (r5 != r7) goto L_0x0ee6
            r6 = 1
        L_0x0ee6:
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            r1.a(r6, r2, r5)
            long r5 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r5, (android.content.Context) r2)
            boolean r2 = r3.isForward
            r1.a((boolean) r2)
            android.widget.TextView r2 = r1.u
            com.paytm.android.chat.a.f$k$2 r5 = new com.paytm.android.chat.a.f$k$2
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            android.widget.TextView r2 = r1.v
            com.paytm.android.chat.a.f$k$3 r5 = new com.paytm.android.chat.a.f$k$3
            r5.<init>(r3)
            r2.setOnClickListener(r5)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r6 = r1.n
            android.view.View r7 = r1.p
            r2.b(r5, r6, r7)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.widget.TextView r6 = r1.f41265b
            r2.b(r3, r5, r6)
            r2 = 1
            r1.a((boolean) r4, (boolean) r9, (boolean) r2)
            return
        L_0x0f28:
            r1 = r17
            com.paytm.android.chat.a.f$u r1 = (com.paytm.android.chat.a.f.u) r1
            long r7 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r7, (android.content.Context) r2)
            java.lang.String r2 = r3.message
            android.view.View r5 = r1.f41324a
            r5.setVisibility(r12)
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5 = r5.f41129c
            boolean r5 = r5.isReplyAllowed()
            r1.b(r5)
            android.widget.TextView r5 = r1.f41325b
            r7 = 1096810496(0x41600000, float:14.0)
            r5.setTextSize(r7)
            android.widget.TextView r5 = r1.f41325b
            r5.setText(r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r7 = r1.n
            android.view.View r8 = r1.p
            r2.b(r5, r7, r8)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.widget.TextView r7 = r1.f41325b
            r2.b(r3, r5, r7)
            android.widget.TextView r2 = r1.f41325b
            com.paytm.android.chat.a.f$u$1 r3 = new com.paytm.android.chat.a.f$u$1
            r3.<init>()
            r2.setOnClickListener(r3)
            r1.a((boolean) r4, (boolean) r9, (boolean) r6)
            return
        L_0x0f77:
            r1 = r17
            com.paytm.android.chat.a.f$j r1 = (com.paytm.android.chat.a.f.j) r1
            com.paytm.android.chat.a.f r5 = com.paytm.android.chat.a.f.this
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r5 = r5.f41129c
            boolean r5 = r5.isReplyAllowed()
            r1.b(r5)
            java.lang.String r5 = r3.message
            android.view.View r7 = r1.f41257a
            r7.setVisibility(r12)
            android.widget.TextView r7 = r1.f41258b
            r8 = 1096810496(0x41600000, float:14.0)
            r7.setTextSize(r8)
            android.widget.TextView r7 = r1.f41258b
            r7.setText(r5)
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r5 = r3.state
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel$RequestState r7 = com.paytm.android.chat.data.models.messages.ChatMessageDataModel.RequestState.FAILED
            if (r5 != r7) goto L_0x0fa0
            r6 = 1
        L_0x0fa0:
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            r1.a(r6, r2, r5)
            long r5 = r3.time
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            android.content.Context r2 = r2.f41127a
            r1.a((boolean) r4, (long) r5, (android.content.Context) r2)
            boolean r2 = r3.isForward
            r1.a((boolean) r2)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            android.view.View r6 = r1.n
            android.view.View r7 = r1.p
            r2.b(r5, r6, r7)
            com.paytm.android.chat.a.f r2 = com.paytm.android.chat.a.f.this
            com.sendbird.android.BaseMessage r3 = r3.baseMessage
            android.view.View r5 = r1.n
            android.widget.TextView r6 = r1.f41258b
            r2.b(r3, r5, r6)
            android.widget.TextView r2 = r1.f41258b
            com.paytm.android.chat.a.f$j$1 r3 = new com.paytm.android.chat.a.f$j$1
            r3.<init>()
            r2.setOnClickListener(r3)
            r2 = 1
            r1.a((boolean) r4, (boolean) r9, (boolean) r2)
        L_0x0fd7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.a.f.onBindViewHolder(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    public final int getItemViewType(int i2) {
        PFPaymentStatusBean pFPaymentStatusBean;
        ChatMessageDataModel chatMessageDataModel = this.f41131e.get(i2);
        BaseMessage baseMessage = this.f41131e.get(i2).baseMessage;
        if (baseMessage instanceof UserMessage) {
            UserMessage userMessage = (UserMessage) baseMessage;
            if (userMessage == null || userMessage.getSender() == null || userMessage.getSender().getUserId() == null) {
                return -1;
            }
            boolean equals = userMessage.getSender().getUserId().equals(SharedPreferencesUtil.getUserId());
            if ("UPI_REQUEST".equals(baseMessage.getCustomType())) {
                return equals ? 29 : 30;
            }
            if ("UPI_RESPONSE".equals(baseMessage.getCustomType())) {
                return (!(chatMessageDataModel instanceof ChatUPIResponseDataModel) || !"FAILURE".equalsIgnoreCase(((ChatUPIResponseDataModel) chatMessageDataModel).getData().getMsgStatus())) ? equals ? 31 : 32 : equals ? 25 : 26;
            }
            if ("GENERIC_NOTIF".equals(baseMessage.getCustomType())) {
                return 28;
            }
            if ("MINI_APP_BASIC_NOTIFICATION".equals(baseMessage.getCustomType())) {
                return 27;
            }
            if ("contact".equals(baseMessage.getCustomType())) {
                return equals ? 18 : 19;
            }
            if ("TRANSFER".equals(baseMessage.getCustomType())) {
                if (!equals) {
                    return 22;
                }
                if (!(chatMessageDataModel instanceof ChatTransferMessageDataModel) || (pFPaymentStatusBean = ((ChatTransferMessageDataModel) chatMessageDataModel).bean) == null || pFPaymentStatusBean.getStatus() != 1) {
                    return 21;
                }
                return 23;
            } else if (!"TRANSFER_FAIL".equals(baseMessage.getCustomType())) {
                return ("reply".equals(baseMessage.getCustomType()) || CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX.equals(baseMessage.getCustomType()) || baseMessage.getCustomType().isEmpty()) ? equals ? 10 : 11 : equals ? 0 : 1;
            } else {
                if (equals) {
                    return 23;
                }
                return 24;
            }
        } else if (baseMessage instanceof FileMessage) {
            FileMessage fileMessage = (FileMessage) baseMessage;
            if (fileMessage == null || fileMessage.getSender() == null || fileMessage.getSender().getUserId() == null || fileMessage.getType() == null) {
                return -1;
            }
            boolean equals2 = fileMessage.getSender().getUserId().equals(SharedPreferencesUtil.getUserId());
            return "Image".equals(baseMessage.getCustomType()) ? equals2 ? 14 : 15 : "Audio".equals(baseMessage.getCustomType()) ? equals2 ? 16 : 17 : "File".equals(baseMessage.getCustomType()) ? equals2 ? 12 : 13 : equals2 ? 0 : 1;
        } else if (!(baseMessage instanceof AdminMessage)) {
            return -1;
        } else {
            if ("ADMM_TEXT".equalsIgnoreCase(baseMessage.getCustomType())) {
                return 20;
            }
            return "metadata_update".equalsIgnoreCase(baseMessage.getCustomType()) ? -1 : 1;
        }
    }

    public final int getItemCount() {
        return this.f41131e.size();
    }

    public final void a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        this.f41129c = chatGroupChannelDataModel;
    }

    public final void a(String str, int i2) {
        for (int size = this.f41131e.size() - 1; size >= 0; size--) {
            ChatMessageDataModel chatMessageDataModel = this.f41131e.get(size);
            if (str.equals(chatMessageDataModel.requestId)) {
                CircleProgressBar circleProgressBar = this.f41130d.get(chatMessageDataModel.fileName);
                if (circleProgressBar != null) {
                    circleProgressBar.setProgress(i2);
                    return;
                }
                return;
            }
        }
    }

    public final void a(ChatUserDataModel chatUserDataModel) {
        this.f41135i = chatUserDataModel;
    }

    public final int a(long j2) {
        for (int i2 = 0; i2 < this.f41131e.size(); i2++) {
            if (j2 == this.f41131e.get(i2).messageId) {
                return i2;
            }
        }
        return 0;
    }

    public final List<BaseMessage> b() {
        return this.o;
    }

    public final void c() {
        if (this.f41134h) {
            this.o.clear();
            notifyDataSetChanged();
        }
        this.f41134h = false;
    }

    /* access modifiers changed from: package-private */
    public final void a(final BaseMessage baseMessage, final View view, View view2) {
        view2.setOnLongClickListener(new View.OnLongClickListener() {
            public final boolean onLongClick(View view) {
                if (!f.this.f41134h) {
                    f.a(f.this, baseMessage, view);
                    f.this.f41134h = true;
                }
                return true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b(final BaseMessage baseMessage, final View view, View view2) {
        if (view2 != null && view != null && baseMessage != null) {
            if (this.o.contains(baseMessage)) {
                view.setVisibility(0);
            } else {
                view.setVisibility(8);
            }
            view2.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick() && f.this.f41134h) {
                        f.a(f.this, baseMessage, view);
                    }
                }
            });
            a(baseMessage, view, view2);
        }
    }

    public final void a(int i2, int i3) {
        AudioPlayView audioPlayView = this.f41128b.get(this.f41133g);
        if (!(audioPlayView == null || audioPlayView.getTag() == null || !audioPlayView.getTag().equals(this.f41133g))) {
            audioPlayView.setAudioTime(i2, i3);
        }
        if (this.f41128b.size() > 1) {
            String str = "";
            for (String next : this.f41128b.keySet()) {
                if (!next.equals(this.f41133g)) {
                    AudioPlayView audioPlayView2 = this.f41128b.get(next);
                    if (audioPlayView2 != null) {
                        audioPlayView2.setAudioTime(0, 0);
                        audioPlayView2.setImagePlay(false);
                        if (audioPlayView2.getImagePlay() != null) {
                            audioPlayView2.getImagePlay().setTag(Boolean.FALSE);
                        }
                    }
                    str = next;
                }
            }
            this.f41128b.remove(str);
        }
    }

    public final void b(boolean z2) {
        AudioPlayView audioPlayView = this.f41128b.get(this.f41133g);
        if (!(audioPlayView == null || audioPlayView.getTag() == null || !audioPlayView.getTag().equals(this.f41133g))) {
            audioPlayView.setImagePlay(z2);
            audioPlayView.getImagePlay().setTag(Boolean.valueOf(z2));
        }
        if (this.f41128b.size() > 1) {
            String str = "";
            for (String next : this.f41128b.keySet()) {
                if (!next.equals(this.f41133g)) {
                    AudioPlayView audioPlayView2 = this.f41128b.get(next);
                    if (audioPlayView2 != null) {
                        audioPlayView2.setImagePlay(false);
                        if (audioPlayView2.getImagePlay() != null) {
                            audioPlayView2.getImagePlay().setTag(Boolean.FALSE);
                        }
                    }
                    str = next;
                }
            }
            this.f41128b.remove(str);
        }
    }

    public final void a(n nVar) {
        this.p = nVar;
    }

    public final void a(m mVar) {
        this.f41132f = mVar;
    }

    public final void a(o oVar) {
        this.q = oVar;
    }

    public final void a(String str) {
        this.j = str;
    }

    public final void b(String str) {
        this.r = str;
    }

    public final void d() {
        HashMap<String, AudioPlayView> hashMap = this.f41128b;
        if (hashMap != null) {
            hashMap.clear();
        }
        List<BaseMessage> list = this.o;
        if (list != null) {
            list.clear();
        }
        List<ChatMessageDataModel> list2 = this.f41131e;
        if (list2 != null) {
            list2.clear();
        }
        Map<String, File> map = this.l;
        if (map != null) {
            map.clear();
        }
    }

    class y extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41360a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f41361b;

        /* renamed from: c  reason: collision with root package name */
        View f41362c;

        /* renamed from: d  reason: collision with root package name */
        View f41363d;

        /* renamed from: e  reason: collision with root package name */
        View f41364e;

        /* renamed from: f  reason: collision with root package name */
        View f41365f;

        /* renamed from: h  reason: collision with root package name */
        private TextView f41367h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f41368i;
        private TextView j;
        private TextView k;
        private TextView l;

        public y(View view) {
            super(view);
            this.t = false;
            this.f41363d = view.findViewById(R.id.messageContainer);
            this.f41367h = (TextView) view.findViewById(R.id.txtMessageTitle);
            this.f41368i = (TextView) view.findViewById(R.id.txtMessageContent);
            this.l = (TextView) view.findViewById(R.id.txtAmount);
            this.j = (TextView) view.findViewById(R.id.chat_msg_time);
            this.k = (TextView) view.findViewById(R.id.textDateTime);
            this.f41360a = (ImageView) view.findViewById(R.id.arrow);
            this.f41361b = (ImageView) view.findViewById(R.id.image_group_chat_read_receipt);
            this.f41362c = view.findViewById(R.id.group_chat_bubble);
            this.f41364e = view.findViewById(R.id.chat_horizontal_loader);
            this.f41365f = view.findViewById(R.id.justIcon);
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(ChatUPIRequestDatModel chatUPIRequestDatModel, GroupChannel groupChannel, boolean z, boolean z2) {
            Long d2;
            if (chatUPIRequestDatModel.getData() != null) {
                ChatMessageUPIData data = chatUPIRequestDatModel.getData();
                a(data.getReply(), f.this.f41129c);
                if (!TextUtils.isEmpty(data.getSenderState())) {
                    this.f41367h.setText(data.getSenderState());
                    this.f41367h.setVisibility(0);
                } else {
                    this.f41367h.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getAmount())) {
                    if ("COMPLETED".equalsIgnoreCase(data.getMsgStatus())) {
                        this.f41365f.setVisibility(4);
                        this.l.setTextSize(20.0f);
                        CTextUtils.Builder proportion = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(1.0f);
                        proportion.append(data.getAmount()).setProportion(1.0f).into(this.l);
                    } else {
                        this.f41365f.setVisibility(0);
                        this.l.setTextSize(42.0f);
                        CTextUtils.Builder proportion2 = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(0.74f);
                        proportion2.append(data.getAmount()).setProportion(1.0f).into(this.l);
                    }
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getSenderDesc())) {
                    this.f41368i.setText(data.getSenderDesc());
                    this.f41368i.setVisibility(0);
                } else {
                    this.f41368i.setVisibility(8);
                }
                if (z) {
                    this.k.setVisibility(0);
                    this.k.setText(DateUtils.getMessageDate(chatUPIRequestDatModel.time, f.this.f41127a));
                } else {
                    this.k.setVisibility(8);
                }
                this.j.setText(DateUtils.formatDateMonthTime(chatUPIRequestDatModel.time));
                if (z || !z2) {
                    this.f41360a.setVisibility(0);
                    View view = this.f41362c;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_bg));
                } else {
                    View view2 = this.f41362c;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_rounded_bg));
                    this.f41360a.setVisibility(4);
                }
                a(chatUPIRequestDatModel.state == ChatMessageDataModel.RequestState.FAILED, groupChannel, chatUPIRequestDatModel.baseMessage);
                this.f41363d.setVisibility(0);
                if (data.getExpireOn() != null && (d2 = kotlin.m.p.d(data.getExpireOn())) != null && d2.longValue() >= System.currentTimeMillis()) {
                    CTA cta = new CTA();
                    cta.setType(CtaType.UPI_EXPIRED.toString());
                    f.this.f41132f.a(cta, data);
                    return;
                }
                return;
            }
            this.f41363d.setVisibility(8);
        }
    }

    class z extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41369a;

        /* renamed from: b  reason: collision with root package name */
        View f41370b;

        /* renamed from: c  reason: collision with root package name */
        View f41371c;

        /* renamed from: d  reason: collision with root package name */
        View f41372d;

        /* renamed from: e  reason: collision with root package name */
        View f41373e;

        /* renamed from: g  reason: collision with root package name */
        private TextView f41375g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f41376h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f41377i;
        private TextView j;
        private TextView k;
        private TextView l;

        public z(View view) {
            super(view);
            this.t = false;
            this.f41371c = view.findViewById(R.id.messageContainer);
            this.f41375g = (TextView) view.findViewById(R.id.txtMessageTitle);
            this.f41376h = (TextView) view.findViewById(R.id.txtMessageContent);
            this.k = (TextView) view.findViewById(R.id.txtAmount);
            this.f41377i = (TextView) view.findViewById(R.id.chat_msg_time);
            this.j = (TextView) view.findViewById(R.id.textDateTime);
            this.f41369a = (ImageView) view.findViewById(R.id.arrow);
            this.f41370b = view.findViewById(R.id.group_chat_bubble);
            this.l = (TextView) view.findViewById(R.id.btnPayUpi);
            this.f41372d = view.findViewById(R.id.chat_horizontal_loader);
            this.f41373e = view.findViewById(R.id.justIcon);
            this.l.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    f.z.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            if (!(view == null || view.getContext() == null)) {
                ChatAnalyticsHelperKt.fireRequestViewClickEvent(view.getContext(), f.this.f41129c);
            }
            f.a(f.this, "paytmmp://upi_passbook?featuretype=getpendingrequests");
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(ChatUPIRequestDatModel chatUPIRequestDatModel, boolean z, boolean z2) {
            Long d2;
            if (chatUPIRequestDatModel.getData() != null) {
                ChatMessageUPIData data = chatUPIRequestDatModel.getData();
                a(data.getReply(), f.this.f41129c);
                if (!TextUtils.isEmpty(data.getReceiverState())) {
                    this.f41375g.setText(data.getReceiverState());
                    this.f41375g.setVisibility(0);
                } else {
                    this.f41375g.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getAmount())) {
                    if ("COMPLETED".equalsIgnoreCase(data.getMsgStatus())) {
                        this.f41373e.setVisibility(4);
                        this.l.setVisibility(8);
                        this.k.setTextSize(20.0f);
                        CTextUtils.Builder proportion = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(1.0f);
                        proportion.append(data.getAmount()).setProportion(1.0f).into(this.k);
                    } else {
                        this.f41373e.setVisibility(0);
                        this.l.setVisibility(0);
                        this.k.setTextSize(42.0f);
                        CTextUtils.Builder proportion2 = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(0.74f);
                        proportion2.append(data.getAmount()).setProportion(1.0f).into(this.k);
                    }
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getReceiverDesc())) {
                    this.f41376h.setText(data.getReceiverDesc());
                    this.f41376h.setVisibility(0);
                } else {
                    this.f41376h.setVisibility(8);
                }
                if (z) {
                    this.j.setVisibility(0);
                    this.j.setText(DateUtils.getMessageDate(chatUPIRequestDatModel.time, f.this.f41127a));
                } else {
                    this.j.setVisibility(8);
                }
                this.f41377i.setText(DateUtils.formatDateMonthTime(chatUPIRequestDatModel.time));
                if (z || !z2) {
                    this.f41369a.setVisibility(0);
                    View view = this.f41370b;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_bg));
                } else {
                    View view2 = this.f41370b;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_rounded_bg));
                    this.f41369a.setVisibility(4);
                }
                this.f41371c.setVisibility(0);
                if (data.getExpireOn() != null && (d2 = kotlin.m.p.d(data.getExpireOn())) != null && d2.longValue() >= System.currentTimeMillis()) {
                    CTA cta = new CTA();
                    cta.setType(CtaType.UPI_EXPIRED.toString());
                    f.this.f41132f.a(cta, data);
                    return;
                }
                return;
            }
            this.f41371c.setVisibility(8);
        }
    }

    class aa extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41149a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f41150b;

        /* renamed from: c  reason: collision with root package name */
        View f41151c;

        /* renamed from: d  reason: collision with root package name */
        View f41152d;

        /* renamed from: e  reason: collision with root package name */
        View f41153e;

        /* renamed from: g  reason: collision with root package name */
        private TextView f41155g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f41156h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f41157i;
        private TextView j;

        public aa(View view) {
            super(view);
            this.t = false;
            this.f41152d = view.findViewById(R.id.messageContainer);
            this.f41155g = (TextView) view.findViewById(R.id.txtMessageTitle);
            this.f41156h = (TextView) view.findViewById(R.id.txtMessageContent);
            this.f41150b = (ImageView) view.findViewById(R.id.image_group_chat_read_receipt);
            this.f41157i = (TextView) view.findViewById(R.id.chat_msg_time);
            this.j = (TextView) view.findViewById(R.id.textDateTime);
            this.f41149a = (ImageView) view.findViewById(R.id.arrow);
            this.f41151c = view.findViewById(R.id.group_chat_bubble);
            this.f41153e = view.findViewById(R.id.chat_horizontal_loader);
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(ChatUPIResponseDataModel chatUPIResponseDataModel, GroupChannel groupChannel, boolean z, boolean z2) {
            if (chatUPIResponseDataModel.getData() != null) {
                ChatMessageUPIData data = chatUPIResponseDataModel.getData();
                a(data.getReply(), f.this.f41129c);
                if (!TextUtils.isEmpty(data.getSenderState())) {
                    this.f41155g.setText(data.getSenderState());
                    this.f41155g.setVisibility(0);
                } else {
                    this.f41155g.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getSenderDesc())) {
                    this.f41156h.setText(data.getSenderDesc());
                    this.f41156h.setVisibility(0);
                } else {
                    this.f41156h.setVisibility(8);
                }
                if (z) {
                    this.j.setVisibility(0);
                    this.j.setText(DateUtils.getMessageDate(chatUPIResponseDataModel.time, f.this.f41127a));
                } else {
                    this.j.setVisibility(8);
                }
                this.f41157i.setText(DateUtils.formatDateMonthTime(chatUPIResponseDataModel.time));
                if (z || !z2) {
                    this.f41149a.setVisibility(0);
                    View view = this.f41151c;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_bg));
                } else {
                    View view2 = this.f41151c;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_rounded_bg));
                    this.f41149a.setVisibility(4);
                }
                if (TxNotifyData.UPI_STATUS_DECLINED.equalsIgnoreCase(data.getMsgStatus()) || TxNotifyData.UPI_STATUS_CANCELLED.equalsIgnoreCase(data.getMsgStatus())) {
                    this.f41150b.setVisibility(0);
                    a(false, groupChannel, chatUPIResponseDataModel.baseMessage);
                } else {
                    this.f41150b.setVisibility(8);
                }
                this.f41152d.setVisibility(0);
                return;
            }
            this.f41152d.setVisibility(8);
        }
    }

    class ab extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        TextView f41158a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41159b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41160c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41161d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f41162e;

        /* renamed from: f  reason: collision with root package name */
        View f41163f;

        /* renamed from: g  reason: collision with root package name */
        View f41164g;

        public ab(View view) {
            super(view);
            this.t = false;
            this.f41164g = view.findViewById(R.id.messageContainer);
            this.f41158a = (TextView) view.findViewById(R.id.txtMessageTitle);
            this.f41159b = (TextView) view.findViewById(R.id.txtMessageContent);
            this.f41160c = (TextView) view.findViewById(R.id.chat_msg_time);
            this.f41161d = (TextView) view.findViewById(R.id.textDateTime);
            this.f41162e = (ImageView) view.findViewById(R.id.arrow);
            this.f41163f = view.findViewById(R.id.group_chat_bubble);
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }
    }

    class d extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41180a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f41181b;

        /* renamed from: c  reason: collision with root package name */
        View f41182c;

        /* renamed from: d  reason: collision with root package name */
        View f41183d;

        /* renamed from: e  reason: collision with root package name */
        View f41184e;

        /* renamed from: f  reason: collision with root package name */
        View f41185f;

        /* renamed from: g  reason: collision with root package name */
        View f41186g;

        /* renamed from: h  reason: collision with root package name */
        View f41187h;

        /* renamed from: i  reason: collision with root package name */
        View f41188i;
        private TextView k;
        private TextView l;
        private TextView m;
        private TextView n;
        private TextView o;
        private TextView p;

        public d(View view) {
            super(view);
            this.f41183d = view.findViewById(R.id.messageContainer);
            this.k = (TextView) view.findViewById(R.id.channelMessageTitle);
            this.l = (TextView) view.findViewById(R.id.channelMessageContent);
            this.m = (TextView) view.findViewById(R.id.chat_msg_time);
            this.n = (TextView) view.findViewById(R.id.textDateTime);
            this.f41180a = (ImageView) view.findViewById(R.id.arrow);
            this.f41181b = (ImageView) view.findViewById(R.id.imgGenericNotif);
            this.f41188i = view.findViewById(R.id.imgLoader);
            this.f41187h = view.findViewById(R.id.cardViewImage);
            this.f41182c = view.findViewById(R.id.group_chat_bubble);
            this.f41184e = view.findViewById(R.id.layoutCta);
            this.o = (TextView) view.findViewById(R.id.txtDynamic1);
            this.p = (TextView) view.findViewById(R.id.txtDynamic2);
            this.f41185f = view.findViewById(R.id.btnDynamic1);
            this.f41186g = view.findViewById(R.id.btnDynamic2);
        }

        /* access modifiers changed from: package-private */
        public final void a(ChatGenericMessageDataModel chatGenericMessageDataModel, boolean z, boolean z2) {
            if (chatGenericMessageDataModel.getData() != null) {
                ChatGenericMessageDataModel.GenericDataBean data = chatGenericMessageDataModel.getData();
                if (!TextUtils.isEmpty(data.getTitle())) {
                    this.k.setText(data.getTitle());
                    this.k.setVisibility(0);
                } else {
                    this.k.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getDesc())) {
                    this.l.setText(data.getDesc());
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                if (z) {
                    this.n.setVisibility(0);
                    this.n.setText(DateUtils.getMessageDate(chatGenericMessageDataModel.time, f.this.f41127a));
                } else {
                    this.n.setVisibility(8);
                }
                if (URLUtil.isNetworkUrl(data.getImageUrl())) {
                    this.f41187h.setVisibility(0);
                    com.bumptech.glide.b.b(f.this.f41127a).a(data.getImageUrl()).b(new com.bumptech.glide.e.g<Drawable>() {
                        public final boolean onLoadFailed(com.bumptech.glide.load.b.q qVar, Object obj, com.bumptech.glide.e.a.j<Drawable> jVar, boolean z) {
                            if (d.this.f41187h == null) {
                                return false;
                            }
                            d.this.f41187h.setVisibility(8);
                            return false;
                        }

                        public final /* synthetic */ boolean onResourceReady(Object obj, Object obj2, com.bumptech.glide.e.a.j jVar, com.bumptech.glide.load.a aVar, boolean z) {
                            if (d.this.f41188i == null) {
                                return false;
                            }
                            d.this.f41188i.setVisibility(8);
                            return false;
                        }
                    }).a(this.f41181b);
                } else {
                    this.f41187h.setVisibility(8);
                }
                this.m.setText(DateUtils.formatTimeWithMarker(chatGenericMessageDataModel.time));
                if (z || !z2) {
                    this.f41180a.setVisibility(0);
                    View view = this.f41182c;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_bg));
                } else {
                    View view2 = this.f41182c;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_rounded_bg));
                    this.f41180a.setVisibility(4);
                }
                if (data.getCta() == null || data.getCta().size() <= 0) {
                    this.f41184e.setVisibility(8);
                } else {
                    if (data.getCta().size() == 1) {
                        this.f41186g.setVisibility(8);
                        this.f41186g.setOnClickListener((View.OnClickListener) null);
                        CTA cta = data.getCta().get(0);
                        this.o.setText(cta.getBtnText());
                        this.f41185f.setOnClickListener(new View.OnClickListener(cta, chatGenericMessageDataModel) {
                            private final /* synthetic */ CTA f$1;
                            private final /* synthetic */ ChatGenericMessageDataModel f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(View view) {
                                f.d.this.c(this.f$1, this.f$2, view);
                            }
                        });
                    } else {
                        CTA cta2 = data.getCta().get(0);
                        CTA cta3 = data.getCta().get(1);
                        this.o.setText(cta2.getBtnText());
                        this.p.setText(cta3.getBtnText());
                        this.f41185f.setOnClickListener(new View.OnClickListener(cta2, chatGenericMessageDataModel) {
                            private final /* synthetic */ CTA f$1;
                            private final /* synthetic */ ChatGenericMessageDataModel f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(View view) {
                                f.d.this.b(this.f$1, this.f$2, view);
                            }
                        });
                        this.f41186g.setOnClickListener(new View.OnClickListener(cta3, chatGenericMessageDataModel) {
                            private final /* synthetic */ CTA f$1;
                            private final /* synthetic */ ChatGenericMessageDataModel f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void onClick(View view) {
                                f.d.this.a(this.f$1, this.f$2, view);
                            }
                        });
                        this.f41185f.setVisibility(0);
                        this.f41186g.setVisibility(0);
                    }
                    this.f41184e.setVisibility(0);
                }
                this.f41183d.setVisibility(0);
                return;
            }
            this.f41183d.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(CTA cta, ChatGenericMessageDataModel chatGenericMessageDataModel, View view) {
            if (f.this.f41132f != null) {
                if (!(cta.getBtnText() == null || cta.getDeeplink() == null)) {
                    f.a(f.this, cta.getDeeplink());
                    ChatAnalyticsHelperKt.fireGenericNotificationCtaClickEvent(f.this.f41127a, f.this.f41129c, 1, cta.getBtnText());
                }
                if (!TextUtils.isEmpty(chatGenericMessageDataModel.campaignId)) {
                    ChatAnalyticsHelperKt.fireCampaignMessageClickedEvent(com.paytm.android.chat.c.a(), chatGenericMessageDataModel.campaignId);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(CTA cta, ChatGenericMessageDataModel chatGenericMessageDataModel, View view) {
            if (f.this.f41132f != null) {
                if (!(cta.getBtnText() == null || cta.getDeeplink() == null)) {
                    f.a(f.this, cta.getDeeplink());
                    ChatAnalyticsHelperKt.fireGenericNotificationCtaClickEvent(f.this.f41127a, f.this.f41129c, 1, cta.getBtnText());
                }
                if (!TextUtils.isEmpty(chatGenericMessageDataModel.campaignId)) {
                    ChatAnalyticsHelperKt.fireCampaignMessageClickedEvent(com.paytm.android.chat.c.a(), chatGenericMessageDataModel.campaignId);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(CTA cta, ChatGenericMessageDataModel chatGenericMessageDataModel, View view) {
            if (f.this.f41132f != null) {
                if (!(cta.getBtnText() == null || cta.getDeeplink() == null)) {
                    f.a(f.this, cta.getDeeplink());
                    ChatAnalyticsHelperKt.fireGenericNotificationCtaClickEvent(f.this.f41127a, f.this.f41129c, 2, cta.getBtnText());
                }
                if (!TextUtils.isEmpty(chatGenericMessageDataModel.campaignId)) {
                    ChatAnalyticsHelperKt.fireCampaignMessageClickedEvent(com.paytm.android.chat.c.a(), chatGenericMessageDataModel.campaignId);
                }
            }
        }
    }

    class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f41166a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41167b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41168c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41169d;

        /* renamed from: e  reason: collision with root package name */
        TextView f41170e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f41171f;

        /* renamed from: g  reason: collision with root package name */
        View f41172g;

        /* renamed from: h  reason: collision with root package name */
        View f41173h;

        public b(View view) {
            super(view);
            this.f41173h = view.findViewById(R.id.messageContainer);
            this.f41166a = (TextView) view.findViewById(R.id.channelMessageTitle);
            this.f41167b = (TextView) view.findViewById(R.id.channelMessageContent);
            this.f41168c = (TextView) view.findViewById(R.id.channelMessageDeeplink);
            this.f41169d = (TextView) view.findViewById(R.id.chat_msg_time);
            this.f41170e = (TextView) view.findViewById(R.id.textDateTime);
            this.f41171f = (ImageView) view.findViewById(R.id.arrow);
            this.f41172g = view.findViewById(R.id.group_chat_bubble);
            this.f41173h.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    f.b.this.a(view);
                }
            });
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(View view) {
            try {
                ChatMessageDataModel chatMessageDataModel = f.this.f41131e.get(getAdapterPosition());
                if (chatMessageDataModel instanceof MiniAppNotificationBean) {
                    f.this.f41132f.a(((MiniAppNotificationBean) chatMessageDataModel).getNotifData().getCta());
                    if (!TextUtils.isEmpty(chatMessageDataModel.campaignId)) {
                        ChatAnalyticsHelperKt.fireCampaignMessageClickedEvent(com.paytm.android.chat.c.a(), chatMessageDataModel.campaignId);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    class j extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        final View f41257a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41258b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41259c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41260d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f41261e;

        j(View view) {
            super(view);
            this.f41258b = (TextView) view.findViewById(R.id.text_group_chat_message);
            this.f41257a = view.findViewById(R.id.layout_group_chat_reply);
            this.f41260d = (TextView) view.findViewById(R.id.text_group_chat_reply_user_name);
            this.f41259c = (TextView) view.findViewById(R.id.text_group_chat_reply_content);
            this.f41261e = (ImageView) view.findViewById(R.id.image_group_chat_reply_type_icon);
        }
    }

    class u extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        final View f41324a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41325b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41326c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41327d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f41328e;

        /* synthetic */ u(f fVar, View view, byte b2) {
            this(view);
        }

        private u(View view) {
            super(view);
            this.f41325b = (TextView) view.findViewById(R.id.text_group_chat_message);
            this.f41324a = view.findViewById(R.id.layout_group_chat_reply);
            this.f41327d = (TextView) view.findViewById(R.id.text_group_chat_reply_user_name);
            this.f41326c = (TextView) view.findViewById(R.id.text_group_chat_reply_content);
            this.f41328e = (ImageView) view.findViewById(R.id.image_group_chat_reply_type_icon);
        }
    }

    public final void a(l lVar) {
        this.k = lVar;
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f41142a;

        /* renamed from: b  reason: collision with root package name */
        CardView f41143b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f41144c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f41145d;

        a(View view) {
            super(view);
            this.f41142a = (TextView) view.findViewById(R.id.text_group_chat_message);
            this.f41143b = (CardView) view.findViewById(R.id.layoutAdminMessage);
            this.f41144c = (ImageView) view.findViewById(R.id.iv_left);
            this.f41145d = (ImageView) view.findViewById(R.id.iv_right);
            this.f41143b.setOnClickListener(new View.OnClickListener(f.this) {
                public final void onClick(View view) {
                    try {
                        ChatMessageDataModel chatMessageDataModel = f.this.f41131e.get(a.this.getAdapterPosition());
                        if (f.this.f41132f != null && (chatMessageDataModel instanceof AdminMessageBean)) {
                            f.this.f41132f.a((AdminMessageBean) chatMessageDataModel);
                            if (!TextUtils.isEmpty(chatMessageDataModel.campaignId)) {
                                ChatAnalyticsHelperKt.fireCampaignMessageClickedEvent(com.paytm.android.chat.c.a(), chatMessageDataModel.campaignId);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        CardView f41175a;

        /* renamed from: c  reason: collision with root package name */
        private TextView f41177c;

        c(View view) {
            super(view);
            this.f41177c = (TextView) view.findViewById(R.id.text_group_chat_message);
            this.f41175a = (CardView) view.findViewById(R.id.layoutAdminMessage);
            this.f41175a.setOnClickListener(new View.OnClickListener(f.this) {
                public final void onClick(View view) {
                    try {
                        ChatMessageDataModel chatMessageDataModel = f.this.f41131e.get(c.this.getAdapterPosition());
                        if (f.this.f41132f != null && (chatMessageDataModel instanceof AdminMessageBean)) {
                            f.this.f41132f.a((AdminMessageBean) chatMessageDataModel);
                        }
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    class k extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        final View f41264a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41265b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41266c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41267d;

        /* renamed from: e  reason: collision with root package name */
        TextView f41268e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f41269f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f41270g;

        /* renamed from: h  reason: collision with root package name */
        RelativeLayout f41271h;

        /* renamed from: i  reason: collision with root package name */
        RoundAngleFrameLayout f41272i;
        int j = Math.round((float) DensityUtil.dp2px(12.0f));
        int k = Math.round((float) DensityUtil.dp2px(0.0f));
        FlexBox l;

        k(View view) {
            super(view);
            this.f41265b = (TextView) view.findViewById(R.id.text_group_chat_message);
            this.f41264a = view.findViewById(R.id.layout_group_chat_reply);
            this.f41267d = (TextView) view.findViewById(R.id.text_group_chat_reply_user_name);
            this.f41266c = (TextView) view.findViewById(R.id.text_group_chat_reply_content);
            this.f41271h = (RelativeLayout) view.findViewById(R.id.image_group_chat_file_type_container);
            this.f41269f = (ImageView) view.findViewById(R.id.image_group_chat_reply_type_icon);
            this.f41270g = (ImageView) view.findViewById(R.id.image_reply_thumb);
            this.f41272i = (RoundAngleFrameLayout) view.findViewById(R.id.image_reply_thumb_container);
            this.f41268e = (TextView) view.findViewById(R.id.sender_title_tv);
            this.l = (FlexBox) view.findViewById(R.id.ll);
        }
    }

    private static void a(ImageView imageView) {
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = DensityUtil.dp2px(16.0f);
        layoutParams.width = DensityUtil.dp2px(16.0f);
        imageView.setLayoutParams(layoutParams);
    }

    class v extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        final View f41331a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41332b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41333c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41334d;

        /* renamed from: e  reason: collision with root package name */
        TextView f41335e;

        /* renamed from: f  reason: collision with root package name */
        ImageView f41336f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f41337g;

        /* renamed from: h  reason: collision with root package name */
        RoundAngleFrameLayout f41338h;

        /* renamed from: i  reason: collision with root package name */
        RelativeLayout f41339i;
        int j;
        int k;

        /* synthetic */ v(f fVar, View view, byte b2) {
            this(view);
        }

        private v(View view) {
            super(view);
            this.f41332b = (TextView) view.findViewById(R.id.text_group_chat_message);
            this.f41331a = view.findViewById(R.id.layout_group_chat_reply);
            this.f41334d = (TextView) view.findViewById(R.id.text_group_chat_reply_user_name);
            this.f41333c = (TextView) view.findViewById(R.id.text_group_chat_reply_content);
            this.f41339i = (RelativeLayout) view.findViewById(R.id.image_group_chat_file_type_container);
            this.f41336f = (ImageView) view.findViewById(R.id.image_group_chat_reply_type_icon);
            this.f41337g = (ImageView) view.findViewById(R.id.image_reply_thumb);
            this.f41338h = (RoundAngleFrameLayout) view.findViewById(R.id.image_reply_thumb_container);
            this.f41335e = (TextView) view.findViewById(R.id.sender_title_tv);
            this.j = Math.round((float) DensityUtil.dp2px(12.0f));
            this.k = Math.round((float) DensityUtil.dp2px(10.0f));
        }
    }

    class h extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        final View f41230a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41231b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41232c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f41233d;

        /* synthetic */ h(f fVar, View view, byte b2) {
            this(view);
        }

        private h(View view) {
            super(view);
            this.f41230a = view.findViewById(R.id.layout_group_chat_file_message);
            this.f41231b = (TextView) view.findViewById(R.id.text_group_chat_file_name);
            this.f41232c = (TextView) view.findViewById(R.id.text_group_chat_file_size);
            this.f41233d = (ImageView) view.findViewById(R.id.image_group_chat_file_type);
        }
    }

    class r extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        final View f41294a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41295b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41296c;

        /* renamed from: d  reason: collision with root package name */
        ImageView f41297d;

        /* synthetic */ r(f fVar, View view, byte b2) {
            this(view);
        }

        private r(View view) {
            super(view);
            this.f41295b = (TextView) view.findViewById(R.id.text_group_chat_file_name);
            this.f41296c = (TextView) view.findViewById(R.id.text_group_chat_file_size);
            this.f41297d = (ImageView) view.findViewById(R.id.image_group_chat_file_type);
            this.f41294a = view.findViewById(R.id.layout_group_chat_file_message);
        }
    }

    class i extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        TextView f41241a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f41242b;

        /* renamed from: c  reason: collision with root package name */
        View f41243c;

        /* renamed from: d  reason: collision with root package name */
        View f41244d;

        /* renamed from: e  reason: collision with root package name */
        View f41245e;

        /* renamed from: f  reason: collision with root package name */
        final CircleProgressBar f41246f;

        /* renamed from: g  reason: collision with root package name */
        View f41247g;

        /* synthetic */ i(f fVar, View view, byte b2) {
            this(view);
        }

        private i(View view) {
            super(view);
            this.f41246f = (CircleProgressBar) view.findViewById(R.id.circle_progress);
            this.f41245e = view.findViewById(R.id.fl_group_chat_down_button);
            this.f41247g = view.findViewById(R.id.image_group_chat_image_down);
            this.f41241a = (TextView) view.findViewById(R.id.text_image_group_chat_file_data);
            this.f41244d = view.findViewById(R.id.ll_group_chat_image_bottom);
            this.f41242b = (ImageView) view.findViewById(R.id.image_group_chat_file_thumbnail);
            this.f41243c = view.findViewById(R.id.image_group_chat_status_gradient);
        }
    }

    public final void c(boolean z2) {
        this.m = z2;
    }

    class s extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        TextView f41301a;

        /* renamed from: b  reason: collision with root package name */
        ImageView f41302b;

        /* renamed from: c  reason: collision with root package name */
        View f41303c;

        /* renamed from: d  reason: collision with root package name */
        final CircleProgressBar f41304d;

        /* renamed from: e  reason: collision with root package name */
        View f41305e;

        /* synthetic */ s(f fVar, View view, byte b2) {
            this(view);
        }

        private s(View view) {
            super(view);
            this.f41301a = (TextView) view.findViewById(R.id.text_image_group_chat_file_data);
            this.f41302b = (ImageView) view.findViewById(R.id.image_group_chat_file_thumbnail);
            this.f41304d = (CircleProgressBar) view.findViewById(R.id.circle_progress);
            this.f41303c = view.findViewById(R.id.fl_group_chat_down_button);
            this.f41305e = view.findViewById(R.id.image_group_chat_image_down);
        }
    }

    class g extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        AudioPlayView f41220a;

        /* synthetic */ g(f fVar, View view, byte b2) {
            this(view);
        }

        private g(View view) {
            super(view);
            this.f41220a = (AudioPlayView) view.findViewById(R.id.audio_play);
        }
    }

    class p extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        AudioPlayView f41279a;

        /* synthetic */ p(f fVar, View view, byte b2) {
            this(view);
        }

        private p(View view) {
            super(view);
            this.f41279a = (AudioPlayView) view.findViewById(R.id.audio_play);
        }
    }

    class e extends com.paytm.android.chat.view.b {

        /* renamed from: b  reason: collision with root package name */
        private final View f41191b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f41192c;

        /* renamed from: d  reason: collision with root package name */
        private ChatHeadView f41193d;

        /* renamed from: e  reason: collision with root package name */
        private ChatHeadView f41194e;

        /* renamed from: f  reason: collision with root package name */
        private View f41195f;

        /* synthetic */ e(f fVar, View view, byte b2) {
            this(view);
        }

        private e(View view) {
            super(view);
            this.f41193d = (ChatHeadView) view.findViewById(R.id.image_group_chat_contact_image1);
            this.f41194e = (ChatHeadView) view.findViewById(R.id.image_group_chat_contact_image2);
            this.f41191b = view.findViewById(R.id.layout_group_chat_contact);
            this.f41192c = (TextView) view.findViewById(R.id.text_group_chat_contact_content);
            this.f41195f = view.findViewById(R.id.ll_contact_image2);
        }

        /* access modifiers changed from: package-private */
        public final void a(final ChatContactsMessageDataModel chatContactsMessageDataModel, GroupChannel groupChannel, boolean z, boolean z2) {
            a(chatContactsMessageDataModel.state == ChatMessageDataModel.RequestState.FAILED, groupChannel, chatContactsMessageDataModel.baseMessage);
            a(chatContactsMessageDataModel.isForward);
            a(z, chatContactsMessageDataModel.time, f.this.f41127a);
            f.this.b(chatContactsMessageDataModel.baseMessage, this.n, this.p);
            CTextUtils.getBuilder(chatContactsMessageDataModel.message).setClickSpan(new ClickableSpan() {
                public final void onClick(View view) {
                }
            }).setForegroundColor(-16777216).into(this.f41192c);
            this.f41191b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!FastClickUtil.isFastClick()) {
                        return;
                    }
                    if (f.this.f41134h) {
                        f.a(f.this, chatContactsMessageDataModel.baseMessage, e.this.n);
                    } else if (f.this.f41132f != null) {
                        f.this.f41132f.a((UserMessage) chatContactsMessageDataModel.baseMessage);
                    }
                }
            });
            List<SelectContactsBean> list = chatContactsMessageDataModel.sendContactBeans;
            if (list != null) {
                if (list.size() == 1) {
                    this.f41195f.setVisibility(8);
                } else {
                    this.f41195f.setVisibility(0);
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    SelectContactsBean selectContactsBean = list.get(i2);
                    if (!(selectContactsBean == null || selectContactsBean.getSendContactBean() == null)) {
                        if (i2 == 0) {
                            this.f41193d.setUI(selectContactsBean.getSendContactBean().getPtPic(), selectContactsBean.getSendContactBean().getContactName(), selectContactsBean.getSendContactBean().getPtName(), selectContactsBean.getSendContactBean().getContactPhone());
                        } else if (i2 == 1) {
                            this.f41194e.setUI(selectContactsBean.getSendContactBean().getPtPic(), selectContactsBean.getSendContactBean().getContactName(), selectContactsBean.getSendContactBean().getPtName(), selectContactsBean.getSendContactBean().getContactPhone());
                        }
                    }
                }
            }
            this.u.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                        f.this.f41132f.b(chatContactsMessageDataModel.baseMessage);
                    }
                }
            });
            this.v.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                        f.this.f41132f.a(chatContactsMessageDataModel.baseMessage);
                    }
                }
            });
            this.t = f.this.f41129c.isReplyAllowed();
            f.this.a(chatContactsMessageDataModel.baseMessage, this.n, this.f41191b);
            f.this.b(chatContactsMessageDataModel.baseMessage, this.n, this.p);
            a(z, z2, true);
        }
    }

    class q extends com.paytm.android.chat.view.a {

        /* renamed from: b  reason: collision with root package name */
        private final View f41286b;

        /* renamed from: c  reason: collision with root package name */
        private final TextView f41287c;

        /* renamed from: d  reason: collision with root package name */
        private ChatHeadView f41288d;

        /* renamed from: e  reason: collision with root package name */
        private ChatHeadView f41289e;

        /* renamed from: f  reason: collision with root package name */
        private final View f41290f;

        /* synthetic */ q(f fVar, View view, byte b2) {
            this(view);
        }

        private q(View view) {
            super(view);
            this.f41290f = view.findViewById(R.id.ll_contact_image2);
            this.f41288d = (ChatHeadView) view.findViewById(R.id.image_group_chat_contact_image1);
            this.f41289e = (ChatHeadView) view.findViewById(R.id.image_group_chat_contact_image2);
            this.f41286b = view.findViewById(R.id.layout_group_chat_contact);
            this.f41287c = (TextView) view.findViewById(R.id.text_group_chat_contact_content);
        }

        /* access modifiers changed from: package-private */
        public final void a(final ChatContactsMessageDataModel chatContactsMessageDataModel, boolean z, boolean z2) {
            this.t = f.this.f41129c.isReplyAllowed();
            a(z, chatContactsMessageDataModel.time, f.this.f41127a);
            f.this.b(chatContactsMessageDataModel.baseMessage, this.n, this.p);
            CTextUtils.getBuilder(chatContactsMessageDataModel.message).setClickSpan(new ClickableSpan() {
                public final void onClick(View view) {
                }
            }).setForegroundColor(-16777216).into(this.f41287c);
            this.f41286b.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!FastClickUtil.isFastClick()) {
                        return;
                    }
                    if (f.this.f41134h) {
                        f.a(f.this, chatContactsMessageDataModel.baseMessage, q.this.n);
                    } else if (f.this.f41132f != null) {
                        f.this.f41132f.a((UserMessage) chatContactsMessageDataModel.baseMessage);
                    }
                }
            });
            List<SelectContactsBean> list = chatContactsMessageDataModel.sendContactBeans;
            if (list != null) {
                if (list.size() == 1) {
                    this.f41290f.setVisibility(8);
                } else {
                    this.f41290f.setVisibility(0);
                }
                for (int i2 = 0; i2 < list.size(); i2++) {
                    SelectContactsBean selectContactsBean = list.get(i2);
                    if (!(selectContactsBean == null || selectContactsBean.getSendContactBean() == null)) {
                        if (i2 == 0) {
                            this.f41288d.setUI(selectContactsBean.getSendContactBean().getPtPic(), selectContactsBean.getSendContactBean().getContactName(), selectContactsBean.getSendContactBean().getPtName(), selectContactsBean.getSendContactBean().getContactPhone());
                        } else if (i2 == 1) {
                            this.f41289e.setUI(selectContactsBean.getSendContactBean().getPtPic(), selectContactsBean.getSendContactBean().getContactName(), selectContactsBean.getSendContactBean().getPtName(), selectContactsBean.getSendContactBean().getContactPhone());
                        }
                    }
                }
            }
            f.this.a(chatContactsMessageDataModel.baseMessage, this.n, this.f41286b);
            f.this.b(chatContactsMessageDataModel.baseMessage, this.n, this.p);
            a(z, z2, false);
        }
    }

    /* renamed from: com.paytm.android.chat.a.f$f  reason: collision with other inner class name */
    class C0690f extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        final TextView f41203a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f41204b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f41205c;

        /* renamed from: d  reason: collision with root package name */
        final View f41206d;

        /* renamed from: e  reason: collision with root package name */
        final RecyclerView f41207e;

        /* renamed from: f  reason: collision with root package name */
        LinearLayoutManager f41208f;

        /* renamed from: g  reason: collision with root package name */
        Animation f41209g;

        /* renamed from: h  reason: collision with root package name */
        Animation f41210h;

        /* renamed from: i  reason: collision with root package name */
        LinearLayout f41211i;
        ImageView j;
        ImageView k;
        View l;

        /* synthetic */ C0690f(f fVar, View view, byte b2) {
            this(view);
        }

        private C0690f(View view) {
            super(view);
            this.f41204b = (TextView) this.itemView.findViewById(R.id.text_group_chat_message);
            this.f41203a = (TextView) this.itemView.findViewById(R.id.text_group_chat_transfer_money);
            this.f41205c = (TextView) this.itemView.findViewById(R.id.tv_group_chat_transfer_status);
            this.f41206d = this.itemView.findViewById(R.id.ll);
            this.f41207e = (RecyclerView) this.itemView.findViewById(R.id.recycler_group_quick_reply_container);
            this.f41208f = new LinearLayoutManager(f.this.f41127a, 0, false);
            this.f41208f.setStackFromEnd(true);
            this.f41207e.setLayoutManager(this.f41208f);
            this.f41211i = (LinearLayout) this.itemView.findViewById(R.id.group_chat_message_container);
            this.j = (ImageView) this.itemView.findViewById(R.id.border);
            this.f41210h = AnimationUtils.loadAnimation(f.this.f41127a, R.anim.chat_payment_border);
            this.f41209g = AnimationUtils.loadAnimation(f.this.f41127a, R.anim.chat_payment_card);
            this.k = (ImageView) this.itemView.findViewById(R.id.iv_group_chat_transfer_status);
            this.l = this.itemView.findViewById(R.id.image_group_chat_read_receipt);
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }
    }

    class t extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        final TextView f41311a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f41312b;

        /* renamed from: c  reason: collision with root package name */
        final View f41313c;

        /* renamed from: d  reason: collision with root package name */
        Animation f41314d;

        /* renamed from: e  reason: collision with root package name */
        Animation f41315e;

        /* renamed from: f  reason: collision with root package name */
        LinearLayout f41316f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f41317g;

        /* renamed from: h  reason: collision with root package name */
        ImageView f41318h;

        /* synthetic */ t(f fVar, View view, byte b2) {
            this(view);
        }

        private t(View view) {
            super(view);
            this.f41312b = (TextView) view.findViewById(R.id.text_group_chat_message);
            this.f41311a = (TextView) view.findViewById(R.id.text_group_chat_transfer_money);
            this.f41313c = view.findViewById(R.id.ll);
            this.f41316f = (LinearLayout) view.findViewById(R.id.group_chat_message_container);
            this.f41317g = (ImageView) view.findViewById(R.id.border);
            this.f41315e = AnimationUtils.loadAnimation(f.this.f41127a, R.anim.chat_payment_border);
            this.f41314d = AnimationUtils.loadAnimation(f.this.f41127a, R.anim.chat_payment_card);
            this.f41318h = (ImageView) view.findViewById(R.id.image_group_chat_read_receipt);
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }
    }

    class w extends com.paytm.android.chat.view.b {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41342a;

        /* renamed from: b  reason: collision with root package name */
        View f41343b;

        /* renamed from: c  reason: collision with root package name */
        View f41344c;

        /* renamed from: e  reason: collision with root package name */
        private TextView f41346e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f41347f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f41348g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f41349h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f41350i;

        public w(View view) {
            super(view);
            this.t = false;
            this.f41344c = view.findViewById(R.id.messageContainer);
            this.f41346e = (TextView) view.findViewById(R.id.txtMessageTitle);
            this.f41347f = (TextView) view.findViewById(R.id.txtMessageContent);
            this.f41348g = (TextView) view.findViewById(R.id.chat_msg_time);
            this.f41349h = (TextView) view.findViewById(R.id.textDateTime);
            this.f41342a = (ImageView) view.findViewById(R.id.arrow);
            this.f41343b = view.findViewById(R.id.group_chat_bubble);
            this.f41350i = (TextView) view.findViewById(R.id.txtAmount);
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }

        public final void a(ChatTransferMessageDataModel chatTransferMessageDataModel, boolean z, boolean z2) {
            if (chatTransferMessageDataModel.bean != null) {
                PFPaymentStatusBean pFPaymentStatusBean = chatTransferMessageDataModel.bean;
                a(pFPaymentStatusBean.getReply(), f.this.f41129c);
                this.f41346e.setText(R.string.chat_fail);
                this.f41346e.setVisibility(0);
                if (!TextUtils.isEmpty(pFPaymentStatusBean.getMessage())) {
                    this.f41347f.setText(pFPaymentStatusBean.getMessage());
                    this.f41347f.setVisibility(0);
                } else {
                    this.f41347f.setVisibility(8);
                }
                if (!TextUtils.isEmpty(pFPaymentStatusBean.getAmount())) {
                    CTextUtils.Builder proportion = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(0.74f);
                    proportion.append(pFPaymentStatusBean.getAmount()).setProportion(1.0f).into(this.f41350i);
                    this.f41350i.setVisibility(0);
                } else {
                    this.f41350i.setVisibility(8);
                }
                if (z) {
                    this.f41349h.setVisibility(0);
                    this.f41349h.setText(DateUtils.getMessageDate(chatTransferMessageDataModel.time, f.this.f41127a));
                } else {
                    this.f41349h.setVisibility(8);
                }
                this.f41348g.setText(DateUtils.formatDateMonthTime(chatTransferMessageDataModel.time));
                if (z || !z2) {
                    this.f41342a.setVisibility(0);
                    View view = this.f41343b;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_bg));
                } else {
                    View view2 = this.f41343b;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_rounded_bg));
                    this.f41342a.setVisibility(4);
                }
                this.f41344c.setOnClickListener(new View.OnClickListener(pFPaymentStatusBean) {
                    private final /* synthetic */ PFPaymentStatusBean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        f.w.this.a(this.f$1, view);
                    }
                });
                this.f41344c.setVisibility(0);
                return;
            }
            this.f41344c.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(PFPaymentStatusBean pFPaymentStatusBean, View view) {
            if (FastClickUtil.isFastClick() && !f.this.f41134h && f.this.f41132f != null) {
                f.this.f41132f.a(pFPaymentStatusBean.getDeeplinkUrl(), pFPaymentStatusBean.getPaymentMode(), pFPaymentStatusBean.getTxnId());
            }
        }

        public final void a(ChatUPIResponseDataModel chatUPIResponseDataModel, boolean z, boolean z2) {
            if (chatUPIResponseDataModel.getData() != null) {
                ChatMessageUPIData data = chatUPIResponseDataModel.getData();
                a(data.getReply(), f.this.f41129c);
                if (data.getSenderState() != null) {
                    this.f41346e.setText(data.getSenderState());
                } else {
                    this.f41346e.setText(R.string.chat_fail);
                }
                this.f41346e.setVisibility(0);
                if (!TextUtils.isEmpty(data.getSenderDesc())) {
                    this.f41347f.setText(data.getSenderDesc());
                    this.f41347f.setVisibility(0);
                } else {
                    this.f41347f.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getAmount())) {
                    CTextUtils.Builder proportion = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(0.74f);
                    proportion.append(data.getAmount()).setProportion(1.0f).into(this.f41350i);
                    this.f41350i.setVisibility(0);
                } else {
                    this.f41350i.setVisibility(8);
                }
                if (z) {
                    this.f41349h.setVisibility(0);
                    this.f41349h.setText(DateUtils.getMessageDate(chatUPIResponseDataModel.time, f.this.f41127a));
                } else {
                    this.f41349h.setVisibility(8);
                }
                this.f41348g.setText(DateUtils.formatDateMonthTime(chatUPIResponseDataModel.time));
                if (z || !z2) {
                    this.f41342a.setVisibility(0);
                    View view = this.f41343b;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_bg));
                } else {
                    View view2 = this.f41343b;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_rounded_bg));
                    this.f41342a.setVisibility(4);
                }
                this.f41344c.setOnClickListener(new View.OnClickListener(data) {
                    private final /* synthetic */ ChatMessageUPIData f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        f.w.this.a(this.f$1, view);
                    }
                });
                this.f41344c.setVisibility(0);
                return;
            }
            this.f41344c.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(ChatMessageUPIData chatMessageUPIData, View view) {
            if (FastClickUtil.isFastClick() && !f.this.f41134h && f.this.f41132f != null) {
                f.this.f41132f.a(chatMessageUPIData.getDeeplinkUrl(), chatMessageUPIData.getPaymentMode(), chatMessageUPIData.getTxnId());
            }
        }
    }

    class x extends com.paytm.android.chat.view.a {

        /* renamed from: a  reason: collision with root package name */
        ImageView f41351a;

        /* renamed from: b  reason: collision with root package name */
        View f41352b;

        /* renamed from: c  reason: collision with root package name */
        View f41353c;

        /* renamed from: e  reason: collision with root package name */
        private TextView f41355e;

        /* renamed from: f  reason: collision with root package name */
        private TextView f41356f;

        /* renamed from: g  reason: collision with root package name */
        private TextView f41357g;

        /* renamed from: h  reason: collision with root package name */
        private TextView f41358h;

        /* renamed from: i  reason: collision with root package name */
        private TextView f41359i;

        public x(View view) {
            super(view);
            this.t = false;
            this.f41353c = view.findViewById(R.id.messageContainer);
            this.f41355e = (TextView) view.findViewById(R.id.txtMessageTitle);
            this.f41356f = (TextView) view.findViewById(R.id.txtMessageContent);
            this.f41357g = (TextView) view.findViewById(R.id.chat_msg_time);
            this.f41358h = (TextView) view.findViewById(R.id.textDateTime);
            this.f41351a = (ImageView) view.findViewById(R.id.arrow);
            this.f41352b = view.findViewById(R.id.group_chat_bubble);
            this.f41359i = (TextView) view.findViewById(R.id.txtAmount);
        }

        public final void a(UserDataBean userDataBean) {
            if (FastClickUtil.isFastClick() && f.this.f41132f != null) {
                f.this.f41132f.a(userDataBean.getMessageId());
            }
        }

        public final void a(ChatTransferMessageDataModel chatTransferMessageDataModel, boolean z, boolean z2) {
            if (chatTransferMessageDataModel.bean != null) {
                PFPaymentStatusBean pFPaymentStatusBean = chatTransferMessageDataModel.bean;
                a(pFPaymentStatusBean.getReply(), f.this.f41129c);
                this.f41355e.setText(R.string.chat_fail);
                this.f41355e.setVisibility(0);
                if (!TextUtils.isEmpty(pFPaymentStatusBean.getMessage())) {
                    this.f41356f.setText(pFPaymentStatusBean.getMessage());
                    this.f41356f.setVisibility(0);
                } else {
                    this.f41356f.setVisibility(8);
                }
                if (!TextUtils.isEmpty(pFPaymentStatusBean.getAmount())) {
                    CTextUtils.Builder proportion = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(0.74f);
                    proportion.append(pFPaymentStatusBean.getAmount()).setProportion(1.0f).into(this.f41359i);
                    this.f41359i.setVisibility(0);
                } else {
                    this.f41359i.setVisibility(8);
                }
                if (z) {
                    this.f41358h.setVisibility(0);
                    this.f41358h.setText(DateUtils.getMessageDate(chatTransferMessageDataModel.time, f.this.f41127a));
                } else {
                    this.f41358h.setVisibility(8);
                }
                this.f41357g.setText(DateUtils.formatDateMonthTime(chatTransferMessageDataModel.time));
                if (z || !z2) {
                    this.f41351a.setVisibility(0);
                    View view = this.f41352b;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_bg));
                } else {
                    View view2 = this.f41352b;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_rounded_bg));
                    this.f41351a.setVisibility(4);
                }
                this.f41353c.setOnClickListener(new View.OnClickListener(pFPaymentStatusBean) {
                    private final /* synthetic */ PFPaymentStatusBean f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        f.x.this.a(this.f$1, view);
                    }
                });
                this.f41353c.setVisibility(0);
                return;
            }
            this.f41353c.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(PFPaymentStatusBean pFPaymentStatusBean, View view) {
            if (FastClickUtil.isFastClick() && !f.this.f41134h && f.this.f41132f != null) {
                f.this.f41132f.a(pFPaymentStatusBean.getDeeplinkUrl(), pFPaymentStatusBean.getPaymentMode(), pFPaymentStatusBean.getTxnId());
            }
        }

        public final void a(ChatUPIResponseDataModel chatUPIResponseDataModel, boolean z, boolean z2) {
            if (chatUPIResponseDataModel.getData() != null) {
                ChatMessageUPIData data = chatUPIResponseDataModel.getData();
                a(data.getReply(), f.this.f41129c);
                if (!TextUtils.isEmpty(data.getReceiverState())) {
                    this.f41355e.setText(data.getReceiverState());
                } else {
                    this.f41355e.setText(R.string.chat_fail);
                }
                this.f41355e.setVisibility(0);
                if (!TextUtils.isEmpty(data.getReceiverDesc())) {
                    this.f41356f.setText(data.getReceiverDesc());
                    this.f41356f.setVisibility(0);
                } else {
                    this.f41356f.setVisibility(8);
                }
                if (!TextUtils.isEmpty(data.getAmount())) {
                    CTextUtils.Builder proportion = CTextUtils.getBuilder("").append(FilterPriceSliderFragment.RUPEE_SYMBOL).setProportion(0.74f);
                    proportion.append(data.getAmount()).setProportion(1.0f).into(this.f41359i);
                    this.f41359i.setVisibility(0);
                } else {
                    this.f41359i.setVisibility(8);
                }
                if (z) {
                    this.f41358h.setVisibility(0);
                    this.f41358h.setText(DateUtils.getMessageDate(chatUPIResponseDataModel.time, f.this.f41127a));
                } else {
                    this.f41358h.setVisibility(8);
                }
                this.f41357g.setText(DateUtils.formatDateMonthTime(chatUPIResponseDataModel.time));
                if (z || !z2) {
                    this.f41351a.setVisibility(0);
                    View view = this.f41352b;
                    view.setBackground(view.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_bg));
                } else {
                    View view2 = this.f41352b;
                    view2.setBackground(view2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_rounded_bg));
                    this.f41351a.setVisibility(4);
                }
                this.f41353c.setOnClickListener(new View.OnClickListener(data) {
                    private final /* synthetic */ ChatMessageUPIData f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void onClick(View view) {
                        f.x.this.a(this.f$1, view);
                    }
                });
                this.f41353c.setVisibility(0);
                return;
            }
            this.f41353c.setVisibility(8);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(ChatMessageUPIData chatMessageUPIData, View view) {
            if (FastClickUtil.isFastClick() && !f.this.f41134h && f.this.f41132f != null) {
                f.this.f41132f.a(chatMessageUPIData.getDeeplinkUrl(), chatMessageUPIData.getPaymentMode(), chatMessageUPIData.getTxnId());
            }
        }
    }

    public final m e() {
        return this.f41132f;
    }

    public final List<ChatMessageDataModel> f() {
        return this.f41131e;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 0) {
            return new j(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_user_me, viewGroup, false));
        }
        if (i2 == 1) {
            return new u(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_user_other, viewGroup, false), (byte) 0);
        }
        switch (i2) {
            case 10:
                return new k(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_user_me, viewGroup, false));
            case 11:
                return new v(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_user_other, viewGroup, false), (byte) 0);
            case 12:
                return new h(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_file_me, viewGroup, false), (byte) 0);
            case 13:
                return new r(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_file_other, viewGroup, false), (byte) 0);
            case 14:
                return new i(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_file_image_me, viewGroup, false), (byte) 0);
            case 15:
                return new s(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_file_image_other, viewGroup, false), (byte) 0);
            case 16:
                return new g(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_file_audio_me, viewGroup, false), (byte) 0);
            case 17:
                return new p(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_file_audio_other, viewGroup, false), (byte) 0);
            case 18:
                return new e(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_contact_me, viewGroup, false), (byte) 0);
            case 19:
                return new q(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_contact_other, viewGroup, false), (byte) 0);
            case 20:
                return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_admin, viewGroup, false));
            case 21:
                return new C0690f(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_transfer_me, viewGroup, false), (byte) 0);
            case 22:
                return new t(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_transfer_other, viewGroup, false), (byte) 0);
            case 23:
            case 25:
                return new w(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_transfer_fail_me, viewGroup, false));
            case 24:
            case 26:
                return new x(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_transfer_fail_other, viewGroup, false));
            case 27:
                return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_paytm_channel_simple_msg, viewGroup, false));
            case 28:
                return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_generic_message_view, viewGroup, false));
            case 29:
                return new y(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_upi_request_me, viewGroup, false));
            case 30:
                return new z(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_upi_request_other, viewGroup, false));
            case 31:
                return new aa(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_upi_response_me, viewGroup, false));
            case 32:
                return new ab(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_message_upi_response_other, viewGroup, false));
            default:
                return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item_group_chat_admin, viewGroup, false));
        }
    }

    static /* synthetic */ void a(f fVar, BaseMessage baseMessage, View view) {
        List<BaseMessage> list;
        if (view != null && (list = fVar.o) != null) {
            if (list.contains(baseMessage)) {
                fVar.o.remove(baseMessage);
                view.setVisibility(8);
            } else if (fVar.o.size() > 0) {
                ToastUtil.showMsg(R.string.chat_module_no_more_than_five_messages);
                return;
            } else {
                fVar.o.add(baseMessage);
                view.setVisibility(0);
            }
            n nVar = fVar.p;
            if (nVar != null) {
                nVar.a(fVar.o.size());
            }
        }
    }

    static /* synthetic */ void a(f fVar, String str) {
        if (URLUtil.isNetworkUrl(str)) {
            try {
                fVar.f41127a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception unused) {
                com.paytm.utility.q.a();
            }
        } else {
            fVar.f41132f.a(str);
        }
    }
}
