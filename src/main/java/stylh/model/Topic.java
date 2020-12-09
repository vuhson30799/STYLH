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
    private int threadNumber;
    private long commentNumber;
    private MainTopic mainTopic;


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

    public MainTopic getMainTopic() {
        return mainTopic;
    }

    public void setMainTopic(MainTopic mainTopic) {
        this.mainTopic = mainTopic;
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

    public int getThreadNumber() {
        return threadNumber;
    }

    public void setThreadNumber(int threadCount) {
        this.threadNumber = threadCount;
    }

    public long getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(long commentCount) {
        this.commentNumber = commentCount;
    }
}
