package com.sparta.notice.service;


import com.sparta.notice.Dto.SignupRequestDto;
import com.sparta.notice.model.UserRoleEnum;
import com.sparta.notice.model.Users;
import com.sparta.notice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

//    @Autowired
//    public void PW(@NotNull SignupRequestDto requestDto) {
//        String password = requestDto.getPassword();
//        Optional<Users>found = userRepository.findByPassword(password);
//        if (found.isPresent()) {
//            Pattern.matches("[a-z0-9]{4,32},*$", password);
//        }
//    }

//    @Autowired
//    public void ID(SignupRequestDto requestDto) {
//        String username = requestDto.getUsername();
//        Optional<Users>found = userRepository.findByUsername(username);
//        if (found.isPresent()) {
//            Pattern.matches("[a-zA-Z0-9]{4,12},*$", username);
//        }
//    }


    public void registerUser(SignupRequestDto requestDto) {// 회원 ID 중복 확인
        String username = requestDto.getUsername();
        Optional<Users> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }

        // 패스워드 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        String email = requestDto.getEmail();

        // 사용자 ROLE 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (requestDto.isAdmin()) {
            if (!requestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        Users users = new Users(username, password, email, role);
        userRepository.save(users);
    }
}
