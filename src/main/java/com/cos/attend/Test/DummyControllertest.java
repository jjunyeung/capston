package com.cos.attend.Test;

import java.util.List;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.attend.model.RoleType;
import com.cos.attend.model.User;
import com.cos.attend.repository.UserRepository;

@RestController
public class DummyControllertest {

	@Autowired
	private UserRepository userRepository;
	
	// // delete
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다. 해당 id는 존재하지 않습니다.";
			// TODO: handle exception
		}
		
		
		return "id 가 삭제 되었습니다. id : "+id;
	}
	
	
	// // update
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
		System.out.println("id : "+ id);
		System.out.println("pw : "+ requestUser.getPassword());
		System.out.println("email : "+ requestUser.getEmail());
		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패하였습니다.");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());

		// userRepository.save(user);
		return user;
	}
	
	
	
	// // select all
	@GetMapping("/dummy/users")
	public List<User> list(){
		return userRepository.findAll(); 	
	}
	
	// // select page
	//사이즈 숫자에 따라서 한페이지에서 볼수있는 개수 바꿀 수 있음
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users= pagingUser.getContent();
		return users;
		
	}
	
	// // select
	@GetMapping("/dummy/user/{id}")
	public User datail(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 유저는 없습니다. id : "+id);
			}
		});
		return user;
	}
	
	
	// // insert
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id : "+user.getId());
		System.out.println("username : "+user.getUsername());
		System.out.println("password : "+user.getPassword());
		System.out.println("email : "+user.getEmail());
		System.out.println("role : "+user.getRole());
		System.out.println("createDate : "+user.getCreateDate() );
		
		user.setRole(RoleType.USER);

		userRepository.save(user);
		return "회원 가입 완료!!";
	}
}
