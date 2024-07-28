package net.one97.paytm.wallet.newdesign.postcard.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import net.one97.paytm.common.entity.lifafa.ReceivedLifafaDetailsResponse;
import net.one97.paytm.common.widgets.CJRVolleyImageView;
import net.one97.paytm.wallet.R;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    ReceivedLifafaDetailsResponse f71162a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<ReceivedLifafaDetailsResponse.RecipientDetails> f71163b;

    /* renamed from: c  reason: collision with root package name */
    ReceivedLifafaDetailsResponse.LifafaFetcherDetails f71164c;

    /* renamed from: d  reason: collision with root package name */
    Context f71165d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f71166e = new ArrayList<String>() {
        {
            add("#2cce86");
            add("#6c7cff");
            add("#ffa400");
            add("#b069ec");
            add("#40cdd8");
            add("#fd5c7f");
            add("#f2c110");
            add("#f36bb4");
            add("#3ab6f4");
            add("#a6b7be");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private boolean f71167f;

    public a(Context context, ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse) {
        this.f71162a = receivedLifafaDetailsResponse;
        ReceivedLifafaDetailsResponse receivedLifafaDetailsResponse2 = this.f71162a;
        if (receivedLifafaDetailsResponse2 != null) {
            this.f71163b = receivedLifafaDetailsResponse2.getRecipientDetails();
            this.f71164c = this.f71162a.getLifafaFetcherDetails();
        }
        this.f71165d = context;
        if (this.f71162a.getRecipientDetails().size() == this.f71162a.getLifafaDetail().getProposedReceiverCount()) {
            this.f71167f = false;
        } else {
            this.f71167f = true;
        }
    }

    public final int getItemViewType(int i2) {
        if (this.f71167f) {
            if (i2 == 0) {
                return 0;
            }
            if (i2 == 1) {
                return 1;
            }
            return i2;
        } else if (i2 == 0) {
            return 0;
        } else {
            return i2;
        }
    }

    public final int getItemCount() {
        if (this.f71167f) {
            return this.f71163b.size() + 2;
        }
        return this.f71163b.size() + 1;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (this.f71167f) {
            if (i2 == 0) {
                return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_received_item_header, viewGroup, false));
            }
            if (i2 == 1) {
                return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_item_your_layout, viewGroup, false));
            }
            if (i2 % 2 == 0) {
                return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_sent_item_graybg, viewGroup, false));
            }
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_sent_item, viewGroup, false));
        } else if (i2 == 0) {
            return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_received_item_header, viewGroup, false));
        } else {
            if (i2 % 2 == 0) {
                return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_sent_item_graybg, viewGroup, false));
            }
            return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lifafa_sent_item, viewGroup, false));
        }
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str = this.f71166e.get(i2 % 10);
        int itemViewType = vVar.getItemViewType();
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                if ((vVar instanceof c) && this.f71165d != null) {
                    c cVar = (c) vVar;
                    int i3 = i2 - 2;
                    ReceivedLifafaDetailsResponse.RecipientInfo recipientInfo = this.f71163b.get(i3).getRecipientInfo();
                    cVar.f71176e.setVisibility(0);
                    cVar.f71172a.setVisibility(8);
                    cVar.f71175d.setText(net.one97.paytm.wallet.utility.a.d(recipientInfo.getName()));
                    cVar.f71173b.setText(recipientInfo.getName());
                    RoboTextView roboTextView = cVar.f71174c;
                    roboTextView.setText(this.f71165d.getResources().getString(R.string.rupee_symbol) + Integer.valueOf(this.f71163b.get(i3).getProposedQuantity().intValue()));
                    cVar.f71177f.setBackgroundColor(Color.parseColor(str));
                }
            } else if ((vVar instanceof c) && this.f71165d != null) {
                c cVar2 = (c) vVar;
                cVar2.f71172a.setVisibility(0);
                if (com.paytm.utility.b.al(this.f71165d) != null) {
                    cVar2.f71176e.setVisibility(8);
                    cVar2.f71172a.setVisibility(0);
                    w.a().a(com.paytm.utility.b.al(this.f71165d)).a(R.drawable.ic_launcher).a((ah) new C1443a()).a(cVar2.f71172a, (e) null);
                } else {
                    cVar2.f71172a.setVisibility(8);
                    cVar2.f71176e.setVisibility(0);
                    cVar2.f71175d.setText(net.one97.paytm.wallet.utility.a.d(this.f71165d.getResources().getString(R.string.lifafa_you)));
                    cVar2.f71177f.setBackgroundColor(Color.parseColor(str));
                }
                if (this.f71164c != null) {
                    cVar2.f71173b.setText(this.f71165d.getResources().getString(R.string.lifafa_received));
                    RoboTextView roboTextView2 = cVar2.f71174c;
                    roboTextView2.setText(this.f71165d.getResources().getString(R.string.rupee_symbol) + Integer.valueOf(this.f71164c.getProposedQuantity().intValue()));
                }
                cVar2.f71177f.setBackgroundColor(Color.parseColor(str));
            }
        } else if ((vVar instanceof b) && this.f71165d != null) {
            b bVar = (b) vVar;
            if (this.f71164c != null) {
                RoboTextView roboTextView3 = bVar.f71169a;
                String string = this.f71165d.getResources().getString(R.string.lifafa_claimed);
                roboTextView3.setText(String.format(string, new Object[]{this.f71165d.getResources().getString(R.string.rupee_symbol) + Integer.valueOf(this.f71164c.getProposedQuantity().intValue()), this.f71165d.getResources().getString(R.string.rupee_symbol) + Integer.valueOf(this.f71162a.getLifafaDetail().getProposedQuantity().intValue())}));
            }
            int proposedReceiverCount = (this.f71162a.getLifafaDetail().getProposedReceiverCount() - this.f71163b.size()) - 1;
            if (proposedReceiverCount > 0) {
                bVar.f71170b.setVisibility(0);
                bVar.f71170b.setText(String.format(this.f71165d.getResources().getString(R.string.lifafa_yet_to_claim), new Object[]{String.valueOf(proposedReceiverCount)}));
                return;
            }
            bVar.f71170b.setVisibility(8);
        }
    }

    public class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f71172a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f71173b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f71174c;

        /* renamed from: d  reason: collision with root package name */
        RoboTextView f71175d;

        /* renamed from: e  reason: collision with root package name */
        RelativeLayout f71176e;

        /* renamed from: f  reason: collision with root package name */
        CJRVolleyImageView f71177f;

        public c(View view) {
            super(view);
            this.f71172a = (ImageView) view.findViewById(R.id.imgProfile);
            this.f71173b = (RoboTextView) view.findViewById(R.id.tvName);
            this.f71174c = (RoboTextView) view.findViewById(R.id.tvAmount);
            this.f71175d = (RoboTextView) view.findViewById(R.id.tvImageName);
            this.f71176e = (RelativeLayout) view.findViewById(R.id.imageLayout);
            this.f71177f = (CJRVolleyImageView) view.findViewById(R.id.ivScanId);
        }
    }

    public class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f71169a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f71170b;

        public b(View view) {
            super(view);
            this.f71169a = (RoboTextView) view.findViewById(R.id.tvCliamedAmount);
            this.f71170b = (RoboTextView) view.findViewById(R.id.tvYetToClaimed);
        }
    }

    /* renamed from: net.one97.paytm.wallet.newdesign.postcard.a.a$a  reason: collision with other inner class name */
    public class C1443a implements ah {
        public final String key() {
            return "circle";
        }

        public C1443a() {
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
}
