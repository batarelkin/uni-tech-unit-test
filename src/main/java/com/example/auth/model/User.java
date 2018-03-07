package com.example.auth.model;

import lombok.Data;

@Data
public class User {

    /**
     * Идентификатор пользователя. Должен быть больше 0
     */
    private long id;

    /**
     * Имя пользователя (максимальная длина 127 символов)
     */
    private String name;

    /**
     * Email пользователя (максимальная длина 127 символов)
     */
    private String email;

    /**
     * Телефон пользователя (максимальная длина 15 символов)
     */
    private String phone;
}
