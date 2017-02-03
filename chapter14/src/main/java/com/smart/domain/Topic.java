package com.smart.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="T_TOPIC")
public class Topic implements Serializable {
	private static final long serialVersionUID = 1L; 
	@Id
	@Column(name = "TOPIC_ID")
	private int topicId;
	
	@Column(name = "USER_ID")
	private int userId;
	
	@Column(name = "TOPIC_TITLE")
	private String topicTitle;
	
	@Column(name = "TOPIC_TIME")
	private Date topicTime;
	
	@ManyToOne
    @JoinColumn(name = "FORUM_ID")
	private Forum forum;
	
	
	@Column(name = "TOPIC_VIEWS")
	private int topicViews;
	
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
	private List<Post> posts;

	@Column(name = "TOPIC_REPLIES")
    private int topicReplies;
	
	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public Date getTopicTime() {
		return topicTime;
	}

	public void setTopicTime(Date topicTime) {
		this.topicTime = topicTime;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public int getTopicViews() {
		return topicViews;
	}

	public void setTopicViews(int topicViews) {
		this.topicViews = topicViews;
	}
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public int getTopicReplies() {
		return topicReplies;
	}

	public void setTopicReplies(int topicReplies) {
		this.topicReplies = topicReplies;
	}
	
	
	

}
