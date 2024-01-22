import java.time.LocalDate;
import java.time.Period;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public Integer getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
