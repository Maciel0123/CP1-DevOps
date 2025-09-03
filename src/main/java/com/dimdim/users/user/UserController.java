package com.dimdim.users.user;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import jakarta.validation.Valid;
import java.util.List;
@RestController @RequestMapping("/api/users")
public class UserController {
  private final UserRepository repository;
  public UserController(UserRepository repository){this.repository=repository;}
  @GetMapping public List<UserResponse> list(){ return repository.findAll().stream().map(UserResponse::from).toList(); }
  @GetMapping("{id}") public UserResponse get(@PathVariable Long id){
    var u=repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    return UserResponse.from(u);
  }
  @PostMapping @ResponseStatus(HttpStatus.CREATED)
  public UserResponse create(@Valid @RequestBody UserRequest req){ var u=new User(req.getName(),req.getAge()); return UserResponse.from(repository.save(u)); }
  @PutMapping("{id}") public UserResponse update(@PathVariable Long id,@Valid @RequestBody UserRequest req){
    var u=repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));
    u.setName(req.getName()); u.setAge(req.getAge()); return UserResponse.from(repository.save(u));
  }
  @DeleteMapping("{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id){ if(!repository.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"); repository.deleteById(id); }
}
