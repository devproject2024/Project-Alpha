package net.one97.paytm.hotels2.fragment;

import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.g.b.k;

final class HotelHomeFragment$onCreateView$3 implements AppBarLayout.b {
    final /* synthetic */ CardView $cardView2;
    final /* synthetic */ double $diffOffset;
    final /* synthetic */ View $h4HeroTextview;
    final /* synthetic */ ImageView $hotelSearchImage;
    final /* synthetic */ float $offset;
    final /* synthetic */ double $triggeredheight;

    HotelHomeFragment$onCreateView$3(double d2, float f2, double d3, CardView cardView, ImageView imageView, View view) {
        this.$triggeredheight = d2;
        this.$offset = f2;
        this.$diffOffset = d3;
        this.$cardView2 = cardView;
        this.$hotelSearchImage = imageView;
        this.$h4HeroTextview = view;
    }

    public final void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
        double abs = (double) Math.abs(i2);
        double d2 = this.$triggeredheight;
        if (abs > d2) {
            double d3 = (abs - d2) + ((double) this.$offset);
            double abs2 = Math.abs(d3 - this.$diffOffset);
            double d4 = this.$diffOffset;
            double d5 = abs2 / d4;
            if (d3 - d4 >= 0.0d) {
                d5 = 0.0d;
            }
            float f2 = (float) d5;
            CardView cardView = this.$cardView2;
            k.a((Object) cardView, "cardView2");
            cardView.setAlpha(f2);
            ImageView imageView = this.$hotelSearchImage;
            k.a((Object) imageView, "hotelSearchImage");
            imageView.setAlpha(1.0f - f2);
            if (Double.valueOf(d5).equals(Double.valueOf(0.0d))) {
                CardView cardView2 = this.$cardView2;
                k.a((Object) cardView2, "cardView2");
                cardView2.setVisibility(8);
                this.$h4HeroTextview.setVisibility(8);
                return;
            }
            return;
        }
        CardView cardView3 = this.$cardView2;
        k.a((Object) cardView3, "cardView2");
        cardView3.setAlpha(1.0f);
        ImageView imageView2 = this.$hotelSearchImage;
        k.a((Object) imageView2, "hotelSearchImage");
        imageView2.setAlpha(0.0f);
        CardView cardView4 = this.$cardView2;
        k.a((Object) cardView4, "cardView2");
        cardView4.setVisibility(0);
        this.$h4HeroTextview.setVisibility(0);
    }
}
