package Consumer;

import java.time.LocalDate;
import java.time.Period;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class Consumer {
    private String lastName;
    private String firstName;
    private String fathersName;
    private LocalDate birthday;
    private String number;

    @Override
    public String toString() {
        return "Consumer{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", birthday=" + birthday +
                ", age=" + getAge().toString() +
                ", number='" + number + '\'' +
                '}';
    }

    public Consumer(String lastName, String firstName, String fathersName, String birthday, String number) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fathersName = fathersName;
        this.birthday = LocalDate.parse(birthday);;
        this.number = number;
    }

    public Integer getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

}
