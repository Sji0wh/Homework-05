package org.example;

public class Person {
        private int personAge;
        private String personName;

    public Person(int personAge, String personName) {
        this.personAge = personAge;
        this.personName = personName;
    }
    public void celebrateBirthday(){
        personAge++;
    }
    public void changeName (String newName){
        personName = newName;
    }
    public String getName (){
        return personName;
    }
    public int getAge (){
        return personAge;
    }
}
