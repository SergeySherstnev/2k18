package com.tsystems;

import com.tsystems.components.InjectRandomInt;

public class TerminatorQuoter implements Quoter {
    @InjectRandomInt(min = 1,max = 3)
    private  int repeat;
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void sayQuote() {
        for (int i=0; i<repeat; i++)
            System.out.println("message = " + message);
    }
}
