public class AccountTest{
	
	public static void main(String[] args){
		Account acc=new Account();
		
		acc.setBalance(5000.00);
		System.out.println("Balance: "+acc.checkBalance());
		acc.depositAmount(1000.00);
		System.out.println("Balance: "+acc.checkBalance());
		acc.withdrawAmount(2000.00);
		System.out.println("Balance: "+acc.checkBalance());
	}
}