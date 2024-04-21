package Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Iterator;


public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public void setPersonList(List<Person> familyMembers) {
        this.familyMembers = familyMembers;
    }


        // Метод для сортировки списка людей по имени
    public void sortByName() {
        Collections.sort(familyMembers, Comparator.comparing(Person::getName));
    }

    // Метод для сортировки списка людей по дате рождения
    public void sortByBirthDate() {
        Collections.sort(familyMembers, Comparator.comparing(Person::getDob));
    }

    public void addFamilyMember(Person person) {
        familyMembers.add(person);
    }

    public Person findFamilyMemberByName(String name) {
        for (Person person : familyMembers) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }
    
    public List<Person> getFamilyMembers() {
        return familyMembers;
    }

    public void printFamilyMembers() {
        for (Person person : familyMembers) {
        System.out.println(person.toString());
        }
    }  
    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(familyMembers);
    }      

}
