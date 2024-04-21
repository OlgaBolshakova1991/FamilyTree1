package Person;

import java.io.Serializable;
import java.time.LocalDate;

abstract class Person implements Serializable, Comparable<Person> {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;

    public Person(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        if (dod == null) {
            return getPeriod(dob, LocalDate.now());
        } else {
            return getPeriod(dob, dod);
        }
    }

    private int getPeriod(LocalDate dob, LocalDate dod) {
        return dob.until(dod).getYears();
    }

    @Override
    public String toString() {
        return  "Имя:" + this.name + ", "
                + "Дата рождения:" + this.dob + ", " + "Дата смерти:"
                + this.dod + ", " + "Пол:" + this.gender;

    }

    @Override
    public int compareTo(Person o){
        return name.compareTo(o.name);
    }

}


