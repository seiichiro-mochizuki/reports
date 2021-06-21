package models.validators;
import java.util.ArrayList;
import java.util.List;

import models.Report;

public class ReportValidator {
    public static List<String> validate(Report r){
        List<String> errors = new ArrayList<>();

        String title_error = _validateTitle(r.getTitle());
        if(!title_error.equals("")){
            errors.add(title_error);
        }

        String content_error = _validateContent(r.getContent());
        if(!content_error.equals("")){
            errors.add(content_error);
        }

        String commutingHour_error = _validateCommutingHour(r.getCommuting_hour());
        if(!commutingHour_error.equals("")){
            errors.add(commutingHour_error);
        }

        String commutingMinute_error = _validateCommutingMinute(r.getCommuting_minute());
        if(!commutingMinute_error.equals("")){
            errors.add(commutingMinute_error);
        }

        String leavingHour_error = _validateLeavingHour(r.getLeaving_hour());
        if(!leavingHour_error.equals("")){
            errors.add(leavingHour_error);
        }

        String leavingMinute_error = _validateLeavingMinute(r.getLeaving_minute());
        if(!leavingMinute_error.equals("")){
            errors.add(leavingMinute_error);
        }

      //桁数をチェックし、二桁かつ先頭が0のときは一桁目をcommuting_hourへセット
        if(r.getCommuting_hour().length() == 2 && Character.toString(r.getCommuting_hour().charAt(0)).equals("0")){
            r.setCommuting_hour(Character.toString(r.getCommuting_hour().charAt(1)));
        }

      //桁数をチェックし、一桁のときは、二桁目に0を入れて二桁にしcommuting_minuteへセット
        if(r.getCommuting_minute().length() == 1 ){
            r.setCommuting_minute("0" + r.getCommuting_minute());
        }

      //桁数をチェックし、二桁かつ先頭が0のときは一桁目をleaving_hourへセット
        if(r.getLeaving_hour().length() == 2 && Character.toString(r.getLeaving_hour().charAt(0)).equals("0")){
            r.setLeaving_hour(Character.toString(r.getLeaving_hour().charAt(1)));
        }

      //桁数をチェックし、一桁のときは、二桁目に0を入れて二桁にしleaving_minuteへセット
        if(r.getLeaving_minute().length() == 1 ){
            r.setLeaving_minute("0" + r.getLeaving_minute());
        }
        return errors;
    }

    private static String _validateTitle(String title){
        if(title == null || title.equals("")){
            return "タイトルを入力してください";
        }

        return "";
    }

    private static String _validateContent(String content){
        if(content == null || content.equals("")){
            return "内容を入力してください";
        }

        return "";
    }

    private static String _validateCommutingHour(String commutingHour){
        boolean numberCheckFlag = false;
        int number;
        try {
            //まずは数字かどうかチェック
            number = Integer.parseInt(commutingHour);
            //その数字が23以下かチェック
            if(number > 23){
                numberCheckFlag = true;
                }
            } catch (NumberFormatException e) {
                numberCheckFlag = true;
        }
        //commutingHourがnullか、空白か、数字でないか、桁数が2桁以上かでエラー
        if(commutingHour == null || commutingHour.equals("") || numberCheckFlag || commutingHour.length() > 2 ){
            return "出勤の時間は「1桁または2桁で、23以下の数字」で入力してください";
        }

        return "";
    }

    private static String _validateCommutingMinute(String commutingMinute){
        boolean numberCheckFlag = false;
        int number;
        try {
            //まずは数字かどうかチェック
            number = Integer.parseInt(commutingMinute);
            //その数字が59以下かチェック
            if(number > 59){
                numberCheckFlag = true;
                }
            } catch (NumberFormatException e) {
                numberCheckFlag = true;
        }
        //commutingMinuteがnullか、空白か、数字でないか、桁数が2桁以上かでエラー
        if(commutingMinute == null || commutingMinute.equals("") || numberCheckFlag || commutingMinute.length() > 2){
            return "出勤の分数は「1桁または2桁で、59以下の数字」で入力してください";
        }

        return "";
    }

    private static String _validateLeavingHour(String leavingHour){
        boolean numberCheckFlag = false;
        int number;
        try {
            //まずは数字かどうかチェック
            number = Integer.parseInt(leavingHour);
            //その数字が23以下かチェック
            if(number > 23){
                numberCheckFlag = true;
                }
            } catch (NumberFormatException e) {
                numberCheckFlag = true;
        }
        //leavingHourがnullか、空白か、数字でないか、桁数が2桁以上かでエラー
        if(leavingHour == null || leavingHour.equals("") || numberCheckFlag || leavingHour.length() > 2 ){
            return "退勤の時間は「1桁または2桁で、23以下の数字」で入力してください";
        }

        return "";
    }

    private static String _validateLeavingMinute(String leavingMinute){
        boolean numberCheckFlag = false;
        int number;
        try {
            //まずは数字かどうかチェック
            number = Integer.parseInt(leavingMinute);
            //その数字が59以下かチェック
            if(number > 59){
                numberCheckFlag = true;
                }
            } catch (NumberFormatException e) {
                numberCheckFlag = true;
        }
        //commutingMinuteがnullか、空白か、数字でないか、桁数が2桁以上かでエラー
        if(leavingMinute == null || leavingMinute.equals("") || numberCheckFlag || leavingMinute.length() > 2){
            return "出勤の分数は「1桁または2桁で、59以下の数字」で入力してください";
        }

        return "";
    }
}
