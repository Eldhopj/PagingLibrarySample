package in.eldhopj.paginglibrarysample.ModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Owner {

    @SerializedName("reputation")
    @Expose
    private Integer reputation;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("accept_rate")
    @Expose
    private Integer acceptRate;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("display_name")
    @Expose
    private String displayName;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     * No args constructor for use in serialization
     *
     */
    public Owner() {
    }

    public Integer getReputation() {
        return reputation;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    public Integer getAcceptRate() {
        return acceptRate;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLink() {
        return link;
    }
}
