package service.authorization;

import com.google.gson.Gson;
import file.FileUtils;
import model.authorization.User;
import model.card.Card;
import service.base.BaseService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class UserService extends BaseService {
    ArrayList<User> users = new ArrayList<>();


    public User signIn(
            String phoneNumber,
            String password
    ) {
        User user = null;
        try {
            this.readUserFromFile();
            for (int i = 0; i < this.users.size() && (user == null); i++) {
                if (this.users.get(i) != null) {
                    if (this.users.get(i).getPhoneNumber().equals(phoneNumber) &&
                            this.users.get(i).getPassword().equals(password)
                    )
                        user = this.users.get(i);
                }
            }
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean add(Object object, Object object1) {
        this.readUserFromFile();
        User newUser = (User) object;
        boolean isHasUser = false;
        for (int i = 0; i < this.users.size() && !isHasUser; i++) {
            if (this.users.get(i) != null) {
                if (this.users.get(i).getPhoneNumber().equals(newUser.getPhoneNumber()))
                    isHasUser = true;
            }
        }
//        if (!isHasUser)
//            FileUtils.save(newUser);

        return !isHasUser;
    }

    @Override
    public boolean add(Object object) {
        return false;
    }

    @Override
    public boolean edit(Object object) {
        User editUser = (User) object;
        boolean isSuccess = false;
        for (int i = 0; i < this.users.size() && !isSuccess; i++) {
            if (this.users.get(i) != null) {
                if (this.users.get(i).getPhoneNumber().equals(editUser.getPhoneNumber())) {
                    isSuccess = true;
                    this.users.get(i).setAge(editUser.getAge());
                }
            }
        }
        return isSuccess;
    }

    @Override
    public boolean delete(Object object) {
        return false;
    }

    @Override
    public void list() {
        for (int i = 0; i < this.users.size(); i++) {
            User user = this.users.get(i);
            if (this.users.get(i) != null) {
                System.out.println("====================== " + (i + 1) + " =======================");
                System.out.println("username: " + user.getPhoneNumber());
                System.out.println("name: " + user.getName());
                System.out.println("age: " + user.getAge());
                System.out.println("password: " + this.getMaskPassword(user.getPassword()));
            }
        }
    }

    @Override
    public void list(Object object) {

    }

    private String getMaskPassword(String str) {
        String s = "";
        for (int i = 0; i < str.length(); i++)
            s += "*";
        return s;
    }


    private void readUserFromFile(){
        try{
            FileReader fileReader = new FileReader("./2021-03-17/12.log");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null)
                this.users.add(new Gson().fromJson(line, User.class));
            bufferedReader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
