package ru.m11.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.m11.springproject.models.User;


@Repository
/////////////////////////////////////////
// Заменил DAO на репозиторий, т.к. логичнее перейти на другой паттерн,
// потому что использую только стандартные операции с данными (стандартные CRUD операции).
// Если бы были более сложные манипуляции с данными, где нужно вручную писать SQL или HQL код,
// то использовал бы DAO.
//////////////////////////////////////////
public interface UsersRepository extends JpaRepository<User, Long> {
}
