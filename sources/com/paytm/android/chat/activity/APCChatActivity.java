package com.paytm.android.chat.activity;

import android.animation.TimeInterpolator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaScannerConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.al;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.transition.ChangeBounds;
import androidx.transition.Transition;
import com.airbnb.lottie.LottieAnimationView;
import com.alipay.mobile.h5container.api.H5Param;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.material.snackbar.Snackbar;
import com.imsdk.IMManager;
import com.imsdk.LoginInfo;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.a.b;
import com.paytm.android.chat.a.f;
import com.paytm.android.chat.a.j;
import com.paytm.android.chat.activity.APCProfileActivity;
import com.paytm.android.chat.base.APCBaseActivity;
import com.paytm.android.chat.bean.CTA;
import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.bean.ChatType;
import com.paytm.android.chat.bean.CtaType;
import com.paytm.android.chat.bean.FriendBean;
import com.paytm.android.chat.bean.ReceiverDisplayInfo;
import com.paytm.android.chat.bean.RegistrationStatus;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import com.paytm.android.chat.bean.daobean.SyncContactBean;
import com.paytm.android.chat.bean.jsonbean.AdminMessageBean;
import com.paytm.android.chat.bean.jsonbean.FileDataBean;
import com.paytm.android.chat.bean.jsonbean.KycInfo;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean;
import com.paytm.android.chat.bottomsheet.MenuItemBottomSheet;
import com.paytm.android.chat.bottomsheet.MerchantFirstUserChatBS;
import com.paytm.android.chat.d;
import com.paytm.android.chat.data.db.room.db_entities.ChatUserEntity;
import com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import com.paytm.android.chat.data.models.messages.ChatMessageUPIData;
import com.paytm.android.chat.data.models.messages.ChatTransferMessageDataModel;
import com.paytm.android.chat.data.models.users.ChatUserDataModel;
import com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse;
import com.paytm.android.chat.data.models.users.payments.UserInfoByIdsData;
import com.paytm.android.chat.data.repository.ChatRepository;
import com.paytm.android.chat.g.a;
import com.paytm.android.chat.h.a;
import com.paytm.android.chat.h.a.a;
import com.paytm.android.chat.network.response.ResponseOfRegister;
import com.paytm.android.chat.network.response.ResponseOfRegisterSendBird;
import com.paytm.android.chat.receiver.NetworkReceiver;
import com.paytm.android.chat.services.MediaPlayerService;
import com.paytm.android.chat.utils.AppUtilKt;
import com.paytm.android.chat.utils.CPCAudioAndTypingHandler;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.ChatNotificationHelper;
import com.paytm.android.chat.utils.ChatOneButtonDialog;
import com.paytm.android.chat.utils.ChatVariantUtilKt;
import com.paytm.android.chat.utils.ContactManager;
import com.paytm.android.chat.utils.DensityUtil;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.FileUtils;
import com.paytm.android.chat.utils.SharedPreferencesUtil;
import com.paytm.android.chat.view.AttachBottomSheet;
import com.paytm.android.chat.view.ChatHeadView;
import com.paytm.android.chat.view.PayButtonView;
import com.paytm.android.chat.view.ReplyView;
import com.paytm.android.chat.view.a.a;
import com.paytm.android.chat.view.input.ChatEditText;
import com.paytm.android.chat.view.kpswitch.b.b;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.FileMessage;
import com.sendbird.android.FileMessageParams;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.Member;
import com.sendbird.android.Sender;
import com.sendbird.android.User;
import com.sendbird.android.UserMessage;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.x;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.moneytransfer.requestmoney.CollectRequestType;
import net.one97.paytm.common.entity.moneytransfer.requestmoney.RequestMoneyActionModel;
import net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse;
import net.one97.paytm.upi.util.UpiConstants;

public final class APCChatActivity extends APCBaseActivity<com.paytm.android.chat.h.a, com.paytm.android.chat.g.a> implements NetworkReceiver.a {

    /* renamed from: g  reason: collision with root package name */
    public static final a f41472g = new a((byte) 0);
    private RelativeLayout A;
    private TextView B;
    private TextView C;
    private TextView D;
    private LinearLayout E;
    /* access modifiers changed from: private */
    public MenuItemBottomSheet F;
    /* access modifiers changed from: private */
    public TextView G;
    private PayButtonView H;
    private PayButtonView I;
    private ConstraintLayout J;
    /* access modifiers changed from: private */
    public View K;
    /* access modifiers changed from: private */
    public AttachBottomSheet L;
    private View M;
    /* access modifiers changed from: private */
    public LinearLayoutManager N;
    private com.paytm.android.chat.a.j O;
    private LinearLayoutManager P;
    /* access modifiers changed from: private */
    public LottieAnimationView Q;
    /* access modifiers changed from: private */
    public String R;
    private SyncContactBean S;
    /* access modifiers changed from: private */
    public String T;
    /* access modifiers changed from: private */
    public ChatOneButtonDialog U;
    /* access modifiers changed from: private */
    public SyncContactBean V;
    private com.paytm.android.chat.e.c W;
    private boolean X = true;
    private IJRDataModel Y;
    /* access modifiers changed from: private */
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public final String f41473a = "GroupChatActivity";
    /* access modifiers changed from: private */
    public boolean aA;
    private Handler aB = new Handler();
    private ServiceConnection aC = new ar(this);
    private int aD = R.layout.chat_apc_group_chat_activity;
    private HashMap aE;
    /* access modifiers changed from: private */
    public boolean aa;
    private final boolean ab;
    private boolean ac;
    /* access modifiers changed from: private */
    public boolean ad;
    /* access modifiers changed from: private */
    public boolean ae = true;
    /* access modifiers changed from: private */
    public com.paytm.android.chat.view.a.a af;
    private List<String> ag = new ArrayList();
    private String ah;
    private NetworkReceiver ai;
    private final com.paytm.android.chat.h aj = new com.paytm.android.chat.h();
    private boolean ak;
    private boolean al;
    private androidx.recyclerview.widget.l am;
    private RecyclerView an;
    /* access modifiers changed from: private */
    public com.paytm.android.chat.d ao;
    /* access modifiers changed from: private */
    public String ap = "";
    /* access modifiers changed from: private */
    public boolean aq;
    /* access modifiers changed from: private */
    public KycInfo ar;
    private boolean as;
    /* access modifiers changed from: private */
    public FriendBean at;
    private final boolean au = true;
    /* access modifiers changed from: private */
    public boolean av;
    /* access modifiers changed from: private */
    public String aw = "";
    /* access modifiers changed from: private */
    public String ax = "";
    private boolean ay;
    private boolean az;

    /* renamed from: b  reason: collision with root package name */
    MerchantFirstUserChatBS f41474b;

    /* renamed from: c  reason: collision with root package name */
    public com.paytm.android.chat.a.f f41475c;

    /* renamed from: d  reason: collision with root package name */
    public CPCAudioAndTypingHandler f41476d = new CPCAudioAndTypingHandler(new WeakReference(this));

    /* renamed from: e  reason: collision with root package name */
    public MediaPlayerService f41477e;

    /* renamed from: f  reason: collision with root package name */
    public com.paytm.android.chat.h.a f41478f;

    /* renamed from: i  reason: collision with root package name */
    private final String f41479i = "defaultMessageConsumed";
    private ChatHeadView j;
    private TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    private TextView m;
    private View n;
    /* access modifiers changed from: private */
    public RecyclerView o;
    /* access modifiers changed from: private */
    public ChatEditText p;
    /* access modifiers changed from: private */
    public ImageView q;
    private ImageView r;
    /* access modifiers changed from: private */
    public ReplyView s;
    /* access modifiers changed from: private */
    public TextView t;
    /* access modifiers changed from: private */
    public TextView u;
    private View v;
    private View w;
    private SwipeRefreshLayout x;
    private RecyclerView y;
    private FrameLayout z;

    static final class aq<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final aq f41509a = new aq();

