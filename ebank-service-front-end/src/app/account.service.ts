import{Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AccountService {
private baseUrl='http://localhost:8888/ACCOUNT-SERVICE/accounts'
constructor(private http: HttpClient) { }

  getAccountById(id:number):Observable<Object>{
    return this.http.get(`${this.baseUrl}/${id}`);
  }
}
