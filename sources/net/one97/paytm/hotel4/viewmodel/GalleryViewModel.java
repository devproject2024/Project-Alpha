package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.y;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages;
import net.one97.paytm.hotel4.service.model.details.Images;
import net.one97.paytm.hotel4.service.model.details.PaytmImages;
import net.one97.paytm.hotel4.service.model.details.RoomOption;

public final class GalleryViewModel extends BaseViewModel {
    private y<String> _galleryTitle;
    private y<List<RoomOption>> roomOptions = new y<>();
    private y<List<HotelRoomTypeImages>> roomTypeImages = new y<>();
    private y<Integer> selectedImagePos = new y<>();
    private y<Boolean> sharePressed;
    private y<Integer> stateImageIndex;
    private y<Integer> statePageIndex;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GalleryViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
        y<Integer> yVar = new y<>();
        yVar.postValue(0);
        this.statePageIndex = yVar;
        y<Integer> yVar2 = new y<>();
        yVar2.postValue(0);
        this.stateImageIndex = yVar2;
        this.sharePressed = new y<>();
        this._galleryTitle = new y<>();
    }

    public final y<List<RoomOption>> getRoomOptions() {
        return this.roomOptions;
    }

    public final void setRoomOptions(y<List<RoomOption>> yVar) {
        k.c(yVar, "<set-?>");
        this.roomOptions = yVar;
    }

    public final y<List<HotelRoomTypeImages>> getRoomTypeImages() {
        return this.roomTypeImages;
    }

    public final void setRoomTypeImages(y<List<HotelRoomTypeImages>> yVar) {
        k.c(yVar, "<set-?>");
        this.roomTypeImages = yVar;
    }

    public final y<Integer> getSelectedImagePos() {
        return this.selectedImagePos;
    }

    public final void setSelectedImagePos(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.selectedImagePos = yVar;
    }

    public final y<Integer> getStatePageIndex() {
        return this.statePageIndex;
    }

    public final void setStatePageIndex(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.statePageIndex = yVar;
    }

    public final y<Integer> getStateImageIndex() {
        return this.stateImageIndex;
    }

    public final void setStateImageIndex(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.stateImageIndex = yVar;
    }

    public final y<Boolean> getSharePressed() {
        return this.sharePressed;
    }

    public final void setSharePressed(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.sharePressed = yVar;
    }

    public final y<String> get_galleryTitle() {
        return this._galleryTitle;
    }

    public final void set_galleryTitle(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._galleryTitle = yVar;
    }

    public final void setRoomOptions(List<RoomOption> list, PaytmImages paytmImages) {
        k.c(list, "roomOption");
        this.selectedImagePos.postValue(0);
        this.roomOptions = this.roomOptions;
        mapRoomWithImages(list, paytmImages);
    }

    private final void mapRoomWithImages(List<RoomOption> list, PaytmImages paytmImages) {
        String paytmRoomName;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (!(paytmImages == null || paytmImages.getFull() == null)) {
            List<String> full = paytmImages.getFull();
            if (full == null) {
                k.a();
            }
            if (full.size() > 0) {
                List<String> full2 = paytmImages.getFull();
                if (full2 == null) {
                    k.a();
                }
                arrayList2.addAll(full2);
            }
        }
        for (RoomOption roomOption : list) {
            Images images = roomOption.getImages();
            if (images == null) {
                k.a();
            }
            List<String> full3 = images.getFull();
            if (full3 == null) {
                k.a();
            }
            if (!full3.isEmpty() && (paytmRoomName = roomOption.getPaytmRoomName()) != null) {
                Images images2 = roomOption.getImages();
                if (images2 == null) {
                    k.a();
                }
                List<String> full4 = images2.getFull();
                if (full4 != null) {
                    arrayList.add(new HotelRoomTypeImages(paytmRoomName, full4));
                    arrayList2.addAll(full4);
                }
            }
        }
        arrayList.add(0, new HotelRoomTypeImages(AppConstants.FOR_ALL, arrayList2));
        this.roomTypeImages.postValue(arrayList);
    }

    public final void selectedRoomPos(int i2) {
        this.selectedImagePos.postValue(Integer.valueOf(i2));
    }

    public final void onBackPressed() {
        getParent().postScreenNavigationEvent("6", "5");
    }

    public final void onSharePressed() {
        this.sharePressed.postValue(Boolean.TRUE);
    }

    public final void setTitle(String str) {
        k.c(str, "title");
        this._galleryTitle.postValue(str);
    }

    public final void onSelectRoomPressed() {
        this.stateImageIndex.postValue(null);
        getParent().postScreenNavigationEvent("5", "7");
    }

    public final HotelRoomTypeImages getSelectedPosRoomImages(int i2) {
        List<HotelRoomTypeImages> value = this.roomTypeImages.getValue();
        if (value == null) {
            k.a();
        }
        return (HotelRoomTypeImages) value.get(i2);
    }
}
