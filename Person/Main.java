package Person;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import SaveLoad.FileHandler;

public class Main {
    public static void main(String[] args) {

        FamilyTree familyTree = new FamilyTree();

        // Создаем объекты ребенка, родителей и семейного дерева
        Child child = new Child("Иван", LocalDate.of(2005, 3, 15), null, Gender.MALE);
        Parent father = new Parent("Петр", LocalDate.of(1975, 8, 20), null, Gender.MALE);
        Parent mother = new Parent("Анна", LocalDate.of(1980, 10, 10), null, Gender.FEMALE);
        Parent granny = new Parent("Елизавета", LocalDate.of(1952, 11, 10), LocalDate.of(2020, 4,4), Gender.FEMALE);
        Parent grandpa = new Parent("Игорь", LocalDate.of(1947, 8, 28), LocalDate.of(2020, 1,11), Gender.MALE);


        // Добавляем ребенка и родителей в семейное дерево
        familyTree.addFamilyMember(child);
        familyTree.addFamilyMember(father);
        familyTree.addFamilyMember(mother);
        familyTree.addFamilyMember(granny);
        familyTree.addFamilyMember(grandpa);

        Iterator<Person> i = familyTree.iterator();
        System.out.println("Члены семьи: ");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println();

        familyTree.sortByName();
        System.out.println("\nЧлены семьи после сортировки по имени:");
        familyTree.printFamilyMembers();

        familyTree.sortByBirthDate();
        System.out.println("\nЧлены семьи после сортировки по дате рождения:");
        familyTree.printFamilyMembers();
        System.out.println();


        Person foundPerson = familyTree.findFamilyMemberByName("");
        if (foundPerson != null) {
            System.out.println("Найден: " + foundPerson.getName());
            System.out.println("Дата рождения: " + foundPerson.getDob()); 
            System.out.println("Дата смерти: " + foundPerson.getDod());
            System.out.println("Возраст: " + foundPerson.getAge());
            System.out.println("Пол: " + foundPerson.getGender());
        } 
        else {
            System.out.println("Такого члена семьи нет");
        }
    
        FileHandler fileHandler = new FileHandler();
        // Сохранение дерева в файл
        try {
            fileHandler.saveFamilyTreeToFile("person.txt", familyTree);
            System.out.println("Семейное дерево успешно сохранено");
            } 
        catch (IOException e) {
            System.out.println("Ошибка при сохранении семейного дерева: " + e.getMessage());
            }
            
            // Загрузка дерева из файла
        try {
            FamilyTree loadFamilyTreeFromFile = fileHandler.loadFamilyTreeFromFile("person.txt");
            System.out.println("Семейное дерево успешно загружено");
        } 
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке семейного дерева: " + e.getMessage());
        }


          // Выводим информацию о загруженном семейном дереве
        if (familyTree != null) {
           System.out.println("Загруженное семейное дерево содержит " + ((Object) familyTree.getFamilyMembers().size()) + " членов семьи.");
        }
    }
 }

   