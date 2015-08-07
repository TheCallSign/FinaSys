/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.finasyscontent;

/**
 *
 * @author Cawl
 */
public class Instruction {
    String ins;
    String[] args;

    public Instruction(String ins, String[] args) {
        this.ins = ins;
        this.args = args;
    }

    public String getIns() {
        return ins;
    }

    public void setIns(String ins) {
        this.ins = ins;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}
