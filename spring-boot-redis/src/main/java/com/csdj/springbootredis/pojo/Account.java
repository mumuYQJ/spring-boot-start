package com.csdj.springbootredis.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("account")
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "账户信息",title = "账户")
public class Account {
    @Schema(description = "账户名")
    private String name;
    @Schema(description = "余额")
    private Double money;
}
