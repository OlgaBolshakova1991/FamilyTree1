package Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index;
    private List<Person> familyMembers;

    public PersonIterator(List<Person> familyMembers) {
        this.familyMembers = familyMembers;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public Person next() {
        return familyMembers.get(index++);
    }
}
