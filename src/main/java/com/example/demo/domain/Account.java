package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *  @program: test-demo
 *  @className: TestUser
 *  @Description:
 *  @author: Mr.Cui
 *  @Date: 2021/3/25 9:53
 */
@Data
@NoArgsConstructor
public class Account {

    String name;
    float amount;

    public Account(String name, float amount) {
        this.name = name;
        this.amount = amount;
    }

    // 存钱
    public void deposit(float amt) {
        amount += amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 取钱
    public void withdraw(float amt) {
        amount -= amt;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public float getBalance() {
        return amount;
    }
}
