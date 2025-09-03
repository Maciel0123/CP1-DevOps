package com.dimdim.users.user;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity @Table(name="users")
public class User {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @NotBlank @Size(min=2,max=100) @Column(nullable=false,length=100) private String name;
  @NotNull @Min(0) @Max(130) @Column(nullable=false) private Integer age;
  public User(){} public User(String name,Integer age){this.name=name;this.age=age;}
  public Long getId(){return id;} public void setId(Long id){this.id=id;}
  public String getName(){return name;} public void setName(String name){this.name=name;}
  public Integer getAge(){return age;} public void setAge(Integer age){this.age=age;}
}
