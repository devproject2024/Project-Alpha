package com.paytm.android.chat.view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.jsonbean.UserDataBean;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.android.chat.utils.DateUtils;
import com.paytm.android.chat.utils.DensityUtil;
import com.paytm.android.chat.utils.ImageUtils;
import com.paytm.android.chat.utils.SharedPreferencesUtil;

public abstract class a extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    private final View f42540a;

    /* renamed from: b  reason: collision with root package name */
    private View f42541b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f42542c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f42543d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f42544e;
    public View n;
    public TextView o;
    public View p;
    TextView q;
    public LinearLayout r;
    ImageView s;
    protected boolean t = false;

    public void a(UserDataBean userDataBean) {
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0051 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(android.view.View r3) {
        /*
            r2 = this;
            r2.<init>(r3)
            r0 = 0
            r2.t = r0
            int r0 = com.paytm.android.chat.R.id.card_group_chat_message
            android.view.View r0 = r3.findViewById(r0)
            r2.p = r0
            int r0 = com.paytm.android.chat.R.id.view_select_view
            android.view.View r0 = r3.findViewById(r0)
            r2.n = r0
            android.view.View r0 = r2.n
            if (r0 == 0) goto L_0x0023
            java.lang.String r1 = "#99E8EDF3"
            int r1 = android.graphics.Color.parseColor(r1)
            r0.setBackgroundColor(r1)
        L_0x0023:
            int r0 = com.paytm.android.chat.R.id.text_group_chat_date
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.o = r0
            int r0 = com.paytm.android.chat.R.id.text_group_chat_list_forward_tip
            android.view.View r0 = r3.findViewById(r0)
            r2.f42540a = r0
            int r0 = com.paytm.android.chat.R.id.chat_msg_time     // Catch:{ Exception -> 0x0051 }
            android.view.View r0 = r3.findViewById(r0)     // Catch:{ Exception -> 0x0051 }
            android.widget.TextView r0 = (android.widget.TextView) r0     // Catch:{ Exception -> 0x0051 }
            r2.q = r0     // Catch:{ Exception -> 0x0051 }
            android.widget.TextView r0 = r2.q     // Catch:{ Exception -> 0x0051 }
            r1 = 1060320051(0x3f333333, float:0.7)
            r0.setAlpha(r1)     // Catch:{ Exception -> 0x0051 }
            int r0 = com.paytm.android.chat.R.id.arrow     // Catch:{ Exception -> 0x0051 }
            android.view.View r0 = r3.findViewById(r0)     // Catch:{ Exception -> 0x0051 }
            android.widget.ImageView r0 = (android.widget.ImageView) r0     // Catch:{ Exception -> 0x0051 }
            r2.s = r0     // Catch:{ Exception -> 0x0051 }
        L_0x0051:
            int r0 = com.paytm.android.chat.R.id.group_chat_bubble     // Catch:{ Exception -> 0x005b }
            android.view.View r0 = r3.findViewById(r0)     // Catch:{ Exception -> 0x005b }
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0     // Catch:{ Exception -> 0x005b }
            r2.r = r0     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            int r0 = com.paytm.android.chat.R.id.layoutReply
            android.view.View r0 = r3.findViewById(r0)
            r2.f42541b = r0
            int r0 = com.paytm.android.chat.R.id.txtReplyTitle
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f42542c = r0
            int r0 = com.paytm.android.chat.R.id.txtReplyContent
            android.view.View r0 = r3.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            r2.f42543d = r0
            int r0 = com.paytm.android.chat.R.id.imgReply
            android.view.View r3 = r3.findViewById(r0)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r2.f42544e = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.a.<init>(android.view.View):void");
    }

    public final void a(boolean z, long j, Context context) {
        TextView textView = this.o;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
                this.o.setText(DateUtils.getMessageDate(j, context));
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = this.q;
        if (textView2 != null) {
            textView2.setText(DateUtils.formatTimeWithMarker(j));
        }
    }

    public final void b(boolean z, long j, Context context) {
        TextView textView = this.o;
        if (textView != null) {
            if (z) {
                textView.setVisibility(0);
                this.o.setText(DateUtils.getMessageDate(j, context));
            } else {
                textView.setVisibility(8);
            }
        }
        TextView textView2 = this.q;
        if (textView2 != null) {
            textView2.setAlpha(0.7f);
            this.q.setTextColor(Color.parseColor("#7F8386"));
            this.q.setText(DateUtils.formatDateMonthTime(j));
        }
    }

    public final void a(boolean z) {
        View view = this.f42540a;
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    public final void a(boolean z, boolean z2, boolean z3) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.p.getLayoutParams();
        if (z || !z2) {
            LinearLayout linearLayout = this.r;
            if (linearLayout != null) {
                if (z3) {
                    linearLayout.setBackground(linearLayout.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_bg));
                } else {
                    linearLayout.setBackground(linearLayout.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_bg));
                }
            }
            ImageView imageView = this.s;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            layoutParams.setMargins(0, DensityUtil.dp2px(8.0f), 0, 0);
            this.p.setLayoutParams(layoutParams);
            return;
        }
        LinearLayout linearLayout2 = this.r;
        if (linearLayout2 != null) {
            if (z3) {
                linearLayout2.setBackground(linearLayout2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_self_rounded_bg));
            } else {
                linearLayout2.setBackground(linearLayout2.getContext().getResources().getDrawable(R.drawable.chat_shape_chat_other_rounded_bg));
            }
        }
        ImageView imageView2 = this.s;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        layoutParams.setMargins(0, DensityUtil.dp2px(4.0f), 0, 0);
        this.p.setLayoutParams(layoutParams);
    }

    public final void b(boolean z) {
        this.t = z;
    }

    public final void a(UserDataBean userDataBean, ChatGroupChannelDataModel chatGroupChannelDataModel) {
        if (this.f42541b != null && this.f42544e != null && this.f42543d != null && this.f42542c != null) {
            if (userDataBean == null || chatGroupChannelDataModel == null) {
                this.f42541b.setOnClickListener((View.OnClickListener) null);
                this.f42541b.setVisibility(8);
                return;
            }
            if (SharedPreferencesUtil.getUserId().equalsIgnoreCase(userDataBean.getUserId())) {
                this.f42542c.setText(R.string.chat_you);
                ImageUtils.displayCircleCropFromUrl(this.f42544e.getContext(), SharedPreferencesUtil.getProfileImg(), this.f42544e);
            } else {
                this.f42542c.setText(chatGroupChannelDataModel.getReceiverDisplayInfo().getName());
                ImageUtils.displayCircleCropFromUrl(this.f42544e.getContext(), chatGroupChannelDataModel.getReceiverDisplayInfo().getProfileImage(), this.f42544e);
            }
            this.f42543d.setText(userDataBean.getContent());
            this.f42541b.setOnClickListener(new View.OnClickListener(userDataBean) {
                private final /* synthetic */ UserDataBean f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    a.this.a(this.f$1, view);
                }
            });
            this.f42541b.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(UserDataBean userDataBean, View view) {
        a(userDataBean);
    }
}
