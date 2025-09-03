package com.dimdim.users.user;
import jakarta.validation.constraints.*;
public class UserRequest {
  @NotBlank @Size(min=2,max=100) private String name;
  @NotNull @Min(0) @Max(130) private Integer age;
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public Integer getAge(){return age;} public void setAge(Integer age){this.age=age;}
}
