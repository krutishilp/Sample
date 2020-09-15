class Account{
	
	private double balance;
	
	public void setBalance(double amt){
		balance=amt;
	}
	
	public void depositAmount(double amt){
		balance=balance+amt;
		System.out.println(amt+" deposited in your account....");
	}
	
	public void withdrawAmount(double amt){
		balance=balance-amt;
		System.out.println(amt+" withdrawn in your account....");
	}
	
	public double checkBalance(){
		return balance;
	}
	
}