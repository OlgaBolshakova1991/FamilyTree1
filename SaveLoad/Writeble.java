package SaveLoad;

import java.io.IOException;

import Person.FamilyTree;

public interface Writeble {
    void saveFamilyTreeToFile(String filename, FamilyTree familyTree) throws IOException;
    FamilyTree loadFamilyTreeFromFile(String filename) throws IOException, ClassNotFoundException;
}
