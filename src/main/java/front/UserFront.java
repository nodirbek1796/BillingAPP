package front;

import model.authorization.User;
import service.authorization.UserService;

import java.util.Scanner;

public class UserFront extends BaseResponse {

    public static void addUser(
            UserService userService
    ) {
        Scanner scanner = new Scanner(System.in);
        User user = new User();

        user.setId();

        System.out.print("enter name: ");
        user.setName(scanner.nextLine());

        System.out.print("enter phone_number: ");
        user.setPhoneNumber(scanner.nextLine());

        System.out.print("enter password: ");
        user.setPassword(scanner.nextLine());

        System.out.print("enter email: ");
        user.setEmail(scanner.nextLine());

        scanner = new Scanner(System.in);
        System.out.print("enter age: ");
        user.setAge(scanner.nextInt());

        boolean status = userService.add(user, null);
        response(status);
    }

    public static User signIn(
            UserService userService
    ) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter phone_number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("enter password: ");
        String password = scanner.nextLine();

        return userService.signIn(phoneNumber, password);
    }
}
