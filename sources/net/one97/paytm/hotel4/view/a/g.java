package net.one97.paytm.hotel4.view.a;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.m;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages;
import net.one97.paytm.hotel4.view.ui.a.l;
import net.one97.paytm.hotel4.viewmodel.GalleryViewModel;

public final class g extends m {

    /* renamed from: a  reason: collision with root package name */
    private final List<HotelRoomTypeImages> f28684a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f28685b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(j jVar, GalleryViewModel galleryViewModel) {
        super(jVar, 1);
        k.c(jVar, "fm");
        k.c(galleryViewModel, "galleryViewModel");
        this.f28684a = galleryViewModel.getRoomTypeImages().getValue();
        List<HotelRoomTypeImages> list = this.f28684a;
        this.f28685b = list != null ? Integer.valueOf(list.size()) : null;
    }

    public final int getCount() {
        Integer num = this.f28685b;
        if (num == null) {
            k.a();
        }
        return num.intValue();
    }

    public final CharSequence getPageTitle(int i2) {
        List<HotelRoomTypeImages> list = this.f28684a;
        if (list == null) {
            k.a();
        }
        return list.get(i2).getRoomTypeName();
    }

    public final Fragment getItem(int i2) {
        l lVar = new l();
        Bundle bundle = new Bundle();
        bundle.putInt(CLPConstants.ARGUMENT_KEY_POSITION, i2);
        lVar.setArguments(bundle);
        return lVar;
    }
}
