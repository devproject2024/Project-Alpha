package net.one97.paytm.wallet.newdesign.postcard.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaDetailsResponse;
import net.one97.paytm.common.entity.lifafa.SentLifafaDetailsResponse;
import net.one97.paytm.common.entity.wallet.CJRPostcardSentData;
import net.one97.paytm.common.entity.wallet.postcard.data.PostcardThemesResponseDataModel;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.utils.n;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.newdesign.postcard.b.d;
import net.one97.paytm.wallet.newdesign.postcard.d;

public class e extends h implements View.OnClickListener, d.C1447d {
    private TextView A;
    private FrameLayout B;
    private CardView C;
    private RoboTextView D;
    private RoboTextView E;
    private RoboTextView F;
    private RoboTextView G;
    private RoboTextView H;
    /* access modifiers changed from: private */
    public RecyclerView I;
    private net.one97.paytm.wallet.newdesign.postcard.a.a J;
    private RelativeLayout K;
    private LinearLayout L;
    private LinearLayout M;
    private LinearLayout N;
    /* access modifiers changed from: private */
    public RelativeLayout O;
    private String P = "d4ac0e69-7852-11e7-83c6-1866da8588af";
    private d Q;
    private PostcardThemesResponseDataModel R;
    private boolean S = false;
    private d.b T;

    /* renamed from: a  reason: collision with root package name */
    RoboTextView f71288a;

    /* renamed from: b  reason: collision with root package name */
    RoboTextView f71289b;

    /* renamed from: c  reason: collision with root package name */
    private b f71290c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f71291d;

    /* renamed from: e  reason: collision with root package name */
    private IJRDataModel f71292e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f71293f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f71294g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f71295h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f71296i;
    private String j;
    private CardView k;
    private RelativeLayout l;
    private LinearLayout m;
    private boolean n;
    private ImageView o;
    private ImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    public interface b {
    }

