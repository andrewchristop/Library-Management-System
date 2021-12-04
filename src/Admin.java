
public class Admin extends User implements AccountHolder {
	String acctStatus;
	public String showInfo() {
		acctStatus = "Administrator";
		return acctStatus;
	}
}
