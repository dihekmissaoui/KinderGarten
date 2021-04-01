package tn.esprit.spring.control;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.IUser;

@RestController
//@CrossOrigin(origins = "*")
@RequestMapping("/api/User")
public class UserController {
	@Autowired
	IUser UserService;
	
	@GetMapping("/")
	public List<User> getAllUser() {
		return this.UserService.getAll();
	}
	
	@GetMapping("/{IdUser}")
	@ResponseBody
	public Optional<User> getUserById(@PathVariable("IdUser") int IdUser) {
		return this.UserService.getById(IdUser);
	}

	@GetMapping("/Director/")
	@ResponseBody
	public List <Map<User,Object>> getDirector() {
		return this.UserService.getDirector();
	}
	
	@GetMapping("/DirectorById/{keyword}")
	@ResponseBody
	public List<Map<User, Object>> getDirectorbyId(@PathVariable("keyword") int keyword) {
		return this.UserService.getDirectorbyId(keyword);
	}
	
	@GetMapping("/DirectorByIdE/{keyword}")
	@ResponseBody
	public List<Map<User, Object>> getDirectorbyIdE(@PathVariable("keyword") int keyword) {
		return this.UserService.getDirectorByIdE(keyword);
	}


	@PostMapping("/")
	@ResponseBody 
	public User AddUser (@RequestBody User User) {
		User user = UserService.save(User);
		return user;
	}


	@DeleteMapping("/{IdUser}")
	@ResponseBody
	public void RemoveUser(@PathVariable("User") int IdUser) {
		UserService.remove(IdUser);
	}
}
