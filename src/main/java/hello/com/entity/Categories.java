package hello.com.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "Categories")
@NamedQuery(name = "Categories.findAll", query = "SELECT c FROM Categories c")
public class Categories implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String name;

	private int status;

	@Column(columnDefinition = "NVARCHAR(1000)")
	private String images;

	@OneToMany(mappedBy = "category")
	private List<Video> videos;

	public Categories() {
		super();
	}

	public Categories(int id, String name, int status, String images) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.images = images;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
}
