package com.core.securityspringboot.model;

import lombok.Data;

@Data
public class PermissionDto {
    public String id;
    public String code;
    public String description;
    public String url;
}
