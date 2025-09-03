package com.dimdim.users.user;
public class UserResponse {
  private Long id; private String name; private Integer age;
  public UserResponse(){} public UserResponse(Long id,String name,Integer age){this.id=id;this.name=name;this.age=age;}
  public static UserResponse from(User u){return new UserResponse(u.getId(),u.getName(),u.getAge());}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public Integer getAge(){return age;} public void setAge(Integer age){this.age=age;}
}
