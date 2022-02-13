package com.beyourself.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String salt;
    private LocalDateTime activationTime;
    private Byte isValid;
    private String confirmCode;

}
