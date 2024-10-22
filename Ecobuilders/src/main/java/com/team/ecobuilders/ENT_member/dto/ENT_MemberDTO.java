package com.team.ecobuilders.ENT_member.dto;

public class ENT_MemberDTO {
	  
		private String entBr;
		private String entPassword;
		private String entName;
		private String entCeo;
		private String entPhone;
		private String entAddress;
		private String entEmail;
	  
		public ENT_MemberDTO() {
		}

		public ENT_MemberDTO(String entBr, String entPassword, String entName, String entCeo, String entPhone, String entAddress,
				String entEmail) {
			super();
			this.entBr = entBr;
			this.entPassword = entPassword;
			this.entName = entName;
			this.entCeo = entCeo;
			this.entPhone = entPhone;
			this.entAddress = entAddress;
			this.entEmail = entEmail;
			
		}

		public String toString() {
			return "ENT_MemberDTO [entBr=" + entBr + ", entPassword=" + entPassword + ", entName=" + entName + ", entCeo="
					+ entCeo + ", entPhone=" + entPhone + ", entAddress=" + entAddress + ", entEmail=" + entEmail + "]";
		}

		public String getEntBr() {
			return entBr;
		}

		public void setEntBr(String entBr) {
			this.entBr = entBr;
		}

		public String getEntPassword() {
			return entPassword;
		}

		public void setEntPassword(String entPassword) {
			this.entPassword = entPassword;
		}

		public String getEntName() {
			return entName;
		}

		public void setEntName(String entName) {
			this.entName = entName;
		}

		public String getEntCeo() {
			return entCeo;
		}
		
		public void setEntCeo(String entCeo) {
			this.entCeo = entCeo;
		}
		
		public String getEntPhone() {
			return entPhone;
		}

		public void setEntPhone(String entPhone) {
			this.entPhone = entPhone;
		}

		public String getEntAddress() {
			return entAddress;
		}

		public void setEntAddress(String entAddress) {
			this.entAddress = entAddress;
		}

		public String getEntEmail() {
			return entEmail;
		}

		public void setEntEmail(String entEmail) {
			this.entEmail = entEmail;
		}
		

	}
