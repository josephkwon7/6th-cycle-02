package net.slipp.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) //this is required to avoid serializaiton related error.
public class Question {
	@Id
	//strategy added to address org.h2.jdbc.JdbcSQLException: Unique index or primary key violation: "PRIMARY KEY ON PUBLIC.QUESTION(ID)";
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	private Long id;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_question_writer"))
	@JsonProperty
	private User writer;
	
	@JsonProperty
	private String title;
	
	@Lob
	@JsonProperty
	private String content;
	
	private LocalDateTime createDate;
	
	@OneToMany(mappedBy = "question")
	@OrderBy("id ASC")
	private List<Answer> answers;
	
	public Question() {} //JPA requires this default constructor

	public Question(User writer, String title, String content) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createDate = LocalDateTime.now();
	}
	
	//this method is NOT necessary spring-boot 2.x handles it's format automatically
	public String getFormattedCreateDate() {
		if (createDate == null) {
			return "";
		}
		return createDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
	}

	public void update(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public boolean isSameWriter(User loginUser) {
		return this.writer.equals(loginUser);
	}

	public Long getId() {
		return id;
	}

	public User getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", writer=" + writer + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", answers=" + answers + "]";
	}
	
}
