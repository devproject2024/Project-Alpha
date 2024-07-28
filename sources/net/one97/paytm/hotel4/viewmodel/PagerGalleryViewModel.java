package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.y;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages;
import net.one97.paytm.hotel4.service.model.details.Images;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.RoomTypeSelection;

public final class PagerGalleryViewModel extends BaseViewModel {
    private String currentScreenName = "";
    private y<Integer> pagerGalleryCountIndex = new y<>();
    private y<Integer> pagerGalleryImageIndex = new y<>();
    private List<String> pagerGalleryList = new ArrayList();
    private String pagerGalleryStartImage = "";
    private y<List<HotelRoomTypeImages>> roomTypeImages = new y<>();
    private int roomTypeRecyclerViewIndex;
    private y<List<RoomTypeSelection>> roomTypeSelection = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PagerGalleryViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final String getPagerGalleryStartImage() {
        return this.pagerGalleryStartImage;
    }

    public final void setPagerGalleryStartImage(String str) {
        k.c(str, "<set-?>");
        this.pagerGalleryStartImage = str;
    }

    public final y<Integer> getPagerGalleryImageIndex() {
        return this.pagerGalleryImageIndex;
    }

    public final void setPagerGalleryImageIndex(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.pagerGalleryImageIndex = yVar;
    }

    public final y<Integer> getPagerGalleryCountIndex() {
        return this.pagerGalleryCountIndex;
    }

    public final void setPagerGalleryCountIndex(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.pagerGalleryCountIndex = yVar;
    }

    public final y<List<HotelRoomTypeImages>> getRoomTypeImages() {
        return this.roomTypeImages;
    }

    public final void setRoomTypeImages(y<List<HotelRoomTypeImages>> yVar) {
        k.c(yVar, "<set-?>");
        this.roomTypeImages = yVar;
    }

    public final y<List<RoomTypeSelection>> getRoomTypeSelection() {
        return this.roomTypeSelection;
    }

    public final void setRoomTypeSelection(y<List<RoomTypeSelection>> yVar) {
        k.c(yVar, "<set-?>");
        this.roomTypeSelection = yVar;
    }

    public final int getRoomTypeRecyclerViewIndex() {
        return this.roomTypeRecyclerViewIndex;
    }

    public final void setRoomTypeRecyclerViewIndex(int i2) {
        this.roomTypeRecyclerViewIndex = i2;
    }

    public final List<String> getPagerGalleryList() {
        return this.pagerGalleryList;
    }

    public final void setPagerGalleryList(List<String> list) {
        k.c(list, "<set-?>");
        this.pagerGalleryList = list;
    }

    public final String getCurrentScreenName() {
        return this.currentScreenName;
    }

    public final void setCurrentScreenName(String str) {
        k.c(str, "<set-?>");
        this.currentScreenName = str;
    }

    public final void openGalleryPagerFragment(String str, String str2, int i2) {
        k.c(str, "mScreenName");
        k.c(str2, "mSelectedGalleryImage");
        this.currentScreenName = str;
        this.pagerGalleryStartImage = str2;
        if (i2 != -1) {
            this.roomTypeRecyclerViewIndex = i2;
        }
        List<String> allImagesURL = getAllImagesURL();
        if (allImagesURL != null) {
            int i3 = 1;
            if (allImagesURL.indexOf(this.pagerGalleryStartImage) != -1) {
                i3 = 1 + allImagesURL.indexOf(this.pagerGalleryStartImage);
            }
            this.pagerGalleryImageIndex.postValue(Integer.valueOf(i3));
            this.pagerGalleryCountIndex.postValue(Integer.valueOf(allImagesURL.size()));
            getParent().postScreenNavigationEvent(this.currentScreenName, "0000");
        }
    }

    public final void closeGalleryPagerFragment() {
        getParent().postScreenNavigationEvent("0000", this.currentScreenName);
    }

    public final void setRoomTypeImages(List<HotelRoomTypeImages> list) {
        k.c(list, "images");
        this.roomTypeImages.setValue(list);
    }

    public final void setRoomTypeSelection(List<RoomTypeSelection> list) {
        k.c(list, "images");
        this.roomTypeSelection.setValue(list);
    }

    public final void setAllImagesURL(List<String> list) {
        if (list != null) {
            this.pagerGalleryList = ab.c(list);
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
    }

    public final List<String> getAllImagesURL() {
        String str = this.currentScreenName;
        int hashCode = str.hashCode();
        if (hashCode != 54) {
            if (hashCode == 55 && str.equals("7")) {
                return getListFormRoomTypeSelection();
            }
            return null;
        } else if (str.equals("6")) {
            return getListDefault();
        } else {
            return null;
        }
    }

    private final List<String> getListDefault() {
        return this.pagerGalleryList;
    }

    private final List<String> getListFormRoomTypeSelection() {
        int i2;
        Images images;
        List value = this.roomTypeSelection.getValue();
        List<String> list = null;
        if (value == null || (i2 = this.roomTypeRecyclerViewIndex) < 0 || i2 >= value.size()) {
            return null;
        }
        RoomOption roomOptions = ((RoomTypeSelection) value.get(this.roomTypeRecyclerViewIndex)).getRoomOptions();
        if (!(roomOptions == null || (images = roomOptions.getImages()) == null)) {
            list = images.getFull();
        }
        if (list != null) {
            return ab.c(list);
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.String>");
    }
}
