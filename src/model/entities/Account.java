package model.entities;

import model.Exceptions.BusinessException;

public class Account {
	private Integer number;
	private String holder;
	private Double balance;
	private Double withDrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithDrawLimit() {
		return withDrawLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw (Double amount) {
		validaWithDraw(amount);
		balance -= amount;
	}
	
	private void validaWithDraw (double amount) {
		if (amount > getWithDrawLimit()) {
			throw new BusinessException("Drawing Error: The withdraw exced the limit");
		} 
		if (amount > getBalance()) {
			throw new BusinessException("Drawing Erro: Insufficient balance");
		}
	}
	
	@Override
	public String toString() {
		return "number: " + number
				+ ", holder: " + holder
				+ ", balance: " + getBalance();
	}

	
	
	
	
	

}
