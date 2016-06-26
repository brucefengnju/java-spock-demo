package org.brucefeng.spockdemo;

import org.brucefeng.spockdemo.bean.User;

import java.util.List;

public interface UserService {

    User getUser(int userId);

    List<User> queryUserList(List<Integer> userIds);
}
