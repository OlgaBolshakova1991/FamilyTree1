package SaveLoad;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Person.FamilyTree;

public class FileHandler implements Writeble{

    @Override
    public void saveFamilyTreeToFile(String filename, FamilyTree familyTree) throws IOException {
        try (ObjectOutputStream objectOut = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOut.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree loadFamilyTreeFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(filename))) {
            return (FamilyTree) objectIn.readObject();
        }
    }
}

