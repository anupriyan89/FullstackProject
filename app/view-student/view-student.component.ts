import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-view-student',
  templateUrl: './view-student.component.html',
  styleUrl: './view-student.component.css'
})
export class ViewStudentComponent {
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

  goToStudentList() {
    this.router.navigate(['/students'])
  }

}
