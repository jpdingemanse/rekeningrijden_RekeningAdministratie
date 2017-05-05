import { Component} from '@angular/core'
import { LoginService } from "app/global/login.Service";
import { UserService } from "app/rest/user.Service";

@Component({
    selector : 'home-page',
    templateUrl : './home.html',
    styleUrls: ['./../app.component.css']
})
export class HomePageComponent {
    constructor(private loginService : LoginService, private userService : UserService){
        console.log("Hello")
        console.log(loginService.loginUser)
    }
    
     
}