package com.blog.example.CreatePDF.dto;

public class Header {
    private String jobTitle;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String postal;
    private String phone;
    private String email;
    private Avatar avatar;

 public String getJobTitle() {
  return jobTitle;
 }

 public void setJobTitle(String jobTitle) {
  this.jobTitle = jobTitle;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }

 public String getCountry() {
  return country;
 }

 public void setCountry(String country) {
  this.country = country;
 }

 public String getCity() {
  return city;
 }

 public void setCity(String city) {
  this.city = city;
 }

 public String getPostal() {
  return postal;
 }

 public void setPostal(String postal) {
  this.postal = postal;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public Avatar getAvatar() {
  return avatar;
 }

 public void setAvatar(Avatar avatar) {
  this.avatar = avatar;
 }


 @Override
 public String toString() {
  return "Header{" +
          "jobTitle='" + jobTitle + '\'' +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", country='" + country + '\'' +
          ", city='" + city + '\'' +
          ", postal='" + postal + '\'' +
          ", phone='" + phone + '\'' +
          ", email='" + email + '\'' +
          ", avatar='" + avatar + '\'' +
          '}';
 }
}


