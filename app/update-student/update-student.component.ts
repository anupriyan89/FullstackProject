import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentService } from '../student.service';
import { Student } from '../student';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrl: './update-student.component.css'
})
export class UpdateStudentComponent {

  student: Student = new Student();
  id: number = 0;
  constructor(private studentService: StudentService,
    private router: Router,
    private route: ActivatedRoute){

  }
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.studentService.getStudentById(this.id).subscribe(data=>{
      this.student = data;
    },
    error => console.log(error));
  }
  updateStudent(){
    this.studentService.updateStudent(this.id, this.student).subscribe(data=>{
      this.goToStudentList();
    },
    error => console.log(error));
    
  }

  goToStudentList() {
    this.router.navigate(['/students'])
  }
  onSubmit(){
    console.log(this.student);  
    this.updateStudent();  
  }

}
