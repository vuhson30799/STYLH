package stylh.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment_reply")
public class CommentReply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long replyID;
    private String replyContent;
    private Date replyDate;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "commentID")
    private Comment comment;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public CommentReply() {
    }

    public Long getReplyID() {
        return replyID;
    }

    public void setReplyID(Long replyID) {
        this.replyID = replyID;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }
}
