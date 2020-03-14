package main.project.web.member.vo;

public class MemberVO {
		String id;
		String email;
		String pwd;
		String nick_name;
		String user_yn;
		String rank;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getNick_name() {
			return nick_name;
		}
		public void setNick_name(String nick_name) {
			this.nick_name = nick_name;
		}
		public String getUser_yn() {
			return user_yn;
		}
		public void setUser_yn(String user_yn) {
			this.user_yn = user_yn;
		}
		public String getRank() {
			return rank;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		
		@Override
		public String toString() {
			return "MemberVO [id=" + id + ", email=" + email + ", pwd=" + pwd + ", nick_name=" + nick_name + ", user_yn="
					+ user_yn + ", rank=" + rank + "]";
		}
		
		
		
		
}
