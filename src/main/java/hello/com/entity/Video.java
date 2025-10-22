package hello.com.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "Videos")
@NamedQuery(name = "Videos.findAll", query = "SELECT v FROM Video v")
public class Video implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "videoid", length = 50)
	private String videoid;

	@Column(columnDefinition = "NVARCHAR(1000)")
	private String title;

	@Column(columnDefinition = "NVARCHAR(1000)")
	private String description;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String poster;

	private Boolean active;

	private Integer views;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Categories category;

	public Video() {
		super();
	}

	public Video(String videoid, String title, String description, String poster, Boolean active, Integer views,
			Categories category) {
		super();
		this.videoid = videoid;
		this.title = title;
		this.description = description;
		this.poster = poster;
		this.active = active;
		this.views = views;
		this.category = category;
	}

	public String getVideoid() {
		return videoid;
	}

	public void setVideoid(String videoid) {
		this.videoid = videoid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getViews() {
		return views;
	}

	public void setViews(Integer views) {
		this.views = views;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}
}
