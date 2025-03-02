// YOUR NAME: Tony Vera
// COLLABORATORS: N/A
// DATE: 3/1/2025

public class Main
{
        //First and Second Instruction are to make all final variables static and declare them in the correct location 

        //CONSTANTS SECTIONS
		public static final String ANSI_BG_RED = "\u001B[41m";
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BOLD = "\u001B[1m";

        //ascii art credit: http://www.oocities.org/spunk1111/bodypart.htm
        public static final String 
        ASCII_ART_0 = "    .----.    .----.  ",
        ASCII_ART_1 = "   (  --  \\  /  --  )",
        ASCII_ART_2 = "          |  |        ",
        ASCII_ART_3 = "         _/  \\_      ",
        ASCII_ART_4 = "        (_    _)      ",
        ASCII_ART_5 = "     ,    `--`    ,   ",
        ASCII_ART_6 = "     \\'-.______.-'/  ",
        ASCII_ART_7 = "      \\          /   ",
        ASCII_ART_8 = "       '.--..--.'     ",
        ASCII_ART_9 = "         `\"\"\"\"\"` ",
        ASCII_CREDIT = "   ascii art by: jgs    ";

        public static final String TITLE_USA = ANSI_BG_RED + ANSI_BOLD + "UNITED STATES OF AMERICA" + ANSI_RESET,
                                   TITLE_EAC = ANSI_BG_RED + ANSI_BOLD + "EMPLOYMENT AUTHORIZATION CARD" + ANSI_RESET;
        public static final String LABEL_SURNAME = "Surname", LABEL_GIVEN_NAME = "Given Name", LABEL_USCIS_NUM = "USCIS#",
                                   LABEL_CATEGORY = "Category", LABEL_CARD_NUM = "Card#", LABEL_BIRTH_COUNTRY = "Country of Birth",
                                   LABEL_TERMS_CONDITIONS = "Terms and Conditions", LABEL_BIRTH_DATE = "Date of Birth",
                                   LABEL_SEX = "Sex", LABEL_VALID_DATE = "Valid From:", LABEL_EXPIRE_DATE = "Card Expires:",
                                   LABEL_REENTRY_DISCLAIMER = "NOT VALID FOR REENTRY TO U.S.";


