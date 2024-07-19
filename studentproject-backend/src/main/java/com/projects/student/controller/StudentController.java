package com.projects.student.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.projects.student.exception.ResourceNotFoundException;
import com.projects.student.model.Card;
import com.projects.student.model.Member;
import com.projects.student.model.Student;
import com.projects.student.repository.CardRepo;
import com.projects.student.repository.MemberRepo;
import com.projects.student.repository.StudentRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CardRepo cardRepo;
	
	@Autowired
	MemberRepo memberRepo;
	
	
	
	@GetMapping("/members/{id}/{password}")
	public ResponseEntity<Boolean> getMemberById(@PathVariable Long id, @PathVariable String password) {
		
		//boolean result = memberService.checkMember(id, password);
		
		boolean result= false;
		Optional<Member> member = memberRepo.findById(id);
		if(!member.isEmpty() && password.equalsIgnoreCase(member.get().getMemberPass())) {
			result=true;
		}
				
		return ResponseEntity.ok(result);
		
	}
	
	@GetMapping( "/members")
	public List<Member> getMembers() {
		return memberRepo.findAll();
		
	}
	
	@GetMapping( "/cards")
	public List<Card> getCards() {
		return cardRepo.findAll();
		
	}
	
	@GetMapping( "/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
		
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		if(student.getFirstName()==null || "".equals(student.getFirstName())) {
			throw new ResourceNotFoundException("First Name is required");
		} else if(student.getLastName()==null || "".equals(student.getLastName())) {
			throw new ResourceNotFoundException("Last Name is required");
		}
		return studentRepository.save(student);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
		Student student =  studentRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Student Not found"));
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
		Student student =  studentRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Student Not found"));
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		Student updatedStudent = studentRepository.save(student);
		return ResponseEntity.ok(updatedStudent);
		
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String, Boolean>>deleteStudent(@PathVariable Long id) {
		Student student =  studentRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Student Not found"));
		studentRepository.delete(student);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}

}