        aq() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object obj) {
        }
    }

    static final class bi implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final bi f41538a = new bi();

        bi() {
        }

        public final void onClick(View view) {
        }
    }

    public final View a(int i2) {
        if (this.aE == null) {
            this.aE = new HashMap();
        }
        View view = (View) this.aE.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.aE.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class ac<T> implements io.reactivex.rxjava3.d.g<ChatGroupChannelDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41484a;

        ac(APCChatActivity aPCChatActivity) {
            this.f41484a = aPCChatActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            kotlin.g.b.k.c(chatGroupChannelDataModel, "result");
            if (!this.f41484a.isFinishing() || !this.f41484a.isDestroyed()) {
                APCChatActivity aPCChatActivity = this.f41484a;
                APCChatActivity.a(aPCChatActivity, chatGroupChannelDataModel, aPCChatActivity.V);
            }
        }
    }

    static final class ad<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41485a;

        ad(APCChatActivity aPCChatActivity) {
            this.f41485a = aPCChatActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            Throwable th = (Throwable) obj;
            if (!this.f41485a.isFinishing() && (th instanceof NetworkCustomError)) {
                NetworkCustomError networkCustomError = (NetworkCustomError) th;
                int statusCode = networkCustomError.getStatusCode();
                boolean z = true;
                if (statusCode == 410 || statusCode == 401 || statusCode == 403) {
                    APCChatActivity.i(this.f41485a);
                    new NetworkCustomError();
                    com.paytm.android.chat.e.a().a(this.f41485a, (String) null, false, true);
                    return;
                }
                CharSequence alertMessage = networkCustomError.getAlertMessage();
                if (!(alertMessage == null || alertMessage.length() == 0)) {
                    z = false;
                }
                if (z) {
                    this.f41485a.a("Oops! Something went wrong");
                } else {
                    this.f41485a.a(networkCustomError.getAlertMessage());
                }
                this.f41485a.finish();
            }
        }
    }

    static final class al<T, R> implements io.reactivex.rxjava3.d.h<T, io.reactivex.rxjava3.a.ac<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41502a;

        al(APCChatActivity aPCChatActivity) {
            this.f41502a = aPCChatActivity;
        }

        public final /* synthetic */ Object apply(Object obj) {
            final List list = (List) obj;
            if (this.f41502a.R != null) {
                com.paytm.android.chat.h.a b2 = this.f41502a.c();
                String c2 = this.f41502a.R;
                if (c2 == null) {
                    kotlin.g.b.k.a();
                }
                io.reactivex.rxjava3.a.y<R> b3 = b2.e(c2).b(new io.reactivex.rxjava3.d.h<T, R>() {
                    public final /* synthetic */ Object apply(Object obj) {
                        List list = list;
                        kotlin.g.b.k.a((Object) list, "userList");
                        return new kotlin.o(list, (ChatGroupChannelDataModel) obj);
                    }
                });
                kotlin.g.b.k.a((Object) list, "userList");
                return b3.b(new kotlin.o(list, null));
            }
            kotlin.g.b.k.a((Object) list, "userList");
            return io.reactivex.rxjava3.a.y.a(new kotlin.o(list, null));
        }
    }

    static final class am<T, R> implements io.reactivex.rxjava3.d.h<T, io.reactivex.rxjava3.a.ac<? extends R>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41504a;

        am(APCChatActivity aPCChatActivity) {
            this.f41504a = aPCChatActivity;
        }

        public final /* synthetic */ Object apply(Object obj) {
            final kotlin.o oVar = (kotlin.o) obj;
            if (this.f41504a.R == null) {
                return io.reactivex.rxjava3.a.y.a(new kotlin.s(oVar.getFirst(), oVar.getSecond(), null));
            }
            com.paytm.android.chat.h.a b2 = this.f41504a.c();
            String c2 = this.f41504a.R;
            if (c2 == null) {
                kotlin.g.b.k.a();
            }
            return b2.f(c2).b(new io.reactivex.rxjava3.d.h<T, R>() {
                public final /* synthetic */ Object apply(Object obj) {
                    return new kotlin.s(oVar.getFirst(), oVar.getSecond(), (GroupChannel) obj);
                }
            }).b(new kotlin.s(oVar.getFirst(), oVar.getSecond(), null));
        }
    }

    static final class an<T> implements io.reactivex.rxjava3.d.g<kotlin.s<? extends List<? extends User>, ? extends ChatGroupChannelDataModel, ? extends GroupChannel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41506a;

        an(APCChatActivity aPCChatActivity) {
            this.f41506a = aPCChatActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            kotlin.s sVar = (kotlin.s) obj;
            List list = (List) sVar.component1();
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) sVar.component2();
            GroupChannel groupChannel = (GroupChannel) sVar.component3();
            if (chatGroupChannelDataModel != null && groupChannel != null) {
                ChatUserDataModel a2 = this.f41506a.c().a(chatGroupChannelDataModel);
                if ((a2 != null ? a2.getSendbirdUserId() : null) != null && this.f41506a.l != null) {
                    boolean z = true;
                    if (list == null || !(!list.isEmpty())) {
                        this.f41506a.a(true);
                        APCChatActivity.a(this.f41506a, chatGroupChannelDataModel, groupChannel);
                        return;
                    }
                    int i2 = 0;
                    while (true) {
                        if (i2 >= list.size()) {
                            z = false;
                            break;
                        } else if (kotlin.g.b.k.a((Object) a2.getSendbirdUserId(), (Object) ((User) list.get(i2)).getUserId())) {
                            TextView K = this.f41506a.l;
                            if (K == null) {
                                kotlin.g.b.k.a();
                            }
                            K.setVisibility(8);
                            this.f41506a.a(false);
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        APCChatActivity.a(this.f41506a, chatGroupChannelDataModel, groupChannel);
                    }
                }
            }
        }
    }

    static final class ap<T> implements io.reactivex.rxjava3.d.g<UserExtendedMetaData> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41508a;

        ap(APCChatActivity aPCChatActivity) {
            this.f41508a = aPCChatActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            UserExtendedMetaData userExtendedMetaData = (UserExtendedMetaData) obj;
            kotlin.g.b.k.c(userExtendedMetaData, "result");
            try {
                APCChatActivity.a(this.f41508a, userExtendedMetaData);
            } catch (Exception unused) {
            }
        }
    }

    static final class aw extends kotlin.g.b.l implements kotlin.g.a.m<ResponseOfRegister, LoginInfo, kotlin.x> {
        final /* synthetic */ APCChatActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aw(APCChatActivity aPCChatActivity) {
            super(2);
            this.this$0 = aPCChatActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((ResponseOfRegister) obj, (LoginInfo) obj2);
            return kotlin.x.f47997a;
        }

        public final void invoke(ResponseOfRegister responseOfRegister, LoginInfo loginInfo) {
            APCChatActivity aPCChatActivity = this.this$0;
            APCChatActivity.a(aPCChatActivity, aPCChatActivity.getIntent(), false);
            this.this$0.c().f();
        }
    }

    static final class ax extends kotlin.g.b.l implements kotlin.g.a.m<Integer, String, kotlin.x> {
        final /* synthetic */ APCChatActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ax(APCChatActivity aPCChatActivity) {
            super(2);
            this.this$0 = aPCChatActivity;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((Integer) obj, (String) obj2);
            return kotlin.x.f47997a;
        }

        public final void invoke(Integer num, String str) {
            APCChatActivity aPCChatActivity = this.this$0;
            APCChatActivity.a(aPCChatActivity, aPCChatActivity.getIntent(), true);
            this.this$0.c().f();
        }
    }

    static final class az<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        public static final az f41522a = new az();

        az() {
        }

        public final /* synthetic */ Object apply(Object obj) {
            GetUserInfoByIdsResponse getUserInfoByIdsResponse = (GetUserInfoByIdsResponse) obj;
            kotlin.g.b.k.c(getUserInfoByIdsResponse, Payload.RESPONSE);
            if (getUserInfoByIdsResponse.getData() != null) {
                UserInfoByIdsData data = getUserInfoByIdsResponse.getData();
                Map<String, UsersInfoJsonBean> map = data != null ? data.getMap() : null;
                if (map == null || !(!map.isEmpty())) {
                    return new AbstractMap.SimpleEntry("0", (Object) null);
                }
                Iterator<Map.Entry<String, UsersInfoJsonBean>> it2 = map.entrySet().iterator();
                if (it2.hasNext()) {
                    return it2.next();
                }
                return null;
            }
            NetworkCustomError networkCustomError = new NetworkCustomError();
            networkCustomError.setStatusCode(getUserInfoByIdsResponse.getStatusCode());
            throw networkCustomError;
        }
    }

    static final class ba<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41524a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f41525b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ChatUserDataModel f41526c;

        ba(APCChatActivity aPCChatActivity, x.e eVar, ChatUserDataModel chatUserDataModel) {
            this.f41524a = aPCChatActivity;
            this.f41525b = eVar;
            this.f41526c = chatUserDataModel;
        }

        public final /* synthetic */ Object apply(Object obj) {
            String str;
            T t;
            Map.Entry entry = (Map.Entry) obj;
            kotlin.g.b.k.c(entry, H5Param.LONG_URL_WITH_ENTRY_KEY);
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                APCChatActivity aPCChatActivity = this.f41524a;
                UsersInfoJsonBean usersInfoJsonBean = (UsersInfoJsonBean) entry.getValue();
                if (usersInfoJsonBean == null || (str = usersInfoJsonBean.getCustomerCreationText()) == null) {
                    str = "";
                }
                aPCChatActivity.ap = str;
                APCChatActivity aPCChatActivity2 = this.f41524a;
                UsersInfoJsonBean usersInfoJsonBean2 = (UsersInfoJsonBean) entry.getValue();
                aPCChatActivity2.aq = usersInfoJsonBean2 != null ? usersInfoJsonBean2.isKyc() : false;
                APCChatActivity aPCChatActivity3 = this.f41524a;
                UsersInfoJsonBean usersInfoJsonBean3 = (UsersInfoJsonBean) entry.getValue();
                aPCChatActivity3.ar = usersInfoJsonBean3 != null ? usersInfoJsonBean3.getKycInfo() : null;
                com.paytm.android.chat.h.a b2 = this.f41524a.c();
                Object key = entry.getKey();
                if (key == null) {
                    kotlin.g.b.k.a();
                }
                String str2 = (String) key;
                Object value = entry.getValue();
                if (value == null) {
                    kotlin.g.b.k.a();
                }
                UsersInfoJsonBean usersInfoJsonBean4 = (UsersInfoJsonBean) value;
                kotlin.g.b.k.c(str2, "sendbirdId");
                kotlin.g.b.k.c(usersInfoJsonBean4, "userInfo");
                ChatUserEntity constructChatUserEntity = b2.f42174i.constructChatUserEntity(str2, usersInfoJsonBean4);
                com.paytm.android.chat.h.a b3 = this.f41524a.c();
                List a2 = kotlin.a.k.a(constructChatUserEntity);
                kotlin.g.b.k.c(a2, "list");
                b3.f42174i.updateUsersThroughEntity(a2);
                String str3 = b3.f42169d;
                if (str3 == null || (t = b3.f42174i.getLocalChannelByIdBlocking(str3)) == null) {
                    t = null;
                } else {
                    b3.f42166a = t;
                }
                if (t != null) {
                    this.f41525b.element = t;
                }
            }
            APCChatActivity.a(this.f41524a, this.f41526c, entry);
            return entry;
        }
    }

    static final class bb<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatUserDataModel f41527a;

        bb(ChatUserDataModel chatUserDataModel) {
            this.f41527a = chatUserDataModel;
        }

        public final /* synthetic */ Object apply(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            SyncContactBean searchContactById = ContactManager.getInstance().searchContactById(this.f41527a.getSendbirdUserId());
            if (searchContactById != null) {
                searchContactById.setPtPic(this.f41527a.getAvatarUrl());
                ContactManager.getInstance().upContact(searchContactById);
            }
            return new kotlin.o(searchContactById, entry);
        }
    }

    static final class bc<T> implements io.reactivex.rxjava3.d.g<kotlin.o<? extends SyncContactBean, ? extends Map.Entry<? extends String, ? extends UsersInfoJsonBean>>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41528a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f41529b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.paytm.android.chat.e.c f41530c;

        bc(APCChatActivity aPCChatActivity, x.e eVar, com.paytm.android.chat.e.c cVar) {
            this.f41528a = aPCChatActivity;
            this.f41529b = eVar;
            this.f41530c = cVar;
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.android.chat.e.c cVar;
            kotlin.o oVar = (kotlin.o) obj;
            kotlin.g.b.k.c(oVar, H5Param.LONG_URL_WITH_ENTRY_KEY);
            this.f41528a.a((ChatGroupChannelDataModel) this.f41529b.element, (SyncContactBean) oVar.getFirst());
            Map.Entry entry = (Map.Entry) oVar.getSecond();
            entry.getValue();
            if (kotlin.g.b.k.a((Object) (String) entry.getKey(), (Object) "0") && (cVar = this.f41530c) != null) {
                cVar.b();
            }
            com.paytm.android.chat.e.c cVar2 = this.f41530c;
            if (cVar2 != null) {
                cVar2.a();
            }
        }
    }

    static final class bd<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41531a;

        bd(APCChatActivity aPCChatActivity) {
            this.f41531a = aPCChatActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            Throwable th = (Throwable) obj;
            if (th instanceof NetworkCustomError) {
                int statusCode = ((NetworkCustomError) th).getStatusCode();
                com.paytm.utility.q.a("====code ===" + statusCode + "=====add user info fail ");
                if (statusCode == 410 || statusCode == 401 || statusCode == 403) {
                    APCChatActivity.i(this.f41531a);
                    new NetworkCustomError();
                    com.paytm.android.chat.e.a().a(this.f41531a, (String) null, false, true);
                }
            }
        }
    }

    static final class y<T, R> implements io.reactivex.rxjava3.d.h<T, R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41563a;

        y(APCChatActivity aPCChatActivity) {
            this.f41563a = aPCChatActivity;
        }

        public final /* synthetic */ Object apply(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            this.f41563a.V = ContactManager.getInstance().searchContactDBByUrl(this.f41563a.R);
            return chatGroupChannelDataModel;
        }
    }

    static final class z<T> implements io.reactivex.rxjava3.d.g<ChatGroupChannelDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41564a;

        z(APCChatActivity aPCChatActivity) {
            this.f41564a = aPCChatActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = (ChatGroupChannelDataModel) obj;
            kotlin.g.b.k.c(chatGroupChannelDataModel, "result");
            if (!this.f41564a.isFinishing() || !this.f41564a.isDestroyed()) {
                if (this.f41564a.T != null && kotlin.m.p.a(this.f41564a.T, "fromFCM", true)) {
                    ChatAnalyticsHelperKt.fireOpenFromNotificationEvent(this.f41564a, chatGroupChannelDataModel.getReceiverDisplayInfo().getChatType().name());
                }
                APCChatActivity aPCChatActivity = this.f41564a;
                APCChatActivity.a(aPCChatActivity, chatGroupChannelDataModel, aPCChatActivity.V);
            }
        }
    }

    public final /* synthetic */ void a(com.paytm.android.chat.base.e eVar) {
        Intent intent;
        ReplyView replyView;
        com.paytm.android.chat.g.a aVar = (com.paytm.android.chat.g.a) eVar;
        kotlin.g.b.k.c(aVar, "state");
        if (aVar instanceof a.C0697a) {
            ChatGroupChannelDataModel chatGroupChannelDataModel = ((a.C0697a) aVar).f42101a;
            if (chatGroupChannelDataModel != null) {
                com.paytm.android.chat.a.f fVar = this.f41475c;
                if (fVar != null) {
                    fVar.a(chatGroupChannelDataModel);
                    k();
                }
                a(chatGroupChannelDataModel);
            }
        } else if (aVar instanceof a.d) {
            finish();
        } else if (aVar instanceof a.b) {
            this.ay = ((a.b) aVar).f42106a;
        } else if (aVar instanceof a.j) {
            String str = ((a.j) aVar).f42121a;
            com.paytm.android.chat.a.f fVar2 = this.f41475c;
            if (fVar2 != null) {
                fVar2.b(str);
            }
        } else if (aVar instanceof a.aa) {
            com.paytm.android.chat.a.f fVar3 = this.f41475c;
            if (fVar3 != null) {
                fVar3.a(((a.aa) aVar).f42102a);
            }
        } else if (aVar instanceof a.z) {
            a.z zVar = (a.z) aVar;
            T t2 = zVar.f42141b;
            if (t2 != null) {
                ChatUserDataModel chatUserDataModel = zVar.f42140a;
                com.paytm.android.chat.e.c cVar = zVar.f42142c;
                if (chatUserDataModel != null) {
                    x.e eVar2 = new x.e();
                    eVar2.element = t2;
                    this.az = chatUserDataModel.isBlockedByMe();
                    ReplyView replyView2 = this.s;
                    if (!(replyView2 == null || replyView2 == null)) {
                        replyView2.setOtherId(chatUserDataModel.getSendbirdUserId());
                    }
                    com.paytm.android.chat.a.f fVar4 = this.f41475c;
                    if (fVar4 != null) {
                        fVar4.a(chatUserDataModel);
                    }
                    a((ChatGroupChannelDataModel) eVar2.element);
                    this.W = cVar;
                    if (!isFinishing()) {
                        try {
                            com.paytm.utility.q.a("====get user info" + chatUserDataModel.getSendbirdUserId());
                            if (((ChatGroupChannelDataModel) eVar2.element).getReceiverDisplayInfo().getRegistrationStatus() != RegistrationStatus.NOT_ON_PAYTM) {
                                com.paytm.android.chat.h.a b2 = c();
                                String sendbirdUserId = chatUserDataModel.getSendbirdUserId();
                                if (sendbirdUserId == null) {
                                    kotlin.g.b.k.a();
                                }
                                b2.b(sendbirdUserId).b(az.f41522a).b(new ba(this, eVar2, chatUserDataModel)).b(new bb(chatUserDataModel)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new bc(this, eVar2, cVar), (io.reactivex.rxjava3.d.g<? super Throwable>) new bd(this));
                                if (this.l != null) {
                                    m();
                                }
                            } else if (cVar != null) {
                                cVar.b();
                            }
                        } catch (Exception unused) {
                            com.paytm.utility.q.a("===========change id error ");
                        }
                    }
                }
            }
        } else if (aVar instanceof a.y) {
            a(((a.y) aVar).f42139a);
        } else {
            boolean z2 = false;
            if (aVar instanceof a.t) {
                View view = this.w;
                if (view != null) {
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    ConstraintLayout constraintLayout = this.J;
                    if (constraintLayout != null) {
                        constraintLayout.setVisibility(8);
                    }
                    a(false);
                    return;
                }
                return;
            }
            String str2 = null;
            if (aVar instanceof a.s) {
                if (((a.s) aVar).f42133a) {
                    FrameLayout frameLayout = this.z;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    RelativeLayout relativeLayout = this.A;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(0);
                    }
                    ReceiverDisplayInfo e2 = c().e();
                    TextView textView = this.B;
                    if (textView != null) {
                        textView.setText(e2 != null ? e2.getName() : null);
                    }
                    TextView textView2 = this.C;
                    if (textView2 != null) {
                        if (e2 != null) {
                            str2 = e2.getPhoneNumber();
                        }
                        textView2.setText(str2);
                    }
                    if (!this.ac) {
                        this.ac = true;
                        ChatGroupChannelDataModel chatGroupChannelDataModel2 = c().f42166a;
                        if (chatGroupChannelDataModel2 != null) {
                            ChatAnalyticsHelperKt.fireChatScreenLoadEvent(this, this.ab, chatGroupChannelDataModel2);
                        }
                    }
                    i();
                    return;
                }
                FrameLayout frameLayout2 = this.z;
                if (frameLayout2 != null) {
                    frameLayout2.setVisibility(0);
                }
                RelativeLayout relativeLayout2 = this.A;
                if (relativeLayout2 != null) {
                    relativeLayout2.setVisibility(8);
                }
                if (!this.ac) {
                    this.ac = true;
                    ChatGroupChannelDataModel chatGroupChannelDataModel3 = c().f42166a;
                    if (chatGroupChannelDataModel3 != null) {
                        ChatAnalyticsHelperKt.fireChatScreenLoadEvent(this, this.ab, chatGroupChannelDataModel3);
                    }
                }
            } else if (aVar instanceof a.p) {
                a.p pVar = (a.p) aVar;
                boolean z3 = pVar.f42129a;
                String[] strArr = pVar.f42130b;
                if (!z3 || strArr == null) {
                    this.al = false;
                    RecyclerView recyclerView = this.y;
                    if (recyclerView != null) {
                        recyclerView.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.al = true;
                RecyclerView recyclerView2 = this.y;
                if (recyclerView2 != null) {
                    recyclerView2.setVisibility(0);
                }
                com.paytm.android.chat.a.j jVar = this.O;
                if (jVar == null) {
                    kotlin.g.b.k.a();
                }
                jVar.a((List<String>) Arrays.asList((String[]) Arrays.copyOf(strArr, strArr.length)));
            } else if (aVar instanceof a.f) {
                a.f fVar5 = (a.f) aVar;
                ChatAnalyticsHelperKt.fireMessageSendingFailedEvent(this, fVar5.f42110a, fVar5.f42111b);
            } else if (aVar instanceof a.u) {
                a(((a.u) aVar).f42135a);
            } else if (aVar instanceof a.g) {
                a.g gVar = (a.g) aVar;
                ChatAnalyticsHelperKt.fireMessageSentEvent(this, gVar.f42112a, gVar.f42113b, gVar.f42114c);
            } else if (aVar instanceof a.q) {
                boolean z4 = ((a.q) aVar).f42131a;
                SwipeRefreshLayout swipeRefreshLayout = this.x;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(z4);
                }
            } else if (aVar instanceof a.l) {
                com.paytm.android.chat.a.f fVar6 = this.f41475c;
                if (fVar6 != null) {
                    fVar6.a();
                }
            } else if (aVar instanceof a.v) {
                c(((a.v) aVar).f42136a);
            } else if (aVar instanceof a.e) {
                com.paytm.android.chat.a.f fVar7 = this.f41475c;
                if (fVar7 != null) {
                    fVar7.c();
                }
                com.paytm.android.chat.view.a.a aVar2 = this.af;
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            } else if (aVar instanceof a.c) {
            } else {
                if (aVar instanceof a.r) {
                    FileMessage fileMessage = ((a.r) aVar).f42132a;
                    if (r()) {
                        Context context = this;
                        kotlin.g.b.k.c(context, "context");
                        Object systemService = context.getSystemService("connectivity");
                        if (systemService != null) {
                            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                                z2 = true;
                            }
                            if (!z2) {
                                ChatOneButtonDialog chatOneButtonDialog = new ChatOneButtonDialog(context);
                                chatOneButtonDialog.hideTitle();
                                Resources resources = getResources();
                                chatOneButtonDialog.setMessage(resources != null ? resources.getString(R.string.chat_module_no_internet) : null);
                                Resources resources2 = getResources();
                                if (resources2 != null) {
                                    str2 = resources2.getString(R.string.chat_module_button_ok);
                                }
                                chatOneButtonDialog.setButton(-3, str2, new bf(chatOneButtonDialog));
                                chatOneButtonDialog.show();
                            } else if (fileMessage != null) {
                                c().a(fileMessage, true);
                            }
                        } else {
                            throw new kotlin.u("null cannot be cast to non-null type android.net.ConnectivityManager");
                        }
                    }
                } else if (aVar instanceof a.m) {
                    r();
                } else if (aVar instanceof a.n) {
                    com.paytm.android.chat.a.f fVar8 = this.f41475c;
                    if (fVar8 != null && (replyView = this.s) != null) {
                        replyView.postDelayed(new bg(fVar8), 50);
                    }
                } else if (aVar instanceof a.x) {
                    File file = ((a.x) aVar).f42138a;
                    try {
                        MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), (String) null);
                    } catch (Exception unused2) {
                    }
                    if (Build.VERSION.SDK_INT >= 19) {
                        MediaScannerConnection.scanFile(this, new String[]{file.getAbsolutePath()}, (String[]) null, (MediaScannerConnection.OnScanCompletedListener) null);
                        return;
                    }
                    if (file.isDirectory()) {
                        intent = new Intent("android.intent.action.MEDIA_MOUNTED");
                        intent.setClassName("com.android.providers.media", "com.android.providers.media.MediaScannerReceiver");
                        intent.setData(Uri.fromFile(Environment.getExternalStorageDirectory()));
                    } else {
                        Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent2.setData(Uri.fromFile(file));
                        intent = intent2;
                    }
                    sendBroadcast(intent);
                } else if (aVar instanceof a.o) {
                    a.o oVar = (a.o) aVar;
                    int i2 = oVar.f42127a;
                    FileMessage fileMessage2 = oVar.f42128b;
                    com.paytm.android.chat.a.f fVar9 = this.f41475c;
                    if (fVar9 != null && fVar9 != null) {
                        fVar9.a(fileMessage2.getRequestId(), i2);
                    }
                } else if (aVar instanceof a.ab) {
                    File file2 = ((a.ab) aVar).f42103a;
                    if (r()) {
                        try {
                            if (file2.exists()) {
                                String name = file2.getName();
                                kotlin.g.b.k.a((Object) name, "file.name");
                                if (kotlin.m.p.c(name, "apk", false)) {
                                    a(getString(R.string.chat_not_open_type_file));
                                    return;
                                }
                                if (!isDestroyed() && !isFinishing()) {
                                    z2 = true;
                                }
                                if (z2) {
                                    Intent intent3 = new Intent();
                                    intent3.addFlags(1);
                                    intent3.setAction("android.intent.action.VIEW");
                                    intent3.setDataAndType(FileUtils.getUriByFile(this, file2), FileUtils.getMIMEType(file2));
                                    startActivity(intent3);
                                }
                            }
                        } catch (Exception unused3) {
                            a(getString(R.string.chat_module_open_file_error));
                        }
                    }
                } else if (aVar instanceof a.ac) {
                    if (!this.aA) {
                        a.ac acVar = (a.ac) aVar;
                        ArrayList<com.zhihu.matisse.a.a> arrayList = acVar.f42104a;
                        int i3 = acVar.f42105b;
                        if (r()) {
                            com.paytm.android.chat.f.a.a(this, i3, arrayList);
                        }
                        c().f42171f.onNext(new a.h());
                        com.paytm.android.chat.h.a b3 = c();
                        b3.f42171f = null;
                        b3.f42171f = io.reactivex.rxjava3.j.a.a();
                        this.aA = true;
                    }
                } else if (aVar instanceof a.i) {
                    a.i iVar = (a.i) aVar;
                    ChatGroupChannelDataModel chatGroupChannelDataModel4 = iVar.f42116a;
                    List<ChatMessageDataModel> list = iVar.f42117b;
                    h.b bVar = iVar.f42118c;
                    boolean z5 = iVar.f42119d;
                    boolean z6 = iVar.f42120e;
                    com.paytm.android.chat.a.f fVar10 = this.f41475c;
                    if (fVar10 != null) {
                        LinearLayoutManager linearLayoutManager = this.N;
                        if (linearLayoutManager != null) {
                            if (list.size() < 10) {
                                z2 = true;
                            }
                            linearLayoutManager.setStackFromEnd(z2);
                        }
                        fVar10.a(chatGroupChannelDataModel4);
                        fVar10.a(list, bVar);
                        runOnUiThread(new ay(this, list, chatGroupChannelDataModel4, bVar, z6, z5));
                    }
                } else if (aVar instanceof a.w) {
                    if (((a.w) aVar).f42137a) {
                        h();
                    } else {
                        i();
                    }
                } else if (aVar instanceof a.k) {
                    a.k kVar = (a.k) aVar;
                    String str3 = kVar.f42122a;
                    String str4 = kVar.f42123b;
                    if (r()) {
                        if (this.f41477e == null || !this.ad) {
                            Intent intent4 = new Intent(this, MediaPlayerService.class);
                            intent4.putExtra("url", str3);
                            this.ad = bindService(intent4, this.aC, 1);
                            this.aw = str3;
                            this.ax = str4;
                        } else {
                            if ((!kotlin.g.b.k.a((Object) this.aw, (Object) str3)) || (!kotlin.g.b.k.a((Object) this.ax, (Object) str4))) {
                                MediaPlayerService mediaPlayerService = this.f41477e;
                                if (mediaPlayerService != null) {
                                    mediaPlayerService.a(str3);
                                }
                                this.aw = str3;
                                this.ax = str4;
                            } else {
                                MediaPlayerService mediaPlayerService2 = this.f41477e;
                                if (mediaPlayerService2 != null) {
                                    mediaPlayerService2.a();
                                }
                            }
                            MediaPlayerService mediaPlayerService3 = this.f41477e;
                            if (mediaPlayerService3 != null) {
                                mediaPlayerService3.a((MediaPlayerService.a) new au(this));
                            }
                        }
                        this.f41476d.removeMessages(1);
                        this.f41476d.sendEmptyMessageDelayed(1, 500);
                    }
                }
            }
        }
    }

    public static final class ar implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41510a;

        ar(APCChatActivity aPCChatActivity) {
            this.f41510a = aPCChatActivity;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            kotlin.g.b.k.c(componentName, "componentName");
            kotlin.g.b.k.c(iBinder, "iBinder");
            if (iBinder instanceof MediaPlayerService.b) {
                this.f41510a.f41477e = ((MediaPlayerService.b) iBinder).a();
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            kotlin.g.b.k.c(componentName, "componentName");
            MediaPlayerService mediaPlayerService = this.f41510a.f41477e;
            if (mediaPlayerService != null) {
                mediaPlayerService.f();
            }
        }
    }

    public final int a() {
        return this.aD;
    }

    /* renamed from: b */
    public final com.paytm.android.chat.h.a c() {
        com.paytm.android.chat.h.a aVar = this.f41478f;
        if (aVar == null) {
            kotlin.g.b.k.a("viewModel");
        }
        return aVar;
    }

    public final void e() {
        a.C0701a aVar = com.paytm.android.chat.h.a.a.f42178a;
        Application application = getApplication();
        kotlin.g.b.k.a((Object) application, "application");
        String g2 = com.paytm.android.chat.c.g();
        kotlin.g.b.k.a((Object) g2, "ChatApplication.getAppId()");
        androidx.lifecycle.ai a2 = new androidx.lifecycle.al((androidx.lifecycle.ao) this, (al.b) a.C0701a.a(application, g2)).a(com.paytm.android.chat.h.a.class);
        kotlin.g.b.k.a((Object) a2, "ViewModelProvider(this, …et(VPCChatVM::class.java)");
        com.paytm.android.chat.h.a aVar2 = (com.paytm.android.chat.h.a) a2;
        kotlin.g.b.k.c(aVar2, "<set-?>");
        this.f41478f = aVar2;
        String stringExtra = getIntent().getStringExtra("groupChannelUrl");
        if (stringExtra != null) {
            this.R = stringExtra;
            c().a(stringExtra);
        }
        Parcelable parcelableExtra = getIntent().getParcelableExtra("friend");
        if (!(parcelableExtra instanceof FriendBean)) {
            parcelableExtra = null;
        }
        this.at = (FriendBean) parcelableExtra;
    }

    public final void onResume() {
        super.onResume();
        this.aB.postDelayed(new as(this), 300);
        IMManager.getInstance().currentUrl = this.R;
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.a(this.R);
        c().f();
        Context context = this;
        ChatNotificationHelper.INSTANCE.clearAllNotification(context);
        if (this.l != null) {
            m();
        }
        com.paytm.android.chat.a.f fVar = this.f41475c;
        if (fVar != null) {
            fVar.a(context);
        }
        com.paytm.utility.q.d(this.R);
        registerReceiver(this.ai, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    static final class as implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41511a;

        as(APCChatActivity aPCChatActivity) {
            this.f41511a = aPCChatActivity;
        }

        public final void run() {
            this.f41511a.aA = false;
        }
    }

    public final void onPause() {
        com.paytm.android.chat.h.a b2 = c();
        io.reactivex.rxjava3.b.c cVar = b2.f42170e;
        if (cVar != null) {
            cVar.dispose();
        }
        if (b2.f42166a != null) {
            String str = b2.f42169d;
            if (str == null) {
                kotlin.g.b.k.a();
            }
            if (com.paytm.android.chat.d.a.b.a(str) != null) {
                ChatManager b3 = ChatManager.b();
                kotlin.g.b.k.a((Object) b3, "ChatManager.getInstance()");
                ChatRepository a2 = b3.a();
                String str2 = b2.f42169d;
                if (str2 == null) {
                    kotlin.g.b.k.a();
                }
                GroupChannel a3 = com.paytm.android.chat.d.a.b.a(str2);
                if (a3 == null) {
                    kotlin.g.b.k.a();
                }
                a2.updateLocalChannel((BaseChannel) a3);
            }
        }
        b2.a(false);
        b2.c();
        b2.d();
        if (this.R != null) {
            String l2 = l();
            c();
            String str3 = this.R;
            if (str3 == null) {
                kotlin.g.b.k.a();
            }
            com.paytm.android.chat.h.a.a(str3, l2);
        }
        s();
        unregisterReceiver(this.ai);
        super.onPause();
    }

    public final void onDestroy() {
        if (this.ad) {
            unbindService(this.aC);
        }
        this.f41476d.removeCallbacksAndMessages((Object) null);
        super.onDestroy();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "outState");
        bundle.putString("STATE_CHANNEL_URL", this.R);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Bundle bundle) {
        kotlin.g.b.k.c(bundle, "savedInstanceState");
        super.onRestoreInstanceState(bundle);
        this.as = bundle.getBoolean(this.f41479i, false);
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.V = null;
        j();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01f8, code lost:
        if (r7 != null) goto L_0x01e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01f3 A[SYNTHETIC, Splitter:B:110:0x01f3] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x02f1 A[SYNTHETIC, Splitter:B:170:0x02f1] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x02f8 A[SYNTHETIC, Splitter:B:177:0x02f8] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0329  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0334  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityResult(int r18, int r19, android.content.Intent r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            r3 = r20
            super.onActivityResult(r18, r19, r20)
            r4 = 0
            r5 = -1
            if (r2 != r5) goto L_0x0020
            r6 = 3
            if (r0 != r6) goto L_0x0020
            if (r3 == 0) goto L_0x002d
            java.lang.String r6 = "is_pay_operation"
            boolean r6 = r3.getBooleanExtra(r6, r4)
            if (r6 == 0) goto L_0x002d
            r17.n()
            goto L_0x002d
        L_0x0020:
            r6 = 306(0x132, float:4.29E-43)
            if (r0 != r6) goto L_0x002d
            if (r2 != r5) goto L_0x002d
            com.paytm.android.chat.a.f r6 = r1.f41475c
            if (r6 == 0) goto L_0x002d
            r6.a()
        L_0x002d:
            r6 = 2002(0x7d2, float:2.805E-42)
            r7 = 1
            java.lang.String r8 = ""
            if (r0 != r6) goto L_0x00ea
            com.paytm.android.chat.view.PayButtonView r6 = r1.H
            if (r6 == 0) goto L_0x0059
            int r9 = com.paytm.android.chat.R.id.buttonLoader
            android.view.View r9 = r6.a((int) r9)
            android.widget.ProgressBar r9 = (android.widget.ProgressBar) r9
            if (r9 == 0) goto L_0x0047
            android.view.View r9 = (android.view.View) r9
            com.paytm.android.chat.f.a((android.view.View) r9, (boolean) r4)
        L_0x0047:
            int r9 = com.paytm.android.chat.R.id.buttonText
            android.view.View r9 = r6.a((int) r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            if (r9 == 0) goto L_0x0056
            android.view.View r9 = (android.view.View) r9
            com.paytm.android.chat.f.a((android.view.View) r9, (boolean) r7)
        L_0x0056:
            r6.setEnabled(r7)
        L_0x0059:
            if (r3 == 0) goto L_0x00ea
            java.lang.String r6 = "post_txn_failure"
            boolean r9 = r3.hasExtra(r6)
            if (r9 == 0) goto L_0x0090
            java.io.Serializable r6 = r3.getSerializableExtra(r6)
            boolean r9 = r6 instanceof net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse
            if (r9 == 0) goto L_0x00ea
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse r6 = (net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse) r6
            java.lang.String r9 = r1.R
            if (r9 == 0) goto L_0x00ea
            if (r6 == 0) goto L_0x0084
            com.paytm.android.chat.bean.jsonbean.TxNotifyData$Companion r9 = com.paytm.android.chat.bean.jsonbean.TxNotifyData.Companion
            java.lang.String r10 = r1.R
            if (r10 != 0) goto L_0x007c
            kotlin.g.b.k.a()
        L_0x007c:
            com.paytm.android.chat.bean.jsonbean.TxNotifyData r6 = r9.createFromPaymentResponse(r10, r6)
            r1.a((com.paytm.android.chat.bean.jsonbean.TxNotifyData) r6)
            goto L_0x00ea
        L_0x0084:
            java.lang.String r6 = "#FD5154"
            int r6 = android.graphics.Color.parseColor(r6)
            java.lang.String r9 = "Payment transaction failed"
            r1.a((java.lang.String) r9, (int) r6)
            goto L_0x00ea
        L_0x0090:
            java.lang.String r6 = "post_txn_response"
            boolean r9 = r3.hasExtra(r6)
            if (r9 == 0) goto L_0x00ea
            java.io.Serializable r6 = r3.getSerializableExtra(r6)
            boolean r9 = r6 instanceof net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse
            if (r9 == 0) goto L_0x00ea
            net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse r6 = (net.one97.paytm.common.entity.wallet.chatintegration.MTSDKPostPaymentResponse) r6
            java.lang.String r9 = r1.R
            if (r9 == 0) goto L_0x00b8
            if (r6 == 0) goto L_0x00b8
            com.paytm.android.chat.bean.jsonbean.TxNotifyData$Companion r9 = com.paytm.android.chat.bean.jsonbean.TxNotifyData.Companion
            java.lang.String r10 = r1.R
            if (r10 != 0) goto L_0x00b1
            kotlin.g.b.k.a()
        L_0x00b1:
            com.paytm.android.chat.bean.jsonbean.TxNotifyData r9 = r9.createFromPaymentResponse(r10, r6)
            r1.a((com.paytm.android.chat.bean.jsonbean.TxNotifyData) r9)
        L_0x00b8:
            com.paytm.android.chat.h.a r9 = r17.c()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r9 = r9.e()
            if (r9 == 0) goto L_0x00ea
            com.paytm.android.chat.bean.ChatType r9 = r9.getChatType()
            if (r9 == 0) goto L_0x00ea
            java.lang.String r9 = r9.name()
            if (r9 == 0) goto L_0x00ea
            r10 = r1
            android.content.Context r10 = (android.content.Context) r10
            net.one97.paytm.p2p.theme.ThemeData r11 = r6.getThemeData()
            if (r11 == 0) goto L_0x00dd
            java.lang.String r11 = r11.getThemeName()
            if (r11 != 0) goto L_0x00de
        L_0x00dd:
            r11 = r8
        L_0x00de:
            java.lang.String r6 = r6.getComment()
            if (r6 != 0) goto L_0x00e5
            r6 = r8
        L_0x00e5:
            java.lang.String r12 = "Payment Success"
            com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireMTPaymentSuccessEvent(r10, r12, r9, r11, r6)
        L_0x00ea:
            if (r3 != 0) goto L_0x00f2
            java.lang.String r0 = "data is null!"
            com.paytm.utility.q.d(r0)
            return
        L_0x00f2:
            android.widget.ImageView r6 = r1.r
            r9 = 2
            float[] r9 = new float[r9]
            r9 = {0, 0} // fill-array
            java.lang.String r10 = "rotation"
            android.animation.ObjectAnimator r6 = android.animation.ObjectAnimator.ofFloat(r6, r10, r9)
            r9 = 0
            android.animation.ObjectAnimator r6 = r6.setDuration(r9)
            r6.start()
            r6 = 301(0x12d, float:4.22E-43)
            r9 = 0
            if (r0 != r6) goto L_0x0178
            if (r2 != r5) goto L_0x0178
            com.paytm.android.chat.a.f r0 = r1.f41475c
            if (r0 == 0) goto L_0x0117
            r0.d()
        L_0x0117:
            java.util.List r0 = com.paytm.android.chat.f.a.d(r20)
            java.util.Iterator r0 = r0.iterator()
        L_0x011f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x044e
            java.lang.Object r2 = r0.next()
            com.zhihu.matisse.internal.entity.Item r2 = (com.zhihu.matisse.internal.entity.Item) r2
            java.lang.String r3 = "item"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            boolean r3 = r2.b()
            if (r3 == 0) goto L_0x015c
            java.io.File r3 = new java.io.File
            java.lang.String r4 = com.paytm.android.chat.utils.FileUtils.getAbsCameraPath()
            java.lang.String r5 = r2.c()
            r3.<init>(r4, r5)
            com.paytm.android.chat.h.a r4 = r17.c()
            android.net.Uri r5 = android.net.Uri.fromFile(r3)
            java.lang.String r5 = r5.toString()
            java.lang.String r6 = "Uri.fromFile(file).toString()"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r2 = r2.e()
            r4.a((java.lang.String) r5, (java.lang.String) r2, (java.io.File) r3)
            goto L_0x011f
        L_0x015c:
            com.paytm.android.chat.h.a r3 = r17.c()
            r4 = r1
            android.content.Context r4 = (android.content.Context) r4
            android.net.Uri r5 = r2.d()
            java.lang.String r4 = com.zhihu.matisse.internal.c.d.a(r4, r5)
            java.lang.String r5 = "PathUtils.getPath(this, item.contentUri)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r2 = r2.e()
            r3.a((java.lang.String) r4, (java.lang.String) r2, (java.io.File) r9)
            goto L_0x011f
        L_0x0178:
            r6 = 302(0x12e, float:4.23E-43)
            java.lang.String r10 = " File size is more than 20MB. "
            r11 = 20971520(0x1400000, float:3.526483E-38)
            java.lang.String r12 = "File must be located in local storage."
            java.lang.String r13 = "uri"
            if (r0 != r6) goto L_0x0260
            if (r2 != r5) goto L_0x0260
            java.lang.String r0 = com.paytm.android.chat.f.a.a((android.content.Intent) r20)
            com.paytm.android.chat.h.a r2 = r17.c()
            java.lang.String r3 = "s"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            kotlin.g.b.k.c(r0, r13)
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r3 = r2.f42166a
            if (r3 == 0) goto L_0x0257
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0257
            java.lang.String r3 = r2.f42169d
            if (r3 != 0) goto L_0x01ab
            kotlin.g.b.k.a()
        L_0x01ab:
            com.sendbird.android.GroupChannel r3 = com.paytm.android.chat.d.a.b.a(r3)
            if (r3 != 0) goto L_0x01b3
            goto L_0x0257
        L_0x01b3:
            java.io.File r3 = new java.io.File
            r3.<init>(r0)
            boolean r5 = r3.exists()
            if (r5 == 0) goto L_0x0257
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r8)
            if (r5 == 0) goto L_0x01d0
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r0 = r2.f42171f
            com.paytm.android.chat.g.a$u r2 = new com.paytm.android.chat.g.a$u
            r2.<init>(r12)
            r0.onNext(r2)
            goto L_0x0257
        L_0x01d0:
            com.paytm.android.chat.h.a$ar r5 = new com.paytm.android.chat.h.a$ar
            r5.<init>(r2)
            com.sendbird.android.BaseChannel$SendFileMessageWithProgressHandler r5 = (com.sendbird.android.BaseChannel.SendFileMessageWithProgressHandler) r5
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x01f7, all -> 0x01f0 }
            r6.<init>(r0)     // Catch:{ Exception -> 0x01f7, all -> 0x01f0 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x01f7, all -> 0x01f0 }
            r7.<init>(r6)     // Catch:{ Exception -> 0x01f7, all -> 0x01f0 }
            int r4 = r7.available()     // Catch:{ Exception -> 0x01ee, all -> 0x01eb }
        L_0x01e5:
            r7.close()     // Catch:{ IOException -> 0x01e9 }
            goto L_0x01fb
        L_0x01e9:
            goto L_0x01fb
        L_0x01eb:
            r0 = move-exception
            r9 = r7
            goto L_0x01f1
        L_0x01ee:
            goto L_0x01f8
        L_0x01f0:
            r0 = move-exception
        L_0x01f1:
            if (r9 == 0) goto L_0x01f6
            r9.close()     // Catch:{ IOException -> 0x01f6 }
        L_0x01f6:
            throw r0
        L_0x01f7:
            r7 = r9
        L_0x01f8:
            if (r7 == 0) goto L_0x01fb
            goto L_0x01e5
        L_0x01fb:
            com.paytm.android.chat.bean.jsonbean.FileDataBean r6 = new com.paytm.android.chat.bean.jsonbean.FileDataBean
            r6.<init>()
            r6.path = r0
            com.sendbird.android.FileMessageParams r0 = new com.sendbird.android.FileMessageParams
            r0.<init>()
            com.sendbird.android.FileMessageParams r0 = r0.setFile(r3)
            java.lang.String r3 = "File"
            com.sendbird.android.FileMessageParams r0 = r0.setCustomType((java.lang.String) r3)
            com.sendbird.android.shadow.com.google.gson.Gson r3 = r2.f42168c
            if (r3 != 0) goto L_0x0218
            kotlin.g.b.k.a()
        L_0x0218:
            java.lang.String r3 = r3.toJson((java.lang.Object) r6)
            com.sendbird.android.FileMessageParams r0 = r0.setData((java.lang.String) r3)
            com.sendbird.android.FileMessageParams r0 = r0.setFileSize(r4)
            if (r4 <= r11) goto L_0x0231
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r0 = r2.f42171f
            com.paytm.android.chat.g.a$u r2 = new com.paytm.android.chat.g.a$u
            r2.<init>(r10)
            r0.onNext(r2)
            goto L_0x0257
        L_0x0231:
            java.lang.String r3 = r2.f42169d
            if (r3 != 0) goto L_0x0238
            kotlin.g.b.k.a()
        L_0x0238:
            com.sendbird.android.GroupChannel r3 = com.paytm.android.chat.d.a.b.a(r3)
            if (r3 != 0) goto L_0x0241
            kotlin.g.b.k.a()
        L_0x0241:
            com.sendbird.android.FileMessage r0 = r3.sendFileMessage((com.sendbird.android.FileMessageParams) r0, (com.sendbird.android.BaseChannel.SendFileMessageWithProgressHandler) r5)
            java.lang.String r2 = r2.f42169d
            if (r2 != 0) goto L_0x024c
            kotlin.g.b.k.a()
        L_0x024c:
            com.sendbird.android.GroupChannel r2 = com.paytm.android.chat.d.a.b.a(r2)
            com.sendbird.android.BaseChannel r2 = (com.sendbird.android.BaseChannel) r2
            com.sendbird.android.BaseMessage r0 = (com.sendbird.android.BaseMessage) r0
            com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.insertOrUpdateMessage((com.sendbird.android.BaseChannel) r2, (com.sendbird.android.BaseMessage) r0)
        L_0x0257:
            com.paytm.android.chat.a.f r0 = r1.f41475c
            if (r0 == 0) goto L_0x044e
            r0.d()
            goto L_0x044e
        L_0x0260:
            r6 = 303(0x12f, float:4.25E-43)
            if (r6 != r0) goto L_0x0366
            if (r2 != r5) goto L_0x0366
            java.util.List r0 = com.paytm.android.chat.f.a.e(r20)
            java.util.Iterator r0 = r0.iterator()
        L_0x026e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x035d
            java.lang.Object r2 = r0.next()
            exfilepicker.ui.adapter.AudioListAdapter$AudioInfo r2 = (exfilepicker.ui.adapter.AudioListAdapter.AudioInfo) r2
            java.lang.String r3 = "path"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            long r5 = r2.b()
            com.paytm.android.chat.h.a r3 = r17.c()
            java.lang.String r2 = r2.a()
            java.lang.String r7 = "path.path"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            kotlin.g.b.k.c(r2, r13)
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r7 = r3.f42166a
            if (r7 == 0) goto L_0x035a
            r7 = r2
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto L_0x035a
            java.lang.String r7 = r3.f42169d
            if (r7 != 0) goto L_0x02a7
            kotlin.g.b.k.a()
        L_0x02a7:
            com.sendbird.android.GroupChannel r7 = com.paytm.android.chat.d.a.b.a(r7)
            if (r7 != 0) goto L_0x02af
            goto L_0x035a
        L_0x02af:
            java.io.File r7 = new java.io.File
            r7.<init>(r2)
            boolean r14 = r7.exists()
            if (r14 == 0) goto L_0x035a
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r8)
            if (r14 == 0) goto L_0x02cb
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r2 = r3.f42171f
            com.paytm.android.chat.g.a$u r3 = new com.paytm.android.chat.g.a$u
            r3.<init>(r12)
            r2.onNext(r3)
            goto L_0x026e
        L_0x02cb:
            com.paytm.android.chat.h.a$as r14 = new com.paytm.android.chat.h.a$as
            r14.<init>(r3)
            com.sendbird.android.BaseChannel$SendFileMessageWithProgressHandler r14 = (com.sendbird.android.BaseChannel.SendFileMessageWithProgressHandler) r14
            java.io.File r15 = new java.io.File     // Catch:{ Exception -> 0x02f5, all -> 0x02ec }
            r15.<init>(r2)     // Catch:{ Exception -> 0x02f5, all -> 0x02ec }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x02f5, all -> 0x02ec }
            r9.<init>(r15)     // Catch:{ Exception -> 0x02f5, all -> 0x02ec }
            int r15 = r9.available()     // Catch:{ Exception -> 0x02ea, all -> 0x02e6 }
            r9.close()     // Catch:{ IOException -> 0x02e4 }
            goto L_0x02fc
        L_0x02e4:
            goto L_0x02fc
        L_0x02e6:
            r0 = move-exception
            r16 = r9
            goto L_0x02ef
        L_0x02ea:
            goto L_0x02f6
        L_0x02ec:
            r0 = move-exception
            r16 = 0
        L_0x02ef:
            if (r16 == 0) goto L_0x02f4
            r16.close()     // Catch:{ IOException -> 0x02f4 }
        L_0x02f4:
            throw r0
        L_0x02f5:
            r9 = 0
        L_0x02f6:
            if (r9 == 0) goto L_0x02fb
            r9.close()     // Catch:{ IOException -> 0x02fb }
        L_0x02fb:
            r15 = 0
        L_0x02fc:
            com.paytm.android.chat.bean.jsonbean.FileDataBean r9 = new com.paytm.android.chat.bean.jsonbean.FileDataBean
            r9.<init>()
            r9.time = r5
            r9.path = r2
            com.sendbird.android.FileMessageParams r2 = new com.sendbird.android.FileMessageParams
            r2.<init>()
            com.sendbird.android.FileMessageParams r2 = r2.setFile(r7)
            java.lang.String r5 = "Audio"
            com.sendbird.android.FileMessageParams r2 = r2.setCustomType((java.lang.String) r5)
            com.sendbird.android.shadow.com.google.gson.Gson r5 = r3.f42168c
            if (r5 != 0) goto L_0x031b
            kotlin.g.b.k.a()
        L_0x031b:
            java.lang.String r5 = r5.toJson((java.lang.Object) r9)
            com.sendbird.android.FileMessageParams r2 = r2.setData((java.lang.String) r5)
            com.sendbird.android.FileMessageParams r2 = r2.setFileSize(r15)
            if (r15 <= r11) goto L_0x0334
            io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r2 = r3.f42171f
            com.paytm.android.chat.g.a$u r3 = new com.paytm.android.chat.g.a$u
            r3.<init>(r10)
            r2.onNext(r3)
            goto L_0x035a
        L_0x0334:
            java.lang.String r5 = r3.f42169d
            if (r5 != 0) goto L_0x033b
            kotlin.g.b.k.a()
        L_0x033b:
            com.sendbird.android.GroupChannel r5 = com.paytm.android.chat.d.a.b.a(r5)
            if (r5 != 0) goto L_0x0344
            kotlin.g.b.k.a()
        L_0x0344:
            com.sendbird.android.FileMessage r2 = r5.sendFileMessage((com.sendbird.android.FileMessageParams) r2, (com.sendbird.android.BaseChannel.SendFileMessageWithProgressHandler) r14)
            java.lang.String r3 = r3.f42169d
            if (r3 != 0) goto L_0x034f
            kotlin.g.b.k.a()
        L_0x034f:
            com.sendbird.android.GroupChannel r3 = com.paytm.android.chat.d.a.b.a(r3)
            com.sendbird.android.BaseChannel r3 = (com.sendbird.android.BaseChannel) r3
            com.sendbird.android.BaseMessage r2 = (com.sendbird.android.BaseMessage) r2
            com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.insertOrUpdateMessage((com.sendbird.android.BaseChannel) r3, (com.sendbird.android.BaseMessage) r2)
        L_0x035a:
            r9 = 0
            goto L_0x026e
        L_0x035d:
            com.paytm.android.chat.a.f r0 = r1.f41475c
            if (r0 == 0) goto L_0x044e
            r0.d()
            goto L_0x044e
        L_0x0366:
            r6 = 304(0x130, float:4.26E-43)
            if (r6 != r0) goto L_0x03b2
            if (r2 != r5) goto L_0x03b2
            java.lang.String r0 = "channels"
            java.util.ArrayList r2 = r3.getStringArrayListExtra(r0)
            com.paytm.android.chat.a.f r3 = r1.f41475c
            if (r3 == 0) goto L_0x037b
            java.util.List r9 = r3.b()
            goto L_0x037c
        L_0x037b:
            r9 = 0
        L_0x037c:
            if (r9 == 0) goto L_0x044e
            int r3 = r2.size()
            if (r3 <= 0) goto L_0x044e
            int r3 = r9.size()
            if (r3 <= 0) goto L_0x044e
            java.lang.Object r3 = r2.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            com.paytm.android.chat.h.a r4 = r17.c()
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r0)
            r4.a((java.util.ArrayList<java.lang.String>) r2, (java.util.List<? extends com.sendbird.android.BaseMessage>) r9)
            int r0 = r2.size()
            if (r0 != r7) goto L_0x044e
            androidx.recyclerview.widget.RecyclerView r0 = r1.o
            if (r0 == 0) goto L_0x044e
            com.paytm.android.chat.activity.APCChatActivity$ak r4 = new com.paytm.android.chat.activity.APCChatActivity$ak
            r4.<init>(r3, r1, r2, r9)
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r2 = 1000(0x3e8, double:4.94E-321)
            r0.postDelayed(r4, r2)
            goto L_0x044e
        L_0x03b2:
            r4 = 305(0x131, float:4.27E-43)
            if (r4 != r0) goto L_0x044e
            if (r2 != r5) goto L_0x044e
            java.lang.String r0 = "SELECTED_CONTACTS"
            java.lang.String r0 = r3.getStringExtra(r0)
            com.paytm.android.chat.a.f r2 = r1.f41475c
            if (r2 == 0) goto L_0x03c5
            r2.c()
        L_0x03c5:
            com.paytm.android.chat.h.a r2 = r17.c()
            java.lang.String r3 = "selectedContacts"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r3 = "contacts"
            kotlin.g.b.k.c(r0, r3)
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r3 = r2.f42166a
            if (r3 == 0) goto L_0x044e
            java.lang.String r3 = r2.f42169d
            if (r3 != 0) goto L_0x03de
            kotlin.g.b.k.a()
        L_0x03de:
            com.sendbird.android.GroupChannel r3 = com.paytm.android.chat.d.a.b.a(r3)
            if (r3 != 0) goto L_0x03e5
            goto L_0x044e
        L_0x03e5:
            com.paytm.android.chat.h.a$ap r3 = new com.paytm.android.chat.h.a$ap
            r3.<init>()
            java.lang.reflect.Type r3 = r3.getType()
            com.sendbird.android.shadow.com.google.gson.Gson r4 = r2.f42168c
            if (r4 != 0) goto L_0x03f5
            kotlin.g.b.k.a()
        L_0x03f5:
            java.lang.Object r3 = r4.fromJson((java.lang.String) r0, (java.lang.reflect.Type) r3)
            java.util.List r3 = (java.util.List) r3
            com.sendbird.android.UserMessageParams r4 = new com.sendbird.android.UserMessageParams
            r4.<init>()
            r4.setData((java.lang.String) r0)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x044e
            java.lang.String r5 = "selectList"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r5)
            java.lang.String r3 = com.paytm.android.chat.h.a.a((java.util.List<? extends com.paytm.android.chat.bean.SelectContactsBean>) r3)
            r4.setMessage(r3)
            java.lang.String r3 = "contact"
            r4.setCustomType((java.lang.String) r3)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            com.paytm.utility.q.a(r0)
            java.lang.String r0 = r2.f42169d
            if (r0 != 0) goto L_0x0428
            kotlin.g.b.k.a()
        L_0x0428:
            com.sendbird.android.GroupChannel r0 = com.paytm.android.chat.d.a.b.a(r0)
            if (r0 != 0) goto L_0x0431
            kotlin.g.b.k.a()
        L_0x0431:
            com.paytm.android.chat.h.a$aq r3 = new com.paytm.android.chat.h.a$aq
            r3.<init>(r2)
            com.sendbird.android.BaseChannel$SendUserMessageHandler r3 = (com.sendbird.android.BaseChannel.SendUserMessageHandler) r3
            com.sendbird.android.UserMessage r0 = r0.sendUserMessage((com.sendbird.android.UserMessageParams) r4, (com.sendbird.android.BaseChannel.SendUserMessageHandler) r3)
            java.lang.String r2 = r2.f42169d
            if (r2 != 0) goto L_0x0443
            kotlin.g.b.k.a()
        L_0x0443:
            com.sendbird.android.GroupChannel r2 = com.paytm.android.chat.d.a.b.a(r2)
            com.sendbird.android.BaseChannel r2 = (com.sendbird.android.BaseChannel) r2
            com.sendbird.android.BaseMessage r0 = (com.sendbird.android.BaseMessage) r0
            com.paytm.android.chat.data.db.room.helper.MessageDBHelperKt.insertOrUpdateMessage((com.sendbird.android.BaseChannel) r2, (com.sendbird.android.BaseMessage) r0)
        L_0x044e:
            com.paytm.android.chat.view.a.a r0 = r1.af
            if (r0 == 0) goto L_0x045c
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r0.a((java.util.List<com.sendbird.android.BaseMessage>) r2)
        L_0x045c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void onBackPressed() {
        super.onBackPressed();
        if (kotlin.g.b.k.a((Object) "true", (Object) this.T)) {
            startActivity(new Intent(this, PaytmChatMainActivity.class));
        }
        if (this.av) {
            this.av = false;
        }
        com.paytm.android.chat.view.a.a aVar = this.af;
        if (aVar != null && aVar.isShowing()) {
            com.paytm.android.chat.a.f fVar = this.f41475c;
            if (fVar != null) {
                fVar.c();
            }
            aVar.dismiss();
        }
        finish();
    }

    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        kotlin.g.b.k.c(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    static final class av extends kotlin.g.b.l implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ APCChatActivity this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        av(APCChatActivity aPCChatActivity) {
            super(0);
            this.this$0 = aPCChatActivity;
        }

        public final void invoke() {
            APCChatActivity aPCChatActivity = this.this$0;
            APCChatActivity.a(aPCChatActivity, aPCChatActivity.getIntent(), false);
            this.this$0.c().f();
        }
    }

    private final void j() {
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.a((Context) this, (kotlin.g.a.a<kotlin.x>) new av(this), (kotlin.g.a.m<? super ResponseOfRegister, ? super LoginInfo, kotlin.x>) new aw(this), (kotlin.g.a.m<? super Integer, ? super String, kotlin.x>) new ax(this));
    }

    static final class ab<T> implements io.reactivex.rxjava3.a.ab<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41481a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Intent f41482b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f41483c;

        ab(APCChatActivity aPCChatActivity, Intent intent, boolean z) {
            this.f41481a = aPCChatActivity;
            this.f41482b = intent;
            this.f41483c = z;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.Map$Entry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v4, resolved type: java.util.Map$Entry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: java.util.Map$Entry} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: java.util.Map$Entry} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void subscribe(io.reactivex.rxjava3.a.z<com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel> r14) {
            /*
                r13 = this;
                android.content.Intent r0 = r13.f41482b
                java.lang.String r1 = "chatType"
                java.lang.String r0 = r0.getStringExtra(r1)
                android.content.Intent r1 = r13.f41482b
                java.lang.String r2 = "source"
                java.lang.String r1 = r1.getStringExtra(r2)
                android.content.Intent r2 = r13.f41482b
                r3 = 0
                java.lang.String r4 = "isFromMT"
                boolean r2 = r2.getBooleanExtra(r4, r3)
                r4 = 0
                if (r2 == 0) goto L_0x0045
                android.content.Intent r2 = r13.f41482b
                java.lang.String r3 = "payment.sender"
                java.io.Serializable r2 = r2.getSerializableExtra(r3)
                java.lang.String r3 = "null cannot be cast to non-null type net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser"
                if (r2 == 0) goto L_0x003f
                net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r2 = (net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r2
                android.content.Intent r5 = r13.f41482b
                java.lang.String r6 = "payment.receiver"
                java.io.Serializable r5 = r5.getSerializableExtra(r6)
                if (r5 == 0) goto L_0x0039
                r3 = r5
                net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r3 = (net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r3
                goto L_0x00d8
            L_0x0039:
                kotlin.u r14 = new kotlin.u
                r14.<init>(r3)
                throw r14
            L_0x003f:
                kotlin.u r14 = new kotlin.u
                r14.<init>(r3)
                throw r14
            L_0x0045:
                net.one97.paytm.common.entity.chat.moneytransfer.CustomerChatPayeeUser r2 = new net.one97.paytm.common.entity.chat.moneytransfer.CustomerChatPayeeUser
                com.paytm.android.chat.activity.APCChatActivity r5 = r13.f41481a
                android.content.Context r5 = (android.content.Context) r5
                java.lang.String r5 = com.paytm.utility.b.n((android.content.Context) r5)
                java.lang.String r6 = "CJRAppCommonUtility.getUserId(this)"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.String r6 = com.paytm.android.chat.utils.SharedPreferencesUtil.getNickname()
                java.lang.String r7 = com.paytm.android.chat.utils.SharedPreferencesUtil.getMobileNumber()
                r2.<init>(r5, r6, r7)
                net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r2 = (net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r2
                com.paytm.android.chat.activity.APCChatActivity r5 = r13.f41481a
                com.paytm.android.chat.bean.FriendBean r5 = r5.at
                android.content.Intent r6 = r13.f41482b
                java.lang.String r7 = "phone"
                java.lang.String r6 = r6.getStringExtra(r7)
                android.content.Intent r8 = r13.f41482b
                java.lang.String r9 = "phoneName"
                java.lang.String r8 = r8.getStringExtra(r9)
                android.content.Intent r9 = r13.f41482b
                java.lang.String r10 = "paytmChannelId"
                java.lang.String r9 = r9.getStringExtra(r10)
                r11 = r1
                java.lang.CharSequence r11 = (java.lang.CharSequence) r11
                boolean r11 = android.text.TextUtils.isEmpty(r11)
                if (r11 == 0) goto L_0x0094
                android.content.Intent r11 = r13.f41482b
                java.lang.String r12 = "isFromContact"
                boolean r3 = r11.getBooleanExtra(r12, r3)
                if (r3 == 0) goto L_0x0094
                java.lang.String r1 = "address_book"
            L_0x0094:
                if (r5 == 0) goto L_0x00af
                net.one97.paytm.common.entity.chat.moneytransfer.CustomerChatPayeeUser r3 = new net.one97.paytm.common.entity.chat.moneytransfer.CustomerChatPayeeUser
                java.lang.String r6 = r5.getPaytmUserId()
                java.lang.String r7 = "friend.paytmUserId"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                java.lang.String r7 = r5.getName()
                java.lang.String r5 = r5.getPhone()
                r3.<init>(r6, r7, r5)
                net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r3 = (net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r3
                goto L_0x00d8
            L_0x00af:
                r3 = r9
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x00c3
                net.one97.paytm.common.entity.chat.moneytransfer.MerchantChatPayeeUser r3 = new net.one97.paytm.common.entity.chat.moneytransfer.MerchantChatPayeeUser
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r10)
                r3.<init>(r9)
                net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r3 = (net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r3
                goto L_0x00d8
            L_0x00c3:
                r3 = r6
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x00d7
                net.one97.paytm.common.entity.chat.moneytransfer.MobileNumberChatPayeeUser r3 = new net.one97.paytm.common.entity.chat.moneytransfer.MobileNumberChatPayeeUser
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r7)
                r3.<init>(r6, r8)
                net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser r3 = (net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r3
                goto L_0x00d8
            L_0x00d7:
                r3 = r4
            L_0x00d8:
                java.lang.String r5 = "emitter"
                if (r3 == 0) goto L_0x0264
                com.paytm.android.chat.activity.APCChatActivity r6 = r13.f41481a
                com.paytm.android.chat.h.a r6 = r6.c()
                java.lang.String r7 = "sender"
                kotlin.g.b.k.c(r2, r7)
                java.lang.String r8 = "receiver"
                kotlin.g.b.k.c(r3, r8)
                com.paytm.android.chat.data.repository.ChatRepository r6 = r6.f42174i
                com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r6 = r6.locateChannelBetweenTwoUsers(r2, r3)
                if (r6 != 0) goto L_0x010a
                boolean r9 = r13.f41483c
                if (r9 == 0) goto L_0x010a
                com.paytm.android.chat.activity.APCChatActivity r6 = r13.f41481a
                com.paytm.android.chat.h.a r6 = r6.c()
                kotlin.g.b.k.c(r2, r7)
                kotlin.g.b.k.c(r3, r8)
                com.paytm.android.chat.data.repository.ChatRepository r6 = r6.f42174i
                com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r6 = r6.offlineCreateFakeChannelBetweenUsers(r2, r3)
            L_0x010a:
                if (r6 == 0) goto L_0x0137
                com.paytm.android.chat.activity.APCChatActivity r0 = r13.f41481a
                java.lang.String r1 = r6.getChannelUrl()
                r0.R = r1
                com.paytm.android.chat.activity.APCChatActivity r0 = r13.f41481a
                com.paytm.android.chat.h.a r0 = r0.c()
                java.lang.String r1 = r6.getChannelUrl()
                r0.a((java.lang.String) r1)
                com.paytm.android.chat.activity.APCChatActivity r0 = r13.f41481a
                com.paytm.android.chat.h.a r0 = r0.c()
                r0.f42166a = r6
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
                boolean r0 = r14.isDisposed()
                if (r0 != 0) goto L_0x0279
                r14.onSuccess(r6)
                return
            L_0x0137:
                com.paytm.a r6 = com.paytm.a.f40823c
                com.paytm.android.chat.network.response.CreateChannelResponse r0 = com.paytm.a.a((net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r2, (net.one97.paytm.common.entity.chat.moneytransfer.ChatPayeeUser) r3, (java.lang.String) r0, (java.lang.String) r1)
                java.lang.String r1 = ""
                if (r0 == 0) goto L_0x0230
                boolean r6 = r0.isSuccess()
                if (r6 == 0) goto L_0x0230
                com.paytm.android.chat.network.response.CreateChannelResponse$Success r6 = r0.getSuccessResponse()
                if (r6 != 0) goto L_0x0150
                kotlin.g.b.k.a()
            L_0x0150:
                com.sendbird.android.BaseChannel r6 = r6.getChannel()
                boolean r6 = r6 instanceof com.sendbird.android.GroupChannel
                if (r6 == 0) goto L_0x01ea
                com.paytm.android.chat.network.response.CreateChannelResponse$Success r6 = r0.getSuccessResponse()
                java.lang.String r6 = r6.getChannelurl()
                com.paytm.android.chat.activity.APCChatActivity r9 = r13.f41481a
                r9.b((java.lang.String) r6)
                com.paytm.android.chat.activity.APCChatActivity r9 = r13.f41481a
                r9.R = r6
                com.paytm.android.chat.activity.APCChatActivity r9 = r13.f41481a
                com.paytm.android.chat.h.a r9 = r9.c()
                r9.a((java.lang.String) r6)
                com.paytm.android.chat.activity.APCChatActivity r6 = r13.f41481a
                com.paytm.android.chat.h.a r6 = r6.c()
                com.paytm.android.chat.network.response.CreateChannelResponse$Success r9 = r0.getSuccessResponse()
                com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse r9 = r9.getUserInfo()
                r6.f42172g = r9
                com.paytm.android.chat.network.response.CreateChannelResponse$Success r6 = r0.getSuccessResponse()
                java.util.Map r6 = r6.getChannelChatPayeeUsers()
                java.util.Set r6 = r6.entrySet()
                java.lang.Iterable r6 = (java.lang.Iterable) r6
                java.util.Iterator r6 = r6.iterator()
            L_0x0195:
                boolean r9 = r6.hasNext()
                if (r9 == 0) goto L_0x01b5
                java.lang.Object r9 = r6.next()
                r10 = r9
                java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                java.lang.String r11 = com.paytm.android.chat.utils.SharedPreferencesUtil.getUserId()
                java.lang.Object r10 = r10.getKey()
                java.lang.String r10 = (java.lang.String) r10
                boolean r10 = kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.Object) r10)
                r10 = r10 ^ 1
                if (r10 == 0) goto L_0x0195
                r4 = r9
            L_0x01b5:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                if (r4 == 0) goto L_0x01ea
                com.paytm.android.chat.activity.APCChatActivity r6 = r13.f41481a
                java.lang.Object r9 = r4.getValue()
                com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean r9 = (com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean) r9
                java.lang.String r9 = r9.getCustomerCreationText()
                if (r9 != 0) goto L_0x01c8
                goto L_0x01c9
            L_0x01c8:
                r1 = r9
            L_0x01c9:
                r6.ap = r1
                com.paytm.android.chat.activity.APCChatActivity r1 = r13.f41481a
                java.lang.Object r6 = r4.getValue()
                com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean r6 = (com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean) r6
                boolean r6 = r6.isKyc()
                r1.aq = r6
                com.paytm.android.chat.activity.APCChatActivity r1 = r13.f41481a
                java.lang.Object r4 = r4.getValue()
                com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean r4 = (com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean) r4
                com.paytm.android.chat.bean.jsonbean.KycInfo r4 = r4.getKycInfo()
                r1.ar = r4
            L_0x01ea:
                com.paytm.android.chat.activity.APCChatActivity r1 = r13.f41481a
                com.paytm.android.chat.h.a r1 = r1.c()
                com.paytm.android.chat.network.response.CreateChannelResponse$Success r4 = r0.getSuccessResponse()
                java.util.Map r4 = r4.getChannelChatPayeeUsers()
                com.paytm.android.chat.network.response.CreateChannelResponse$Success r6 = r0.getSuccessResponse()
                com.sendbird.android.BaseChannel r6 = r6.getChannel()
                kotlin.g.b.k.c(r2, r7)
                kotlin.g.b.k.c(r3, r8)
                java.lang.String r7 = "userMap"
                kotlin.g.b.k.c(r4, r7)
                java.lang.String r7 = "channel"
                kotlin.g.b.k.c(r6, r7)
                com.paytm.android.chat.data.repository.ChatRepository r1 = r1.f42174i
                com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r1 = r1.updateChannelFromCreateChannelApi(r2, r3, r4, r6)
                com.paytm.android.chat.activity.APCChatActivity r2 = r13.f41481a
                com.paytm.android.chat.network.response.CreateChannelResponse$Success r0 = r0.getSuccessResponse()
                com.paytm.android.chat.network.response.ResponseOfRegisterSendBird$DataOfRegisterSendBird r0 = r0.getData()
                com.paytm.android.chat.activity.APCChatActivity.a((com.paytm.android.chat.activity.APCChatActivity) r2, (com.paytm.android.chat.network.response.ResponseOfRegisterSendBird.DataOfRegisterSendBird) r0)
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
                boolean r0 = r14.isDisposed()
                if (r0 != 0) goto L_0x022f
                r14.onSuccess(r1)
            L_0x022f:
                return
            L_0x0230:
                if (r0 == 0) goto L_0x0255
                com.paytm.network.model.NetworkCustomError r14 = new com.paytm.network.model.NetworkCustomError
                r14.<init>()
                com.paytm.android.chat.network.response.CreateChannelResponse$Failure r1 = r0.getFailureResponse()
                if (r1 != 0) goto L_0x0240
                kotlin.g.b.k.a()
            L_0x0240:
                int r1 = r1.getErrorCode()
                r14.setStatusCode(r1)
                com.paytm.android.chat.network.response.CreateChannelResponse$Failure r0 = r0.getFailureResponse()
                java.lang.String r0 = r0.getError()
                r14.setAlertMessage(r0)
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                throw r14
            L_0x0255:
                com.paytm.network.model.NetworkCustomError r14 = new com.paytm.network.model.NetworkCustomError
                r14.<init>()
                r0 = -1
                r14.setStatusCode(r0)
                r14.setAlertMessage(r1)
                java.lang.Throwable r14 = (java.lang.Throwable) r14
                throw r14
            L_0x0264:
                kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r5)
                boolean r0 = r14.isDisposed()
                if (r0 != 0) goto L_0x0279
                java.lang.Exception r0 = new java.lang.Exception
                java.lang.String r1 = "Sender or Receiver is null"
                r0.<init>(r1)
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                r14.onError(r0)
            L_0x0279:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.ab.subscribe(io.reactivex.rxjava3.a.z):void");
        }
    }

    static final class b implements SwipeRefreshLayout.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41523a;

        b(APCChatActivity aPCChatActivity) {
            this.f41523a = aPCChatActivity;
        }

        public final void onRefresh() {
            boolean z = true;
            this.f41523a.c().b(true);
            com.paytm.android.chat.h.a b2 = this.f41523a.c();
            LinearLayoutManager j = this.f41523a.N;
            if (j != null && j.findFirstVisibleItemPosition() == 0) {
                z = false;
            }
            b2.f42173h = z;
        }
    }

    public static final class c implements com.paytm.android.chat.view.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41539a;

        c(APCChatActivity aPCChatActivity) {
            this.f41539a = aPCChatActivity;
        }

        public final void a(int i2) {
            com.paytm.android.chat.a.f fVar = this.f41539a.f41475c;
            if (fVar == null) {
                kotlin.g.b.k.a();
            }
            if (fVar.e() != null) {
                com.paytm.android.chat.a.f fVar2 = this.f41539a.f41475c;
                if (fVar2 == null) {
                    kotlin.g.b.k.a();
                }
                f.m e2 = fVar2.e();
                com.paytm.android.chat.a.f fVar3 = this.f41539a.f41475c;
                if (fVar3 == null) {
                    kotlin.g.b.k.a();
                }
                e2.c(fVar3.f().get(i2).baseMessage);
            }
        }
    }

    static final class w implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41561a;

        w(APCChatActivity aPCChatActivity) {
            this.f41561a = aPCChatActivity;
        }

        public final void onClick(View view) {
            this.f41561a.onBackPressed();
        }
    }

    static final class d implements j.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41540a;

        d(APCChatActivity aPCChatActivity) {
            this.f41540a = aPCChatActivity;
        }

        public final void a(String str) {
            ChatType chatType;
            String name;
            this.f41540a.c().c(str);
            ReceiverDisplayInfo e2 = this.f41540a.c().e();
            if (e2 != null && (chatType = e2.getChatType()) != null && (name = chatType.name()) != null) {
                kotlin.g.b.k.a((Object) str, "message");
                ChatAnalyticsHelperKt.firePaymentQuickReplyEvent(this.f41540a, name, str);
            }
        }
    }

    static final class o implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41553a;

        o(APCChatActivity aPCChatActivity) {
            this.f41553a = aPCChatActivity;
        }

        public final void onClick(View view) {
            ChatType chatType;
            String name;
            ChatGroupChannelDataModel chatGroupChannelDataModel;
            LottieAnimationView k = this.f41553a.Q;
            if (k != null) {
                k.playAnimation();
            }
            this.f41553a.c().c("Hello 👋");
            ReceiverDisplayInfo e2 = this.f41553a.c().e();
            if (e2 != null && (chatType = e2.getChatType()) != null && (name = chatType.name()) != null && (chatGroupChannelDataModel = this.f41553a.c().f42166a) != null) {
                APCChatActivity aPCChatActivity = this.f41553a;
                String localClassName = aPCChatActivity.getLocalClassName();
                kotlin.g.b.k.a((Object) localClassName, "this@APCChatActivity.localClassName");
                ChatAnalyticsHelperKt.fireHelloQuickReplyClickEvent(aPCChatActivity, chatGroupChannelDataModel, name, localClassName);
            }
        }
    }

    static final class p implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41554a;

        p(APCChatActivity aPCChatActivity) {
            this.f41554a = aPCChatActivity;
        }

        public final void onClick(View view) {
            if (FastClickUtil.isFastClick() && !this.f41554a.isFinishing() && !this.f41554a.isDestroyed()) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", this.f41554a.getString(R.string.chat_invite_text));
                Intent createChooser = Intent.createChooser(intent, AppConstants.SHARE);
                kotlin.g.b.k.a((Object) createChooser, "Intent.createChooser(shareIntent, \"Share\")");
                this.f41554a.startActivity(createChooser);
            }
        }
    }

    static final class q implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41555a;

        q(APCChatActivity aPCChatActivity) {
            this.f41555a = aPCChatActivity;
        }

        public final void onClick(View view) {
            this.f41555a.n();
        }
    }

    static final class r implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41556a;

        r(APCChatActivity aPCChatActivity) {
            this.f41556a = aPCChatActivity;
        }

        public final void onClick(View view) {
            this.f41556a.n();
        }
    }

    static final class s implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41557a;

        s(APCChatActivity aPCChatActivity) {
            this.f41557a = aPCChatActivity;
        }

        public final void onClick(View view) {
            APCChatActivity.m(this.f41557a);
        }
    }

    public static final class t implements ChatEditText.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41558a;

        t(APCChatActivity aPCChatActivity) {
            this.f41558a = aPCChatActivity;
        }

        public final void a(androidx.core.h.c.c cVar) {
            try {
                ContentResolver contentResolver = this.f41558a.getContentResolver();
                if (cVar == null) {
                    kotlin.g.b.k.a();
                }
                InputStream openInputStream = contentResolver.openInputStream(cVar.a());
                String absCameraPath = FileUtils.getAbsCameraPath();
                File file = new File(absCameraPath, String.valueOf(System.currentTimeMillis()) + ".gif");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                com.google.a.a.c.l.a(openInputStream, fileOutputStream);
                com.paytm.android.chat.h.a b2 = this.f41558a.c();
                if (b2.f42166a != null) {
                    String str = b2.f42169d;
                    if (str == null) {
                        kotlin.g.b.k.a();
                    }
                    if (com.paytm.android.chat.d.a.b.a(str) != null) {
                        List arrayList = new ArrayList();
                        arrayList.add(new FileMessage.ThumbnailSize(240, 240));
                        BaseChannel.SendFileMessageWithProgressHandler auVar = new a.au(b2);
                        FileDataBean fileDataBean = new FileDataBean();
                        fileDataBean.message = "";
                        FileMessageParams customType = new FileMessageParams().setFile(file).setMimeType("image/gif").setCustomType("Image");
                        Gson gson = b2.f42168c;
                        if (gson == null) {
                            kotlin.g.b.k.a();
                        }
                        FileMessageParams thumbnailSizes = customType.setData(gson.toJson((Object) fileDataBean)).setThumbnailSizes(arrayList);
                        String str2 = b2.f42169d;
                        if (str2 == null) {
                            kotlin.g.b.k.a();
                        }
                        GroupChannel a2 = com.paytm.android.chat.d.a.b.a(str2);
                        if (a2 == null) {
                            kotlin.g.b.k.a();
                        }
                        FileMessage sendFileMessage = a2.sendFileMessage(thumbnailSizes, auVar);
                        String str3 = b2.f42169d;
                        if (str3 == null) {
                            kotlin.g.b.k.a();
                        }
                        MessageDBHelperKt.insertOrUpdateMessage((BaseChannel) com.paytm.android.chat.d.a.b.a(str3), (BaseMessage) sendFileMessage);
                    }
                }
                if (openInputStream != null) {
                    openInputStream.close();
                }
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    static final class u implements AttachBottomSheet.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41559a;

        u(APCChatActivity aPCChatActivity) {
            this.f41559a = aPCChatActivity;
        }

        public final void a(b.a aVar, String str) {
            kotlin.g.b.k.c(aVar, "dataHolder");
            kotlin.g.b.k.c(str, CLPConstants.ARGUMENT_KEY_POSITION);
            AttachBottomSheet n = this.f41559a.L;
            if (n != null) {
                n.a();
            }
            switch (str.hashCode()) {
                case -1905167199:
                    if (str.equals("Photos") && this.f41559a.r()) {
                        com.paytm.android.chat.f.a.a((Activity) this.f41559a);
                        ChatAnalyticsHelperKt.fireBottomFunctionClickEvent(this.f41559a, aVar.f41039a, 2);
                        return;
                    }
                    return;
                case -1347456360:
                    if (str.equals("Documents") && this.f41559a.r()) {
                        ReceiverDisplayInfo e2 = this.f41559a.c().e();
                        String name = e2 != null ? e2.getName() : null;
                        Activity activity = this.f41559a;
                        if (name == null) {
                            name = "";
                        }
                        com.paytm.android.chat.f.a.a(activity, name);
                        ChatAnalyticsHelperKt.fireBottomFunctionClickEvent(this.f41559a, aVar.f41039a, 5);
                        return;
                    }
                    return;
                case -502807437:
                    if (str.equals("Contacts")) {
                        AppUtilKt.hasPermission(this.f41559a, "android.permission.READ_CONTACTS");
                        if (APCChatActivity.p(this.f41559a) && !this.f41559a.isFinishing() && !this.f41559a.isDestroyed()) {
                            APCChatActivity aPCChatActivity = this.f41559a;
                            aPCChatActivity.startActivityForResult(new Intent(aPCChatActivity, ChatSearchSendContactsActivity.class), 305);
                            ChatAnalyticsHelperKt.fireBottomFunctionClickEvent(this.f41559a, aVar.f41039a, 4);
                            return;
                        }
                        return;
                    }
                    return;
                case 80068062:
                    if (str.equals("Songs") && this.f41559a.r()) {
                        com.paytm.android.chat.f.a.c((Activity) this.f41559a);
                        ChatAnalyticsHelperKt.fireBottomFunctionClickEvent(this.f41559a, aVar.f41039a, 3);
                        return;
                    }
                    return;
                case 706215855:
                    if (str.equals("Request Money")) {
                        APCChatActivity.m(this.f41559a);
                        return;
                    }
                    return;
                case 982264360:
                    if (str.equals("Send Money")) {
                        this.f41559a.n();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    static final class v implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41560a;

        v(APCChatActivity aPCChatActivity) {
            this.f41560a = aPCChatActivity;
        }

        public final void onClick(View view) {
            View q = this.f41560a.K;
            if (q != null) {
                q.setVisibility(0);
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41541a;

        e(APCChatActivity aPCChatActivity) {
            this.f41541a = aPCChatActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
            r0 = (r0 = r0.getText()).toString();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r4) {
            /*
                r3 = this;
                com.paytm.android.chat.activity.APCChatActivity r4 = r3.f41541a
                com.paytm.android.chat.view.AttachBottomSheet r4 = r4.L
                if (r4 == 0) goto L_0x0017
                com.paytm.android.chat.activity.APCChatActivity r0 = r3.f41541a
                boolean r0 = r0.Z
                com.paytm.android.chat.activity.APCChatActivity r1 = r3.f41541a
                boolean r1 = r1.aa
                r4.a(r0, r1)
            L_0x0017:
                com.paytm.android.chat.activity.APCChatActivity r4 = r3.f41541a
                com.paytm.android.chat.h.a r4 = r4.c()
                com.paytm.android.chat.bean.ReceiverDisplayInfo r4 = r4.e()
                if (r4 == 0) goto L_0x0051
                com.paytm.android.chat.bean.ChatType r4 = r4.getChatType()
                if (r4 == 0) goto L_0x0051
                java.lang.String r4 = r4.name()
                if (r4 == 0) goto L_0x0051
                com.paytm.android.chat.activity.APCChatActivity r0 = r3.f41541a
                r1 = r0
                android.content.Context r1 = (android.content.Context) r1
                com.paytm.android.chat.view.input.ChatEditText r0 = r0.p
                if (r0 == 0) goto L_0x004b
                android.text.Editable r0 = r0.getText()
                if (r0 == 0) goto L_0x004b
                java.lang.String r0 = r0.toString()
                if (r0 == 0) goto L_0x004b
                int r0 = r0.length()
                goto L_0x004c
            L_0x004b:
                r0 = 0
            L_0x004c:
                java.lang.String r2 = "Plus CTA Click"
                com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireSendTextMessageCTAClickEvent(r1, r2, r4, r0)
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.e.onClick(android.view.View):void");
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41542a;

        f(APCChatActivity aPCChatActivity) {
            this.f41542a = aPCChatActivity;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
            r1 = (r1 = r1.getText()).toString();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r8) {
            /*
                r7 = this;
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                com.paytm.android.chat.h.a r8 = r8.c()
                com.paytm.android.chat.bean.ReceiverDisplayInfo r8 = r8.e()
                r0 = 0
                if (r8 == 0) goto L_0x003b
                com.paytm.android.chat.bean.ChatType r8 = r8.getChatType()
                if (r8 == 0) goto L_0x003b
                java.lang.String r8 = r8.name()
                if (r8 == 0) goto L_0x003b
                com.paytm.android.chat.activity.APCChatActivity r1 = r7.f41542a
                r2 = r1
                android.content.Context r2 = (android.content.Context) r2
                com.paytm.android.chat.view.input.ChatEditText r1 = r1.p
                if (r1 == 0) goto L_0x0035
                android.text.Editable r1 = r1.getText()
                if (r1 == 0) goto L_0x0035
                java.lang.String r1 = r1.toString()
                if (r1 == 0) goto L_0x0035
                int r1 = r1.length()
                goto L_0x0036
            L_0x0035:
                r1 = 0
            L_0x0036:
                java.lang.String r3 = "Send Text Message CTA Click"
                com.paytm.android.chat.utils.ChatAnalyticsHelperKt.fireSendTextMessageCTAClickEvent(r2, r3, r8, r1)
            L_0x003b:
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                com.paytm.android.chat.view.input.ChatEditText r8 = r8.p
                if (r8 == 0) goto L_0x004e
                android.text.Editable r8 = r8.getText()
                if (r8 == 0) goto L_0x004e
                java.lang.String r8 = r8.toString()
                goto L_0x004f
            L_0x004e:
                r8 = 0
            L_0x004f:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                boolean r8 = android.text.TextUtils.isEmpty(r8)
                if (r8 == 0) goto L_0x0065
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                android.content.Context r8 = (android.content.Context) r8
                int r1 = com.paytm.android.chat.R.string.chat_enter_a_message
                android.widget.Toast r8 = android.widget.Toast.makeText(r8, r1, r0)
                r8.show()
                return
            L_0x0065:
                boolean r8 = com.paytm.android.chat.utils.FastClickUtil.isFastClick()
                if (r8 == 0) goto L_0x01de
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                com.paytm.android.chat.a.f r8 = r8.f41475c
                if (r8 == 0) goto L_0x0082
                int r8 = r8.getItemCount()
                if (r8 != 0) goto L_0x0082
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                com.airbnb.lottie.LottieAnimationView r8 = r8.Q
                if (r8 == 0) goto L_0x0082
                r8.playAnimation()
            L_0x0082:
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                java.lang.String r8 = r8.l()
                if (r8 == 0) goto L_0x01be
                r1 = r8
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                int r1 = r1.length()
                r2 = 1
                if (r1 <= 0) goto L_0x0096
                r1 = 1
                goto L_0x0097
            L_0x0096:
                r1 = 0
            L_0x0097:
                if (r1 == 0) goto L_0x01be
                com.paytm.android.chat.activity.APCChatActivity r1 = r7.f41542a
                boolean r1 = com.paytm.android.chat.activity.APCChatActivity.v(r1)
                if (r1 == 0) goto L_0x01b5
                com.paytm.android.chat.activity.APCChatActivity r1 = r7.f41542a
                com.paytm.android.chat.h.a r1 = r1.c()
                com.paytm.android.chat.activity.APCChatActivity r3 = r7.f41542a
                com.sendbird.android.BaseMessage r3 = com.paytm.android.chat.activity.APCChatActivity.w(r3)
                com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r4 = r1.f42166a
                if (r4 == 0) goto L_0x01be
                if (r3 == 0) goto L_0x01be
                java.lang.String r4 = r1.f42169d
                if (r4 != 0) goto L_0x00ba
                kotlin.g.b.k.a()
            L_0x00ba:
                com.sendbird.android.GroupChannel r4 = com.paytm.android.chat.d.a.b.a(r4)
                if (r4 != 0) goto L_0x00c2
                goto L_0x01be
            L_0x00c2:
                com.sendbird.android.UserMessageParams r4 = new com.sendbird.android.UserMessageParams
                r4.<init>()
                r4.setMessage(r8)
                java.lang.String r8 = "reply"
                r4.setCustomType((java.lang.String) r8)
                com.paytm.android.chat.bean.jsonbean.UserDataBean r8 = new com.paytm.android.chat.bean.jsonbean.UserDataBean
                long r5 = r3.getMessageId()
                r8.<init>(r5)
                com.paytm.android.chat.utils.MessageContentUtils$MessageContentBean r5 = com.paytm.android.chat.utils.MessageContentUtils.getReplyContentBean(r3)
                if (r5 == 0) goto L_0x00e3
                java.lang.String r5 = r5.content
                r8.setContent(r5)
            L_0x00e3:
                boolean r5 = r3 instanceof com.sendbird.android.UserMessage
                if (r5 == 0) goto L_0x0124
                r2 = r3
                com.sendbird.android.UserMessage r2 = (com.sendbird.android.UserMessage) r2
                com.sendbird.android.Sender r2 = r2.getSender()
                if (r2 == 0) goto L_0x00fe
                java.lang.String r5 = r2.getNickname()
                r8.setTitle(r5)
                java.lang.String r2 = r2.getUserId()
                r8.setUserId(r2)
            L_0x00fe:
                java.lang.String r2 = r3.getCustomType()
                java.lang.String r5 = "contact"
                boolean r2 = kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.Object) r5)
                if (r2 == 0) goto L_0x010f
                r2 = 5
                r8.setType(r2)
                goto L_0x016d
            L_0x010f:
                java.lang.String r2 = r3.getCustomType()
                java.lang.String r3 = "TRANSFER"
                boolean r2 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r2)
                if (r2 == 0) goto L_0x0120
                r2 = 3
                r8.setType(r2)
                goto L_0x016d
            L_0x0120:
                r8.setType(r0)
                goto L_0x016d
            L_0x0124:
                boolean r5 = r3 instanceof com.sendbird.android.FileMessage
                if (r5 == 0) goto L_0x016d
                java.lang.String r5 = r3.getCustomType()
                java.lang.String r6 = "Audio"
                boolean r5 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r5)
                if (r5 == 0) goto L_0x0139
                r2 = 2
                r8.setType(r2)
                goto L_0x0157
            L_0x0139:
                java.lang.String r5 = r3.getCustomType()
                java.lang.String r6 = "Image"
                boolean r5 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r5)
                if (r5 == 0) goto L_0x0149
                r8.setType(r2)
                goto L_0x0157
            L_0x0149:
                r2 = 4
                r8.setType(r2)
                r2 = r3
                com.sendbird.android.FileMessage r2 = (com.sendbird.android.FileMessage) r2
                java.lang.String r2 = r2.getName()
                r8.setContent(r2)
            L_0x0157:
                com.sendbird.android.FileMessage r3 = (com.sendbird.android.FileMessage) r3
                com.sendbird.android.Sender r2 = r3.getSender()
                if (r2 == 0) goto L_0x016d
                java.lang.String r3 = r2.getNickname()
                r8.setTitle(r3)
                java.lang.String r2 = r2.getUserId()
                r8.setUserId(r2)
            L_0x016d:
                com.sendbird.android.shadow.com.google.gson.Gson r2 = r1.f42168c
                if (r2 != 0) goto L_0x0174
                kotlin.g.b.k.a()
            L_0x0174:
                java.lang.String r8 = r2.toJson((java.lang.Object) r8)
                r4.setData((java.lang.String) r8)
                com.paytm.android.chat.data.repository.ChatRepository r8 = r1.f42174i
                java.lang.String r2 = r1.f42169d
                if (r2 != 0) goto L_0x0184
                kotlin.g.b.k.a()
            L_0x0184:
                io.reactivex.rxjava3.a.l r8 = r8.getLocalChannelById(r2)
                com.paytm.android.chat.h.a$ax r2 = new com.paytm.android.chat.h.a$ax
                r2.<init>(r1, r4)
                io.reactivex.rxjava3.d.h r2 = (io.reactivex.rxjava3.d.h) r2
                io.reactivex.rxjava3.a.p r8 = r8.a(r2)
                io.reactivex.rxjava3.a.x r2 = io.reactivex.rxjava3.i.a.b()
                io.reactivex.rxjava3.a.p r8 = r8.subscribeOn(r2)
                io.reactivex.rxjava3.a.x r2 = io.reactivex.rxjava3.android.b.a.a()
                io.reactivex.rxjava3.a.p r8 = r8.observeOn(r2)
                com.paytm.android.chat.h.a$ay r2 = new com.paytm.android.chat.h.a$ay
                r2.<init>(r1)
                io.reactivex.rxjava3.d.g r2 = (io.reactivex.rxjava3.d.g) r2
                com.paytm.android.chat.h.a$az r3 = new com.paytm.android.chat.h.a$az
                r3.<init>(r1)
                io.reactivex.rxjava3.d.g r3 = (io.reactivex.rxjava3.d.g) r3
                r8.subscribe(r2, r3)
                goto L_0x01be
            L_0x01b5:
                com.paytm.android.chat.activity.APCChatActivity r1 = r7.f41542a
                com.paytm.android.chat.h.a r1 = r1.c()
                r1.c((java.lang.String) r8)
            L_0x01be:
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                com.paytm.android.chat.view.ReplyView r8 = r8.s
                if (r8 == 0) goto L_0x01cf
                boolean r1 = r8.a()
                if (r1 == 0) goto L_0x01cf
                r8.setReply(r0)
            L_0x01cf:
                com.paytm.android.chat.activity.APCChatActivity r8 = r7.f41542a
                com.paytm.android.chat.view.input.ChatEditText r8 = r8.p
                if (r8 == 0) goto L_0x01de
                java.lang.String r0 = ""
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                r8.setText(r0)
            L_0x01de:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.f.onClick(android.view.View):void");
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41543a;

        g(APCChatActivity aPCChatActivity) {
            this.f41543a = aPCChatActivity;
        }

        public final void onClick(View view) {
            if (FastClickUtil.isFastClick()) {
                this.f41543a.c(0);
                TextView y = this.f41543a.t;
                if (y != null) {
                    y.setVisibility(8);
                }
                TextView z = this.f41543a.u;
                if (z != null) {
                    z.setVisibility(8);
                }
            }
        }
    }

    static final class h implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41544a;

        h(APCChatActivity aPCChatActivity) {
            this.f41544a = aPCChatActivity;
        }

        public final void onClick(View view) {
            if (FastClickUtil.isFastClick()) {
                TextView z = this.f41544a.u;
                if (z != null) {
                    z.setVisibility(8);
                }
                TextView y = this.f41544a.t;
                Object tag = y != null ? y.getTag() : null;
                if (tag != null && (tag instanceof Integer) && this.f41544a.o != null) {
                    this.f41544a.c(((Number) tag).intValue());
                }
            }
        }
    }

    public static final class i implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41545a;

        public final void afterTextChanged(Editable editable) {
            kotlin.g.b.k.c(editable, "s");
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            kotlin.g.b.k.c(charSequence, "s");
        }

        i(APCChatActivity aPCChatActivity) {
            this.f41545a = aPCChatActivity;
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            com.paytm.android.chat.view.a.a B;
            kotlin.g.b.k.c(charSequence, "s");
            this.f41545a.f41476d.removeMessages(2);
            boolean z = true;
            Editable editable = null;
            if (charSequence.length() == 0) {
                this.f41545a.c().a(false);
            } else {
                this.f41545a.f41476d.sendEmptyMessageDelayed(2, 1000);
                if (this.f41545a.af != null) {
                    com.paytm.android.chat.view.a.a B2 = this.f41545a.af;
                    Boolean valueOf = B2 != null ? Boolean.valueOf(B2.isShowing()) : null;
                    if (valueOf == null) {
                        kotlin.g.b.k.a();
                    }
                    if (valueOf.booleanValue() && (B = this.f41545a.af) != null) {
                        B.dismiss();
                    }
                }
                com.paytm.android.chat.a.f fVar = this.f41545a.f41475c;
                if (fVar != null) {
                    fVar.c();
                }
            }
            ChatEditText t = this.f41545a.p;
            if (t != null) {
                editable = t.getText();
            }
            if (String.valueOf(editable).length() != 0) {
                z = false;
            }
            if (z) {
                ImageView C = this.f41545a.q;
                if (C != null) {
                    ImageView C2 = this.f41545a.q;
                    if (C2 == null) {
                        kotlin.g.b.k.a();
                    }
                    C.setBackground(androidx.core.content.b.a(C2.getContext(), R.drawable.chat_shape_send_bg_inactive));
                    return;
                }
                return;
            }
            ImageView C3 = this.f41545a.q;
            if (C3 != null) {
                ImageView C4 = this.f41545a.q;
                if (C4 == null) {
                    kotlin.g.b.k.a();
                }
                C3.setBackground(androidx.core.content.b.a(C4.getContext(), R.drawable.chat_shape_send_bg_active));
            }
        }
    }

    public static final class j implements f.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41546a;

        j(APCChatActivity aPCChatActivity) {
            this.f41546a = aPCChatActivity;
        }

        public final void a(BaseMessage baseMessage) {
            kotlin.g.b.k.c(baseMessage, "baseMessage");
            this.f41546a.c().b(baseMessage);
        }

        public final void b(BaseMessage baseMessage) {
            kotlin.g.b.k.c(baseMessage, "baseMessage");
            com.paytm.android.chat.h.a b2 = this.f41546a.c();
            kotlin.g.b.k.c(baseMessage, "message");
            if (b2.f42166a != null) {
                String str = b2.f42169d;
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                if (com.paytm.android.chat.d.a.b.a(str) != null) {
                    String str2 = b2.f42169d;
                    if (str2 == null) {
                        kotlin.g.b.k.a();
                    }
                    GroupChannel a2 = com.paytm.android.chat.d.a.b.a(str2);
                    b2.f42171f.onNext(new a.v());
                    if (baseMessage instanceof UserMessage) {
                        ChatRepository chatRepository = b2.f42174i;
                        if (a2 == null) {
                            kotlin.g.b.k.a();
                        }
                        chatRepository.resendUserMessage(a2, (UserMessage) baseMessage).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new a.al(a2), a.am.f42206a);
                    } else if (baseMessage instanceof FileMessage) {
                        try {
                            String data = baseMessage.getData();
                            Gson gson = b2.f42168c;
                            if (gson == null) {
                                kotlin.g.b.k.a();
                            }
                            FileDataBean fileDataBean = (FileDataBean) gson.fromJson(data, FileDataBean.class);
                            if (fileDataBean != null) {
                                String str3 = fileDataBean.path;
                                if (!TextUtils.isEmpty(str3)) {
                                    File file = new File(str3);
                                    if (!file.exists() || a2 == null) {
                                        b2.b(baseMessage);
                                    } else {
                                        b2.f42174i.resendFileMessage(a2, (FileMessage) baseMessage, file).subscribeOn(io.reactivex.rxjava3.i.a.b()).observeOn(io.reactivex.rxjava3.android.b.a.a()).subscribe(new a.an(b2, a2), new a.ao(b2));
                                    }
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0059  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.sendbird.android.FileMessage r6) {
            /*
                r5 = this;
                java.lang.String r0 = "baseMessage"
                kotlin.g.b.k.c(r6, r0)
                com.paytm.android.chat.activity.APCChatActivity r1 = r5.f41546a
                com.paytm.android.chat.h.a r1 = r1.c()
                kotlin.g.b.k.c(r6, r0)
                java.lang.String r0 = r6.getData()
                r2 = 0
                com.sendbird.android.shadow.com.google.gson.Gson r3 = r1.f42168c     // Catch:{ Exception -> 0x0027 }
                if (r3 != 0) goto L_0x001a
                kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0027 }
            L_0x001a:
                java.lang.Class<com.paytm.android.chat.bean.jsonbean.FileDataBean> r4 = com.paytm.android.chat.bean.jsonbean.FileDataBean.class
                java.lang.Object r0 = r3.fromJson((java.lang.String) r0, r4)     // Catch:{ Exception -> 0x0027 }
                com.paytm.android.chat.bean.jsonbean.FileDataBean r0 = (com.paytm.android.chat.bean.jsonbean.FileDataBean) r0     // Catch:{ Exception -> 0x0027 }
                if (r0 == 0) goto L_0x0027
                java.lang.String r0 = r0.path     // Catch:{ Exception -> 0x0027 }
                goto L_0x0028
            L_0x0027:
                r0 = r2
            L_0x0028:
                r3 = r0
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 != 0) goto L_0x0059
                java.io.File r3 = new java.io.File
                r3.<init>(r0)
                boolean r3 = r3.exists()
                if (r3 == 0) goto L_0x0059
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r1 = r1.f42171f
                if (r0 == 0) goto L_0x0055
                com.paytm.android.chat.g.a$k r2 = new com.paytm.android.chat.g.a$k
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r6 = r6.getRequestId()
                r3.append(r6)
                java.lang.String r6 = r3.toString()
                r2.<init>(r0, r6)
            L_0x0055:
                r1.onNext(r2)
                return
            L_0x0059:
                java.io.File r0 = new java.io.File
                java.lang.String r2 = "audio"
                java.lang.String r2 = r1.d((java.lang.String) r2)
                java.lang.String r3 = r6.getName()
                r0.<init>(r2, r3)
                boolean r2 = r0.exists()
                if (r2 == 0) goto L_0x0092
                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> r1 = r1.f42171f
                com.paytm.android.chat.g.a$k r2 = new com.paytm.android.chat.g.a$k
                java.lang.String r0 = r0.getAbsolutePath()
                java.lang.String r3 = "file.absolutePath"
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r6 = r6.getRequestId()
                r3.append(r6)
                java.lang.String r6 = r3.toString()
                r2.<init>(r0, r6)
                r1.onNext(r2)
                return
            L_0x0092:
                r0 = 0
                r1.a((com.sendbird.android.FileMessage) r6, (boolean) r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.j.a(com.sendbird.android.FileMessage):void");
        }

        public final void a() {
            this.f41546a.s();
        }

        public final void a(int i2) {
            MediaPlayerService mediaPlayerService;
            if (this.f41546a.ad && (mediaPlayerService = this.f41546a.f41477e) != null) {
                mediaPlayerService.a(i2);
            }
        }

        public final void b(FileMessage fileMessage) {
            kotlin.g.b.k.c(fileMessage, "message");
            if (this.f41546a.r()) {
                this.f41546a.c().b(fileMessage);
            }
        }

        public final void c(FileMessage fileMessage) {
            kotlin.g.b.k.c(fileMessage, "message");
            com.paytm.android.chat.h.a b2 = this.f41546a.c();
            kotlin.g.b.k.c(fileMessage, "message");
            String data = fileMessage.getData();
            Gson gson = b2.f42168c;
            if (gson == null) {
                kotlin.g.b.k.a();
            }
            FileDataBean fileDataBean = (FileDataBean) gson.fromJson(data, FileDataBean.class);
            if (fileDataBean != null) {
                File file = new File(fileDataBean.path);
                if (!file.exists()) {
                    b2.b(fileMessage);
                } else if (kotlin.g.b.k.a((Object) "Image", (Object) fileMessage.getCustomType())) {
                    b2.a(fileMessage);
                } else {
                    b2.f42171f.onNext(new a.ab(file));
                }
            }
        }

        public final void a(long j) {
            int intValue;
            RecyclerView A;
            com.paytm.android.chat.a.f fVar = this.f41546a.f41475c;
            Integer valueOf = fVar != null ? Integer.valueOf(fVar.a(j)) : null;
            if (valueOf != null && (intValue = valueOf.intValue()) > 0 && (A = this.f41546a.o) != null) {
                A.smoothScrollToPosition(intValue);
            }
        }

        public final void a(UserMessage userMessage) {
            kotlin.g.b.k.c(userMessage, "message");
            if (!this.f41546a.isFinishing() && !this.f41546a.isDestroyed()) {
                Intent intent = new Intent(this.f41546a, SendOrAddContactsActivity.class);
                intent.putExtra("IS_ADD", true);
                intent.putExtra("SELECTED_CONTACTS", userMessage.getData());
                this.f41546a.startActivity(intent);
            }
        }

        public final void c(BaseMessage baseMessage) {
            kotlin.g.b.k.c(baseMessage, "message");
            if (baseMessage.getMessageId() != 0 && this.f41546a.s != null) {
                View q = this.f41546a.K;
                if (q != null) {
                    q.setVisibility(4);
                }
                ReplyView x = this.f41546a.s;
                if (x == null || x.getVisibility() != 0) {
                    ReplyView x2 = this.f41546a.s;
                    if (x2 != null) {
                        x2.setReplyMessage(baseMessage);
                        return;
                    }
                    return;
                }
                ReplyView x3 = this.f41546a.s;
                if (x3 != null) {
                    x3.setReply(false);
                }
            }
        }

        public final void d(FileMessage fileMessage) {
            kotlin.g.b.k.c(fileMessage, "message");
            if (APCChatActivity.F(this.f41546a)) {
                this.f41546a.c().a(fileMessage, false);
            }
        }

        public final void a(String str, String str2, String str3) {
            com.paytm.android.chat.d G;
            if (this.f41546a.ao != null && (G = this.f41546a.ao) != null) {
                G.a((Context) this.f41546a, str, str2, str3);
            }
        }

        public final void a(String str, String str2) {
            ChatType chatType;
            String name;
            ChatGroupChannelDataModel chatGroupChannelDataModel;
            kotlin.g.b.k.c(str, "message");
            kotlin.g.b.k.c(str2, "source");
            this.f41546a.c().c(str);
            ReceiverDisplayInfo e2 = this.f41546a.c().e();
            if (e2 != null && (chatType = e2.getChatType()) != null && (name = chatType.name()) != null && (chatGroupChannelDataModel = this.f41546a.c().f42166a) != null) {
                ChatAnalyticsHelperKt.firePaymentQuickReplyClickEvent(this.f41546a, chatGroupChannelDataModel, name, str, str2);
            }
        }

        public final void a(AdminMessageBean adminMessageBean) {
            CtaType type;
            kotlin.g.b.k.c(adminMessageBean, "adminMessageBean");
            try {
                AdminMessageBean.CTADetail myAdminMessageCtaDetails = AppUtilKt.getMyAdminMessageCtaDetails(adminMessageBean);
                if (myAdminMessageCtaDetails != null && (type = myAdminMessageCtaDetails.getType()) != null) {
                    int i2 = a.f41754a[type.ordinal()];
                    if (i2 == 1) {
                        com.paytm.android.chat.d G = this.f41546a.ao;
                        if (G != null) {
                            G.a(this.f41546a, myAdminMessageCtaDetails.getDeeplink());
                        }
                    } else if (i2 == 2) {
                        APCChatActivity aPCChatActivity = this.f41546a;
                        kotlin.g.b.k.c(myAdminMessageCtaDetails, "ctaDetail");
                        try {
                            MerchantFirstUserChatBS merchantFirstUserChatBS = aPCChatActivity.f41474b;
                            if (merchantFirstUserChatBS != null) {
                                merchantFirstUserChatBS.f41815a.dismiss();
                            }
                            aPCChatActivity.f41474b = new MerchantFirstUserChatBS(aPCChatActivity, myAdminMessageCtaDetails.getImageUrl(), myAdminMessageCtaDetails.getTitle(), myAdminMessageCtaDetails.getDescription(), myAdminMessageCtaDetails.getBtnText());
                            MerchantFirstUserChatBS merchantFirstUserChatBS2 = aPCChatActivity.f41474b;
                            if (merchantFirstUserChatBS2 != null) {
                                merchantFirstUserChatBS2.f41815a.show();
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
        }

        public final void a(String str) {
            kotlin.g.b.k.c(str, "deeplink");
            try {
                com.paytm.android.chat.d G = this.f41546a.ao;
                if (G != null) {
                    G.a(this.f41546a, str);
                }
            } catch (Exception unused) {
            }
        }

        public final void a(CTA cta, ChatMessageUPIData chatMessageUPIData) {
            if (this.f41546a.ao != null && chatMessageUPIData != null) {
                String payerVpa = chatMessageUPIData.getPayerVpa();
                if (payerVpa == null) {
                    payerVpa = "";
                }
                String amount = chatMessageUPIData.getAmount();
                if (amount == null) {
                    amount = "";
                }
                String payeeName = chatMessageUPIData.getPayeeName();
                if (payeeName == null) {
                    payeeName = "";
                }
                String payeeVpa = chatMessageUPIData.getPayeeVpa();
                if (payeeVpa == null) {
                    payeeVpa = "";
                }
                String txnId = chatMessageUPIData.getTxnId();
                if (txnId == null) {
                    txnId = "";
                }
                String note = chatMessageUPIData.getNote();
                if (note == null) {
                    note = "";
                }
                new RequestMoneyActionModel(payerVpa, amount, payeeName, payeeVpa, txnId, note);
                CtaType ctaType = cta.getCtaType();
                if (ctaType != null) {
                    int i2 = a.f41755b[ctaType.ordinal()];
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                if (i2 != 4) {
                                    if (i2 == 5 && this.f41546a.R != null) {
                                        TxNotifyData.Companion companion = TxNotifyData.Companion;
                                        String c2 = this.f41546a.R;
                                        if (c2 == null) {
                                            kotlin.g.b.k.a();
                                        }
                                        TxNotifyData createFromChatMessageUPIData = companion.createFromChatMessageUPIData(c2, chatMessageUPIData);
                                        this.f41546a.c();
                                        com.paytm.android.chat.h.a.a(createFromChatMessageUPIData);
                                    }
                                } else if (this.f41546a.ao != null) {
                                    CollectRequestType collectRequestType = CollectRequestType.MARK_AS_SPAM;
                                    CtaType ctaType2 = CtaType.UPI_MARK_AS_SPAM;
                                }
                            } else if (this.f41546a.ao != null) {
                                CollectRequestType collectRequestType2 = CollectRequestType.DECLINE;
                                CtaType ctaType3 = CtaType.UPI_DECLINE;
                            }
                        } else if (this.f41546a.ao != null) {
                            CollectRequestType collectRequestType3 = CollectRequestType.DECLINE;
                            CtaType ctaType4 = CtaType.UPI_CANCEL;
                        }
                    } else if (this.f41546a.ao != null) {
                        CollectRequestType collectRequestType4 = CollectRequestType.PAY;
                        CtaType ctaType5 = CtaType.UPI_PAY;
                    }
                }
            }
        }
    }

    static final class k implements f.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41547a;

        k(APCChatActivity aPCChatActivity) {
            this.f41547a = aPCChatActivity;
        }

        public final void a(int i2) {
            com.paytm.android.chat.view.a.a B;
            this.f41547a.s();
            com.paytm.android.chat.a.f fVar = this.f41547a.f41475c;
            if (fVar == null) {
                kotlin.g.b.k.a();
            }
            fVar.a(i2 > 0);
            if (this.f41547a.af == null) {
                APCChatActivity aPCChatActivity = this.f41547a;
                aPCChatActivity.af = new com.paytm.android.chat.view.a.a(aPCChatActivity);
                com.paytm.android.chat.view.a.a B2 = this.f41547a.af;
                if (B2 != null) {
                    B2.a((a.C0705a) new a.C0705a(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ k f41548a;

                        {
                            this.f41548a = r1;
                        }

                        public final void a() {
                            if (!this.f41548a.f41547a.isDestroyed() && !this.f41548a.f41547a.isFinishing()) {
                                this.f41548a.f41547a.startActivityForResult(new Intent(this.f41548a.f41547a, ChatMultipleSelectSendActivity.class), 304);
                            }
                        }

                        public final void b() {
                            if (this.f41548a.f41547a.f41475c != null) {
                                com.paytm.android.chat.a.f fVar = this.f41548a.f41547a.f41475c;
                                List<BaseMessage> b2 = fVar != null ? fVar.b() : null;
                                StringBuilder sb = new StringBuilder();
                                if (b2 != null) {
                                    for (BaseMessage next : b2) {
                                        if (next instanceof UserMessage) {
                                            sb.append(((UserMessage) next).getMessage());
                                        }
                                    }
                                }
                                com.paytm.android.chat.utils.TextUtils.copyText(this.f41548a.f41547a, sb.toString());
                                com.paytm.android.chat.a.f fVar2 = this.f41548a.f41547a.f41475c;
                                if (fVar2 != null) {
                                    fVar2.c();
                                }
                            }
                        }

                        public final void c() {
                            BaseMessage baseMessage;
                            com.paytm.android.chat.a.f fVar = this.f41548a.f41547a.f41475c;
                            List<BaseMessage> b2 = fVar != null ? fVar.b() : null;
                            if (!(b2 == null || b2.size() != 1 || (baseMessage = b2.get(0)) == null || baseMessage.getMessageId() == 0)) {
                                ReplyView x = this.f41548a.f41547a.s;
                                if (x != null) {
                                    x.setReplyMessage(baseMessage);
                                }
                                View q = this.f41548a.f41547a.K;
                                if (q != null) {
                                    q.setVisibility(4);
                                }
                            }
                            com.paytm.android.chat.a.f fVar2 = this.f41548a.f41547a.f41475c;
                            if (fVar2 != null) {
                                fVar2.c();
                            }
                        }

                        public final void d() {
                            com.paytm.android.chat.a.f fVar = this.f41548a.f41547a.f41475c;
                            if (fVar != null) {
                                fVar.c();
                            }
                        }

                        public final void e() {
                            com.paytm.android.chat.a.f fVar = this.f41548a.f41547a.f41475c;
                            List<BaseMessage> b2 = fVar != null ? fVar.b() : null;
                            if (b2 != null) {
                                com.paytm.android.chat.h.a b3 = this.f41548a.f41547a.c();
                                kotlin.g.b.k.c(b2, StringSet.messages);
                                if (b3.f42166a != null) {
                                    for (BaseMessage a2 : b2) {
                                        b3.a(a2);
                                    }
                                }
                            }
                            com.paytm.android.chat.a.f fVar2 = this.f41548a.f41547a.f41475c;
                            if (fVar2 != null) {
                                fVar2.c();
                            }
                        }

                        public final void f() {
                            com.paytm.android.chat.a.f fVar = this.f41548a.f41547a.f41475c;
                            if (fVar != null) {
                                fVar.c();
                            }
                        }
                    });
                }
            }
            com.paytm.android.chat.view.a.a B3 = this.f41547a.af;
            if (!(B3 == null || B3.isShowing() || (B = this.f41547a.af) == null)) {
                B.showAtLocation(this.f41547a.o, 48, 0, 0);
            }
            com.paytm.android.chat.view.a.a B4 = this.f41547a.af;
            if (B4 != null) {
                com.paytm.android.chat.a.f fVar2 = this.f41547a.f41475c;
                B4.a(fVar2 != null ? fVar2.b() : null);
            }
        }
    }

    static final class l implements f.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41549a;

        l(APCChatActivity aPCChatActivity) {
            this.f41549a = aPCChatActivity;
        }

        public final void a() {
            if (!this.f41549a.isDestroyed() && !this.f41549a.isFinishing()) {
                final ChatOneButtonDialog chatOneButtonDialog = new ChatOneButtonDialog(this.f41549a);
                chatOneButtonDialog.hideTitle();
                Resources resources = this.f41549a.getResources();
                String str = null;
                chatOneButtonDialog.setMessage(resources != null ? resources.getString(R.string.chat_module_unknown_msg_prompt_to_upgrade) : null);
                Resources resources2 = this.f41549a.getResources();
                if (resources2 != null) {
                    str = resources2.getString(R.string.chat_module_button_ok);
                }
                chatOneButtonDialog.setButton(-3, str, new View.OnClickListener() {
                    public final void onClick(View view) {
                        chatOneButtonDialog.dismiss();
                    }
                });
                chatOneButtonDialog.show();
            }
        }
    }

    static final class m implements f.o {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41551a;

        m(APCChatActivity aPCChatActivity) {
            this.f41551a = aPCChatActivity;
        }

        public final void a(List<ChatMessageDataModel> list) {
            com.paytm.android.chat.h.a b2 = this.f41551a.c();
            kotlin.g.b.k.a((Object) list, "mMessageList");
            kotlin.g.b.k.c(list, "mMessageList");
            b2.f42171f.onNext(new a.p(false, (String[]) null));
            Collection collection = list;
            if (!collection.isEmpty()) {
                b2.f42171f.onNext(new a.s(false));
            }
            List arrayList = new ArrayList(collection);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                BaseMessage baseMessage = ((ChatMessageDataModel) arrayList.get(i2)).baseMessage;
                if (baseMessage instanceof UserMessage) {
                    UserMessage userMessage = (UserMessage) baseMessage;
                    if (userMessage.getSender() != null) {
                        Sender sender = userMessage.getSender();
                        kotlin.g.b.k.a((Object) sender, "userMessage.sender");
                        if (sender.getUserId() != null) {
                            Sender sender2 = userMessage.getSender();
                            kotlin.g.b.k.a((Object) sender2, "userMessage.sender");
                            if (kotlin.g.b.k.a((Object) sender2.getUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                                return;
                            }
                            if (kotlin.g.b.k.a((Object) "TRANSFER", (Object) baseMessage.getCustomType())) {
                                Gson gson = new Gson();
                                ChatTransferMessageDataModel chatTransferMessageDataModel = new ChatTransferMessageDataModel();
                                chatTransferMessageDataModel.bean = (PFPaymentStatusBean) gson.fromJson(baseMessage.getData(), PFPaymentStatusBean.class);
                                io.reactivex.rxjava3.j.a<com.paytm.android.chat.g.a> aVar = b2.f42171f;
                                PFPaymentStatusBean pFPaymentStatusBean = chatTransferMessageDataModel.bean;
                                kotlin.g.b.k.a((Object) pFPaymentStatusBean, "uiBean.bean");
                                aVar.onNext(new a.p(true, pFPaymentStatusBean.getReceiverQuickReply()));
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else if (baseMessage instanceof FileMessage) {
                    FileMessage fileMessage = (FileMessage) baseMessage;
                    if (fileMessage.getSender() != null) {
                        Sender sender3 = fileMessage.getSender();
                        kotlin.g.b.k.a((Object) sender3, "fileMessage.sender");
                        if (sender3.getUserId() != null) {
                            Sender sender4 = fileMessage.getSender();
                            kotlin.g.b.k.a((Object) sender4, "fileMessage.sender");
                            if (kotlin.g.b.k.a((Object) sender4.getUserId(), (Object) SharedPreferencesUtil.getUserId())) {
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
    }

    static final class n implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41552a;

        n(APCChatActivity aPCChatActivity) {
            this.f41552a = aPCChatActivity;
        }

        public final void onClick(View view) {
            String c2;
            if (FastClickUtil.isFastClick() && (c2 = this.f41552a.R) != null) {
                APCProfileActivity.a aVar = APCProfileActivity.f41565b;
                APCChatActivity aPCChatActivity = this.f41552a;
                Activity activity = aPCChatActivity;
                String f2 = aPCChatActivity.ap;
                boolean g2 = this.f41552a.aq;
                KycInfo h2 = this.f41552a.ar;
                kotlin.g.b.k.c(f2, "joinDate");
                if (!(activity == null || c2 == null)) {
                    Intent intent = new Intent(activity, APCProfileActivity.class);
                    intent.putExtra("channelUrl", c2);
                    intent.putExtra("dateJoin", f2);
                    intent.putExtra("kyc_verified", g2);
                    intent.putExtra("kyc_info", h2);
                    activity.startActivityForResult(intent, 400);
                }
                ReceiverDisplayInfo e2 = this.f41552a.c().e();
                if (e2 == null) {
                    return;
                }
                if (e2.getProfileImage() != null) {
                    APCChatActivity aPCChatActivity2 = this.f41552a;
                    Context context = aPCChatActivity2;
                    String c3 = aPCChatActivity2.R;
                    if (c3 == null) {
                        kotlin.g.b.k.a();
                    }
                    ChatAnalyticsHelperKt.fireUserProfileClickEvent(context, AppUtilKt.getReceiverDisplayInfo$default(com.paytm.android.chat.d.a.b.a(c3), (SyncContactBean) null, 2, (Object) null).getChatType().name(), true);
                    return;
                }
                APCChatActivity aPCChatActivity3 = this.f41552a;
                Context context2 = aPCChatActivity3;
                String c4 = aPCChatActivity3.R;
                if (c4 == null) {
                    kotlin.g.b.k.a();
                }
                ChatAnalyticsHelperKt.fireUserProfileClickEvent(context2, AppUtilKt.getReceiverDisplayInfo$default(com.paytm.android.chat.d.a.b.a(c4), (SyncContactBean) null, 2, (Object) null).getChatType().name(), false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        if (r11.getUserType() == com.paytm.android.chat.bean.UserType.CHANNEL) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a5 A[Catch:{ Exception -> 0x01d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cf A[Catch:{ Exception -> 0x01d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ec A[Catch:{ Exception -> 0x01d2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r10, com.paytm.android.chat.bean.daobean.SyncContactBean r11) {
        /*
            r9 = this;
            java.lang.String r0 = r10.getDraftMessage()     // Catch:{ Exception -> 0x01d2 }
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x01d2 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x01d2 }
            if (r1 != 0) goto L_0x0016
            com.paytm.android.chat.view.input.ChatEditText r1 = r9.p     // Catch:{ Exception -> 0x01d2 }
            if (r1 == 0) goto L_0x0016
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x01d2 }
            r1.setText(r0)     // Catch:{ Exception -> 0x01d2 }
        L_0x0016:
            java.lang.String r0 = r9.R     // Catch:{ Exception -> 0x01d2 }
            if (r0 != 0) goto L_0x001d
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01d2 }
        L_0x001d:
            com.sendbird.android.GroupChannel r0 = com.paytm.android.chat.d.a.b.a(r0)     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.bean.ReceiverDisplayInfo r11 = com.paytm.android.chat.utils.AppUtilKt.getReceiverDisplayInfo(r0, r11)     // Catch:{ Exception -> 0x01d2 }
            int r0 = com.paytm.android.chat.R.id.imageBlueTickName     // Catch:{ Exception -> 0x01d2 }
            android.view.View r0 = r9.findViewById(r0)     // Catch:{ Exception -> 0x01d2 }
            int r1 = com.paytm.android.chat.R.id.layoutBusinessName     // Catch:{ Exception -> 0x01d2 }
            android.view.View r1 = r9.findViewById(r1)     // Catch:{ Exception -> 0x01d2 }
            int r2 = com.paytm.android.chat.R.id.textBusinessName     // Catch:{ Exception -> 0x01d2 }
            android.view.View r2 = r9.findViewById(r2)     // Catch:{ Exception -> 0x01d2 }
            android.widget.TextView r2 = (android.widget.TextView) r2     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.bean.UserType r3 = r11.getUserType()     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.bean.UserType r4 = com.paytm.android.chat.bean.UserType.MERCHANT     // Catch:{ Exception -> 0x01d2 }
            r5 = 1
            r6 = 0
            java.lang.String r7 = "imageNameBlueTick"
            r8 = 8
            if (r3 == r4) goto L_0x004f
            com.paytm.android.chat.bean.UserType r3 = r11.getUserType()     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.bean.UserType r4 = com.paytm.android.chat.bean.UserType.CHANNEL     // Catch:{ Exception -> 0x01d2 }
            if (r3 != r4) goto L_0x00c5
        L_0x004f:
            boolean r3 = r11.isFromContact()     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r4 = "layoutBusinessName"
            if (r3 == 0) goto L_0x0097
            java.lang.String r3 = r11.getBusinessName()     // Catch:{ Exception -> 0x01d2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x01d2 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x01d2 }
            if (r3 != 0) goto L_0x0097
            java.lang.String r3 = "textBusinessName"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r3 = r11.getBusinessName()     // Catch:{ Exception -> 0x01d2 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x01d2 }
            r2.setText(r3)     // Catch:{ Exception -> 0x01d2 }
            android.widget.TextView r2 = r9.l     // Catch:{ Exception -> 0x01d2 }
            if (r2 != 0) goto L_0x0079
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01d2 }
        L_0x0079:
            r2.setVisibility(r8)     // Catch:{ Exception -> 0x01d2 }
            r9.X = r6     // Catch:{ Exception -> 0x01d2 }
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x01d2 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r2 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.utils.ChatConfigUtil r2 = r2.getInstance()     // Catch:{ Exception -> 0x01d2 }
            boolean r2 = r2.isConsumer()     // Catch:{ Exception -> 0x01d2 }
            if (r2 == 0) goto L_0x009f
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x01d2 }
            r1.setVisibility(r6)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x009f
        L_0x0097:
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)     // Catch:{ Exception -> 0x01d2 }
            r1.setVisibility(r8)     // Catch:{ Exception -> 0x01d2 }
            r9.X = r5     // Catch:{ Exception -> 0x01d2 }
        L_0x009f:
            boolean r1 = r11.isFromContact()     // Catch:{ Exception -> 0x01d2 }
            if (r1 != 0) goto L_0x00c5
            boolean r1 = r11.isBusinessNameAvailable()     // Catch:{ Exception -> 0x01d2 }
            if (r1 == 0) goto L_0x00be
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r1 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.utils.ChatConfigUtil r1 = r1.getInstance()     // Catch:{ Exception -> 0x01d2 }
            boolean r1 = r1.isConsumer()     // Catch:{ Exception -> 0x01d2 }
            if (r1 == 0) goto L_0x00cb
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x01d2 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x00cb
        L_0x00be:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x01d2 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x00cb
        L_0x00c5:
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x01d2 }
            r0.setVisibility(r8)     // Catch:{ Exception -> 0x01d2 }
        L_0x00cb:
            com.paytm.android.chat.bean.FriendBean r1 = r9.at     // Catch:{ Exception -> 0x01d2 }
            if (r1 == 0) goto L_0x00ec
            android.widget.TextView r10 = r9.k     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x00dc
            java.lang.String r11 = r1.getName()     // Catch:{ Exception -> 0x01d2 }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ Exception -> 0x01d2 }
            r10.setText(r11)     // Catch:{ Exception -> 0x01d2 }
        L_0x00dc:
            com.paytm.android.chat.view.ChatHeadView r10 = r9.j     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x00eb
            java.lang.String r11 = r1.getPhoto()     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r0 = r1.getName()     // Catch:{ Exception -> 0x01d2 }
            r10.setUI(r11, r0)     // Catch:{ Exception -> 0x01d2 }
        L_0x00eb:
            return
        L_0x00ec:
            android.widget.TextView r1 = r9.k     // Catch:{ Exception -> 0x01d2 }
            if (r1 == 0) goto L_0x00f9
            java.lang.String r2 = r11.getName()     // Catch:{ Exception -> 0x01d2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01d2 }
            r1.setText(r2)     // Catch:{ Exception -> 0x01d2 }
        L_0x00f9:
            com.paytm.android.chat.data.models.users.ChatUserDataModel r1 = com.paytm.android.chat.utils.ChatVariantUtilKt.getChannelDisplayMember((com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r10)     // Catch:{ Exception -> 0x01d2 }
            if (r1 == 0) goto L_0x013e
            com.paytm.android.chat.bean.UserMetaData r2 = r1.getUserMetaData()     // Catch:{ Exception -> 0x01d2 }
            if (r2 != 0) goto L_0x0108
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01d2 }
        L_0x0108:
            java.lang.String r3 = r2.getName()     // Catch:{ Exception -> 0x01d2 }
            if (r3 == 0) goto L_0x0131
            android.widget.TextView r3 = r9.k     // Catch:{ Exception -> 0x01d2 }
            if (r3 != 0) goto L_0x0115
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x01d2 }
        L_0x0115:
            java.lang.String r2 = r2.getName()     // Catch:{ Exception -> 0x01d2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01d2 }
            r3.setText(r2)     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.utils.ChatConfigUtil$Companion r2 = com.paytm.android.chat.utils.ChatConfigUtil.Companion     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.utils.ChatConfigUtil r2 = r2.getInstance()     // Catch:{ Exception -> 0x01d2 }
            boolean r2 = r2.isConsumer()     // Catch:{ Exception -> 0x01d2 }
            if (r2 == 0) goto L_0x013e
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)     // Catch:{ Exception -> 0x01d2 }
            r0.setVisibility(r6)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x013e
        L_0x0131:
            android.widget.TextView r0 = r9.k     // Catch:{ Exception -> 0x01d2 }
            if (r0 == 0) goto L_0x013e
            java.lang.String r2 = r1.getSendbirdUsername()     // Catch:{ Exception -> 0x01d2 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x01d2 }
            r0.setText(r2)     // Catch:{ Exception -> 0x01d2 }
        L_0x013e:
            if (r1 == 0) goto L_0x0151
            com.paytm.android.chat.view.ChatHeadView r10 = r9.j     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x01cf
            java.lang.String r11 = r1.getAvatarUrl()     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r0 = r1.getSendbirdUsername()     // Catch:{ Exception -> 0x01d2 }
            r10.setUI(r11, r0)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x01cf
        L_0x0151:
            com.paytm.android.chat.bean.ChatType r0 = r11.getChatType()     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.bean.ChatType r1 = com.paytm.android.chat.bean.ChatType.P2BK     // Catch:{ Exception -> 0x01d2 }
            if (r0 == r1) goto L_0x017a
            com.paytm.android.chat.bean.ChatType r0 = r11.getChatType()     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.bean.ChatType r1 = com.paytm.android.chat.bean.ChatType.P2VPA     // Catch:{ Exception -> 0x01d2 }
            if (r0 == r1) goto L_0x017a
            com.paytm.android.chat.bean.ChatType r0 = r11.getChatType()     // Catch:{ Exception -> 0x01d2 }
            com.paytm.android.chat.bean.ChatType r1 = com.paytm.android.chat.bean.ChatType.P2VPAM     // Catch:{ Exception -> 0x01d2 }
            if (r0 != r1) goto L_0x016a
            goto L_0x017a
        L_0x016a:
            com.paytm.android.chat.view.ChatHeadView r10 = r9.j     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x01cf
            java.lang.String r0 = r11.getProfileImage()     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r11 = r11.getName()     // Catch:{ Exception -> 0x01d2 }
            r10.setUI(r0, r11)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x01cf
        L_0x017a:
            java.util.List r10 = r10.getMembers()     // Catch:{ Exception -> 0x01d2 }
            java.lang.Iterable r10 = (java.lang.Iterable) r10     // Catch:{ Exception -> 0x01d2 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x01d2 }
        L_0x0184:
            boolean r0 = r10.hasNext()     // Catch:{ Exception -> 0x01d2 }
            if (r0 == 0) goto L_0x0199
            java.lang.Object r0 = r10.next()     // Catch:{ Exception -> 0x01d2 }
            r1 = r0
            com.paytm.android.chat.data.models.users.ChatUserDataModel r1 = (com.paytm.android.chat.data.models.users.ChatUserDataModel) r1     // Catch:{ Exception -> 0x01d2 }
            boolean r1 = r1.isMe()     // Catch:{ Exception -> 0x01d2 }
            r1 = r1 ^ r5
            if (r1 == 0) goto L_0x0184
            goto L_0x019a
        L_0x0199:
            r0 = 0
        L_0x019a:
            com.paytm.android.chat.data.models.users.ChatUserDataModel r0 = (com.paytm.android.chat.data.models.users.ChatUserDataModel) r0     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r10 = com.paytm.android.chat.utils.ChatVariantUtilKt.getPaymentInfoHeaderText(r0)     // Catch:{ Exception -> 0x01d2 }
            r0 = r10
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x01d2 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x01d2 }
            if (r0 != 0) goto L_0x01c1
            android.widget.TextView r0 = r9.m     // Catch:{ Exception -> 0x01d2 }
            if (r0 == 0) goto L_0x01b2
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10     // Catch:{ Exception -> 0x01d2 }
            r0.setText(r10)     // Catch:{ Exception -> 0x01d2 }
        L_0x01b2:
            android.widget.TextView r10 = r9.m     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x01b9
            r10.setVisibility(r6)     // Catch:{ Exception -> 0x01d2 }
        L_0x01b9:
            android.widget.TextView r10 = r9.l     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x01c8
            r10.setVisibility(r8)     // Catch:{ Exception -> 0x01d2 }
            goto L_0x01c8
        L_0x01c1:
            android.widget.TextView r10 = r9.m     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x01c8
            r10.setVisibility(r8)     // Catch:{ Exception -> 0x01d2 }
        L_0x01c8:
            com.paytm.android.chat.view.ChatHeadView r10 = r9.j     // Catch:{ Exception -> 0x01d2 }
            if (r10 == 0) goto L_0x01cf
            r10.setOnlinePaymentUI(r11)     // Catch:{ Exception -> 0x01d2 }
        L_0x01cf:
            r9.k()     // Catch:{ Exception -> 0x01d2 }
        L_0x01d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.a(com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel, com.paytm.android.chat.bean.daobean.SyncContactBean):void");
    }

    static final class aa<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41480a;

        aa(APCChatActivity aPCChatActivity) {
            this.f41480a = aPCChatActivity;
        }

        public final /* synthetic */ void accept(Object obj) {
            this.f41480a.finish();
        }
    }

    public static final class be implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41532a;

        be(APCChatActivity aPCChatActivity) {
            this.f41532a = aPCChatActivity;
        }

        static final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ be f41534a;

            b(be beVar) {
                this.f41534a = beVar;
            }

            public final void run() {
                APCChatActivity.I(this.f41534a.f41532a);
            }
        }

        public final void a() {
            this.f41532a.av = true;
            TextView H = this.f41532a.G;
            if (H != null) {
                H.post(new b(this));
            }
        }

        static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ be f41533a;

            a(be beVar) {
                this.f41533a = beVar;
            }

            public final void run() {
                APCChatActivity.J(this.f41533a.f41532a);
            }
        }

        public final void b() {
            this.f41532a.av = false;
            TextView H = this.f41532a.G;
            if (H != null) {
                H.post(new a(this));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void k() {
        /*
            r5 = this;
            com.paytm.android.chat.h.a r0 = r5.c()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = r0.f42166a
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0053
            boolean r0 = r5.au
            if (r0 == 0) goto L_0x003a
            com.paytm.android.chat.h.a r0 = r5.c()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = r0.f42166a
            if (r0 == 0) goto L_0x001b
            boolean r0 = r0.isPayAllowed()
            goto L_0x001c
        L_0x001b:
            r0 = 0
        L_0x001c:
            if (r0 == 0) goto L_0x0038
            com.paytm.android.chat.h.a r0 = r5.c()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r0.e()
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = r0.getPhoneNumber()
            if (r0 == 0) goto L_0x0033
            java.lang.String r0 = com.paytm.android.chat.f.a((java.lang.String) r0)
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            if (r0 == 0) goto L_0x0038
            r0 = 1
            goto L_0x0046
        L_0x0038:
            r0 = 0
            goto L_0x0046
        L_0x003a:
            com.paytm.android.chat.h.a r0 = r5.c()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r0 = r0.f42166a
            if (r0 == 0) goto L_0x0038
            boolean r0 = r0.isPayAllowed()
        L_0x0046:
            com.paytm.android.chat.h.a r3 = r5.c()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r3 = r3.f42166a
            if (r3 == 0) goto L_0x0054
            boolean r3 = r3.isRequestAllowed()
            goto L_0x0055
        L_0x0053:
            r0 = 1
        L_0x0054:
            r3 = 0
        L_0x0055:
            com.paytm.android.chat.view.PayButtonView r4 = r5.H
            if (r4 != 0) goto L_0x005c
            kotlin.g.b.k.a()
        L_0x005c:
            android.view.View r4 = (android.view.View) r4
            com.paytm.android.chat.f.a((android.view.View) r4, (boolean) r0)
            r5.ak = r3
            if (r0 == 0) goto L_0x0078
            r5.Z = r1
            android.widget.TextView r0 = r5.G
            if (r0 != 0) goto L_0x006e
            kotlin.g.b.k.a()
        L_0x006e:
            int r0 = r0.getVisibility()
            if (r0 == 0) goto L_0x007f
            r5.b((int) r2)
            return
        L_0x0078:
            r5.Z = r2
            r0 = 8
            r5.b((int) r0)
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.k():void");
    }

    private final void b(int i2) {
        TextView textView = this.G;
        if (textView == null) {
            kotlin.g.b.k.a();
        }
        textView.setVisibility(i2);
    }

    /* access modifiers changed from: private */
    public final void a(boolean z2) {
        ChatEditText chatEditText = this.p;
        if (chatEditText != null) {
            chatEditText.setEnabled(z2);
        }
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setEnabled(z2);
        }
        TextView textView = this.G;
        if (textView != null) {
            textView.setEnabled(z2);
        }
    }

    static final class au implements MediaPlayerService.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41515a;

        au(APCChatActivity aPCChatActivity) {
            this.f41515a = aPCChatActivity;
        }

        public final void a(MediaPlayer mediaPlayer) {
            if (mediaPlayer != null) {
                mediaPlayer.stop();
                mediaPlayer.reset();
                this.f41515a.aw = "";
                this.f41515a.ax = "";
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c(int i2) {
        RecyclerView recyclerView = this.o;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(i2);
        }
    }

    /* access modifiers changed from: private */
    public final String l() {
        Editable editable;
        ChatEditText chatEditText = this.p;
        if (chatEditText == null) {
            return "";
        }
        if (chatEditText != null) {
            editable = chatEditText.getText();
        } else {
            editable = null;
        }
        CharSequence valueOf = String.valueOf(editable);
        int length = valueOf.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean z3 = valueOf.charAt(!z2 ? i2 : length) <= ' ';
            if (z2) {
                if (!z3) {
                    break;
                }
                length--;
            } else if (!z3) {
                z2 = true;
            } else {
                i2++;
            }
        }
        return valueOf.subSequence(i2, length + 1).toString();
    }

    static final class bg implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.paytm.android.chat.a.f f41536a;

        bg(com.paytm.android.chat.a.f fVar) {
            this.f41536a = fVar;
        }

        public final void run() {
            this.f41536a.a();
        }
    }

    private final void m() {
        c().g().a(new al(this)).a(new am(this)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new an(this), (io.reactivex.rxjava3.d.g<? super Throwable>) ao.f41507a);
    }

    /* access modifiers changed from: private */
    public final void a(String str) {
        if (!com.paytm.android.chat.f.a((Activity) this)) {
            Toast.makeText(this, str, 1).show();
        }
    }

    private final void a(String str, int i2) {
        try {
            Snackbar a2 = Snackbar.a(findViewById(R.id.resizelayout), (CharSequence) str, -2);
            a2.a(R.string.chat_button_ok, (View.OnClickListener) bi.f41538a);
            a2.b().setBackgroundColor(i2);
            View findViewById = a2.b().findViewById(com.google.android.material.R.id.snackbar_text);
            if (findViewById != null) {
                ((TextView) findViewById).setMaxLines(20);
                View findViewById2 = a2.b().findViewById(com.google.android.material.R.id.snackbar_text);
                if (findViewById2 != null) {
                    ((TextView) findViewById2).setTextColor(-1);
                    View findViewById3 = a2.b().findViewById(com.google.android.material.R.id.snackbar_action);
                    if (findViewById3 != null) {
                        ((TextView) findViewById3).setTextColor(-1);
                        a2.c();
                        return;
                    }
                    throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.TextView");
        } catch (Exception unused) {
            com.paytm.utility.q.a();
        }
    }

    /* access modifiers changed from: private */
    public final void b(String str) {
        if (getIntent().hasExtra("payment.txn.detail")) {
            Serializable serializableExtra = getIntent().getSerializableExtra("payment.txn.detail");
            if (!(serializableExtra instanceof MTSDKPostPaymentResponse)) {
                serializableExtra = null;
            }
            MTSDKPostPaymentResponse mTSDKPostPaymentResponse = (MTSDKPostPaymentResponse) serializableExtra;
            if (mTSDKPostPaymentResponse == null) {
                return;
            }
            if (kotlin.m.p.a("SUCCESS", mTSDKPostPaymentResponse.getTransactionStatus(), true) || kotlin.m.p.a("PENDING", mTSDKPostPaymentResponse.getTransactionStatus(), true)) {
                TxNotifyData createFromPaymentResponse = TxNotifyData.Companion.createFromPaymentResponse(str, mTSDKPostPaymentResponse);
                c();
                com.paytm.android.chat.h.a.a(createFromPaymentResponse);
            }
        }
    }

    static final class ay implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41516a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f41517b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ChatGroupChannelDataModel f41518c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h.b f41519d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f41520e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ boolean f41521f;

        ay(APCChatActivity aPCChatActivity, List list, ChatGroupChannelDataModel chatGroupChannelDataModel, h.b bVar, boolean z, boolean z2) {
            this.f41516a = aPCChatActivity;
            this.f41517b = list;
            this.f41518c = chatGroupChannelDataModel;
            this.f41519d = bVar;
            this.f41520e = z;
            this.f41521f = z2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
            if (r0 != false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0017, code lost:
            r2 = r0.computeVerticalScrollRange();
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                com.paytm.android.chat.activity.APCChatActivity r0 = r5.f41516a
                androidx.recyclerview.widget.RecyclerView r0 = r0.o
                if (r0 == 0) goto L_0x0063
                r1 = 0
                r0.setVisibility(r1)
                boolean r2 = r5.f41520e
                r3 = 1
                if (r2 == 0) goto L_0x002c
                boolean r2 = r5.f41521f
                if (r2 != 0) goto L_0x002d
                if (r0 == 0) goto L_0x0028
                int r2 = r0.computeVerticalScrollRange()
                int r4 = r0.computeVerticalScrollOffset()
                int r0 = r0.computeVerticalScrollExtent()
                int r4 = r4 + r0
                if (r4 < r2) goto L_0x0028
                r0 = 1
                goto L_0x0029
            L_0x0028:
                r0 = 0
            L_0x0029:
                if (r0 == 0) goto L_0x002c
                goto L_0x002d
            L_0x002c:
                r3 = 0
            L_0x002d:
                com.paytm.android.chat.activity.APCChatActivity r0 = r5.f41516a
                androidx.recyclerview.widget.LinearLayoutManager r0 = r0.N
                if (r0 == 0) goto L_0x003e
                boolean r0 = r0.getStackFromEnd()
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                goto L_0x003f
            L_0x003e:
                r0 = 0
            L_0x003f:
                if (r0 != 0) goto L_0x0044
                kotlin.g.b.k.a()
            L_0x0044:
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x005c
                com.paytm.android.chat.activity.APCChatActivity r0 = r5.f41516a
                boolean r0 = r0.ae
                if (r0 == 0) goto L_0x005c
                com.paytm.android.chat.activity.APCChatActivity r0 = r5.f41516a
                r0.c((int) r1)
                com.paytm.android.chat.activity.APCChatActivity r0 = r5.f41516a
                r0.ae = false
            L_0x005c:
                if (r3 == 0) goto L_0x0063
                com.paytm.android.chat.activity.APCChatActivity r0 = r5.f41516a
                r0.c((int) r1)
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.activity.APCChatActivity.ay.run():void");
        }
    }

    private final void a(ChatGroupChannelDataModel chatGroupChannelDataModel) {
        try {
            View findViewById = findViewById(R.id.layout_group_chat_chatbox);
            kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.layout_group_chat_chatbox)");
            View findViewById2 = findViewById(R.id.layoutChannelBottom);
            kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.layoutChannelBottom)");
            View findViewById3 = findViewById(R.id.layoutP2vpaP2vpamP2bkBottom);
            kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.layoutP2vpaP2vpamP2bkBottom)");
            ReceiverDisplayInfo receiverDisplayInfo = chatGroupChannelDataModel.getReceiverDisplayInfo();
            k();
            int i2 = a.f41756c[receiverDisplayInfo.getChatType().ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (chatGroupChannelDataModel.isReplyAllowed()) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
            } else if (i2 != 3) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(8);
            } else if (receiverDisplayInfo.getReceiver() != null) {
                Member receiver = receiverDisplayInfo.getReceiver();
                if (receiver == null) {
                    kotlin.g.b.k.a();
                }
                String userId = receiver.getUserId();
                kotlin.g.b.k.a((Object) userId, "receiverDisplayInfo.receiver!!.userId");
                c(userId);
            }
        } catch (Exception unused) {
        }
    }

    private final void c(String str) {
        this.aj.a(str).b(io.reactivex.rxjava3.i.a.b()).b(io.reactivex.rxjava3.android.b.a.a()).a(new ap(this), (io.reactivex.rxjava3.d.g<? super Throwable>) aq.f41509a);
    }

    static final class ae implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f41487b;

        ae(APCChatActivity aPCChatActivity, List list) {
            this.f41486a = aPCChatActivity;
            this.f41487b = list;
        }

        public final void onClick(View view) {
            APCChatActivity.a(this.f41486a, (List) ((com.paytm.android.chat.view.d) this.f41487b.get(0)).f42570d);
        }
    }

    static final class af implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41488a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f41489b;

        af(APCChatActivity aPCChatActivity, String str) {
            this.f41488a = aPCChatActivity;
            this.f41489b = str;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "v");
            com.paytm.android.chat.d G = this.f41488a.ao;
            if (G == null) {
                kotlin.g.b.k.a();
            }
            G.a(view.getContext(), this.f41489b);
        }
    }

    static final class ag implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41490a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f41491b;

        ag(APCChatActivity aPCChatActivity, List list) {
            this.f41490a = aPCChatActivity;
            this.f41491b = list;
        }

        public final void onClick(View view) {
            APCChatActivity.a(this.f41490a, this.f41491b);
        }
    }

    static final class ah implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41492a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f41493b;

        ah(APCChatActivity aPCChatActivity, String str) {
            this.f41492a = aPCChatActivity;
            this.f41493b = str;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "v");
            com.paytm.android.chat.d G = this.f41492a.ao;
            if (G == null) {
                kotlin.g.b.k.a();
            }
            G.a(view.getContext(), this.f41493b);
        }
    }

    static final class ai implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f41495b;

        ai(APCChatActivity aPCChatActivity, List list) {
            this.f41494a = aPCChatActivity;
            this.f41495b = list;
        }

        public final void onClick(View view) {
            APCChatActivity.a(this.f41494a, this.f41495b);
        }
    }

    static final class aj implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41496a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f41497b;

        aj(APCChatActivity aPCChatActivity, String str) {
            this.f41496a = aPCChatActivity;
            this.f41497b = str;
        }

        public final void onClick(View view) {
            kotlin.g.b.k.c(view, "v");
            com.paytm.android.chat.d G = this.f41496a.ao;
            if (G == null) {
                kotlin.g.b.k.a();
            }
            G.a(view.getContext(), this.f41497b);
        }
    }

    public static final class bh implements com.paytm.android.chat.view.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41537a;

        bh(APCChatActivity aPCChatActivity) {
            this.f41537a = aPCChatActivity;
        }

        public final void a(com.paytm.android.chat.view.d dVar) {
            kotlin.g.b.k.c(dVar, "item");
            try {
                if (this.f41537a.ao != null) {
                    com.paytm.android.chat.d G = this.f41537a.ao;
                    if (G == null) {
                        kotlin.g.b.k.a();
                    }
                    G.a(this.f41537a, dVar.f42569c);
                }
            } catch (Exception unused) {
            }
        }

        public final void a() {
            MenuItemBottomSheet N;
            try {
                if (this.f41537a.F != null && (N = this.f41537a.F) != null) {
                    N.f41823a.dismiss();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public final void n() {
        Object obj;
        if (this.au) {
            o();
        } else if (FastClickUtil.isFastClick()) {
            ChatAnalyticsHelperKt.fireChatPayClickEvent(this);
            if (!q()) {
                ChatGroupChannelDataModel chatGroupChannelDataModel = c().f42166a;
                if (this.ao != null && chatGroupChannelDataModel != null) {
                    View view = this.v;
                    if (view != null) {
                        view.setVisibility(0);
                    }
                    IJRDataModel iJRDataModel = this.Y;
                    Iterator it2 = chatGroupChannelDataModel.getMembers().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        if (!((ChatUserDataModel) obj).isMe()) {
                            break;
                        }
                    }
                    ChatUserDataModel chatUserDataModel = (ChatUserDataModel) obj;
                    if (chatUserDataModel != null) {
                        AppUtilKt.convertChatUserEntityToMTSDKReceiverDetail(chatUserDataModel, iJRDataModel);
                    }
                }
            }
        }
    }

    private final void o() {
        ReceiverDisplayInfo e2;
        String phoneNumber;
        String a2;
        String str;
        com.paytm.android.chat.d dVar;
        if (FastClickUtil.isFastClick()) {
            Context context = this;
            ChatAnalyticsHelperKt.fireChatPayClickEvent(context);
            if (!q() && (e2 = c().e()) != null && (phoneNumber = e2.getPhoneNumber()) != null && (a2 = com.paytm.android.chat.f.a(phoneNumber)) != null && (str = this.R) != null && (dVar = this.ao) != null) {
                dVar.a(context, str, a2, (d.a) new at(str, a2, this));
            }
        }
    }

    static final class at implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f41512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f41513b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41514c;

        at(String str, String str2, APCChatActivity aPCChatActivity) {
            this.f41512a = str;
            this.f41513b = str2;
            this.f41514c = aPCChatActivity;
        }

        public final void a(PFPaymentStatusBean pFPaymentStatusBean) {
            APCChatActivity aPCChatActivity = this.f41514c;
            TxNotifyData.Companion companion = TxNotifyData.Companion;
            String str = this.f41512a;
            kotlin.g.b.k.a((Object) pFPaymentStatusBean, "it");
            aPCChatActivity.a(companion.createFromPFPaymentStatusBean(str, pFPaymentStatusBean));
        }
    }

    /* access modifiers changed from: private */
    public final void a(TxNotifyData txNotifyData) {
        ChatType chatType;
        String name;
        try {
            View view = this.v;
            if (view != null) {
                view.setVisibility(8);
            }
            if (txNotifyData == null) {
                return;
            }
            if (txNotifyData.getTxnId() == null || !kotlin.g.b.k.a((Object) txNotifyData.getTxnId(), (Object) this.ah)) {
                this.ah = txNotifyData.getTxnId();
                Color.parseColor("#21C17A");
                if (kotlin.g.b.k.a((Object) "SUCCESS", (Object) txNotifyData.getStatus())) {
                    c();
                    com.paytm.android.chat.h.a.a(txNotifyData);
                    ReceiverDisplayInfo e2 = c().e();
                    if (!(e2 == null || (chatType = e2.getChatType()) == null || (name = chatType.name()) == null)) {
                        ChatAnalyticsHelperKt.firePaymentSuccessEvent(this, name, txNotifyData.getAmount());
                    }
                    Color.parseColor("#21C17A");
                } else if (kotlin.g.b.k.a((Object) "FAILURE", (Object) txNotifyData.getStatus())) {
                    a("Payment transaction failed", Color.parseColor("#FD5154"));
                } else if (kotlin.g.b.k.a((Object) "PENDING", (Object) txNotifyData.getStatus())) {
                    c();
                    com.paytm.android.chat.h.a.a(txNotifyData);
                    Color.parseColor("#FF9D00");
                } else if (kotlin.g.b.k.a((Object) "PENDING", (Object) txNotifyData.getStatus())) {
                    Color.parseColor("#FD5154");
                }
                if (txNotifyData.getErrorMsg() != null) {
                    CharSequence errorMsg = txNotifyData.getErrorMsg();
                    int length = errorMsg.length() - 1;
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 <= length) {
                        boolean z3 = errorMsg.charAt(!z2 ? i2 : length) <= ' ';
                        if (z2) {
                            if (!z3) {
                                break;
                            }
                            length--;
                        } else if (!z3) {
                            z2 = true;
                        } else {
                            i2++;
                        }
                    }
                    if (errorMsg.subSequence(i2, length + 1).toString().length() > 0) {
                        txNotifyData.getErrorMsg();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private final void p() {
        Context context = this;
        if (!com.paytm.utility.b.c(context) && this.U == null) {
            this.U = new ChatOneButtonDialog(context);
            ChatOneButtonDialog chatOneButtonDialog = this.U;
            if (chatOneButtonDialog != null) {
                chatOneButtonDialog.hideTitle();
            }
            ChatOneButtonDialog chatOneButtonDialog2 = this.U;
            String str = null;
            if (chatOneButtonDialog2 != null) {
                Resources resources = getResources();
                chatOneButtonDialog2.setMessage(resources != null ? resources.getString(R.string.chat_module_no_internet) : null);
            }
            ChatOneButtonDialog chatOneButtonDialog3 = this.U;
            if (chatOneButtonDialog3 != null) {
                Resources resources2 = getResources();
                if (resources2 != null) {
                    str = resources2.getString(R.string.chat_module_button_ok);
                }
                chatOneButtonDialog3.setButton(-3, str, new x(this));
            }
            ChatOneButtonDialog chatOneButtonDialog4 = this.U;
            if (chatOneButtonDialog4 != null) {
                chatOneButtonDialog4.show();
            }
        }
    }

    static final class x implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41562a;

        x(APCChatActivity aPCChatActivity) {
            this.f41562a = aPCChatActivity;
        }

        public final void onClick(View view) {
            com.paytm.android.chat.a.f fVar;
            ChatOneButtonDialog O = this.f41562a.U;
            if (O != null) {
                O.dismiss();
            }
            if (this.f41562a.f41475c == null || ((fVar = this.f41562a.f41475c) != null && fVar.getItemCount() == 0)) {
                this.f41562a.finish();
            } else {
                this.f41562a.U = null;
            }
        }
    }

    public final void f() {
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
    }

    public final void g() {
        LinearLayout linearLayout = this.E;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
    }

    private final boolean q() {
        if (isFinishing() || isDestroyed() || com.paytm.utility.b.c((Context) this)) {
            return false;
        }
        p();
        return true;
    }

    /* access modifiers changed from: private */
    public final boolean r() {
        if (com.paytm.android.chat.f.a((Activity) this)) {
            return false;
        }
        Context context = this;
        if (androidx.core.content.b.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2020);
        }
        return false;
    }

    static final class bf implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ChatOneButtonDialog f41535a;

        bf(ChatOneButtonDialog chatOneButtonDialog) {
            this.f41535a = chatOneButtonDialog;
        }

        public final void onClick(View view) {
            this.f41535a.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void s() {
        MediaPlayerService mediaPlayerService;
        if (this.ad && (mediaPlayerService = this.f41477e) != null) {
            mediaPlayerService.b();
        }
        com.paytm.android.chat.a.f fVar = this.f41475c;
        if (fVar != null) {
            if (fVar == null) {
                kotlin.g.b.k.a();
            }
            fVar.b(false);
        }
        this.f41476d.removeCallbacksAndMessages((Object) null);
    }

    static final class ak implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f41498a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ APCChatActivity f41499b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f41500c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f41501d;

        ak(String str, APCChatActivity aPCChatActivity, ArrayList arrayList, List list) {
            this.f41498a = str;
            this.f41499b = aPCChatActivity;
            this.f41500c = arrayList;
            this.f41501d = list;
        }

        public final void run() {
            if (!this.f41499b.isDestroyed() && !this.f41499b.isFinishing()) {
                Intent intent = new Intent(this.f41499b, APCChatActivity.class);
                intent.putExtra("groupChannelUrl", this.f41498a);
                this.f41499b.startActivity(intent);
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(Context context, String str, String str2, String str3, boolean z) {
            kotlin.g.b.k.c(context, "context");
            Intent intent = new Intent(context, APCChatActivity.class);
            intent.putExtra("groupChannelUrl", str);
            boolean z2 = true;
            if (str2 != null) {
                if (!(str2.length() == 0)) {
                    intent.putExtra(ContactColumn.PHONE_NUMBER, str2);
                }
            }
            if (str3 != null) {
                if (str3.length() != 0) {
                    z2 = false;
                }
                if (!z2) {
                    intent.putExtra("phoneName", str3);
                }
            }
            intent.putExtra("isFromContact", z);
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
    }

    static final class ao<T> implements io.reactivex.rxjava3.d.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        public static final ao f41507a = new ao();

        ao() {
        }

        public final /* synthetic */ void accept(Object obj) {
            com.paytm.utility.q.c("isBlackList");
        }
    }

    public final void d() {
        RecyclerView recyclerView;
        if (getIntent().getStringExtra("groupChannelUrl") != null) {
            this.R = getIntent().getStringExtra("groupChannelUrl");
            com.paytm.android.chat.h.a b2 = c();
            String stringExtra = getIntent().getStringExtra("groupChannelUrl");
            kotlin.g.b.k.a((Object) stringExtra, "intent.getStringExtra(\"groupChannelUrl\")");
            b2.a(stringExtra);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_channel_list);
        kotlin.g.b.k.a((Object) toolbar, "toolbar");
        toolbar.setTitle((CharSequence) "");
        toolbar.setNavigationOnClickListener(new w(this));
        if (getSupportActionBar() != null) {
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar != null) {
                supportActionBar.b(true);
            }
            getSupportActionBar();
        }
        h();
        j();
        if (!SharedPreferencesUtil.isRegist()) {
            SharedPreferencesUtil.updateUserData(this);
        }
        Context context = this;
        ChatNotificationHelper.INSTANCE.clearAllNotification(context);
        com.paytm.android.chat.view.kpswitch.b.b.a(this, new be(this));
        this.v = findViewById(R.id.chat_payment_pb);
        this.t = (TextView) findViewById(R.id.text_group_chat_new_message);
        this.u = (TextView) findViewById(R.id.text_group_chat_un_read_message);
        this.o = (RecyclerView) findViewById(R.id.recycler_group_chat);
        this.x = (SwipeRefreshLayout) findViewById(R.id.swipe_layout_group_chat);
        this.f41475c = new com.paytm.android.chat.a.f(context);
        com.paytm.android.chat.a.f fVar = this.f41475c;
        if (fVar != null) {
            fVar.a(c().f42166a);
        }
        com.paytm.android.chat.a.f fVar2 = this.f41475c;
        if (fVar2 != null) {
            fVar2.c(!com.paytm.android.chat.f.a((Activity) this) && androidx.core.content.b.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0);
        }
        this.N = new LinearLayoutManager(context);
        LinearLayoutManager linearLayoutManager = this.N;
        if (linearLayoutManager != null) {
            linearLayoutManager.setRecycleChildrenOnDetach(true);
        }
        LinearLayoutManager linearLayoutManager2 = this.N;
        if (linearLayoutManager2 != null) {
            linearLayoutManager2.setReverseLayout(true);
        }
        RecyclerView recyclerView2 = this.o;
        RecyclerView.a aVar = null;
        if (recyclerView2 != null) {
            recyclerView2.setItemAnimator((RecyclerView.f) null);
        }
        RecyclerView recyclerView3 = this.o;
        if (recyclerView3 != null) {
            recyclerView3.setLayoutManager(this.N);
        }
        RecyclerView recyclerView4 = this.o;
        if (recyclerView4 != null) {
            aVar = recyclerView4.getAdapter();
        }
        if (aVar == null && (recyclerView = this.o) != null) {
            recyclerView.setAdapter(this.f41475c);
        }
        SwipeRefreshLayout swipeRefreshLayout = this.x;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(new b(this));
        }
        this.am = new androidx.recyclerview.widget.l(new com.paytm.android.chat.view.g(context, new c(this)));
        androidx.recyclerview.widget.l lVar = this.am;
        if (lVar != null) {
            lVar.a(this.o);
        }
        this.w = findViewById(R.id.chat_rl_invite_view);
        this.M = findViewById(R.id.chat_text_invite_button);
        this.an = (RecyclerView) findViewById(R.id.rcl_view);
        this.p = (ChatEditText) findViewById(R.id.edittext_group_chat_message);
        this.q = (ImageView) findViewById(R.id.button_group_chat_send);
        this.r = (ImageView) findViewById(R.id.button_group_chat_upload);
        this.s = (ReplyView) findViewById(R.id.layout_group_chat_reply_view);
        this.G = (TextView) findViewById(R.id.btn_payment);
        this.K = findViewById(R.id.input_box_divider);
        this.H = (PayButtonView) findViewById(R.id.btnPayP2vpaP2vamP2bk);
        this.I = (PayButtonView) findViewById(R.id.btnMoneyRequestP2vpaP2vamP2bk);
        this.y = (RecyclerView) findViewById(R.id.recycler_group_quick_reply_container);
        this.P = new LinearLayoutManager(context, 0, false);
        LinearLayoutManager linearLayoutManager3 = this.P;
        if (linearLayoutManager3 != null) {
            linearLayoutManager3.setStackFromEnd(true);
        }
        RecyclerView recyclerView5 = this.y;
        if (recyclerView5 != null) {
            recyclerView5.setLayoutManager(this.P);
        }
        this.O = new com.paytm.android.chat.a.j(context, this.ag);
        RecyclerView recyclerView6 = this.y;
        if (recyclerView6 != null) {
            recyclerView6.setAdapter(this.O);
        }
        this.E = (LinearLayout) findViewById(R.id.network_error);
        this.z = (FrameLayout) findViewById(R.id.fl_chat_container);
        this.A = (RelativeLayout) findViewById(R.id.rv_new_chat_container);
        this.B = (TextView) findViewById(R.id.tv_name);
        this.C = (TextView) findViewById(R.id.tv_number);
        this.D = (TextView) findViewById(R.id.tv_action);
        this.Q = (LottieAnimationView) findViewById(R.id.lotti_animation);
        LottieAnimationView lottieAnimationView = this.Q;
        if (lottieAnimationView != null) {
            lottieAnimationView.setAnimation("confetti.json");
        }
        TextView textView = this.D;
        if (textView != null) {
            textView.setText("Say Hello! 👋");
        }
        this.J = (ConstraintLayout) findViewById(R.id.input_box);
        this.n = findViewById(R.id.rl_chat_window_user);
        this.j = (ChatHeadView) findViewById(R.id.image_group_chat_head_pic);
        this.k = (TextView) findViewById(R.id.text_group_chat_user_name);
        this.l = (TextView) findViewById(R.id.text_group_chat_user_state);
        this.m = (TextView) findViewById(R.id.payment_info_tv);
        ChatHeadView chatHeadView = this.j;
        if (chatHeadView != null) {
            chatHeadView.setContainerBG(R.color.color_fafafa);
        }
        this.ai = new NetworkReceiver();
        NetworkReceiver networkReceiver = this.ai;
        if (networkReceiver != null) {
            networkReceiver.a(this);
        }
        com.paytm.android.chat.a.j jVar = this.O;
        if (jVar != null) {
            jVar.a((j.a) new d(this));
        }
        TextView textView2 = this.D;
        if (textView2 != null) {
            textView2.setOnClickListener(new o(this));
        }
        this.ao = ChatManager.b().a(this.R);
        View view = this.M;
        if (view != null) {
            view.setOnClickListener(new p(this));
        }
        TextView textView3 = this.G;
        if (textView3 != null) {
            textView3.setOnClickListener(new q(this));
        }
        PayButtonView payButtonView = this.H;
        if (payButtonView != null) {
            payButtonView.setOnClickListener(new r(this));
        }
        PayButtonView payButtonView2 = this.I;
        if (payButtonView2 != null) {
            payButtonView2.setOnClickListener(new s(this));
        }
        ChatEditText chatEditText = this.p;
        if (chatEditText != null) {
            chatEditText.setKeyBoardInputCallbackListener(new t(this));
        }
        this.L = new AttachBottomSheet(context, new com.google.android.material.bottomsheet.a(context), new u(this));
        ReplyView replyView = this.s;
        if (replyView != null) {
            replyView.setOnClickListener(new v(this));
        }
        ImageView imageView = this.r;
        if (imageView != null) {
            imageView.setOnClickListener(new e(this));
        }
        ImageView imageView2 = this.q;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new f(this));
        }
        TextView textView4 = this.t;
        if (textView4 != null) {
            textView4.setOnClickListener(new g(this));
        }
        TextView textView5 = this.u;
        if (textView5 != null) {
            textView5.setOnClickListener(new h(this));
        }
        ChatEditText chatEditText2 = this.p;
        if (chatEditText2 != null) {
            chatEditText2.addTextChangedListener(new i(this));
        }
        com.paytm.android.chat.a.f fVar3 = this.f41475c;
        if (fVar3 != null) {
            fVar3.a((f.m) new j(this));
        }
        com.paytm.android.chat.a.f fVar4 = this.f41475c;
        if (fVar4 != null) {
            fVar4.a((f.n) new k(this));
        }
        com.paytm.android.chat.a.f fVar5 = this.f41475c;
        if (fVar5 != null) {
            fVar5.a((f.l) new l(this));
        }
        com.paytm.android.chat.a.f fVar6 = this.f41475c;
        if (fVar6 != null) {
            fVar6.a((f.o) new m(this));
        }
        View view2 = this.n;
        if (view2 != null) {
            view2.setOnClickListener(new n(this));
        }
    }

    public static final /* synthetic */ void a(APCChatActivity aPCChatActivity, Intent intent, boolean z2) {
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("payment.option");
            if (serializableExtra instanceof IJRDataModel) {
                aPCChatActivity.Y = (IJRDataModel) serializableExtra;
            }
            aPCChatActivity.T = intent.getStringExtra("fromFCM");
            String str = aPCChatActivity.R;
            if (str != null) {
                if (str == null) {
                    kotlin.g.b.k.a();
                }
                if (!(str.length() == 0)) {
                    com.paytm.a aVar = com.paytm.a.f40823c;
                    com.paytm.a.a(aPCChatActivity.R);
                    String str2 = aPCChatActivity.R;
                    if (str2 != null) {
                        aPCChatActivity.b(str2);
                        aPCChatActivity.c().a(str2);
                        aPCChatActivity.c().e(str2).b(new y(aPCChatActivity)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new z(aPCChatActivity), (io.reactivex.rxjava3.d.g<? super Throwable>) new aa(aPCChatActivity));
                        return;
                    }
                    return;
                }
            }
            if (intent != null) {
                io.reactivex.rxjava3.a.y.a(new ab(aPCChatActivity, intent, z2)).b(io.reactivex.rxjava3.i.a.b()).a(io.reactivex.rxjava3.android.b.a.a()).a(new ac(aPCChatActivity), (io.reactivex.rxjava3.d.g<? super Throwable>) new ad(aPCChatActivity));
            }
        }
    }

    public static final /* synthetic */ void a(APCChatActivity aPCChatActivity, ChatGroupChannelDataModel chatGroupChannelDataModel, SyncContactBean syncContactBean) {
        String str = aPCChatActivity.T;
        if (str != null && kotlin.m.p.a(str, "fromFCM", true)) {
            ChatAnalyticsHelperKt.fireOpenFromNotificationEvent(aPCChatActivity, chatGroupChannelDataModel.getReceiverDisplayInfo().getChatType().name());
        }
        if (syncContactBean == null) {
            syncContactBean = ContactManager.getInstance().searchContactDBByUrl(aPCChatActivity.R);
        }
        if (chatGroupChannelDataModel.isFake()) {
            aPCChatActivity.k();
            aPCChatActivity.a(chatGroupChannelDataModel);
            String offlineDisplayNameForReceiver = ChatVariantUtilKt.getOfflineDisplayNameForReceiver(chatGroupChannelDataModel);
            TextView textView = aPCChatActivity.k;
            if (textView != null) {
                textView.setText(offlineDisplayNameForReceiver);
            }
            ChatUserDataModel offlineReceiver = ChatVariantUtilKt.getOfflineReceiver(chatGroupChannelDataModel);
            offlineReceiver.setSendbirdUsername(offlineDisplayNameForReceiver);
            ChatHeadView chatHeadView = aPCChatActivity.j;
            if (chatHeadView != null) {
                chatHeadView.setOfflineUI(offlineReceiver);
            }
            aPCChatActivity.i();
            LinearLayout linearLayout = (LinearLayout) aPCChatActivity.a(R.id.network_error);
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
        } else {
            aPCChatActivity.c().f();
            aPCChatActivity.a(chatGroupChannelDataModel);
            LinearLayout linearLayout2 = (LinearLayout) aPCChatActivity.a(R.id.network_error);
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            aPCChatActivity.a(chatGroupChannelDataModel, syncContactBean);
        }
        aPCChatActivity.R = chatGroupChannelDataModel.getChannelUrl();
        if (aPCChatActivity.getIntent().getBooleanExtra(UpiConstants.EXTRA_DEEP_LINK_FLAG, false)) {
            aPCChatActivity.getIntent().getStringExtra("EXTRA_DEEP_LINK_DATA");
            aPCChatActivity.getIntent().getIntExtra("payment_result", -1);
            try {
                if (aPCChatActivity.getIntent().getSerializableExtra("PAYMENT_DATA") == null) {
                    throw new kotlin.u("null cannot be cast to non-null type com.paytm.android.chat.bean.pfbean.PFPaymentStatusBean");
                }
            } catch (Exception unused) {
            }
        }
    }

    public static final /* synthetic */ SyncContactBean a(APCChatActivity aPCChatActivity, ResponseOfRegisterSendBird.DataOfRegisterSendBird dataOfRegisterSendBird) {
        SyncContactBean syncContactBean;
        SyncContactBean syncContactBean2;
        SyncContactBean syncContactBean3;
        aPCChatActivity.R = dataOfRegisterSendBird.getChannelUrl();
        com.paytm.a aVar = com.paytm.a.f40823c;
        com.paytm.a.a(aPCChatActivity.R);
        if (dataOfRegisterSendBird.getContactMobile() != null) {
            aPCChatActivity.V = ContactManager.getInstance().searchContactByPhone(dataOfRegisterSendBird.getContactMobile());
        }
        if (aPCChatActivity.V == null) {
            aPCChatActivity.V = new SyncContactBean();
        }
        if (ContactManager.getInstance().searchContactDBByUrl(aPCChatActivity.R) == null && (syncContactBean3 = aPCChatActivity.V) != null) {
            syncContactBean3.setChannelUrl(aPCChatActivity.R);
        }
        com.paytm.utility.q.b("onSuccess: " + dataOfRegisterSendBird.getContactUserId());
        SyncContactBean syncContactBean4 = aPCChatActivity.V;
        if (syncContactBean4 != null) {
            syncContactBean4.setPtName(dataOfRegisterSendBird.getContactName());
        }
        SyncContactBean syncContactBean5 = aPCChatActivity.V;
        if (syncContactBean5 != null) {
            syncContactBean5.setIsPaytm(dataOfRegisterSendBird.isPfuser());
        }
        SyncContactBean syncContactBean6 = aPCChatActivity.V;
        if (syncContactBean6 != null) {
            syncContactBean6.setPtId(dataOfRegisterSendBird.getContactUserId());
        }
        if (!TextUtils.isEmpty(dataOfRegisterSendBird.getAvatar()) && (syncContactBean2 = aPCChatActivity.V) != null) {
            syncContactBean2.setPtPic(dataOfRegisterSendBird.getAvatar());
        }
        SyncContactBean syncContactBean7 = aPCChatActivity.V;
        if (TextUtils.isEmpty(syncContactBean7 != null ? syncContactBean7.getContactPhone() : null) && (syncContactBean = aPCChatActivity.V) != null) {
            syncContactBean.setContactPhone(dataOfRegisterSendBird.getContactMobile());
        }
        ContactManager.getInstance().upContact(aPCChatActivity.V);
        return aPCChatActivity.V;
    }

    public static final /* synthetic */ void i(APCChatActivity aPCChatActivity) {
        Intent intent = new Intent();
        intent.setAction("com.paytm.android.chat.finish");
        aPCChatActivity.sendBroadcast(intent);
    }

    public static final /* synthetic */ void m(APCChatActivity aPCChatActivity) {
        ChatGroupChannelDataModel chatGroupChannelDataModel;
        Object obj;
        if (FastClickUtil.isFastClick() && !aPCChatActivity.q() && (chatGroupChannelDataModel = aPCChatActivity.c().f42166a) != null) {
            Iterator it2 = chatGroupChannelDataModel.getMembers().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (!kotlin.g.b.k.a((Object) SharedPreferencesUtil.getUserId(), (Object) ((ChatUserDataModel) obj).getSendbirdUserId())) {
                    break;
                }
            }
            ChatUserDataModel chatUserDataModel = (ChatUserDataModel) obj;
            if (chatUserDataModel != null) {
                AppUtilKt.convertChatUserEntityToMTRequestMoneyDetails(chatUserDataModel, chatGroupChannelDataModel.getReceiverDisplayInfo());
            }
        }
    }

    public static final /* synthetic */ boolean p(APCChatActivity aPCChatActivity) {
        if (com.paytm.android.chat.f.a((Activity) aPCChatActivity)) {
            return false;
        }
        if (androidx.core.content.b.a((Context) aPCChatActivity, "android.permission.READ_CONTACTS") == 0) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            aPCChatActivity.requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 2021);
        }
        return false;
    }

    public static final /* synthetic */ boolean v(APCChatActivity aPCChatActivity) {
        ReplyView replyView = aPCChatActivity.s;
        if (replyView == null) {
            return false;
        }
        if (replyView == null) {
            kotlin.g.b.k.a();
        }
        if (!replyView.a()) {
            return false;
        }
        ReplyView replyView2 = aPCChatActivity.s;
        if (replyView2 == null) {
            kotlin.g.b.k.a();
        }
        return replyView2.getBaseMessage() != null;
    }

    public static final /* synthetic */ BaseMessage w(APCChatActivity aPCChatActivity) {
        ReplyView replyView = aPCChatActivity.s;
        if (replyView != null) {
            return replyView.getBaseMessage();
        }
        return null;
    }

    public static final /* synthetic */ boolean F(APCChatActivity aPCChatActivity) {
        if (com.paytm.android.chat.f.a((Activity) aPCChatActivity)) {
            return false;
        }
        Context context = aPCChatActivity;
        if (androidx.core.content.b.a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.a(context, "android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return true;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            aPCChatActivity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, 2022);
        }
        return false;
    }

    public static final /* synthetic */ void a(APCChatActivity aPCChatActivity, ChatUserDataModel chatUserDataModel, Map.Entry entry) {
        String str = (String) entry.getKey();
        UsersInfoJsonBean usersInfoJsonBean = (UsersInfoJsonBean) entry.getValue();
        if (usersInfoJsonBean != null && usersInfoJsonBean.getPhoneNumber() != null) {
            aPCChatActivity.V = ContactManager.getInstance().searchContactByPhone(usersInfoJsonBean.getPhoneNumber());
            SyncContactBean syncContactBean = aPCChatActivity.V;
            if (syncContactBean == null) {
                aPCChatActivity.V = new SyncContactBean();
                SyncContactBean syncContactBean2 = aPCChatActivity.V;
                if (syncContactBean2 != null) {
                    syncContactBean2.setSelfId(SharedPreferencesUtil.getUserId());
                }
                SyncContactBean syncContactBean3 = aPCChatActivity.V;
                if (syncContactBean3 != null) {
                    syncContactBean3.setPtName(usersInfoJsonBean.getPfName());
                }
                SyncContactBean syncContactBean4 = aPCChatActivity.V;
                if (syncContactBean4 != null) {
                    syncContactBean4.setPtId(usersInfoJsonBean.getPhoneNumber());
                }
                SyncContactBean syncContactBean5 = aPCChatActivity.V;
                if (syncContactBean5 != null) {
                    syncContactBean5.setSendbirdId(chatUserDataModel.getSendbirdUserId());
                }
                SyncContactBean syncContactBean6 = aPCChatActivity.V;
                if (syncContactBean6 != null) {
                    syncContactBean6.setContactPhone(usersInfoJsonBean.getPhoneNumber());
                }
                SyncContactBean syncContactBean7 = aPCChatActivity.V;
                if (syncContactBean7 != null) {
                    syncContactBean7.setIsPaytm(usersInfoJsonBean.isPfuser());
                }
                SyncContactBean syncContactBean8 = aPCChatActivity.V;
                if (syncContactBean8 != null) {
                    syncContactBean8.setChannelUrl(aPCChatActivity.R);
                }
                ContactManager instance = ContactManager.getInstance();
                SyncContactBean syncContactBean9 = aPCChatActivity.V;
                if (syncContactBean9 == null) {
                    kotlin.g.b.k.a();
                }
                instance.addContact(syncContactBean9);
            } else {
                if (syncContactBean != null) {
                    syncContactBean.setSelfId(SharedPreferencesUtil.getUserId());
                }
                SyncContactBean syncContactBean10 = aPCChatActivity.V;
                if (syncContactBean10 != null) {
                    syncContactBean10.setPtName(usersInfoJsonBean.getPfName());
                }
                SyncContactBean syncContactBean11 = aPCChatActivity.V;
                if (syncContactBean11 != null) {
                    syncContactBean11.setPtId(usersInfoJsonBean.getPhoneNumber());
                }
                SyncContactBean syncContactBean12 = aPCChatActivity.V;
                if (syncContactBean12 != null) {
                    syncContactBean12.setSendbirdId(chatUserDataModel.getSendbirdUserId());
                }
                SyncContactBean syncContactBean13 = aPCChatActivity.V;
                if (syncContactBean13 != null) {
                    syncContactBean13.setIsPaytm(usersInfoJsonBean.isPfuser());
                }
                SyncContactBean syncContactBean14 = aPCChatActivity.V;
                if (syncContactBean14 != null) {
                    syncContactBean14.setChannelUrl(aPCChatActivity.R);
                }
                ContactManager.getInstance().upContact(aPCChatActivity.V);
            }
            if (!aPCChatActivity.isFinishing() && !aPCChatActivity.isDestroyed()) {
                String stringExtra = aPCChatActivity.getIntent().getStringExtra("defaultMessage");
                if (!aPCChatActivity.as && !TextUtils.isEmpty(stringExtra)) {
                    aPCChatActivity.as = true;
                    aPCChatActivity.c().c(stringExtra);
                }
            }
        } else if (kotlin.g.b.k.a((Object) str, (Object) "0")) {
            aPCChatActivity.S = ContactManager.getInstance().searchContactDBByUrl(aPCChatActivity.R);
            SyncContactBean syncContactBean15 = aPCChatActivity.S;
            if (syncContactBean15 == null) {
                aPCChatActivity.S = new SyncContactBean();
                SyncContactBean syncContactBean16 = aPCChatActivity.S;
                if (syncContactBean16 != null) {
                    syncContactBean16.setChannelUrl(aPCChatActivity.R);
                }
                SyncContactBean syncContactBean17 = aPCChatActivity.S;
                if (syncContactBean17 != null) {
                    syncContactBean17.setPtName(chatUserDataModel.getSendbirdUsername());
                }
                SyncContactBean syncContactBean18 = aPCChatActivity.S;
                if (syncContactBean18 != null) {
                    syncContactBean18.setSendbirdId(chatUserDataModel.getSendbirdUserId());
                }
                ContactManager.getInstance().addContact(aPCChatActivity.S);
                com.paytm.utility.q.a("====up user info 1 " + ContactManager.getInstance().searchContactDBByUrl(aPCChatActivity.R));
                return;
            }
            if (syncContactBean15 != null) {
                syncContactBean15.setPtName(chatUserDataModel.getSendbirdUsername());
            }
            SyncContactBean syncContactBean19 = aPCChatActivity.S;
            if (syncContactBean19 != null) {
                syncContactBean19.setSendbirdId(chatUserDataModel.getSendbirdUserId());
            }
            ContactManager.getInstance().upContact(aPCChatActivity.S);
            com.paytm.utility.q.a("====up user info 2 " + ContactManager.getInstance().searchContactDBByUrl(aPCChatActivity.R));
        }
    }

    public static final /* synthetic */ void I(APCChatActivity aPCChatActivity) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ChatEditText chatEditText = aPCChatActivity.p;
        if (chatEditText == null) {
            kotlin.g.b.k.a();
        }
        chatEditText.setMaxLines(6);
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.a((Context) aPCChatActivity, R.layout.chat_input_box_2);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.a((TimeInterpolator) new LinearInterpolator());
        changeBounds.a(150);
        ConstraintLayout constraintLayout = aPCChatActivity.J;
        if (constraintLayout == null) {
            kotlin.g.b.k.a();
        }
        androidx.transition.v.a((ViewGroup) constraintLayout, (Transition) changeBounds);
        cVar.c(aPCChatActivity.J);
        aPCChatActivity.aa = true;
        ChatEditText chatEditText2 = aPCChatActivity.p;
        if (chatEditText2 == null) {
            kotlin.g.b.k.a();
        }
        chatEditText2.setPadding(DensityUtil.dp2px(17.0f), DensityUtil.dp2px(7.0f), DensityUtil.dp2px(17.0f), DensityUtil.dp2px(7.0f));
        ImageView imageView = aPCChatActivity.r;
        if (!(imageView == null || (layoutParams2 = imageView.getLayoutParams()) == null)) {
            layoutParams2.height = DensityUtil.dp2px(36.0f);
        }
        ImageView imageView2 = aPCChatActivity.r;
        if (!(imageView2 == null || (layoutParams = imageView2.getLayoutParams()) == null)) {
            layoutParams.width = DensityUtil.dp2px(36.0f);
        }
        ImageView imageView3 = aPCChatActivity.r;
        if (imageView3 != null) {
            imageView3.requestLayout();
        }
        ImageView imageView4 = aPCChatActivity.r;
        if (imageView4 != null) {
            imageView4.setPadding(DensityUtil.dp2px(11.0f), DensityUtil.dp2px(11.0f), DensityUtil.dp2px(11.0f), DensityUtil.dp2px(11.0f));
        }
        ImageView imageView5 = aPCChatActivity.r;
        if (imageView5 != null) {
            ImageView imageView6 = aPCChatActivity.q;
            if (imageView6 == null) {
                kotlin.g.b.k.a();
            }
            imageView5.setBackground(androidx.core.content.b.a(imageView6.getContext(), R.drawable.chat_shape_send_bg_active));
        }
        ImageView imageView7 = aPCChatActivity.r;
        if (imageView7 == null) {
            kotlin.g.b.k.a();
        }
        Drawable f2 = androidx.core.graphics.drawable.a.f(imageView7.getDrawable());
        ImageView imageView8 = aPCChatActivity.r;
        if (imageView8 == null) {
            kotlin.g.b.k.a();
        }
        androidx.core.graphics.drawable.a.a(f2, androidx.core.content.b.c(imageView8.getContext(), R.color.white));
        if (aPCChatActivity.al) {
            RecyclerView recyclerView = aPCChatActivity.y;
            if (recyclerView == null) {
                kotlin.g.b.k.a();
            }
            recyclerView.setVisibility(0);
        } else {
            RecyclerView recyclerView2 = aPCChatActivity.y;
            if (recyclerView2 == null) {
                kotlin.g.b.k.a();
            }
            recyclerView2.setVisibility(8);
        }
        if (aPCChatActivity.Z) {
            aPCChatActivity.b(0);
        } else {
            aPCChatActivity.b(8);
        }
    }

    public static final /* synthetic */ void J(APCChatActivity aPCChatActivity) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2;
        ViewGroup.LayoutParams layoutParams3;
        ViewGroup.LayoutParams layoutParams4;
        ChatEditText chatEditText = aPCChatActivity.p;
        if (chatEditText == null) {
            kotlin.g.b.k.a();
        }
        chatEditText.setMaxLines(1);
        aPCChatActivity.k();
        ChatEditText chatEditText2 = aPCChatActivity.p;
        if (chatEditText2 == null) {
            kotlin.g.b.k.a();
        }
        if (String.valueOf(chatEditText2.getText()).length() == 0) {
            androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
            cVar.a((Context) aPCChatActivity, R.layout.chat_input_box_3);
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.a((TimeInterpolator) new LinearInterpolator());
            changeBounds.a(150);
            ConstraintLayout constraintLayout = aPCChatActivity.J;
            if (constraintLayout == null) {
                kotlin.g.b.k.a();
            }
            androidx.transition.v.a((ViewGroup) constraintLayout, (Transition) changeBounds);
            cVar.c(aPCChatActivity.J);
            aPCChatActivity.aa = false;
            ChatEditText chatEditText3 = aPCChatActivity.p;
            if (chatEditText3 == null) {
                kotlin.g.b.k.a();
            }
            chatEditText3.setPadding(DensityUtil.dp2px(46.0f), DensityUtil.dp2px(7.0f), DensityUtil.dp2px(17.0f), DensityUtil.dp2px(7.0f));
            ImageView imageView = aPCChatActivity.r;
            if (imageView != null) {
                imageView.setBackground((Drawable) null);
            }
            ImageView imageView2 = aPCChatActivity.r;
            if (!(imageView2 == null || (layoutParams4 = imageView2.getLayoutParams()) == null)) {
                layoutParams4.height = DensityUtil.dp2px(26.0f);
            }
            ImageView imageView3 = aPCChatActivity.r;
            if (!(imageView3 == null || (layoutParams3 = imageView3.getLayoutParams()) == null)) {
                layoutParams3.width = DensityUtil.dp2px(26.0f);
            }
            ImageView imageView4 = aPCChatActivity.r;
            if (imageView4 != null) {
                imageView4.requestLayout();
            }
            ImageView imageView5 = aPCChatActivity.r;
            if (imageView5 != null) {
                ImageView imageView6 = aPCChatActivity.q;
                if (imageView6 == null) {
                    kotlin.g.b.k.a();
                }
                imageView5.setBackground(androidx.core.content.b.a(imageView6.getContext(), R.drawable.chat_shape_send_bg_inactive));
            }
            ImageView imageView7 = aPCChatActivity.r;
            if (imageView7 != null) {
                imageView7.setPadding(DensityUtil.dp2px(7.0f), DensityUtil.dp2px(7.0f), DensityUtil.dp2px(7.0f), DensityUtil.dp2px(7.0f));
            }
            ImageView imageView8 = aPCChatActivity.r;
            if (imageView8 == null) {
                kotlin.g.b.k.a();
            }
            Drawable f2 = androidx.core.graphics.drawable.a.f(imageView8.getDrawable());
            ImageView imageView9 = aPCChatActivity.r;
            if (imageView9 == null) {
                kotlin.g.b.k.a();
            }
            androidx.core.graphics.drawable.a.a(f2, androidx.core.content.b.c(imageView9.getContext(), R.color.chat_edittext_hint));
            if (aPCChatActivity.al) {
                RecyclerView recyclerView = aPCChatActivity.y;
                if (recyclerView == null) {
                    kotlin.g.b.k.a();
                }
                recyclerView.setVisibility(0);
            } else {
                RecyclerView recyclerView2 = aPCChatActivity.y;
                if (recyclerView2 == null) {
                    kotlin.g.b.k.a();
                }
                recyclerView2.setVisibility(8);
            }
            if (aPCChatActivity.Z) {
                aPCChatActivity.b(0);
            } else {
                aPCChatActivity.b(8);
            }
        } else {
            androidx.constraintlayout.widget.c cVar2 = new androidx.constraintlayout.widget.c();
            cVar2.a((Context) aPCChatActivity, R.layout.chat_input_box_2);
            ChangeBounds changeBounds2 = new ChangeBounds();
            changeBounds2.a((TimeInterpolator) new LinearInterpolator());
            changeBounds2.a(150);
            ConstraintLayout constraintLayout2 = aPCChatActivity.J;
            if (constraintLayout2 == null) {
                kotlin.g.b.k.a();
            }
            androidx.transition.v.a((ViewGroup) constraintLayout2, (Transition) changeBounds2);
            cVar2.c(aPCChatActivity.J);
            aPCChatActivity.aa = true;
            ImageView imageView10 = aPCChatActivity.r;
            if (!(imageView10 == null || (layoutParams2 = imageView10.getLayoutParams()) == null)) {
                layoutParams2.height = DensityUtil.dp2px(36.0f);
            }
            ImageView imageView11 = aPCChatActivity.r;
            if (!(imageView11 == null || (layoutParams = imageView11.getLayoutParams()) == null)) {
                layoutParams.width = DensityUtil.dp2px(36.0f);
            }
            ImageView imageView12 = aPCChatActivity.r;
            if (imageView12 != null) {
                imageView12.requestLayout();
            }
            ImageView imageView13 = aPCChatActivity.r;
            if (imageView13 != null) {
                imageView13.setPadding(DensityUtil.dp2px(11.0f), DensityUtil.dp2px(11.0f), DensityUtil.dp2px(11.0f), DensityUtil.dp2px(11.0f));
            }
            ImageView imageView14 = aPCChatActivity.r;
            if (imageView14 != null) {
                ImageView imageView15 = aPCChatActivity.q;
                if (imageView15 == null) {
                    kotlin.g.b.k.a();
                }
                imageView14.setBackground(androidx.core.content.b.a(imageView15.getContext(), R.drawable.chat_shape_send_bg_active));
            }
            ImageView imageView16 = aPCChatActivity.r;
            if (imageView16 == null) {
                kotlin.g.b.k.a();
            }
            Drawable f3 = androidx.core.graphics.drawable.a.f(imageView16.getDrawable());
            ImageView imageView17 = aPCChatActivity.r;
            if (imageView17 == null) {
                kotlin.g.b.k.a();
            }
            androidx.core.graphics.drawable.a.a(f3, androidx.core.content.b.c(imageView17.getContext(), R.color.white));
            ChatEditText chatEditText4 = aPCChatActivity.p;
            if (chatEditText4 == null) {
                kotlin.g.b.k.a();
            }
            chatEditText4.setPadding(DensityUtil.dp2px(17.0f), DensityUtil.dp2px(7.0f), DensityUtil.dp2px(17.0f), DensityUtil.dp2px(7.0f));
            if (aPCChatActivity.al) {
                RecyclerView recyclerView3 = aPCChatActivity.y;
                if (recyclerView3 == null) {
                    kotlin.g.b.k.a();
                }
                recyclerView3.setVisibility(0);
            } else {
                RecyclerView recyclerView4 = aPCChatActivity.y;
                if (recyclerView4 == null) {
                    kotlin.g.b.k.a();
                }
                recyclerView4.setVisibility(8);
            }
            if (aPCChatActivity.Z) {
                aPCChatActivity.b(0);
            } else {
                aPCChatActivity.b(8);
            }
        }
    }

    public static final /* synthetic */ void a(APCChatActivity aPCChatActivity, ChatGroupChannelDataModel chatGroupChannelDataModel, GroupChannel groupChannel) {
        ChatType chatType;
        ChannelMetaData a2 = com.paytm.android.chat.g.a((BaseChannel) groupChannel);
        if (a2 == null || !((chatType = a2.getChatType()) == ChatType.P2P || chatType == ChatType.P2M)) {
            TextView textView = aPCChatActivity.l;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        ChatUserDataModel a3 = aPCChatActivity.c().a(chatGroupChannelDataModel);
        if ((a3 != null ? a3.getConnectionStatus() : null) == User.ConnectionStatus.ONLINE.toString()) {
            TextView textView2 = aPCChatActivity.m;
            if (textView2 != null && textView2.getVisibility() != 0) {
                TextView textView3 = aPCChatActivity.l;
                if (textView3 != null) {
                    textView3.setText(R.string.chat_module_online);
                }
                TextView textView4 = aPCChatActivity.l;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        TextView textView5 = aPCChatActivity.l;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
    }

    public static final /* synthetic */ void a(APCChatActivity aPCChatActivity, UserExtendedMetaData userExtendedMetaData) {
        View findViewById = aPCChatActivity.findViewById(R.id.menuItemDividerView);
        kotlin.g.b.k.a((Object) findViewById, "findViewById(R.id.menuItemDividerView)");
        View findViewById2 = aPCChatActivity.findViewById(R.id.layoutChannelBottom);
        kotlin.g.b.k.a((Object) findViewById2, "findViewById(R.id.layoutChannelBottom)");
        View findViewById3 = aPCChatActivity.findViewById(R.id.layoutDynamicItem1);
        kotlin.g.b.k.a((Object) findViewById3, "findViewById(R.id.layoutDynamicItem1)");
        View findViewById4 = aPCChatActivity.findViewById(R.id.layoutDynamicItem2);
        kotlin.g.b.k.a((Object) findViewById4, "findViewById(R.id.layoutDynamicItem2)");
        View findViewById5 = aPCChatActivity.findViewById(R.id.txtDynamicItem1);
        kotlin.g.b.k.a((Object) findViewById5, "findViewById(R.id.txtDynamicItem1)");
        TextView textView = (TextView) findViewById5;
        View findViewById6 = aPCChatActivity.findViewById(R.id.txtDynamicItem2);
        kotlin.g.b.k.a((Object) findViewById6, "findViewById(R.id.txtDynamicItem2)");
        TextView textView2 = (TextView) findViewById6;
        View findViewById7 = aPCChatActivity.findViewById(R.id.imgDynamicItem1);
        kotlin.g.b.k.a((Object) findViewById7, "findViewById(R.id.imgDynamicItem1)");
        AppCompatImageView appCompatImageView = (AppCompatImageView) findViewById7;
        View findViewById8 = aPCChatActivity.findViewById(R.id.imgDynamicItem2);
        kotlin.g.b.k.a((Object) findViewById8, "findViewById(R.id.imgDynamicItem2)");
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) findViewById8;
        if (userExtendedMetaData.getMetadata() != null) {
            UserExtendedMetaData.MetaData metadata = userExtendedMetaData.getMetadata();
            if (metadata == null) {
                kotlin.g.b.k.a();
            }
            if (metadata.getMenuItems() != null) {
                UserExtendedMetaData.MetaData metadata2 = userExtendedMetaData.getMetadata();
                if (metadata2 == null) {
                    kotlin.g.b.k.a();
                }
                List<com.paytm.android.chat.view.d> menuItems = metadata2.getMenuItems();
                if (menuItems == null) {
                    kotlin.g.b.k.a();
                }
                if (menuItems.size() > 0) {
                    UserExtendedMetaData.MetaData metadata3 = userExtendedMetaData.getMetadata();
                    if (metadata3 == null) {
                        kotlin.g.b.k.a();
                    }
                    List<com.paytm.android.chat.view.d> menuItems2 = metadata3.getMenuItems();
                    if (menuItems2 == null) {
                        kotlin.g.b.k.a();
                    }
                    if (menuItems2.size() == 1) {
                        findViewById4.setVisibility(8);
                        findViewById.setVisibility(8);
                        com.paytm.android.chat.view.d dVar = menuItems2.get(0);
                        String str = dVar.f42567a;
                        String str2 = dVar.f42568b;
                        String str3 = dVar.f42569c;
                        List<com.paytm.android.chat.view.d> list = dVar.f42570d;
                        textView.setText(str);
                        com.bumptech.glide.b.b(appCompatImageView.getContext()).a(str2).a((ImageView) appCompatImageView);
                        if (list == null || list.size() <= 0) {
                            findViewById3.setOnClickListener(new af(aPCChatActivity, str3));
                        } else {
                            findViewById3.setOnClickListener(new ae(aPCChatActivity, menuItems2));
                        }
                        findViewById3.setVisibility(0);
                    } else {
                        com.paytm.android.chat.view.d dVar2 = menuItems2.get(0);
                        String str4 = dVar2.f42567a;
                        String str5 = dVar2.f42568b;
                        String str6 = dVar2.f42569c;
                        List<com.paytm.android.chat.view.d> list2 = dVar2.f42570d;
                        textView.setText(str4);
                        com.bumptech.glide.b.b(appCompatImageView.getContext()).a(str5).a((ImageView) appCompatImageView);
                        if (list2 == null || list2.size() <= 0) {
                            findViewById3.setOnClickListener(new ah(aPCChatActivity, str6));
                        } else {
                            findViewById3.setOnClickListener(new ag(aPCChatActivity, list2));
                        }
                        com.paytm.android.chat.view.d dVar3 = menuItems2.get(1);
                        String str7 = dVar3.f42567a;
                        String str8 = dVar3.f42568b;
                        String str9 = dVar3.f42569c;
                        List<com.paytm.android.chat.view.d> list3 = dVar3.f42570d;
                        textView2.setText(str7);
                        com.bumptech.glide.b.b(appCompatImageView2.getContext()).a(str8).a((ImageView) appCompatImageView2);
                        if (list3 == null || list3.size() <= 0) {
                            findViewById4.setOnClickListener(new aj(aPCChatActivity, str9));
                        } else {
                            findViewById4.setOnClickListener(new ai(aPCChatActivity, list3));
                        }
                        findViewById.setVisibility(0);
                        findViewById3.setVisibility(0);
                        findViewById4.setVisibility(0);
                    }
                    findViewById2.setVisibility(0);
                    return;
                }
            }
        }
        findViewById2.setVisibility(8);
        findViewById3.setOnClickListener((View.OnClickListener) null);
        findViewById4.setOnClickListener((View.OnClickListener) null);
    }

    public static final /* synthetic */ void a(APCChatActivity aPCChatActivity, List list) {
        try {
            if (aPCChatActivity.F != null) {
                MenuItemBottomSheet menuItemBottomSheet = aPCChatActivity.F;
                if (menuItemBottomSheet != null) {
                    menuItemBottomSheet.f41823a.dismiss();
                }
                aPCChatActivity.F = null;
            }
            Context context = aPCChatActivity;
            if (list == null) {
                kotlin.g.b.k.a();
            }
            aPCChatActivity.F = new MenuItemBottomSheet(context, list);
            MenuItemBottomSheet menuItemBottomSheet2 = aPCChatActivity.F;
            if (menuItemBottomSheet2 != null) {
                menuItemBottomSheet2.setClickListener(new bh(aPCChatActivity));
            }
            MenuItemBottomSheet menuItemBottomSheet3 = aPCChatActivity.F;
            if (menuItemBottomSheet3 != null) {
                menuItemBottomSheet3.f41823a.show();
            }
        } catch (Exception unused) {
        }
    }
}
