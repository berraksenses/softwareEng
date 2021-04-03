package com.mycompany.soapforexam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
public class Director {

 private int directorId;
 private String name;
 private String yearOfBirth;
 
  public static void main(String[] args) {
       
    }
 public void setId(int directorId){
     this.directorId = directorId;
 }
 
 public int getId(){
     return directorId;
 }
  public void setName(String name){
     this.name = name;
 }
  public String getName(String name){
     return name;
 }
 public int getDirectorId(){
     return directorId;
 }
   public void setYearOfBirth(String yearOfBirth){
     this.yearOfBirth = yearOfBirth;
 }
 public String getYearOfBirth(){
     return yearOfBirth;
 }
     
}
  
    
