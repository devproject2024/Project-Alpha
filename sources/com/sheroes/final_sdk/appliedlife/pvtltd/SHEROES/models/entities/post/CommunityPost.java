package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.models.entities.post;

import java.util.ArrayList;
import java.util.List;
import org.parceler.Parcel;

@Parcel
public class CommunityPost extends Post {
    public static final String COMMUNITY_POST_OBJ = "COMMUNITY_POST_OBJ";
    public String challengeHashTag;
    public int challengeId;
    public String challengeType;
    public Community community;
    public int createPostRequestFrom;
    public boolean isAnonymous;
    public boolean isChallengeType;
    public boolean isCompanyAdmin;
    public boolean isEdit;
    public boolean isMyPost;
    public boolean isPostByCommunity;
    public List<Community> myCommunitiesList = new ArrayList();
    public ArrayList<Photo> photos = new ArrayList<>();
}
