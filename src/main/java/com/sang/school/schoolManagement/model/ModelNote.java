package com.sang.school.schoolManagement.model;

import java.sql.Date;

public class ModelNote {
	
	    private long id ;
		private Long typeNoteId;
		private Long CoursId;
		private Date dateNote;
		private String heureDebut; 
		private String heureFin;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public Long getTypeNoteId() {
			return typeNoteId;
		}
		public void setTypeNoteId(Long typeNoteId) {
			this.typeNoteId = typeNoteId;
		}
		public Long getCoursId() {
			return CoursId;
		}
		public void setCoursId(Long coursId) {
			CoursId = coursId;
		}
		public Date getDateNote() {
			return dateNote;
		}
		public void setDateNote(Date dateNote) {
			this.dateNote = dateNote;
		}
		public String getHeureDebut() {
			return heureDebut;
		}
		public void setHeureDebut(String heureDebut) {
			this.heureDebut = heureDebut;
		}
		public String getHeureFin() {
			return heureFin;
		}
		public void setHeureFin(String heureFin) {
			this.heureFin = heureFin;
		}
		

		
}
