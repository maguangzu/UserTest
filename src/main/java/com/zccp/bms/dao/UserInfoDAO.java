package com.zccp.bms.dao;

import com.zccp.bms.entity.UserInfo;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserInfoDAO {
    /**
     * 1 | andy | | Andy
     * 2 | carl | | Carl
     * 3 | bruce | | Bruce
     * 4 | dolly | | Dolly
     *
     * @return
     */
    public List<UserInfo> queryData() {
        List<UserInfo> ll = new ArrayList<>(4);

        UserInfo u2 = new UserInfo();
        u2.setId(2);
        u2.setLoginname("carl");
        u2.setPassword(DigestUtils.md5Hex("carl"));
        u2.setName("Carl");
        ll.add(u2);

        UserInfo u = new UserInfo();
        u.setId(1);
        u.setLoginname("andy");
        u.setPassword(DigestUtils.md5Hex("andy"));
        u.setName("Andy");
        ll.add(u);

        UserInfo u4 = new UserInfo();
        u4.setId(4);
        u4.setLoginname("dolly");
        u4.setPassword(DigestUtils.md5Hex("dolly"));
        u4.setName("Dolly");
        ll.add(u4);

        UserInfo u3 = new UserInfo();
        u3.setId(3);
        u3.setLoginname("bruce");
        u3.setPassword(DigestUtils.md5Hex("bruce"));
        u3.setName("Bruce");
        ll.add(u3);
        return ll;
    }

    public List<UserInfo> queryData(String name) {
        if (StringUtils.isBlank(name)){
            return this.queryData();
        }
        List<UserInfo> ll = this.queryData();
        if (CollectionUtils.isNotEmpty(ll)){
            return ll.stream().filter(l -> l.getName().contains(name)).collect(Collectors.toList());
        }
        return null;
    }
}
