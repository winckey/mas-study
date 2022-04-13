package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.repository.UserEntity;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@Slf4j

public class UserServiceImpl implements UserService {


    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository , BCryptPasswordEncoder bCryptPasswordEncoder) {
                                                                //BCryptPasswordEncoder 여기 뜨는 에러는 빈으로 생성한적이 없기때문에
                                                                //Autowired할수없음 -> 등록과정이 필요하다.
        this.userRepository =userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setUserId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);// 모델 매핑전략지정 : STRICT 일치하지 않으면 실행 x
        UserEntity userEntity = modelMapper.map(userDto , UserEntity.class);


        userEntity.setEncryptedPwd(bCryptPasswordEncoder.encode(userDto.getPwd()));// 비밀번호 암호화


        userRepository.save(userEntity);

        UserDto returnUserDto = modelMapper.map(userEntity , UserDto.class);
        return returnUserDto;
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        return null;
    }

    @Override
    public UserDto getUserDetailsByEmail(String userName) {
        return null;
    }
}
