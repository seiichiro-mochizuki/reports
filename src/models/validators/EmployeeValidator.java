package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Employee;
import utls.DBUtil;

public class EmployeeValidator {
    public static List<String> validate(Employee e, Boolean codeDuplicateCheckFlag, Boolean passwordCheckFlag){
        List<String> errors = new ArrayList<>();

        String code_error = validateCode(e.getCode(), codeDuplicateCheckFlag);
        if(!code_error.equals("")){
            errors.add(code_error);
        }
        String name_error = validateName(e.getName());
        if(!name_error.equals("")){
            errors.add(code_error);
        }
        String password_error = validatePassword(e.getPassword(), passwordCheckFlag);
        if(!password_error.equals("")){
            errors.add(code_error);
        }
        return errors;
    }

    //社員番号チェックメソッド
    private static String validateCode(String code, Boolean codeDuplicateCheckFlag){
        //必須入力チェック
        if(code == null || code.equals("")){
            return "社員番号を入力してください";
        }
        //重複チェック
        if(codeDuplicateCheckFlag){
            EntityManager em = DBUtil.createEntityManager();
            long employees_count = (long)em.createNamedQuery("checkRegisteredCode", Long.class).setParameter("code", code).getSingleResult();
            em.close();
            if(employees_count > 0){
                return "入力された社員番号の情報は既に存在します";
            }
        }
        return "";
    }
    //社員名必須入力チェック
    private static String validateName(String name){
        if(name == null || name.equals("")){
            return "氏名を入力してください";
        }
        return "";
    }
    //パスワード必須入力チェック
    private static String validatePassword(String password, Boolean passwordCheckFlag){
        if(passwordCheckFlag == null || passwordCheckFlag.equals("")){
            return "パスワードを入力してください";
        }
        return "";
    }
}

