package com.ajax;

public class Composer {

    private String ISBN;
    private String TITLE;
    private String EDITIONNUMBER;
    private String COPYRIGHT;
    private String PUBLISHERNAME;

    public Composer(String ISBN, String TITLE, String EDITIONNUMBER, String COPYRIGHT, String PUBLISHERNAME) {
        this.ISBN = ISBN;
        this.TITLE = TITLE;
        this.EDITIONNUMBER = EDITIONNUMBER;
        this.COPYRIGHT = COPYRIGHT;
        this.PUBLISHERNAME = PUBLISHERNAME;
    }

    public String getCOPYRIGHT() {
        return COPYRIGHT;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTITLE() {
        return TITLE;
    }

    public String getEDITIONNUMBER() {
        return EDITIONNUMBER;
    }

    public String getPUBLISHERNAME() {
        return PUBLISHERNAME;
    }

//    private String id;
//    private String firstName;
//    private String lastName;
//    private String category;
//    
//    
//    public Composer (String id, String firstName, String lastName, String category) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.category = category;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//    
//    public String getId() {
//        return id;
//    }
//    
//    public String getFirstName() {
//        return firstName;
//    }
//    
//    public String getLastName() {
//        return lastName;
//    }
}
