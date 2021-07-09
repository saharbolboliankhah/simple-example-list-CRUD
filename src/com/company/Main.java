package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


class User {
    private long id;
    private String name;
    private int age;
    private String gender;

    public User(long id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

public class Main {
    public static void main(String[] args) {
        // write your code here
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("press 1 : ( create user ) ");
        System.out.println("press 2 : ( update user ) ");
        System.out.println("press 3 : ( get user ) ");
        System.out.println("press 4 : ( get all users ) ");
        System.out.println("press 5 : ( delete user ) ");
        System.out.println("press exit");
        boolean exit = false;
        String name = "";
        int age = 1;
        long id = 1;
        String gender = "F";
        while (!exit) {
            System.out.print("\nwhat do you want ? ");
            String input = scanner.next();
            switch (input) {
                case "1":
                    users = createUser(users, id);
                    id++;
                    users.forEach(user -> {
                        System.out.println("id : " + user.getId() + " name : " + user.getName() + ", age : " + user.getAge() + ", gender : " + user.getGender());
                    });
                    break;
                case "2":
                    users = updateUser(users);
//                    users.forEach(user -> {
//                        System.out.println("id : " + user.getId() + " name : " + user.getName() + ", age : " + user.getAge() + ", gender : " + user.getGender());
//                    });
                    break;
                case "3":
                    getUser(users);
                    break;
                case "4":
                    users.forEach(user -> {
                        System.out.println("id : " + user.getId() + " name : " + user.getName() + ", age : " + user.getAge() + ", gender : " + user.getGender());
                    });
                    break;
                case "5":
                    deleteUser(users);
                    break;
                case "exit":
                    exit = true;
                    System.out.print("Bye Bye");
                    break;
                default:
                    System.out.print("Wrong code !!");
                    break;
            }
        }

        scanner.close();
    }

    static List<User> createUser(List<User> users, long id) {
        String name = "";
        int age;
        String gender;
        Scanner scanner = new Scanner(System.in);
        System.out.print("name : ");
        name = scanner.nextLine();
        if (name == "") {
            System.out.println("invalid name");
            createUser(users, id);
            return users;
        }
        System.out.print("age : ");
        age = scanner.nextInt();
        if (age < 1 || age > 200) {
            System.out.println("invalid age");
            createUser(users, id);
            return users;
        }
        System.out.print("gender (f / m) : ");
        scanner.nextLine();
        gender = scanner.nextLine();
        System.out.println(gender);

//        if (!(gender== "f" || gender =="m")) {
//            System.out.println("invalid gender");
//            createUser(users,id);
//            return users;
//        }
        users.add(new User(id, name, age, gender));
        return users;

    }

    static int findIndex(List<User> users, long params) {
        int index = -1;
        int size = users.size();
        for(int i = 0 ;i<size;i++){
            if(users.get(i).getId() == params)
                index = i;
        }
//        index = users.forEach((el,i )-> {
//            if(el.getId() == params) {
//            };
//                });
        return index;

    }

    static List<User> updateUser(List<User> users) {
        String name = "";
        int age;
        String gender;
        Scanner scanner = new Scanner(System.in);
        System.out.print("which id ?: ");
        long params = scanner.nextLong();
        int index = findIndex(users, params);
        if(index == -1){
            System.out.println("invalid params");
            return users;
        }
//        System.out.println("index");
//        System.out.println(index);
        User user = users.get(index);
        System.out.print("update name : ");
        scanner.nextLine();
        name = scanner.nextLine();
        if (name == "") {
            System.out.println("invalid name");
            updateUser(users);
            return users;
        }
        System.out.print("update age : ");
        age = scanner.nextInt();
        if (age < 1 || age > 200) {
            System.out.println("invalid age");
            updateUser(users);
            return users;
        }
        System.out.print("update gender (f / m) : ");
        scanner.nextLine();
        gender = scanner.nextLine();

//        if (!(gender== "f" || gender =="m")) {
//            System.out.println("invalid gender");
//            updateUser(users);
//            return users;
//        }
        user.setName(name);
        user.setAge(age);
        user.setGender(gender);
        System.out.println("update successfully");

        return users;

    }

    static void getUser(List<User> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("which id ?: ");
        long params = scanner.nextLong();
        int index = findIndex(users, params);
        if(index == -1){
            System.out.println("invalid params");
            return;
        }
        User user = users.get(index);
        System.out.println("id : " + user.getId() + " name : " + user.getName() + ", age : " + user.getAge() + ", gender : " + user.getGender());
        return;

    }

    static void deleteUser(List<User> users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("which id ?: ");
        long params = scanner.nextLong();
        int index = findIndex(users, params);
        if(index == -1){
            System.out.println("invalid params");
            return;
        }
        User user = users.get(index);
        System.out.println("id : " + user.getId() + " name : " + user.getName() + ", age : " + user.getAge() + ", gender : " + user.getGender());
        users.remove(index);
        System.out.println("delete successfully");
        return;

    }

}

