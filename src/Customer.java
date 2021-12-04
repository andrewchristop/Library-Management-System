
public class Customer extends User implements AccountHolder{
	String acctInfo;
	public String showInfo() {
		acctInfo = "Customer";
		return acctInfo;
	}
}
