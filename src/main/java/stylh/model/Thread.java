package stylh.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "thread")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long threadID;
    private int reply;
    private int view;
    private Date postDate;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "topicID")
    private Topic topic;

    @OneToMany(targetEntity = Comment.class)
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Thread() {
    }

    public Long getThreadID() {
        return threadID;
    }

    public void setThreadID(Long threadID) {
        this.threadID = threadID;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
