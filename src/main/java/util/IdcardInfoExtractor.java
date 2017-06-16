package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class IdcardInfoExtractor {  
    // 性别  
    private String gender;  
    // 出生日期  
    private Date birthday;  
  
    private IdcardValidator validator = null;  
  
    /** 
     * 通过构造方法初始化各个成员属性 
     */  
    public IdcardInfoExtractor(String idcard) {  
        try {  
            validator = new IdcardValidator();  
            if (validator.isValidatedAllIdcard(idcard)) {  
                if (idcard.length() == 15) {  
                    idcard = validator.convertIdcarBy15bit(idcard);  
                }  
                // 获取性别  
                String id17 = idcard.substring(16, 17);  
                if (Integer.parseInt(id17) % 2 != 0) {  
                    this.gender = "男";  
                } else {  
                    this.gender = "女";  
                }  
  
                // 获取出生日期  
                String birthday = idcard.substring(6, 14);  
                Date birthdate = new SimpleDateFormat("yyyyMMdd")  
                        .parse(birthday); 
                this.birthday = birthdate;
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
  
    /** 
     * @return the gender 
     */  
    public String getGender() {  
        return gender;  
    }  
  
    /** 
     * @return the birthday 
     */  
    public Date getBirthday() {  
        return birthday;  
    }  
  
    @Override  
    public String toString() {  
        return "性别：" + this.gender + ",出生日期："  
                + this.birthday;  
    }  
  
    public static void main(String[] args) {  
        String idcard = "";  
        IdcardInfoExtractor ie = new IdcardInfoExtractor(idcard);  
        System.out.println(ie.gender+"---------"+DateFormatUtil.getStringFormatDate(ie.getBirthday()));  
    }  
    
}