    public static void main(String[] args)
    {

        //INPUT + CALCULATION SECTION

        //DECLARATION SECTION
        //complete fields
        String surname, givenName, category, cardNum, birthCountry, termsAndConditions;
        char sex;

        //parts of fields
        String birthMonth;
        int uscisNum1, uscisNum2, uscisNum3, birthDay, birthYear,
                validDay, validMonth, validYear, expireMonth, expireDay, expireYear;

        //extra vars to help with formatting of Strings (not raw data like above vars)
        String uscisNum, dateOfBirth, validDate, expireDate;


        //INITIALIZATION SECTION 
        //USING UtilityBelt to prompt user to enter required data
        
        //Retrieve First and Last Names
        surname = UtilityBelt.readString("Eneter Last Name / Surname: ", 1, 20); //surname = "CHAPETON-LAMAS";
        givenName = UtilityBelt.readString("Eneter First Name / Given Name: ", 1, 20); //givenName= "NERY";

        //Retrieve USCIS Number in three sets of 0-999
        uscisNum1 = UtilityBelt.readInt("Enter uscisNum1: ", 0,999); //uscisNum1 = 12;
        uscisNum2 = UtilityBelt.readInt("Enter uscisNum2: ", 0,999); //uscisNum2 =4;
        uscisNum3 = UtilityBelt.readInt("Enter uscisNum3: ", 0,999); //uscisNum3 = 789;
        //Number greater than 999 will prompt user of invalid entry

        //Retrieve Category
        category = UtilityBelt.readString("Enter category level in the following format C04: ",0,3); //category = C09;
        //Data entered with more that 3 characters will be truncated to 3 characters i.e. C999 will retrun C99

        //Retrieve Card Number
        cardNum = UtilityBelt.readString("Enter Card Number in the following format SRC0123456789: ",0,13); 
        //cardNum= SRC9876543210;
        //Data entered with more that 13 characters will be truncated to 13 characters i.e. SRC112233445566 will retrun SRC1122334455
        
        //Retrive Country of Birth
        birthCountry = UtilityBelt.readString("Enter the Country of Birth: ", 1, 25); //birthCountry = Guatemala;

        //Retrieve any Terms and Conditions
        termsAndConditions = UtilityBelt.readString("Enter any Special Terms and Conditions: ", 0, 10); 
        //termsAndConditions ="None";

        //Retrieve Birth Day/Month/Year
        birthDay = UtilityBelt.readInt("Enter the Day of Birth 1-31: ", 1, 31); //birthDay= 1;
        birthMonth = UtilityBelt.readString("Enter the Month of Birth in upper case 3 Letter Format: ",3,3); //birthMonth= "JAN";
        birthYear = UtilityBelt.readInt("Enter the Year of Birth in 4 digit format xxxx: ",1800, 2025); //birthYear = 1970;

        //Retrieve Identifying Gender
        sex = UtilityBelt.readChar("Enter the Gender Identificatino: ", "FfMm"); //sex ='M'

        //Retrieve the Date of Validity
        validMonth = UtilityBelt.readInt("Enter the Month of Validity 1-12: ", 1, 12); //ValidMonth = 2;
        validDay = UtilityBelt.readInt("Enter the Day of Validity 1-31: ", 1, 31); //ValidDay = 2;
        validYear = UtilityBelt.readInt("Enter the Year of Validity in 4 digit format xxxx: ",1900, 2025); //validYear = 2020;

        //Retrieve the Date of Experiration
        expireMonth = UtilityBelt.readInt("Enter the Month of Experation 1-12: ", 1, 12); //ValidMonth = 2;
        expireDay = UtilityBelt.readInt("Enter the Day of Birth 1-31: ", 1, 31); //expireDay = 2;
        expireYear = UtilityBelt.readInt("Enter the Year of Experation in 4 digit format xxxx: ",1980, 2065); //expireDay = 2026;

        //Strings to help clean up long printf's below
        uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        dateOfBirth = String.format("%02d %s %d", birthDay, birthMonth, birthYear);


        //Static method to format Valid and Experation Dates
        validDate = Main.formatDate(validDay, validMonth, validYear);
        expireDate = Main.formatDate(expireMonth, expireDay, expireYear);
        

        //OUTPUT SECTION by calling formatCard method
        Main.formatCard(surname, givenName,
        category, cardNum, birthCountry, 
        termsAndConditions, sex, uscisNum, 
        dateOfBirth, validDate, expireDate);
        
    }

    public static void formatCard(String surname, String givenName,
    String category, String cardNum, String birthCountry, 
    String termsAndConditions, char sex, String uscisNum, 
    String dateOfBirth, String validDate, String expireDate)
    {
        System.out.println("");
        System.out.printf("╔══════════════════════════════════════════════════════════════════════╗%n");
        System.out.printf("║%40s%43s║%n", TITLE_USA, "");
        System.out.printf("║%60s%23s║%n", TITLE_EAC, "");
        System.out.printf("║%-25s%-45s║%n", "", LABEL_SURNAME);
        System.out.printf("║%-25s%-45s║%n", "", surname);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_0, LABEL_GIVEN_NAME);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_1, givenName);
        System.out.printf("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_2, LABEL_USCIS_NUM, LABEL_CATEGORY, LABEL_CARD_NUM);
        System.out.printf("║%-25s%-15s%-15s%-15s║%n", ASCII_ART_3, uscisNum, category, cardNum);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_4, LABEL_BIRTH_COUNTRY);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_5, birthCountry);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_6, LABEL_TERMS_CONDITIONS);
        System.out.printf("║%-25s%-45s║%n", ASCII_ART_7, termsAndConditions);
        System.out.printf("║%-25s%-15s%-30s║%n", ASCII_ART_8, LABEL_BIRTH_DATE, LABEL_SEX);
        System.out.printf("║%-25s%-15s%-30s║%n", ASCII_ART_9, dateOfBirth, sex);
        System.out.printf("║%-25s%-15s%-30s║%n", "", LABEL_VALID_DATE, validDate);
        System.out.printf("║%-25s%-15s%-30s║%n", "", LABEL_EXPIRE_DATE, expireDate);
        System.out.printf("║%-25s%-45s║%n", ASCII_CREDIT, LABEL_REENTRY_DISCLAIMER);
        System.out.printf("╚══════════════════════════════════════════════════════════════════════╝%n");
        

    }
    public static String formatDate(int month, int day, int year)
    {
        return String.format("%02d/%02d/%4d", month, day, year);

    }
}