package lab1;

import lab1.Models.AbstractItem;
import lab1.Exceptions.*;
import lab1.Items.*;
import lab1.storages.*;

public class Lab1 {

    public static void testBrickBookNote() {
        Book book1 = new lab1.Items.Book("Брасеро", 0.9, "Путешевствие мексиканца", "Автор: Юджин Нельсон");
        System.out.println(book1);
        System.out.println(book1.showText());
        Brick brick1 = new Brick("кирпич1", 3.3, new String[]{"красный"});
        System.out.println(brick1);
        Note note1 = new Note("блокнот1", 3.3, new String[]{});
        System.out.println(brick1);
        note1.addText("Новая запись1");
        note1.addText("Новая запись2");
        System.out.println(note1);
        System.out.println(note1.showText());

    }

    public static void testBag() throws ItemStoreException {
        Brick A = new Brick("Кирпич1", 4.4, new String[]{"квадратный", "красный"});
        Book B = new Book("Книга1", 1, "Бла - Бла -Бла блабла", new String[]{"красная"});
        Bag D = new Bag("Мешок 1", 9.1, 0.02, "серый");
        Bag E = new Bag("Мешок 2", 4.1, 0.01, "серый");

        System.out.println("\nПОМЕЩЕНИЕ ОБЪЕКТА В МЕШОК!");
        D.addItem(A);
        System.out.println(D);
        //assertE

        D.addItem(new Brick("Кирпич2", 1.4, new String[]{"квадратный", "красный"}));
        System.out.println(D);
//        D.addItem(new Brick("Кирпич3", 2.4, new String[]{"красный"}));
//        System.out.println(D);

        //add self
        try {
            System.out.println("\n#ПОМЕЩЕНИЕ МЕШКА САМОГО В СЕБЯ!");
            System.out.println(D);
            D.addItem(D);
            System.out.println(D);

        } catch (ItemAlreadyPlacedException ex) {
            System.out.println(ex);
        } catch (ItemStoreException ex) {
            System.out.println(ex.toString());
        }
        try {
            System.out.println("\n#ПОМЕЩЕНИЕ В МЕШОК ОБЪЕКТА ИЗ ЧУЖОГО МЕШКА!");
            D.addItem(A);
            System.out.println(D);

        } catch (ItemAlreadyPlacedException ex) {
            System.out.println(ex);
        } catch (ItemStoreException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("\n#УДАЛЕНИЕ ИЗ МЕШКА!");
        System.out.println(D);
        AbstractItem S = D.findItem("Кирпич2");
        System.out.println(D);
        System.out.println(S);

        System.out.println("\n#ПОПЫТКА СДЕЛАТЬ МЕШОК ПЛОСКИМ!");
        try {
            Book B2 = new Book("Книга <война и мир>", 2, "Война война война", "красная");
            D.addItem(new Brick("Кирпич4", 1.4, new String[]{"квадратный", "плоский"}));
            D.addItem(B2);
        } catch (ItemAlreadyPlacedException ex) {
            System.out.println(ex);
        } catch (ItemStoreException ex) {
            System.out.println(ex.toString());
        }
        AbstractItem item;
        do {
            System.out.println();
            D.makeFlat();
            System.out.println(D);
            if (D.peculiar("плоский")) {
                System.out.println("\tCOMPLITE");
                break;
            } else {
                item = D.popItem();
                System.out.println("удаляемый объект " + item);
            }
        } while (item != null);
        System.out.println(D);
        try {
            System.out.println("\n#ПОМЕЩЕНИЕ В МЕШОК МЕШКА!");
            E.addItem(B);
            System.out.println(E);
            D.addItem(E);
            System.out.println(D);
            System.out.println(E);

        } catch (ItemAlreadyPlacedException ex) {
            System.out.println(ex);
        } catch (ItemStoreException ex) {
            System.out.println(ex.toString());
        }
    }

    public static void testPile() throws ItemStoreException {
        Brick brick1 = new Brick("Кирпич1", 4.4, new String[]{"квадратный", "красный", "плоский"});
        Book book1 = new Book("Книга1", 1, "Бла - Бла -Бла блабла", "красная");
        Bag bag1 = new Bag("Мешок 1", 9.1, 0.02, new String[]{"серый"});
        Bag bag2 = new Bag("Мешок 2", 4.1, 0.01, new String[]{"серый"});

        Pile pile1 = new Pile("Стопка 1", 3, new String[]{});
        Pile pile2 = new Pile("Стопка 2", 4, new String[]{});

        System.out.println("\nПОМЕЩЕНИЕ ОБЪЕКТА В СТОПКУ!");
        System.out.println(pile1);
        try {
            pile1.addItem(brick1);
            System.out.println(pile1);
            pile1.addItem(book1);
            System.out.println(pile1);
            pile1.addItem(bag1);
            System.out.println(pile1);
        } catch (ItemStoreException e) {
            System.out.println(e);
        }
        System.out.println("\nПОМЕЩЕНИЕ СТОПКИ В СТОПКУ!");
        try {
            pile2.addItem(pile1);
            System.out.println(pile2);
        } catch (ItemStoreException e) {
            System.out.println(e);
        }
        System.out.println("\nПОМЕЩЕНИЕ СТОПКИ В САМУ СЕБЯ!");
        try {
            pile2.addItem(pile2);
        } catch (ItemStoreException e) {
            System.out.println(e);
        }
        System.out.println("\n#УДАЛЕНИЕ ИЗ МЕШКА!");
        System.out.println("\nПОМЕЩЕНИЕ СТОПКИ В САМУ СЕБЯ!");
        AbstractItem elem = pile2.popItem();
        System.out.println(elem);
        System.out.println(pile2);
    }

    public static void main(String[] args) {
        testBrickBookNote();
        System.out.println("//////////////////////////////");
        try {
            testBag();
            System.out.println("//////////////////////////////");
            testPile();
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }

}
