/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Hi
 */
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    private String maSV;
    private String hovaten;
    private String IP;
    private int group;

    public Student(String maSV, String hovaten, int group) {
        this.maSV = maSV;
        this.hovaten = hovaten;
        this.group = group;
    }

    public Student() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public String getMaSV() {
        return maSV;
    }

    public String getHovaten() {
        return hovaten;
    }

    public String getIP() {
        return IP;
    }

    public int getGroup() {
        return group;
    }
    
    @Override
    public String toString(){
        return this.getMaSV() + " " + this.getHovaten() + " " + this.getGroup();
    }
         
}
