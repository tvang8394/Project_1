package dev.vang.models;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="pitch")
@Table(name="pitch", schema="story_pitch")
public class Pitch {
	@Id
	@Column(name="pitch_id", insertable=false, updatable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pitchId;
	
	
	@OneToOne
	@JoinColumn(name="user_id")
	private Users userId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="completion_date")
	private String completionDate;
	
	@OneToOne
	@JoinColumn(name="story_type")
	private Type storyType; // points depend on story type
	
	@ManyToOne
	@JoinColumn(name="genre")
	private Genre genre;
	
	@Column(name="tag_line")
	private String tagLine;
	
	@Column(name="description")
	private String description;
	
//	@Column(name="image_file")
//	private String imgFile;
	
	@Column(name="assistant_approval")
	private boolean assistantApproval;
	
	@Column(name="general_approval")
	private boolean generalApproval;
	
	@Column(name="senior_approval")
	private boolean seniorApproval;

//	public Pitch(Users userId, String title, String completionDate, Type storyType, Genre genre, String tagLine,
//			String description) {
//		super();
//		this.userId = userId;
//		this.title = title;
//		this.completionDate = completionDate;
//		this.storyType = storyType;
//		this.genre = genre;
//		this.tagLine = tagLine;
//		this.description = description;
////		this.imgFile = imgFile;
//	}

	
	public Pitch(Users userId, String title, String completionDate, Type storyType, Genre genre, String tagLine,
			String description) {
		super();
		this.userId = userId;
		this.title = title;
		this.completionDate = completionDate;
		this.storyType = storyType;
		this.genre = genre;
		this.tagLine = tagLine;
		this.description = description;
	}


	public Pitch() {
		super();
	}

	public Pitch(Integer pitchId, Users userId, String title, String completionDate, Type storyType, Genre genre,
			String tagLine, String description, String imgFile, boolean assistantApproval, boolean generalApproval,
			boolean seniorApproval) {
		super();
		this.pitchId = pitchId;
		this.userId = userId;
		this.title = title;
		this.completionDate = completionDate;
		this.storyType = storyType;
		this.genre = genre;
		this.tagLine = tagLine;
		this.description = description;
//		this.imgFile = imgFile;
		this.assistantApproval = assistantApproval;
		this.generalApproval = generalApproval;
		this.seniorApproval = seniorApproval;
	}
	
	

	public Integer getPitchId() {
		return pitchId;
	}

	public void setPitchId(Integer pitchId) {
		this.pitchId = pitchId;
	}

	public Users getUserId() {
		return userId;
	}

	public void setUserId(Users userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}

	public Type getStoryType() {
		return storyType;
	}

	public void setStoryType(Type storyType) {
		this.storyType = storyType;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public String getImgFile() {
//		return imgFile;
//	}
//
//	public void setImgFile(String imgFile) {
//		this.imgFile = imgFile;
//	}

	public boolean isAssistantApproval() {
		return assistantApproval;
	}

	public void setAssistantApproval(boolean assistantApproval) {
		this.assistantApproval = assistantApproval;
	}

	public boolean isGeneralApproval() {
		return generalApproval;
	}

	public void setGeneralApproval(boolean generalApproval) {
		this.generalApproval = generalApproval;
	}

	public boolean isSeniorApproval() {
		return seniorApproval;
	}

	public void setSeniorApproval(boolean seniorApproval) {
		this.seniorApproval = seniorApproval;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (assistantApproval ? 1231 : 1237);
		result = prime * result + ((completionDate == null) ? 0 : completionDate.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (generalApproval ? 1231 : 1237);
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((pitchId == null) ? 0 : pitchId.hashCode());
		result = prime * result + (seniorApproval ? 1231 : 1237);
		result = prime * result + ((storyType == null) ? 0 : storyType.hashCode());
		result = prime * result + ((tagLine == null) ? 0 : tagLine.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		Pitch other = (Pitch) obj;
		if (assistantApproval != other.assistantApproval)
			return false;
		if (completionDate == null) {
			if (other.completionDate != null)
				return false;
		} else if (!completionDate.equals(other.completionDate))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (generalApproval != other.generalApproval)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (pitchId == null) {
			if (other.pitchId != null)
				return false;
		} else if (!pitchId.equals(other.pitchId))
			return false;
		if (seniorApproval != other.seniorApproval)
			return false;
		if (storyType == null) {
			if (other.storyType != null)
				return false;
		} else if (!storyType.equals(other.storyType))
			return false;
		if (tagLine == null) {
			if (other.tagLine != null)
				return false;
		} else if (!tagLine.equals(other.tagLine))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pitch [pitchId=" + pitchId + ", userId=" + userId + ", title=" + title + ", completionDate="
				+ completionDate + ", storyType=" + storyType + ", genre=" + genre + ", tagLine=" + tagLine
				+ ", description=" + description + ", assistantApproval=" + assistantApproval + ", generalApproval="
				+ generalApproval + ", seniorApproval=" + seniorApproval + "]";
	}
	
	
}
