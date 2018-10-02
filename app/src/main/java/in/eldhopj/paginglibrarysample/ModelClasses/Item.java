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
     *
     */
    public Item() {
    }

    /**
     *
     * @param creationDate
     * @param questionId
     * @param lastActivityDate
     * @param score
     * @param owner
     * @param answerId
     * @param lastEditDate
     * @param isAccepted
     */
    public Item(Owner owner, Boolean isAccepted, Integer score, Integer lastActivityDate, Integer creationDate, Integer answerId, Integer questionId, Integer lastEditDate) {
        super();
        this.owner = owner;
        this.isAccepted = isAccepted;
        this.score = score;
        this.lastActivityDate = lastActivityDate;
        this.creationDate = creationDate;
        this.answerId = answerId;
        this.questionId = questionId;
        this.lastEditDate = lastEditDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Boolean getIsAccepted() {
        return isAccepted;
    }

    public void setIsAccepted(Boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Integer lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Integer getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Integer creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Integer lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

}
