/**
  * Created by a.shipulin on 07.07.16.
  */
class BankAccount {
  private var _balance : Double = 0
  def balance = _balance
  def deposit(money: Double)  {_balance += money }
  def withdraw(money : Double) = if(money < _balance) _balance -= money

}
