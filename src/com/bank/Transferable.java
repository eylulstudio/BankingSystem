package com.bank;

public interface Transferable {
    boolean transfer(Account target, double amount);
}
