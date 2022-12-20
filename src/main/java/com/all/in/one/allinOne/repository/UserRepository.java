package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.domain.Role;
import com.all.in.one.allinOne.domain.User;
import com.all.in.one.allinOne.repository.query.Queries;
import com.all.in.one.allinOne.repository.query.QueryHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final QueryHolder queryHolder;

    public Optional<User> findById(int id) {
        return jdbcTemplate.query(
                        queryHolder.get(Queries.FIND_USER_BY_ID),
                        Map.of("id", id),
                        new BeanPropertyRowMapper<>(User.class))
                .stream().findFirst();
    }

    public Optional<User> findByUsername(String username) {
        return jdbcTemplate.query(
                        queryHolder.get(Queries.FIND_USER_BY_USERNAME),
                        Map.of("username", username),
                        new BeanPropertyRowMapper<>(User.class))
                .stream().findFirst();
    }

    public void addUser(User user) {
        var params = Map.of(
                "username", user.getUsername(),
                "name", user.getName(),
                "surname", user.getSurname(),
                "password", user.getPassword(),
                "role", Role.USER.getId());

        jdbcTemplate.update(queryHolder.get(Queries.ADD_USER), params);
    }

    public void addAdmin(User user) {
        var params = Map.of(
                "username", user.getUsername(),
                "name", user.getName(),
                "surname", user.getSurname(),
                "password", user.getPassword(),
                "role", Role.ADMIN.getId());

        jdbcTemplate.update(queryHolder.get(Queries.ADD_USER), params);
    }

}
