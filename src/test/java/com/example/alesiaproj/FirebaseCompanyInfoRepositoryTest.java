package com.example.alesiaproj;

import com.example.alesiaproj.entity.CompanyInfo;
import com.example.alesiaproj.entity.UserInfo;
import com.example.alesiaproj.repository.FirebaseCompanyInfoRepository;
import com.example.alesiaproj.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class FirebaseCompanyInfoRepositoryTest {
    @Autowired
    private FirebaseCompanyInfoRepository firebaseCompanyInfoRepository;
    @Autowired
    private UserService userService;
    @Test
    void come() throws FirebaseAuthException {
        //userService.registerUserAsClient(new UserInfo("test","test@mail.ru","test","ADMIN"),"somePass","mycompanmy");
       String login = userService.loginUser("test@mail.ru","somePass");
        System.out.println(login);
    }
//    @Test
//    void createTest() {
//        CompanyInfo companyInfo = new CompanyInfo("some company", "logistic", "email@gmail.com", new A);
//        Assertions.assertDoesNotThrow(() -> {
//            String dateCreated = firebaseCompanyInfoRepository.create(companyInfo);
//            Assertions.assertNotNull(dateCreated);
//        });
//    }

//    @Test
//    void getByIdTest() {
//        Assertions.assertDoesNotThrow(() -> {
//            CompanyInfo companyInfo = new CompanyInfo("MyId", "some company", "logistic", "email@gmail.com");
//            firebaseCompanyInfoRepository.create(companyInfo);
//            Optional<CompanyInfo> companyInfoOptional = firebaseCompanyInfoRepository.getById("MyId");
//            Assertions.assertTrue(companyInfoOptional.isPresent());
//        });
//    }
//
//    @Test
//    void deleteByIdTest() {
//        Assertions.assertDoesNotThrow(() -> {
//            CompanyInfo companyInfo = new CompanyInfo("MyId", "some company", "logistic", "email@gmail.com");
//            firebaseCompanyInfoRepository.create(companyInfo);
//            String result = firebaseCompanyInfoRepository.deleteById(companyInfo.getId());
//            Assertions.assertTrue(result.contains("OK"));
//        });
//    }
//    @Test
//    void updateTest(){
//        Assertions.assertDoesNotThrow(() -> {
//            CompanyInfo companyInfoForCreate = new CompanyInfo("MyId", "some company", "logistic", "email@gmail.com");
//            CompanyInfo companyInfoForUpdate = new CompanyInfo("MyId", "some company1", "logistic1", "email1@gmail.com");
//            firebaseCompanyInfoRepository.create(companyInfoForCreate);
//            firebaseCompanyInfoRepository.update(companyInfoForUpdate);
//            Optional<CompanyInfo> companyInfoOptional = firebaseCompanyInfoRepository.getById("MyId");
//            if(companyInfoOptional.isPresent()){
//                Assertions.assertEquals(companyInfoForUpdate,companyInfoOptional.get());
//            }else {
//                Assertions.fail();
//            }
//        });
//    }
}
