package dev.vang.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="genre")
@Table(name="genre", schema="story_pitch")
public class Genre {
	
	@Id
	@Column(name="genre_id", insertable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer genreId;
	
	@Column(name="genre")
	private String genre;
	
	public Genre() {
		super();
	}
	
	public Integer getGenreId() {
		return genreId;
	}
	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (genreId == null) {
			if (other.genreId != null)
				return false;
		} else if (!genreId.equals(other.genreId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", genre=" + genre + "]";
	}
	
	
}
