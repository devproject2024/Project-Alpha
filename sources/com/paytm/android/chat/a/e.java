package com.paytm.android.chat.a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.ChatChannelHeader;
import com.paytm.android.chat.bean.ChatContactHeader;
import com.paytm.android.chat.bean.ChatFriendsHeader;
import com.paytm.android.chat.bean.ChatHomeChip;
import com.paytm.android.chat.bean.ChatType;
import com.paytm.android.chat.bean.FriendBean;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.MPCMessagePreview;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.network.response.HomeChips;
import com.paytm.android.chat.utils.CTextUtils;
import com.paytm.android.chat.utils.ChatMessageState;
import com.paytm.android.chat.utils.ChatOneButtonDialog;
import com.paytm.android.chat.utils.ChatVariantUtilKt;
import com.paytm.android.chat.utils.DateUtils;
import com.paytm.android.chat.utils.DensityUtil;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.MessageContentUtils;
import com.paytm.android.chat.utils.NetUtils;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.utils.TwoButtonDialogUtil;
import com.paytm.android.chat.view.ChatHeadView;
import com.paytm.android.chat.view.SwipeMenuLayout;
import com.sendbird.android.AdminMessage;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.UserMessage;
import java.util.ArrayList;
import java.util.List;

public final class e extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    int f41062a;

    /* renamed from: b  reason: collision with root package name */
    Context f41063b;

    /* renamed from: c  reason: collision with root package name */
    public j f41064c;

    /* renamed from: d  reason: collision with root package name */
    public k f41065d;

    /* renamed from: e  reason: collision with root package name */
    public h f41066e;

    /* renamed from: f  reason: collision with root package name */
    public i f41067f;

    /* renamed from: g  reason: collision with root package name */
    public final List<Object> f41068g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public int f41069h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f41070i = 0;
    private RecyclerView j;

    public interface h {
        void a(SelectContactsBean selectContactsBean);
    }

    public interface i {
        void a(FriendBean friendBean, int i2);
    }

    public interface j {
        void a(ChatGroupChannelDataModel chatGroupChannelDataModel, Integer num);
    }

    public interface k {
        void a(ChatGroupChannelDataModel chatGroupChannelDataModel, int i2);

        void a(ChatGroupChannelDataModel chatGroupChannelDataModel, String str, int i2);

        void a(ChatGroupChannelDataModel chatGroupChannelDataModel, boolean z, int i2);
    }

    public e(Context context) {
        this.f41063b = context;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 == 1) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_group_channel, viewGroup, false));
        }
        if (i2 == 2) {
            return new C0689e(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_group_contact, viewGroup, false));
        }
        if (i2 == 4) {
            return new f(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_group_friend, viewGroup, false));
        }
        if (i2 == 5) {
            return new g(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_item_filter_chips, viewGroup, false));
        }
        if (i2 == 6) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_home_channel_header, viewGroup, false));
        }
        if (i2 == 7) {
            return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_home_friend_header, viewGroup, false));
        }
        if (i2 == 8) {
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_home_contact_header, viewGroup, false));
        }
        return new RecyclerView.v(new View(viewGroup.getContext())) {
        };
    }

    public final void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.j = recyclerView;
        this.j.addItemDecoration(new RecyclerView.h() {
            public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                super.getItemOffsets(rect, view, recyclerView, sVar);
                if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getItemCount() - 1) {
                    rect.bottom = DensityUtil.dp2px(40.0f);
                }
            }
        });
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        int i3;
        Object obj = this.f41068g.get(i2);
        if (vVar instanceof g) {
            g gVar = ((g) vVar).f41125c;
            List<HomeChips> list = ((ChatHomeChip) obj).getList();
            kotlin.g.b.k.c(list, "chips");
            gVar.f41378a = list;
            gVar.notifyDataSetChanged();
            return;
        }
        boolean z = true;
        if (vVar instanceof a) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            a aVar = (a) vVar;
            Context context = this.f41063b;
            j jVar = this.f41064c;
            k kVar = this.f41065d;
            if (kotlin.a.k.a(e.this.f41068g, i2 + 1) instanceof ChatGroupChannelDataModel) {
                aVar.s.setVisibility(0);
            } else {
                aVar.s.setVisibility(4);
            }
            View view = aVar.itemView;
            if (view != null) {
                int i4 = -1;
                boolean booleanValue = view.getTag(R.id.isShow) != null ? ((Boolean) view.getTag(R.id.isShow)).booleanValue() : false;
                if (view.getTag(R.id.position) != null) {
                    i4 = ((Integer) aVar.itemView.getTag(R.id.position)).intValue();
                }
                if (i4 != i2 && booleanValue) {
                    view.setScrollX(0);
                    view.setBackgroundColor(0);
                } else if (i4 == i2 && booleanValue) {
                    view.setBackgroundColor(Color.parseColor("#F2F2F2"));
                }
            }
            aVar.l.setClickListener(new SwipeMenuLayout.a(jVar, chatGroupChannelDataModel, i2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ j f41083a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ ChatGroupChannelDataModel f41084b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ int f41085c;

                {
                    this.f41083a = r2;
                    this.f41084b = r3;
                    this.f41085c = r4;
                }

                public final void a() {
                    if (FastClickUtil.isFastClick() && !a.this.l.f42527a) {
                        this.f41083a.a(this.f41084b, Integer.valueOf(this.f41085c + 1));
                    }
                }
            });
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            String name = receiverDisplayInfo.getName();
            String profileImage = receiverDisplayInfo.getProfileImage();
            ChatUserDataModel channelDisplayMember = ChatVariantUtilKt.getChannelDisplayMember(chatGroupChannelDataModel);
            if (channelDisplayMember != null) {
                aVar.f41074a.setText(channelDisplayMember.getSendbirdUsername());
                aVar.f41079f.setUI(channelDisplayMember.getAvatarUrl(), channelDisplayMember.getSendbirdUsername());
            } else if (receiverDisplayInfo.getChatType() == ChatType.P2BK || receiverDisplayInfo.getChatType() == ChatType.P2VPA || receiverDisplayInfo.getChatType() == ChatType.P2VPAM) {
                aVar.f41079f.setOnlinePaymentUI(receiverDisplayInfo);
                aVar.f41074a.setText(name);
            } else {
                aVar.f41074a.setText(name);
                aVar.f41079f.setUI(profileImage, name);
            }
            e.this.f41062a = chatGroupChannelDataModel.getUnreadMessageCount();
            if (e.this.f41062a == 0) {
                aVar.f41076c.setVisibility(4);
            } else if (e.this.f41062a > 99) {
                aVar.f41076c.setVisibility(0);
                aVar.f41076c.setText("99+");
            } else {
                aVar.f41076c.setVisibility(0);
                aVar.f41076c.setText(String.valueOf(chatGroupChannelDataModel.getUnreadMessageCount()));
            }
            BaseMessage baseMessage = chatGroupChannelDataModel.getLastMessage() != null ? chatGroupChannelDataModel.getLastMessage().baseMessage : null;
            if (baseMessage != null) {
                aVar.f41077d.setVisibility(0);
                aVar.f41075b.setVisibility(0);
                aVar.f41077d.setText(String.valueOf(DateUtils.formatDateOr(baseMessage.getCreatedAt(), context)));
            } else {
                aVar.f41077d.setVisibility(4);
                aVar.f41075b.setVisibility(4);
            }
            String draftMessage = chatGroupChannelDataModel.getDraftMessage();
            MPCMessagePreview lastMessagePreview = chatGroupChannelDataModel.getLastMessagePreview();
            switch (lastMessagePreview.getPreviewDrawable()) {
                case FAIL:
                    i3 = R.drawable.chat_icon_group_chat_message_state_fail;
                    break;
                case FILE:
                    i3 = R.drawable.chat_icon_chat_multi_item_document;
                    break;
                case AUDIO:
                    i3 = R.drawable.chat_icon_chat_multi_item_audio;
                    break;
                case PHOTO:
                    i3 = R.drawable.chat_icon_chat_message_type_photo;
                    break;
                case RUPEE:
                    i3 = R.drawable.chat_ic_payment_new;
                    break;
                case CONTACT:
                    i3 = R.drawable.chat_icon_chat_multi_item_contact2;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (chatGroupChannelDataModel.isTyping()) {
                aVar.q.setVisibility(8);
                aVar.f41075b.setTypeface((Typeface) null, 2);
                aVar.f41075b.setText(R.string.chat_module_chat_typing);
            } else {
                aVar.f41075b.setTypeface((Typeface) null, 0);
                if (lastMessagePreview != null) {
                    if (i3 != 0) {
                        aVar.q.setImageResource(i3);
                        if (TextUtils.isEmpty(draftMessage)) {
                            aVar.q.setVisibility(0);
                        } else {
                            aVar.q.setVisibility(8);
                        }
                    } else {
                        aVar.q.setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(draftMessage)) {
                        CTextUtils.getBuilder("[Drafts] ").setForegroundColor(Color.parseColor("#FD5C5C")).append(draftMessage).into(aVar.f41075b);
                    } else {
                        aVar.f41075b.setText(lastMessagePreview.getPreviewText());
                    }
                } else if (!TextUtils.isEmpty(draftMessage)) {
                    CTextUtils.getBuilder("[Drafts] ").setForegroundColor(Color.parseColor("#FD5C5C")).append(draftMessage).into(aVar.f41075b);
                } else {
                    aVar.f41075b.setText(MessageContentUtils.getContent(baseMessage));
                }
            }
            if (jVar != null) {
                aVar.itemView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                    }
                });
            }
            aVar.f41080g.getParent().requestDisallowInterceptTouchEvent(true);
            aVar.f41080g.setOnClickListener(new View.OnClickListener(kVar, chatGroupChannelDataModel, i2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ k f41088a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ ChatGroupChannelDataModel f41089b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ int f41090c;

                {
                    this.f41088a = r2;
                    this.f41089b = r3;
                    this.f41090c = r4;
                }

                public final void onClick(View view) {
                    int visibility = a.this.m.getVisibility();
                    a.this.l.a();
                    view.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001c: INVOKE  
                          (r6v0 'view' android.view.View)
                          (wrap: com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ : 0x0017: CONSTRUCTOR  (r4v0 com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ) = 
                          (wrap: com.paytm.android.chat.a.e$k : 0x000f: IGET  (r1v2 com.paytm.android.chat.a.e$k) = (r5v0 'this' com.paytm.android.chat.a.e$a$3 A[THIS]) com.paytm.android.chat.a.e.a.3.a com.paytm.android.chat.a.e$k)
                          (wrap: com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel : 0x0011: IGET  (r2v0 com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) = (r5v0 'this' com.paytm.android.chat.a.e$a$3 A[THIS]) com.paytm.android.chat.a.e.a.3.b com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel)
                          (r0v2 'visibility' int)
                          (wrap: int : 0x0013: IGET  (r3v0 int) = (r5v0 'this' com.paytm.android.chat.a.e$a$3 A[THIS]) com.paytm.android.chat.a.e.a.3.c int)
                         call: com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ.<init>(com.paytm.android.chat.a.e$k, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel, int, int):void type: CONSTRUCTOR)
                          (500 long)
                         android.view.View.postDelayed(java.lang.Runnable, long):boolean type: VIRTUAL in method: com.paytm.android.chat.a.e.a.3.onClick(android.view.View):void, dex: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: CONSTRUCTOR  (r4v0 com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ) = 
                          (wrap: com.paytm.android.chat.a.e$k : 0x000f: IGET  (r1v2 com.paytm.android.chat.a.e$k) = (r5v0 'this' com.paytm.android.chat.a.e$a$3 A[THIS]) com.paytm.android.chat.a.e.a.3.a com.paytm.android.chat.a.e$k)
                          (wrap: com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel : 0x0011: IGET  (r2v0 com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) = (r5v0 'this' com.paytm.android.chat.a.e$a$3 A[THIS]) com.paytm.android.chat.a.e.a.3.b com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel)
                          (r0v2 'visibility' int)
                          (wrap: int : 0x0013: IGET  (r3v0 int) = (r5v0 'this' com.paytm.android.chat.a.e$a$3 A[THIS]) com.paytm.android.chat.a.e.a.3.c int)
                         call: com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ.<init>(com.paytm.android.chat.a.e$k, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel, int, int):void type: CONSTRUCTOR in method: com.paytm.android.chat.a.e.a.3.onClick(android.view.View):void, dex: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 70 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	... 76 more
                        */
                    /*
                        this = this;
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.ImageView r0 = r0.m
                        int r0 = r0.getVisibility()
                        com.paytm.android.chat.a.e$a r1 = com.paytm.android.chat.a.e.a.this
                        com.paytm.android.chat.view.SwipeMenuLayout r1 = r1.l
                        r1.a()
                        com.paytm.android.chat.a.e$k r1 = r5.f41088a
                        com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r2 = r5.f41089b
                        int r3 = r5.f41090c
                        com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ r4 = new com.paytm.android.chat.a.-$$Lambda$e$a$3$x8QLZ_zBff_6GOtkog1tbYvasLQ
                        r4.<init>(r1, r2, r0, r3)
                        r0 = 500(0x1f4, double:2.47E-321)
                        r6.postDelayed(r4, r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.a.e.a.AnonymousClass3.onClick(android.view.View):void");
                }

                /* access modifiers changed from: private */
                public static /* synthetic */ void a(k kVar, ChatGroupChannelDataModel chatGroupChannelDataModel, int i2, int i3) {
                    if (kVar != null) {
                        kVar.a(chatGroupChannelDataModel, i2 == 8, i3 + 1);
                    }
                }
            });
            aVar.f41081h.getParent().requestDisallowInterceptTouchEvent(true);
            aVar.f41081h.setOnClickListener(new View.OnClickListener(chatGroupChannelDataModel, kVar, i2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ ChatGroupChannelDataModel f41092a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ k f41093b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ int f41094c;

                {
                    this.f41092a = r2;
                    this.f41093b = r3;
                    this.f41094c = r4;
                }

                public final void onClick(View view) {
                    if (!this.f41092a.isPushEnabled()) {
                        a.this.n.setVisibility(8);
                        a.this.p.setImageResource(R.drawable.chat_icon_not_undisturb);
                        a.this.k.setText("Mute");
                    } else {
                        a.this.n.setVisibility(0);
                        a.this.p.setImageResource(R.drawable.ic_muted);
                        a.this.k.setText("Muted");
                    }
                    String trim = a.this.f41074a.getText().toString().trim();
                    a.this.l.a();
                    view.postDelayed(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0064: INVOKE  
                          (r8v0 'view' android.view.View)
                          (wrap: com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc : 0x005f: CONSTRUCTOR  (r1v0 com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc) = 
                          (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS])
                          (wrap: com.paytm.android.chat.a.e$k : 0x0055: IGET  (r3v0 com.paytm.android.chat.a.e$k) = (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS]) com.paytm.android.chat.a.e.a.4.b com.paytm.android.chat.a.e$k)
                          (wrap: com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel : 0x0057: IGET  (r4v0 com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) = (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS]) com.paytm.android.chat.a.e.a.4.a com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel)
                          (r5v0 'trim' java.lang.String)
                          (wrap: int : 0x0059: IGET  (r6v0 int) = (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS]) com.paytm.android.chat.a.e.a.4.c int)
                         call: com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc.<init>(com.paytm.android.chat.a.e$a$4, com.paytm.android.chat.a.e$k, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel, java.lang.String, int):void type: CONSTRUCTOR)
                          (500 long)
                         android.view.View.postDelayed(java.lang.Runnable, long):boolean type: VIRTUAL in method: com.paytm.android.chat.a.e.a.4.onClick(android.view.View):void, dex: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                        	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                        	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                        	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                        	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                        	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                        	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                        	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                        	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                        	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                        	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                        	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x005f: CONSTRUCTOR  (r1v0 com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc) = 
                          (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS])
                          (wrap: com.paytm.android.chat.a.e$k : 0x0055: IGET  (r3v0 com.paytm.android.chat.a.e$k) = (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS]) com.paytm.android.chat.a.e.a.4.b com.paytm.android.chat.a.e$k)
                          (wrap: com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel : 0x0057: IGET  (r4v0 com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) = (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS]) com.paytm.android.chat.a.e.a.4.a com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel)
                          (r5v0 'trim' java.lang.String)
                          (wrap: int : 0x0059: IGET  (r6v0 int) = (r7v0 'this' com.paytm.android.chat.a.e$a$4 A[THIS]) com.paytm.android.chat.a.e.a.4.c int)
                         call: com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc.<init>(com.paytm.android.chat.a.e$a$4, com.paytm.android.chat.a.e$k, com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel, java.lang.String, int):void type: CONSTRUCTOR in method: com.paytm.android.chat.a.e.a.4.onClick(android.view.View):void, dex: classes2.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                        	... 70 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:260)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:606)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                        	... 76 more
                        */
                    /*
                        this = this;
                        com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = r7.f41092a
                        boolean r0 = r0.isPushEnabled()
                        if (r0 != 0) goto L_0x0024
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.ImageView r0 = r0.n
                        r1 = 8
                        r0.setVisibility(r1)
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.ImageView r0 = r0.p
                        int r1 = com.paytm.android.chat.R.drawable.chat_icon_not_undisturb
                        r0.setImageResource(r1)
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.TextView r0 = r0.k
                        java.lang.String r1 = "Mute"
                        r0.setText(r1)
                        goto L_0x003e
                    L_0x0024:
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.ImageView r0 = r0.n
                        r1 = 0
                        r0.setVisibility(r1)
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.ImageView r0 = r0.p
                        int r1 = com.paytm.android.chat.R.drawable.ic_muted
                        r0.setImageResource(r1)
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.TextView r0 = r0.k
                        java.lang.String r1 = "Muted"
                        r0.setText(r1)
                    L_0x003e:
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        android.widget.TextView r0 = r0.f41074a
                        java.lang.CharSequence r0 = r0.getText()
                        java.lang.String r0 = r0.toString()
                        java.lang.String r5 = r0.trim()
                        com.paytm.android.chat.a.e$a r0 = com.paytm.android.chat.a.e.a.this
                        com.paytm.android.chat.view.SwipeMenuLayout r0 = r0.l
                        r0.a()
                        com.paytm.android.chat.a.e$k r3 = r7.f41093b
                        com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r4 = r7.f41092a
                        int r6 = r7.f41094c
                        com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc r0 = new com.paytm.android.chat.a.-$$Lambda$e$a$4$7ZwXR9QDDoMiR87H3E3hR4Nbubc
                        r1 = r0
                        r2 = r7
                        r1.<init>(r2, r3, r4, r5, r6)
                        r1 = 500(0x1f4, double:2.47E-321)
                        r8.postDelayed(r0, r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.a.e.a.AnonymousClass4.onClick(android.view.View):void");
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void a(k kVar, ChatGroupChannelDataModel chatGroupChannelDataModel, String str, int i2) {
                    if (kVar != null) {
                        if (a.this.f41074a == null) {
                            str = "User";
                        }
                        kVar.a(chatGroupChannelDataModel, str, i2);
                    }
                }
            });
            aVar.f41082i.getParent().requestDisallowInterceptTouchEvent(true);
            aVar.f41082i.setOnClickListener(new View.OnClickListener(kVar, chatGroupChannelDataModel, i2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ k f41096a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ ChatGroupChannelDataModel f41097b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ int f41098c;

                {
                    this.f41096a = r2;
                    this.f41097b = r3;
                    this.f41098c = r4;
                }

                public final void onClick(View view) {
                    a.this.l.a();
                    if (NetUtils.isNetWorkAvailable(e.this.f41063b)) {
                        String trim = a.this.f41074a.getText().toString().trim();
                        TwoButtonDialogUtil.showSystemDialog(e.this.f41063b, String.format(com.paytm.android.chat.c.a(R.string.chat_module_delete_chat_with, "Delete chat with %s ?"), new Object[]{trim}), com.paytm.android.chat.c.a(R.string.chat_module_cancel, "Cancel"), (DialogInterface.OnClickListener) null, com.paytm.android.chat.c.a(R.string.chat_module_delete, "Delete"), new DialogInterface.OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                if (AnonymousClass5.this.f41096a != null) {
                                    AnonymousClass5.this.f41096a.a(AnonymousClass5.this.f41097b, AnonymousClass5.this.f41098c + 1);
                                }
                            }
                        }, (DialogInterface.OnDismissListener) null);
                        return;
                    }
                    final ChatOneButtonDialog chatOneButtonDialog = new ChatOneButtonDialog(e.this.f41063b);
                    chatOneButtonDialog.hideTitle();
                    chatOneButtonDialog.setMessage(com.paytm.android.chat.c.a(R.string.chat_module_no_internet, "Check your internet connection and try again"));
                    chatOneButtonDialog.setButton(-3, com.paytm.android.chat.c.a(R.string.chat_module_button_ok, "ok"), new View.OnClickListener() {
                        public final void onClick(View view) {
                            chatOneButtonDialog.dismiss();
                        }
                    });
                    chatOneButtonDialog.show();
                }
            });
            if (chatGroupChannelDataModel.isPushEnabled()) {
                aVar.n.setVisibility(8);
                aVar.p.setImageResource(R.drawable.chat_icon_not_undisturb);
                aVar.k.setText("Mute");
            } else {
                aVar.n.setVisibility(0);
                aVar.p.setImageResource(R.drawable.ic_muted);
                aVar.k.setText("Muted");
            }
            if (chatGroupChannelDataModel.isPinned()) {
                aVar.o.setImageResource(R.drawable.ic_pinned);
                aVar.m.setVisibility(0);
                aVar.j.setText("Pinned");
            } else {
                aVar.o.setImageResource(R.drawable.ic_pin);
                aVar.m.setVisibility(8);
                aVar.j.setText("Pin");
            }
            aVar.f41078e.setOnClickListener(new View.OnClickListener(context) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Context f41103a;

                {
                    this.f41103a = r2;
                }

                public final void onClick(View view) {
                    if (FastClickUtil.isFastClick()) {
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.SEND");
                        intent.setType("text/plain");
                        intent.putExtra("android.intent.extra.TEXT", "Here is the Shared text.");
                        this.f41103a.startActivity(Intent.createChooser(intent, "Here is the title of Select box"));
                    }
                }
            });
            if (chatGroupChannelDataModel == null || chatGroupChannelDataModel.getLastMessage() == null) {
                aVar.r.setVisibility(8);
                return;
            }
            BaseMessage baseMessage2 = chatGroupChannelDataModel.getLastMessage().baseMessage;
            try {
                if (baseMessage2 instanceof UserMessage) {
                    z = ((UserMessage) baseMessage2).getSender().getUserId().equals(SharedPreferencesUtil.getUserId());
                } else if (baseMessage2 instanceof FileMessage) {
                    z = ((FileMessage) baseMessage2).getSender().getUserId().equals(SharedPreferencesUtil.getUserId());
                } else if (baseMessage2 instanceof AdminMessage) {
                    z = false;
                }
                if ("TRANSFER".equalsIgnoreCase(baseMessage2.getCustomType())) {
                    z = false;
                }
            } catch (Exception unused) {
            }
            if (z) {
                aVar.r.setVisibility(0);
                ChatMessageState chatMessageState = chatGroupChannelDataModel.getLastMessage().messageState;
                if (chatMessageState != null) {
                    if (chatMessageState == ChatMessageState.FAILED) {
                        aVar.r.setImageResource(R.drawable.chat_icon_group_chat_message_state_fail);
                    } else if (chatMessageState == ChatMessageState.SENDING) {
                        aVar.r.setImageResource(R.drawable.chat_icon_group_chat_message_state_send);
                    } else if (chatMessageState == ChatMessageState.SENT) {
                        aVar.r.setImageResource(R.drawable.chat_icon_group_chat_message_state_sent);
                    } else if (chatMessageState == ChatMessageState.DELIVERED) {
                        aVar.r.setImageResource(R.drawable.chat_icon_group_chat_message_state_arravl);
                    } else if (chatMessageState == ChatMessageState.READ) {
                        aVar.r.setImageResource(R.drawable.chat_icon_group_chat_message_state_read);
                    }
                }
                if (!chatGroupChannelDataModel.isTyping()) {
                    aVar.r.setVisibility(0);
                    return;
                }
            }
            aVar.r.setVisibility(8);
        } else if (vVar instanceof f) {
            FriendBean friendBean = (FriendBean) obj;
            f fVar = (f) vVar;
            fVar.f41115b.setText(friendBean.getName());
            fVar.f41114a.setUI(friendBean.getPhoto(), friendBean.getName());
            fVar.f41116c.setText(friendBean.getPreviewText());
            if (friendBean.isNew()) {
                fVar.f41117d.setVisibility(0);
            } else {
                fVar.f41117d.setVisibility(8);
            }
            if (e.this.f41068g.size() - 1 == i2) {
                fVar.f41118e.setVisibility(8);
            } else {
                fVar.f41118e.setVisibility(0);
            }
            fVar.itemView.setOnClickListener(new View.OnClickListener(friendBean, i2) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ FriendBean f41120a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ int f41121b;

                {
                    this.f41120a = r2;
                    this.f41121b = r3;
                }

                public final void onClick(View view) {
                    if (e.this.f41067f != null) {
                        e.this.f41067f.a(this.f41120a, this.f41121b);
                    }
                }
            });
        } else if (vVar instanceof C0689e) {
            SelectContactsBean selectContactsBean = (SelectContactsBean) obj;
            C0689e eVar = (C0689e) vVar;
            eVar.f41110c.setVisibility(8);
            eVar.f41109b.setText(selectContactsBean.getSendContactBean().getContactName());
            eVar.f41108a.setUI(selectContactsBean.getSendContactBean().getContactPic(), selectContactsBean.getSendContactBean().getContactName());
            eVar.itemView.setOnClickListener(new View.OnClickListener(selectContactsBean) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ SelectContactsBean f41112a;

                {
                    this.f41112a = r2;
                }

                public final void onClick(View view) {
                    if (e.this.f41066e != null) {
                        e.this.f41066e.a(this.f41112a);
                    }
                }
            });
        }
    }

    public final int getItemViewType(int i2) {
        Object obj = this.f41068g.get(i2);
        if (obj instanceof ChatHomeChip) {
            return 5;
        }
        if (obj instanceof ChatGroupChannelDataModel) {
            return 1;
        }
        if (obj instanceof FriendBean) {
            return 4;
        }
        if (obj instanceof SelectContactsBean) {
            return 2;
        }
        if (obj instanceof ChatChannelHeader) {
            return 6;
        }
        if (obj instanceof ChatFriendsHeader) {
            return 7;
        }
        return obj instanceof ChatContactHeader ? 8 : 3;
    }

    public final int getItemCount() {
        return this.f41068g.size();
    }

    public final void a(List<Object> list, h.b bVar) {
        this.f41068g.clear();
        this.f41068g.addAll(list);
        bVar.a((RecyclerView.a) this);
    }

    public final void a(j jVar) {
        this.f41064c = jVar;
    }

    public final void a(k kVar) {
        this.f41065d = kVar;
    }

    class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f41074a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41075b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41076c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41077d;

        /* renamed from: e  reason: collision with root package name */
        TextView f41078e;

        /* renamed from: f  reason: collision with root package name */
        ChatHeadView f41079f;

        /* renamed from: g  reason: collision with root package name */
        ConstraintLayout f41080g;

        /* renamed from: h  reason: collision with root package name */
        ConstraintLayout f41081h;

        /* renamed from: i  reason: collision with root package name */
        ConstraintLayout f41082i;
        TextView j;
        TextView k;
        SwipeMenuLayout l;
        ImageView m;
        ImageView n;
        ImageView o;
        ImageView p;
        ImageView q;
        ImageView r;
        View s;

        a(View view) {
            super(view);
            this.f41074a = (TextView) view.findViewById(R.id.text_group_channel_list_topic);
            this.f41075b = (TextView) view.findViewById(R.id.text_group_channel_list_message);
            this.f41076c = (TextView) view.findViewById(R.id.text_group_channel_list_unread_count);
            this.f41077d = (TextView) view.findViewById(R.id.text_group_channel_list_date);
            this.f41079f = (ChatHeadView) view.findViewById(R.id.image_group_channel_list_cover);
            this.f41080g = (ConstraintLayout) view.findViewById(R.id.placed_at_the_top);
            this.f41081h = (ConstraintLayout) view.findViewById(R.id.message_do_not_disturb);
            this.f41082i = (ConstraintLayout) view.findViewById(R.id.delete);
            this.m = (ImageView) view.findViewById(R.id.img_item_channel_top);
            this.n = (ImageView) view.findViewById(R.id.img_item_channel_mute);
            this.l = (SwipeMenuLayout) view.findViewById(R.id.channel_bg);
            this.f41078e = (TextView) view.findViewById(R.id.tv_item_invite_btn);
            this.o = (ImageView) view.findViewById(R.id.img_item_top);
            this.p = (ImageView) view.findViewById(R.id.img_item_mute);
            this.q = (ImageView) view.findViewById(R.id.image_chat_list_message_type_icon);
            this.r = (ImageView) view.findViewById(R.id.image_chat_list_message_status_icon);
            this.s = view.findViewById(R.id.divider);
            this.j = (TextView) view.findViewById(R.id.txt_item_top);
            this.k = (TextView) view.findViewById(R.id.txt_item_mute);
        }
    }

    /* renamed from: com.paytm.android.chat.a.e$e  reason: collision with other inner class name */
    class C0689e extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ChatHeadView f41108a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41109b;

        /* renamed from: c  reason: collision with root package name */
        LinearLayout f41110c;

        public C0689e(View view) {
            super(view);
            this.f41109b = (TextView) view.findViewById(R.id.text_group_contact_name);
            this.f41108a = (ChatHeadView) view.findViewById(R.id.image_group_channel_list_cover);
            this.f41110c = (LinearLayout) view.findViewById(R.id.header_container);
        }
    }

    class f extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ChatHeadView f41114a;

        /* renamed from: b  reason: collision with root package name */
        TextView f41115b;

        /* renamed from: c  reason: collision with root package name */
        TextView f41116c;

        /* renamed from: d  reason: collision with root package name */
        TextView f41117d;

        /* renamed from: e  reason: collision with root package name */
        View f41118e;

        public f(View view) {
            super(view);
            this.f41115b = (TextView) view.findViewById(R.id.text_group_contact_name);
            this.f41114a = (ChatHeadView) view.findViewById(R.id.image_group_channel_list_cover);
            this.f41116c = (TextView) view.findViewById(R.id.text_group_preview);
            this.f41117d = (TextView) view.findViewById(R.id.text_group_new);
            this.f41118e = view.findViewById(R.id.divider);
        }
    }

    class g extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RecyclerView f41123a;

        /* renamed from: b  reason: collision with root package name */
        LinearLayoutManager f41124b = new LinearLayoutManager(e.this.f41063b, 0, false);

        /* renamed from: c  reason: collision with root package name */
        g f41125c;

        public g(View view) {
            super(view);
            this.f41123a = (RecyclerView) view.findViewById(R.id.filter_chips);
            this.f41123a.setLayoutManager(this.f41124b);
            this.f41125c = new g(new ArrayList());
            this.f41123a.setAdapter(this.f41125c);
        }
    }

    class b extends RecyclerView.v {
        public b(View view) {
            super(view);
        }
    }

    class d extends RecyclerView.v {
        public d(View view) {
            super(view);
        }
    }

    class c extends RecyclerView.v {
        public c(View view) {
            super(view);
        }
    }
}
