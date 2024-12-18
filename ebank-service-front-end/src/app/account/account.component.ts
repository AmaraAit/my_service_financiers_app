import { Component } from '@angular/core';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrl: './account.component.css'
})
export class AccountComponent implements OnInit{
account : any ;
constructor(private accoutservice:AccountserviceService){}
  ngOnInit(): void {
    this.fetchAccounts();
    console.log(this.account);
  }
  fetchAccounts():void {
    this.accoutservice.getAccountById(3).subscribe(data => (this.account = data));
  }


}