    public final void a(NetworkCustomError networkCustomError) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!(getArguments() == null || getArguments().getSerializable("data") == null)) {
            this.f71292e = (IJRDataModel) getArguments().getSerializable("data");
            this.j = getArguments().getString("event_id");
            this.n = getArguments().getBoolean("first_time");
        }
        this.Q = net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity());
        this.R = this.Q.a((d.C1447d) this);
        if (this.R != null) {
            this.Q.b();
        }
    }

    public final void a(PostcardThemesResponseDataModel postcardThemesResponseDataModel) {
        if (getActivity() != null) {
            this.S = true;
            d.b bVar = this.T;
            if (bVar != null) {
                bVar.a(postcardThemesResponseDataModel);
            }
            net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity()).a();
        }
    }

    public final void a() {
        net.one97.paytm.wallet.newdesign.postcard.d.a((Context) getActivity()).b();
    }

    public final void a(String str, String str2) {
        com.paytm.utility.b.b((Context) getActivity(), str, str2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_lifafa_sent_view, viewGroup, false);
        this.f71291d = (ImageView) inflate.findViewById(R.id.iv_back_button);
        this.O = (RelativeLayout) inflate.findViewById(R.id.rl_card_bg);
        this.k = (CardView) inflate.findViewById(R.id.cardtop);
        this.M = (LinearLayout) inflate.findViewById(R.id.receive_top_ll);
        this.N = (LinearLayout) inflate.findViewById(R.id.receive_middle_ll);
        this.f71291d.setOnClickListener(this);
        this.A = (TextView) inflate.findViewById(R.id.tvYouAreLate);
        this.z = (TextView) inflate.findViewById(R.id.tvAllClaimedLifafaMessage);
        this.L = (LinearLayout) inflate.findViewById(R.id.llExpiredViewLayout);
        this.y = (TextView) inflate.findViewById(R.id.tvLuckyLifafaCountText);
        this.x = (TextView) inflate.findViewById(R.id.tvLifafaStatus);
        this.w = (TextView) inflate.findViewById(R.id.tvLifafaRecivedAmount);
        this.v = (TextView) inflate.findViewById(R.id.tvLifafaRecievedFromText);
        this.u = (TextView) inflate.findViewById(R.id.tvClaimed);
        this.t = (TextView) inflate.findViewById(R.id.tvLifafaSendTo);
        this.m = (LinearLayout) inflate.findViewById(R.id.lifafaSingleSentView);
        this.l = (RelativeLayout) inflate.findViewById(R.id.shareLayout);
        this.B = (FrameLayout) inflate.findViewById(R.id.mainLayout);
        this.o = (ImageView) inflate.findViewById(R.id.ivLifafaShare);
        this.o.setOnClickListener(this);
        this.p = (ImageView) inflate.findViewById(R.id.ivProfileImageView);
        this.q = (TextView) inflate.findViewById(R.id.tvPostMessage);
        this.r = (TextView) inflate.findViewById(R.id.tvTotalLifafaAmount);
        this.s = (TextView) inflate.findViewById(R.id.tvLifafaSenderName);
        this.p.bringToFront();
        this.H = (RoboTextView) inflate.findViewById(R.id.tvTime);
        this.K = (RelativeLayout) inflate.findViewById(R.id.rlRecycleview);
        this.I = (RecyclerView) inflate.findViewById(R.id.recycleview);
        IJRDataModel iJRDataModel = this.f71292e;
        if (iJRDataModel != null) {
            if (iJRDataModel instanceof CJRPostcardSentData) {
                if (TextUtils.isEmpty(com.paytm.utility.b.al(getActivity()))) {
                    w.a().a(com.paytm.utility.b.al(getActivity())).a((Drawable) new ColorDrawable(getActivity().getResources().getColor(R.color.color_postcard_theme1))).a((ah) new a()).a(this.p, (com.squareup.picasso.e) null);
                }
                if (e() != null) {
                    this.p.setBackground(new BitmapDrawable(getResources(), e()));
                }
            } else {
                if (iJRDataModel instanceof ReceivedLifafaDetailsResponse) {
                    ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse = (ReceivedLifafaDetailsResponse) iJRDataModel;
                    if (!TextUtils.isEmpty(receivedLifafaDetailsResponse.getLifafaDetail().getCreatorLogo())) {
                        w.a().a(receivedLifafaDetailsResponse.getLifafaDetail().getCreatorLogo()).a((Drawable) new ColorDrawable(getActivity().getResources().getColor(R.color.color_postcard_theme1))).a((ah) new a()).a(this.p, (com.squareup.picasso.e) null);
                    } else if (e() != null) {
                        this.p.setBackground(new BitmapDrawable(getResources(), e()));
                    }
                }
                IJRDataModel iJRDataModel2 = this.f71292e;
                if (iJRDataModel2 instanceof SentLifafaDetailsResponse) {
                    if (!TextUtils.isEmpty(((SentLifafaDetailsResponse) iJRDataModel2).getLifafaDetail().getCreatorLogo())) {
                        w.a().a(com.paytm.utility.b.al(getActivity())).a((Drawable) new ColorDrawable(getActivity().getResources().getColor(R.color.color_postcard_theme1))).a((ah) new a()).a(this.p, (com.squareup.picasso.e) null);
                    } else if (e() != null) {
                        this.p.setBackground(new BitmapDrawable(getResources(), e()));
                    }
                }
            }
        }
        this.f71293f = (TextView) inflate.findViewById(R.id.tv_title);
        this.f71294g = (TextView) inflate.findViewById(R.id.tv_description);
        this.f71295h = (TextView) inflate.findViewById(R.id.tv_amount);
        this.f71296i = (TextView) inflate.findViewById(R.id.tv_from_name);
        this.f71288a = (RoboTextView) inflate.findViewById(R.id.tv_postcard_status);
        this.f71289b = (RoboTextView) inflate.findViewById(R.id.tv_expiry);
        this.C = (CardView) inflate.findViewById(R.id.cardtop);
        this.D = (RoboTextView) inflate.findViewById(R.id.tvFb);
        this.G = (RoboTextView) inflate.findViewById(R.id.tvMsg);
        this.E = (RoboTextView) inflate.findViewById(R.id.tvTw);
        this.F = (RoboTextView) inflate.findViewById(R.id.tvWt);
        this.D.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        if (!net.one97.paytm.wallet.utility.a.c((Context) getActivity(), n.T)) {
            this.D.setVisibility(8);
        }
        if (!net.one97.paytm.wallet.utility.a.c((Context) getActivity(), n.bi)) {
            this.E.setVisibility(8);
        }
        if (!net.one97.paytm.wallet.utility.a.c((Context) getActivity(), n.bh)) {
            this.G.setVisibility(8);
        }
        if (!net.one97.paytm.wallet.utility.a.c((Context) getActivity(), n.bj)) {
            this.F.setVisibility(8);
        }
        IJRDataModel iJRDataModel3 = this.f71292e;
        if (iJRDataModel3 == null) {
            TextUtils.isEmpty(this.j);
        } else if (iJRDataModel3 instanceof CJRPostcardSentData) {
            if (((CJRPostcardSentData) iJRDataModel3).isLuckyLifafa()) {
                IJRDataModel iJRDataModel4 = this.f71292e;
                if (iJRDataModel4 instanceof CJRPostcardSentData) {
                    CJRPostcardSentData cJRPostcardSentData = (CJRPostcardSentData) iJRDataModel4;
                    TextView textView = this.r;
                    textView.setText(getString(R.string.rupee_symbol) + "0 / " + getString(R.string.rupee_symbol) + a(cJRPostcardSentData.getAmount()));
                    this.s.setText(c());
                    this.q.setText(cJRPostcardSentData.getDesciptionMessage());
                    b(cJRPostcardSentData.getmThemeId());
                    this.H.setText(net.one97.paytm.wallet.utility.a.a());
                    if (TextUtils.isEmpty(cJRPostcardSentData.getmLifafaCount()) || Integer.parseInt(cJRPostcardSentData.getmLifafaCount()) != 1) {
                        this.y.setText(String.format(getResources().getString(R.string.first_ten_people_text), new Object[]{cJRPostcardSentData.getmLifafaCount()}));
                    } else {
                        this.y.setText(getResources().getString(R.string.single_create_lucky_lifafa));
                    }
                }
            } else {
                IJRDataModel iJRDataModel5 = this.f71292e;
                if (iJRDataModel5 instanceof CJRPostcardSentData) {
                    CJRPostcardSentData cJRPostcardSentData2 = (CJRPostcardSentData) iJRDataModel5;
                    this.o.setVisibility(8);
                    TextView textView2 = this.r;
                    textView2.setText(getString(R.string.rupee_symbol) + a(cJRPostcardSentData2.getAmount()));
                    this.s.setText(c());
                    this.q.setText(cJRPostcardSentData2.getDesciptionMessage());
                    b(cJRPostcardSentData2.getmThemeId());
                    TextView textView3 = this.t;
                    textView3.setText("To: " + cJRPostcardSentData2.getRecepientName());
                    this.H.setText(net.one97.paytm.wallet.utility.a.a());
                    this.l.setVisibility(8);
                    this.m.setVisibility(0);
                    this.u.setVisibility(8);
                }
            }
        } else if (iJRDataModel3 instanceof ReceivedLifafaDetailsResponse) {
            ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse2 = (ReceivedLifafaDetailsResponse) iJRDataModel3;
            if (receivedLifafaDetailsResponse2 != null) {
                this.q.setText(receivedLifafaDetailsResponse2.getLifafaDetail().getLifafaMessage());
                this.p.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in));
                this.M.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.wallet_bottom_up));
                this.N.setAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.fade_in));
                b(receivedLifafaDetailsResponse2.getThemeDetailsResponse().getId());
                this.o.setVisibility(8);
                this.w.setVisibility(0);
                this.v.setVisibility(0);
                this.r.setVisibility(8);
                this.l.setVisibility(8);
                String phoneNo = (TextUtils.isEmpty(receivedLifafaDetailsResponse2.getLifafaDetail().getCreatorInfo().getName()) || "null".equalsIgnoreCase(receivedLifafaDetailsResponse2.getLifafaDetail().getCreatorInfo().getName())) ? receivedLifafaDetailsResponse2.getLifafaDetail().getCreatorInfo().getPhoneNo() : receivedLifafaDetailsResponse2.getLifafaDetail().getCreatorInfo().getName();
                receivedLifafaDetailsResponse2.getLifafaDetail().getCreatorInfo().setName(phoneNo);
                this.s.setText(phoneNo);
                this.u.setVisibility(8);
                if (receivedLifafaDetailsResponse2.getLifafaFetcherDetails() != null && !TextUtils.isEmpty(receivedLifafaDetailsResponse2.getLifafaFetcherDetails().getProcessTimestamp())) {
                    this.H.setText(com.paytm.utility.b.g(receivedLifafaDetailsResponse2.getLifafaFetcherDetails().getProcessTimestamp(), "yyyy-MM-dd hh:mm:ss", "dd MMM yy, hh:mm aa"));
                }
                if (receivedLifafaDetailsResponse2.getLifafaFetcherDetails() != null) {
                    TextView textView4 = this.w;
                    String string = getActivity().getResources().getString(R.string.lifafa_get_money);
                    textView4.setText(String.format(string, new Object[]{getActivity().getResources().getString(R.string.rupee_symbol) + Integer.valueOf(receivedLifafaDetailsResponse2.getLifafaFetcherDetails().getProposedQuantity().intValue())}));
                } else {
                    TextView textView5 = this.w;
                    String string2 = getActivity().getResources().getString(R.string.lifafa_get_money);
                    textView5.setText(String.format(string2, new Object[]{getActivity().getResources().getString(R.string.rupee_symbol) + Integer.valueOf(receivedLifafaDetailsResponse2.getLifafaDetail().getProposedQuantity().intValue())}));
                }
                if (!TextUtils.isEmpty(receivedLifafaDetailsResponse2.getLifafaDetail().getStrategyType()) && receivedLifafaDetailsResponse2.getLifafaDetail().getStrategyType().equalsIgnoreCase("UNIFORM")) {
                    this.K.setVisibility(8);
                } else if (!TextUtils.isEmpty(receivedLifafaDetailsResponse2.getLifafaDetail().getStrategyType()) && receivedLifafaDetailsResponse2.getLifafaDetail().getStrategyType().equalsIgnoreCase("RANDOM")) {
                    if (receivedLifafaDetailsResponse2.getRecipientDetails() != null) {
                        this.o.setVisibility(0);
                        this.K.setVisibility(8);
                        this.I.setVisibility(8);
                        this.J = new net.one97.paytm.wallet.newdesign.postcard.a.a(getActivity(), receivedLifafaDetailsResponse2);
                        this.I.setLayoutManager(new LinearLayoutManager(getActivity()));
                        this.I.setItemAnimator(new g());
                        this.I.setAdapter(this.J);
                        final RelativeLayout relativeLayout = this.K;
                        try {
                            if (Build.VERSION.SDK_INT >= 11) {
                                relativeLayout.measure(-1, -2);
                                final int measuredHeight = relativeLayout.getMeasuredHeight();
                                relativeLayout.getLayoutParams().height = 0;
                                relativeLayout.setVisibility(0);
                                AnonymousClass2 r5 = new Animation() {
                                    public final boolean willChangeBounds() {
                                        return true;
                                    }

                                    /* access modifiers changed from: protected */
                                    public final void applyTransformation(float f2, Transformation transformation) {
                                        relativeLayout.getLayoutParams().height = f2 == 1.0f ? -2 : (int) (((float) measuredHeight) * f2);
                                        relativeLayout.requestLayout();
                                    }
                                };
                                r5.setDuration(1000);
                                relativeLayout.startAnimation(r5);
                                r5.setAnimationListener(new Animation.AnimationListener() {
                                    public final void onAnimationRepeat(Animation animation) {
                                    }

                                    public final void onAnimationStart(Animation animation) {
                                    }

                                    public final void onAnimationEnd(Animation animation) {
                                        e.this.I.setVisibility(0);
                                    }
                                });
                            } else {
                                relativeLayout.setVisibility(0);
                                this.I.setVisibility(0);
                            }
                        } catch (Exception unused) {
                        }
                    }
                    if (receivedLifafaDetailsResponse2.getRecipientDetails().size() == receivedLifafaDetailsResponse2.getLifafaDetail().getProposedReceiverCount() && receivedLifafaDetailsResponse2.getStatusCode().equalsIgnoreCase("EV_0041")) {
                        this.H.setVisibility(8);
                        this.u.setVisibility(8);
                        this.q.setVisibility(8);
                        this.r.setVisibility(8);
                        this.H.setVisibility(8);
                        this.L.setVisibility(0);
                        this.z.setText(String.format(getResources().getString(R.string.lucky_lifafa_all_claimed), new Object[]{phoneNo, receivedLifafaDetailsResponse2.getLifafaDetail().getProposedQuantity()}));
                    } else if (receivedLifafaDetailsResponse2.getStatusCode().equalsIgnoreCase("PE_0005")) {
                        this.H.setVisibility(8);
                        this.u.setVisibility(8);
                        this.q.setVisibility(8);
                        this.r.setVisibility(8);
                        this.H.setVisibility(8);
                        this.L.setVisibility(0);
                        this.z.setText(getResources().getString(R.string.lifafa_expire));
                    } else if (receivedLifafaDetailsResponse2.getStatusCode().equalsIgnoreCase("PE_0000")) {
                        this.H.setVisibility(8);
                        this.u.setVisibility(8);
                        this.q.setVisibility(8);
                        this.r.setVisibility(8);
                        this.H.setVisibility(8);
                        this.L.setVisibility(0);
                        this.A.setText("Already Claimed");
                        this.z.setText(String.format(getResources().getString(R.string.lucky_lifafa_all_claimed), new Object[]{phoneNo, receivedLifafaDetailsResponse2.getLifafaDetail().getProposedQuantity()}));
                    } else if (!TextUtils.isEmpty(receivedLifafaDetailsResponse2.getLifafaDetail().getLifafaStatus()) && !receivedLifafaDetailsResponse2.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("ACTIVATED") && !receivedLifafaDetailsResponse2.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("CLOSED") && ((receivedLifafaDetailsResponse2.getRecipientDetails().size() != receivedLifafaDetailsResponse2.getLifafaDetail().getProposedReceiverCount() || !receivedLifafaDetailsResponse2.getStatusCode().equalsIgnoreCase("PE_0005")) && receivedLifafaDetailsResponse2.getStatusCode().equalsIgnoreCase("EV_0041") && !receivedLifafaDetailsResponse2.getStatusCode().equalsIgnoreCase("PE_0000"))) {
                        this.H.setVisibility(8);
                        this.u.setVisibility(8);
                        this.q.setVisibility(8);
                        this.r.setVisibility(8);
                        this.H.setVisibility(8);
                        this.L.setVisibility(0);
                        this.A.setText(SDKConstants.GA_NATIVE_FAILED);
                        this.z.setText(String.format(getResources().getString(R.string.lucky_lifafa_all_claimed), new Object[]{phoneNo, receivedLifafaDetailsResponse2.getLifafaDetail().getProposedQuantity()}));
                    }
                }
            }
        } else if (iJRDataModel3 instanceof SentLifafaDetailsResponse) {
            d();
        }
        return inflate;
    }

    public class a implements ah {
        public final String key() {
            return "circle";
        }

        public a() {
        }

        public final Bitmap transform(Bitmap bitmap) {
            int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
            if (createBitmap != bitmap) {
                bitmap.recycle();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig());
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
            paint.setAntiAlias(true);
            float f2 = ((float) min) / 2.0f;
            canvas.drawCircle(f2, f2, f2, paint);
            createBitmap.recycle();
            return createBitmap2;
        }
    }

    private String b() {
        IJRDataModel iJRDataModel = this.f71292e;
        if (iJRDataModel instanceof CJRPostcardSentData) {
            CJRPostcardSentData cJRPostcardSentData = (CJRPostcardSentData) iJRDataModel;
            return cJRPostcardSentData.getName() + " " + getResources().getString(R.string.lifafa_share) + " http://m.p-y.tm/claimlifafa?lifafaId=" + cJRPostcardSentData.getmLifafaKey() + " # LuckyLifafa";
        }
        if (iJRDataModel instanceof ReceivedLifafaDetailsResponse) {
            ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse = (ReceivedLifafaDetailsResponse) iJRDataModel;
            if (TextUtils.isEmpty(receivedLifafaDetailsResponse.getLifafaDetail().getStrategyType()) || !receivedLifafaDetailsResponse.getLifafaDetail().getStrategyType().equalsIgnoreCase("RANDOM")) {
                return receivedLifafaDetailsResponse.getLifafaDetail().getCreatorInfo().getName() + " " + getResources().getString(R.string.lifafa_share) + " http://m.p-y.tm/claimlifafa?lifafaId=" + receivedLifafaDetailsResponse.getLifafaDetail().getLifafaKey() + " # LuckyLifafa";
            } else if (receivedLifafaDetailsResponse.getRecipientDetails() != null) {
                if (receivedLifafaDetailsResponse.getRecipientDetails().size() == 0 || receivedLifafaDetailsResponse.getRecipientDetails().size() == receivedLifafaDetailsResponse.getLifafaDetail().getProposedReceiverCount()) {
                    StringBuilder sb = new StringBuilder();
                    String string = getResources().getString(R.string.lifafa_complete_claimed);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Integer.valueOf(receivedLifafaDetailsResponse.getLifafaFetcherDetails().getProposedQuantity().intValue()));
                    sb.append(String.format(string, new Object[]{sb2.toString(), "http://m.p-y.tm/claimlifafa?lifafaId=" + receivedLifafaDetailsResponse.getLifafaDetail().getLifafaKey()}));
                    sb.append(" # LuckyLifafa");
                    return sb.toString();
                }
                StringBuilder sb3 = new StringBuilder();
                String string2 = getResources().getString(R.string.lifafa_not_complete_claimed);
                StringBuilder sb4 = new StringBuilder();
                sb4.append(Integer.valueOf(receivedLifafaDetailsResponse.getLifafaFetcherDetails().getProposedQuantity().intValue()));
                sb3.append(String.format(string2, new Object[]{sb4.toString(), "http://m.p-y.tm/claimlifafa?lifafaId=" + receivedLifafaDetailsResponse.getLifafaDetail().getLifafaKey()}));
                sb3.append(" # LuckyLifafa");
                return sb3.toString();
            }
        }
        IJRDataModel iJRDataModel2 = this.f71292e;
        if (!(iJRDataModel2 instanceof SentLifafaDetailsResponse)) {
            return null;
        }
        SentLifafaDetailsResponse sentLifafaDetailsResponse = (SentLifafaDetailsResponse) iJRDataModel2;
        return sentLifafaDetailsResponse.getLifafaDetail().getCreatorInfo().getName() + " " + getResources().getString(R.string.lifafa_share) + " http://m.p-y.tm/claimlifafa?lifafaId=" + sentLifafaDetailsResponse.getLifafaDetail().getLifafaKey() + " # LuckyLifafa";
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            if (context instanceof b) {
                this.f71290c = (b) context;
            }
        } catch (Exception e2) {
            q.d(String.valueOf(e2));
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f71290c = null;
    }

    public void onClick(View view) {
        if (this.f71291d == view) {
            getActivity().onBackPressed();
        } else if (view == this.o) {
            if (this.f71292e instanceof ReceivedLifafaDetailsResponse) {
                String b2 = b();
                if (getActivity() == null) {
                    return;
                }
                if (!s.a() || getActivity().checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
                    try {
                        Intent intent = new Intent("android.intent.action.SEND");
                        intent.setType("image/png");
                        intent.putExtra("android.intent.extra.SUBJECT", getString(R.string.post_payment_share_subject));
                        intent.putExtra("android.intent.extra.TEXT", b2);
                        RelativeLayout relativeLayout = this.K;
                        Bitmap createBitmap = Bitmap.createBitmap(relativeLayout.getWidth(), relativeLayout.getHeight(), Bitmap.Config.ARGB_8888);
                        relativeLayout.draw(new Canvas(createBitmap));
                        String insertImage = MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), createBitmap, getString(R.string.title), (String) null);
                        if (insertImage != null) {
                            intent.putExtra("android.intent.extra.STREAM", Uri.parse(insertImage));
                            Intent createChooser = Intent.createChooser(intent, getResources().getString(R.string.lifafa_share_using));
                            if (createChooser.resolveActivity(getActivity().getPackageManager()) != null) {
                                startActivity(createChooser);
                            } else {
                                Toast.makeText(getActivity(), getString(R.string.no_app_found), 1).show();
                            }
                        }
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e2));
                        }
                    }
                } else {
                    s.b((Activity) getActivity());
                    Toast.makeText(getActivity(), getString(R.string.permission_not_granted), 0).show();
                }
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.SEND");
                intent2.putExtra("android.intent.extra.TEXT", b());
                intent2.setType("text/plain");
                startActivity(Intent.createChooser(intent2, getResources().getString(R.string.lifafa_share_using)));
            }
        } else if (view == this.D) {
            net.one97.paytm.wallet.utility.a.a((Context) getActivity(), n.T, b());
        } else if (view == this.G) {
            net.one97.paytm.wallet.utility.a.a((Context) getActivity(), n.bh, b());
        } else if (view == this.E) {
            net.one97.paytm.wallet.utility.a.a((Context) getActivity(), n.bi, b());
        } else if (view == this.F) {
            net.one97.paytm.wallet.utility.a.a((Context) getActivity(), n.bj, b());
        }
    }

    private String c() {
        if (TextUtils.isEmpty(com.paytm.utility.b.h((Context) getActivity())) || "null".equalsIgnoreCase(com.paytm.utility.b.h((Context) getActivity()))) {
            return com.paytm.utility.b.l((Context) getActivity());
        }
        return !TextUtils.isEmpty(com.paytm.utility.b.h((Context) getActivity())) ? com.paytm.utility.b.h((Context) getActivity()) : "";
    }

    private void d() {
        SentLifafaDetailsResponse sentLifafaDetailsResponse = (SentLifafaDetailsResponse) this.f71292e;
        b(sentLifafaDetailsResponse.getThemeDetailsResponse().getId());
        this.o.setVisibility(0);
        this.l.setVisibility(8);
        this.r.setVisibility(0);
        this.u.setVisibility(0);
        this.q.setText(sentLifafaDetailsResponse.getLifafaDetail().getLifafaMessage());
        String phoneNo = (TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getCreatorInfo().getName()) || "null".equalsIgnoreCase(sentLifafaDetailsResponse.getLifafaDetail().getCreatorInfo().getName())) ? sentLifafaDetailsResponse.getLifafaDetail().getCreatorInfo().getPhoneNo() : sentLifafaDetailsResponse.getLifafaDetail().getCreatorInfo().getName();
        sentLifafaDetailsResponse.getLifafaDetail().getCreatorInfo().setName(phoneNo);
        this.s.setText(phoneNo);
        this.H.setText(com.paytm.utility.b.g(sentLifafaDetailsResponse.getLifafaDetail().getCreateTimestamp(), "yyyy-MM-dd hh:mm:ss", "dd MMM yy, hh:mm aa"));
        int i2 = 0;
        for (int i3 = 0; i3 < sentLifafaDetailsResponse.getRecipientDetails().size(); i3++) {
            i2 += sentLifafaDetailsResponse.getRecipientDetails().get(i3).getProposedQuantity().intValue();
        }
        int intValue = sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue() - i2;
        TextView textView = this.r;
        textView.setText(getString(R.string.rupee_symbol) + i2 + " / " + getString(R.string.rupee_symbol) + sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue());
        if (!TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getStrategyType()) && sentLifafaDetailsResponse.getLifafaDetail().getStrategyType().equalsIgnoreCase("UNIFORM")) {
            this.o.setVisibility(8);
            String phoneNo2 = (TextUtils.isEmpty(sentLifafaDetailsResponse.getRecipientDetails().get(0).getRecipientInfo().getName()) || "null".equalsIgnoreCase(sentLifafaDetailsResponse.getRecipientDetails().get(0).getRecipientInfo().getName())) ? sentLifafaDetailsResponse.getRecipientDetails().get(0).getRecipientInfo().getPhoneNo() : sentLifafaDetailsResponse.getRecipientDetails().get(0).getRecipientInfo().getName();
            String g2 = com.paytm.utility.b.g(sentLifafaDetailsResponse.getLifafaDetail().getExpiryTimestamp(), "yyyy-MM-dd", "dd-MMM-yyyy");
            if (TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) || !sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("ACTIVATED")) {
                if (!TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("CLOSED")) {
                    TextView textView2 = this.r;
                    textView2.setText(getString(R.string.rupee_symbol) + Integer.valueOf(sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue()));
                    this.m.setVisibility(0);
                    this.u.setVisibility(8);
                    this.x.setVisibility(0);
                    this.x.setText("Successfully Claimed");
                    this.t.setText("by ".concat(String.valueOf(phoneNo2)));
                } else if (!TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_EXPIRED)) {
                    this.m.setVisibility(0);
                    this.u.setVisibility(8);
                    this.x.setVisibility(0);
                    this.x.setText("Lifafa Expired");
                    this.x.setTextColor(getResources().getColor(R.color.red));
                    TextView textView3 = this.t;
                    String string = getResources().getString(R.string.single_sent_lifafa_expired);
                    textView3.setText(String.format(string, new Object[]{getString(R.string.rupee_symbol) + Integer.valueOf(sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue())}));
                } else if (!TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
                    this.m.setVisibility(0);
                    this.u.setVisibility(8);
                    this.x.setVisibility(0);
                    this.x.setText("Lifafa Cancelled");
                    this.x.setTextColor(getResources().getColor(R.color.red));
                    TextView textView4 = this.t;
                    String string2 = getResources().getString(R.string.single_lifafa_cancel);
                    textView4.setText(String.format(string2, new Object[]{getString(R.string.rupee_symbol) + Integer.valueOf(sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue())}));
                } else if (!TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("CANCELLATION_PENDING")) {
                    this.m.setVisibility(0);
                    this.u.setVisibility(8);
                    this.x.setVisibility(0);
                    this.x.setText("Lifafa Cancelled");
                    this.x.setTextColor(getResources().getColor(R.color.red));
                    this.t.setText(String.format(getResources().getString(R.string.single_lifafa_cancel_pending), new Object[]{g2}));
                } else if (!TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("CANCELLATION_PENDING")) {
                    this.m.setVisibility(0);
                    this.u.setVisibility(8);
                    this.x.setVisibility(0);
                    this.x.setText("Lifafa Expired");
                    this.x.setTextColor(getResources().getColor(R.color.red));
                    TextView textView5 = this.t;
                    String string3 = getResources().getString(R.string.single_lifafa_expire_pending);
                    textView5.setText(String.format(string3, new Object[]{getString(R.string.rupee_symbol) + Integer.valueOf(sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue())}));
                }
            } else if (sentLifafaDetailsResponse.getRecipientDetails().get(0).getRecipientStatus().equalsIgnoreCase("ACTIVATED")) {
                TextView textView6 = this.r;
                textView6.setText(getString(R.string.rupee_symbol) + Integer.valueOf(sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue()));
                this.m.setVisibility(0);
                this.u.setVisibility(8);
                this.x.setVisibility(8);
                this.t.setText(String.format(getResources().getString(R.string.sent_lifafa_activated), new Object[]{g2}));
            } else if (sentLifafaDetailsResponse.getRecipientDetails().get(0).getRecipientStatus().equalsIgnoreCase("SUCCESS")) {
                TextView textView7 = this.r;
                textView7.setText(getString(R.string.rupee_symbol) + Integer.valueOf(sentLifafaDetailsResponse.getLifafaDetail().getProposedQuantity().intValue()));
                this.m.setVisibility(0);
                this.u.setVisibility(8);
                this.x.setVisibility(0);
                this.x.setText("Successfully Claimed");
                this.t.setText("by ".concat(String.valueOf(phoneNo2)));
            }
        } else if (!TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getStrategyType()) && sentLifafaDetailsResponse.getLifafaDetail().getStrategyType().equalsIgnoreCase("RANDOM") && sentLifafaDetailsResponse.getRecipientDetails() != null) {
            this.K.setVisibility(0);
            net.one97.paytm.wallet.newdesign.postcard.a.b bVar = new net.one97.paytm.wallet.newdesign.postcard.a.b(getActivity(), sentLifafaDetailsResponse);
            this.I.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.I.setItemAnimator(new g());
            this.I.setAdapter(bVar);
            this.o.setVisibility(0);
            if (sentLifafaDetailsResponse.getLifafaDetail().getProposedReceiverCount() == 1) {
                if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_EXPIRED)) {
                    this.K.setVisibility(8);
                    this.H.setVisibility(0);
                    RoboTextView roboTextView = this.H;
                    String string4 = getString(R.string.sent_lifafa_expired);
                    roboTextView.setText(String.format(string4, new Object[]{getString(R.string.rupee_symbol) + intValue}));
                } else if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
                    this.K.setVisibility(8);
                    this.H.setVisibility(0);
                    RoboTextView roboTextView2 = this.H;
                    String string5 = getString(R.string.lucky_lifafa_cancelled);
                    roboTextView2.setText(String.format(string5, new Object[]{getString(R.string.rupee_symbol) + intValue}));
                } else if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("CANCELLATION_PENDING")) {
                    this.K.setVisibility(8);
                    this.H.setTextColor(getResources().getColor(R.color.color_222222));
                    this.H.setText(getString(R.string.lucky_lifafa_cancel_pending));
                } else if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("EXPIRATION_PENDING")) {
                    this.K.setVisibility(8);
                    this.H.setTextColor(getResources().getColor(R.color.color_222222));
                    this.H.setText(getString(R.string.lucky_lifafa_expire_pending));
                }
            } else if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_EXPIRED)) {
                this.H.setVisibility(0);
                RoboTextView roboTextView3 = this.H;
                String string6 = getString(R.string.sent_lifafa_expired);
                roboTextView3.setText(String.format(string6, new Object[]{getString(R.string.rupee_symbol) + intValue}));
            } else if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase(TxNotifyData.UPI_STATUS_CANCELLED)) {
                this.H.setVisibility(0);
                RoboTextView roboTextView4 = this.H;
                String string7 = getString(R.string.lucky_lifafa_cancelled);
                roboTextView4.setText(String.format(string7, new Object[]{getString(R.string.rupee_symbol) + intValue}));
            } else if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("CANCELLATION_PENDING")) {
                this.H.setTextColor(getResources().getColor(R.color.color_222222));
                this.H.setText(getString(R.string.lucky_lifafa_cancel_pending));
            } else if (intValue > 0 && !TextUtils.isEmpty(sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus()) && sentLifafaDetailsResponse.getLifafaDetail().getLifafaStatus().equalsIgnoreCase("EXPIRATION_PENDING")) {
                this.H.setTextColor(getResources().getColor(R.color.color_222222));
                this.H.setText(getString(R.string.lucky_lifafa_expire_pending));
            }
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (!str.endsWith(".0") && !str.endsWith(".00")) {
            return str;
        }
        String[] split = str.split("\\.");
        return split.length > 0 ? split[0] : str;
    }

    private void b(String str) {
        if (!this.Q.a(str)) {
            str = this.P;
        }
        Bitmap a2 = this.Q.a(str, (d.b) new d.b() {
            public final void a(final Bitmap bitmap) {
                if (e.this.getActivity() != null) {
                    e.this.getActivity().runOnUiThread(new Runnable() {
                        public final void run() {
                            if (bitmap != null) {
                                e.this.O.setBackground(new BitmapDrawable(bitmap));
                            }
                        }
                    });
                }
            }
        });
        if (a2 != null) {
            this.O.setBackground(new BitmapDrawable(a2));
        }
    }

    private Bitmap e() {
        String str;
        IJRDataModel iJRDataModel = this.f71292e;
        if (iJRDataModel instanceof ReceivedLifafaDetailsResponse) {
            str = this.Q.a(((ReceivedLifafaDetailsResponse) iJRDataModel).getThemeDetailsResponse().getId(), (Context) getActivity());
        } else if (iJRDataModel instanceof SentLifafaDetailsResponse) {
            str = this.Q.a(((SentLifafaDetailsResponse) iJRDataModel).getThemeDetailsResponse().getId(), (Context) getActivity());
        } else {
            str = iJRDataModel instanceof CJRPostcardSentData ? this.Q.a(((CJRPostcardSentData) iJRDataModel).getmThemeId(), (Context) getActivity()) : "";
        }
        if (TextUtils.isEmpty(str)) {
            str = this.Q.a(this.P, (Context) getActivity());
        }
        return BitmapFactory.decodeFile(str);
    }
}
