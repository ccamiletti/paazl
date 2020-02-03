import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Question } from '../objects/question';
import { Score } from '../objects/score';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  constructor(private httpClient: HttpClient) { }

  getQuestions(): Observable<Question[]> {
    return this.httpClient.get<Question[]>("services/questions");
  }

  checkAnswers(arrQuestion : Question[]): Observable<Score> {
    return this.httpClient.post<Score>('services/questions/checkAnswers', arrQuestion);
  }


}
