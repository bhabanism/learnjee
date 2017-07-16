package com.bsm.user.dataaccess;

import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import com.bsm.dataccess.DataAccess;
import com.bsm.user.entity.UserEntity;


public class UserDataUtil {
    public static List<UserEntity> getAllUsers() throws Exception {
        List<UserEntity> userlist = new ArrayList<UserEntity>();
        List<String> list = DataAccess.getData();
        StringTokenizer tokens;
        UserEntity user;
        for(String line : list) {
            tokens = new StringTokenizer(line);
            user = new UserEntity(tokens.nextToken(), tokens.nextToken());
            user.setBalance(Long.parseLong(tokens.nextToken()));
            userlist.add(user);
        }
        return userlist;
    }

    public static void updateAllUsers(List<String> list) throws Exception {
        DataAccess.updateData(list);
    }

    public static void main(String[] args) {
        try {
            List<UserEntity> list = getAllUsers();
            for(UserEntity user : list) {
                System.out.println(user.toString());
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
