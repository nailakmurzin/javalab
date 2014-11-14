package lab1;

import lab1.Models.AbstractItem;
import lab1.Exceptions.*;
import lab1.Items.*;
import lab1.storages.*;

public class Lab1 {

    public static void testBrickBookNote() {
        Book a = new lab1.Items.Book("Брасеро", 0.9, new String[]{"Автор: Юджин Нельсон"}, "Путешевствие мексиканца");
        System.out.println(a);
        System.out.println(a.showText());
    }

    public static void testBag() throws ItemStoreException {
        Brick A = new Brick("Кирпич1", 4.4, new String[]{"квадратный", "красный", "плоский"});
        Book B = new Book("Книга1", 1, new String[]{"красная"}, "Бла - Бла -Бла блабла");
        Bag D = new Bag("Мешок 1", 9.1, new String[]{"серый"}, 0.02);
        Bag E = new Bag("Мешок 2", 4.1, new String[]{"серый"}, 0.01);

        System.out.println("\nПОМЕЩЕНИЕ ОБЪЕКТА В МЕШОК!");
        D.addItem(A);
        System.out.println(D);
        //assertE

        D.addItem(new Brick("Кирпич2", 1.4, new String[]{"квадратный", "красный"}));
        System.out.println(D);
        D.addItem(new Brick("Кирпич3", 2.4, new String[]{"красный"}));
        System.out.println(D);

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
        System.out.println("\n#УДАЛЕНИЕ ИЗ МЕШКА!");
        System.out.println(D);
        AbstractItem S = D.findItem("Кирпич2");
        System.out.println(D);
        System.out.println(S);

        System.out.println("\n#ПОПЫТКА СДЕЛАТЬ МЕШОК ПЛОСКИМ!");
        try {
            Book B2 = new Book("Книга <война и мир>", 2, new String[]{"красная"}, "Война война война");
            D.addItem(new Brick("Кирпич4", 1.4, new String[]{"квадратный", "красный"}));
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
                item = D.getItem();
                System.out.println("удаляемый объект " + item);
            }
        } while (item != null);
        System.out.println(D);
    }

    public static void testPile() throws ItemStoreException {
        Brick brick1 = new Brick("Кирпич1", 4.4, new String[]{"квадратный", "красный", "плоский"});
        Book book1 = new Book("Книга1", 1, new String[]{"красная"}, "Бла - Бла -Бла блабла");
        Bag bag1 = new Bag("Мешок 1", 9.1, new String[]{"серый"}, 0.02);
        Bag bag2 = new Bag("Мешок 2", 4.1, new String[]{"серый"}, 0.01);

        Pile pile = new Pile("Стопка 1", 3, new String[]{});
        System.out.println("\nПОМЕЩЕНИЕ ОБЪЕКТА В СТОПКУ!");
        System.out.println(pile);
        try {
            pile.addItem(brick1);
            System.out.println(pile);
            pile.addItem(book1);
            System.out.println(pile);
        } catch (ItemStoreException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        try {
            testBag();
            System.out.println("//////////////////////////////");
            testBrickBookNote();
            System.out.println("//////////////////////////////");
            testPile();
            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }

}
