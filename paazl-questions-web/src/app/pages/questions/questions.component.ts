import { Component, OnInit } from '@angular/core';
import { QuestionService } from 'src/app/services/question-service';
import { Question, AnswerEnum } from 'src/app/objects/question';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {

  constructor(private questionSerivce: QuestionService) { }
  public message: string
  questions: Question[];
  public answerEnum = AnswerEnum;
  public keys = Object.keys;
  public displayedColumns: string[] = ['id', 'question', 'answer'];

  ngOnInit() {
    this.questionSerivce.getQuestions().subscribe(questions => {
      this.questions = questions;
    }, error => {

    });
  }

  checkAnswers() {
    this.questionSerivce.checkAnswers(this.questions).subscribe(response => {
      this.message = 'You got ' + response.score + ' corrects answers. You are a: ' + response.description;
    },error => {
      this.message = 'So sorry, There was a problem getting your Score';
    });
    
  }

}
