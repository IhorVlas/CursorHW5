package com.company;

import java.util.Scanner;

public class Authentication {

    public static void authentication() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Confirm password: ");
        String confirmPassword = sc.nextLine();

        try {
            verificationLogAndPass(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Повторите ввод логина!");
            e.printStackTrace();
        } catch (WrongPasswordException p) {
            System.out.println("Повторите ввод пароля!");
            p.printStackTrace();
        }
    }

    public static boolean verificationLogAndPass(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String range = "[0-9a-zA-Z_]{1,20}";
        if ( (login.matches(range) && password.matches(range) && confirmPassword.equals(password)) ) {
            System.out.println("Login and password OK");
            return true;
        } else if ( !login.matches(range) ) {
            throw new WrongLoginException();
        } else if ( !password.matches(range) ) {
            throw new WrongPasswordException();
        } else if ( !confirmPassword.equals(password) ) {
            throw new WrongPasswordException();
        }
        return false;
    }
}