package stylh.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long topicID;
    private String topicName;
    private int threadCount;
    private long commentCount;

    @OneToMany(targetEntity = Thread.class)
    private List<Thread> threads;

    public List<Thread> getThreads() {
        return threads;
    }

    public void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    public Topic() {
    }

    public Long getTopicID() {
        return topicID;
    }

    public void setTopicID(Long topicID) {
        this.topicID = topicID;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }
}
