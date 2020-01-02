
package com.example.bk_turizm.Veritabanı;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperUtilities {

    public static boolean isValidPostalCode(String postalCode) {
        String regexPostalCode = "[A-Za-z][0-9][A-Za-z] [0-9][A-Za-z][0-9]";

        if (postalCode.matches(regexPostalCode)) {
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        String regexEmail = "([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";

        if (email.matches(regexEmail)) {
            return true;
        }
        return false;
    }

    public static boolean isValidPhone(String phone) {
        String regexPhone = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";

        if (phone.matches(regexPhone)) {
            return true;
        }
        return false;
    }

    public static boolean isEmptyOrNull(String param) {
        if (param == null || param.trim().equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isString(String data) {

        if (data.matches("\\d+(?:\\.\\d+)?")) {
            return false;
        }

        return true;
    }

    public static boolean isShortPassword(String password) {
        if (password.length() > 5) {
            return false;
        }
        return true;
    }




    public static String getDateTime() {

        return DateFormat.getDateInstance().format(new Date());

    }
    public static String formatDate(int y, int m, int d){

        try{
            String date = d + "/" + (m+1) +"/" + y;
            Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(date);
            DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL);

            return fullDf.format(date1);

        }catch(Exception e){

        }

        return null;
    }

    public static int currentYear(){

        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR);
    }

    public static int currentMonth(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH);
    }

    public static int currentDay(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.DAY_OF_MONTH);
    }



    public static String capitalize(String str) {
        return str.length() == 0 ? str : str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String filter(String input) {
        if (!hasSpecialChars(input)) {
            return (input);
        }
        StringBuilder sb = new StringBuilder(input.length());
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            switch (c) {
                case '<':
                    sb.append("&lt;");
                    break;
                case '>':
                    sb.append("&gt;");
                    break;
                case '"':
                    sb.append("&quot;");
                    break;
                case '\'':
                    sb.append("&apos;");
                    break;
                case '&':
                    sb.append("&amp;");
                    break;
                default:
                    sb.append(c);
            }
        }
        return sb.toString();

    }

    private static boolean hasSpecialChars(String input) {

        Pattern regexSpecialChars = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher inputStr = regexSpecialChars.matcher(input);
        boolean hasSpecialChars = inputStr.find();

        if (!hasSpecialChars) {
            return false;
        }

        return true;
    }


    public static Double calculateTotalFare(double outboundFare, double returnFare, int numTraveller){
        return (outboundFare + returnFare) * numTraveller;
    }

    public static Double calculateTotalFare(double fare, int numTraveller){
        return fare * numTraveller;
    }

    public static boolean compareDate(String departureDate, String returnDate){

        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse(departureDate);
            Date date2 = sdf.parse(returnDate);

            if (date2.before(date1)) {
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}
