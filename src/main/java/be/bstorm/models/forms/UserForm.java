package be.bstorm.models.forms;

import be.bstorm.models.entities.User;

public record UserForm(String firstname, String lastname,String email) {

    public User toEntity(){
        return new User(this.firstname,this.lastname,this.email);
    }
}
