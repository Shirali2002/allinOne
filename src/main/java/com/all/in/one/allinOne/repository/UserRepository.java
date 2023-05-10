package com.all.in.one.allinOne.repository;

import com.all.in.one.allinOne.entity.User;
import com.all.in.one.allinOne.repository.query.Queries;
import com.all.in.one.allinOne.repository.query.QueryHolder;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final QueryHolder queryHolder;

    public void save(User user) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("email", user.getEmail());
        params.put("enabled", user.getEnabled());
        params.put("name", user.getName());
        params.put("otp", user.getOtpCode());
        params.put("password", user.getPassword());
        params.put("resetEnabled", user.getResetEnabled());
        params.put("resetToken", user.getResetPasswordToken());
        params.put("surname", user.getSurname());


        jdbcTemplate.update(queryHolder.get(Queries.SAVE_USER), params);
    }

    public void update(User user) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("email", user.getEmail());
        params.put("enabled", user.getEnabled());
        params.put("name", user.getName());
        params.put("otp", user.getOtpCode());
        params.put("password", user.getPassword());
        params.put("resetEnabled", user.getResetEnabled());
        params.put("resetToken", user.getResetPasswordToken());
        params.put("surname", user.getSurname());


        jdbcTemplate.update(queryHolder.get(Queries.UPDATE_USER_BY_EMAIL), params);
    }

    public Optional<User> findByEmail(String email) {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_USER_BY_EMAIL),
                        Map.of("email", email),
                        new BeanPropertyRowMapper<>(User.class))
                .stream()
                .findFirst();
    }

    public Optional<User> findByResetPasswordToken(String resetPasswordToken) {
        return jdbcTemplate.query(queryHolder.get(Queries.FIND_USER_BY_RESET_PASSWORD_TOKEN),
                        Map.of("resetPasswordToken", resetPasswordToken),
                        new BeanPropertyRowMapper<>(User.class))
                .stream()
                .findFirst();
    }

}
