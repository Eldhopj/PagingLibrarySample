package in.eldhopj.paginglibrarysample.ModelClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("owner")
    @Expose
    private Owner owner;
    @SerializedName("is_accepted")
    @Expose
    private Boolean isAccepted;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("last_activity_date")
    @Expose
    private Integer lastActivityDate;
    @SerializedName("creation_date")
    @Expose
    private Integer creationDate;
    @SerializedName("answer_id")
    @Expose
    private Integer answerId;
    @SerializedName("question_id")
    @Expose
    private Integer questionId;
    @SerializedName("last_edit_date")
    @Expose
    private Integer lastEditDate;

    /**
     * No args constructor for use in serialization
     */
    public Item() {
    }

    public Owner getOwner() {
        return owner;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public Integer getLastEditDate() {
        return lastEditDate;
    }
}