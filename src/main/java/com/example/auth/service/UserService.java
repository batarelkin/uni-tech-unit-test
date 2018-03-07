package com.example.auth.service;

import java.util.List;

import com.example.auth.NotFoundException;
import com.example.auth.model.User;

/**
 * Сервис работы с пользователями
 */
public interface UserService {

    /**
     * Возвращает пользователя с указанным идентификатором
     *
     * @param id идентификатор пользователя
     * @return пользователя с указанным идентификатором
     * @throws NotFoundException если пользователя с указанным идентификатором не существует
     */
    User getUser(long id) throws NotFoundException;

    /**
     * Возвращает список пользователей, name, email или phone которых сожержит указанную строку
     *
     * @param filter фильтр пользователей по name, email или phone
     * @return список пользователей
     */
    List<User> findUsers(String filter);

    /**
     * Добавляет нового пользователя с указанными данными
     *
     * @param newUser данные нового пользователя. Поле <code>id</code> игнорируется
     * @return созданный пользователь
     */
    User addUser(User newUser);

    /**
     * Обновляет данные пользователя
     *
     * @param user данные пользователя
     * @return актуальные данные пользователя
     * @throws NotFoundException если пользователя с указанным идентификатором не существует
     */
    User updateUser(User user) throws NotFoundException;

    /**
     * Удаляет пользователя по идентификатору
     *
     * @param id идентификатор пользователя
     * @throws NotFoundException если пользователь по указанному идентификатору не найден
     */
    void deleteUser(long id) throws NotFoundException;
}
