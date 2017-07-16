package com.bsm.user.dataaccess;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import com.bsm.dataccess.DataAccess;
import com.bsm.user.entity.UserEntity;


public class UserDataUtil {
    private static List<UserEntity> userList = new ArrayList<>();

    public static List<UserEntity> getAllUsersFromDB() throws Exception {
        userList.clear();
        List<String> list = DataAccess.getData();
        StringTokenizer tokens;
        UserEntity user;
        for(String line : list) {
            tokens = new StringTokenizer(line);
            user = new UserEntity(tokens.nextToken(), tokens.nextToken());
            user.setBalance(Long.parseLong(tokens.nextToken()));
            userList.add(user);
        }
        return new ArrayList<>(userList);
    }

    public static List<UserEntity>  getAllUsers() throws Exception {
        return userList == null ? getAllUsersFromDB() : userList;
    }

    public static void setAllUsers(List<UserEntity> list) {
        userList.clear();
        userList.addAll(list);
    }

    public static void updateAllUsers(List<String> list) throws Exception {
        DataAccess.updateData(list);
    }

    public static void main(String[] args) {
        try {
            List<UserEntity> list = getAllUsersFromDB();
            for(UserEntity user : list) {
                System.out.println(user.toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
