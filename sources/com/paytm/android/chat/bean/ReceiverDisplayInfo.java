package com.paytm.android.chat.bean;

import com.sendbird.android.Member;
import kotlin.g.b.k;

public final class ReceiverDisplayInfo {
    private String address;
    private String businessName;
    private ChatType chatType = ChatType.P2P;
    private boolean isBusinessNameAvailable;
    private boolean isFromContact;
    private String locationString;
    private String name = "";
    private String paytmChannelId;
    private String phoneNumber;
    private String profileImage = "";
    private Member receiver;
    private RegistrationStatus registrationStatus;
    private String source;
    private UserType userType = UserType.CUSTOMER;

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getBusinessName() {
        return this.businessName;
    }

    public final void setBusinessName(String str) {
        this.businessName = str;
    }

    public final String getProfileImage() {
        return this.profileImage;
    }

    public final void setProfileImage(String str) {
        this.profileImage = str;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String str) {
        this.phoneNumber = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final String getLocationString() {
        return this.locationString;
    }

    public final void setLocationString(String str) {
        this.locationString = str;
    }

    public final boolean isFromContact() {
        return this.isFromContact;
    }

    public final void setFromContact(boolean z) {
        this.isFromContact = z;
    }

    public final boolean isBusinessNameAvailable() {
        return this.isBusinessNameAvailable;
    }

    public final void setBusinessNameAvailable(boolean z) {
        this.isBusinessNameAvailable = z;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final ChatType getChatType() {
        return this.chatType;
    }

    public final void setChatType(ChatType chatType2) {
        k.c(chatType2, "<set-?>");
        this.chatType = chatType2;
    }

    public final UserType getUserType() {
        return this.userType;
    }

    public final void setUserType(UserType userType2) {
        k.c(userType2, "<set-?>");
        this.userType = userType2;
    }

    public final Member getReceiver() {
        return this.receiver;
    }

    public final void setReceiver(Member member) {
        this.receiver = member;
    }

    public final String getPaytmChannelId() {
        return this.paytmChannelId;
    }

    public final void setPaytmChannelId(String str) {
        this.paytmChannelId = str;
    }

    public final RegistrationStatus getRegistrationStatus() {
        return this.registrationStatus;
    }

    public final void setRegistrationStatus(RegistrationStatus registrationStatus2) {
        this.registrationStatus = registrationStatus2;
    }
}
