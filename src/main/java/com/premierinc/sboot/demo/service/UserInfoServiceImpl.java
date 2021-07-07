package com.premierinc.sboot.demo.service;

import com.premierinc.sboot.demo.domain.CommunicationPref;
import com.premierinc.sboot.demo.domain.UserInfo;
import com.premierinc.sboot.demo.dto.UserInfoDTO;
import com.premierinc.sboot.demo.logic.UserInfoLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

    @Autowired
    UserInfoLogic userInfoLogic;

    @Override
    public void update(UserInfoDTO userInfoDTO) {

        UserInfo userInfo = userInfoLogic.findUser(userInfoDTO.getFirstName()
                ,userInfoDTO.getLastName());
        if(null == userInfo){
            userInfo = new UserInfo(userInfoDTO.getId(),userInfoDTO.getLastName()
                    ,userInfoDTO.getFirstName(),userInfoDTO.getAddress(),userInfoDTO.getMobile());
        }
        List<CommunicationPref> communicationPrefs = new ArrayList<>();
        for(String emailAddress: userInfoDTO.getEmailAddresses()){
            communicationPrefs.add(new CommunicationPref(emailAddress.replaceAll("[\\[\\]\"]", ""), userInfo));
        }
        userInfo.setCommunicationPrefs(communicationPrefs);
        userInfoLogic.saveUser(userInfo);
    }

    @Override
    public List<UserInfoDTO> getAllUsers() {
        List<UserInfoDTO> userInfoDTOs = new ArrayList();
        Iterable<UserInfo> userInfos = userInfoLogic.findAllUsers();

        for(UserInfo userInfo : userInfos){
            List<String> emailAddresses = new ArrayList<>();
            //Hibernate.initialize(userInfo.getCommunicationPrefs());
            for(CommunicationPref communicationPref: userInfo.getCommunicationPrefs()){
                emailAddresses.add(communicationPref.getCommunicationPrefId().getCommunicationId());
            }
            userInfoDTOs.add(new UserInfoDTO(userInfo.getUserId(),userInfo.getFirstName()
                    ,userInfo.getLastName(),userInfo.getAddress(), userInfo.getMobile() , emailAddresses));
        }
        return userInfoDTOs;
    }
}
