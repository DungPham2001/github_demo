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
public class Answer implements Serializable{
    private static final long serialVersionUID = 2L;
    Student student;

    public Answer(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Answer{" + "student=" + student + '}';
    }
    
}
