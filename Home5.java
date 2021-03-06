package ru.geekbrains.java_one1;

public class Animal {
    String name;
    int runLength;
    double jumpLength;
    int swimLength;

    public Animal(String name, int runLength, double jumpLength, int swimLength) {
        this.name = name;
        this.runLength = runLength;
        this.jumpLength = jumpLength;
        this.swimLength = swimLength;
    }

    public void run(int val) {

         System.out.println(this.name + " бежит " + val + " метров");
    }

    public void jump(double val) {

        System.out.println(this.name + " прыгает на " + val + " метров");
    }

    public void swim(int val) {

        System.out.println(this.name + " плывет " + val + " метров");
    }

    public void fly() {

        System.out.println(this.name + " взлетает на ветку");
    }
}



package ru.geekbrains.java_one1;

public class Bird extends Animal {
    public Bird(String name, int runLength, double jumpLength, int swimLength) {

        super("Bird", 5, 0.2, 0);
    }
    @Override
    public void swim(int val) {
        System.out.println("Bird: I can't swimming");
    }
}



package ru.geekbrains.java_one1;

public class Cat extends Animal {
    public Cat(String name, int runLength, double jumpLength, int swimLength) {
        super("Cat", 200, 2, 0);
    }

    @Override
    public void swim(int val) {
        System.out.println("Cat тонет");
    }
}




package ru.geekbrains.java_one1;

public class Dog extends Animal {
    public Dog(String name, int runLength, double jumpLength, int swimLength) {

        super("Dog", 500,0.5, 10);
    }
}

package ru.geekbrains.java_one1;

public class Hors extends Animal {
    public Hors(String name, int runLength, double jumpLength, int swimLength) {
        super("Hors", 1500, 3, 100);
    }
}



package ru.geekbrains.java_one1;

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog("Dog", 500, 0.5, 10);
        Hors hors = new Hors("Hors", 1500, 3, 100);
        Bird bird = new Bird("Bird", 5, 0.2, 0);
        Cat cat = new Cat("Cat", 200, 2, 0);
        Animal[] pets = {dog, hors, bird, cat};
        for (int i = 0; i < pets.length; i++) {
            if (pets[i] instanceof Bird) {
                pets[i].fly();
            }
        }

        dog.run(500);
        dog.jump(0.5);
        dog.swim(10);

        hors.run(1500);
        hors.jump(3);
        hors.swim(100);

        bird.run(5);
        bird.jump(0.2);
        bird.swim(0);

        cat.run(200);
        cat.jump(2);
        cat.swim(0);

    }
}
