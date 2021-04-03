package com.mycompany.soapforexam;


import javax.xml.bind.annotation.XmlType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author studente
 */
@XmlType(name = "Movies")
public class Movies {
 private int id;
 private String title;
 private String year;
 private String directorName;
 
  public static void main(String[] args) {
       
    }
 public void setId(int id){
     this.id = id;
 }
 public Movies(int id,String title, String year, String directorName){
     this.id=id;
     this.title = title;
     this.year = year;
     this.directorName = directorName;
 }
 
 public int getId(){
     return id;
 }
  public void setTitle(String title){
     this.title = title;
 }
 public String getDirectorName(){
     return directorName;
 }
public void setDirectorName(String directorName){
     this.directorName = directorName;
 }
   public void setYear(String year){
     this.title = title;
 }
 public String getYear(){
     return year;
 }
 
 
 
    
}


