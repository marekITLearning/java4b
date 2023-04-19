package sk.itlearning.java4.jpa;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rating", schema = "public")
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String tconst;
	private Float averagerating;
	private Integer numvotes;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "tconst", referencedColumnName = "tconst", insertable=false, updatable=false)	
	private Title title;

	public String getTconst() {
		return tconst;
	}

	public void setTconst(String tconst) {
		this.tconst = tconst;
	}

	public Float getAveragerating() {
		return averagerating;
	}

	public void setAveragerating(Float averagerating) {
		this.averagerating = averagerating;
	}

	public Integer getNumvotes() {
		return numvotes;
	}

	public void setNumvotes(Integer numvotes) {
		this.numvotes = numvotes;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}