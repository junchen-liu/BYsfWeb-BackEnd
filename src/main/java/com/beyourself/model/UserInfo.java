package com.beyourself.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserInfo {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String nickName;
    private Integer grade;
    private String email;
    private String introduction;
    private String school;
    private String college;
    private String realName;
    private String mobile;
    private String qqNumber;
    private String headerUrl;
}
